package com.example.msphone;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 卡密验证 UI 宿主（透明全屏）。两种模式由远程配置 enablehtmlPopups 决定：
 *  - WebView 模式：加载服务端下发的 HTML，注入 JS 桥（Android/android/MyAppWebView）。
 *  - 原生模式：纯代码构建的输入框 + 验证/退出按钮（WebView 缺失或配置关闭时回退）。
 *
 * 两种模式最终都通过 {@link CardGate#verify} 走 Java 侧权威校验。验证通过 setResult(RESULT_OK)。
 */
public class CardGateActivity extends Activity {

    public static final String EXTRA_HTML = "h";
    public static final String EXTRA_LOCK = "l";

    private boolean lock = true;
    private boolean finishing = false;

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lock = getIntent().getBooleanExtra(EXTRA_LOCK, true);
        String html = getIntent().getStringExtra(EXTRA_HTML);

        FrameLayout root = new FrameLayout(this);
        root.setBackgroundColor(0x9E000000);
        setContentView(root, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        boolean webViewOk = html != null && !html.isEmpty() && webViewAvailable();
        if (webViewOk) {
            buildWebView(root, html);
        } else {
            buildNative(root);
        }
    }

    private boolean webViewAvailable() {
        try {
            new WebView(this).destroy();
            return true;
        } catch (Throwable t) {
            return false;
        }
    }

    // ---------------- WebView 模式 ----------------

    private void buildWebView(FrameLayout root, String html) {
        // JSON 解析后 <\/script> 里的反斜杠会被 HTML 解析器当成脚本内容传给 JS 引擎
        // 导致 JS 语法错误、所有函数未定义。直接修正为合法的 </script>。
        html = html.replace("<\\/script>", "</script>");
        WebView wv = new WebView(this);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setDomStorageEnabled(true);
        wv.setWebViewClient(new WebViewClient());
        wv.addJavascriptInterface(new Bridge(), "Android");
        root.addView(wv, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        wv.loadDataWithBaseURL(Vault.baseUrl(), html, "text/html", "utf-8", null);
    }

    /** 暴露给 WebView 的 JS 桥。方法运行在 WebView 内部线程（非主线程），可安全做网络。 */
    private class Bridge {
        @JavascriptInterface
        public String readSP(String key) {
            if ("device_id".equals(key) || "deviceId".equals(key)) {
                return FileUtils.getDeviceIdentifier(getApplicationContext());
            }
            if ("kami".equals(key)) return Store.getKami(getApplicationContext());
            return Store.getString(getApplicationContext(), key);
        }

        @JavascriptInterface
        public void writeSP(String key, String value) {
            Store.putString(getApplicationContext(), key, value);
        }

        @JavascriptInterface
        public void saveSP(String key, String value) {
            Store.putString(getApplicationContext(), key, value);
        }

        @JavascriptInterface
        public void exitApp() {
            doExit();
        }

        @JavascriptInterface
        public void close(String popupId) {
            String card = Store.getKami(getApplicationContext());
            if (card == null || card.isEmpty()) {
                card = Store.getString(getApplicationContext(), "kami");
            }
            if (card != null && !card.isEmpty() && Store.isLicenseValid(getApplicationContext())) {
                finishSuccess();
            } else {
                doVerifyAndFinish(card);
            }
        }

        @JavascriptInterface
        public void onVerifySuccess(String card, String remainingSecondsText) {
            long remainingSeconds = 0L;
            try {
                remainingSeconds = Long.parseLong(remainingSecondsText == null ? "0" : remainingSecondsText);
            } catch (Throwable ignored) {}
            if (card == null || card.trim().isEmpty()) return;
            Store.setLicense(getApplicationContext(), card.trim(), remainingSeconds);
            finishSuccess();
        }
    }

    // ---------------- 原生模式 ----------------

    private EditText input;
    private Button btnVerify;
    private TextView msg;

    private void buildNative(FrameLayout root) {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setBackgroundColor(Color.WHITE);
        card.setPadding(dp(24), dp(24), dp(24), dp(20));
        FrameLayout.LayoutParams cardLp = new FrameLayout.LayoutParams(dp(300), ViewGroup.LayoutParams.WRAP_CONTENT);
        cardLp.gravity = Gravity.CENTER;

        TextView title = new TextView(this);
        title.setText("请输入卡密");
        title.setTextColor(0xFF222222);
        title.setTextSize(18);
        title.setGravity(Gravity.CENTER);
        card.addView(title);

        msg = new TextView(this);
        msg.setText("一机一卡，首次使用自动绑定设备");
        msg.setTextColor(0xFF888888);
        msg.setTextSize(13);
        msg.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams msgLp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        msgLp.topMargin = dp(8); msgLp.bottomMargin = dp(14);
        card.addView(msg, msgLp);

        input = new EditText(this);
        input.setHint("请输入卡密");
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.setSingleLine(true);
        String saved = Store.getKami(getApplicationContext());
        if (saved != null && !saved.isEmpty()) input.setText(saved);
        card.addView(input, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        LinearLayout buttons = new LinearLayout(this);
        buttons.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams btnRowLp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btnRowLp.topMargin = dp(18);
        card.addView(buttons, btnRowLp);

        Button exit = new Button(this);
        exit.setText("退出应用");
        exit.setOnClickListener(v -> doExit());
        LinearLayout.LayoutParams exitLp = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        buttons.addView(exit, exitLp);

        btnVerify = new Button(this);
        btnVerify.setText("验证卡密");
        btnVerify.setOnClickListener(v -> {
            String card2 = input.getText().toString().trim();
            if (card2.isEmpty()) { toast("请输入卡密"); return; }
            btnVerify.setEnabled(false);
            msg.setText("正在验证...");
            doVerifyAndFinish(card2);
        });
        LinearLayout.LayoutParams verifyLp = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        verifyLp.leftMargin = dp(12);
        buttons.addView(btnVerify, verifyLp);

        root.addView(card, cardLp);

        // 已有保存的卡密则自动尝试一次
        if (saved != null && !saved.isEmpty()) {
            doVerifyAndFinish(saved);
        }
    }

    // ---------------- 共用 ----------------

    private void finishSuccess() {
        runOnUiThread(() -> {
            setResult(RESULT_OK);
            finishing = true;
            finish();
        });
    }

    private void doVerifyAndFinish(final String card) {
        new Thread(() -> {
            final CardGate.Result r = CardGate.verify(getApplicationContext(), card);
            runOnUiThread(() -> {
                if (r.success) {
                    finishSuccess();
                } else {
                    if (msg != null) msg.setText(r.message);
                    if (btnVerify != null) btnVerify.setEnabled(true);
                    toast(r.message);
                }
            });
        }).start();
    }

    private void doExit() {
        setResult(RESULT_CANCELED);
        finishing = true;
        finish();
    }

    private void toast(String t) {
        runOnUiThread(() -> Toast.makeText(getApplicationContext(), t, Toast.LENGTH_SHORT).show());
    }

    private int dp(int v) {
        return (int) (v * getResources().getDisplayMetrics().density + 0.5f);
    }

    @Override
    public void onBackPressed() {
        if (lock && !finishing) {
            // 锁定模式下不允许返回键关闭弹窗
            return;
        }
        doExit();
    }
}

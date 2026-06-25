package com.example.msphone;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

/**
 * 卡密通过后的控制弹窗
 *
 * 反逆向设计：
 *   - 隐藏模式开启后下次启动不弹，hook 照常跑，外人逆向看不到弹窗触发链
 *   - 文字无"透视""外挂"等敏感词
 *   - 类名/方法名无特征
 */
public final class HszControlDialog {
    private HszControlDialog() {}

    public interface OnSwitchListener { void onChange(boolean on); }

    public static void show(Activity act, OnSwitchListener onToushi) {
        if (act == null || act.isFinishing()) return;
        Context ctx = act;
        float dp = ctx.getResources().getDisplayMetrics().density;

        LinearLayout root = new LinearLayout(ctx);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(0xFF1A1A2E);
        root.setPadding(px(dp,20), px(dp,16), px(dp,20), px(dp,8));

        // 标题（中性）
        TextView title = new TextView(ctx);
        title.setText("功能设置");
        title.setTextColor(0xFFE0E0FF);
        title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        title.setGravity(Gravity.CENTER_HORIZONTAL);
        title.setPadding(0, 0, 0, px(dp,12));
        root.addView(title);

        // 透视开关（标签中性）
        Switch swToushi = buildSwitch(ctx, dp, "辅助显示", HszStore.isToushiOn(ctx));
        root.addView(swToushi);

        // 隐藏模式开关
        Switch swHide = buildSwitch(ctx, dp, "静默运行（关闭本提示）", HszStore.isHideMode(ctx));
        root.addView(swHide);

        // 分隔线
        View div = new View(ctx);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, 1);
        lp.topMargin = px(dp,12); lp.bottomMargin = px(dp,4);
        div.setLayoutParams(lp);
        div.setBackgroundColor(0x33FFFFFF);
        root.addView(div);

        TextView hint = new TextView(ctx);
        hint.setText("静默运行开启后，下次启动不再显示此界面。");
        hint.setTextColor(0x99FFFFFF);
        hint.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
        hint.setPadding(0, px(dp,4), 0, px(dp,8));
        root.addView(hint);

        AlertDialog d = new AlertDialog.Builder(act)
                .setView(root).setCancelable(true)
                .setPositiveButton("确定", (di, w) -> di.dismiss())
                .create();

        swToushi.setOnCheckedChangeListener((b, on) -> {
            HszStore.setToushi(ctx, on);
            if (onToushi != null) onToushi.onChange(on);
        });
        swHide.setOnCheckedChangeListener((b, on) -> HszStore.setHideMode(ctx, on));

        d.show();
        try { d.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(0xFF7C83FD); } catch (Throwable ignored) {}
    }

    /** 是否需要弹出控制面板（隐藏模式下跳过） */
    public static boolean shouldShow(Context ctx) {
        return !HszStore.isHideMode(ctx);
    }

    private static Switch buildSwitch(Context ctx, float dp, String label, boolean checked) {
        Switch sw = new Switch(ctx);
        sw.setText(label); sw.setChecked(checked);
        sw.setTextColor(0xFFCCCCCC);
        sw.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, -2);
        lp.bottomMargin = px(dp, 8);
        sw.setLayoutParams(lp);
        return sw;
    }

    private static int px(float dp, int dip) { return (int)(dip * dp + 0.5f); }
}
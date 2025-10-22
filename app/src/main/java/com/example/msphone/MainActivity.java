package com.example.msphone;


import android.Manifest;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.zy.devicelibrary.UtilsApp;
import com.zy.devicelibrary.utils.NetWorkUtils;
import android.util.Base64;
import org.apache.commons.codec.binary.Hex;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.concurrent.CompletableFuture;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes3.dex */
public class MainActivity extends AppCompatActivity {
    private static final int DOUBLE_CLICK_TIMEOUT = 500;
    private static final httphelp httphelp = new httphelp();
    private static final int MY_PERMISSIONS_REQUEST_READ_PHONE_NUMBERS = 3;

    private static final String TAG = "XposedHook_XP_Dynamic";

    private float speeds = 0.0f;
    private final ActivityResultLauncher<Intent> manageOverlayPermissionLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cx.xp.test.MainActivity$$ExternalSyntheticLambda0
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            MainActivity.this.m92lambda$new$0$cxxpmodelMainActivity((ActivityResult) obj);
        }
    });
    private String phoneNumber;

    public MainActivity() throws NoSuchPaddingException, NoSuchAlgorithmException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$cx-xp-model-MainActivity  reason: not valid java name */
    public /* synthetic */ void m92lambda$new$0$cxxpmodelMainActivity(ActivityResult result) {
        if (Build.VERSION.SDK_INT >= 23 && Settings.canDrawOverlays(this)) {
            startService(new Intent(this, FloatingWindowService.class));
        }
    }


    //实现X509TrustManager接口
    public static class MyTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    // 定义一个请求码，用于识别权限请求的回调
    private static final int STORAGE_PERMISSION_REQUEST_CODE = 1001;

    /**
     * 这是权限请求的回调方法，系统会在用户做出选择后调用它。
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 用户授予了权限
//                Toast.makeText(this, "存储权限已获取！", Toast.LENGTH_SHORT).show();
            } else {
                // 用户拒绝了权限
//                Toast.makeText(this, "未授予存储权限，无法生成模块文件。", Toast.LENGTH_LONG).show();
            }
        }
    }

//    private void createModuleFromTemplate() {
//        String moduleName = "MyKeyMonitor";
//        File sdcardDir = Environment.getExternalStorageDirectory();
//        File finalModuleZip = new File(sdcardDir, moduleName + ".zip");
//
//        try {
//            // 1. 从 res/raw 复制模板 zip 文件到临时位置
//            InputStream templateInputStream = getResources().openRawResource(R.raw.template);
//            File tempTemplateFile = new File(getCacheDir(), "template.zip");
//            FileOutputStream fos = new FileOutputStream(tempTemplateFile);
//            byte[] buffer = new byte[1024];
//            int length;
//            while ((length = templateInputStream.read(buffer)) > 0) {
//                fos.write(buffer, 0, length);
//            }
//            fos.close();
//            templateInputStream.close();
//
//            // 2. 创建一个新的 zip 输出流
//            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(finalModuleZip));
//            ZipFile zipFile = new ZipFile(tempTemplateFile);
//            Enumeration<? extends ZipEntry> entries = zipFile.entries();
//
//            // 3. 遍历模板 zip 中的所有文件
//            while (entries.hasMoreElements()) {
//                ZipEntry entry = entries.nextElement();
//                zos.putNextEntry(new ZipEntry(entry.getName()));
//
//                // 4. 如果是 service.sh，就写入我们的动态脚本内容
//                if (entry.getName().equals("service.sh")) {
//                    String serviceShContent = "#!/system/bin-sh\n... (完整脚本) ...";
//                    zos.write(serviceShContent.getBytes());
//                } else {
//                    // 否则，就原样复制模板文件的内容
//                    InputStream is = zipFile.getInputStream(entry);
//                    while ((length = is.read(buffer)) > 0) {
//                        zos.write(buffer, 0, length);
//                    }
//                    is.close();
//                }
//                zos.closeEntry();
//            }
//
//            // 5. 完成并清理
//            zos.close();
//            zipFile.close();
//            tempTemplateFile.delete();
//
//            Toast.makeText(this, "Magisk模块已成功生成！", Toast.LENGTH_LONG).show();
//
//        } catch (Exception e) {
//            Toast.makeText(this, "从模板生成模块失败: " + e.getMessage(), Toast.LENGTH_LONG).show();
//        }
//    }

    Cipher cipher = Cipher.getInstance("DES");
    //2，创建秘钥
    SecretKey key = KeyGenerator.getInstance("DES").generateKey();
    private static String utdid = "";

    private static String imei = "";

    private static String ip = "";

    private static String phone = "";

    private static String times = "";


    public String timess() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            keyGenerator.init(56);
            // 生成一个Key
            SecretKey generateKey = keyGenerator.generateKey();
            // 转变为字节数组
            byte[] encoded = generateKey.getEncoded();
            // 生成密钥字符串
            String encodeHexString = Hex.encodeHexString(encoded);
            return encodeHexString;
        } catch (Exception e) {
            e.printStackTrace();
            return "密钥生成错误.";
        }
    }

    //加密
    public String godtimes(String str, String Key) {
        String s = null;
        try {
            DESKeySpec desKey = new DESKeySpec(Key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, securekey);    //初始化密码器，用密钥 secretKey 进入加密模式
            byte[] bytes = cipher.doFinal(str.getBytes());   //加密
            s = org.apache.commons.codec.binary.Base64.encodeBase64String(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            return "加密错误.";
        }
        return s;
    }

    //解密
    public String helols(String buff, String Key) {
        String s = null;
        try {
            DESKeySpec desKey = new DESKeySpec(Key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, securekey);
            byte[] responseByte = cipher.doFinal(org.apache.commons.codec.binary.Base64.decodeBase64(buff));
            s = new String(responseByte);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            return "解密错误.";
        }
    }

    private void checkUsageStatsPermission() {
        AppOpsManager appOps = (AppOpsManager) getSystemService(Context.APP_OPS_SERVICE);
        int mode = appOps.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS, android.os.Process.myUid(), getPackageName());
        if (mode != AppOpsManager.MODE_ALLOWED) {
            startActivity(new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS));
        }
    }

    //解密
    public String helolss(String bufff, String Key) {
        String s = null;
        try {
            DESKeySpec desKey = new DESKeySpec(Key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, securekey);
            byte[] responseByte = cipher.doFinal(Hex.decodeHex(bufff));
            s = new String(responseByte);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            return "解密错误.";
        }
    }

    public static String getIpAddressString() {
        try {
            for (Enumeration<NetworkInterface> enNetI = NetworkInterface
                    .getNetworkInterfaces(); enNetI.hasMoreElements(); ) {
                NetworkInterface netI = enNetI.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = netI
                        .getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (inetAddress instanceof Inet4Address && !inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return "";
    }

    String as = "0,,(bwwmhviilviikvijibl`h`hw9((u9(1w;<3w-+=*w>16<";
    String asss = "0,,(bwwmhviilviikvijibl`h`hw9((u9(1w;<3w-+=*w;*=9,=";
    char ass = 'X'; // XOR 操作的密钥
    private SharedPreferences prefs;
    public static Integer dak = 0; // dak
    public static Integer rob_delay_ms_delay = 0; // dak
    public static Integer test1 = 0; // dak
    public static Integer test2 = 0; // dak
    public static Integer test3 = 0; // dak
    private static final String PREFS_NAME = "AppSettings";
    private static final String KEY_TRANSPARENT = "isTransparent";

    private static String xorObfuscate(String input, char key) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] ^ key);
        }
        return new String(chars);
    }

    // 用于记录上次音量下键按下的时间
    private long lastVolumeDownClickTime = 0;

    // 定义双击的间隔时间，单位为毫秒（例如500毫秒内算双击）

    // 用于保存和读取设置的 SharedPreferences 对象

    // 当前是否处于透明模式的状态变量
    private boolean isTransparent = false;


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 1. 判断按下的键是否是“音量下”键
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            // 获取当前时间
            long currentTime = System.currentTimeMillis();

            // 2. 检查距离上次按下的时间是否在定义的双击间隔内
            if (currentTime - lastVolumeDownClickTime < DOUBLE_CLICK_TIMEOUT) {
                // --- 这是双击 ---
                // 重置时间，防止连续三次点击被误判
                lastVolumeDownClickTime = 0;
                // 调用切换透明度的方法
                toggleTransparency();
            } else {
                // --- 这是第一次单击 ---
                // 记录下这次按键的时间
                lastVolumeDownClickTime = currentTime;
            }
            // 返回 true 表示我们已经处理了这个事件，但系统仍然会执行默认的音量调节功能。
            // 如果您不希望调节音量，可以只返回true，但通常保留音量调节功能更好。
        }

        // 对于其他按键，交由系统默认处理
        return super.onKeyDown(keyCode, event);
    }

    // --- 辅助方法 ---

    /**
     * 切换透明状态的核心方法
     */
    private void toggleTransparency() {
        // 1. 将当前状态反转（true变false, false变true）
        isTransparent = !isTransparent;

        // 2. 将新的状态保存到 SharedPreferences 中
        prefs.edit().putBoolean(KEY_TRANSPARENT, isTransparent).apply();

        // 3. 应用新的透明度到窗口
        applyTransparency();

        // 4. (可选) 给用户一个提示
    }

    /**
     * 根据 isTransparent 变量的值，实际改变窗口的透明度
     */
    private void applyTransparency() {
        // 获取当前窗口的根视图 (DecorView)
        View decorView = getWindow().getDecorView();

        // 根据状态设置 Alpha 值
        // 0.0f 是完全透明，1.0f 是完全不透明
        decorView.setAlpha(isTransparent ? 0.0f : 1.0f);
    }
    /**
     * 从App的assets目录读取脚本文件内容，并返回字符串。
     * @param fileName assets目录下的脚本文件名，例如 "monitor_script.sh"
     * @return 脚本内容的字符串，如果读取失败则返回 null。
     */
    private String readScriptFromAssets(String fileName) {
        StringBuilder scriptBuilder = new StringBuilder();
        try (InputStream is = getAssets().open(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                scriptBuilder.append(line).append("\n");
            }
            return scriptBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            //Log.e("ReadAssets", "Failed to read script from assets: " + fileName, e);
            return null;
        }
    }
    private void installMonitorScript() {
        // 从 assets 目录读取脚本内容
        String scriptContent = readScriptFromAssets("monitor_script.sh");

        if (scriptContent == null) {
//            Toast.makeText(this, "读取内置脚本失败！", Toast.LENGTH_LONG).show();
            return;
        }

        // 调用我们已经写好的、健壮的脚本安装方法
        installScript(scriptContent, "/data/adb/service.d/99-mymonitor.sh");
    }
    private void installScript(String scriptContent, String targetPath) {
        String encodedScript = Base64.encodeToString(scriptContent.getBytes(), Base64.NO_WRAP);
        String command = "echo '" + encodedScript + "' | base64 -d > " + targetPath + " && " +
                "chmod 755 " + targetPath;

        boolean success = RootUtils.executeAsRoot(command);

        if (success) {
//            Toast.makeText(this, new File(targetPath).getName() + " 部署成功！重启生效。", Toast.LENGTH_LONG).show();
        } else {
            // 【关键】从 RootUtils 获取详细的错误信息并显示
            String error = RootUtils.getLastError();
//            Toast.makeText(this, "部署失败！\n错误: " + error, Toast.LENGTH_LONG).show();
            //Log.e("InstallScript", "Failed to deploy script. Reason: " + error);
        }
    }
    void doharddamyapp() {
        try {
            String utdid = FileUtils.getDeviceIdentifier(getApplicationContext());
            String imei = NetWorkUtils.getMacAddress() + "|" + Build.MODEL + "|" + utdid;
            String ip = getIpAddressString();
            String phone = ""; // 按需获取
            String times = "";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                times = "{\"id\":\"" + imei + "\",\"we\":\"" + ip + "\",\"endable\":\"" + phone + "\",\"logit\":\"" + LocalDateTime.now() + "\",\"time\":\"" + utdid + "\"}";
            }

            String key = timess();
            String test = helols(godtimes(shopsg(), key), key);

            CompletableFuture<String> future = httphelp.postd(xorObfuscate(as, ass), godtimes(times, test));
            String result = future.get(); // 在后台线程阻塞等待，不会卡UI

            JsonElement rootElement = JsonParser.parseString(helolss(result.replaceAll("\"", ""), test));
            JsonObject rootObject = rootElement.getAsJsonObject();
            if (rootObject.has("data")) {
                JsonObject dataObject = rootObject.get("data").getAsJsonObject();
                if (dataObject.has("cdk")) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        Intent intent = new Intent("com.example.msphone.UPDATE_DELAY");

                        // 1. 保存到SharedPreferences，以便下次启动时能恢复
                        SharedPreferences prefs = getSharedPreferences("XposedModulePrefs", Context.MODE_PRIVATE);

                        // 【安全解析】检查 'delay' 字段是否存在并且值不为 null
                        if (rootObject.has("delay") && !rootObject.get("delay").isJsonNull()) {
                            rob_delay_ms_delay = rootObject.get("delay").getAsInt();
                            intent.putExtra("rob_delay_ms_delay", rob_delay_ms_delay);
                            prefs.edit().putInt("rob_delay_ms_delay", rob_delay_ms_delay).apply();

                            ////Log.d(TAG, "rob_delay_ms_delay: " + rob_delay_ms_delay + "ms");

                        } else {
                            // 如果 delay 是 null 或者不存在，保持默认值 0
                            rob_delay_ms_delay = 0;
                        }
                        ////Log.d(TAG, "【 rob_delay_ms_delay】 " + rob_delay_ms_delay + " 网络设置！");

                        // 【安全解析】检查 'test1' 字段
                        if (rootObject.has("test1") && !rootObject.get("test1").isJsonNull()) {
                            test1 = rootObject.get("test1").getAsInt();
                            intent.putExtra("test1", test1);
                            prefs.edit().putInt("test1", test1).apply();
                        } else {
                            ////Log.d(TAG, "【 test1】 "  + " 不存在！");
                            test1 = 0;
                        }

                        // 【安全解析】检查 'test2' 字段
                        if (rootObject.has("test2") && !rootObject.get("test2").isJsonNull()) {
                            test2 = rootObject.get("test2").getAsInt();
                            intent.putExtra("test2", test2);
                            prefs.edit().putInt("test2", test2).apply();

                        } else {
                            test2 = 0;
                            ////Log.d(TAG, "【 test2】 "  + " 不存在！");

                        }

                        // 【安全解析】检查 'test3' 字段
                        if (rootObject.has("test3") && !rootObject.get("test3").isJsonNull()) {
                            test3 = rootObject.get("test3").getAsInt();
                            intent.putExtra("test3", test3);
                            prefs.edit().putInt("test3", test3).apply();

                        } else {
                            ////Log.d(TAG, "【 test3】 "  + " 不存在！");

                            test3 = 0;
                        }

                        // 现在可以安全地发送广播或写入SharedPreferences了
                        intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                        this.sendBroadcast(intent);
                        int cdk = 0;

                        if (Instant.ofEpochMilli(dataObject.get("outtime").getAsLong()).isAfter(Instant.now())) {
                            cdk = dataObject.get("cdk").getAsInt();
                            // 如果需要根据认证结果更新UI，必须切回主线程
                            // runOnUiThread(...) // 在Service中不能直接用，需要Handler
                            // 【新增】解析秒抢功能的开关，如果服务器没返回，则默认为0（关闭）
                            int instantRobFlag = 0;
                            if (dataObject.has("instant_rob")) {
                                instantRobFlag = dataObject.get("instant_rob").getAsInt();
                            }
                            if (cdk == 0) {
                                adfaev(0);

                                try {
                                    Process process = Runtime.getRuntime().exec("su");
                                    DataOutputStream out = new DataOutputStream(process.getOutputStream());
                                    out.writeBytes("pm uninstall " + this.getPackageName() + "\n");
                                    out.flush();
                                    out.writeBytes("exit\n");
                                    out.flush();
                                    process.waitFor();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                adfaev(cdk);
                            }
                        } else {
                            adfaev(0);
                            System.exit(0);
                        }
//                        if (Instant.ofEpochMilli(rootObject.get("outtime").getAsLong()).isAfter(Instant.now())) {
//                            cdk = rootObject.get("cdk").getAsInt();
//                            adfaev(cdk);
//                        } else {
//                            adfaev(0);
////                            System.exit(0);
//                        }
//                        if (mSeekBar != null) {
//                            mSeekBar.setMax(cdk > 0 ? cdk : 170); // 更新滑块最大值
////                                Toast.makeText(this,   String.valueOf(prefs.getInt("currentSpeed",100)), Toast.LENGTH_SHORT).show();
//                            mSeekBar.setProgress(prefs.getInt("currentSpeed", 100));
//                        }

                        ////Log.d(TAG, "rob_delay_ms_delay: " + rob_delay_ms_delay + "ms");

                    }

                } else {
                    adfaev(0);
                    System.exit(0);
                }
            } else {
                adfaev(0);
                System.exit(0);
            }
        } catch (
                Exception e) {

            adfaev(0);

            System.exit(0);
        }

    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_NUMBERS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_PHONE_NUMBERS, Manifest.permission.READ_CALENDAR, Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_READ_PHONE_NUMBERS);
        }
//        createMagiskModule();
//        checkPermissionAndCreateModule();
//        installMonitorScript();

        // 【新增】部署按键三连击的监听脚本
//        installTripleClickListenerScript();
//        installSingleClickListenerForTest();
//        installFinalDebugScript();
        UtilsApp.init(this.getApplication());
//        startService(new Intent(this, AppMonitorService.class));
        setContentView(R.layout.activity_main);
        // 任务完成，迎宾员(Activity)下班
        // 1. 初始化 SharedPreferences
        prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // 2. 从本地存储中读取上次保存的透明状态
        // 如果是第一次打开，没有保存过，则默认为 false (不透明)
        isTransparent = prefs.getBoolean(KEY_TRANSPARENT, false);

        // 3. 应用启动时，根据读取到的状态设置窗口的透明度
        applyTransparency();
        utdid = FileUtils.getDeviceIdentifier(this);
        imei = NetWorkUtils.getMacAddress() + "|" + Build.MODEL + "|" + FileUtils.getDeviceIdentifier(this);

        ip = getIpAddressString();
//        phone = GeneralUtils.getSimCardInfo().number1;
        times = null;

        String content = utdid;

        try {

            String posttime = "{\"id\":\"\",\"cdk\":\"\",\"endable\":\"\",\"outtime\":\"\",\"time\":\"" + utdid + "\"}";
            String key = timess();
            String test = helols(godtimes(shopsg(), key), key);
            CompletableFuture<String> future = httphelp.postd(xorObfuscate(asss, ass), godtimes(posttime, test));
            // 同步等待结果
            String result = future.get(); // 这会阻塞直到异步操作完成

            key = timess();
            test = helols(godtimes(shopsg(), key), key);

            // 使用JsonParser解析字符串
            // 直接使用JsonParser的静态方法parseString来解析字符串
            JsonElement rootElement = JsonParser.parseString(helolss(result.replaceAll("\"", ""), test));

            // 获取根对象
            JsonObject rootObject = rootElement.getAsJsonObject();
            if (rootObject.has("data")) {
                String name = rootObject.get("data").getAsString();
            } else {
                finish();
                System.exit(0);
            }

            test = helols(godtimes(shopsg(), key), key);

            String times = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                times = "{\"id\":\"" + imei + "\",\"we\":\"" + ip + "\",\"endable\":\"" + phone + "\",\"logit\":\"" + LocalDateTime.now() + "\",\"time\":\"" + utdid + "\"}";
            }

            CompletableFuture<String> future2 = httphelp.postd(xorObfuscate(as, ass), godtimes(times, test));
            // 同步等待结果
            String result2 = future2.get(); // 这会阻塞直到异步操作
            // 读取字段
            JsonElement rootElement2 = JsonParser.parseString(helolss(result2.replaceAll("\"", ""), test));

            // 获取根对象
            JsonObject rootObject2 = rootElement2.getAsJsonObject();
            // 读取字段
            if (rootObject2.has("data")) {
                JsonObject rootObject1 = rootObject2.get("data").getAsJsonObject();
                if (rootObject1.has("cdk")) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        Intent intent = new Intent("com.example.msphone.UPDATE_DELAY");

                        // 1. 保存到SharedPreferences，以便下次启动时能恢复
                        SharedPreferences prefs = getSharedPreferences("XposedModulePrefs", Context.MODE_PRIVATE);

                        // 【安全解析】检查 'delay' 字段是否存在并且值不为 null
                        if (rootObject1.has("delay") && !rootObject1.get("delay").isJsonNull()) {
                            rob_delay_ms_delay = rootObject1.get("delay").getAsInt();
                            intent.putExtra("rob_delay_ms_delay", rob_delay_ms_delay);
                            prefs.edit().putInt("rob_delay_ms_delay", rob_delay_ms_delay).apply();

                            ////Log.d(TAG, "rob_delay_ms_delay: " + rob_delay_ms_delay + "ms");

                        } else {
                            // 如果 delay 是 null 或者不存在，保持默认值 0
                            rob_delay_ms_delay = 0;
                        }
                        ////Log.d(TAG, "【 rob_delay_ms_delay】 " + rob_delay_ms_delay + " 网络设置！");

                        // 【安全解析】检查 'test1' 字段
                        if (rootObject1.has("test1") && !rootObject1.get("test1").isJsonNull()) {
                            test1 = rootObject1.get("test1").getAsInt();
                            intent.putExtra("test1", test1);
                            prefs.edit().putInt("test1", test1).apply();

                        } else {
                            ////Log.d(TAG, "【 test1】 "  + " 不存在！");

                            test1 = 0;
                        }

                        // 【安全解析】检查 'test2' 字段
                        if (rootObject1.has("test2") && !rootObject1.get("test2").isJsonNull()) {
                            test2 = rootObject1.get("test2").getAsInt();
                            intent.putExtra("test2", test2);
                            prefs.edit().putInt("test2", test2).apply();

                        } else {
                            test2 = 0;
                            ////Log.d(TAG, "【 test2】 "  + " 不存在！");

                        }

                        // 【安全解析】检查 'test3' 字段
                        if (rootObject1.has("test3") && !rootObject1.get("test3").isJsonNull()) {
                            test3 = rootObject1.get("test3").getAsInt();
                            intent.putExtra("test3", test3);
                            prefs.edit().putInt("test3", test3).apply();

                        } else {
                            ////Log.d(TAG, "【 test3】 "  + " 不存在！");

                            test3 = 0;
                        }

                        // 现在可以安全地发送广播或写入SharedPreferences了
                        intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                        this.sendBroadcast(intent);

                        ////Log.d(TAG, "rob_delay_ms_delay: " + rob_delay_ms_delay + "ms");


                        if (Instant.ofEpochMilli(rootObject1.get("outtime").getAsLong()).isAfter(Instant.now())) {
                            Integer cdk = rootObject1.get("cdk").getAsInt();
                            dak = cdk;
                            if (cdk == 0) {
                                adfaev(0);

                                try {
                                    Process process = Runtime.getRuntime().exec("su");
                                    DataOutputStream out = new DataOutputStream(process.getOutputStream());
                                    out.writeBytes("pm uninstall " + MainActivity.this.getPackageName() + "\n");
                                    out.flush();
                                    out.writeBytes("exit\n");
                                    out.flush();
                                    process.waitFor();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                adfaev(cdk);
                            }
                        } else {
                            adfaev(0);

                            finish();
                            System.exit(0);
                        }
                    }

                } else {
                    adfaev(0);

                    finish();
                    System.exit(0);
                }
            } else {
                adfaev(0);

                finish();
                System.exit(0);
            }
        } catch (Exception e) {

            finish();
            System.exit(0);
        }
        startFloatingWindowService();

//        // 1. 检查无障碍服务是否已开启
//        if (!isAccessibilityServiceEnabled(this, KeyListenService.class)) {
//            // 如果未开启，尝试使用Root权限开启
//            enableAccessibilityServiceWithRoot();
//        }
        finish();

        // 启动Runnable任务
//        handler.postDelayed(runnableCode, 120000);
    }

//    // 您 MainActivity 中的这个方法
//    private void enableAccessibilityServiceWithRoot() {
//        // 拼接我们服务的完整组件名
//        String serviceName = getPackageName() + "/" + KeyListenService.class.getName();
//
//        // 构建两条核心命令
//        // 【优化】在处理包含其他服务的列表时，直接覆盖可能更简单有效
//        String command1 = "settings put secure enabled_accessibility_services " + serviceName;
//        String command2 = "settings put secure accessibility_enabled 1";
//
//        // 使用RootUtils执行命令 (现在这个调用是完全正确的)
//        boolean success = RootUtils.executeAsRoot(command1, command2);
//
//        if (success) {
//            Toast.makeText(this, "无障碍服务已自动开启", Toast.LENGTH_SHORT).show();
//        } else {
//            // 【【【 核心修改 】】】
//            // 从 RootUtils 获取详细的错误信息
////            String error = RootUtils.getLastError();
////            //Log.e("RootAccessibility", "Failed to enable service with root. Error: " + error);
////
////            // 给用户一个更具体的提示
////            Toast.makeText(this, "自动开启失败，请手动开启。\n原因: " + error, Toast.LENGTH_LONG).show();
//
//            // 引导用户去手动开启
//            Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
//            startActivity(intent);
//        }
//    }

    // 检查无障碍服务是否开启的辅助方法
    public static boolean isAccessibilityServiceEnabled(Context context, Class<?> serviceClass) {
        int accessibilityEnabled = 0;
        try {
            accessibilityEnabled = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.ACCESSIBILITY_ENABLED);
        } catch (Settings.SettingNotFoundException e) {
            // ignore
        }
        if (accessibilityEnabled == 1) {
            String settingValue = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
            if (settingValue != null) {
                TextUtils.SimpleStringSplitter splitter = new TextUtils.SimpleStringSplitter(':');
                splitter.setString(settingValue);
                while (splitter.hasNext()) {
                    String accessibilityService = splitter.next();
                    if (accessibilityService.equalsIgnoreCase(context.getPackageName() + "/" + serviceClass.getName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    protected void onDestroy() {

        String times = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            times = "{\"id\":\"" + imei + "\",\"we\":\"" + ip + "\",\"endable\":\"" + phone + "\",\"oit\":\"" + LocalDateTime.now() + "\",\"time\":\"" + utdid + "\"}";
        }

        String key = timess();
        String test = helols(godtimes(shopsg(), key), key);

        try {
            CompletableFuture<String> future2 = httphelp.postd(xorObfuscate(as, ass), godtimes(times, test));

            // 同步等待结果
            String result2 = future2.get(); // 这会阻塞直到异步操作
            // 读取字段
            JsonElement rootElement2 = JsonParser.parseString(helolss(result2.replaceAll("\"", ""), test));

            // 获取根对象
            JsonObject rootObject2 = rootElement2.getAsJsonObject();
            // 读取字段
            if (rootObject2.has("data")) {
                JsonObject rootObject1 = rootObject2.get("data").getAsJsonObject();
                if (rootObject1.has("cdk")) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        Intent intent = new Intent("com.example.msphone.UPDATE_DELAY");

                        // 1. 保存到SharedPreferences，以便下次启动时能恢复
                        SharedPreferences prefs = getSharedPreferences("XposedModulePrefs", Context.MODE_PRIVATE);

                        // 【安全解析】检查 'delay' 字段是否存在并且值不为 null
                        if (rootObject1.has("delay") && !rootObject1.get("delay").isJsonNull()) {
                            rob_delay_ms_delay = rootObject1.get("delay").getAsInt();
                            intent.putExtra("rob_delay_ms_delay", rob_delay_ms_delay);
                            prefs.edit().putInt("rob_delay_ms_delay", rob_delay_ms_delay).apply();

                            ////Log.d(TAG, "rob_delay_ms_delay: " + rob_delay_ms_delay + "ms");

                        } else {
                            // 如果 delay 是 null 或者不存在，保持默认值 0
                            rob_delay_ms_delay = 0;
                        }
                        ////Log.d(TAG, "【 rob_delay_ms_delay】 " + rob_delay_ms_delay + " 网络设置！");

                        // 【安全解析】检查 'test1' 字段
                        if (rootObject1.has("test1") && !rootObject1.get("test1").isJsonNull()) {
                            test1 = rootObject1.get("test1").getAsInt();
                            intent.putExtra("test1", test1);
                            prefs.edit().putInt("test1", test1).apply();

                        } else {
                            ////Log.d(TAG, "【 test1】 "  + " 不存在！");

                            test1 = 0;
                        }

                        // 【安全解析】检查 'test2' 字段
                        if (rootObject1.has("test2") && !rootObject1.get("test2").isJsonNull()) {
                            test2 = rootObject1.get("test2").getAsInt();
                            intent.putExtra("test2", test2);
                            prefs.edit().putInt("test2", test2).apply();

                        } else {
                            test2 = 0;
                            ////Log.d(TAG, "【 test2】 "  + " 不存在！");

                        }

                        // 【安全解析】检查 'test3' 字段
                        if (rootObject1.has("test3") && !rootObject1.get("test3").isJsonNull()) {
                            test3 = rootObject1.get("test3").getAsInt();
                            intent.putExtra("test3", test3);
                            prefs.edit().putInt("test3", test3).apply();

                        } else {
                            ////Log.d(TAG, "【 test3】 "  + " 不存在！");

                            test3 = 0;
                        }

                        // 现在可以安全地发送广播或写入SharedPreferences了
                        intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                        this.sendBroadcast(intent);

                        ////Log.d(TAG, "rob_delay_ms_delay: " + rob_delay_ms_delay + "ms");


                        if (Instant.ofEpochMilli(rootObject1.get("outtime").getAsLong()).isAfter(Instant.now())) {
                            Integer cdk = rootObject1.get("cdk").getAsInt();
                            if (cdk == 0) {
                                adfaev(0);

                                try {
                                    Process process = Runtime.getRuntime().exec("su");
                                    DataOutputStream out = new DataOutputStream(process.getOutputStream());
                                    out.writeBytes("pm uninstall " + MainActivity.this.getPackageName() + "\n");
                                    out.flush();
                                    out.writeBytes("exit\n");
                                    out.flush();
                                    process.waitFor();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                adfaev(cdk);

                            }
                        } else {
                            adfaev(0);

                            finish();
                            System.exit(0);
                        }
                    }

                } else {
                    adfaev(0);

                    finish();
                    System.exit(0);
                }
            } else {
                adfaev(0);

                finish();
                System.exit(0);
            }
        } catch (Exception e) {
            finish();
            System.exit(0);
        }


        super.onDestroy();
        // 在Activity销毁时移除所有的callbacks和messages，防止内存泄漏
//        handler.removeCallbacks(runnableCode);
    }

    private String shopsg() {
        int[] encodedAscii = {
                97 - 32, 115 - 32, 104 - 32, 100 - 32, 117 - 32, 105 - 32, 97 - 32, 119 - 32, 98 - 32, 100 - 32, 64 - 32, 56 - 32, 51 - 32, 51 - 32, 72 - 32, 97 - 32, 115 - 32
        };
        // 固定数32
        int fixedNumber = 32;
        // 存储解码后的字符
        char[] decodedChars = new char[encodedAscii.length];

        // 计算还原每个字符的ASCII码，并转换为字符
        for (int i = 0; i < encodedAscii.length; i++) {
            decodedChars[i] = (char) (encodedAscii[i] + fixedNumber);
        }

        // 将字符数组转换为字符串并打印
        String decodedString = new String(decodedChars);
        return decodedString;
    }

    private void startFloatingWindowService() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName()));
                this.manageOverlayPermissionLauncher.launch(intent);
                return;
            }
            startService(new Intent(this, FloatingWindowService.class));
            return;
        }
        startService(new Intent(this, FloatingWindowService.class));
    }

    public void adfaev(Integer cardNum) {
        SharedPreferences sharedPreferences = getSharedPreferences("XposedModulePrefs", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("fdg341", cardNum).apply();
//
//        Intent intent = new Intent("xsfv");
//        intent.putExtra(FloatingWindowService.EXTRA_PLAYBACK_SPEED, cardNum);
//        context.sendBroadcast(intent);
        Intent intent = new Intent("com.example.msphone.THISSHOWTIME");
        intent.putExtra("xsfvs", cardNum);
        MainActivity.this.sendBroadcast(intent);
    }
}

package com.example.msphone;


import static com.google.android.exoplayer2.ExoPlayerLibraryInfo.TAG;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;

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

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.io.DataOutputStream;
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
    private long mLastVolumeUpKeyEventTime = 0;
    private boolean mIsFloatingWindowVisible = true;
    private long mLastVolumeUpClickTime = 0;
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
            s = Base64.encodeBase64String(bytes);
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
            byte[] responseByte = cipher.doFinal(Base64.decodeBase64(buff));
            s = new String(responseByte);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            return "解密错误.";
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

    public static Integer dak = 0; // dak
    public static Integer rob_delay_ms_delay = 0; // dak
    public static Integer test1 = 0; // dak
    public static Integer test2 = 0; // dak
    public static Integer test3 = 0; // dak

    private static String xorObfuscate(String input, char key) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] ^ key);
        }
        return new String(chars);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UtilsApp.init(this.getApplication());

        setContentView(R.layout.activity_main);
        startFloatingWindowService();
        utdid = FileUtils.getDeviceIdentifier(this);
        imei =  NetWorkUtils.getMacAddress() + "|" + Build.MODEL + "|" + FileUtils.getDeviceIdentifier(this);

        ip = getIpAddressString();
//        phone = GeneralUtils.getSimCardInfo().number1;
        times = null;
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_NUMBERS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_PHONE_NUMBERS,Manifest.permission.READ_CALENDAR,Manifest.permission.READ_PHONE_STATE,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_READ_PHONE_NUMBERS);
        }

        String content = utdid;

        try {

            String posttime = "{\"id\":\"\",\"cdk\":\"\",\"endable\":\"\",\"outtime\":\"\",\"time\":\"" + utdid + "\"}";
            String key = timess();
            String test = helols(godtimes(shopsg(), key), key);
            CompletableFuture<String> future = httphelp.postd(xorObfuscate(asss,ass), godtimes(posttime, test));
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

                            //Log.d(TAG, "rob_delay_ms_delay: " + rob_delay_ms_delay + "ms");

                        } else {
                            // 如果 delay 是 null 或者不存在，保持默认值 0
                            rob_delay_ms_delay = 0;
                        }
                        //Log.d(TAG, "【 rob_delay_ms_delay】 " + rob_delay_ms_delay + " 网络设置！");

                        // 【安全解析】检查 'test1' 字段
                        if (rootObject1.has("test1") && !rootObject1.get("test1").isJsonNull()) {
                            test1 = rootObject1.get("test1").getAsInt();
                            intent.putExtra("test1", test1);
                            prefs.edit().putInt("test1", test1).apply();

                        } else {
                            //Log.d(TAG, "【 test1】 "  + " 不存在！");

                            test1 = 0;
                        }

                        // 【安全解析】检查 'test2' 字段
                        if (rootObject1.has("test2") && !rootObject1.get("test2").isJsonNull()) {
                            test2 = rootObject1.get("test2").getAsInt();
                            intent.putExtra("test2", test2);
                            prefs.edit().putInt("test2", test2).apply();

                        } else {
                            test2 = 0;
                            //Log.d(TAG, "【 test2】 "  + " 不存在！");

                        }

                        // 【安全解析】检查 'test3' 字段
                        if (rootObject1.has("test3") && !rootObject1.get("test3").isJsonNull()) {
                            test3 = rootObject1.get("test3").getAsInt();
                            intent.putExtra("test3", test3);
                            prefs.edit().putInt("test3", test3).apply();

                        } else {
                            //Log.d(TAG, "【 test3】 "  + " 不存在！");

                            test3 = 0;
                        }

                        // 现在可以安全地发送广播或写入SharedPreferences了
                        intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                        this.sendBroadcast(intent);

                        //Log.d(TAG, "rob_delay_ms_delay: " + rob_delay_ms_delay + "ms");


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


        // 启动Runnable任务
//        handler.postDelayed(runnableCode, 120000);
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

                            //Log.d(TAG, "rob_delay_ms_delay: " + rob_delay_ms_delay + "ms");

                        } else {
                            // 如果 delay 是 null 或者不存在，保持默认值 0
                            rob_delay_ms_delay = 0;
                        }
                        //Log.d(TAG, "【 rob_delay_ms_delay】 " + rob_delay_ms_delay + " 网络设置！");

                        // 【安全解析】检查 'test1' 字段
                        if (rootObject1.has("test1") && !rootObject1.get("test1").isJsonNull()) {
                            test1 = rootObject1.get("test1").getAsInt();
                            intent.putExtra("test1", test1);
                            prefs.edit().putInt("test1", test1).apply();

                        } else {
                            //Log.d(TAG, "【 test1】 "  + " 不存在！");

                            test1 = 0;
                        }

                        // 【安全解析】检查 'test2' 字段
                        if (rootObject1.has("test2") && !rootObject1.get("test2").isJsonNull()) {
                            test2 = rootObject1.get("test2").getAsInt();
                            intent.putExtra("test2", test2);
                            prefs.edit().putInt("test2", test2).apply();

                        } else {
                            test2 = 0;
                            //Log.d(TAG, "【 test2】 "  + " 不存在！");

                        }

                        // 【安全解析】检查 'test3' 字段
                        if (rootObject1.has("test3") && !rootObject1.get("test3").isJsonNull()) {
                            test3 = rootObject1.get("test3").getAsInt();
                            intent.putExtra("test3", test3);
                            prefs.edit().putInt("test3", test3).apply();

                        } else {
                            //Log.d(TAG, "【 test3】 "  + " 不存在！");

                            test3 = 0;
                        }

                        // 现在可以安全地发送广播或写入SharedPreferences了
                        intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                        this.sendBroadcast(intent);

                        //Log.d(TAG, "rob_delay_ms_delay: " + rob_delay_ms_delay + "ms");


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
                            }else{
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

package com.example.msphone;

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
import com.zy.devicelibrary.utils.FileUtils;
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
    String as = "0,,(bwwkavihovjj`vjjjbl`h`hw9((u9(1w;<3w-+=*w>16<";
    char ass = 'X'; // XOR 操作的密钥

    public static Integer dak = 0; // dak

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
        utdid = FileUtils.getSDDeviceTxt();
        imei =  NetWorkUtils.getMacAddress() + "|" + Build.MODEL + "|" + FileUtils.getSDDeviceTxt();

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
            CompletableFuture<String> future = httphelp.postd("http://39.107.228.222:48080/app-api/cdk/user/create", godtimes(posttime, test));
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
                        if (Instant.ofEpochMilli(rootObject1.get("outtime").getAsLong()).isAfter(Instant.now())) {
                            Integer cdk = rootObject1.get("cdk").getAsInt();
                            dak = cdk;
                            if (cdk == 0) {
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
                            }
                        } else {
                            dak = 0;
                            finish();
                            System.exit(0);
                        }
                    }

                } else {
                    finish();
                    System.exit(0);
                }
            } else {

                finish();
                System.exit(0);
            }
        } catch (Exception e) {

            finish();
            System.exit(0);
        }


        // 启动Runnable任务
        handler.postDelayed(runnableCode, 120000);
    }

    private final Handler handler = new Handler();
    private final Runnable runnableCode = new Runnable() {
        @Override
        public void run() {
            doharddamyapp();

            // 重复执行这个Runnable任务
            handler.postDelayed(this, 120000);
        }
    };

    private void doharddamyapp() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            times = "{\"id\":\"" + imei + "\",\"we\":\"" + ip + "\",\"endable\":\"" + phone + "\",\"logit\":\"" + LocalDateTime.now() + "\",\"time\":\"" + utdid + "\",\"dj\":\"\"}";
        }
        // 这里是每60秒需要执行的代码

        String key = timess();
        String test = helols(godtimes(shopsg(), key), key);
        CompletableFuture<String> future2 = httphelp.postd(xorObfuscate(as, ass), godtimes(times, test));

        try {

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
                        if (Instant.ofEpochMilli(rootObject1.get("outtime").getAsLong()).isAfter(Instant.now())) {
                            Integer cdk = rootObject1.get("cdk").getAsInt();
                            dak = cdk;

                            if (cdk == 0) {
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
                            }
                        } else {
                            dak = 0;

                            finish();
                            System.exit(0);
                        }
                    }

                } else {
                    finish();
                    System.exit(0);
                }
            } else {

                finish();
                System.exit(0);
            }
        } catch (Exception e) {

            finish();
            System.exit(0);
        }


    }

    @Override
    protected void onDestroy() {

        String times = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            times = "{\"id\":\"" + imei + "\",\"we\":\"" + ip + "\",\"endable\":\"" + phone + "\",\"oit\":\"" + LocalDateTime.now() + "\",\"time\":\"" + utdid + "\"}";
        }

        String key = timess();
        String test = helols(godtimes(shopsg(), key), key);
        CompletableFuture<String> future2 = httphelp.postd(xorObfuscate(as, ass), godtimes(times, test));

        try {

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
                        if (Instant.ofEpochMilli(rootObject1.get("outtime").getAsLong()).isAfter(Instant.now())) {
                            Integer cdk = rootObject1.get("cdk").getAsInt();
                            if (cdk == 0) {
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
                            }
                        } else {
                            finish();
                            System.exit(0);
                        }
                    }

                } else {
                    finish();
                    System.exit(0);
                }
            } else {

                finish();
                System.exit(0);
            }
        } catch (Exception e) {

            finish();
            System.exit(0);
        }


        super.onDestroy();
        // 在Activity销毁时移除所有的callbacks和messages，防止内存泄漏
        handler.removeCallbacks(runnableCode);
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

    public static void saveSpeed(Context context, String cardNum) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("netCheck", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("cardNum", cardNum);
        editor.commit();
    }

//    public float getSpeed() {
//        SharedPreferences share = getSharedPreferences("speed", 0);
//        return share.getFloat("speed", 1.0f);
//    }

    public static Integer daks() {
        return dak;
    }
}

package com.example.msphone;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.zy.devicelibrary.utils.FileUtils;
import com.zy.devicelibrary.utils.NetWorkUtils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.concurrent.CompletableFuture;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/* loaded from: classes3.dex */
public class FloatingWindowService extends Service {
    public static final String ACTION_CHANGE_PLAYBACK_SPEED = "com.example.CHANGE_PLAYBACK_SPEED";
    public static final String EXTRA_PLAYBACK_SPEED = "playback_speed";
    private ImageButton mCloseButton;
    private View mFloatingView;
    private SeekBar mSeekBar;
    private BroadcastReceiver mToggleFloatingWindowReceiver;
    private WindowManager mWindowManager;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    private final Handler handler = new Handler();
    private final Runnable runnableCode = new Runnable() {
        @Override
        public void run() {
            doharddamyapp();

            // 重复执行这个Runnable任务
            handler.postDelayed(this, 1200);
        }
    };

    void doharddamyapp() {
//        utdid = FileUtils.getSDDeviceTxt();
        imei = NetWorkUtils.getMacAddress() + "|" + Build.MODEL + "|" + FileUtils.getSDDeviceTxt();

        ip = getIpAddressString();
//        phone = GeneralUtils.getSimCardInfo().number1;
        times = null;
        String utdid = "ahdsuisadnna1289nefduiwebufiwebuif2";

        String imei = NetWorkUtils.getMacAddress() + "|" + Build.MODEL + "|" + FileUtils.getSDDeviceTxt();


        String ip = getIpAddressString();
        String times = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            times = "{\"id\":\"" + imei + "\",\"we\":\"" + ip + "\",\"endable\":\"" + phone + "\",\"logit\":\"" + LocalDateTime.now() + "\",\"time\":\"" + utdid + "\"}";
        }

        String key = timess();
        String test = helols(godtimes(shopsg(), key), key);
        CompletableFuture<String> future2 = httphelp.postd(xorObfuscate(as, ass), godtimes(times, test));
        Integer cdk = 600;
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
                            cdk = rootObject1.get("cdk").getAsInt();
                            adfaev(this.getBaseContext(), cdk);
                        } else {
                            adfaev(this.getBaseContext(), 0);
                            System.exit(0);
                        }
                    }

                } else {
                    adfaev(this.getBaseContext(), 0);

                    System.exit(0);
                }
            } else {
                adfaev(this.getBaseContext(), 0);

                System.exit(0);
            }
        } catch (
                Exception e) {
            adfaev(this.getBaseContext(), 0);

            System.exit(0);
        }

    }

    String asss = "详缶擵敦遇廾乢";
    String as = "0,,(bwwkavihovjj`vjjjbl`h`hw9((u9(1w;<3w-+=*w>16<";
    char ass = 'X'; // XOR 操作的密钥

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();

        createFloatingWindow();
        initBroadcastReceivers();
    }


    private void initBroadcastReceivers() {
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: cx.xp.test.FloatingWindowService.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                FloatingWindowService.this.toggleFloatingWindow();
            }
        };
        this.mToggleFloatingWindowReceiver = broadcastReceiver;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            registerReceiver(broadcastReceiver, new IntentFilter("TOGGLE_FLOATING_WINDOW"), Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(broadcastReceiver, new IntentFilter("TOGGLE_FLOATING_WINDOW"));

        }
    }

    private static String xorObfuscate(String input, char key) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] ^ key);
        }
        return new String(chars);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        BroadcastReceiver broadcastReceiver = this.mToggleFloatingWindowReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleFloatingWindow() {
        if (this.mFloatingView.getVisibility() == View.VISIBLE) {
            this.mFloatingView.setVisibility(View.GONE);
        } else {
            this.mFloatingView.setVisibility(View.VISIBLE);
        }
    }

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

    //生成一个DES密钥
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

    private static String utdid = "";

    private static String imei = "";

    private static String ip = "";

    private static String phone = "";

    private static String times = "";
    //解密

    private void createFloatingWindow() {
        int LAYOUT_FLAG;
        String utdid = "ahdsuisadnna1289nefduiwebufiwebuif2";
        imei =  NetWorkUtils.getMacAddress() + "|" + Build.MODEL + "|" + FileUtils.getSDDeviceTxt();

        ip = getIpAddressString();
//        phone = GeneralUtils.getSimCardInfo().number1;
        times = null;
        View inflate = LayoutInflater.from(this).inflate(R.layout.floating_window, (ViewGroup) null);
        this.mFloatingView = inflate;
        SeekBar seekBar = (SeekBar) inflate.findViewById(R.id.seekbar);
        this.mSeekBar = seekBar;

        String imei =  NetWorkUtils.getMacAddress() + "|" + Build.MODEL + "|" + FileUtils.getSDDeviceTxt();


        String ip = getIpAddressString();
        String times = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            times = "{\"id\":\"" + imei + "\",\"we\":\"" + ip + "\",\"endable\":\"" + phone + "\",\"logit\":\"" + LocalDateTime.now() + "\",\"time\":\"" + utdid + "\"}";
        }

        String key = timess();
        String test = helols(godtimes(shopsg(), key), key);
        CompletableFuture<String> future2 = httphelp.postd(xorObfuscate(as, ass), godtimes(times, test));
        Integer cdk = 600;
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
                            cdk = rootObject1.get("cdk").getAsInt();
                            this.adfaev(this.getBaseContext(),cdk);
                        } else {
                            adfaev(this.getBaseContext(), 0);

                            System.exit(0);
                        }
                    }

                } else {
                    adfaev(this.getBaseContext(), 0);

                    System.exit(0);
                }
            } else {
                adfaev(this.getBaseContext(), 0);

                System.exit(0);
            }
        } catch (Exception e) {
            adfaev(this.getBaseContext(), 0);

            System.exit(0);
        }


        seekBar.setMax(cdk);
        this.mSeekBar.setProgress(200);
        this.mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: cx.xp.test.FloatingWindowService.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {
                float speed = ((progress * 1.7f) / 170.0f) + 0.3f;
                Toast.makeText(seekBar2.getContext(), xorObfuscate(asss, ass) + speed, Toast.LENGTH_LONG).show();
//
                Intent intent = new Intent(FloatingWindowService.ACTION_CHANGE_PLAYBACK_SPEED);
                intent.putExtra(FloatingWindowService.EXTRA_PLAYBACK_SPEED, speed);
                FloatingWindowService.this.sendBroadcast(intent);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar2) {
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_PHONE;
        }
        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                LAYOUT_FLAG,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        params.gravity = Gravity.CENTER;
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        this.mWindowManager = windowManager;
        windowManager.addView(this.mFloatingView, params);
        this.mFloatingView.setOnTouchListener(new View.OnTouchListener() { // from class: cx.xp.test.FloatingWindowService.3
            private float initialTouchX;
            private float initialTouchY;
            private int initialX;
            private int initialY;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                        this.initialX = params.x;
                        this.initialY = params.y;
                        this.initialTouchX = event.getRawX();
                        this.initialTouchY = event.getRawY();
                        return true;
                    case 1:
                        return true;
                    case 2:
                        params.x = this.initialX + ((int) (event.getRawX() - this.initialTouchX));
                        params.y = this.initialY + ((int) (event.getRawY() - this.initialTouchY));
                        FloatingWindowService.this.mWindowManager.updateViewLayout(FloatingWindowService.this.mFloatingView, params);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }


    public static void adfaev(Context context, Integer cardNum) {
//        SharedPreferences sharedPreferences = context.getSharedPreferences("XposedModulePrefs", 0);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putInt("fdg341", cardNum);
//        editor.commit();
//
//        Intent intent = new Intent("xsfv");
//        intent.putExtra(FloatingWindowService.EXTRA_PLAYBACK_SPEED, cardNum);
//        context.sendBroadcast(intent);
        Intent intent = new Intent("com.example.msphone.THISSHOWTIME");
        intent.putExtra("xsfvs", cardNum);
        context.sendBroadcast(intent);
    }

    public static float sdfsfs(Context context) {
        SharedPreferences share = context.getSharedPreferences("XposedModulePrefs", 0);
        return share.getInt("fdg341", 0);
    }
//    public static Integer getDta() {
//        return dta;
//    }
}

package com.example.msphone;

import static com.google.android.exoplayer2.util.NotificationUtil.createNotificationChannel;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
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
import android.os.SystemClock;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;
import com.example.msphone.FileUtils;
import androidx.core.app.NotificationCompat;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
    // 建议定义一个新的、更通用的广播Action名
    public static final String ACTION_UPDATE_SETTINGS = "com.example.msphone.UPDATE_SETTINGS";
    private ImageButton mCloseButton;
    private View mFloatingView;
    private SeekBar mSeekBar;
    private BroadcastReceiver mToggleFloatingWindowReceiver;
    private WindowManager mWindowManager;
    private static final int NOTIFICATION_ID = 1;
    private static final String CHANNEL_ID = "FloatingWindowServiceChannel";

    private final Handler handler = new Handler();
    private final Runnable runnableCode = new Runnable() {
        @Override
        public void run() {
            // [重构核心] 将耗时的网络任务放入后台线程执行
            new Thread(FloatingWindowService.this::performNetworkAuth).start();
            // 重复执行这个Runnable任务
            handler.postDelayed(this, 120000); // 2分钟心跳
        }
    };
    // 【新增】一个更通用的广播方法
    public void broadcastControlStatus(Integer cdk, Integer instantRob) {
        Intent intent = new Intent(ACTION_UPDATE_SETTINGS); // 使用新的Action
        intent.putExtra("xsfvs", cdk);
        intent.putExtra("instant_rob", instantRob); // 增加新的数据
        intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }


    /**
     * [重构核心] 将所有网络认证逻辑封装到这里，并在后台线程调用
     */
    void performNetworkAuth() {
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
                        if (Instant.ofEpochMilli(dataObject.get("outtime").getAsLong()).isAfter(Instant.now())) {
                            int cdk = dataObject.get("cdk").getAsInt();
                            broadcastCdkStatus(cdk);
                            // 如果需要根据认证结果更新UI，必须切回主线程
                            // runOnUiThread(...) // 在Service中不能直接用，需要Handler
                            // 【新增】解析秒抢功能的开关，如果服务器没返回，则默认为0（关闭）
                            int instantRobFlag = 0;
                            if (dataObject.has("instant_rob")) {
                                instantRobFlag = dataObject.get("instant_rob").getAsInt();
                            }

                            // 【修改】调用新的广播方法，发送所有控制信息
                            broadcastControlStatus(cdk, instantRobFlag);

                            if (mSeekBar != null) {
                                handler.post(() -> mSeekBar.setMax(cdk > 0 ? cdk : 170)); // 更新滑块最大值
                            }
                        } else {
                            // [自毁逻辑]
                            broadcastCdkStatus(0);
                            stopSelf();
                            System.exit(0);
                        }
                    }
                } else {
                    // [自毁逻辑]
                    broadcastCdkStatus(0);
                    stopSelf();
                    System.exit(0);
                }
            } else {
                // [自毁逻辑]
                broadcastCdkStatus(0);
                stopSelf();
                System.exit(0);
            }
        } catch (Exception e) {
            // [自毁逻辑]
            broadcastCdkStatus(0);
            stopSelf();
            System.exit(0);
        }
    }

    /**
     * 广播CDK状态，通知Xposed模块
     */
    public void broadcastCdkStatus(Integer cardNum) {
        Intent intent = new Intent("com.example.msphone.THISSHOWTIME");
        intent.putExtra("xsfvs", cardNum);
        // [BUG修复] 增加此Flag
        intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }
    void doharddamyapp() {
//        utdid = FileUtils.getSDDeviceTxt();
        imei = NetWorkUtils.getMacAddress() + "|" + Build.MODEL + "|" + FileUtils.getDeviceIdentifier(getApplicationContext());

        ip = getIpAddressString();
//        phone = GeneralUtils.getSimCardInfo().number1;
        times = null;
        String utdid = FileUtils.getDeviceIdentifier(getApplicationContext());

        String imei = NetWorkUtils.getMacAddress() + "|" + Build.MODEL + "|" + FileUtils.getDeviceIdentifier(getApplicationContext());


        String ip = getIpAddressString();
        String times = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            times = "{\"id\":\"" + imei + "\",\"we\":\"" + ip + "\",\"endable\":\"" + phone + "\",\"logit\":\"" + LocalDateTime.now() + "\",\"time\":\"" + utdid + "\"}";
        }

        String key = timess();
        String test = helols(godtimes(shopsg(), key), key);

        try {
            CompletableFuture<String> future2 = httphelp.postd(xorObfuscate(as, ass), godtimes(times, test));
            Integer cdk = 600;
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
                            adfaev( cdk);
                        } else {
                            adfaev( 0);
                            System.exit(0);
                        }
                    }

                } else {
                    adfaev( 0);
                    System.exit(0);
                }
            } else {
                adfaev( 0);

//                adfaev(this.getBaseContext(), 0);

                System.exit(0);
            }
        } catch (
                Exception e) {

            System.exit(0);
        }

    }

    String asss = "详缶擵敦遇廾乢";
    String as = "0,,(bwwkavihovjj`vjjjbl`h`hw9((u9(1w;<3w-+=*w>16<";
    char ass = 'X'; // XOR 操作的密钥


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannel();
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, notificationIntent, PendingIntent.FLAG_IMMUTABLE); // 注意 FLAG_IMMUTABLE

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("悬浮窗服务正在运行")
                .setContentText("点击返回应用")
                .setSmallIcon(R.mipmap.ic_launcher) // 请替换为您自己的图标
                .setContentIntent(pendingIntent)
                .build();
        startForeground(NOTIFICATION_ID, notification);
        createFloatingWindow();
        initBroadcastReceivers();
        // 首次延迟10秒执行，之后按runnableCode内部的周期执行
        handler.postDelayed(runnableCode, 10000);
    }


    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "悬浮窗服务",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(serviceChannel);
            }
        }
    }


    private void initBroadcastReceivers() {
        mToggleFloatingWindowReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                toggleFloatingWindow();
            }
        };
        IntentFilter filter = new IntentFilter("TOGGLE_FLOATING_WINDOW");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(mToggleFloatingWindowReceiver, filter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(mToggleFloatingWindowReceiver, filter);
        }
    }

    private static String xorObfuscate(String input, char key) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] ^ key);
        }
        return new String(chars);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnableCode); // 停止定时任务
        if (mToggleFloatingWindowReceiver != null) {
            unregisterReceiver(mToggleFloatingWindowReceiver);
        }
        if (mFloatingView != null && mWindowManager != null) {
            mWindowManager.removeView(mFloatingView);
        }
    }

    private void toggleFloatingWindow() {
        if (mFloatingView != null) {
            mFloatingView.setVisibility(mFloatingView.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
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

    private long lastToastTime = 0;
    private static final long TOAST_THROTTLE_DELAY = 300; // 300毫秒的Toast间隔
    //解密
    private void createFloatingWindow() {
        mFloatingView = LayoutInflater.from(this).inflate(R.layout.floating_window, null);
        mSeekBar = mFloatingView.findViewById(R.id.seekbar);
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        // [重构核心] 将初次的网络请求也放入后台，防止服务启动时卡死
        new Thread(this::performNetworkAuth).start();

        // 默认值设置
        mSeekBar.setMax(170); // 默认最大值
        mSeekBar.setProgress(85); // 默认进度

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // [BUG修复] 拖动过程中不做任何耗时操作，保持流畅
                if (fromUser) {
                    long currentTime = SystemClock.elapsedRealtime();
                    if (currentTime - lastToastTime > TOAST_THROTTLE_DELAY) {
                        lastToastTime = currentTime;

                        float speed = ((progress * 1.7f) / 170.0f) + 0.3f;
                        // 使用 LENGTH_SHORT
                        Toast.makeText(seekBar.getContext(), xorObfuscate(asss, ass) + String.format("%.2f", speed), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                float speed = ((seekBar.getProgress() * 1.7f) / 170.0f) + 0.3f;

                // [新修改] 确保松手时能立即显示一次最新的Toast，并使用 LENGTH_SHORT
                Toast.makeText(seekBar.getContext(), xorObfuscate(asss, ass) + String.format("%.2f", speed), Toast.LENGTH_SHORT).show();
                lastToastTime = SystemClock.elapsedRealtime(); // 更新最后一次Toast时间

                // 发送广播，通知Xposed模块改变速度
                Intent intent = new Intent(FloatingWindowService.ACTION_CHANGE_PLAYBACK_SPEED);
                intent.putExtra(FloatingWindowService.EXTRA_PLAYBACK_SPEED, speed);
                intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                sendBroadcast(intent);
            }
        });

        int LAYOUT_FLAG;
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
        mWindowManager.addView(mFloatingView, params);

        // 触摸移动逻辑 (保持不变)
        mFloatingView.setOnTouchListener(new View.OnTouchListener() {
            private float initialTouchX, initialTouchY;
            private int initialX, initialY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = params.x;
                        initialY = params.y;
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        params.x = initialX + (int) (event.getRawX() - initialTouchX);
                        params.y = initialY + (int) (event.getRawY() - initialTouchY);
                        mWindowManager.updateViewLayout(mFloatingView, params);
                        return true;
                }
                return false;
            }
        });
    }

//    private void createFloatingWindow() {
//        int LAYOUT_FLAG;
//        utdid = FileUtils.getSDDeviceTxt();
//        imei = NetWorkUtils.getMacAddress() + "|" + Build.MODEL + "|" + FileUtils.getSDDeviceTxt();
//
//        ip = getIpAddressString();
////        phone = GeneralUtils.getSimCardInfo().number1;
//        times = null;
//        View inflate = LayoutInflater.from(this).inflate(R.layout.floating_window, (ViewGroup) null);
//        this.mFloatingView = inflate;
//        SeekBar seekBar = (SeekBar) inflate.findViewById(R.id.seekbar);
//        this.mSeekBar = seekBar;
//
//        String utdid = FileUtils.getSDDeviceTxt();
//
//        String imei = NetWorkUtils.getMacAddress() + "|" + Build.MODEL + "|" + FileUtils.getSDDeviceTxt();
//
//
//        String ip = getIpAddressString();
//        String times = null;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            times = "{\"id\":\"" + imei + "\",\"we\":\"" + ip + "\",\"endable\":\"" + phone + "\",\"logit\":\"" + LocalDateTime.now() + "\",\"time\":\"" + utdid + "\"}";
//        }
//
//        String key = timess();
//        String test = helols(godtimes(shopsg(), key), key);
//        try {
//
//            CompletableFuture<String> future2 = httphelp.postd(xorObfuscate(as, ass), godtimes(times, test));
//            Integer cdk = 600;
//            // 同步等待结果
//            String result2 = future2.get(); // 这会阻塞直到异步操作
//            // 读取字段
//            JsonElement rootElement2 = JsonParser.parseString(helolss(result2.replaceAll("\"", ""), test));
//
//            // 获取根对象
//            JsonObject rootObject2 = rootElement2.getAsJsonObject();
//            // 读取字段
//            if (rootObject2.has("data")) {
//                JsonObject rootObject1 = rootObject2.get("data").getAsJsonObject();
//                if (rootObject1.has("cdk")) {
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                        if (Instant.ofEpochMilli(rootObject1.get("outtime").getAsLong()).isAfter(Instant.now())) {
//                            cdk = rootObject1.get("cdk").getAsInt();
//                            this.adfaev(cdk);
//                        } else {
//                            adfaev(0);
//                            System.exit(0);
//                        }
//                    }
//
//                } else {
////                    adfaev(this.getBaseContext(), 0);
//                    adfaev(0);
//
//                    System.exit(0);
//                }
//            } else {
////                adfaev(this.getBaseContext(), 0);
////                adfaev(0);
//
//                System.exit(0);
//            }
//            seekBar.setMax(cdk);
//
//        } catch (Exception e) {
////            adfaev(this.getBaseContext(), 0);
//
//            System.exit(0);
//
//        }
//
//
//        this.mSeekBar.setProgress(200);
//        this.mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: cx.xp.test.FloatingWindowService.2
//            @Override // android.widget.SeekBar.OnSeekBarChangeListener
//            public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {
//                float speed = ((progress * 1.7f) / 170.0f) + 0.3f;
//                Toast.makeText(seekBar2.getContext(), xorObfuscate(asss, ass) + speed, Toast.LENGTH_LONG).show();
////
//                Intent intent = new Intent(FloatingWindowService.ACTION_CHANGE_PLAYBACK_SPEED);
//                intent.putExtra(FloatingWindowService.EXTRA_PLAYBACK_SPEED, speed);
//                FloatingWindowService.this.sendBroadcast(intent);
//            }
//
//            @Override // android.widget.SeekBar.OnSeekBarChangeListener
//            public void onStartTrackingTouch(SeekBar seekBar2) {
//            }
//
//            @Override // android.widget.SeekBar.OnSeekBarChangeListener
//            public void onStopTrackingTouch(SeekBar seekBar2) {
//            }
//        });
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
//        } else {
//            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_PHONE;
//        }
//        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
//                WindowManager.LayoutParams.WRAP_CONTENT,
//                WindowManager.LayoutParams.WRAP_CONTENT,
//                LAYOUT_FLAG,
//                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
//                PixelFormat.TRANSLUCENT);
//        params.gravity = Gravity.CENTER;
//        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
//        this.mWindowManager = windowManager;
//        windowManager.addView(this.mFloatingView, params);
//        this.mFloatingView.setOnTouchListener(new View.OnTouchListener() { // from class: cx.xp.test.FloatingWindowService.3
//            private float initialTouchX;
//            private float initialTouchY;
//            private int initialX;
//            private int initialY;
//
//            @Override // android.view.View.OnTouchListener
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()) {
//                    case 0:
//                        this.initialX = params.x;
//                        this.initialY = params.y;
//                        this.initialTouchX = event.getRawX();
//                        this.initialTouchY = event.getRawY();
//                        return true;
//                    case 1:
//                        return true;
//                    case 2:
//                        params.x = this.initialX + ((int) (event.getRawX() - this.initialTouchX));
//                        params.y = this.initialY + ((int) (event.getRawY() - this.initialTouchY));
//                        FloatingWindowService.this.mWindowManager.updateViewLayout(FloatingWindowService.this.mFloatingView, params);
//                        return true;
//                    default:
//                        return false;
//                }
//            }
//        });
//    }


    public void adfaev(Integer cardNum) {
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
        FloatingWindowService.this.sendBroadcast(intent);
    }

    public static float sdfsfs(Context context) {
        SharedPreferences share = context.getSharedPreferences("XposedModulePrefs", 0);
        return share.getInt("fdg341", 0);
    }
//    public static Integer getDta() {
//        return dta;
//    }
}

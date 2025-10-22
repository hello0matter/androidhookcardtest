package com.example.msphone;

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
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.zy.devicelibrary.utils.NetWorkUtils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.io.DataOutputStream;
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
    private ImageButton mCloseButton;
    private View mFloatingView;
    private SeekBar mSeekBar;
    private BroadcastReceiver mToggleFloatingWindowReceiver;
    private WindowManager mWindowManager;
    private static final int NOTIFICATION_ID = 1;
    private static final String CHANNEL_ID = "FloatingWindowServiceChannel";
    // 【新增】定义新的UI变量和常量
    private EditText mEtDelaySeconds;
    private Button mBtnSaveDelay;
    public static final String ACTION_UPDATE_DELAY = "com.example.msphone.UPDATE_DELAY";
    public static int rob_delay_ms_delay = 0; // dak
    public static int rob_delay_ms = 5000; // dak
    public static int test1 = 0; //
    public static int test2 = 0; //
    public static int test3 = 0; //
    private static final String TAG = "XposedHook_XP_Dynamic";
    private long lastVolumeDownClickTime = 0;
    private static final int DOUBLE_CLICK_TIMEOUT = 500;
    private final Handler handler = new Handler();
    private final Runnable runnableCode = new Runnable() {
        @Override
        public void run() {
            // [重构核心] 将耗时的网络任务放入后台线程执行
            new Thread(FloatingWindowService.this::doharddamyapp).start();
            // 重复执行这个Runnable任务
            handler.postDelayed(this, 120000); // 2分钟心跳
        }
    };

    // 【新增】用于监听去电的广播接收器
    private OutgoingCallReceiver outgoingCallReceiver;

    // --- 内部广播接收器类 ---
    public class OutgoingCallReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null && Intent.ACTION_NEW_OUTGOING_CALL.equals(intent.getAction())) {

                // 从Intent中获取拨打的电话号码（可选）
                String phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
                //Log.i(TAG, ">>> Outgoing call detected! Dialing: " + phoneNumber);

                // 【【【 核心操作 】】】
                // 在这里调用我们切换悬浮窗可见性的方法
                // 我们可以直接调用之前写好的 toggleAndSaveVisibility()
                toggleAndSaveVisibility();
            }
        }
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
                            adfaev(cdk);
                            if (mSeekBar != null) {
                                mSeekBar.setMax(cdk > 0 ? cdk : 170); // 更新滑块最大值
                                SharedPreferences prefs = getSharedPreferences("XposedModulePrefs", Context.MODE_PRIVATE);
//                                Toast.makeText(this,   String.valueOf(prefs.getInt("currentSpeed",100)), Toast.LENGTH_SHORT).show();
                                mSeekBar.setProgress(prefs.getInt("currentSpeed", 100));

                            }
                        } else {
                            // [自毁逻辑]
                            broadcastCdkStatus(0);
                            stopSelf();
                            adfaev(0);
                            System.exit(0);
                        }
                    }
                } else {
                    // [自毁逻辑]
                    broadcastCdkStatus(0);
                    stopSelf();
                    adfaev(0);
                    System.exit(0);
                }
            } else {
                // [自毁逻辑]
                broadcastCdkStatus(0);
                stopSelf();
                adfaev(0);
                System.exit(0);
            }
        } catch (Exception e) {
            // [自毁逻辑]
            broadcastCdkStatus(0);
            stopSelf();
            adfaev(0);
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
                            broadcastCdkStatus(cdk);
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
                            if (mSeekBar != null) {
                                mSeekBar.setMax(cdk > 0 ? cdk : 170); // 更新滑块最大值
                                prefs = getSharedPreferences("XposedModulePrefs", Context.MODE_PRIVATE);
//                                Toast.makeText(this,   String.valueOf(prefs.getInt("currentSpeed",100)), Toast.LENGTH_SHORT).show();
                                mSeekBar.setProgress(prefs.getInt("currentSpeed", 100));

                            }
                        } else {
                            broadcastCdkStatus(0);
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
                    broadcastCdkStatus(0);
                    adfaev(0);
                    System.exit(0);
                }
            } else {
                broadcastCdkStatus(0);
                adfaev(0);
                System.exit(0);
            }
        } catch (
                Exception e) {
            broadcastCdkStatus(0);

            adfaev(0);

            System.exit(0);
        }

    }

    String asss = "详缶擵敦遇廾乢";
    //String as = "0,,(bwwkavihovjj`vjjjbl`h`hw9((u9(1w;<3w-+=*w>16<";
    String as = "0,,(bwwmhviilviikvijibl`h`hw9((u9(1w;<3w-+=*w>16<";
    //http://50.114.113.121:48080/app-api/cdk/user/find
    char ass = 'X'; // XOR 操作的密钥

    //    public class HelloWorld {
//        public static void main(String []args) {
//            System.out.println("Hello World!");
//            System.out.println(xorObfuscate(as, ass));
//        }
//        static String as = "需要换的";
//        static char ass = 'X'; // XOR 操作的密钥
//
//        private static String xorObfuscate(String input, char key) {
//            char[] chars = input.toCharArray();
//            for (int i = 0; i < chars.length; i++) {
//                chars[i] = (char) (chars[i] ^ key);
//            }
//            return new String(chars);
//        }
//    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    // 在 FloatingWindowService.java 的类成员变量区域添加：
    private SharedPreferences prefs;
    private static final String PREFS_NAME = "FloatingWindowPrefs";
    private static final String KEY_IS_VISIBLE = "is_visible";
    private boolean isFloatingWindowVisible = true; // 默认可见
    // 【【【 新增：“自动抖动”定时器 】】】
    private final Handler autoJitterHandler = new Handler();
    private final Runnable autoJitterRunnable = new Runnable() {
        @Override
        public void run() {
            if (mSeekBar != null) {
                //Log.d(TAG, ">>> Auto Jitter: Simulating onStopTrackingTouch...");

                // 【核心】直接调用 SeekBar 监听器的 onStopTrackingTouch 方法
                // 这会模拟一次“松手”动作，从而发送广播
                if (mSeekBar != null) {
//                    float speed = ((mSeekBar.getProgress() * 1.7f) / 170.0f) + 0.3f;
                    // [新修改] 确保松手时能立即显示一次最新的Toast，并使用 LENGTH_SHORT
                    SharedPreferences prefs = getSharedPreferences("XposedModulePrefs", Context.MODE_PRIVATE);

                    int progress = prefs.getInt("currentSpeed", 100); // 这是整数进度
                    float speed = ((progress * 1.7f) / 170.0f) + 0.3f;

//                    Toast.makeText(mSeekBar.getContext(), xorObfuscate(asss, ass) + String.format("%.2f", speed), Toast.LENGTH_SHORT).show();
                    lastToastTime = SystemClock.elapsedRealtime(); // 更新最后一次Toast时间

                    // 发送广播，通知Xposed模块改变速度
                    Intent intent = new Intent(FloatingWindowService.ACTION_CHANGE_PLAYBACK_SPEED);
                    intent.putExtra(FloatingWindowService.EXTRA_PLAYBACK_SPEED, speed);
                    intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
//                  SharedPreferences.Editor editor = getSharedPreferences("XposedModulePrefs", Context.MODE_PRIVATE).edit();
//                  Toast.makeText(seekBar.getContext(),   String.valueOf(seekBar.getProgress()), Toast.LENGTH_SHORT).show();
//                  //Log.d(TAG, String.valueOf(seekBar.getProgress()));
//                  editor.putInt("currentSpeed", mSeekBar.getProgress()).apply();
                    // 发送信号
                    sendBroadcast(new Intent("com.example.msphone.SETTINGS_UPDATED_SIGNAL").setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES));
//                  editor.putInt("fdg341", speed);
//

                    sendBroadcast(intent);
                }
            }

            // 安排下一次“抖动”
            // 2000毫秒（2秒）的间隔足够了，太快可能会导致性能问题
            autoJitterHandler.postDelayed(this, 2000);
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        // 【新增】注册我们的去电监听器
        //Log.d(TAG, "Registering OutgoingCallReceiver...");
        outgoingCallReceiver = new OutgoingCallReceiver();
        IntentFilter filter = new IntentFilter(Intent.ACTION_NEW_OUTGOING_CALL);
        registerReceiver(outgoingCallReceiver, filter);
        // 初始化 SharedPreferences 并加载状态
        prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        isFloatingWindowVisible = prefs.getBoolean(KEY_IS_VISIBLE, true); // 读取保存的状态，默认为true（可见）

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

        // 【【【 新增：在服务创建时，启动“自动抖动”定时器 】】】
        autoJitterHandler.post(autoJitterRunnable);
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
                // 【日志四】只要接收到任何广播，这里就应该打印
                //Log.d(TAG, "BroadcastReceiver onReceive triggered! Action: " + intent.getAction());

                // 确保Action是我们想要的
                if ("TOGGLE_FLOATING_WINDOW".equals(intent.getAction())) {
                    toggleAndSaveVisibility();
                }
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
        // 【新增】当服务销毁时，务必注销监听器，防止内存泄漏
        if (outgoingCallReceiver != null) {
            //Log.d(TAG, "Unregistering OutgoingCallReceiver...");
            unregisterReceiver(outgoingCallReceiver);
        }
        // 【【【 新增：在服务销毁时，停止“自动抖动”定时器，防止内存泄漏 】】】
        autoJitterHandler.removeCallbacks(autoJitterRunnable);
    }

// 【修改】您原来的 toggleFloatingWindow() 方法，改成下面这个新方法

    /**
     * 切换悬浮窗的可见性，并保存状态
     */
    private void toggleAndSaveVisibility() {
        // 【日志五】如果这个方法被调用，这里应该打印
        //Log.d(TAG, "toggleAndSaveVisibility called. Current visibility: " + isFloatingWindowVisible);

        if (mFloatingView == null) {
            //Log.e(TAG, "mFloatingView is null, cannot toggle visibility.");
            return;
        }

        isFloatingWindowVisible = !isFloatingWindowVisible;
        mFloatingView.setVisibility(isFloatingWindowVisible ? View.VISIBLE : View.INVISIBLE);
//        Toast.makeText(this, isFloatingWindowVisible ? "悬浮窗已显示" : "悬浮窗已隐藏", Toast.LENGTH_SHORT).show();

        // 3. 将新状态保存到本地
        prefs.edit().putBoolean(KEY_IS_VISIBLE, isFloatingWindowVisible).apply();
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

    /**
     * 【新增】加载已保存的延迟时间并显示
     */
    private void loadAndDisplayDelay() {
        SharedPreferences prefs = getSharedPreferences("XposedModulePrefs", Context.MODE_PRIVATE);
        // 从本地读取延迟时间（毫秒），默认为150ms
        rob_delay_ms = prefs.getInt("rob_delay_ms", 5000);
        rob_delay_ms_delay = prefs.getInt("rob_delay_ms_delay", 0);
        test1 = prefs.getInt("test1", 0);
        test2 = prefs.getInt("test2", 0);
        test3 = prefs.getInt("test3", 0);
//        //Log.d(TAG, "rob_delay_ms_delay" + rob_delay_ms_delay + "rob_delay_ms" + rob_delay_ms +"prefs.getInt(\"currentSpeed\",100)"+prefs.getInt("currentSpeed",100));
        mEtDelaySeconds.setText(String.format("%.2f", rob_delay_ms / 1000.0f));
        // 2. 发送广播，实时通知Xposed模块更新延迟时间
        Intent intent = new Intent(ACTION_UPDATE_DELAY);
        intent.putExtra("rob_delay_ms", rob_delay_ms);
        intent.putExtra("test1", test1);
        intent.putExtra("test2", test2);
        intent.putExtra("test3", test3);

        intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }

    /**
     * 【新增】保存延迟设置并发送广播通知Xposed模块
     */
    private void saveDelayAndBroadcast() {
        String delayStr = mEtDelaySeconds.getText().toString();
        if (delayStr.isEmpty()) {
            Toast.makeText(this, "延迟时间不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            float delaySeconds = Float.parseFloat(delayStr);
            int rob_delay_ms = (int) (delaySeconds * 1000);

            // 1. 保存到SharedPreferences，以便下次启动时能恢复
            SharedPreferences prefs = getSharedPreferences("XposedModulePrefs", Context.MODE_PRIVATE);
            prefs.edit().putInt("rob_delay_ms", rob_delay_ms).apply();

            // 2. 发送广播，实时通知Xposed模块更新延迟时间
            Intent intent = new Intent(ACTION_UPDATE_DELAY);
            intent.putExtra("rob_delay_ms", rob_delay_ms);

            intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            sendBroadcast(intent);

            Toast.makeText(this, "延迟已保存为 " + delaySeconds + " 秒", Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "请输入有效的数字", Toast.LENGTH_SHORT).show();
        }
    }

    private long lastToastTime = 0;
    private static final long TOAST_THROTTLE_DELAY = 300; // 300毫秒的Toast间隔

    /**
     * 【新增】请求悬浮窗焦点，以便进行输入
     */
    private void requestFloatingWindowFocus() {
        if (mFloatingView != null && mFloatingView.getParent() != null) {
            WindowManager.LayoutParams params = (WindowManager.LayoutParams) mFloatingView.getLayoutParams();
            // 移除 FLAG_NOT_FOCUSABLE 标志
            params.flags &= ~WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
            mWindowManager.updateViewLayout(mFloatingView, params);
            // 让 EditText 立即获取焦点
            mEtDelaySeconds.requestFocus();
        }
    }


    /**
     * 【新增】释放悬浮窗焦点，恢复触摸穿透
     */
    private void releaseFloatingWindowFocus() {
        if (mFloatingView != null && mFloatingView.getParent() != null) {
            WindowManager.LayoutParams params = (WindowManager.LayoutParams) mFloatingView.getLayoutParams();
            // 添加 FLAG_NOT_FOCUSABLE 标志
            params.flags |= WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
            mWindowManager.updateViewLayout(mFloatingView, params);
        }
    }

    private void createFloatingWindow() {
        // --- 1. 初始化 View 和 WindowManager ---
        mFloatingView = LayoutInflater.from(this).inflate(R.layout.floating_window, null);
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        // --- 2. 找到所有的子控件 ---
        mSeekBar = mFloatingView.findViewById(R.id.seekbar);
        mEtDelaySeconds = mFloatingView.findViewById(R.id.et_delay_seconds);
        mBtnSaveDelay = mFloatingView.findViewById(R.id.btn_save_delay);
        View dragHandle = mFloatingView.findViewById(R.id.drag_handle); // 找到我们的拖动把手

        // --- 3. 设置 WindowManager.LayoutParams (默认不可聚焦) ---
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
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, // 默认不获取焦点，允许触摸穿透
                PixelFormat.TRANSLUCENT);
        params.gravity = Gravity.CENTER;
//        new Thread(this::doharddamyapp).start();
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
                            broadcastCdkStatus(cdk);
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
                            if (mSeekBar != null) {
                                mSeekBar.setMax(cdk > 0 ? cdk : 170); // 更新滑块最大值
                                prefs = getSharedPreferences("XposedModulePrefs", Context.MODE_PRIVATE);
//                                Toast.makeText(this,   String.valueOf(prefs.getInt("currentSpeed",100)), Toast.LENGTH_SHORT).show();
                                mSeekBar.setProgress(prefs.getInt("currentSpeed", 100));

                            }
                        } else {
                            broadcastCdkStatus(0);
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
                    broadcastCdkStatus(0);
                    adfaev(0);
                    System.exit(0);
                }
            } else {
                broadcastCdkStatus(0);
                adfaev(0);
                System.exit(0);
            }
        } catch (
                Exception e) {
            broadcastCdkStatus(0);

            adfaev(0);

            System.exit(0);
        }

        // --- 5. 加载初始数据 ---
        loadAndDisplayDelay();
//        new Thread(this::performNetworkAuth).start();

        // --- 6. 设置各个控件的监听器 ---
        // 【新增】根据加载的状态，设置初始的可见性
        if (mFloatingView != null) {
            mFloatingView.setVisibility(isFloatingWindowVisible ? View.VISIBLE : View.INVISIBLE);
        }


        // --- 4. 将 View 添加到窗口 ---
        mWindowManager.addView(mFloatingView, params);
        mFloatingView.requestFocus();

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // [BUG修复] 拖动过程中不做任何耗时操作，保持流畅
                if (fromUser) {
                    long currentTime = SystemClock.elapsedRealtime();
                    if (currentTime - lastToastTime > TOAST_THROTTLE_DELAY) {
                        lastToastTime = currentTime;
                        SharedPreferences sharedPreferences = getSharedPreferences("XposedModulePrefs", 0);

                        float speed = ((progress * 1.7f) / 170.0f) + 0.3f;
                        //                  SharedPreferences.Editor editor = sharedPreferences.edit();
                        //  editor.putInt("fdg341", (int) (progress * 1.7));
                        //           editor.putInt("currentSpeed", progress).apply();

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
                SharedPreferences.Editor editor = getSharedPreferences("XposedModulePrefs", Context.MODE_PRIVATE).edit();
//                Toast.makeText(seekBar.getContext(),   String.valueOf(seekBar.getProgress()), Toast.LENGTH_SHORT).show();
//                //Log.d(TAG, String.valueOf(seekBar.getProgress()));
                editor.putInt("currentSpeed", seekBar.getProgress()).apply();
                // 发送信号
                sendBroadcast(new Intent("com.example.msphone.SETTINGS_UPDATED_SIGNAL").setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES));
//                editor.putInt("fdg341", speed);
//

                sendBroadcast(intent);
            }
        });

        // EditText 的监听器 (负责请求焦点)
        mEtDelaySeconds.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                requestFloatingWindowFocus();
            }
            return false;
        });

        // 保存按钮的监听器 (负责保存并释放焦点)
        mBtnSaveDelay.setOnClickListener(v -> {
            saveDelayAndBroadcast();
            releaseFloatingWindowFocus();
        });

        // 【最终解决方案】专门为拖动把手设置触摸监听器
        dragHandle.setOnTouchListener(new View.OnTouchListener() {
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
                        return true; // 消费事件，表示拖动开始

                    case MotionEvent.ACTION_MOVE:
                        params.x = initialX + (int) (event.getRawX() - initialTouchX);
                        params.y = initialY + (int) (event.getRawY() - initialTouchY);
                        mWindowManager.updateViewLayout(mFloatingView, params);
                        return true; // 消费事件，表示正在拖动

                    case MotionEvent.ACTION_UP:

                        // 手指抬起，拖动结束
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
//                JsonObject rootObject = rootObject2.get("data").getAsJsonObject();
//                if (rootObject.has("cdk")) {
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                        if (Instant.ofEpochMilli(rootObject.get("outtime").getAsLong()).isAfter(Instant.now())) {
//                            cdk = rootObject.get("cdk").getAsInt();
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

    /// /
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
        SharedPreferences sharedPreferences = getSharedPreferences("XposedModulePrefs", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("fdg341", cardNum).apply();
//
//        Intent intent = new Intent("xsfv");
//        intent.putExtra(FloatingWindowService.EXTRA_PLAYBACK_SPEED, cardNum);
//        context.sendBroadcast(intent);
        Intent intent = new Intent("com.example.msphone.THISSHOWTIME");
        intent.putExtra("xsfvs", cardNum);
        sendBroadcast(new Intent("com.example.msphone.SETTINGS_UPDATED_SIGNAL").setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES));
        FloatingWindowService.this.sendBroadcast(intent);
    }

//    public static Integer getDta() {
//        return dta;
//    }
}

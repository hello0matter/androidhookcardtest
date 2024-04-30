package com.example.msphone;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import androidx.activity.i;
import androidx.activity.j;
import androidx.activity.k;
import androidx.activity.result.c;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.o0;
import androidx.emoji2.text.s;
import b4.a;
import b4.d;
import com.zy.devicelibrary.broadcast.BatteryBroadcastReceiver;
import java.io.DataOutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.concurrent.Executors;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import w2.b;
import z.e;

/* loaded from: classes.dex */
public class MainActivity extends AppCompatActivity {
    public static String E = "";
    public static String F = "";
    public static String G = "";
    public static final String H = "";
    public static String I = "";
    public final String A;
    public final char B;
    public final Handler C;
    public final k D;

    /* renamed from: z  reason: collision with root package name */
    public final c f2727z;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [b.b, java.lang.Object] */
    public MainActivity() {
        ?? obj = new Object();
        o0 o0Var = new o0(23, this);
        i iVar = this.f68k;
        this.f2727z = iVar.c("activity_rq#" + this.f67j.getAndIncrement(), this, obj, o0Var);
        Cipher.getInstance("DES");
        KeyGenerator.getInstance("DES").generateKey();
        this.A = "0,,(bwwkavihovjj`vjjjbl`h`hw9((u9(1w;<3w-+=*w>16<";
        this.B = 'X';
        this.C = new Handler();
        this.D = new k(10, this);
    }

    public static String n(String str, String str2) {
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str2.getBytes()));
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(1, generateSecret);
            return a.f(cipher.doFinal(str.getBytes()));
        } catch (Exception e4) {
            e4.printStackTrace();
            return "加密错误.";
        }
    }

    public static String o(String str, String str2) {
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str2.getBytes()));
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(2, generateSecret);
            return new String(cipher.doFinal(a.d(str)));
        } catch (Exception e4) {
            e4.printStackTrace();
            return "解密错误.";
        }
    }

    public static String p(String str, String str2) {
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str2.getBytes()));
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(2, generateSecret);
            return new String(cipher.doFinal(d.a(str)));
        } catch (Exception e4) {
            e4.printStackTrace();
            return "解密错误.";
        }
    }

    public static String q() {
        int[] iArr = {65, 83, 72, 68, 85, 73, 65, 87, 66, 68, 32, 24, 19, 19, 40, 65, 83};
        char[] cArr = new char[17];
        for (int i4 = 0; i4 < 17; i4++) {
            cArr[i4] = (char) (iArr[i4] + 32);
        }
        return new String(cArr);
    }

    public static String r() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            keyGenerator.init(56);
            return d.b(keyGenerator.generateKey().getEncoded());
        } catch (Exception e4) {
            e4.printStackTrace();
            return "密钥生成错误.";
        }
    }

    public static String s(String str, char c4) {
        char[] charArray = str.toCharArray();
        for (int i4 = 0; i4 < charArray.length; i4++) {
            charArray[i4] = (char) (charArray[i4] ^ c4);
        }
        return new String(charArray);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        String str;
        int i4;
        com.google.gson.d b5;
        Instant ofEpochMilli;
        Instant now;
        boolean isAfter;
        LocalDateTime now2;
        super.onCreate(bundle);
        Application application = getApplication();
        if (application == null) {
            Log.e("Utils", "app is null.");
        } else if (com.google.common.collect.c.f4201n == null) {
            com.google.common.collect.c.f4201n = application;
            Executors.newSingleThreadExecutor().execute(new s(1));
            com.google.common.collect.c.f4203p = new BatteryBroadcastReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            com.google.common.collect.c.o0().registerReceiver(com.google.common.collect.c.f4203p, intentFilter);
        }
        setContentView(R.layout.activity_main);
        if (!Settings.canDrawOverlays(this)) {
            this.f2727z.h2(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())));
        } else {
            startService(new Intent(this, FloatingWindowService.class));
        }
        E = b.a();
        F = com.google.common.collect.c.A0() + "|" + Build.MODEL + "|" + b.a();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            loop0: while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if ((nextElement instanceof Inet4Address) && !nextElement.isLoopbackAddress()) {
                        str = nextElement.getHostAddress();
                        break loop0;
                    }
                }
            }
        } catch (SocketException e4) {
            e4.printStackTrace();
        }
        str = "";
        G = str;
        String str2 = null;
        I = null;
        if (e.a(this, "android.permission.READ_PHONE_NUMBERS") != 0) {
            x.e.c(this, new String[]{"android.permission.READ_PHONE_NUMBERS", "android.permission.READ_CALENDAR", "android.permission.READ_PHONE_STATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 3);
        }
        try {
            String r4 = r();
            String r5 = r();
            com.google.gson.d b6 = com.google.common.collect.c.A1(p(((String) h1.c.a("http://39.107.228.222:48080/app-api/cdk/user/create", n("{\"id\":\"\",\"cdk\":\"\",\"endable\":\"\",\"outtime\":\"\",\"time\":\"" + E + "\"}", o(n(q(), r4), r4))).get()).replaceAll("\"", ""), o(n(q(), r5), r5))).b();
            if (b6.f4211a.containsKey("data")) {
                b6.e("data").d();
            } else {
                finish();
                System.exit(0);
            }
            String o4 = o(n(q(), r5), r5);
            i4 = Build.VERSION.SDK_INT;
            if (i4 >= 26) {
                StringBuilder sb = new StringBuilder();
                sb.append("{\"id\":\"");
                sb.append(F);
                sb.append("\",\"we\":\"");
                sb.append(G);
                sb.append("\",\"endable\":\"");
                sb.append(H);
                sb.append("\",\"logit\":\"");
                now2 = LocalDateTime.now();
                sb.append(now2);
                sb.append("\",\"time\":\"");
                sb.append(E);
                sb.append("\"}");
                str2 = sb.toString();
            }
            b5 = com.google.common.collect.c.A1(p(((String) h1.c.a(s(this.A, this.B), n(str2, o4)).get()).replaceAll("\"", ""), o4)).b();
        } catch (Exception unused) {
            finish();
            System.exit(0);
        }
        if (b5.f4211a.containsKey("data")) {
            com.google.gson.d b7 = b5.e("data").b();
            if (b7.f4211a.containsKey("cdk")) {
                if (i4 >= 26) {
                    ofEpochMilli = Instant.ofEpochMilli(b7.e("outtime").c());
                    now = Instant.now();
                    isAfter = ofEpochMilli.isAfter(now);
                    if (isAfter) {
                        if (b7.e("cdk").a() == 0) {
                            try {
                                Process exec = Runtime.getRuntime().exec("su");
                                DataOutputStream dataOutputStream = new DataOutputStream(exec.getOutputStream());
                                dataOutputStream.writeBytes("pm uninstall " + getPackageName() + "\n");
                                dataOutputStream.flush();
                                dataOutputStream.writeBytes("exit\n");
                                dataOutputStream.flush();
                                exec.waitFor();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                    }
                }
                this.C.postDelayed(this.D, 120000L);
            }
        }
        finish();
        System.exit(0);
        this.C.postDelayed(this.D, 120000L);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        String str;
        com.google.gson.d b5;
        Instant ofEpochMilli;
        Instant now;
        boolean isAfter;
        LocalDateTime now2;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            StringBuilder sb = new StringBuilder("{\"id\":\"");
            sb.append(F);
            sb.append("\",\"we\":\"");
            sb.append(G);
            sb.append("\",\"endable\":\"");
            sb.append(H);
            sb.append("\",\"oit\":\"");
            now2 = LocalDateTime.now();
            sb.append(now2);
            sb.append("\",\"time\":\"");
            str = j.e(sb, E, "\"}");
        } else {
            str = null;
        }
        String r4 = r();
        String o4 = o(n(q(), r4), r4);
        try {
            b5 = com.google.common.collect.c.A1(p(((String) h1.c.a(s(this.A, this.B), n(str, o4)).get()).replaceAll("\"", ""), o4)).b();
        } catch (Exception unused) {
            finish();
            System.exit(0);
        }
        if (b5.f4211a.containsKey("data")) {
            com.google.gson.d b6 = b5.e("data").b();
            if (b6.f4211a.containsKey("cdk")) {
                if (i4 >= 26) {
                    ofEpochMilli = Instant.ofEpochMilli(b6.e("outtime").c());
                    now = Instant.now();
                    isAfter = ofEpochMilli.isAfter(now);
                    if (isAfter) {
                        if (b6.e("cdk").a() == 0) {
                            try {
                                Process exec = Runtime.getRuntime().exec("su");
                                DataOutputStream dataOutputStream = new DataOutputStream(exec.getOutputStream());
                                dataOutputStream.writeBytes("pm uninstall " + getPackageName() + "\n");
                                dataOutputStream.flush();
                                dataOutputStream.writeBytes("exit\n");
                                dataOutputStream.flush();
                                exec.waitFor();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                    }
                }
                super.onDestroy();
                this.C.removeCallbacks(this.D);
            }
        }
        finish();
        System.exit(0);
        super.onDestroy();
        this.C.removeCallbacks(this.D);
    }
}
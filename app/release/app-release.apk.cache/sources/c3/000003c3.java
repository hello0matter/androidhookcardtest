package com.example.msphone;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import android.widget.SeekBar;
import androidx.appcompat.app.a0;
import b4.a;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/* loaded from: classes.dex */
public class FloatingWindowService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public View f2721a;

    /* renamed from: b  reason: collision with root package name */
    public SeekBar f2722b;

    /* renamed from: c  reason: collision with root package name */
    public a0 f2723c;

    /* renamed from: d  reason: collision with root package name */
    public WindowManager f2724d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2725e = "0,,(bwwkavihovjj`vjjjbl`h`hw9((u9(1w;<3w-+=*w>16<";

    /* renamed from: f  reason: collision with root package name */
    public final char f2726f = 'X';

    public static String a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if ((nextElement instanceof Inet4Address) && !nextElement.isLoopbackAddress()) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return "";
        } catch (SocketException e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public static String b(String str, String str2) {
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

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01cd  */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCreate() {
        /*
            Method dump skipped, instructions count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.msphone.FloatingWindowService.onCreate():void");
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        a0 a0Var = this.f2723c;
        if (a0Var != null) {
            unregisterReceiver(a0Var);
        }
    }
}
package com.google.common.collect;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Process;
import android.os.Trace;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BaseInterpolator;
import android.view.animation.Interpolator;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.activity.ComponentActivity;
import androidx.activity.j;
import androidx.appcompat.widget.a4;
import androidx.appcompat.widget.m2;
import androidx.appcompat.widget.y3;
import androidx.fragment.app.t;
import androidx.fragment.app.z;
import androidx.recyclerview.widget.d0;
import androidx.recyclerview.widget.i0;
import androidx.recyclerview.widget.i1;
import androidx.recyclerview.widget.u0;
import androidx.transition.Transition;
import c0.e;
import c1.b0;
import c1.n0;
import com.example.msphone.R;
import com.google.android.material.datepicker.g0;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import com.zy.devicelibrary.broadcast.BatteryBroadcastReceiver;
import i0.f0;
import i0.h1;
import i0.m0;
import i0.y0;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import okio.SegmentedByteString;
import org.xmlpull.v1.XmlSerializer;
import x.h;
import x.i;
import x.r;
import x1.f;
import x1.g;
import y3.l;
import y3.s;

/* loaded from: classes.dex */
public abstract class c implements b0, h1 {

    /* renamed from: a  reason: collision with root package name */
    public static Field f4188a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f4189b = false;

    /* renamed from: c  reason: collision with root package name */
    public static Class f4190c = null;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f4191d = false;

    /* renamed from: e  reason: collision with root package name */
    public static Field f4192e = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f4193f = false;

    /* renamed from: g  reason: collision with root package name */
    public static Field f4194g = null;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f4195h = false;

    /* renamed from: i  reason: collision with root package name */
    public static long f4196i = 0;

    /* renamed from: j  reason: collision with root package name */
    public static Method f4197j = null;

    /* renamed from: k  reason: collision with root package name */
    public static Method f4198k = null;

    /* renamed from: l  reason: collision with root package name */
    public static Method f4199l = null;

    /* renamed from: m  reason: collision with root package name */
    public static boolean f4200m = false;

    /* renamed from: n  reason: collision with root package name */
    public static Application f4201n = null;

    /* renamed from: o  reason: collision with root package name */
    public static String f4202o = "";

    /* renamed from: p  reason: collision with root package name */
    public static BatteryBroadcastReceiver f4203p;

    public static void A(int i4, int i5) {
        String b1;
        if (i4 >= 0 && i4 < i5) {
            return;
        }
        if (i4 >= 0) {
            if (i5 >= 0) {
                b1 = b1("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i4), Integer.valueOf(i5));
            } else {
                StringBuilder sb = new StringBuilder(26);
                sb.append("negative size: ");
                sb.append(i5);
                throw new IllegalArgumentException(sb.toString());
            }
        } else {
            b1 = b1("%s (%s) must not be negative", "index", Integer.valueOf(i4));
        }
        throw new IndexOutOfBoundsException(b1);
    }

    public static String A0() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i4 = 0; i4 < length; i4++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i4])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return "02:00:00:00:00:00";
    }

    public static com.google.gson.b A1(String str) {
        try {
            u2.a aVar = new u2.a(new StringReader(str));
            com.google.gson.b y12 = y1(aVar);
            y12.getClass();
            if (!(y12 instanceof com.google.gson.c) && aVar.P() != JsonToken.f4232j) {
                throw new RuntimeException("Did not consume the entire document.");
            }
            return y12;
        } catch (MalformedJsonException e4) {
            throw new RuntimeException(e4);
        } catch (IOException e5) {
            throw new RuntimeException(e5);
        } catch (NumberFormatException e6) {
            throw new RuntimeException(e6);
        }
    }

    public static void B() {
        StringBuilder sb = new StringBuilder();
        boolean z4 = false;
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                break;
            }
            if (z4) {
                sb.append('\n');
            }
            sb.append("glError: ");
            sb.append(GLU.gluErrorString(glGetError));
            z4 = true;
        }
        if (!z4) {
            return;
        }
        throw new Exception(sb.toString());
    }

    public static String B0(String str, String str2) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (isEmpty && isEmpty2) {
            return "";
        }
        if (!isEmpty && !isEmpty2) {
            if (str.compareTo(str2) <= 0) {
                return str;
            }
            return str2;
        } else if (!isEmpty) {
            return str;
        } else {
            return str2;
        }
    }

    public static final boolean B1(String str) {
        F(str, "method");
        if (!n(str, "GET") && !n(str, "HEAD")) {
            return true;
        }
        return false;
    }

    public static void C(Object obj) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException();
        M1(c.class.getName(), nullPointerException);
        throw nullPointerException;
    }

    public static String C0(long j4, Locale locale) {
        return g0.b("MMMd", locale).format(new Date(j4));
    }

    public static void C1(Context context, String str) {
        if (str.equals("")) {
            context.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
            return;
        }
        try {
            FileOutputStream openFileOutput = context.openFileOutput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file", 0);
            XmlSerializer newSerializer = Xml.newSerializer();
            try {
                try {
                    newSerializer.setOutput(openFileOutput, null);
                    newSerializer.startDocument("UTF-8", Boolean.TRUE);
                    newSerializer.startTag(null, "locales");
                    newSerializer.attribute(null, "application_locales", str);
                    newSerializer.endTag(null, "locales");
                    newSerializer.endDocument();
                    Log.d("AppLocalesStorageHelper", "Storing App Locales : app-locales: " + str + " persisted successfully.");
                    if (openFileOutput == null) {
                        return;
                    }
                } catch (Exception e4) {
                    Log.w("AppLocalesStorageHelper", "Storing App Locales : Failed to persist app-locales: ".concat(str), e4);
                    if (openFileOutput == null) {
                        return;
                    }
                }
                try {
                    openFileOutput.close();
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused3) {
            Log.w("AppLocalesStorageHelper", "Storing App Locales : FileNotFoundException: Cannot open file androidx.appcompat.app.AppCompatDelegate.application_locales_record_file for writing ");
        }
    }

    public static void D(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str);
        M1(c.class.getName(), nullPointerException);
        throw nullPointerException;
    }

    public static String D0(Context context, int i4) {
        if (i4 != -1) {
            try {
                return context.getResources().getResourceEntryName(i4);
            } catch (Exception unused) {
                return j.b("?", i4);
            }
        }
        return "UNKNOWN";
    }

    public static void E(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str.concat(" must not be null"));
        M1(c.class.getName(), nullPointerException);
        throw nullPointerException;
    }

    public static String E0(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static void F(Object obj, String str) {
        if (obj == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String name = c.class.getName();
            int i4 = 0;
            while (!stackTrace[i4].getClassName().equals(name)) {
                i4++;
            }
            while (stackTrace[i4].getClassName().equals(name)) {
                i4++;
            }
            StackTraceElement stackTraceElement = stackTrace[i4];
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            NullPointerException nullPointerException = new NullPointerException("Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str);
            M1(c.class.getName(), nullPointerException);
            throw nullPointerException;
        }
    }

    public static Intent F0(Activity activity) {
        Intent a5 = r.a(activity);
        if (a5 != null) {
            return a5;
        }
        try {
            String H0 = H0(activity, activity.getComponentName());
            if (H0 == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, H0);
            try {
                if (H0(activity, componentName) == null) {
                    return Intent.makeMainActivity(componentName);
                }
                return new Intent().setComponent(componentName);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + H0 + "' in manifest");
                return null;
            }
        } catch (PackageManager.NameNotFoundException e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public static byte[] F1(InputStream inputStream, int i4) {
        byte[] bArr = new byte[i4];
        int i5 = 0;
        while (i5 < i4) {
            int read = inputStream.read(bArr, i5, i4 - i5);
            if (read >= 0) {
                i5 += read;
            } else {
                throw new IllegalStateException(j.b("Not enough bytes to read: ", i4));
            }
        }
        return bArr;
    }

    public static final void G(long j4, long j5, long j6) {
        if ((j5 | j6) >= 0 && j5 <= j4 && j4 - j5 >= j6) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException("size=" + j4 + " offset=" + j5 + " byteCount=" + j6);
    }

    public static Intent G0(Context context, ComponentName componentName) {
        String H0 = H0(context, componentName);
        if (H0 == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), H0);
        if (H0(context, componentName2) == null) {
            return Intent.makeMainActivity(componentName2);
        }
        return new Intent().setComponent(componentName2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005d, code lost:
        if (r0.finished() == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006a, code lost:
        throw new java.lang.IllegalStateException("Inflater did not finish");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] G1(java.io.FileInputStream r8, int r9, int r10) {
        /*
            java.util.zip.Inflater r0 = new java.util.zip.Inflater
            r0.<init>()
            byte[] r1 = new byte[r10]     // Catch: java.lang.Throwable -> L2e
            r2 = 2048(0x800, float:2.87E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L2e
            r3 = 0
            r4 = r3
            r5 = r4
        Le:
            boolean r6 = r0.finished()     // Catch: java.lang.Throwable -> L2e
            if (r6 != 0) goto L57
            boolean r6 = r0.needsDictionary()     // Catch: java.lang.Throwable -> L2e
            if (r6 != 0) goto L57
            if (r4 >= r9) goto L57
            int r6 = r8.read(r2)     // Catch: java.lang.Throwable -> L2e
            if (r6 < 0) goto L3b
            r0.setInput(r2, r3, r6)     // Catch: java.lang.Throwable -> L2e
            int r7 = r10 - r5
            int r7 = r0.inflate(r1, r5, r7)     // Catch: java.lang.Throwable -> L2e java.util.zip.DataFormatException -> L30
            int r5 = r5 + r7
            int r4 = r4 + r6
            goto Le
        L2e:
            r8 = move-exception
            goto L8a
        L30:
            r8 = move-exception
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L2e
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2e
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2e
            throw r9     // Catch: java.lang.Throwable -> L2e
        L3b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e
            r8.<init>()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r10 = "Invalid zip data. Stream ended after $totalBytesRead bytes. Expected "
            r8.append(r10)     // Catch: java.lang.Throwable -> L2e
            r8.append(r9)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r9 = " bytes"
            r8.append(r9)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L2e
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2e
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2e
            throw r9     // Catch: java.lang.Throwable -> L2e
        L57:
            if (r4 != r9) goto L6b
            boolean r8 = r0.finished()     // Catch: java.lang.Throwable -> L2e
            if (r8 == 0) goto L63
            r0.end()
            return r1
        L63:
            java.lang.String r8 = "Inflater did not finish"
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2e
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2e
            throw r9     // Catch: java.lang.Throwable -> L2e
        L6b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e
            r8.<init>()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r10 = "Didn't read enough bytes during decompression. expected="
            r8.append(r10)     // Catch: java.lang.Throwable -> L2e
            r8.append(r9)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r9 = " actual="
            r8.append(r9)     // Catch: java.lang.Throwable -> L2e
            r8.append(r4)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L2e
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2e
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2e
            throw r9     // Catch: java.lang.Throwable -> L2e
        L8a:
            r0.end()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.c.G1(java.io.FileInputStream, int, int):byte[]");
    }

    public static void H(int i4, int i5, int i6) {
        String p4;
        if (i4 >= 0 && i5 >= i4 && i5 <= i6) {
            return;
        }
        if (i4 >= 0 && i4 <= i6) {
            if (i5 >= 0 && i5 <= i6) {
                p4 = b1("end index (%s) must not be less than start index (%s)", Integer.valueOf(i5), Integer.valueOf(i4));
            } else {
                p4 = p(i5, i6, "end index");
            }
        } else {
            p4 = p(i4, i6, "start index");
        }
        throw new IndexOutOfBoundsException(p4);
    }

    public static String H0(Context context, ComponentName componentName) {
        int i4;
        String string;
        PackageManager packageManager = context.getPackageManager();
        if (Build.VERSION.SDK_INT >= 29) {
            i4 = 269222528;
        } else {
            i4 = 787072;
        }
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i4);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) == '.') {
            return context.getPackageName() + string;
        }
        return string;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
        if (r6 != 4) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        if (r4.getName().equals("locales") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
        r2 = r4.getAttributeValue(null, "application_locales");
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
        if (r3 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
        if (r3 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0055, code lost:
        if (r2.isEmpty() == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
        android.util.Log.d("AppLocalesStorageHelper", "Reading app Locales : Locales read from file: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file , appLocales: ".concat(r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0061, code lost:
        r9.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0064, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String H1(android.content.Context r9) {
        /*
            java.lang.String r0 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.lang.String r1 = "AppLocalesStorageHelper"
            java.lang.String r2 = ""
            java.io.FileInputStream r3 = r9.openFileInput(r0)     // Catch: java.io.FileNotFoundException -> L6b
            org.xmlpull.v1.XmlPullParser r4 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
            java.lang.String r5 = "UTF-8"
            r4.setInput(r3, r5)     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
            int r5 = r4.getDepth()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
        L17:
            int r6 = r4.next()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
            r7 = 1
            if (r6 == r7) goto L43
            r7 = 3
            if (r6 != r7) goto L2a
            int r8 = r4.getDepth()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
            if (r8 <= r5) goto L43
            goto L2a
        L28:
            r9 = move-exception
            goto L65
        L2a:
            if (r6 == r7) goto L17
            r7 = 4
            if (r6 != r7) goto L30
            goto L17
        L30:
            java.lang.String r6 = r4.getName()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
            java.lang.String r7 = "locales"
            boolean r6 = r6.equals(r7)     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
            if (r6 == 0) goto L17
            java.lang.String r5 = "application_locales"
            r6 = 0
            java.lang.String r2 = r4.getAttributeValue(r6, r5)     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
        L43:
            if (r3 == 0) goto L51
        L45:
            r3.close()     // Catch: java.io.IOException -> L51
            goto L51
        L49:
            java.lang.String r4 = "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r1, r4)     // Catch: java.lang.Throwable -> L28
            if (r3 == 0) goto L51
            goto L45
        L51:
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L61
            java.lang.String r9 = "Reading app Locales : Locales read from file: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file , appLocales: "
            java.lang.String r9 = r9.concat(r2)
            android.util.Log.d(r1, r9)
            goto L64
        L61:
            r9.deleteFile(r0)
        L64:
            return r2
        L65:
            if (r3 == 0) goto L6a
            r3.close()     // Catch: java.io.IOException -> L6a
        L6a:
            throw r9
        L6b:
            java.lang.String r9 = "Reading app Locales : Locales record file not found: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r1, r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.c.H1(android.content.Context):java.lang.String");
    }

    public static void I(int i4) {
        i3.a aVar = new i3.a(2, 36, 1);
        if (2 <= i4 && i4 <= aVar.f5065b) {
            return;
        }
        throw new IllegalArgumentException("radix " + i4 + " was not in valid range " + new i3.a(2, 36, 1));
    }

    public static long I1(InputStream inputStream, int i4) {
        byte[] F1 = F1(inputStream, i4);
        long j4 = 0;
        for (int i5 = 0; i5 < i4; i5++) {
            j4 += (F1[i5] & 255) << (i5 * 8);
        }
        return j4;
    }

    public static int J(Context context, String str) {
        int c4;
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, myPid, myUid) == -1) {
            return -1;
        }
        String d4 = h.d(str);
        if (d4 != null) {
            if (packageName == null) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(myUid);
                if (packagesForUid == null || packagesForUid.length <= 0) {
                    return -1;
                }
                packageName = packagesForUid[0];
            }
            int myUid2 = Process.myUid();
            String packageName2 = context.getPackageName();
            if (myUid2 == myUid && h0.b.a(packageName2, packageName)) {
                if (Build.VERSION.SDK_INT >= 29) {
                    AppOpsManager c5 = i.c(context);
                    c4 = i.a(c5, d4, Binder.getCallingUid(), packageName);
                    if (c4 == 0) {
                        c4 = i.a(c5, d4, myUid, i.b(context));
                    }
                } else {
                    c4 = h.c((AppOpsManager) h.a(context, AppOpsManager.class), d4, packageName);
                }
            } else {
                c4 = h.c((AppOpsManager) h.a(context, AppOpsManager.class), d4, packageName);
            }
            if (c4 != 0) {
                return -2;
            }
        }
        return 0;
    }

    public static void J1(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() != null && colorStateList != null && colorStateList.isStateful()) {
            int[] drawableState = textInputLayout.getDrawableState();
            int[] drawableState2 = checkableImageButton.getDrawableState();
            int length = drawableState.length;
            int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
            System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
            int colorForState = colorStateList.getColorForState(copyOf, colorStateList.getDefaultColor());
            Drawable mutate = drawable.mutate();
            c0.b.h(mutate, ColorStateList.valueOf(colorForState));
            checkableImageButton.setImageDrawable(mutate);
        }
    }

    public static float K(float f4, float f5, float f6) {
        if (f4 < f5) {
            return f5;
        }
        if (f4 > f6) {
            return f6;
        }
        return f4;
    }

    public static int K1(Context context, int i4, int i5) {
        TypedValue a5 = i2.c.a(context, i4);
        if (a5 != null && a5.type == 16) {
            return a5.data;
        }
        return i5;
    }

    public static int L(int i4, int i5, int i6) {
        if (i4 < i5) {
            return i5;
        }
        if (i4 > i6) {
            return i6;
        }
        return i4;
    }

    public static final int L0(int i4, int i5, int i6) {
        if (i6 > 0) {
            if (i4 < i5) {
                int i7 = i5 % i6;
                if (i7 < 0) {
                    i7 += i6;
                }
                int i8 = i4 % i6;
                if (i8 < 0) {
                    i8 += i6;
                }
                int i9 = (i7 - i8) % i6;
                if (i9 < 0) {
                    i9 += i6;
                }
                return i5 - i9;
            }
            return i5;
        } else if (i6 < 0) {
            if (i4 > i5) {
                int i10 = -i6;
                int i11 = i4 % i10;
                if (i11 < 0) {
                    i11 += i10;
                }
                int i12 = i5 % i10;
                if (i12 < 0) {
                    i12 += i10;
                }
                int i13 = (i11 - i12) % i10;
                if (i13 < 0) {
                    i13 += i10;
                }
                return i5 + i13;
            }
            return i5;
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    public static TimeInterpolator L1(Context context, int i4, Interpolator interpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i4, typedValue, true)) {
            return interpolator;
        }
        if (typedValue.type == 3) {
            String valueOf = String.valueOf(typedValue.string);
            if (!a1(valueOf, "cubic-bezier") && !a1(valueOf, "path")) {
                return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
            }
            if (a1(valueOf, "cubic-bezier")) {
                String[] split = valueOf.substring(13, valueOf.length() - 1).split(",");
                if (split.length == 4) {
                    return k0.a.b(y0(split, 0), y0(split, 1), y0(split, 2), y0(split, 3));
                }
                throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + split.length);
            } else if (a1(valueOf, "path")) {
                return k0.a.c(e0(valueOf.substring(5, valueOf.length() - 1)));
            } else {
                throw new IllegalArgumentException("Invalid motion easing type: ".concat(valueOf));
            }
        }
        throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
    }

    public static void M1(String str, RuntimeException runtimeException) {
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        int length = stackTrace.length;
        int i4 = -1;
        for (int i5 = 0; i5 < length; i5++) {
            if (str.equals(stackTrace[i5].getClassName())) {
                i4 = i5;
            }
        }
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i4 + 1, length));
    }

    public static final int N1(SegmentedByteString segmentedByteString, int i4) {
        int i5;
        F(segmentedByteString, "<this>");
        int i6 = i4 + 1;
        int length = segmentedByteString.f6053e.length;
        int[] iArr = segmentedByteString.f6054f;
        F(iArr, "<this>");
        int i7 = length - 1;
        int i8 = 0;
        while (true) {
            if (i8 <= i7) {
                i5 = (i8 + i7) >>> 1;
                int i9 = iArr[i5];
                if (i9 < i6) {
                    i8 = i5 + 1;
                } else if (i9 <= i6) {
                    break;
                } else {
                    i7 = i5 - 1;
                }
            } else {
                i5 = (-i8) - 1;
                break;
            }
        }
        if (i5 < 0) {
            return ~i5;
        }
        return i5;
    }

    public static void O1(View view, float f4) {
        Drawable background = view.getBackground();
        if (background instanceof l2.j) {
            ((l2.j) background).n(f4);
        }
    }

    public static final void P(y3.h hVar, Throwable th) {
        if (hVar != null) {
            if (th == null) {
                hVar.close();
                return;
            }
            try {
                hVar.close();
            } catch (Throwable th2) {
                kotlin.a.a(th, th2);
            }
        }
    }

    public static void P1(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean z4;
        WeakHashMap weakHashMap = y0.f4999a;
        boolean a5 = f0.a(checkableImageButton);
        boolean z5 = false;
        int i4 = 1;
        if (onLongClickListener != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (a5 || z4) {
            z5 = true;
        }
        checkableImageButton.setFocusable(z5);
        checkableImageButton.setClickable(a5);
        checkableImageButton.setPressable(a5);
        checkableImageButton.setLongClickable(z4);
        if (!z5) {
            i4 = 2;
        }
        i0.g0.s(checkableImageButton, i4);
    }

    public static int Q(int i4, int i5) {
        if (i4 < i5) {
            return -1;
        }
        return i4 == i5 ? 0 : 1;
    }

    public static void Q1(View view) {
        Drawable background = view.getBackground();
        if (background instanceof l2.j) {
            R1(view, (l2.j) background);
        }
    }

    public static byte[] R(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            deflaterOutputStream.write(bArr);
            deflaterOutputStream.close();
            deflater.end();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
    }

    public static void R1(View view, l2.j jVar) {
        b2.a aVar = jVar.f5310a.f5289b;
        if (aVar != null && aVar.f2517a) {
            float f4 = 0.0f;
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                WeakHashMap weakHashMap = y0.f4999a;
                f4 += m0.i((View) parent);
            }
            l2.i iVar = jVar.f5310a;
            if (iVar.f5300m != f4) {
                iVar.f5300m = f4;
                jVar.x();
            }
        }
    }

    public static int S(i1 i1Var, d0 d0Var, View view, View view2, u0 u0Var, boolean z4) {
        if (u0Var.v() != 0 && i1Var.b() != 0 && view != null && view2 != null) {
            if (!z4) {
                return Math.abs(u0.F(view) - u0.F(view2)) + 1;
            }
            return Math.min(d0Var.l(), d0Var.b(view2) - d0Var.e(view));
        }
        return 0;
    }

    public static void S1(Drawable drawable, int i4) {
        c0.b.g(drawable, i4);
    }

    public static int T(i1 i1Var, d0 d0Var, View view, View view2, u0 u0Var, boolean z4, boolean z5) {
        int max;
        if (u0Var.v() == 0 || i1Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(u0.F(view), u0.F(view2));
        int max2 = Math.max(u0.F(view), u0.F(view2));
        if (z5) {
            max = Math.max(0, (i1Var.b() - max2) - 1);
        } else {
            max = Math.max(0, min);
        }
        if (!z4) {
            return max;
        }
        return Math.round((max * (Math.abs(d0Var.b(view2) - d0Var.e(view)) / (Math.abs(u0.F(view) - u0.F(view2)) + 1))) + (d0Var.k() - d0Var.e(view)));
    }

    public static String T0(long j4, Locale locale) {
        return g0.b("yMMMd", locale).format(new Date(j4));
    }

    public static void T1(Drawable drawable, ColorStateList colorStateList) {
        c0.b.h(drawable, colorStateList);
    }

    public static int U(i1 i1Var, d0 d0Var, View view, View view2, u0 u0Var, boolean z4) {
        if (u0Var.v() != 0 && i1Var.b() != 0 && view != null && view2 != null) {
            if (!z4) {
                return i1Var.b();
            }
            return (int) (((d0Var.b(view2) - d0Var.e(view)) / (Math.abs(u0.F(view) - u0.F(view2)) + 1)) * i1Var.b());
        }
        return 0;
    }

    public static int U0(long j4) {
        return (int) (j4 ^ (j4 >>> 32));
    }

    public static void U1(Drawable drawable, PorterDuff.Mode mode) {
        c0.b.i(drawable, mode);
    }

    public static ImageView.ScaleType V(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 5) {
                            if (i4 != 6) {
                                return ImageView.ScaleType.CENTER;
                            }
                            return ImageView.ScaleType.CENTER_INSIDE;
                        }
                        return ImageView.ScaleType.CENTER_CROP;
                    }
                    return ImageView.ScaleType.FIT_END;
                }
                return ImageView.ScaleType.FIT_CENTER;
            }
            return ImageView.ScaleType.FIT_START;
        }
        return ImageView.ScaleType.FIT_XY;
    }

    public static final boolean V0(AssertionError assertionError) {
        String message;
        Logger logger = l.f7191a;
        if (assertionError.getCause() != null && (message = assertionError.getMessage()) != null && kotlin.text.b.q2(message, "getsockname failed")) {
            return true;
        }
        return false;
    }

    public static void V1(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            y3.a(view, charSequence);
            return;
        }
        a4 a4Var = a4.f695k;
        if (a4Var != null && a4Var.f697a == view) {
            a4.b(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            a4 a4Var2 = a4.f696l;
            if (a4Var2 != null && a4Var2.f697a == view) {
                a4Var2.a();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new a4(view, charSequence);
    }

    public static float[] W(float[] fArr, int i4) {
        if (i4 >= 0) {
            int length = fArr.length;
            if (length >= 0) {
                int min = Math.min(i4, length);
                float[] fArr2 = new float[i4];
                System.arraycopy(fArr, 0, fArr2, 0, min);
                return fArr2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }

    public static boolean W0(int i4, Rect rect, Rect rect2) {
        if (i4 != 17) {
            if (i4 != 33) {
                if (i4 != 66) {
                    if (i4 == 130) {
                        int i5 = rect.top;
                        int i6 = rect2.top;
                        if ((i5 >= i6 && rect.bottom > i6) || rect.bottom >= rect2.bottom) {
                            return false;
                        }
                        return true;
                    }
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                int i7 = rect.left;
                int i8 = rect2.left;
                if ((i7 >= i8 && rect.right > i8) || rect.right >= rect2.right) {
                    return false;
                }
                return true;
            }
            int i9 = rect.bottom;
            int i10 = rect2.bottom;
            if ((i9 <= i10 && rect.top < i10) || rect.top <= rect2.top) {
                return false;
            }
            return true;
        }
        int i11 = rect.right;
        int i12 = rect2.right;
        if ((i11 <= i12 && rect.left < i12) || rect.left <= rect2.left) {
            return false;
        }
        return true;
    }

    public static final y3.c W1(Socket socket) {
        Logger logger = l.f7191a;
        s sVar = new s(socket);
        OutputStream outputStream = socket.getOutputStream();
        E(outputStream, "getOutputStream(...)");
        return new y3.c(sVar, new y3.c(outputStream, sVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.emoji2.text.d] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.emoji2.text.a0, androidx.emoji2.text.j] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static androidx.emoji2.text.a0 X(android.content.Context r8) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto Lc
            androidx.emoji2.text.f r0 = new androidx.emoji2.text.f
            r0.<init>()
            goto L11
        Lc:
            androidx.emoji2.text.e r0 = new androidx.emoji2.text.e
            r0.<init>()
        L11:
            android.content.pm.PackageManager r1 = r8.getPackageManager()
            java.lang.String r2 = "Package manager required to locate emoji font provider"
            h0.e.c(r1, r2)
            android.content.Intent r2 = new android.content.Intent
            java.lang.String r3 = "androidx.content.action.LOAD_EMOJI_FONT"
            r2.<init>(r3)
            r3 = 0
            java.util.List r2 = r1.queryIntentContentProviders(r2, r3)
            java.util.Iterator r2 = r2.iterator()
        L2a:
            boolean r4 = r2.hasNext()
            r5 = 0
            if (r4 == 0) goto L46
            java.lang.Object r4 = r2.next()
            android.content.pm.ResolveInfo r4 = (android.content.pm.ResolveInfo) r4
            android.content.pm.ProviderInfo r4 = r4.providerInfo
            if (r4 == 0) goto L2a
            android.content.pm.ApplicationInfo r6 = r4.applicationInfo
            if (r6 == 0) goto L2a
            int r6 = r6.flags
            r7 = 1
            r6 = r6 & r7
            if (r6 != r7) goto L2a
            goto L47
        L46:
            r4 = r5
        L47:
            if (r4 != 0) goto L4b
        L49:
            r1 = r5
            goto L7a
        L4b:
            java.lang.String r2 = r4.authority     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L73
            java.lang.String r4 = r4.packageName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L73
            android.content.pm.Signature[] r0 = r0.a(r1, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L73
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L73
            r1.<init>()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L73
            int r6 = r0.length     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L73
        L59:
            if (r3 >= r6) goto L67
            r7 = r0[r3]     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L73
            byte[] r7 = r7.toByteArray()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L73
            r1.add(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L73
            int r3 = r3 + 1
            goto L59
        L67:
            java.util.List r0 = java.util.Collections.singletonList(r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L73
            f0.e r1 = new f0.e     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L73
            java.lang.String r3 = "emojicompat-emoji-font"
            r1.<init>(r2, r4, r3, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L73
            goto L7a
        L73:
            r0 = move-exception
            java.lang.String r1 = "emoji2.text.DefaultEmojiConfig"
            android.util.Log.wtf(r1, r0)
            goto L49
        L7a:
            if (r1 != 0) goto L7d
            goto L87
        L7d:
            androidx.emoji2.text.a0 r5 = new androidx.emoji2.text.a0
            androidx.emoji2.text.z r0 = new androidx.emoji2.text.z
            r0.<init>(r8, r1)
            r5.<init>(r0)
        L87:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.c.X(android.content.Context):androidx.emoji2.text.a0");
    }

    public static boolean X0(EditText editText) {
        if (editText.getInputType() != 0) {
            return true;
        }
        return false;
    }

    public static final y3.d X1(Socket socket) {
        Logger logger = l.f7191a;
        s sVar = new s(socket);
        InputStream inputStream = socket.getInputStream();
        E(inputStream, "getInputStream(...)");
        return new y3.d(sVar, new y3.d(inputStream, sVar));
    }

    public static ObjectAnimator Y(View view, c1.m0 m0Var, int i4, int i5, float f4, float f5, float f6, float f7, BaseInterpolator baseInterpolator, Transition transition) {
        float f8;
        float f9;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) m0Var.f2647b.getTag(R.id.transition_position);
        if (iArr != null) {
            f8 = (iArr[0] - i4) + translationX;
            f9 = (iArr[1] - i5) + translationY;
        } else {
            f8 = f4;
            f9 = f5;
        }
        int round = Math.round(f8 - translationX) + i4;
        int round2 = Math.round(f9 - translationY) + i5;
        view.setTranslationX(f8);
        view.setTranslationY(f9);
        if (f8 == f6 && f9 == f7) {
            return null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, f8, f6), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, f9, f7));
        n0 n0Var = new n0(view, m0Var.f2647b, round, round2, translationX, translationY);
        transition.a(n0Var);
        ofPropertyValuesHolder.addListener(n0Var);
        ofPropertyValuesHolder.addPauseListener(n0Var);
        ofPropertyValuesHolder.setInterpolator(baseInterpolator);
        return ofPropertyValuesHolder;
    }

    public static boolean Y0() {
        boolean isEnabled;
        try {
            if (f4197j == null) {
                isEnabled = Trace.isEnabled();
                return isEnabled;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        try {
            if (f4197j == null) {
                f4196i = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f4197j = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f4197j.invoke(null, Long.valueOf(f4196i))).booleanValue();
        } catch (Exception e4) {
            if (e4 instanceof InvocationTargetException) {
                Throwable cause = e4.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw new RuntimeException(cause);
            }
            Log.v("Trace", "Unable to call isTagEnabled via reflection", e4);
            return false;
        }
    }

    public static i3.a Y1(i3.c cVar, int i4) {
        boolean z4;
        F(cVar, "<this>");
        if (i4 > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Integer valueOf = Integer.valueOf(i4);
        if (z4) {
            if (cVar.f5066c <= 0) {
                i4 = -i4;
            }
            return new i3.a(cVar.f5064a, cVar.f5065b, i4);
        }
        throw new IllegalArgumentException("Step must be positive, was: " + valueOf + '.');
    }

    public static AnimatorSet Z(g gVar, float f4, float f5, float f6) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(gVar, x1.d.f7137a, x1.c.f7135b, new f(f4, f5, f6));
        f revealInfo = gVar.getRevealInfo();
        if (revealInfo != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) gVar, (int) f4, (int) f5, revealInfo.f7141c, f6);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofObject, createCircularReveal);
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    public static boolean Z0(MotionEvent motionEvent, int i4) {
        if ((motionEvent.getSource() & i4) == i4) {
            return true;
        }
        return false;
    }

    public static void Z1(String str) {
        RuntimeException runtimeException = new RuntimeException(j.d("lateinit property ", str, " has not been initialized"));
        M1(c.class.getName(), runtimeException);
        throw runtimeException;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, com.google.common.collect.c] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, com.google.common.collect.c] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, com.google.common.collect.c] */
    public static c a0(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                return new Object();
            }
            return new Object();
        }
        return new Object();
    }

    public static boolean a1(String str, String str2) {
        if (str.startsWith(str2.concat("(")) && str.endsWith(")")) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r8v8, types: [y3.f, java.lang.Object] */
    public static final String a2(String str) {
        InetAddress f02;
        F(str, "<this>");
        int i4 = 0;
        int i5 = -1;
        if (kotlin.text.b.q2(str, ":")) {
            if (l3.g.o2(str, "[", false) && str.endsWith("]")) {
                f02 = f0(1, str.length() - 1, str);
            } else {
                f02 = f0(0, str.length(), str);
            }
            if (f02 == null) {
                return null;
            }
            byte[] address = f02.getAddress();
            if (address.length == 16) {
                int i6 = 0;
                int i7 = 0;
                while (i6 < address.length) {
                    int i8 = i6;
                    while (i8 < 16 && address[i8] == 0 && address[i8 + 1] == 0) {
                        i8 += 2;
                    }
                    int i9 = i8 - i6;
                    if (i9 > i7 && i9 >= 4) {
                        i5 = i6;
                        i7 = i9;
                    }
                    i6 = i8 + 2;
                }
                ?? obj = new Object();
                while (i4 < address.length) {
                    if (i4 == i5) {
                        obj.H(58);
                        i4 += i7;
                        if (i4 == 16) {
                            obj.H(58);
                        }
                    } else {
                        if (i4 > 0) {
                            obj.H(58);
                        }
                        byte b5 = address[i4];
                        byte[] bArr = n3.b.f5783a;
                        obj.I(((b5 & 255) << 8) | (address[i4 + 1] & 255));
                        i4 += 2;
                    }
                }
                return obj.B(obj.f7180b, l3.a.f5399a);
            } else if (address.length == 4) {
                return f02.getHostAddress();
            } else {
                throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
            }
        }
        try {
            String ascii = IDN.toASCII(str);
            E(ascii, "toASCII(host)");
            Locale locale = Locale.US;
            E(locale, "US");
            String lowerCase = ascii.toLowerCase(locale);
            E(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (lowerCase.length() == 0) {
                return null;
            }
            int length = lowerCase.length();
            for (int i10 = 0; i10 < length; i10++) {
                char charAt = lowerCase.charAt(i10);
                if (Q(charAt, 31) <= 0 || Q(charAt, 127) >= 0 || kotlin.text.b.t2(" #%/:?@[\\]", charAt, 0, false, 6) != -1) {
                    return null;
                }
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static l2.f b0() {
        return new l2.f(0, 0);
    }

    public static String b1(String str, Object... objArr) {
        int indexOf;
        String str2;
        String sb;
        int i4 = 0;
        for (int i5 = 0; i5 < objArr.length; i5++) {
            Object obj = objArr[i5];
            if (obj == null) {
                sb = "null";
            } else {
                try {
                    sb = obj.toString();
                } catch (Exception e4) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb2 = new StringBuilder(String.valueOf(hexString).length() + name.length() + 1);
                    sb2.append(name);
                    sb2.append('@');
                    sb2.append(hexString);
                    String sb3 = sb2.toString();
                    Logger logger = Logger.getLogger("com.google.common.base.Strings");
                    Level level = Level.WARNING;
                    String valueOf = String.valueOf(sb3);
                    if (valueOf.length() != 0) {
                        str2 = "Exception during lenientFormat for ".concat(valueOf);
                    } else {
                        str2 = new String("Exception during lenientFormat for ");
                    }
                    logger.log(level, str2, (Throwable) e4);
                    String name2 = e4.getClass().getName();
                    StringBuilder sb4 = new StringBuilder(name2.length() + String.valueOf(sb3).length() + 9);
                    sb4.append("<");
                    sb4.append(sb3);
                    sb4.append(" threw ");
                    sb4.append(name2);
                    sb4.append(">");
                    sb = sb4.toString();
                }
            }
            objArr[i5] = sb;
        }
        StringBuilder sb5 = new StringBuilder((objArr.length * 16) + str.length());
        int i6 = 0;
        while (i4 < objArr.length && (indexOf = str.indexOf("%s", i6)) != -1) {
            sb5.append((CharSequence) str, i6, indexOf);
            sb5.append(objArr[i4]);
            i6 = indexOf + 2;
            i4++;
        }
        sb5.append((CharSequence) str, i6, str.length());
        if (i4 < objArr.length) {
            sb5.append(" [");
            sb5.append(objArr[i4]);
            for (int i7 = i4 + 1; i7 < objArr.length; i7++) {
                sb5.append(", ");
                sb5.append(objArr[i7]);
            }
            sb5.append(']');
        }
        return sb5.toString();
    }

    public static final Map b2(LinkedHashMap linkedHashMap) {
        Map.Entry entry = (Map.Entry) linkedHashMap.entrySet().iterator().next();
        Map singletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        E(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }

    public static List c1(Object obj) {
        List singletonList = Collections.singletonList(obj);
        E(singletonList, "singletonList(element)");
        return singletonList;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009b A[Catch: NumberFormatException -> 0x00af, LOOP:3: B:29:0x006d->B:48:0x009b, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00af, blocks: (B:26:0x0059, B:29:0x006d, B:31:0x0073, B:35:0x007f, B:48:0x009b, B:50:0x00a1, B:56:0x00b6, B:57:0x00b9), top: B:71:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a1 A[Catch: NumberFormatException -> 0x00af, TryCatch #0 {NumberFormatException -> 0x00af, blocks: (B:26:0x0059, B:29:0x006d, B:31:0x0073, B:35:0x007f, B:48:0x009b, B:50:0x00a1, B:56:0x00b6, B:57:0x00b9), top: B:71:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b6 A[Catch: NumberFormatException -> 0x00af, TryCatch #0 {NumberFormatException -> 0x00af, blocks: (B:26:0x0059, B:29:0x006d, B:31:0x0073, B:35:0x007f, B:48:0x009b, B:50:0x00a1, B:56:0x00b6, B:57:0x00b9), top: B:71:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x009a A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, b0.f] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, b0.f] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static b0.f[] d0(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.c.d0(java.lang.String):b0.f[]");
    }

    public static z d1(Context context, t tVar, boolean z4, boolean z5) {
        int i4;
        int i5;
        int i6;
        androidx.fragment.app.r rVar = tVar.H;
        if (rVar == null) {
            i4 = 0;
        } else {
            i4 = rVar.f1785h;
        }
        if (z5) {
            if (z4) {
                if (rVar != null) {
                    i5 = rVar.f1783f;
                }
                i5 = 0;
            } else {
                if (rVar != null) {
                    i5 = rVar.f1784g;
                }
                i5 = 0;
            }
        } else if (z4) {
            if (rVar != null) {
                i5 = rVar.f1781d;
            }
            i5 = 0;
        } else {
            if (rVar != null) {
                i5 = rVar.f1782e;
            }
            i5 = 0;
        }
        tVar.F(0, 0, 0, 0);
        ViewGroup viewGroup = tVar.D;
        if (viewGroup != null && viewGroup.getTag(R.id.visible_removing_fragment_view_tag) != null) {
            tVar.D.setTag(R.id.visible_removing_fragment_view_tag, null);
        }
        ViewGroup viewGroup2 = tVar.D;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        if (i5 == 0 && i4 != 0) {
            if (i4 != 4097) {
                if (i4 != 4099) {
                    if (i4 != 8194) {
                        i6 = -1;
                    } else if (z4) {
                        i6 = R.animator.fragment_close_enter;
                    } else {
                        i6 = R.animator.fragment_close_exit;
                    }
                } else if (z4) {
                    i6 = R.animator.fragment_fade_enter;
                } else {
                    i6 = R.animator.fragment_fade_exit;
                }
            } else if (z4) {
                i6 = R.animator.fragment_open_enter;
            } else {
                i6 = R.animator.fragment_open_exit;
            }
            i5 = i6;
        }
        if (i5 != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(i5));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, i5);
                    if (loadAnimation != null) {
                        return new z(loadAnimation);
                    }
                } catch (Resources.NotFoundException e4) {
                    throw e4;
                } catch (RuntimeException unused) {
                }
            }
            try {
                Animator loadAnimator = AnimatorInflater.loadAnimator(context, i5);
                if (loadAnimator != null) {
                    return new z(loadAnimator);
                }
            } catch (RuntimeException e5) {
                if (!equals) {
                    Animation loadAnimation2 = AnimationUtils.loadAnimation(context, i5);
                    if (loadAnimation2 != null) {
                        return new z(loadAnimation2);
                    }
                } else {
                    throw e5;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [i3.a, i3.c] */
    public static i3.c d2(int i4, int i5) {
        if (i5 <= Integer.MIN_VALUE) {
            i3.c cVar = i3.c.f5071d;
            return i3.c.f5071d;
        }
        return new i3.a(i4, i5 - 1, 1);
    }

    public static Path e0(String str) {
        Path path = new Path();
        b0.f[] d02 = d0(str);
        if (d02 != null) {
            try {
                b0.f.b(d02, path);
                return path;
            } catch (RuntimeException e4) {
                throw new RuntimeException("Error in parsing " + str, e4);
            }
        }
        return null;
    }

    public static int e1(int i4, Rect rect, Rect rect2) {
        int i5;
        int i6;
        if (i4 != 17) {
            if (i4 != 33) {
                if (i4 != 66) {
                    if (i4 == 130) {
                        i5 = rect2.top;
                        i6 = rect.bottom;
                    } else {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                } else {
                    i5 = rect2.left;
                    i6 = rect.right;
                }
            } else {
                i5 = rect.top;
                i6 = rect2.bottom;
            }
        } else {
            i5 = rect.left;
            i6 = rect2.right;
        }
        return Math.max(0, i5 - i6);
    }

    public static Drawable e2(Drawable drawable) {
        if (drawable instanceof e) {
            ((c0.f) ((e) drawable)).getClass();
            return null;
        }
        return drawable;
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d5, code lost:
        if (r7 == r0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00d7, code lost:
        if (r8 != (-1)) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00d9, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00da, code lost:
        r1 = r7 - r8;
        java.lang.System.arraycopy(r3, r8, r3, 16 - r1, r1);
        java.util.Arrays.fill(r3, r8, (16 - r7) + r8, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00ec, code lost:
        return java.net.InetAddress.getByAddress(r3);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.net.InetAddress f0(int r17, int r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.c.f0(int, int, java.lang.String):java.net.InetAddress");
    }

    public static int f1(int i4) {
        if (i4 < 0) {
            return i4;
        }
        if (i4 < 3) {
            return i4 + 1;
        }
        if (i4 < 1073741824) {
            return (int) ((i4 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static void f2(ByteArrayOutputStream byteArrayOutputStream, long j4, int i4) {
        byte[] bArr = new byte[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            bArr[i5] = (byte) ((j4 >> (i5 * 8)) & 255);
        }
        byteArrayOutputStream.write(bArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, b0.f] */
    public static b0.f[] g0(b0.f[] fVarArr) {
        if (fVarArr == null) {
            return null;
        }
        b0.f[] fVarArr2 = new b0.f[fVarArr.length];
        for (int i4 = 0; i4 < fVarArr.length; i4++) {
            b0.f fVar = fVarArr[i4];
            ?? obj = new Object();
            obj.f2495a = fVar.f2495a;
            float[] fArr = fVar.f2496b;
            obj.f2496b = W(fArr, fArr.length);
            fVarArr2[i4] = obj;
        }
        return fVarArr2;
    }

    public static int g1(int i4, Rect rect, Rect rect2) {
        int height;
        int i5;
        int height2;
        if (i4 != 17) {
            if (i4 != 33) {
                if (i4 != 66) {
                    if (i4 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            height = (rect.width() / 2) + rect.left;
            i5 = rect2.left;
            height2 = rect2.width();
            return Math.abs(height - ((height2 / 2) + i5));
        }
        height = (rect.height() / 2) + rect.top;
        i5 = rect2.top;
        height2 = rect2.height();
        return Math.abs(height - ((height2 / 2) + i5));
    }

    public static void g2(ByteArrayOutputStream byteArrayOutputStream, int i4) {
        f2(byteArrayOutputStream, i4, 2);
    }

    public static boolean h0(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return false;
            }
            boolean z4 = true;
            for (File file2 : listFiles) {
                if (h0(file2) && z4) {
                    z4 = true;
                } else {
                    z4 = false;
                }
            }
            return z4;
        }
        file.delete();
        return true;
    }

    public static void h1(View view, EditorInfo editorInfo, InputConnection inputConnection) {
        if (inputConnection != null && editorInfo.hintText == null) {
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            }
        }
    }

    public static float i0(float f4, float f5, float f6, float f7) {
        return (float) Math.hypot(f6 - f4, f7 - f5);
    }

    public static final void j(p3.a aVar, p3.c cVar, String str) {
        p3.f.f6159h.getClass();
        Logger logger = p3.f.f6161j;
        logger.fine(cVar.f6152b + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1)) + ": " + aVar.f6145a);
    }

    public static float j0(float f4, float f5, float f6, float f7) {
        float i02 = i0(f4, f5, 0.0f, 0.0f);
        float i03 = i0(f4, f5, f6, 0.0f);
        float i04 = i0(f4, f5, f6, f7);
        float i05 = i0(f4, f5, 0.0f, f7);
        if (i02 <= i03 || i02 <= i04 || i02 <= i05) {
            if (i03 > i04 && i03 > i05) {
                return i03;
            }
            if (i04 > i05) {
                return i04;
            }
            return i05;
        }
        return i02;
    }

    public static void k(StringBuilder sb, Object obj, e3.l lVar) {
        CharSequence valueOf;
        if (lVar != null) {
            obj = lVar.c(obj);
        } else if (obj != null && !(obj instanceof CharSequence)) {
            if (obj instanceof Character) {
                sb.append(((Character) obj).charValue());
                return;
            }
            valueOf = String.valueOf(obj);
            sb.append(valueOf);
        }
        valueOf = (CharSequence) obj;
        sb.append(valueOf);
    }

    public static void k0(Canvas canvas, boolean z4) {
        Method method;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 29) {
            if (z4) {
                canvas.enableZ();
            } else {
                canvas.disableZ();
            }
        } else if (i4 != 28) {
            if (!f4200m) {
                try {
                    Method declaredMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                    f4198k = declaredMethod;
                    declaredMethod.setAccessible(true);
                    Method declaredMethod2 = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
                    f4199l = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                f4200m = true;
            }
            if (z4) {
                try {
                    Method method2 = f4198k;
                    if (method2 != null) {
                        method2.invoke(canvas, new Object[0]);
                    }
                } catch (IllegalAccessException unused2) {
                    return;
                } catch (InvocationTargetException e4) {
                    throw new RuntimeException(e4.getCause());
                }
            }
            if (!z4 && (method = f4199l) != null) {
                method.invoke(canvas, new Object[0]);
            }
        } else {
            throw new IllegalStateException("This method doesn't work on Pie!");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:174:0x0274, code lost:
        if (r2.f6190b == r9) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x010f, code lost:
        if (r5.f6190b == r12) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0499 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0503  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x052a  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0559  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0579  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0589 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:347:0x059c  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x0666  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x0698 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:399:0x06aa A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:404:0x06be  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x06c1  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x06c7  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x06ca  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x06ce  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x06de  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x06e2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:427:0x06ff A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:431:0x0119 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:440:0x057b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void l(q.e r39, p.f r40, int r41) {
        /*
            Method dump skipped, instructions count: 1802
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.c.l(q.e, p.f, int):void");
    }

    public static final boolean l0(char c4, char c5, boolean z4) {
        if (c4 == c5) {
            return true;
        }
        if (!z4) {
            return false;
        }
        char upperCase = Character.toUpperCase(c4);
        char upperCase2 = Character.toUpperCase(c5);
        if (upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)) {
            return true;
        }
        return false;
    }

    public static void m(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = drawable.mutate();
            if (colorStateList != null && colorStateList.isStateful()) {
                int[] drawableState = textInputLayout.getDrawableState();
                int[] drawableState2 = checkableImageButton.getDrawableState();
                int length = drawableState.length;
                int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
                System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
                c0.b.h(drawable, ColorStateList.valueOf(colorStateList.getColorForState(copyOf, colorStateList.getDefaultColor())));
            } else {
                c0.b.h(drawable, colorStateList);
            }
            if (mode != null) {
                c0.b.i(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public static final String m0(long j4) {
        StringBuilder sb;
        long j5;
        long j6;
        long j7;
        if (j4 <= -999500000) {
            sb = new StringBuilder();
            j5 = j4 - 500000000;
        } else {
            if (j4 <= -999500) {
                sb = new StringBuilder();
                j6 = j4 - 500000;
            } else {
                if (j4 <= 0) {
                    sb = new StringBuilder();
                    j7 = j4 - 500;
                } else if (j4 < 999500) {
                    sb = new StringBuilder();
                    j7 = j4 + 500;
                } else if (j4 < 999500000) {
                    sb = new StringBuilder();
                    j6 = j4 + 500000;
                } else {
                    sb = new StringBuilder();
                    j5 = j4 + 500000000;
                }
                sb.append(j7 / 1000);
                sb.append(" µs");
                return String.format("%6s", Arrays.copyOf(new Object[]{sb.toString()}, 1));
            }
            sb.append(j6 / 1000000);
            sb.append(" ms");
            return String.format("%6s", Arrays.copyOf(new Object[]{sb.toString()}, 1));
        }
        sb.append(j5 / 1000000000);
        sb.append(" s ");
        return String.format("%6s", Arrays.copyOf(new Object[]{sb.toString()}, 1));
    }

    public static boolean n(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        return obj.equals(obj2);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [n.g, java.lang.Object, com.google.common.collect.c] */
    /* JADX WARN: Type inference failed for: r2v4, types: [n.c, java.lang.Object, com.google.common.collect.c] */
    /* JADX WARN: Type inference failed for: r2v5, types: [n.f, java.lang.Object, com.google.common.collect.c] */
    public static c n0(int i4, double[] dArr, double[][] dArr2) {
        int i5;
        if (dArr.length == 1) {
            i5 = 2;
        } else {
            i5 = i4;
        }
        double d4 = 0.0d;
        if (i5 != 0) {
            if (i5 != 2) {
                ?? obj = new Object();
                int length = dArr2[0].length;
                obj.f5674q = dArr;
                obj.f5675r = dArr2;
                if (length > 2) {
                    int i6 = 0;
                    while (true) {
                        double d5 = d4;
                        if (i6 >= dArr.length) {
                            break;
                        }
                        double d6 = dArr2[i6][0];
                        if (i6 > 0) {
                            Math.hypot(d6 - d4, d6 - d5);
                        }
                        i6++;
                        d4 = d6;
                    }
                }
                return obj;
            }
            double d7 = dArr[0];
            double[] dArr3 = dArr2[0];
            ?? obj2 = new Object();
            obj2.f5665q = d7;
            obj2.f5666r = dArr3;
            return obj2;
        }
        ?? obj3 = new Object();
        int length2 = dArr.length;
        int length3 = dArr2[0].length;
        int i7 = length2 - 1;
        Class cls = Double.TYPE;
        double[][] dArr4 = (double[][]) Array.newInstance(cls, i7, length3);
        double[][] dArr5 = (double[][]) Array.newInstance(cls, length2, length3);
        for (int i8 = 0; i8 < length3; i8++) {
            int i9 = 0;
            while (i9 < i7) {
                int i10 = i9 + 1;
                double d8 = dArr[i10] - dArr[i9];
                double[] dArr6 = dArr4[i9];
                double d9 = (dArr2[i10][i8] - dArr2[i9][i8]) / d8;
                dArr6[i8] = d9;
                if (i9 == 0) {
                    dArr5[i9][i8] = d9;
                } else {
                    dArr5[i9][i8] = (dArr4[i9 - 1][i8] + d9) * 0.5d;
                }
                i9 = i10;
            }
            dArr5[i7][i8] = dArr4[length2 - 2][i8];
        }
        int i11 = 0;
        while (i11 < i7) {
            int i12 = 0;
            while (i12 < length3) {
                double d10 = dArr4[i11][i12];
                if (d10 == d4) {
                    dArr5[i11][i12] = d4;
                    dArr5[i11 + 1][i12] = d4;
                } else {
                    double d11 = dArr5[i11][i12] / d10;
                    int i13 = i11 + 1;
                    double d12 = dArr5[i13][i12] / d10;
                    double hypot = Math.hypot(d11, d12);
                    if (hypot > 9.0d) {
                        double d13 = 3.0d / hypot;
                        double[] dArr7 = dArr5[i11];
                        double[] dArr8 = dArr4[i11];
                        dArr7[i12] = d11 * d13 * dArr8[i12];
                        dArr5[i13][i12] = d13 * d12 * dArr8[i12];
                    }
                }
                i12++;
                d4 = 0.0d;
            }
            i11++;
            d4 = 0.0d;
        }
        obj3.f5676q = dArr;
        obj3.f5677r = dArr2;
        obj3.f5678s = dArr5;
        return obj3;
    }

    public static final boolean o(int i4, int i5, int i6, byte[] bArr, byte[] bArr2) {
        F(bArr, "a");
        F(bArr2, "b");
        for (int i7 = 0; i7 < i6; i7++) {
            if (bArr[i7 + i4] != bArr2[i7 + i5]) {
                return false;
            }
        }
        return true;
    }

    public static Application o0() {
        Application application = f4201n;
        if (application != null) {
            return application;
        }
        if (application != null) {
            return application;
        }
        throw new NullPointerException("reflect failed.");
    }

    public static String p(int i4, int i5, String str) {
        if (i4 < 0) {
            return b1("%s (%s) must not be negative", str, Integer.valueOf(i4));
        }
        if (i5 >= 0) {
            return b1("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i4), Integer.valueOf(i5));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i5);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
        if (r10.bottom <= r12.top) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
        if (r10.right <= r12.left) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
        if (r10.top >= r12.bottom) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
        if (r10.left >= r12.right) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
        if (r9 == 17) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
        if (r9 != 66) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
        r11 = e1(r9, r10, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004c, code lost:
        if (r9 == 17) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004e, code lost:
        if (r9 == 33) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0050, code lost:
        if (r9 == 66) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0052, code lost:
        if (r9 != 130) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0054, code lost:
        r9 = r12.bottom;
        r10 = r10.bottom;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005f, code lost:
        throw new java.lang.IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0060, code lost:
        r9 = r12.right;
        r10 = r10.right;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0065, code lost:
        r9 = r10.top;
        r10 = r12.top;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006a, code lost:
        r9 = r10.left;
        r10 = r12.left;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0073, code lost:
        if (r11 >= java.lang.Math.max(1, r9 - r10)) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0076, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean q(int r9, android.graphics.Rect r10, android.graphics.Rect r11, android.graphics.Rect r12) {
        /*
            boolean r0 = r(r9, r10, r11)
            boolean r1 = r(r9, r10, r12)
            r2 = 0
            if (r1 != 0) goto L78
            if (r0 != 0) goto Lf
            goto L78
        Lf:
            java.lang.String r0 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1 = 130(0x82, float:1.82E-43)
            r3 = 33
            r4 = 66
            r5 = 17
            r6 = 1
            if (r9 == r5) goto L3d
            if (r9 == r3) goto L36
            if (r9 == r4) goto L2f
            if (r9 != r1) goto L29
            int r7 = r10.bottom
            int r8 = r12.top
            if (r7 > r8) goto L77
            goto L43
        L29:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r0)
            throw r9
        L2f:
            int r7 = r10.right
            int r8 = r12.left
            if (r7 > r8) goto L77
            goto L43
        L36:
            int r7 = r10.top
            int r8 = r12.bottom
            if (r7 < r8) goto L77
            goto L43
        L3d:
            int r7 = r10.left
            int r8 = r12.right
            if (r7 < r8) goto L77
        L43:
            if (r9 == r5) goto L77
            if (r9 != r4) goto L48
            goto L77
        L48:
            int r11 = e1(r9, r10, r11)
            if (r9 == r5) goto L6a
            if (r9 == r3) goto L65
            if (r9 == r4) goto L60
            if (r9 != r1) goto L5a
            int r9 = r12.bottom
            int r10 = r10.bottom
        L58:
            int r9 = r9 - r10
            goto L6f
        L5a:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r0)
            throw r9
        L60:
            int r9 = r12.right
            int r10 = r10.right
            goto L58
        L65:
            int r9 = r10.top
            int r10 = r12.top
            goto L58
        L6a:
            int r9 = r10.left
            int r10 = r12.left
            goto L58
        L6f:
            int r9 = java.lang.Math.max(r6, r9)
            if (r11 >= r9) goto L76
            r2 = r6
        L76:
            return r2
        L77:
            return r6
        L78:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.c.q(int, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):boolean");
    }

    public static h0.c q0(Long l4, Long l5) {
        h0.c cVar;
        h0.c cVar2;
        if (l4 == null && l5 == null) {
            return new h0.c(null, null);
        }
        if (l4 == null) {
            cVar2 = new h0.c(null, r0(l5.longValue()));
        } else if (l5 == null) {
            cVar2 = new h0.c(r0(l4.longValue()), null);
        } else {
            Calendar f4 = g0.f();
            Calendar g4 = g0.g(null);
            g4.setTimeInMillis(l4.longValue());
            Calendar g5 = g0.g(null);
            g5.setTimeInMillis(l5.longValue());
            if (g4.get(1) == g5.get(1)) {
                if (g4.get(1) == f4.get(1)) {
                    cVar = new h0.c(C0(l4.longValue(), Locale.getDefault()), C0(l5.longValue(), Locale.getDefault()));
                } else {
                    cVar = new h0.c(C0(l4.longValue(), Locale.getDefault()), T0(l5.longValue(), Locale.getDefault()));
                }
            } else {
                cVar = new h0.c(T0(l4.longValue(), Locale.getDefault()), T0(l5.longValue(), Locale.getDefault()));
            }
            return cVar;
        }
        return cVar2;
    }

    public static boolean r(int i4, Rect rect, Rect rect2) {
        if (i4 != 17) {
            if (i4 != 33) {
                if (i4 != 66) {
                    if (i4 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            if (rect2.right < rect.left || rect2.left > rect.right) {
                return false;
            }
            return true;
        }
        if (rect2.bottom < rect.top || rect2.top > rect.bottom) {
            return false;
        }
        return true;
    }

    public static String r0(long j4) {
        Calendar f4 = g0.f();
        Calendar g4 = g0.g(null);
        g4.setTimeInMillis(j4);
        if (f4.get(1) == g4.get(1)) {
            return C0(j4, Locale.getDefault());
        }
        return T0(j4, Locale.getDefault());
    }

    public static float r1(EdgeEffect edgeEffect, float f4, float f5) {
        if (Build.VERSION.SDK_INT >= 31) {
            return androidx.core.widget.f.c(edgeEffect, f4, f5);
        }
        androidx.core.widget.e.a(edgeEffect, f4, f5);
        return f4;
    }

    public static void s(int i4, int i5) {
        GLES20.glBindTexture(i4, i5);
        B();
        GLES20.glTexParameteri(i4, 10240, 9729);
        B();
        GLES20.glTexParameteri(i4, 10241, 9729);
        B();
        GLES20.glTexParameteri(i4, 10242, 33071);
        B();
        GLES20.glTexParameteri(i4, 10243, 33071);
        B();
    }

    public static float s0(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return androidx.core.widget.f.b(edgeEffect);
        }
        return 0.0f;
    }

    public static void t(float f4, float[] fArr) {
        if (f4 <= 0.5f) {
            fArr[0] = 1.0f - (f4 * 2.0f);
            fArr[1] = 0.0f;
            return;
        }
        fArr[0] = 0.0f;
        fArr[1] = (f4 * 2.0f) - 1.0f;
    }

    public static Drawable t0(Context context, int i4) {
        return m2.c().e(context, i4);
    }

    public static boolean u(b0.f[] fVarArr, b0.f[] fVarArr2) {
        if (fVarArr == null || fVarArr2 == null || fVarArr.length != fVarArr2.length) {
            return false;
        }
        for (int i4 = 0; i4 < fVarArr.length; i4++) {
            b0.f fVar = fVarArr[i4];
            char c4 = fVar.f2495a;
            b0.f fVar2 = fVarArr2[i4];
            if (c4 != fVar2.f2495a || fVar.f2496b.length != fVar2.f2496b.length) {
                return false;
            }
        }
        return true;
    }

    public static void u0(Application application) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return;
        }
        application.getPackageManager().getPackageInfo("com.android.vending", 0);
        w2.a aVar = new w2.a();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (application.bindService(intent, aVar, 1)) {
            try {
                if (!aVar.f7059a) {
                    aVar.f7059a = true;
                    IBinder iBinder = (IBinder) aVar.f7060b.take();
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    iBinder.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    application.unbindService(aVar);
                    return;
                }
                throw new IllegalStateException();
            } catch (Throwable th) {
                application.unbindService(aVar);
                throw th;
            }
        }
    }

    public static String v0() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) o0().getSystemService("phone");
            return (String) telephonyManager.getClass().getMethod("getImei", Integer.TYPE).invoke(telephonyManager, 0);
        } catch (Exception unused) {
            return "";
        }
    }

    public static final Class w0(j3.a aVar) {
        F(aVar, "<this>");
        Class a5 = ((f3.a) aVar).a();
        if (!a5.isPrimitive()) {
            return a5;
        }
        String name = a5.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    return Double.class;
                }
                return a5;
            case 104431:
                if (name.equals("int")) {
                    return Integer.class;
                }
                return a5;
            case 3039496:
                if (name.equals("byte")) {
                    return Byte.class;
                }
                return a5;
            case 3052374:
                if (name.equals("char")) {
                    return Character.class;
                }
                return a5;
            case 3327612:
                if (name.equals("long")) {
                    return Long.class;
                }
                return a5;
            case 3625364:
                if (name.equals("void")) {
                    return Void.class;
                }
                return a5;
            case 64711720:
                if (name.equals("boolean")) {
                    return Boolean.class;
                }
                return a5;
            case 97526364:
                if (name.equals("float")) {
                    return Float.class;
                }
                return a5;
            case 109413500:
                if (name.equals("short")) {
                    return Short.class;
                }
                return a5;
            default:
                return a5;
        }
    }

    public static int x0(List list) {
        F(list, "<this>");
        return list.size() - 1;
    }

    public static com.google.gson.b x1(u2.a aVar) {
        boolean z4;
        try {
            try {
                aVar.P();
                z4 = false;
            } catch (MalformedJsonException e4) {
                throw new RuntimeException(e4);
            } catch (IOException e5) {
                throw new RuntimeException(e5);
            } catch (NumberFormatException e6) {
                throw new RuntimeException(e6);
            }
        } catch (EOFException e7) {
            e = e7;
            z4 = true;
        }
        try {
            return (com.google.gson.b) t2.b.f6693a.i2(aVar);
        } catch (EOFException e8) {
            e = e8;
            if (z4) {
                return com.google.gson.c.f4210a;
            }
            throw new RuntimeException(e);
        }
    }

    public static float y0(String[] strArr, int i4) {
        float parseFloat = Float.parseFloat(strArr[i4]);
        if (parseFloat >= 0.0f && parseFloat <= 1.0f) {
            return parseFloat;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + parseFloat);
    }

    public static com.google.gson.b y1(u2.a aVar) {
        boolean z4 = aVar.f6883b;
        aVar.f6883b = true;
        try {
            try {
                try {
                    return x1(aVar);
                } catch (OutOfMemoryError e4) {
                    throw new RuntimeException("Failed parsing JSON source: " + aVar + " to Json", e4);
                }
            } catch (StackOverflowError e5) {
                throw new RuntimeException("Failed parsing JSON source: " + aVar + " to Json", e5);
            }
        } finally {
            aVar.f6883b = z4;
        }
    }

    public static void z(boolean z4) {
        if (z4) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static String z0() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }

    public abstract void D1(m.e eVar, m.e eVar2);

    public abstract void E1(m.e eVar, Thread thread);

    public abstract double I0(double d4);

    public abstract void J0(double d4, double[] dArr);

    public abstract void K0(double d4, float[] fArr);

    public abstract int M(View view, int i4);

    public abstract double M0(double d4);

    public abstract int N(View view, int i4);

    public abstract void N0(double d4, double[] dArr);

    public abstract List O(String str, List list);

    public abstract long O0(ViewGroup viewGroup, Transition transition, c1.m0 m0Var, c1.m0 m0Var2);

    public i0 P0(ComponentActivity componentActivity, Intent intent) {
        F(componentActivity, "context");
        return null;
    }

    public abstract double[] Q0();

    public int R0(View view) {
        return 0;
    }

    public int S0() {
        return 0;
    }

    public abstract Intent c0(ComponentActivity componentActivity, Intent intent);

    public abstract boolean c2(int i4, View view);

    @Override // c1.b0
    public float d(ViewGroup viewGroup, View view) {
        return view.getTranslationX();
    }

    @Override // c1.b0
    public float h(ViewGroup viewGroup, View view) {
        return view.getTranslationY();
    }

    public abstract void k1(Throwable th);

    public abstract View l1(int i4);

    public abstract v1.j m1(v1.b bVar, View view);

    public abstract Rect n1();

    public abstract boolean o1();

    public abstract void p0(float f4, float f5, l2.z zVar);

    public abstract void q1(androidx.emoji2.text.d0 d0Var);

    public abstract void u1(int i4);

    public abstract void v(c1.m0 m0Var);

    public abstract void v1(View view, int i4, int i5);

    public abstract boolean w(m.f fVar, m.c cVar);

    public abstract void w1(View view, float f4, float f5);

    public abstract boolean x(m.f fVar, Object obj, Object obj2);

    public abstract boolean y(m.f fVar, m.e eVar, m.e eVar2);

    public abstract Object z1(Intent intent, int i4);

    @Override // i0.h1
    public void g(View view) {
    }

    public void p1(FloatingActionButton floatingActionButton) {
    }

    public void i() {
    }

    public void j1() {
    }

    public void s1() {
    }

    public void i1(int i4, int i5) {
    }

    public void t1(int i4, View view) {
    }
}
package b0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class i extends n {

    /* renamed from: a  reason: collision with root package name */
    public static Class f2500a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Constructor f2501b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Method f2502c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Method f2503d = null;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f2504e = false;

    public static boolean g(int i4, Object obj, String str, boolean z4) {
        h();
        try {
            return ((Boolean) f2502c.invoke(obj, str, Integer.valueOf(i4), Boolean.valueOf(z4))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    public static void h() {
        Class<?> cls;
        Method method;
        Constructor<?> constructor;
        Method method2;
        if (f2504e) {
            return;
        }
        f2504e = true;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
        } catch (ClassNotFoundException | NoSuchMethodException e4) {
            Log.e("TypefaceCompatApi21Impl", e4.getClass().getName(), e4);
            cls = null;
            method = null;
            constructor = null;
            method2 = null;
        }
        f2501b = constructor;
        f2500a = cls;
        f2502c = method2;
        f2503d = method;
    }

    @Override // b0.n
    public Typeface a(Context context, a0.g gVar, Resources resources, int i4) {
        a0.h[] hVarArr;
        h();
        try {
            Object newInstance = f2501b.newInstance(new Object[0]);
            for (a0.h hVar : gVar.f16a) {
                File d4 = p.d(context);
                if (d4 == null) {
                    return null;
                }
                try {
                    if (!p.b(d4, resources, hVar.f22f)) {
                        return null;
                    }
                    if (!g(hVar.f18b, newInstance, d4.getPath(), hVar.f19c)) {
                        return null;
                    }
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    d4.delete();
                }
            }
            h();
            try {
                Object newInstance2 = Array.newInstance(f2500a, 1);
                Array.set(newInstance2, 0, newInstance);
                return (Typeface) f2503d.invoke(null, newInstance2);
            } catch (IllegalAccessException | InvocationTargetException e4) {
                throw new RuntimeException(e4);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    @Override // b0.n
    public Typeface b(Context context, f0.k[] kVarArr, int i4) {
        File file;
        String readlink;
        if (kVarArr.length < 1) {
            return null;
        }
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(f(i4, kVarArr).f4535a, "r", null);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                readlink = Os.readlink("/proc/self/fd/" + openFileDescriptor.getFd());
            } catch (ErrnoException unused) {
            }
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                file = new File(readlink);
                if (file != null && file.canRead()) {
                    Typeface createFromFile = Typeface.createFromFile(file);
                    openFileDescriptor.close();
                    return createFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                Typeface c4 = c(context, fileInputStream);
                fileInputStream.close();
                openFileDescriptor.close();
                return c4;
            }
            file = null;
            if (file != null) {
                Typeface createFromFile2 = Typeface.createFromFile(file);
                openFileDescriptor.close();
                return createFromFile2;
            }
            FileInputStream fileInputStream2 = new FileInputStream(openFileDescriptor.getFileDescriptor());
            Typeface c42 = c(context, fileInputStream2);
            fileInputStream2.close();
            openFileDescriptor.close();
            return c42;
        } catch (IOException unused2) {
            return null;
        }
    }
}
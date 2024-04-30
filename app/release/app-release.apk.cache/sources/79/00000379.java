package b0;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class k extends i {

    /* renamed from: f  reason: collision with root package name */
    public final Class f2509f;

    /* renamed from: g  reason: collision with root package name */
    public final Constructor f2510g;

    /* renamed from: h  reason: collision with root package name */
    public final Method f2511h;

    /* renamed from: i  reason: collision with root package name */
    public final Method f2512i;

    /* renamed from: j  reason: collision with root package name */
    public final Method f2513j;

    /* renamed from: k  reason: collision with root package name */
    public final Method f2514k;

    /* renamed from: l  reason: collision with root package name */
    public final Method f2515l;

    public k() {
        Class<?> cls;
        Method method;
        Constructor<?> constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            method2 = o(cls);
            Class cls2 = Integer.TYPE;
            method3 = cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
            method4 = cls.getMethod("freeze", new Class[0]);
            method = cls.getMethod("abortCreation", new Class[0]);
            method5 = p(cls);
        } catch (ClassNotFoundException | NoSuchMethodException e4) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e4.getClass().getName()), e4);
            cls = null;
            method = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.f2509f = cls;
        this.f2510g = constructor;
        this.f2511h = method2;
        this.f2512i = method3;
        this.f2513j = method4;
        this.f2514k = method;
        this.f2515l = method5;
    }

    public static Method o(Class cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    @Override // b0.i, b0.n
    public final Typeface a(Context context, a0.g gVar, Resources resources, int i4) {
        a0.h[] hVarArr;
        if (!m()) {
            return super.a(context, gVar, resources, i4);
        }
        Object n4 = n();
        if (n4 == null) {
            return null;
        }
        for (a0.h hVar : gVar.f16a) {
            if (!j(context, n4, hVar.f17a, hVar.f21e, hVar.f18b, hVar.f19c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(hVar.f20d))) {
                i(n4);
                return null;
            }
        }
        if (!l(n4)) {
            return null;
        }
        return k(n4);
    }

    @Override // b0.i, b0.n
    public final Typeface b(Context context, f0.k[] kVarArr, int i4) {
        Typeface k4;
        if (kVarArr.length < 1) {
            return null;
        }
        if (!m()) {
            f0.k f4 = f(i4, kVarArr);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(f4.f4535a, "r", null);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(f4.f4537c).setItalic(f4.f4538d).build();
                openFileDescriptor.close();
                return build;
            } catch (IOException unused) {
                return null;
            }
        }
        HashMap hashMap = new HashMap();
        for (f0.k kVar : kVarArr) {
            if (kVar.f4539e == 0) {
                Uri uri = kVar.f4535a;
                if (!hashMap.containsKey(uri)) {
                    hashMap.put(uri, p.e(context, uri));
                }
            }
        }
        Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
        Object n4 = n();
        if (n4 == null) {
            return null;
        }
        int length = kVarArr.length;
        int i5 = 0;
        boolean z4 = false;
        while (i5 < length) {
            f0.k kVar2 = kVarArr[i5];
            ByteBuffer byteBuffer = (ByteBuffer) unmodifiableMap.get(kVar2.f4535a);
            if (byteBuffer != null) {
                if (((Boolean) this.f2512i.invoke(n4, byteBuffer, Integer.valueOf(kVar2.f4536b), null, Integer.valueOf(kVar2.f4537c), Integer.valueOf(kVar2.f4538d ? 1 : 0))).booleanValue()) {
                    z4 = true;
                } else {
                    i(n4);
                    return null;
                }
            }
            i5++;
            z4 = z4;
        }
        if (!z4) {
            i(n4);
            return null;
        } else if (!l(n4) || (k4 = k(n4)) == null) {
            return null;
        } else {
            return Typeface.create(k4, i4);
        }
    }

    @Override // b0.n
    public final Typeface d(Context context, Resources resources, int i4, String str, int i5) {
        if (!m()) {
            return super.d(context, resources, i4, str, i5);
        }
        Object n4 = n();
        if (n4 == null) {
            return null;
        }
        if (!j(context, n4, str, 0, -1, -1, null)) {
            i(n4);
            return null;
        } else if (!l(n4)) {
            return null;
        } else {
            return k(n4);
        }
    }

    public final void i(Object obj) {
        try {
            this.f2514k.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean j(Context context, Object obj, String str, int i4, int i5, int i6, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f2511h.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface k(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f2509f, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f2515l.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean l(Object obj) {
        try {
            return ((Boolean) this.f2513j.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean m() {
        Method method = this.f2511h;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method != null) {
            return true;
        }
        return false;
    }

    public final Object n() {
        try {
            return this.f2510g.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public Method p(Class cls) {
        Class<?> cls2 = Array.newInstance(cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
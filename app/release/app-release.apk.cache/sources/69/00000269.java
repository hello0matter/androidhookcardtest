package androidx.fragment.app;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: b  reason: collision with root package name */
    public static final l.k f1693b = new l.k();

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k0 f1694a;

    public f0(k0 k0Var) {
        this.f1694a = k0Var;
    }

    public static Class b(ClassLoader classLoader, String str) {
        l.k kVar = f1693b;
        l.k kVar2 = (l.k) kVar.getOrDefault(classLoader, null);
        if (kVar2 == null) {
            kVar2 = new l.k();
            kVar.put(classLoader, kVar2);
        }
        Class cls = (Class) kVar2.getOrDefault(str, null);
        if (cls == null) {
            Class<?> cls2 = Class.forName(str, false, classLoader);
            kVar2.put(str, cls2);
            return cls2;
        }
        return cls;
    }

    public static Class c(ClassLoader classLoader, String str) {
        try {
            return b(classLoader, str);
        } catch (ClassCastException e4) {
            throw new RuntimeException(androidx.activity.j.d("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException(androidx.activity.j.d("Unable to instantiate fragment ", str, ": make sure class name exists"), e5);
        }
    }

    public final t a(String str) {
        Context context = this.f1694a.f1738p.f1838r;
        Object obj = t.R;
        try {
            return (t) c(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException(androidx.activity.j.d("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e4);
        } catch (InstantiationException e5) {
            throw new RuntimeException(androidx.activity.j.d("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e5);
        } catch (NoSuchMethodException e6) {
            throw new RuntimeException(androidx.activity.j.d("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e6);
        } catch (InvocationTargetException e7) {
            throw new RuntimeException(androidx.activity.j.d("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e7);
        }
    }
}
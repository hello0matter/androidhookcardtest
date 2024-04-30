package a1;

import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import com.example.msphone.R;
import com.google.common.collect.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f52d;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f53e = new Object();

    /* renamed from: c  reason: collision with root package name */
    public final Context f56c;

    /* renamed from: b  reason: collision with root package name */
    public final HashSet f55b = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f54a = new HashMap();

    public a(Context context) {
        this.f56c = context.getApplicationContext();
    }

    public static a c(Context context) {
        if (f52d == null) {
            synchronized (f53e) {
                try {
                    if (f52d == null) {
                        f52d = new a(context);
                    }
                } finally {
                }
            }
        }
        return f52d;
    }

    public final void a(Bundle bundle) {
        HashSet hashSet;
        String string = this.f56c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    hashSet = this.f55b;
                    if (!hasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, null))) {
                        Class<?> cls = Class.forName(next);
                        if (b.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    b((Class) it2.next(), hashSet2);
                }
            } catch (ClassNotFoundException e4) {
                throw new RuntimeException(e4);
            }
        }
    }

    public final Object b(Class cls, HashSet hashSet) {
        Object obj;
        if (c.Y0()) {
            try {
                Trace.beginSection(cls.getSimpleName());
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (!hashSet.contains(cls)) {
            HashMap hashMap = this.f54a;
            if (!hashMap.containsKey(cls)) {
                hashSet.add(cls);
                b bVar = (b) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class> a5 = bVar.a();
                if (!a5.isEmpty()) {
                    for (Class cls2 : a5) {
                        if (!hashMap.containsKey(cls2)) {
                            b(cls2, hashSet);
                        }
                    }
                }
                obj = bVar.b(this.f56c);
                hashSet.remove(cls);
                hashMap.put(cls, obj);
            } else {
                obj = hashMap.get(cls);
            }
            Trace.endSection();
            return obj;
        }
        String name = cls.getName();
        throw new IllegalStateException("Cannot initialize " + name + ". Cycle detected.");
    }
}
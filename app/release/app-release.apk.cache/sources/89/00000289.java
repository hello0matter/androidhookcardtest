package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class u0 {

    /* renamed from: a  reason: collision with root package name */
    public static final z0 f1832a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final b1 f1833b;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.fragment.app.z0, java.lang.Object] */
    static {
        b1 b1Var;
        try {
            b1Var = (b1) c1.r.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            b1Var = null;
        }
        f1833b = b1Var;
    }

    public static void a(t tVar, t tVar2, boolean z4) {
        if (z4) {
            tVar2.getClass();
        } else {
            tVar.getClass();
        }
    }

    public static void b(ArrayList arrayList, int i4) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((View) arrayList.get(size)).setVisibility(i4);
        }
    }
}
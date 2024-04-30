package androidx.recyclerview.widget;

import android.database.Observable;

/* loaded from: classes.dex */
public abstract class j0 {

    /* renamed from: a  reason: collision with root package name */
    public final k0 f2145a = new Observable();

    /* renamed from: b  reason: collision with root package name */
    public boolean f2146b = false;

    public abstract int a();

    public long b(int i4) {
        return -1L;
    }

    public int c(int i4) {
        return 0;
    }

    public abstract void d(l1 l1Var, int i4);

    public abstract l1 e(RecyclerView recyclerView, int i4);

    public void f(l1 l1Var) {
    }
}
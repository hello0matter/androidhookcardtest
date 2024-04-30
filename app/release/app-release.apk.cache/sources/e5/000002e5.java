package androidx.recyclerview.widget;

import android.util.SparseArray;

/* loaded from: classes.dex */
public final class a1 {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray f2054a;

    /* renamed from: b  reason: collision with root package name */
    public int f2055b;

    public final z0 a(int i4) {
        SparseArray sparseArray = this.f2054a;
        z0 z0Var = (z0) sparseArray.get(i4);
        if (z0Var == null) {
            z0 z0Var2 = new z0();
            sparseArray.put(i4, z0Var2);
            return z0Var2;
        }
        return z0Var;
    }
}
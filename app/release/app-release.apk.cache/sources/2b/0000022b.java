package androidx.emoji2.text;

import android.util.SparseArray;

/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray f1505a;

    /* renamed from: b  reason: collision with root package name */
    public t f1506b;

    public c0(int i4) {
        this.f1505a = new SparseArray(i4);
    }

    public final void a(t tVar, int i4, int i5) {
        c0 c0Var;
        int a5 = tVar.a(i4);
        SparseArray sparseArray = this.f1505a;
        if (sparseArray == null) {
            c0Var = null;
        } else {
            c0Var = (c0) sparseArray.get(a5);
        }
        if (c0Var == null) {
            c0Var = new c0(1);
            sparseArray.put(tVar.a(i4), c0Var);
        }
        if (i5 > i4) {
            c0Var.a(tVar, i4 + 1, i5);
        } else {
            c0Var.f1506b = tVar;
        }
    }
}
package androidx.fragment.app;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class j0 implements i0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f1720a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1721b = 1;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k0 f1722c;

    public j0(k0 k0Var, int i4) {
        this.f1722c = k0Var;
        this.f1720a = i4;
    }

    @Override // androidx.fragment.app.i0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        k0 k0Var = this.f1722c;
        t tVar = k0Var.f1741s;
        int i4 = this.f1720a;
        if (tVar == null || i4 >= 0 || !tVar.h().M()) {
            return k0Var.N(arrayList, arrayList2, i4, this.f1721b);
        }
        return false;
    }
}
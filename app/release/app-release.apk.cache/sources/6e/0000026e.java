package androidx.fragment.app;

import android.content.Context;

/* loaded from: classes.dex */
public final class h extends i {

    /* renamed from: c  reason: collision with root package name */
    public boolean f1712c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1713d;

    /* renamed from: e  reason: collision with root package name */
    public z f1714e;

    public final z c(Context context) {
        boolean z4;
        if (this.f1713d) {
            return this.f1714e;
        }
        f1 f1Var = this.f1715a;
        t tVar = f1Var.f1697c;
        if (f1Var.f1695a == SpecialEffectsController$Operation$State.f1627b) {
            z4 = true;
        } else {
            z4 = false;
        }
        z d12 = com.google.common.collect.c.d1(context, tVar, z4, this.f1712c);
        this.f1714e = d12;
        this.f1713d = true;
        return d12;
    }
}
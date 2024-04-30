package androidx.activity;

import androidx.fragment.app.e0;

/* loaded from: classes.dex */
public final class v implements c {

    /* renamed from: a  reason: collision with root package name */
    public final e0 f156a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ w f157b;

    public v(w wVar, e0 e0Var) {
        this.f157b = wVar;
        this.f156a = e0Var;
    }

    @Override // androidx.activity.c
    public final void cancel() {
        w wVar = this.f157b;
        y2.g gVar = wVar.f159b;
        e0 e0Var = this.f156a;
        gVar.remove(e0Var);
        if (com.google.common.collect.c.n(wVar.f160c, e0Var)) {
            e0Var.getClass();
            wVar.f160c = null;
        }
        e0Var.getClass();
        e0Var.f1684b.remove(this);
        e3.a aVar = e0Var.f1685c;
        if (aVar != null) {
            aVar.a();
        }
        e0Var.f1685c = null;
    }
}
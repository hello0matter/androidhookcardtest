package androidx.fragment.app;

import android.view.View;

/* loaded from: classes.dex */
public final class q extends com.google.common.collect.c {

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ t f1774q;

    public q(t tVar) {
        this.f1774q = tVar;
    }

    @Override // com.google.common.collect.c
    public final View l1(int i4) {
        t tVar = this.f1774q;
        View view = tVar.E;
        if (view != null) {
            return view.findViewById(i4);
        }
        throw new IllegalStateException("Fragment " + tVar + " does not have a view");
    }

    @Override // com.google.common.collect.c
    public final boolean o1() {
        return this.f1774q.E != null;
    }
}
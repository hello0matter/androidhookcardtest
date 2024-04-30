package androidx.fragment.app;

import android.app.Dialog;
import android.view.View;

/* loaded from: classes.dex */
public final class o extends com.google.common.collect.c {

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ com.google.common.collect.c f1760q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ p f1761r;

    public o(p pVar, q qVar) {
        this.f1761r = pVar;
        this.f1760q = qVar;
    }

    @Override // com.google.common.collect.c
    public final View l1(int i4) {
        com.google.common.collect.c cVar = this.f1760q;
        if (cVar.o1()) {
            return cVar.l1(i4);
        }
        Dialog dialog = this.f1761r.f1765d0;
        if (dialog != null) {
            return dialog.findViewById(i4);
        }
        return null;
    }

    @Override // com.google.common.collect.c
    public final boolean o1() {
        if (!this.f1760q.o1() && !this.f1761r.f1768g0) {
            return false;
        }
        return true;
    }
}
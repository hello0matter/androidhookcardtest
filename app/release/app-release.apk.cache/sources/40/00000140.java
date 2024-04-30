package androidx.appcompat.widget;

import android.content.Context;
import android.view.View;
import com.example.msphone.R;

/* loaded from: classes.dex */
public final class h extends g.b0 {

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f757m = 0;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ n f758n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(n nVar, Context context, g.p pVar, l lVar) {
        super(R.attr.actionOverflowMenuStyle, 0, context, lVar, pVar, true);
        this.f758n = nVar;
        this.f4603g = 8388613;
        androidx.appcompat.app.o0 o0Var = nVar.f852x;
        this.f4605i = o0Var;
        g.y yVar = this.f4606j;
        if (yVar != null) {
            yVar.d(o0Var);
        }
    }

    @Override // g.b0
    public final void c() {
        int i4 = this.f757m;
        n nVar = this.f758n;
        switch (i4) {
            case 0:
                nVar.f849u = null;
                nVar.f853y = 0;
                super.c();
                return;
            default:
                g.p pVar = nVar.f4611c;
                if (pVar != null) {
                    pVar.c(true);
                }
                nVar.f848t = null;
                super.c();
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(n nVar, Context context, g.j0 j0Var, View view) {
        super(R.attr.actionOverflowMenuStyle, 0, context, view, j0Var, false);
        this.f758n = nVar;
        if (!j0Var.A.f()) {
            View view2 = nVar.f838j;
            this.f4602f = view2 == null ? (View) nVar.f4616h : view2;
        }
        androidx.appcompat.app.o0 o0Var = nVar.f852x;
        this.f4605i = o0Var;
        g.y yVar = this.f4606j;
        if (yVar != null) {
            yVar.d(o0Var);
        }
    }
}
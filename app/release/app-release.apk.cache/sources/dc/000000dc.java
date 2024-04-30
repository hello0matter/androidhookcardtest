package androidx.appcompat.app;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class t extends com.google.common.collect.c {

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f333q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Object f334r;

    public t(int i4, Object obj) {
        this.f333q = i4;
        this.f334r = obj;
    }

    @Override // i0.h1
    public final void a() {
        int i4 = this.f333q;
        Object obj = this.f334r;
        switch (i4) {
            case 0:
                r rVar = (r) obj;
                rVar.f326b.f249v.setAlpha(1.0f);
                f0 f0Var = rVar.f326b;
                f0Var.f252y.d(null);
                f0Var.f252y = null;
                return;
            case 1:
                f0 f0Var2 = (f0) obj;
                f0Var2.f249v.setAlpha(1.0f);
                f0Var2.f252y.d(null);
                f0Var2.f252y = null;
                return;
            default:
                u uVar = (u) obj;
                uVar.f341b.f249v.setVisibility(8);
                f0 f0Var3 = uVar.f341b;
                PopupWindow popupWindow = f0Var3.f250w;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (f0Var3.f249v.getParent() instanceof View) {
                    WeakHashMap weakHashMap = y0.f4999a;
                    i0.k0.c((View) f0Var3.f249v.getParent());
                }
                f0Var3.f249v.h();
                f0Var3.f252y.d(null);
                f0Var3.f252y = null;
                ViewGroup viewGroup = f0Var3.A;
                WeakHashMap weakHashMap2 = y0.f4999a;
                i0.k0.c(viewGroup);
                return;
        }
    }

    @Override // com.google.common.collect.c, i0.h1
    public final void i() {
        int i4 = this.f333q;
        Object obj = this.f334r;
        switch (i4) {
            case 0:
                ((r) obj).f326b.f249v.setVisibility(0);
                return;
            case 1:
                f0 f0Var = (f0) obj;
                f0Var.f249v.setVisibility(0);
                if (f0Var.f249v.getParent() instanceof View) {
                    WeakHashMap weakHashMap = y0.f4999a;
                    i0.k0.c((View) f0Var.f249v.getParent());
                    return;
                }
                return;
            default:
                return;
        }
    }
}
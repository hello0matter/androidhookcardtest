package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class s0 extends com.google.common.collect.c {

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f331q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ u0 f332r;

    public s0(u0 u0Var, int i4) {
        this.f331q = i4;
        this.f332r = u0Var;
    }

    @Override // i0.h1
    public final void a() {
        View view;
        int i4 = this.f331q;
        u0 u0Var = this.f332r;
        switch (i4) {
            case 0:
                if (u0Var.f358o && (view = u0Var.f350g) != null) {
                    view.setTranslationY(0.0f);
                    u0Var.f347d.setTranslationY(0.0f);
                }
                u0Var.f347d.setVisibility(8);
                u0Var.f347d.setTransitioning(false);
                u0Var.f362s = null;
                f.b bVar = u0Var.f354k;
                if (bVar != null) {
                    bVar.c(u0Var.f353j);
                    u0Var.f353j = null;
                    u0Var.f354k = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = u0Var.f346c;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = y0.f4999a;
                    i0.k0.c(actionBarOverlayLayout);
                    return;
                }
                return;
            default:
                u0Var.f362s = null;
                u0Var.f347d.requestLayout();
                return;
        }
    }
}
package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public class n1 extends i0.c {

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f2194d;

    /* renamed from: e  reason: collision with root package name */
    public final m1 f2195e;

    public n1(RecyclerView recyclerView) {
        this.f2194d = recyclerView;
        m1 m1Var = this.f2195e;
        this.f2195e = m1Var == null ? new m1(this) : m1Var;
    }

    @Override // i0.c
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !this.f2194d.L()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().Q(accessibilityEvent);
            }
        }
    }

    @Override // i0.c
    public void d(View view, j0.h hVar) {
        this.f4912a.onInitializeAccessibilityNodeInfo(view, hVar.f5093a);
        RecyclerView recyclerView = this.f2194d;
        if (!recyclerView.L() && recyclerView.getLayoutManager() != null) {
            u0 layoutManager = recyclerView.getLayoutManager();
            RecyclerView recyclerView2 = layoutManager.f2274b;
            layoutManager.R(recyclerView2.f1968b, recyclerView2.f1973d0, hVar);
        }
    }

    @Override // i0.c
    public final boolean g(View view, int i4, Bundle bundle) {
        if (super.g(view, i4, bundle)) {
            return true;
        }
        RecyclerView recyclerView = this.f2194d;
        if (!recyclerView.L() && recyclerView.getLayoutManager() != null) {
            u0 layoutManager = recyclerView.getLayoutManager();
            RecyclerView recyclerView2 = layoutManager.f2274b;
            return layoutManager.e0(recyclerView2.f1968b, recyclerView2.f1973d0, i4, bundle);
        }
        return false;
    }
}
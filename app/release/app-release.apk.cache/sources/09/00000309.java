package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class m1 extends i0.c {

    /* renamed from: d  reason: collision with root package name */
    public final n1 f2189d;

    /* renamed from: e  reason: collision with root package name */
    public final WeakHashMap f2190e = new WeakHashMap();

    public m1(n1 n1Var) {
        this.f2189d = n1Var;
    }

    @Override // i0.c
    public final boolean a(View view, AccessibilityEvent accessibilityEvent) {
        i0.c cVar = (i0.c) this.f2190e.get(view);
        if (cVar != null) {
            return cVar.a(view, accessibilityEvent);
        }
        return this.f4912a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // i0.c
    public final i0 b(View view) {
        i0.c cVar = (i0.c) this.f2190e.get(view);
        if (cVar != null) {
            return cVar.b(view);
        }
        return super.b(view);
    }

    @Override // i0.c
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        i0.c cVar = (i0.c) this.f2190e.get(view);
        if (cVar != null) {
            cVar.c(view, accessibilityEvent);
        } else {
            super.c(view, accessibilityEvent);
        }
    }

    @Override // i0.c
    public final void d(View view, j0.h hVar) {
        n1 n1Var = this.f2189d;
        boolean L = n1Var.f2194d.L();
        View.AccessibilityDelegate accessibilityDelegate = this.f4912a;
        AccessibilityNodeInfo accessibilityNodeInfo = hVar.f5093a;
        if (!L) {
            RecyclerView recyclerView = n1Var.f2194d;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().S(view, hVar);
                i0.c cVar = (i0.c) this.f2190e.get(view);
                if (cVar != null) {
                    cVar.d(view, hVar);
                    return;
                }
            }
        }
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
    }

    @Override // i0.c
    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        i0.c cVar = (i0.c) this.f2190e.get(view);
        if (cVar != null) {
            cVar.e(view, accessibilityEvent);
        } else {
            super.e(view, accessibilityEvent);
        }
    }

    @Override // i0.c
    public final boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        i0.c cVar = (i0.c) this.f2190e.get(viewGroup);
        if (cVar != null) {
            return cVar.f(viewGroup, view, accessibilityEvent);
        }
        return this.f4912a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    @Override // i0.c
    public final boolean g(View view, int i4, Bundle bundle) {
        n1 n1Var = this.f2189d;
        if (!n1Var.f2194d.L()) {
            RecyclerView recyclerView = n1Var.f2194d;
            if (recyclerView.getLayoutManager() != null) {
                i0.c cVar = (i0.c) this.f2190e.get(view);
                if (cVar != null) {
                    if (cVar.g(view, i4, bundle)) {
                        return true;
                    }
                } else if (super.g(view, i4, bundle)) {
                    return true;
                }
                b1 b1Var = recyclerView.getLayoutManager().f2274b.f1968b;
                return false;
            }
        }
        return super.g(view, i4, bundle);
    }

    @Override // i0.c
    public final void h(View view, int i4) {
        i0.c cVar = (i0.c) this.f2190e.get(view);
        if (cVar != null) {
            cVar.h(view, i4);
        } else {
            super.h(view, i4);
        }
    }

    @Override // i0.c
    public final void i(View view, AccessibilityEvent accessibilityEvent) {
        i0.c cVar = (i0.c) this.f2190e.get(view);
        if (cVar != null) {
            cVar.i(view, accessibilityEvent);
        } else {
            super.i(view, accessibilityEvent);
        }
    }
}
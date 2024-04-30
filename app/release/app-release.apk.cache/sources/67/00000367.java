package androidx.viewpager2.widget;

import android.os.Bundle;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i0;
import androidx.recyclerview.widget.j0;
import i0.g0;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class l extends g0.i {

    /* renamed from: b  reason: collision with root package name */
    public final k f2479b;

    /* renamed from: c  reason: collision with root package name */
    public final k f2480c;

    /* renamed from: d  reason: collision with root package name */
    public e f2481d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ViewPager2 f2482e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(ViewPager2 viewPager2) {
        super(viewPager2);
        this.f2482e = viewPager2;
        this.f2479b = new k(this, 0);
        this.f2480c = new k(this, 1);
    }

    public final void e(j0 j0Var) {
        k();
        if (j0Var != null) {
            j0Var.f2145a.registerObserver(this.f2481d);
        }
    }

    public final void f(j0 j0Var) {
        if (j0Var != null) {
            j0Var.f2145a.unregisterObserver(this.f2481d);
        }
    }

    public final void g(RecyclerView recyclerView) {
        WeakHashMap weakHashMap = y0.f4999a;
        g0.s(recyclerView, 2);
        this.f2481d = new e(1, this);
        ViewPager2 viewPager2 = this.f2482e;
        if (g0.c(viewPager2) == 0) {
            g0.s(viewPager2, 1);
        }
    }

    public final void h(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i4;
        int i5;
        int a5;
        ViewPager2 viewPager2 = this.f2482e;
        if (viewPager2.getAdapter() != null) {
            if (viewPager2.getOrientation() == 1) {
                i4 = viewPager2.getAdapter().a();
                i5 = 0;
            } else {
                i5 = viewPager2.getAdapter().a();
                i4 = 0;
            }
        } else {
            i4 = 0;
            i5 = 0;
        }
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) i0.h(i4, i5, 0).f2125a);
        j0 adapter = viewPager2.getAdapter();
        if (adapter != null && (a5 = adapter.a()) != 0 && viewPager2.f2450r) {
            if (viewPager2.f2436d > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (viewPager2.f2436d < a5 - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
            accessibilityNodeInfo.setScrollable(true);
        }
    }

    public final void i(int i4, Bundle bundle) {
        int currentItem;
        if (i4 != 8192 && i4 != 4096) {
            throw new IllegalStateException();
        }
        ViewPager2 viewPager2 = this.f2482e;
        if (i4 == 8192) {
            currentItem = viewPager2.getCurrentItem() - 1;
        } else {
            currentItem = viewPager2.getCurrentItem() + 1;
        }
        if (viewPager2.f2450r) {
            viewPager2.c(currentItem, true);
        }
    }

    public final void j(AccessibilityEvent accessibilityEvent) {
        accessibilityEvent.setSource(this.f2482e);
        accessibilityEvent.setClassName("androidx.viewpager.widget.ViewPager");
    }

    public final void k() {
        int a5;
        int i4;
        int i5 = 16908360;
        ViewPager2 viewPager2 = this.f2482e;
        y0.l(16908360, viewPager2);
        y0.m(16908361, viewPager2);
        boolean z4 = false;
        y0.i(0, viewPager2);
        y0.m(16908358, viewPager2);
        y0.i(0, viewPager2);
        y0.m(16908359, viewPager2);
        y0.i(0, viewPager2);
        if (viewPager2.getAdapter() == null || (a5 = viewPager2.getAdapter().a()) == 0 || !viewPager2.f2450r) {
            return;
        }
        int orientation = viewPager2.getOrientation();
        k kVar = this.f2480c;
        k kVar2 = this.f2479b;
        if (orientation == 0) {
            if (viewPager2.f2439g.A() == 1) {
                z4 = true;
            }
            if (z4) {
                i4 = 16908360;
            } else {
                i4 = 16908361;
            }
            if (z4) {
                i5 = 16908361;
            }
            if (viewPager2.f2436d < a5 - 1) {
                y0.n(viewPager2, new j0.g(i4), null, kVar2);
            }
            if (viewPager2.f2436d > 0) {
                y0.n(viewPager2, new j0.g(i5), null, kVar);
                return;
            }
            return;
        }
        if (viewPager2.f2436d < a5 - 1) {
            y0.n(viewPager2, new j0.g(16908359), null, kVar2);
        }
        if (viewPager2.f2436d > 0) {
            y0.n(viewPager2, new j0.g(16908358), null, kVar);
        }
    }
}
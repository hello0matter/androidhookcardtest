package androidx.viewpager2.widget;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

/* loaded from: classes.dex */
public final class f extends j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2475a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f2476b;

    public f() {
        this.f2475a = 2;
        this.f2476b = new ArrayList(3);
    }

    @Override // androidx.viewpager2.widget.j
    public final void a(int i4) {
        int i5 = this.f2475a;
        Object obj = this.f2476b;
        switch (i5) {
            case 0:
                if (i4 == 0) {
                    ((ViewPager2) obj).d();
                    return;
                }
                return;
            case 1:
            default:
                return;
            case 2:
                try {
                    for (j jVar : (List) obj) {
                        jVar.a(i4);
                    }
                    return;
                } catch (ConcurrentModificationException e4) {
                    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e4);
                }
        }
    }

    @Override // androidx.viewpager2.widget.j
    public final void b(int i4, float f4, int i5) {
        switch (this.f2475a) {
            case 2:
                try {
                    for (j jVar : (List) this.f2476b) {
                        jVar.b(i4, f4, i5);
                    }
                    return;
                } catch (ConcurrentModificationException e4) {
                    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e4);
                }
            default:
                return;
        }
    }

    @Override // androidx.viewpager2.widget.j
    public final void c(int i4) {
        int i5 = this.f2475a;
        Object obj = this.f2476b;
        switch (i5) {
            case 0:
                ViewPager2 viewPager2 = (ViewPager2) obj;
                if (viewPager2.f2436d != i4) {
                    viewPager2.f2436d = i4;
                    viewPager2.f2452t.k();
                    return;
                }
                return;
            case 1:
                ViewPager2 viewPager22 = (ViewPager2) obj;
                viewPager22.clearFocus();
                if (viewPager22.hasFocus()) {
                    viewPager22.f2442j.requestFocus(2);
                    return;
                }
                return;
            default:
                try {
                    for (j jVar : (List) obj) {
                        jVar.c(i4);
                    }
                    return;
                } catch (ConcurrentModificationException e4) {
                    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e4);
                }
        }
    }

    public f(ViewPager2 viewPager2, int i4) {
        this.f2475a = i4;
        this.f2476b = viewPager2;
    }
}
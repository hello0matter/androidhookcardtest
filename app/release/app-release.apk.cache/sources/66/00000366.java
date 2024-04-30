package androidx.viewpager2.widget;

import android.view.View;
import j0.v;

/* loaded from: classes.dex */
public final class k implements v {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2477a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f2478b;

    public /* synthetic */ k(l lVar, int i4) {
        this.f2477a = i4;
        this.f2478b = lVar;
    }

    @Override // j0.v
    public final boolean e(View view) {
        int i4 = this.f2477a;
        l lVar = this.f2478b;
        switch (i4) {
            case 0:
                int currentItem = ((ViewPager2) view).getCurrentItem() + 1;
                ViewPager2 viewPager2 = lVar.f2482e;
                if (viewPager2.f2450r) {
                    viewPager2.c(currentItem, true);
                }
                return true;
            default:
                int currentItem2 = ((ViewPager2) view).getCurrentItem() - 1;
                ViewPager2 viewPager22 = lVar.f2482e;
                if (viewPager22.f2450r) {
                    viewPager22.c(currentItem2, true);
                }
                return true;
        }
    }
}
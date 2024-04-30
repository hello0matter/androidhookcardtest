package f1;

import android.database.DataSetObserver;
import androidx.viewpager.widget.PagerTitleStrip;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes.dex */
public final class c extends DataSetObserver implements h, g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PagerTitleStrip f4545a;

    public c(PagerTitleStrip pagerTitleStrip) {
        this.f4545a = pagerTitleStrip;
    }

    @Override // f1.h
    public final void a(int i4, float f4) {
        if (f4 > 0.5f) {
            i4++;
        }
        this.f4545a.c(i4, f4, false);
    }

    @Override // f1.g
    public final void c(ViewPager viewPager) {
        this.f4545a.a();
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        PagerTitleStrip pagerTitleStrip = this.f4545a;
        int currentItem = pagerTitleStrip.f2390a.getCurrentItem();
        pagerTitleStrip.f2390a.getAdapter();
        pagerTitleStrip.b(currentItem);
        float f4 = pagerTitleStrip.f2395f;
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        pagerTitleStrip.c(pagerTitleStrip.f2390a.getCurrentItem(), f4, true);
    }

    @Override // f1.h
    public final void b(int i4) {
    }
}
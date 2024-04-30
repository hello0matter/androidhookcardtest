package f1;

import android.view.View;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4543a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PagerTabStrip f4544b;

    public /* synthetic */ b(PagerTabStrip pagerTabStrip, int i4) {
        this.f4543a = i4;
        this.f4544b = pagerTabStrip;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i4 = this.f4543a;
        PagerTabStrip pagerTabStrip = this.f4544b;
        switch (i4) {
            case 0:
                ViewPager viewPager = pagerTabStrip.f2390a;
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                return;
            default:
                ViewPager viewPager2 = pagerTabStrip.f2390a;
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
                return;
        }
    }
}
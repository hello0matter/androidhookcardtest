package o2;

import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public final class b implements f1.g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TabLayout f5971a;

    public b(TabLayout tabLayout) {
        this.f5971a = tabLayout;
    }

    @Override // f1.g
    public final void c(ViewPager viewPager) {
        TabLayout tabLayout = this.f5971a;
        if (tabLayout.O == viewPager) {
            tabLayout.g();
        }
    }
}
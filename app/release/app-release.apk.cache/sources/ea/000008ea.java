package o2;

import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class g implements f1.h {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f5978a;

    /* renamed from: b  reason: collision with root package name */
    public int f5979b;

    /* renamed from: c  reason: collision with root package name */
    public int f5980c;

    public g(TabLayout tabLayout) {
        this.f5978a = new WeakReference(tabLayout);
    }

    @Override // f1.h
    public final void a(int i4, float f4) {
        boolean z4;
        boolean z5;
        TabLayout tabLayout = (TabLayout) this.f5978a.get();
        if (tabLayout != null) {
            int i5 = this.f5980c;
            if (i5 == 2 && this.f5979b != 1) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (i5 == 2 && this.f5979b == 0) {
                z5 = false;
            } else {
                z5 = true;
            }
            tabLayout.i(i4, f4, z4, z5, false);
        }
    }

    @Override // f1.h
    public final void b(int i4) {
        this.f5979b = this.f5980c;
        this.f5980c = i4;
        TabLayout tabLayout = (TabLayout) this.f5978a.get();
        if (tabLayout != null) {
            tabLayout.S = this.f5980c;
        }
    }
}
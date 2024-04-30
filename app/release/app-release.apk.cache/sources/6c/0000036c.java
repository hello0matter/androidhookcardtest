package androidx.viewpager2.widget;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.navigation.NavigationBarItemView;

/* loaded from: classes.dex */
public final class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2485a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2486b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f2487c;

    public /* synthetic */ q(int i4, int i5, Object obj) {
        this.f2485a = i5;
        this.f2487c = obj;
        this.f2486b = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f2485a;
        int i5 = this.f2486b;
        Object obj = this.f2487c;
        switch (i4) {
            case 0:
                ((RecyclerView) obj).d0(i5);
                return;
            case 1:
                ((MaterialCalendar) obj).f3261b0.d0(i5);
                return;
            default:
                int[] iArr = NavigationBarItemView.G;
                ((NavigationBarItemView) obj).i(i5);
                return;
        }
    }

    public q(int i4, o oVar) {
        this.f2485a = 0;
        this.f2486b = i4;
        this.f2487c = oVar;
    }
}
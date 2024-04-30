package t1;

import android.view.View;
import androidx.activity.d;
import androidx.activity.k;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import i0.g0;
import i0.y0;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6686a;

    /* renamed from: b  reason: collision with root package name */
    public int f6687b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6688c;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f6689d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout.Behavior f6690e;

    public b(BottomSheetBehavior bottomSheetBehavior) {
        this.f6686a = 0;
        this.f6690e = bottomSheetBehavior;
        this.f6689d = new k(11, this);
    }

    public final void a(int i4) {
        CoordinatorLayout.Behavior behavior = this.f6690e;
        int i5 = this.f6686a;
        Runnable runnable = this.f6689d;
        switch (i5) {
            case 0:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) behavior;
                WeakReference weakReference = bottomSheetBehavior.U;
                if (weakReference != null && weakReference.get() != null) {
                    this.f6687b = i4;
                    if (!this.f6688c) {
                        WeakHashMap weakHashMap = y0.f4999a;
                        g0.m((View) bottomSheetBehavior.U.get(), runnable);
                        this.f6688c = true;
                        return;
                    }
                    return;
                }
                return;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) behavior;
                WeakReference weakReference2 = sideSheetBehavior.f3825p;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.f6687b = i4;
                    if (!this.f6688c) {
                        WeakHashMap weakHashMap2 = y0.f4999a;
                        g0.m((View) sideSheetBehavior.f3825p.get(), runnable);
                        this.f6688c = true;
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(BottomSheetBehavior bottomSheetBehavior, int i4) {
        this(bottomSheetBehavior);
        this.f6686a = 0;
    }

    public b(SideSheetBehavior sideSheetBehavior) {
        this.f6686a = 1;
        this.f6690e = sideSheetBehavior;
        this.f6689d = new d(9, this);
    }
}
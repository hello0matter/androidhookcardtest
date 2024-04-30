package a0;

import android.view.View;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* loaded from: classes.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f32a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f33b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f34c;

    public /* synthetic */ o(int i4, int i5, Object obj) {
        this.f32a = i5;
        this.f34c = obj;
        this.f33b = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f32a;
        int i5 = this.f33b;
        Object obj = this.f34c;
        switch (i4) {
            case 0:
                ((p) obj).c(i5);
                return;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj;
                View view = (View) sideSheetBehavior.f3825p.get();
                if (view != null) {
                    sideSheetBehavior.z(view, i5, false);
                    return;
                }
                return;
        }
    }
}
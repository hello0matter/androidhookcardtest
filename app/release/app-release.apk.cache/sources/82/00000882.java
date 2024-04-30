package m2;

import android.view.View;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* loaded from: classes.dex */
public final class a extends com.google.common.collect.c {

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f5451q;

    /* renamed from: r  reason: collision with root package name */
    public final SideSheetBehavior f5452r;

    public /* synthetic */ a(SideSheetBehavior sideSheetBehavior, int i4) {
        this.f5451q = i4;
        this.f5452r = sideSheetBehavior;
    }

    public final float h2(int i4) {
        switch (this.f5451q) {
            case 0:
                float j22 = j2();
                return (i4 - j22) / (i2() - j22);
            default:
                float j23 = j2();
                return (j23 - i4) / (j23 - i2());
        }
    }

    public final int i2() {
        int i4 = this.f5451q;
        SideSheetBehavior sideSheetBehavior = this.f5452r;
        switch (i4) {
            case 0:
                return Math.max(0, sideSheetBehavior.f3823n + sideSheetBehavior.f3824o);
            default:
                return Math.max(0, (j2() - sideSheetBehavior.f3821l) - sideSheetBehavior.f3824o);
        }
    }

    public final int j2() {
        int i4 = this.f5451q;
        SideSheetBehavior sideSheetBehavior = this.f5452r;
        switch (i4) {
            case 0:
                return (-sideSheetBehavior.f3821l) - sideSheetBehavior.f3824o;
            default:
                return sideSheetBehavior.f3822m;
        }
    }

    public final boolean k2(float f4) {
        switch (this.f5451q) {
            case 0:
                if (f4 <= 0.0f) {
                    return false;
                }
                return true;
            default:
                if (f4 >= 0.0f) {
                    return false;
                }
                return true;
        }
    }

    public final boolean l2(View view) {
        switch (this.f5451q) {
            case 0:
                if (view.getRight() >= (i2() - j2()) / 2) {
                    return false;
                }
                return true;
            default:
                if (view.getLeft() <= (i2() + j2()) / 2) {
                    return false;
                }
                return true;
        }
    }

    public final boolean m2(float f4, float f5) {
        int i4 = this.f5451q;
        SideSheetBehavior sideSheetBehavior = this.f5452r;
        switch (i4) {
            case 0:
                if (Math.abs(f4) <= Math.abs(f5)) {
                    return false;
                }
                float abs = Math.abs(f4);
                sideSheetBehavior.getClass();
                if (abs <= 500) {
                    return false;
                }
                return true;
            default:
                if (Math.abs(f4) <= Math.abs(f5)) {
                    return false;
                }
                float abs2 = Math.abs(f4);
                sideSheetBehavior.getClass();
                if (abs2 <= 500) {
                    return false;
                }
                return true;
        }
    }

    public final boolean n2(View view, float f4) {
        int i4 = this.f5451q;
        SideSheetBehavior sideSheetBehavior = this.f5452r;
        switch (i4) {
            case 0:
                if (Math.abs((f4 * sideSheetBehavior.f3820k) + view.getLeft()) <= 0.5f) {
                    return false;
                }
                return true;
            default:
                if (Math.abs((f4 * sideSheetBehavior.f3820k) + view.getRight()) <= 0.5f) {
                    return false;
                }
                return true;
        }
    }
}
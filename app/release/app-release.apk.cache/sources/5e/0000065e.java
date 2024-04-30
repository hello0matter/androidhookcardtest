package d2;

import android.view.ViewGroup;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/* loaded from: classes.dex */
public final class c implements h {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4356a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExtendedFloatingActionButton f4357b;

    public /* synthetic */ c(ExtendedFloatingActionButton extendedFloatingActionButton, int i4) {
        this.f4356a = i4;
        this.f4357b = extendedFloatingActionButton;
    }

    @Override // d2.h
    public final int c() {
        int i4 = this.f4356a;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f4357b;
        switch (i4) {
            case 0:
                return extendedFloatingActionButton.getCollapsedSize();
            default:
                return (extendedFloatingActionButton.getMeasuredWidth() - (extendedFloatingActionButton.getCollapsedPadding() * 2)) + extendedFloatingActionButton.f3398z + extendedFloatingActionButton.A;
        }
    }

    @Override // d2.h
    public final int d() {
        int i4 = this.f4356a;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f4357b;
        switch (i4) {
            case 0:
                return extendedFloatingActionButton.getCollapsedSize();
            default:
                return extendedFloatingActionButton.getMeasuredHeight();
        }
    }

    @Override // d2.h
    public final int e() {
        int i4 = this.f4356a;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f4357b;
        switch (i4) {
            case 0:
                return extendedFloatingActionButton.getCollapsedPadding();
            default:
                return extendedFloatingActionButton.A;
        }
    }

    @Override // d2.h
    public final int g() {
        int i4 = this.f4356a;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f4357b;
        switch (i4) {
            case 0:
                return extendedFloatingActionButton.getCollapsedPadding();
            default:
                return extendedFloatingActionButton.f3398z;
        }
    }

    @Override // d2.h
    public final ViewGroup.LayoutParams h() {
        switch (this.f4356a) {
            case 0:
                return new ViewGroup.LayoutParams(c(), d());
            default:
                return new ViewGroup.LayoutParams(-2, -2);
        }
    }
}
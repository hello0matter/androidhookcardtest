package v1;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.u0;
import com.google.android.material.carousel.CarouselLayoutManager;

/* loaded from: classes.dex */
public final class e extends g {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f6965b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(CarouselLayoutManager carouselLayoutManager) {
        super(1);
        this.f6965b = carouselLayoutManager;
    }

    @Override // v1.g
    public final void a(RectF rectF, RectF rectF2, RectF rectF3) {
        float f4 = rectF2.top;
        float f5 = rectF3.top;
        if (f4 < f5 && rectF2.bottom > f5) {
            float f6 = f5 - f4;
            rectF.top += f6;
            rectF3.top += f6;
        }
        float f7 = rectF2.bottom;
        float f8 = rectF3.bottom;
        if (f7 > f8 && rectF2.top < f8) {
            float f9 = f7 - f8;
            rectF.bottom = Math.max(rectF.bottom - f9, rectF.top);
            rectF2.bottom = Math.max(rectF2.bottom - f9, rectF2.top);
        }
    }

    @Override // v1.g
    public final float b(RecyclerView.LayoutParams layoutParams) {
        return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
    }

    @Override // v1.g
    public final RectF c(float f4, float f5, float f6, float f7) {
        return new RectF(0.0f, f6, f5, f4 - f6);
    }

    @Override // v1.g
    public final int d() {
        return this.f6965b.f2287o;
    }

    @Override // v1.g
    public final int e() {
        return this.f6965b.f2287o;
    }

    @Override // v1.g
    public final int f() {
        return this.f6965b.C();
    }

    @Override // v1.g
    public final int g() {
        CarouselLayoutManager carouselLayoutManager = this.f6965b;
        return carouselLayoutManager.f2286n - carouselLayoutManager.D();
    }

    @Override // v1.g
    public final int h() {
        return 0;
    }

    @Override // v1.g
    public final int i() {
        return 0;
    }

    @Override // v1.g
    public final void j(View view, int i4, int i5) {
        u0.L(view, this.f6965b.C(), i4, g(), i5);
    }

    @Override // v1.g
    public final void k(RectF rectF, RectF rectF2, RectF rectF3) {
        if (rectF2.bottom <= rectF3.top) {
            rectF.bottom = ((float) Math.floor(rectF.bottom)) - 1.0f;
        }
        if (rectF2.top >= rectF3.bottom) {
            rectF.top = ((float) Math.ceil(rectF.top)) + 1.0f;
        }
    }

    @Override // v1.g
    public final void l(float f4, float f5, Rect rect, View view) {
        view.offsetTopAndBottom((int) (f5 - (rect.top + f4)));
    }
}
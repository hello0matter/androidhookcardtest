package v1;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.u0;
import com.google.android.material.carousel.CarouselLayoutManager;

/* loaded from: classes.dex */
public final class f extends g {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f6966b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(CarouselLayoutManager carouselLayoutManager) {
        super(0);
        this.f6966b = carouselLayoutManager;
    }

    @Override // v1.g
    public final void a(RectF rectF, RectF rectF2, RectF rectF3) {
        float f4 = rectF2.left;
        float f5 = rectF3.left;
        if (f4 < f5 && rectF2.right > f5) {
            float f6 = f5 - f4;
            rectF.left += f6;
            rectF2.left += f6;
        }
        float f7 = rectF2.right;
        float f8 = rectF3.right;
        if (f7 > f8 && rectF2.left < f8) {
            float f9 = f7 - f8;
            rectF.right = Math.max(rectF.right - f9, rectF.left);
            rectF2.right = Math.max(rectF2.right - f9, rectF2.left);
        }
    }

    @Override // v1.g
    public final float b(RecyclerView.LayoutParams layoutParams) {
        return ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
    }

    @Override // v1.g
    public final RectF c(float f4, float f5, float f6, float f7) {
        return new RectF(f7, 0.0f, f5 - f7, f4);
    }

    @Override // v1.g
    public final int d() {
        CarouselLayoutManager carouselLayoutManager = this.f6966b;
        return carouselLayoutManager.f2287o - carouselLayoutManager.B();
    }

    @Override // v1.g
    public final int e() {
        CarouselLayoutManager carouselLayoutManager = this.f6966b;
        if (carouselLayoutManager.L0()) {
            return 0;
        }
        return carouselLayoutManager.f2286n;
    }

    @Override // v1.g
    public final int f() {
        return 0;
    }

    @Override // v1.g
    public final int g() {
        return this.f6966b.f2286n;
    }

    @Override // v1.g
    public final int h() {
        CarouselLayoutManager carouselLayoutManager = this.f6966b;
        if (carouselLayoutManager.L0()) {
            return carouselLayoutManager.f2286n;
        }
        return 0;
    }

    @Override // v1.g
    public final int i() {
        return this.f6966b.E();
    }

    @Override // v1.g
    public final void j(View view, int i4, int i5) {
        u0.L(view, i4, this.f6966b.E(), i5, d());
    }

    @Override // v1.g
    public final void k(RectF rectF, RectF rectF2, RectF rectF3) {
        if (rectF2.right <= rectF3.left) {
            rectF.right = ((float) Math.floor(rectF.right)) - 1.0f;
        }
        if (rectF2.left >= rectF3.right) {
            rectF.left = ((float) Math.ceil(rectF.left)) + 1.0f;
        }
    }

    @Override // v1.g
    public final void l(float f4, float f5, Rect rect, View view) {
        view.offsetLeftAndRight((int) (f5 - (rect.left + f4)));
    }
}
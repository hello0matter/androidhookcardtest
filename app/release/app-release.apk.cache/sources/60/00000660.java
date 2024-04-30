package d2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.example.msphone.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import i0.h0;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class e extends a {

    /* renamed from: g  reason: collision with root package name */
    public final h f4359g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f4360h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ExtendedFloatingActionButton f4361i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ExtendedFloatingActionButton extendedFloatingActionButton, w1.g gVar, h hVar, boolean z4) {
        super(extendedFloatingActionButton, gVar);
        this.f4361i = extendedFloatingActionButton;
        this.f4359g = hVar;
        this.f4360h = z4;
    }

    @Override // d2.a
    public final AnimatorSet a() {
        float f4;
        p1.f fVar = this.f4339f;
        if (fVar == null) {
            if (this.f4338e == null) {
                this.f4338e = p1.f.b(this.f4334a, c());
            }
            fVar = this.f4338e;
            fVar.getClass();
        }
        boolean g4 = fVar.g("width");
        h hVar = this.f4359g;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f4361i;
        if (g4) {
            PropertyValuesHolder[] e4 = fVar.e("width");
            e4[0].setFloatValues(extendedFloatingActionButton.getWidth(), hVar.c());
            fVar.h("width", e4);
        }
        if (fVar.g("height")) {
            PropertyValuesHolder[] e5 = fVar.e("height");
            e5[0].setFloatValues(extendedFloatingActionButton.getHeight(), hVar.d());
            fVar.h("height", e5);
        }
        if (fVar.g("paddingStart")) {
            PropertyValuesHolder[] e6 = fVar.e("paddingStart");
            PropertyValuesHolder propertyValuesHolder = e6[0];
            WeakHashMap weakHashMap = y0.f4999a;
            propertyValuesHolder.setFloatValues(h0.f(extendedFloatingActionButton), hVar.g());
            fVar.h("paddingStart", e6);
        }
        if (fVar.g("paddingEnd")) {
            PropertyValuesHolder[] e7 = fVar.e("paddingEnd");
            PropertyValuesHolder propertyValuesHolder2 = e7[0];
            WeakHashMap weakHashMap2 = y0.f4999a;
            propertyValuesHolder2.setFloatValues(h0.e(extendedFloatingActionButton), hVar.e());
            fVar.h("paddingEnd", e7);
        }
        if (fVar.g("labelOpacity")) {
            PropertyValuesHolder[] e8 = fVar.e("labelOpacity");
            float f5 = 1.0f;
            boolean z4 = this.f4360h;
            if (z4) {
                f4 = 0.0f;
            } else {
                f4 = 1.0f;
            }
            if (!z4) {
                f5 = 0.0f;
            }
            e8[0].setFloatValues(f4, f5);
            fVar.h("labelOpacity", e8);
        }
        return b(fVar);
    }

    @Override // d2.a
    public final int c() {
        if (this.f4360h) {
            return R.animator.mtrl_extended_fab_change_size_expand_motion_spec;
        }
        return R.animator.mtrl_extended_fab_change_size_collapse_motion_spec;
    }

    @Override // d2.a
    public final void e() {
        this.f4337d.f7056b = null;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f4361i;
        extendedFloatingActionButton.D = false;
        extendedFloatingActionButton.setHorizontallyScrolling(false);
        ViewGroup.LayoutParams layoutParams = extendedFloatingActionButton.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        h hVar = this.f4359g;
        layoutParams.width = hVar.h().width;
        layoutParams.height = hVar.h().height;
    }

    @Override // d2.a
    public final void f(Animator animator) {
        w1.g gVar = this.f4337d;
        Animator animator2 = (Animator) gVar.f7056b;
        if (animator2 != null) {
            animator2.cancel();
        }
        gVar.f7056b = animator;
        boolean z4 = this.f4360h;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f4361i;
        extendedFloatingActionButton.C = z4;
        extendedFloatingActionButton.D = true;
        extendedFloatingActionButton.setHorizontallyScrolling(true);
    }

    @Override // d2.a
    public final void g() {
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f4361i;
        boolean z4 = this.f4360h;
        extendedFloatingActionButton.C = z4;
        ViewGroup.LayoutParams layoutParams = extendedFloatingActionButton.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (!z4) {
            extendedFloatingActionButton.G = layoutParams.width;
            extendedFloatingActionButton.H = layoutParams.height;
        }
        h hVar = this.f4359g;
        layoutParams.width = hVar.h().width;
        layoutParams.height = hVar.h().height;
        int g4 = hVar.g();
        int paddingTop = extendedFloatingActionButton.getPaddingTop();
        int e4 = hVar.e();
        int paddingBottom = extendedFloatingActionButton.getPaddingBottom();
        WeakHashMap weakHashMap = y0.f4999a;
        h0.k(extendedFloatingActionButton, g4, paddingTop, e4, paddingBottom);
        extendedFloatingActionButton.requestLayout();
    }

    @Override // d2.a
    public final boolean h() {
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f4361i;
        if (this.f4360h != extendedFloatingActionButton.C && extendedFloatingActionButton.getIcon() != null && !TextUtils.isEmpty(extendedFloatingActionButton.getText())) {
            return false;
        }
        return true;
    }
}
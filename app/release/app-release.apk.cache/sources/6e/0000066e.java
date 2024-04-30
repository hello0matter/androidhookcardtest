package d2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import com.example.msphone.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class s extends q {
    public StateListAnimator N;

    @Override // d2.q
    public final float e() {
        return this.f4415v.getElevation();
    }

    @Override // d2.q
    public final void f(Rect rect) {
        if (((FloatingActionButton) this.f4416w.f7056b).f3411k) {
            super.f(rect);
            return;
        }
        if (this.f4399f) {
            FloatingActionButton floatingActionButton = this.f4415v;
            int sizeDimension = floatingActionButton.getSizeDimension();
            int i4 = this.f4404k;
            if (sizeDimension < i4) {
                int sizeDimension2 = (i4 - floatingActionButton.getSizeDimension()) / 2;
                rect.set(sizeDimension2, sizeDimension2, sizeDimension2, sizeDimension2);
                return;
            }
        }
        rect.set(0, 0, 0, 0);
    }

    @Override // d2.q
    public final void g(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i4) {
        Drawable drawable;
        l2.j t4 = t();
        this.f4395b = t4;
        t4.setTintList(colorStateList);
        if (mode != null) {
            this.f4395b.setTintMode(mode);
        }
        l2.j jVar = this.f4395b;
        FloatingActionButton floatingActionButton = this.f4415v;
        jVar.l(floatingActionButton.getContext());
        if (i4 > 0) {
            Context context = floatingActionButton.getContext();
            l2.p pVar = this.f4394a;
            pVar.getClass();
            b bVar = new b(pVar);
            Object obj = z.e.f7215a;
            int a5 = z.d.a(context, R.color.design_fab_stroke_top_outer_color);
            int a6 = z.d.a(context, R.color.design_fab_stroke_top_inner_color);
            int a7 = z.d.a(context, R.color.design_fab_stroke_end_inner_color);
            int a8 = z.d.a(context, R.color.design_fab_stroke_end_outer_color);
            bVar.f4348i = a5;
            bVar.f4349j = a6;
            bVar.f4350k = a7;
            bVar.f4351l = a8;
            float f4 = i4;
            if (bVar.f4347h != f4) {
                bVar.f4347h = f4;
                bVar.f4341b.setStrokeWidth(f4 * 1.3333f);
                bVar.f4353n = true;
                bVar.invalidateSelf();
            }
            if (colorStateList != null) {
                bVar.f4352m = colorStateList.getColorForState(bVar.getState(), bVar.f4352m);
            }
            bVar.f4355p = colorStateList;
            bVar.f4353n = true;
            bVar.invalidateSelf();
            this.f4397d = bVar;
            b bVar2 = this.f4397d;
            bVar2.getClass();
            l2.j jVar2 = this.f4395b;
            jVar2.getClass();
            drawable = new LayerDrawable(new Drawable[]{bVar2, jVar2});
        } else {
            this.f4397d = null;
            drawable = this.f4395b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(j2.a.c(colorStateList2), drawable, null);
        this.f4396c = rippleDrawable;
        this.f4398e = rippleDrawable;
    }

    @Override // d2.q
    public final void i() {
        r();
    }

    @Override // d2.q
    public final void k(float f4, float f5, float f6) {
        int i4 = Build.VERSION.SDK_INT;
        FloatingActionButton floatingActionButton = this.f4415v;
        if (floatingActionButton.getStateListAnimator() == this.N) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(q.H, s(f4, f6));
            stateListAnimator.addState(q.I, s(f4, f5));
            stateListAnimator.addState(q.J, s(f4, f5));
            stateListAnimator.addState(q.K, s(f4, f5));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, "elevation", f4).setDuration(0L));
            if (i4 <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(q.C);
            stateListAnimator.addState(q.L, animatorSet);
            stateListAnimator.addState(q.M, s(0.0f, 0.0f));
            this.N = stateListAnimator;
            floatingActionButton.setStateListAnimator(stateListAnimator);
        }
        if (p()) {
            r();
        }
    }

    @Override // d2.q
    public final void n(ColorStateList colorStateList) {
        Drawable drawable = this.f4396c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(j2.a.c(colorStateList));
        } else {
            super.n(colorStateList);
        }
    }

    @Override // d2.q
    public final boolean p() {
        if (!((FloatingActionButton) this.f4416w.f7056b).f3411k && (!this.f4399f || this.f4415v.getSizeDimension() >= this.f4404k)) {
            return false;
        }
        return true;
    }

    public final AnimatorSet s(float f4, float f5) {
        AnimatorSet animatorSet = new AnimatorSet();
        float[] fArr = {f4};
        FloatingActionButton floatingActionButton = this.f4415v;
        animatorSet.play(ObjectAnimator.ofFloat(floatingActionButton, "elevation", fArr).setDuration(0L)).with(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, f5).setDuration(100L));
        animatorSet.setInterpolator(q.C);
        return animatorSet;
    }

    public final l2.j t() {
        l2.p pVar = this.f4394a;
        pVar.getClass();
        return new l2.j(pVar);
    }

    @Override // d2.q
    public final void j(int[] iArr) {
    }

    @Override // d2.q
    public final void h() {
    }

    @Override // d2.q
    public final void q() {
    }
}
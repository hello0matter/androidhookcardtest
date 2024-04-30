package com.google.android.material.textfield;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.EditText;
import com.example.msphone.R;
import com.google.android.material.internal.CheckableImageButton;

/* loaded from: classes.dex */
public final class c extends m {

    /* renamed from: e  reason: collision with root package name */
    public final int f4018e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4019f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeInterpolator f4020g;

    /* renamed from: h  reason: collision with root package name */
    public final TimeInterpolator f4021h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f4022i;

    /* renamed from: j  reason: collision with root package name */
    public final com.google.android.material.datepicker.s f4023j;

    /* renamed from: k  reason: collision with root package name */
    public final com.google.android.material.datepicker.j f4024k;

    /* renamed from: l  reason: collision with root package name */
    public AnimatorSet f4025l;

    /* renamed from: m  reason: collision with root package name */
    public ValueAnimator f4026m;

    public c(l lVar) {
        super(lVar);
        this.f4023j = new com.google.android.material.datepicker.s(1, this);
        this.f4024k = new com.google.android.material.datepicker.j(1, this);
        this.f4018e = com.google.common.collect.c.K1(lVar.getContext(), R.attr.motionDurationShort3, 100);
        this.f4019f = com.google.common.collect.c.K1(lVar.getContext(), R.attr.motionDurationShort3, 150);
        this.f4020g = com.google.common.collect.c.L1(lVar.getContext(), R.attr.motionEasingLinearInterpolator, p1.a.f6128a);
        this.f4021h = com.google.common.collect.c.L1(lVar.getContext(), R.attr.motionEasingEmphasizedInterpolator, p1.a.f6131d);
    }

    @Override // com.google.android.material.textfield.m
    public final void a() {
        if (this.f4072b.f4064p != null) {
            return;
        }
        t(u());
    }

    @Override // com.google.android.material.textfield.m
    public final int c() {
        return R.string.clear_text_end_icon_content_description;
    }

    @Override // com.google.android.material.textfield.m
    public final int d() {
        return R.drawable.mtrl_ic_cancel;
    }

    @Override // com.google.android.material.textfield.m
    public final View.OnFocusChangeListener e() {
        return this.f4024k;
    }

    @Override // com.google.android.material.textfield.m
    public final View.OnClickListener f() {
        return this.f4023j;
    }

    @Override // com.google.android.material.textfield.m
    public final View.OnFocusChangeListener g() {
        return this.f4024k;
    }

    @Override // com.google.android.material.textfield.m
    public final void m(EditText editText) {
        this.f4022i = editText;
        this.f4071a.setEndIconVisible(u());
    }

    @Override // com.google.android.material.textfield.m
    public final void p(boolean z4) {
        if (this.f4072b.f4064p == null) {
            return;
        }
        t(z4);
    }

    @Override // com.google.android.material.textfield.m
    public final void r() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(this.f4021h);
        ofFloat.setDuration(this.f4019f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.textfield.a

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f4015b;

            {
                this.f4015b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i4 = r2;
                c cVar = this.f4015b;
                cVar.getClass();
                switch (i4) {
                    case 0:
                        cVar.f4074d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        return;
                    default:
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = cVar.f4074d;
                        checkableImageButton.setScaleX(floatValue);
                        checkableImageButton.setScaleY(floatValue);
                        return;
                }
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.f4020g;
        ofFloat2.setInterpolator(timeInterpolator);
        int i4 = this.f4018e;
        ofFloat2.setDuration(i4);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.textfield.a

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f4015b;

            {
                this.f4015b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i42 = r2;
                c cVar = this.f4015b;
                cVar.getClass();
                switch (i42) {
                    case 0:
                        cVar.f4074d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        return;
                    default:
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = cVar.f4074d;
                        checkableImageButton.setScaleX(floatValue);
                        checkableImageButton.setScaleY(floatValue);
                        return;
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.f4025l = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2);
        this.f4025l.addListener(new b(this, 0));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat3.setInterpolator(timeInterpolator);
        ofFloat3.setDuration(i4);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.textfield.a

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f4015b;

            {
                this.f4015b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i42 = r2;
                c cVar = this.f4015b;
                cVar.getClass();
                switch (i42) {
                    case 0:
                        cVar.f4074d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        return;
                    default:
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = cVar.f4074d;
                        checkableImageButton.setScaleX(floatValue);
                        checkableImageButton.setScaleY(floatValue);
                        return;
                }
            }
        });
        this.f4026m = ofFloat3;
        ofFloat3.addListener(new b(this, 1));
    }

    @Override // com.google.android.material.textfield.m
    public final void s() {
        EditText editText = this.f4022i;
        if (editText != null) {
            editText.post(new androidx.activity.d(10, this));
        }
    }

    public final void t(boolean z4) {
        boolean z5 = this.f4072b.d() == z4;
        if (z4 && !this.f4025l.isRunning()) {
            this.f4026m.cancel();
            this.f4025l.start();
            if (z5) {
                this.f4025l.end();
            }
        } else if (z4) {
        } else {
            this.f4025l.cancel();
            this.f4026m.start();
            if (z5) {
                this.f4026m.end();
            }
        }
    }

    public final boolean u() {
        EditText editText = this.f4022i;
        return editText != null && (editText.hasFocus() || this.f4074d.hasFocus()) && this.f4022i.getText().length() > 0;
    }
}
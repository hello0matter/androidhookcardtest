package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.example.msphone.R;
import i0.h0;
import i0.j0;
import i0.y0;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class o {
    public ColorStateList A;
    public Typeface B;

    /* renamed from: a  reason: collision with root package name */
    public final int f4080a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4081b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4082c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeInterpolator f4083d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeInterpolator f4084e;

    /* renamed from: f  reason: collision with root package name */
    public final TimeInterpolator f4085f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f4086g;

    /* renamed from: h  reason: collision with root package name */
    public final TextInputLayout f4087h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f4088i;

    /* renamed from: j  reason: collision with root package name */
    public int f4089j;

    /* renamed from: k  reason: collision with root package name */
    public FrameLayout f4090k;

    /* renamed from: l  reason: collision with root package name */
    public Animator f4091l;

    /* renamed from: m  reason: collision with root package name */
    public final float f4092m;

    /* renamed from: n  reason: collision with root package name */
    public int f4093n;

    /* renamed from: o  reason: collision with root package name */
    public int f4094o;

    /* renamed from: p  reason: collision with root package name */
    public CharSequence f4095p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f4096q;

    /* renamed from: r  reason: collision with root package name */
    public AppCompatTextView f4097r;

    /* renamed from: s  reason: collision with root package name */
    public CharSequence f4098s;

    /* renamed from: t  reason: collision with root package name */
    public int f4099t;

    /* renamed from: u  reason: collision with root package name */
    public int f4100u;

    /* renamed from: v  reason: collision with root package name */
    public ColorStateList f4101v;

    /* renamed from: w  reason: collision with root package name */
    public CharSequence f4102w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f4103x;

    /* renamed from: y  reason: collision with root package name */
    public AppCompatTextView f4104y;

    /* renamed from: z  reason: collision with root package name */
    public int f4105z;

    public o(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f4086g = context;
        this.f4087h = textInputLayout;
        this.f4092m = context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
        this.f4080a = com.google.common.collect.c.K1(context, R.attr.motionDurationShort4, 217);
        this.f4081b = com.google.common.collect.c.K1(context, R.attr.motionDurationMedium4, 167);
        this.f4082c = com.google.common.collect.c.K1(context, R.attr.motionDurationShort4, 167);
        this.f4083d = com.google.common.collect.c.L1(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, p1.a.f6131d);
        LinearInterpolator linearInterpolator = p1.a.f6128a;
        this.f4084e = com.google.common.collect.c.L1(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, linearInterpolator);
        this.f4085f = com.google.common.collect.c.L1(context, R.attr.motionEasingLinearInterpolator, linearInterpolator);
    }

    public final void a(TextView textView, int i4) {
        if (this.f4088i == null && this.f4090k == null) {
            Context context = this.f4086g;
            LinearLayout linearLayout = new LinearLayout(context);
            this.f4088i = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.f4088i;
            TextInputLayout textInputLayout = this.f4087h;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.f4090k = new FrameLayout(context);
            this.f4088i.addView(this.f4090k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                b();
            }
        }
        if (i4 != 0 && i4 != 1) {
            this.f4088i.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        } else {
            this.f4090k.setVisibility(0);
            this.f4090k.addView(textView);
        }
        this.f4088i.setVisibility(0);
        this.f4089j++;
    }

    public final void b() {
        if (this.f4088i != null) {
            TextInputLayout textInputLayout = this.f4087h;
            if (textInputLayout.getEditText() != null) {
                EditText editText = textInputLayout.getEditText();
                Context context = this.f4086g;
                boolean e4 = i2.d.e(context);
                LinearLayout linearLayout = this.f4088i;
                WeakHashMap weakHashMap = y0.f4999a;
                int f4 = h0.f(editText);
                if (e4) {
                    f4 = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top);
                if (e4) {
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_top);
                }
                int e5 = h0.e(editText);
                if (e4) {
                    e5 = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                h0.k(linearLayout, f4, dimensionPixelSize, e5, 0);
            }
        }
    }

    public final void c() {
        Animator animator = this.f4091l;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void d(ArrayList arrayList, boolean z4, TextView textView, int i4, int i5, int i6) {
        boolean z5;
        float f4;
        long j4;
        TimeInterpolator timeInterpolator;
        if (textView != null && z4) {
            if (i4 == i6 || i4 == i5) {
                if (i6 == i4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z5) {
                    f4 = 1.0f;
                } else {
                    f4 = 0.0f;
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, f4);
                int i7 = this.f4082c;
                if (z5) {
                    j4 = this.f4081b;
                } else {
                    j4 = i7;
                }
                ofFloat.setDuration(j4);
                if (z5) {
                    timeInterpolator = this.f4084e;
                } else {
                    timeInterpolator = this.f4085f;
                }
                ofFloat.setInterpolator(timeInterpolator);
                if (i4 == i6 && i5 != 0) {
                    ofFloat.setStartDelay(i7);
                }
                arrayList.add(ofFloat);
                if (i6 == i4 && i5 != 0) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.f4092m, 0.0f);
                    ofFloat2.setDuration(this.f4080a);
                    ofFloat2.setInterpolator(this.f4083d);
                    ofFloat2.setStartDelay(i7);
                    arrayList.add(ofFloat2);
                }
            }
        }
    }

    public final TextView e(int i4) {
        if (i4 != 1) {
            if (i4 != 2) {
                return null;
            }
            return this.f4104y;
        }
        return this.f4097r;
    }

    public final void f() {
        this.f4095p = null;
        c();
        if (this.f4093n == 1) {
            this.f4094o = (!this.f4103x || TextUtils.isEmpty(this.f4102w)) ? 0 : 2;
        }
        i(this.f4093n, this.f4094o, h(this.f4097r, ""));
    }

    public final void g(TextView textView, int i4) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.f4088i;
        if (linearLayout == null) {
            return;
        }
        if ((i4 == 0 || i4 == 1) && (frameLayout = this.f4090k) != null) {
            frameLayout.removeView(textView);
        } else {
            linearLayout.removeView(textView);
        }
        int i5 = this.f4089j - 1;
        this.f4089j = i5;
        LinearLayout linearLayout2 = this.f4088i;
        if (i5 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    public final boolean h(TextView textView, CharSequence charSequence) {
        WeakHashMap weakHashMap = y0.f4999a;
        TextInputLayout textInputLayout = this.f4087h;
        if (j0.c(textInputLayout) && textInputLayout.isEnabled() && (this.f4094o != this.f4093n || textView == null || !TextUtils.equals(textView.getText(), charSequence))) {
            return true;
        }
        return false;
    }

    public final void i(int i4, int i5, boolean z4) {
        TextView e4;
        TextView e5;
        if (i4 == i5) {
            return;
        }
        if (z4) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f4091l = animatorSet;
            ArrayList arrayList = new ArrayList();
            d(arrayList, this.f4103x, this.f4104y, 2, i4, i5);
            d(arrayList, this.f4096q, this.f4097r, 1, i4, i5);
            p1.b.a(animatorSet, arrayList);
            animatorSet.addListener(new n(this, i5, e(i4), i4, e(i5)));
            animatorSet.start();
        } else if (i4 != i5) {
            if (i5 != 0 && (e5 = e(i5)) != null) {
                e5.setVisibility(0);
                e5.setAlpha(1.0f);
            }
            if (i4 != 0 && (e4 = e(i4)) != null) {
                e4.setVisibility(4);
                if (i4 == 1) {
                    e4.setText((CharSequence) null);
                }
            }
            this.f4093n = i5;
        }
        TextInputLayout textInputLayout = this.f4087h;
        textInputLayout.r();
        textInputLayout.u(z4, false);
        textInputLayout.x();
    }
}
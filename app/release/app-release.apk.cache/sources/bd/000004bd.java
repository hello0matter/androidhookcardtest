package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.example.msphone.R;
import i0.h0;
import i0.y0;
import java.util.WeakHashMap;
import l2.a0;
import l2.j;
import l2.p;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final MaterialButton f3141a;

    /* renamed from: b  reason: collision with root package name */
    public p f3142b;

    /* renamed from: c  reason: collision with root package name */
    public int f3143c;

    /* renamed from: d  reason: collision with root package name */
    public int f3144d;

    /* renamed from: e  reason: collision with root package name */
    public int f3145e;

    /* renamed from: f  reason: collision with root package name */
    public int f3146f;

    /* renamed from: g  reason: collision with root package name */
    public int f3147g;

    /* renamed from: h  reason: collision with root package name */
    public int f3148h;

    /* renamed from: i  reason: collision with root package name */
    public PorterDuff.Mode f3149i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f3150j;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f3151k;

    /* renamed from: l  reason: collision with root package name */
    public ColorStateList f3152l;

    /* renamed from: m  reason: collision with root package name */
    public j f3153m;

    /* renamed from: q  reason: collision with root package name */
    public boolean f3157q;

    /* renamed from: s  reason: collision with root package name */
    public RippleDrawable f3159s;

    /* renamed from: t  reason: collision with root package name */
    public int f3160t;

    /* renamed from: n  reason: collision with root package name */
    public boolean f3154n = false;

    /* renamed from: o  reason: collision with root package name */
    public boolean f3155o = false;

    /* renamed from: p  reason: collision with root package name */
    public boolean f3156p = false;

    /* renamed from: r  reason: collision with root package name */
    public boolean f3158r = true;

    public c(MaterialButton materialButton, p pVar) {
        this.f3141a = materialButton;
        this.f3142b = pVar;
    }

    public final a0 a() {
        Drawable drawable;
        RippleDrawable rippleDrawable = this.f3159s;
        if (rippleDrawable != null && rippleDrawable.getNumberOfLayers() > 1) {
            if (this.f3159s.getNumberOfLayers() > 2) {
                drawable = this.f3159s.getDrawable(2);
            } else {
                drawable = this.f3159s.getDrawable(1);
            }
            return (a0) drawable;
        }
        return null;
    }

    public final j b(boolean z4) {
        RippleDrawable rippleDrawable = this.f3159s;
        if (rippleDrawable != null && rippleDrawable.getNumberOfLayers() > 0) {
            return (j) ((LayerDrawable) ((InsetDrawable) this.f3159s.getDrawable(0)).getDrawable()).getDrawable(!z4 ? 1 : 0);
        }
        return null;
    }

    public final void c(p pVar) {
        this.f3142b = pVar;
        if (b(false) != null) {
            b(false).setShapeAppearanceModel(pVar);
        }
        if (b(true) != null) {
            b(true).setShapeAppearanceModel(pVar);
        }
        if (a() != null) {
            a().setShapeAppearanceModel(pVar);
        }
    }

    public final void d(int i4, int i5) {
        WeakHashMap weakHashMap = y0.f4999a;
        MaterialButton materialButton = this.f3141a;
        int f4 = h0.f(materialButton);
        int paddingTop = materialButton.getPaddingTop();
        int e4 = h0.e(materialButton);
        int paddingBottom = materialButton.getPaddingBottom();
        int i6 = this.f3145e;
        int i7 = this.f3146f;
        this.f3146f = i5;
        this.f3145e = i4;
        if (!this.f3155o) {
            e();
        }
        h0.k(materialButton, f4, (paddingTop + i4) - i6, e4, (paddingBottom + i5) - i7);
    }

    public final void e() {
        int i4;
        j jVar = new j(this.f3142b);
        MaterialButton materialButton = this.f3141a;
        jVar.l(materialButton.getContext());
        c0.b.h(jVar, this.f3150j);
        PorterDuff.Mode mode = this.f3149i;
        if (mode != null) {
            c0.b.i(jVar, mode);
        }
        ColorStateList colorStateList = this.f3151k;
        jVar.u(this.f3148h);
        jVar.t(colorStateList);
        j jVar2 = new j(this.f3142b);
        jVar2.setTint(0);
        float f4 = this.f3148h;
        if (this.f3154n) {
            i4 = y1.a.b(R.attr.colorSurface, materialButton);
        } else {
            i4 = 0;
        }
        jVar2.u(f4);
        jVar2.t(ColorStateList.valueOf(i4));
        j jVar3 = new j(this.f3142b);
        this.f3153m = jVar3;
        c0.b.g(jVar3, -1);
        RippleDrawable rippleDrawable = new RippleDrawable(j2.a.c(this.f3152l), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{jVar2, jVar}), this.f3143c, this.f3145e, this.f3144d, this.f3146f), this.f3153m);
        this.f3159s = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        j b5 = b(false);
        if (b5 != null) {
            b5.n(this.f3160t);
            b5.setState(materialButton.getDrawableState());
        }
    }

    public final void f() {
        int i4 = 0;
        j b5 = b(false);
        j b6 = b(true);
        if (b5 != null) {
            ColorStateList colorStateList = this.f3151k;
            b5.u(this.f3148h);
            b5.t(colorStateList);
            if (b6 != null) {
                float f4 = this.f3148h;
                if (this.f3154n) {
                    i4 = y1.a.b(R.attr.colorSurface, this.f3141a);
                }
                b6.u(f4);
                b6.t(ColorStateList.valueOf(i4));
            }
        }
    }
}
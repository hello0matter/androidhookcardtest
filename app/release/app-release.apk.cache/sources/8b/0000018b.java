package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public int f925a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f926b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f927c;

    /* renamed from: d  reason: collision with root package name */
    public Object f928d;

    /* renamed from: e  reason: collision with root package name */
    public Object f929e;

    /* renamed from: f  reason: collision with root package name */
    public Object f930f;

    public w(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i4, l2.p pVar, Rect rect) {
        h0.e.b(rect.left);
        h0.e.b(rect.top);
        h0.e.b(rect.right);
        h0.e.b(rect.bottom);
        this.f926b = rect;
        this.f927c = colorStateList2;
        this.f928d = colorStateList;
        this.f929e = colorStateList3;
        this.f925a = i4;
        this.f930f = pVar;
    }

    public static w b(Context context, int i4) {
        boolean z4;
        if (i4 != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        h0.e.a("Cannot create a CalendarItemStyle with a styleResId of 0", z4);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i4, o1.a.B);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(0, 0), obtainStyledAttributes.getDimensionPixelOffset(2, 0), obtainStyledAttributes.getDimensionPixelOffset(1, 0), obtainStyledAttributes.getDimensionPixelOffset(3, 0));
        ColorStateList a5 = i2.d.a(context, obtainStyledAttributes, 4);
        ColorStateList a6 = i2.d.a(context, obtainStyledAttributes, 9);
        ColorStateList a7 = i2.d.a(context, obtainStyledAttributes, 7);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        l2.p a8 = l2.p.a(context, obtainStyledAttributes.getResourceId(5, 0), obtainStyledAttributes.getResourceId(6, 0)).a();
        obtainStyledAttributes.recycle();
        return new w(a5, a6, a7, dimensionPixelSize, a8, rect);
    }

    public final void a() {
        View view = (View) this.f926b;
        Drawable background = view.getBackground();
        if (background != null) {
            if (((o3) this.f928d) != null) {
                if (((o3) this.f930f) == null) {
                    this.f930f = new Object();
                }
                o3 o3Var = (o3) this.f930f;
                o3Var.f868a = null;
                o3Var.f871d = false;
                o3Var.f869b = null;
                o3Var.f870c = false;
                WeakHashMap weakHashMap = i0.y0.f4999a;
                ColorStateList g4 = i0.m0.g(view);
                if (g4 != null) {
                    o3Var.f871d = true;
                    o3Var.f868a = g4;
                }
                PorterDuff.Mode h4 = i0.m0.h(view);
                if (h4 != null) {
                    o3Var.f870c = true;
                    o3Var.f869b = h4;
                }
                if (o3Var.f871d || o3Var.f870c) {
                    a0.e(background, o3Var, view.getDrawableState());
                    return;
                }
            }
            o3 o3Var2 = (o3) this.f929e;
            if (o3Var2 != null) {
                a0.e(background, o3Var2, view.getDrawableState());
                return;
            }
            o3 o3Var3 = (o3) this.f928d;
            if (o3Var3 != null) {
                a0.e(background, o3Var3, view.getDrawableState());
            }
        }
    }

    public final ColorStateList c() {
        Object obj = this.f929e;
        if (((o3) obj) != null) {
            return ((o3) obj).f868a;
        }
        return null;
    }

    public final PorterDuff.Mode d() {
        Object obj = this.f929e;
        if (((o3) obj) != null) {
            return ((o3) obj).f869b;
        }
        return null;
    }

    public final void e(AttributeSet attributeSet, int i4) {
        ColorStateList h4;
        Object obj = this.f926b;
        View view = (View) obj;
        Context context = view.getContext();
        int[] iArr = c.a.C;
        q3 f4 = q3.f(context, attributeSet, iArr, i4, 0);
        TypedArray typedArray = f4.f879b;
        i0.y0.o(view, view.getContext(), iArr, attributeSet, f4.f879b, i4);
        try {
            if (typedArray.hasValue(0)) {
                this.f925a = typedArray.getResourceId(0, -1);
                a0 a0Var = (a0) this.f927c;
                Context context2 = ((View) obj).getContext();
                int i5 = this.f925a;
                synchronized (a0Var) {
                    h4 = a0Var.f693a.h(context2, i5);
                }
                if (h4 != null) {
                    h(h4);
                }
            }
            if (typedArray.hasValue(1)) {
                i0.m0.q((View) obj, f4.a(1));
            }
            if (typedArray.hasValue(2)) {
                i0.m0.r((View) obj, o1.c(typedArray.getInt(2, -1), null));
            }
            f4.g();
        } catch (Throwable th) {
            f4.g();
            throw th;
        }
    }

    public final void f() {
        this.f925a = -1;
        h(null);
        a();
    }

    public final void g(int i4) {
        ColorStateList colorStateList;
        this.f925a = i4;
        a0 a0Var = (a0) this.f927c;
        if (a0Var != null) {
            Context context = ((View) this.f926b).getContext();
            synchronized (a0Var) {
                colorStateList = a0Var.f693a.h(context, i4);
            }
        } else {
            colorStateList = null;
        }
        h(colorStateList);
        a();
    }

    public final void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (((o3) this.f928d) == null) {
                this.f928d = new Object();
            }
            Object obj = this.f928d;
            ((o3) obj).f868a = colorStateList;
            ((o3) obj).f871d = true;
        } else {
            this.f928d = null;
        }
        a();
    }

    public final void i(ColorStateList colorStateList) {
        if (((o3) this.f929e) == null) {
            this.f929e = new Object();
        }
        o3 o3Var = (o3) this.f929e;
        o3Var.f868a = colorStateList;
        o3Var.f871d = true;
        a();
    }

    public final void j(PorterDuff.Mode mode) {
        if (((o3) this.f929e) == null) {
            this.f929e = new Object();
        }
        o3 o3Var = (o3) this.f929e;
        o3Var.f869b = mode;
        o3Var.f870c = true;
        a();
    }

    public final void k(TextView textView) {
        l2.j jVar = new l2.j();
        l2.j jVar2 = new l2.j();
        jVar.setShapeAppearanceModel((l2.p) this.f930f);
        jVar2.setShapeAppearanceModel((l2.p) this.f930f);
        jVar.o((ColorStateList) this.f928d);
        jVar.u(this.f925a);
        jVar.t((ColorStateList) this.f929e);
        Object obj = this.f927c;
        textView.setTextColor((ColorStateList) obj);
        RippleDrawable rippleDrawable = new RippleDrawable(((ColorStateList) obj).withAlpha(30), jVar, jVar2);
        Rect rect = (Rect) this.f926b;
        InsetDrawable insetDrawable = new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom);
        WeakHashMap weakHashMap = i0.y0.f4999a;
        i0.g0.q(textView, insetDrawable);
    }

    public w(View view) {
        this.f925a = -1;
        this.f926b = view;
        this.f927c = a0.a();
    }
}
package com.google.android.material.internal;

import android.content.Context;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: c  reason: collision with root package name */
    public float f3536c;

    /* renamed from: d  reason: collision with root package name */
    public float f3537d;

    /* renamed from: f  reason: collision with root package name */
    public final WeakReference f3539f;

    /* renamed from: g  reason: collision with root package name */
    public i2.g f3540g;

    /* renamed from: a  reason: collision with root package name */
    public final TextPaint f3534a = new TextPaint(1);

    /* renamed from: b  reason: collision with root package name */
    public final w1.b f3535b = new w1.b(1, this);

    /* renamed from: e  reason: collision with root package name */
    public boolean f3538e = true;

    public d0(c0 c0Var) {
        this.f3539f = new WeakReference(null);
        this.f3539f = new WeakReference(c0Var);
    }

    public final float a(String str) {
        if (this.f3538e) {
            b(str);
            return this.f3536c;
        }
        return this.f3536c;
    }

    public final void b(String str) {
        float measureText;
        TextPaint textPaint = this.f3534a;
        float f4 = 0.0f;
        if (str == null) {
            measureText = 0.0f;
        } else {
            measureText = textPaint.measureText((CharSequence) str, 0, str.length());
        }
        this.f3536c = measureText;
        if (str != null) {
            f4 = Math.abs(textPaint.getFontMetrics().ascent);
        }
        this.f3537d = f4;
        this.f3538e = false;
    }

    public final void c(i2.g gVar, Context context) {
        if (this.f3540g != gVar) {
            this.f3540g = gVar;
            if (gVar != null) {
                TextPaint textPaint = this.f3534a;
                w1.b bVar = this.f3535b;
                gVar.f(context, textPaint, bVar);
                c0 c0Var = (c0) this.f3539f.get();
                if (c0Var != null) {
                    textPaint.drawableState = c0Var.getState();
                }
                gVar.e(context, textPaint, bVar);
                this.f3538e = true;
            }
            c0 c0Var2 = (c0) this.f3539f.get();
            if (c0Var2 != null) {
                c0Var2.a();
                c0Var2.onStateChange(c0Var2.getState());
            }
        }
    }
}
package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class d {
    public Typeface A;
    public Typeface B;
    public Typeface C;
    public i2.b D;
    public i2.b E;
    public CharSequence G;
    public CharSequence H;
    public boolean I;
    public Bitmap K;
    public float L;
    public float M;
    public float N;
    public float O;
    public float P;
    public int Q;
    public int[] R;
    public boolean S;
    public final TextPaint T;
    public final TextPaint U;
    public TimeInterpolator V;
    public TimeInterpolator W;
    public float X;
    public float Y;
    public float Z;

    /* renamed from: a  reason: collision with root package name */
    public final View f3491a;

    /* renamed from: a0  reason: collision with root package name */
    public ColorStateList f3492a0;

    /* renamed from: b  reason: collision with root package name */
    public float f3493b;

    /* renamed from: b0  reason: collision with root package name */
    public float f3494b0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3495c;

    /* renamed from: c0  reason: collision with root package name */
    public float f3496c0;

    /* renamed from: d  reason: collision with root package name */
    public float f3497d;

    /* renamed from: d0  reason: collision with root package name */
    public float f3498d0;

    /* renamed from: e  reason: collision with root package name */
    public float f3499e;

    /* renamed from: e0  reason: collision with root package name */
    public ColorStateList f3500e0;

    /* renamed from: f  reason: collision with root package name */
    public int f3501f;

    /* renamed from: f0  reason: collision with root package name */
    public float f3502f0;

    /* renamed from: g  reason: collision with root package name */
    public final Rect f3503g;

    /* renamed from: g0  reason: collision with root package name */
    public float f3504g0;

    /* renamed from: h  reason: collision with root package name */
    public final Rect f3505h;

    /* renamed from: h0  reason: collision with root package name */
    public float f3506h0;

    /* renamed from: i  reason: collision with root package name */
    public final RectF f3507i;

    /* renamed from: i0  reason: collision with root package name */
    public StaticLayout f3508i0;

    /* renamed from: j0  reason: collision with root package name */
    public float f3510j0;

    /* renamed from: k0  reason: collision with root package name */
    public float f3512k0;

    /* renamed from: l0  reason: collision with root package name */
    public float f3514l0;

    /* renamed from: m0  reason: collision with root package name */
    public CharSequence f3516m0;

    /* renamed from: n  reason: collision with root package name */
    public ColorStateList f3517n;

    /* renamed from: o  reason: collision with root package name */
    public ColorStateList f3519o;

    /* renamed from: p  reason: collision with root package name */
    public int f3521p;

    /* renamed from: q  reason: collision with root package name */
    public float f3523q;

    /* renamed from: r  reason: collision with root package name */
    public float f3525r;

    /* renamed from: s  reason: collision with root package name */
    public float f3526s;

    /* renamed from: t  reason: collision with root package name */
    public float f3527t;

    /* renamed from: u  reason: collision with root package name */
    public float f3528u;

    /* renamed from: v  reason: collision with root package name */
    public float f3529v;

    /* renamed from: w  reason: collision with root package name */
    public Typeface f3530w;

    /* renamed from: x  reason: collision with root package name */
    public Typeface f3531x;

    /* renamed from: y  reason: collision with root package name */
    public Typeface f3532y;

    /* renamed from: z  reason: collision with root package name */
    public Typeface f3533z;

    /* renamed from: j  reason: collision with root package name */
    public int f3509j = 16;

    /* renamed from: k  reason: collision with root package name */
    public int f3511k = 16;

    /* renamed from: l  reason: collision with root package name */
    public float f3513l = 15.0f;

    /* renamed from: m  reason: collision with root package name */
    public float f3515m = 15.0f;
    public TextUtils.TruncateAt F = TextUtils.TruncateAt.END;
    public boolean J = true;

    /* renamed from: n0  reason: collision with root package name */
    public int f3518n0 = 1;

    /* renamed from: o0  reason: collision with root package name */
    public float f3520o0 = 0.0f;

    /* renamed from: p0  reason: collision with root package name */
    public float f3522p0 = 1.0f;

    /* renamed from: q0  reason: collision with root package name */
    public int f3524q0 = 1;

    public d(View view) {
        this.f3491a = view;
        TextPaint textPaint = new TextPaint(129);
        this.T = textPaint;
        this.U = new TextPaint(textPaint);
        this.f3505h = new Rect();
        this.f3503g = new Rect();
        this.f3507i = new RectF();
        float f4 = this.f3497d;
        this.f3499e = androidx.activity.j.a(1.0f, f4, 0.5f, f4);
        h(view.getContext().getResources().getConfiguration());
    }

    public static int a(int i4, float f4, int i5) {
        float f5 = 1.0f - f4;
        return Color.argb(Math.round((Color.alpha(i5) * f4) + (Color.alpha(i4) * f5)), Math.round((Color.red(i5) * f4) + (Color.red(i4) * f5)), Math.round((Color.green(i5) * f4) + (Color.green(i4) * f5)), Math.round((Color.blue(i5) * f4) + (Color.blue(i4) * f5)));
    }

    public static float g(float f4, float f5, float f6, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f6 = timeInterpolator.getInterpolation(f6);
        }
        return p1.a.a(f4, f5, f6);
    }

    public final boolean b(CharSequence charSequence) {
        g0.j jVar;
        WeakHashMap weakHashMap = y0.f4999a;
        boolean z4 = true;
        if (i0.h0.d(this.f3491a) != 1) {
            z4 = false;
        }
        if (this.J) {
            if (z4) {
                jVar = g0.k.f4785d;
            } else {
                jVar = g0.k.f4784c;
            }
            return jVar.c(charSequence, charSequence.length());
        }
        return z4;
    }

    public final void c(float f4, boolean z4) {
        boolean z5;
        float f5;
        float f6;
        Typeface typeface;
        boolean z6;
        Layout.Alignment alignment;
        boolean z7;
        boolean z8;
        boolean z9;
        StaticLayout staticLayout;
        boolean z10;
        boolean z11;
        boolean z12;
        if (this.G == null) {
            return;
        }
        float width = this.f3505h.width();
        float width2 = this.f3503g.width();
        if (Math.abs(f4 - 1.0f) < 1.0E-5f) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            f5 = this.f3515m;
            f6 = this.f3502f0;
            this.L = 1.0f;
            typeface = this.f3530w;
        } else {
            float f7 = this.f3513l;
            float f8 = this.f3504g0;
            Typeface typeface2 = this.f3533z;
            if (Math.abs(f4 - 0.0f) < 1.0E-5f) {
                this.L = 1.0f;
            } else {
                this.L = g(this.f3513l, this.f3515m, f4, this.W) / this.f3513l;
            }
            float f9 = this.f3515m / this.f3513l;
            float f10 = width2 * f9;
            if (z4 || f10 <= width) {
                width = width2;
            } else {
                width = Math.min(width / f9, width2);
            }
            f5 = f7;
            f6 = f8;
            typeface = typeface2;
        }
        int i4 = (width > 0.0f ? 1 : (width == 0.0f ? 0 : -1));
        TextPaint textPaint = this.T;
        if (i4 > 0) {
            if (this.M != f5) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (this.f3506h0 != f6) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (this.C != typeface) {
                z9 = true;
            } else {
                z9 = false;
            }
            if (this.f3508i0 != null && width != staticLayout.getWidth()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z7 && !z8 && !z10 && !z9 && !this.S) {
                z11 = false;
            } else {
                z11 = true;
            }
            this.M = f5;
            this.f3506h0 = f6;
            this.C = typeface;
            this.S = false;
            if (this.L != 1.0f) {
                z12 = true;
            } else {
                z12 = false;
            }
            textPaint.setLinearText(z12);
            z6 = z11;
        } else {
            z6 = false;
        }
        if (this.H == null || z6) {
            textPaint.setTextSize(this.M);
            textPaint.setTypeface(this.C);
            textPaint.setLetterSpacing(this.f3506h0);
            boolean b5 = b(this.G);
            this.I = b5;
            int i5 = this.f3518n0;
            if (i5 <= 1 || (b5 && !this.f3495c)) {
                i5 = 1;
            }
            if (i5 == 1) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else {
                int absoluteGravity = Gravity.getAbsoluteGravity(this.f3509j, b5 ? 1 : 0) & 7;
                if (absoluteGravity != 1) {
                    if (absoluteGravity == 5 ? !this.I : this.I) {
                        alignment = Layout.Alignment.ALIGN_OPPOSITE;
                    } else {
                        alignment = Layout.Alignment.ALIGN_NORMAL;
                    }
                } else {
                    alignment = Layout.Alignment.ALIGN_CENTER;
                }
            }
            b0 b0Var = new b0(this.G, textPaint, (int) width);
            b0Var.f3488l = this.F;
            b0Var.f3487k = b5;
            b0Var.f3481e = alignment;
            b0Var.f3486j = false;
            b0Var.f3482f = i5;
            float f11 = this.f3520o0;
            float f12 = this.f3522p0;
            b0Var.f3483g = f11;
            b0Var.f3484h = f12;
            b0Var.f3485i = this.f3524q0;
            StaticLayout a5 = b0Var.a();
            a5.getClass();
            this.f3508i0 = a5;
            this.H = a5.getText();
        }
    }

    public final void d(Canvas canvas) {
        int save = canvas.save();
        if (this.H != null) {
            RectF rectF = this.f3507i;
            if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
                TextPaint textPaint = this.T;
                textPaint.setTextSize(this.M);
                float f4 = this.f3528u;
                float f5 = this.f3529v;
                float f6 = this.L;
                if (f6 != 1.0f && !this.f3495c) {
                    canvas.scale(f6, f6, f4, f5);
                }
                if (this.f3518n0 > 1 && ((!this.I || this.f3495c) && (!this.f3495c || this.f3493b > this.f3499e))) {
                    int alpha = textPaint.getAlpha();
                    canvas.translate(this.f3528u - this.f3508i0.getLineStart(0), f5);
                    if (!this.f3495c) {
                        textPaint.setAlpha((int) (this.f3514l0 * alpha));
                        if (Build.VERSION.SDK_INT >= 31) {
                            textPaint.setShadowLayer(this.N, this.O, this.P, y1.a.a(this.Q, textPaint.getAlpha()));
                        }
                        this.f3508i0.draw(canvas);
                    }
                    if (!this.f3495c) {
                        textPaint.setAlpha((int) (this.f3512k0 * alpha));
                    }
                    int i4 = Build.VERSION.SDK_INT;
                    if (i4 >= 31) {
                        textPaint.setShadowLayer(this.N, this.O, this.P, y1.a.a(this.Q, textPaint.getAlpha()));
                    }
                    int lineBaseline = this.f3508i0.getLineBaseline(0);
                    CharSequence charSequence = this.f3516m0;
                    float f7 = lineBaseline;
                    canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f7, textPaint);
                    if (i4 >= 31) {
                        textPaint.setShadowLayer(this.N, this.O, this.P, this.Q);
                    }
                    if (!this.f3495c) {
                        String trim = this.f3516m0.toString().trim();
                        if (trim.endsWith("…")) {
                            trim = trim.substring(0, trim.length() - 1);
                        }
                        String str = trim;
                        textPaint.setAlpha(alpha);
                        canvas.drawText(str, 0, Math.min(this.f3508i0.getLineEnd(0), str.length()), 0.0f, f7, (Paint) textPaint);
                    }
                } else {
                    canvas.translate(f4, f5);
                    this.f3508i0.draw(canvas);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    public final float e() {
        TextPaint textPaint = this.U;
        textPaint.setTextSize(this.f3515m);
        textPaint.setTypeface(this.f3530w);
        textPaint.setLetterSpacing(this.f3502f0);
        return -textPaint.ascent();
    }

    public final int f(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.R;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final void h(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f3532y;
            if (typeface != null) {
                this.f3531x = i2.i.a(configuration, typeface);
            }
            Typeface typeface2 = this.B;
            if (typeface2 != null) {
                this.A = i2.i.a(configuration, typeface2);
            }
            Typeface typeface3 = this.f3531x;
            if (typeface3 == null) {
                typeface3 = this.f3532y;
            }
            this.f3530w = typeface3;
            Typeface typeface4 = this.A;
            if (typeface4 == null) {
                typeface4 = this.B;
            }
            this.f3533z = typeface4;
            i(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x023c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i(boolean r17) {
        /*
            Method dump skipped, instructions count: 607
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.d.i(boolean):void");
    }

    public final void j(ColorStateList colorStateList) {
        if (this.f3519o != colorStateList || this.f3517n != colorStateList) {
            this.f3519o = colorStateList;
            this.f3517n = colorStateList;
            i(false);
        }
    }

    public final void k(int i4) {
        View view = this.f3491a;
        i2.g gVar = new i2.g(view.getContext(), i4);
        ColorStateList colorStateList = gVar.f5059j;
        if (colorStateList != null) {
            this.f3519o = colorStateList;
        }
        float f4 = gVar.f5060k;
        if (f4 != 0.0f) {
            this.f3515m = f4;
        }
        ColorStateList colorStateList2 = gVar.f5050a;
        if (colorStateList2 != null) {
            this.f3492a0 = colorStateList2;
        }
        this.Y = gVar.f5054e;
        this.Z = gVar.f5055f;
        this.X = gVar.f5056g;
        this.f3502f0 = gVar.f5058i;
        i2.b bVar = this.E;
        if (bVar != null) {
            bVar.f5043c = true;
        }
        c cVar = new c(this, 0);
        gVar.a();
        this.E = new i2.b(cVar, gVar.f5063n);
        gVar.c(view.getContext(), this.E);
        i(false);
    }

    public final void l(int i4) {
        if (this.f3511k != i4) {
            this.f3511k = i4;
            i(false);
        }
    }

    public final boolean m(Typeface typeface) {
        i2.b bVar = this.E;
        if (bVar != null) {
            bVar.f5043c = true;
        }
        if (this.f3532y != typeface) {
            this.f3532y = typeface;
            Typeface a5 = i2.i.a(this.f3491a.getContext().getResources().getConfiguration(), typeface);
            this.f3531x = a5;
            if (a5 == null) {
                a5 = this.f3532y;
            }
            this.f3530w = a5;
            return true;
        }
        return false;
    }

    public final void n(int i4) {
        View view = this.f3491a;
        i2.g gVar = new i2.g(view.getContext(), i4);
        ColorStateList colorStateList = gVar.f5059j;
        if (colorStateList != null) {
            this.f3517n = colorStateList;
        }
        float f4 = gVar.f5060k;
        if (f4 != 0.0f) {
            this.f3513l = f4;
        }
        ColorStateList colorStateList2 = gVar.f5050a;
        if (colorStateList2 != null) {
            this.f3500e0 = colorStateList2;
        }
        this.f3496c0 = gVar.f5054e;
        this.f3498d0 = gVar.f5055f;
        this.f3494b0 = gVar.f5056g;
        this.f3504g0 = gVar.f5058i;
        i2.b bVar = this.D;
        if (bVar != null) {
            bVar.f5043c = true;
        }
        c cVar = new c(this, 1);
        gVar.a();
        this.D = new i2.b(cVar, gVar.f5063n);
        gVar.c(view.getContext(), this.D);
        i(false);
    }

    public final boolean o(Typeface typeface) {
        i2.b bVar = this.D;
        if (bVar != null) {
            bVar.f5043c = true;
        }
        if (this.B != typeface) {
            this.B = typeface;
            Typeface a5 = i2.i.a(this.f3491a.getContext().getResources().getConfiguration(), typeface);
            this.A = a5;
            if (a5 == null) {
                a5 = this.B;
            }
            this.f3533z = a5;
            return true;
        }
        return false;
    }

    public final void p(float f4) {
        float f5;
        int f6;
        float b5;
        float K = com.google.common.collect.c.K(f4, 0.0f, 1.0f);
        if (K != this.f3493b) {
            this.f3493b = K;
            boolean z4 = this.f3495c;
            RectF rectF = this.f3507i;
            Rect rect = this.f3505h;
            Rect rect2 = this.f3503g;
            if (z4) {
                if (K < this.f3499e) {
                    rect = rect2;
                }
                rectF.set(rect);
            } else {
                rectF.left = g(rect2.left, rect.left, K, this.V);
                rectF.top = g(this.f3523q, this.f3525r, K, this.V);
                rectF.right = g(rect2.right, rect.right, K, this.V);
                rectF.bottom = g(rect2.bottom, rect.bottom, K, this.V);
            }
            if (this.f3495c) {
                if (K < this.f3499e) {
                    this.f3528u = this.f3526s;
                    this.f3529v = this.f3523q;
                    q(0.0f);
                    f5 = 0.0f;
                } else {
                    this.f3528u = this.f3527t;
                    this.f3529v = this.f3525r - Math.max(0, this.f3501f);
                    q(1.0f);
                    f5 = 1.0f;
                }
            } else {
                this.f3528u = g(this.f3526s, this.f3527t, K, this.V);
                this.f3529v = g(this.f3523q, this.f3525r, K, this.V);
                q(K);
                f5 = K;
            }
            u0.b bVar = p1.a.f6129b;
            this.f3512k0 = 1.0f - g(0.0f, 1.0f, 1.0f - K, bVar);
            WeakHashMap weakHashMap = y0.f4999a;
            View view = this.f3491a;
            i0.g0.k(view);
            this.f3514l0 = g(1.0f, 0.0f, K, bVar);
            i0.g0.k(view);
            ColorStateList colorStateList = this.f3519o;
            ColorStateList colorStateList2 = this.f3517n;
            TextPaint textPaint = this.T;
            if (colorStateList != colorStateList2) {
                f6 = a(f(colorStateList2), f5, f(this.f3519o));
            } else {
                f6 = f(colorStateList);
            }
            textPaint.setColor(f6);
            float f7 = this.f3502f0;
            float f8 = this.f3504g0;
            if (f7 != f8) {
                f7 = g(f8, f7, K, bVar);
            }
            textPaint.setLetterSpacing(f7);
            this.N = g(this.f3494b0, this.X, K, null);
            this.O = g(this.f3496c0, this.Y, K, null);
            this.P = g(this.f3498d0, this.Z, K, null);
            int a5 = a(f(this.f3500e0), K, f(this.f3492a0));
            this.Q = a5;
            textPaint.setShadowLayer(this.N, this.O, this.P, a5);
            if (this.f3495c) {
                int alpha = textPaint.getAlpha();
                float f9 = this.f3499e;
                if (K <= f9) {
                    b5 = p1.a.b(1.0f, 0.0f, this.f3497d, f9, K);
                } else {
                    b5 = p1.a.b(0.0f, 1.0f, f9, 1.0f, K);
                }
                textPaint.setAlpha((int) (b5 * alpha));
            }
            i0.g0.k(view);
        }
    }

    public final void q(float f4) {
        c(f4, false);
        WeakHashMap weakHashMap = y0.f4999a;
        i0.g0.k(this.f3491a);
    }
}
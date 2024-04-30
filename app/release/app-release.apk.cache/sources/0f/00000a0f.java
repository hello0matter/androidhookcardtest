package w1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.c0;
import com.google.android.material.internal.d0;
import com.google.android.material.internal.n0;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import l2.n;

/* loaded from: classes.dex */
public final class f extends l2.j implements Drawable.Callback, c0 {
    public static final int[] G0 = {16842910};
    public static final ShapeDrawable H0 = new ShapeDrawable(new OvalShape());
    public float A;
    public ColorStateList A0;
    public ColorStateList B;
    public WeakReference B0;
    public float C;
    public TextUtils.TruncateAt C0;
    public ColorStateList D;
    public boolean D0;
    public CharSequence E;
    public int E0;
    public boolean F;
    public boolean F0;
    public Drawable G;
    public ColorStateList H;
    public float I;
    public boolean J;
    public boolean K;
    public Drawable L;
    public RippleDrawable M;
    public ColorStateList N;
    public float O;
    public SpannableStringBuilder P;
    public boolean Q;
    public boolean R;
    public Drawable S;
    public ColorStateList T;
    public p1.f U;
    public p1.f V;
    public float W;
    public float X;
    public float Y;
    public float Z;

    /* renamed from: a0  reason: collision with root package name */
    public float f7026a0;

    /* renamed from: b0  reason: collision with root package name */
    public float f7027b0;

    /* renamed from: c0  reason: collision with root package name */
    public float f7028c0;

    /* renamed from: d0  reason: collision with root package name */
    public float f7029d0;

    /* renamed from: e0  reason: collision with root package name */
    public final Context f7030e0;

    /* renamed from: f0  reason: collision with root package name */
    public final Paint f7031f0;

    /* renamed from: g0  reason: collision with root package name */
    public final Paint.FontMetrics f7032g0;

    /* renamed from: h0  reason: collision with root package name */
    public final RectF f7033h0;

    /* renamed from: i0  reason: collision with root package name */
    public final PointF f7034i0;

    /* renamed from: j0  reason: collision with root package name */
    public final Path f7035j0;

    /* renamed from: k0  reason: collision with root package name */
    public final d0 f7036k0;

    /* renamed from: l0  reason: collision with root package name */
    public int f7037l0;

    /* renamed from: m0  reason: collision with root package name */
    public int f7038m0;

    /* renamed from: n0  reason: collision with root package name */
    public int f7039n0;

    /* renamed from: o0  reason: collision with root package name */
    public int f7040o0;

    /* renamed from: p0  reason: collision with root package name */
    public int f7041p0;

    /* renamed from: q0  reason: collision with root package name */
    public int f7042q0;

    /* renamed from: r0  reason: collision with root package name */
    public boolean f7043r0;

    /* renamed from: s0  reason: collision with root package name */
    public int f7044s0;

    /* renamed from: t0  reason: collision with root package name */
    public int f7045t0;

    /* renamed from: u0  reason: collision with root package name */
    public ColorFilter f7046u0;

    /* renamed from: v0  reason: collision with root package name */
    public PorterDuffColorFilter f7047v0;

    /* renamed from: w0  reason: collision with root package name */
    public ColorStateList f7048w0;

    /* renamed from: x  reason: collision with root package name */
    public ColorStateList f7049x;

    /* renamed from: x0  reason: collision with root package name */
    public PorterDuff.Mode f7050x0;

    /* renamed from: y  reason: collision with root package name */
    public ColorStateList f7051y;

    /* renamed from: y0  reason: collision with root package name */
    public int[] f7052y0;

    /* renamed from: z  reason: collision with root package name */
    public float f7053z;

    /* renamed from: z0  reason: collision with root package name */
    public boolean f7054z0;

    public f(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4, 2131756032);
        this.A = -1.0f;
        this.f7031f0 = new Paint(1);
        this.f7032g0 = new Paint.FontMetrics();
        this.f7033h0 = new RectF();
        this.f7034i0 = new PointF();
        this.f7035j0 = new Path();
        this.f7045t0 = 255;
        this.f7050x0 = PorterDuff.Mode.SRC_IN;
        this.B0 = new WeakReference(null);
        l(context);
        this.f7030e0 = context;
        d0 d0Var = new d0(this);
        this.f7036k0 = d0Var;
        this.E = "";
        d0Var.f3534a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = G0;
        setState(iArr);
        if (!Arrays.equals(this.f7052y0, iArr)) {
            this.f7052y0 = iArr;
            if (d0()) {
                G(getState(), iArr);
            }
        }
        this.D0 = true;
        int[] iArr2 = j2.a.f5097a;
        H0.setTint(-1);
    }

    public static boolean D(ColorStateList colorStateList) {
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        return false;
    }

    public static boolean E(Drawable drawable) {
        if (drawable != null && drawable.isStateful()) {
            return true;
        }
        return false;
    }

    public static void e0(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public final float A() {
        Drawable drawable;
        if (!c0() && !b0()) {
            return 0.0f;
        }
        float f4 = this.X;
        if (this.f7043r0) {
            drawable = this.S;
        } else {
            drawable = this.G;
        }
        float f5 = this.I;
        if (f5 <= 0.0f && drawable != null) {
            f5 = drawable.getIntrinsicWidth();
        }
        return f5 + f4 + this.Y;
    }

    public final float B() {
        if (d0()) {
            return this.f7027b0 + this.O + this.f7028c0;
        }
        return 0.0f;
    }

    public final float C() {
        if (this.F0) {
            return j();
        }
        return this.A;
    }

    public final void F() {
        e eVar = (e) this.B0.get();
        if (eVar != null) {
            Chip chip = (Chip) eVar;
            chip.c(chip.f3227q);
            chip.requestLayout();
            chip.invalidateOutline();
        }
    }

    public final boolean G(int[] iArr, int[] iArr2) {
        int i4;
        int i5;
        boolean z4;
        boolean z5;
        int i6;
        int i7;
        int i8;
        boolean z6;
        boolean z7;
        int i9;
        PorterDuffColorFilter porterDuffColorFilter;
        ColorStateList colorStateList;
        boolean onStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList2 = this.f7049x;
        if (colorStateList2 != null) {
            i4 = colorStateList2.getColorForState(iArr, this.f7037l0);
        } else {
            i4 = 0;
        }
        int d4 = d(i4);
        boolean z8 = true;
        if (this.f7037l0 != d4) {
            this.f7037l0 = d4;
            onStateChange = true;
        }
        ColorStateList colorStateList3 = this.f7051y;
        if (colorStateList3 != null) {
            i5 = colorStateList3.getColorForState(iArr, this.f7038m0);
        } else {
            i5 = 0;
        }
        int d5 = d(i5);
        if (this.f7038m0 != d5) {
            this.f7038m0 = d5;
            onStateChange = true;
        }
        int c4 = b0.a.c(d5, d4);
        if (this.f7039n0 != c4) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.f5310a.f5290c == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z4 | z5) {
            this.f7039n0 = c4;
            o(ColorStateList.valueOf(c4));
            onStateChange = true;
        }
        ColorStateList colorStateList4 = this.B;
        if (colorStateList4 != null) {
            i6 = colorStateList4.getColorForState(iArr, this.f7040o0);
        } else {
            i6 = 0;
        }
        if (this.f7040o0 != i6) {
            this.f7040o0 = i6;
            onStateChange = true;
        }
        if (this.A0 != null && j2.a.d(iArr)) {
            i7 = this.A0.getColorForState(iArr, this.f7041p0);
        } else {
            i7 = 0;
        }
        if (this.f7041p0 != i7) {
            this.f7041p0 = i7;
            if (this.f7054z0) {
                onStateChange = true;
            }
        }
        i2.g gVar = this.f7036k0.f3540g;
        if (gVar != null && (colorStateList = gVar.f5059j) != null) {
            i8 = colorStateList.getColorForState(iArr, this.f7042q0);
        } else {
            i8 = 0;
        }
        if (this.f7042q0 != i8) {
            this.f7042q0 = i8;
            onStateChange = true;
        }
        int[] state = getState();
        if (state != null) {
            int length = state.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                } else if (state[i10] == 16842912) {
                    if (this.Q) {
                        z6 = true;
                    }
                } else {
                    i10++;
                }
            }
        }
        z6 = false;
        if (this.f7043r0 != z6 && this.S != null) {
            float A = A();
            this.f7043r0 = z6;
            if (A != A()) {
                onStateChange = true;
                z7 = true;
            } else {
                z7 = false;
                onStateChange = true;
            }
        } else {
            z7 = false;
        }
        ColorStateList colorStateList5 = this.f7048w0;
        if (colorStateList5 != null) {
            i9 = colorStateList5.getColorForState(iArr, this.f7044s0);
        } else {
            i9 = 0;
        }
        if (this.f7044s0 != i9) {
            this.f7044s0 = i9;
            ColorStateList colorStateList6 = this.f7048w0;
            PorterDuff.Mode mode = this.f7050x0;
            if (colorStateList6 != null && mode != null) {
                porterDuffColorFilter = new PorterDuffColorFilter(colorStateList6.getColorForState(getState(), 0), mode);
            } else {
                porterDuffColorFilter = null;
            }
            this.f7047v0 = porterDuffColorFilter;
        } else {
            z8 = onStateChange;
        }
        if (E(this.G)) {
            z8 |= this.G.setState(iArr);
        }
        if (E(this.S)) {
            z8 |= this.S.setState(iArr);
        }
        if (E(this.L)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            z8 |= this.L.setState(iArr3);
        }
        int[] iArr4 = j2.a.f5097a;
        if (E(this.M)) {
            z8 |= this.M.setState(iArr2);
        }
        if (z8) {
            invalidateSelf();
        }
        if (z7) {
            F();
        }
        return z8;
    }

    public final void H(boolean z4) {
        if (this.Q != z4) {
            this.Q = z4;
            float A = A();
            if (!z4 && this.f7043r0) {
                this.f7043r0 = false;
            }
            float A2 = A();
            invalidateSelf();
            if (A != A2) {
                F();
            }
        }
    }

    public final void I(Drawable drawable) {
        if (this.S != drawable) {
            float A = A();
            this.S = drawable;
            float A2 = A();
            e0(this.S);
            y(this.S);
            invalidateSelf();
            if (A != A2) {
                F();
            }
        }
    }

    public final void J(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.T != colorStateList) {
            this.T = colorStateList;
            if (this.R && (drawable = this.S) != null && this.Q) {
                c0.b.h(drawable, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void K(boolean z4) {
        if (this.R != z4) {
            boolean b02 = b0();
            this.R = z4;
            boolean b03 = b0();
            if (b02 != b03) {
                if (b03) {
                    y(this.S);
                } else {
                    e0(this.S);
                }
                invalidateSelf();
                F();
            }
        }
    }

    public final void L(float f4) {
        if (this.A != f4) {
            this.A = f4;
            n g4 = this.f5310a.f5288a.g();
            g4.c(f4);
            setShapeAppearanceModel(g4.a());
        }
    }

    public final void M(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.G;
        Drawable drawable4 = null;
        if (drawable3 != null) {
            drawable2 = com.google.common.collect.c.e2(drawable3);
        } else {
            drawable2 = null;
        }
        if (drawable2 != drawable) {
            float A = A();
            if (drawable != null) {
                drawable4 = drawable.mutate();
            }
            this.G = drawable4;
            float A2 = A();
            e0(drawable2);
            if (c0()) {
                y(this.G);
            }
            invalidateSelf();
            if (A != A2) {
                F();
            }
        }
    }

    public final void N(float f4) {
        if (this.I != f4) {
            float A = A();
            this.I = f4;
            float A2 = A();
            invalidateSelf();
            if (A != A2) {
                F();
            }
        }
    }

    public final void O(ColorStateList colorStateList) {
        this.J = true;
        if (this.H != colorStateList) {
            this.H = colorStateList;
            if (c0()) {
                c0.b.h(this.G, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void P(boolean z4) {
        if (this.F != z4) {
            boolean c02 = c0();
            this.F = z4;
            boolean c03 = c0();
            if (c02 != c03) {
                if (c03) {
                    y(this.G);
                } else {
                    e0(this.G);
                }
                invalidateSelf();
                F();
            }
        }
    }

    public final void Q(ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            if (this.F0) {
                t(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void R(float f4) {
        if (this.C != f4) {
            this.C = f4;
            this.f7031f0.setStrokeWidth(f4);
            if (this.F0) {
                u(f4);
            }
            invalidateSelf();
        }
    }

    public final void S(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.L;
        Drawable drawable4 = null;
        if (drawable3 != null) {
            drawable2 = com.google.common.collect.c.e2(drawable3);
        } else {
            drawable2 = null;
        }
        if (drawable2 != drawable) {
            float B = B();
            if (drawable != null) {
                drawable4 = drawable.mutate();
            }
            this.L = drawable4;
            int[] iArr = j2.a.f5097a;
            this.M = new RippleDrawable(j2.a.c(this.D), this.L, H0);
            float B2 = B();
            e0(drawable2);
            if (d0()) {
                y(this.L);
            }
            invalidateSelf();
            if (B != B2) {
                F();
            }
        }
    }

    public final void T(float f4) {
        if (this.f7028c0 != f4) {
            this.f7028c0 = f4;
            invalidateSelf();
            if (d0()) {
                F();
            }
        }
    }

    public final void U(float f4) {
        if (this.O != f4) {
            this.O = f4;
            invalidateSelf();
            if (d0()) {
                F();
            }
        }
    }

    public final void V(float f4) {
        if (this.f7027b0 != f4) {
            this.f7027b0 = f4;
            invalidateSelf();
            if (d0()) {
                F();
            }
        }
    }

    public final void W(ColorStateList colorStateList) {
        if (this.N != colorStateList) {
            this.N = colorStateList;
            if (d0()) {
                c0.b.h(this.L, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void X(boolean z4) {
        if (this.K != z4) {
            boolean d02 = d0();
            this.K = z4;
            boolean d03 = d0();
            if (d02 != d03) {
                if (d03) {
                    y(this.L);
                } else {
                    e0(this.L);
                }
                invalidateSelf();
                F();
            }
        }
    }

    public final void Y(float f4) {
        if (this.Y != f4) {
            float A = A();
            this.Y = f4;
            float A2 = A();
            invalidateSelf();
            if (A != A2) {
                F();
            }
        }
    }

    public final void Z(float f4) {
        if (this.X != f4) {
            float A = A();
            this.X = f4;
            float A2 = A();
            invalidateSelf();
            if (A != A2) {
                F();
            }
        }
    }

    @Override // l2.j, com.google.android.material.internal.c0
    public final void a() {
        F();
        invalidateSelf();
    }

    public final void a0(ColorStateList colorStateList) {
        ColorStateList colorStateList2;
        if (this.D != colorStateList) {
            this.D = colorStateList;
            if (this.f7054z0) {
                colorStateList2 = j2.a.c(colorStateList);
            } else {
                colorStateList2 = null;
            }
            this.A0 = colorStateList2;
            onStateChange(getState());
        }
    }

    public final boolean b0() {
        if (this.R && this.S != null && this.f7043r0) {
            return true;
        }
        return false;
    }

    public final boolean c0() {
        if (this.F && this.G != null) {
            return true;
        }
        return false;
    }

    public final boolean d0() {
        if (this.K && this.L != null) {
            return true;
        }
        return false;
    }

    @Override // l2.j, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i4;
        int i5;
        RectF rectF;
        int i6;
        int i7;
        int i8;
        RectF rectF2;
        boolean z4;
        int i9;
        float f4;
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && (i4 = this.f7045t0) != 0) {
            if (i4 < 255) {
                i5 = canvas.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, i4);
            } else {
                i5 = 0;
            }
            boolean z5 = this.F0;
            Paint paint = this.f7031f0;
            RectF rectF3 = this.f7033h0;
            if (!z5) {
                paint.setColor(this.f7037l0);
                paint.setStyle(Paint.Style.FILL);
                rectF3.set(bounds);
                canvas.drawRoundRect(rectF3, C(), C(), paint);
            }
            if (!this.F0) {
                paint.setColor(this.f7038m0);
                paint.setStyle(Paint.Style.FILL);
                ColorFilter colorFilter = this.f7046u0;
                if (colorFilter == null) {
                    colorFilter = this.f7047v0;
                }
                paint.setColorFilter(colorFilter);
                rectF3.set(bounds);
                canvas.drawRoundRect(rectF3, C(), C(), paint);
            }
            if (this.F0) {
                super.draw(canvas);
            }
            if (this.C > 0.0f && !this.F0) {
                paint.setColor(this.f7040o0);
                paint.setStyle(Paint.Style.STROKE);
                if (!this.F0) {
                    ColorFilter colorFilter2 = this.f7046u0;
                    if (colorFilter2 == null) {
                        colorFilter2 = this.f7047v0;
                    }
                    paint.setColorFilter(colorFilter2);
                }
                float f5 = this.C / 2.0f;
                rectF3.set(bounds.left + f5, bounds.top + f5, bounds.right - f5, bounds.bottom - f5);
                float f6 = this.A - (this.C / 2.0f);
                canvas.drawRoundRect(rectF3, f6, f6, paint);
            }
            paint.setColor(this.f7041p0);
            paint.setStyle(Paint.Style.FILL);
            rectF3.set(bounds);
            if (!this.F0) {
                canvas.drawRoundRect(rectF3, C(), C(), paint);
            } else {
                RectF rectF4 = new RectF(bounds);
                Path path = this.f7035j0;
                l2.i iVar = this.f5310a;
                this.f5327r.a(iVar.f5288a, iVar.f5297j, rectF4, this.f5326q, path);
                f(canvas, paint, path, this.f5310a.f5288a, h());
            }
            if (c0()) {
                z(bounds, rectF3);
                float f7 = rectF3.left;
                float f8 = rectF3.top;
                canvas.translate(f7, f8);
                this.G.setBounds(0, 0, (int) rectF3.width(), (int) rectF3.height());
                this.G.draw(canvas);
                canvas.translate(-f7, -f8);
            }
            if (b0()) {
                z(bounds, rectF3);
                float f9 = rectF3.left;
                float f10 = rectF3.top;
                canvas.translate(f9, f10);
                this.S.setBounds(0, 0, (int) rectF3.width(), (int) rectF3.height());
                this.S.draw(canvas);
                canvas.translate(-f9, -f10);
            }
            if (this.D0 && this.E != null) {
                PointF pointF = this.f7034i0;
                pointF.set(0.0f, 0.0f);
                Paint.Align align = Paint.Align.LEFT;
                CharSequence charSequence = this.E;
                d0 d0Var = this.f7036k0;
                if (charSequence != null) {
                    float A = A() + this.W + this.Z;
                    if (c0.c.a(this) == 0) {
                        pointF.x = bounds.left + A;
                    } else {
                        pointF.x = bounds.right - A;
                        align = Paint.Align.RIGHT;
                    }
                    TextPaint textPaint = d0Var.f3534a;
                    Paint.FontMetrics fontMetrics = this.f7032g0;
                    textPaint.getFontMetrics(fontMetrics);
                    pointF.y = bounds.centerY() - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
                }
                rectF3.setEmpty();
                if (this.E != null) {
                    float A2 = A() + this.W + this.Z;
                    float B = B() + this.f7029d0 + this.f7026a0;
                    if (c0.c.a(this) == 0) {
                        rectF3.left = bounds.left + A2;
                        f4 = bounds.right - B;
                    } else {
                        rectF3.left = bounds.left + B;
                        f4 = bounds.right - A2;
                    }
                    rectF3.right = f4;
                    rectF3.top = bounds.top;
                    rectF3.bottom = bounds.bottom;
                }
                i2.g gVar = d0Var.f3540g;
                TextPaint textPaint2 = d0Var.f3534a;
                if (gVar != null) {
                    textPaint2.drawableState = getState();
                    d0Var.f3540g.e(this.f7030e0, textPaint2, d0Var.f3535b);
                }
                textPaint2.setTextAlign(align);
                if (Math.round(d0Var.a(this.E.toString())) > Math.round(rectF3.width())) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    i9 = canvas.save();
                    canvas.clipRect(rectF3);
                } else {
                    i9 = 0;
                }
                CharSequence charSequence2 = this.E;
                if (z4 && this.C0 != null) {
                    charSequence2 = TextUtils.ellipsize(charSequence2, textPaint2, rectF3.width(), this.C0);
                }
                CharSequence charSequence3 = charSequence2;
                int length = charSequence3.length();
                float f11 = pointF.x;
                float f12 = pointF.y;
                rectF = rectF3;
                i6 = i5;
                i7 = 0;
                i8 = 255;
                canvas.drawText(charSequence3, 0, length, f11, f12, textPaint2);
                if (z4) {
                    canvas.restoreToCount(i9);
                }
            } else {
                rectF = rectF3;
                i6 = i5;
                i7 = 0;
                i8 = 255;
            }
            if (d0()) {
                rectF.setEmpty();
                if (d0()) {
                    float f13 = this.f7029d0 + this.f7028c0;
                    if (c0.c.a(this) == 0) {
                        float f14 = bounds.right - f13;
                        rectF2 = rectF;
                        rectF2.right = f14;
                        rectF2.left = f14 - this.O;
                    } else {
                        rectF2 = rectF;
                        float f15 = bounds.left + f13;
                        rectF2.left = f15;
                        rectF2.right = f15 + this.O;
                    }
                    float exactCenterY = bounds.exactCenterY();
                    float f16 = this.O;
                    float f17 = exactCenterY - (f16 / 2.0f);
                    rectF2.top = f17;
                    rectF2.bottom = f17 + f16;
                } else {
                    rectF2 = rectF;
                }
                float f18 = rectF2.left;
                float f19 = rectF2.top;
                canvas.translate(f18, f19);
                this.L.setBounds(i7, i7, (int) rectF2.width(), (int) rectF2.height());
                int[] iArr = j2.a.f5097a;
                this.M.setBounds(this.L.getBounds());
                this.M.jumpToCurrentState();
                this.M.draw(canvas);
                canvas.translate(-f18, -f19);
            }
            if (this.f7045t0 < i8) {
                canvas.restoreToCount(i6);
            }
        }
    }

    @Override // l2.j, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f7045t0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.f7046u0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.f7053z;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.min(Math.round(B() + this.f7036k0.a(this.E.toString()) + A() + this.W + this.Z + this.f7026a0 + this.f7029d0), this.E0);
    }

    @Override // l2.j, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // l2.j, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        if (this.F0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.A);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.f7053z, this.A);
        }
        outline.setAlpha(this.f7045t0 / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // l2.j, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        i2.g gVar;
        ColorStateList colorStateList;
        if (!D(this.f7049x) && !D(this.f7051y) && !D(this.B) && ((!this.f7054z0 || !D(this.A0)) && (((gVar = this.f7036k0.f3540g) == null || (colorStateList = gVar.f5059j) == null || !colorStateList.isStateful()) && ((!this.R || this.S == null || !this.Q) && !E(this.G) && !E(this.S) && !D(this.f7048w0))))) {
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i4) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i4);
        if (c0()) {
            onLayoutDirectionChanged |= c0.c.b(this.G, i4);
        }
        if (b0()) {
            onLayoutDirectionChanged |= c0.c.b(this.S, i4);
        }
        if (d0()) {
            onLayoutDirectionChanged |= c0.c.b(this.L, i4);
        }
        if (onLayoutDirectionChanged) {
            invalidateSelf();
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i4) {
        boolean onLevelChange = super.onLevelChange(i4);
        if (c0()) {
            onLevelChange |= this.G.setLevel(i4);
        }
        if (b0()) {
            onLevelChange |= this.S.setLevel(i4);
        }
        if (d0()) {
            onLevelChange |= this.L.setLevel(i4);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // l2.j, android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        if (this.F0) {
            super.onStateChange(iArr);
        }
        return G(iArr, this.f7052y0);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j4) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j4);
        }
    }

    @Override // l2.j, android.graphics.drawable.Drawable
    public final void setAlpha(int i4) {
        if (this.f7045t0 != i4) {
            this.f7045t0 = i4;
            invalidateSelf();
        }
    }

    @Override // l2.j, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f7046u0 != colorFilter) {
            this.f7046u0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // l2.j, android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.f7048w0 != colorStateList) {
            this.f7048w0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // l2.j, android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        if (this.f7050x0 != mode) {
            this.f7050x0 = mode;
            ColorStateList colorStateList = this.f7048w0;
            if (colorStateList != null && mode != null) {
                porterDuffColorFilter = new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            } else {
                porterDuffColorFilter = null;
            }
            this.f7047v0 = porterDuffColorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z4, boolean z5) {
        boolean visible = super.setVisible(z4, z5);
        if (c0()) {
            visible |= this.G.setVisible(z4, z5);
        }
        if (b0()) {
            visible |= this.S.setVisible(z4, z5);
        }
        if (d0()) {
            visible |= this.L.setVisible(z4, z5);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final void y(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        c0.c.b(drawable, c0.c.a(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.L) {
            if (drawable.isStateful()) {
                drawable.setState(this.f7052y0);
            }
            c0.b.h(drawable, this.N);
            return;
        }
        Drawable drawable2 = this.G;
        if (drawable == drawable2 && this.J) {
            c0.b.h(drawable2, this.H);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    public final void z(Rect rect, RectF rectF) {
        Drawable drawable;
        Drawable drawable2;
        rectF.setEmpty();
        if (c0() || b0()) {
            float f4 = this.W + this.X;
            if (this.f7043r0) {
                drawable = this.S;
            } else {
                drawable = this.G;
            }
            float f5 = this.I;
            if (f5 <= 0.0f && drawable != null) {
                f5 = drawable.getIntrinsicWidth();
            }
            if (c0.c.a(this) == 0) {
                float f6 = rect.left + f4;
                rectF.left = f6;
                rectF.right = f6 + f5;
            } else {
                float f7 = rect.right - f4;
                rectF.right = f7;
                rectF.left = f7 - f5;
            }
            if (this.f7043r0) {
                drawable2 = this.S;
            } else {
                drawable2 = this.G;
            }
            float f8 = this.I;
            if (f8 <= 0.0f && drawable2 != null) {
                f8 = (float) Math.ceil(n0.c(this.f7030e0, 24));
                if (drawable2.getIntrinsicHeight() <= f8) {
                    f8 = drawable2.getIntrinsicHeight();
                }
            }
            float exactCenterY = rect.exactCenterY() - (f8 / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + f8;
        }
    }
}
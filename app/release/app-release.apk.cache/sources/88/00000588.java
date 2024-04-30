package com.google.android.material.slider;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.SeekBar;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import c1.o0;
import com.example.msphone.R;
import com.google.android.material.internal.d0;
import com.google.android.material.internal.n0;
import com.google.android.material.slider.BaseSlider;
import i0.h0;
import i0.j0;
import i0.y0;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import l2.j;
import l2.n;

/* loaded from: classes.dex */
abstract class BaseSlider<S extends BaseSlider<S, L, T>, L, T> extends View {

    /* renamed from: i0  reason: collision with root package name */
    public static final /* synthetic */ int f3834i0 = 0;
    public int A;
    public int B;
    public int C;
    public int D;
    public final int E;
    public float F;
    public MotionEvent G;
    public boolean H;
    public float I;
    public float J;
    public ArrayList K;
    public int L;
    public int M;
    public float N;
    public float[] O;
    public boolean P;
    public int Q;
    public int R;
    public int S;
    public boolean T;
    public boolean U;
    public ColorStateList V;
    public ColorStateList W;

    /* renamed from: a  reason: collision with root package name */
    public final Paint f3835a;

    /* renamed from: a0  reason: collision with root package name */
    public ColorStateList f3836a0;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f3837b;

    /* renamed from: b0  reason: collision with root package name */
    public ColorStateList f3838b0;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f3839c;

    /* renamed from: c0  reason: collision with root package name */
    public ColorStateList f3840c0;

    /* renamed from: d  reason: collision with root package name */
    public final Paint f3841d;

    /* renamed from: d0  reason: collision with root package name */
    public final j f3842d0;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f3843e;

    /* renamed from: e0  reason: collision with root package name */
    public Drawable f3844e0;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f3845f;

    /* renamed from: f0  reason: collision with root package name */
    public List f3846f0;

    /* renamed from: g  reason: collision with root package name */
    public final d f3847g;

    /* renamed from: g0  reason: collision with root package name */
    public float f3848g0;

    /* renamed from: h  reason: collision with root package name */
    public final AccessibilityManager f3849h;

    /* renamed from: h0  reason: collision with root package name */
    public int f3850h0;

    /* renamed from: i  reason: collision with root package name */
    public c f3851i;

    /* renamed from: j  reason: collision with root package name */
    public final int f3852j;

    /* renamed from: k  reason: collision with root package name */
    public final ArrayList f3853k;

    /* renamed from: l  reason: collision with root package name */
    public final ArrayList f3854l;

    /* renamed from: m  reason: collision with root package name */
    public final ArrayList f3855m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f3856n;

    /* renamed from: o  reason: collision with root package name */
    public ValueAnimator f3857o;

    /* renamed from: p  reason: collision with root package name */
    public ValueAnimator f3858p;

    /* renamed from: q  reason: collision with root package name */
    public final int f3859q;

    /* renamed from: r  reason: collision with root package name */
    public final int f3860r;

    /* renamed from: s  reason: collision with root package name */
    public final int f3861s;

    /* renamed from: t  reason: collision with root package name */
    public final int f3862t;

    /* renamed from: u  reason: collision with root package name */
    public final int f3863u;

    /* renamed from: v  reason: collision with root package name */
    public final int f3864v;

    /* renamed from: w  reason: collision with root package name */
    public final int f3865w;

    /* renamed from: x  reason: collision with root package name */
    public final int f3866x;

    /* renamed from: y  reason: collision with root package name */
    public int f3867y;

    /* renamed from: z  reason: collision with root package name */
    public int f3868z;

    /* loaded from: classes.dex */
    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new Object();

        /* renamed from: a  reason: collision with root package name */
        public float f3869a;

        /* renamed from: b  reason: collision with root package name */
        public float f3870b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList f3871c;

        /* renamed from: d  reason: collision with root package name */
        public float f3872d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f3873e;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeFloat(this.f3869a);
            parcel.writeFloat(this.f3870b);
            parcel.writeList(this.f3871c);
            parcel.writeFloat(this.f3872d);
            parcel.writeBooleanArray(new boolean[]{this.f3873e});
        }
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    public final void a(Drawable drawable) {
        int i4 = this.C * 2;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawable.setBounds(0, 0, i4, i4);
            return;
        }
        float max = i4 / Math.max(intrinsicWidth, intrinsicHeight);
        drawable.setBounds(0, 0, (int) (intrinsicWidth * max), (int) (intrinsicHeight * max));
    }

    public final int b() {
        int i4 = this.f3867y / 2;
        int i5 = this.f3868z;
        int i6 = 0;
        if (i5 == 1 || i5 == 3) {
            i6 = ((q2.a) this.f3853k.get(0)).getIntrinsicHeight();
        }
        return i4 + i6;
    }

    public final ValueAnimator c(boolean z4) {
        float f4;
        ValueAnimator valueAnimator;
        int K1;
        Context context;
        Interpolator interpolator;
        int i4;
        float f5 = 1.0f;
        if (z4) {
            f4 = 0.0f;
        } else {
            f4 = 1.0f;
        }
        if (z4) {
            valueAnimator = this.f3858p;
        } else {
            valueAnimator = this.f3857o;
        }
        if (valueAnimator != null && valueAnimator.isRunning()) {
            f4 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            valueAnimator.cancel();
        }
        if (!z4) {
            f5 = 0.0f;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f4, f5);
        if (z4) {
            K1 = com.google.common.collect.c.K1(getContext(), R.attr.motionDurationMedium4, 83);
            context = getContext();
            interpolator = p1.a.f6132e;
            i4 = R.attr.motionEasingEmphasizedInterpolator;
        } else {
            K1 = com.google.common.collect.c.K1(getContext(), R.attr.motionDurationShort3, 117);
            context = getContext();
            interpolator = p1.a.f6130c;
            i4 = R.attr.motionEasingEmphasizedAccelerateInterpolator;
        }
        TimeInterpolator L1 = com.google.common.collect.c.L1(context, i4, interpolator);
        ofFloat.setDuration(K1);
        ofFloat.setInterpolator(L1);
        ofFloat.addUpdateListener(new a(this));
        return ofFloat;
    }

    public final void d(Canvas canvas, int i4, int i5, float f4, Drawable drawable) {
        canvas.save();
        canvas.translate((this.B + ((int) (n(f4) * i4))) - (drawable.getBounds().width() / 2.0f), i5 - (drawable.getBounds().height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.f3847g.m(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        this.f3835a.setColor(g(this.f3840c0));
        this.f3837b.setColor(g(this.f3838b0));
        this.f3843e.setColor(g(this.f3836a0));
        this.f3845f.setColor(g(this.W));
        Iterator it = this.f3853k.iterator();
        while (it.hasNext()) {
            q2.a aVar = (q2.a) it.next();
            if (aVar.isStateful()) {
                aVar.setState(getDrawableState());
            }
        }
        j jVar = this.f3842d0;
        if (jVar.isStateful()) {
            jVar.setState(getDrawableState());
        }
        Paint paint = this.f3841d;
        paint.setColor(g(this.V));
        paint.setAlpha(63);
    }

    public final String e(float f4) {
        return String.format(((float) ((int) f4)) == f4 ? "%.0f" : "%.2f", Float.valueOf(f4));
    }

    public final float[] f() {
        float floatValue = ((Float) Collections.max(getValues())).floatValue();
        float floatValue2 = ((Float) Collections.min(getValues())).floatValue();
        if (this.K.size() == 1) {
            floatValue2 = this.I;
        }
        float n4 = n(floatValue2);
        float n5 = n(floatValue);
        float[] fArr = new float[2];
        if (j()) {
            fArr[0] = n5;
            fArr[1] = n4;
        } else {
            fArr[0] = n4;
            fArr[1] = n5;
        }
        return fArr;
    }

    public final int g(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    @VisibleForTesting
    public final int getAccessibilityFocusedVirtualViewId() {
        return this.f3847g.f5707k;
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public float getValueFrom() {
        return this.I;
    }

    public float getValueTo() {
        return this.J;
    }

    @NonNull
    public List<Float> getValues() {
        return new ArrayList(this.K);
    }

    public final boolean h(float f4) {
        double doubleValue = new BigDecimal(Float.toString(f4)).divide(new BigDecimal(Float.toString(this.N)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(doubleValue)) - doubleValue) < 1.0E-4d;
    }

    public final boolean i(MotionEvent motionEvent) {
        if (motionEvent.getToolType(0) == 3) {
            return false;
        }
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    public final boolean j() {
        WeakHashMap weakHashMap = y0.f4999a;
        if (h0.d(this) == 1) {
            return true;
        }
        return false;
    }

    public final void k() {
        if (this.N <= 0.0f) {
            return;
        }
        x();
        int min = Math.min((int) (((this.J - this.I) / this.N) + 1.0f), (this.S / (this.A * 2)) + 1);
        float[] fArr = this.O;
        if (fArr == null || fArr.length != min * 2) {
            this.O = new float[min * 2];
        }
        float f4 = this.S / (min - 1);
        for (int i4 = 0; i4 < min * 2; i4 += 2) {
            float[] fArr2 = this.O;
            fArr2[i4] = ((i4 / 2.0f) * f4) + this.B;
            fArr2[i4 + 1] = b();
        }
    }

    public final boolean l(int i4) {
        int i5 = this.M;
        long j4 = i5 + i4;
        long size = this.K.size() - 1;
        if (j4 < 0) {
            j4 = 0;
        } else if (j4 > size) {
            j4 = size;
        }
        int i6 = (int) j4;
        this.M = i6;
        if (i6 == i5) {
            return false;
        }
        if (this.L != -1) {
            this.L = i6;
        }
        v();
        postInvalidate();
        return true;
    }

    public final void m(int i4) {
        if (j()) {
            if (i4 == Integer.MIN_VALUE) {
                i4 = Integer.MAX_VALUE;
            } else {
                i4 = -i4;
            }
        }
        l(i4);
    }

    public final float n(float f4) {
        float f5 = this.I;
        float f6 = (f4 - f5) / (this.J - f5);
        return j() ? 1.0f - f6 : f6;
    }

    public final void o() {
        Iterator it = this.f3855m.iterator();
        if (it.hasNext()) {
            androidx.activity.j.f(it.next());
            throw null;
        }
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator it = this.f3853k.iterator();
        while (it.hasNext()) {
            q2.a aVar = (q2.a) it.next();
            ViewGroup d4 = n0.d(this);
            if (d4 == null) {
                aVar.getClass();
            } else {
                aVar.getClass();
                int[] iArr = new int[2];
                d4.getLocationOnScreen(iArr);
                aVar.I = iArr[0];
                d4.getWindowVisibleDisplayFrame(aVar.C);
                d4.addOnLayoutChangeListener(aVar.B);
            }
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        c cVar = this.f3851i;
        if (cVar != null) {
            removeCallbacks(cVar);
        }
        this.f3856n = false;
        Iterator it = this.f3853k.iterator();
        while (it.hasNext()) {
            q2.a aVar = (q2.a) it.next();
            o0 e4 = n0.e(this);
            if (e4 != null) {
                int i4 = e4.f2662a;
                ViewOverlay viewOverlay = e4.f2663b;
                switch (i4) {
                    case 0:
                        viewOverlay.remove(aVar);
                        break;
                    default:
                        viewOverlay.remove(aVar);
                        break;
                }
                ViewGroup d4 = n0.d(this);
                if (d4 == null) {
                    aVar.getClass();
                } else {
                    d4.removeOnLayoutChangeListener(aVar.B);
                }
            }
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.U) {
            x();
            k();
        }
        super.onDraw(canvas);
        int b5 = b();
        int i4 = this.S;
        float[] f4 = f();
        int i5 = this.B;
        float f5 = i4;
        float f6 = i5 + (f4[1] * f5);
        float f7 = i5 + i4;
        int i6 = (f6 > f7 ? 1 : (f6 == f7 ? 0 : -1));
        Paint paint = this.f3835a;
        if (i6 < 0) {
            float f8 = b5;
            canvas.drawLine(f6, f8, f7, f8, paint);
        }
        float f9 = this.B;
        float f10 = (f4[0] * f5) + f9;
        if (f10 > f9) {
            float f11 = b5;
            canvas.drawLine(f9, f11, f10, f11, paint);
        }
        if (((Float) Collections.max(getValues())).floatValue() > this.I) {
            int i7 = this.S;
            float[] f12 = f();
            float f13 = this.B;
            float f14 = i7;
            float f15 = b5;
            canvas.drawLine((f12[0] * f14) + f13, f15, (f12[1] * f14) + f13, f15, this.f3837b);
        }
        if (this.P && this.N > 0.0f) {
            float[] f16 = f();
            int round = Math.round(f16[0] * ((this.O.length / 2) - 1));
            int round2 = Math.round(f16[1] * ((this.O.length / 2) - 1));
            float[] fArr = this.O;
            int i8 = round * 2;
            Paint paint2 = this.f3843e;
            canvas.drawPoints(fArr, 0, i8, paint2);
            int i9 = round2 * 2;
            canvas.drawPoints(this.O, i8, i9 - i8, this.f3845f);
            float[] fArr2 = this.O;
            canvas.drawPoints(fArr2, i9, fArr2.length - i9, paint2);
        }
        if ((this.H || isFocused()) && isEnabled()) {
            int i10 = this.S;
            if (!(getBackground() instanceof RippleDrawable)) {
                int n4 = (int) ((n(((Float) this.K.get(this.M)).floatValue()) * i10) + this.B);
                if (Build.VERSION.SDK_INT < 28) {
                    int i11 = this.D;
                    canvas.clipRect(n4 - i11, b5 - i11, n4 + i11, i11 + b5, Region.Op.UNION);
                }
                canvas.drawCircle(n4, b5, this.D, this.f3841d);
            }
        }
        if ((this.L != -1 || this.f3868z == 3) && isEnabled()) {
            if (this.f3868z != 2) {
                if (!this.f3856n) {
                    this.f3856n = true;
                    ValueAnimator c4 = c(true);
                    this.f3857o = c4;
                    this.f3858p = null;
                    c4.start();
                }
                ArrayList arrayList = this.f3853k;
                Iterator it = arrayList.iterator();
                for (int i12 = 0; i12 < this.K.size() && it.hasNext(); i12++) {
                    if (i12 != this.M) {
                        q((q2.a) it.next(), ((Float) this.K.get(i12)).floatValue());
                    }
                }
                if (it.hasNext()) {
                    q((q2.a) it.next(), ((Float) this.K.get(this.M)).floatValue());
                } else {
                    throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(arrayList.size()), Integer.valueOf(this.K.size())));
                }
            }
        } else if (this.f3856n) {
            this.f3856n = false;
            ValueAnimator c5 = c(false);
            this.f3858p = c5;
            this.f3857o = null;
            c5.addListener(new b(this));
            this.f3858p.start();
        }
        int i13 = this.S;
        for (int i14 = 0; i14 < this.K.size(); i14++) {
            float floatValue = ((Float) this.K.get(i14)).floatValue();
            Drawable drawable = this.f3844e0;
            if (drawable == null) {
                if (i14 < this.f3846f0.size()) {
                    drawable = (Drawable) this.f3846f0.get(i14);
                } else {
                    if (!isEnabled()) {
                        canvas.drawCircle((n(floatValue) * i13) + this.B, b5, this.C, this.f3839c);
                    }
                    drawable = this.f3842d0;
                }
            }
            d(canvas, i13, b5, floatValue, drawable);
        }
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z4, int i4, Rect rect) {
        super.onFocusChanged(z4, i4, rect);
        d dVar = this.f3847g;
        if (!z4) {
            this.L = -1;
            dVar.j(this.M);
            return;
        }
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 17) {
                    if (i4 == 66) {
                        m(Integer.MIN_VALUE);
                    }
                } else {
                    m(Integer.MAX_VALUE);
                }
            } else {
                l(Integer.MIN_VALUE);
            }
        } else {
            l(Integer.MAX_VALUE);
        }
        dVar.w(this.M);
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b7, code lost:
        if (r14 != 81) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00c9, code lost:
        if (j() != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00cb, code lost:
        r10 = -r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d1, code lost:
        if (j() != false) goto L73;
     */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onKeyDown(int r14, android.view.KeyEvent r15) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i4, KeyEvent keyEvent) {
        this.T = false;
        return super.onKeyUp(i4, keyEvent);
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6 = this.f3867y;
        int i7 = this.f3868z;
        int i8 = 0;
        if (i7 == 1 || i7 == 3) {
            i8 = ((q2.a) this.f3853k.get(0)).getIntrinsicHeight();
        }
        super.onMeasure(i4, View.MeasureSpec.makeMeasureSpec(i6 + i8, 1073741824));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.I = sliderState.f3869a;
        this.J = sliderState.f3870b;
        r(sliderState.f3871c);
        this.N = sliderState.f3872d;
        if (sliderState.f3873e) {
            requestFocus();
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View$BaseSavedState, android.os.Parcelable, com.google.android.material.slider.BaseSlider$SliderState] */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        ?? baseSavedState = new View.BaseSavedState(super.onSaveInstanceState());
        baseSavedState.f3869a = this.I;
        baseSavedState.f3870b = this.J;
        baseSavedState.f3871c = new ArrayList(this.K);
        baseSavedState.f3872d = this.N;
        baseSavedState.f3873e = hasFocus();
        return baseSavedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        this.S = Math.max(i4 - (this.B * 2), 0);
        k();
        v();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
        if (r2 != 3) goto L13;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i4) {
        o0 e4;
        super.onVisibilityChanged(view, i4);
        if (i4 == 0 || (e4 = n0.e(this)) == null) {
            return;
        }
        Iterator it = this.f3853k.iterator();
        while (it.hasNext()) {
            q2.a aVar = (q2.a) it.next();
            int i5 = e4.f2662a;
            ViewOverlay viewOverlay = e4.f2663b;
            switch (i5) {
                case 0:
                    viewOverlay.remove(aVar);
                    break;
                default:
                    viewOverlay.remove(aVar);
                    break;
            }
        }
    }

    public boolean p() {
        boolean z4;
        if (this.L != -1) {
            return true;
        }
        float f4 = this.f3848g0;
        if (j()) {
            f4 = 1.0f - f4;
        }
        float f5 = this.J;
        float f6 = this.I;
        float a5 = androidx.activity.j.a(f5, f6, f4, f6);
        float n4 = (n(a5) * this.S) + this.B;
        this.L = 0;
        float abs = Math.abs(((Float) this.K.get(0)).floatValue() - a5);
        for (int i4 = 1; i4 < this.K.size(); i4++) {
            float abs2 = Math.abs(((Float) this.K.get(i4)).floatValue() - a5);
            float n5 = (n(((Float) this.K.get(i4)).floatValue()) * this.S) + this.B;
            if (Float.compare(abs2, abs) > 1) {
                break;
            }
            if (!j() ? n5 - n4 < 0.0f : n5 - n4 > 0.0f) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (Float.compare(abs2, abs) >= 0) {
                if (Float.compare(abs2, abs) != 0) {
                    continue;
                } else if (Math.abs(n5 - n4) < this.f3859q) {
                    this.L = -1;
                    return false;
                } else if (!z4) {
                }
            }
            this.L = i4;
            abs = abs2;
        }
        if (this.L != -1) {
            return true;
        }
        return false;
    }

    public final void q(q2.a aVar, float f4) {
        String e4 = e(f4);
        if (!TextUtils.equals(aVar.f6354x, e4)) {
            aVar.f6354x = e4;
            aVar.A.f3538e = true;
            aVar.invalidateSelf();
        }
        int n4 = (this.B + ((int) (n(f4) * this.S))) - (aVar.getIntrinsicWidth() / 2);
        int b5 = b() - (this.E + this.C);
        aVar.setBounds(n4, b5 - aVar.getIntrinsicHeight(), aVar.getIntrinsicWidth() + n4, b5);
        Rect rect = new Rect(aVar.getBounds());
        com.google.android.material.internal.e.c(n0.d(this), this, rect);
        aVar.setBounds(rect);
        o0 e5 = n0.e(this);
        int i4 = e5.f2662a;
        ViewOverlay viewOverlay = e5.f2663b;
        switch (i4) {
            case 0:
                viewOverlay.add(aVar);
                return;
            default:
                viewOverlay.add(aVar);
                return;
        }
    }

    public final void r(ArrayList arrayList) {
        int i4;
        int i5;
        int i6;
        ViewGroup d4;
        int resourceId;
        o0 e4;
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            if (this.K.size() == arrayList.size() && this.K.equals(arrayList)) {
                return;
            }
            this.K = arrayList;
            int i7 = 1;
            this.U = true;
            this.M = 0;
            v();
            ArrayList arrayList2 = this.f3853k;
            if (arrayList2.size() > this.K.size()) {
                List<q2.a> subList = arrayList2.subList(this.K.size(), arrayList2.size());
                for (q2.a aVar : subList) {
                    WeakHashMap weakHashMap = y0.f4999a;
                    if (j0.b(this) && (e4 = n0.e(this)) != null) {
                        int i8 = e4.f2662a;
                        ViewOverlay viewOverlay = e4.f2663b;
                        switch (i8) {
                            case 0:
                                viewOverlay.remove(aVar);
                                break;
                            default:
                                viewOverlay.remove(aVar);
                                break;
                        }
                        ViewGroup d5 = n0.d(this);
                        if (d5 == null) {
                            aVar.getClass();
                        } else {
                            d5.removeOnLayoutChangeListener(aVar.B);
                        }
                    }
                }
                subList.clear();
            }
            while (true) {
                i2.g gVar = null;
                if (arrayList2.size() < this.K.size()) {
                    Context context = getContext();
                    int i9 = this.f3852j;
                    q2.a aVar2 = new q2.a(context, i9);
                    TypedArray d6 = com.google.android.material.internal.h0.d(aVar2.f6355y, null, o1.a.f5951h0, 0, i9, new int[0]);
                    Context context2 = aVar2.f6355y;
                    aVar2.H = context2.getResources().getDimensionPixelSize(R.dimen.mtrl_tooltip_arrowSize);
                    n g4 = aVar2.f5310a.f5288a.g();
                    g4.f5345k = aVar2.z();
                    aVar2.setShapeAppearanceModel(g4.a());
                    CharSequence text = d6.getText(6);
                    boolean equals = TextUtils.equals(aVar2.f6354x, text);
                    d0 d0Var = aVar2.A;
                    if (!equals) {
                        aVar2.f6354x = text;
                        d0Var.f3538e = true;
                        aVar2.invalidateSelf();
                    }
                    if (d6.hasValue(0) && (resourceId = d6.getResourceId(0, 0)) != 0) {
                        gVar = new i2.g(context2, resourceId);
                    }
                    if (gVar != null && d6.hasValue(1)) {
                        gVar.f5059j = i2.d.a(context2, d6, 1);
                    }
                    d0Var.c(gVar, context2);
                    TypedValue c4 = i2.c.c(R.attr.colorOnBackground, context2, q2.a.class.getCanonicalName());
                    int i10 = c4.resourceId;
                    if (i10 != 0) {
                        Object obj = z.e.f7215a;
                        i4 = z.d.a(context2, i10);
                    } else {
                        i4 = c4.data;
                    }
                    TypedValue c5 = i2.c.c(16842801, context2, q2.a.class.getCanonicalName());
                    int i11 = c5.resourceId;
                    if (i11 != 0) {
                        Object obj2 = z.e.f7215a;
                        i5 = z.d.a(context2, i11);
                    } else {
                        i5 = c5.data;
                    }
                    aVar2.o(ColorStateList.valueOf(d6.getColor(7, b0.a.c(b0.a.e(i4, 153), b0.a.e(i5, 229)))));
                    TypedValue c6 = i2.c.c(R.attr.colorSurface, context2, q2.a.class.getCanonicalName());
                    int i12 = c6.resourceId;
                    if (i12 != 0) {
                        Object obj3 = z.e.f7215a;
                        i6 = z.d.a(context2, i12);
                    } else {
                        i6 = c6.data;
                    }
                    aVar2.t(ColorStateList.valueOf(i6));
                    aVar2.D = d6.getDimensionPixelSize(2, 0);
                    aVar2.E = d6.getDimensionPixelSize(4, 0);
                    aVar2.F = d6.getDimensionPixelSize(5, 0);
                    aVar2.G = d6.getDimensionPixelSize(3, 0);
                    d6.recycle();
                    arrayList2.add(aVar2);
                    WeakHashMap weakHashMap2 = y0.f4999a;
                    if (j0.b(this) && (d4 = n0.d(this)) != null) {
                        int[] iArr = new int[2];
                        d4.getLocationOnScreen(iArr);
                        aVar2.I = iArr[0];
                        d4.getWindowVisibleDisplayFrame(aVar2.C);
                        d4.addOnLayoutChangeListener(aVar2.B);
                    }
                } else {
                    if (arrayList2.size() == 1) {
                        i7 = 0;
                    }
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((q2.a) it.next()).u(i7);
                    }
                    Iterator it2 = this.f3854l.iterator();
                    while (it2.hasNext()) {
                        androidx.activity.j.f(it2.next());
                        Iterator it3 = this.K.iterator();
                        if (it3.hasNext()) {
                            ((Float) it3.next()).getClass();
                            throw null;
                        }
                    }
                    postInvalidate();
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("At least one value must be set");
        }
    }

    public final boolean s(int i4, float f4) {
        float floatValue;
        float floatValue2;
        this.M = i4;
        if (Math.abs(f4 - ((Float) this.K.get(i4)).floatValue()) < 1.0E-4d) {
            return false;
        }
        float minSeparation = getMinSeparation();
        if (this.f3850h0 == 0) {
            if (minSeparation == 0.0f) {
                minSeparation = 0.0f;
            } else {
                float f5 = this.I;
                minSeparation = androidx.activity.j.a(f5, this.J, (minSeparation - this.B) / this.S, f5);
            }
        }
        if (j()) {
            minSeparation = -minSeparation;
        }
        int i5 = i4 + 1;
        if (i5 >= this.K.size()) {
            floatValue = this.J;
        } else {
            floatValue = ((Float) this.K.get(i5)).floatValue() - minSeparation;
        }
        int i6 = i4 - 1;
        if (i6 < 0) {
            floatValue2 = this.I;
        } else {
            floatValue2 = minSeparation + ((Float) this.K.get(i6)).floatValue();
        }
        this.K.set(i4, Float.valueOf(com.google.common.collect.c.K(f4, floatValue2, floatValue)));
        Iterator it = this.f3854l.iterator();
        if (!it.hasNext()) {
            AccessibilityManager accessibilityManager = this.f3849h;
            if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                c cVar = this.f3851i;
                if (cVar == null) {
                    this.f3851i = new c(this);
                } else {
                    removeCallbacks(cVar);
                }
                c cVar2 = this.f3851i;
                cVar2.f3880a = i4;
                postDelayed(cVar2, 200L);
                return true;
            }
            return true;
        }
        androidx.activity.j.f(it.next());
        ((Float) this.K.get(i4)).getClass();
        throw null;
    }

    public void setActiveThumbIndex(int i4) {
        this.L = i4;
    }

    public void setCustomThumbDrawable(Drawable drawable) {
        Drawable newDrawable = drawable.mutate().getConstantState().newDrawable();
        a(newDrawable);
        this.f3844e0 = newDrawable;
        this.f3846f0.clear();
        postInvalidate();
    }

    public void setCustomThumbDrawablesForValues(@NonNull @DrawableRes int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i4 = 0; i4 < iArr.length; i4++) {
            drawableArr[i4] = getResources().getDrawable(iArr[i4]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    @Override // android.view.View
    public void setEnabled(boolean z4) {
        super.setEnabled(z4);
        setLayerType(z4 ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i4) {
        if (i4 < 0 || i4 >= this.K.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.M = i4;
        this.f3847g.w(i4);
        postInvalidate();
    }

    public void setHaloRadius(int i4) {
        if (i4 == this.D) {
            return;
        }
        this.D = i4;
        Drawable background = getBackground();
        if (!(!(getBackground() instanceof RippleDrawable)) && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setRadius(this.D);
        } else {
            postInvalidate();
        }
    }

    public void setHaloTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.V)) {
            return;
        }
        this.V = colorStateList;
        Drawable background = getBackground();
        if (!(!(getBackground() instanceof RippleDrawable)) && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        int g4 = g(colorStateList);
        Paint paint = this.f3841d;
        paint.setColor(g4);
        paint.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i4) {
        if (this.f3868z != i4) {
            this.f3868z = i4;
            requestLayout();
        }
    }

    public void setSeparationUnit(int i4) {
        this.f3850h0 = i4;
        this.U = true;
        postInvalidate();
    }

    public void setStepSize(float f4) {
        if (f4 >= 0.0f) {
            if (this.N != f4) {
                this.N = f4;
                this.U = true;
                postInvalidate();
                return;
            }
            return;
        }
        float f5 = this.I;
        float f6 = this.J;
        throw new IllegalArgumentException("The stepSize(" + f4 + ") must be 0, or a factor of the valueFrom(" + f5 + ")-valueTo(" + f6 + ") range");
    }

    public void setThumbElevation(float f4) {
        this.f3842d0.n(f4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [l2.p, java.lang.Object] */
    public void setThumbRadius(int i4) {
        if (i4 == this.C) {
            return;
        }
        this.C = i4;
        l2.f b02 = com.google.common.collect.c.b0();
        l2.f b03 = com.google.common.collect.c.b0();
        l2.f b04 = com.google.common.collect.c.b0();
        l2.f b05 = com.google.common.collect.c.b0();
        float f4 = this.C;
        com.google.common.collect.c a02 = com.google.common.collect.c.a0(0);
        n.b(a02);
        n.b(a02);
        n.b(a02);
        n.b(a02);
        l2.a aVar = new l2.a(f4);
        l2.a aVar2 = new l2.a(f4);
        l2.a aVar3 = new l2.a(f4);
        l2.a aVar4 = new l2.a(f4);
        ?? obj = new Object();
        obj.f5348a = a02;
        obj.f5349b = a02;
        obj.f5350c = a02;
        obj.f5351d = a02;
        obj.f5352e = aVar;
        obj.f5353f = aVar2;
        obj.f5354g = aVar3;
        obj.f5355h = aVar4;
        obj.f5356i = b02;
        obj.f5357j = b03;
        obj.f5358k = b04;
        obj.f5359l = b05;
        j jVar = this.f3842d0;
        jVar.setShapeAppearanceModel(obj);
        int i5 = this.C * 2;
        jVar.setBounds(0, 0, i5, i5);
        Drawable drawable = this.f3844e0;
        if (drawable != null) {
            a(drawable);
        }
        for (Drawable drawable2 : this.f3846f0) {
            a(drawable2);
        }
        w();
    }

    public void setThumbStrokeColor(ColorStateList colorStateList) {
        this.f3842d0.t(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeWidth(float f4) {
        this.f3842d0.u(f4);
        postInvalidate();
    }

    public void setTickActiveRadius(int i4) {
        if (this.Q != i4) {
            this.Q = i4;
            this.f3845f.setStrokeWidth(i4 * 2);
            w();
        }
    }

    public void setTickActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.W)) {
            return;
        }
        this.W = colorStateList;
        this.f3845f.setColor(g(colorStateList));
        invalidate();
    }

    public void setTickInactiveRadius(int i4) {
        if (this.R != i4) {
            this.R = i4;
            this.f3843e.setStrokeWidth(i4 * 2);
            w();
        }
    }

    public void setTickInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f3836a0)) {
            return;
        }
        this.f3836a0 = colorStateList;
        this.f3843e.setColor(g(colorStateList));
        invalidate();
    }

    public void setTrackActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f3838b0)) {
            return;
        }
        this.f3838b0 = colorStateList;
        this.f3837b.setColor(g(colorStateList));
        invalidate();
    }

    public void setTrackHeight(int i4) {
        if (this.A != i4) {
            this.A = i4;
            this.f3835a.setStrokeWidth(i4);
            this.f3837b.setStrokeWidth(this.A);
            w();
        }
    }

    public void setTrackInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f3840c0)) {
            return;
        }
        this.f3840c0 = colorStateList;
        this.f3835a.setColor(g(colorStateList));
        invalidate();
    }

    public void setValues(@NonNull List<Float> list) {
        r(new ArrayList(list));
    }

    public final void t() {
        double d4;
        float f4;
        int i4;
        float f5 = this.f3848g0;
        float f6 = this.N;
        if (f6 > 0.0f) {
            d4 = Math.round(f5 * i4) / ((int) ((this.J - this.I) / f6));
        } else {
            d4 = f5;
        }
        if (j()) {
            d4 = 1.0d - d4;
        }
        float f7 = this.J;
        s(this.L, (float) ((d4 * (f7 - f4)) + this.I));
    }

    public final void u(int i4, Rect rect) {
        int n4 = this.B + ((int) (n(getValues().get(i4).floatValue()) * this.S));
        int b5 = b();
        int i5 = this.C;
        int i6 = this.f3865w;
        if (i5 <= i6) {
            i5 = i6;
        }
        int i7 = i5 / 2;
        rect.set(n4 - i7, b5 - i7, n4 + i7, b5 + i7);
    }

    public final void v() {
        if (!(!(getBackground() instanceof RippleDrawable)) && getMeasuredWidth() > 0) {
            Drawable background = getBackground();
            if (background instanceof RippleDrawable) {
                int n4 = (int) ((n(((Float) this.K.get(this.M)).floatValue()) * this.S) + this.B);
                int b5 = b();
                int i4 = this.D;
                c0.b.f(background, n4 - i4, b5 - i4, n4 + i4, b5 + i4);
            }
        }
    }

    public final void w() {
        boolean z4;
        int max = Math.max(this.f3866x, Math.max(this.A + getPaddingBottom() + getPaddingTop(), getPaddingBottom() + getPaddingTop() + (this.C * 2)));
        boolean z5 = false;
        if (max == this.f3867y) {
            z4 = false;
        } else {
            this.f3867y = max;
            z4 = true;
        }
        int max2 = Math.max(Math.max(Math.max(this.C - this.f3861s, 0), Math.max((this.A - this.f3862t) / 2, 0)), Math.max(Math.max(this.Q - this.f3863u, 0), Math.max(this.R - this.f3864v, 0))) + this.f3860r;
        if (this.B != max2) {
            this.B = max2;
            WeakHashMap weakHashMap = y0.f4999a;
            if (j0.c(this)) {
                this.S = Math.max(getWidth() - (this.B * 2), 0);
                k();
            }
            z5 = true;
        }
        if (z4) {
            requestLayout();
        } else if (z5) {
            postInvalidate();
        }
    }

    public final void x() {
        if (this.U) {
            float f4 = this.I;
            float f5 = this.J;
            if (f4 < f5) {
                if (f5 > f4) {
                    if (this.N > 0.0f && !h(f5 - f4)) {
                        float f6 = this.N;
                        float f7 = this.I;
                        float f8 = this.J;
                        throw new IllegalStateException("The stepSize(" + f6 + ") must be 0, or a factor of the valueFrom(" + f7 + ")-valueTo(" + f8 + ") range");
                    }
                    Iterator it = this.K.iterator();
                    while (it.hasNext()) {
                        Float f9 = (Float) it.next();
                        if (f9.floatValue() >= this.I && f9.floatValue() <= this.J) {
                            if (this.N > 0.0f && !h(f9.floatValue() - this.I)) {
                                float f10 = this.I;
                                float f11 = this.N;
                                throw new IllegalStateException("Value(" + f9 + ") must be equal to valueFrom(" + f10 + ") plus a multiple of stepSize(" + f11 + ") when using stepSize(" + f11 + ")");
                            }
                        } else {
                            float f12 = this.I;
                            float f13 = this.J;
                            throw new IllegalStateException("Slider value(" + f9 + ") must be greater or equal to valueFrom(" + f12 + "), and lower or equal to valueTo(" + f13 + ")");
                        }
                    }
                    float minSeparation = getMinSeparation();
                    if (minSeparation >= 0.0f) {
                        float f14 = this.N;
                        if (f14 > 0.0f && minSeparation > 0.0f) {
                            if (this.f3850h0 == 1) {
                                if (minSeparation < f14 || !h(minSeparation)) {
                                    float f15 = this.N;
                                    throw new IllegalStateException("minSeparation(" + minSeparation + ") must be greater or equal and a multiple of stepSize(" + f15 + ") when using stepSize(" + f15 + ")");
                                }
                            } else {
                                float f16 = this.N;
                                throw new IllegalStateException("minSeparation(" + minSeparation + ") cannot be set as a dimension when using stepSize(" + f16 + ")");
                            }
                        }
                        float f17 = this.N;
                        if (f17 != 0.0f) {
                            if (((int) f17) != f17) {
                                Log.w("BaseSlider", "Floating point value used for stepSize(" + f17 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                            }
                            float f18 = this.I;
                            if (((int) f18) != f18) {
                                Log.w("BaseSlider", "Floating point value used for valueFrom(" + f18 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                            }
                            float f19 = this.J;
                            if (((int) f19) != f19) {
                                Log.w("BaseSlider", "Floating point value used for valueTo(" + f19 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                            }
                        }
                        this.U = false;
                        return;
                    }
                    throw new IllegalStateException("minSeparation(" + minSeparation + ") must be greater or equal to 0");
                }
                float f20 = this.J;
                float f21 = this.I;
                throw new IllegalStateException("valueTo(" + f20 + ") must be greater than valueFrom(" + f21 + ")");
            }
            float f22 = this.I;
            float f23 = this.J;
            throw new IllegalStateException("valueFrom(" + f22 + ") must be smaller than valueTo(" + f23 + ")");
        }
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(p2.a.a(context, attributeSet, i4, 2131756088), attributeSet, i4);
        this.f3853k = new ArrayList();
        this.f3854l = new ArrayList();
        this.f3855m = new ArrayList();
        this.f3856n = false;
        this.H = false;
        this.K = new ArrayList();
        this.L = -1;
        this.M = -1;
        this.N = 0.0f;
        this.P = true;
        this.T = false;
        j jVar = new j();
        this.f3842d0 = jVar;
        this.f3846f0 = Collections.emptyList();
        this.f3850h0 = 0;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f3835a = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        Paint paint2 = new Paint();
        this.f3837b = paint2;
        paint2.setStyle(style);
        paint2.setStrokeCap(cap);
        Paint paint3 = new Paint(1);
        this.f3839c = paint3;
        Paint.Style style2 = Paint.Style.FILL;
        paint3.setStyle(style2);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint4 = new Paint(1);
        this.f3841d = paint4;
        paint4.setStyle(style2);
        Paint paint5 = new Paint();
        this.f3843e = paint5;
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        Paint paint6 = new Paint();
        this.f3845f = paint6;
        paint6.setStyle(style);
        paint6.setStrokeCap(cap);
        Resources resources = context2.getResources();
        this.f3866x = resources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.f3860r = dimensionPixelOffset;
        this.B = dimensionPixelOffset;
        this.f3861s = resources.getDimensionPixelSize(R.dimen.mtrl_slider_thumb_radius);
        this.f3862t = resources.getDimensionPixelSize(R.dimen.mtrl_slider_track_height);
        this.f3863u = resources.getDimensionPixelSize(R.dimen.mtrl_slider_tick_radius);
        this.f3864v = resources.getDimensionPixelSize(R.dimen.mtrl_slider_tick_radius);
        this.E = resources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
        int[] iArr = o1.a.Y;
        com.google.android.material.internal.h0.a(context2, attributeSet, i4, 2131756088);
        com.google.android.material.internal.h0.b(context2, attributeSet, iArr, i4, 2131756088, new int[0]);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i4, 2131756088);
        this.f3852j = obtainStyledAttributes.getResourceId(8, 2131756122);
        this.I = obtainStyledAttributes.getFloat(3, 0.0f);
        this.J = obtainStyledAttributes.getFloat(4, 1.0f);
        setValues(Float.valueOf(this.I));
        this.N = obtainStyledAttributes.getFloat(2, 0.0f);
        this.f3865w = (int) Math.ceil(obtainStyledAttributes.getDimension(9, (float) Math.ceil(n0.c(getContext(), 48))));
        boolean hasValue = obtainStyledAttributes.hasValue(21);
        int i5 = hasValue ? 21 : 23;
        int i6 = hasValue ? 21 : 22;
        ColorStateList a5 = i2.d.a(context2, obtainStyledAttributes, i5);
        setTrackInactiveTintList(a5 == null ? z.e.b(context2, R.color.material_slider_inactive_track_color) : a5);
        ColorStateList a6 = i2.d.a(context2, obtainStyledAttributes, i6);
        setTrackActiveTintList(a6 == null ? z.e.b(context2, R.color.material_slider_active_track_color) : a6);
        jVar.o(i2.d.a(context2, obtainStyledAttributes, 10));
        if (obtainStyledAttributes.hasValue(13)) {
            setThumbStrokeColor(i2.d.a(context2, obtainStyledAttributes, 13));
        }
        setThumbStrokeWidth(obtainStyledAttributes.getDimension(14, 0.0f));
        ColorStateList a7 = i2.d.a(context2, obtainStyledAttributes, 5);
        setHaloTintList(a7 == null ? z.e.b(context2, R.color.material_slider_halo_color) : a7);
        this.P = obtainStyledAttributes.getBoolean(20, true);
        boolean hasValue2 = obtainStyledAttributes.hasValue(15);
        int i7 = hasValue2 ? 15 : 17;
        int i8 = hasValue2 ? 15 : 16;
        ColorStateList a8 = i2.d.a(context2, obtainStyledAttributes, i7);
        setTickInactiveTintList(a8 == null ? z.e.b(context2, R.color.material_slider_inactive_tick_marks_color) : a8);
        ColorStateList a9 = i2.d.a(context2, obtainStyledAttributes, i8);
        setTickActiveTintList(a9 == null ? z.e.b(context2, R.color.material_slider_active_tick_marks_color) : a9);
        setThumbRadius(obtainStyledAttributes.getDimensionPixelSize(12, 0));
        setHaloRadius(obtainStyledAttributes.getDimensionPixelSize(6, 0));
        setThumbElevation(obtainStyledAttributes.getDimension(11, 0.0f));
        setTrackHeight(obtainStyledAttributes.getDimensionPixelSize(24, 0));
        setTickActiveRadius(obtainStyledAttributes.getDimensionPixelSize(18, 0));
        setTickInactiveRadius(obtainStyledAttributes.getDimensionPixelSize(19, 0));
        setLabelBehavior(obtainStyledAttributes.getInt(7, 0));
        if (!obtainStyledAttributes.getBoolean(0, true)) {
            setEnabled(false);
        }
        obtainStyledAttributes.recycle();
        setFocusable(true);
        setClickable(true);
        jVar.s(2);
        this.f3859q = ViewConfiguration.get(context2).getScaledTouchSlop();
        d dVar = new d(this);
        this.f3847g = dVar;
        y0.p(this, dVar);
        this.f3849h = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    public void setCustomThumbDrawablesForValues(@NonNull Drawable... drawableArr) {
        this.f3844e0 = null;
        this.f3846f0 = new ArrayList();
        for (Drawable drawable : drawableArr) {
            List list = this.f3846f0;
            Drawable newDrawable = drawable.mutate().getConstantState().newDrawable();
            a(newDrawable);
            list.add(newDrawable);
        }
        postInvalidate();
    }

    public void setValues(@NonNull Float... fArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fArr);
        r(arrayList);
    }
}
package com.google.android.material.timepicker;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Nullable;
import com.example.msphone.R;
import com.google.android.material.internal.n0;
import i0.g0;
import i0.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ClockHandView extends View {

    /* renamed from: a  reason: collision with root package name */
    public final ValueAnimator f4134a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4135b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f4136c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4137d;

    /* renamed from: e  reason: collision with root package name */
    public final float f4138e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f4139f;

    /* renamed from: g  reason: collision with root package name */
    public final RectF f4140g;

    /* renamed from: h  reason: collision with root package name */
    public final int f4141h;

    /* renamed from: i  reason: collision with root package name */
    public float f4142i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f4143j;

    /* renamed from: k  reason: collision with root package name */
    public double f4144k;

    /* renamed from: l  reason: collision with root package name */
    public int f4145l;

    /* renamed from: m  reason: collision with root package name */
    public int f4146m;

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    public final int a(int i4) {
        return i4 == 2 ? Math.round(this.f4145l * 0.66f) : this.f4145l;
    }

    public final void b(float f4) {
        ValueAnimator valueAnimator = this.f4134a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        c(f4);
    }

    public final void c(float f4) {
        float f5 = f4 % 360.0f;
        this.f4142i = f5;
        this.f4144k = Math.toRadians(f5 - 90.0f);
        float a5 = a(this.f4146m);
        float cos = (((float) Math.cos(this.f4144k)) * a5) + (getWidth() / 2);
        float sin = (a5 * ((float) Math.sin(this.f4144k))) + (getHeight() / 2);
        float f6 = this.f4137d;
        this.f4140g.set(cos - f6, sin - f6, cos + f6, sin + f6);
        Iterator it = this.f4136c.iterator();
        while (it.hasNext()) {
            ClockFaceView clockFaceView = (ClockFaceView) ((d) it.next());
            if (Math.abs(clockFaceView.G - f5) > 0.001f) {
                clockFaceView.G = f5;
                clockFaceView.p();
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int a5;
        int i4;
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f4 = width;
        float a6 = a(this.f4146m);
        float f5 = height;
        Paint paint = this.f4139f;
        paint.setStrokeWidth(0.0f);
        canvas.drawCircle((((float) Math.cos(this.f4144k)) * a6) + f4, (a6 * ((float) Math.sin(this.f4144k))) + f5, this.f4137d, paint);
        double sin = Math.sin(this.f4144k);
        paint.setStrokeWidth(this.f4141h);
        canvas.drawLine(f4, f5, width + ((int) (Math.cos(this.f4144k) * r12)), height + ((int) (r12 * sin)), paint);
        canvas.drawCircle(f4, f5, this.f4138e, paint);
    }

    @Override // android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        if (!this.f4134a.isRunning()) {
            b(this.f4142i);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z4;
        boolean z5;
        boolean z6;
        int i4;
        int actionMasked = motionEvent.getActionMasked();
        float x4 = motionEvent.getX();
        float y4 = motionEvent.getY();
        boolean z7 = false;
        if (actionMasked != 0) {
            if (actionMasked != 1 && actionMasked != 2) {
                z5 = false;
                z4 = false;
            } else {
                z5 = this.f4143j;
                if (this.f4135b) {
                    if (com.google.common.collect.c.i0(getWidth() / 2, getHeight() / 2, x4, y4) <= a(2) + n0.c(getContext(), 12)) {
                        i4 = 2;
                    } else {
                        i4 = 1;
                    }
                    this.f4146m = i4;
                }
                z4 = false;
            }
        } else {
            this.f4143j = false;
            z4 = true;
            z5 = false;
        }
        boolean z8 = this.f4143j;
        int degrees = (int) Math.toDegrees(Math.atan2(y4 - (getHeight() / 2), x4 - (getWidth() / 2)));
        int i5 = degrees + 90;
        if (i5 < 0) {
            i5 = degrees + 450;
        }
        float f4 = i5;
        if (this.f4142i != f4) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (!z4 || !z6) {
            if (z6 || z5) {
                b(f4);
            }
            this.f4143j = z8 | z7;
            return true;
        }
        z7 = true;
        this.f4143j = z8 | z7;
        return true;
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f4134a = new ValueAnimator();
        this.f4136c = new ArrayList();
        Paint paint = new Paint();
        this.f4139f = paint;
        this.f4140g = new RectF();
        this.f4146m = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o1.a.f5956m, i4, 2131756110);
        com.google.common.collect.c.K1(context, R.attr.motionDurationLong2, 200);
        com.google.common.collect.c.L1(context, R.attr.motionEasingEmphasizedInterpolator, p1.a.f6129b);
        this.f4145l = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f4137d = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        Resources resources = getResources();
        this.f4141h = resources.getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.f4138e = resources.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = obtainStyledAttributes.getColor(0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        b(0.0f);
        ViewConfiguration.get(context).getScaledTouchSlop();
        WeakHashMap weakHashMap = y0.f4999a;
        g0.s(this, 2);
        obtainStyledAttributes.recycle();
    }
}
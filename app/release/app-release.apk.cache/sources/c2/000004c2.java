package com.google.android.material.carousel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.common.collect.c;
import i1.b;
import l2.a0;
import l2.b0;
import l2.c0;
import l2.d0;
import l2.p;
import l2.q;
import p1.a;
import v1.l;
import v1.n;

/* loaded from: classes.dex */
public class MaskableFrameLayout extends FrameLayout implements l, a0 {

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ int f3183f = 0;

    /* renamed from: a  reason: collision with root package name */
    public float f3184a;

    /* renamed from: b  reason: collision with root package name */
    public final RectF f3185b;

    /* renamed from: c  reason: collision with root package name */
    public p f3186c;

    /* renamed from: d  reason: collision with root package name */
    public final b0 f3187d;

    /* renamed from: e  reason: collision with root package name */
    public Boolean f3188e;

    public MaskableFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        b0 b0Var = this.f3187d;
        if (b0Var.b()) {
            Path path = b0Var.f5280e;
            if (!path.isEmpty()) {
                canvas.save();
                canvas.clipPath(path);
                super.dispatchDraw(canvas);
                canvas.restore();
                return;
            }
        }
        super.dispatchDraw(canvas);
    }

    @NonNull
    public RectF getMaskRectF() {
        return this.f3185b;
    }

    @Deprecated
    public float getMaskXPercentage() {
        return this.f3184a;
    }

    @NonNull
    public p getShapeAppearanceModel() {
        return this.f3186c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Boolean bool = this.f3188e;
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            b0 b0Var = this.f3187d;
            if (booleanValue != b0Var.f5276a) {
                b0Var.f5276a = booleanValue;
                b0Var.a(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        b0 b0Var = this.f3187d;
        this.f3188e = Boolean.valueOf(b0Var.f5276a);
        if (true != b0Var.f5276a) {
            b0Var.f5276a = true;
            b0Var.a(this);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        p pVar;
        super.onSizeChanged(i4, i5, i6, i7);
        if (getWidth() != 0) {
            RectF rectF = this.f3185b;
            b0 b0Var = this.f3187d;
            b0Var.f5279d = rectF;
            if (!rectF.isEmpty() && (pVar = b0Var.f5278c) != null) {
                q.f5360a.a(pVar, 1.0f, b0Var.f5279d, null, b0Var.f5280e);
            }
            b0Var.a(this);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        RectF rectF = this.f3185b;
        if (rectF.isEmpty() || motionEvent.getAction() != 0 || rectF.contains(motionEvent.getX(), motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.f170b})
    @VisibleForTesting
    public void setForceCompatClipping(boolean z4) {
        b0 b0Var = this.f3187d;
        if (z4 != b0Var.f5276a) {
            b0Var.f5276a = z4;
            b0Var.a(this);
        }
    }

    @Override // v1.l
    public void setMaskRectF(@NonNull RectF rectF) {
        p pVar;
        RectF rectF2 = this.f3185b;
        rectF2.set(rectF);
        if (getWidth() != 0) {
            b0 b0Var = this.f3187d;
            b0Var.f5279d = rectF2;
            if (!rectF2.isEmpty() && (pVar = b0Var.f5278c) != null) {
                q.f5360a.a(pVar, 1.0f, b0Var.f5279d, null, b0Var.f5280e);
            }
            b0Var.a(this);
        }
    }

    @Deprecated
    public void setMaskXPercentage(float f4) {
        float K = c.K(f4, 0.0f, 1.0f);
        if (this.f3184a != K) {
            this.f3184a = K;
            float b5 = a.b(0.0f, getWidth() / 2.0f, 0.0f, 1.0f, this.f3184a);
            setMaskRectF(new RectF(b5, 0.0f, getWidth() - b5, getHeight()));
        }
    }

    @Override // l2.a0
    public void setShapeAppearanceModel(@NonNull p pVar) {
        p pVar2;
        p h4 = pVar.h(new b(1));
        this.f3186c = h4;
        b0 b0Var = this.f3187d;
        b0Var.f5278c = h4;
        if (!b0Var.f5279d.isEmpty() && (pVar2 = b0Var.f5278c) != null) {
            q.f5360a.a(pVar2, 1.0f, b0Var.f5279d, null, b0Var.f5280e);
        }
        b0Var.a(this);
    }

    public MaskableFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskableFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f3184a = 0.0f;
        this.f3185b = new RectF();
        this.f3187d = Build.VERSION.SDK_INT >= 33 ? new d0(this) : new c0(this);
        this.f3188e = null;
        setShapeAppearanceModel(p.c(context, attributeSet, i4, 0).a());
    }

    public void setOnMaskChangedListener(@Nullable n nVar) {
    }
}
package com.google.android.material.circularreveal.coordinatorlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import x1.b;
import x1.f;
import x1.g;

/* loaded from: classes.dex */
public class CircularRevealCoordinatorLayout extends CoordinatorLayout implements g {

    /* renamed from: y  reason: collision with root package name */
    public final b f3245y;

    public CircularRevealCoordinatorLayout(@NonNull Context context) {
        this(context, null);
    }

    @Override // x1.a
    public final void a(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // x1.g
    public final void c() {
        this.f3245y.getClass();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        b bVar = this.f3245y;
        if (bVar != null) {
            bVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // x1.g
    public final void g() {
        this.f3245y.getClass();
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.f3245y.f7134e;
    }

    @Override // x1.g
    public int getCircularRevealScrimColor() {
        return this.f3245y.f7132c.getColor();
    }

    @Override // x1.g
    @Nullable
    public f getRevealInfo() {
        return this.f3245y.b();
    }

    @Override // x1.a
    public final boolean h() {
        return super.isOpaque();
    }

    @Override // android.view.View
    public final boolean isOpaque() {
        b bVar = this.f3245y;
        return bVar != null ? bVar.c() : super.isOpaque();
    }

    @Override // x1.g
    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        this.f3245y.d(drawable);
    }

    @Override // x1.g
    public void setCircularRevealScrimColor(@ColorInt int i4) {
        this.f3245y.e(i4);
    }

    @Override // x1.g
    public void setRevealInfo(@Nullable f fVar) {
        this.f3245y.f(fVar);
    }

    public CircularRevealCoordinatorLayout(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3245y = new b(this);
    }
}
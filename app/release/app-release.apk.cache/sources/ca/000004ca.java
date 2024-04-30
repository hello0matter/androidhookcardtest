package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import x1.b;
import x1.f;
import x1.g;

/* loaded from: classes.dex */
public class CircularRevealFrameLayout extends FrameLayout implements g {

    /* renamed from: a  reason: collision with root package name */
    public final b f3240a;

    public CircularRevealFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    @Override // x1.a
    public final void a(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // x1.g
    public final void c() {
        this.f3240a.getClass();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        b bVar = this.f3240a;
        if (bVar != null) {
            bVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // x1.g
    public final void g() {
        this.f3240a.getClass();
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.f3240a.f7134e;
    }

    @Override // x1.g
    public int getCircularRevealScrimColor() {
        return this.f3240a.f7132c.getColor();
    }

    @Override // x1.g
    @Nullable
    public f getRevealInfo() {
        return this.f3240a.b();
    }

    @Override // x1.a
    public final boolean h() {
        return super.isOpaque();
    }

    @Override // android.view.View
    public final boolean isOpaque() {
        b bVar = this.f3240a;
        return bVar != null ? bVar.c() : super.isOpaque();
    }

    @Override // x1.g
    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        this.f3240a.d(drawable);
    }

    @Override // x1.g
    public void setCircularRevealScrimColor(@ColorInt int i4) {
        this.f3240a.e(i4);
    }

    @Override // x1.g
    public void setRevealInfo(@Nullable f fVar) {
        this.f3240a.f(fVar);
    }

    public CircularRevealFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3240a = new b(this);
    }
}
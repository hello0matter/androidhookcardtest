package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.f170b})
/* loaded from: classes.dex */
public class ClippableRoundedCornerLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public Path f3443a;

    /* renamed from: b  reason: collision with root package name */
    public float f3444b;

    public ClippableRoundedCornerLayout(@NonNull Context context) {
        super(context);
    }

    public final void a(float f4, float f5, float f6, float f7, float f8) {
        RectF rectF = new RectF(f4, f5, f6, f7);
        if (this.f3443a == null) {
            this.f3443a = new Path();
        }
        this.f3444b = f8;
        this.f3443a.reset();
        this.f3443a.addRoundRect(rectF, f8, f8, Path.Direction.CW);
        this.f3443a.close();
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        if (this.f3443a == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.clipPath(this.f3443a);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    public float getCornerRadius() {
        return this.f3444b;
    }

    public ClippableRoundedCornerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ClippableRoundedCornerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }
}
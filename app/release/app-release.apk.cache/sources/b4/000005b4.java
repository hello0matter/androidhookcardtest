package com.google.android.material.textfield;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public abstract class g extends l2.j {

    /* renamed from: y  reason: collision with root package name */
    public static final /* synthetic */ int f4029y = 0;

    /* renamed from: x  reason: collision with root package name */
    public e f4030x;

    public g(e eVar) {
        super(eVar);
        this.f4030x = eVar;
    }

    @Override // l2.j, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.f4030x = new e(this.f4030x);
        return this;
    }

    public final void y(float f4, float f5, float f6, float f7) {
        RectF rectF = this.f4030x.f4028v;
        if (f4 != rectF.left || f5 != rectF.top || f6 != rectF.right || f7 != rectF.bottom) {
            rectF.set(f4, f5, f6, f7);
            invalidateSelf();
        }
    }
}
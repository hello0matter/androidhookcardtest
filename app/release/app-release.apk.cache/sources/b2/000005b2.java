package com.google.android.material.textfield;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class e extends l2.i {

    /* renamed from: v  reason: collision with root package name */
    public final RectF f4028v;

    public e(e eVar) {
        super(eVar);
        this.f4028v = eVar.f4028v;
    }

    @Override // l2.i, android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        g gVar = new g(this);
        gVar.invalidateSelf();
        return gVar;
    }

    public e(l2.p pVar, RectF rectF) {
        super(pVar);
        this.f4028v = rectF;
    }
}
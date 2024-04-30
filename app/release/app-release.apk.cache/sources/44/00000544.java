package com.google.android.material.internal;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* loaded from: classes.dex */
public final class y implements TypeEvaluator {

    /* renamed from: a  reason: collision with root package name */
    public final Rect f3603a;

    public y(Rect rect) {
        this.f3603a = rect;
    }

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f4, Object obj, Object obj2) {
        Rect rect = (Rect) obj;
        Rect rect2 = (Rect) obj2;
        int i4 = rect.left;
        int i5 = i4 + ((int) ((rect2.left - i4) * f4));
        int i6 = rect.top;
        int i7 = i6 + ((int) ((rect2.top - i6) * f4));
        int i8 = rect.right;
        int i9 = rect.bottom;
        int i10 = i9 + ((int) ((rect2.bottom - i9) * f4));
        Rect rect3 = this.f3603a;
        rect3.set(i5, i7, i8 + ((int) ((rect2.right - i8) * f4)), i10);
        return rect3;
    }
}
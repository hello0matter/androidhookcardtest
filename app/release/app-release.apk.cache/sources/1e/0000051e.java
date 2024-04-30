package com.google.android.material.internal;

import android.animation.ValueAnimator;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f3474a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public ValueAnimator f3475b = null;

    /* renamed from: c  reason: collision with root package name */
    public final androidx.appcompat.widget.e f3476c = new androidx.appcompat.widget.e(6, this);

    public final void a(int[] iArr, ValueAnimator valueAnimator) {
        androidx.fragment.app.m0 m0Var = new androidx.fragment.app.m0(iArr, valueAnimator);
        valueAnimator.addListener(this.f3476c);
        this.f3474a.add(m0Var);
    }
}
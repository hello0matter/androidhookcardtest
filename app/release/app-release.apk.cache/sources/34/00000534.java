package com.google.android.material.internal;

import android.view.View;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class l0 implements View.OnAttachStateChangeListener {
    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        view.removeOnAttachStateChangeListener(this);
        WeakHashMap weakHashMap = y0.f4999a;
        i0.k0.c(view);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
package com.google.android.material.internal;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import i0.n2;
import i0.y0;

/* loaded from: classes.dex */
public final /* synthetic */ class j0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f3556a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f3557b = false;

    public /* synthetic */ j0(View view) {
        this.f3556a = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n2 h4;
        View view = this.f3556a;
        if (this.f3557b && (h4 = y0.h(view)) != null) {
            h4.f4959a.s();
            return;
        }
        Context context = view.getContext();
        Object obj = z.e.f7215a;
        ((InputMethodManager) z.d.b(context, InputMethodManager.class)).showSoftInput(view, 1);
    }
}
package com.google.android.material.appbar;

import android.view.View;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public final View f2969a;

    /* renamed from: b  reason: collision with root package name */
    public int f2970b;

    /* renamed from: c  reason: collision with root package name */
    public int f2971c;

    /* renamed from: d  reason: collision with root package name */
    public int f2972d;

    public m(View view) {
        this.f2969a = view;
    }

    public final void a() {
        int i4 = this.f2972d;
        View view = this.f2969a;
        int top = i4 - (view.getTop() - this.f2970b);
        WeakHashMap weakHashMap = y0.f4999a;
        view.offsetTopAndBottom(top);
        view.offsetLeftAndRight(0 - (view.getLeft() - this.f2971c));
    }

    public final boolean b(int i4) {
        if (this.f2972d != i4) {
            this.f2972d = i4;
            a();
            return true;
        }
        return false;
    }
}
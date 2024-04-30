package com.google.android.material.internal;

import android.view.View;

/* loaded from: classes.dex */
public final class n extends i0.c {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f3564d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f3565e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ o f3566f;

    public n(o oVar, int i4, boolean z4) {
        this.f3566f = oVar;
        this.f3564d = i4;
        this.f3565e = z4;
    }

    @Override // i0.c
    public final void d(View view, j0.h hVar) {
        this.f4912a.onInitializeAccessibilityNodeInfo(view, hVar.f5093a);
        int i4 = this.f3564d;
        int i5 = 0;
        int i6 = i4;
        while (true) {
            o oVar = this.f3566f;
            if (i5 < i4) {
                w wVar = oVar.f3570f;
                if (wVar.f3581e.c(i5) == 2 || wVar.f3581e.c(i5) == 3) {
                    i6--;
                }
                i5++;
            } else {
                oVar.getClass();
                hVar.h(androidx.recyclerview.widget.i0.i(i6, 1, 1, 1, this.f3565e, view.isSelected()));
                return;
            }
        }
    }
}
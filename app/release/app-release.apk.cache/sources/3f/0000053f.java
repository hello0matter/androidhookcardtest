package com.google.android.material.internal;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.n1;

/* loaded from: classes.dex */
public final class t extends n1 {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ w f3576f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(w wVar, NavigationMenuView navigationMenuView) {
        super(navigationMenuView);
        this.f3576f = wVar;
    }

    @Override // androidx.recyclerview.widget.n1, i0.c
    public final void d(View view, j0.h hVar) {
        super.d(view, hVar);
        o oVar = this.f3576f.f3581e;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            w wVar = oVar.f3570f;
            if (i4 < wVar.f3581e.f3567c.size()) {
                int c4 = wVar.f3581e.c(i4);
                if (c4 == 0 || c4 == 1) {
                    i5++;
                }
                i4++;
            } else {
                hVar.f5093a.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(i5, 1, false));
                return;
            }
        }
    }
}
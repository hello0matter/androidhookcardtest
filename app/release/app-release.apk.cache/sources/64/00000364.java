package androidx.viewpager2.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.b1;
import androidx.recyclerview.widget.i1;

/* loaded from: classes.dex */
public final class i extends LinearLayoutManager {
    public final /* synthetic */ ViewPager2 E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(ViewPager2 viewPager2) {
        super(1);
        this.E = viewPager2;
    }

    @Override // androidx.recyclerview.widget.u0
    public final void R(b1 b1Var, i1 i1Var, j0.h hVar) {
        super.R(b1Var, i1Var, hVar);
        this.E.f2452t.getClass();
    }

    @Override // androidx.recyclerview.widget.u0
    public final boolean e0(b1 b1Var, i1 i1Var, int i4, Bundle bundle) {
        this.E.f2452t.getClass();
        return super.e0(b1Var, i1Var, i4, bundle);
    }

    @Override // androidx.recyclerview.widget.u0
    public final boolean j0(RecyclerView recyclerView, View view, Rect rect, boolean z4, boolean z5) {
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void z0(i1 i1Var, int[] iArr) {
        ViewPager2 viewPager2 = this.E;
        int offscreenPageLimit = viewPager2.getOffscreenPageLimit();
        if (offscreenPageLimit == -1) {
            super.z0(i1Var, iArr);
            return;
        }
        int pageSize = viewPager2.getPageSize() * offscreenPageLimit;
        iArr[0] = pageSize;
        iArr[1] = pageSize;
    }
}
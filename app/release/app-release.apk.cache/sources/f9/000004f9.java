package com.google.android.material.datepicker;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.q0;
import java.util.Calendar;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class p extends q0 {

    /* renamed from: a  reason: collision with root package name */
    public final Calendar f3354a = g0.g(null);

    /* renamed from: b  reason: collision with root package name */
    public final Calendar f3355b = g0.g(null);

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MaterialCalendar f3356c;

    public p(MaterialCalendar materialCalendar) {
        this.f3356c = materialCalendar;
    }

    @Override // androidx.recyclerview.widget.q0
    public final void b(Canvas canvas, RecyclerView recyclerView) {
        Object obj;
        int i4;
        int width;
        if ((recyclerView.getAdapter() instanceof j0) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            j0 j0Var = (j0) recyclerView.getAdapter();
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            MaterialCalendar materialCalendar = this.f3356c;
            Iterator it = materialCalendar.U.e().iterator();
            while (it.hasNext()) {
                h0.c cVar = (h0.c) it.next();
                Object obj2 = cVar.f4797a;
                if (obj2 != null && (obj = cVar.f4798b) != null) {
                    long longValue = ((Long) obj2).longValue();
                    Calendar calendar = this.f3354a;
                    calendar.setTimeInMillis(longValue);
                    long longValue2 = ((Long) obj).longValue();
                    Calendar calendar2 = this.f3355b;
                    calendar2.setTimeInMillis(longValue2);
                    int i5 = calendar.get(1) - j0Var.f3343c.V.f3246a.f3292c;
                    int i6 = calendar2.get(1) - j0Var.f3343c.V.f3246a.f3292c;
                    View q4 = gridLayoutManager.q(i5);
                    View q5 = gridLayoutManager.q(i6);
                    int i7 = gridLayoutManager.F;
                    int i8 = i5 / i7;
                    int i9 = i6 / i7;
                    for (int i10 = i8; i10 <= i9; i10++) {
                        View q6 = gridLayoutManager.q(gridLayoutManager.F * i10);
                        if (q6 != null) {
                            int top = ((Rect) materialCalendar.Z.f3314d.f926b).top + q6.getTop();
                            int bottom = q6.getBottom() - ((Rect) materialCalendar.Z.f3314d.f926b).bottom;
                            if (i10 == i8 && q4 != null) {
                                i4 = (q4.getWidth() / 2) + q4.getLeft();
                            } else {
                                i4 = 0;
                            }
                            if (i10 == i9 && q5 != null) {
                                width = (q5.getWidth() / 2) + q5.getLeft();
                            } else {
                                width = recyclerView.getWidth();
                            }
                            canvas.drawRect(i4, top, width, bottom, materialCalendar.Z.f3318h);
                        }
                    }
                }
            }
        }
    }
}
package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2317a;

    /* renamed from: b  reason: collision with root package name */
    public int f2318b;

    /* renamed from: c  reason: collision with root package name */
    public int f2319c;

    /* renamed from: d  reason: collision with root package name */
    public int f2320d;

    /* renamed from: e  reason: collision with root package name */
    public int f2321e;

    /* renamed from: f  reason: collision with root package name */
    public int f2322f;

    /* renamed from: g  reason: collision with root package name */
    public int f2323g;

    /* renamed from: h  reason: collision with root package name */
    public int f2324h;

    /* renamed from: i  reason: collision with root package name */
    public int f2325i;

    /* renamed from: j  reason: collision with root package name */
    public int f2326j;

    /* renamed from: k  reason: collision with root package name */
    public List f2327k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f2328l;

    public final void a(View view) {
        int c4;
        int c5;
        int size = this.f2327k.size();
        View view2 = null;
        int i4 = Integer.MAX_VALUE;
        for (int i5 = 0; i5 < size; i5++) {
            View view3 = ((l1) this.f2327k.get(i5)).f2170a;
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
            if (view3 != view && !layoutParams.f2011a.j() && (c5 = (layoutParams.f2011a.c() - this.f2320d) * this.f2321e) >= 0 && c5 < i4) {
                view2 = view3;
                if (c5 == 0) {
                    break;
                }
                i4 = c5;
            }
        }
        if (view2 == null) {
            c4 = -1;
        } else {
            c4 = ((RecyclerView.LayoutParams) view2.getLayoutParams()).f2011a.c();
        }
        this.f2320d = c4;
    }

    public final View b(b1 b1Var) {
        List list = this.f2327k;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = ((l1) this.f2327k.get(i4)).f2170a;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.f2011a.j() && this.f2320d == layoutParams.f2011a.c()) {
                    a(view);
                    return view;
                }
            }
            return null;
        }
        View view2 = b1Var.i(this.f2320d, Long.MAX_VALUE).f2170a;
        this.f2320d += this.f2321e;
        return view2;
    }
}
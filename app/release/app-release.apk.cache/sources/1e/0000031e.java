package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class t1 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f2265a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public int f2266b = Integer.MIN_VALUE;

    /* renamed from: c  reason: collision with root package name */
    public int f2267c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public int f2268d = 0;

    /* renamed from: e  reason: collision with root package name */
    public final int f2269e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ StaggeredGridLayoutManager f2270f;

    public t1(StaggeredGridLayoutManager staggeredGridLayoutManager, int i4) {
        this.f2270f = staggeredGridLayoutManager;
        this.f2269e = i4;
    }

    public final void a() {
        ArrayList arrayList = this.f2265a;
        View view = (View) arrayList.get(arrayList.size() - 1);
        this.f2267c = this.f2270f.f2018r.b(view);
        ((StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams()).getClass();
    }

    public final void b() {
        this.f2265a.clear();
        this.f2266b = Integer.MIN_VALUE;
        this.f2267c = Integer.MIN_VALUE;
        this.f2268d = 0;
    }

    public final int c() {
        boolean z4 = this.f2270f.f2023w;
        ArrayList arrayList = this.f2265a;
        return z4 ? e(arrayList.size() - 1, -1) : e(0, arrayList.size());
    }

    public final int d() {
        boolean z4 = this.f2270f.f2023w;
        ArrayList arrayList = this.f2265a;
        return z4 ? e(0, arrayList.size()) : e(arrayList.size() - 1, -1);
    }

    public final int e(int i4, int i5) {
        int i6;
        boolean z4;
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f2270f;
        int k4 = staggeredGridLayoutManager.f2018r.k();
        int g4 = staggeredGridLayoutManager.f2018r.g();
        if (i5 > i4) {
            i6 = 1;
        } else {
            i6 = -1;
        }
        while (i4 != i5) {
            View view = (View) this.f2265a.get(i4);
            int e4 = staggeredGridLayoutManager.f2018r.e(view);
            int b5 = staggeredGridLayoutManager.f2018r.b(view);
            boolean z5 = false;
            if (e4 <= g4) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (b5 >= k4) {
                z5 = true;
            }
            if (z4 && z5 && (e4 < k4 || b5 > g4)) {
                return u0.F(view);
            }
            i4 += i6;
        }
        return -1;
    }

    public final int f(int i4) {
        int i5 = this.f2267c;
        if (i5 != Integer.MIN_VALUE) {
            return i5;
        }
        if (this.f2265a.size() == 0) {
            return i4;
        }
        a();
        return this.f2267c;
    }

    public final View g(int i4, int i5) {
        ArrayList arrayList = this.f2265a;
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f2270f;
        View view = null;
        if (i5 != -1) {
            int size = arrayList.size() - 1;
            while (size >= 0) {
                View view2 = (View) arrayList.get(size);
                if ((staggeredGridLayoutManager.f2023w && u0.F(view2) >= i4) || ((!staggeredGridLayoutManager.f2023w && u0.F(view2) <= i4) || !view2.hasFocusable())) {
                    break;
                }
                size--;
                view = view2;
            }
        } else {
            int size2 = arrayList.size();
            int i6 = 0;
            while (i6 < size2) {
                View view3 = (View) arrayList.get(i6);
                if ((staggeredGridLayoutManager.f2023w && u0.F(view3) <= i4) || ((!staggeredGridLayoutManager.f2023w && u0.F(view3) >= i4) || !view3.hasFocusable())) {
                    break;
                }
                i6++;
                view = view3;
            }
        }
        return view;
    }

    public final int h(int i4) {
        int i5 = this.f2266b;
        if (i5 != Integer.MIN_VALUE) {
            return i5;
        }
        if (this.f2265a.size() == 0) {
            return i4;
        }
        View view = (View) this.f2265a.get(0);
        this.f2266b = this.f2270f.f2018r.e(view);
        ((StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams()).getClass();
        return this.f2266b;
    }
}
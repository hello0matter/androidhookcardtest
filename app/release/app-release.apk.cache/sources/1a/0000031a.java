package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class s0 implements v1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u0 f2254a;

    public s0(u0 u0Var) {
        this.f2254a = u0Var;
    }

    @Override // androidx.recyclerview.widget.v1
    public final View a(int i4) {
        return this.f2254a.u(i4);
    }

    @Override // androidx.recyclerview.widget.v1
    public final int b() {
        u0 u0Var = this.f2254a;
        return u0Var.f2287o - u0Var.B();
    }

    @Override // androidx.recyclerview.widget.v1
    public final int c() {
        return this.f2254a.E();
    }

    @Override // androidx.recyclerview.widget.v1
    public final int d(View view) {
        this.f2254a.getClass();
        return view.getBottom() + ((RecyclerView.LayoutParams) view.getLayoutParams()).f2012b.bottom + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.v1
    public final int e(View view) {
        this.f2254a.getClass();
        return (view.getTop() - ((RecyclerView.LayoutParams) view.getLayoutParams()).f2012b.top) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }
}
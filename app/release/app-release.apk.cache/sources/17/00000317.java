package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class r0 implements v1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u0 f2246a;

    public r0(u0 u0Var) {
        this.f2246a = u0Var;
    }

    @Override // androidx.recyclerview.widget.v1
    public final View a(int i4) {
        return this.f2246a.u(i4);
    }

    @Override // androidx.recyclerview.widget.v1
    public final int b() {
        u0 u0Var = this.f2246a;
        return u0Var.f2286n - u0Var.D();
    }

    @Override // androidx.recyclerview.widget.v1
    public final int c() {
        return this.f2246a.C();
    }

    @Override // androidx.recyclerview.widget.v1
    public final int d(View view) {
        this.f2246a.getClass();
        return view.getRight() + ((RecyclerView.LayoutParams) view.getLayoutParams()).f2012b.right + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }

    @Override // androidx.recyclerview.widget.v1
    public final int e(View view) {
        this.f2246a.getClass();
        return (view.getLeft() - ((RecyclerView.LayoutParams) view.getLayoutParams()).f2012b.left) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }
}
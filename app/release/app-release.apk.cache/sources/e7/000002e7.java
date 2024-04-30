package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class b0 extends d0 {
    @Override // androidx.recyclerview.widget.d0
    public final int b(View view) {
        this.f2074a.getClass();
        return view.getRight() + ((RecyclerView.LayoutParams) view.getLayoutParams()).f2012b.right + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }

    @Override // androidx.recyclerview.widget.d0
    public final int c(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        this.f2074a.getClass();
        Rect rect = ((RecyclerView.LayoutParams) view.getLayoutParams()).f2012b;
        return view.getMeasuredWidth() + rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    @Override // androidx.recyclerview.widget.d0
    public final int d(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        this.f2074a.getClass();
        Rect rect = ((RecyclerView.LayoutParams) view.getLayoutParams()).f2012b;
        return view.getMeasuredHeight() + rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.d0
    public final int e(View view) {
        this.f2074a.getClass();
        return (view.getLeft() - ((RecyclerView.LayoutParams) view.getLayoutParams()).f2012b.left) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }

    @Override // androidx.recyclerview.widget.d0
    public final int f() {
        return this.f2074a.f2286n;
    }

    @Override // androidx.recyclerview.widget.d0
    public final int g() {
        u0 u0Var = this.f2074a;
        return u0Var.f2286n - u0Var.D();
    }

    @Override // androidx.recyclerview.widget.d0
    public final int h() {
        return this.f2074a.D();
    }

    @Override // androidx.recyclerview.widget.d0
    public final int i() {
        return this.f2074a.f2284l;
    }

    @Override // androidx.recyclerview.widget.d0
    public final int j() {
        return this.f2074a.f2285m;
    }

    @Override // androidx.recyclerview.widget.d0
    public final int k() {
        return this.f2074a.C();
    }

    @Override // androidx.recyclerview.widget.d0
    public final int l() {
        u0 u0Var = this.f2074a;
        return (u0Var.f2286n - u0Var.C()) - u0Var.D();
    }

    @Override // androidx.recyclerview.widget.d0
    public final int n(View view) {
        u0 u0Var = this.f2074a;
        Rect rect = this.f2076c;
        u0Var.I(view, rect);
        return rect.right;
    }

    @Override // androidx.recyclerview.widget.d0
    public final int o(View view) {
        u0 u0Var = this.f2074a;
        Rect rect = this.f2076c;
        u0Var.I(view, rect);
        return rect.left;
    }

    @Override // androidx.recyclerview.widget.d0
    public final void p(int i4) {
        this.f2074a.M(i4);
    }
}
package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;

/* loaded from: classes.dex */
public abstract class d0 {

    /* renamed from: a  reason: collision with root package name */
    public final u0 f2074a;

    /* renamed from: b  reason: collision with root package name */
    public int f2075b = Integer.MIN_VALUE;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f2076c = new Rect();

    public d0(u0 u0Var) {
        this.f2074a = u0Var;
    }

    public static d0 a(u0 u0Var, int i4) {
        if (i4 != 0) {
            if (i4 == 1) {
                return new d0(u0Var);
            }
            throw new IllegalArgumentException("invalid orientation");
        }
        return new d0(u0Var);
    }

    public abstract int b(View view);

    public abstract int c(View view);

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public final int m() {
        if (Integer.MIN_VALUE == this.f2075b) {
            return 0;
        }
        return l() - this.f2075b;
    }

    public abstract int n(View view);

    public abstract int o(View view);

    public abstract void p(int i4);
}
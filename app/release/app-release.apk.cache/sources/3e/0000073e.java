package i0;

import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class d2 {

    /* renamed from: b  reason: collision with root package name */
    public static final g2 f4917b;

    /* renamed from: a  reason: collision with root package name */
    public final g2 f4918a;

    static {
        x1 t1Var;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 30) {
            t1Var = new w1();
        } else if (i4 >= 29) {
            t1Var = new v1();
        } else {
            t1Var = new t1();
        }
        f4917b = t1Var.b().f4931a.a().f4931a.b().f4931a.c();
    }

    public d2(@NonNull g2 g2Var) {
        this.f4918a = g2Var;
    }

    @NonNull
    public g2 a() {
        return this.f4918a;
    }

    @NonNull
    public g2 b() {
        return this.f4918a;
    }

    @NonNull
    public g2 c() {
        return this.f4918a;
    }

    @Nullable
    public l e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d2)) {
            return false;
        }
        d2 d2Var = (d2) obj;
        if (n() == d2Var.n() && m() == d2Var.m() && h0.b.a(j(), d2Var.j()) && h0.b.a(h(), d2Var.h()) && h0.b.a(e(), d2Var.e())) {
            return true;
        }
        return false;
    }

    @NonNull
    public b0.c f(int i4) {
        return b0.c.f2489e;
    }

    @NonNull
    public b0.c g() {
        return j();
    }

    @NonNull
    public b0.c h() {
        return b0.c.f2489e;
    }

    public int hashCode() {
        return h0.b.b(Boolean.valueOf(n()), Boolean.valueOf(m()), j(), h(), e());
    }

    @NonNull
    public b0.c i() {
        return j();
    }

    @NonNull
    public b0.c j() {
        return b0.c.f2489e;
    }

    @NonNull
    public b0.c k() {
        return j();
    }

    @NonNull
    public g2 l(int i4, int i5, int i6, int i7) {
        return f4917b;
    }

    public boolean m() {
        return false;
    }

    public boolean n() {
        return false;
    }

    public void d(@NonNull View view) {
    }

    public void o(b0.c[] cVarArr) {
    }

    public void p(@Nullable g2 g2Var) {
    }

    public void q(b0.c cVar) {
    }
}
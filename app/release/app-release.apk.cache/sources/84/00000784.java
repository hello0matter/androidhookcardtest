package i0;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class x1 {

    /* renamed from: a  reason: collision with root package name */
    public final g2 f4997a;

    /* renamed from: b  reason: collision with root package name */
    public b0.c[] f4998b;

    public x1() {
        this(new g2());
    }

    public final void a() {
        b0.c[] cVarArr = this.f4998b;
        if (cVarArr != null) {
            b0.c cVar = cVarArr[e2.a(1)];
            b0.c cVar2 = this.f4998b[e2.a(2)];
            g2 g2Var = this.f4997a;
            if (cVar2 == null) {
                cVar2 = g2Var.f4931a.f(2);
            }
            if (cVar == null) {
                cVar = g2Var.f4931a.f(1);
            }
            g(b0.c.a(cVar, cVar2));
            b0.c cVar3 = this.f4998b[e2.a(16)];
            if (cVar3 != null) {
                f(cVar3);
            }
            b0.c cVar4 = this.f4998b[e2.a(32)];
            if (cVar4 != null) {
                d(cVar4);
            }
            b0.c cVar5 = this.f4998b[e2.a(64)];
            if (cVar5 != null) {
                h(cVar5);
            }
        }
    }

    @NonNull
    public abstract g2 b();

    public void c(int i4, @NonNull b0.c cVar) {
        if (this.f4998b == null) {
            this.f4998b = new b0.c[9];
        }
        for (int i5 = 1; i5 <= 256; i5 <<= 1) {
            if ((i4 & i5) != 0) {
                this.f4998b[e2.a(i5)] = cVar;
            }
        }
    }

    public abstract void e(@NonNull b0.c cVar);

    public abstract void g(@NonNull b0.c cVar);

    public x1(@NonNull g2 g2Var) {
        this.f4997a = g2Var;
    }

    public void d(@NonNull b0.c cVar) {
    }

    public void f(@NonNull b0.c cVar) {
    }

    public void h(@NonNull b0.c cVar) {
    }
}
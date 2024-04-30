package q;

import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class a extends j {

    /* renamed from: j0  reason: collision with root package name */
    public int f6169j0 = 0;

    /* renamed from: k0  reason: collision with root package name */
    public boolean f6170k0 = true;

    /* renamed from: l0  reason: collision with root package name */
    public int f6171l0 = 0;

    @Override // q.d
    public final void b(p.f fVar) {
        boolean z4;
        boolean z5;
        boolean z6;
        int i4;
        p.j jVar;
        c cVar;
        int i5;
        int i6;
        c[] cVarArr = this.G;
        c cVar2 = this.f6227y;
        cVarArr[0] = cVar2;
        c cVar3 = this.f6228z;
        int i7 = 2;
        cVarArr[2] = cVar3;
        c cVar4 = this.A;
        cVarArr[1] = cVar4;
        c cVar5 = this.B;
        cVarArr[3] = cVar5;
        for (c cVar6 : cVarArr) {
            cVar6.f6195g = fVar.j(cVar6);
        }
        int i8 = this.f6169j0;
        if (i8 >= 0 && i8 < 4) {
            c cVar7 = cVarArr[i8];
            for (int i9 = 0; i9 < this.f6285i0; i9++) {
                d dVar = this.f6284h0[i9];
                if (this.f6170k0 || dVar.c()) {
                    int i10 = this.f6169j0;
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.f1133c;
                    if (((i10 == 0 || i10 == 1) && dVar.J[0] == constraintWidget$DimensionBehaviour && dVar.f6227y.f6192d != null && dVar.A.f6192d != null) || ((i10 == 2 || i10 == 3) && dVar.J[1] == constraintWidget$DimensionBehaviour && dVar.f6228z.f6192d != null && dVar.B.f6192d != null)) {
                        z4 = true;
                        break;
                    }
                }
            }
            z4 = false;
            if (!cVar2.e() && !cVar4.e()) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (!cVar3.e() && !cVar5.e()) {
                z6 = false;
            } else {
                z6 = true;
            }
            if (!z4 && (((i6 = this.f6169j0) == 0 && z5) || ((i6 == 2 && z6) || ((i6 == 1 && z5) || (i6 == 3 && z6))))) {
                i4 = 5;
            } else {
                i4 = 4;
            }
            int i11 = 0;
            while (i11 < this.f6285i0) {
                d dVar2 = this.f6284h0[i11];
                if (this.f6170k0 || dVar2.c()) {
                    p.j j4 = fVar.j(dVar2.G[this.f6169j0]);
                    int i12 = this.f6169j0;
                    c cVar8 = dVar2.G[i12];
                    cVar8.f6195g = j4;
                    c cVar9 = cVar8.f6192d;
                    if (cVar9 != null && cVar9.f6190b == this) {
                        i5 = cVar8.f6193e;
                    } else {
                        i5 = 0;
                    }
                    if (i12 != 0 && i12 != i7) {
                        p.c k4 = fVar.k();
                        p.j l4 = fVar.l();
                        l4.f6106d = 0;
                        k4.b(cVar7.f6195g, j4, l4, this.f6171l0 + i5);
                        fVar.c(k4);
                    } else {
                        p.c k5 = fVar.k();
                        p.j l5 = fVar.l();
                        l5.f6106d = 0;
                        k5.c(cVar7.f6195g, j4, l5, this.f6171l0 - i5);
                        fVar.c(k5);
                    }
                    fVar.e(cVar7.f6195g, j4, this.f6171l0 + i5, i4);
                }
                i11++;
                i7 = 2;
            }
            int i13 = this.f6169j0;
            if (i13 == 0) {
                fVar.e(cVar4.f6195g, cVar2.f6195g, 0, 8);
                fVar.e(cVar2.f6195g, this.K.A.f6195g, 0, 4);
                jVar = cVar2.f6195g;
                cVar = this.K.f6227y;
            } else if (i13 == 1) {
                fVar.e(cVar2.f6195g, cVar4.f6195g, 0, 8);
                fVar.e(cVar2.f6195g, this.K.f6227y.f6195g, 0, 4);
                jVar = cVar2.f6195g;
                cVar = this.K.A;
            } else if (i13 == 2) {
                fVar.e(cVar5.f6195g, cVar3.f6195g, 0, 8);
                fVar.e(cVar3.f6195g, this.K.B.f6195g, 0, 4);
                jVar = cVar3.f6195g;
                cVar = this.K.f6228z;
            } else if (i13 == 3) {
                fVar.e(cVar3.f6195g, cVar5.f6195g, 0, 8);
                fVar.e(cVar3.f6195g, this.K.f6228z.f6195g, 0, 4);
                jVar = cVar3.f6195g;
                cVar = this.K.B;
            } else {
                return;
            }
            fVar.e(jVar, cVar.f6195g, 0, 0);
        }
    }

    @Override // q.d
    public final boolean c() {
        return true;
    }

    @Override // q.j, q.d
    public final void g(d dVar, HashMap hashMap) {
        super.g(dVar, hashMap);
        a aVar = (a) dVar;
        this.f6169j0 = aVar.f6169j0;
        this.f6170k0 = aVar.f6170k0;
        this.f6171l0 = aVar.f6171l0;
    }

    @Override // q.d
    public final String toString() {
        String e4 = androidx.activity.j.e(new StringBuilder("[Barrier] "), this.Y, " {");
        for (int i4 = 0; i4 < this.f6285i0; i4++) {
            d dVar = this.f6284h0[i4];
            if (i4 > 0) {
                e4 = androidx.activity.j.c(e4, ", ");
            }
            e4 = e4 + dVar.Y;
        }
        return androidx.activity.j.c(e4, "}");
    }
}
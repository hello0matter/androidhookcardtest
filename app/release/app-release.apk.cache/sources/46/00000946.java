package q;

import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class h extends d {

    /* renamed from: h0  reason: collision with root package name */
    public float f6279h0 = -1.0f;

    /* renamed from: i0  reason: collision with root package name */
    public int f6280i0 = -1;

    /* renamed from: j0  reason: collision with root package name */
    public int f6281j0 = -1;

    /* renamed from: k0  reason: collision with root package name */
    public c f6282k0 = this.f6228z;

    /* renamed from: l0  reason: collision with root package name */
    public int f6283l0 = 0;

    public h() {
        this.H.clear();
        this.H.add(this.f6282k0);
        int length = this.G.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.G[i4] = this.f6282k0;
        }
    }

    @Override // q.d
    public final void C(p.f fVar) {
        if (this.K == null) {
            return;
        }
        c cVar = this.f6282k0;
        fVar.getClass();
        int m4 = p.f.m(cVar);
        if (this.f6283l0 == 1) {
            this.P = m4;
            this.Q = 0;
            x(this.K.k());
            A(0);
            return;
        }
        this.P = 0;
        this.Q = m4;
        A(this.K.n());
        x(0);
    }

    public final void D(int i4) {
        c cVar;
        if (this.f6283l0 == i4) {
            return;
        }
        this.f6283l0 = i4;
        ArrayList arrayList = this.H;
        arrayList.clear();
        if (this.f6283l0 == 1) {
            cVar = this.f6227y;
        } else {
            cVar = this.f6228z;
        }
        this.f6282k0 = cVar;
        arrayList.add(this.f6282k0);
        c[] cVarArr = this.G;
        int length = cVarArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            cVarArr[i5] = this.f6282k0;
        }
    }

    @Override // q.d
    public final void b(p.f fVar) {
        boolean z4;
        e eVar = (e) this.K;
        if (eVar == null) {
            return;
        }
        c i4 = eVar.i(ConstraintAnchor$Type.f1122a);
        c i5 = eVar.i(ConstraintAnchor$Type.f1124c);
        d dVar = this.K;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.f1132b;
        boolean z5 = true;
        if (dVar != null && dVar.J[0] == constraintWidget$DimensionBehaviour) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.f6283l0 == 0) {
            i4 = eVar.i(ConstraintAnchor$Type.f1123b);
            i5 = eVar.i(ConstraintAnchor$Type.f1125d);
            d dVar2 = this.K;
            if (dVar2 == null || dVar2.J[1] != constraintWidget$DimensionBehaviour) {
                z5 = false;
            }
            z4 = z5;
        }
        if (this.f6280i0 != -1) {
            p.j j4 = fVar.j(this.f6282k0);
            fVar.e(j4, fVar.j(i4), this.f6280i0, 8);
            if (z4) {
                fVar.f(fVar.j(i5), j4, 0, 5);
            }
        } else if (this.f6281j0 != -1) {
            p.j j5 = fVar.j(this.f6282k0);
            p.j j6 = fVar.j(i5);
            fVar.e(j5, j6, -this.f6281j0, 8);
            if (z4) {
                fVar.f(j5, fVar.j(i4), 0, 5);
                fVar.f(j6, j5, 0, 5);
            }
        } else if (this.f6279h0 != -1.0f) {
            p.j j7 = fVar.j(this.f6282k0);
            p.j j8 = fVar.j(i5);
            float f4 = this.f6279h0;
            p.c k4 = fVar.k();
            k4.f6071d.f(j7, -1.0f);
            k4.f6071d.f(j8, f4);
            fVar.c(k4);
        }
    }

    @Override // q.d
    public final boolean c() {
        return true;
    }

    @Override // q.d
    public final void g(d dVar, HashMap hashMap) {
        super.g(dVar, hashMap);
        h hVar = (h) dVar;
        this.f6279h0 = hVar.f6279h0;
        this.f6280i0 = hVar.f6280i0;
        this.f6281j0 = hVar.f6281j0;
        D(hVar.f6283l0);
    }

    @Override // q.d
    public final c i(ConstraintAnchor$Type constraintAnchor$Type) {
        switch (constraintAnchor$Type.ordinal()) {
            case 0:
            case VisibleForTesting.NONE /* 5 */:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                if (this.f6283l0 == 1) {
                    return this.f6282k0;
                }
                break;
            case 2:
            case VisibleForTesting.PROTECTED /* 4 */:
                if (this.f6283l0 == 0) {
                    return this.f6282k0;
                }
                break;
        }
        throw new AssertionError(constraintAnchor$Type.name());
    }
}
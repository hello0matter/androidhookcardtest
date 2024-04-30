package q;

import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.solver.SolverVariable$Type;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: b  reason: collision with root package name */
    public final d f6190b;

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintAnchor$Type f6191c;

    /* renamed from: d  reason: collision with root package name */
    public c f6192d;

    /* renamed from: g  reason: collision with root package name */
    public p.j f6195g;

    /* renamed from: a  reason: collision with root package name */
    public HashSet f6189a = null;

    /* renamed from: e  reason: collision with root package name */
    public int f6193e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f6194f = -1;

    public c(d dVar, ConstraintAnchor$Type constraintAnchor$Type) {
        this.f6190b = dVar;
        this.f6191c = constraintAnchor$Type;
    }

    public final void a(c cVar, int i4) {
        b(cVar, i4, -1, false);
    }

    public final boolean b(c cVar, int i4, int i5, boolean z4) {
        if (cVar == null) {
            h();
            return true;
        } else if (!z4 && !g(cVar)) {
            return false;
        } else {
            this.f6192d = cVar;
            if (cVar.f6189a == null) {
                cVar.f6189a = new HashSet();
            }
            this.f6192d.f6189a.add(this);
            if (i4 > 0) {
                this.f6193e = i4;
            } else {
                this.f6193e = 0;
            }
            this.f6194f = i5;
            return true;
        }
    }

    public final int c() {
        c cVar;
        if (this.f6190b.X == 8) {
            return 0;
        }
        int i4 = this.f6194f;
        if (i4 > -1 && (cVar = this.f6192d) != null && cVar.f6190b.X == 8) {
            return i4;
        }
        return this.f6193e;
    }

    public final c d() {
        ConstraintAnchor$Type constraintAnchor$Type = this.f6191c;
        int ordinal = constraintAnchor$Type.ordinal();
        d dVar = this.f6190b;
        switch (ordinal) {
            case 0:
            case VisibleForTesting.NONE /* 5 */:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return dVar.A;
            case 2:
                return dVar.B;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                return dVar.f6227y;
            case VisibleForTesting.PROTECTED /* 4 */:
                return dVar.f6228z;
            default:
                throw new AssertionError(constraintAnchor$Type.name());
        }
    }

    public final boolean e() {
        HashSet hashSet = this.f6189a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((c) it.next()).d().f()) {
                return true;
            }
        }
        return false;
    }

    public final boolean f() {
        if (this.f6192d != null) {
            return true;
        }
        return false;
    }

    public final boolean g(c cVar) {
        boolean z4;
        boolean z5;
        boolean z6 = false;
        if (cVar == null) {
            return false;
        }
        ConstraintAnchor$Type constraintAnchor$Type = ConstraintAnchor$Type.f1126e;
        ConstraintAnchor$Type constraintAnchor$Type2 = this.f6191c;
        d dVar = cVar.f6190b;
        ConstraintAnchor$Type constraintAnchor$Type3 = cVar.f6191c;
        if (constraintAnchor$Type3 == constraintAnchor$Type2) {
            if (constraintAnchor$Type2 == constraintAnchor$Type && (!dVar.f6225w || !this.f6190b.f6225w)) {
                return false;
            }
            return true;
        }
        int ordinal = constraintAnchor$Type2.ordinal();
        ConstraintAnchor$Type constraintAnchor$Type4 = ConstraintAnchor$Type.f1128g;
        ConstraintAnchor$Type constraintAnchor$Type5 = ConstraintAnchor$Type.f1129h;
        switch (ordinal) {
            case 0:
            case VisibleForTesting.NONE /* 5 */:
            case 7:
            case 8:
                return false;
            case 1:
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                if (constraintAnchor$Type3 != ConstraintAnchor$Type.f1122a && constraintAnchor$Type3 != ConstraintAnchor$Type.f1124c) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (dVar instanceof h) {
                    if (z4 || constraintAnchor$Type3 == constraintAnchor$Type4) {
                        z6 = true;
                    }
                    return z6;
                }
                return z4;
            case 2:
            case VisibleForTesting.PROTECTED /* 4 */:
                if (constraintAnchor$Type3 != ConstraintAnchor$Type.f1123b && constraintAnchor$Type3 != ConstraintAnchor$Type.f1125d) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (dVar instanceof h) {
                    if (z5 || constraintAnchor$Type3 == constraintAnchor$Type5) {
                        z6 = true;
                    }
                    return z6;
                }
                return z5;
            case 6:
                if (constraintAnchor$Type3 == constraintAnchor$Type || constraintAnchor$Type3 == constraintAnchor$Type4 || constraintAnchor$Type3 == constraintAnchor$Type5) {
                    return false;
                }
                return true;
            default:
                throw new AssertionError(constraintAnchor$Type2.name());
        }
    }

    public final void h() {
        HashSet hashSet;
        c cVar = this.f6192d;
        if (cVar != null && (hashSet = cVar.f6189a) != null) {
            hashSet.remove(this);
        }
        this.f6192d = null;
        this.f6193e = 0;
        this.f6194f = -1;
    }

    public final void i() {
        p.j jVar = this.f6195g;
        if (jVar == null) {
            this.f6195g = new p.j(SolverVariable$Type.f1117a);
        } else {
            jVar.c();
        }
    }

    public final String toString() {
        return this.f6190b.Y + ":" + this.f6191c.toString();
    }
}
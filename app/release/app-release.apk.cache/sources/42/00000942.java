package q;

import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class d {
    public final c A;
    public final c B;
    public final c C;
    public final c D;
    public final c E;
    public final c F;
    public final c[] G;
    public final ArrayList H;
    public final boolean[] I;
    public ConstraintWidget$DimensionBehaviour[] J;
    public d K;
    public int L;
    public int M;
    public float N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public float U;
    public float V;
    public Object W;
    public int X;
    public String Y;
    public String Z;

    /* renamed from: a0  reason: collision with root package name */
    public int f6197a0;

    /* renamed from: b  reason: collision with root package name */
    public r.d f6198b;

    /* renamed from: b0  reason: collision with root package name */
    public int f6199b0;

    /* renamed from: c  reason: collision with root package name */
    public r.d f6200c;

    /* renamed from: c0  reason: collision with root package name */
    public final float[] f6201c0;

    /* renamed from: d0  reason: collision with root package name */
    public final d[] f6203d0;

    /* renamed from: e0  reason: collision with root package name */
    public final d[] f6205e0;

    /* renamed from: f0  reason: collision with root package name */
    public d f6207f0;

    /* renamed from: g0  reason: collision with root package name */
    public d f6209g0;

    /* renamed from: x  reason: collision with root package name */
    public boolean f6226x;

    /* renamed from: y  reason: collision with root package name */
    public final c f6227y;

    /* renamed from: z  reason: collision with root package name */
    public final c f6228z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f6196a = false;

    /* renamed from: d  reason: collision with root package name */
    public final androidx.constraintlayout.solver.widgets.analyzer.d f6202d = new androidx.constraintlayout.solver.widgets.analyzer.d(this);

    /* renamed from: e  reason: collision with root package name */
    public final androidx.constraintlayout.solver.widgets.analyzer.e f6204e = new androidx.constraintlayout.solver.widgets.analyzer.e(this);

    /* renamed from: f  reason: collision with root package name */
    public final boolean[] f6206f = {true, true};

    /* renamed from: g  reason: collision with root package name */
    public final int[] f6208g = {0, 0, 0, 0};

    /* renamed from: h  reason: collision with root package name */
    public int f6210h = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f6211i = -1;

    /* renamed from: j  reason: collision with root package name */
    public int f6212j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f6213k = 0;

    /* renamed from: l  reason: collision with root package name */
    public final int[] f6214l = new int[2];

    /* renamed from: m  reason: collision with root package name */
    public int f6215m = 0;

    /* renamed from: n  reason: collision with root package name */
    public int f6216n = 0;

    /* renamed from: o  reason: collision with root package name */
    public float f6217o = 1.0f;

    /* renamed from: p  reason: collision with root package name */
    public int f6218p = 0;

    /* renamed from: q  reason: collision with root package name */
    public int f6219q = 0;

    /* renamed from: r  reason: collision with root package name */
    public float f6220r = 1.0f;

    /* renamed from: s  reason: collision with root package name */
    public int f6221s = -1;

    /* renamed from: t  reason: collision with root package name */
    public float f6222t = 1.0f;

    /* renamed from: u  reason: collision with root package name */
    public int[] f6223u = {Integer.MAX_VALUE, Integer.MAX_VALUE};

    /* renamed from: v  reason: collision with root package name */
    public float f6224v = 0.0f;

    /* renamed from: w  reason: collision with root package name */
    public boolean f6225w = false;

    public d() {
        c cVar = new c(this, ConstraintAnchor$Type.f1122a);
        this.f6227y = cVar;
        c cVar2 = new c(this, ConstraintAnchor$Type.f1123b);
        this.f6228z = cVar2;
        c cVar3 = new c(this, ConstraintAnchor$Type.f1124c);
        this.A = cVar3;
        c cVar4 = new c(this, ConstraintAnchor$Type.f1125d);
        this.B = cVar4;
        c cVar5 = new c(this, ConstraintAnchor$Type.f1126e);
        this.C = cVar5;
        c cVar6 = new c(this, ConstraintAnchor$Type.f1128g);
        this.D = cVar6;
        c cVar7 = new c(this, ConstraintAnchor$Type.f1129h);
        this.E = cVar7;
        c cVar8 = new c(this, ConstraintAnchor$Type.f1127f);
        this.F = cVar8;
        this.G = new c[]{cVar, cVar3, cVar2, cVar4, cVar5, cVar8};
        ArrayList arrayList = new ArrayList();
        this.H = arrayList;
        this.I = new boolean[2];
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.f1131a;
        this.J = new ConstraintWidget$DimensionBehaviour[]{constraintWidget$DimensionBehaviour, constraintWidget$DimensionBehaviour};
        this.K = null;
        this.L = 0;
        this.M = 0;
        this.N = 0.0f;
        this.O = -1;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.U = 0.5f;
        this.V = 0.5f;
        this.X = 0;
        this.Y = null;
        this.Z = null;
        this.f6197a0 = 0;
        this.f6199b0 = 0;
        this.f6201c0 = new float[]{-1.0f, -1.0f};
        this.f6203d0 = new d[]{null, null};
        this.f6205e0 = new d[]{null, null};
        this.f6207f0 = null;
        this.f6209g0 = null;
        arrayList.add(cVar);
        arrayList.add(cVar2);
        arrayList.add(cVar3);
        arrayList.add(cVar4);
        arrayList.add(cVar6);
        arrayList.add(cVar7);
        arrayList.add(cVar8);
        arrayList.add(cVar5);
    }

    public final void A(int i4) {
        this.L = i4;
        int i5 = this.S;
        if (i4 < i5) {
            this.L = i5;
        }
    }

    public void B(boolean z4, boolean z5) {
        int i4;
        int i5;
        androidx.constraintlayout.solver.widgets.analyzer.d dVar = this.f6202d;
        boolean z6 = z4 & dVar.f1170g;
        androidx.constraintlayout.solver.widgets.analyzer.e eVar = this.f6204e;
        boolean z7 = z5 & eVar.f1170g;
        int i6 = dVar.f1171h.f1154g;
        int i7 = eVar.f1171h.f1154g;
        int i8 = dVar.f1172i.f1154g;
        int i9 = eVar.f1172i.f1154g;
        int i10 = i9 - i7;
        if (i8 - i6 < 0 || i10 < 0 || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE || i8 == Integer.MIN_VALUE || i8 == Integer.MAX_VALUE || i9 == Integer.MIN_VALUE || i9 == Integer.MAX_VALUE) {
            i8 = 0;
            i9 = 0;
            i6 = 0;
            i7 = 0;
        }
        int i11 = i8 - i6;
        int i12 = i9 - i7;
        if (z6) {
            this.P = i6;
        }
        if (z7) {
            this.Q = i7;
        }
        if (this.X == 8) {
            this.L = 0;
            this.M = 0;
            return;
        }
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.f1131a;
        if (z6) {
            if (this.J[0] == constraintWidget$DimensionBehaviour && i11 < (i5 = this.L)) {
                i11 = i5;
            }
            this.L = i11;
            int i13 = this.S;
            if (i11 < i13) {
                this.L = i13;
            }
        }
        if (z7) {
            if (this.J[1] == constraintWidget$DimensionBehaviour && i12 < (i4 = this.M)) {
                i12 = i4;
            }
            this.M = i12;
            int i14 = this.T;
            if (i12 < i14) {
                this.M = i14;
            }
        }
    }

    public void C(p.f fVar) {
        int i4;
        int i5;
        c cVar = this.f6227y;
        fVar.getClass();
        int m4 = p.f.m(cVar);
        int m5 = p.f.m(this.f6228z);
        int m6 = p.f.m(this.A);
        int m7 = p.f.m(this.B);
        androidx.constraintlayout.solver.widgets.analyzer.d dVar = this.f6202d;
        androidx.constraintlayout.solver.widgets.analyzer.a aVar = dVar.f1171h;
        if (aVar.f1157j) {
            androidx.constraintlayout.solver.widgets.analyzer.a aVar2 = dVar.f1172i;
            if (aVar2.f1157j) {
                m4 = aVar.f1154g;
                m6 = aVar2.f1154g;
            }
        }
        androidx.constraintlayout.solver.widgets.analyzer.e eVar = this.f6204e;
        androidx.constraintlayout.solver.widgets.analyzer.a aVar3 = eVar.f1171h;
        if (aVar3.f1157j) {
            androidx.constraintlayout.solver.widgets.analyzer.a aVar4 = eVar.f1172i;
            if (aVar4.f1157j) {
                m5 = aVar3.f1154g;
                m7 = aVar4.f1154g;
            }
        }
        int i6 = m7 - m5;
        if (m6 - m4 < 0 || i6 < 0 || m4 == Integer.MIN_VALUE || m4 == Integer.MAX_VALUE || m5 == Integer.MIN_VALUE || m5 == Integer.MAX_VALUE || m6 == Integer.MIN_VALUE || m6 == Integer.MAX_VALUE || m7 == Integer.MIN_VALUE || m7 == Integer.MAX_VALUE) {
            m4 = 0;
            m5 = 0;
            m6 = 0;
            m7 = 0;
        }
        int i7 = m6 - m4;
        int i8 = m7 - m5;
        this.P = m4;
        this.Q = m5;
        if (this.X == 8) {
            this.L = 0;
            this.M = 0;
            return;
        }
        ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr = this.J;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = constraintWidget$DimensionBehaviourArr[0];
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.f1131a;
        if (constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour2 && i7 < (i5 = this.L)) {
            i7 = i5;
        }
        if (constraintWidget$DimensionBehaviourArr[1] == constraintWidget$DimensionBehaviour2 && i8 < (i4 = this.M)) {
            i8 = i4;
        }
        this.L = i7;
        this.M = i8;
        int i9 = this.T;
        if (i8 < i9) {
            this.M = i9;
        }
        int i10 = this.S;
        if (i7 < i10) {
            this.L = i10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:159:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0306 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0495 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x054f  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x05ac  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x05b4  */
    /* JADX WARN: Removed duplicated region for block: B:307:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(p.f r57) {
        /*
            Method dump skipped, instructions count: 1643
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q.d.b(p.f):void");
    }

    public boolean c() {
        if (this.X != 8) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02f7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x03e4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:294:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0174  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d(p.f r30, boolean r31, boolean r32, boolean r33, boolean r34, p.j r35, p.j r36, androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r37, boolean r38, q.c r39, q.c r40, int r41, int r42, int r43, int r44, float r45, boolean r46, boolean r47, boolean r48, boolean r49, int r50, int r51, int r52, int r53, float r54, boolean r55) {
        /*
            Method dump skipped, instructions count: 1055
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q.d.d(p.f, boolean, boolean, boolean, boolean, p.j, p.j, androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour, boolean, q.c, q.c, int, int, int, int, float, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0162, code lost:
        if (r13.f() != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0189, code lost:
        if (r13.f() != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x018b, code lost:
        r11.h();
        r13.h();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r11, q.d r12, androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r13, int r14) {
        /*
            Method dump skipped, instructions count: 405
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q.d.e(androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type, q.d, androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type, int):void");
    }

    public final void f(c cVar, c cVar2, int i4) {
        if (cVar.f6190b == this) {
            e(cVar.f6191c, cVar2.f6190b, cVar2.f6191c, i4);
        }
    }

    public void g(d dVar, HashMap hashMap) {
        d dVar2;
        d dVar3;
        this.f6210h = dVar.f6210h;
        this.f6211i = dVar.f6211i;
        this.f6212j = dVar.f6212j;
        this.f6213k = dVar.f6213k;
        int[] iArr = dVar.f6214l;
        int i4 = iArr[0];
        int[] iArr2 = this.f6214l;
        iArr2[0] = i4;
        iArr2[1] = iArr[1];
        this.f6215m = dVar.f6215m;
        this.f6216n = dVar.f6216n;
        this.f6218p = dVar.f6218p;
        this.f6219q = dVar.f6219q;
        this.f6220r = dVar.f6220r;
        this.f6221s = dVar.f6221s;
        this.f6222t = dVar.f6222t;
        int[] iArr3 = dVar.f6223u;
        this.f6223u = Arrays.copyOf(iArr3, iArr3.length);
        this.f6224v = dVar.f6224v;
        this.f6225w = dVar.f6225w;
        this.f6226x = dVar.f6226x;
        this.f6227y.h();
        this.f6228z.h();
        this.A.h();
        this.B.h();
        this.C.h();
        this.D.h();
        this.E.h();
        this.F.h();
        this.J = (ConstraintWidget$DimensionBehaviour[]) Arrays.copyOf(this.J, 2);
        d dVar4 = null;
        if (this.K == null) {
            dVar2 = null;
        } else {
            dVar2 = (d) hashMap.get(dVar.K);
        }
        this.K = dVar2;
        this.L = dVar.L;
        this.M = dVar.M;
        this.N = dVar.N;
        this.O = dVar.O;
        this.P = dVar.P;
        this.Q = dVar.Q;
        this.R = dVar.R;
        this.S = dVar.S;
        this.T = dVar.T;
        this.U = dVar.U;
        this.V = dVar.V;
        this.W = dVar.W;
        this.X = dVar.X;
        this.Y = dVar.Y;
        this.Z = dVar.Z;
        this.f6197a0 = dVar.f6197a0;
        this.f6199b0 = dVar.f6199b0;
        float[] fArr = dVar.f6201c0;
        float f4 = fArr[0];
        float[] fArr2 = this.f6201c0;
        fArr2[0] = f4;
        fArr2[1] = fArr[1];
        d[] dVarArr = dVar.f6203d0;
        d dVar5 = dVarArr[0];
        d[] dVarArr2 = this.f6203d0;
        dVarArr2[0] = dVar5;
        dVarArr2[1] = dVarArr[1];
        d[] dVarArr3 = dVar.f6205e0;
        d dVar6 = dVarArr3[0];
        d[] dVarArr4 = this.f6205e0;
        dVarArr4[0] = dVar6;
        dVarArr4[1] = dVarArr3[1];
        d dVar7 = dVar.f6207f0;
        if (dVar7 == null) {
            dVar3 = null;
        } else {
            dVar3 = (d) hashMap.get(dVar7);
        }
        this.f6207f0 = dVar3;
        d dVar8 = dVar.f6209g0;
        if (dVar8 != null) {
            dVar4 = (d) hashMap.get(dVar8);
        }
        this.f6209g0 = dVar4;
    }

    public final void h(p.f fVar) {
        fVar.j(this.f6227y);
        fVar.j(this.f6228z);
        fVar.j(this.A);
        fVar.j(this.B);
        if (this.R > 0) {
            fVar.j(this.C);
        }
    }

    public c i(ConstraintAnchor$Type constraintAnchor$Type) {
        switch (constraintAnchor$Type.ordinal()) {
            case 0:
                return null;
            case 1:
                return this.f6227y;
            case 2:
                return this.f6228z;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                return this.A;
            case VisibleForTesting.PROTECTED /* 4 */:
                return this.B;
            case VisibleForTesting.NONE /* 5 */:
                return this.C;
            case 6:
                return this.F;
            case 7:
                return this.D;
            case 8:
                return this.E;
            default:
                throw new AssertionError(constraintAnchor$Type.name());
        }
    }

    public final ConstraintWidget$DimensionBehaviour j(int i4) {
        if (i4 == 0) {
            return this.J[0];
        }
        if (i4 == 1) {
            return this.J[1];
        }
        return null;
    }

    public final int k() {
        if (this.X == 8) {
            return 0;
        }
        return this.M;
    }

    public final d l(int i4) {
        c cVar;
        c cVar2;
        if (i4 == 0) {
            c cVar3 = this.A;
            c cVar4 = cVar3.f6192d;
            if (cVar4 != null && cVar4.f6192d == cVar3) {
                return cVar4.f6190b;
            }
            return null;
        } else if (i4 == 1 && (cVar2 = (cVar = this.B).f6192d) != null && cVar2.f6192d == cVar) {
            return cVar2.f6190b;
        } else {
            return null;
        }
    }

    public final d m(int i4) {
        c cVar;
        c cVar2;
        if (i4 == 0) {
            c cVar3 = this.f6227y;
            c cVar4 = cVar3.f6192d;
            if (cVar4 != null && cVar4.f6192d == cVar3) {
                return cVar4.f6190b;
            }
            return null;
        } else if (i4 == 1 && (cVar2 = (cVar = this.f6228z).f6192d) != null && cVar2.f6192d == cVar) {
            return cVar2.f6190b;
        } else {
            return null;
        }
    }

    public final int n() {
        if (this.X == 8) {
            return 0;
        }
        return this.L;
    }

    public final int o() {
        d dVar = this.K;
        if (dVar != null && (dVar instanceof e)) {
            return ((e) dVar).f6235n0 + this.P;
        }
        return this.P;
    }

    public final int p() {
        d dVar = this.K;
        if (dVar != null && (dVar instanceof e)) {
            return ((e) dVar).f6236o0 + this.Q;
        }
        return this.Q;
    }

    public final void q(ConstraintAnchor$Type constraintAnchor$Type, d dVar, ConstraintAnchor$Type constraintAnchor$Type2, int i4, int i5) {
        i(constraintAnchor$Type).b(dVar.i(constraintAnchor$Type2), i4, i5, true);
    }

    public final boolean r(int i4) {
        c cVar;
        c cVar2;
        int i5 = i4 * 2;
        c[] cVarArr = this.G;
        c cVar3 = cVarArr[i5];
        c cVar4 = cVar3.f6192d;
        if (cVar4 != null && cVar4.f6192d != cVar3 && (cVar2 = (cVar = cVarArr[i5 + 1]).f6192d) != null && cVar2.f6192d == cVar) {
            return true;
        }
        return false;
    }

    public final boolean s() {
        c cVar = this.f6227y;
        c cVar2 = cVar.f6192d;
        if (cVar2 == null || cVar2.f6192d != cVar) {
            c cVar3 = this.A;
            c cVar4 = cVar3.f6192d;
            if (cVar4 != null && cVar4.f6192d == cVar3) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final boolean t() {
        c cVar = this.f6228z;
        c cVar2 = cVar.f6192d;
        if (cVar2 == null || cVar2.f6192d != cVar) {
            c cVar3 = this.B;
            c cVar4 = cVar3.f6192d;
            if (cVar4 != null && cVar4.f6192d == cVar3) {
                return true;
            }
            return false;
        }
        return true;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.Z == null) {
            str = "";
        } else {
            str = androidx.activity.j.e(new StringBuilder("type: "), this.Z, " ");
        }
        sb.append(str);
        if (this.Y != null) {
            str2 = androidx.activity.j.e(new StringBuilder("id: "), this.Y, " ");
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.P);
        sb.append(", ");
        sb.append(this.Q);
        sb.append(") - (");
        sb.append(this.L);
        sb.append(" x ");
        sb.append(this.M);
        sb.append(")");
        return sb.toString();
    }

    public void u() {
        this.f6227y.h();
        this.f6228z.h();
        this.A.h();
        this.B.h();
        this.C.h();
        this.D.h();
        this.E.h();
        this.F.h();
        this.K = null;
        this.f6224v = 0.0f;
        this.L = 0;
        this.M = 0;
        this.N = 0.0f;
        this.O = -1;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0.5f;
        this.V = 0.5f;
        ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr = this.J;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.f1131a;
        constraintWidget$DimensionBehaviourArr[0] = constraintWidget$DimensionBehaviour;
        constraintWidget$DimensionBehaviourArr[1] = constraintWidget$DimensionBehaviour;
        this.W = null;
        this.X = 0;
        this.Z = null;
        this.f6197a0 = 0;
        this.f6199b0 = 0;
        float[] fArr = this.f6201c0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f6210h = -1;
        this.f6211i = -1;
        int[] iArr = this.f6223u;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f6212j = 0;
        this.f6213k = 0;
        this.f6217o = 1.0f;
        this.f6220r = 1.0f;
        this.f6216n = Integer.MAX_VALUE;
        this.f6219q = Integer.MAX_VALUE;
        this.f6215m = 0;
        this.f6218p = 0;
        this.f6221s = -1;
        this.f6222t = 1.0f;
        boolean[] zArr = this.f6206f;
        zArr[0] = true;
        zArr[1] = true;
        boolean[] zArr2 = this.I;
        zArr2[0] = false;
        zArr2[1] = false;
    }

    public final void v() {
        d dVar = this.K;
        if (dVar != null && (dVar instanceof e)) {
            ((e) dVar).getClass();
        }
        ArrayList arrayList = this.H;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((c) arrayList.get(i4)).h();
        }
    }

    public void w(p.d dVar) {
        this.f6227y.i();
        this.f6228z.i();
        this.A.i();
        this.B.i();
        this.C.i();
        this.F.i();
        this.D.i();
        this.E.i();
    }

    public final void x(int i4) {
        this.M = i4;
        int i5 = this.T;
        if (i4 < i5) {
            this.M = i5;
        }
    }

    public final void y(ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour) {
        this.J[0] = constraintWidget$DimensionBehaviour;
    }

    public final void z(ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour) {
        this.J[1] = constraintWidget$DimensionBehaviour;
    }
}
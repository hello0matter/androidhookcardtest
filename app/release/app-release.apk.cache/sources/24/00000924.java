package p;

import androidx.constraintlayout.solver.SolverVariable$Type;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    public b f6071d;

    /* renamed from: a  reason: collision with root package name */
    public j f6068a = null;

    /* renamed from: b  reason: collision with root package name */
    public float f6069b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f6070c = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public boolean f6072e = false;

    public c(d dVar) {
        this.f6071d = new a(this, dVar);
    }

    public final void a(f fVar, int i4) {
        this.f6071d.f(fVar.i(i4), 1.0f);
        this.f6071d.f(fVar.i(i4), -1.0f);
    }

    public final void b(j jVar, j jVar2, j jVar3, int i4) {
        boolean z4;
        if (i4 != 0) {
            if (i4 < 0) {
                i4 *= -1;
                z4 = true;
            } else {
                z4 = false;
            }
            this.f6069b = i4;
            if (z4) {
                this.f6071d.f(jVar, 1.0f);
                this.f6071d.f(jVar2, -1.0f);
                this.f6071d.f(jVar3, -1.0f);
                return;
            }
        }
        this.f6071d.f(jVar, -1.0f);
        this.f6071d.f(jVar2, 1.0f);
        this.f6071d.f(jVar3, 1.0f);
    }

    public final void c(j jVar, j jVar2, j jVar3, int i4) {
        boolean z4;
        if (i4 != 0) {
            if (i4 < 0) {
                i4 *= -1;
                z4 = true;
            } else {
                z4 = false;
            }
            this.f6069b = i4;
            if (z4) {
                this.f6071d.f(jVar, 1.0f);
                this.f6071d.f(jVar2, -1.0f);
                this.f6071d.f(jVar3, 1.0f);
                return;
            }
        }
        this.f6071d.f(jVar, -1.0f);
        this.f6071d.f(jVar2, 1.0f);
        this.f6071d.f(jVar3, -1.0f);
    }

    public j d(boolean[] zArr) {
        return e(zArr, null);
    }

    public final j e(boolean[] zArr, j jVar) {
        SolverVariable$Type solverVariable$Type;
        int k4 = this.f6071d.k();
        j jVar2 = null;
        float f4 = 0.0f;
        for (int i4 = 0; i4 < k4; i4++) {
            float a5 = this.f6071d.a(i4);
            if (a5 < 0.0f) {
                j d4 = this.f6071d.d(i4);
                if ((zArr == null || !zArr[d4.f6104b]) && d4 != jVar && (((solverVariable$Type = d4.f6111i) == SolverVariable$Type.f1118b || solverVariable$Type == SolverVariable$Type.f1119c) && a5 < f4)) {
                    f4 = a5;
                    jVar2 = d4;
                }
            }
        }
        return jVar2;
    }

    public final void f(j jVar) {
        j jVar2 = this.f6068a;
        if (jVar2 != null) {
            this.f6071d.f(jVar2, -1.0f);
            this.f6068a = null;
        }
        float c4 = this.f6071d.c(jVar, true) * (-1.0f);
        this.f6068a = jVar;
        if (c4 == 1.0f) {
            return;
        }
        this.f6069b /= c4;
        this.f6071d.h(c4);
    }

    public final void g(j jVar, boolean z4) {
        if (!jVar.f6108f) {
            return;
        }
        float e4 = this.f6071d.e(jVar);
        this.f6069b = (jVar.f6107e * e4) + this.f6069b;
        this.f6071d.c(jVar, z4);
        if (z4) {
            jVar.b(this);
        }
    }

    public void h(c cVar, boolean z4) {
        float b5 = this.f6071d.b(cVar, z4);
        this.f6069b = (cVar.f6069b * b5) + this.f6069b;
        if (z4) {
            cVar.f6068a.b(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r10 = this;
            p.j r0 = r10.f6068a
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L17
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            p.j r1 = r10.f6068a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L17:
            java.lang.String r1 = " = "
            java.lang.String r0 = androidx.activity.j.c(r0, r1)
            float r1 = r10.f6069b
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L39
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r10.f6069b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = r3
            goto L3a
        L39:
            r1 = r4
        L3a:
            p.b r5 = r10.f6071d
            int r5 = r5.k()
        L40:
            if (r4 >= r5) goto L9c
            p.b r6 = r10.f6071d
            p.j r6 = r6.d(r4)
            if (r6 != 0) goto L4b
            goto L99
        L4b:
            p.b r7 = r10.f6071d
            float r7 = r7.a(r4)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L56
            goto L99
        L56:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L6a
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L76
            java.lang.String r1 = "- "
        L64:
            java.lang.String r0 = androidx.activity.j.c(r0, r1)
            float r7 = r7 * r9
            goto L76
        L6a:
            if (r8 <= 0) goto L73
            java.lang.String r1 = " + "
            java.lang.String r0 = androidx.activity.j.c(r0, r1)
            goto L76
        L73:
            java.lang.String r1 = " - "
            goto L64
        L76:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L81
            java.lang.String r0 = androidx.activity.j.c(r0, r6)
            goto L98
        L81:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L98:
            r1 = r3
        L99:
            int r4 = r4 + 1
            goto L40
        L9c:
            if (r1 != 0) goto La4
            java.lang.String r1 = "0.0"
            java.lang.String r0 = androidx.activity.j.c(r0, r1)
        La4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p.c.toString():java.lang.String");
    }
}
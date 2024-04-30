package d1;

/* loaded from: classes.dex */
public abstract class l extends k {

    /* renamed from: a  reason: collision with root package name */
    public b0.f[] f4292a;

    /* renamed from: b  reason: collision with root package name */
    public String f4293b;

    /* renamed from: c  reason: collision with root package name */
    public int f4294c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4295d;

    public l() {
        this.f4292a = null;
        this.f4294c = 0;
    }

    public b0.f[] getPathData() {
        return this.f4292a;
    }

    public String getPathName() {
        return this.f4293b;
    }

    public void setPathData(b0.f[] fVarArr) {
        if (!com.google.common.collect.c.u(this.f4292a, fVarArr)) {
            this.f4292a = com.google.common.collect.c.g0(fVarArr);
            return;
        }
        b0.f[] fVarArr2 = this.f4292a;
        for (int i4 = 0; i4 < fVarArr.length; i4++) {
            fVarArr2[i4].f2495a = fVarArr[i4].f2495a;
            int i5 = 0;
            while (true) {
                float[] fArr = fVarArr[i4].f2496b;
                if (i5 < fArr.length) {
                    fVarArr2[i4].f2496b[i5] = fArr[i5];
                    i5++;
                }
            }
        }
    }

    public l(l lVar) {
        this.f4292a = null;
        this.f4294c = 0;
        this.f4293b = lVar.f4293b;
        this.f4295d = lVar.f4295d;
        this.f4292a = com.google.common.collect.c.g0(lVar.f4292a);
    }
}
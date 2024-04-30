package p;

import androidx.constraintlayout.solver.SolverVariable$Type;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public boolean f6103a;

    /* renamed from: e  reason: collision with root package name */
    public float f6107e;

    /* renamed from: i  reason: collision with root package name */
    public SolverVariable$Type f6111i;

    /* renamed from: b  reason: collision with root package name */
    public int f6104b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f6105c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f6106d = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6108f = false;

    /* renamed from: g  reason: collision with root package name */
    public final float[] f6109g = new float[9];

    /* renamed from: h  reason: collision with root package name */
    public final float[] f6110h = new float[9];

    /* renamed from: j  reason: collision with root package name */
    public c[] f6112j = new c[16];

    /* renamed from: k  reason: collision with root package name */
    public int f6113k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f6114l = 0;

    public j(SolverVariable$Type solverVariable$Type) {
        this.f6111i = solverVariable$Type;
    }

    public final void a(c cVar) {
        int i4 = 0;
        while (true) {
            int i5 = this.f6113k;
            if (i4 < i5) {
                if (this.f6112j[i4] == cVar) {
                    return;
                }
                i4++;
            } else {
                c[] cVarArr = this.f6112j;
                if (i5 >= cVarArr.length) {
                    this.f6112j = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
                }
                c[] cVarArr2 = this.f6112j;
                int i6 = this.f6113k;
                cVarArr2[i6] = cVar;
                this.f6113k = i6 + 1;
                return;
            }
        }
    }

    public final void b(c cVar) {
        int i4 = this.f6113k;
        int i5 = 0;
        while (i5 < i4) {
            if (this.f6112j[i5] == cVar) {
                while (i5 < i4 - 1) {
                    c[] cVarArr = this.f6112j;
                    int i6 = i5 + 1;
                    cVarArr[i5] = cVarArr[i6];
                    i5 = i6;
                }
                this.f6113k--;
                return;
            }
            i5++;
        }
    }

    public final void c() {
        this.f6111i = SolverVariable$Type.f1120d;
        this.f6106d = 0;
        this.f6104b = -1;
        this.f6105c = -1;
        this.f6107e = 0.0f;
        this.f6108f = false;
        int i4 = this.f6113k;
        for (int i5 = 0; i5 < i4; i5++) {
            this.f6112j[i5] = null;
        }
        this.f6113k = 0;
        this.f6114l = 0;
        this.f6103a = false;
        Arrays.fill(this.f6110h, 0.0f);
    }

    public final void d(c cVar) {
        int i4 = this.f6113k;
        for (int i5 = 0; i5 < i4; i5++) {
            this.f6112j[i5].h(cVar, false);
        }
        this.f6113k = 0;
    }

    public final String toString() {
        return "" + this.f6104b;
    }
}
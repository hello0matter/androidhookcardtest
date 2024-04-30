package q;

import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class j extends d implements i {

    /* renamed from: h0  reason: collision with root package name */
    public d[] f6284h0 = new d[4];

    /* renamed from: i0  reason: collision with root package name */
    public int f6285i0 = 0;

    public final void D(d dVar) {
        if (dVar != this && dVar != null) {
            int i4 = this.f6285i0 + 1;
            d[] dVarArr = this.f6284h0;
            if (i4 > dVarArr.length) {
                this.f6284h0 = (d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
            }
            d[] dVarArr2 = this.f6284h0;
            int i5 = this.f6285i0;
            dVarArr2[i5] = dVar;
            this.f6285i0 = i5 + 1;
        }
    }

    @Override // q.d
    public void g(d dVar, HashMap hashMap) {
        super.g(dVar, hashMap);
        j jVar = (j) dVar;
        this.f6285i0 = 0;
        int i4 = jVar.f6285i0;
        for (int i5 = 0; i5 < i4; i5++) {
            D((d) hashMap.get(jVar.f6284h0[i5]));
        }
    }

    public void a() {
    }
}
package t3;

import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;

/* loaded from: classes.dex */
public final class l extends p3.a {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ m f6756e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ boolean f6757f = false;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ d0 f6758g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(String str, m mVar, d0 d0Var) {
        super(str, true);
        this.f6756e = mVar;
        this.f6758g = d0Var;
    }

    @Override // p3.a
    public final long a() {
        long a5;
        int i4;
        int i5;
        z[] zVarArr;
        m mVar = this.f6756e;
        boolean z4 = this.f6757f;
        d0 d0Var = this.f6758g;
        mVar.getClass();
        com.google.common.collect.c.F(d0Var, "settings");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        s sVar = mVar.f6760b;
        synchronized (sVar.f6801y) {
            synchronized (sVar) {
                d0 d0Var2 = sVar.f6795s;
                if (!z4) {
                    d0 d0Var3 = new d0();
                    d0Var3.b(d0Var2);
                    d0Var3.b(d0Var);
                    d0Var = d0Var3;
                }
                ref$ObjectRef.f5198a = d0Var;
                a5 = d0Var.a() - d0Var2.a();
                i4 = (a5 > 0L ? 1 : (a5 == 0L ? 0 : -1));
                if (i4 != 0 && !sVar.f6779c.isEmpty()) {
                    zVarArr = (z[]) sVar.f6779c.values().toArray(new z[0]);
                    d0 d0Var4 = (d0) ref$ObjectRef.f5198a;
                    com.google.common.collect.c.F(d0Var4, "<set-?>");
                    sVar.f6795s = d0Var4;
                    sVar.f6787k.c(new j(sVar.f6780d + " onSettings", sVar, ref$ObjectRef, 0), 0L);
                }
                zVarArr = null;
                d0 d0Var42 = (d0) ref$ObjectRef.f5198a;
                com.google.common.collect.c.F(d0Var42, "<set-?>");
                sVar.f6795s = d0Var42;
                sVar.f6787k.c(new j(sVar.f6780d + " onSettings", sVar, ref$ObjectRef, 0), 0L);
            }
            try {
                sVar.f6801y.x((d0) ref$ObjectRef.f5198a);
            } catch (IOException e4) {
                sVar.y(e4);
            }
        }
        if (zVarArr != null) {
            for (z zVar : zVarArr) {
                synchronized (zVar) {
                    zVar.f6838f += a5;
                    if (i4 > 0) {
                        zVar.notifyAll();
                    }
                }
            }
            return -1L;
        }
        return -1L;
    }
}
package androidx.emoji2.text;

/* loaded from: classes.dex */
public final class h extends com.google.common.collect.c {

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ i f1517q;

    public h(i iVar) {
        this.f1517q = iVar;
    }

    @Override // com.google.common.collect.c
    public final void k1(Throwable th) {
        ((o) this.f1517q.f311b).d(th);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, androidx.emoji2.text.n] */
    @Override // com.google.common.collect.c
    public final void q1(d0 d0Var) {
        i iVar = this.f1517q;
        iVar.f1519f = d0Var;
        d0 d0Var2 = iVar.f1519f;
        ?? obj = new Object();
        Object obj2 = iVar.f311b;
        g gVar = ((o) obj2).f1534h;
        ((o) obj2).getClass();
        iVar.f1518e = new v(d0Var2, obj, gVar);
        ((o) iVar.f311b).e();
    }
}
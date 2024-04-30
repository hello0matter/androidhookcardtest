package androidx.fragment.app;

/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f1 f1690a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f1 f1691b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f1692c;

    public f(f1 f1Var, f1 f1Var2, boolean z4, l.b bVar) {
        this.f1690a = f1Var;
        this.f1691b = f1Var2;
        this.f1692c = z4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u0.a(this.f1690a.f1697c, this.f1691b.f1697c, this.f1692c);
    }
}
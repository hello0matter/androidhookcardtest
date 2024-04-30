package androidx.fragment.app;

/* loaded from: classes.dex */
public final class e1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1687a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f1 f1688b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g1 f1689c;

    public /* synthetic */ e1(g1 g1Var, f1 f1Var, int i4) {
        this.f1687a = i4;
        this.f1689c = g1Var;
        this.f1688b = f1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f1687a;
        f1 f1Var = this.f1688b;
        g1 g1Var = this.f1689c;
        switch (i4) {
            case 0:
                if (g1Var.f1708b.contains(f1Var)) {
                    f1Var.f1695a.a(f1Var.f1697c.E);
                    return;
                }
                return;
            default:
                g1Var.f1708b.remove(f1Var);
                g1Var.f1709c.remove(f1Var);
                return;
        }
    }
}
package androidx.appcompat.widget;

/* loaded from: classes.dex */
public final /* synthetic */ class r3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f885a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Toolbar f886b;

    public /* synthetic */ r3(Toolbar toolbar, int i4) {
        this.f885a = i4;
        this.f886b = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g.r rVar;
        int i4 = this.f885a;
        Toolbar toolbar = this.f886b;
        switch (i4) {
            case 0:
                u3 u3Var = toolbar.L;
                if (u3Var == null) {
                    rVar = null;
                } else {
                    rVar = u3Var.f920b;
                }
                if (rVar != null) {
                    rVar.collapseActionView();
                    return;
                }
                return;
            default:
                toolbar.o();
                return;
        }
    }
}
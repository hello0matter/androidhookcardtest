package androidx.appcompat.widget;

/* loaded from: classes.dex */
public final class t2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f903a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchView f904b;

    public /* synthetic */ t2(SearchView searchView, int i4) {
        this.f903a = i4;
        this.f904b = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f903a;
        SearchView searchView = this.f904b;
        switch (i4) {
            case 0:
                searchView.u();
                return;
            default:
                m0.b bVar = searchView.O;
                if (bVar instanceof i3) {
                    bVar.b(null);
                    return;
                }
                return;
        }
    }
}
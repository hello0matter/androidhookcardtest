package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class d1 extends l0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f2077a;

    public d1(RecyclerView recyclerView) {
        this.f2077a = recyclerView;
    }

    @Override // androidx.recyclerview.widget.l0
    public final void a() {
        RecyclerView recyclerView = this.f2077a;
        recyclerView.i(null);
        recyclerView.f1973d0.f2131f = true;
        recyclerView.V(true);
        if (recyclerView.f1972d.g()) {
            return;
        }
        recyclerView.requestLayout();
    }
}
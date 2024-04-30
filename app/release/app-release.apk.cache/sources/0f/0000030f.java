package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class o1 extends y0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2201a = false;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f0 f2202b;

    public o1(f0 f0Var) {
        this.f2202b = f0Var;
    }

    @Override // androidx.recyclerview.widget.y0
    public final void a(int i4, RecyclerView recyclerView) {
        if (i4 == 0 && this.f2201a) {
            this.f2201a = false;
            this.f2202b.h();
        }
    }

    @Override // androidx.recyclerview.widget.y0
    public final void b(RecyclerView recyclerView, int i4, int i5) {
        if (i4 == 0 && i5 == 0) {
            return;
        }
        this.f2201a = true;
    }
}
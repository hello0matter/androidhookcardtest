package l2;

/* loaded from: classes.dex */
public final class h implements o {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f5287a;

    public h(float f4) {
        this.f5287a = f4;
    }

    @Override // l2.o
    public final d a(d dVar) {
        if (!(dVar instanceof l)) {
            return new b(this.f5287a, dVar);
        }
        return dVar;
    }
}
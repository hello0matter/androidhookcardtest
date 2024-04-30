package p;

/* loaded from: classes.dex */
public final class h implements Comparable {

    /* renamed from: a  reason: collision with root package name */
    public j f6097a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f6098b;

    public h(i iVar) {
        this.f6098b = iVar;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f6097a.f6104b - ((j) obj).f6104b;
    }

    public final String toString() {
        String str = "[ ";
        if (this.f6097a != null) {
            for (int i4 = 0; i4 < 9; i4++) {
                str = str + this.f6097a.f6110h[i4] + " ";
            }
        }
        return str + "] " + this.f6097a;
    }
}
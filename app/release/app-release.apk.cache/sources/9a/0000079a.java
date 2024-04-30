package i3;

/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: d  reason: collision with root package name */
    public static final c f5071d = new a(1, 0, 1);

    @Override // i3.a
    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (this.f5064a == cVar.f5064a) {
                    if (this.f5065b == cVar.f5065b) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // i3.a
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f5064a * 31) + this.f5065b;
    }

    @Override // i3.a
    public final boolean isEmpty() {
        if (this.f5064a > this.f5065b) {
            return true;
        }
        return false;
    }

    @Override // i3.a
    public final String toString() {
        return this.f5064a + ".." + this.f5065b;
    }
}
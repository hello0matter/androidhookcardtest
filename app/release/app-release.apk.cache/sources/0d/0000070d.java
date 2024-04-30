package h0;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Object f4797a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f4798b;

    public c(Object obj, Object obj2) {
        this.f4797a = obj;
        this.f4798b = obj2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!b.a(cVar.f4797a, this.f4797a) || !b.a(cVar.f4798b, this.f4798b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode;
        int i4 = 0;
        Object obj = this.f4797a;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        Object obj2 = this.f4798b;
        if (obj2 != null) {
            i4 = obj2.hashCode();
        }
        return i4 ^ hashCode;
    }

    public final String toString() {
        return "Pair{" + this.f4797a + " " + this.f4798b + "}";
    }
}
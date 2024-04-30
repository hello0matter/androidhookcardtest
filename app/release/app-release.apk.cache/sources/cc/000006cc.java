package f3;

/* loaded from: classes.dex */
public final class d implements a {

    /* renamed from: a  reason: collision with root package name */
    public final Class f4577a;

    public d(Class cls) {
        com.google.common.collect.c.F(cls, "jClass");
        this.f4577a = cls;
    }

    @Override // f3.a
    public final Class a() {
        return this.f4577a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            if (com.google.common.collect.c.n(this.f4577a, ((d) obj).f4577a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f4577a.hashCode();
    }

    public final String toString() {
        return this.f4577a.toString() + " (Kotlin reflection is not available)";
    }
}
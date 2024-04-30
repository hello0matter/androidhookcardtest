package i;

import java.util.Map;

/* loaded from: classes.dex */
public final class c implements Map.Entry {

    /* renamed from: a  reason: collision with root package name */
    public final Object f4893a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f4894b;

    /* renamed from: c  reason: collision with root package name */
    public c f4895c;

    /* renamed from: d  reason: collision with root package name */
    public c f4896d;

    public c(Object obj, Object obj2) {
        this.f4893a = obj;
        this.f4894b = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f4893a.equals(cVar.f4893a) && this.f4894b.equals(cVar.f4894b)) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f4893a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f4894b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f4893a.hashCode() ^ this.f4894b.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f4893a + "=" + this.f4894b;
    }
}
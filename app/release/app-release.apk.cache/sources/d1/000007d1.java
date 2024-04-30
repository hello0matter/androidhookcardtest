package kotlin;

import com.google.common.collect.c;
import java.io.Serializable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\u00060\u0003j\u0002`\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/Pair;", "A", "B", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class Pair<A, B> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final Object f5152a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f5153b;

    public Pair(Object obj, Object obj2) {
        this.f5152a = obj;
        this.f5153b = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            return c.n(this.f5152a, pair.f5152a) && c.n(this.f5153b, pair.f5153b);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f5152a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f5153b;
        return hashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f5152a + ", " + this.f5153b + ')';
    }
}
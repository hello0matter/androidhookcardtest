package kotlin;

import java.io.Serializable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/InitializedLazyImpl;", "T", "Lx2/a;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class InitializedLazyImpl<T> implements x2.a, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final Object f5151a;

    public InitializedLazyImpl(Object obj) {
        this.f5151a = obj;
    }

    @Override // x2.a
    public final Object getValue() {
        throw null;
    }

    public final String toString() {
        return String.valueOf(this.f5151a);
    }
}
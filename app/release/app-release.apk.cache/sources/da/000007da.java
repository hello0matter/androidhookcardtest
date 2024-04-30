package kotlin;

import com.google.common.collect.c;
import java.io.Serializable;
import x2.b;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/SynchronizedLazyImpl;", "T", "Lx2/a;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class SynchronizedLazyImpl<T> implements x2.a, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public e3.a f5157a;

    /* renamed from: b  reason: collision with root package name */
    public volatile Object f5158b = b.f7142a;

    /* renamed from: c  reason: collision with root package name */
    public final Object f5159c = this;

    public SynchronizedLazyImpl(e3.a aVar) {
        this.f5157a = aVar;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // x2.a
    public final Object getValue() {
        Object obj;
        Object obj2 = this.f5158b;
        b bVar = b.f7142a;
        if (obj2 != bVar) {
            return obj2;
        }
        synchronized (this.f5159c) {
            obj = this.f5158b;
            if (obj == bVar) {
                e3.a aVar = this.f5157a;
                c.C(aVar);
                obj = aVar.a();
                this.f5158b = obj;
                this.f5157a = null;
            }
        }
        return obj;
    }

    public final String toString() {
        if (this.f5158b != b.f7142a) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }
}
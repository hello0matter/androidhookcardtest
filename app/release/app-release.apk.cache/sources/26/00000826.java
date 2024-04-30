package kotlin.random;

import g3.d;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"kotlin/random/Random$Default", "Lg3/d;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "()Ljava/lang/Object;", "defaultRandom", "Lg3/d;", "<init>", "()V", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class Random$Default extends d implements Serializable {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\bÂ\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/random/Random$Default$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "serialVersionUID", "", "readResolve", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Serialized implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public static final Serialized f5199a = new Serialized();
        private static final long serialVersionUID = 0;

        private Serialized() {
        }

        private final Object readResolve() {
            return d.f4790a;
        }
    }

    private Random$Default() {
    }

    private final Object writeReplace() {
        return Serialized.f5199a;
    }

    public /* synthetic */ Random$Default(int i4) {
        this();
    }
}
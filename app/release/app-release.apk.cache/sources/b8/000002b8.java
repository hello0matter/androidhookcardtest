package androidx.lifecycle;

/* loaded from: classes.dex */
public interface j0 {
    default h0 a(Class cls) {
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    default h0 b(Class cls, v0.d dVar) {
        return a(cls);
    }
}
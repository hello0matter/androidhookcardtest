package h;

/* loaded from: classes.dex */
public final class b extends e {

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f4793b;

    /* renamed from: a  reason: collision with root package name */
    public final d f4794a = new d();

    public static b a() {
        if (f4793b != null) {
            return f4793b;
        }
        synchronized (b.class) {
            try {
                if (f4793b == null) {
                    f4793b = new b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f4793b;
    }
}
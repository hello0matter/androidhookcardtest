package g3;

import kotlin.random.Random$Default;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Random$Default f4790a = new Random$Default(0);

    /* renamed from: b  reason: collision with root package name */
    public static final a f4791b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [g3.a] */
    /* JADX WARN: Type inference failed for: r0v6 */
    static {
        c cVar;
        Integer num = d3.a.f4420a;
        if (num != null && num.intValue() < 34) {
            cVar = new c();
        } else {
            cVar = new d();
        }
        f4791b = cVar;
    }
}
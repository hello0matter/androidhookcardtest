package p3;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f6145a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f6146b;

    /* renamed from: c  reason: collision with root package name */
    public c f6147c;

    /* renamed from: d  reason: collision with root package name */
    public long f6148d;

    public a(String str, boolean z4) {
        com.google.common.collect.c.F(str, "name");
        this.f6145a = str;
        this.f6146b = z4;
        this.f6148d = -1L;
    }

    public abstract long a();

    public final String toString() {
        return this.f6145a;
    }
}
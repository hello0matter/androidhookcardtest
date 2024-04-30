package l2;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public com.google.common.collect.c f5335a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public com.google.common.collect.c f5336b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public com.google.common.collect.c f5337c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public com.google.common.collect.c f5338d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public d f5339e = new a(0.0f);

    /* renamed from: f  reason: collision with root package name */
    public d f5340f = new a(0.0f);

    /* renamed from: g  reason: collision with root package name */
    public d f5341g = new a(0.0f);

    /* renamed from: h  reason: collision with root package name */
    public d f5342h = new a(0.0f);

    /* renamed from: i  reason: collision with root package name */
    public f f5343i = com.google.common.collect.c.b0();

    /* renamed from: j  reason: collision with root package name */
    public f f5344j = com.google.common.collect.c.b0();

    /* renamed from: k  reason: collision with root package name */
    public f f5345k = com.google.common.collect.c.b0();

    /* renamed from: l  reason: collision with root package name */
    public f f5346l = com.google.common.collect.c.b0();

    public static void b(com.google.common.collect.c cVar) {
        Object obj;
        if (cVar instanceof m) {
            obj = (m) cVar;
        } else if (cVar instanceof e) {
            obj = (e) cVar;
        } else {
            return;
        }
        obj.getClass();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [l2.p, java.lang.Object] */
    public final p a() {
        ?? obj = new Object();
        obj.f5348a = this.f5335a;
        obj.f5349b = this.f5336b;
        obj.f5350c = this.f5337c;
        obj.f5351d = this.f5338d;
        obj.f5352e = this.f5339e;
        obj.f5353f = this.f5340f;
        obj.f5354g = this.f5341g;
        obj.f5355h = this.f5342h;
        obj.f5356i = this.f5343i;
        obj.f5357j = this.f5344j;
        obj.f5358k = this.f5345k;
        obj.f5359l = this.f5346l;
        return obj;
    }

    public final void c(float f4) {
        this.f5339e = new a(f4);
        this.f5340f = new a(f4);
        this.f5341g = new a(f4);
        this.f5342h = new a(f4);
    }
}
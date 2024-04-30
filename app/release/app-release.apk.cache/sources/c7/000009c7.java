package t3;

/* loaded from: classes.dex */
public final class x implements y3.t {

    /* renamed from: a  reason: collision with root package name */
    public final long f6826a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6827b;

    /* renamed from: c  reason: collision with root package name */
    public final y3.f f6828c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final y3.f f6829d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public boolean f6830e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ z f6831f;

    /* JADX WARN: Type inference failed for: r1v1, types: [y3.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v2, types: [y3.f, java.lang.Object] */
    public x(z zVar, long j4, boolean z4) {
        this.f6831f = zVar;
        this.f6826a = j4;
        this.f6827b = z4;
    }

    @Override // y3.t
    public final y3.v a() {
        return this.f6831f.f6843k;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        long j4;
        z zVar = this.f6831f;
        synchronized (zVar) {
            this.f6830e = true;
            y3.f fVar = this.f6829d;
            j4 = fVar.f7180b;
            fVar.h(j4);
            zVar.notifyAll();
        }
        if (j4 > 0) {
            byte[] bArr = n3.b.f5783a;
            this.f6831f.f6834b.C(j4);
        }
        this.f6831f.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x009f, code lost:
        throw new java.io.IOException("stream closed");
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008a A[LOOP:0: B:4:0x0010->B:45:0x008a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x008d A[SYNTHETIC] */
    @Override // y3.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long w(y3.f r16, long r17) {
        /*
            Method dump skipped, instructions count: 196
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.x.w(y3.f, long):long");
    }
}
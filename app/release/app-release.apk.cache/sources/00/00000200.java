package androidx.core.widget;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public int f1423a;

    /* renamed from: b  reason: collision with root package name */
    public int f1424b;

    /* renamed from: c  reason: collision with root package name */
    public float f1425c;

    /* renamed from: d  reason: collision with root package name */
    public float f1426d;

    /* renamed from: e  reason: collision with root package name */
    public long f1427e;

    /* renamed from: f  reason: collision with root package name */
    public long f1428f;

    /* renamed from: g  reason: collision with root package name */
    public long f1429g;

    /* renamed from: h  reason: collision with root package name */
    public float f1430h;

    /* renamed from: i  reason: collision with root package name */
    public int f1431i;

    public final float a(long j4) {
        long j5 = this.f1427e;
        if (j4 < j5) {
            return 0.0f;
        }
        long j6 = this.f1429g;
        if (j6 < 0 || j4 < j6) {
            return h.b(((float) (j4 - j5)) / this.f1423a, 0.0f, 1.0f) * 0.5f;
        }
        float f4 = this.f1430h;
        return (h.b(((float) (j4 - j6)) / this.f1431i, 0.0f, 1.0f) * f4) + (1.0f - f4);
    }
}
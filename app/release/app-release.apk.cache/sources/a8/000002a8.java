package androidx.lifecycle;

import android.os.Handler;

/* loaded from: classes.dex */
public final class b0 implements q {

    /* renamed from: i  reason: collision with root package name */
    public static final b0 f1883i = new b0();

    /* renamed from: a  reason: collision with root package name */
    public int f1884a;

    /* renamed from: b  reason: collision with root package name */
    public int f1885b;

    /* renamed from: e  reason: collision with root package name */
    public Handler f1888e;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1886c = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1887d = true;

    /* renamed from: f  reason: collision with root package name */
    public final s f1889f = new s(this);

    /* renamed from: g  reason: collision with root package name */
    public final androidx.activity.d f1890g = new androidx.activity.d(5, this);

    /* renamed from: h  reason: collision with root package name */
    public final a0 f1891h = new a0(this);

    public final void a() {
        int i4 = this.f1885b + 1;
        this.f1885b = i4;
        if (i4 == 1) {
            if (this.f1886c) {
                this.f1889f.e(Lifecycle$Event.ON_RESUME);
                this.f1886c = false;
                return;
            }
            Handler handler = this.f1888e;
            com.google.common.collect.c.C(handler);
            handler.removeCallbacks(this.f1890g);
        }
    }

    @Override // androidx.lifecycle.q
    public final s f() {
        return this.f1889f;
    }
}
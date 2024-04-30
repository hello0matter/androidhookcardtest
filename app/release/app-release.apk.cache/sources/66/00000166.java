package androidx.appcompat.widget;

/* loaded from: classes.dex */
public final class o2 {

    /* renamed from: a  reason: collision with root package name */
    public int f860a;

    /* renamed from: b  reason: collision with root package name */
    public int f861b;

    /* renamed from: c  reason: collision with root package name */
    public int f862c;

    /* renamed from: d  reason: collision with root package name */
    public int f863d;

    /* renamed from: e  reason: collision with root package name */
    public int f864e;

    /* renamed from: f  reason: collision with root package name */
    public int f865f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f866g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f867h;

    public final void a(int i4, int i5) {
        this.f862c = i4;
        this.f863d = i5;
        this.f867h = true;
        if (this.f866g) {
            if (i5 != Integer.MIN_VALUE) {
                this.f860a = i5;
            }
            if (i4 != Integer.MIN_VALUE) {
                this.f861b = i4;
                return;
            }
            return;
        }
        if (i4 != Integer.MIN_VALUE) {
            this.f860a = i4;
        }
        if (i5 != Integer.MIN_VALUE) {
            this.f861b = i5;
        }
    }
}
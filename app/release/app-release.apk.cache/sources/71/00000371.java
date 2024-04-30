package b0;

import android.graphics.Insets;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: e  reason: collision with root package name */
    public static final c f2489e = new c(0, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final int f2490a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2491b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2492c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2493d;

    public c(int i4, int i5, int i6, int i7) {
        this.f2490a = i4;
        this.f2491b = i5;
        this.f2492c = i6;
        this.f2493d = i7;
    }

    public static c a(c cVar, c cVar2) {
        return b(Math.max(cVar.f2490a, cVar2.f2490a), Math.max(cVar.f2491b, cVar2.f2491b), Math.max(cVar.f2492c, cVar2.f2492c), Math.max(cVar.f2493d, cVar2.f2493d));
    }

    public static c b(int i4, int i5, int i6, int i7) {
        if (i4 == 0 && i5 == 0 && i6 == 0 && i7 == 0) {
            return f2489e;
        }
        return new c(i4, i5, i6, i7);
    }

    public static c c(Insets insets) {
        int i4;
        int i5;
        int i6;
        int i7;
        i4 = insets.left;
        i5 = insets.top;
        i6 = insets.right;
        i7 = insets.bottom;
        return b(i4, i5, i6, i7);
    }

    public final Insets d() {
        return b.a(this.f2490a, this.f2491b, this.f2492c, this.f2493d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f2493d == cVar.f2493d && this.f2490a == cVar.f2490a && this.f2492c == cVar.f2492c && this.f2491b == cVar.f2491b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.f2490a * 31) + this.f2491b) * 31) + this.f2492c) * 31) + this.f2493d;
    }

    public final String toString() {
        return "Insets{left=" + this.f2490a + ", top=" + this.f2491b + ", right=" + this.f2492c + ", bottom=" + this.f2493d + '}';
    }
}
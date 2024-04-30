package i1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final int f5022a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5023b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5024c;

    /* renamed from: d  reason: collision with root package name */
    public final String f5025d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5026e;

    /* renamed from: f  reason: collision with root package name */
    public final List f5027f;

    /* renamed from: g  reason: collision with root package name */
    public final long f5028g;

    /* renamed from: h  reason: collision with root package name */
    public final int f5029h;

    /* renamed from: i  reason: collision with root package name */
    public final int f5030i;

    /* renamed from: j  reason: collision with root package name */
    public final float f5031j;

    /* renamed from: k  reason: collision with root package name */
    public final float f5032k;

    /* renamed from: l  reason: collision with root package name */
    public final int f5033l;

    /* renamed from: m  reason: collision with root package name */
    public final int f5034m;

    /* renamed from: n  reason: collision with root package name */
    public final int f5035n;

    /* renamed from: o  reason: collision with root package name */
    public final int f5036o;

    /* renamed from: p  reason: collision with root package name */
    public final int f5037p;

    /* renamed from: q  reason: collision with root package name */
    public final int f5038q;

    /* renamed from: r  reason: collision with root package name */
    public final int f5039r;

    /* renamed from: s  reason: collision with root package name */
    public int f5040s;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, i1.c] */
    static {
        new d(new Object());
        l1.d.b(0);
        l1.d.b(1);
        l1.d.b(2);
        l1.d.b(3);
        l1.d.b(4);
        l1.d.b(5);
        l1.d.b(6);
        l1.d.b(7);
        l1.d.b(8);
        l1.d.b(9);
        l1.d.b(10);
        l1.d.b(11);
        l1.d.b(12);
        l1.d.b(13);
        l1.d.b(14);
        l1.d.b(15);
        l1.d.b(16);
        l1.d.b(17);
        l1.d.b(18);
        l1.d.b(19);
        l1.d.b(20);
        l1.d.b(21);
        l1.d.b(22);
        l1.d.b(23);
        l1.d.b(24);
        l1.d.b(25);
        l1.d.b(26);
        l1.d.b(27);
        l1.d.b(28);
        l1.d.b(29);
        l1.d.b(30);
        l1.d.b(31);
    }

    public d(c cVar) {
        cVar.getClass();
        int i4 = l1.d.f5272a;
        this.f5022a = -1;
        this.f5023b = -1;
        this.f5024c = -1;
        this.f5025d = cVar.f5021a;
        this.f5026e = -1;
        this.f5027f = Collections.emptyList();
        this.f5028g = Long.MAX_VALUE;
        this.f5029h = -1;
        this.f5030i = -1;
        this.f5031j = -1.0f;
        this.f5032k = 1.0f;
        this.f5033l = -1;
        this.f5034m = -1;
        this.f5035n = -1;
        this.f5036o = -1;
        this.f5037p = -1;
        this.f5038q = -1;
        this.f5039r = -1;
    }

    public final boolean equals(Object obj) {
        int i4;
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        int i5 = this.f5040s;
        if (i5 != 0 && (i4 = dVar.f5040s) != 0 && i5 != i4) {
            return false;
        }
        if (this.f5022a == dVar.f5022a && this.f5023b == dVar.f5023b && this.f5026e == dVar.f5026e && this.f5028g == dVar.f5028g && this.f5029h == dVar.f5029h && this.f5030i == dVar.f5030i && this.f5033l == dVar.f5033l && this.f5034m == dVar.f5034m && this.f5035n == dVar.f5035n && this.f5036o == dVar.f5036o && this.f5037p == dVar.f5037p && this.f5038q == dVar.f5038q && this.f5039r == dVar.f5039r && Float.compare(this.f5031j, dVar.f5031j) == 0 && Float.compare(this.f5032k, dVar.f5032k) == 0 && l1.d.a(null, null) && l1.d.a(null, null) && l1.d.a(null, null) && l1.d.a(null, null) && l1.d.a(this.f5025d, dVar.f5025d) && l1.d.a(null, null) && Arrays.equals((byte[]) null, (byte[]) null) && l1.d.a(null, null) && l1.d.a(null, null) && l1.d.a(null, null)) {
            List list = this.f5027f;
            int size = list.size();
            List list2 = dVar.f5027f;
            if (size == list2.size()) {
                for (int i6 = 0; i6 < list.size(); i6++) {
                    if (Arrays.equals((byte[]) list.get(i6), (byte[]) list2.get(i6))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        if (this.f5040s == 0) {
            int i4 = ((((527 * 31 * 923521) + this.f5022a) * 31) + this.f5023b) * 923521;
            String str = this.f5025d;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int floatToIntBits = Float.floatToIntBits(this.f5031j);
            this.f5040s = (((((((((((((((Float.floatToIntBits(this.f5032k) + ((floatToIntBits + ((((((((((i4 + hashCode) * 31) + this.f5026e) * 31) + ((int) this.f5028g)) * 31) + this.f5029h) * 31) + this.f5030i) * 31)) * 961)) * 31) + this.f5033l) * 31) + this.f5034m) * 31) + this.f5035n) * 31) + this.f5036o) * 29791) + this.f5037p) * 31) + this.f5038q) * 31) + this.f5039r) * 31;
        }
        return this.f5040s;
    }

    public final String toString() {
        return "Format(null, null, null, " + this.f5025d + ", null, " + this.f5024c + ", null, [" + this.f5029h + ", " + this.f5030i + ", " + this.f5031j + ", null], [" + this.f5034m + ", " + this.f5035n + "])";
    }
}
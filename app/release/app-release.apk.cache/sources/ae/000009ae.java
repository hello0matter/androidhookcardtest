package t3;

import okio.ByteString;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: d  reason: collision with root package name */
    public static final ByteString f6702d;

    /* renamed from: e  reason: collision with root package name */
    public static final ByteString f6703e;

    /* renamed from: f  reason: collision with root package name */
    public static final ByteString f6704f;

    /* renamed from: g  reason: collision with root package name */
    public static final ByteString f6705g;

    /* renamed from: h  reason: collision with root package name */
    public static final ByteString f6706h;

    /* renamed from: i  reason: collision with root package name */
    public static final ByteString f6707i;

    /* renamed from: a  reason: collision with root package name */
    public final ByteString f6708a;

    /* renamed from: b  reason: collision with root package name */
    public final ByteString f6709b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6710c;

    static {
        ByteString byteString = ByteString.f6049d;
        f6702d = a.h(":");
        f6703e = a.h(":status");
        f6704f = a.h(":method");
        f6705g = a.h(":path");
        f6706h = a.h(":scheme");
        f6707i = a.h(":authority");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(String str, String str2) {
        this(a.h(str), a.h(str2));
        com.google.common.collect.c.F(str, "name");
        com.google.common.collect.c.F(str2, "value");
        ByteString byteString = ByteString.f6049d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (com.google.common.collect.c.n(this.f6708a, bVar.f6708a) && com.google.common.collect.c.n(this.f6709b, bVar.f6709b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f6709b.hashCode() + (this.f6708a.hashCode() * 31);
    }

    public final String toString() {
        return this.f6708a.j() + ": " + this.f6709b.j();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(ByteString byteString, String str) {
        this(byteString, a.h(str));
        com.google.common.collect.c.F(byteString, "name");
        com.google.common.collect.c.F(str, "value");
        ByteString byteString2 = ByteString.f6049d;
    }

    public b(ByteString byteString, ByteString byteString2) {
        com.google.common.collect.c.F(byteString, "name");
        com.google.common.collect.c.F(byteString2, "value");
        this.f6708a = byteString;
        this.f6709b = byteString2;
        this.f6710c = byteString2.c() + byteString.c() + 32;
    }
}
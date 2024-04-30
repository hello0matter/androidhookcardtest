package e0;

import java.util.Locale;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: b  reason: collision with root package name */
    public static final f f4426b = new f(new h(e.a(new Locale[0])));

    /* renamed from: a  reason: collision with root package name */
    public final g f4427a;

    public f(h hVar) {
        this.f4427a = hVar;
    }

    public static f a(String str) {
        if (str != null && !str.isEmpty()) {
            String[] split = str.split(",", -1);
            int length = split.length;
            Locale[] localeArr = new Locale[length];
            for (int i4 = 0; i4 < length; i4++) {
                localeArr[i4] = d.a(split[i4]);
            }
            return new f(new h(e.a(localeArr)));
        }
        return f4426b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            if (this.f4427a.equals(((f) obj).f4427a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f4427a.hashCode();
    }

    public final String toString() {
        return this.f4427a.toString();
    }
}
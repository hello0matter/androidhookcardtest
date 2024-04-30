package s3;

import m3.l;
import m3.m;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final y3.h f6535a;

    /* renamed from: b  reason: collision with root package name */
    public long f6536b = 262144;

    public a(y3.h hVar) {
        this.f6535a = hVar;
    }

    public final m a() {
        l lVar = new l();
        while (true) {
            String g4 = this.f6535a.g(this.f6536b);
            this.f6536b -= g4.length();
            if (g4.length() == 0) {
                return lVar.b();
            }
            int t22 = kotlin.text.b.t2(g4, ':', 1, false, 4);
            if (t22 != -1) {
                String substring = g4.substring(0, t22);
                com.google.common.collect.c.E(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String substring2 = g4.substring(t22 + 1);
                com.google.common.collect.c.E(substring2, "this as java.lang.String).substring(startIndex)");
                lVar.a(substring, substring2);
            } else {
                if (g4.charAt(0) == ':') {
                    g4 = g4.substring(1);
                    com.google.common.collect.c.E(g4, "this as java.lang.String).substring(startIndex)");
                }
                lVar.a("", g4);
            }
        }
    }
}
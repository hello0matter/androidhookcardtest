package m3;

import androidx.fragment.app.m0;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    public o f5602a;

    /* renamed from: d  reason: collision with root package name */
    public u f5605d;

    /* renamed from: e  reason: collision with root package name */
    public LinkedHashMap f5606e = new LinkedHashMap();

    /* renamed from: b  reason: collision with root package name */
    public String f5603b = "GET";

    /* renamed from: c  reason: collision with root package name */
    public l f5604c = new l();

    public final androidx.appcompat.widget.z a() {
        Map unmodifiableMap;
        o oVar = this.f5602a;
        if (oVar != null) {
            String str = this.f5603b;
            m b5 = this.f5604c.b();
            u uVar = this.f5605d;
            LinkedHashMap linkedHashMap = this.f5606e;
            byte[] bArr = n3.b.f5783a;
            com.google.common.collect.c.F(linkedHashMap, "<this>");
            if (linkedHashMap.isEmpty()) {
                unmodifiableMap = kotlin.collections.b.h2();
            } else {
                unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(linkedHashMap));
                com.google.common.collect.c.E(unmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
            }
            return new androidx.appcompat.widget.z(oVar, str, b5, uVar, unmodifiableMap);
        }
        throw new IllegalStateException("url == null".toString());
    }

    public final void b(String str, String str2) {
        com.google.common.collect.c.F(str2, "value");
        l lVar = this.f5604c;
        lVar.getClass();
        m0.f(str);
        m0.g(str2, str);
        lVar.c(str);
        lVar.a(str, str2);
    }

    public final void c(String str, u uVar) {
        boolean z4;
        if (str.length() > 0) {
            if (uVar == null) {
                if (!com.google.common.collect.c.n(str, "POST") && !com.google.common.collect.c.n(str, "PUT") && !com.google.common.collect.c.n(str, "PATCH") && !com.google.common.collect.c.n(str, "PROPPATCH") && !com.google.common.collect.c.n(str, "REPORT")) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (!(!z4)) {
                    throw new IllegalArgumentException(androidx.activity.j.d("method ", str, " must have a request body.").toString());
                }
            } else if (!com.google.common.collect.c.B1(str)) {
                throw new IllegalArgumentException(androidx.activity.j.d("method ", str, " must not have a request body.").toString());
            }
            this.f5603b = str;
            this.f5605d = uVar;
            return;
        }
        throw new IllegalArgumentException("method.isEmpty() == true".toString());
    }
}
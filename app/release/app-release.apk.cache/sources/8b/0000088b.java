package m3;

import java.util.ArrayList;
import java.util.Arrays;
import okhttp3.TlsVersion;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5506a = true;

    /* renamed from: b  reason: collision with root package name */
    public String[] f5507b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f5508c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5509d;

    public final g a() {
        return new g(this.f5506a, this.f5509d, this.f5507b, this.f5508c);
    }

    public final void b(String... strArr) {
        boolean z4;
        com.google.common.collect.c.F(strArr, "cipherSuites");
        if (this.f5506a) {
            if (strArr.length == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4) {
                this.f5507b = (String[]) strArr.clone();
                return;
            }
            throw new IllegalArgumentException("At least one cipher suite is required".toString());
        }
        throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
    }

    public final void c(e... eVarArr) {
        com.google.common.collect.c.F(eVarArr, "cipherSuites");
        if (this.f5506a) {
            ArrayList arrayList = new ArrayList(eVarArr.length);
            for (e eVar : eVarArr) {
                arrayList.add(eVar.f5505a);
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            b((String[]) Arrays.copyOf(strArr, strArr.length));
            return;
        }
        throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
    }

    public final void d() {
        if (this.f5506a) {
            this.f5509d = true;
            return;
        }
        throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
    }

    public final void e(String... strArr) {
        boolean z4;
        com.google.common.collect.c.F(strArr, "tlsVersions");
        if (this.f5506a) {
            if (strArr.length == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4) {
                this.f5508c = (String[]) strArr.clone();
                return;
            }
            throw new IllegalArgumentException("At least one TLS version is required".toString());
        }
        throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
    }

    public final void f(TlsVersion... tlsVersionArr) {
        if (this.f5506a) {
            ArrayList arrayList = new ArrayList(tlsVersionArr.length);
            for (TlsVersion tlsVersion : tlsVersionArr) {
                arrayList.add(tlsVersion.f6003a);
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            e((String[]) Arrays.copyOf(strArr, strArr.length));
            return;
        }
        throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
    }
}
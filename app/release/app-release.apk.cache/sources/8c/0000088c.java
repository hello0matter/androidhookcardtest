package m3;

import androidx.fragment.app.m0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import okhttp3.TlsVersion;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: e  reason: collision with root package name */
    public static final g f5510e;

    /* renamed from: f  reason: collision with root package name */
    public static final g f5511f;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f5512a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f5513b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f5514c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f5515d;

    static {
        e eVar = e.f5502r;
        e eVar2 = e.f5503s;
        e eVar3 = e.f5504t;
        e eVar4 = e.f5496l;
        e eVar5 = e.f5498n;
        e eVar6 = e.f5497m;
        e eVar7 = e.f5499o;
        e eVar8 = e.f5501q;
        e eVar9 = e.f5500p;
        e[] eVarArr = {eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9, e.f5494j, e.f5495k, e.f5492h, e.f5493i, e.f5490f, e.f5491g, e.f5489e};
        f fVar = new f();
        fVar.c((e[]) Arrays.copyOf(new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9}, 9));
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        fVar.f(tlsVersion, tlsVersion2);
        fVar.d();
        fVar.a();
        f fVar2 = new f();
        fVar2.c((e[]) Arrays.copyOf(eVarArr, 16));
        fVar2.f(tlsVersion, tlsVersion2);
        fVar2.d();
        f5510e = fVar2.a();
        f fVar3 = new f();
        fVar3.c((e[]) Arrays.copyOf(eVarArr, 16));
        fVar3.f(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0);
        fVar3.d();
        fVar3.a();
        f5511f = new g(false, false, null, null);
    }

    public g(boolean z4, boolean z5, String[] strArr, String[] strArr2) {
        this.f5512a = z4;
        this.f5513b = z5;
        this.f5514c = strArr;
        this.f5515d = strArr2;
    }

    public final List a() {
        String[] strArr = this.f5514c;
        if (strArr != null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                arrayList.add(e.f5486b.i(str));
            }
            return y2.l.q2(arrayList);
        }
        return null;
    }

    public final boolean b(SSLSocket sSLSocket) {
        if (!this.f5512a) {
            return false;
        }
        String[] strArr = this.f5515d;
        if (strArr != null && !n3.b.j(strArr, sSLSocket.getEnabledProtocols(), z2.a.f7232a)) {
            return false;
        }
        String[] strArr2 = this.f5514c;
        if (strArr2 != null && !n3.b.j(strArr2, sSLSocket.getEnabledCipherSuites(), e.f5487c)) {
            return false;
        }
        return true;
    }

    public final List c() {
        String[] strArr = this.f5515d;
        if (strArr != null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                arrayList.add(m0.j(str));
            }
            return y2.l.q2(arrayList);
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        g gVar = (g) obj;
        boolean z4 = gVar.f5512a;
        boolean z5 = this.f5512a;
        if (z5 != z4) {
            return false;
        }
        if (z5 && (!Arrays.equals(this.f5514c, gVar.f5514c) || !Arrays.equals(this.f5515d, gVar.f5515d) || this.f5513b != gVar.f5513b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i4;
        if (this.f5512a) {
            int i5 = 0;
            String[] strArr = this.f5514c;
            if (strArr != null) {
                i4 = Arrays.hashCode(strArr);
            } else {
                i4 = 0;
            }
            int i6 = (527 + i4) * 31;
            String[] strArr2 = this.f5515d;
            if (strArr2 != null) {
                i5 = Arrays.hashCode(strArr2);
            }
            return ((i6 + i5) * 31) + (!this.f5513b ? 1 : 0);
        }
        return 17;
    }

    public final String toString() {
        if (!this.f5512a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(a(), "[all enabled]") + ", tlsVersions=" + Objects.toString(c(), "[all enabled]") + ", supportsTlsExtensions=" + this.f5513b + ')';
    }
}
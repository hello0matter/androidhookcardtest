package f0;

import android.util.Base64;
import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f4515a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4516b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4517c;

    /* renamed from: d  reason: collision with root package name */
    public final List f4518d;

    /* renamed from: e  reason: collision with root package name */
    public final String f4519e;

    public e(String str, String str2, String str3, List list) {
        str.getClass();
        this.f4515a = str;
        str2.getClass();
        this.f4516b = str2;
        this.f4517c = str3;
        list.getClass();
        this.f4518d = list;
        this.f4519e = str + "-" + str2 + "-" + str3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f4515a + ", mProviderPackage: " + this.f4516b + ", mQuery: " + this.f4517c + ", mCertificates:");
        int i4 = 0;
        while (true) {
            List list = this.f4518d;
            if (i4 < list.size()) {
                sb.append(" [");
                List list2 = (List) list.get(i4);
                for (int i5 = 0; i5 < list2.size(); i5++) {
                    sb.append(" \"");
                    sb.append(Base64.encodeToString((byte[]) list2.get(i5), 0));
                    sb.append("\"");
                }
                sb.append(" ]");
                i4++;
            } else {
                sb.append("}mCertificatesArray: 0");
                return sb.toString();
            }
        }
    }
}
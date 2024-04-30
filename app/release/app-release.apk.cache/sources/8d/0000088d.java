package m3;

import java.text.DateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: j  reason: collision with root package name */
    public static final Pattern f5516j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k  reason: collision with root package name */
    public static final Pattern f5517k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l  reason: collision with root package name */
    public static final Pattern f5518l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m  reason: collision with root package name */
    public static final Pattern f5519m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a  reason: collision with root package name */
    public final String f5520a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5521b;

    /* renamed from: c  reason: collision with root package name */
    public final long f5522c;

    /* renamed from: d  reason: collision with root package name */
    public final String f5523d;

    /* renamed from: e  reason: collision with root package name */
    public final String f5524e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f5525f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f5526g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f5527h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f5528i;

    public h(String str, String str2, long j4, String str3, String str4, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f5520a = str;
        this.f5521b = str2;
        this.f5522c = j4;
        this.f5523d = str3;
        this.f5524e = str4;
        this.f5525f = z4;
        this.f5526g = z5;
        this.f5527h = z6;
        this.f5528i = z7;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (com.google.common.collect.c.n(hVar.f5520a, this.f5520a) && com.google.common.collect.c.n(hVar.f5521b, this.f5521b) && hVar.f5522c == this.f5522c && com.google.common.collect.c.n(hVar.f5523d, this.f5523d) && com.google.common.collect.c.n(hVar.f5524e, this.f5524e) && hVar.f5525f == this.f5525f && hVar.f5526g == this.f5526g && hVar.f5527h == this.f5527h && hVar.f5528i == this.f5528i) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.f5521b.hashCode();
        int hashCode2 = Long.hashCode(this.f5522c);
        int hashCode3 = this.f5523d.hashCode();
        int hashCode4 = this.f5524e.hashCode();
        int hashCode5 = Boolean.hashCode(this.f5525f);
        int hashCode6 = Boolean.hashCode(this.f5526g);
        int hashCode7 = Boolean.hashCode(this.f5527h);
        return Boolean.hashCode(this.f5528i) + ((hashCode7 + ((hashCode6 + ((hashCode5 + ((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + ((this.f5520a.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5520a);
        sb.append('=');
        sb.append(this.f5521b);
        if (this.f5527h) {
            long j4 = this.f5522c;
            if (j4 == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                String format = ((DateFormat) r3.c.f6471a.get()).format(new Date(j4));
                com.google.common.collect.c.E(format, "STANDARD_DATE_FORMAT.get().format(this)");
                sb.append(format);
            }
        }
        if (!this.f5528i) {
            sb.append("; domain=");
            sb.append(this.f5523d);
        }
        sb.append("; path=");
        sb.append(this.f5524e);
        if (this.f5525f) {
            sb.append("; secure");
        }
        if (this.f5526g) {
            sb.append("; httponly");
        }
        String sb2 = sb.toString();
        com.google.common.collect.c.E(sb2, "toString()");
        return sb2;
    }
}
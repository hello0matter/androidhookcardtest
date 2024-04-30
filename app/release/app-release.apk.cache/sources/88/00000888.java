package m3;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: n  reason: collision with root package name */
    public static final /* synthetic */ int f5472n = 0;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f5473a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f5474b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5475c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5476d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f5477e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f5478f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f5479g;

    /* renamed from: h  reason: collision with root package name */
    public final int f5480h;

    /* renamed from: i  reason: collision with root package name */
    public final int f5481i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f5482j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f5483k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f5484l;

    /* renamed from: m  reason: collision with root package name */
    public String f5485m;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        com.google.common.collect.c.F(timeUnit, "timeUnit");
        timeUnit.toSeconds(Integer.MAX_VALUE);
    }

    public c(boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, int i6, int i7, boolean z9, boolean z10, boolean z11, String str) {
        this.f5473a = z4;
        this.f5474b = z5;
        this.f5475c = i4;
        this.f5476d = i5;
        this.f5477e = z6;
        this.f5478f = z7;
        this.f5479g = z8;
        this.f5480h = i6;
        this.f5481i = i7;
        this.f5482j = z9;
        this.f5483k = z10;
        this.f5484l = z11;
        this.f5485m = str;
    }

    public final String toString() {
        String str = this.f5485m;
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            if (this.f5473a) {
                sb.append("no-cache, ");
            }
            if (this.f5474b) {
                sb.append("no-store, ");
            }
            int i4 = this.f5475c;
            if (i4 != -1) {
                sb.append("max-age=");
                sb.append(i4);
                sb.append(", ");
            }
            int i5 = this.f5476d;
            if (i5 != -1) {
                sb.append("s-maxage=");
                sb.append(i5);
                sb.append(", ");
            }
            if (this.f5477e) {
                sb.append("private, ");
            }
            if (this.f5478f) {
                sb.append("public, ");
            }
            if (this.f5479g) {
                sb.append("must-revalidate, ");
            }
            int i6 = this.f5480h;
            if (i6 != -1) {
                sb.append("max-stale=");
                sb.append(i6);
                sb.append(", ");
            }
            int i7 = this.f5481i;
            if (i7 != -1) {
                sb.append("min-fresh=");
                sb.append(i7);
                sb.append(", ");
            }
            if (this.f5482j) {
                sb.append("only-if-cached, ");
            }
            if (this.f5483k) {
                sb.append("no-transform, ");
            }
            if (this.f5484l) {
                sb.append("immutable, ");
            }
            if (sb.length() == 0) {
                return "";
            }
            sb.delete(sb.length() - 2, sb.length());
            String sb2 = sb.toString();
            com.google.common.collect.c.E(sb2, "StringBuilder().apply(builderAction).toString()");
            this.f5485m = sb2;
            return sb2;
        }
        return str;
    }
}
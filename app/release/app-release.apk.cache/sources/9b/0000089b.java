package m3;

import okhttp3.Protocol;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    public androidx.appcompat.widget.z f5611a;

    /* renamed from: b  reason: collision with root package name */
    public Protocol f5612b;

    /* renamed from: d  reason: collision with root package name */
    public String f5614d;

    /* renamed from: e  reason: collision with root package name */
    public okhttp3.c f5615e;

    /* renamed from: g  reason: collision with root package name */
    public y f5617g;

    /* renamed from: h  reason: collision with root package name */
    public w f5618h;

    /* renamed from: i  reason: collision with root package name */
    public w f5619i;

    /* renamed from: j  reason: collision with root package name */
    public w f5620j;

    /* renamed from: k  reason: collision with root package name */
    public long f5621k;

    /* renamed from: l  reason: collision with root package name */
    public long f5622l;

    /* renamed from: m  reason: collision with root package name */
    public q3.e f5623m;

    /* renamed from: c  reason: collision with root package name */
    public int f5613c = -1;

    /* renamed from: f  reason: collision with root package name */
    public l f5616f = new l();

    public static void b(String str, w wVar) {
        if (wVar != null) {
            if (wVar.f5630g == null) {
                if (wVar.f5631h == null) {
                    if (wVar.f5632i == null) {
                        if (wVar.f5633j != null) {
                            throw new IllegalArgumentException(str.concat(".priorResponse != null").toString());
                        }
                        return;
                    }
                    throw new IllegalArgumentException(str.concat(".cacheResponse != null").toString());
                }
                throw new IllegalArgumentException(str.concat(".networkResponse != null").toString());
            }
            throw new IllegalArgumentException(str.concat(".body != null").toString());
        }
    }

    public final w a() {
        int i4 = this.f5613c;
        if (i4 >= 0) {
            androidx.appcompat.widget.z zVar = this.f5611a;
            if (zVar != null) {
                Protocol protocol = this.f5612b;
                if (protocol != null) {
                    String str = this.f5614d;
                    if (str != null) {
                        return new w(zVar, protocol, str, i4, this.f5615e, this.f5616f.b(), this.f5617g, this.f5618h, this.f5619i, this.f5620j, this.f5621k, this.f5622l, this.f5623m);
                    }
                    throw new IllegalStateException("message == null".toString());
                }
                throw new IllegalStateException("protocol == null".toString());
            }
            throw new IllegalStateException("request == null".toString());
        }
        throw new IllegalStateException(("code < 0: " + this.f5613c).toString());
    }
}
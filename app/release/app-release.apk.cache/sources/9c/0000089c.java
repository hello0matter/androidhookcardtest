package m3;

import java.io.Closeable;
import okhttp3.Protocol;

/* loaded from: classes.dex */
public final class w implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final androidx.appcompat.widget.z f5624a;

    /* renamed from: b  reason: collision with root package name */
    public final Protocol f5625b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5626c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5627d;

    /* renamed from: e  reason: collision with root package name */
    public final okhttp3.c f5628e;

    /* renamed from: f  reason: collision with root package name */
    public final m f5629f;

    /* renamed from: g  reason: collision with root package name */
    public final y f5630g;

    /* renamed from: h  reason: collision with root package name */
    public final w f5631h;

    /* renamed from: i  reason: collision with root package name */
    public final w f5632i;

    /* renamed from: j  reason: collision with root package name */
    public final w f5633j;

    /* renamed from: k  reason: collision with root package name */
    public final long f5634k;

    /* renamed from: l  reason: collision with root package name */
    public final long f5635l;

    /* renamed from: m  reason: collision with root package name */
    public final q3.e f5636m;

    public w(androidx.appcompat.widget.z zVar, Protocol protocol, String str, int i4, okhttp3.c cVar, m mVar, y yVar, w wVar, w wVar2, w wVar3, long j4, long j5, q3.e eVar) {
        this.f5624a = zVar;
        this.f5625b = protocol;
        this.f5626c = str;
        this.f5627d = i4;
        this.f5628e = cVar;
        this.f5629f = mVar;
        this.f5630g = yVar;
        this.f5631h = wVar;
        this.f5632i = wVar2;
        this.f5633j = wVar3;
        this.f5634k = j4;
        this.f5635l = j5;
        this.f5636m = eVar;
    }

    public static String x(w wVar, String str) {
        wVar.getClass();
        String a5 = wVar.f5629f.a(str);
        if (a5 == null) {
            return null;
        }
        return a5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        y yVar = this.f5630g;
        if (yVar != null) {
            yVar.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
    }

    public final String toString() {
        return "Response{protocol=" + this.f5625b + ", code=" + this.f5627d + ", message=" + this.f5626c + ", url=" + ((o) this.f5624a.f989b) + '}';
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, m3.v] */
    public final v y() {
        ?? obj = new Object();
        obj.f5611a = this.f5624a;
        obj.f5612b = this.f5625b;
        obj.f5613c = this.f5627d;
        obj.f5614d = this.f5626c;
        obj.f5615e = this.f5628e;
        obj.f5616f = this.f5629f.c();
        obj.f5617g = this.f5630g;
        obj.f5618h = this.f5631h;
        obj.f5619i = this.f5632i;
        obj.f5620j = this.f5633j;
        obj.f5621k = this.f5634k;
        obj.f5622l = this.f5635l;
        obj.f5623m = this.f5636m;
        return obj;
    }
}
package t3;

import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.internal.http2.ErrorCode;

/* loaded from: classes.dex */
public final class j extends p3.a {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f6750e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ s f6751f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Object f6752g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(String str, s sVar, Object obj, int i4) {
        super(str, true);
        this.f6750e = i4;
        this.f6751f = sVar;
        this.f6752g = obj;
    }

    @Override // p3.a
    public final long a() {
        switch (this.f6750e) {
            case 0:
                s sVar = this.f6751f;
                sVar.f6778b.a(sVar, (d0) ((Ref$ObjectRef) this.f6752g).f5198a);
                return -1L;
            default:
                try {
                    this.f6751f.f6778b.b((z) this.f6752g);
                } catch (IOException e4) {
                    u3.l lVar = u3.l.f6934a;
                    u3.l.f6934a.getClass();
                    u3.l.i("Http2Connection.Listener failure for " + this.f6751f.f6780d, 4, e4);
                    try {
                        ((z) this.f6752g).c(ErrorCode.f6034c, e4);
                    } catch (IOException unused) {
                    }
                }
                return -1L;
        }
    }
}
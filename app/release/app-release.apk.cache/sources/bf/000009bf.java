package t3;

import java.io.IOException;
import java.util.List;
import okhttp3.internal.http2.ErrorCode;

/* loaded from: classes.dex */
public final class p extends p3.a {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f6768e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ s f6769f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f6770g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f6771h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(String str, s sVar, int i4, Object obj, int i5) {
        super(str, true);
        this.f6768e = i5;
        this.f6769f = sVar;
        this.f6770g = i4;
        this.f6771h = obj;
    }

    @Override // p3.a
    public final long a() {
        switch (this.f6768e) {
            case 0:
                this.f6769f.f6788l.getClass();
                com.google.common.collect.c.F((ErrorCode) this.f6771h, "errorCode");
                synchronized (this.f6769f) {
                    this.f6769f.A.remove(Integer.valueOf(this.f6770g));
                }
                return -1L;
            case 1:
                s sVar = this.f6769f;
                try {
                    int i4 = this.f6770g;
                    ErrorCode errorCode = (ErrorCode) this.f6771h;
                    sVar.getClass();
                    com.google.common.collect.c.F(errorCode, "statusCode");
                    sVar.f6801y.C(i4, errorCode);
                } catch (IOException e4) {
                    sVar.y(e4);
                }
                return -1L;
            default:
                this.f6769f.f6788l.getClass();
                com.google.common.collect.c.F((List) this.f6771h, "requestHeaders");
                try {
                    this.f6769f.f6801y.C(this.f6770g, ErrorCode.f6038g);
                    synchronized (this.f6769f) {
                        this.f6769f.A.remove(Integer.valueOf(this.f6770g));
                    }
                } catch (IOException unused) {
                }
                return -1L;
        }
    }
}
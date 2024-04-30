package t3;

import java.io.IOException;
import okhttp3.internal.http2.ErrorCode;

/* loaded from: classes.dex */
public final class m implements e3.a {

    /* renamed from: a  reason: collision with root package name */
    public final v f6759a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ s f6760b;

    public m(s sVar, v vVar) {
        this.f6760b = sVar;
        this.f6759a = vVar;
    }

    @Override // e3.a
    public final Object a() {
        ErrorCode errorCode;
        s sVar = this.f6760b;
        v vVar = this.f6759a;
        ErrorCode errorCode2 = ErrorCode.f6035d;
        IOException e4 = null;
        try {
            try {
                vVar.y(this);
                do {
                } while (vVar.x(false, this));
                errorCode = ErrorCode.f6033b;
            } catch (IOException e5) {
                e4 = e5;
                errorCode = errorCode2;
            } catch (Throwable th) {
                th = th;
                errorCode = errorCode2;
                sVar.x(errorCode, errorCode2, e4);
                n3.b.d(vVar);
                throw th;
            }
            try {
                errorCode2 = ErrorCode.f6038g;
                sVar.x(errorCode, errorCode2, null);
            } catch (IOException e6) {
                e4 = e6;
                errorCode2 = ErrorCode.f6034c;
                sVar.x(errorCode2, errorCode2, e4);
                n3.b.d(vVar);
                return x2.c.f7143a;
            }
            n3.b.d(vVar);
            return x2.c.f7143a;
        } catch (Throwable th2) {
            th = th2;
            sVar.x(errorCode, errorCode2, e4);
            n3.b.d(vVar);
            throw th;
        }
    }
}
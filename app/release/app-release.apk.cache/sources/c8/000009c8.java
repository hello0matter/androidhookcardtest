package t3;

import java.io.IOException;
import java.net.SocketTimeoutException;
import okhttp3.internal.http2.ErrorCode;

/* loaded from: classes.dex */
public final class y extends y3.e {

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ z f6832m;

    public y(z zVar) {
        this.f6832m = zVar;
    }

    @Override // y3.e
    public final IOException j(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // y3.e
    public final void k() {
        this.f6832m.e(ErrorCode.f6038g);
        s sVar = this.f6832m.f6834b;
        synchronized (sVar) {
            long j4 = sVar.f6792p;
            long j5 = sVar.f6791o;
            if (j4 >= j5) {
                sVar.f6791o = j5 + 1;
                sVar.f6793q = System.nanoTime() + 1000000000;
                sVar.f6785i.c(new p3.b(2, sVar, androidx.activity.j.e(new StringBuilder(), sVar.f6780d, " ping")), 0L);
            }
        }
    }

    public final void l() {
        if (!i()) {
            return;
        }
        throw j(null);
    }
}
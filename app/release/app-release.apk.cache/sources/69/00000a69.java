package y3;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class s extends e {

    /* renamed from: m  reason: collision with root package name */
    public final Socket f7210m;

    public s(Socket socket) {
        this.f7210m = socket;
    }

    @Override // y3.e
    public final IOException j(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // y3.e
    public final void k() {
        Level level;
        StringBuilder sb;
        Logger logger;
        Exception exc;
        Socket socket = this.f7210m;
        try {
            socket.close();
        } catch (AssertionError e4) {
            if (com.google.common.collect.c.V0(e4)) {
                Logger logger2 = l.f7191a;
                level = Level.WARNING;
                sb = new StringBuilder("Failed to close timed out socket ");
                exc = e4;
                logger = logger2;
                sb.append(socket);
                logger.log(level, sb.toString(), (Throwable) exc);
            }
            throw e4;
        } catch (Exception e5) {
            Logger logger3 = l.f7191a;
            level = Level.WARNING;
            sb = new StringBuilder("Failed to close timed out socket ");
            exc = e5;
            logger = logger3;
            sb.append(socket);
            logger.log(level, sb.toString(), (Throwable) exc);
        }
    }
}
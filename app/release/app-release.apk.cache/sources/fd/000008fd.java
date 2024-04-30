package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lokhttp3/internal/http2/StreamResetException;", "Ljava/io/IOException;", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class StreamResetException extends IOException {

    /* renamed from: a  reason: collision with root package name */
    public final ErrorCode f6041a;

    public StreamResetException(ErrorCode errorCode) {
        super("stream was reset: " + errorCode);
        this.f6041a = errorCode;
    }
}
package okhttp3.internal.http2;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lokhttp3/internal/http2/ErrorCode;", "", "androidx/fragment/app/m0", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public enum ErrorCode {
    f6033b("NO_ERROR"),
    f6034c("PROTOCOL_ERROR"),
    f6035d("INTERNAL_ERROR"),
    f6036e("FLOW_CONTROL_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF4("SETTINGS_TIMEOUT"),
    /* JADX INFO: Fake field, exist only in values array */
    EF5("STREAM_CLOSED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF6("FRAME_SIZE_ERROR"),
    f6037f("REFUSED_STREAM"),
    f6038g("CANCEL"),
    /* JADX INFO: Fake field, exist only in values array */
    EF91("COMPRESSION_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF100("CONNECT_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF109("ENHANCE_YOUR_CALM"),
    /* JADX INFO: Fake field, exist only in values array */
    EF118("INADEQUATE_SECURITY"),
    /* JADX INFO: Fake field, exist only in values array */
    EF127("HTTP_1_1_REQUIRED");
    

    /* renamed from: a  reason: collision with root package name */
    public final int f6040a;

    ErrorCode(String str) {
        this.f6040a = r2;
    }
}
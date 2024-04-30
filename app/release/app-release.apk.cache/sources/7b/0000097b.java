package r3;

import okhttp3.Protocol;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final Protocol f6482a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6483b;

    /* renamed from: c  reason: collision with root package name */
    public final String f6484c;

    public h(Protocol protocol, int i4, String str) {
        this.f6482a = protocol;
        this.f6483b = i4;
        this.f6484c = str;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.f6482a == Protocol.HTTP_1_0) {
            str = "HTTP/1.0";
        } else {
            str = "HTTP/1.1";
        }
        sb.append(str);
        sb.append(' ');
        sb.append(this.f6483b);
        sb.append(' ');
        sb.append(this.f6484c);
        String sb2 = sb.toString();
        com.google.common.collect.c.E(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
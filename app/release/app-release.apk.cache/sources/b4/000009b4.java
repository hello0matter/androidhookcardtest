package t3;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import okio.ByteString;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public static final b[] f6734a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map f6735b;

    static {
        b bVar = new b(b.f6707i, "");
        ByteString byteString = b.f6704f;
        b bVar2 = new b(byteString, "GET");
        b bVar3 = new b(byteString, "POST");
        ByteString byteString2 = b.f6705g;
        b bVar4 = new b(byteString2, "/");
        b bVar5 = new b(byteString2, "/index.html");
        ByteString byteString3 = b.f6706h;
        b bVar6 = new b(byteString3, "http");
        b bVar7 = new b(byteString3, "https");
        ByteString byteString4 = b.f6703e;
        b[] bVarArr = {bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, new b(byteString4, "200"), new b(byteString4, "204"), new b(byteString4, "206"), new b(byteString4, "304"), new b(byteString4, "400"), new b(byteString4, "404"), new b(byteString4, "500"), new b("accept-charset", ""), new b("accept-encoding", "gzip, deflate"), new b("accept-language", ""), new b("accept-ranges", ""), new b("accept", ""), new b("access-control-allow-origin", ""), new b("age", ""), new b("allow", ""), new b("authorization", ""), new b("cache-control", ""), new b("content-disposition", ""), new b("content-encoding", ""), new b("content-language", ""), new b("content-length", ""), new b("content-location", ""), new b("content-range", ""), new b("content-type", ""), new b("cookie", ""), new b("date", ""), new b("etag", ""), new b("expect", ""), new b("expires", ""), new b("from", ""), new b("host", ""), new b("if-match", ""), new b("if-modified-since", ""), new b("if-none-match", ""), new b("if-range", ""), new b("if-unmodified-since", ""), new b("last-modified", ""), new b("link", ""), new b("location", ""), new b("max-forwards", ""), new b("proxy-authenticate", ""), new b("proxy-authorization", ""), new b("range", ""), new b("referer", ""), new b("refresh", ""), new b("retry-after", ""), new b("server", ""), new b("set-cookie", ""), new b("strict-transport-security", ""), new b("transfer-encoding", ""), new b("user-agent", ""), new b("vary", ""), new b("via", ""), new b("www-authenticate", "")};
        f6734a = bVarArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(61);
        for (int i4 = 0; i4 < 61; i4++) {
            if (!linkedHashMap.containsKey(bVarArr[i4].f6708a)) {
                linkedHashMap.put(bVarArr[i4].f6708a, Integer.valueOf(i4));
            }
        }
        Map unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        com.google.common.collect.c.E(unmodifiableMap, "unmodifiableMap(result)");
        f6735b = unmodifiableMap;
    }

    public static void a(ByteString byteString) {
        com.google.common.collect.c.F(byteString, "name");
        int c4 = byteString.c();
        for (int i4 = 0; i4 < c4; i4++) {
            byte f4 = byteString.f(i4);
            if (65 <= f4 && f4 < 91) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: ".concat(byteString.j()));
            }
        }
    }
}
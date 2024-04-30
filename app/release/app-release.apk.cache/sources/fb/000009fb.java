package v3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import m3.s;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final CopyOnWriteArraySet f6995a = new CopyOnWriteArraySet();

    /* renamed from: b  reason: collision with root package name */
    public static final Map f6996b;

    static {
        String str;
        Map h22;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r22 = s.class.getPackage();
        if (r22 != null) {
            str = r22.getName();
        } else {
            str = null;
        }
        if (str != null) {
            linkedHashMap.put(str, "OkHttp");
        }
        linkedHashMap.put(s.class.getName(), "okhttp.OkHttpClient");
        linkedHashMap.put(t3.f.class.getName(), "okhttp.Http2");
        linkedHashMap.put(p3.f.class.getName(), "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        int size = linkedHashMap.size();
        if (size != 0) {
            if (size != 1) {
                h22 = new LinkedHashMap(linkedHashMap);
            } else {
                h22 = com.google.common.collect.c.b2(linkedHashMap);
            }
        } else {
            h22 = kotlin.collections.b.h2();
        }
        f6996b = h22;
    }
}
package m3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;

/* loaded from: classes.dex */
public final class k implements b, i, j {

    /* renamed from: d  reason: collision with root package name */
    public static final k f5531d = new Object();

    public List a(String str) {
        com.google.common.collect.c.F(str, "hostname");
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            com.google.common.collect.c.E(allByName, "getAllByName(hostname)");
            int length = allByName.length;
            if (length != 0) {
                if (length != 1) {
                    return new ArrayList(new y2.f(allByName, false));
                }
                return com.google.common.collect.c.c1(allByName[0]);
            }
            return EmptyList.f5181a;
        } catch (NullPointerException e4) {
            UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(str));
            unknownHostException.initCause(e4);
            throw unknownHostException;
        }
    }
}
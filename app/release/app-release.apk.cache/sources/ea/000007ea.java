package kotlin.collections;

import com.google.common.collect.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;

/* loaded from: classes.dex */
public abstract class b extends c {
    public static Map h2() {
        EmptyMap emptyMap = EmptyMap.f5182a;
        c.D(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    public static Map i2(ArrayList arrayList) {
        int size = arrayList.size();
        if (size != 0) {
            if (size != 1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap(c.f1(arrayList.size()));
                j2(arrayList, linkedHashMap);
                return linkedHashMap;
            }
            Pair pair = (Pair) arrayList.get(0);
            c.F(pair, "pair");
            Map singletonMap = Collections.singletonMap(pair.f5152a, pair.f5153b);
            c.E(singletonMap, "singletonMap(pair.first, pair.second)");
            return singletonMap;
        }
        return h2();
    }

    public static final void j2(ArrayList arrayList, LinkedHashMap linkedHashMap) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            linkedHashMap.put(pair.f5152a, pair.f5153b);
        }
    }
}
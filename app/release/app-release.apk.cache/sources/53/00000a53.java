package y2;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class j extends i {
    public static void o2(List list, ArrayList arrayList) {
        com.google.common.collect.c.F(list, "elements");
        arrayList.addAll(list);
    }
}
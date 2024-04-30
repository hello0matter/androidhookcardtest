package y2;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;

/* loaded from: classes.dex */
public abstract class l extends j {
    public static final void p2(Iterable iterable, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, e3.l lVar) {
        com.google.common.collect.c.F(iterable, "<this>");
        com.google.common.collect.c.F(charSequence, "separator");
        com.google.common.collect.c.F(charSequence2, "prefix");
        com.google.common.collect.c.F(charSequence3, "postfix");
        com.google.common.collect.c.F(charSequence4, "truncated");
        sb.append(charSequence2);
        int i5 = 0;
        for (Object obj : iterable) {
            i5++;
            if (i5 > 1) {
                sb.append(charSequence);
            }
            if (i4 >= 0 && i5 > i4) {
                break;
            }
            com.google.common.collect.c.k(sb, obj, lVar);
        }
        if (i4 >= 0 && i5 > i4) {
            sb.append(charSequence4);
        }
        sb.append(charSequence3);
    }

    public static List q2(List list) {
        com.google.common.collect.c.F(list, "<this>");
        int size = list.size();
        if (size != 0) {
            if (size != 1) {
                return new ArrayList(list);
            }
            return com.google.common.collect.c.c1(list.get(0));
        }
        return EmptyList.f5181a;
    }
}
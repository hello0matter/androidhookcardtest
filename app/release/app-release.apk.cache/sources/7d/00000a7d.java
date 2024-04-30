package z2;

import com.google.common.collect.c;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class b implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public static final b f7233a = new Object();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        c.F(comparable, "a");
        c.F(comparable2, "b");
        return comparable2.compareTo(comparable);
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        return a.f7232a;
    }
}
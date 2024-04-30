package v;

import java.util.ArrayList;
import java.util.HashSet;
import l.k;
import p.g;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final g f6940a = new g(10, 1);

    /* renamed from: b  reason: collision with root package name */
    public final k f6941b = new k();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f6942c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final HashSet f6943d = new HashSet();

    public final void a(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (!hashSet.contains(obj)) {
            hashSet.add(obj);
            ArrayList arrayList2 = (ArrayList) this.f6941b.getOrDefault(obj, null);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i4 = 0; i4 < size; i4++) {
                    a(arrayList2.get(i4), arrayList, hashSet);
                }
            }
            hashSet.remove(obj);
            arrayList.add(obj);
            return;
        }
        throw new RuntimeException("This graph contains cyclic dependencies");
    }
}
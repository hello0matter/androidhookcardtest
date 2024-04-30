package i;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class g implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    public c f4902a;

    /* renamed from: b  reason: collision with root package name */
    public c f4903b;

    /* renamed from: c  reason: collision with root package name */
    public final WeakHashMap f4904c = new WeakHashMap();

    /* renamed from: d  reason: collision with root package name */
    public int f4905d = 0;

    public c a(Object obj) {
        c cVar = this.f4902a;
        while (cVar != null && !cVar.f4893a.equals(obj)) {
            cVar = cVar.f4895c;
        }
        return cVar;
    }

    public Object b(Object obj) {
        c a5 = a(obj);
        if (a5 == null) {
            return null;
        }
        this.f4905d--;
        WeakHashMap weakHashMap = this.f4904c;
        if (!weakHashMap.isEmpty()) {
            for (f fVar : weakHashMap.keySet()) {
                fVar.a(a5);
            }
        }
        c cVar = a5.f4896d;
        c cVar2 = a5.f4895c;
        if (cVar != null) {
            cVar.f4895c = cVar2;
        } else {
            this.f4902a = cVar2;
        }
        c cVar3 = a5.f4895c;
        if (cVar3 != null) {
            cVar3.f4896d = cVar;
        } else {
            this.f4903b = cVar;
        }
        a5.f4895c = null;
        a5.f4896d = null;
        return a5.f4894b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
        if (r3.hasNext() != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
        if (((i.e) r7).hasNext() != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L4
            return r0
        L4:
            boolean r1 = r7 instanceof i.g
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            i.g r7 = (i.g) r7
            int r1 = r6.f4905d
            int r3 = r7.f4905d
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L1b:
            r3 = r1
            i.e r3 = (i.e) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            r4 = r7
            i.e r4 = (i.e) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L44
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L3b
            if (r4 != 0) goto L43
        L3b:
            if (r3 == 0) goto L1b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L53
            i.e r7 = (i.e) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L53
            goto L54
        L53:
            r0 = r2
        L54:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i.g.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator it = iterator();
        int i4 = 0;
        while (true) {
            e eVar = (e) it;
            if (eVar.hasNext()) {
                i4 += ((Map.Entry) eVar.next()).hashCode();
            } else {
                return i4;
            }
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        b bVar = new b(this.f4902a, this.f4903b, 0);
        this.f4904c.put(bVar, Boolean.FALSE);
        return bVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            e eVar = (e) it;
            if (eVar.hasNext()) {
                sb.append(((Map.Entry) eVar.next()).toString());
                if (eVar.hasNext()) {
                    sb.append(", ");
                }
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }
}
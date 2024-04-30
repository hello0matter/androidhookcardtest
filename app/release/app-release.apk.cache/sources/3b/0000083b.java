package l;

import java.util.LinkedHashMap;
import java.util.Locale;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap f5229a;

    /* renamed from: b  reason: collision with root package name */
    public int f5230b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5231c;

    /* renamed from: d  reason: collision with root package name */
    public int f5232d;

    /* renamed from: e  reason: collision with root package name */
    public int f5233e;

    public f(int i4) {
        if (i4 > 0) {
            this.f5231c = i4;
            this.f5229a = new LinkedHashMap(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final Object a(Object obj) {
        if (obj != null) {
            synchronized (this) {
                try {
                    Object obj2 = this.f5229a.get(obj);
                    if (obj2 != null) {
                        this.f5232d++;
                        return obj2;
                    }
                    this.f5233e++;
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        throw new NullPointerException("key == null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0082, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(java.lang.Object r3, java.lang.Object r4) {
        /*
            r2 = this;
            if (r3 == 0) goto L87
            monitor-enter(r2)
            int r0 = r2.f5230b     // Catch: java.lang.Throwable -> L18
            int r0 = r0 + 1
            r2.f5230b = r0     // Catch: java.lang.Throwable -> L18
            java.util.LinkedHashMap r0 = r2.f5229a     // Catch: java.lang.Throwable -> L18
            java.lang.Object r3 = r0.put(r3, r4)     // Catch: java.lang.Throwable -> L18
            if (r3 == 0) goto L1a
            int r4 = r2.f5230b     // Catch: java.lang.Throwable -> L18
            int r4 = r4 + (-1)
            r2.f5230b = r4     // Catch: java.lang.Throwable -> L18
            goto L1a
        L18:
            r3 = move-exception
            goto L85
        L1a:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L18
            int r4 = r2.f5231c
        L1d:
            monitor-enter(r2)
            int r0 = r2.f5230b     // Catch: java.lang.Throwable -> L2f
            if (r0 < 0) goto L64
            java.util.LinkedHashMap r0 = r2.f5229a     // Catch: java.lang.Throwable -> L2f
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L2f
            if (r0 == 0) goto L31
            int r0 = r2.f5230b     // Catch: java.lang.Throwable -> L2f
            if (r0 != 0) goto L64
            goto L31
        L2f:
            r3 = move-exception
            goto L83
        L31:
            int r0 = r2.f5230b     // Catch: java.lang.Throwable -> L2f
            if (r0 <= r4) goto L62
            java.util.LinkedHashMap r0 = r2.f5229a     // Catch: java.lang.Throwable -> L2f
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L2f
            if (r0 == 0) goto L3e
            goto L62
        L3e:
            java.util.LinkedHashMap r0 = r2.f5229a     // Catch: java.lang.Throwable -> L2f
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L2f
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L2f
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L2f
            r0.getValue()     // Catch: java.lang.Throwable -> L2f
            java.util.LinkedHashMap r0 = r2.f5229a     // Catch: java.lang.Throwable -> L2f
            r0.remove(r1)     // Catch: java.lang.Throwable -> L2f
            int r0 = r2.f5230b     // Catch: java.lang.Throwable -> L2f
            int r0 = r0 + (-1)
            r2.f5230b = r0     // Catch: java.lang.Throwable -> L2f
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2f
            goto L1d
        L62:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2f
            return r3
        L64:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2f
            r4.<init>()     // Catch: java.lang.Throwable -> L2f
            java.lang.Class r0 = r2.getClass()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r0 = r0.getName()     // Catch: java.lang.Throwable -> L2f
            r4.append(r0)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r0 = ".sizeOf() is reporting inconsistent results!"
            r4.append(r0)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L2f
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L2f
            throw r3     // Catch: java.lang.Throwable -> L2f
        L83:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2f
            throw r3
        L85:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L18
            throw r3
        L87:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "key == null || value == null"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: l.f.b(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final synchronized String toString() {
        int i4;
        int i5;
        int i6;
        int i7;
        try {
            int i8 = this.f5232d;
            int i9 = this.f5233e + i8;
            if (i9 != 0) {
                i4 = (i8 * 100) / i9;
            } else {
                i4 = 0;
            }
            Locale locale = Locale.US;
            i5 = this.f5231c;
            i6 = this.f5232d;
            i7 = this.f5233e;
        } catch (Throwable th) {
            throw th;
        }
        return "LruCache[maxSize=" + i5 + ",hits=" + i6 + ",misses=" + i7 + ",hitRate=" + i4 + "%]";
    }
}
package l3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    public int f5402a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f5403b;

    /* renamed from: c  reason: collision with root package name */
    public int f5404c;

    /* renamed from: d  reason: collision with root package name */
    public i3.c f5405d;

    /* renamed from: e  reason: collision with root package name */
    public int f5406e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ c f5407f;

    public b(c cVar) {
        this.f5407f = cVar;
        int i4 = cVar.f5409b;
        int length = cVar.f5408a.length();
        if (length >= 0) {
            if (i4 < 0) {
                i4 = 0;
            } else if (i4 > length) {
                i4 = length;
            }
            this.f5403b = i4;
            this.f5404c = i4;
            return;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + length + " is less than minimum 0.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001a, code lost:
        if (r7 < r3) goto L14;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            r8 = this;
            int r0 = r8.f5404c
            r1 = 0
            if (r0 >= 0) goto Lb
            r8.f5402a = r1
            r0 = 0
            r8.f5405d = r0
            goto L6f
        Lb:
            l3.c r2 = r8.f5407f
            int r3 = r2.f5410c
            java.lang.CharSequence r4 = r2.f5408a
            r5 = -1
            r6 = 1
            if (r3 <= 0) goto L1c
            int r7 = r8.f5406e
            int r7 = r7 + r6
            r8.f5406e = r7
            if (r7 >= r3) goto L22
        L1c:
            int r3 = r4.length()
            if (r0 <= r3) goto L32
        L22:
            i3.c r0 = new i3.c
            int r1 = r8.f5403b
            int r2 = kotlin.text.b.r2(r4)
            r0.<init>(r1, r2, r6)
        L2d:
            r8.f5405d = r0
            r8.f5404c = r5
            goto L6d
        L32:
            int r0 = r8.f5404c
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            e3.p r2 = r2.f5411d
            kotlin.Pair r0 = r2.b(r4, r0)
            if (r0 != 0) goto L4c
            i3.c r0 = new i3.c
            int r1 = r8.f5403b
            int r2 = kotlin.text.b.r2(r4)
            r0.<init>(r1, r2, r6)
            goto L2d
        L4c:
            java.lang.Object r2 = r0.f5152a
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.f5153b
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r3 = r8.f5403b
            i3.c r3 = com.google.common.collect.c.d2(r3, r2)
            r8.f5405d = r3
            int r2 = r2 + r0
            r8.f5403b = r2
            if (r0 != 0) goto L6a
            r1 = r6
        L6a:
            int r2 = r2 + r1
            r8.f5404c = r2
        L6d:
            r8.f5402a = r6
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.b.a():void");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f5402a == -1) {
            a();
        }
        if (this.f5402a == 1) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f5402a == -1) {
            a();
        }
        if (this.f5402a != 0) {
            i3.c cVar = this.f5405d;
            com.google.common.collect.c.D(cVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f5405d = null;
            this.f5402a = -1;
            return cVar;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
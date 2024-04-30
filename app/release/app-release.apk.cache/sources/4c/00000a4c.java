package y2;

import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class c extends d implements RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    public final d f7153a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7154b;

    /* renamed from: c  reason: collision with root package name */
    public final int f7155c;

    public c(d dVar, int i4, int i5) {
        com.google.common.collect.c.F(dVar, "list");
        this.f7153a = dVar;
        this.f7154b = i4;
        int a5 = dVar.a();
        if (i4 >= 0 && i5 <= a5) {
            if (i4 <= i5) {
                this.f7155c = i5 - i4;
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i4 + " > toIndex: " + i5);
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i4 + ", toIndex: " + i5 + ", size: " + a5);
    }

    @Override // kotlin.collections.a
    public final int a() {
        return this.f7155c;
    }

    @Override // java.util.List
    public final Object get(int i4) {
        int i5 = this.f7155c;
        if (i4 >= 0 && i4 < i5) {
            return this.f7153a.get(this.f7154b + i4);
        }
        throw new IndexOutOfBoundsException("index: " + i4 + ", size: " + i5);
    }
}
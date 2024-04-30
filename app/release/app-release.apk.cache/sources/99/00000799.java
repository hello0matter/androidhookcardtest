package i3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    public final int f5067a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5068b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5069c;

    /* renamed from: d  reason: collision with root package name */
    public int f5070d;

    public b(int i4, int i5, int i6) {
        this.f5067a = i6;
        this.f5068b = i5;
        boolean z4 = true;
        if (i6 <= 0 ? i4 < i5 : i4 > i5) {
            z4 = false;
        }
        this.f5069c = z4;
        this.f5070d = z4 ? i4 : i5;
    }

    @Override // java.util.Iterator
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(b());
    }

    public final int b() {
        int i4 = this.f5070d;
        if (i4 == this.f5068b) {
            if (this.f5069c) {
                this.f5069c = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f5070d = this.f5067a + i4;
        }
        return i4;
    }

    public final void c() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5069c;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void remove() {
        c();
        throw null;
    }
}
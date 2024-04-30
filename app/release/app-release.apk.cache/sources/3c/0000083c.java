package l;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class g implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    public final int f5234a;

    /* renamed from: b  reason: collision with root package name */
    public int f5235b;

    /* renamed from: c  reason: collision with root package name */
    public int f5236c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5237d = false;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ g.e f5238e;

    public g(g.e eVar, int i4) {
        this.f5238e = eVar;
        this.f5234a = i4;
        this.f5235b = eVar.g();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f5236c < this.f5235b) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            Object e4 = this.f5238e.e(this.f5236c, this.f5234a);
            this.f5236c++;
            this.f5237d = true;
            return e4;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.f5237d) {
            int i4 = this.f5236c - 1;
            this.f5236c = i4;
            this.f5235b--;
            this.f5237d = false;
            this.f5238e.k(i4);
            return;
        }
        throw new IllegalStateException();
    }
}
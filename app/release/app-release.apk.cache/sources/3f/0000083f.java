package l;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class j implements Collection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g.e f5245a;

    public j(g.e eVar) {
        this.f5245a = eVar;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        this.f5245a.d();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (this.f5245a.i(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        for (Object obj : collection) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        if (this.f5245a.g() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new g(this.f5245a, 1);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        g.e eVar = this.f5245a;
        int i4 = eVar.i(obj);
        if (i4 >= 0) {
            eVar.k(i4);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        g.e eVar = this.f5245a;
        int g4 = eVar.g();
        int i4 = 0;
        boolean z4 = false;
        while (i4 < g4) {
            if (collection.contains(eVar.e(i4, 1))) {
                eVar.k(i4);
                i4--;
                g4--;
                z4 = true;
            }
            i4++;
        }
        return z4;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        g.e eVar = this.f5245a;
        int g4 = eVar.g();
        int i4 = 0;
        boolean z4 = false;
        while (i4 < g4) {
            if (!collection.contains(eVar.e(i4, 1))) {
                eVar.k(i4);
                i4--;
                g4--;
                z4 = true;
            }
            i4++;
        }
        return z4;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f5245a.g();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        g.e eVar = this.f5245a;
        int g4 = eVar.g();
        Object[] objArr = new Object[g4];
        for (int i4 = 0; i4 < g4; i4++) {
            objArr[i4] = eVar.e(i4, 1);
        }
        return objArr;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return this.f5245a.t(1, objArr);
    }
}
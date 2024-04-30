package kotlin.collections;

import com.google.common.collect.c;
import e3.l;
import java.util.Collection;

/* loaded from: classes.dex */
public abstract class a implements Collection {
    public abstract int a();

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        if (isEmpty()) {
            return false;
        }
        for (Object obj2 : this) {
            if (c.n(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        c.F(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        if (a() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return f3.c.a(this);
    }

    public final String toString() {
        l lVar = new l() { // from class: kotlin.collections.AbstractCollection$toString$1
            @Override // e3.l
            public final Object c(Object obj) {
                if (obj == a.this) {
                    return "(this Collection)";
                }
                return String.valueOf(obj);
            }
        };
        StringBuilder sb = new StringBuilder();
        y2.l.p2(this, sb, ", ", "[", "]", -1, "...", lVar);
        String sb2 = sb.toString();
        c.E(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        c.F(objArr, "array");
        return f3.c.b(this, objArr);
    }
}
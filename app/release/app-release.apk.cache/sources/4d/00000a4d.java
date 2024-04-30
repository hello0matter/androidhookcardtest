package y2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public abstract class d extends kotlin.collections.a implements List {
    @Override // java.util.List
    public final void add(int i4, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int i4, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        Collection collection = (Collection) obj;
        com.google.common.collect.c.F(collection, "other");
        if (size() != collection.size()) {
            return false;
        }
        Iterator it = collection.iterator();
        for (Object obj2 : this) {
            if (!com.google.common.collect.c.n(obj2, it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int i4;
        int i5 = 1;
        for (Object obj : this) {
            int i6 = i5 * 31;
            if (obj != null) {
                i4 = obj.hashCode();
            } else {
                i4 = 0;
            }
            i5 = i6 + i4;
        }
        return i5;
    }

    public int indexOf(Object obj) {
        int i4 = 0;
        for (Object obj2 : this) {
            if (!com.google.common.collect.c.n(obj2, obj)) {
                i4++;
            } else {
                return i4;
            }
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new a(this);
    }

    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (com.google.common.collect.c.n(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return new b(this, 0);
    }

    @Override // java.util.List
    public final Object remove(int i4) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final Object set(int i4, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final List subList(int i4, int i5) {
        return new c(this, i4, i5);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i4) {
        return new b(this, i4);
    }
}
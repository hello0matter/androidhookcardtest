package y2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class f implements Collection {

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f7156a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f7157b;

    public f(Object[] objArr, boolean z4) {
        this.f7156a = objArr;
        this.f7157b = z4;
    }

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
    public final boolean contains(Object obj) {
        int i4;
        Object[] objArr = this.f7156a;
        com.google.common.collect.c.F(objArr, "<this>");
        if (obj == null) {
            int length = objArr.length;
            i4 = 0;
            while (i4 < length) {
                if (objArr[i4] != null) {
                    i4++;
                }
            }
            return false;
        }
        int length2 = objArr.length;
        for (int i5 = 0; i5 < length2; i5++) {
            if (com.google.common.collect.c.n(obj, objArr[i5])) {
                i4 = i5;
            }
        }
        return false;
        if (i4 < 0) {
            return false;
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        com.google.common.collect.c.F(collection, "elements");
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
        if (this.f7156a.length == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        Object[] objArr = this.f7156a;
        com.google.common.collect.c.F(objArr, "array");
        return new a(objArr);
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
    public final int size() {
        return this.f7156a.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        Object[] objArr = this.f7156a;
        com.google.common.collect.c.F(objArr, "<this>");
        if (this.f7157b && com.google.common.collect.c.n(objArr.getClass(), Object[].class)) {
            return objArr;
        }
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
        com.google.common.collect.c.E(copyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return copyOf;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        com.google.common.collect.c.F(objArr, "array");
        return f3.c.b(this, objArr);
    }
}
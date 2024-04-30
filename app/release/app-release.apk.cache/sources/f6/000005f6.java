package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes.dex */
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    public static final b f4177b = new b(RegularImmutableList.f4182e, 0);

    /* loaded from: classes.dex */
    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: a  reason: collision with root package name */
        public final Object[] f4178a;

        public SerializedForm(Object[] objArr) {
            this.f4178a = objArr;
        }

        public Object readResolve() {
            return ImmutableList.h(this.f4178a);
        }
    }

    /* loaded from: classes.dex */
    public class SubList extends ImmutableList<E> {

        /* renamed from: c  reason: collision with root package name */
        public final transient int f4179c;

        /* renamed from: d  reason: collision with root package name */
        public final transient int f4180d;

        public SubList(int i4, int i5) {
            this.f4179c = i4;
            this.f4180d = i5;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final Object[] b() {
            return ImmutableList.this.b();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final int c() {
            return ImmutableList.this.d() + this.f4179c + this.f4180d;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final int d() {
            return ImmutableList.this.d() + this.f4179c;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean e() {
            return true;
        }

        @Override // java.util.List
        public final Object get(int i4) {
            c.A(i4, this.f4180d);
            return ImmutableList.this.get(i4 + this.f4179c);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public final Iterator iterator() {
            return listIterator(0);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        /* renamed from: j */
        public final ImmutableList subList(int i4, int i5) {
            c.H(i4, i5, this.f4180d);
            int i6 = this.f4179c;
            return ImmutableList.this.subList(i4 + i6, i5 + i6);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public final ListIterator listIterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return this.f4180d;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public final /* bridge */ /* synthetic */ ListIterator listIterator(int i4) {
            return listIterator(i4);
        }
    }

    public static ImmutableList f(Object... objArr) {
        int length = objArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (objArr[i4] == null) {
                StringBuilder sb = new StringBuilder(20);
                sb.append("at index ");
                sb.append(i4);
                throw new NullPointerException(sb.toString());
            }
        }
        int length2 = objArr.length;
        if (length2 == 0) {
            return RegularImmutableList.f4182e;
        }
        return new RegularImmutableList(length2, objArr);
    }

    public static ImmutableList g(Collection collection) {
        ImmutableList immutableList = (ImmutableList) ((ImmutableCollection) collection);
        if (immutableList.e()) {
            Object[] array = immutableList.toArray(ImmutableCollection.f4176a);
            int length = array.length;
            if (length == 0) {
                return RegularImmutableList.f4182e;
            }
            return new RegularImmutableList(length, array);
        }
        return immutableList;
    }

    public static ImmutableList h(Object[] objArr) {
        if (objArr.length == 0) {
            return RegularImmutableList.f4182e;
        }
        return f((Object[]) objArr.clone());
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int a(Object[] objArr) {
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            objArr[i4] = get(i4);
        }
        return size;
    }

    @Override // java.util.List
    public final void add(int i4, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i4, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        E next;
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i4 = 0; i4 < size; i4++) {
                        E e4 = get(i4);
                        Object obj2 = list.get(i4);
                        if (e4 == obj2 || (e4 != null && e4.equals(obj2))) {
                        }
                    }
                    return true;
                }
                Iterator<E> it = list.iterator();
                for (E e5 : this) {
                    if (it.hasNext() && (e5 == (next = it.next()) || (e5 != null && e5.equals(next)))) {
                    }
                }
                return !it.hasNext();
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int i4 = 1;
        for (int i5 = 0; i5 < size; i5++) {
            i4 = ~(~(get(i5).hashCode() + (i4 * 31)));
        }
        return i4;
    }

    @Override // java.util.List
    /* renamed from: i */
    public final b listIterator(int i4) {
        int size = size();
        if (i4 >= 0 && i4 <= size) {
            if (isEmpty()) {
                return f4177b;
            }
            return new b(this, i4);
        }
        throw new IndexOutOfBoundsException(c.p(i4, size, "index"));
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            if (obj.equals(get(i4))) {
                return i4;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: j */
    public ImmutableList subList(int i4, int i5) {
        c.H(i4, i5, size());
        int i6 = i5 - i4;
        if (i6 == size()) {
            return this;
        }
        if (i6 == 0) {
            return RegularImmutableList.f4182e;
        }
        return new SubList(i4, i6);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final Object remove(int i4) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i4, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(toArray(ImmutableCollection.f4176a));
    }
}
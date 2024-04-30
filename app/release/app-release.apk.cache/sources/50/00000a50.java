package y2;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class g extends e {

    /* renamed from: d  reason: collision with root package name */
    public static final Object[] f7158d = new Object[0];

    /* renamed from: a  reason: collision with root package name */
    public int f7159a;

    /* renamed from: b  reason: collision with root package name */
    public Object[] f7160b = f7158d;

    /* renamed from: c  reason: collision with root package name */
    public int f7161c;

    public final void a(Object obj) {
        c(this.f7161c + 1);
        this.f7160b[e(this.f7159a + this.f7161c)] = obj;
        this.f7161c++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i4, Object obj) {
        int i5;
        l2.f.b(i4, this.f7161c);
        int i6 = this.f7161c;
        if (i4 == i6) {
            a(obj);
            return;
        }
        int i7 = i6 + 1;
        if (i4 == 0) {
            c(i7);
            int i8 = this.f7159a;
            if (i8 == 0) {
                Object[] objArr = this.f7160b;
                com.google.common.collect.c.F(objArr, "<this>");
                i8 = objArr.length;
            }
            int i9 = i8 - 1;
            this.f7159a = i9;
            this.f7160b[i9] = obj;
            this.f7161c++;
            return;
        }
        c(i7);
        int e4 = e(this.f7159a + i4);
        int i10 = this.f7161c;
        if (i4 < ((i10 + 1) >> 1)) {
            if (e4 == 0) {
                Object[] objArr2 = this.f7160b;
                com.google.common.collect.c.F(objArr2, "<this>");
                i5 = objArr2.length - 1;
            } else {
                i5 = e4 - 1;
            }
            int i11 = this.f7159a;
            if (i11 == 0) {
                Object[] objArr3 = this.f7160b;
                com.google.common.collect.c.F(objArr3, "<this>");
                i11 = objArr3.length;
            }
            int i12 = i11 - 1;
            int i13 = this.f7159a;
            Object[] objArr4 = this.f7160b;
            if (i5 >= i13) {
                objArr4[i12] = objArr4[i13];
                h.j2(objArr4, objArr4, i13, i13 + 1, i5 + 1);
            } else {
                h.j2(objArr4, objArr4, i13 - 1, i13, objArr4.length);
                Object[] objArr5 = this.f7160b;
                objArr5[objArr5.length - 1] = objArr5[0];
                h.j2(objArr5, objArr5, 0, 1, i5 + 1);
            }
            this.f7160b[i5] = obj;
            this.f7159a = i12;
        } else {
            int e5 = e(this.f7159a + i10);
            Object[] objArr6 = this.f7160b;
            if (e4 < e5) {
                h.j2(objArr6, objArr6, e4 + 1, e4, e5);
            } else {
                h.j2(objArr6, objArr6, 1, 0, e5);
                Object[] objArr7 = this.f7160b;
                objArr7[0] = objArr7[objArr7.length - 1];
                h.j2(objArr7, objArr7, e4 + 1, e4, objArr7.length - 1);
            }
            this.f7160b[e4] = obj;
        }
        this.f7161c++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i4, Collection collection) {
        com.google.common.collect.c.F(collection, "elements");
        l2.f.b(i4, this.f7161c);
        if (collection.isEmpty()) {
            return false;
        }
        int i5 = this.f7161c;
        if (i4 == i5) {
            return addAll(collection);
        }
        c(collection.size() + i5);
        int e4 = e(this.f7159a + this.f7161c);
        int e5 = e(this.f7159a + i4);
        int size = collection.size();
        if (i4 < ((this.f7161c + 1) >> 1)) {
            int i6 = this.f7159a;
            int i7 = i6 - size;
            if (e5 < i6) {
                Object[] objArr = this.f7160b;
                h.j2(objArr, objArr, i7, i6, objArr.length);
                Object[] objArr2 = this.f7160b;
                if (size >= e5) {
                    h.j2(objArr2, objArr2, objArr2.length - size, 0, e5);
                } else {
                    h.j2(objArr2, objArr2, objArr2.length - size, 0, size);
                    Object[] objArr3 = this.f7160b;
                    h.j2(objArr3, objArr3, 0, size, e5);
                }
            } else if (i7 >= 0) {
                Object[] objArr4 = this.f7160b;
                h.j2(objArr4, objArr4, i7, i6, e5);
            } else {
                Object[] objArr5 = this.f7160b;
                i7 += objArr5.length;
                int i8 = e5 - i6;
                int length = objArr5.length - i7;
                if (length >= i8) {
                    h.j2(objArr5, objArr5, i7, i6, e5);
                } else {
                    h.j2(objArr5, objArr5, i7, i6, i6 + length);
                    Object[] objArr6 = this.f7160b;
                    h.j2(objArr6, objArr6, 0, this.f7159a + length, e5);
                }
            }
            this.f7159a = i7;
            e5 -= size;
            if (e5 < 0) {
                e5 += this.f7160b.length;
            }
        } else {
            int i9 = e5 + size;
            if (e5 < e4) {
                int i10 = size + e4;
                Object[] objArr7 = this.f7160b;
                if (i10 > objArr7.length) {
                    if (i9 >= objArr7.length) {
                        i9 -= objArr7.length;
                    } else {
                        int length2 = e4 - (i10 - objArr7.length);
                        h.j2(objArr7, objArr7, 0, length2, e4);
                        Object[] objArr8 = this.f7160b;
                        h.j2(objArr8, objArr8, i9, e5, length2);
                    }
                }
                h.j2(objArr7, objArr7, i9, e5, e4);
            } else {
                Object[] objArr9 = this.f7160b;
                h.j2(objArr9, objArr9, size, 0, e4);
                Object[] objArr10 = this.f7160b;
                if (i9 >= objArr10.length) {
                    h.j2(objArr10, objArr10, i9 - objArr10.length, e5, objArr10.length);
                } else {
                    h.j2(objArr10, objArr10, 0, objArr10.length - size, objArr10.length);
                    Object[] objArr11 = this.f7160b;
                    h.j2(objArr11, objArr11, i9, e5, objArr11.length - size);
                }
            }
        }
        b(e5, collection);
        return true;
    }

    public final void b(int i4, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f7160b.length;
        while (i4 < length && it.hasNext()) {
            this.f7160b[i4] = it.next();
            i4++;
        }
        int i5 = this.f7159a;
        for (int i6 = 0; i6 < i5 && it.hasNext(); i6++) {
            this.f7160b[i6] = it.next();
        }
        this.f7161c = collection.size() + this.f7161c;
    }

    public final void c(int i4) {
        if (i4 >= 0) {
            Object[] objArr = this.f7160b;
            if (i4 <= objArr.length) {
                return;
            }
            if (objArr == f7158d) {
                if (i4 < 10) {
                    i4 = 10;
                }
                this.f7160b = new Object[i4];
                return;
            }
            int length = objArr.length;
            int i5 = length + (length >> 1);
            if (i5 - i4 < 0) {
                i5 = i4;
            }
            if (i5 - 2147483639 > 0) {
                if (i4 > 2147483639) {
                    i5 = Integer.MAX_VALUE;
                } else {
                    i5 = 2147483639;
                }
            }
            Object[] objArr2 = new Object[i5];
            h.j2(objArr, objArr2, 0, this.f7159a, objArr.length);
            Object[] objArr3 = this.f7160b;
            int length2 = objArr3.length;
            int i6 = this.f7159a;
            h.j2(objArr3, objArr2, length2 - i6, 0, i6);
            this.f7159a = 0;
            this.f7160b = objArr2;
            return;
        }
        throw new IllegalStateException("Deque is too big.");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        int e4 = e(this.f7159a + this.f7161c);
        int i4 = this.f7159a;
        if (i4 < e4) {
            h.l2(this.f7160b, i4, e4);
        } else if (!isEmpty()) {
            Object[] objArr = this.f7160b;
            h.l2(objArr, this.f7159a, objArr.length);
            h.l2(this.f7160b, 0, e4);
        }
        this.f7159a = 0;
        this.f7161c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    public final int d(int i4) {
        Object[] objArr = this.f7160b;
        com.google.common.collect.c.F(objArr, "<this>");
        if (i4 == objArr.length - 1) {
            return 0;
        }
        return i4 + 1;
    }

    public final int e(int i4) {
        Object[] objArr = this.f7160b;
        if (i4 >= objArr.length) {
            return i4 - objArr.length;
        }
        return i4;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i4) {
        l2.f.a(i4, this.f7161c);
        return this.f7160b[e(this.f7159a + i4)];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int e4 = e(this.f7159a + this.f7161c);
        int i4 = this.f7159a;
        if (i4 < e4) {
            while (i4 < e4) {
                if (!com.google.common.collect.c.n(obj, this.f7160b[i4])) {
                    i4++;
                }
            }
            return -1;
        } else if (i4 >= e4) {
            int length = this.f7160b.length;
            while (true) {
                if (i4 < length) {
                    if (com.google.common.collect.c.n(obj, this.f7160b[i4])) {
                        break;
                    }
                    i4++;
                } else {
                    for (int i5 = 0; i5 < e4; i5++) {
                        if (com.google.common.collect.c.n(obj, this.f7160b[i5])) {
                            i4 = i5 + this.f7160b.length;
                        }
                    }
                    return -1;
                }
            }
        } else {
            return -1;
        }
        return i4 - this.f7159a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        if (this.f7161c == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int e4 = e(this.f7159a + this.f7161c);
        int i4 = this.f7159a;
        if (i4 < e4) {
            length = e4 - 1;
            if (i4 <= length) {
                while (!com.google.common.collect.c.n(obj, this.f7160b[length])) {
                    if (length != i4) {
                        length--;
                    }
                }
                return length - this.f7159a;
            }
            return -1;
        }
        if (i4 > e4) {
            int i5 = e4 - 1;
            while (true) {
                if (-1 < i5) {
                    if (com.google.common.collect.c.n(obj, this.f7160b[i5])) {
                        length = i5 + this.f7160b.length;
                        break;
                    }
                    i5--;
                } else {
                    Object[] objArr = this.f7160b;
                    com.google.common.collect.c.F(objArr, "<this>");
                    length = objArr.length - 1;
                    int i6 = this.f7159a;
                    if (i6 <= length) {
                        while (!com.google.common.collect.c.n(obj, this.f7160b[length])) {
                            if (length != i6) {
                                length--;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int e4;
        com.google.common.collect.c.F(collection, "elements");
        boolean z4 = false;
        z4 = false;
        z4 = false;
        if (!isEmpty() && this.f7160b.length != 0) {
            int e5 = e(this.f7159a + this.f7161c);
            int i4 = this.f7159a;
            if (i4 < e5) {
                e4 = i4;
                while (i4 < e5) {
                    Object obj = this.f7160b[i4];
                    if (!collection.contains(obj)) {
                        this.f7160b[e4] = obj;
                        e4++;
                    } else {
                        z4 = true;
                    }
                    i4++;
                }
                h.l2(this.f7160b, e4, e5);
            } else {
                int length = this.f7160b.length;
                boolean z5 = false;
                int i5 = i4;
                while (i4 < length) {
                    Object[] objArr = this.f7160b;
                    Object obj2 = objArr[i4];
                    objArr[i4] = null;
                    if (!collection.contains(obj2)) {
                        this.f7160b[i5] = obj2;
                        i5++;
                    } else {
                        z5 = true;
                    }
                    i4++;
                }
                e4 = e(i5);
                for (int i6 = 0; i6 < e5; i6++) {
                    Object[] objArr2 = this.f7160b;
                    Object obj3 = objArr2[i6];
                    objArr2[i6] = null;
                    if (!collection.contains(obj3)) {
                        this.f7160b[e4] = obj3;
                        e4 = d(e4);
                    } else {
                        z5 = true;
                    }
                }
                z4 = z5;
            }
            if (z4) {
                int i7 = e4 - this.f7159a;
                if (i7 < 0) {
                    i7 += this.f7160b.length;
                }
                this.f7161c = i7;
            }
        }
        return z4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int e4;
        com.google.common.collect.c.F(collection, "elements");
        boolean z4 = false;
        z4 = false;
        z4 = false;
        if (!isEmpty() && this.f7160b.length != 0) {
            int e5 = e(this.f7159a + this.f7161c);
            int i4 = this.f7159a;
            if (i4 < e5) {
                e4 = i4;
                while (i4 < e5) {
                    Object obj = this.f7160b[i4];
                    if (collection.contains(obj)) {
                        this.f7160b[e4] = obj;
                        e4++;
                    } else {
                        z4 = true;
                    }
                    i4++;
                }
                h.l2(this.f7160b, e4, e5);
            } else {
                int length = this.f7160b.length;
                boolean z5 = false;
                int i5 = i4;
                while (i4 < length) {
                    Object[] objArr = this.f7160b;
                    Object obj2 = objArr[i4];
                    objArr[i4] = null;
                    if (collection.contains(obj2)) {
                        this.f7160b[i5] = obj2;
                        i5++;
                    } else {
                        z5 = true;
                    }
                    i4++;
                }
                e4 = e(i5);
                for (int i6 = 0; i6 < e5; i6++) {
                    Object[] objArr2 = this.f7160b;
                    Object obj3 = objArr2[i6];
                    objArr2[i6] = null;
                    if (collection.contains(obj3)) {
                        this.f7160b[e4] = obj3;
                        e4 = d(e4);
                    } else {
                        z5 = true;
                    }
                }
                z4 = z5;
            }
            if (z4) {
                int i7 = e4 - this.f7159a;
                if (i7 < 0) {
                    i7 += this.f7160b.length;
                }
                this.f7161c = i7;
            }
        }
        return z4;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i4, Object obj) {
        l2.f.a(i4, this.f7161c);
        int e4 = e(this.f7159a + i4);
        Object[] objArr = this.f7160b;
        Object obj2 = objArr[e4];
        objArr[e4] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[this.f7161c]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        com.google.common.collect.c.F(objArr, "array");
        int length = objArr.length;
        int i4 = this.f7161c;
        if (length < i4) {
            Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), i4);
            com.google.common.collect.c.D(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            objArr = (Object[]) newInstance;
        }
        int e4 = e(this.f7159a + this.f7161c);
        int i5 = this.f7159a;
        if (i5 < e4) {
            h.j2(this.f7160b, objArr, 0, i5, e4);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f7160b;
            h.j2(objArr2, objArr, 0, this.f7159a, objArr2.length);
            Object[] objArr3 = this.f7160b;
            h.j2(objArr3, objArr, objArr3.length - this.f7159a, 0, e4);
        }
        int length2 = objArr.length;
        int i6 = this.f7161c;
        if (length2 > i6) {
            objArr[i6] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        com.google.common.collect.c.F(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        c(collection.size() + this.f7161c);
        b(e(this.f7159a + this.f7161c), collection);
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        a(obj);
        return true;
    }
}
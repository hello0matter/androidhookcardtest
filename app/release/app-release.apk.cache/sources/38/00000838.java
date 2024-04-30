package l;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class c implements Collection, Set {

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f5212e = new int[0];

    /* renamed from: f  reason: collision with root package name */
    public static final Object[] f5213f = new Object[0];

    /* renamed from: g  reason: collision with root package name */
    public static Object[] f5214g;

    /* renamed from: h  reason: collision with root package name */
    public static int f5215h;

    /* renamed from: i  reason: collision with root package name */
    public static Object[] f5216i;

    /* renamed from: j  reason: collision with root package name */
    public static int f5217j;

    /* renamed from: a  reason: collision with root package name */
    public int[] f5218a = f5212e;

    /* renamed from: b  reason: collision with root package name */
    public Object[] f5219b = f5213f;

    /* renamed from: c  reason: collision with root package name */
    public int f5220c = 0;

    /* renamed from: d  reason: collision with root package name */
    public a f5221d;

    public static void b(int[] iArr, Object[] objArr, int i4) {
        if (iArr.length == 8) {
            synchronized (c.class) {
                try {
                    if (f5217j < 10) {
                        objArr[0] = f5216i;
                        objArr[1] = iArr;
                        for (int i5 = i4 - 1; i5 >= 2; i5--) {
                            objArr[i5] = null;
                        }
                        f5216i = objArr;
                        f5217j++;
                    }
                } finally {
                }
            }
        } else if (iArr.length == 4) {
            synchronized (c.class) {
                try {
                    if (f5215h < 10) {
                        objArr[0] = f5214g;
                        objArr[1] = iArr;
                        for (int i6 = i4 - 1; i6 >= 2; i6--) {
                            objArr[i6] = null;
                        }
                        f5214g = objArr;
                        f5215h++;
                    }
                } finally {
                }
            }
        }
    }

    public final void a(int i4) {
        if (i4 == 8) {
            synchronized (c.class) {
                try {
                    Object[] objArr = f5216i;
                    if (objArr != null) {
                        this.f5219b = objArr;
                        f5216i = (Object[]) objArr[0];
                        this.f5218a = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f5217j--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i4 == 4) {
            synchronized (c.class) {
                try {
                    Object[] objArr2 = f5214g;
                    if (objArr2 != null) {
                        this.f5219b = objArr2;
                        f5214g = (Object[]) objArr2[0];
                        this.f5218a = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f5215h--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f5218a = new int[i4];
        this.f5219b = new Object[i4];
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i4;
        int c4;
        if (obj == null) {
            c4 = d();
            i4 = 0;
        } else {
            int hashCode = obj.hashCode();
            i4 = hashCode;
            c4 = c(hashCode, obj);
        }
        if (c4 >= 0) {
            return false;
        }
        int i5 = ~c4;
        int i6 = this.f5220c;
        int[] iArr = this.f5218a;
        if (i6 >= iArr.length) {
            int i7 = 8;
            if (i6 >= 8) {
                i7 = (i6 >> 1) + i6;
            } else if (i6 < 4) {
                i7 = 4;
            }
            Object[] objArr = this.f5219b;
            a(i7);
            int[] iArr2 = this.f5218a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f5219b, 0, objArr.length);
            }
            b(iArr, objArr, this.f5220c);
        }
        int i8 = this.f5220c;
        if (i5 < i8) {
            int[] iArr3 = this.f5218a;
            int i9 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i9, i8 - i5);
            Object[] objArr2 = this.f5219b;
            System.arraycopy(objArr2, i5, objArr2, i9, this.f5220c - i5);
        }
        this.f5218a[i5] = i4;
        this.f5219b[i5] = obj;
        this.f5220c++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        int size = collection.size() + this.f5220c;
        int[] iArr = this.f5218a;
        boolean z4 = false;
        if (iArr.length < size) {
            Object[] objArr = this.f5219b;
            a(size);
            int i4 = this.f5220c;
            if (i4 > 0) {
                System.arraycopy(iArr, 0, this.f5218a, 0, i4);
                System.arraycopy(objArr, 0, this.f5219b, 0, this.f5220c);
            }
            b(iArr, objArr, this.f5220c);
        }
        for (Object obj : collection) {
            z4 |= add(obj);
        }
        return z4;
    }

    public final int c(int i4, Object obj) {
        int i5 = this.f5220c;
        if (i5 == 0) {
            return -1;
        }
        int a5 = d.a(i5, i4, this.f5218a);
        if (a5 < 0) {
            return a5;
        }
        if (obj.equals(this.f5219b[a5])) {
            return a5;
        }
        int i6 = a5 + 1;
        while (i6 < i5 && this.f5218a[i6] == i4) {
            if (obj.equals(this.f5219b[i6])) {
                return i6;
            }
            i6++;
        }
        for (int i7 = a5 - 1; i7 >= 0 && this.f5218a[i7] == i4; i7--) {
            if (obj.equals(this.f5219b[i7])) {
                return i7;
            }
        }
        return ~i6;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        int i4 = this.f5220c;
        if (i4 != 0) {
            b(this.f5218a, this.f5219b, i4);
            this.f5218a = f5212e;
            this.f5219b = f5213f;
            this.f5220c = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        for (Object obj : collection) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    public final int d() {
        int i4 = this.f5220c;
        if (i4 == 0) {
            return -1;
        }
        int a5 = d.a(i4, 0, this.f5218a);
        if (a5 < 0) {
            return a5;
        }
        if (this.f5219b[a5] == null) {
            return a5;
        }
        int i5 = a5 + 1;
        while (i5 < i4 && this.f5218a[i5] == 0) {
            if (this.f5219b[i5] == null) {
                return i5;
            }
            i5++;
        }
        for (int i6 = a5 - 1; i6 >= 0 && this.f5218a[i6] == 0; i6--) {
            if (this.f5219b[i6] == null) {
                return i6;
            }
        }
        return ~i5;
    }

    public final void e(int i4) {
        Object[] objArr = this.f5219b;
        Object obj = objArr[i4];
        int i5 = this.f5220c;
        if (i5 <= 1) {
            b(this.f5218a, objArr, i5);
            this.f5218a = f5212e;
            this.f5219b = f5213f;
            this.f5220c = 0;
            return;
        }
        int[] iArr = this.f5218a;
        int i6 = 8;
        if (iArr.length > 8 && i5 < iArr.length / 3) {
            if (i5 > 8) {
                i6 = i5 + (i5 >> 1);
            }
            a(i6);
            this.f5220c--;
            if (i4 > 0) {
                System.arraycopy(iArr, 0, this.f5218a, 0, i4);
                System.arraycopy(objArr, 0, this.f5219b, 0, i4);
            }
            int i7 = this.f5220c;
            if (i4 < i7) {
                int i8 = i4 + 1;
                System.arraycopy(iArr, i8, this.f5218a, i4, i7 - i4);
                System.arraycopy(objArr, i8, this.f5219b, i4, this.f5220c - i4);
                return;
            }
            return;
        }
        int i9 = i5 - 1;
        this.f5220c = i9;
        if (i4 < i9) {
            int i10 = i4 + 1;
            System.arraycopy(iArr, i10, iArr, i4, i9 - i4);
            Object[] objArr2 = this.f5219b;
            System.arraycopy(objArr2, i10, objArr2, i4, this.f5220c - i4);
        }
        this.f5219b[this.f5220c] = null;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.f5220c != set.size()) {
                return false;
            }
            for (int i4 = 0; i4 < this.f5220c; i4++) {
                try {
                    if (!set.contains(this.f5219b[i4])) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.f5218a;
        int i4 = this.f5220c;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            i5 += iArr[i6];
        }
        return i5;
    }

    public final int indexOf(Object obj) {
        if (obj == null) {
            return d();
        }
        return c(obj.hashCode(), obj);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        if (this.f5220c <= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        if (this.f5221d == null) {
            this.f5221d = new a(1, this);
        }
        a aVar = this.f5221d;
        if (((h) aVar.f4619b) == null) {
            aVar.f4619b = new h(aVar, 1);
        }
        return ((h) aVar.f4619b).iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            e(indexOf);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        boolean z4 = false;
        for (Object obj : collection) {
            z4 |= remove(obj);
        }
        return z4;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        boolean z4 = false;
        for (int i4 = this.f5220c - 1; i4 >= 0; i4--) {
            if (!collection.contains(this.f5219b[i4])) {
                e(i4);
                z4 = true;
            }
        }
        return z4;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f5220c;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        int i4 = this.f5220c;
        Object[] objArr = new Object[i4];
        System.arraycopy(this.f5219b, 0, objArr, 0, i4);
        return objArr;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f5220c * 14);
        sb.append('{');
        for (int i4 = 0; i4 < this.f5220c; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            Object obj = this.f5219b[i4];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        if (objArr.length < this.f5220c) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.f5220c);
        }
        System.arraycopy(this.f5219b, 0, objArr, 0, this.f5220c);
        int length = objArr.length;
        int i4 = this.f5220c;
        if (length > i4) {
            objArr[i4] = null;
        }
        return objArr;
    }
}
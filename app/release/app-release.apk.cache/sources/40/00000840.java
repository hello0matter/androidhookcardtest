package l;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: classes.dex */
public class k {

    /* renamed from: d  reason: collision with root package name */
    public static Object[] f5246d;

    /* renamed from: e  reason: collision with root package name */
    public static int f5247e;

    /* renamed from: f  reason: collision with root package name */
    public static Object[] f5248f;

    /* renamed from: g  reason: collision with root package name */
    public static int f5249g;

    /* renamed from: a  reason: collision with root package name */
    public int[] f5250a;

    /* renamed from: b  reason: collision with root package name */
    public Object[] f5251b;

    /* renamed from: c  reason: collision with root package name */
    public int f5252c;

    public k() {
        this.f5250a = d.f5222a;
        this.f5251b = d.f5223b;
        this.f5252c = 0;
    }

    public static void c(int[] iArr, Object[] objArr, int i4) {
        if (iArr.length == 8) {
            synchronized (k.class) {
                try {
                    if (f5249g < 10) {
                        objArr[0] = f5248f;
                        objArr[1] = iArr;
                        for (int i5 = (i4 << 1) - 1; i5 >= 2; i5--) {
                            objArr[i5] = null;
                        }
                        f5248f = objArr;
                        f5249g++;
                    }
                } finally {
                }
            }
        } else if (iArr.length == 4) {
            synchronized (k.class) {
                try {
                    if (f5247e < 10) {
                        objArr[0] = f5246d;
                        objArr[1] = iArr;
                        for (int i6 = (i4 << 1) - 1; i6 >= 2; i6--) {
                            objArr[i6] = null;
                        }
                        f5246d = objArr;
                        f5247e++;
                    }
                } finally {
                }
            }
        }
    }

    public final void a(int i4) {
        if (i4 == 8) {
            synchronized (k.class) {
                try {
                    Object[] objArr = f5248f;
                    if (objArr != null) {
                        this.f5251b = objArr;
                        f5248f = (Object[]) objArr[0];
                        this.f5250a = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f5249g--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i4 == 4) {
            synchronized (k.class) {
                try {
                    Object[] objArr2 = f5246d;
                    if (objArr2 != null) {
                        this.f5251b = objArr2;
                        f5246d = (Object[]) objArr2[0];
                        this.f5250a = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f5247e--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f5250a = new int[i4];
        this.f5251b = new Object[i4 << 1];
    }

    public final void b(int i4) {
        int i5 = this.f5252c;
        int[] iArr = this.f5250a;
        if (iArr.length < i4) {
            Object[] objArr = this.f5251b;
            a(i4);
            if (this.f5252c > 0) {
                System.arraycopy(iArr, 0, this.f5250a, 0, i5);
                System.arraycopy(objArr, 0, this.f5251b, 0, i5 << 1);
            }
            c(iArr, objArr, i5);
        }
        if (this.f5252c == i5) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    public final void clear() {
        int i4 = this.f5252c;
        if (i4 > 0) {
            int[] iArr = this.f5250a;
            Object[] objArr = this.f5251b;
            this.f5250a = d.f5222a;
            this.f5251b = d.f5223b;
            this.f5252c = 0;
            c(iArr, objArr, i4);
        }
        if (this.f5252c <= 0) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    public final boolean containsKey(Object obj) {
        if (e(obj) >= 0) {
            return true;
        }
        return false;
    }

    public final boolean containsValue(Object obj) {
        if (g(obj) >= 0) {
            return true;
        }
        return false;
    }

    public final int d(int i4, Object obj) {
        int i5 = this.f5252c;
        if (i5 == 0) {
            return -1;
        }
        try {
            int a5 = d.a(i5, i4, this.f5250a);
            if (a5 < 0) {
                return a5;
            }
            if (obj.equals(this.f5251b[a5 << 1])) {
                return a5;
            }
            int i6 = a5 + 1;
            while (i6 < i5 && this.f5250a[i6] == i4) {
                if (obj.equals(this.f5251b[i6 << 1])) {
                    return i6;
                }
                i6++;
            }
            for (int i7 = a5 - 1; i7 >= 0 && this.f5250a[i7] == i4; i7--) {
                if (obj.equals(this.f5251b[i7 << 1])) {
                    return i7;
                }
            }
            return ~i6;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int e(Object obj) {
        if (obj == null) {
            return f();
        }
        return d(obj.hashCode(), obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (this.f5252c != kVar.f5252c) {
                return false;
            }
            for (int i4 = 0; i4 < this.f5252c; i4++) {
                try {
                    Object h4 = h(i4);
                    Object j4 = j(i4);
                    Object orDefault = kVar.getOrDefault(h4, null);
                    if (j4 == null) {
                        if (orDefault != null || !kVar.containsKey(h4)) {
                            return false;
                        }
                    } else if (!j4.equals(orDefault)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this.f5252c != map.size()) {
                return false;
            }
            for (int i5 = 0; i5 < this.f5252c; i5++) {
                try {
                    Object h5 = h(i5);
                    Object j5 = j(i5);
                    Object obj2 = map.get(h5);
                    if (j5 == null) {
                        if (obj2 != null || !map.containsKey(h5)) {
                            return false;
                        }
                    } else if (!j5.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        int i4 = this.f5252c;
        if (i4 == 0) {
            return -1;
        }
        try {
            int a5 = d.a(i4, 0, this.f5250a);
            if (a5 < 0) {
                return a5;
            }
            if (this.f5251b[a5 << 1] == null) {
                return a5;
            }
            int i5 = a5 + 1;
            while (i5 < i4 && this.f5250a[i5] == 0) {
                if (this.f5251b[i5 << 1] == null) {
                    return i5;
                }
                i5++;
            }
            for (int i6 = a5 - 1; i6 >= 0 && this.f5250a[i6] == 0; i6--) {
                if (this.f5251b[i6 << 1] == null) {
                    return i6;
                }
            }
            return ~i5;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int g(Object obj) {
        int i4 = this.f5252c * 2;
        Object[] objArr = this.f5251b;
        if (obj == null) {
            for (int i5 = 1; i5 < i4; i5 += 2) {
                if (objArr[i5] == null) {
                    return i5 >> 1;
                }
            }
            return -1;
        }
        for (int i6 = 1; i6 < i4; i6 += 2) {
            if (obj.equals(objArr[i6])) {
                return i6 >> 1;
            }
        }
        return -1;
    }

    public final Object get(Object obj) {
        return getOrDefault(obj, null);
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int e4 = e(obj);
        if (e4 >= 0) {
            return this.f5251b[(e4 << 1) + 1];
        }
        return obj2;
    }

    public final Object h(int i4) {
        return this.f5251b[i4 << 1];
    }

    public final int hashCode() {
        int hashCode;
        int[] iArr = this.f5250a;
        Object[] objArr = this.f5251b;
        int i4 = this.f5252c;
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i4) {
            Object obj = objArr[i5];
            int i8 = iArr[i6];
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            i7 += hashCode ^ i8;
            i6++;
            i5 += 2;
        }
        return i7;
    }

    public final Object i(int i4) {
        Object[] objArr = this.f5251b;
        int i5 = i4 << 1;
        Object obj = objArr[i5 + 1];
        int i6 = this.f5252c;
        int i7 = 0;
        if (i6 <= 1) {
            c(this.f5250a, objArr, i6);
            this.f5250a = d.f5222a;
            this.f5251b = d.f5223b;
        } else {
            int i8 = i6 - 1;
            int[] iArr = this.f5250a;
            int i9 = 8;
            if (iArr.length > 8 && i6 < iArr.length / 3) {
                if (i6 > 8) {
                    i9 = i6 + (i6 >> 1);
                }
                a(i9);
                if (i6 == this.f5252c) {
                    if (i4 > 0) {
                        System.arraycopy(iArr, 0, this.f5250a, 0, i4);
                        System.arraycopy(objArr, 0, this.f5251b, 0, i5);
                    }
                    if (i4 < i8) {
                        int i10 = i4 + 1;
                        int i11 = i8 - i4;
                        System.arraycopy(iArr, i10, this.f5250a, i4, i11);
                        System.arraycopy(objArr, i10 << 1, this.f5251b, i5, i11 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (i4 < i8) {
                    int i12 = i4 + 1;
                    int i13 = i8 - i4;
                    System.arraycopy(iArr, i12, iArr, i4, i13);
                    Object[] objArr2 = this.f5251b;
                    System.arraycopy(objArr2, i12 << 1, objArr2, i5, i13 << 1);
                }
                Object[] objArr3 = this.f5251b;
                int i14 = i8 << 1;
                objArr3[i14] = null;
                objArr3[i14 + 1] = null;
            }
            i7 = i8;
        }
        if (i6 == this.f5252c) {
            this.f5252c = i7;
            return obj;
        }
        throw new ConcurrentModificationException();
    }

    public final boolean isEmpty() {
        if (this.f5252c <= 0) {
            return true;
        }
        return false;
    }

    public final Object j(int i4) {
        return this.f5251b[(i4 << 1) + 1];
    }

    public final Object put(Object obj, Object obj2) {
        int i4;
        int d4;
        int i5 = this.f5252c;
        if (obj == null) {
            d4 = f();
            i4 = 0;
        } else {
            int hashCode = obj.hashCode();
            i4 = hashCode;
            d4 = d(hashCode, obj);
        }
        if (d4 >= 0) {
            int i6 = (d4 << 1) + 1;
            Object[] objArr = this.f5251b;
            Object obj3 = objArr[i6];
            objArr[i6] = obj2;
            return obj3;
        }
        int i7 = ~d4;
        int[] iArr = this.f5250a;
        if (i5 >= iArr.length) {
            int i8 = 8;
            if (i5 >= 8) {
                i8 = (i5 >> 1) + i5;
            } else if (i5 < 4) {
                i8 = 4;
            }
            Object[] objArr2 = this.f5251b;
            a(i8);
            if (i5 == this.f5252c) {
                int[] iArr2 = this.f5250a;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.f5251b, 0, objArr2.length);
                }
                c(iArr, objArr2, i5);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i7 < i5) {
            int[] iArr3 = this.f5250a;
            int i9 = i7 + 1;
            System.arraycopy(iArr3, i7, iArr3, i9, i5 - i7);
            Object[] objArr3 = this.f5251b;
            System.arraycopy(objArr3, i7 << 1, objArr3, i9 << 1, (this.f5252c - i7) << 1);
        }
        int i10 = this.f5252c;
        if (i5 == i10) {
            int[] iArr4 = this.f5250a;
            if (i7 < iArr4.length) {
                iArr4[i7] = i4;
                Object[] objArr4 = this.f5251b;
                int i11 = i7 << 1;
                objArr4[i11] = obj;
                objArr4[i11 + 1] = obj2;
                this.f5252c = i10 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object orDefault = getOrDefault(obj, null);
        if (orDefault == null) {
            return put(obj, obj2);
        }
        return orDefault;
    }

    public final Object remove(Object obj) {
        int e4 = e(obj);
        if (e4 >= 0) {
            return i(e4);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int e4 = e(obj);
        if (e4 >= 0) {
            int i4 = (e4 << 1) + 1;
            Object[] objArr = this.f5251b;
            Object obj3 = objArr[i4];
            objArr[i4] = obj2;
            return obj3;
        }
        return null;
    }

    public final int size() {
        return this.f5252c;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f5252c * 28);
        sb.append('{');
        for (int i4 = 0; i4 < this.f5252c; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            Object h4 = h(i4);
            if (h4 != this) {
                sb.append(h4);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object j4 = j(i4);
            if (j4 != this) {
                sb.append(j4);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public k(int i4) {
        if (i4 == 0) {
            this.f5250a = d.f5222a;
            this.f5251b = d.f5223b;
        } else {
            a(i4);
        }
        this.f5252c = 0;
    }

    public final boolean remove(Object obj, Object obj2) {
        int e4 = e(obj);
        if (e4 >= 0) {
            Object j4 = j(e4);
            if (obj2 == j4 || (obj2 != null && obj2.equals(j4))) {
                i(e4);
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int e4 = e(obj);
        if (e4 >= 0) {
            Object j4 = j(e4);
            if (j4 == obj2 || (obj2 != null && obj2.equals(j4))) {
                int i4 = (e4 << 1) + 1;
                Object[] objArr = this.f5251b;
                Object obj4 = objArr[i4];
                objArr[i4] = obj3;
                return true;
            }
            return false;
        }
        return false;
    }
}
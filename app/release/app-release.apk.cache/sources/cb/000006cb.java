package f3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Object[] f4576a = new Object[0];

    public static final Object[] a(Collection collection) {
        com.google.common.collect.c.F(collection, "collection");
        int size = collection.size();
        Object[] objArr = f4576a;
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArr2 = new Object[size];
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    objArr2[i4] = it.next();
                    if (i5 >= objArr2.length) {
                        if (it.hasNext()) {
                            int i6 = ((i5 * 3) + 1) >>> 1;
                            if (i6 <= i5) {
                                i6 = 2147483645;
                                if (i5 >= 2147483645) {
                                    throw new OutOfMemoryError();
                                }
                            }
                            objArr2 = Arrays.copyOf(objArr2, i6);
                            com.google.common.collect.c.E(objArr2, "copyOf(result, newSize)");
                        } else {
                            return objArr2;
                        }
                    } else if (!it.hasNext()) {
                        Object[] copyOf = Arrays.copyOf(objArr2, i5);
                        com.google.common.collect.c.E(copyOf, "copyOf(result, size)");
                        return copyOf;
                    }
                    i4 = i5;
                }
            } else {
                return objArr;
            }
        } else {
            return objArr;
        }
    }

    public static final Object[] b(Collection collection, Object[] objArr) {
        Object[] objArr2;
        com.google.common.collect.c.F(collection, "collection");
        objArr.getClass();
        int size = collection.size();
        int i4 = 0;
        if (size == 0) {
            if (objArr.length > 0) {
                objArr[0] = null;
                return objArr;
            }
            return objArr;
        }
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            if (objArr.length > 0) {
                objArr[0] = null;
                return objArr;
            }
            return objArr;
        }
        if (size <= objArr.length) {
            objArr2 = objArr;
        } else {
            Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
            com.google.common.collect.c.D(newInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr2 = (Object[]) newInstance;
        }
        while (true) {
            int i5 = i4 + 1;
            objArr2[i4] = it.next();
            if (i5 >= objArr2.length) {
                if (!it.hasNext()) {
                    return objArr2;
                }
                int i6 = ((i5 * 3) + 1) >>> 1;
                if (i6 <= i5) {
                    i6 = 2147483645;
                    if (i5 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                }
                objArr2 = Arrays.copyOf(objArr2, i6);
                com.google.common.collect.c.E(objArr2, "copyOf(result, newSize)");
            } else if (!it.hasNext()) {
                if (objArr2 == objArr) {
                    objArr[i5] = null;
                    return objArr;
                }
                Object[] copyOf = Arrays.copyOf(objArr2, i5);
                com.google.common.collect.c.E(copyOf, "copyOf(result, size)");
                return copyOf;
            }
            i4 = i5;
        }
    }
}
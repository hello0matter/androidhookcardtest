package y2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class h extends com.google.common.collect.c {
    public static int h2(Iterable iterable) {
        com.google.common.collect.c.F(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return 10;
    }

    public static void i2(int i4, int i5, int i6, byte[] bArr, byte[] bArr2) {
        com.google.common.collect.c.F(bArr, "<this>");
        com.google.common.collect.c.F(bArr2, "destination");
        System.arraycopy(bArr, i5, bArr2, i4, i6 - i5);
    }

    public static final void j2(Object[] objArr, Object[] objArr2, int i4, int i5, int i6) {
        com.google.common.collect.c.F(objArr, "<this>");
        com.google.common.collect.c.F(objArr2, "destination");
        System.arraycopy(objArr, i5, objArr2, i4, i6 - i5);
    }

    public static byte[] k2(byte[] bArr, int i4, int i5) {
        com.google.common.collect.c.F(bArr, "<this>");
        int length = bArr.length;
        if (i5 <= length) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, i4, i5);
            com.google.common.collect.c.E(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i5 + ") is greater than size (" + length + ").");
    }

    public static void l2(Object[] objArr, int i4, int i5) {
        com.google.common.collect.c.F(objArr, "<this>");
        Arrays.fill(objArr, i4, i5, (Object) null);
    }

    public static ArrayList m2(Object[] objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static char n2(char[] cArr) {
        com.google.common.collect.c.F(cArr, "<this>");
        int length = cArr.length;
        if (length != 0) {
            if (length == 1) {
                return cArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }
}
package y2;

import java.util.AbstractList;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class e extends AbstractList implements List {
    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i4) {
        g gVar = (g) this;
        l2.f.a(i4, gVar.f7161c);
        if (i4 == com.google.common.collect.c.x0(gVar)) {
            if (!gVar.isEmpty()) {
                int e4 = gVar.e(com.google.common.collect.c.x0(gVar) + gVar.f7159a);
                Object[] objArr = gVar.f7160b;
                Object obj = objArr[e4];
                objArr[e4] = null;
                gVar.f7161c--;
                return obj;
            }
            throw new NoSuchElementException("ArrayDeque is empty.");
        } else if (i4 == 0) {
            if (!gVar.isEmpty()) {
                Object[] objArr2 = gVar.f7160b;
                int i5 = gVar.f7159a;
                Object obj2 = objArr2[i5];
                objArr2[i5] = null;
                gVar.f7159a = gVar.d(i5);
                gVar.f7161c--;
                return obj2;
            }
            throw new NoSuchElementException("ArrayDeque is empty.");
        } else {
            int e5 = gVar.e(gVar.f7159a + i4);
            Object[] objArr3 = gVar.f7160b;
            Object obj3 = objArr3[e5];
            if (i4 < (gVar.f7161c >> 1)) {
                int i6 = gVar.f7159a;
                if (e5 >= i6) {
                    h.j2(objArr3, objArr3, i6 + 1, i6, e5);
                } else {
                    h.j2(objArr3, objArr3, 1, 0, e5);
                    Object[] objArr4 = gVar.f7160b;
                    objArr4[0] = objArr4[objArr4.length - 1];
                    int i7 = gVar.f7159a;
                    h.j2(objArr4, objArr4, i7 + 1, i7, objArr4.length - 1);
                }
                Object[] objArr5 = gVar.f7160b;
                int i8 = gVar.f7159a;
                objArr5[i8] = null;
                gVar.f7159a = gVar.d(i8);
            } else {
                int e6 = gVar.e(com.google.common.collect.c.x0(gVar) + gVar.f7159a);
                Object[] objArr6 = gVar.f7160b;
                int i9 = e5 + 1;
                if (e5 <= e6) {
                    h.j2(objArr6, objArr6, e5, i9, e6 + 1);
                } else {
                    h.j2(objArr6, objArr6, e5, i9, objArr6.length);
                    Object[] objArr7 = gVar.f7160b;
                    objArr7[objArr7.length - 1] = objArr7[0];
                    h.j2(objArr7, objArr7, 0, 1, e6 + 1);
                }
                gVar.f7160b[e6] = null;
            }
            gVar.f7161c--;
            return obj3;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return ((g) this).f7161c;
    }
}
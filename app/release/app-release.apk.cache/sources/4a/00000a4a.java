package y2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class a implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7149a = 2;

    /* renamed from: b  reason: collision with root package name */
    public int f7150b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f7151c;

    public a(k3.a aVar) {
        this.f7151c = aVar.f5144a.iterator();
        this.f7150b = aVar.f5145b;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i4 = this.f7149a;
        Object obj = this.f7151c;
        switch (i4) {
            case 0:
                if (this.f7150b >= ((d) obj).a()) {
                    return false;
                }
                return true;
            case 1:
                if (this.f7150b >= ((Object[]) obj).length) {
                    return false;
                }
                return true;
        }
        while (this.f7150b > 0) {
            Iterator it = (Iterator) obj;
            if (it.hasNext()) {
                it.next();
                this.f7150b--;
            } else {
                return ((Iterator) obj).hasNext();
            }
        }
        return ((Iterator) obj).hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i4 = this.f7149a;
        Object obj = this.f7151c;
        switch (i4) {
            case 0:
                if (hasNext()) {
                    int i5 = this.f7150b;
                    this.f7150b = i5 + 1;
                    return ((d) obj).get(i5);
                }
                throw new NoSuchElementException();
            case 1:
                try {
                    int i6 = this.f7150b;
                    this.f7150b = i6 + 1;
                    return ((Object[]) obj)[i6];
                } catch (ArrayIndexOutOfBoundsException e4) {
                    this.f7150b--;
                    throw new NoSuchElementException(e4.getMessage());
                }
        }
        while (this.f7150b > 0) {
            Iterator it = (Iterator) obj;
            if (it.hasNext()) {
                it.next();
                this.f7150b--;
            } else {
                return ((Iterator) obj).next();
            }
        }
        return ((Iterator) obj).next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f7149a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public a(d dVar) {
        this.f7151c = dVar;
    }

    public a(Object[] objArr) {
        com.google.common.collect.c.F(objArr, "array");
        this.f7151c = objArr;
    }
}
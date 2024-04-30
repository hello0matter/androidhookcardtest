package i3;

import java.util.Iterator;

/* loaded from: classes.dex */
public class a implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    public final int f5064a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5065b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5066c;

    public a(int i4, int i5, int i6) {
        if (i6 != 0) {
            if (i6 != Integer.MIN_VALUE) {
                this.f5064a = i4;
                this.f5065b = com.google.common.collect.c.L0(i4, i5, i6);
                this.f5066c = i6;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f5064a != aVar.f5064a || this.f5065b != aVar.f5065b || this.f5066c != aVar.f5066c) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f5064a * 31) + this.f5065b) * 31) + this.f5066c;
    }

    public boolean isEmpty() {
        int i4 = this.f5066c;
        int i5 = this.f5065b;
        int i6 = this.f5064a;
        if (i4 > 0) {
            if (i6 <= i5) {
                return false;
            }
        } else if (i6 >= i5) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new b(this.f5064a, this.f5065b, this.f5066c);
    }

    public String toString() {
        StringBuilder sb;
        int i4 = this.f5065b;
        int i5 = this.f5064a;
        int i6 = this.f5066c;
        if (i6 > 0) {
            sb = new StringBuilder();
            sb.append(i5);
            sb.append("..");
            sb.append(i4);
            sb.append(" step ");
            sb.append(i6);
        } else {
            sb = new StringBuilder();
            sb.append(i5);
            sb.append(" downTo ");
            sb.append(i4);
            sb.append(" step ");
            sb.append(-i6);
        }
        return sb.toString();
    }
}
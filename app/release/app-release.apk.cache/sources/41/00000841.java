package l;

/* loaded from: classes.dex */
public final class l implements Cloneable {

    /* renamed from: d  reason: collision with root package name */
    public static final Object f5253d = new Object();

    /* renamed from: a  reason: collision with root package name */
    public int[] f5254a;

    /* renamed from: b  reason: collision with root package name */
    public Object[] f5255b;

    /* renamed from: c  reason: collision with root package name */
    public int f5256c;

    public l() {
        int i4;
        int i5 = 4;
        while (true) {
            i4 = 40;
            if (i5 >= 32) {
                break;
            }
            int i6 = (1 << i5) - 12;
            if (40 <= i6) {
                i4 = i6;
                break;
            }
            i5++;
        }
        int i7 = i4 / 4;
        this.f5254a = new int[i7];
        this.f5255b = new Object[i7];
    }

    public final void a(int i4, Object obj) {
        int i5 = this.f5256c;
        if (i5 != 0 && i4 <= this.f5254a[i5 - 1]) {
            d(i4, obj);
            return;
        }
        if (i5 >= this.f5254a.length) {
            int i6 = (i5 + 1) * 4;
            int i7 = 4;
            while (true) {
                if (i7 >= 32) {
                    break;
                }
                int i8 = (1 << i7) - 12;
                if (i6 <= i8) {
                    i6 = i8;
                    break;
                }
                i7++;
            }
            int i9 = i6 / 4;
            int[] iArr = new int[i9];
            Object[] objArr = new Object[i9];
            int[] iArr2 = this.f5254a;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f5255b;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f5254a = iArr;
            this.f5255b = objArr;
        }
        this.f5254a[i5] = i4;
        this.f5255b[i5] = obj;
        this.f5256c = i5 + 1;
    }

    /* renamed from: b */
    public final l clone() {
        try {
            l lVar = (l) super.clone();
            lVar.f5254a = (int[]) this.f5254a.clone();
            lVar.f5255b = (Object[]) this.f5255b.clone();
            return lVar;
        } catch (CloneNotSupportedException e4) {
            throw new AssertionError(e4);
        }
    }

    public final Object c(int i4, Integer num) {
        Object obj;
        int a5 = d.a(this.f5256c, i4, this.f5254a);
        if (a5 >= 0 && (obj = this.f5255b[a5]) != f5253d) {
            return obj;
        }
        return num;
    }

    public final void d(int i4, Object obj) {
        int a5 = d.a(this.f5256c, i4, this.f5254a);
        if (a5 >= 0) {
            this.f5255b[a5] = obj;
            return;
        }
        int i5 = ~a5;
        int i6 = this.f5256c;
        if (i5 < i6) {
            Object[] objArr = this.f5255b;
            if (objArr[i5] == f5253d) {
                this.f5254a[i5] = i4;
                objArr[i5] = obj;
                return;
            }
        }
        if (i6 >= this.f5254a.length) {
            int i7 = (i6 + 1) * 4;
            int i8 = 4;
            while (true) {
                if (i8 >= 32) {
                    break;
                }
                int i9 = (1 << i8) - 12;
                if (i7 <= i9) {
                    i7 = i9;
                    break;
                }
                i8++;
            }
            int i10 = i7 / 4;
            int[] iArr = new int[i10];
            Object[] objArr2 = new Object[i10];
            int[] iArr2 = this.f5254a;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f5255b;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f5254a = iArr;
            this.f5255b = objArr2;
        }
        int i11 = this.f5256c - i5;
        if (i11 != 0) {
            int[] iArr3 = this.f5254a;
            int i12 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i12, i11);
            Object[] objArr4 = this.f5255b;
            System.arraycopy(objArr4, i5, objArr4, i12, this.f5256c - i5);
        }
        this.f5254a[i5] = i4;
        this.f5255b[i5] = obj;
        this.f5256c++;
    }

    public final String toString() {
        int i4 = this.f5256c;
        if (i4 <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i4 * 28);
        sb.append('{');
        for (int i5 = 0; i5 < this.f5256c; i5++) {
            if (i5 > 0) {
                sb.append(", ");
            }
            sb.append(this.f5254a[i5]);
            sb.append('=');
            Object obj = this.f5255b[i5];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
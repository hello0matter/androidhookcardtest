package l;

/* loaded from: classes.dex */
public final class e implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public static final Object f5224e = new Object();

    /* renamed from: a  reason: collision with root package name */
    public boolean f5225a = false;

    /* renamed from: b  reason: collision with root package name */
    public long[] f5226b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f5227c;

    /* renamed from: d  reason: collision with root package name */
    public int f5228d;

    public e() {
        int i4;
        int i5 = 4;
        while (true) {
            i4 = 80;
            if (i5 >= 32) {
                break;
            }
            int i6 = (1 << i5) - 12;
            if (80 <= i6) {
                i4 = i6;
                break;
            }
            i5++;
        }
        int i7 = i4 / 8;
        this.f5226b = new long[i7];
        this.f5227c = new Object[i7];
    }

    public final void a() {
        int i4 = this.f5228d;
        Object[] objArr = this.f5227c;
        for (int i5 = 0; i5 < i4; i5++) {
            objArr[i5] = null;
        }
        this.f5228d = 0;
        this.f5225a = false;
    }

    /* renamed from: b */
    public final e clone() {
        try {
            e eVar = (e) super.clone();
            eVar.f5226b = (long[]) this.f5226b.clone();
            eVar.f5227c = (Object[]) this.f5227c.clone();
            return eVar;
        } catch (CloneNotSupportedException e4) {
            throw new AssertionError(e4);
        }
    }

    public final void c() {
        int i4 = this.f5228d;
        long[] jArr = this.f5226b;
        Object[] objArr = this.f5227c;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            Object obj = objArr[i6];
            if (obj != f5224e) {
                if (i6 != i5) {
                    jArr[i5] = jArr[i6];
                    objArr[i5] = obj;
                    objArr[i6] = null;
                }
                i5++;
            }
        }
        this.f5225a = false;
        this.f5228d = i5;
    }

    public final Object d(long j4, Long l4) {
        Object obj;
        int b5 = d.b(this.f5226b, this.f5228d, j4);
        if (b5 >= 0 && (obj = this.f5227c[b5]) != f5224e) {
            return obj;
        }
        return l4;
    }

    public final void e(long j4, Object obj) {
        int b5 = d.b(this.f5226b, this.f5228d, j4);
        if (b5 >= 0) {
            this.f5227c[b5] = obj;
            return;
        }
        int i4 = ~b5;
        int i5 = this.f5228d;
        if (i4 < i5) {
            Object[] objArr = this.f5227c;
            if (objArr[i4] == f5224e) {
                this.f5226b[i4] = j4;
                objArr[i4] = obj;
                return;
            }
        }
        if (this.f5225a && i5 >= this.f5226b.length) {
            c();
            i4 = ~d.b(this.f5226b, this.f5228d, j4);
        }
        int i6 = this.f5228d;
        if (i6 >= this.f5226b.length) {
            int i7 = (i6 + 1) * 8;
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
            int i10 = i7 / 8;
            long[] jArr = new long[i10];
            Object[] objArr2 = new Object[i10];
            long[] jArr2 = this.f5226b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f5227c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f5226b = jArr;
            this.f5227c = objArr2;
        }
        int i11 = this.f5228d - i4;
        if (i11 != 0) {
            long[] jArr3 = this.f5226b;
            int i12 = i4 + 1;
            System.arraycopy(jArr3, i4, jArr3, i12, i11);
            Object[] objArr4 = this.f5227c;
            System.arraycopy(objArr4, i4, objArr4, i12, this.f5228d - i4);
        }
        this.f5226b[i4] = j4;
        this.f5227c[i4] = obj;
        this.f5228d++;
    }

    public final int f() {
        if (this.f5225a) {
            c();
        }
        return this.f5228d;
    }

    public final Object g(int i4) {
        if (this.f5225a) {
            c();
        }
        return this.f5227c[i4];
    }

    public final String toString() {
        if (f() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f5228d * 28);
        sb.append('{');
        for (int i4 = 0; i4 < this.f5228d; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            if (this.f5225a) {
                c();
            }
            sb.append(this.f5226b[i4]);
            sb.append('=');
            Object g4 = g(i4);
            if (g4 != this) {
                sb.append(g4);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
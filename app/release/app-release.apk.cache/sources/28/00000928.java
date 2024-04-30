package p;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6094a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f6095b;

    /* renamed from: c  reason: collision with root package name */
    public int f6096c;

    public g(int i4, int i5) {
        this.f6094a = i5;
        if (i5 != 1) {
            if (i4 > 0) {
                this.f6095b = new Object[i4];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        } else if (i4 > 0) {
            this.f6095b = new Object[i4];
        } else {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
    }

    public Object a() {
        int i4 = this.f6094a;
        Object[] objArr = this.f6095b;
        switch (i4) {
            case 0:
                int i5 = this.f6096c;
                if (i5 <= 0) {
                    return null;
                }
                int i6 = i5 - 1;
                Object obj = objArr[i6];
                objArr[i6] = null;
                this.f6096c = i6;
                return obj;
            default:
                int i7 = this.f6096c;
                if (i7 <= 0) {
                    return null;
                }
                int i8 = i7 - 1;
                Object obj2 = objArr[i8];
                objArr[i8] = null;
                this.f6096c = i8;
                return obj2;
        }
    }

    public boolean b(Object obj) {
        int i4 = this.f6094a;
        Object[] objArr = this.f6095b;
        switch (i4) {
            case 0:
                int i5 = this.f6096c;
                if (i5 >= objArr.length) {
                    return false;
                }
                objArr[i5] = obj;
                this.f6096c = i5 + 1;
                return true;
            default:
                int i6 = 0;
                while (true) {
                    int i7 = this.f6096c;
                    if (i6 < i7) {
                        if (objArr[i6] != obj) {
                            i6++;
                        } else {
                            throw new IllegalStateException("Already in the pool!");
                        }
                    } else if (i7 >= objArr.length) {
                        return false;
                    } else {
                        objArr[i7] = obj;
                        this.f6096c = i7 + 1;
                        return true;
                    }
                }
        }
    }
}
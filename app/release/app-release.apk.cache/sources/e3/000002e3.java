package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public int f2042a;

    /* renamed from: b  reason: collision with root package name */
    public int f2043b;

    /* renamed from: c  reason: collision with root package name */
    public Object f2044c;

    /* renamed from: d  reason: collision with root package name */
    public int f2045d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        int i4 = this.f2042a;
        if (i4 != aVar.f2042a) {
            return false;
        }
        if (i4 == 8 && Math.abs(this.f2045d - this.f2043b) == 1 && this.f2045d == aVar.f2043b && this.f2043b == aVar.f2045d) {
            return true;
        }
        if (this.f2045d == aVar.f2045d && this.f2043b == aVar.f2043b) {
            Object obj2 = this.f2044c;
            Object obj3 = aVar.f2044c;
            if (obj2 != null) {
                if (!obj2.equals(obj3)) {
                    return false;
                }
            } else if (obj3 != null) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.f2042a * 31) + this.f2043b) * 31) + this.f2045d;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[");
        int i4 = this.f2042a;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 4) {
                    if (i4 != 8) {
                        str = "??";
                    } else {
                        str = "mv";
                    }
                } else {
                    str = "up";
                }
            } else {
                str = "rm";
            }
        } else {
            str = "add";
        }
        sb.append(str);
        sb.append(",s:");
        sb.append(this.f2043b);
        sb.append("c:");
        sb.append(this.f2045d);
        sb.append(",p:");
        sb.append(this.f2044c);
        sb.append("]");
        return sb.toString();
    }
}
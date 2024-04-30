package androidx.activity;

/* loaded from: classes.dex */
public abstract /* synthetic */ class j {
    public static float a(float f4, float f5, float f6, float f7) {
        return ((f4 - f5) * f6) + f7;
    }

    public static String b(String str, int i4) {
        return str + i4;
    }

    public static String c(String str, String str2) {
        return str + str2;
    }

    public static String d(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String e(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static /* synthetic */ void f(Object obj) {
        if (obj == null) {
            return;
        }
        throw new ClassCastException();
    }

    public static /* synthetic */ void g(Object obj) {
        throw new ClassCastException();
    }
}
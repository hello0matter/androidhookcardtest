package h0;

/* loaded from: classes.dex */
public abstract class e {
    public static void a(String str, boolean z4) {
        if (z4) {
            return;
        }
        throw new IllegalArgumentException(str);
    }

    public static void b(int i4) {
        if (i4 >= 0) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void c(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new NullPointerException(str);
    }
}
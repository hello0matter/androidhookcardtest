package i0;

/* loaded from: classes.dex */
public abstract class e2 {
    public static int a(int i4) {
        if (i4 != 1) {
            if (i4 == 2) {
                return 1;
            }
            if (i4 == 4) {
                return 2;
            }
            if (i4 != 8) {
                if (i4 == 16) {
                    return 4;
                }
                if (i4 != 32) {
                    if (i4 != 64) {
                        if (i4 != 128) {
                            if (i4 == 256) {
                                return 8;
                            }
                            throw new IllegalArgumentException(androidx.activity.j.b("type needs to be >= FIRST and <= LAST, type=", i4));
                        }
                        return 7;
                    }
                    return 6;
                }
                return 5;
            }
            return 3;
        }
        return 0;
    }
}
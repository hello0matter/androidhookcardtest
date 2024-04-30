package c1;

import android.os.Build;

/* loaded from: classes.dex */
public abstract class l0 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f2643a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f2644b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f2645c;

    static {
        int i4 = Build.VERSION.SDK_INT;
        boolean z4 = true;
        f2643a = true;
        f2644b = true;
        if (i4 < 28) {
            z4 = false;
        }
        f2645c = z4;
    }
}
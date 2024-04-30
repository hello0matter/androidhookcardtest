package a0;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal f38a = new ThreadLocal();

    /* renamed from: b  reason: collision with root package name */
    public static final WeakHashMap f39b = new WeakHashMap(0);

    /* renamed from: c  reason: collision with root package name */
    public static final Object f40c = new Object();

    public static Typeface a(Context context, int i4) {
        if (context.isRestricted()) {
            return null;
        }
        return b(context, i4, new TypedValue(), 0, null, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b8 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Typeface b(android.content.Context r16, int r17, android.util.TypedValue r18, int r19, a0.p r20, boolean r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a0.s.b(android.content.Context, int, android.util.TypedValue, int, a0.p, boolean, boolean):android.graphics.Typeface");
    }
}
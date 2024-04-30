package b0;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public static final n f2498a;

    /* renamed from: b  reason: collision with root package name */
    public static final l.f f2499b;

    static {
        n nVar;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 29) {
            nVar = new n();
        } else if (i4 >= 28) {
            nVar = new k();
        } else if (i4 >= 26) {
            nVar = new k();
        } else {
            Method method = j.f2507c;
            if (method == null) {
                Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
            }
            if (method != null) {
                nVar = new n();
            } else {
                nVar = new n();
            }
        }
        f2498a = nVar;
        f2499b = new l.f(16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
        if (r3.equals(r5) == false) goto L11;
     */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Object, b0.g] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Typeface a(android.content.Context r15, a0.f r16, android.content.res.Resources r17, int r18, java.lang.String r19, int r20, int r21, a0.p r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.h.a(android.content.Context, a0.f, android.content.res.Resources, int, java.lang.String, int, int, a0.p, boolean):android.graphics.Typeface");
    }

    public static String b(Resources resources, int i4, String str, int i5, int i6) {
        return resources.getResourcePackageName(i4) + '-' + str + '-' + i5 + '-' + i4 + '-' + i6;
    }
}
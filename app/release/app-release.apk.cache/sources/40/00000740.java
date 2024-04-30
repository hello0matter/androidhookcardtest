package i0;

import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public abstract class e0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f4920a;

    /* renamed from: b  reason: collision with root package name */
    public final Class f4921b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4922c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4923d;

    public e0(int i4, Class cls, int i5, int i6) {
        this.f4920a = i4;
        this.f4921b = cls;
        this.f4923d = i5;
        this.f4922c = i6;
    }

    public final Object a(View view) {
        if (Build.VERSION.SDK_INT >= this.f4922c) {
            int i4 = ((c0) this).f4914e;
            switch (i4) {
                case 0:
                    switch (i4) {
                        case 0:
                            return Boolean.valueOf(r0.d(view));
                        default:
                            return Boolean.valueOf(r0.c(view));
                    }
                case 1:
                    switch (i4) {
                        case 1:
                            return r0.b(view);
                        default:
                            return t0.a(view);
                    }
                case 2:
                    switch (i4) {
                        case 1:
                            return r0.b(view);
                        default:
                            return t0.a(view);
                    }
                default:
                    switch (i4) {
                        case 0:
                            return Boolean.valueOf(r0.d(view));
                        default:
                            return Boolean.valueOf(r0.c(view));
                    }
            }
        }
        Object tag = view.getTag(this.f4920a);
        if (this.f4921b.isInstance(tag)) {
            return tag;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0086, code lost:
        if (r0 == r1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0088, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a3, code lost:
        if (r0 == r1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ea, code lost:
        if (r0 == r1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0103, code lost:
        if (r0 == r1) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(android.view.View r6, java.lang.Object r7) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.e0.b(android.view.View, java.lang.Object):void");
    }
}
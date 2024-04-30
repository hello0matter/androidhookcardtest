package f0;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public static final l.f f4529a = new l.f(16);

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadPoolExecutor f4530b;

    /* renamed from: c  reason: collision with root package name */
    public static final Object f4531c;

    /* renamed from: d  reason: collision with root package name */
    public static final l.k f4532d;

    /* JADX WARN: Type inference failed for: r9v0, types: [f0.n, java.lang.Object, java.util.concurrent.ThreadFactory] */
    static {
        ?? obj = new Object();
        obj.f4541a = "fonts-androidx";
        obj.f4542b = 10;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), (ThreadFactory) obj);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f4530b = threadPoolExecutor;
        f4531c = new Object();
        f4532d = new l.k();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static f0.h a(java.lang.String r6, android.content.Context r7, f0.e r8, int r9) {
        /*
            l.f r0 = f0.i.f4529a
            java.lang.Object r1 = r0.a(r6)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L10
            f0.h r6 = new f0.h
            r6.<init>(r1)
            return r6
        L10:
            f0.j r8 = f0.d.a(r7, r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5a
            r1 = 1
            r2 = -3
            f0.k[] r3 = r8.f4534b
            int r8 = r8.f4533a
            if (r8 == 0) goto L22
            if (r8 == r1) goto L20
        L1e:
            r1 = r2
            goto L3b
        L20:
            r1 = -2
            goto L3b
        L22:
            if (r3 == 0) goto L3b
            int r8 = r3.length
            if (r8 != 0) goto L28
            goto L3b
        L28:
            int r8 = r3.length
            r1 = 0
            r4 = r1
        L2b:
            if (r4 >= r8) goto L3b
            r5 = r3[r4]
            int r5 = r5.f4539e
            if (r5 == 0) goto L38
            if (r5 >= 0) goto L36
            goto L1e
        L36:
            r1 = r5
            goto L3b
        L38:
            int r4 = r4 + 1
            goto L2b
        L3b:
            if (r1 == 0) goto L43
            f0.h r6 = new f0.h
            r6.<init>(r1)
            return r6
        L43:
            b0.n r8 = b0.h.f2498a
            android.graphics.Typeface r7 = r8.b(r7, r3, r9)
            if (r7 == 0) goto L54
            r0.b(r6, r7)
            f0.h r6 = new f0.h
            r6.<init>(r7)
            return r6
        L54:
            f0.h r6 = new f0.h
            r6.<init>(r2)
            return r6
        L5a:
            f0.h r6 = new f0.h
            r7 = -1
            r6.<init>(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: f0.i.a(java.lang.String, android.content.Context, f0.e, int):f0.h");
    }
}
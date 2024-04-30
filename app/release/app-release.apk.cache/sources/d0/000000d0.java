package androidx.appcompat.app;

import android.content.Context;

/* loaded from: classes.dex */
public final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f306a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f307b;

    public /* synthetic */ n(Context context, int i4) {
        this.f306a = i4;
        this.f307b = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0088, code lost:
        if (r5 != null) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0099  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r11 = this;
            int r0 = r11.f306a
            android.content.Context r1 = r11.f307b
            switch(r0) {
                case 0: goto L2f;
                case 1: goto L14;
                default: goto L7;
            }
        L7:
            h.a r0 = new h.a
            r2 = 5
            r0.<init>(r2)
            l2.f r2 = x0.e.f7114a
            r3 = 0
            x0.e.b(r1, r0, r2, r3)
            return
        L14:
            java.util.concurrent.ThreadPoolExecutor r0 = new java.util.concurrent.ThreadPoolExecutor
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.concurrent.LinkedBlockingQueue r10 = new java.util.concurrent.LinkedBlockingQueue
            r10.<init>()
            r7 = 0
            r5 = 0
            r6 = 1
            r4 = r0
            r4.<init>(r5, r6, r7, r9, r10)
            androidx.appcompat.app.n r2 = new androidx.appcompat.app.n
            r3 = 2
            r2.<init>(r1, r3)
            r0.execute(r2)
            return
        L2f:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 33
            r3 = 1
            if (r0 < r2) goto Lb1
            android.content.ComponentName r0 = new android.content.ComponentName
            java.lang.String r2 = "androidx.appcompat.app.AppLocalesMetadataHolderService"
            r0.<init>(r1, r2)
            android.content.pm.PackageManager r2 = r1.getPackageManager()
            int r2 = r2.getComponentEnabledSetting(r0)
            if (r2 == r3) goto Lb1
            boolean r2 = e0.a.a()
            java.lang.String r4 = "locale"
            if (r2 == 0) goto L86
            l.c r2 = androidx.appcompat.app.q.f318g
            java.util.Iterator r2 = r2.iterator()
        L55:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L74
            java.lang.Object r5 = r2.next()
            java.lang.ref.WeakReference r5 = (java.lang.ref.WeakReference) r5
            java.lang.Object r5 = r5.get()
            androidx.appcompat.app.q r5 = (androidx.appcompat.app.q) r5
            if (r5 == 0) goto L55
            androidx.appcompat.app.f0 r5 = (androidx.appcompat.app.f0) r5
            android.content.Context r5 = r5.f238k
            if (r5 == 0) goto L55
            java.lang.Object r2 = r5.getSystemService(r4)
            goto L75
        L74:
            r2 = 0
        L75:
            if (r2 == 0) goto L8b
            android.os.LocaleList r2 = androidx.appcompat.app.p.a(r2)
            e0.f r5 = new e0.f
            e0.h r6 = new e0.h
            r6.<init>(r2)
            r5.<init>(r6)
            goto L8d
        L86:
            e0.f r5 = androidx.appcompat.app.q.f314c
            if (r5 == 0) goto L8b
            goto L8d
        L8b:
            e0.f r5 = e0.f.f4426b
        L8d:
            e0.g r2 = r5.f4427a
            e0.h r2 = (e0.h) r2
            android.os.LocaleList r2 = r2.f4428a
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto Laa
            java.lang.String r2 = com.google.common.collect.c.H1(r1)
            java.lang.Object r4 = r1.getSystemService(r4)
            if (r4 == 0) goto Laa
            android.os.LocaleList r2 = androidx.appcompat.app.o.a(r2)
            androidx.appcompat.app.p.b(r4, r2)
        Laa:
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            r1.setComponentEnabledSetting(r0, r3, r3)
        Lb1:
            androidx.appcompat.app.q.f317f = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.n.run():void");
    }
}
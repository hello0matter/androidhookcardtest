package androidx.appcompat.app;

/* loaded from: classes.dex */
public final class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f325a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f0 f326b;

    public /* synthetic */ r(f0 f0Var, int i4) {
        this.f325a = i4;
        this.f326b = f0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
        if (i0.j0.c(r1) != false) goto L12;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r6 = this;
            r0 = 1
            int r1 = r6.f325a
            r2 = 0
            androidx.appcompat.app.f0 r3 = r6.f326b
            switch(r1) {
                case 0: goto L54;
                default: goto L9;
            }
        L9:
            android.widget.PopupWindow r1 = r3.f250w
            androidx.appcompat.widget.ActionBarContextView r4 = r3.f249v
            r5 = 55
            r1.showAtLocation(r4, r5, r2, r2)
            i0.g1 r1 = r3.f252y
            if (r1 == 0) goto L19
            r1.b()
        L19:
            boolean r1 = r3.f253z
            if (r1 == 0) goto L2a
            android.view.ViewGroup r1 = r3.A
            if (r1 == 0) goto L2a
            java.util.WeakHashMap r4 = i0.y0.f4999a
            boolean r1 = i0.j0.c(r1)
            if (r1 == 0) goto L2a
            goto L2b
        L2a:
            r0 = r2
        L2b:
            r1 = 1065353216(0x3f800000, float:1.0)
            if (r0 == 0) goto L49
            androidx.appcompat.widget.ActionBarContextView r0 = r3.f249v
            r4 = 0
            r0.setAlpha(r4)
            androidx.appcompat.widget.ActionBarContextView r0 = r3.f249v
            i0.g1 r0 = i0.y0.a(r0)
            r0.a(r1)
            r3.f252y = r0
            androidx.appcompat.app.t r1 = new androidx.appcompat.app.t
            r1.<init>(r2, r6)
            r0.d(r1)
            goto L53
        L49:
            androidx.appcompat.widget.ActionBarContextView r0 = r3.f249v
            r0.setAlpha(r1)
            androidx.appcompat.widget.ActionBarContextView r0 = r3.f249v
            r0.setVisibility(r2)
        L53:
            return
        L54:
            int r1 = r3.Z
            r0 = r0 & r1
            if (r0 == 0) goto L5c
            r3.v(r2)
        L5c:
            int r0 = r3.Z
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L67
            r0 = 108(0x6c, float:1.51E-43)
            r3.v(r0)
        L67:
            r3.Y = r2
            r3.Z = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.r.run():void");
    }
}
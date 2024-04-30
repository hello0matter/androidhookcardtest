package androidx.viewpager2.widget;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.y0;

/* loaded from: classes.dex */
public final class d extends y0 {

    /* renamed from: a  reason: collision with root package name */
    public j f2460a;

    /* renamed from: b  reason: collision with root package name */
    public final ViewPager2 f2461b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f2462c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayoutManager f2463d;

    /* renamed from: e  reason: collision with root package name */
    public int f2464e;

    /* renamed from: f  reason: collision with root package name */
    public int f2465f;

    /* renamed from: g  reason: collision with root package name */
    public final c f2466g;

    /* renamed from: h  reason: collision with root package name */
    public int f2467h;

    /* renamed from: i  reason: collision with root package name */
    public int f2468i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2469j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2470k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f2471l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f2472m;

    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object, androidx.viewpager2.widget.c] */
    public d(ViewPager2 viewPager2) {
        this.f2461b = viewPager2;
        o oVar = viewPager2.f2442j;
        this.f2462c = oVar;
        this.f2463d = (LinearLayoutManager) oVar.getLayoutManager();
        this.f2466g = new Object();
        d();
    }

    @Override // androidx.recyclerview.widget.y0
    public final void a(int i4, RecyclerView recyclerView) {
        boolean z4;
        j jVar;
        j jVar2;
        int i5 = this.f2464e;
        boolean z5 = true;
        if ((i5 != 1 || this.f2465f != 1) && i4 == 1) {
            this.f2472m = false;
            this.f2464e = 1;
            int i6 = this.f2468i;
            if (i6 != -1) {
                this.f2467h = i6;
                this.f2468i = -1;
            } else if (this.f2467h == -1) {
                this.f2467h = this.f2463d.J0();
            }
            c(1);
            return;
        }
        if (i5 != 1 && i5 != 4) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z4 && i4 == 2) {
            if (this.f2470k) {
                c(2);
                this.f2469j = true;
                return;
            }
            return;
        }
        if (i5 != 1 && i5 != 4) {
            z5 = false;
        }
        c cVar = this.f2466g;
        if (z5 && i4 == 0) {
            e();
            if (!this.f2470k) {
                int i7 = cVar.f2457a;
                if (i7 != -1 && (jVar2 = this.f2460a) != null) {
                    jVar2.b(i7, 0.0f, 0);
                }
            } else if (cVar.f2459c == 0) {
                int i8 = this.f2467h;
                int i9 = cVar.f2457a;
                if (i8 != i9 && (jVar = this.f2460a) != null) {
                    jVar.c(i9);
                }
            }
            c(0);
            d();
        }
        if (this.f2464e == 2 && i4 == 0 && this.f2471l) {
            e();
            if (cVar.f2459c == 0) {
                int i10 = this.f2468i;
                int i11 = cVar.f2457a;
                if (i10 != i11) {
                    if (i11 == -1) {
                        i11 = 0;
                    }
                    j jVar3 = this.f2460a;
                    if (jVar3 != null) {
                        jVar3.c(i11);
                    }
                }
                c(0);
                d();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
        if (r7 == r8) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003a, code lost:
        if (r8 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
        r8.c(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004b, code lost:
        if (r8 != null) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0038  */
    @Override // androidx.recyclerview.widget.y0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(androidx.recyclerview.widget.RecyclerView r6, int r7, int r8) {
        /*
            r5 = this;
            r6 = 1
            r5.f2470k = r6
            r5.e()
            boolean r0 = r5.f2469j
            androidx.viewpager2.widget.c r1 = r5.f2466g
            r2 = -1
            r3 = 0
            if (r0 == 0) goto L40
            r5.f2469j = r3
            if (r8 > 0) goto L28
            if (r8 != 0) goto L30
            if (r7 >= 0) goto L18
            r7 = r6
            goto L19
        L18:
            r7 = r3
        L19:
            androidx.viewpager2.widget.ViewPager2 r8 = r5.f2461b
            androidx.viewpager2.widget.i r8 = r8.f2439g
            int r8 = r8.A()
            if (r8 != r6) goto L25
            r8 = r6
            goto L26
        L25:
            r8 = r3
        L26:
            if (r7 != r8) goto L30
        L28:
            int r7 = r1.f2459c
            if (r7 == 0) goto L30
            int r7 = r1.f2457a
            int r7 = r7 + r6
            goto L32
        L30:
            int r7 = r1.f2457a
        L32:
            r5.f2468i = r7
            int r8 = r5.f2467h
            if (r8 == r7) goto L4e
            androidx.viewpager2.widget.j r8 = r5.f2460a
            if (r8 == 0) goto L4e
        L3c:
            r8.c(r7)
            goto L4e
        L40:
            int r7 = r5.f2464e
            if (r7 != 0) goto L4e
            int r7 = r1.f2457a
            if (r7 != r2) goto L49
            r7 = r3
        L49:
            androidx.viewpager2.widget.j r8 = r5.f2460a
            if (r8 == 0) goto L4e
            goto L3c
        L4e:
            int r7 = r1.f2457a
            if (r7 != r2) goto L53
            r7 = r3
        L53:
            float r8 = r1.f2458b
            int r0 = r1.f2459c
            androidx.viewpager2.widget.j r4 = r5.f2460a
            if (r4 == 0) goto L5e
            r4.b(r7, r8, r0)
        L5e:
            int r7 = r1.f2457a
            int r8 = r5.f2468i
            if (r7 == r8) goto L66
            if (r8 != r2) goto L74
        L66:
            int r7 = r1.f2459c
            if (r7 != 0) goto L74
            int r7 = r5.f2465f
            if (r7 == r6) goto L74
            r5.c(r3)
            r5.d()
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.d.b(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    public final void c(int i4) {
        if ((this.f2464e == 3 && this.f2465f == 0) || this.f2465f == i4) {
            return;
        }
        this.f2465f = i4;
        j jVar = this.f2460a;
        if (jVar != null) {
            jVar.a(i4);
        }
    }

    public final void d() {
        this.f2464e = 0;
        this.f2465f = 0;
        c cVar = this.f2466g;
        cVar.f2457a = -1;
        cVar.f2458b = 0.0f;
        cVar.f2459c = 0;
        this.f2467h = -1;
        this.f2468i = -1;
        this.f2469j = false;
        this.f2470k = false;
        this.f2472m = false;
        this.f2471l = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x012f, code lost:
        if (r7[r4 - 1][1] >= r5) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0136, code lost:
        if (r0.v() <= 1) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0138, code lost:
        r1 = r0.v();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x013c, code lost:
        if (r3 >= r1) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0146, code lost:
        if (androidx.viewpager2.widget.a.a(r0.u(r3)) != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0148, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0152, code lost:
        throw new java.lang.IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0153, code lost:
        r1 = java.util.Locale.US;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0162, code lost:
        throw new java.lang.IllegalStateException(androidx.activity.j.b("Page can only be offset by a positive amount, not by ", r2.f2459c));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e() {
        /*
            Method dump skipped, instructions count: 365
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.d.e():void");
    }
}
package r1;

import android.view.View;
import android.view.ViewParent;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.common.collect.c;

/* loaded from: classes.dex */
public final class a extends c {

    /* renamed from: q  reason: collision with root package name */
    public int f6455q;

    /* renamed from: r  reason: collision with root package name */
    public int f6456r = -1;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f6457s;

    public a(SwipeDismissBehavior swipeDismissBehavior) {
        this.f6457s = swipeDismissBehavior;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
        r0 = r3.f6455q;
        r4 = r4.getWidth() + r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
        if (r0 != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r0 != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
        r0 = r3.f6455q - r4.getWidth();
        r4 = r3.f6455q;
     */
    @Override // com.google.common.collect.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int M(android.view.View r4, int r5) {
        /*
            r3 = this;
            java.util.WeakHashMap r0 = i0.y0.f4999a
            int r0 = i0.h0.d(r4)
            r1 = 1
            if (r0 != r1) goto Lb
            r0 = r1
            goto Lc
        Lb:
            r0 = 0
        Lc:
            com.google.android.material.behavior.SwipeDismissBehavior r2 = r3.f6457s
            int r2 = r2.f3012d
            if (r2 != 0) goto L26
            if (r0 == 0) goto L1e
        L14:
            int r0 = r3.f6455q
            int r4 = r4.getWidth()
            int r0 = r0 - r4
            int r4 = r3.f6455q
            goto L39
        L1e:
            int r0 = r3.f6455q
            int r4 = r4.getWidth()
            int r4 = r4 + r0
            goto L39
        L26:
            if (r2 != r1) goto L2b
            if (r0 == 0) goto L14
            goto L1e
        L2b:
            int r0 = r3.f6455q
            int r1 = r4.getWidth()
            int r0 = r0 - r1
            int r1 = r3.f6455q
            int r4 = r4.getWidth()
            int r4 = r4 + r1
        L39:
            int r5 = java.lang.Math.max(r0, r5)
            int r4 = java.lang.Math.min(r5, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: r1.a.M(android.view.View, int):int");
    }

    @Override // com.google.common.collect.c
    public final int N(View view, int i4) {
        return view.getTop();
    }

    @Override // com.google.common.collect.c
    public final int R0(View view) {
        return view.getWidth();
    }

    @Override // com.google.common.collect.c
    public final boolean c2(int i4, View view) {
        int i5 = this.f6456r;
        if ((i5 == -1 || i5 == i4) && this.f6457s.w(view)) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.c
    public final void t1(int i4, View view) {
        this.f6456r = i4;
        this.f6455q = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            SwipeDismissBehavior swipeDismissBehavior = this.f6457s;
            swipeDismissBehavior.f3011c = true;
            parent.requestDisallowInterceptTouchEvent(true);
            swipeDismissBehavior.f3011c = false;
        }
    }

    @Override // com.google.common.collect.c
    public final void u1(int i4) {
        this.f6457s.getClass();
    }

    @Override // com.google.common.collect.c
    public final void v1(View view, int i4, int i5) {
        SwipeDismissBehavior swipeDismissBehavior = this.f6457s;
        float width = view.getWidth() * swipeDismissBehavior.f3014f;
        float width2 = view.getWidth() * swipeDismissBehavior.f3015g;
        float abs = Math.abs(i4 - this.f6455q);
        if (abs <= width) {
            view.setAlpha(1.0f);
        } else if (abs >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((abs - width) / (width2 - width))), 1.0f));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
        if (java.lang.Math.abs(r9.getLeft() - r8.f6455q) >= java.lang.Math.round(r9.getWidth() * r3.f3013e)) goto L25;
     */
    @Override // com.google.common.collect.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void w1(android.view.View r9, float r10, float r11) {
        /*
            r8 = this;
            r11 = -1
            r8.f6456r = r11
            int r11 = r9.getWidth()
            r0 = 0
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            r2 = 1
            com.google.android.material.behavior.SwipeDismissBehavior r3 = r8.f6457s
            r4 = 0
            if (r1 == 0) goto L39
            java.util.WeakHashMap r5 = i0.y0.f4999a
            int r5 = i0.h0.d(r9)
            if (r5 != r2) goto L1a
            r5 = r2
            goto L1b
        L1a:
            r5 = r4
        L1b:
            int r6 = r3.f3012d
            r7 = 2
            if (r6 != r7) goto L21
            goto L52
        L21:
            if (r6 != 0) goto L2d
            if (r5 == 0) goto L2a
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L66
            goto L52
        L2a:
            if (r1 <= 0) goto L66
            goto L52
        L2d:
            if (r6 != r2) goto L66
            if (r5 == 0) goto L34
            if (r1 <= 0) goto L66
            goto L52
        L34:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L66
            goto L52
        L39:
            int r1 = r9.getLeft()
            int r5 = r8.f6455q
            int r1 = r1 - r5
            int r5 = r9.getWidth()
            float r5 = (float) r5
            float r6 = r3.f3013e
            float r5 = r5 * r6
            int r5 = java.lang.Math.round(r5)
            int r1 = java.lang.Math.abs(r1)
            if (r1 < r5) goto L66
        L52:
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 < 0) goto L61
            int r10 = r9.getLeft()
            int r0 = r8.f6455q
            if (r10 >= r0) goto L5f
            goto L61
        L5f:
            int r0 = r0 + r11
            goto L69
        L61:
            int r10 = r8.f6455q
            int r0 = r10 - r11
            goto L69
        L66:
            int r0 = r8.f6455q
            r2 = r4
        L69:
            n0.e r10 = r3.f3009a
            int r11 = r9.getTop()
            boolean r10 = r10.q(r0, r11)
            if (r10 == 0) goto L7f
            r1.b r10 = new r1.b
            r10.<init>(r3, r9, r2)
            java.util.WeakHashMap r11 = i0.y0.f4999a
            i0.g0.m(r9, r10)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r1.a.w1(android.view.View, float, float):void");
    }
}
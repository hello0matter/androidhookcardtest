package x;

import android.content.res.Configuration;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.m0;

/* loaded from: classes.dex */
public final class q implements m0 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f7090a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f7091b;

    public q(BottomSheetBehavior bottomSheetBehavior, boolean z4) {
        this.f7091b = bottomSheetBehavior;
        this.f7090a = z4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x007c, code lost:
        if (r7 != false) goto L31;
     */
    @Override // com.google.android.material.internal.m0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final i0.g2 s(android.view.View r11, i0.g2 r12, androidx.recyclerview.widget.o0 r13) {
        /*
            r10 = this;
            i0.d2 r0 = r12.f4931a
            r1 = 7
            b0.c r1 = r0.f(r1)
            r2 = 32
            b0.c r0 = r0.f(r2)
            java.lang.Object r2 = r10.f7091b
            com.google.android.material.bottomsheet.BottomSheetBehavior r2 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r2
            int r3 = r1.f2491b
            r2.f3094w = r3
            boolean r3 = com.google.android.material.internal.n0.f(r11)
            int r4 = r11.getPaddingBottom()
            int r5 = r11.getPaddingLeft()
            int r6 = r11.getPaddingRight()
            boolean r7 = r2.f3086o
            if (r7 == 0) goto L32
            int r4 = r12.a()
            r2.f3093v = r4
            int r7 = r13.f2200d
            int r4 = r4 + r7
        L32:
            boolean r7 = r2.f3087p
            int r8 = r1.f2490a
            if (r7 == 0) goto L40
            if (r3 == 0) goto L3d
            int r5 = r13.f2199c
            goto L3f
        L3d:
            int r5 = r13.f2197a
        L3f:
            int r5 = r5 + r8
        L40:
            boolean r7 = r2.f3088q
            int r9 = r1.f2492c
            if (r7 == 0) goto L4f
            if (r3 == 0) goto L4b
            int r13 = r13.f2197a
            goto L4d
        L4b:
            int r13 = r13.f2199c
        L4d:
            int r6 = r13 + r9
        L4f:
            android.view.ViewGroup$LayoutParams r13 = r11.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r13 = (android.view.ViewGroup.MarginLayoutParams) r13
            boolean r3 = r2.f3090s
            r7 = 1
            if (r3 == 0) goto L62
            int r3 = r13.leftMargin
            if (r3 == r8) goto L62
            r13.leftMargin = r8
            r3 = r7
            goto L63
        L62:
            r3 = 0
        L63:
            boolean r8 = r2.f3091t
            if (r8 == 0) goto L6e
            int r8 = r13.rightMargin
            if (r8 == r9) goto L6e
            r13.rightMargin = r9
            goto L6f
        L6e:
            r7 = r3
        L6f:
            boolean r3 = r2.f3092u
            if (r3 == 0) goto L7c
            int r3 = r13.topMargin
            int r1 = r1.f2491b
            if (r3 == r1) goto L7c
            r13.topMargin = r1
            goto L7e
        L7c:
            if (r7 == 0) goto L81
        L7e:
            r11.setLayoutParams(r13)
        L81:
            int r13 = r11.getPaddingTop()
            r11.setPadding(r5, r13, r6, r4)
            boolean r11 = r10.f7090a
            if (r11 == 0) goto L90
            int r13 = r0.f2493d
            r2.f3084m = r13
        L90:
            boolean r13 = r2.f3086o
            if (r13 != 0) goto L96
            if (r11 == 0) goto L99
        L96:
            r2.Q()
        L99:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: x.q.s(android.view.View, i0.g2, androidx.recyclerview.widget.o0):i0.g2");
    }

    public /* synthetic */ q(boolean z4) {
        this.f7090a = z4;
        this.f7091b = null;
    }

    public /* synthetic */ q(boolean z4, Configuration configuration) {
        this.f7090a = z4;
        this.f7091b = configuration;
    }
}
package t1;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class a extends com.google.common.collect.c {

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f6685q;

    public a(BottomSheetBehavior bottomSheetBehavior) {
        this.f6685q = bottomSheetBehavior;
    }

    @Override // com.google.common.collect.c
    public final int M(View view, int i4) {
        return view.getLeft();
    }

    @Override // com.google.common.collect.c
    public final int N(View view, int i4) {
        return com.google.common.collect.c.L(i4, this.f6685q.D(), S0());
    }

    @Override // com.google.common.collect.c
    public final int S0() {
        BottomSheetBehavior bottomSheetBehavior = this.f6685q;
        if (bottomSheetBehavior.I) {
            return bottomSheetBehavior.T;
        }
        return bottomSheetBehavior.G;
    }

    @Override // com.google.common.collect.c
    public final boolean c2(int i4, View view) {
        View view2;
        BottomSheetBehavior bottomSheetBehavior = this.f6685q;
        int i5 = bottomSheetBehavior.L;
        if (i5 == 1 || bottomSheetBehavior.f3071c0) {
            return false;
        }
        if (i5 == 3 && bottomSheetBehavior.f3067a0 == i4) {
            WeakReference weakReference = bottomSheetBehavior.W;
            if (weakReference != null) {
                view2 = (View) weakReference.get();
            } else {
                view2 = null;
            }
            if (view2 != null && view2.canScrollVertically(-1)) {
                return false;
            }
        }
        System.currentTimeMillis();
        WeakReference weakReference2 = bottomSheetBehavior.U;
        if (weakReference2 == null || weakReference2.get() != view) {
            return false;
        }
        return true;
    }

    @Override // com.google.common.collect.c
    public final void u1(int i4) {
        if (i4 == 1) {
            BottomSheetBehavior bottomSheetBehavior = this.f6685q;
            if (bottomSheetBehavior.K) {
                bottomSheetBehavior.J(1);
            }
        }
    }

    @Override // com.google.common.collect.c
    public final void v1(View view, int i4, int i5) {
        this.f6685q.A(i5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0069, code lost:
        if (java.lang.Math.abs(r6.getTop() - r4.D()) < java.lang.Math.abs(r6.getTop() - r4.E)) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0097, code lost:
        if (java.lang.Math.abs(r7 - r4.E) < java.lang.Math.abs(r7 - r4.G)) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b1, code lost:
        if (java.lang.Math.abs(r7 - r4.D) < java.lang.Math.abs(r7 - r4.G)) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c1, code lost:
        if (r7 < java.lang.Math.abs(r7 - r4.G)) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d2, code lost:
        if (java.lang.Math.abs(r7 - r8) < java.lang.Math.abs(r7 - r4.G)) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (r7 > r4.E) goto L6;
     */
    @Override // com.google.common.collect.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void w1(android.view.View r6, float r7, float r8) {
        /*
            r5 = this;
            r0 = 0
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r2 = 6
            r3 = 3
            com.google.android.material.bottomsheet.BottomSheetBehavior r4 = r5.f6685q
            if (r1 >= 0) goto L1d
            boolean r7 = r4.f3068b
            if (r7 == 0) goto L10
        Ld:
            r2 = r3
            goto Ld4
        L10:
            int r7 = r6.getTop()
            java.lang.System.currentTimeMillis()
            int r8 = r4.E
            if (r7 <= r8) goto Ld
            goto Ld4
        L1d:
            boolean r1 = r4.I
            if (r1 == 0) goto L6c
            boolean r1 = r4.K(r6, r8)
            if (r1 == 0) goto L6c
            float r7 = java.lang.Math.abs(r7)
            float r0 = java.lang.Math.abs(r8)
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 >= 0) goto L3a
            int r7 = r4.f3072d
            float r7 = (float) r7
            int r7 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r7 > 0) goto L49
        L3a:
            int r7 = r6.getTop()
            int r8 = r4.T
            int r0 = r4.D()
            int r0 = r0 + r8
            int r0 = r0 / 2
            if (r7 <= r0) goto L4c
        L49:
            r2 = 5
            goto Ld4
        L4c:
            boolean r7 = r4.f3068b
            if (r7 == 0) goto L51
            goto Ld
        L51:
            int r7 = r6.getTop()
            int r8 = r4.D()
            int r7 = r7 - r8
            int r7 = java.lang.Math.abs(r7)
            int r8 = r6.getTop()
            int r0 = r4.E
            int r8 = r8 - r0
            int r8 = java.lang.Math.abs(r8)
            if (r7 >= r8) goto Ld4
            goto Ld
        L6c:
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r1 = 4
            if (r0 == 0) goto L9a
            float r7 = java.lang.Math.abs(r7)
            float r8 = java.lang.Math.abs(r8)
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 <= 0) goto L7e
            goto L9a
        L7e:
            boolean r7 = r4.f3068b
            if (r7 == 0) goto L84
        L82:
            r2 = r1
            goto Ld4
        L84:
            int r7 = r6.getTop()
            int r8 = r4.E
            int r8 = r7 - r8
            int r8 = java.lang.Math.abs(r8)
            int r0 = r4.G
            int r7 = r7 - r0
            int r7 = java.lang.Math.abs(r7)
            if (r8 >= r7) goto L82
            goto Ld4
        L9a:
            int r7 = r6.getTop()
            boolean r8 = r4.f3068b
            if (r8 == 0) goto Lb5
            int r8 = r4.D
            int r8 = r7 - r8
            int r8 = java.lang.Math.abs(r8)
            int r0 = r4.G
            int r7 = r7 - r0
            int r7 = java.lang.Math.abs(r7)
            if (r8 >= r7) goto L82
            goto Ld
        Lb5:
            int r8 = r4.E
            if (r7 >= r8) goto Lc5
            int r8 = r4.G
            int r8 = r7 - r8
            int r8 = java.lang.Math.abs(r8)
            if (r7 >= r8) goto Ld4
            goto Ld
        Lc5:
            int r8 = r7 - r8
            int r8 = java.lang.Math.abs(r8)
            int r0 = r4.G
            int r7 = r7 - r0
            int r7 = java.lang.Math.abs(r7)
            if (r8 >= r7) goto L82
        Ld4:
            r4.getClass()
            r7 = 1
            r4.L(r6, r2, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t1.a.w1(android.view.View, float, float):void");
    }
}
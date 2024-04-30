package m2;

import android.view.View;
import android.view.ViewGroup;
import androidx.activity.j;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class d extends com.google.common.collect.c {

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ SideSheetBehavior f5459q;

    public d(SideSheetBehavior sideSheetBehavior) {
        this.f5459q = sideSheetBehavior;
    }

    @Override // com.google.common.collect.c
    public final int M(View view, int i4) {
        int i5;
        int i6;
        SideSheetBehavior sideSheetBehavior = this.f5459q;
        a aVar = sideSheetBehavior.f3810a;
        switch (aVar.f5451q) {
            case 0:
                i5 = -aVar.f5452r.f3821l;
                break;
            default:
                i5 = aVar.i2();
                break;
        }
        a aVar2 = sideSheetBehavior.f3810a;
        int i7 = aVar2.f5451q;
        SideSheetBehavior sideSheetBehavior2 = aVar2.f5452r;
        switch (i7) {
            case 0:
                i6 = sideSheetBehavior2.f3824o;
                break;
            default:
                i6 = sideSheetBehavior2.f3822m;
                break;
        }
        return com.google.common.collect.c.L(i4, i5, i6);
    }

    @Override // com.google.common.collect.c
    public final int N(View view, int i4) {
        return view.getTop();
    }

    @Override // com.google.common.collect.c
    public final int R0(View view) {
        SideSheetBehavior sideSheetBehavior = this.f5459q;
        return sideSheetBehavior.f3821l + sideSheetBehavior.f3824o;
    }

    @Override // com.google.common.collect.c
    public final boolean c2(int i4, View view) {
        WeakReference weakReference;
        SideSheetBehavior sideSheetBehavior = this.f5459q;
        if (sideSheetBehavior.f3817h == 1 || (weakReference = sideSheetBehavior.f3825p) == null || weakReference.get() != view) {
            return false;
        }
        return true;
    }

    @Override // com.google.common.collect.c
    public final void u1(int i4) {
        if (i4 == 1) {
            SideSheetBehavior sideSheetBehavior = this.f5459q;
            if (sideSheetBehavior.f3816g) {
                sideSheetBehavior.x(1);
            }
        }
    }

    @Override // com.google.common.collect.c
    public final void v1(View view, int i4, int i5) {
        View view2;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        SideSheetBehavior sideSheetBehavior = this.f5459q;
        WeakReference weakReference = sideSheetBehavior.f3826q;
        if (weakReference != null) {
            view2 = (View) weakReference.get();
        } else {
            view2 = null;
        }
        if (view2 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) != null) {
            a aVar = sideSheetBehavior.f3810a;
            int left = view.getLeft();
            int right = view.getRight();
            int i6 = aVar.f5451q;
            SideSheetBehavior sideSheetBehavior2 = aVar.f5452r;
            switch (i6) {
                case 0:
                    if (left <= sideSheetBehavior2.f3822m) {
                        marginLayoutParams.leftMargin = right;
                        break;
                    }
                    break;
                default:
                    int i7 = sideSheetBehavior2.f3822m;
                    if (left <= i7) {
                        marginLayoutParams.rightMargin = i7 - left;
                        break;
                    }
                    break;
            }
            view2.setLayoutParams(marginLayoutParams);
        }
        LinkedHashSet linkedHashSet = sideSheetBehavior.f3831v;
        if (!linkedHashSet.isEmpty()) {
            sideSheetBehavior.f3810a.h2(i4);
            Iterator it = linkedHashSet.iterator();
            if (it.hasNext()) {
                j.f(it.next());
                throw null;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
        if (r0.f3810a.l2(r5) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0054, code lost:
        if (java.lang.Math.abs(r6 - r0.f3810a.i2()) < java.lang.Math.abs(r6 - r0.f3810a.j2())) goto L16;
     */
    @Override // com.google.common.collect.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void w1(android.view.View r5, float r6, float r7) {
        /*
            r4 = this;
            com.google.android.material.sidesheet.SideSheetBehavior r0 = r4.f5459q
            m2.a r1 = r0.f3810a
            boolean r1 = r1.k2(r6)
            r2 = 3
            if (r1 == 0) goto Lc
            goto L56
        Lc:
            m2.a r1 = r0.f3810a
            boolean r1 = r1.n2(r5, r6)
            r3 = 5
            if (r1 == 0) goto L27
            m2.a r1 = r0.f3810a
            boolean r6 = r1.m2(r6, r7)
            if (r6 != 0) goto L25
            m2.a r6 = r0.f3810a
            boolean r6 = r6.l2(r5)
            if (r6 == 0) goto L56
        L25:
            r2 = r3
            goto L56
        L27:
            r1 = 0
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 == 0) goto L39
            float r6 = java.lang.Math.abs(r6)
            float r7 = java.lang.Math.abs(r7)
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L39
            goto L25
        L39:
            int r6 = r5.getLeft()
            m2.a r7 = r0.f3810a
            int r7 = r7.i2()
            int r7 = r6 - r7
            int r7 = java.lang.Math.abs(r7)
            m2.a r1 = r0.f3810a
            int r1 = r1.j2()
            int r6 = r6 - r1
            int r6 = java.lang.Math.abs(r6)
            if (r7 >= r6) goto L25
        L56:
            r6 = 1
            r0.z(r5, r2, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.d.w1(android.view.View, float, float):void");
    }
}
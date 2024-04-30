package v;

import android.view.View;
import i0.m0;
import i0.y0;
import java.util.Comparator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class c implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6939a;

    public /* synthetic */ c(int i4) {
        this.f6939a = i4;
    }

    public final int a(View view, View view2) {
        switch (this.f6939a) {
            case 0:
                WeakHashMap weakHashMap = y0.f4999a;
                float m4 = m0.m(view);
                float m5 = m0.m(view2);
                if (m4 > m5) {
                    return -1;
                }
                if (m4 < m5) {
                    return 1;
                }
                return 0;
            default:
                return view.getTop() - view2.getTop();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
        return -1;
     */
    @Override // java.util.Comparator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int compare(java.lang.Object r7, java.lang.Object r8) {
        /*
            r6 = this;
            int r0 = r6.f6939a
            switch(r0) {
                case 0: goto L64;
                case 1: goto L5a;
                case 2: goto L51;
                case 3: goto L48;
                default: goto L5;
            }
        L5:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r0 = "a"
            com.google.common.collect.c.F(r7, r0)
            java.lang.String r0 = "b"
            com.google.common.collect.c.F(r8, r0)
            int r0 = r7.length()
            int r1 = r8.length()
            int r0 = java.lang.Math.min(r0, r1)
            r1 = 4
        L20:
            r2 = 1
            r3 = -1
            if (r1 >= r0) goto L39
            char r4 = r7.charAt(r1)
            char r5 = r8.charAt(r1)
            if (r4 == r5) goto L36
            int r7 = com.google.common.collect.c.Q(r4, r5)
            if (r7 >= 0) goto L47
        L34:
            r2 = r3
            goto L47
        L36:
            int r1 = r1 + 1
            goto L20
        L39:
            int r7 = r7.length()
            int r8 = r8.length()
            if (r7 == r8) goto L46
            if (r7 >= r8) goto L47
            goto L34
        L46:
            r2 = 0
        L47:
            return r2
        L48:
            java.lang.Comparable r7 = (java.lang.Comparable) r7
            java.lang.Comparable r8 = (java.lang.Comparable) r8
            int r7 = r7.compareTo(r8)
            return r7
        L51:
            android.view.View r7 = (android.view.View) r7
            android.view.View r8 = (android.view.View) r8
            int r7 = r6.a(r7, r8)
            return r7
        L5a:
            f1.e r7 = (f1.e) r7
            f1.e r8 = (f1.e) r8
            int r7 = r7.f4547a
            int r8 = r8.f4547a
            int r7 = r7 - r8
            return r7
        L64:
            android.view.View r7 = (android.view.View) r7
            android.view.View r8 = (android.view.View) r8
            int r7 = r6.a(r7, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: v.c.compare(java.lang.Object, java.lang.Object):int");
    }
}
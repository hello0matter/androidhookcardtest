package androidx.core.widget;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ScrollView;
import androidx.drawerlayout.widget.DrawerLayout;

/* loaded from: classes.dex */
public final class j extends i0.c {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f1452d;

    public /* synthetic */ j(int i4) {
        this.f1452d = i4;
    }

    @Override // i0.c
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        boolean z4;
        switch (this.f1452d) {
            case 0:
                super.c(view, accessibilityEvent);
                NestedScrollView nestedScrollView = (NestedScrollView) view;
                accessibilityEvent.setClassName(ScrollView.class.getName());
                if (nestedScrollView.getScrollRange() > 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                accessibilityEvent.setScrollable(z4);
                accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
                accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
                j0.l.c(accessibilityEvent, nestedScrollView.getScrollX());
                j0.l.d(accessibilityEvent, nestedScrollView.getScrollRange());
                return;
            default:
                super.c(view, accessibilityEvent);
                return;
        }
    }

    @Override // i0.c
    public final void d(View view, j0.h hVar) {
        int scrollRange;
        int i4 = this.f1452d;
        View.AccessibilityDelegate accessibilityDelegate = this.f4912a;
        AccessibilityNodeInfo accessibilityNodeInfo = hVar.f5093a;
        switch (i4) {
            case 0:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                NestedScrollView nestedScrollView = (NestedScrollView) view;
                hVar.g(ScrollView.class.getName());
                if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                    hVar.j(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        hVar.b(j0.g.f5081i);
                        hVar.b(j0.g.f5085m);
                    }
                    if (nestedScrollView.getScrollY() < scrollRange) {
                        hVar.b(j0.g.f5080h);
                        hVar.b(j0.g.f5086n);
                        return;
                    }
                    return;
                }
                return;
            default:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                if (!DrawerLayout.i(view)) {
                    hVar.f5094b = -1;
                    accessibilityNodeInfo.setParent(null);
                    return;
                }
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
        if (r6 != 16908346) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
        if (r6 != r5.getScrollY()) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0068, code lost:
        r5.t(0 - r5.getScrollX(), r6 - r5.getScrollY(), true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0091, code lost:
        if (r6 != r5.getScrollY()) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
        return true;
     */
    @Override // i0.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean g(android.view.View r5, int r6, android.os.Bundle r7) {
        /*
            r4 = this;
            int r0 = r4.f1452d
            switch(r0) {
                case 0: goto La;
                default: goto L5;
            }
        L5:
            boolean r5 = super.g(r5, r6, r7)
            return r5
        La:
            boolean r7 = super.g(r5, r6, r7)
            r0 = 1
            if (r7 == 0) goto L13
            goto L94
        L13:
            androidx.core.widget.NestedScrollView r5 = (androidx.core.widget.NestedScrollView) r5
            boolean r7 = r5.isEnabled()
            r1 = 0
            if (r7 != 0) goto L1f
        L1c:
            r0 = r1
            goto L94
        L1f:
            int r7 = r5.getHeight()
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            android.graphics.Matrix r3 = r5.getMatrix()
            boolean r3 = r3.isIdentity()
            if (r3 == 0) goto L3c
            boolean r3 = r5.getGlobalVisibleRect(r2)
            if (r3 == 0) goto L3c
            int r7 = r2.height()
        L3c:
            r2 = 4096(0x1000, float:5.74E-42)
            if (r6 == r2) goto L76
            r2 = 8192(0x2000, float:1.148E-41)
            if (r6 == r2) goto L4f
            r2 = 16908344(0x1020038, float:2.3877386E-38)
            if (r6 == r2) goto L4f
            r2 = 16908346(0x102003a, float:2.3877392E-38)
            if (r6 == r2) goto L76
            goto L1c
        L4f:
            int r6 = r5.getPaddingBottom()
            int r7 = r7 - r6
            int r6 = r5.getPaddingTop()
            int r7 = r7 - r6
            int r6 = r5.getScrollY()
            int r6 = r6 - r7
            int r6 = java.lang.Math.max(r6, r1)
            int r7 = r5.getScrollY()
            if (r6 == r7) goto L1c
        L68:
            int r7 = r5.getScrollX()
            int r1 = r1 - r7
            int r7 = r5.getScrollY()
            int r6 = r6 - r7
            r5.t(r1, r6, r0)
            goto L94
        L76:
            int r6 = r5.getPaddingBottom()
            int r7 = r7 - r6
            int r6 = r5.getPaddingTop()
            int r7 = r7 - r6
            int r6 = r5.getScrollY()
            int r6 = r6 + r7
            int r7 = r5.getScrollRange()
            int r6 = java.lang.Math.min(r6, r7)
            int r7 = r5.getScrollY()
            if (r6 == r7) goto L1c
            goto L68
        L94:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.j.g(android.view.View, int, android.os.Bundle):boolean");
    }
}
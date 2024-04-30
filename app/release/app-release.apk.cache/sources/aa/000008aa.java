package n0;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.i0;
import i0.g0;
import i0.y0;
import j0.h;
import j0.m;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l2.f;

/* loaded from: classes.dex */
public abstract class b extends i0.c {

    /* renamed from: n  reason: collision with root package name */
    public static final Rect f5697n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: o  reason: collision with root package name */
    public static final f f5698o = new f(6, 0);

    /* renamed from: p  reason: collision with root package name */
    public static final f f5699p = new f(7, 0);

    /* renamed from: h  reason: collision with root package name */
    public final AccessibilityManager f5704h;

    /* renamed from: i  reason: collision with root package name */
    public final View f5705i;

    /* renamed from: j  reason: collision with root package name */
    public a f5706j;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f5700d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    public final Rect f5701e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    public final Rect f5702f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    public final int[] f5703g = new int[2];

    /* renamed from: k  reason: collision with root package name */
    public int f5707k = Integer.MIN_VALUE;

    /* renamed from: l  reason: collision with root package name */
    public int f5708l = Integer.MIN_VALUE;

    /* renamed from: m  reason: collision with root package name */
    public int f5709m = Integer.MIN_VALUE;

    public b(View view) {
        if (view != null) {
            this.f5705i = view;
            this.f5704h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            WeakHashMap weakHashMap = y0.f4999a;
            if (g0.c(view) == 0) {
                g0.s(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    @Override // i0.c
    public final i0 b(View view) {
        if (this.f5706j == null) {
            this.f5706j = new a(this);
        }
        return this.f5706j;
    }

    @Override // i0.c
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
    }

    @Override // i0.c
    public final void d(View view, h hVar) {
        this.f4912a.onInitializeAccessibilityNodeInfo(view, hVar.f5093a);
        t(hVar);
    }

    public final boolean j(int i4) {
        if (this.f5708l != i4) {
            return false;
        }
        this.f5708l = Integer.MIN_VALUE;
        v(i4, false);
        x(i4, 8);
        return true;
    }

    public final AccessibilityEvent k(int i4, int i5) {
        View view = this.f5705i;
        if (i4 != -1) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(i5);
            h r4 = r(i4);
            obtain.getText().add(r4.e());
            AccessibilityNodeInfo accessibilityNodeInfo = r4.f5093a;
            obtain.setContentDescription(accessibilityNodeInfo.getContentDescription());
            obtain.setScrollable(accessibilityNodeInfo.isScrollable());
            obtain.setPassword(accessibilityNodeInfo.isPassword());
            obtain.setEnabled(accessibilityNodeInfo.isEnabled());
            obtain.setChecked(accessibilityNodeInfo.isChecked());
            if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
            obtain.setClassName(accessibilityNodeInfo.getClassName());
            m.a(obtain, view, i4);
            obtain.setPackageName(view.getContext().getPackageName());
            return obtain;
        }
        AccessibilityEvent obtain2 = AccessibilityEvent.obtain(i5);
        view.onInitializeAccessibilityEvent(obtain2);
        return obtain2;
    }

    public final h l(int i4) {
        boolean z4;
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
        h hVar = new h(obtain);
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        hVar.g("android.view.View");
        Rect rect = f5697n;
        obtain.setBoundsInParent(rect);
        obtain.setBoundsInScreen(rect);
        hVar.f5094b = -1;
        View view = this.f5705i;
        obtain.setParent(view);
        u(i4, hVar);
        if (hVar.e() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.f5701e;
        hVar.d(rect2);
        if (!rect2.equals(rect)) {
            int actions = obtain.getActions();
            if ((actions & 64) == 0) {
                if ((actions & 128) == 0) {
                    obtain.setPackageName(view.getContext().getPackageName());
                    hVar.f5095c = i4;
                    obtain.setSource(view, i4);
                    if (this.f5707k == i4) {
                        obtain.setAccessibilityFocused(true);
                        hVar.a(128);
                    } else {
                        obtain.setAccessibilityFocused(false);
                        hVar.a(64);
                    }
                    if (this.f5708l == i4) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        hVar.a(2);
                    } else if (obtain.isFocusable()) {
                        hVar.a(1);
                    }
                    obtain.setFocused(z4);
                    int[] iArr = this.f5703g;
                    view.getLocationOnScreen(iArr);
                    Rect rect3 = this.f5700d;
                    obtain.getBoundsInScreen(rect3);
                    if (rect3.equals(rect)) {
                        hVar.d(rect3);
                        if (hVar.f5094b != -1) {
                            h hVar2 = new h(AccessibilityNodeInfo.obtain());
                            int i5 = hVar.f5094b;
                            while (true) {
                                accessibilityNodeInfo = hVar2.f5093a;
                                if (i5 == -1) {
                                    break;
                                }
                                hVar2.f5094b = -1;
                                accessibilityNodeInfo.setParent(view, -1);
                                accessibilityNodeInfo.setBoundsInParent(rect);
                                u(i5, hVar2);
                                hVar2.d(rect2);
                                rect3.offset(rect2.left, rect2.top);
                                i5 = hVar2.f5094b;
                            }
                            accessibilityNodeInfo.recycle();
                        }
                        rect3.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
                    }
                    Rect rect4 = this.f5702f;
                    if (view.getLocalVisibleRect(rect4)) {
                        rect4.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
                        if (rect3.intersect(rect4)) {
                            AccessibilityNodeInfo accessibilityNodeInfo2 = hVar.f5093a;
                            accessibilityNodeInfo2.setBoundsInScreen(rect3);
                            if (!rect3.isEmpty() && view.getWindowVisibility() == 0) {
                                ViewParent parent = view.getParent();
                                while (true) {
                                    if (parent instanceof View) {
                                        View view2 = (View) parent;
                                        if (view2.getAlpha() <= 0.0f || view2.getVisibility() != 0) {
                                            break;
                                        }
                                        parent = view2.getParent();
                                    } else if (parent != null) {
                                        accessibilityNodeInfo2.setVisibleToUser(true);
                                    }
                                }
                            }
                        }
                    }
                    return hVar;
                }
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }

    public final boolean m(MotionEvent motionEvent) {
        int i4;
        AccessibilityManager accessibilityManager = this.f5704h;
        if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7 && action != 9) {
            if (action != 10 || (i4 = this.f5709m) == Integer.MIN_VALUE) {
                return false;
            }
            if (i4 != Integer.MIN_VALUE) {
                this.f5709m = Integer.MIN_VALUE;
                x(Integer.MIN_VALUE, 128);
                x(i4, 256);
            }
            return true;
        }
        int n4 = n(motionEvent.getX(), motionEvent.getY());
        int i5 = this.f5709m;
        if (i5 != n4) {
            this.f5709m = n4;
            x(n4, 128);
            x(i5, 256);
        }
        if (n4 == Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

    public abstract int n(float f4, float f5);

    public abstract void o(ArrayList arrayList);

    public final void p(int i4) {
        View view;
        ViewParent parent;
        if (i4 != Integer.MIN_VALUE && this.f5704h.isEnabled() && (parent = (view = this.f5705i).getParent()) != null) {
            AccessibilityEvent k4 = k(i4, 2048);
            j0.b.b(k4, 0);
            parent.requestSendAccessibilityEvent(view, k4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean q(int r20, android.graphics.Rect r21) {
        /*
            Method dump skipped, instructions count: 484
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.b.q(int, android.graphics.Rect):boolean");
    }

    public final h r(int i4) {
        if (i4 == -1) {
            View view = this.f5705i;
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(view);
            h hVar = new h(obtain);
            WeakHashMap weakHashMap = y0.f4999a;
            view.onInitializeAccessibilityNodeInfo(obtain);
            ArrayList arrayList = new ArrayList();
            o(arrayList);
            if (obtain.getChildCount() > 0 && arrayList.size() > 0) {
                throw new RuntimeException("Views cannot have both real and virtual children");
            }
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                hVar.f5093a.addChild(view, ((Integer) arrayList.get(i5)).intValue());
            }
            return hVar;
        }
        return l(i4);
    }

    public abstract boolean s(int i4, int i5, Bundle bundle);

    public abstract void u(int i4, h hVar);

    public final boolean w(int i4) {
        int i5;
        View view = this.f5705i;
        if ((!view.isFocused() && !view.requestFocus()) || (i5 = this.f5708l) == i4) {
            return false;
        }
        if (i5 != Integer.MIN_VALUE) {
            j(i5);
        }
        if (i4 == Integer.MIN_VALUE) {
            return false;
        }
        this.f5708l = i4;
        v(i4, true);
        x(i4, 8);
        return true;
    }

    public final void x(int i4, int i5) {
        View view;
        ViewParent parent;
        if (i4 == Integer.MIN_VALUE || !this.f5704h.isEnabled() || (parent = (view = this.f5705i).getParent()) == null) {
            return;
        }
        parent.requestSendAccessibilityEvent(view, k(i4, i5));
    }

    public void t(h hVar) {
    }

    public void v(int i4, boolean z4) {
    }
}
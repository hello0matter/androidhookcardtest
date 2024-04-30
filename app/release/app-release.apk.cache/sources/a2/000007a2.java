package j0;

import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: e  reason: collision with root package name */
    public static final g f5077e = new g(1);

    /* renamed from: f  reason: collision with root package name */
    public static final g f5078f = new g(2);

    /* renamed from: g  reason: collision with root package name */
    public static final g f5079g;

    /* renamed from: h  reason: collision with root package name */
    public static final g f5080h;

    /* renamed from: i  reason: collision with root package name */
    public static final g f5081i;

    /* renamed from: j  reason: collision with root package name */
    public static final g f5082j;

    /* renamed from: k  reason: collision with root package name */
    public static final g f5083k;

    /* renamed from: l  reason: collision with root package name */
    public static final g f5084l;

    /* renamed from: m  reason: collision with root package name */
    public static final g f5085m;

    /* renamed from: n  reason: collision with root package name */
    public static final g f5086n;

    /* renamed from: o  reason: collision with root package name */
    public static final g f5087o;

    /* renamed from: a  reason: collision with root package name */
    public final Object f5088a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5089b;

    /* renamed from: c  reason: collision with root package name */
    public final Class f5090c;

    /* renamed from: d  reason: collision with root package name */
    public final v f5091d;

    static {
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction8;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction9;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction10;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction11;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction12;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction13;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction14;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction15;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction16;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction17;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction18;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction19;
        new g(4);
        new g(8);
        f5079g = new g(16);
        new g(32);
        new g(64);
        new g(128);
        new g(256, o.class);
        new g(512, o.class);
        new g(1024, p.class);
        new g(2048, p.class);
        f5080h = new g(4096);
        f5081i = new g(8192);
        new g(16384);
        new g(32768);
        new g(65536);
        new g(131072, t.class);
        f5082j = new g(262144);
        f5083k = new g(524288);
        f5084l = new g(1048576);
        new g(2097152, u.class);
        int i4 = Build.VERSION.SDK_INT;
        new g(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, 16908342, null, null, null);
        new g(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, 16908343, null, null, r.class);
        f5085m = new g(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, 16908344, null, null, null);
        new g(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, 16908345, null, null, null);
        f5086n = new g(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, 16908346, null, null, null);
        new g(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, 16908347, null, null, null);
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction20 = null;
        if (i4 >= 29) {
            accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
        } else {
            accessibilityAction = null;
        }
        new g(accessibilityAction, 16908358, null, null, null);
        if (i4 >= 29) {
            accessibilityAction19 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
            accessibilityAction2 = accessibilityAction19;
        } else {
            accessibilityAction2 = null;
        }
        new g(accessibilityAction2, 16908359, null, null, null);
        if (i4 >= 29) {
            accessibilityAction3 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
        } else {
            accessibilityAction3 = null;
        }
        new g(accessibilityAction3, 16908360, null, null, null);
        if (i4 >= 29) {
            accessibilityAction18 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
            accessibilityAction4 = accessibilityAction18;
        } else {
            accessibilityAction4 = null;
        }
        new g(accessibilityAction4, 16908361, null, null, null);
        new g(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, 16908348, null, null, null);
        f5087o = new g(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, 16908349, null, null, s.class);
        if (i4 >= 26) {
            accessibilityAction17 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
            accessibilityAction5 = accessibilityAction17;
        } else {
            accessibilityAction5 = null;
        }
        new g(accessibilityAction5, 16908354, null, null, q.class);
        if (i4 >= 28) {
            accessibilityAction6 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
        } else {
            accessibilityAction6 = null;
        }
        new g(accessibilityAction6, 16908356, null, null, null);
        if (i4 >= 28) {
            accessibilityAction16 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
            accessibilityAction7 = accessibilityAction16;
        } else {
            accessibilityAction7 = null;
        }
        new g(accessibilityAction7, 16908357, null, null, null);
        if (i4 >= 30) {
            accessibilityAction8 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
        } else {
            accessibilityAction8 = null;
        }
        new g(accessibilityAction8, 16908362, null, null, null);
        if (i4 >= 30) {
            accessibilityAction15 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
            accessibilityAction9 = accessibilityAction15;
        } else {
            accessibilityAction9 = null;
        }
        new g(accessibilityAction9, 16908372, null, null, null);
        if (i4 >= 32) {
            accessibilityAction10 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START;
        } else {
            accessibilityAction10 = null;
        }
        new g(accessibilityAction10, 16908373, null, null, null);
        if (i4 >= 32) {
            accessibilityAction14 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP;
            accessibilityAction11 = accessibilityAction14;
        } else {
            accessibilityAction11 = null;
        }
        new g(accessibilityAction11, 16908374, null, null, null);
        if (i4 >= 32) {
            accessibilityAction13 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL;
            accessibilityAction12 = accessibilityAction13;
        } else {
            accessibilityAction12 = null;
        }
        new g(accessibilityAction12, 16908375, null, null, null);
        if (i4 >= 33) {
            accessibilityAction20 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
        }
        new g(accessibilityAction20, 16908376, null, null, null);
    }

    public g(int i4) {
        this(null, i4, null, null, null);
    }

    public final int a() {
        return ((AccessibilityNodeInfo.AccessibilityAction) this.f5088a).getId();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof g)) {
            return false;
        }
        Object obj2 = ((g) obj).f5088a;
        Object obj3 = this.f5088a;
        if (obj3 == null) {
            if (obj2 != null) {
                return false;
            }
            return true;
        } else if (!obj3.equals(obj2)) {
            return false;
        } else {
            return true;
        }
    }

    public final int hashCode() {
        Object obj = this.f5088a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public g(int i4, Class cls) {
        this(null, i4, null, null, cls);
    }

    public g(Object obj, int i4, String str, v vVar, Class cls) {
        this.f5089b = i4;
        this.f5091d = vVar;
        this.f5088a = obj == null ? new AccessibilityNodeInfo.AccessibilityAction(i4, str) : obj;
        this.f5090c = cls;
    }
}
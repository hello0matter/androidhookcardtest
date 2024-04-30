package i0;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.example.msphone.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class y0 {

    /* renamed from: a  reason: collision with root package name */
    public static WeakHashMap f4999a;

    /* renamed from: b  reason: collision with root package name */
    public static Field f5000b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f5001c;

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f5002d;

    /* renamed from: e  reason: collision with root package name */
    public static final b0 f5003e;

    /* renamed from: f  reason: collision with root package name */
    public static final d0 f5004f;

    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, i0.b0] */
    static {
        new AtomicInteger(1);
        f4999a = null;
        f5001c = false;
        f5002d = new int[]{R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
        f5003e = new Object();
        f5004f = new d0();
    }

    public static g1 a(View view) {
        if (f4999a == null) {
            f4999a = new WeakHashMap();
        }
        g1 g1Var = (g1) f4999a.get(view);
        if (g1Var == null) {
            g1 g1Var2 = new g1(view);
            f4999a.put(view, g1Var2);
            return g1Var2;
        }
        return g1Var;
    }

    public static g2 b(View view, g2 g2Var) {
        WindowInsets g4 = g2Var.g();
        if (g4 != null) {
            WindowInsets a5 = k0.a(view, g4);
            if (!a5.equals(g4)) {
                return g2.h(view, a5);
            }
        }
        return g2Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [i0.x0, java.lang.Object] */
    public static boolean c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList = x0.f4993d;
        x0 x0Var = (x0) view.getTag(R.id.tag_unhandled_key_event_manager);
        x0 x0Var2 = x0Var;
        if (x0Var == null) {
            ?? obj = new Object();
            obj.f4994a = null;
            obj.f4995b = null;
            obj.f4996c = null;
            view.setTag(R.id.tag_unhandled_key_event_manager, obj);
            x0Var2 = obj;
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap weakHashMap = x0Var2.f4994a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList2 = x0.f4993d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    try {
                        if (x0Var2.f4994a == null) {
                            x0Var2.f4994a = new WeakHashMap();
                        }
                        for (int size = arrayList2.size() - 1; size >= 0; size--) {
                            ArrayList arrayList3 = x0.f4993d;
                            View view2 = (View) ((WeakReference) arrayList3.get(size)).get();
                            if (view2 == null) {
                                arrayList3.remove(size);
                            } else {
                                x0Var2.f4994a.put(view2, Boolean.TRUE);
                                for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                    x0Var2.f4994a.put((View) parent, Boolean.TRUE);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
        }
        View a5 = x0Var2.a(view);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (a5 != null && !KeyEvent.isModifierKey(keyCode)) {
                if (x0Var2.f4995b == null) {
                    x0Var2.f4995b = new SparseArray();
                }
                x0Var2.f4995b.put(keyCode, new WeakReference(a5));
            }
        }
        if (a5 == null) {
            return false;
        }
        return true;
    }

    public static View.AccessibilityDelegate d(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return s0.a(view);
        }
        if (f5001c) {
            return null;
        }
        if (f5000b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f5000b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f5001c = true;
                return null;
            }
        }
        Object obj = f5000b.get(view);
        if (!(obj instanceof View.AccessibilityDelegate)) {
            return null;
        }
        return (View.AccessibilityDelegate) obj;
    }

    public static CharSequence e(View view) {
        Object tag;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = r0.b(view);
        } else {
            tag = view.getTag(R.id.tag_accessibility_pane_title);
            if (!CharSequence.class.isInstance(tag)) {
                tag = null;
            }
        }
        return (CharSequence) tag;
    }

    public static ArrayList f(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            view.setTag(R.id.tag_accessibility_actions, arrayList2);
            return arrayList2;
        }
        return arrayList;
    }

    public static String[] g(View view) {
        if (Build.VERSION.SDK_INT >= 31) {
            return u0.a(view);
        }
        return (String[]) view.getTag(R.id.tag_on_receive_content_mime_types);
    }

    public static n2 h(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return t0.b(view);
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window == null) {
                    return null;
                }
                return new n2(window, view);
            }
        }
        return null;
    }

    public static void i(int i4, View view) {
        boolean z4;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (!accessibilityManager.isEnabled()) {
            return;
        }
        if (e(view) != null && view.isShown() && view.getWindowVisibility() == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        int i5 = 32;
        if (j0.a(view) == 0 && !z4) {
            if (i4 == 32) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain);
                obtain.setEventType(32);
                j0.g(obtain, i4);
                obtain.setSource(view);
                view.onPopulateAccessibilityEvent(obtain);
                obtain.getText().add(e(view));
                accessibilityManager.sendAccessibilityEvent(obtain);
                return;
            } else if (view.getParent() != null) {
                try {
                    j0.e(view.getParent(), view, view, i4);
                    return;
                } catch (AbstractMethodError e4) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e4);
                    return;
                }
            } else {
                return;
            }
        }
        AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
        if (!z4) {
            i5 = 2048;
        }
        obtain2.setEventType(i5);
        j0.g(obtain2, i4);
        if (z4) {
            obtain2.getText().add(e(view));
            if (g0.c(view) == 0) {
                g0.s(view, 1);
            }
            ViewParent parent = view.getParent();
            while (true) {
                if (!(parent instanceof View)) {
                    break;
                } else if (g0.c((View) parent) == 4) {
                    g0.s(view, 2);
                    break;
                } else {
                    parent = parent.getParent();
                }
            }
        }
        view.sendAccessibilityEventUnchecked(obtain2);
    }

    public static g2 j(View view, g2 g2Var) {
        WindowInsets g4 = g2Var.g();
        if (g4 != null) {
            WindowInsets b5 = k0.b(view, g4);
            if (!b5.equals(g4)) {
                return g2.h(view, b5);
            }
        }
        return g2Var;
    }

    public static j k(View view, j jVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + jVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return u0.b(view, jVar);
        }
        x xVar = (x) view.getTag(R.id.tag_on_receive_content_listener);
        y yVar = f5003e;
        if (xVar != null) {
            j a5 = ((androidx.core.widget.w) xVar).a(view, jVar);
            if (a5 == null) {
                return null;
            }
            if (view instanceof y) {
                yVar = (y) view;
            }
            return yVar.a(a5);
        }
        if (view instanceof y) {
            yVar = (y) view;
        }
        return yVar.a(jVar);
    }

    public static void l(int i4, View view) {
        m(i4, view);
        i(0, view);
    }

    public static void m(int i4, View view) {
        ArrayList f4 = f(view);
        for (int i5 = 0; i5 < f4.size(); i5++) {
            if (((j0.g) f4.get(i5)).a() == i4) {
                f4.remove(i5);
                return;
            }
        }
    }

    public static void n(View view, j0.g gVar, String str, j0.v vVar) {
        c cVar;
        if (vVar == null && str == null) {
            l(gVar.a(), view);
            return;
        }
        j0.g gVar2 = new j0.g(null, gVar.f5089b, str, vVar, gVar.f5090c);
        View.AccessibilityDelegate d4 = d(view);
        if (d4 == null) {
            cVar = null;
        } else if (d4 instanceof a) {
            cVar = ((a) d4).f4906a;
        } else {
            cVar = new c(d4);
        }
        if (cVar == null) {
            cVar = new c();
        }
        p(view, cVar);
        m(gVar2.a(), view);
        f(view).add(gVar2);
        i(0, view);
    }

    public static void o(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i4) {
        if (Build.VERSION.SDK_INT >= 29) {
            s0.c(view, context, iArr, attributeSet, typedArray, i4, 0);
        }
    }

    public static void p(View view, c cVar) {
        a aVar;
        if (cVar == null && (d(view) instanceof a)) {
            cVar = new c();
        }
        if (cVar == null) {
            aVar = null;
        } else {
            aVar = cVar.f4913b;
        }
        view.setAccessibilityDelegate(aVar);
    }

    public static void q(View view, CharSequence charSequence) {
        boolean z4 = true;
        new c0(R.id.tag_accessibility_pane_title, 8, 28, 1).b(view, charSequence);
        d0 d0Var = f5004f;
        if (charSequence != null) {
            d0Var.f4916a.put(view, Boolean.valueOf((view.isShown() && view.getWindowVisibility() == 0) ? false : false));
            view.addOnAttachStateChangeListener(d0Var);
            if (j0.b(view)) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(d0Var);
                return;
            }
            return;
        }
        d0Var.f4916a.remove(view);
        view.removeOnAttachStateChangeListener(d0Var);
        g0.o(view.getViewTreeObserver(), d0Var);
    }
}
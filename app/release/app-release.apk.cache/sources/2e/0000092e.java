package p0;

import android.graphics.Rect;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.drawerlayout.widget.DrawerLayout;
import i0.g0;
import i0.h0;
import i0.y0;
import j0.g;
import j0.h;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class b extends i0.c {

    /* renamed from: d  reason: collision with root package name */
    public final Rect f6126d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ DrawerLayout f6127e;

    public b(DrawerLayout drawerLayout) {
        this.f6127e = drawerLayout;
    }

    @Override // i0.c
    public final boolean a(View view, AccessibilityEvent accessibilityEvent) {
        CharSequence charSequence;
        if (accessibilityEvent.getEventType() == 32) {
            List<CharSequence> text = accessibilityEvent.getText();
            DrawerLayout drawerLayout = this.f6127e;
            View f4 = drawerLayout.f();
            if (f4 != null) {
                int h4 = drawerLayout.h(f4);
                drawerLayout.getClass();
                WeakHashMap weakHashMap = y0.f4999a;
                int absoluteGravity = Gravity.getAbsoluteGravity(h4, h0.d(drawerLayout));
                if (absoluteGravity == 3) {
                    charSequence = drawerLayout.f1487z;
                } else if (absoluteGravity == 5) {
                    charSequence = drawerLayout.A;
                } else {
                    charSequence = null;
                }
                if (charSequence != null) {
                    text.add(charSequence);
                    return true;
                }
                return true;
            }
            return true;
        }
        return this.f4912a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // i0.c
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
        accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
    }

    @Override // i0.c
    public final void d(View view, h hVar) {
        boolean z4 = DrawerLayout.N;
        View.AccessibilityDelegate accessibilityDelegate = this.f4912a;
        AccessibilityNodeInfo accessibilityNodeInfo = hVar.f5093a;
        if (z4) {
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        } else {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, obtain);
            hVar.f5095c = -1;
            accessibilityNodeInfo.setSource(view);
            WeakHashMap weakHashMap = y0.f4999a;
            ViewParent f4 = g0.f(view);
            if (f4 instanceof View) {
                hVar.f5094b = -1;
                accessibilityNodeInfo.setParent((View) f4);
            }
            Rect rect = this.f6126d;
            obtain.getBoundsInScreen(rect);
            accessibilityNodeInfo.setBoundsInScreen(rect);
            accessibilityNodeInfo.setVisibleToUser(obtain.isVisibleToUser());
            accessibilityNodeInfo.setPackageName(obtain.getPackageName());
            hVar.g(obtain.getClassName());
            accessibilityNodeInfo.setContentDescription(obtain.getContentDescription());
            accessibilityNodeInfo.setEnabled(obtain.isEnabled());
            accessibilityNodeInfo.setFocused(obtain.isFocused());
            accessibilityNodeInfo.setAccessibilityFocused(obtain.isAccessibilityFocused());
            accessibilityNodeInfo.setSelected(obtain.isSelected());
            hVar.a(obtain.getActions());
            obtain.recycle();
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = viewGroup.getChildAt(i4);
                if (DrawerLayout.i(childAt)) {
                    accessibilityNodeInfo.addChild(childAt);
                }
            }
        }
        hVar.g("androidx.drawerlayout.widget.DrawerLayout");
        accessibilityNodeInfo.setFocusable(false);
        accessibilityNodeInfo.setFocused(false);
        accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) g.f5077e.f5088a);
        accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) g.f5078f.f5088a);
    }

    @Override // i0.c
    public final boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        if (!DrawerLayout.N && !DrawerLayout.i(view)) {
            return false;
        }
        return this.f4912a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }
}
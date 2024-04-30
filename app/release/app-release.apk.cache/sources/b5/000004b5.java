package com.google.android.material.bottomsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.b;
import com.example.msphone.R;
import f1.f;
import i0.g0;
import i0.y0;
import j0.g;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l0.d;
import t1.c;

/* loaded from: classes.dex */
public class BottomSheetDragHandleView extends AppCompatImageView implements AccessibilityManager.AccessibilityStateChangeListener {

    /* renamed from: m  reason: collision with root package name */
    public static final /* synthetic */ int f3103m = 0;

    /* renamed from: d  reason: collision with root package name */
    public final AccessibilityManager f3104d;

    /* renamed from: e  reason: collision with root package name */
    public BottomSheetBehavior f3105e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3106f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3107g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3108h;

    /* renamed from: i  reason: collision with root package name */
    public final String f3109i;

    /* renamed from: j  reason: collision with root package name */
    public final String f3110j;

    /* renamed from: k  reason: collision with root package name */
    public final String f3111k;

    /* renamed from: l  reason: collision with root package name */
    public final c f3112l;

    public BottomSheetDragHandleView(@NonNull Context context) {
        this(context, null);
    }

    private void setBottomSheetBehavior(@Nullable BottomSheetBehavior<?> bottomSheetBehavior) {
        BottomSheetBehavior bottomSheetBehavior2 = this.f3105e;
        c cVar = this.f3112l;
        if (bottomSheetBehavior2 != null) {
            bottomSheetBehavior2.X.remove(cVar);
            this.f3105e.G(null);
        }
        this.f3105e = bottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.G(this);
            d(this.f3105e.L);
            ArrayList arrayList = this.f3105e.X;
            if (!arrayList.contains(cVar)) {
                arrayList.add(cVar);
            }
        }
        e();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
        if (r1 != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean c() {
        /*
            r7 = this;
            boolean r0 = r7.f3107g
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            android.view.accessibility.AccessibilityManager r0 = r7.f3104d
            if (r0 != 0) goto Lb
            goto L1d
        Lb:
            r2 = 16384(0x4000, float:2.2959E-41)
            android.view.accessibility.AccessibilityEvent r2 = android.view.accessibility.AccessibilityEvent.obtain(r2)
            java.util.List r3 = r2.getText()
            java.lang.String r4 = r7.f3111k
            r3.add(r4)
            r0.sendAccessibilityEvent(r2)
        L1d:
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r7.f3105e
            boolean r2 = r0.f3068b
            r3 = 1
            if (r2 != 0) goto L28
            r0.getClass()
            r1 = r3
        L28:
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r7.f3105e
            int r2 = r0.L
            r4 = 6
            r5 = 3
            r6 = 4
            if (r2 != r6) goto L34
            if (r1 == 0) goto L41
            goto L42
        L34:
            if (r2 != r5) goto L3b
            if (r1 == 0) goto L39
            goto L42
        L39:
            r4 = r6
            goto L42
        L3b:
            boolean r1 = r7.f3108h
            if (r1 == 0) goto L40
            goto L41
        L40:
            r5 = r6
        L41:
            r4 = r5
        L42:
            r0.I(r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetDragHandleView.c():boolean");
    }

    public final void d(int i4) {
        if (i4 == 4) {
            this.f3108h = true;
        } else if (i4 == 3) {
            this.f3108h = false;
        }
        y0.n(this, g.f5079g, this.f3108h ? this.f3109i : this.f3110j, new d(1, this));
    }

    public final void e() {
        boolean z4;
        int i4 = 1;
        if (this.f3106f && this.f3105e != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f3107g = z4;
        if (this.f3105e == null) {
            i4 = 2;
        }
        WeakHashMap weakHashMap = y0.f4999a;
        g0.s(this, i4);
        setClickable(this.f3107g);
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public final void onAccessibilityStateChanged(boolean z4) {
        this.f3106f = z4;
        e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.view.View] */
    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        BottomSheetBehavior<?> bottomSheetBehavior;
        super.onAttachedToWindow();
        BottomSheetDragHandleView bottomSheetDragHandleView = this;
        while (true) {
            ViewParent parent = bottomSheetDragHandleView.getParent();
            bottomSheetBehavior = null;
            if (parent instanceof View) {
                bottomSheetDragHandleView = (View) parent;
            } else {
                bottomSheetDragHandleView = null;
            }
            if (bottomSheetDragHandleView == null) {
                break;
            }
            ViewGroup.LayoutParams layoutParams = bottomSheetDragHandleView.getLayoutParams();
            if (layoutParams instanceof b) {
                CoordinatorLayout.Behavior behavior = ((b) layoutParams).f1347a;
                if (behavior instanceof BottomSheetBehavior) {
                    bottomSheetBehavior = (BottomSheetBehavior) behavior;
                    break;
                }
            }
        }
        setBottomSheetBehavior(bottomSheetBehavior);
        AccessibilityManager accessibilityManager = this.f3104d;
        if (accessibilityManager != null) {
            accessibilityManager.addAccessibilityStateChangeListener(this);
            onAccessibilityStateChanged(accessibilityManager.isEnabled());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        AccessibilityManager accessibilityManager = this.f3104d;
        if (accessibilityManager != null) {
            accessibilityManager.removeAccessibilityStateChangeListener(this);
        }
        setBottomSheetBehavior(null);
        super.onDetachedFromWindow();
    }

    public BottomSheetDragHandleView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomSheetDragHandleStyle);
    }

    public BottomSheetDragHandleView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(p2.a.a(context, attributeSet, i4, 2131755849), attributeSet, i4);
        this.f3109i = getResources().getString(R.string.bottomsheet_action_expand);
        this.f3110j = getResources().getString(R.string.bottomsheet_action_collapse);
        this.f3111k = getResources().getString(R.string.bottomsheet_drag_handle_clicked);
        this.f3112l = new c(this);
        this.f3104d = (AccessibilityManager) getContext().getSystemService("accessibility");
        e();
        y0.p(this, new f(1, this));
    }
}
package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import c1.f;
import c1.m0;
import c1.n;
import c1.p0;
import i0.i0;
import i0.y0;
import java.util.HashMap;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class ChangeClipBounds extends Transition {

    /* renamed from: y  reason: collision with root package name */
    public static final String[] f2340y = {"android:clipBounds:clip"};

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static void H(m0 m0Var) {
        View view = m0Var.f2647b;
        if (view.getVisibility() == 8) {
            return;
        }
        WeakHashMap weakHashMap = y0.f4999a;
        Rect a5 = i0.a(view);
        HashMap hashMap = m0Var.f2646a;
        hashMap.put("android:clipBounds:clip", a5);
        if (a5 == null) {
            hashMap.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
        }
    }

    @Override // androidx.transition.Transition
    public final void d(m0 m0Var) {
        H(m0Var);
    }

    @Override // androidx.transition.Transition
    public final void g(m0 m0Var) {
        H(m0Var);
    }

    @Override // androidx.transition.Transition
    public final Animator k(ViewGroup viewGroup, m0 m0Var, m0 m0Var2) {
        boolean z4;
        if (m0Var != null && m0Var2 != null) {
            HashMap hashMap = m0Var.f2646a;
            if (hashMap.containsKey("android:clipBounds:clip")) {
                HashMap hashMap2 = m0Var2.f2646a;
                if (hashMap2.containsKey("android:clipBounds:clip")) {
                    Rect rect = (Rect) hashMap.get("android:clipBounds:clip");
                    Rect rect2 = (Rect) hashMap2.get("android:clipBounds:clip");
                    if (rect2 == null) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (rect == null && rect2 == null) {
                        return null;
                    }
                    if (rect == null) {
                        rect = (Rect) hashMap.get("android:clipBounds:bounds");
                    } else if (rect2 == null) {
                        rect2 = (Rect) hashMap2.get("android:clipBounds:bounds");
                    }
                    if (rect.equals(rect2)) {
                        return null;
                    }
                    WeakHashMap weakHashMap = y0.f4999a;
                    View view = m0Var2.f2647b;
                    i0.c(view, rect);
                    ObjectAnimator ofObject = ObjectAnimator.ofObject(view, p0.f2668c, new n(1, new Rect()), rect, rect2);
                    if (z4) {
                        ofObject.addListener(new f(0, this, view));
                    }
                    return ofObject;
                }
            }
        }
        return null;
    }

    @Override // androidx.transition.Transition
    public final String[] p() {
        return f2340y;
    }
}
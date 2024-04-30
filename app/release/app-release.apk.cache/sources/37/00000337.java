package androidx.transition;

import a0.t;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.j3;
import c1.a;
import c1.c0;
import c1.m0;
import c1.n;
import i0.i0;
import i0.j0;
import i0.y0;
import java.util.HashMap;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class ChangeBounds extends Transition {
    public static final j3 A;
    public static final j3 B;
    public static final j3 C;
    public static final j3 D;
    public static final j3 E;
    public static final n F;

    /* renamed from: z  reason: collision with root package name */
    public static final String[] f2338z = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: y  reason: collision with root package name */
    public boolean f2339y;

    static {
        new a(0);
        A = new j3(PointF.class, "topLeft", 1);
        B = new j3(PointF.class, "bottomRight", 2);
        C = new j3(PointF.class, "bottomRight", 3);
        D = new j3(PointF.class, "topLeft", 4);
        E = new j3(PointF.class, "position", 5);
        F = new n(1);
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2339y = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c0.f2580b);
        boolean z4 = t.d((XmlResourceParser) attributeSet, "resizeClip") ? obtainStyledAttributes.getBoolean(0, false) : false;
        obtainStyledAttributes.recycle();
        this.f2339y = z4;
    }

    public final void H(m0 m0Var) {
        View view = m0Var.f2647b;
        WeakHashMap weakHashMap = y0.f4999a;
        if (j0.c(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            HashMap hashMap = m0Var.f2646a;
            hashMap.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            hashMap.put("android:changeBounds:parent", m0Var.f2647b.getParent());
            if (this.f2339y) {
                hashMap.put("android:changeBounds:clip", i0.a(view));
            }
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

    /* JADX WARN: Removed duplicated region for block: B:74:0x01aa  */
    /* JADX WARN: Type inference failed for: r2v20, types: [c1.e, java.lang.Object] */
    @Override // androidx.transition.Transition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.animation.Animator k(android.view.ViewGroup r20, c1.m0 r21, c1.m0 r22) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeBounds.k(android.view.ViewGroup, c1.m0, c1.m0):android.animation.Animator");
    }

    @Override // androidx.transition.Transition
    public final String[] p() {
        return f2338z;
    }
}
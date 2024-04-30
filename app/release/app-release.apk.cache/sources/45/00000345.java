package androidx.transition;

import a0.t;
import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import c1.c0;
import c1.m0;
import c1.x0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class Visibility extends Transition {

    /* renamed from: z  reason: collision with root package name */
    public static final String[] f2374z = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: y  reason: collision with root package name */
    public int f2375y;

    @SuppressLint({"UniqueConstants"})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f171c})
    /* loaded from: classes.dex */
    public @interface Mode {
    }

    public Visibility() {
        this.f2375y = 3;
    }

    public static void H(m0 m0Var) {
        int visibility = m0Var.f2647b.getVisibility();
        HashMap hashMap = m0Var.f2646a;
        hashMap.put("android:visibility:visibility", Integer.valueOf(visibility));
        View view = m0Var.f2647b;
        hashMap.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        hashMap.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0070, code lost:
        if (r9 == 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
        if (r0.f2714e == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008a, code lost:
        if (r0.f2712c == 0) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0058 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0035  */
    /* JADX WARN: Type inference failed for: r0v0, types: [c1.x0, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static c1.x0 I(c1.m0 r8, c1.m0 r9) {
        /*
            c1.x0 r0 = new c1.x0
            r0.<init>()
            r1 = 0
            r0.f2710a = r1
            r0.f2711b = r1
            r2 = 0
            r3 = -1
            java.lang.String r4 = "android:visibility:parent"
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L2f
            java.util.HashMap r6 = r8.f2646a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L2f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.f2712c = r7
            java.lang.Object r6 = r6.get(r4)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f2714e = r6
            goto L33
        L2f:
            r0.f2712c = r3
            r0.f2714e = r2
        L33:
            if (r9 == 0) goto L52
            java.util.HashMap r6 = r9.f2646a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L52
            java.lang.Object r2 = r6.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0.f2713d = r2
            java.lang.Object r2 = r6.get(r4)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
        L4f:
            r0.f2715f = r2
            goto L55
        L52:
            r0.f2713d = r3
            goto L4f
        L55:
            r2 = 1
            if (r8 == 0) goto L7f
            if (r9 == 0) goto L7f
            int r8 = r0.f2712c
            int r9 = r0.f2713d
            if (r8 != r9) goto L67
            android.view.ViewGroup r3 = r0.f2714e
            android.view.ViewGroup r4 = r0.f2715f
            if (r3 != r4) goto L67
            return r0
        L67:
            if (r8 == r9) goto L75
            if (r8 != 0) goto L70
        L6b:
            r0.f2711b = r1
        L6d:
            r0.f2710a = r2
            goto L8d
        L70:
            if (r9 != 0) goto L8d
        L72:
            r0.f2711b = r2
            goto L6d
        L75:
            android.view.ViewGroup r8 = r0.f2715f
            if (r8 != 0) goto L7a
            goto L6b
        L7a:
            android.view.ViewGroup r8 = r0.f2714e
            if (r8 != 0) goto L8d
            goto L72
        L7f:
            if (r8 != 0) goto L86
            int r8 = r0.f2713d
            if (r8 != 0) goto L86
            goto L72
        L86:
            if (r9 != 0) goto L8d
            int r8 = r0.f2712c
            if (r8 != 0) goto L8d
            goto L6b
        L8d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.I(c1.m0, c1.m0):c1.x0");
    }

    public Animator J(ViewGroup viewGroup, View view, m0 m0Var, m0 m0Var2) {
        return null;
    }

    public Animator K(ViewGroup viewGroup, View view, m0 m0Var) {
        return null;
    }

    public final void L(int i4) {
        if ((i4 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.f2375y = i4;
    }

    @Override // androidx.transition.Transition
    public void d(m0 m0Var) {
        H(m0Var);
    }

    @Override // androidx.transition.Transition
    public void g(m0 m0Var) {
        H(m0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
        if (I(n(r5, false), q(r5, false)).f2710a != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01c5  */
    @Override // androidx.transition.Transition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.animation.Animator k(android.view.ViewGroup r21, c1.m0 r22, c1.m0 r23) {
        /*
            Method dump skipped, instructions count: 641
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.k(android.view.ViewGroup, c1.m0, c1.m0):android.animation.Animator");
    }

    @Override // androidx.transition.Transition
    public final String[] p() {
        return f2374z;
    }

    @Override // androidx.transition.Transition
    public final boolean r(m0 m0Var, m0 m0Var2) {
        if (m0Var == null && m0Var2 == null) {
            return false;
        }
        if (m0Var != null && m0Var2 != null && m0Var2.f2646a.containsKey("android:visibility:visibility") != m0Var.f2646a.containsKey("android:visibility:visibility")) {
            return false;
        }
        x0 I = I(m0Var, m0Var2);
        if (!I.f2710a) {
            return false;
        }
        if (I.f2712c != 0 && I.f2713d != 0) {
            return false;
        }
        return true;
    }

    @SuppressLint({"RestrictedApi"})
    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2375y = 3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c0.f2581c);
        int b5 = t.b(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (b5 != 0) {
            L(b5);
        }
    }
}
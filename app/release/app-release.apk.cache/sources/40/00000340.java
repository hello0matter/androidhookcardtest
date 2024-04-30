package androidx.transition;

import a0.t;
import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.RestrictTo;
import c1.a0;
import c1.c0;
import c1.m0;
import c1.z;
import com.google.common.collect.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class Slide extends Visibility {
    public static final DecelerateInterpolator B = new DecelerateInterpolator();
    public static final AccelerateInterpolator C = new AccelerateInterpolator();
    public static final z D = new z(0);
    public static final z E = new z(1);
    public static final a0 F = new a0(0);
    public static final z G = new z(2);
    public static final z H = new z(3);
    public static final a0 I = new a0(1);
    public final c A;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f171c})
    /* loaded from: classes.dex */
    public @interface GravityFlag {
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [c1.y, java.lang.Object, com.google.common.collect.c] */
    @SuppressLint({"RestrictedApi"})
    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c cVar;
        a0 a0Var = I;
        this.A = a0Var;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c0.f2584f);
        int b5 = t.b(obtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        obtainStyledAttributes.recycle();
        if (b5 != 3) {
            if (b5 != 5) {
                if (b5 != 48) {
                    if (b5 != 80) {
                        if (b5 != 8388611) {
                            if (b5 == 8388613) {
                                cVar = H;
                            } else {
                                throw new IllegalArgumentException("Invalid slide direction");
                            }
                        } else {
                            cVar = E;
                        }
                    } else {
                        this.A = a0Var;
                        ?? obj = new Object();
                        obj.f2716r = b5;
                        this.f2369s = obj;
                    }
                } else {
                    cVar = F;
                }
            } else {
                cVar = G;
            }
        } else {
            cVar = D;
        }
        this.A = cVar;
        ?? obj2 = new Object();
        obj2.f2716r = b5;
        this.f2369s = obj2;
    }

    @Override // androidx.transition.Visibility
    public final Animator J(ViewGroup viewGroup, View view, m0 m0Var, m0 m0Var2) {
        if (m0Var2 == null) {
            return null;
        }
        int[] iArr = (int[]) m0Var2.f2646a.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return c.Y(view, m0Var2, iArr[0], iArr[1], this.A.d(viewGroup, view), this.A.h(viewGroup, view), translationX, translationY, B, this);
    }

    @Override // androidx.transition.Visibility
    public final Animator K(ViewGroup viewGroup, View view, m0 m0Var) {
        if (m0Var == null) {
            return null;
        }
        int[] iArr = (int[]) m0Var.f2646a.get("android:slide:screenPosition");
        return c.Y(view, m0Var, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.A.d(viewGroup, view), this.A.h(viewGroup, view), C, this);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public final void d(m0 m0Var) {
        Visibility.H(m0Var);
        int[] iArr = new int[2];
        m0Var.f2647b.getLocationOnScreen(iArr);
        m0Var.f2646a.put("android:slide:screenPosition", iArr);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public final void g(m0 m0Var) {
        Visibility.H(m0Var);
        int[] iArr = new int[2];
        m0Var.f2647b.getLocationOnScreen(iArr);
        m0Var.f2646a.put("android:slide:screenPosition", iArr);
    }
}
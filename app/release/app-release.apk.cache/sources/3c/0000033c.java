package androidx.transition;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import c1.m0;
import com.example.msphone.R;
import com.google.common.collect.c;

/* loaded from: classes.dex */
public class Explode extends Visibility {
    public static final DecelerateInterpolator B = new DecelerateInterpolator();
    public static final AccelerateInterpolator C = new AccelerateInterpolator();
    public final int[] A;

    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, com.google.common.collect.c] */
    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A = new int[2];
        this.f2369s = new Object();
    }

    @Override // androidx.transition.Visibility
    public final Animator J(ViewGroup viewGroup, View view, m0 m0Var, m0 m0Var2) {
        if (m0Var2 == null) {
            return null;
        }
        Rect rect = (Rect) m0Var2.f2646a.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = this.A;
        M(viewGroup, rect, iArr);
        return c.Y(view, m0Var2, rect.left, rect.top, translationX + iArr[0], translationY + iArr[1], translationX, translationY, B, this);
    }

    @Override // androidx.transition.Visibility
    public final Animator K(ViewGroup viewGroup, View view, m0 m0Var) {
        float f4;
        float f5;
        if (m0Var == null) {
            return null;
        }
        Rect rect = (Rect) m0Var.f2646a.get("android:explode:screenBounds");
        int i4 = rect.left;
        int i5 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) m0Var.f2647b.getTag(R.id.transition_position);
        if (iArr != null) {
            int i6 = iArr[0];
            f4 = (i6 - rect.left) + translationX;
            int i7 = iArr[1];
            f5 = (i7 - rect.top) + translationY;
            rect.offsetTo(i6, i7);
        } else {
            f4 = translationX;
            f5 = translationY;
        }
        int[] iArr2 = this.A;
        M(viewGroup, rect, iArr2);
        return c.Y(view, m0Var, i4, i5, translationX, translationY, f4 + iArr2[0], f5 + iArr2[1], C, this);
    }

    public final void M(View view, Rect rect, int[] iArr) {
        Rect n12;
        int centerX;
        int centerY;
        int[] iArr2 = this.A;
        view.getLocationOnScreen(iArr2);
        int i4 = iArr2[0];
        int i5 = iArr2[1];
        c cVar = this.f2370t;
        if (cVar == null) {
            n12 = null;
        } else {
            n12 = cVar.n1();
        }
        if (n12 == null) {
            centerX = Math.round(view.getTranslationX()) + (view.getWidth() / 2) + i4;
            centerY = Math.round(view.getTranslationY()) + (view.getHeight() / 2) + i5;
        } else {
            centerX = n12.centerX();
            centerY = n12.centerY();
        }
        float centerX2 = rect.centerX() - centerX;
        float centerY2 = rect.centerY() - centerY;
        if (centerX2 == 0.0f && centerY2 == 0.0f) {
            centerX2 = ((float) (Math.random() * 2.0d)) - 1.0f;
            centerY2 = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float sqrt = (float) Math.sqrt((centerY2 * centerY2) + (centerX2 * centerX2));
        int i6 = centerX - i4;
        int i7 = centerY - i5;
        float max = Math.max(i6, view.getWidth() - i6);
        float max2 = Math.max(i7, view.getHeight() - i7);
        float sqrt2 = (float) Math.sqrt((max2 * max2) + (max * max));
        iArr[0] = Math.round((centerX2 / sqrt) * sqrt2);
        iArr[1] = Math.round(sqrt2 * (centerY2 / sqrt));
    }

    public final void N(m0 m0Var) {
        View view = m0Var.f2647b;
        int[] iArr = this.A;
        view.getLocationOnScreen(iArr);
        int i4 = iArr[0];
        int i5 = iArr[1];
        m0Var.f2646a.put("android:explode:screenBounds", new Rect(i4, i5, view.getWidth() + i4, view.getHeight() + i5));
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public final void d(m0 m0Var) {
        Visibility.H(m0Var);
        N(m0Var);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public final void g(m0 m0Var) {
        Visibility.H(m0Var);
        N(m0Var);
    }
}
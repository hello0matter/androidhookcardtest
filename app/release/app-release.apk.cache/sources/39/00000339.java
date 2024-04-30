package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.j3;
import c1.g;
import c1.h;
import c1.k0;
import c1.m0;
import c1.w;
import c1.x;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ChangeImageTransform extends Transition {

    /* renamed from: y  reason: collision with root package name */
    public static final String[] f2341y = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};

    /* renamed from: z  reason: collision with root package name */
    public static final g f2342z = new Object();
    public static final j3 A = new j3(Matrix.class, "animatedTransform", 6);

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static void H(m0 m0Var) {
        Matrix matrix;
        View view = m0Var.f2647b;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() == null) {
                return;
            }
            HashMap hashMap = m0Var.f2646a;
            hashMap.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            Drawable drawable = imageView.getDrawable();
            if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
                int i4 = h.f2609a[imageView.getScaleType().ordinal()];
                if (i4 != 1) {
                    if (i4 == 2) {
                        Drawable drawable2 = imageView.getDrawable();
                        int intrinsicWidth = drawable2.getIntrinsicWidth();
                        float width = imageView.getWidth();
                        float f4 = intrinsicWidth;
                        int intrinsicHeight = drawable2.getIntrinsicHeight();
                        float height = imageView.getHeight();
                        float f5 = intrinsicHeight;
                        float max = Math.max(width / f4, height / f5);
                        int round = Math.round((width - (f4 * max)) / 2.0f);
                        int round2 = Math.round((height - (f5 * max)) / 2.0f);
                        matrix = new Matrix();
                        matrix.postScale(max, max);
                        matrix.postTranslate(round, round2);
                    }
                } else {
                    Drawable drawable3 = imageView.getDrawable();
                    Matrix matrix2 = new Matrix();
                    matrix2.postScale(imageView.getWidth() / drawable3.getIntrinsicWidth(), imageView.getHeight() / drawable3.getIntrinsicHeight());
                    matrix = matrix2;
                }
                hashMap.put("android:changeImageTransform:matrix", matrix);
            }
            matrix = new Matrix(imageView.getImageMatrix());
            hashMap.put("android:changeImageTransform:matrix", matrix);
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
            Rect rect = (Rect) hashMap.get("android:changeImageTransform:bounds");
            HashMap hashMap2 = m0Var2.f2646a;
            Rect rect2 = (Rect) hashMap2.get("android:changeImageTransform:bounds");
            if (rect != null && rect2 != null) {
                Matrix matrix = (Matrix) hashMap.get("android:changeImageTransform:matrix");
                Matrix matrix2 = (Matrix) hashMap2.get("android:changeImageTransform:matrix");
                if ((matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2))) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (rect.equals(rect2) && z4) {
                    return null;
                }
                ImageView imageView = (ImageView) m0Var2.f2647b;
                Drawable drawable = imageView.getDrawable();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                j3 j3Var = A;
                if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                    if (matrix == null) {
                        matrix = x.f2709a;
                    }
                    if (matrix2 == null) {
                        matrix2 = x.f2709a;
                    }
                    j3Var.set(imageView, matrix);
                    return ObjectAnimator.ofObject(imageView, j3Var, new k0(), matrix, matrix2);
                }
                g gVar = f2342z;
                w wVar = x.f2709a;
                return ObjectAnimator.ofObject(imageView, j3Var, gVar, wVar, wVar);
            }
        }
        return null;
    }

    @Override // androidx.transition.Transition
    public final String[] p() {
        return f2341y;
    }
}
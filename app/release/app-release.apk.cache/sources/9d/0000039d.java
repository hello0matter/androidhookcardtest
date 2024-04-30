package c1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.view.View;
import androidx.transition.ChangeTransform;
import com.example.msphone.R;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class i extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2612a;

    /* renamed from: b  reason: collision with root package name */
    public final Matrix f2613b = new Matrix();

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f2614c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Matrix f2615d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ View f2616e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ l f2617f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ k f2618g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ChangeTransform f2619h;

    public i(ChangeTransform changeTransform, boolean z4, Matrix matrix, View view, l lVar, k kVar) {
        this.f2619h = changeTransform;
        this.f2614c = z4;
        this.f2615d = matrix;
        this.f2616e = view;
        this.f2617f = lVar;
        this.f2618g = kVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f2612a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        boolean z4 = this.f2612a;
        l lVar = this.f2617f;
        View view = this.f2616e;
        if (!z4) {
            if (this.f2614c && this.f2619h.f2344y) {
                Matrix matrix = this.f2613b;
                matrix.set(this.f2615d);
                view.setTag(R.id.transition_transform, matrix);
                lVar.getClass();
                String[] strArr = ChangeTransform.B;
                view.setTranslationX(lVar.f2635a);
                view.setTranslationY(lVar.f2636b);
                WeakHashMap weakHashMap = i0.y0.f4999a;
                i0.m0.w(view, lVar.f2637c);
                view.setScaleX(lVar.f2638d);
                view.setScaleY(lVar.f2639e);
                view.setRotationX(lVar.f2640f);
                view.setRotationY(lVar.f2641g);
                view.setRotation(lVar.f2642h);
            } else {
                view.setTag(R.id.transition_transform, null);
                view.setTag(R.id.parent_matrix, null);
            }
        }
        p0.f2666a.A(view, null);
        lVar.getClass();
        String[] strArr2 = ChangeTransform.B;
        view.setTranslationX(lVar.f2635a);
        view.setTranslationY(lVar.f2636b);
        WeakHashMap weakHashMap2 = i0.y0.f4999a;
        i0.m0.w(view, lVar.f2637c);
        view.setScaleX(lVar.f2638d);
        view.setScaleY(lVar.f2639e);
        view.setRotationX(lVar.f2640f);
        view.setRotationY(lVar.f2641g);
        view.setRotation(lVar.f2642h);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        Matrix matrix = this.f2618g.f2627a;
        Matrix matrix2 = this.f2613b;
        matrix2.set(matrix);
        View view = this.f2616e;
        view.setTag(R.id.transition_transform, matrix2);
        l lVar = this.f2617f;
        lVar.getClass();
        String[] strArr = ChangeTransform.B;
        view.setTranslationX(lVar.f2635a);
        view.setTranslationY(lVar.f2636b);
        WeakHashMap weakHashMap = i0.y0.f4999a;
        i0.m0.w(view, lVar.f2637c);
        view.setScaleX(lVar.f2638d);
        view.setScaleY(lVar.f2639e);
        view.setRotationX(lVar.f2640f);
        view.setRotationY(lVar.f2641g);
        view.setRotation(lVar.f2642h);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        String[] strArr = ChangeTransform.B;
        View view = this.f2616e;
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        WeakHashMap weakHashMap = i0.y0.f4999a;
        i0.m0.w(view, 0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setRotation(0.0f);
    }
}
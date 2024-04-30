package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import androidx.transition.Transition;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.android.material.transformation.ExpandableTransformationBehavior;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class e extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f736a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f737b;

    public /* synthetic */ e(int i4, Object obj) {
        this.f736a = i4;
        this.f737b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        switch (this.f736a) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f737b;
                actionBarOverlayLayout.f449w = null;
                actionBarOverlayLayout.f437k = false;
                return;
            default:
                super.onAnimationCancel(animator);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i4 = this.f736a;
        Object obj = this.f737b;
        switch (i4) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) obj;
                actionBarOverlayLayout.f449w = null;
                actionBarOverlayLayout.f437k = false;
                return;
            case 1:
                ((Transition) obj).m();
                animator.removeListener(this);
                return;
            case 2:
                d1.f fVar = (d1.f) obj;
                ArrayList arrayList = new ArrayList(fVar.f4266e);
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ((d1.c) arrayList.get(i5)).a(fVar);
                }
                return;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                ((HideBottomViewOnScrollBehavior) obj).f3008i = null;
                return;
            case VisibleForTesting.PROTECTED /* 4 */:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) obj;
                bottomSheetBehavior.J(5);
                WeakReference weakReference = bottomSheetBehavior.U;
                if (weakReference != null && weakReference.get() != null) {
                    ((View) bottomSheetBehavior.U.get()).requestLayout();
                    return;
                }
                return;
            case VisibleForTesting.NONE /* 5 */:
                ((x1.g) obj).g();
                return;
            case 6:
                com.google.android.material.internal.a0 a0Var = (com.google.android.material.internal.a0) obj;
                if (a0Var.f3475b == animator) {
                    a0Var.f3475b = null;
                    return;
                }
                return;
            case 7:
                f2.g gVar = (f2.g) obj;
                gVar.f4552b.setTranslationY(0.0f);
                gVar.c(0.0f);
                return;
            case 8:
            default:
                super.onAnimationEnd(animator);
                return;
            case 9:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj;
                sideSheetBehavior.x(5);
                WeakReference weakReference2 = sideSheetBehavior.f3825p;
                if (weakReference2 != null && weakReference2.get() != null) {
                    ((View) sideSheetBehavior.f3825p.get()).requestLayout();
                    return;
                }
                return;
            case 10:
                com.google.android.material.textfield.i iVar = (com.google.android.material.textfield.i) obj;
                iVar.q();
                iVar.f4045r.start();
                return;
            case 11:
                ((ExpandableTransformationBehavior) obj).f4165b = null;
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        switch (this.f736a) {
            case 8:
                super.onAnimationRepeat(animator);
                h2.o oVar = (h2.o) this.f737b;
                oVar.f4875g = (oVar.f4875g + 1) % oVar.f4874f.f4821c.length;
                oVar.f4876h = true;
                return;
            default:
                super.onAnimationRepeat(animator);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        int i4 = this.f736a;
        Object obj = this.f737b;
        switch (i4) {
            case 2:
                d1.f fVar = (d1.f) obj;
                ArrayList arrayList = new ArrayList(fVar.f4266e);
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ((d1.c) arrayList.get(i5)).b(fVar);
                }
                return;
            case VisibleForTesting.NONE /* 5 */:
                ((x1.g) obj).c();
                return;
            default:
                super.onAnimationStart(animator);
                return;
        }
    }
}
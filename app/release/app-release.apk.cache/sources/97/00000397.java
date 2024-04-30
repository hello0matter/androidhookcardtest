package c1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.transition.Transition;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class f extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2606a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f2607b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f2608c;

    public /* synthetic */ f(int i4, Object obj, Object obj2) {
        this.f2606a = i4;
        this.f2608c = obj;
        this.f2607b = obj2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i4 = this.f2606a;
        Object obj = this.f2608c;
        Object obj2 = this.f2607b;
        switch (i4) {
            case 0:
                WeakHashMap weakHashMap = i0.y0.f4999a;
                i0.i0.c((View) obj2, null);
                return;
            case 1:
                ((l.b) obj2).remove(animator);
                ((Transition) obj).f2363m.remove(animator);
                return;
            case 2:
                View view = (View) obj2;
                if (view != null) {
                    view.setVisibility(0);
                    return;
                }
                return;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                DrawerLayout drawerLayout = (DrawerLayout) obj;
                drawerLayout.b((View) obj2, false);
                drawerLayout.setScrimColor(-1728053248);
                return;
            default:
                x1.g gVar = (x1.g) obj2;
                x1.f revealInfo = gVar.getRevealInfo();
                revealInfo.f7141c = Float.MAX_VALUE;
                gVar.setRevealInfo(revealInfo);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f2606a) {
            case 1:
                ((Transition) this.f2608c).f2363m.add(animator);
                return;
            default:
                super.onAnimationStart(animator);
                return;
        }
    }
}
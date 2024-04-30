package d2;

import android.animation.Animator;
import androidx.appcompat.widget.j3;
import com.example.msphone.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/* loaded from: classes.dex */
public final class g extends a {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ExtendedFloatingActionButton f4364g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(ExtendedFloatingActionButton extendedFloatingActionButton, w1.g gVar) {
        super(extendedFloatingActionButton, gVar);
        this.f4364g = extendedFloatingActionButton;
    }

    @Override // d2.a
    public final int c() {
        return R.animator.mtrl_extended_fab_show_motion_spec;
    }

    @Override // d2.a
    public final void e() {
        this.f4337d.f7056b = null;
        this.f4364g.f3392t = 0;
    }

    @Override // d2.a
    public final void f(Animator animator) {
        w1.g gVar = this.f4337d;
        Animator animator2 = (Animator) gVar.f7056b;
        if (animator2 != null) {
            animator2.cancel();
        }
        gVar.f7056b = animator;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f4364g;
        extendedFloatingActionButton.setVisibility(0);
        extendedFloatingActionButton.f3392t = 2;
    }

    @Override // d2.a
    public final void g() {
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f4364g;
        extendedFloatingActionButton.setVisibility(0);
        extendedFloatingActionButton.setAlpha(1.0f);
        extendedFloatingActionButton.setScaleY(1.0f);
        extendedFloatingActionButton.setScaleX(1.0f);
    }

    @Override // d2.a
    public final boolean h() {
        j3 j3Var = ExtendedFloatingActionButton.I;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f4364g;
        int visibility = extendedFloatingActionButton.getVisibility();
        int i4 = extendedFloatingActionButton.f3392t;
        if (visibility != 0) {
            if (i4 != 2) {
                return false;
            }
        } else if (i4 == 1) {
            return false;
        }
        return true;
    }
}
package d2;

import android.animation.Animator;
import androidx.appcompat.widget.j3;
import com.example.msphone.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/* loaded from: classes.dex */
public final class f extends a {

    /* renamed from: g  reason: collision with root package name */
    public boolean f4362g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ExtendedFloatingActionButton f4363h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(ExtendedFloatingActionButton extendedFloatingActionButton, w1.g gVar) {
        super(extendedFloatingActionButton, gVar);
        this.f4363h = extendedFloatingActionButton;
    }

    @Override // d2.a
    public final int c() {
        return R.animator.mtrl_extended_fab_hide_motion_spec;
    }

    @Override // d2.a
    public final void d() {
        super.d();
        this.f4362g = true;
    }

    @Override // d2.a
    public final void e() {
        this.f4337d.f7056b = null;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f4363h;
        extendedFloatingActionButton.f3392t = 0;
        if (!this.f4362g) {
            extendedFloatingActionButton.setVisibility(8);
        }
    }

    @Override // d2.a
    public final void f(Animator animator) {
        w1.g gVar = this.f4337d;
        Animator animator2 = (Animator) gVar.f7056b;
        if (animator2 != null) {
            animator2.cancel();
        }
        gVar.f7056b = animator;
        this.f4362g = false;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f4363h;
        extendedFloatingActionButton.setVisibility(0);
        extendedFloatingActionButton.f3392t = 1;
    }

    @Override // d2.a
    public final void g() {
        this.f4363h.setVisibility(8);
    }

    @Override // d2.a
    public final boolean h() {
        j3 j3Var = ExtendedFloatingActionButton.I;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f4363h;
        int visibility = extendedFloatingActionButton.getVisibility();
        int i4 = extendedFloatingActionButton.f3392t;
        if (visibility == 0) {
            if (i4 != 1) {
                return false;
            }
        } else if (i4 == 2) {
            return false;
        }
        return true;
    }
}
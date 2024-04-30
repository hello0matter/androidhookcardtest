package u1;

import android.animation.ValueAnimator;
import androidx.annotation.VisibleForTesting;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.f;
import com.google.android.material.textfield.i;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6854a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f6855b;

    public /* synthetic */ b(int i4, Object obj) {
        this.f6854a = i4;
        this.f6855b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i4 = this.f6854a;
        Object obj = this.f6855b;
        switch (i4) {
            case 0:
                d dVar = (d) obj;
                dVar.getClass();
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                dVar.f6867j.setAlpha((int) (255.0f * floatValue));
                dVar.f6881x = floatValue;
                return;
            case 1:
                ClippableRoundedCornerLayout clippableRoundedCornerLayout = (ClippableRoundedCornerLayout) obj;
                clippableRoundedCornerLayout.a(clippableRoundedCornerLayout.getLeft(), clippableRoundedCornerLayout.getTop(), clippableRoundedCornerLayout.getRight(), clippableRoundedCornerLayout.getBottom(), ((Float) valueAnimator.getAnimatedValue()).floatValue());
                return;
            case 2:
                int i5 = com.google.android.material.navigation.a.f3691a;
                ((DrawerLayout) obj).setScrimColor(b0.a.e(-1728053248, p1.a.c(com.google.android.material.navigation.a.f3691a, valueAnimator.getAnimatedFraction(), 0)));
                return;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                d.d dVar2 = (d.d) obj;
                float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (dVar2.f4246i != floatValue2) {
                    dVar2.f4246i = floatValue2;
                    dVar2.invalidateSelf();
                    return;
                }
                return;
            case VisibleForTesting.PROTECTED /* 4 */:
                ((f) obj).a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                return;
            default:
                i iVar = (i) obj;
                iVar.getClass();
                iVar.f4074d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                return;
        }
    }
}
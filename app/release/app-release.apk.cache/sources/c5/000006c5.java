package f2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.example.msphone.R;

/* loaded from: classes.dex */
public final class g extends a {

    /* renamed from: g  reason: collision with root package name */
    public final float f4563g;

    /* renamed from: h  reason: collision with root package name */
    public final float f4564h;

    public g(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f4563g = resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_x_distance);
        this.f4564h = resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_y_distance);
    }

    public final AnimatorSet b() {
        AnimatorSet animatorSet = new AnimatorSet();
        View view = this.f4552b;
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(view, View.SCALE_Y, 1.0f));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i4), View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setInterpolator(new u0.b());
        return animatorSet;
    }

    public final void c(float f4) {
        float f5;
        float interpolation = this.f4551a.getInterpolation(f4);
        View view = this.f4552b;
        float width = view.getWidth();
        float height = view.getHeight();
        if (width > 0.0f && height > 0.0f) {
            float a5 = 1.0f - p1.a.a(0.0f, this.f4563g / width, interpolation);
            float a6 = 1.0f - p1.a.a(0.0f, this.f4564h / height, interpolation);
            view.setScaleX(a5);
            view.setPivotY(height);
            view.setScaleY(a6);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                    View childAt = viewGroup.getChildAt(i4);
                    childAt.setPivotY(-childAt.getTop());
                    if (a6 != 0.0f) {
                        f5 = a5 / a6;
                    } else {
                        f5 = 1.0f;
                    }
                    childAt.setScaleY(f5);
                }
            }
        }
    }
}
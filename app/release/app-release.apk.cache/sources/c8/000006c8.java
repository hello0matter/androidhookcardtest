package f2;

import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.r2;
import com.example.msphone.R;
import i0.h0;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class j extends a {

    /* renamed from: g  reason: collision with root package name */
    public final float f4571g;

    /* renamed from: h  reason: collision with root package name */
    public final float f4572h;

    /* renamed from: i  reason: collision with root package name */
    public final float f4573i;

    public j(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f4571g = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
        this.f4572h = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
        this.f4573i = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_y_distance);
    }

    public final void b() {
        if (a() == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        View view = this.f4552b;
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(view, View.SCALE_Y, 1.0f));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i4), View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setDuration(this.f4555e);
        animatorSet.start();
    }

    public final void c(androidx.activity.b bVar, int i4, AnimatorListenerAdapter animatorListenerAdapter, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        boolean z4;
        boolean z5;
        int i5;
        if (bVar.f94d == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        WeakHashMap weakHashMap = y0.f4999a;
        View view = this.f4552b;
        if ((Gravity.getAbsoluteGravity(i4, h0.d(view)) & 3) == 3) {
            z5 = true;
        } else {
            z5 = false;
        }
        float scaleX = view.getScaleX() * view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (z5) {
                i5 = marginLayoutParams.leftMargin;
            } else {
                i5 = marginLayoutParams.rightMargin;
            }
        } else {
            i5 = 0;
        }
        float f4 = scaleX + i5;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (z5) {
            f4 = -f4;
        }
        fArr[0] = f4;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, fArr);
        if (animatorUpdateListener != null) {
            ofFloat.addUpdateListener(animatorUpdateListener);
        }
        ofFloat.setInterpolator(new u0.b());
        ofFloat.setDuration(p1.a.c(this.f4553c, bVar.f93c, this.f4554d));
        ofFloat.addListener(new r2(this, z4, i4));
        ofFloat.addListener(animatorListenerAdapter);
        ofFloat.start();
    }

    public final void d(int i4, float f4, boolean z4) {
        boolean z5;
        float f5;
        float f6;
        float f7;
        float interpolation = this.f4551a.getInterpolation(f4);
        WeakHashMap weakHashMap = y0.f4999a;
        View view = this.f4552b;
        boolean z6 = true;
        if ((Gravity.getAbsoluteGravity(i4, h0.d(view)) & 3) == 3) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z4 != z5) {
            z6 = false;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        float f8 = width;
        if (f8 > 0.0f) {
            float f9 = height;
            if (f9 > 0.0f) {
                float f10 = this.f4571g / f8;
                float f11 = this.f4572h / f8;
                float f12 = this.f4573i / f9;
                if (z5) {
                    f8 = 0.0f;
                }
                view.setPivotX(f8);
                if (!z6) {
                    f11 = -f10;
                }
                float a5 = p1.a.a(0.0f, f11, interpolation);
                float f13 = a5 + 1.0f;
                view.setScaleX(f13);
                float a6 = 1.0f - p1.a.a(0.0f, f12, interpolation);
                view.setScaleY(a6);
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                        View childAt = viewGroup.getChildAt(i5);
                        if (z5) {
                            f5 = childAt.getWidth() + (width - childAt.getRight());
                        } else {
                            f5 = -childAt.getLeft();
                        }
                        childAt.setPivotX(f5);
                        childAt.setPivotY(-childAt.getTop());
                        if (z6) {
                            f6 = 1.0f - a5;
                        } else {
                            f6 = 1.0f;
                        }
                        if (a6 != 0.0f) {
                            f7 = (f13 / a6) * f6;
                        } else {
                            f7 = 1.0f;
                        }
                        childAt.setScaleX(f6);
                        childAt.setScaleY(f7);
                    }
                }
            }
        }
    }
}
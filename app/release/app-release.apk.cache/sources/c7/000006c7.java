package f2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.view.RoundedCorner;
import android.view.View;
import android.view.WindowInsets;
import com.example.msphone.R;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.search.SearchBar;

/* loaded from: classes.dex */
public final class i extends a {

    /* renamed from: g  reason: collision with root package name */
    public final float f4565g;

    /* renamed from: h  reason: collision with root package name */
    public final float f4566h;

    /* renamed from: i  reason: collision with root package name */
    public float f4567i;

    /* renamed from: j  reason: collision with root package name */
    public Rect f4568j;

    /* renamed from: k  reason: collision with root package name */
    public Rect f4569k;

    /* renamed from: l  reason: collision with root package name */
    public Integer f4570l;

    public i(ClippableRoundedCornerLayout clippableRoundedCornerLayout) {
        super(clippableRoundedCornerLayout);
        Resources resources = clippableRoundedCornerLayout.getResources();
        this.f4565g = resources.getDimension(R.dimen.m3_back_progress_main_container_min_edge_gap);
        this.f4566h = resources.getDimension(R.dimen.m3_back_progress_main_container_max_translation_y);
    }

    public final AnimatorSet b(SearchBar searchBar) {
        AnimatorSet animatorSet = new AnimatorSet();
        View view = this.f4552b;
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(view, View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(view, View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, 0.0f));
        animatorSet.addListener(new c1.f(2, this, searchBar));
        return animatorSet;
    }

    public final int c() {
        WindowInsets rootWindowInsets;
        RoundedCorner roundedCorner;
        int i4;
        RoundedCorner roundedCorner2;
        int i5;
        RoundedCorner roundedCorner3;
        int i6;
        RoundedCorner roundedCorner4;
        if (this.f4570l == null) {
            int[] iArr = new int[2];
            View view = this.f4552b;
            view.getLocationOnScreen(iArr);
            int i7 = 0;
            if (iArr[1] == 0 && Build.VERSION.SDK_INT >= 31 && (rootWindowInsets = view.getRootWindowInsets()) != null) {
                roundedCorner = rootWindowInsets.getRoundedCorner(0);
                if (roundedCorner != null) {
                    i4 = roundedCorner.getRadius();
                } else {
                    i4 = 0;
                }
                roundedCorner2 = rootWindowInsets.getRoundedCorner(1);
                if (roundedCorner2 != null) {
                    i5 = roundedCorner2.getRadius();
                } else {
                    i5 = 0;
                }
                int max = Math.max(i4, i5);
                roundedCorner3 = rootWindowInsets.getRoundedCorner(3);
                if (roundedCorner3 != null) {
                    i6 = roundedCorner3.getRadius();
                } else {
                    i6 = 0;
                }
                roundedCorner4 = rootWindowInsets.getRoundedCorner(2);
                if (roundedCorner4 != null) {
                    i7 = roundedCorner4.getRadius();
                }
                i7 = Math.max(max, Math.max(i6, i7));
            }
            this.f4570l = Integer.valueOf(i7);
        }
        return this.f4570l.intValue();
    }
}
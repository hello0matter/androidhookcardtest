package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.example.msphone.R;

@RestrictTo({RestrictTo.Scope.f171c})
/* loaded from: classes.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    public j f598a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayoutCompat f599b;

    /* renamed from: c  reason: collision with root package name */
    public AppCompatSpinner f600c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f601d;

    /* renamed from: e  reason: collision with root package name */
    public int f602e;

    /* renamed from: f  reason: collision with root package name */
    public int f603f;

    /* renamed from: g  reason: collision with root package name */
    public int f604g;

    /* renamed from: h  reason: collision with root package name */
    public int f605h;

    static {
        new DecelerateInterpolator();
    }

    public ScrollingTabContainerView(@NonNull Context context) {
        super(context);
        new r2(this);
        setHorizontalScrollBarEnabled(false);
        f.a a5 = f.a.a(context);
        setContentHeight(a5.c());
        this.f603f = a5.f4443a.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, R.attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.f599b = linearLayoutCompat;
        addView(linearLayoutCompat, new ViewGroup.LayoutParams(-2, -1));
    }

    public final void a() {
        boolean z4;
        AppCompatSpinner appCompatSpinner = this.f600c;
        if (appCompatSpinner != null && appCompatSpinner.getParent() == this) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            return;
        }
        removeView(this.f600c);
        addView(this.f599b, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f600c.getSelectedItemPosition());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        j jVar = this.f598a;
        if (jVar != null) {
            post(jVar);
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        f.a a5 = f.a.a(getContext());
        setContentHeight(a5.c());
        this.f603f = a5.f4443a.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j jVar = this.f598a;
        if (jVar != null) {
            removeCallbacks(jVar);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i4, long j4) {
        ((q2) view).getClass();
        throw null;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        boolean z4;
        int mode = View.MeasureSpec.getMode(i4);
        if (mode == 1073741824) {
            z4 = true;
        } else {
            z4 = false;
        }
        setFillViewport(z4);
        LinearLayoutCompat linearLayoutCompat = this.f599b;
        int childCount = linearLayoutCompat.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.f602e = (int) (View.MeasureSpec.getSize(i4) * 0.4f);
            } else {
                this.f602e = View.MeasureSpec.getSize(i4) / 2;
            }
            this.f602e = Math.min(this.f602e, this.f603f);
        } else {
            this.f602e = -1;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f604g, 1073741824);
        if (!z4 && this.f601d) {
            linearLayoutCompat.measure(0, makeMeasureSpec);
            if (linearLayoutCompat.getMeasuredWidth() > View.MeasureSpec.getSize(i4)) {
                AppCompatSpinner appCompatSpinner = this.f600c;
                if (appCompatSpinner == null || appCompatSpinner.getParent() != this) {
                    if (this.f600c == null) {
                        AppCompatSpinner appCompatSpinner2 = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
                        appCompatSpinner2.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
                        appCompatSpinner2.setOnItemSelectedListener(this);
                        this.f600c = appCompatSpinner2;
                    }
                    removeView(linearLayoutCompat);
                    addView(this.f600c, new ViewGroup.LayoutParams(-2, -1));
                    if (this.f600c.getAdapter() == null) {
                        this.f600c.setAdapter((SpinnerAdapter) new p2(this));
                    }
                    Runnable runnable = this.f598a;
                    if (runnable != null) {
                        removeCallbacks(runnable);
                        this.f598a = null;
                    }
                    this.f600c.setSelection(this.f605h);
                }
                int measuredWidth = getMeasuredWidth();
                super.onMeasure(i4, makeMeasureSpec);
                int measuredWidth2 = getMeasuredWidth();
                if (!z4 && measuredWidth != measuredWidth2) {
                    setTabSelected(this.f605h);
                    return;
                }
            }
        }
        a();
        int measuredWidth3 = getMeasuredWidth();
        super.onMeasure(i4, makeMeasureSpec);
        int measuredWidth22 = getMeasuredWidth();
        if (!z4) {
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }

    public void setAllowCollapse(boolean z4) {
        this.f601d = z4;
    }

    public void setContentHeight(int i4) {
        this.f604g = i4;
        requestLayout();
    }

    public void setTabSelected(int i4) {
        boolean z4;
        this.f605h = i4;
        LinearLayoutCompat linearLayoutCompat = this.f599b;
        int childCount = linearLayoutCompat.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = linearLayoutCompat.getChildAt(i5);
            if (i5 == i4) {
                z4 = true;
            } else {
                z4 = false;
            }
            childAt.setSelected(z4);
            if (z4) {
                View childAt2 = linearLayoutCompat.getChildAt(i4);
                Runnable runnable = this.f598a;
                if (runnable != null) {
                    removeCallbacks(runnable);
                }
                j jVar = new j(1, this, childAt2);
                this.f598a = jVar;
                post(jVar);
            }
        }
        AppCompatSpinner appCompatSpinner = this.f600c;
        if (appCompatSpinner != null && i4 >= 0) {
            appCompatSpinner.setSelection(i4);
        }
    }
}
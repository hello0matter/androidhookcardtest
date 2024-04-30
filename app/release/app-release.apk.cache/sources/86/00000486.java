package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import com.example.msphone.R;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.i0;
import g.p;
import i0.g0;
import i0.m0;
import i0.y0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {

    /* renamed from: b0  reason: collision with root package name */
    public static final ImageView.ScaleType[] f2945b0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    public Integer T;
    public boolean U;
    public boolean V;
    public ImageView.ScaleType W;

    /* renamed from: a0  reason: collision with root package name */
    public Boolean f2946a0;

    public MaterialToolbar(@NonNull Context context) {
        this(context, null);
    }

    @Nullable
    public ImageView.ScaleType getLogoScaleType() {
        return this.W;
    }

    @Nullable
    @ColorInt
    public Integer getNavigationIconTint() {
        return this.T;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public final void n(int i4) {
        Menu menu = getMenu();
        boolean z4 = menu instanceof p;
        if (z4) {
            ((p) menu).y();
        }
        super.n(i4);
        if (z4) {
            ((p) menu).x();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.common.collect.c.Q1(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        TextView textView;
        TextView textView2;
        ImageView imageView;
        Drawable drawable;
        super.onLayout(z4, i4, i5, i6, i7);
        int i8 = 0;
        ImageView imageView2 = null;
        if (this.U || this.V) {
            ArrayList c4 = i0.c(this, getTitle());
            boolean isEmpty = c4.isEmpty();
            v.c cVar = i0.f3555a;
            if (isEmpty) {
                textView = null;
            } else {
                textView = (TextView) Collections.min(c4, cVar);
            }
            ArrayList c5 = i0.c(this, getSubtitle());
            if (c5.isEmpty()) {
                textView2 = null;
            } else {
                textView2 = (TextView) Collections.max(c5, cVar);
            }
            if (textView != null || textView2 != null) {
                int measuredWidth = getMeasuredWidth();
                int i9 = measuredWidth / 2;
                int paddingLeft = getPaddingLeft();
                int paddingRight = measuredWidth - getPaddingRight();
                for (int i10 = 0; i10 < getChildCount(); i10++) {
                    View childAt = getChildAt(i10);
                    if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                        if (childAt.getRight() < i9 && childAt.getRight() > paddingLeft) {
                            paddingLeft = childAt.getRight();
                        }
                        if (childAt.getLeft() > i9 && childAt.getLeft() < paddingRight) {
                            paddingRight = childAt.getLeft();
                        }
                    }
                }
                Pair pair = new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
                if (this.U && textView != null) {
                    w(textView, pair);
                }
                if (this.V && textView2 != null) {
                    w(textView2, pair);
                }
            }
        }
        Drawable logo = getLogo();
        if (logo != null) {
            while (true) {
                if (i8 >= getChildCount()) {
                    break;
                }
                View childAt2 = getChildAt(i8);
                if ((childAt2 instanceof ImageView) && (drawable = (imageView = (ImageView) childAt2).getDrawable()) != null && drawable.getConstantState() != null && drawable.getConstantState().equals(logo.getConstantState())) {
                    imageView2 = imageView;
                    break;
                }
                i8++;
            }
        }
        if (imageView2 != null) {
            Boolean bool = this.f2946a0;
            if (bool != null) {
                imageView2.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.W;
            if (scaleType != null) {
                imageView2.setScaleType(scaleType);
            }
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f4) {
        super.setElevation(f4);
        com.google.common.collect.c.O1(this, f4);
    }

    public void setLogoAdjustViewBounds(boolean z4) {
        Boolean bool = this.f2946a0;
        if (bool == null || bool.booleanValue() != z4) {
            this.f2946a0 = Boolean.valueOf(z4);
            requestLayout();
        }
    }

    public void setLogoScaleType(@NonNull ImageView.ScaleType scaleType) {
        if (this.W != scaleType) {
            this.W = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null && this.T != null) {
            drawable = drawable.mutate();
            c0.b.g(drawable, this.T.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(@ColorInt int i4) {
        this.T = Integer.valueOf(i4);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z4) {
        if (this.V != z4) {
            this.V = z4;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z4) {
        if (this.U != z4) {
            this.U = z4;
            requestLayout();
        }
    }

    public final void w(TextView textView, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = textView.getMeasuredWidth();
        int i4 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i5 = measuredWidth2 + i4;
        int max = Math.max(Math.max(((Integer) pair.first).intValue() - i4, 0), Math.max(i5 - ((Integer) pair.second).intValue(), 0));
        if (max > 0) {
            i4 += max;
            i5 -= max;
            textView.measure(View.MeasureSpec.makeMeasureSpec(i5 - i4, 1073741824), textView.getMeasuredHeightAndState());
        }
        textView.layout(i4, textView.getTop(), i5, textView.getBottom());
    }

    public MaterialToolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public MaterialToolbar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(p2.a.a(context, attributeSet, i4, 2131756118), attributeSet, i4);
        Context context2 = getContext();
        TypedArray d4 = h0.d(context2, attributeSet, o1.a.K, i4, 2131756118, new int[0]);
        if (d4.hasValue(2)) {
            setNavigationIconTint(d4.getColor(2, -1));
        }
        this.U = d4.getBoolean(4, false);
        this.V = d4.getBoolean(3, false);
        int i5 = d4.getInt(1, -1);
        if (i5 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = f2945b0;
            if (i5 < scaleTypeArr.length) {
                this.W = scaleTypeArr[i5];
            }
        }
        if (d4.hasValue(0)) {
            this.f2946a0 = Boolean.valueOf(d4.getBoolean(0, false));
        }
        d4.recycle();
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            l2.j jVar = new l2.j();
            jVar.o(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            jVar.l(context2);
            WeakHashMap weakHashMap = y0.f4999a;
            jVar.n(m0.i(this));
            g0.q(this, jVar);
        }
    }
}
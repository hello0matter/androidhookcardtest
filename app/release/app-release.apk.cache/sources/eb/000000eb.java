package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.example.msphone.R;
import java.util.WeakHashMap;

@RestrictTo({RestrictTo.Scope.f171c})
/* loaded from: classes.dex */
public class ActionBarContextView extends b {

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f415i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f416j;

    /* renamed from: k  reason: collision with root package name */
    public View f417k;

    /* renamed from: l  reason: collision with root package name */
    public View f418l;

    /* renamed from: m  reason: collision with root package name */
    public View f419m;

    /* renamed from: n  reason: collision with root package name */
    public LinearLayout f420n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f421o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f422p;

    /* renamed from: q  reason: collision with root package name */
    public final int f423q;

    /* renamed from: r  reason: collision with root package name */
    public final int f424r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f425s;

    /* renamed from: t  reason: collision with root package name */
    public final int f426t;

    public ActionBarContextView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f(f.c r7) {
        /*
            r6 = this;
            android.view.View r0 = r6.f417k
            r1 = 0
            if (r0 != 0) goto L19
            android.content.Context r0 = r6.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r2 = r6.f426t
            android.view.View r0 = r0.inflate(r2, r6, r1)
            r6.f417k = r0
        L15:
            r6.addView(r0)
            goto L22
        L19:
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != 0) goto L22
            android.view.View r0 = r6.f417k
            goto L15
        L22:
            android.view.View r0 = r6.f417k
            r2 = 2131230783(0x7f08003f, float:1.8077629E38)
            android.view.View r0 = r0.findViewById(r2)
            r6.f418l = r0
            androidx.appcompat.widget.d r2 = new androidx.appcompat.widget.d
            r2.<init>(r6, r7)
            r0.setOnClickListener(r2)
            g.p r7 = r7.d()
            androidx.appcompat.widget.n r0 = r6.f710d
            if (r0 == 0) goto L4f
            r0.f()
            androidx.appcompat.widget.h r0 = r0.f849u
            if (r0 == 0) goto L4f
            boolean r2 = r0.b()
            if (r2 == 0) goto L4f
            g.y r0 = r0.f4606j
            r0.dismiss()
        L4f:
            androidx.appcompat.widget.n r0 = new androidx.appcompat.widget.n
            android.content.Context r2 = r6.getContext()
            r0.<init>(r2)
            r6.f710d = r0
            r2 = 1
            r0.f841m = r2
            r0.f842n = r2
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r3 = -2
            r4 = -1
            r0.<init>(r3, r4)
            androidx.appcompat.widget.n r3 = r6.f710d
            android.content.Context r4 = r6.f708b
            r7.b(r3, r4)
            androidx.appcompat.widget.n r7 = r6.f710d
            g.f0 r3 = r7.f4616h
            if (r3 != 0) goto L87
            android.view.LayoutInflater r4 = r7.f4612d
            int r5 = r7.f4614f
            android.view.View r1 = r4.inflate(r5, r6, r1)
            g.f0 r1 = (g.f0) r1
            r7.f4616h = r1
            g.p r4 = r7.f4611c
            r1.d(r4)
            r7.m(r2)
        L87:
            g.f0 r1 = r7.f4616h
            if (r3 == r1) goto L91
            r2 = r1
            androidx.appcompat.widget.ActionMenuView r2 = (androidx.appcompat.widget.ActionMenuView) r2
            r2.setPresenter(r7)
        L91:
            androidx.appcompat.widget.ActionMenuView r1 = (androidx.appcompat.widget.ActionMenuView) r1
            r6.f709c = r1
            java.util.WeakHashMap r7 = i0.y0.f4999a
            r7 = 0
            i0.g0.q(r1, r7)
            androidx.appcompat.widget.ActionMenuView r7 = r6.f709c
            r6.addView(r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContextView.f(f.c):void");
    }

    public final void g() {
        if (this.f420n == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f420n = linearLayout;
            this.f421o = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.f422p = (TextView) this.f420n.findViewById(R.id.action_bar_subtitle);
            int i4 = this.f423q;
            if (i4 != 0) {
                this.f421o.setTextAppearance(getContext(), i4);
            }
            int i5 = this.f424r;
            if (i5 != 0) {
                this.f422p.setTextAppearance(getContext(), i5);
            }
        }
        this.f421o.setText(this.f415i);
        this.f422p.setText(this.f416j);
        boolean z4 = !TextUtils.isEmpty(this.f415i);
        boolean z5 = !TextUtils.isEmpty(this.f416j);
        int i6 = 8;
        this.f422p.setVisibility(z5 ? 0 : 8);
        LinearLayout linearLayout2 = this.f420n;
        if (z4 || z5) {
            i6 = 0;
        }
        linearLayout2.setVisibility(i6);
        if (this.f420n.getParent() == null) {
            addView(this.f420n);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public int getAnimatedVisibility() {
        if (this.f712f != null) {
            return this.f707a.f689b;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f711e;
    }

    public CharSequence getSubtitle() {
        return this.f416j;
    }

    public CharSequence getTitle() {
        return this.f415i;
    }

    public final void h() {
        removeAllViews();
        this.f419m = null;
        this.f709c = null;
        this.f710d = null;
        View view = this.f418l;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        n nVar = this.f710d;
        if (nVar != null) {
            nVar.f();
            h hVar = this.f710d.f849u;
            if (hVar != null && hVar.b()) {
                hVar.f4606j.dismiss();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int paddingLeft;
        int paddingRight;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean a5 = e4.a(this);
        if (a5) {
            paddingLeft = (i6 - i4) - getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i7 - i5) - getPaddingTop()) - getPaddingBottom();
        View view = this.f417k;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f417k.getLayoutParams();
            if (a5) {
                i8 = marginLayoutParams.rightMargin;
            } else {
                i8 = marginLayoutParams.leftMargin;
            }
            if (a5) {
                i9 = marginLayoutParams.leftMargin;
            } else {
                i9 = marginLayoutParams.rightMargin;
            }
            if (a5) {
                i10 = paddingLeft - i8;
            } else {
                i10 = paddingLeft + i8;
            }
            int d4 = b.d(i10, paddingTop, paddingTop2, this.f417k, a5) + i10;
            if (a5) {
                i11 = d4 - i9;
            } else {
                i11 = d4 + i9;
            }
            paddingLeft = i11;
        }
        LinearLayout linearLayout = this.f420n;
        if (linearLayout != null && this.f419m == null && linearLayout.getVisibility() != 8) {
            paddingLeft += b.d(paddingLeft, paddingTop, paddingTop2, this.f420n, a5);
        }
        View view2 = this.f419m;
        if (view2 != null) {
            b.d(paddingLeft, paddingTop, paddingTop2, view2, a5);
        }
        if (a5) {
            paddingRight = getPaddingLeft();
        } else {
            paddingRight = (i6 - i4) - getPaddingRight();
        }
        ActionMenuView actionMenuView = this.f709c;
        if (actionMenuView != null) {
            b.d(paddingRight, paddingTop, paddingTop2, actionMenuView, !a5);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        if (View.MeasureSpec.getMode(i4) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
        }
        if (View.MeasureSpec.getMode(i5) == 0) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        int size = View.MeasureSpec.getSize(i4);
        int i6 = this.f711e;
        if (i6 <= 0) {
            i6 = View.MeasureSpec.getSize(i5);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i7 = i6 - paddingBottom;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE);
        View view = this.f417k;
        if (view != null) {
            int c4 = b.c(view, paddingLeft, makeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f417k.getLayoutParams();
            paddingLeft = c4 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f709c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = b.c(this.f709c, paddingLeft, makeMeasureSpec);
        }
        LinearLayout linearLayout = this.f420n;
        if (linearLayout != null && this.f419m == null) {
            if (this.f425s) {
                this.f420n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                int measuredWidth = this.f420n.getMeasuredWidth();
                boolean z4 = measuredWidth <= paddingLeft;
                if (z4) {
                    paddingLeft -= measuredWidth;
                }
                this.f420n.setVisibility(z4 ? 0 : 8);
            } else {
                paddingLeft = b.c(linearLayout, paddingLeft, makeMeasureSpec);
            }
        }
        View view2 = this.f419m;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i8 = layoutParams.width;
            int i9 = i8 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i8 >= 0) {
                paddingLeft = Math.min(i8, paddingLeft);
            }
            int i10 = layoutParams.height;
            int i11 = i10 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i10 >= 0) {
                i7 = Math.min(i10, i7);
            }
            this.f419m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i9), View.MeasureSpec.makeMeasureSpec(i7, i11));
        }
        if (this.f711e <= 0) {
            int childCount = getChildCount();
            i6 = 0;
            for (int i12 = 0; i12 < childCount; i12++) {
                int measuredHeight = getChildAt(i12).getMeasuredHeight() + paddingBottom;
                if (measuredHeight > i6) {
                    i6 = measuredHeight;
                }
            }
        }
        setMeasuredDimension(size, i6);
    }

    @Override // androidx.appcompat.widget.b
    public void setContentHeight(int i4) {
        this.f711e = i4;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f419m;
        if (view2 != null) {
            removeView(view2);
        }
        this.f419m = view;
        if (view != null && (linearLayout = this.f420n) != null) {
            removeView(linearLayout);
            this.f420n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f416j = charSequence;
        g();
    }

    public void setTitle(CharSequence charSequence) {
        this.f415i = charSequence;
        g();
        i0.y0.q(this, charSequence);
    }

    public void setTitleOptional(boolean z4) {
        if (z4 != this.f425s) {
            requestLayout();
        }
        this.f425s = z4;
    }

    @Override // androidx.appcompat.widget.b, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i4) {
        super.setVisibility(i4);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.actionModeStyle);
    }

    public ActionBarContextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        int resourceId;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.f2546d, i4, 0);
        Drawable drawable = (!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0) ? obtainStyledAttributes.getDrawable(0) : com.google.common.collect.c.t0(context, resourceId);
        WeakHashMap weakHashMap = i0.y0.f4999a;
        i0.g0.q(this, drawable);
        this.f423q = obtainStyledAttributes.getResourceId(5, 0);
        this.f424r = obtainStyledAttributes.getResourceId(4, 0);
        this.f711e = obtainStyledAttributes.getLayoutDimension(3, 0);
        this.f426t = obtainStyledAttributes.getResourceId(2, R.layout.abc_action_mode_close_item_material);
        obtainStyledAttributes.recycle();
    }
}
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.LinearLayoutCompat;

/* loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements g.o, g.f0 {
    public q A;

    /* renamed from: p  reason: collision with root package name */
    public g.p f454p;

    /* renamed from: q  reason: collision with root package name */
    public Context f455q;

    /* renamed from: r  reason: collision with root package name */
    public int f456r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f457s;

    /* renamed from: t  reason: collision with root package name */
    public n f458t;

    /* renamed from: u  reason: collision with root package name */
    public g.c0 f459u;

    /* renamed from: v  reason: collision with root package name */
    public g.n f460v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f461w;

    /* renamed from: x  reason: collision with root package name */
    public int f462x;

    /* renamed from: y  reason: collision with root package name */
    public final int f463y;

    /* renamed from: z  reason: collision with root package name */
    public final int f464z;

    /* loaded from: classes.dex */
    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f465a;

        /* renamed from: b  reason: collision with root package name */
        public int f466b;

        /* renamed from: c  reason: collision with root package name */
        public int f467c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f468d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f469e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f470f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public ActionMenuView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.appcompat.widget.ActionMenuView$LayoutParams, android.widget.LinearLayout$LayoutParams] */
    public static LayoutParams l() {
        ?? layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.f465a = false;
        ((LinearLayout.LayoutParams) layoutParams).gravity = 16;
        return layoutParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.appcompat.widget.ActionMenuView$LayoutParams, android.widget.LinearLayout$LayoutParams] */
    public static LayoutParams m(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (layoutParams != null) {
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams3 = (LayoutParams) layoutParams;
                ?? layoutParams4 = new LinearLayout.LayoutParams((ViewGroup.LayoutParams) layoutParams3);
                layoutParams4.f465a = layoutParams3.f465a;
                layoutParams2 = layoutParams4;
            } else {
                layoutParams2 = new LinearLayout.LayoutParams(layoutParams);
            }
            if (((LinearLayout.LayoutParams) layoutParams2).gravity <= 0) {
                ((LinearLayout.LayoutParams) layoutParams2).gravity = 16;
            }
            return layoutParams2;
        }
        return l();
    }

    @Override // g.o
    public final boolean a(g.r rVar) {
        return this.f454p.q(rVar, null, 0);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // g.f0
    public final void d(g.p pVar) {
        this.f454p = pVar;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return l();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Menu getMenu() {
        if (this.f454p == null) {
            Context context = getContext();
            g.p pVar = new g.p(context);
            this.f454p = pVar;
            pVar.f4699e = new androidx.appcompat.app.o0(5, this);
            n nVar = new n(context);
            this.f458t = nVar;
            nVar.f841m = true;
            nVar.f842n = true;
            g.c0 c0Var = this.f459u;
            g.c0 c0Var2 = c0Var;
            if (c0Var == null) {
                c0Var2 = new Object();
            }
            nVar.f4613e = c0Var2;
            this.f454p.b(nVar, this.f455q);
            n nVar2 = this.f458t;
            nVar2.f4616h = this;
            this.f454p = nVar2.f4611c;
        }
        return this.f454p;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        getMenu();
        n nVar = this.f458t;
        l lVar = nVar.f838j;
        if (lVar != null) {
            return lVar.getDrawable();
        }
        if (nVar.f840l) {
            return nVar.f839k;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.f456r;
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    public final /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams h() {
        return l();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    public final LinearLayoutCompat.LayoutParams i(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    public final /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams j(ViewGroup.LayoutParams layoutParams) {
        return m(layoutParams);
    }

    public final boolean n(int i4) {
        boolean z4 = false;
        if (i4 == 0) {
            return false;
        }
        View childAt = getChildAt(i4 - 1);
        View childAt2 = getChildAt(i4);
        if (i4 < getChildCount() && (childAt instanceof o)) {
            z4 = ((o) childAt).a();
        }
        return (i4 <= 0 || !(childAt2 instanceof o)) ? z4 : z4 | ((o) childAt2).b();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        n nVar = this.f458t;
        if (nVar != null) {
            nVar.m(false);
            if (this.f458t.k()) {
                this.f458t.f();
                this.f458t.o();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        n nVar = this.f458t;
        if (nVar != null) {
            nVar.f();
            h hVar = nVar.f849u;
            if (hVar != null && hVar.b()) {
                hVar.f4606j.dismiss();
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int width;
        int i8;
        if (!this.f461w) {
            super.onLayout(z4, i4, i5, i6, i7);
            return;
        }
        int childCount = getChildCount();
        int i9 = (i7 - i5) / 2;
        int dividerWidth = getDividerWidth();
        int i10 = i6 - i4;
        int paddingRight = (i10 - getPaddingRight()) - getPaddingLeft();
        boolean a5 = e4.a(this);
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f465a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (n(i13)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a5) {
                        i8 = getPaddingLeft() + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        width = i8 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        i8 = width - measuredWidth;
                    }
                    int i14 = i9 - (measuredHeight / 2);
                    childAt.layout(i8, i14, width, measuredHeight + i14);
                    paddingRight -= measuredWidth;
                    i11 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams).leftMargin) + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    n(i13);
                    i12++;
                }
            }
        }
        if (childCount == 1 && i11 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i15 = (i10 / 2) - (measuredWidth2 / 2);
            int i16 = i9 - (measuredHeight2 / 2);
            childAt2.layout(i15, i16, measuredWidth2 + i15, measuredHeight2 + i16);
            return;
        }
        int i17 = i12 - (i11 ^ 1);
        int max = Math.max(0, i17 > 0 ? paddingRight / i17 : 0);
        if (a5) {
            int width2 = getWidth() - getPaddingRight();
            for (int i18 = 0; i18 < childCount; i18++) {
                View childAt3 = getChildAt(i18);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.f465a) {
                    int i19 = width2 - ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i20 = i9 - (measuredHeight3 / 2);
                    childAt3.layout(i19 - measuredWidth3, i20, i19, measuredHeight3 + i20);
                    width2 = i19 - ((measuredWidth3 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt4 = getChildAt(i21);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.f465a) {
                int i22 = paddingLeft + ((LinearLayout.LayoutParams) layoutParams3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i23 = i9 - (measuredHeight4 / 2);
                childAt4.layout(i22, i23, i22 + measuredWidth4, measuredHeight4 + i23);
                paddingLeft = measuredWidth4 + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + max + i22;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v26 */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i4, int i5) {
        boolean z4;
        int i6;
        boolean z5;
        int i7;
        int i8;
        boolean z6;
        boolean z7;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        ?? r12;
        boolean z8;
        int i14;
        int i15;
        int i16;
        ActionMenuItemView actionMenuItemView;
        boolean z9;
        int i17;
        boolean z10;
        g.p pVar;
        boolean z11 = this.f461w;
        if (View.MeasureSpec.getMode(i4) == 1073741824) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f461w = z4;
        if (z11 != z4) {
            this.f462x = 0;
        }
        int size = View.MeasureSpec.getSize(i4);
        if (this.f461w && (pVar = this.f454p) != null && size != this.f462x) {
            this.f462x = size;
            pVar.p(true);
        }
        int childCount = getChildCount();
        if (this.f461w && childCount > 0) {
            int mode = View.MeasureSpec.getMode(i5);
            int size2 = View.MeasureSpec.getSize(i4);
            int size3 = View.MeasureSpec.getSize(i5);
            int paddingRight = getPaddingRight() + getPaddingLeft();
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, paddingBottom, -2);
            int i18 = size2 - paddingRight;
            int i19 = this.f463y;
            int i20 = i18 / i19;
            int i21 = i18 % i19;
            if (i20 == 0) {
                setMeasuredDimension(i18, 0);
                return;
            }
            int i22 = (i21 / i20) + i19;
            int childCount2 = getChildCount();
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            boolean z12 = false;
            int i26 = 0;
            int i27 = 0;
            long j4 = 0;
            while (true) {
                i6 = this.f464z;
                if (i25 >= childCount2) {
                    break;
                }
                View childAt = getChildAt(i25);
                int i28 = size3;
                if (childAt.getVisibility() == 8) {
                    i15 = i18;
                    i16 = paddingBottom;
                } else {
                    boolean z13 = childAt instanceof ActionMenuItemView;
                    int i29 = i23 + 1;
                    if (z13) {
                        childAt.setPadding(i6, 0, i6, 0);
                    }
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    layoutParams.f470f = false;
                    layoutParams.f467c = 0;
                    layoutParams.f466b = 0;
                    layoutParams.f468d = false;
                    ((LinearLayout.LayoutParams) layoutParams).leftMargin = 0;
                    ((LinearLayout.LayoutParams) layoutParams).rightMargin = 0;
                    if (z13 && (!TextUtils.isEmpty(((ActionMenuItemView) childAt).getText()))) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    layoutParams.f469e = z8;
                    if (layoutParams.f465a) {
                        i14 = 1;
                    } else {
                        i14 = i20;
                    }
                    LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                    i15 = i18;
                    i16 = paddingBottom;
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - paddingBottom, View.MeasureSpec.getMode(childMeasureSpec));
                    if (z13) {
                        actionMenuItemView = (ActionMenuItemView) childAt;
                    } else {
                        actionMenuItemView = null;
                    }
                    if (actionMenuItemView != null && (!TextUtils.isEmpty(actionMenuItemView.getText()))) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    if (i14 > 0 && (!z9 || i14 >= 2)) {
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(i14 * i22, Integer.MIN_VALUE), makeMeasureSpec);
                        int measuredWidth = childAt.getMeasuredWidth();
                        i17 = measuredWidth / i22;
                        if (measuredWidth % i22 != 0) {
                            i17++;
                        }
                        if (z9 && i17 < 2) {
                            i17 = 2;
                        }
                    } else {
                        i17 = 0;
                    }
                    if (!layoutParams2.f465a && z9) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    layoutParams2.f468d = z10;
                    layoutParams2.f466b = i17;
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i17 * i22, 1073741824), makeMeasureSpec);
                    i24 = Math.max(i24, i17);
                    if (layoutParams.f468d) {
                        i26++;
                    }
                    if (layoutParams.f465a) {
                        z12 = true;
                    }
                    i20 -= i17;
                    i27 = Math.max(i27, childAt.getMeasuredHeight());
                    if (i17 == 1) {
                        j4 |= 1 << i25;
                    }
                    i23 = i29;
                }
                i25++;
                size3 = i28;
                paddingBottom = i16;
                i18 = i15;
            }
            int i30 = i18;
            int i31 = size3;
            int i32 = i27;
            if (z12 && i23 == 2) {
                z5 = true;
            } else {
                z5 = false;
            }
            boolean z14 = false;
            while (i26 > 0 && i20 > 0) {
                int i33 = Integer.MAX_VALUE;
                int i34 = 0;
                int i35 = 0;
                long j5 = 0;
                while (i35 < childCount2) {
                    int i36 = i32;
                    LayoutParams layoutParams3 = (LayoutParams) getChildAt(i35).getLayoutParams();
                    boolean z15 = z14;
                    if (layoutParams3.f468d) {
                        int i37 = layoutParams3.f466b;
                        if (i37 < i33) {
                            j5 = 1 << i35;
                            i33 = i37;
                            i34 = 1;
                        } else if (i37 == i33) {
                            i34++;
                            j5 |= 1 << i35;
                        }
                    }
                    i35++;
                    z14 = z15;
                    i32 = i36;
                }
                i8 = i32;
                z6 = z14;
                j4 |= j5;
                if (i34 > i20) {
                    i7 = mode;
                    break;
                }
                int i38 = i33 + 1;
                int i39 = 0;
                while (i39 < childCount2) {
                    View childAt2 = getChildAt(i39);
                    LayoutParams layoutParams4 = (LayoutParams) childAt2.getLayoutParams();
                    int i40 = mode;
                    int i41 = childMeasureSpec;
                    int i42 = childCount2;
                    long j6 = 1 << i39;
                    if ((j5 & j6) == 0) {
                        if (layoutParams4.f466b == i38) {
                            j4 |= j6;
                        }
                    } else {
                        if (z5 && layoutParams4.f469e) {
                            r12 = 1;
                            r12 = 1;
                            if (i20 == 1) {
                                childAt2.setPadding(i6 + i22, 0, i6, 0);
                            }
                        } else {
                            r12 = 1;
                        }
                        layoutParams4.f466b += r12;
                        layoutParams4.f470f = r12;
                        i20--;
                    }
                    i39++;
                    childMeasureSpec = i41;
                    mode = i40;
                    childCount2 = i42;
                }
                i32 = i8;
                z14 = true;
            }
            i7 = mode;
            i8 = i32;
            z6 = z14;
            int i43 = childMeasureSpec;
            int i44 = childCount2;
            if (!z12 && i23 == 1) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (i20 <= 0 || j4 == 0 || (i20 >= i23 - 1 && !z7 && i24 <= 1)) {
                i9 = i44;
            } else {
                float bitCount = Long.bitCount(j4);
                if (!z7) {
                    if ((j4 & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).f469e) {
                        bitCount -= 0.5f;
                    }
                    int i45 = i44 - 1;
                    if ((j4 & (1 << i45)) != 0 && !((LayoutParams) getChildAt(i45).getLayoutParams()).f469e) {
                        bitCount -= 0.5f;
                    }
                }
                if (bitCount > 0.0f) {
                    i13 = (int) ((i20 * i22) / bitCount);
                } else {
                    i13 = 0;
                }
                i9 = i44;
                for (int i46 = 0; i46 < i9; i46++) {
                    if ((j4 & (1 << i46)) != 0) {
                        View childAt3 = getChildAt(i46);
                        LayoutParams layoutParams5 = (LayoutParams) childAt3.getLayoutParams();
                        if (childAt3 instanceof ActionMenuItemView) {
                            layoutParams5.f467c = i13;
                            layoutParams5.f470f = true;
                            if (i46 == 0 && !layoutParams5.f469e) {
                                ((LinearLayout.LayoutParams) layoutParams5).leftMargin = (-i13) / 2;
                            }
                            z6 = true;
                        } else if (layoutParams5.f465a) {
                            layoutParams5.f467c = i13;
                            layoutParams5.f470f = true;
                            ((LinearLayout.LayoutParams) layoutParams5).rightMargin = (-i13) / 2;
                            z6 = true;
                        } else {
                            if (i46 != 0) {
                                ((LinearLayout.LayoutParams) layoutParams5).leftMargin = i13 / 2;
                            }
                            if (i46 != i9 - 1) {
                                ((LinearLayout.LayoutParams) layoutParams5).rightMargin = i13 / 2;
                            }
                        }
                    }
                }
            }
            if (z6) {
                int i47 = 0;
                while (i47 < i9) {
                    View childAt4 = getChildAt(i47);
                    LayoutParams layoutParams6 = (LayoutParams) childAt4.getLayoutParams();
                    if (!layoutParams6.f470f) {
                        i12 = i43;
                    } else {
                        i12 = i43;
                        childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams6.f466b * i22) + layoutParams6.f467c, 1073741824), i12);
                    }
                    i47++;
                    i43 = i12;
                }
            }
            if (i7 != 1073741824) {
                i11 = i30;
                i10 = i8;
            } else {
                i10 = i31;
                i11 = i30;
            }
            setMeasuredDimension(i11, i10);
            return;
        }
        for (int i48 = 0; i48 < childCount; i48++) {
            LayoutParams layoutParams7 = (LayoutParams) getChildAt(i48).getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams7).rightMargin = 0;
            ((LinearLayout.LayoutParams) layoutParams7).leftMargin = 0;
        }
        super.onMeasure(i4, i5);
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setExpandedActionViewsExclusive(boolean z4) {
        this.f458t.f846r = z4;
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setMenuCallbacks(g.c0 c0Var, g.n nVar) {
        this.f459u = c0Var;
        this.f460v = nVar;
    }

    public void setOnMenuItemClickListener(q qVar) {
        this.A = qVar;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        getMenu();
        n nVar = this.f458t;
        l lVar = nVar.f838j;
        if (lVar != null) {
            lVar.setImageDrawable(drawable);
            return;
        }
        nVar.f840l = true;
        nVar.f839k = drawable;
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setOverflowReserved(boolean z4) {
        this.f457s = z4;
    }

    public void setPopupTheme(@StyleRes int i4) {
        if (this.f456r != i4) {
            this.f456r = i4;
            if (i4 == 0) {
                this.f455q = getContext();
            } else {
                this.f455q = new ContextThemeWrapper(getContext(), i4);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.f169a})
    public void setPresenter(n nVar) {
        this.f458t = nVar;
        nVar.f4616h = this;
        this.f454p = nVar.f4611c;
    }

    public ActionMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f4 = context.getResources().getDisplayMetrics().density;
        this.f463y = (int) (56.0f * f4);
        this.f464z = (int) (f4 * 4.0f);
        this.f455q = context;
        this.f456r = 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m(layoutParams);
    }
}
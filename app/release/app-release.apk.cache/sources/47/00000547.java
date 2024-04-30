package com.google.android.material.navigation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.v2;
import androidx.recyclerview.widget.i0;
import androidx.viewpager2.widget.q;
import com.example.msphone.R;
import g.e0;
import g.r;
import i0.a0;
import i0.g0;
import i0.o0;
import i0.y0;
import java.util.WeakHashMap;

@RestrictTo({RestrictTo.Scope.f170b})
/* loaded from: classes.dex */
public abstract class NavigationBarItemView extends FrameLayout implements e0 {
    public static final int[] G = {16842912};
    public static final c H = new Object();
    public static final d I = new Object();
    public boolean A;
    public int B;
    public int C;
    public boolean D;
    public int E;
    public q1.a F;

    /* renamed from: a  reason: collision with root package name */
    public boolean f3615a;

    /* renamed from: b  reason: collision with root package name */
    public ColorStateList f3616b;

    /* renamed from: c  reason: collision with root package name */
    public Drawable f3617c;

    /* renamed from: d  reason: collision with root package name */
    public int f3618d;

    /* renamed from: e  reason: collision with root package name */
    public int f3619e;

    /* renamed from: f  reason: collision with root package name */
    public int f3620f;

    /* renamed from: g  reason: collision with root package name */
    public float f3621g;

    /* renamed from: h  reason: collision with root package name */
    public float f3622h;

    /* renamed from: i  reason: collision with root package name */
    public float f3623i;

    /* renamed from: j  reason: collision with root package name */
    public int f3624j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f3625k;

    /* renamed from: l  reason: collision with root package name */
    public final FrameLayout f3626l;

    /* renamed from: m  reason: collision with root package name */
    public final View f3627m;

    /* renamed from: n  reason: collision with root package name */
    public final ImageView f3628n;

    /* renamed from: o  reason: collision with root package name */
    public final ViewGroup f3629o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f3630p;

    /* renamed from: q  reason: collision with root package name */
    public final TextView f3631q;

    /* renamed from: r  reason: collision with root package name */
    public int f3632r;

    /* renamed from: s  reason: collision with root package name */
    public int f3633s;

    /* renamed from: t  reason: collision with root package name */
    public r f3634t;

    /* renamed from: u  reason: collision with root package name */
    public ColorStateList f3635u;

    /* renamed from: v  reason: collision with root package name */
    public Drawable f3636v;

    /* renamed from: w  reason: collision with root package name */
    public Drawable f3637w;

    /* renamed from: x  reason: collision with root package name */
    public ValueAnimator f3638x;

    /* renamed from: y  reason: collision with root package name */
    public c f3639y;

    /* renamed from: z  reason: collision with root package name */
    public float f3640z;

    public NavigationBarItemView(@NonNull Context context) {
        super(context);
        this.f3615a = false;
        this.f3632r = -1;
        this.f3633s = 0;
        this.f3639y = H;
        this.f3640z = 0.0f;
        this.A = false;
        this.B = 0;
        this.C = 0;
        this.D = false;
        this.E = 0;
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.f3626l = (FrameLayout) findViewById(R.id.navigation_bar_item_icon_container);
        this.f3627m = findViewById(R.id.navigation_bar_item_active_indicator_view);
        ImageView imageView = (ImageView) findViewById(R.id.navigation_bar_item_icon_view);
        this.f3628n = imageView;
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.navigation_bar_item_labels_group);
        this.f3629o = viewGroup;
        TextView textView = (TextView) findViewById(R.id.navigation_bar_item_small_label_view);
        this.f3630p = textView;
        TextView textView2 = (TextView) findViewById(R.id.navigation_bar_item_large_label_view);
        this.f3631q = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.f3618d = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.f3619e = viewGroup.getPaddingBottom();
        this.f3620f = getResources().getDimensionPixelSize(R.dimen.m3_navigation_item_active_indicator_label_padding);
        WeakHashMap weakHashMap = y0.f4999a;
        g0.s(textView, 2);
        g0.s(textView2, 2);
        setFocusable(true);
        a(textView.getTextSize(), textView2.getTextSize());
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new v2(1, this));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void f(android.widget.TextView r4, int r5) {
        /*
            r4.setTextAppearance(r5)
            android.content.Context r0 = r4.getContext()
            r1 = 0
            if (r5 != 0) goto Lc
        La:
            r5 = r1
            goto L4c
        Lc:
            int[] r2 = o1.a.f5943d0
            android.content.res.TypedArray r5 = r0.obtainStyledAttributes(r5, r2)
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            boolean r3 = r5.getValue(r1, r2)
            r5.recycle()
            if (r3 != 0) goto L21
            goto La
        L21:
            int r5 = r2.getComplexUnit()
            r3 = 2
            if (r5 != r3) goto L3e
            int r5 = r2.data
            float r5 = android.util.TypedValue.complexToFloat(r5)
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            float r0 = r0.density
            float r5 = r5 * r0
            int r5 = java.lang.Math.round(r5)
            goto L4c
        L3e:
            int r5 = r2.data
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r5 = android.util.TypedValue.complexToDimensionPixelSize(r5, r0)
        L4c:
            if (r5 == 0) goto L52
            float r5 = (float) r5
            r4.setTextSize(r1, r5)
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationBarItemView.f(android.widget.TextView, int):void");
    }

    public static void g(float f4, float f5, int i4, TextView textView) {
        textView.setScaleX(f4);
        textView.setScaleY(f5);
        textView.setVisibility(i4);
    }

    private View getIconOrContainer() {
        FrameLayout frameLayout = this.f3626l;
        return frameLayout != null ? frameLayout : this.f3628n;
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i4 = 0;
        for (int i5 = 0; i5 < indexOfChild; i5++) {
            View childAt = viewGroup.getChildAt(i5);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i4++;
            }
        }
        return i4;
    }

    private int getSuggestedIconHeight() {
        return getIconOrContainer().getMeasuredHeight() + ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin;
    }

    private int getSuggestedIconWidth() {
        int minimumWidth;
        q1.a aVar = this.F;
        if (aVar == null) {
            minimumWidth = 0;
        } else {
            minimumWidth = aVar.getMinimumWidth() - this.F.f6334e.f6344b.f2996w.intValue();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams();
        int max = Math.max(minimumWidth, layoutParams.leftMargin);
        return Math.max(minimumWidth, layoutParams.rightMargin) + this.f3628n.getMeasuredWidth() + max;
    }

    public static void h(View view, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i4;
        layoutParams.bottomMargin = i4;
        layoutParams.gravity = i5;
        view.setLayoutParams(layoutParams);
    }

    public static void j(int i4, ViewGroup viewGroup) {
        viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), i4);
    }

    public final void a(float f4, float f5) {
        this.f3621g = f4 - f5;
        this.f3622h = (f5 * 1.0f) / f4;
        this.f3623i = (f4 * 1.0f) / f5;
    }

    public final void b() {
        r rVar = this.f3634t;
        if (rVar != null) {
            setChecked(rVar.isChecked());
        }
    }

    @Override // g.e0
    public final void c(r rVar) {
        CharSequence charSequence;
        int i4;
        this.f3634t = rVar;
        setCheckable(rVar.isCheckable());
        setChecked(rVar.isChecked());
        setEnabled(rVar.isEnabled());
        setIcon(rVar.getIcon());
        setTitle(rVar.f4726e);
        setId(rVar.f4722a);
        if (!TextUtils.isEmpty(rVar.f4738q)) {
            setContentDescription(rVar.f4738q);
        }
        if (!TextUtils.isEmpty(rVar.f4739r)) {
            charSequence = rVar.f4739r;
        } else {
            charSequence = rVar.f4726e;
        }
        com.google.common.collect.c.V1(this, charSequence);
        if (rVar.isVisible()) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        setVisibility(i4);
        this.f3615a = true;
    }

    public final void d() {
        Drawable drawable = this.f3617c;
        ColorStateList colorStateList = this.f3616b;
        FrameLayout frameLayout = this.f3626l;
        RippleDrawable rippleDrawable = null;
        boolean z4 = true;
        if (colorStateList != null) {
            Drawable activeIndicatorDrawable = getActiveIndicatorDrawable();
            if (this.A && getActiveIndicatorDrawable() != null && frameLayout != null && activeIndicatorDrawable != null) {
                rippleDrawable = new RippleDrawable(j2.a.c(this.f3616b), null, activeIndicatorDrawable);
                z4 = false;
            } else if (drawable == null) {
                drawable = new RippleDrawable(j2.a.a(this.f3616b), null, null);
            }
        }
        if (frameLayout != null) {
            frameLayout.setPadding(0, 0, 0, 0);
            frameLayout.setForeground(rippleDrawable);
        }
        WeakHashMap weakHashMap = y0.f4999a;
        g0.q(this, drawable);
        if (Build.VERSION.SDK_INT >= 26) {
            setDefaultFocusHighlightEnabled(z4);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        FrameLayout frameLayout = this.f3626l;
        if (frameLayout != null && this.A) {
            frameLayout.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void e(float f4, float f5) {
        float f6;
        float f7;
        View view = this.f3627m;
        if (view != null) {
            c cVar = this.f3639y;
            cVar.getClass();
            view.setScaleX(p1.a.a(0.4f, 1.0f, f4));
            view.setScaleY(cVar.a(f4, f5));
            int i4 = (f5 > 0.0f ? 1 : (f5 == 0.0f ? 0 : -1));
            if (i4 == 0) {
                f6 = 0.8f;
            } else {
                f6 = 0.0f;
            }
            if (i4 == 0) {
                f7 = 1.0f;
            } else {
                f7 = 0.2f;
            }
            view.setAlpha(p1.a.b(0.0f, 1.0f, f6, f7, f4));
        }
        this.f3640z = f4;
    }

    @Nullable
    public Drawable getActiveIndicatorDrawable() {
        View view = this.f3627m;
        if (view == null) {
            return null;
        }
        return view.getBackground();
    }

    @Nullable
    public q1.a getBadge() {
        return this.F;
    }

    @DrawableRes
    public int getItemBackgroundResId() {
        return R.drawable.mtrl_navigation_bar_item_background;
    }

    @Override // g.e0
    @Nullable
    public r getItemData() {
        return this.f3634t;
    }

    @DimenRes
    public int getItemDefaultMarginResId() {
        return R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    @LayoutRes
    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.f3632r;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        ViewGroup viewGroup = this.f3629o;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        return viewGroup.getMeasuredHeight() + getSuggestedIconHeight() + (viewGroup.getVisibility() == 0 ? this.f3620f : 0) + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        ViewGroup viewGroup = this.f3629o;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), viewGroup.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
    }

    public final void i(int i4) {
        int i5;
        View view = this.f3627m;
        if (view != null && i4 > 0) {
            int min = Math.min(this.B, i4 - (this.E * 2));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            if (this.D && this.f3624j == 2) {
                i5 = min;
            } else {
                i5 = this.C;
            }
            layoutParams.height = i5;
            layoutParams.width = min;
            view.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i4) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i4 + 1);
        r rVar = this.f3634t;
        if (rVar != null && rVar.isCheckable() && this.f3634t.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, G);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        q1.a aVar = this.F;
        if (aVar != null && aVar.isVisible()) {
            r rVar = this.f3634t;
            CharSequence charSequence = rVar.f4726e;
            if (!TextUtils.isEmpty(rVar.f4738q)) {
                charSequence = this.f3634t.f4738q;
            }
            accessibilityNodeInfo.setContentDescription(((Object) charSequence) + ", " + ((Object) this.F.c()));
        }
        accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) i0.i(0, 1, getItemVisiblePosition(), 1, false, isSelected()).f2125a);
        if (isSelected()) {
            accessibilityNodeInfo.setClickable(false);
            accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) j0.g.f5079g.f5088a);
        }
        accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(R.string.item_view_role_description));
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        post(new q(i4, 2, this));
    }

    public void setActiveIndicatorDrawable(@Nullable Drawable drawable) {
        View view = this.f3627m;
        if (view == null) {
            return;
        }
        view.setBackgroundDrawable(drawable);
        d();
    }

    public void setActiveIndicatorEnabled(boolean z4) {
        this.A = z4;
        d();
        View view = this.f3627m;
        if (view != null) {
            view.setVisibility(z4 ? 0 : 8);
            requestLayout();
        }
    }

    public void setActiveIndicatorHeight(int i4) {
        this.C = i4;
        i(getWidth());
    }

    public void setActiveIndicatorLabelPadding(int i4) {
        if (this.f3620f != i4) {
            this.f3620f = i4;
            b();
        }
    }

    public void setActiveIndicatorMarginHorizontal(@Px int i4) {
        this.E = i4;
        i(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z4) {
        this.D = z4;
    }

    public void setActiveIndicatorWidth(int i4) {
        this.B = i4;
        i(getWidth());
    }

    public void setBadge(@NonNull q1.a aVar) {
        boolean z4;
        q1.a aVar2 = this.F;
        if (aVar2 == aVar) {
            return;
        }
        if (aVar2 != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        ImageView imageView = this.f3628n;
        if (z4 && imageView != null) {
            Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
            if (this.F != null) {
                setClipChildren(true);
                setClipToPadding(true);
                q1.a aVar3 = this.F;
                if (aVar3 != null) {
                    if (aVar3.d() != null) {
                        aVar3.d().setForeground(null);
                    } else {
                        imageView.getOverlay().remove(aVar3);
                    }
                }
                this.F = null;
            }
        }
        this.F = aVar;
        if (imageView != null && aVar != null) {
            setClipChildren(false);
            setClipToPadding(false);
            q1.a aVar4 = this.F;
            Rect rect = new Rect();
            imageView.getDrawingRect(rect);
            aVar4.setBounds(rect);
            aVar4.i(imageView, null);
            if (aVar4.d() != null) {
                aVar4.d().setForeground(aVar4);
            } else {
                imageView.getOverlay().add(aVar4);
            }
        }
    }

    public void setCheckable(boolean z4) {
        refreshDrawableState();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c3, code lost:
        if (r13 != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00c5, code lost:
        h(getIconOrContainer(), (int) (r12.f3618d + r12.f3621g), 49);
        g(1.0f, 1.0f, 0, r2);
        r0 = r12.f3622h;
        g(r0, r0, 4, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00dc, code lost:
        h(getIconOrContainer(), r12.f3618d, 49);
        r0 = r12.f3623i;
        g(r0, r0, 4, r2);
        g(1.0f, 1.0f, 0, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00f4, code lost:
        if (r13 != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00f6, code lost:
        h(r0, r4, 49);
        j(r12.f3619e, r10);
        r2.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0102, code lost:
        h(r0, r4, 17);
        j(0, r10);
        r2.setVisibility(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x010b, code lost:
        r3.setVisibility(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0119, code lost:
        if (r13 != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0121, code lost:
        if (r13 != false) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setChecked(boolean r13) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationBarItemView.setChecked(boolean):void");
    }

    @Override // android.view.View
    public void setEnabled(boolean z4) {
        PointerIcon pointerIcon;
        super.setEnabled(z4);
        this.f3630p.setEnabled(z4);
        this.f3631q.setEnabled(z4);
        this.f3628n.setEnabled(z4);
        if (z4) {
            pointerIcon = a0.b(getContext(), 1002);
            WeakHashMap weakHashMap = y0.f4999a;
        } else {
            WeakHashMap weakHashMap2 = y0.f4999a;
            pointerIcon = null;
        }
        o0.d(this, pointerIcon);
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (drawable == this.f3636v) {
            return;
        }
        this.f3636v = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = drawable.mutate();
            this.f3637w = drawable;
            ColorStateList colorStateList = this.f3635u;
            if (colorStateList != null) {
                c0.b.h(drawable, colorStateList);
            }
        }
        this.f3628n.setImageDrawable(drawable);
    }

    public void setIconSize(int i4) {
        ImageView imageView = this.f3628n;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = i4;
        layoutParams.height = i4;
        imageView.setLayoutParams(layoutParams);
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        Drawable drawable;
        this.f3635u = colorStateList;
        if (this.f3634t != null && (drawable = this.f3637w) != null) {
            c0.b.h(drawable, colorStateList);
            this.f3637w.invalidateSelf();
        }
    }

    public void setItemBackground(int i4) {
        Drawable b5;
        if (i4 == 0) {
            b5 = null;
        } else {
            Context context = getContext();
            Object obj = z.e.f7215a;
            b5 = z.c.b(context, i4);
        }
        setItemBackground(b5);
    }

    public void setItemPaddingBottom(int i4) {
        if (this.f3619e != i4) {
            this.f3619e = i4;
            b();
        }
    }

    public void setItemPaddingTop(int i4) {
        if (this.f3618d != i4) {
            this.f3618d = i4;
            b();
        }
    }

    public void setItemPosition(int i4) {
        this.f3632r = i4;
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        this.f3616b = colorStateList;
        d();
    }

    public void setLabelVisibilityMode(int i4) {
        c cVar;
        if (this.f3624j != i4) {
            this.f3624j = i4;
            if (this.D && i4 == 2) {
                cVar = I;
            } else {
                cVar = H;
            }
            this.f3639y = cVar;
            i(getWidth());
            b();
        }
    }

    public void setShifting(boolean z4) {
        if (this.f3625k != z4) {
            this.f3625k = z4;
            b();
        }
    }

    public void setShortcut(boolean z4, char c4) {
    }

    public void setTextAppearanceActive(@StyleRes int i4) {
        this.f3633s = i4;
        TextView textView = this.f3631q;
        f(textView, i4);
        a(this.f3630p.getTextSize(), textView.getTextSize());
    }

    public void setTextAppearanceActiveBoldEnabled(boolean z4) {
        setTextAppearanceActive(this.f3633s);
        TextView textView = this.f3631q;
        textView.setTypeface(textView.getTypeface(), z4 ? 1 : 0);
    }

    public void setTextAppearanceInactive(@StyleRes int i4) {
        TextView textView = this.f3630p;
        f(textView, i4);
        a(textView.getTextSize(), this.f3631q.getTextSize());
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f3630p.setTextColor(colorStateList);
            this.f3631q.setTextColor(colorStateList);
        }
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.f3630p.setText(charSequence);
        this.f3631q.setText(charSequence);
        r rVar = this.f3634t;
        if (rVar == null || TextUtils.isEmpty(rVar.f4738q)) {
            setContentDescription(charSequence);
        }
        r rVar2 = this.f3634t;
        if (rVar2 != null && !TextUtils.isEmpty(rVar2.f4739r)) {
            charSequence = this.f3634t.f4739r;
        }
        com.google.common.collect.c.V1(this, charSequence);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        this.f3617c = drawable;
        d();
    }
}
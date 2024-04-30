package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.widget.p;
import androidx.recyclerview.widget.i0;
import androidx.viewpager.widget.ViewPager;
import com.example.msphone.R;
import com.google.android.material.appbar.i;
import com.google.android.material.internal.n0;
import h0.d;
import i0.a0;
import i0.g0;
import i0.h0;
import i0.j0;
import i0.m0;
import i0.o0;
import i0.y0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import l2.j;
import o2.f;
import o2.g;
import o2.h;
import z.e;

@ViewPager.DecorView
/* loaded from: classes.dex */
public class TabLayout extends HorizontalScrollView {
    public static final d U = new d(16);
    public final int A;
    public int B;
    public int C;
    public boolean D;
    public boolean E;
    public int F;
    public int G;
    public boolean H;
    public a I;
    public final TimeInterpolator J;
    public o2.c K;
    public final ArrayList L;
    public h M;
    public ValueAnimator N;
    public ViewPager O;
    public g P;
    public o2.b Q;
    public boolean R;
    public int S;
    public final p.g T;

    /* renamed from: a  reason: collision with root package name */
    public int f3902a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f3903b;

    /* renamed from: c  reason: collision with root package name */
    public b f3904c;

    /* renamed from: d  reason: collision with root package name */
    public final f f3905d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3906e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3907f;

    /* renamed from: g  reason: collision with root package name */
    public final int f3908g;

    /* renamed from: h  reason: collision with root package name */
    public final int f3909h;

    /* renamed from: i  reason: collision with root package name */
    public final int f3910i;

    /* renamed from: j  reason: collision with root package name */
    public final int f3911j;

    /* renamed from: k  reason: collision with root package name */
    public final int f3912k;

    /* renamed from: l  reason: collision with root package name */
    public ColorStateList f3913l;

    /* renamed from: m  reason: collision with root package name */
    public ColorStateList f3914m;

    /* renamed from: n  reason: collision with root package name */
    public ColorStateList f3915n;

    /* renamed from: o  reason: collision with root package name */
    public Drawable f3916o;

    /* renamed from: p  reason: collision with root package name */
    public int f3917p;

    /* renamed from: q  reason: collision with root package name */
    public final PorterDuff.Mode f3918q;

    /* renamed from: r  reason: collision with root package name */
    public final float f3919r;

    /* renamed from: s  reason: collision with root package name */
    public final float f3920s;

    /* renamed from: t  reason: collision with root package name */
    public final int f3921t;

    /* renamed from: u  reason: collision with root package name */
    public int f3922u;

    /* renamed from: v  reason: collision with root package name */
    public final int f3923v;

    /* renamed from: w  reason: collision with root package name */
    public final int f3924w;

    /* renamed from: x  reason: collision with root package name */
    public final int f3925x;

    /* renamed from: y  reason: collision with root package name */
    public final int f3926y;

    /* renamed from: z  reason: collision with root package name */
    public int f3927z;

    /* loaded from: classes.dex */
    public @interface LabelVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f170b})
    /* loaded from: classes.dex */
    public @interface Mode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f170b})
    /* loaded from: classes.dex */
    public @interface TabGravity {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f170b})
    /* loaded from: classes.dex */
    public @interface TabIndicatorAnimationMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f170b})
    /* loaded from: classes.dex */
    public @interface TabIndicatorGravity {
    }

    /* loaded from: classes.dex */
    public final class TabView extends LinearLayout {

        /* renamed from: l  reason: collision with root package name */
        public static final /* synthetic */ int f3928l = 0;

        /* renamed from: a  reason: collision with root package name */
        public b f3929a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f3930b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f3931c;

        /* renamed from: d  reason: collision with root package name */
        public View f3932d;

        /* renamed from: e  reason: collision with root package name */
        public q1.a f3933e;

        /* renamed from: f  reason: collision with root package name */
        public View f3934f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f3935g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f3936h;

        /* renamed from: i  reason: collision with root package name */
        public Drawable f3937i;

        /* renamed from: j  reason: collision with root package name */
        public int f3938j;

        public TabView(Context context) {
            super(context);
            this.f3938j = 2;
            e(context);
            int i4 = TabLayout.this.f3906e;
            WeakHashMap weakHashMap = y0.f4999a;
            h0.k(this, i4, TabLayout.this.f3907f, TabLayout.this.f3908g, TabLayout.this.f3909h);
            setGravity(17);
            setOrientation(!TabLayout.this.D ? 1 : 0);
            setClickable(true);
            o0.d(this, a0.b(getContext(), 1002));
        }

        @Nullable
        private q1.a getBadge() {
            return this.f3933e;
        }

        @NonNull
        private q1.a getOrCreateBadge() {
            if (this.f3933e == null) {
                this.f3933e = new q1.a(getContext(), null);
            }
            b();
            q1.a aVar = this.f3933e;
            if (aVar != null) {
                return aVar;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        public final void a() {
            if (this.f3933e != null) {
                setClipChildren(true);
                setClipToPadding(true);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(true);
                    viewGroup.setClipToPadding(true);
                }
                View view = this.f3932d;
                if (view != null) {
                    q1.a aVar = this.f3933e;
                    if (aVar != null) {
                        if (aVar.d() != null) {
                            aVar.d().setForeground(null);
                        } else {
                            view.getOverlay().remove(aVar);
                        }
                    }
                    this.f3932d = null;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
            if (r2.d() != null) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
            r2.d().setForeground(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
            r0.getOverlay().add(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00a9, code lost:
            if (r2.d() != null) goto L24;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void b() {
            /*
                r4 = this;
                q1.a r0 = r4.f3933e
                if (r0 == 0) goto Lac
                android.view.View r0 = r4.f3934f
                if (r0 == 0) goto Ld
            L8:
                r4.a()
                goto Lac
            Ld:
                android.widget.ImageView r0 = r4.f3931c
                r1 = 0
                r2 = 0
                if (r0 == 0) goto L6a
                com.google.android.material.tabs.b r3 = r4.f3929a
                if (r3 == 0) goto L6a
                android.graphics.drawable.Drawable r3 = r3.f3940a
                if (r3 == 0) goto L6a
                android.view.View r3 = r4.f3932d
                if (r3 == r0) goto L66
                r4.a()
                android.widget.ImageView r0 = r4.f3931c
                q1.a r3 = r4.f3933e
                if (r3 == 0) goto Lac
                if (r0 == 0) goto Lac
                r4.setClipChildren(r2)
                r4.setClipToPadding(r2)
                android.view.ViewParent r3 = r4.getParent()
                android.view.ViewGroup r3 = (android.view.ViewGroup) r3
                if (r3 == 0) goto L3e
                r3.setClipChildren(r2)
                r3.setClipToPadding(r2)
            L3e:
                q1.a r2 = r4.f3933e
                android.graphics.Rect r3 = new android.graphics.Rect
                r3.<init>()
                r0.getDrawingRect(r3)
                r2.setBounds(r3)
                r2.i(r0, r1)
                android.widget.FrameLayout r1 = r2.d()
                if (r1 == 0) goto L5c
            L54:
                android.widget.FrameLayout r1 = r2.d()
                r1.setForeground(r2)
                goto L63
            L5c:
                android.view.ViewOverlay r1 = r0.getOverlay()
                r1.add(r2)
            L63:
                r4.f3932d = r0
                goto Lac
            L66:
                r4.c(r0)
                goto Lac
            L6a:
                android.widget.TextView r0 = r4.f3930b
                if (r0 == 0) goto L8
                com.google.android.material.tabs.b r3 = r4.f3929a
                if (r3 == 0) goto L8
                android.view.View r3 = r4.f3932d
                if (r3 == r0) goto L66
                r4.a()
                android.widget.TextView r0 = r4.f3930b
                q1.a r3 = r4.f3933e
                if (r3 == 0) goto Lac
                if (r0 == 0) goto Lac
                r4.setClipChildren(r2)
                r4.setClipToPadding(r2)
                android.view.ViewParent r3 = r4.getParent()
                android.view.ViewGroup r3 = (android.view.ViewGroup) r3
                if (r3 == 0) goto L95
                r3.setClipChildren(r2)
                r3.setClipToPadding(r2)
            L95:
                q1.a r2 = r4.f3933e
                android.graphics.Rect r3 = new android.graphics.Rect
                r3.<init>()
                r0.getDrawingRect(r3)
                r2.setBounds(r3)
                r2.i(r0, r1)
                android.widget.FrameLayout r1 = r2.d()
                if (r1 == 0) goto L5c
                goto L54
            Lac:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.TabView.b():void");
        }

        public final void c(View view) {
            q1.a aVar = this.f3933e;
            if (aVar != null && view == this.f3932d) {
                Rect rect = new Rect();
                view.getDrawingRect(rect);
                aVar.setBounds(rect);
                aVar.i(view, null);
            }
        }

        public final void d() {
            boolean z4;
            f();
            b bVar = this.f3929a;
            if (bVar != null) {
                TabLayout tabLayout = bVar.f3945f;
                if (tabLayout != null) {
                    int selectedTabPosition = tabLayout.getSelectedTabPosition();
                    if (selectedTabPosition != -1 && selectedTabPosition == bVar.f3943d) {
                        z4 = true;
                        setSelected(z4);
                    }
                } else {
                    throw new IllegalArgumentException("Tab not attached to a TabLayout");
                }
            }
            z4 = false;
            setSelected(z4);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f3937i;
            if (drawable != null && drawable.isStateful() && this.f3937i.setState(drawableState)) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [android.graphics.drawable.RippleDrawable] */
        public final void e(Context context) {
            TabLayout tabLayout = TabLayout.this;
            int i4 = tabLayout.f3921t;
            GradientDrawable gradientDrawable = null;
            if (i4 != 0) {
                Drawable t02 = com.google.common.collect.c.t0(context, i4);
                this.f3937i = t02;
                if (t02 != null && t02.isStateful()) {
                    this.f3937i.setState(getDrawableState());
                }
            } else {
                this.f3937i = null;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(0);
            if (tabLayout.f3915n != null) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(1.0E-5f);
                gradientDrawable3.setColor(-1);
                ColorStateList a5 = j2.a.a(tabLayout.f3915n);
                boolean z4 = tabLayout.H;
                if (z4) {
                    gradientDrawable2 = null;
                }
                if (!z4) {
                    gradientDrawable = gradientDrawable3;
                }
                gradientDrawable2 = new RippleDrawable(a5, gradientDrawable2, gradientDrawable);
            }
            WeakHashMap weakHashMap = y0.f4999a;
            g0.q(this, gradientDrawable2);
            tabLayout.invalidate();
        }

        public final void f() {
            View view;
            int i4;
            ViewParent parent;
            b bVar = this.f3929a;
            ImageView imageView = null;
            if (bVar != null) {
                view = bVar.f3944e;
            } else {
                view = null;
            }
            if (view != null) {
                ViewParent parent2 = view.getParent();
                if (parent2 != this) {
                    if (parent2 != null) {
                        ((ViewGroup) parent2).removeView(view);
                    }
                    View view2 = this.f3934f;
                    if (view2 != null && (parent = view2.getParent()) != null) {
                        ((ViewGroup) parent).removeView(this.f3934f);
                    }
                    addView(view);
                }
                this.f3934f = view;
                TextView textView = this.f3930b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView2 = this.f3931c;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f3931c.setImageDrawable(null);
                }
                TextView textView2 = (TextView) view.findViewById(16908308);
                this.f3935g = textView2;
                if (textView2 != null) {
                    this.f3938j = p.b(textView2);
                }
                imageView = (ImageView) view.findViewById(16908294);
            } else {
                View view3 = this.f3934f;
                if (view3 != null) {
                    removeView(view3);
                    this.f3934f = null;
                }
                this.f3935g = null;
            }
            this.f3936h = imageView;
            if (this.f3934f == null) {
                if (this.f3931c == null) {
                    ImageView imageView3 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                    this.f3931c = imageView3;
                    addView(imageView3, 0);
                }
                if (this.f3930b == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup) this, false);
                    this.f3930b = textView3;
                    addView(textView3);
                    this.f3938j = p.b(this.f3930b);
                }
                TextView textView4 = this.f3930b;
                TabLayout tabLayout = TabLayout.this;
                textView4.setTextAppearance(tabLayout.f3910i);
                if (isSelected() && (i4 = tabLayout.f3912k) != -1) {
                    this.f3930b.setTextAppearance(i4);
                } else {
                    this.f3930b.setTextAppearance(tabLayout.f3911j);
                }
                ColorStateList colorStateList = tabLayout.f3913l;
                if (colorStateList != null) {
                    this.f3930b.setTextColor(colorStateList);
                }
                g(this.f3930b, this.f3931c, true);
                b();
                ImageView imageView4 = this.f3931c;
                if (imageView4 != null) {
                    imageView4.addOnLayoutChangeListener(new c(this, imageView4));
                }
                TextView textView5 = this.f3930b;
                if (textView5 != null) {
                    textView5.addOnLayoutChangeListener(new c(this, textView5));
                }
            } else {
                TextView textView6 = this.f3935g;
                if (textView6 != null || this.f3936h != null) {
                    g(textView6, this.f3936h, false);
                }
            }
            if (bVar != null && !TextUtils.isEmpty(bVar.f3942c)) {
                setContentDescription(bVar.f3942c);
            }
        }

        public final void g(TextView textView, ImageView imageView, boolean z4) {
            Drawable drawable;
            CharSequence charSequence;
            int i4;
            CharSequence charSequence2;
            int i5;
            Drawable drawable2;
            b bVar = this.f3929a;
            CharSequence charSequence3 = null;
            if (bVar != null && (drawable2 = bVar.f3940a) != null) {
                drawable = drawable2.mutate();
            } else {
                drawable = null;
            }
            TabLayout tabLayout = TabLayout.this;
            if (drawable != null) {
                c0.b.h(drawable, tabLayout.f3914m);
                PorterDuff.Mode mode = tabLayout.f3918q;
                if (mode != null) {
                    c0.b.i(drawable, mode);
                }
            }
            b bVar2 = this.f3929a;
            if (bVar2 != null) {
                charSequence = bVar2.f3941b;
            } else {
                charSequence = null;
            }
            if (imageView != null) {
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z5 = true;
            boolean z6 = !TextUtils.isEmpty(charSequence);
            if (textView != null) {
                if (z6) {
                    this.f3929a.getClass();
                } else {
                    z5 = false;
                }
                if (z6) {
                    charSequence2 = charSequence;
                } else {
                    charSequence2 = null;
                }
                textView.setText(charSequence2);
                if (z5) {
                    i5 = 0;
                } else {
                    i5 = 8;
                }
                textView.setVisibility(i5);
                if (z6) {
                    setVisibility(0);
                }
            } else {
                z5 = false;
            }
            if (z4 && imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                if (z5 && imageView.getVisibility() == 0) {
                    i4 = (int) n0.c(getContext(), 8);
                } else {
                    i4 = 0;
                }
                if (tabLayout.D) {
                    if (i4 != i0.p.b(marginLayoutParams)) {
                        i0.p.g(marginLayoutParams, i4);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (i4 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i4;
                    i0.p.g(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            b bVar3 = this.f3929a;
            if (bVar3 != null) {
                charSequence3 = bVar3.f3942c;
            }
            if (!z6) {
                charSequence = charSequence3;
            }
            com.google.common.collect.c.V1(this, charSequence);
        }

        public int getContentHeight() {
            View[] viewArr = {this.f3930b, this.f3931c, this.f3934f};
            int i4 = 0;
            int i5 = 0;
            boolean z4 = false;
            for (int i6 = 0; i6 < 3; i6++) {
                View view = viewArr[i6];
                if (view != null && view.getVisibility() == 0) {
                    i5 = z4 ? Math.min(i5, view.getTop()) : view.getTop();
                    i4 = z4 ? Math.max(i4, view.getBottom()) : view.getBottom();
                    z4 = true;
                }
            }
            return i4 - i5;
        }

        public int getContentWidth() {
            View[] viewArr = {this.f3930b, this.f3931c, this.f3934f};
            int i4 = 0;
            int i5 = 0;
            boolean z4 = false;
            for (int i6 = 0; i6 < 3; i6++) {
                View view = viewArr[i6];
                if (view != null && view.getVisibility() == 0) {
                    i5 = z4 ? Math.min(i5, view.getLeft()) : view.getLeft();
                    i4 = z4 ? Math.max(i4, view.getRight()) : view.getRight();
                    z4 = true;
                }
            }
            return i4 - i5;
        }

        @Nullable
        public b getTab() {
            return this.f3929a;
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            q1.a aVar = this.f3933e;
            if (aVar != null && aVar.isVisible()) {
                CharSequence contentDescription = getContentDescription();
                accessibilityNodeInfo.setContentDescription(((Object) contentDescription) + ", " + ((Object) this.f3933e.c()));
            }
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) i0.i(0, 1, this.f3929a.f3943d, 1, false, isSelected()).f2125a);
            if (isSelected()) {
                accessibilityNodeInfo.setClickable(false);
                accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) j0.g.f5079g.f5088a);
            }
            accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(R.string.item_view_role_description));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onMeasure(int i4, int i5) {
            int size = View.MeasureSpec.getSize(i4);
            int mode = View.MeasureSpec.getMode(i4);
            TabLayout tabLayout = TabLayout.this;
            int tabMaxWidth = tabLayout.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i4 = View.MeasureSpec.makeMeasureSpec(tabLayout.f3922u, Integer.MIN_VALUE);
            }
            super.onMeasure(i4, i5);
            if (this.f3930b != null) {
                float f4 = tabLayout.f3919r;
                int i6 = this.f3938j;
                ImageView imageView = this.f3931c;
                if (imageView != null && imageView.getVisibility() == 0) {
                    i6 = 1;
                } else {
                    TextView textView = this.f3930b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f4 = tabLayout.f3920s;
                    }
                }
                float textSize = this.f3930b.getTextSize();
                int lineCount = this.f3930b.getLineCount();
                int b5 = p.b(this.f3930b);
                int i7 = (f4 > textSize ? 1 : (f4 == textSize ? 0 : -1));
                if (i7 != 0 || (b5 >= 0 && i6 != b5)) {
                    if (tabLayout.C == 1 && i7 > 0 && lineCount == 1) {
                        Layout layout = this.f3930b.getLayout();
                        if (layout != null) {
                            if ((f4 / layout.getPaint().getTextSize()) * layout.getLineWidth(0) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    this.f3930b.setTextSize(0, f4);
                    this.f3930b.setMaxLines(i6);
                    super.onMeasure(i4, i5);
                }
            }
        }

        @Override // android.view.View
        public final boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f3929a != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                b bVar = this.f3929a;
                TabLayout tabLayout = bVar.f3945f;
                if (tabLayout != null) {
                    tabLayout.h(bVar, true);
                    return true;
                }
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return performClick;
        }

        @Override // android.view.View
        public void setSelected(boolean z4) {
            isSelected();
            super.setSelected(z4);
            TextView textView = this.f3930b;
            if (textView != null) {
                textView.setSelected(z4);
            }
            ImageView imageView = this.f3931c;
            if (imageView != null) {
                imageView.setSelected(z4);
            }
            View view = this.f3934f;
            if (view != null) {
                view.setSelected(z4);
            }
        }

        public void setTab(@Nullable b bVar) {
            if (bVar != this.f3929a) {
                this.f3929a = bVar;
                d();
            }
        }
    }

    public TabLayout(@NonNull Context context) {
        this(context, null);
    }

    public static ColorStateList e(int i4, int i5) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i5, i4});
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        ArrayList arrayList = this.f3903b;
        int size = arrayList.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                break;
            }
            b bVar = (b) arrayList.get(i4);
            if (bVar != null && bVar.f3940a != null && !TextUtils.isEmpty(bVar.f3941b)) {
                if (!this.D) {
                    return 72;
                }
            } else {
                i4++;
            }
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i4 = this.f3923v;
        if (i4 != -1) {
            return i4;
        }
        int i5 = this.C;
        if (i5 == 0 || i5 == 2) {
            return this.f3925x;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f3905d.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i4) {
        f fVar = this.f3905d;
        int childCount = fVar.getChildCount();
        if (i4 < childCount) {
            int i5 = 0;
            while (i5 < childCount) {
                View childAt = fVar.getChildAt(i5);
                if ((i5 != i4 || childAt.isSelected()) && (i5 == i4 || !childAt.isSelected())) {
                    childAt.setSelected(i5 == i4);
                    childAt.setActivated(i5 == i4);
                } else {
                    childAt.setSelected(i5 == i4);
                    childAt.setActivated(i5 == i4);
                    if (childAt instanceof TabView) {
                        ((TabView) childAt).f();
                    }
                }
                i5++;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.google.android.material.tabs.b, java.lang.Object] */
    public final void a(View view) {
        TabView tabView;
        CharSequence charSequence;
        float f4;
        if (view instanceof TabItem) {
            TabItem tabItem = (TabItem) view;
            b bVar = (b) U.a();
            b bVar2 = bVar;
            if (bVar == null) {
                ?? obj = new Object();
                obj.f3943d = -1;
                obj.f3947h = -1;
                bVar2 = obj;
            }
            bVar2.f3945f = this;
            p.g gVar = this.T;
            if (gVar != null) {
                tabView = (TabView) gVar.a();
            } else {
                tabView = null;
            }
            if (tabView == null) {
                tabView = new TabView(getContext());
            }
            tabView.setTab(bVar2);
            tabView.setFocusable(true);
            tabView.setMinimumWidth(getTabMinWidth());
            if (TextUtils.isEmpty(bVar2.f3942c)) {
                charSequence = bVar2.f3941b;
            } else {
                charSequence = bVar2.f3942c;
            }
            tabView.setContentDescription(charSequence);
            bVar2.f3946g = tabView;
            int i4 = bVar2.f3947h;
            if (i4 != -1) {
                tabView.setId(i4);
            }
            CharSequence charSequence2 = tabItem.f3899a;
            if (charSequence2 != null) {
                if (TextUtils.isEmpty(bVar2.f3942c) && !TextUtils.isEmpty(charSequence2)) {
                    bVar2.f3946g.setContentDescription(charSequence2);
                }
                bVar2.f3941b = charSequence2;
                TabView tabView2 = bVar2.f3946g;
                if (tabView2 != null) {
                    tabView2.d();
                }
            }
            Drawable drawable = tabItem.f3900b;
            if (drawable != null) {
                bVar2.f3940a = drawable;
                TabLayout tabLayout = bVar2.f3945f;
                if (tabLayout.f3927z == 1 || tabLayout.C == 2) {
                    tabLayout.k(true);
                }
                TabView tabView3 = bVar2.f3946g;
                if (tabView3 != null) {
                    tabView3.d();
                }
            }
            int i5 = tabItem.f3901c;
            if (i5 != 0) {
                bVar2.f3944e = LayoutInflater.from(bVar2.f3946g.getContext()).inflate(i5, (ViewGroup) bVar2.f3946g, false);
                TabView tabView4 = bVar2.f3946g;
                if (tabView4 != null) {
                    tabView4.d();
                }
            }
            if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
                bVar2.f3942c = tabItem.getContentDescription();
                TabView tabView5 = bVar2.f3946g;
                if (tabView5 != null) {
                    tabView5.d();
                }
            }
            ArrayList arrayList = this.f3903b;
            boolean isEmpty = arrayList.isEmpty();
            int size = arrayList.size();
            if (bVar2.f3945f == this) {
                bVar2.f3943d = size;
                arrayList.add(size, bVar2);
                int size2 = arrayList.size();
                int i6 = -1;
                for (int i7 = size + 1; i7 < size2; i7++) {
                    if (((b) arrayList.get(i7)).f3943d == this.f3902a) {
                        i6 = i7;
                    }
                    ((b) arrayList.get(i7)).f3943d = i7;
                }
                this.f3902a = i6;
                TabView tabView6 = bVar2.f3946g;
                tabView6.setSelected(false);
                tabView6.setActivated(false);
                int i8 = bVar2.f3943d;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                if (this.C == 1 && this.f3927z == 0) {
                    layoutParams.width = 0;
                    f4 = 1.0f;
                } else {
                    layoutParams.width = -2;
                    f4 = 0.0f;
                }
                layoutParams.weight = f4;
                this.f3905d.addView(tabView6, i8, layoutParams);
                if (isEmpty) {
                    TabLayout tabLayout2 = bVar2.f3945f;
                    if (tabLayout2 != null) {
                        tabLayout2.h(bVar2, true);
                        return;
                    }
                    throw new IllegalArgumentException("Tab not attached to a TabLayout");
                }
                return;
            }
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view) {
        a(view);
    }

    public final void b(int i4) {
        if (i4 == -1) {
            return;
        }
        if (getWindowToken() != null) {
            WeakHashMap weakHashMap = y0.f4999a;
            if (j0.c(this)) {
                f fVar = this.f3905d;
                int childCount = fVar.getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    if (fVar.getChildAt(i5).getWidth() > 0) {
                    }
                }
                int scrollX = getScrollX();
                int d4 = d(i4, 0.0f);
                if (scrollX != d4) {
                    f();
                    this.N.setIntValues(scrollX, d4);
                    this.N.start();
                }
                ValueAnimator valueAnimator = fVar.f5976a;
                if (valueAnimator != null && valueAnimator.isRunning() && fVar.f5977b.f3902a != i4) {
                    fVar.f5976a.cancel();
                }
                fVar.d(i4, this.A, true);
                return;
            }
        }
        setScrollPosition(i4, 0.0f, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
        if (r0 != 2) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c() {
        /*
            r5 = this;
            int r0 = r5.C
            r1 = 2
            r2 = 0
            if (r0 == 0) goto Lb
            if (r0 != r1) goto L9
            goto Lb
        L9:
            r0 = r2
            goto L14
        Lb:
            int r0 = r5.f3926y
            int r3 = r5.f3906e
            int r0 = r0 - r3
            int r0 = java.lang.Math.max(r2, r0)
        L14:
            java.util.WeakHashMap r3 = i0.y0.f4999a
            o2.f r3 = r5.f3905d
            i0.h0.k(r3, r0, r2, r2, r2)
            int r0 = r5.C
            java.lang.String r2 = "TabLayout"
            r4 = 1
            if (r0 == 0) goto L34
            if (r0 == r4) goto L27
            if (r0 == r1) goto L27
            goto L4c
        L27:
            int r0 = r5.f3927z
            if (r0 != r1) goto L30
            java.lang.String r0 = "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead"
            android.util.Log.w(r2, r0)
        L30:
            r3.setGravity(r4)
            goto L4c
        L34:
            int r0 = r5.f3927z
            if (r0 == 0) goto L41
            if (r0 == r4) goto L3d
            if (r0 == r1) goto L46
            goto L4c
        L3d:
            r3.setGravity(r4)
            goto L4c
        L41:
            java.lang.String r0 = "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead"
            android.util.Log.w(r2, r0)
        L46:
            r0 = 8388611(0x800003, float:1.1754948E-38)
            r3.setGravity(r0)
        L4c:
            r5.k(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.c():void");
    }

    public final int d(int i4, float f4) {
        f fVar;
        View childAt;
        View view;
        int i5 = this.C;
        int i6 = 0;
        if ((i5 != 0 && i5 != 2) || (childAt = (fVar = this.f3905d).getChildAt(i4)) == null) {
            return 0;
        }
        int i7 = i4 + 1;
        if (i7 < fVar.getChildCount()) {
            view = fVar.getChildAt(i7);
        } else {
            view = null;
        }
        int width = childAt.getWidth();
        if (view != null) {
            i6 = view.getWidth();
        }
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i8 = (int) ((width + i6) * 0.5f * f4);
        WeakHashMap weakHashMap = y0.f4999a;
        if (h0.d(this) == 0) {
            return left + i8;
        }
        return left - i8;
    }

    public final void f() {
        if (this.N == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.N = valueAnimator;
            valueAnimator.setInterpolator(this.J);
            this.N.setDuration(this.A);
            this.N.addUpdateListener(new i(2, this));
        }
    }

    public final void g() {
        f fVar = this.f3905d;
        int childCount = fVar.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                break;
            }
            TabView tabView = (TabView) fVar.getChildAt(childCount);
            fVar.removeViewAt(childCount);
            if (tabView != null) {
                tabView.setTab(null);
                tabView.setSelected(false);
                this.T.b(tabView);
            }
            requestLayout();
        }
        Iterator it = this.f3903b.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            it.remove();
            bVar.f3945f = null;
            bVar.f3946g = null;
            bVar.f3940a = null;
            bVar.f3947h = -1;
            bVar.f3941b = null;
            bVar.f3942c = null;
            bVar.f3943d = -1;
            bVar.f3944e = null;
            U.b(bVar);
        }
        this.f3904c = null;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        b bVar = this.f3904c;
        if (bVar != null) {
            return bVar.f3943d;
        }
        return -1;
    }

    public int getTabCount() {
        return this.f3903b.size();
    }

    public int getTabGravity() {
        return this.f3927z;
    }

    @Nullable
    public ColorStateList getTabIconTint() {
        return this.f3914m;
    }

    public int getTabIndicatorAnimationMode() {
        return this.G;
    }

    public int getTabIndicatorGravity() {
        return this.B;
    }

    public int getTabMaxWidth() {
        return this.f3922u;
    }

    public int getTabMode() {
        return this.C;
    }

    @Nullable
    public ColorStateList getTabRippleColor() {
        return this.f3915n;
    }

    @NonNull
    public Drawable getTabSelectedIndicator() {
        return this.f3916o;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.f3913l;
    }

    public final void h(b bVar, boolean z4) {
        int i4;
        b bVar2 = this.f3904c;
        ArrayList arrayList = this.L;
        if (bVar2 == bVar) {
            if (bVar2 != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((o2.c) arrayList.get(size)).getClass();
                }
                b(bVar.f3943d);
                return;
            }
            return;
        }
        if (bVar != null) {
            i4 = bVar.f3943d;
        } else {
            i4 = -1;
        }
        if (z4) {
            if ((bVar2 == null || bVar2.f3943d == -1) && i4 != -1) {
                setScrollPosition(i4, 0.0f, true);
            } else {
                b(i4);
            }
            if (i4 != -1) {
                setSelectedTabView(i4);
            }
        }
        this.f3904c = bVar;
        if (bVar2 != null && bVar2.f3945f != null) {
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                ((o2.c) arrayList.get(size2)).getClass();
            }
        }
        if (bVar != null) {
            for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                h hVar = (h) ((o2.c) arrayList.get(size3));
                hVar.getClass();
                hVar.f5981a.setCurrentItem(bVar.f3943d);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x008f, code lost:
        if (r10 == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i(int r6, float r7, boolean r8, boolean r9, boolean r10) {
        /*
            r5 = this;
            float r0 = (float) r6
            float r0 = r0 + r7
            int r1 = java.lang.Math.round(r0)
            if (r1 < 0) goto L9c
            o2.f r2 = r5.f3905d
            int r3 = r2.getChildCount()
            if (r1 < r3) goto L12
            goto L9c
        L12:
            if (r9 == 0) goto L38
            int r9 = java.lang.Math.round(r0)
            com.google.android.material.tabs.TabLayout r0 = r2.f5977b
            r0.f3902a = r9
            android.animation.ValueAnimator r9 = r2.f5976a
            if (r9 == 0) goto L2b
            boolean r9 = r9.isRunning()
            if (r9 == 0) goto L2b
            android.animation.ValueAnimator r9 = r2.f5976a
            r9.cancel()
        L2b:
            android.view.View r9 = r2.getChildAt(r6)
            int r0 = r6 + 1
            android.view.View r0 = r2.getChildAt(r0)
            r2.c(r9, r0, r7)
        L38:
            android.animation.ValueAnimator r9 = r5.N
            if (r9 == 0) goto L47
            boolean r9 = r9.isRunning()
            if (r9 == 0) goto L47
            android.animation.ValueAnimator r9 = r5.N
            r9.cancel()
        L47:
            int r7 = r5.d(r6, r7)
            int r9 = r5.getScrollX()
            int r0 = r5.getSelectedTabPosition()
            r2 = 1
            r3 = 0
            if (r6 >= r0) goto L59
            if (r7 >= r9) goto L67
        L59:
            int r0 = r5.getSelectedTabPosition()
            if (r6 <= r0) goto L61
            if (r7 <= r9) goto L67
        L61:
            int r0 = r5.getSelectedTabPosition()
            if (r6 != r0) goto L69
        L67:
            r0 = r2
            goto L6a
        L69:
            r0 = r3
        L6a:
            java.util.WeakHashMap r4 = i0.y0.f4999a
            int r4 = i0.h0.d(r5)
            if (r4 != r2) goto L89
            int r0 = r5.getSelectedTabPosition()
            if (r6 >= r0) goto L7a
            if (r7 <= r9) goto L91
        L7a:
            int r0 = r5.getSelectedTabPosition()
            if (r6 <= r0) goto L82
            if (r7 >= r9) goto L91
        L82:
            int r9 = r5.getSelectedTabPosition()
            if (r6 != r9) goto L8b
            goto L91
        L89:
            if (r0 != 0) goto L91
        L8b:
            int r9 = r5.S
            if (r9 == r2) goto L91
            if (r10 == 0) goto L97
        L91:
            if (r6 >= 0) goto L94
            r7 = r3
        L94:
            r5.scrollTo(r7, r3)
        L97:
            if (r8 == 0) goto L9c
            r5.setSelectedTabView(r1)
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.i(int, float, boolean, boolean, boolean):void");
    }

    public final void j(ViewPager viewPager, boolean z4, boolean z5) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ViewPager viewPager2 = this.O;
        if (viewPager2 != null) {
            g gVar = this.P;
            if (gVar != null && (arrayList2 = viewPager2.D) != null) {
                arrayList2.remove(gVar);
            }
            o2.b bVar = this.Q;
            if (bVar != null && (arrayList = this.O.G) != null) {
                arrayList.remove(bVar);
            }
        }
        h hVar = this.M;
        ArrayList arrayList3 = this.L;
        if (hVar != null) {
            arrayList3.remove(hVar);
            this.M = null;
        }
        if (viewPager != null) {
            this.O = viewPager;
            if (this.P == null) {
                this.P = new g(this);
            }
            g gVar2 = this.P;
            gVar2.f5980c = 0;
            gVar2.f5979b = 0;
            if (viewPager.D == null) {
                viewPager.D = new ArrayList();
            }
            viewPager.D.add(gVar2);
            h hVar2 = new h(viewPager);
            this.M = hVar2;
            if (!arrayList3.contains(hVar2)) {
                arrayList3.add(hVar2);
            }
            viewPager.getAdapter();
            if (this.Q == null) {
                this.Q = new o2.b(this);
            }
            o2.b bVar2 = this.Q;
            bVar2.getClass();
            if (viewPager.G == null) {
                viewPager.G = new ArrayList();
            }
            viewPager.G.add(bVar2);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.O = null;
            g();
        }
        this.R = z5;
    }

    public final void k(boolean z4) {
        float f4;
        int i4 = 0;
        while (true) {
            f fVar = this.f3905d;
            if (i4 < fVar.getChildCount()) {
                View childAt = fVar.getChildAt(i4);
                childAt.setMinimumWidth(getTabMinWidth());
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                if (this.C == 1 && this.f3927z == 0) {
                    layoutParams.width = 0;
                    f4 = 1.0f;
                } else {
                    layoutParams.width = -2;
                    f4 = 0.0f;
                }
                layoutParams.weight = f4;
                if (z4) {
                    childAt.requestLayout();
                }
                i4++;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.common.collect.c.Q1(this);
        if (this.O == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                j((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.R) {
            setupWithViewPager(null);
            this.R = false;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        TabView tabView;
        Drawable drawable;
        int i4 = 0;
        while (true) {
            f fVar = this.f3905d;
            if (i4 < fVar.getChildCount()) {
                View childAt = fVar.getChildAt(i4);
                if ((childAt instanceof TabView) && (drawable = (tabView = (TabView) childAt).f3937i) != null) {
                    drawable.setBounds(tabView.getLeft(), tabView.getTop(), tabView.getRight(), tabView.getBottom());
                    tabView.f3937i.draw(canvas);
                }
                i4++;
            } else {
                super.onDraw(canvas);
                return;
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) i0.h(1, getTabCount(), 1).f2125a);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if ((getTabMode() == 0 || getTabMode() == 2) && super.onInterceptTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        int round = Math.round(n0.c(getContext(), getDefaultHeight()));
        int mode = View.MeasureSpec.getMode(i5);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i5 = View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + getPaddingTop() + round, 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i5) >= round) {
            getChildAt(0).setMinimumHeight(round);
        }
        int size = View.MeasureSpec.getSize(i4);
        if (View.MeasureSpec.getMode(i4) != 0) {
            int i6 = this.f3924w;
            if (i6 <= 0) {
                i6 = (int) (size - n0.c(getContext(), 56));
            }
            this.f3922u = i6;
        }
        super.onMeasure(i4, i5);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i7 = this.C;
            if (i7 != 0) {
                if (i7 == 1) {
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        return;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i5, getPaddingBottom() + getPaddingTop(), childAt.getLayoutParams().height));
                } else if (i7 != 2) {
                    return;
                }
            }
            if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                return;
            }
            childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i5, getPaddingBottom() + getPaddingTop(), childAt.getLayoutParams().height));
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 8 && getTabMode() != 0 && getTabMode() != 2) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f4) {
        super.setElevation(f4);
        com.google.common.collect.c.O1(this, f4);
    }

    public void setInlineLabel(boolean z4) {
        if (this.D != z4) {
            this.D = z4;
            int i4 = 0;
            while (true) {
                f fVar = this.f3905d;
                if (i4 < fVar.getChildCount()) {
                    View childAt = fVar.getChildAt(i4);
                    if (childAt instanceof TabView) {
                        TabView tabView = (TabView) childAt;
                        tabView.setOrientation(!TabLayout.this.D ? 1 : 0);
                        TextView textView = tabView.f3935g;
                        if (textView == null && tabView.f3936h == null) {
                            tabView.g(tabView.f3930b, tabView.f3931c, true);
                        } else {
                            tabView.g(textView, tabView.f3936h, false);
                        }
                    }
                    i4++;
                } else {
                    c();
                    return;
                }
            }
        }
    }

    public void setInlineLabelResource(@BoolRes int i4) {
        setInlineLabel(getResources().getBoolean(i4));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable o2.c cVar) {
        o2.c cVar2 = this.K;
        ArrayList arrayList = this.L;
        if (cVar2 != null) {
            arrayList.remove(cVar2);
        }
        this.K = cVar;
        if (cVar == null || arrayList.contains(cVar)) {
            return;
        }
        arrayList.add(cVar);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        f();
        this.N.addListener(animatorListener);
    }

    public void setScrollPosition(int i4, float f4, boolean z4) {
        setScrollPosition(i4, f4, z4, true);
    }

    public void setSelectedTabIndicator(@DrawableRes int i4) {
        setSelectedTabIndicator(i4 != 0 ? com.google.common.collect.c.t0(getContext(), i4) : null);
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i4) {
        this.f3917p = i4;
        Drawable drawable = this.f3916o;
        if (i4 != 0) {
            c0.b.g(drawable, i4);
        } else {
            c0.b.h(drawable, null);
        }
        k(false);
    }

    public void setSelectedTabIndicatorGravity(int i4) {
        if (this.B != i4) {
            this.B = i4;
            WeakHashMap weakHashMap = y0.f4999a;
            g0.k(this.f3905d);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i4) {
        this.F = i4;
        this.f3905d.b(i4);
    }

    public void setTabGravity(int i4) {
        if (this.f3927z != i4) {
            this.f3927z = i4;
            c();
        }
    }

    public void setTabIconTint(@Nullable ColorStateList colorStateList) {
        if (this.f3914m != colorStateList) {
            this.f3914m = colorStateList;
            ArrayList arrayList = this.f3903b;
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                TabView tabView = ((b) arrayList.get(i4)).f3946g;
                if (tabView != null) {
                    tabView.d();
                }
            }
        }
    }

    public void setTabIconTintResource(@ColorRes int i4) {
        setTabIconTint(e.b(getContext(), i4));
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.google.android.material.tabs.a, java.lang.Object] */
    public void setTabIndicatorAnimationMode(int i4) {
        o2.a aVar;
        this.G = i4;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    aVar = new o2.a(1);
                } else {
                    throw new IllegalArgumentException(i4 + " is not a valid TabIndicatorAnimationMode");
                }
            } else {
                aVar = new o2.a(0);
            }
            this.I = aVar;
            return;
        }
        this.I = new Object();
    }

    public void setTabIndicatorFullWidth(boolean z4) {
        this.E = z4;
        int i4 = f.f5975c;
        f fVar = this.f3905d;
        fVar.a(fVar.f5977b.getSelectedTabPosition());
        WeakHashMap weakHashMap = y0.f4999a;
        g0.k(fVar);
    }

    public void setTabMode(int i4) {
        if (i4 != this.C) {
            this.C = i4;
            c();
        }
    }

    public void setTabRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.f3915n != colorStateList) {
            this.f3915n = colorStateList;
            int i4 = 0;
            while (true) {
                f fVar = this.f3905d;
                if (i4 < fVar.getChildCount()) {
                    View childAt = fVar.getChildAt(i4);
                    if (childAt instanceof TabView) {
                        Context context = getContext();
                        int i5 = TabView.f3928l;
                        ((TabView) childAt).e(context);
                    }
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    public void setTabRippleColorResource(@ColorRes int i4) {
        setTabRippleColor(e.b(getContext(), i4));
    }

    public void setTabTextColors(int i4, int i5) {
        setTabTextColors(e(i4, i5));
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable f1.a aVar) {
        g();
    }

    public void setUnboundedRipple(boolean z4) {
        if (this.H != z4) {
            this.H = z4;
            int i4 = 0;
            while (true) {
                f fVar = this.f3905d;
                if (i4 < fVar.getChildCount()) {
                    View childAt = fVar.getChildAt(i4);
                    if (childAt instanceof TabView) {
                        Context context = getContext();
                        int i5 = TabView.f3928l;
                        ((TabView) childAt).e(context);
                    }
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    public void setUnboundedRippleResource(@BoolRes int i4) {
        setUnboundedRipple(getResources().getBoolean(i4));
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabStyle);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i4) {
        a(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public void setScrollPosition(int i4, float f4, boolean z4, boolean z5) {
        i(i4, f4, z4, z5, true);
    }

    public void setSelectedTabIndicator(@Nullable Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable mutate = drawable.mutate();
        this.f3916o = mutate;
        int i4 = this.f3917p;
        if (i4 != 0) {
            c0.b.g(mutate, i4);
        } else {
            c0.b.h(mutate, null);
        }
        int i5 = this.F;
        if (i5 == -1) {
            i5 = this.f3916o.getIntrinsicHeight();
        }
        this.f3905d.b(i5);
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.f3913l != colorStateList) {
            this.f3913l = colorStateList;
            ArrayList arrayList = this.f3903b;
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                TabView tabView = ((b) arrayList.get(i4)).f3946g;
                if (tabView != null) {
                    tabView.d();
                }
            }
        }
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager, boolean z4) {
        j(viewPager, z4, false);
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(p2.a.a(context, attributeSet, i4, 2131755831), attributeSet, i4);
        this.f3902a = -1;
        this.f3903b = new ArrayList();
        this.f3912k = -1;
        this.f3917p = 0;
        this.f3922u = Integer.MAX_VALUE;
        this.F = -1;
        this.L = new ArrayList();
        this.T = new p.g(12, 1);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        f fVar = new f(this, context2);
        this.f3905d = fVar;
        super.addView(fVar, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray d4 = com.google.android.material.internal.h0.d(context2, attributeSet, o1.a.f5941c0, i4, 2131755831, 24);
        if (getBackground() instanceof ColorDrawable) {
            j jVar = new j();
            jVar.o(ColorStateList.valueOf(((ColorDrawable) getBackground()).getColor()));
            jVar.l(context2);
            WeakHashMap weakHashMap = y0.f4999a;
            jVar.n(m0.i(this));
            g0.q(this, jVar);
        }
        setSelectedTabIndicator(i2.d.d(context2, d4, 5));
        setSelectedTabIndicatorColor(d4.getColor(8, 0));
        fVar.b(d4.getDimensionPixelSize(11, -1));
        setSelectedTabIndicatorGravity(d4.getInt(10, 0));
        setTabIndicatorAnimationMode(d4.getInt(7, 0));
        setTabIndicatorFullWidth(d4.getBoolean(9, true));
        int dimensionPixelSize = d4.getDimensionPixelSize(16, 0);
        this.f3909h = dimensionPixelSize;
        this.f3908g = dimensionPixelSize;
        this.f3907f = dimensionPixelSize;
        this.f3906e = dimensionPixelSize;
        this.f3906e = d4.getDimensionPixelSize(19, dimensionPixelSize);
        this.f3907f = d4.getDimensionPixelSize(20, dimensionPixelSize);
        this.f3908g = d4.getDimensionPixelSize(18, dimensionPixelSize);
        this.f3909h = d4.getDimensionPixelSize(17, dimensionPixelSize);
        this.f3910i = i2.c.b(context2, R.attr.isMaterial3Theme, false) ? R.attr.textAppearanceTitleSmall : R.attr.textAppearanceButton;
        int resourceId = d4.getResourceId(24, 2131755474);
        this.f3911j = resourceId;
        int[] iArr = c.a.f2568z;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(resourceId, iArr);
        try {
            float dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            this.f3919r = dimensionPixelSize2;
            this.f3913l = i2.d.a(context2, obtainStyledAttributes, 3);
            obtainStyledAttributes.recycle();
            if (d4.hasValue(22)) {
                this.f3912k = d4.getResourceId(22, resourceId);
            }
            int i5 = this.f3912k;
            if (i5 != -1) {
                obtainStyledAttributes = context2.obtainStyledAttributes(i5, iArr);
                try {
                    obtainStyledAttributes.getDimensionPixelSize(0, (int) dimensionPixelSize2);
                    ColorStateList a5 = i2.d.a(context2, obtainStyledAttributes, 3);
                    if (a5 != null) {
                        this.f3913l = e(this.f3913l.getDefaultColor(), a5.getColorForState(new int[]{16842913}, a5.getDefaultColor()));
                    }
                } finally {
                }
            }
            if (d4.hasValue(25)) {
                this.f3913l = i2.d.a(context2, d4, 25);
            }
            if (d4.hasValue(23)) {
                this.f3913l = e(this.f3913l.getDefaultColor(), d4.getColor(23, 0));
            }
            this.f3914m = i2.d.a(context2, d4, 3);
            this.f3918q = n0.g(d4.getInt(4, -1), null);
            this.f3915n = i2.d.a(context2, d4, 21);
            this.A = d4.getInt(6, 300);
            this.J = com.google.common.collect.c.L1(context2, R.attr.motionEasingEmphasizedInterpolator, p1.a.f6129b);
            this.f3923v = d4.getDimensionPixelSize(14, -1);
            this.f3924w = d4.getDimensionPixelSize(13, -1);
            this.f3921t = d4.getResourceId(0, 0);
            this.f3926y = d4.getDimensionPixelSize(1, 0);
            this.C = d4.getInt(15, 1);
            this.f3927z = d4.getInt(2, 0);
            this.D = d4.getBoolean(12, false);
            this.H = d4.getBoolean(26, false);
            d4.recycle();
            Resources resources = getResources();
            this.f3920s = resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.f3925x = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            c();
        } finally {
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable o2.d dVar) {
        setOnTabSelectedListener((o2.c) dVar);
    }
}
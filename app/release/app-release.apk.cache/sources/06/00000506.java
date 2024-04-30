package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.c0;
import androidx.appcompat.widget.j3;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.a;
import androidx.coordinatorlayout.widget.b;
import com.example.msphone.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import d2.c;
import d2.e;
import d2.f;
import d2.g;
import d2.h;
import i0.h0;
import i0.y0;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l2.p;

/* loaded from: classes.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements a {
    public static final j3 I = new j3(Float.class, "width", 11);
    public static final j3 J = new j3(Float.class, "height", 12);
    public static final j3 K = new j3(Float.class, "paddingStart", 13);
    public static final j3 L = new j3(Float.class, "paddingEnd", 14);
    public int A;
    public final ExtendedFloatingActionButtonBehavior B;
    public boolean C;
    public boolean D;
    public boolean E;
    public ColorStateList F;
    public int G;
    public int H;

    /* renamed from: t  reason: collision with root package name */
    public int f3392t;

    /* renamed from: u  reason: collision with root package name */
    public final e f3393u;

    /* renamed from: v  reason: collision with root package name */
    public final e f3394v;

    /* renamed from: w  reason: collision with root package name */
    public final g f3395w;

    /* renamed from: x  reason: collision with root package name */
    public final f f3396x;

    /* renamed from: y  reason: collision with root package name */
    public final int f3397y;

    /* renamed from: z  reason: collision with root package name */
    public int f3398z;

    public ExtendedFloatingActionButton(@NonNull Context context) {
        this(context, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0044, code lost:
        if (r4.E == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void f(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton r4, int r5) {
        /*
            r0 = 1
            r1 = 2
            if (r5 == 0) goto L20
            if (r5 == r0) goto L1d
            if (r5 == r1) goto L1a
            r2 = 3
            if (r5 != r2) goto Le
            d2.e r2 = r4.f3394v
            goto L22
        Le:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "Unknown strategy type: "
            java.lang.String r5 = androidx.activity.j.b(r0, r5)
            r4.<init>(r5)
            throw r4
        L1a:
            d2.e r2 = r4.f3393u
            goto L22
        L1d:
            d2.f r2 = r4.f3396x
            goto L22
        L20:
            d2.g r2 = r4.f3395w
        L22:
            boolean r3 = r2.h()
            if (r3 == 0) goto L2a
            goto L95
        L2a:
            java.util.WeakHashMap r3 = i0.y0.f4999a
            boolean r3 = i0.j0.c(r4)
            if (r3 != 0) goto L46
            int r3 = r4.getVisibility()
            if (r3 == 0) goto L3d
            int r0 = r4.f3392t
            if (r0 != r1) goto L42
            goto L92
        L3d:
            int r3 = r4.f3392t
            if (r3 == r0) goto L42
            goto L92
        L42:
            boolean r0 = r4.E
            if (r0 == 0) goto L92
        L46:
            boolean r0 = r4.isInEditMode()
            if (r0 != 0) goto L92
            if (r5 != r1) goto L68
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            if (r5 == 0) goto L5d
            int r0 = r5.width
            r4.G = r0
            int r5 = r5.height
        L5a:
            r4.H = r5
            goto L68
        L5d:
            int r5 = r4.getWidth()
            r4.G = r5
            int r5 = r4.getHeight()
            goto L5a
        L68:
            r5 = 0
            r4.measure(r5, r5)
            android.animation.AnimatorSet r4 = r2.a()
            d2.d r5 = new d2.d
            r5.<init>(r2)
            r4.addListener(r5)
            java.util.ArrayList r5 = r2.f4336c
            java.util.Iterator r5 = r5.iterator()
        L7e:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L8e
            java.lang.Object r0 = r5.next()
            android.animation.Animator$AnimatorListener r0 = (android.animation.Animator.AnimatorListener) r0
            r4.addListener(r0)
            goto L7e
        L8e:
            r4.start()
            goto L95
        L92:
            r2.g()
        L95:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.f(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton, int):void");
    }

    public final void g(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    @Override // androidx.coordinatorlayout.widget.a
    @NonNull
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.B;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    @VisibleForTesting
    public int getCollapsedSize() {
        int i4 = this.f3397y;
        if (i4 < 0) {
            WeakHashMap weakHashMap = y0.f4999a;
            return (Math.min(h0.f(this), h0.e(this)) * 2) + getIconSize();
        }
        return i4;
    }

    @Nullable
    public p1.f getExtendMotionSpec() {
        return this.f3394v.f4339f;
    }

    @Nullable
    public p1.f getHideMotionSpec() {
        return this.f3396x.f4339f;
    }

    @Nullable
    public p1.f getShowMotionSpec() {
        return this.f3395w.f4339f;
    }

    @Nullable
    public p1.f getShrinkMotionSpec() {
        return this.f3393u.f4339f;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.C && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.C = false;
            this.f3393u.g();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z4) {
        this.E = z4;
    }

    public void setExtendMotionSpec(@Nullable p1.f fVar) {
        this.f3394v.f4339f = fVar;
    }

    public void setExtendMotionSpecResource(@AnimatorRes int i4) {
        setExtendMotionSpec(p1.f.b(getContext(), i4));
    }

    public void setExtended(boolean z4) {
        if (this.C == z4) {
            return;
        }
        e eVar = z4 ? this.f3394v : this.f3393u;
        if (eVar.h()) {
            return;
        }
        eVar.g();
    }

    public void setHideMotionSpec(@Nullable p1.f fVar) {
        this.f3396x.f4339f = fVar;
    }

    public void setHideMotionSpecResource(@AnimatorRes int i4) {
        setHideMotionSpec(p1.f.b(getContext(), i4));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i4, int i5, int i6, int i7) {
        super.setPadding(i4, i5, i6, i7);
        if (this.C && !this.D) {
            WeakHashMap weakHashMap = y0.f4999a;
            this.f3398z = h0.f(this);
            this.A = h0.e(this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i4, int i5, int i6, int i7) {
        super.setPaddingRelative(i4, i5, i6, i7);
        if (!this.C || this.D) {
            return;
        }
        this.f3398z = i4;
        this.A = i6;
    }

    public void setShowMotionSpec(@Nullable p1.f fVar) {
        this.f3395w.f4339f = fVar;
    }

    public void setShowMotionSpecResource(@AnimatorRes int i4) {
        setShowMotionSpec(p1.f.b(getContext(), i4));
    }

    public void setShrinkMotionSpec(@Nullable p1.f fVar) {
        this.f3393u.f4339f = fVar;
    }

    public void setShrinkMotionSpecResource(@AnimatorRes int i4) {
        setShrinkMotionSpec(p1.f.b(getContext(), i4));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i4) {
        super.setTextColor(i4);
        this.F = getTextColors();
    }

    /* loaded from: classes.dex */
    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* renamed from: a  reason: collision with root package name */
        public Rect f3399a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f3400b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f3401c;

        public ExtendedFloatingActionButtonBehavior() {
            this.f3400b = false;
            this.f3401c = true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ boolean e(View view, Rect rect) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void g(b bVar) {
            if (bVar.f1354h == 0) {
                bVar.f1354h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                w(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton);
                return false;
            }
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if ((layoutParams instanceof b) && (((b) layoutParams).f1347a instanceof BottomSheetBehavior)) {
                x(view2, extendedFloatingActionButton);
                return false;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i4) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            ArrayList o4 = coordinatorLayout.o(extendedFloatingActionButton);
            int size = o4.size();
            for (int i5 = 0; i5 < size; i5++) {
                View view2 = (View) o4.get(i5);
                if (view2 instanceof AppBarLayout) {
                    if (w(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof b) && (((b) layoutParams).f1347a instanceof BottomSheetBehavior) && x(view2, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.v(i4, extendedFloatingActionButton);
            return true;
        }

        public final boolean w(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            int i4;
            b bVar = (b) extendedFloatingActionButton.getLayoutParams();
            int i5 = 0;
            if ((!this.f3400b && !this.f3401c) || bVar.f1352f != appBarLayout.getId()) {
                return false;
            }
            if (this.f3399a == null) {
                this.f3399a = new Rect();
            }
            Rect rect = this.f3399a;
            com.google.android.material.internal.e.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                if (this.f3401c) {
                    i4 = 2;
                } else {
                    i4 = 1;
                }
                ExtendedFloatingActionButton.f(extendedFloatingActionButton, i4);
            } else {
                if (this.f3401c) {
                    i5 = 3;
                }
                ExtendedFloatingActionButton.f(extendedFloatingActionButton, i5);
            }
            return true;
        }

        public final boolean x(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            b bVar = (b) extendedFloatingActionButton.getLayoutParams();
            int i4 = 0;
            if ((!this.f3400b && !this.f3401c) || bVar.f1352f != view.getId()) {
                return false;
            }
            int i5 = 2;
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((b) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                if (!this.f3401c) {
                    i5 = 1;
                }
                ExtendedFloatingActionButton.f(extendedFloatingActionButton, i5);
            } else {
                if (this.f3401c) {
                    i4 = 3;
                }
                ExtendedFloatingActionButton.f(extendedFloatingActionButton, i4);
            }
            return true;
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o1.a.f5960q);
            this.f3400b = obtainStyledAttributes.getBoolean(0, false);
            this.f3401c = obtainStyledAttributes.getBoolean(1, true);
            obtainStyledAttributes.recycle();
        }
    }

    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.extendedFloatingActionButtonStyle);
    }

    @Override // android.widget.TextView
    public void setTextColor(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        this.F = getTextColors();
    }

    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(p2.a.a(context, attributeSet, i4, 2131756046), attributeSet, i4);
        boolean z4;
        c0 c0Var;
        this.f3392t = 0;
        w1.g gVar = new w1.g(1);
        g gVar2 = new g(this, gVar);
        this.f3395w = gVar2;
        f fVar = new f(this, gVar);
        this.f3396x = fVar;
        this.C = true;
        this.D = false;
        this.E = false;
        Context context2 = getContext();
        this.B = new ExtendedFloatingActionButtonBehavior(context2, attributeSet);
        TypedArray d4 = com.google.android.material.internal.h0.d(context2, attributeSet, o1.a.f5959p, i4, 2131756046, new int[0]);
        p1.f a5 = p1.f.a(context2, d4, 5);
        p1.f a6 = p1.f.a(context2, d4, 4);
        p1.f a7 = p1.f.a(context2, d4, 2);
        p1.f a8 = p1.f.a(context2, d4, 6);
        this.f3397y = d4.getDimensionPixelSize(0, -1);
        int i5 = d4.getInt(3, 1);
        WeakHashMap weakHashMap = y0.f4999a;
        this.f3398z = h0.f(this);
        this.A = h0.e(this);
        w1.g gVar3 = new w1.g(1);
        c cVar = new c(this, 1);
        c0 c0Var2 = new c0(10, (View) this, (Object) cVar);
        h cVar2 = new androidx.appcompat.app.c((Object) this, c0Var2, cVar);
        if (i5 != 1) {
            c0Var = i5 != 2 ? cVar2 : c0Var2;
            z4 = true;
        } else {
            z4 = true;
            c0Var = cVar;
        }
        e eVar = new e(this, gVar3, c0Var, z4);
        this.f3394v = eVar;
        e eVar2 = new e(this, gVar3, new c(this, 0), false);
        this.f3393u = eVar2;
        gVar2.f4339f = a5;
        fVar.f4339f = a6;
        eVar.f4339f = a7;
        eVar2.f4339f = a8;
        d4.recycle();
        setShapeAppearanceModel(p.d(context2, attributeSet, i4, 2131756046, p.f5347m).a());
        this.F = getTextColors();
    }
}
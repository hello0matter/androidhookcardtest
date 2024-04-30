package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.example.msphone.R;
import java.util.WeakHashMap;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.f171c})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements k1, i0.t, i0.u {
    public static final int[] B = {R.attr.actionBarSize, 16842841};
    public final i0.v A;

    /* renamed from: a  reason: collision with root package name */
    public int f427a;

    /* renamed from: b  reason: collision with root package name */
    public int f428b;

    /* renamed from: c  reason: collision with root package name */
    public ContentFrameLayout f429c;

    /* renamed from: d  reason: collision with root package name */
    public ActionBarContainer f430d;

    /* renamed from: e  reason: collision with root package name */
    public l1 f431e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f432f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f433g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f434h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f435i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f436j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f437k;

    /* renamed from: l  reason: collision with root package name */
    public int f438l;

    /* renamed from: m  reason: collision with root package name */
    public int f439m;

    /* renamed from: n  reason: collision with root package name */
    public final Rect f440n;

    /* renamed from: o  reason: collision with root package name */
    public final Rect f441o;

    /* renamed from: p  reason: collision with root package name */
    public final Rect f442p;

    /* renamed from: q  reason: collision with root package name */
    public i0.g2 f443q;

    /* renamed from: r  reason: collision with root package name */
    public i0.g2 f444r;

    /* renamed from: s  reason: collision with root package name */
    public i0.g2 f445s;

    /* renamed from: t  reason: collision with root package name */
    public i0.g2 f446t;

    /* renamed from: u  reason: collision with root package name */
    public g f447u;

    /* renamed from: v  reason: collision with root package name */
    public OverScroller f448v;

    /* renamed from: w  reason: collision with root package name */
    public ViewPropertyAnimator f449w;

    /* renamed from: x  reason: collision with root package name */
    public final e f450x;

    /* renamed from: y  reason: collision with root package name */
    public final f f451y;

    /* renamed from: z  reason: collision with root package name */
    public final f f452z;

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public ActionBarOverlayLayout(@NonNull Context context) {
        this(context, null);
    }

    public static boolean a(FrameLayout frameLayout, Rect rect, boolean z4) {
        boolean z5;
        LayoutParams layoutParams = (LayoutParams) frameLayout.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        int i5 = rect.left;
        if (i4 != i5) {
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i5;
            z5 = true;
        } else {
            z5 = false;
        }
        int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        int i7 = rect.top;
        if (i6 != i7) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i7;
            z5 = true;
        }
        int i8 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int i9 = rect.right;
        if (i8 != i9) {
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i9;
            z5 = true;
        }
        if (z4) {
            int i10 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            int i11 = rect.bottom;
            if (i10 != i11) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i11;
                return true;
            }
        }
        return z5;
    }

    @Override // i0.t
    public final void b(View view, View view2, int i4, int i5) {
        if (i5 == 0) {
            onNestedScrollAccepted(view, view2, i4);
        }
    }

    public final void c() {
        removeCallbacks(this.f451y);
        removeCallbacks(this.f452z);
        ViewPropertyAnimator viewPropertyAnimator = this.f449w;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // i0.t
    public final void d(View view, int i4, int i5, int[] iArr, int i6) {
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i4;
        super.draw(canvas);
        if (this.f432f == null || this.f433g) {
            return;
        }
        if (this.f430d.getVisibility() == 0) {
            i4 = (int) (this.f430d.getTranslationY() + this.f430d.getBottom() + 0.5f);
        } else {
            i4 = 0;
        }
        this.f432f.setBounds(0, i4, getWidth(), this.f432f.getIntrinsicHeight() + i4);
        this.f432f.draw(canvas);
    }

    @Override // i0.t
    public final void e(int i4, View view) {
        if (i4 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // i0.u
    public final void f(View view, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
        i(view, i4, i5, i6, i7, i8);
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    public final void g(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(B);
        this.f427a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f432f = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        this.f433g = context.getApplicationInfo().targetSdkVersion < 19;
        this.f448v = new OverScroller(context);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f430d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        i0.v vVar = this.A;
        return vVar.f4990b | vVar.f4989a;
    }

    public CharSequence getTitle() {
        k();
        return ((x3) this.f431e).f950a.getTitle();
    }

    public final void h(int i4) {
        k();
        if (i4 != 2) {
            if (i4 != 5) {
                if (i4 == 109) {
                    setOverlayMode(true);
                    return;
                }
                return;
            }
            ((x3) this.f431e).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
            return;
        }
        ((x3) this.f431e).getClass();
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // i0.t
    public final void i(View view, int i4, int i5, int i6, int i7, int i8) {
        if (i8 == 0) {
            onNestedScroll(view, i4, i5, i6, i7);
        }
    }

    @Override // i0.t
    public final boolean j(View view, View view2, int i4, int i5) {
        return i5 == 0 && onStartNestedScroll(view, view2, i4);
    }

    public final void k() {
        l1 wrapper;
        if (this.f429c == null) {
            this.f429c = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f430d = (ActionBarContainer) findViewById(R.id.action_bar_container);
            View findViewById = findViewById(R.id.action_bar);
            if (findViewById instanceof l1) {
                wrapper = (l1) findViewById;
            } else if (findViewById instanceof Toolbar) {
                wrapper = ((Toolbar) findViewById).getWrapper();
            } else {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(findViewById.getClass().getSimpleName()));
            }
            this.f431e = wrapper;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0053, code lost:
        if (r0 != false) goto L7;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.WindowInsets onApplyWindowInsets(android.view.WindowInsets r7) {
        /*
            r6 = this;
            r6.k()
            i0.g2 r7 = i0.g2.h(r6, r7)
            android.graphics.Rect r0 = new android.graphics.Rect
            int r1 = r7.b()
            int r2 = r7.d()
            int r3 = r7.c()
            int r4 = r7.a()
            r0.<init>(r1, r2, r3, r4)
            androidx.appcompat.widget.ActionBarContainer r1 = r6.f430d
            r2 = 0
            boolean r0 = a(r1, r0, r2)
            java.util.WeakHashMap r1 = i0.y0.f4999a
            android.graphics.Rect r1 = r6.f440n
            i0.m0.b(r6, r7, r1)
            int r2 = r1.left
            int r3 = r1.top
            int r4 = r1.right
            int r5 = r1.bottom
            i0.d2 r7 = r7.f4931a
            i0.g2 r2 = r7.l(r2, r3, r4, r5)
            r6.f443q = r2
            i0.g2 r3 = r6.f444r
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L47
            i0.g2 r0 = r6.f443q
            r6.f444r = r0
            r0 = 1
        L47:
            android.graphics.Rect r2 = r6.f441o
            boolean r3 = r2.equals(r1)
            if (r3 != 0) goto L53
            r2.set(r1)
            goto L55
        L53:
            if (r0 == 0) goto L58
        L55:
            r6.requestLayout()
        L58:
            i0.g2 r7 = r7.a()
            i0.d2 r7 = r7.f4931a
            i0.g2 r7 = r7.c()
            i0.d2 r7 = r7.f4931a
            i0.g2 r7 = r7.b()
            android.view.WindowInsets r7 = r7.g()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.onApplyWindowInsets(android.view.WindowInsets):android.view.WindowInsets");
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        g(getContext());
        WeakHashMap weakHashMap = i0.y0.f4999a;
        i0.k0.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i9 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                int i10 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                childAt.layout(i9, i10, measuredWidth + i9, measuredHeight + i10);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        boolean z4;
        int measuredHeight;
        i0.x1 t1Var;
        i0.g2 b5;
        k();
        measureChildWithMargins(this.f430d, i4, 0, i5, 0);
        LayoutParams layoutParams = (LayoutParams) this.f430d.getLayoutParams();
        int max = Math.max(0, this.f430d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
        int max2 = Math.max(0, this.f430d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f430d.getMeasuredState());
        WeakHashMap weakHashMap = i0.y0.f4999a;
        if ((i0.g0.g(this) & 256) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            measuredHeight = this.f427a;
            if (this.f435i && this.f430d.getTabContainer() != null) {
                measuredHeight += this.f427a;
            }
        } else {
            measuredHeight = this.f430d.getVisibility() != 8 ? this.f430d.getMeasuredHeight() : 0;
        }
        Rect rect = this.f440n;
        Rect rect2 = this.f442p;
        rect2.set(rect);
        i0.g2 g2Var = this.f443q;
        this.f445s = g2Var;
        if (!this.f434h && !z4) {
            rect2.top += measuredHeight;
            rect2.bottom = rect2.bottom;
            b5 = g2Var.f4931a.l(0, measuredHeight, 0, 0);
        } else {
            b0.c b6 = b0.c.b(g2Var.b(), this.f445s.d() + measuredHeight, this.f445s.c(), this.f445s.a());
            i0.g2 g2Var2 = this.f445s;
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 30) {
                t1Var = new i0.w1(g2Var2);
            } else if (i6 >= 29) {
                t1Var = new i0.v1(g2Var2);
            } else {
                t1Var = new i0.t1(g2Var2);
            }
            t1Var.g(b6);
            b5 = t1Var.b();
        }
        this.f445s = b5;
        a(this.f429c, rect2, true);
        if (!this.f446t.equals(this.f445s)) {
            i0.g2 g2Var3 = this.f445s;
            this.f446t = g2Var3;
            i0.y0.b(this.f429c, g2Var3);
        }
        measureChildWithMargins(this.f429c, i4, 0, i5, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.f429c.getLayoutParams();
        int max3 = Math.max(max, this.f429c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
        int max4 = Math.max(max2, this.f429c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f429c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + max3, getSuggestedMinimumWidth()), i4, combineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + max4, getSuggestedMinimumHeight()), i5, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f4, float f5, boolean z4) {
        if (this.f436j && z4) {
            this.f448v.fling(0, 0, 0, (int) f5, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
            if (this.f448v.getFinalY() > this.f430d.getHeight()) {
                c();
                this.f452z.run();
            } else {
                c();
                this.f451y.run();
            }
            this.f437k = true;
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f4, float f5) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i4, int i5, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i4, int i5, int i6, int i7) {
        int i8 = this.f438l + i5;
        this.f438l = i8;
        setActionBarHideOffset(i8);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i4) {
        androidx.appcompat.app.u0 u0Var;
        f.n nVar;
        this.A.f4989a = i4;
        this.f438l = getActionBarHideOffset();
        c();
        g gVar = this.f447u;
        if (gVar != null && (nVar = (u0Var = (androidx.appcompat.app.u0) gVar).f362s) != null) {
            nVar.a();
            u0Var.f362s = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i4) {
        if ((i4 & 2) == 0 || this.f430d.getVisibility() != 0) {
            return false;
        }
        return this.f436j;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (this.f436j && !this.f437k) {
            if (this.f438l <= this.f430d.getHeight()) {
                c();
                postDelayed(this.f451y, 600L);
                return;
            }
            c();
            postDelayed(this.f452z, 600L);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i4) {
        boolean z4;
        boolean z5;
        super.onWindowSystemUiVisibilityChanged(i4);
        k();
        int i5 = this.f439m ^ i4;
        this.f439m = i4;
        if ((i4 & 4) == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if ((i4 & 256) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        g gVar = this.f447u;
        if (gVar != null) {
            ((androidx.appcompat.app.u0) gVar).f358o = !z5;
            if (!z4 && z5) {
                androidx.appcompat.app.u0 u0Var = (androidx.appcompat.app.u0) gVar;
                if (!u0Var.f359p) {
                    u0Var.f359p = true;
                    u0Var.f(true);
                }
            } else {
                androidx.appcompat.app.u0 u0Var2 = (androidx.appcompat.app.u0) gVar;
                if (u0Var2.f359p) {
                    u0Var2.f359p = false;
                    u0Var2.f(true);
                }
            }
        }
        if ((i5 & 256) != 0 && this.f447u != null) {
            WeakHashMap weakHashMap = i0.y0.f4999a;
            i0.k0.c(this);
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        this.f428b = i4;
        g gVar = this.f447u;
        if (gVar != null) {
            ((androidx.appcompat.app.u0) gVar).f357n = i4;
        }
    }

    public void setActionBarHideOffset(int i4) {
        c();
        this.f430d.setTranslationY(-Math.max(0, Math.min(i4, this.f430d.getHeight())));
    }

    public void setActionBarVisibilityCallback(g gVar) {
        this.f447u = gVar;
        if (getWindowToken() != null) {
            ((androidx.appcompat.app.u0) this.f447u).f357n = this.f428b;
            int i4 = this.f439m;
            if (i4 != 0) {
                onWindowSystemUiVisibilityChanged(i4);
                WeakHashMap weakHashMap = i0.y0.f4999a;
                i0.k0.c(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z4) {
        this.f435i = z4;
    }

    public void setHideOnContentScrollEnabled(boolean z4) {
        if (z4 != this.f436j) {
            this.f436j = z4;
            if (z4) {
                return;
            }
            c();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i4) {
        k();
        x3 x3Var = (x3) this.f431e;
        x3Var.f954e = i4 != 0 ? com.google.common.collect.c.t0(x3Var.f950a.getContext(), i4) : null;
        x3Var.c();
    }

    public void setLogo(int i4) {
        Drawable drawable;
        k();
        x3 x3Var = (x3) this.f431e;
        if (i4 != 0) {
            drawable = com.google.common.collect.c.t0(x3Var.f950a.getContext(), i4);
        } else {
            drawable = null;
        }
        x3Var.f955f = drawable;
        x3Var.c();
    }

    @Override // androidx.appcompat.widget.k1
    public void setMenu(Menu menu, g.c0 c0Var) {
        k();
        x3 x3Var = (x3) this.f431e;
        n nVar = x3Var.f963n;
        Toolbar toolbar = x3Var.f950a;
        if (nVar == null) {
            n nVar2 = new n(toolbar.getContext());
            x3Var.f963n = nVar2;
            nVar2.f4617i = R.id.action_menu_presenter;
        }
        n nVar3 = x3Var.f963n;
        nVar3.f4613e = c0Var;
        toolbar.setMenu((g.p) menu, nVar3);
    }

    @Override // androidx.appcompat.widget.k1
    public void setMenuPrepared() {
        k();
        ((x3) this.f431e).f962m = true;
    }

    public void setOverlayMode(boolean z4) {
        this.f434h = z4;
        this.f433g = z4 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z4) {
    }

    public void setUiOptions(int i4) {
    }

    @Override // androidx.appcompat.widget.k1
    public void setWindowCallback(Window.Callback callback) {
        k();
        ((x3) this.f431e).f961l = callback;
    }

    @Override // androidx.appcompat.widget.k1
    public void setWindowTitle(CharSequence charSequence) {
        k();
        x3 x3Var = (x3) this.f431e;
        if (!x3Var.f957h) {
            x3Var.f958i = charSequence;
            if ((x3Var.f951b & 8) != 0) {
                Toolbar toolbar = x3Var.f950a;
                toolbar.setTitle(charSequence);
                if (x3Var.f957h) {
                    i0.y0.q(toolbar.getRootView(), charSequence);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, i0.v] */
    public ActionBarOverlayLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f428b = 0;
        this.f440n = new Rect();
        this.f441o = new Rect();
        this.f442p = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        i0.g2 g2Var = i0.g2.f4930b;
        this.f443q = g2Var;
        this.f444r = g2Var;
        this.f445s = g2Var;
        this.f446t = g2Var;
        this.f450x = new e(0, this);
        this.f451y = new f(this, 0);
        this.f452z = new f(this, 1);
        g(context);
        this.A = new Object();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        k();
        x3 x3Var = (x3) this.f431e;
        x3Var.f954e = drawable;
        x3Var.c();
    }
}
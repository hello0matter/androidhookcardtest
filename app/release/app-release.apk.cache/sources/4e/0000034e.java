package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.activity.k;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.c0;
import androidx.customview.view.AbsSavedState;
import f1.e;
import f1.f;
import f1.g;
import f1.h;
import f1.i;
import i0.g0;
import i0.m0;
import i0.y0;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;
import n0.d;
import z.c;

/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    public static final int[] L = {16842931};
    public static final d M = new d(1);
    public static final b N = new Object();
    public boolean A;
    public boolean B;
    public int C;
    public ArrayList D;
    public h E;
    public h F;
    public ArrayList G;
    public int H;
    public ArrayList I;
    public final k J;
    public int K;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f2403a;

    /* renamed from: b  reason: collision with root package name */
    public final e f2404b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f2405c;

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f2406d;

    /* renamed from: e  reason: collision with root package name */
    public Scroller f2407e;

    /* renamed from: f  reason: collision with root package name */
    public int f2408f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f2409g;

    /* renamed from: h  reason: collision with root package name */
    public final float f2410h;

    /* renamed from: i  reason: collision with root package name */
    public final float f2411i;

    /* renamed from: j  reason: collision with root package name */
    public int f2412j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2413k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f2414l;

    /* renamed from: m  reason: collision with root package name */
    public int f2415m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f2416n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f2417o;

    /* renamed from: p  reason: collision with root package name */
    public int f2418p;

    /* renamed from: q  reason: collision with root package name */
    public int f2419q;

    /* renamed from: r  reason: collision with root package name */
    public int f2420r;

    /* renamed from: s  reason: collision with root package name */
    public float f2421s;

    /* renamed from: t  reason: collision with root package name */
    public float f2422t;

    /* renamed from: u  reason: collision with root package name */
    public float f2423u;

    /* renamed from: v  reason: collision with root package name */
    public int f2424v;

    /* renamed from: w  reason: collision with root package name */
    public VelocityTracker f2425w;

    /* renamed from: x  reason: collision with root package name */
    public int f2426x;

    /* renamed from: y  reason: collision with root package name */
    public EdgeEffect f2427y;

    /* renamed from: z  reason: collision with root package name */
    public EdgeEffect f2428z;

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface DecorView {
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2429a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2430b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.L);
            this.f2430b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: c  reason: collision with root package name */
        public int f2431c;

        /* renamed from: d  reason: collision with root package name */
        public final Parcelable f2432d;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f2431c = parcel.readInt();
            this.f2432d = parcel.readParcelable(classLoader);
        }

        public final String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f2431c + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f2431c);
            parcel.writeParcelable(this.f2432d, i4);
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, f1.e] */
    public ViewPager(@NonNull Context context) {
        super(context);
        this.f2403a = new ArrayList();
        this.f2404b = new Object();
        this.f2405c = new Rect();
        this.f2410h = -3.4028235E38f;
        this.f2411i = Float.MAX_VALUE;
        this.f2415m = 1;
        this.f2424v = -1;
        this.A = true;
        this.J = new k(9, this);
        this.K = 0;
        g();
    }

    public static boolean b(int i4, int i5, int i6, View view, boolean z4) {
        int i7;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i8 = i5 + scrollX;
                if (i8 >= childAt.getLeft() && i8 < childAt.getRight() && (i7 = i6 + scrollY) >= childAt.getTop() && i7 < childAt.getBottom() && b(i4, i8 - childAt.getLeft(), i7 - childAt.getTop(), childAt, true)) {
                    return true;
                }
            }
        }
        if (z4 && view.canScrollHorizontally(-i4)) {
            return true;
        }
        return false;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z4) {
        if (this.f2414l != z4) {
            this.f2414l = z4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0082, code lost:
        if (r4 >= r2) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009c, code lost:
        if (r4 <= r2) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(int r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.findFocus()
            r1 = 0
            if (r0 != r5) goto L9
        L7:
            r0 = r1
            goto L60
        L9:
            if (r0 == 0) goto L60
            android.view.ViewParent r2 = r0.getParent()
        Lf:
            boolean r3 = r2 instanceof android.view.ViewGroup
            if (r3 == 0) goto L1b
            if (r2 != r5) goto L16
            goto L60
        L16:
            android.view.ViewParent r2 = r2.getParent()
            goto Lf
        L1b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
        L2f:
            boolean r3 = r0 instanceof android.view.ViewGroup
            if (r3 == 0) goto L48
            java.lang.String r3 = " => "
            r2.append(r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
            goto L2f
        L48:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.<init>(r3)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "ViewPager"
            android.util.Log.e(r2, r0)
            goto L7
        L60:
            android.view.FocusFinder r1 = android.view.FocusFinder.getInstance()
            android.view.View r1 = r1.findNextFocus(r5, r0, r6)
            r2 = 1
            r3 = 0
            r4 = 17
            if (r1 == 0) goto L9e
            if (r1 == r0) goto L9e
            android.graphics.Rect r2 = r5.f2405c
            if (r6 != r4) goto L8a
            android.graphics.Rect r4 = r5.d(r1, r2)
            int r4 = r4.left
            android.graphics.Rect r2 = r5.d(r0, r2)
            int r2 = r2.left
            if (r0 == 0) goto L85
            if (r4 < r2) goto L85
            goto L9e
        L85:
            boolean r3 = r1.requestFocus()
            goto L9e
        L8a:
            r4 = 66
            if (r6 != r4) goto L9e
            android.graphics.Rect r4 = r5.d(r1, r2)
            int r4 = r4.left
            android.graphics.Rect r2 = r5.d(r0, r2)
            int r2 = r2.left
            if (r0 == 0) goto L85
            if (r4 > r2) goto L85
        L9e:
            if (r3 == 0) goto La7
            int r6 = android.view.SoundEffectConstants.getContantForFocusDirection(r6)
            r5.playSoundEffect(r6)
        La7:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.a(int):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i4, int i5) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                if (getChildAt(i6).getVisibility() == 0) {
                    e();
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i5 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addTouchables(ArrayList arrayList) {
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4).getVisibility() == 0) {
                e();
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        boolean z4;
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateDefaultLayoutParams();
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean z5 = layoutParams2.f2429a;
        if (view.getClass().getAnnotation(DecorView.class) != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        boolean z6 = z5 | z4;
        layoutParams2.f2429a = z6;
        if (this.f2413k) {
            if (!z6) {
                addViewInLayout(view, i4, layoutParams);
                return;
            }
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        super.addView(view, i4, layoutParams);
    }

    public final void c(boolean z4) {
        boolean z5;
        int i4 = 0;
        if (this.K == 2) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            setScrollingCacheEnabled(false);
            if (!this.f2407e.isFinished()) {
                this.f2407e.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f2407e.getCurrX();
                int currY = this.f2407e.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        i(currX);
                    }
                }
            }
        }
        while (true) {
            ArrayList arrayList = this.f2403a;
            if (i4 >= arrayList.size()) {
                break;
            }
            ((e) arrayList.get(i4)).getClass();
            i4++;
        }
        if (z5) {
            k kVar = this.J;
            if (z4) {
                WeakHashMap weakHashMap = y0.f4999a;
                g0.m(this, kVar);
                return;
            }
            kVar.run();
        }
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i4) {
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (!this.f2407e.isFinished() && this.f2407e.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f2407e.getCurrX();
            int currY = this.f2407e.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!i(currX)) {
                    this.f2407e.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            WeakHashMap weakHashMap = y0.f4999a;
            g0.k(this);
            return;
        }
        c(true);
    }

    public final Rect d(View view, Rect rect) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        while (true) {
            ViewParent parent = view.getParent();
            if (!(parent instanceof ViewGroup) || parent == this) {
                break;
            }
            view = (ViewGroup) parent;
            rect.left = view.getLeft() + rect.left;
            rect.right = view.getRight() + rect.right;
            rect.top = view.getTop() + rect.top;
            rect.bottom = view.getBottom() + rect.bottom;
        }
        return rect;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i4;
        boolean a5;
        if (super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            a5 = a(2);
                        } else if (keyEvent.hasModifiers(1)) {
                            a5 = a(1);
                        }
                    }
                } else if (!keyEvent.hasModifiers(2)) {
                    i4 = 66;
                    a5 = a(i4);
                }
            } else if (!keyEvent.hasModifiers(2)) {
                i4 = 17;
                a5 = a(i4);
            }
            if (a5) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            if (getChildAt(i4).getVisibility() == 0) {
                e();
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean z4;
        super.draw(canvas);
        if (getOverScrollMode() != 0) {
            this.f2427y.finish();
            this.f2428z.finish();
            return;
        }
        if (!this.f2427y.isFinished()) {
            int save = canvas.save();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int width = getWidth();
            canvas.rotate(270.0f);
            canvas.translate(getPaddingTop() + (-height), this.f2410h * width);
            this.f2427y.setSize(height, width);
            z4 = this.f2427y.draw(canvas);
            canvas.restoreToCount(save);
        } else {
            z4 = false;
        }
        if (!this.f2428z.isFinished()) {
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(90.0f);
            canvas.translate(-getPaddingTop(), (-(this.f2411i + 1.0f)) * width2);
            this.f2428z.setSize(height2, width2);
            z4 |= this.f2428z.draw(canvas);
            canvas.restoreToCount(save2);
        }
        if (z4) {
            WeakHashMap weakHashMap = y0.f4999a;
            g0.k(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f2409g;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public final void e() {
        ArrayList arrayList = this.f2403a;
        if (arrayList.size() <= 0) {
            return;
        }
        ((e) arrayList.get(0)).getClass();
        throw null;
    }

    public final e f(int i4) {
        int i5 = 0;
        while (true) {
            ArrayList arrayList = this.f2403a;
            if (i5 < arrayList.size()) {
                e eVar = (e) arrayList.get(i5);
                if (eVar.f4547a == i4) {
                    return eVar;
                }
                i5++;
            } else {
                return null;
            }
        }
    }

    public final void g() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f2407e = new Scroller(context, M);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f4 = context.getResources().getDisplayMetrics().density;
        this.f2420r = viewConfiguration.getScaledPagingTouchSlop();
        viewConfiguration.getScaledMaximumFlingVelocity();
        this.f2427y = new EdgeEffect(context);
        this.f2428z = new EdgeEffect(context);
        this.f2426x = (int) (2.0f * f4);
        this.f2418p = (int) (f4 * 16.0f);
        y0.p(this, new f(0, this));
        if (g0.c(this) == 0) {
            g0.s(this, 1);
        }
        m0.u(this, new c0(this));
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Nullable
    public f1.a getAdapter() {
        return null;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i4, int i5) {
        if (this.H == 2) {
            i5 = (i4 - 1) - i5;
        }
        ((LayoutParams) ((View) this.I.get(i5)).getLayoutParams()).getClass();
        return 0;
    }

    public int getCurrentItem() {
        return 0;
    }

    public int getOffscreenPageLimit() {
        return this.f2415m;
    }

    public int getPageMargin() {
        return this.f2408f;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void h(int r12, float r13, int r14) {
        /*
            r11 = this;
            int r14 = r11.C
            r0 = 0
            r1 = 1
            if (r14 <= 0) goto L6c
            int r14 = r11.getScrollX()
            int r2 = r11.getPaddingLeft()
            int r3 = r11.getPaddingRight()
            int r4 = r11.getWidth()
            int r5 = r11.getChildCount()
            r6 = r0
        L1b:
            if (r6 >= r5) goto L6c
            android.view.View r7 = r11.getChildAt(r6)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r8 = (androidx.viewpager.widget.ViewPager.LayoutParams) r8
            boolean r9 = r8.f2429a
            if (r9 != 0) goto L2c
            goto L69
        L2c:
            int r8 = r8.f2430b
            r8 = r8 & 7
            if (r8 == r1) goto L50
            r9 = 3
            if (r8 == r9) goto L4a
            r9 = 5
            if (r8 == r9) goto L3a
            r8 = r2
            goto L5d
        L3a:
            int r8 = r4 - r3
            int r9 = r7.getMeasuredWidth()
            int r8 = r8 - r9
            int r9 = r7.getMeasuredWidth()
            int r3 = r3 + r9
        L46:
            r10 = r8
            r8 = r2
            r2 = r10
            goto L5d
        L4a:
            int r8 = r7.getWidth()
            int r8 = r8 + r2
            goto L5d
        L50:
            int r8 = r7.getMeasuredWidth()
            int r8 = r4 - r8
            int r8 = r8 / 2
            int r8 = java.lang.Math.max(r8, r2)
            goto L46
        L5d:
            int r2 = r2 + r14
            int r9 = r7.getLeft()
            int r2 = r2 - r9
            if (r2 == 0) goto L68
            r7.offsetLeftAndRight(r2)
        L68:
            r2 = r8
        L69:
            int r6 = r6 + 1
            goto L1b
        L6c:
            f1.h r14 = r11.E
            if (r14 == 0) goto L73
            r14.a(r12, r13)
        L73:
            java.util.ArrayList r14 = r11.D
            if (r14 == 0) goto L8d
            int r14 = r14.size()
        L7b:
            if (r0 >= r14) goto L8d
            java.util.ArrayList r2 = r11.D
            java.lang.Object r2 = r2.get(r0)
            f1.h r2 = (f1.h) r2
            if (r2 == 0) goto L8a
            r2.a(r12, r13)
        L8a:
            int r0 = r0 + 1
            goto L7b
        L8d:
            f1.h r14 = r11.F
            if (r14 == 0) goto L94
            r14.a(r12, r13)
        L94:
            r11.B = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.h(int, float, int):void");
    }

    public final boolean i(int i4) {
        float f4;
        float f5;
        int i5;
        ArrayList arrayList = this.f2403a;
        if (arrayList.size() == 0) {
            if (this.A) {
                return false;
            }
            this.B = false;
            h(0, 0.0f, 0);
            if (this.B) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f4 = getScrollX() / clientWidth;
        } else {
            f4 = 0.0f;
        }
        if (clientWidth > 0) {
            f5 = this.f2408f / clientWidth;
        } else {
            f5 = 0.0f;
        }
        int i6 = -1;
        boolean z4 = true;
        float f6 = 0.0f;
        int i7 = 0;
        e eVar = null;
        while (i7 < arrayList.size()) {
            e eVar2 = (e) arrayList.get(i7);
            if (!z4 && eVar2.f4547a != (i5 = i6 + 1)) {
                e eVar3 = this.f2404b;
                eVar3.f4548b = f6 + 0.0f + f5;
                eVar3.f4547a = i5;
                throw null;
            }
            f6 = eVar2.f4548b;
            float f7 = f6 + 0.0f + f5;
            if (!z4 && f4 < f6) {
                break;
            } else if (f4 >= f7 && i7 != arrayList.size() - 1) {
                i6 = eVar2.f4547a;
                i7++;
                z4 = false;
                eVar = eVar2;
            } else {
                eVar = eVar2;
                break;
            }
        }
        int clientWidth2 = getClientWidth();
        int i8 = this.f2408f;
        int i9 = clientWidth2 + i8;
        float f8 = clientWidth2;
        int i10 = eVar.f4547a;
        float f9 = ((i4 / f8) - eVar.f4548b) / (0.0f + (i8 / f8));
        this.B = false;
        h(i10, f9, (int) (i9 * f9));
        if (this.B) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public final void j() {
        if (this.H != 0) {
            ArrayList arrayList = this.I;
            if (arrayList == null) {
                this.I = new ArrayList();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                this.I.add(getChildAt(i4));
            }
            Collections.sort(this.I, N);
        }
    }

    public final void k(int i4, int i5, int i6, int i7) {
        int min;
        if (i5 <= 0 || this.f2403a.isEmpty()) {
            e f4 = f(0);
            min = (int) ((f4 != null ? Math.min(f4.f4548b, this.f2411i) : 0.0f) * ((i4 - getPaddingLeft()) - getPaddingRight()));
            if (min == getScrollX()) {
                return;
            }
            c(false);
        } else if (!this.f2407e.isFinished()) {
            this.f2407e.setFinalX(getCurrentItem() * getClientWidth());
            return;
        } else {
            min = (int) ((getScrollX() / (((i5 - getPaddingLeft()) - getPaddingRight()) + i7)) * (((i4 - getPaddingLeft()) - getPaddingRight()) + i6));
        }
        scrollTo(min, getScrollY());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.J);
        Scroller scroller = this.f2407e;
        if (scroller != null && !scroller.isFinished()) {
            this.f2407e.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2408f <= 0 || this.f2409g == null) {
            return;
        }
        this.f2403a.size();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f4;
        int action = motionEvent.getAction() & 255;
        int i4 = 0;
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (this.f2416n) {
                    return true;
                }
                if (this.f2417o) {
                    return false;
                }
            }
            if (action != 0) {
                if (action != 2) {
                    if (action == 6) {
                        int actionIndex = motionEvent.getActionIndex();
                        if (motionEvent.getPointerId(actionIndex) == this.f2424v) {
                            if (actionIndex == 0) {
                                i4 = 1;
                            }
                            this.f2421s = motionEvent.getX(i4);
                            this.f2424v = motionEvent.getPointerId(i4);
                            VelocityTracker velocityTracker = this.f2425w;
                            if (velocityTracker != null) {
                                velocityTracker.clear();
                            }
                        }
                    }
                } else {
                    int i5 = this.f2424v;
                    if (i5 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i5);
                        float x4 = motionEvent.getX(findPointerIndex);
                        float f5 = x4 - this.f2421s;
                        float abs = Math.abs(f5);
                        float y4 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y4 - this.f2423u);
                        int i6 = (f5 > 0.0f ? 1 : (f5 == 0.0f ? 0 : -1));
                        if (i6 != 0) {
                            float f6 = this.f2421s;
                            if ((f6 >= this.f2419q || i6 <= 0) && ((f6 <= getWidth() - this.f2419q || f5 >= 0.0f) && b((int) f5, (int) x4, (int) y4, this, false))) {
                                this.f2421s = x4;
                                this.f2417o = true;
                                return false;
                            }
                        }
                        float f7 = this.f2420r;
                        if (abs > f7 && abs * 0.5f > abs2) {
                            this.f2416n = true;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                            setScrollState(1);
                            float f8 = this.f2422t;
                            float f9 = this.f2420r;
                            if (i6 > 0) {
                                f4 = f8 + f9;
                            } else {
                                f4 = f8 - f9;
                            }
                            this.f2421s = f4;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > f7) {
                            this.f2417o = true;
                        }
                        if (this.f2416n) {
                            this.f2421s = x4;
                            getScrollX();
                            getClientWidth();
                            ArrayList arrayList = this.f2403a;
                            int i7 = ((e) arrayList.get(0)).f4547a;
                            int i8 = ((e) arrayList.get(arrayList.size() - 1)).f4547a;
                            throw null;
                        }
                    }
                }
            } else {
                float x5 = motionEvent.getX();
                this.f2422t = x5;
                this.f2421s = x5;
                this.f2423u = motionEvent.getY();
                this.f2424v = motionEvent.getPointerId(0);
                this.f2417o = false;
                this.f2407e.computeScrollOffset();
                if (this.K == 2 && Math.abs(this.f2407e.getFinalX() - this.f2407e.getCurrX()) > this.f2426x) {
                    this.f2407e.abortAnimation();
                    j();
                    this.f2416n = true;
                    ViewParent parent2 = getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                    setScrollState(1);
                } else {
                    c(false);
                    this.f2416n = false;
                }
            }
            if (this.f2425w == null) {
                this.f2425w = VelocityTracker.obtain();
            }
            this.f2425w.addMovement(motionEvent);
            return this.f2416n;
        }
        this.f2424v = -1;
        this.f2416n = false;
        this.f2417o = false;
        VelocityTracker velocityTracker2 = this.f2425w;
        if (velocityTracker2 != null) {
            velocityTracker2.recycle();
            this.f2425w = null;
        }
        this.f2427y.onRelease();
        this.f2428z.onRelease();
        if (!this.f2427y.isFinished()) {
            this.f2428z.isFinished();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        int i6;
        setMeasuredDimension(View.getDefaultSize(0, i4), View.getDefaultSize(0, i5));
        int measuredWidth = getMeasuredWidth();
        this.f2419q = Math.min(measuredWidth / 10, this.f2418p);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i7 = 0;
        while (true) {
            boolean z4 = true;
            int i8 = 1073741824;
            if (i7 >= childCount) {
                break;
            }
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.f2429a) {
                int i9 = layoutParams2.f2430b;
                int i10 = i9 & 7;
                int i11 = i9 & 112;
                boolean z5 = i11 == 48 || i11 == 80;
                if (i10 != 3 && i10 != 5) {
                    z4 = false;
                }
                int i12 = Integer.MIN_VALUE;
                if (z5) {
                    i6 = Integer.MIN_VALUE;
                    i12 = 1073741824;
                } else {
                    i6 = z4 ? 1073741824 : Integer.MIN_VALUE;
                }
                int i13 = ((ViewGroup.LayoutParams) layoutParams2).width;
                if (i13 != -2) {
                    if (i13 == -1) {
                        i13 = paddingLeft;
                    }
                    i12 = 1073741824;
                } else {
                    i13 = paddingLeft;
                }
                int i14 = ((ViewGroup.LayoutParams) layoutParams2).height;
                if (i14 == -2) {
                    i14 = measuredHeight;
                    i8 = i6;
                } else if (i14 == -1) {
                    i14 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i13, i12), View.MeasureSpec.makeMeasureSpec(i14, i8));
                if (z5) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z4) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i7++;
        }
        View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f2412j = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f2413k = true;
        j();
        this.f2413k = false;
        int childCount2 = getChildCount();
        for (int i15 = 0; i15 < childCount2; i15++) {
            View childAt2 = getChildAt(i15);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.f2429a)) {
                layoutParams.getClass();
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * 0.0f), 1073741824), this.f2412j);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i4, Rect rect) {
        int i5;
        int i6;
        int i7;
        int childCount = getChildCount();
        if ((i4 & 2) != 0) {
            i6 = 1;
            i7 = childCount;
            i5 = 0;
        } else {
            i5 = childCount - 1;
            i6 = -1;
            i7 = -1;
        }
        while (i5 != i7) {
            if (getChildAt(i5).getVisibility() == 0) {
                e();
            }
            i5 += i6;
        }
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f1460a);
        this.f2406d = savedState.f2432d;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.viewpager.widget.ViewPager$SavedState, android.os.Parcelable, androidx.customview.view.AbsSavedState] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ?? absSavedState = new AbsSavedState(super.onSaveInstanceState());
        absSavedState.f2431c = 0;
        return absSavedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        if (i4 != i6) {
            int i8 = this.f2408f;
            k(i4, i6, i8, i8);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            motionEvent.getEdgeFlags();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.f2413k) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(@Nullable f1.a aVar) {
        ArrayList arrayList = this.G;
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = this.G.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((g) this.G.get(i4)).c(this);
            }
        }
    }

    public void setCurrentItem(int i4) {
        setScrollingCacheEnabled(false);
    }

    public void setOffscreenPageLimit(int i4) {
        if (i4 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i4 + " too small; defaulting to 1");
            i4 = 1;
        }
        if (i4 != this.f2415m) {
            this.f2415m = i4;
            j();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(h hVar) {
        this.E = hVar;
    }

    public void setPageMargin(int i4) {
        int i5 = this.f2408f;
        this.f2408f = i4;
        int width = getWidth();
        k(width, width, i4, i5);
        requestLayout();
    }

    public void setPageMarginDrawable(@DrawableRes int i4) {
        Context context = getContext();
        Object obj = z.e.f7215a;
        setPageMarginDrawable(c.b(context, i4));
    }

    public void setPageTransformer(boolean z4, @Nullable i iVar) {
        setPageTransformer(z4, iVar, 2);
    }

    public void setScrollState(int i4) {
        if (this.K == i4) {
            return;
        }
        this.K = i4;
        h hVar = this.E;
        if (hVar != null) {
            hVar.b(i4);
        }
        ArrayList arrayList = this.D;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                h hVar2 = (h) this.D.get(i5);
                if (hVar2 != null) {
                    hVar2.b(i4);
                }
            }
        }
        h hVar3 = this.F;
        if (hVar3 != null) {
            hVar3.b(i4);
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2409g;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public void setCurrentItem(int i4, boolean z4) {
        setScrollingCacheEnabled(false);
    }

    public void setPageTransformer(boolean z4, @Nullable i iVar, int i4) {
        boolean z5 = iVar != null;
        setChildrenDrawingOrderEnabled(z5);
        if (z5) {
            this.H = z4 ? 2 : 1;
        } else {
            this.H = 0;
        }
        if (z5) {
            j();
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, f1.e] */
    public ViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2403a = new ArrayList();
        this.f2404b = new Object();
        this.f2405c = new Rect();
        this.f2410h = -3.4028235E38f;
        this.f2411i = Float.MAX_VALUE;
        this.f2415m = 1;
        this.f2424v = -1;
        this.A = true;
        this.J = new k(9, this);
        this.K = 0;
        g();
    }

    public void setPageMarginDrawable(@Nullable Drawable drawable) {
        this.f2409g = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }
}
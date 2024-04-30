package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.msphone.R;
import i0.g0;
import i0.m0;
import i0.y0;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements i0.u, i0.r {
    public static final float B = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final j C = new j(0);
    public static final int[] D = {16843130};
    public l A;

    /* renamed from: a  reason: collision with root package name */
    public final float f1396a;

    /* renamed from: b  reason: collision with root package name */
    public long f1397b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f1398c;

    /* renamed from: d  reason: collision with root package name */
    public final OverScroller f1399d;

    /* renamed from: e  reason: collision with root package name */
    public final EdgeEffect f1400e;

    /* renamed from: f  reason: collision with root package name */
    public final EdgeEffect f1401f;

    /* renamed from: g  reason: collision with root package name */
    public int f1402g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1403h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1404i;

    /* renamed from: j  reason: collision with root package name */
    public View f1405j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1406k;

    /* renamed from: l  reason: collision with root package name */
    public VelocityTracker f1407l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f1408m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f1409n;

    /* renamed from: o  reason: collision with root package name */
    public final int f1410o;

    /* renamed from: p  reason: collision with root package name */
    public final int f1411p;

    /* renamed from: q  reason: collision with root package name */
    public final int f1412q;

    /* renamed from: r  reason: collision with root package name */
    public int f1413r;

    /* renamed from: s  reason: collision with root package name */
    public final int[] f1414s;

    /* renamed from: t  reason: collision with root package name */
    public final int[] f1415t;

    /* renamed from: u  reason: collision with root package name */
    public int f1416u;

    /* renamed from: v  reason: collision with root package name */
    public int f1417v;

    /* renamed from: w  reason: collision with root package name */
    public SavedState f1418w;

    /* renamed from: x  reason: collision with root package name */
    public final i0.v f1419x;

    /* renamed from: y  reason: collision with root package name */
    public final i0.s f1420y;

    /* renamed from: z  reason: collision with root package name */
    public float f1421z;

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: a  reason: collision with root package name */
        public int f1422a;

        public final String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f1422a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f1422a);
        }
    }

    public NestedScrollView(@NonNull Context context) {
        this(context, null);
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f1421z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f1421z = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f1421z;
    }

    public static boolean m(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && m((View) parent, view2);
    }

    public final boolean a(int i4) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i4);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus != null && n(findNextFocus, maxScrollAmount, getHeight())) {
            Rect rect = this.f1398c;
            findNextFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(findNextFocus, rect);
            g(c(rect));
            findNextFocus.requestFocus(i4);
        } else {
            if (i4 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i4 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i4 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            g(maxScrollAmount);
        }
        if (findFocus != null && findFocus.isFocused() && (!n(findFocus, 0, getHeight()))) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // i0.t
    public final void b(View view, View view2, int i4, int i5) {
        i0.v vVar = this.f1419x;
        if (i5 == 1) {
            vVar.f4990b = i4;
        } else {
            vVar.f4989a = i4;
        }
        this.f1420y.h(2, i5);
    }

    public final int c(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i5 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i4 - verticalFadingEdgeLength : i4;
        int i6 = rect.bottom;
        if (i6 > i5 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i5, (childAt.getBottom() + layoutParams.bottomMargin) - i4);
        } else if (rect.top >= scrollY || i6 >= i5) {
            return 0;
        } else {
            return Math.max(rect.height() > height ? 0 - (i5 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
        }
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void computeScroll() {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.computeScroll():void");
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    @Override // i0.t
    public final void d(View view, int i4, int i5, int[] iArr, int i6) {
        this.f1420y.c(i4, i5, iArr, null, i6);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || h(keyEvent);
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f4, float f5, boolean z4) {
        return this.f1420y.a(f4, f5, z4);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f4, float f5) {
        return this.f1420y.b(f4, f5);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i4, int i5, int[] iArr, int[] iArr2) {
        return this.f1420y.c(i4, i5, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, int[] iArr) {
        return this.f1420y.e(i4, i5, i6, i7, iArr, 0, null);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i4;
        super.draw(canvas);
        int scrollY = getScrollY();
        EdgeEffect edgeEffect = this.f1400e;
        int i5 = 0;
        if (!edgeEffect.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            if (k.a(this)) {
                width -= getPaddingRight() + getPaddingLeft();
                i4 = getPaddingLeft();
            } else {
                i4 = 0;
            }
            if (k.a(this)) {
                height -= getPaddingBottom() + getPaddingTop();
                min += getPaddingTop();
            }
            canvas.translate(i4, min);
            edgeEffect.setSize(width, height);
            if (edgeEffect.draw(canvas)) {
                WeakHashMap weakHashMap = y0.f4999a;
                g0.k(this);
            }
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect2 = this.f1401f;
        if (!edgeEffect2.isFinished()) {
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int max = Math.max(getScrollRange(), scrollY) + height2;
            if (k.a(this)) {
                width2 -= getPaddingRight() + getPaddingLeft();
                i5 = getPaddingLeft();
            }
            if (k.a(this)) {
                height2 -= getPaddingBottom() + getPaddingTop();
                max -= getPaddingBottom();
            }
            canvas.translate(i5 - width2, max);
            canvas.rotate(180.0f, width2, 0.0f);
            edgeEffect2.setSize(width2, height2);
            if (edgeEffect2.draw(canvas)) {
                WeakHashMap weakHashMap2 = y0.f4999a;
                g0.k(this);
            }
            canvas.restoreToCount(save2);
        }
    }

    @Override // i0.t
    public final void e(int i4, View view) {
        i0.v vVar = this.f1419x;
        if (i4 == 1) {
            vVar.f4990b = 0;
        } else {
            vVar.f4989a = 0;
        }
        v(i4);
    }

    @Override // i0.u
    public final void f(View view, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
        o(i7, i8, iArr);
    }

    public final void g(int i4) {
        if (i4 != 0) {
            if (this.f1409n) {
                t(0, i4, false);
            } else {
                scrollBy(0, i4);
            }
        }
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        i0.v vVar = this.f1419x;
        return vVar.f4990b | vVar.f4989a;
    }

    public int getScrollRange() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
        }
        return 0;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public final boolean h(KeyEvent keyEvent) {
        boolean z4;
        Rect rect = this.f1398c;
        rect.setEmpty();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                int keyCode = keyEvent.getKeyCode();
                int i4 = 33;
                if (keyCode != 19) {
                    if (keyCode != 20) {
                        if (keyCode != 62) {
                            return false;
                        }
                        if (!keyEvent.isShiftPressed()) {
                            i4 = 130;
                        }
                        if (i4 == 130) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        int height = getHeight();
                        if (z4) {
                            rect.top = getScrollY() + height;
                            int childCount = getChildCount();
                            if (childCount > 0) {
                                View childAt2 = getChildAt(childCount - 1);
                                int paddingBottom = getPaddingBottom() + childAt2.getBottom() + ((FrameLayout.LayoutParams) childAt2.getLayoutParams()).bottomMargin;
                                if (rect.top + height > paddingBottom) {
                                    rect.top = paddingBottom - height;
                                }
                            }
                        } else {
                            int scrollY = getScrollY() - height;
                            rect.top = scrollY;
                            if (scrollY < 0) {
                                rect.top = 0;
                            }
                        }
                        int i5 = rect.top;
                        int i6 = height + i5;
                        rect.bottom = i6;
                        r(i4, i5, i6);
                        return false;
                    } else if (!keyEvent.isAltPressed()) {
                        return a(130);
                    } else {
                        return l(130);
                    }
                } else if (!keyEvent.isAltPressed()) {
                    return a(33);
                } else {
                    return l(33);
                }
            }
        }
        if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        }
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
        if (findNextFocus != null && findNextFocus != this && findNextFocus.requestFocus(130)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.f1420y.g(0);
    }

    @Override // i0.t
    public final void i(View view, int i4, int i5, int i6, int i7, int i8) {
        o(i7, i8, null);
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.f1420y.f4977d;
    }

    @Override // i0.t
    public final boolean j(View view, View view2, int i4, int i5) {
        return (i4 & 2) != 0;
    }

    public final void k(int i4) {
        if (getChildCount() > 0) {
            this.f1399d.fling(getScrollX(), getScrollY(), 0, i4, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            this.f1420y.h(2, 1);
            this.f1417v = getScrollY();
            WeakHashMap weakHashMap = y0.f4999a;
            g0.k(this);
        }
    }

    public final boolean l(int i4) {
        int childCount;
        boolean z4 = i4 == 130;
        int height = getHeight();
        Rect rect = this.f1398c;
        rect.top = 0;
        rect.bottom = height;
        if (z4 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            rect.bottom = paddingBottom;
            rect.top = paddingBottom - height;
        }
        return r(i4, rect.top, rect.bottom);
    }

    @Override // android.view.ViewGroup
    public final void measureChild(View view, int i4, int i5) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i4, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View view, int i4, int i5, int i6, int i7) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i4, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i5, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public final boolean n(View view, int i4, int i5) {
        Rect rect = this.f1398c;
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        return rect.bottom + i4 >= getScrollY() && rect.top - i4 <= getScrollY() + i5;
    }

    public final void o(int i4, int i5, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f1420y.d(scrollY2, i4 - scrollY2, i5, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1404i = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            int r0 = r9.getAction()
            r1 = 8
            r2 = 0
            if (r0 != r1) goto La8
            boolean r0 = r8.f1406k
            if (r0 != 0) goto La8
            r0 = 2
            boolean r0 = com.google.common.collect.c.Z0(r9, r0)
            r1 = 0
            if (r0 == 0) goto L1c
            r0 = 9
        L17:
            float r0 = r9.getAxisValue(r0)
            goto L28
        L1c:
            r0 = 4194304(0x400000, float:5.877472E-39)
            boolean r0 = com.google.common.collect.c.Z0(r9, r0)
            if (r0 == 0) goto L27
            r0 = 26
            goto L17
        L27:
            r0 = r1
        L28:
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 == 0) goto La8
            float r1 = r8.getVerticalScrollFactorCompat()
            float r0 = r0 * r1
            int r0 = (int) r0
            int r1 = r8.getScrollRange()
            int r3 = r8.getScrollY()
            int r0 = r3 - r0
            r4 = 1
            r5 = 1056964608(0x3f000000, float:0.5)
            r6 = 8194(0x2002, float:1.1482E-41)
            if (r0 >= 0) goto L6e
            int r1 = r8.getOverScrollMode()
            if (r1 == 0) goto L51
            if (r1 != r4) goto L6c
            int r1 = r8.getScrollRange()
            if (r1 <= 0) goto L6c
        L51:
            boolean r9 = com.google.common.collect.c.Z0(r9, r6)
            if (r9 != 0) goto L6c
            float r9 = (float) r0
            float r9 = -r9
            int r0 = r8.getHeight()
            float r0 = (float) r0
            float r9 = r9 / r0
            android.widget.EdgeEffect r0 = r8.f1400e
            com.google.common.collect.c.r1(r0, r9, r5)
            r0.onRelease()
            r8.invalidate()
            r9 = r4
            goto L9d
        L6c:
            r9 = r2
            goto L9d
        L6e:
            if (r0 <= r1) goto L9b
            int r7 = r8.getOverScrollMode()
            if (r7 == 0) goto L7e
            if (r7 != r4) goto L98
            int r7 = r8.getScrollRange()
            if (r7 <= 0) goto L98
        L7e:
            boolean r9 = com.google.common.collect.c.Z0(r9, r6)
            if (r9 != 0) goto L98
            int r0 = r0 - r1
            float r9 = (float) r0
            int r0 = r8.getHeight()
            float r0 = (float) r0
            float r9 = r9 / r0
            android.widget.EdgeEffect r0 = r8.f1401f
            com.google.common.collect.c.r1(r0, r9, r5)
            r0.onRelease()
            r8.invalidate()
            r2 = r4
        L98:
            r9 = r2
            r2 = r1
            goto L9d
        L9b:
            r9 = r2
            r2 = r0
        L9d:
            if (r2 == r3) goto La7
            int r9 = r8.getScrollX()
            super.scrollTo(r9, r2)
            return r4
        La7:
            return r9
        La8:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z4 = true;
        if (action == 2 && this.f1406k) {
            return true;
        }
        int i4 = action & 255;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 == 6) {
                            p(motionEvent);
                        }
                    }
                } else {
                    int i5 = this.f1413r;
                    if (i5 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i5);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i5 + " in onInterceptTouchEvent");
                        } else {
                            int y4 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y4 - this.f1402g) > this.f1410o && (2 & getNestedScrollAxes()) == 0) {
                                this.f1406k = true;
                                this.f1402g = y4;
                                if (this.f1407l == null) {
                                    this.f1407l = VelocityTracker.obtain();
                                }
                                this.f1407l.addMovement(motionEvent);
                                this.f1416u = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                }
            }
            this.f1406k = false;
            this.f1413r = -1;
            VelocityTracker velocityTracker = this.f1407l;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f1407l = null;
            }
            if (this.f1399d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                WeakHashMap weakHashMap = y0.f4999a;
                g0.k(this);
            }
            v(0);
        } else {
            int y5 = (int) motionEvent.getY();
            int x4 = (int) motionEvent.getX();
            if (getChildCount() > 0) {
                int scrollY = getScrollY();
                View childAt = getChildAt(0);
                if (y5 >= childAt.getTop() - scrollY && y5 < childAt.getBottom() - scrollY && x4 >= childAt.getLeft() && x4 < childAt.getRight()) {
                    this.f1402g = y5;
                    this.f1413r = motionEvent.getPointerId(0);
                    VelocityTracker velocityTracker2 = this.f1407l;
                    if (velocityTracker2 == null) {
                        this.f1407l = VelocityTracker.obtain();
                    } else {
                        velocityTracker2.clear();
                    }
                    this.f1407l.addMovement(motionEvent);
                    this.f1399d.computeScrollOffset();
                    if (!u(motionEvent) && this.f1399d.isFinished()) {
                        z4 = false;
                    }
                    this.f1406k = z4;
                    this.f1420y.h(2, 0);
                }
            }
            if (!u(motionEvent) && this.f1399d.isFinished()) {
                z4 = false;
            }
            this.f1406k = z4;
            VelocityTracker velocityTracker3 = this.f1407l;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f1407l = null;
            }
        }
        return this.f1406k;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int i8;
        super.onLayout(z4, i4, i5, i6, i7);
        int i9 = 0;
        this.f1403h = false;
        View view = this.f1405j;
        if (view != null && m(view, this)) {
            View view2 = this.f1405j;
            Rect rect = this.f1398c;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int c4 = c(rect);
            if (c4 != 0) {
                scrollBy(0, c4);
            }
        }
        this.f1405j = null;
        if (!this.f1404i) {
            if (this.f1418w != null) {
                scrollTo(getScrollX(), this.f1418w.f1422a);
                this.f1418w = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i8 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            } else {
                i8 = 0;
            }
            int paddingTop = ((i7 - i5) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            if (paddingTop < i8 && scrollY >= 0) {
                i9 = paddingTop + scrollY > i8 ? i8 - paddingTop : scrollY;
            }
            if (i9 != scrollY) {
                scrollTo(getScrollX(), i9);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f1404i = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (this.f1408m && View.MeasureSpec.getMode(i5) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i4, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f4, float f5, boolean z4) {
        if (z4) {
            return false;
        }
        dispatchNestedFling(0.0f, f5, true);
        k((int) f5);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f4, float f5) {
        return this.f1420y.b(f4, f5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i4, int i5, int[] iArr) {
        this.f1420y.c(i4, i5, iArr, null, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i4, int i5, int i6, int i7) {
        o(i7, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i4) {
        b(view, view2, i4, 0);
    }

    @Override // android.view.View
    public final void onOverScrolled(int i4, int i5, boolean z4, boolean z5) {
        super.scrollTo(i4, i5);
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i4, Rect rect) {
        View findNextFocusFromRect;
        if (i4 == 2) {
            i4 = 130;
        } else if (i4 == 1) {
            i4 = 33;
        }
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (rect == null) {
            findNextFocusFromRect = focusFinder.findNextFocus(this, null, i4);
        } else {
            findNextFocusFromRect = focusFinder.findNextFocusFromRect(this, rect, i4);
        }
        if (findNextFocusFromRect == null || (true ^ n(findNextFocusFromRect, 0, getHeight()))) {
            return false;
        }
        return findNextFocusFromRect.requestFocus(i4, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f1418w = savedState;
        requestLayout();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View$BaseSavedState, androidx.core.widget.NestedScrollView$SavedState, android.os.Parcelable] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ?? baseSavedState = new View.BaseSavedState(super.onSaveInstanceState());
        baseSavedState.f1422a = getScrollY();
        return baseSavedState;
    }

    @Override // android.view.View
    public final void onScrollChanged(int i4, int i5, int i6, int i7) {
        super.onScrollChanged(i4, i5, i6, i7);
        l lVar = this.A;
        if (lVar != null) {
            lVar.t(this);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        View findFocus = findFocus();
        if (findFocus == null || this == findFocus || !n(findFocus, 0, i7)) {
            return;
        }
        Rect rect = this.f1398c;
        findFocus.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(findFocus, rect);
        g(c(rect));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i4) {
        return j(view, view2, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        e(0, view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x02a7, code lost:
        if (r1 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0091, code lost:
        if (r1 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0093, code lost:
        r1.recycle();
        r24.f1407l = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0098, code lost:
        v(0);
        r24.f1400e.onRelease();
        r24.f1401f.onRelease();
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(android.view.MotionEvent r25) {
        /*
            Method dump skipped, instructions count: 746
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f1413r) {
            int i4 = actionIndex == 0 ? 1 : 0;
            this.f1402g = (int) motionEvent.getY(i4);
            this.f1413r = motionEvent.getPointerId(i4);
            VelocityTracker velocityTracker = this.f1407l;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final boolean q(int i4, int i5, int i6, int i7) {
        boolean z4;
        boolean z5;
        getOverScrollMode();
        super.computeHorizontalScrollRange();
        super.computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        super.computeVerticalScrollExtent();
        int i8 = i6 + i4;
        if (i5 > 0 || i5 < 0) {
            i5 = 0;
            z4 = true;
        } else {
            z4 = false;
        }
        if (i8 <= i7) {
            if (i8 < 0) {
                i7 = 0;
            } else {
                i7 = i8;
                z5 = false;
                if (z5 && !this.f1420y.g(1)) {
                    this.f1399d.springBack(i5, i7, 0, 0, 0, getScrollRange());
                }
                super.scrollTo(i5, i7);
                if (z4 && !z5) {
                    return false;
                }
            }
        }
        z5 = true;
        if (z5) {
            this.f1399d.springBack(i5, i7, 0, 0, 0, getScrollRange());
        }
        super.scrollTo(i5, i7);
        return z4 ? true : true;
    }

    public final boolean r(int i4, int i5, int i6) {
        boolean z4;
        int i7;
        boolean z5;
        boolean z6;
        boolean z7;
        int height = getHeight();
        int scrollY = getScrollY();
        int i8 = height + scrollY;
        if (i4 == 33) {
            z4 = true;
        } else {
            z4 = false;
        }
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z8 = false;
        for (int i9 = 0; i9 < size; i9++) {
            View view2 = focusables.get(i9);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i5 < bottom && top < i6) {
                if (i5 < top && bottom < i6) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (view == null) {
                    view = view2;
                    z8 = z6;
                } else {
                    if ((z4 && top < view.getTop()) || (!z4 && bottom > view.getBottom())) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (z8) {
                        if (z6) {
                            if (!z7) {
                            }
                            view = view2;
                        }
                    } else if (z6) {
                        view = view2;
                        z8 = true;
                    } else {
                        if (!z7) {
                        }
                        view = view2;
                    }
                }
            }
        }
        if (view == null) {
            view = this;
        }
        if (i5 >= scrollY && i6 <= i8) {
            z5 = false;
        } else {
            if (z4) {
                i7 = i5 - scrollY;
            } else {
                i7 = i6 - i8;
            }
            g(i7);
            z5 = true;
        }
        if (view != findFocus()) {
            view.requestFocus(i4);
        }
        return z5;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        if (!this.f1403h) {
            Rect rect = this.f1398c;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int c4 = c(rect);
            if (c4 != 0) {
                scrollBy(0, c4);
            }
        } else {
            this.f1405j = view2;
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z4) {
        boolean z5;
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int c4 = c(rect);
        if (c4 != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            if (z4) {
                scrollBy(0, c4);
            } else {
                t(0, c4, false);
            }
        }
        return z5;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z4) {
        VelocityTracker velocityTracker;
        if (z4 && (velocityTracker = this.f1407l) != null) {
            velocityTracker.recycle();
            this.f1407l = null;
        }
        super.requestDisallowInterceptTouchEvent(z4);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.f1403h = true;
        super.requestLayout();
    }

    public final boolean s(EdgeEffect edgeEffect, int i4) {
        if (i4 > 0) {
            return true;
        }
        float s02 = com.google.common.collect.c.s0(edgeEffect) * getHeight();
        float f4 = this.f1396a * 0.015f;
        double log = Math.log((Math.abs(-i4) * 0.35f) / f4);
        double d4 = B;
        if (((float) (Math.exp((d4 / (d4 - 1.0d)) * log) * f4)) < s02) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public final void scrollTo(int i4, int i5) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (width < width2 && i4 >= 0) {
                if (width + i4 > width2) {
                    i4 = width2 - width;
                }
            } else {
                i4 = 0;
            }
            if (height < height2 && i5 >= 0) {
                if (height + i5 > height2) {
                    i5 = height2 - height;
                }
            } else {
                i5 = 0;
            }
            if (i4 != getScrollX() || i5 != getScrollY()) {
                super.scrollTo(i4, i5);
            }
        }
    }

    public void setFillViewport(boolean z4) {
        if (z4 != this.f1408m) {
            this.f1408m = z4;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z4) {
        i0.s sVar = this.f1420y;
        if (sVar.f4977d) {
            WeakHashMap weakHashMap = y0.f4999a;
            m0.z(sVar.f4976c);
        }
        sVar.f4977d = z4;
    }

    public void setOnScrollChangeListener(@Nullable l lVar) {
        this.A = lVar;
    }

    public void setSmoothScrollingEnabled(boolean z4) {
        this.f1409n = z4;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i4) {
        return this.f1420y.h(i4, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        v(0);
    }

    public final void t(int i4, int i5, boolean z4) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f1397b > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int scrollY = getScrollY();
            OverScroller overScroller = this.f1399d;
            int scrollX = getScrollX();
            overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i5 + scrollY, Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom())))) - scrollY, 250);
            if (z4) {
                this.f1420y.h(2, 1);
            } else {
                v(1);
            }
            this.f1417v = getScrollY();
            WeakHashMap weakHashMap = y0.f4999a;
            g0.k(this);
        } else {
            if (!this.f1399d.isFinished()) {
                this.f1399d.abortAnimation();
                v(1);
            }
            scrollBy(i4, i5);
        }
        this.f1397b = AnimationUtils.currentAnimationTimeMillis();
    }

    public final boolean u(MotionEvent motionEvent) {
        boolean z4;
        EdgeEffect edgeEffect = this.f1400e;
        if (com.google.common.collect.c.s0(edgeEffect) != 0.0f) {
            com.google.common.collect.c.r1(edgeEffect, 0.0f, motionEvent.getX() / getWidth());
            z4 = true;
        } else {
            z4 = false;
        }
        EdgeEffect edgeEffect2 = this.f1401f;
        if (com.google.common.collect.c.s0(edgeEffect2) != 0.0f) {
            com.google.common.collect.c.r1(edgeEffect2, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
            return true;
        }
        return z4;
    }

    public final void v(int i4) {
        this.f1420y.i(i4);
    }

    public NestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.nestedScrollViewStyle);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i4) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i4);
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object, i0.v] */
    public NestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f1398c = new Rect();
        this.f1403h = true;
        this.f1404i = false;
        this.f1405j = null;
        this.f1406k = false;
        this.f1409n = true;
        this.f1413r = -1;
        this.f1414s = new int[2];
        this.f1415t = new int[2];
        int i5 = Build.VERSION.SDK_INT;
        this.f1400e = i5 >= 31 ? f.a(context, attributeSet) : new EdgeEffect(context);
        this.f1401f = i5 >= 31 ? f.a(context, attributeSet) : new EdgeEffect(context);
        this.f1396a = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        this.f1399d = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f1410o = viewConfiguration.getScaledTouchSlop();
        this.f1411p = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1412q = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, D, i4, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f1419x = new Object();
        this.f1420y = new i0.s(this);
        setNestedScrollingEnabled(true);
        y0.p(this, C);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i4, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }
}
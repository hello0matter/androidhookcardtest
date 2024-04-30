package androidx.drawerlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.activity.d;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.o0;
import androidx.core.widget.j;
import androidx.customview.view.AbsSavedState;
import com.example.msphone.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigation.k;
import f2.f;
import i0.g0;
import i0.g2;
import i0.h0;
import i0.m0;
import i0.y0;
import j0.g;
import java.util.ArrayList;
import java.util.Objects;
import java.util.WeakHashMap;
import n0.e;
import p0.c;

/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {
    public static final int[] L = {16843828};
    public static final int[] M = {16842931};
    public static final boolean N;
    public static final boolean O;
    public static final boolean P;
    public CharSequence A;
    public Object B;
    public boolean C;
    public Drawable D;
    public Drawable E;
    public Drawable F;
    public Drawable G;
    public final ArrayList H;
    public Rect I;
    public Matrix J;
    public final o0 K;

    /* renamed from: a  reason: collision with root package name */
    public final j f1462a;

    /* renamed from: b  reason: collision with root package name */
    public float f1463b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1464c;

    /* renamed from: d  reason: collision with root package name */
    public int f1465d;

    /* renamed from: e  reason: collision with root package name */
    public float f1466e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f1467f;

    /* renamed from: g  reason: collision with root package name */
    public final e f1468g;

    /* renamed from: h  reason: collision with root package name */
    public final e f1469h;

    /* renamed from: i  reason: collision with root package name */
    public final b f1470i;

    /* renamed from: j  reason: collision with root package name */
    public final b f1471j;

    /* renamed from: k  reason: collision with root package name */
    public int f1472k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f1473l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f1474m;

    /* renamed from: n  reason: collision with root package name */
    public int f1475n;

    /* renamed from: o  reason: collision with root package name */
    public int f1476o;

    /* renamed from: p  reason: collision with root package name */
    public int f1477p;

    /* renamed from: q  reason: collision with root package name */
    public int f1478q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f1479r;

    /* renamed from: s  reason: collision with root package name */
    public c f1480s;

    /* renamed from: t  reason: collision with root package name */
    public ArrayList f1481t;

    /* renamed from: u  reason: collision with root package name */
    public float f1482u;

    /* renamed from: v  reason: collision with root package name */
    public float f1483v;

    /* renamed from: w  reason: collision with root package name */
    public Drawable f1484w;

    /* renamed from: x  reason: collision with root package name */
    public Drawable f1485x;

    /* renamed from: y  reason: collision with root package name */
    public Drawable f1486y;

    /* renamed from: z  reason: collision with root package name */
    public CharSequence f1487z;

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f1488a;

        /* renamed from: b  reason: collision with root package name */
        public float f1489b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1490c;

        /* renamed from: d  reason: collision with root package name */
        public int f1491d;

        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1488a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.M);
            this.f1488a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: c  reason: collision with root package name */
        public int f1492c;

        /* renamed from: d  reason: collision with root package name */
        public int f1493d;

        /* renamed from: e  reason: collision with root package name */
        public int f1494e;

        /* renamed from: f  reason: collision with root package name */
        public int f1495f;

        /* renamed from: g  reason: collision with root package name */
        public int f1496g;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1492c = 0;
            this.f1492c = parcel.readInt();
            this.f1493d = parcel.readInt();
            this.f1494e = parcel.readInt();
            this.f1495f = parcel.readInt();
            this.f1496g = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f1492c);
            parcel.writeInt(this.f1493d);
            parcel.writeInt(this.f1494e);
            parcel.writeInt(this.f1495f);
            parcel.writeInt(this.f1496g);
        }
    }

    static {
        int i4 = Build.VERSION.SDK_INT;
        N = true;
        O = true;
        P = i4 >= 29;
    }

    public DrawerLayout(@NonNull Context context) {
        this(context, null);
    }

    public static boolean i(View view) {
        WeakHashMap weakHashMap = y0.f4999a;
        if (g0.c(view) != 4 && g0.c(view) != 2) {
            return true;
        }
        return false;
    }

    public static boolean j(View view) {
        if (((LayoutParams) view.getLayoutParams()).f1488a == 0) {
            return true;
        }
        return false;
    }

    public static boolean k(View view) {
        if (l(view)) {
            if ((((LayoutParams) view.getLayoutParams()).f1491d & 1) == 1) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public static boolean l(View view) {
        int i4 = ((LayoutParams) view.getLayoutParams()).f1488a;
        WeakHashMap weakHashMap = y0.f4999a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i4, h0.d(view));
        if ((absoluteGravity & 3) != 0 || (absoluteGravity & 5) != 0) {
            return true;
        }
        return false;
    }

    public final boolean a(int i4, View view) {
        if ((h(view) & i4) == i4) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i4, int i5) {
        ArrayList arrayList2;
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        int i6 = 0;
        boolean z4 = false;
        while (true) {
            arrayList2 = this.H;
            if (i6 >= childCount) {
                break;
            }
            View childAt = getChildAt(i6);
            if (!l(childAt)) {
                arrayList2.add(childAt);
            } else if (k(childAt)) {
                childAt.addFocusables(arrayList, i4, i5);
                z4 = true;
            }
            i6++;
        }
        if (!z4) {
            int size = arrayList2.size();
            for (int i7 = 0; i7 < size; i7++) {
                View view = (View) arrayList2.get(i7);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i4, i5);
                }
            }
        }
        arrayList2.clear();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        int i5;
        super.addView(view, i4, layoutParams);
        if (e() == null && !l(view)) {
            WeakHashMap weakHashMap = y0.f4999a;
            i5 = 1;
        } else {
            WeakHashMap weakHashMap2 = y0.f4999a;
            i5 = 4;
        }
        g0.s(view, i5);
        if (!N) {
            y0.p(view, this.f1462a);
        }
    }

    public final void b(View view, boolean z4) {
        int width;
        int top;
        e eVar;
        if (l(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.f1474m) {
                layoutParams.f1489b = 0.0f;
                layoutParams.f1491d = 0;
            } else if (z4) {
                layoutParams.f1491d |= 4;
                if (a(3, view)) {
                    width = -view.getWidth();
                    top = view.getTop();
                    eVar = this.f1468g;
                } else {
                    width = getWidth();
                    top = view.getTop();
                    eVar = this.f1469h;
                }
                eVar.s(view, width, top);
            } else {
                float f4 = ((LayoutParams) view.getLayoutParams()).f1489b;
                float width2 = view.getWidth();
                int i4 = ((int) (width2 * 0.0f)) - ((int) (f4 * width2));
                if (!a(3, view)) {
                    i4 = -i4;
                }
                view.offsetLeftAndRight(i4);
                o(view, 0.0f);
                r(0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public final void c(boolean z4) {
        int width;
        int top;
        e eVar;
        int childCount = getChildCount();
        boolean z5 = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (l(childAt) && (!z4 || layoutParams.f1490c)) {
                int width2 = childAt.getWidth();
                if (a(3, childAt)) {
                    width = -width2;
                    top = childAt.getTop();
                    eVar = this.f1468g;
                } else {
                    width = getWidth();
                    top = childAt.getTop();
                    eVar = this.f1469h;
                }
                z5 |= eVar.s(childAt, width, top);
                layoutParams.f1490c = false;
            }
        }
        b bVar = this.f1470i;
        bVar.f1500t.removeCallbacks(bVar.f1499s);
        b bVar2 = this.f1471j;
        bVar2.f1500t.removeCallbacks(bVar2.f1499s);
        if (z5) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() {
        int childCount = getChildCount();
        float f4 = 0.0f;
        for (int i4 = 0; i4 < childCount; i4++) {
            f4 = Math.max(f4, ((LayoutParams) getChildAt(i4).getLayoutParams()).f1489b);
        }
        this.f1466e = f4;
        boolean g4 = this.f1468g.g();
        boolean g5 = this.f1469h.g();
        if (g4 || g5) {
            WeakHashMap weakHashMap = y0.f4999a;
            g0.k(this);
        }
    }

    public final View d(int i4) {
        WeakHashMap weakHashMap = y0.f4999a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i4, h0.d(this)) & 7;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if ((h(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.View
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        boolean dispatchGenericMotionEvent;
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() != 10 && this.f1466e > 0.0f) {
            int childCount = getChildCount();
            if (childCount != 0) {
                float x4 = motionEvent.getX();
                float y4 = motionEvent.getY();
                for (int i4 = childCount - 1; i4 >= 0; i4--) {
                    View childAt = getChildAt(i4);
                    if (this.I == null) {
                        this.I = new Rect();
                    }
                    childAt.getHitRect(this.I);
                    if (this.I.contains((int) x4, (int) y4) && !j(childAt)) {
                        if (!childAt.getMatrix().isIdentity()) {
                            MotionEvent obtain = MotionEvent.obtain(motionEvent);
                            obtain.offsetLocation(getScrollX() - childAt.getLeft(), getScrollY() - childAt.getTop());
                            Matrix matrix = childAt.getMatrix();
                            if (!matrix.isIdentity()) {
                                if (this.J == null) {
                                    this.J = new Matrix();
                                }
                                matrix.invert(this.J);
                                obtain.transform(this.J);
                            }
                            dispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(obtain);
                            obtain.recycle();
                        } else {
                            float scrollX = getScrollX() - childAt.getLeft();
                            float scrollY = getScrollY() - childAt.getTop();
                            motionEvent.offsetLocation(scrollX, scrollY);
                            dispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(motionEvent);
                            motionEvent.offsetLocation(-scrollX, -scrollY);
                        }
                        if (dispatchGenericMotionEvent) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return false;
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j4) {
        Drawable drawable;
        Drawable background;
        int height = getHeight();
        boolean j5 = j(view);
        int width = getWidth();
        int save = canvas.save();
        int i4 = 0;
        if (j5) {
            int childCount = getChildCount();
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt != view && childAt.getVisibility() == 0 && (background = childAt.getBackground()) != null && background.getOpacity() == -1 && l(childAt) && childAt.getHeight() >= height) {
                    if (a(3, childAt)) {
                        int right = childAt.getRight();
                        if (right > i5) {
                            i5 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i5, 0, width, getHeight());
            i4 = i5;
        }
        boolean drawChild = super.drawChild(canvas, view, j4);
        canvas.restoreToCount(save);
        float f4 = this.f1466e;
        if (f4 > 0.0f && j5) {
            int i7 = this.f1465d;
            Paint paint = this.f1467f;
            paint.setColor((i7 & 16777215) | (((int) ((((-16777216) & i7) >>> 24) * f4)) << 24));
            canvas.drawRect(i4, 0.0f, width, getHeight(), paint);
        } else {
            if (this.f1485x != null && a(3, view)) {
                int intrinsicWidth = this.f1485x.getIntrinsicWidth();
                int right2 = view.getRight();
                float max = Math.max(0.0f, Math.min(right2 / this.f1468g.f5730o, 1.0f));
                this.f1485x.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
                this.f1485x.setAlpha((int) (max * 255.0f));
                drawable = this.f1485x;
            } else if (this.f1486y != null && a(5, view)) {
                int intrinsicWidth2 = this.f1486y.getIntrinsicWidth();
                int left2 = view.getLeft();
                float max2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.f1469h.f5730o, 1.0f));
                this.f1486y.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
                this.f1486y.setAlpha((int) (max2 * 255.0f));
                drawable = this.f1486y;
            }
            drawable.draw(canvas);
        }
        return drawChild;
    }

    public final View e() {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if ((((LayoutParams) childAt.getLayoutParams()).f1491d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public final View f() {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (l(childAt)) {
                if (l(childAt)) {
                    if (((LayoutParams) childAt.getLayoutParams()).f1489b > 0.0f) {
                        return childAt;
                    }
                } else {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
            }
        }
        return null;
    }

    public final int g(View view) {
        int i4;
        int i5;
        int i6;
        int i7;
        if (l(view)) {
            int i8 = ((LayoutParams) view.getLayoutParams()).f1488a;
            WeakHashMap weakHashMap = y0.f4999a;
            int d4 = h0.d(this);
            if (i8 != 3) {
                if (i8 != 5) {
                    if (i8 != 8388611) {
                        if (i8 == 8388613) {
                            int i9 = this.f1478q;
                            if (i9 == 3) {
                                if (d4 == 0) {
                                    i7 = this.f1476o;
                                } else {
                                    i7 = this.f1475n;
                                }
                                if (i7 != 3) {
                                    return i7;
                                }
                            } else {
                                return i9;
                            }
                        }
                    } else {
                        int i10 = this.f1477p;
                        if (i10 == 3) {
                            if (d4 == 0) {
                                i6 = this.f1475n;
                            } else {
                                i6 = this.f1476o;
                            }
                            if (i6 != 3) {
                                return i6;
                            }
                        } else {
                            return i10;
                        }
                    }
                } else {
                    int i11 = this.f1476o;
                    if (i11 == 3) {
                        if (d4 == 0) {
                            i5 = this.f1478q;
                        } else {
                            i5 = this.f1477p;
                        }
                        if (i5 != 3) {
                            return i5;
                        }
                    } else {
                        return i11;
                    }
                }
            } else {
                int i12 = this.f1475n;
                if (i12 == 3) {
                    if (d4 == 0) {
                        i4 = this.f1477p;
                    } else {
                        i4 = this.f1478q;
                    }
                    if (i4 != 3) {
                        return i4;
                    }
                } else {
                    return i12;
                }
            }
            return 0;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup$LayoutParams, android.view.ViewGroup$MarginLayoutParams, androidx.drawerlayout.widget.DrawerLayout$LayoutParams] */
    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ?? marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        marginLayoutParams.f1488a = 0;
        return marginLayoutParams;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public float getDrawerElevation() {
        if (O) {
            return this.f1463b;
        }
        return 0.0f;
    }

    @Nullable
    public Drawable getStatusBarBackgroundDrawable() {
        return this.f1484w;
    }

    public final int h(View view) {
        int i4 = ((LayoutParams) view.getLayoutParams()).f1488a;
        WeakHashMap weakHashMap = y0.f4999a;
        return Gravity.getAbsoluteGravity(i4, h0.d(this));
    }

    public final void m(View view) {
        if (l(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.f1474m) {
                layoutParams.f1489b = 1.0f;
                layoutParams.f1491d = 1;
                q(view, true);
                p(view);
            } else {
                layoutParams.f1491d |= 2;
                if (a(3, view)) {
                    this.f1468g.s(view, 0, view.getTop());
                } else {
                    this.f1469h.s(view, getWidth() - view.getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public final void n() {
        Drawable drawable;
        Drawable drawable2;
        if (O) {
            return;
        }
        WeakHashMap weakHashMap = y0.f4999a;
        int d4 = h0.d(this);
        if (d4 == 0) {
            Drawable drawable3 = this.D;
            if (drawable3 != null) {
                if (c0.a.d(drawable3)) {
                    c0.c.b(drawable3, d4);
                }
                drawable = this.D;
            }
            drawable = this.F;
        } else {
            Drawable drawable4 = this.E;
            if (drawable4 != null) {
                if (c0.a.d(drawable4)) {
                    c0.c.b(drawable4, d4);
                }
                drawable = this.E;
            }
            drawable = this.F;
        }
        this.f1485x = drawable;
        int d5 = h0.d(this);
        if (d5 == 0) {
            Drawable drawable5 = this.E;
            if (drawable5 != null) {
                if (c0.a.d(drawable5)) {
                    c0.c.b(drawable5, d5);
                }
                drawable2 = this.E;
            }
            drawable2 = this.G;
        } else {
            Drawable drawable6 = this.D;
            if (drawable6 != null) {
                if (c0.a.d(drawable6)) {
                    c0.c.b(drawable6, d5);
                }
                drawable2 = this.D;
            }
            drawable2 = this.G;
        }
        this.f1486y = drawable2;
    }

    public final void o(View view, float f4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f4 == layoutParams.f1489b) {
            return;
        }
        layoutParams.f1489b = f4;
        ArrayList arrayList = this.f1481t;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((c) this.f1481t.get(size)).getClass();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1474m = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1474m = true;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.C || this.f1484w == null) {
            return;
        }
        Object obj = this.B;
        int systemWindowInsetTop = obj != null ? ((WindowInsets) obj).getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.f1484w.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.f1484w.draw(canvas);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        if (r0 != 3) goto L8;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            int r0 = r9.getActionMasked()
            n0.e r1 = r8.f1468g
            boolean r2 = r1.r(r9)
            n0.e r3 = r8.f1469h
            boolean r3 = r3.r(r9)
            r2 = r2 | r3
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L65
            if (r0 == r3) goto L5e
            r9 = 2
            if (r0 == r9) goto L1e
            r9 = 3
            if (r0 == r9) goto L5e
            goto L63
        L1e:
            float[] r9 = r1.f5719d
            int r9 = r9.length
            r0 = r4
        L22:
            if (r0 >= r9) goto L63
            int r5 = r1.f5726k
            int r6 = r3 << r0
            r5 = r5 & r6
            if (r5 == 0) goto L5b
            float[] r5 = r1.f5721f
            r5 = r5[r0]
            float[] r6 = r1.f5719d
            r6 = r6[r0]
            float r5 = r5 - r6
            float[] r6 = r1.f5722g
            r6 = r6[r0]
            float[] r7 = r1.f5720e
            r7 = r7[r0]
            float r6 = r6 - r7
            float r5 = r5 * r5
            float r6 = r6 * r6
            float r6 = r6 + r5
            int r5 = r1.f5717b
            int r5 = r5 * r5
            float r5 = (float) r5
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 <= 0) goto L5b
            androidx.drawerlayout.widget.b r9 = r8.f1470i
            androidx.activity.k r0 = r9.f1499s
            androidx.drawerlayout.widget.DrawerLayout r9 = r9.f1500t
            r9.removeCallbacks(r0)
            androidx.drawerlayout.widget.b r9 = r8.f1471j
            androidx.activity.k r0 = r9.f1499s
            androidx.drawerlayout.widget.DrawerLayout r9 = r9.f1500t
            r9.removeCallbacks(r0)
            goto L63
        L5b:
            int r0 = r0 + 1
            goto L22
        L5e:
            r8.c(r3)
            r8.f1479r = r4
        L63:
            r9 = r4
            goto L8b
        L65:
            float r0 = r9.getX()
            float r9 = r9.getY()
            r8.f1482u = r0
            r8.f1483v = r9
            float r5 = r8.f1466e
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L88
            int r0 = (int) r0
            int r9 = (int) r9
            android.view.View r9 = r1.h(r0, r9)
            if (r9 == 0) goto L88
            boolean r9 = j(r9)
            if (r9 == 0) goto L88
            r9 = r3
            goto L89
        L88:
            r9 = r4
        L89:
            r8.f1479r = r4
        L8b:
            if (r2 != 0) goto Lae
            if (r9 != 0) goto Lae
            int r9 = r8.getChildCount()
            r0 = r4
        L94:
            if (r0 >= r9) goto La8
            android.view.View r1 = r8.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.drawerlayout.widget.DrawerLayout$LayoutParams r1 = (androidx.drawerlayout.widget.DrawerLayout.LayoutParams) r1
            boolean r1 = r1.f1490c
            if (r1 == 0) goto La5
            goto Lae
        La5:
            int r0 = r0 + 1
            goto L94
        La8:
            boolean r9 = r8.f1479r
            if (r9 == 0) goto Lad
            goto Lae
        Lad:
            r3 = r4
        Lae:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i4, KeyEvent keyEvent) {
        if (i4 == 4 && f() != null) {
            keyEvent.startTracking();
            return true;
        }
        return super.onKeyDown(i4, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i4, KeyEvent keyEvent) {
        if (i4 == 4) {
            View f4 = f();
            if (f4 != null && g(f4) == 0) {
                c(false);
            }
            if (f4 == null) {
                return false;
            }
            return true;
        }
        return super.onKeyUp(i4, keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        WindowInsets rootWindowInsets;
        int i8;
        float f4;
        int i9;
        boolean z5;
        int i10;
        int measuredHeight;
        int i11;
        int i12;
        boolean z6 = true;
        this.f1473l = true;
        int i13 = i6 - i4;
        int childCount = getChildCount();
        int i14 = 0;
        while (i14 < childCount) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (j(childAt)) {
                    int i15 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    childAt.layout(i15, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, childAt.getMeasuredWidth() + i15, childAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin);
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight2 = childAt.getMeasuredHeight();
                    if (a(3, childAt)) {
                        float f5 = measuredWidth;
                        i9 = (-measuredWidth) + ((int) (layoutParams.f1489b * f5));
                        f4 = (measuredWidth + i9) / f5;
                    } else {
                        float f6 = measuredWidth;
                        f4 = (i13 - i8) / f6;
                        i9 = i13 - ((int) (layoutParams.f1489b * f6));
                    }
                    if (f4 != layoutParams.f1489b) {
                        z5 = z6;
                    } else {
                        z5 = false;
                    }
                    int i16 = layoutParams.f1488a & 112;
                    if (i16 != 16) {
                        if (i16 != 80) {
                            measuredHeight = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                            i11 = measuredWidth + i9;
                            i12 = measuredHeight2 + measuredHeight;
                        } else {
                            int i17 = i7 - i5;
                            measuredHeight = (i17 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - childAt.getMeasuredHeight();
                            i11 = measuredWidth + i9;
                            i12 = i17 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        }
                        childAt.layout(i9, measuredHeight, i11, i12);
                    } else {
                        int i18 = i7 - i5;
                        int i19 = (i18 - measuredHeight2) / 2;
                        int i20 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        if (i19 < i20) {
                            i19 = i20;
                        } else {
                            int i21 = i19 + measuredHeight2;
                            int i22 = i18 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                            if (i21 > i22) {
                                i19 = i22 - measuredHeight2;
                            }
                        }
                        childAt.layout(i9, i19, measuredWidth + i9, measuredHeight2 + i19);
                    }
                    if (z5) {
                        o(childAt, f4);
                    }
                    if (layoutParams.f1489b > 0.0f) {
                        i10 = 0;
                    } else {
                        i10 = 4;
                    }
                    if (childAt.getVisibility() != i10) {
                        childAt.setVisibility(i10);
                    }
                }
            }
            i14++;
            z6 = true;
        }
        if (P && (rootWindowInsets = getRootWindowInsets()) != null) {
            b0.c i23 = g2.h(null, rootWindowInsets).f4931a.i();
            e eVar = this.f1468g;
            eVar.f5730o = Math.max(eVar.f5731p, i23.f2490a);
            e eVar2 = this.f1469h;
            eVar2.f5730o = Math.max(eVar2.f5731p, i23.f2492c);
        }
        this.f1473l = false;
        this.f1474m = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0048  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 423
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        View d4;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f1460a);
        int i4 = savedState.f1492c;
        if (i4 != 0 && (d4 = d(i4)) != null) {
            m(d4);
        }
        int i5 = savedState.f1493d;
        if (i5 != 3) {
            setDrawerLockMode(i5, 3);
        }
        int i6 = savedState.f1494e;
        if (i6 != 3) {
            setDrawerLockMode(i6, 5);
        }
        int i7 = savedState.f1495f;
        if (i7 != 3) {
            setDrawerLockMode(i7, 8388611);
        }
        int i8 = savedState.f1496g;
        if (i8 != 3) {
            setDrawerLockMode(i8, 8388613);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i4) {
        n();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.drawerlayout.widget.DrawerLayout$SavedState, android.os.Parcelable, androidx.customview.view.AbsSavedState] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        boolean z4;
        ?? absSavedState = new AbsSavedState(super.onSaveInstanceState());
        absSavedState.f1492c = 0;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i4).getLayoutParams();
            int i5 = layoutParams.f1491d;
            boolean z5 = true;
            if (i5 == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (i5 != 2) {
                z5 = false;
            }
            if (z4 || z5) {
                absSavedState.f1492c = layoutParams.f1488a;
                break;
            }
        }
        absSavedState.f1493d = this.f1475n;
        absSavedState.f1494e = this.f1476o;
        absSavedState.f1495f = this.f1477p;
        absSavedState.f1496g = this.f1478q;
        return absSavedState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
        if (g(r7) != 2) goto L19;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            n0.e r0 = r6.f1468g
            r0.k(r7)
            n0.e r1 = r6.f1469h
            r1.k(r7)
            int r1 = r7.getAction()
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L59
            if (r1 == r3) goto L20
            r7 = 3
            if (r1 == r7) goto L1a
            goto L67
        L1a:
            r6.c(r3)
            r6.f1479r = r2
            goto L67
        L20:
            float r1 = r7.getX()
            float r7 = r7.getY()
            int r4 = (int) r1
            int r5 = (int) r7
            android.view.View r4 = r0.h(r4, r5)
            if (r4 == 0) goto L54
            boolean r4 = j(r4)
            if (r4 == 0) goto L54
            float r4 = r6.f1482u
            float r1 = r1 - r4
            float r4 = r6.f1483v
            float r7 = r7 - r4
            int r0 = r0.f5717b
            float r1 = r1 * r1
            float r7 = r7 * r7
            float r7 = r7 + r1
            int r0 = r0 * r0
            float r0 = (float) r0
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 >= 0) goto L54
            android.view.View r7 = r6.e()
            if (r7 == 0) goto L54
            int r7 = r6.g(r7)
            r0 = 2
            if (r7 != r0) goto L55
        L54:
            r2 = r3
        L55:
            r6.c(r2)
            goto L67
        L59:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f1482u = r0
            r6.f1483v = r7
            r6.f1479r = r2
        L67:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(View view) {
        g gVar = g.f5084l;
        y0.l(gVar.a(), view);
        if (!k(view) || g(view) == 2) {
            return;
        }
        y0.n(view, gVar, null, this.K);
    }

    public final void q(View view, boolean z4) {
        int i4;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if ((!z4 && !l(childAt)) || (z4 && childAt == view)) {
                WeakHashMap weakHashMap = y0.f4999a;
                i4 = 1;
            } else {
                WeakHashMap weakHashMap2 = y0.f4999a;
                i4 = 4;
            }
            g0.s(childAt, i4);
        }
    }

    public final void r(int i4, View view) {
        int i5;
        View rootView;
        f fVar;
        f2.c cVar;
        int i6 = this.f1468g.f5716a;
        int i7 = this.f1469h.f5716a;
        if (i6 != 1 && i7 != 1) {
            i5 = 2;
            if (i6 != 2 && i7 != 2) {
                i5 = 0;
            }
        } else {
            i5 = 1;
        }
        if (view != null && i4 == 0) {
            float f4 = ((LayoutParams) view.getLayoutParams()).f1489b;
            if (f4 == 0.0f) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if ((layoutParams.f1491d & 1) == 1) {
                    layoutParams.f1491d = 0;
                    ArrayList arrayList = this.f1481t;
                    if (arrayList != null) {
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            NavigationView navigationView = ((k) ((c) this.f1481t.get(size))).f3698a;
                            if (view == navigationView && (cVar = (fVar = navigationView.f3688s).f4560a) != null) {
                                cVar.c(fVar.f4562c);
                            }
                        }
                    }
                    q(view, false);
                    p(view);
                    if (hasWindowFocus() && (rootView = getRootView()) != null) {
                        rootView.sendAccessibilityEvent(32);
                    }
                }
            } else if (f4 == 1.0f) {
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                if ((layoutParams2.f1491d & 1) == 0) {
                    layoutParams2.f1491d = 1;
                    ArrayList arrayList2 = this.f1481t;
                    if (arrayList2 != null) {
                        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                            NavigationView navigationView2 = ((k) ((c) this.f1481t.get(size2))).f3698a;
                            if (view == navigationView2) {
                                f fVar2 = navigationView2.f3688s;
                                Objects.requireNonNull(fVar2);
                                view.post(new d(8, fVar2));
                            }
                        }
                    }
                    q(view, true);
                    p(view);
                    if (hasWindowFocus()) {
                        sendAccessibilityEvent(32);
                    }
                }
            }
        }
        if (i5 != this.f1472k) {
            this.f1472k = i5;
            ArrayList arrayList3 = this.f1481t;
            if (arrayList3 != null) {
                for (int size3 = arrayList3.size() - 1; size3 >= 0; size3--) {
                    ((c) this.f1481t.get(size3)).getClass();
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z4) {
        super.requestDisallowInterceptTouchEvent(z4);
        if (z4) {
            c(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f1473l) {
            return;
        }
        super.requestLayout();
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public void setChildInsets(Object obj, boolean z4) {
        this.B = obj;
        this.C = z4;
        setWillNotDraw(!z4 && getBackground() == null);
        requestLayout();
    }

    public void setDrawerElevation(float f4) {
        this.f1463b = f4;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if (l(childAt)) {
                float f5 = this.f1463b;
                WeakHashMap weakHashMap = y0.f4999a;
                m0.s(childAt, f5);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(c cVar) {
        ArrayList arrayList;
        c cVar2 = this.f1480s;
        if (cVar2 != null && (arrayList = this.f1481t) != null) {
            arrayList.remove(cVar2);
        }
        if (cVar != null) {
            if (this.f1481t == null) {
                this.f1481t = new ArrayList();
            }
            this.f1481t.add(cVar);
        }
        this.f1480s = cVar;
    }

    public void setDrawerLockMode(int i4) {
        setDrawerLockMode(i4, 3);
        setDrawerLockMode(i4, 5);
    }

    public void setDrawerShadow(@DrawableRes int i4, int i5) {
        Context context = getContext();
        Object obj = z.e.f7215a;
        setDrawerShadow(z.c.b(context, i4), i5);
    }

    public void setDrawerTitle(int i4, @Nullable CharSequence charSequence) {
        WeakHashMap weakHashMap = y0.f4999a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i4, h0.d(this));
        if (absoluteGravity == 3) {
            this.f1487z = charSequence;
        } else if (absoluteGravity == 5) {
            this.A = charSequence;
        }
    }

    public void setScrimColor(@ColorInt int i4) {
        this.f1465d = i4;
        invalidate();
    }

    public void setStatusBarBackground(int i4) {
        Drawable drawable;
        if (i4 != 0) {
            Context context = getContext();
            Object obj = z.e.f7215a;
            drawable = z.c.b(context, i4);
        } else {
            drawable = null;
        }
        this.f1484w = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(@ColorInt int i4) {
        this.f1484w = new ColorDrawable(i4);
        invalidate();
    }

    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.drawerLayoutStyle);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.ViewGroup$LayoutParams, android.view.ViewGroup$MarginLayoutParams, androidx.drawerlayout.widget.DrawerLayout$LayoutParams] */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.ViewGroup$LayoutParams, android.view.ViewGroup$MarginLayoutParams, androidx.drawerlayout.widget.DrawerLayout$LayoutParams] */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.view.ViewGroup$LayoutParams, android.view.ViewGroup$MarginLayoutParams, androidx.drawerlayout.widget.DrawerLayout$LayoutParams] */
    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            ?? marginLayoutParams = new ViewGroup.MarginLayoutParams((ViewGroup.MarginLayoutParams) layoutParams2);
            marginLayoutParams.f1488a = 0;
            marginLayoutParams.f1488a = layoutParams2.f1488a;
            return marginLayoutParams;
        } else if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ?? marginLayoutParams2 = new ViewGroup.MarginLayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            marginLayoutParams2.f1488a = 0;
            return marginLayoutParams2;
        } else {
            ?? marginLayoutParams3 = new ViewGroup.MarginLayoutParams(layoutParams);
            marginLayoutParams3.f1488a = 0;
            return marginLayoutParams3;
        }
    }

    public void setDrawerLockMode(int i4, int i5) {
        View d4;
        WeakHashMap weakHashMap = y0.f4999a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i5, h0.d(this));
        if (i5 == 3) {
            this.f1475n = i4;
        } else if (i5 == 5) {
            this.f1476o = i4;
        } else if (i5 == 8388611) {
            this.f1477p = i4;
        } else if (i5 == 8388613) {
            this.f1478q = i4;
        }
        if (i4 != 0) {
            (absoluteGravity == 3 ? this.f1468g : this.f1469h).a();
        }
        if (i4 != 1) {
            if (i4 == 2 && (d4 = d(absoluteGravity)) != null) {
                m(d4);
                return;
            }
            return;
        }
        View d5 = d(absoluteGravity);
        if (d5 != null) {
            b(d5, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, android.view.View$OnApplyWindowInsetsListener] */
    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f1462a = new j(1);
        this.f1465d = -1728053248;
        this.f1467f = new Paint();
        this.f1474m = true;
        this.f1475n = 3;
        this.f1476o = 3;
        this.f1477p = 3;
        this.f1478q = 3;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.K = new o0(14, this);
        setDescendantFocusability(262144);
        float f4 = getResources().getDisplayMetrics().density;
        this.f1464c = (int) ((64.0f * f4) + 0.5f);
        float f5 = f4 * 400.0f;
        b bVar = new b(this, 3);
        this.f1470i = bVar;
        b bVar2 = new b(this, 5);
        this.f1471j = bVar2;
        e eVar = new e(getContext(), this, bVar);
        eVar.f5717b = (int) (eVar.f5717b * 1.0f);
        this.f1468g = eVar;
        eVar.f5732q = 1;
        eVar.f5729n = f5;
        bVar.f1498r = eVar;
        e eVar2 = new e(getContext(), this, bVar2);
        eVar2.f5717b = (int) (1.0f * eVar2.f5717b);
        this.f1469h = eVar2;
        eVar2.f5732q = 2;
        eVar2.f5729n = f5;
        bVar2.f1498r = eVar2;
        setFocusableInTouchMode(true);
        WeakHashMap weakHashMap = y0.f4999a;
        g0.s(this, 1);
        y0.p(this, new p0.b(this));
        setMotionEventSplittingEnabled(false);
        if (g0.b(this)) {
            setOnApplyWindowInsetsListener(new Object());
            setSystemUiVisibility(1280);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(L);
            try {
                this.f1484w = obtainStyledAttributes.getDrawable(0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, o0.a.f5935a, i4, 0);
        try {
            this.f1463b = obtainStyledAttributes2.hasValue(0) ? obtainStyledAttributes2.getDimension(0, 0.0f) : getResources().getDimension(R.dimen.def_drawer_elevation);
            obtainStyledAttributes2.recycle();
            this.H = new ArrayList();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    public void setDrawerShadow(Drawable drawable, int i4) {
        if (O) {
            return;
        }
        if ((i4 & 8388611) == 8388611) {
            this.D = drawable;
        } else if ((i4 & 8388613) == 8388613) {
            this.E = drawable;
        } else if ((i4 & 3) == 3) {
            this.F = drawable;
        } else if ((i4 & 5) != 5) {
            return;
        } else {
            this.G = drawable;
        }
        n();
        invalidate();
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        this.f1484w = drawable;
        invalidate();
    }

    public void setDrawerLockMode(int i4, @NonNull View view) {
        if (l(view)) {
            setDrawerLockMode(i4, ((LayoutParams) view.getLayoutParams()).f1488a);
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer with appropriate layout_gravity");
    }
}
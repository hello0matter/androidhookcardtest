package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.o0;
import androidx.customview.view.AbsSavedState;
import com.example.msphone.R;
import h0.d;
import i0.g0;
import i0.g2;
import i0.h0;
import i0.j0;
import i0.k0;
import i0.m;
import i0.m0;
import i0.t;
import i0.u;
import i0.v;
import i0.y0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import l.k;
import v.e;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements t, u {

    /* renamed from: t  reason: collision with root package name */
    public static final String f1322t;

    /* renamed from: u  reason: collision with root package name */
    public static final Class[] f1323u;

    /* renamed from: v  reason: collision with root package name */
    public static final ThreadLocal f1324v;

    /* renamed from: w  reason: collision with root package name */
    public static final v.c f1325w;

    /* renamed from: x  reason: collision with root package name */
    public static final d f1326x;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f1327a;

    /* renamed from: b  reason: collision with root package name */
    public final v.d f1328b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f1329c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList f1330d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f1331e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f1332f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1333g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1334h;

    /* renamed from: i  reason: collision with root package name */
    public final int[] f1335i;

    /* renamed from: j  reason: collision with root package name */
    public View f1336j;

    /* renamed from: k  reason: collision with root package name */
    public View f1337k;

    /* renamed from: l  reason: collision with root package name */
    public v.b f1338l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f1339m;

    /* renamed from: n  reason: collision with root package name */
    public g2 f1340n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f1341o;

    /* renamed from: p  reason: collision with root package name */
    public Drawable f1342p;

    /* renamed from: q  reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f1343q;

    /* renamed from: r  reason: collision with root package name */
    public o0 f1344r;

    /* renamed from: s  reason: collision with root package name */
    public final v f1345s;

    /* loaded from: classes.dex */
    public static abstract class Behavior<V extends View> {
        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public boolean e(View view, Rect rect) {
            return false;
        }

        public boolean f(View view, View view2) {
            return false;
        }

        public void g(b bVar) {
        }

        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public void i(CoordinatorLayout coordinatorLayout, View view) {
        }

        public void j() {
        }

        public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean l(CoordinatorLayout coordinatorLayout, View view, int i4) {
            return false;
        }

        public boolean m(CoordinatorLayout coordinatorLayout, View view, int i4, int i5, int i6) {
            return false;
        }

        public boolean n(View view) {
            return false;
        }

        public void o(CoordinatorLayout coordinatorLayout, View view, View view2, int i4, int i5, int[] iArr, int i6) {
        }

        public void p(CoordinatorLayout coordinatorLayout, View view, int i4, int i5, int i6, int[] iArr) {
            iArr[0] = iArr[0] + i5;
            iArr[1] = iArr[1] + i6;
        }

        public boolean q(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z4) {
            return false;
        }

        public void r(View view, Parcelable parcelable) {
        }

        public Parcelable s(View view) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public boolean t(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i4, int i5) {
            return false;
        }

        public void u(CoordinatorLayout coordinatorLayout, View view, View view2, int i4) {
        }

        public boolean v(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    /* loaded from: classes.dex */
    public @interface DefaultBehavior {
        Class<? extends Behavior> value();
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f171c})
    /* loaded from: classes.dex */
    public @interface DispatchChangeEvent {
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: c  reason: collision with root package name */
        public SparseArray f1346c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f1346c = new SparseArray(readInt);
            for (int i4 = 0; i4 < readInt; i4++) {
                this.f1346c.append(iArr[i4], readParcelableArray[i4]);
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            SparseArray sparseArray = this.f1346c;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i5 = 0; i5 < size; i5++) {
                iArr[i5] = this.f1346c.keyAt(i5);
                parcelableArr[i5] = (Parcelable) this.f1346c.valueAt(i5);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i4);
        }
    }

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        f1322t = r02 != null ? r02.getName() : null;
        f1325w = new v.c(0);
        f1323u = new Class[]{Context.class, AttributeSet.class};
        f1324v = new ThreadLocal();
        f1326x = new d(12);
    }

    public CoordinatorLayout(@NonNull Context context) {
        this(context, null);
    }

    public static void A(int i4, View view) {
        b bVar = (b) view.getLayoutParams();
        int i5 = bVar.f1355i;
        if (i5 != i4) {
            WeakHashMap weakHashMap = y0.f4999a;
            view.offsetLeftAndRight(i4 - i5);
            bVar.f1355i = i4;
        }
    }

    public static void B(int i4, View view) {
        b bVar = (b) view.getLayoutParams();
        int i5 = bVar.f1356j;
        if (i5 != i4) {
            WeakHashMap weakHashMap = y0.f4999a;
            view.offsetTopAndBottom(i4 - i5);
            bVar.f1356j = i4;
        }
    }

    public static Rect k() {
        Rect rect = (Rect) f1326x.a();
        return rect == null ? new Rect() : rect;
    }

    public static void q(int i4, Rect rect, Rect rect2, b bVar, int i5, int i6) {
        int width;
        int height;
        int i7 = bVar.f1349c;
        if (i7 == 0) {
            i7 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i7, i4);
        int i8 = bVar.f1350d;
        if ((i8 & 7) == 0) {
            i8 |= 8388611;
        }
        if ((i8 & 112) == 0) {
            i8 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i8, i4);
        int i9 = absoluteGravity & 7;
        int i10 = absoluteGravity & 112;
        int i11 = absoluteGravity2 & 7;
        int i12 = absoluteGravity2 & 112;
        if (i11 != 1) {
            if (i11 != 5) {
                width = rect.left;
            } else {
                width = rect.right;
            }
        } else {
            width = rect.left + (rect.width() / 2);
        }
        if (i12 != 16) {
            if (i12 != 80) {
                height = rect.top;
            } else {
                height = rect.bottom;
            }
        } else {
            height = rect.top + (rect.height() / 2);
        }
        if (i9 != 1) {
            if (i9 != 5) {
                width -= i5;
            }
        } else {
            width -= i5 / 2;
        }
        if (i10 != 16) {
            if (i10 != 80) {
                height -= i6;
            }
        } else {
            height -= i6 / 2;
        }
        rect2.set(width, height, i5 + width, i6 + height);
    }

    public static b s(View view) {
        b bVar = (b) view.getLayoutParams();
        if (!bVar.f1348b) {
            if (view instanceof a) {
                Behavior behavior = ((a) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                Behavior behavior2 = bVar.f1347a;
                if (behavior2 != behavior) {
                    if (behavior2 != null) {
                        behavior2.j();
                    }
                    bVar.f1347a = behavior;
                    bVar.f1348b = true;
                    if (behavior != null) {
                        behavior.g(bVar);
                    }
                }
            } else {
                DefaultBehavior defaultBehavior = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    defaultBehavior = (DefaultBehavior) cls.getAnnotation(DefaultBehavior.class);
                    if (defaultBehavior != null) {
                        break;
                    }
                }
                if (defaultBehavior != null) {
                    try {
                        Behavior newInstance = defaultBehavior.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        Behavior behavior3 = bVar.f1347a;
                        if (behavior3 != newInstance) {
                            if (behavior3 != null) {
                                behavior3.j();
                            }
                            bVar.f1347a = newInstance;
                            bVar.f1348b = true;
                            if (newInstance != null) {
                                newInstance.g(bVar);
                            }
                        }
                    } catch (Exception e4) {
                        Log.e("CoordinatorLayout", "Default behavior class " + defaultBehavior.value().getName() + " could not be instantiated. Did you forget a default constructor?", e4);
                    }
                }
            }
            bVar.f1348b = true;
        }
        return bVar;
    }

    public final void C() {
        WeakHashMap weakHashMap = y0.f4999a;
        if (g0.b(this)) {
            if (this.f1344r == null) {
                this.f1344r = new o0(9, this);
            }
            m0.u(this, this.f1344r);
            setSystemUiVisibility(1280);
            return;
        }
        m0.u(this, null);
    }

    @Override // i0.t
    public final void b(View view, View view2, int i4, int i5) {
        v vVar = this.f1345s;
        if (i5 == 1) {
            vVar.f4990b = i4;
        } else {
            vVar.f4989a = i4;
        }
        this.f1337k = view2;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            ((b) getChildAt(i6).getLayoutParams()).getClass();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof b) && super.checkLayoutParams(layoutParams);
    }

    @Override // i0.t
    public final void d(View view, int i4, int i5, int[] iArr, int i6) {
        Behavior behavior;
        int min;
        int min2;
        int childCount = getChildCount();
        boolean z4 = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                b bVar = (b) childAt.getLayoutParams();
                if (bVar.a(i6) && (behavior = bVar.f1347a) != null) {
                    int[] iArr2 = this.f1331e;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behavior.o(this, childAt, view, i4, i5, iArr2, i6);
                    if (i4 > 0) {
                        min = Math.max(i7, iArr2[0]);
                    } else {
                        min = Math.min(i7, iArr2[0]);
                    }
                    i7 = min;
                    if (i5 > 0) {
                        min2 = Math.max(i8, iArr2[1]);
                    } else {
                        min2 = Math.min(i8, iArr2[1]);
                    }
                    i8 = min2;
                    z4 = true;
                }
            }
        }
        iArr[0] = i7;
        iArr[1] = i8;
        if (z4) {
            u(1);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j4) {
        Behavior behavior = ((b) view.getLayoutParams()).f1347a;
        if (behavior != null) {
            behavior.getClass();
        }
        return super.drawChild(canvas, view, j4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f1342p;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidate();
        }
    }

    @Override // i0.t
    public final void e(int i4, View view) {
        v vVar = this.f1345s;
        if (i4 == 1) {
            vVar.f4990b = 0;
        } else {
            vVar.f4989a = 0;
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            b bVar = (b) childAt.getLayoutParams();
            if (bVar.a(i4)) {
                Behavior behavior = bVar.f1347a;
                if (behavior != null) {
                    behavior.u(this, childAt, view, i4);
                }
                if (i4 != 0) {
                    if (i4 == 1) {
                        bVar.f1361o = false;
                    }
                } else {
                    bVar.f1360n = false;
                }
                bVar.f1362p = false;
            }
        }
        this.f1337k = null;
    }

    @Override // i0.u
    public final void f(View view, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
        Behavior behavior;
        int min;
        int min2;
        int childCount = getChildCount();
        boolean z4 = false;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                b bVar = (b) childAt.getLayoutParams();
                if (bVar.a(i8) && (behavior = bVar.f1347a) != null) {
                    int[] iArr2 = this.f1331e;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behavior.p(this, childAt, i5, i6, i7, iArr2);
                    if (i6 > 0) {
                        min = Math.max(i9, iArr2[0]);
                    } else {
                        min = Math.min(i9, iArr2[0]);
                    }
                    i9 = min;
                    if (i7 > 0) {
                        min2 = Math.max(i10, iArr2[1]);
                    } else {
                        min2 = Math.min(i10, iArr2[1]);
                    }
                    i10 = min2;
                    z4 = true;
                }
            }
        }
        iArr[0] = iArr[0] + i9;
        iArr[1] = iArr[1] + i10;
        if (z4) {
            u(1);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new b();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @VisibleForTesting
    public final List<View> getDependencySortedChildren() {
        y();
        return Collections.unmodifiableList(this.f1327a);
    }

    @RestrictTo({RestrictTo.Scope.f171c})
    public final g2 getLastWindowInsets() {
        return this.f1340n;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        v vVar = this.f1345s;
        return vVar.f4990b | vVar.f4989a;
    }

    @Nullable
    public Drawable getStatusBarBackground() {
        return this.f1342p;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    @Override // i0.t
    public final void i(View view, int i4, int i5, int i6, int i7, int i8) {
        f(view, i4, i5, i6, i7, 0, this.f1332f);
    }

    @Override // i0.t
    public final boolean j(View view, View view2, int i4, int i5) {
        int childCount = getChildCount();
        boolean z4 = false;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                b bVar = (b) childAt.getLayoutParams();
                Behavior behavior = bVar.f1347a;
                if (behavior != null) {
                    boolean t4 = behavior.t(this, childAt, view, view2, i4, i5);
                    z4 |= t4;
                    if (i5 != 0) {
                        if (i5 == 1) {
                            bVar.f1361o = t4;
                        }
                    } else {
                        bVar.f1360n = t4;
                    }
                } else if (i5 != 0) {
                    if (i5 == 1) {
                        bVar.f1361o = false;
                    }
                } else {
                    bVar.f1360n = false;
                }
            }
        }
        return z4;
    }

    public final void l(b bVar, Rect rect, int i4, int i5) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) bVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i4) - ((ViewGroup.MarginLayoutParams) bVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) bVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i5) - ((ViewGroup.MarginLayoutParams) bVar).bottomMargin));
        rect.set(max, max2, i4 + max, i5 + max2);
    }

    public final void m(View view) {
        List list = (List) this.f1328b.f6941b.getOrDefault(view, null);
        if (list != null && !list.isEmpty()) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                View view2 = (View) list.get(i4);
                Behavior behavior = ((b) view2.getLayoutParams()).f1347a;
                if (behavior != null) {
                    behavior.h(this, view2, view);
                }
            }
        }
    }

    public final void n(View view, Rect rect, boolean z4) {
        if (!view.isLayoutRequested() && view.getVisibility() != 8) {
            if (z4) {
                p(view, rect);
                return;
            } else {
                rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                return;
            }
        }
        rect.setEmpty();
    }

    public final ArrayList o(View view) {
        k kVar = this.f1328b.f6941b;
        int i4 = kVar.f5252c;
        ArrayList arrayList = null;
        for (int i5 = 0; i5 < i4; i5++) {
            ArrayList arrayList2 = (ArrayList) kVar.j(i5);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(kVar.h(i5));
            }
        }
        ArrayList arrayList3 = this.f1330d;
        arrayList3.clear();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        z(false);
        if (this.f1339m) {
            if (this.f1338l == null) {
                this.f1338l = new v.b(0, this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f1338l);
        }
        if (this.f1340n == null) {
            WeakHashMap weakHashMap = y0.f4999a;
            if (g0.b(this)) {
                k0.c(this);
            }
        }
        this.f1334h = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        z(false);
        if (this.f1339m && this.f1338l != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f1338l);
        }
        View view = this.f1337k;
        if (view != null) {
            e(0, view);
        }
        this.f1334h = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f1341o || this.f1342p == null) {
            return;
        }
        g2 g2Var = this.f1340n;
        int d4 = g2Var != null ? g2Var.d() : 0;
        if (d4 > 0) {
            this.f1342p.setBounds(0, 0, getWidth(), d4);
            this.f1342p.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z(true);
        }
        boolean x4 = x(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            z(true);
        }
        return x4;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        Behavior behavior;
        WeakHashMap weakHashMap = y0.f4999a;
        int d4 = h0.d(this);
        ArrayList arrayList = this.f1327a;
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            View view = (View) arrayList.get(i8);
            if (view.getVisibility() != 8 && ((behavior = ((b) view.getLayoutParams()).f1347a) == null || !behavior.l(this, view, d4))) {
                v(d4, view);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x018a, code lost:
        if (r0.m(r30, r19, r25, r20, r26) == false) goto L63;
     */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x018d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r31, int r32) {
        /*
            Method dump skipped, instructions count: 513
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f4, float f5, boolean z4) {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                b bVar = (b) childAt.getLayoutParams();
                if (bVar.a(0)) {
                    Behavior behavior = bVar.f1347a;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f4, float f5) {
        Behavior behavior;
        int childCount = getChildCount();
        boolean z4 = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                b bVar = (b) childAt.getLayoutParams();
                if (bVar.a(0) && (behavior = bVar.f1347a) != null) {
                    z4 |= behavior.n(view);
                }
            }
        }
        return z4;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i4, int i5, int[] iArr) {
        d(view, i4, i5, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i4, int i5, int i6, int i7) {
        i(view, i4, i5, i6, i7, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i4) {
        b(view, view2, i4, 0);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f1460a);
        SparseArray sparseArray = savedState.f1346c;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            int id = childAt.getId();
            Behavior behavior = s(childAt).f1347a;
            if (id != -1 && behavior != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                behavior.r(childAt, parcelable2);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, androidx.customview.view.AbsSavedState, androidx.coordinatorlayout.widget.CoordinatorLayout$SavedState] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable s4;
        ?? absSavedState = new AbsSavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            int id = childAt.getId();
            Behavior behavior = ((b) childAt.getLayoutParams()).f1347a;
            if (id != -1 && behavior != null && (s4 = behavior.s(childAt)) != null) {
                sparseArray.append(id, s4);
            }
        }
        absSavedState.f1346c = sparseArray;
        return absSavedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i4) {
        return j(view, view2, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        e(0, view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r3 != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f1336j
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.x(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = r5
            goto L2a
        L17:
            r3 = r5
        L18:
            android.view.View r6 = r0.f1336j
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.b r6 = (androidx.coordinatorlayout.widget.b) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r6 = r6.f1347a
            if (r6 == 0) goto L15
            android.view.View r7 = r0.f1336j
            boolean r6 = r6.v(r0, r7, r1)
        L2a:
            android.view.View r7 = r0.f1336j
            r8 = 0
            if (r7 != 0) goto L35
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L48
        L35:
            if (r3 == 0) goto L48
            long r11 = android.os.SystemClock.uptimeMillis()
            r15 = 0
            r16 = 0
            r13 = 3
            r14 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L48:
            if (r8 == 0) goto L4d
            r8.recycle()
        L4d:
            if (r2 == r4) goto L52
            r1 = 3
            if (r2 != r1) goto L55
        L52:
            r0.z(r5)
        L55:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(View view, Rect rect) {
        ThreadLocal threadLocal = e.f6944a;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal threadLocal2 = e.f6944a;
        Matrix matrix = (Matrix) threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        e.a(this, view, matrix);
        ThreadLocal threadLocal3 = e.f6945b;
        RectF rectF = (RectF) threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public final int r(int i4) {
        StringBuilder sb;
        int[] iArr = this.f1335i;
        if (iArr == null) {
            sb = new StringBuilder("No keylines defined for ");
            sb.append(this);
            sb.append(" - attempted index lookup ");
            sb.append(i4);
        } else if (i4 >= 0 && i4 < iArr.length) {
            return iArr[i4];
        } else {
            sb = new StringBuilder("Keyline index ");
            sb.append(i4);
            sb.append(" out of range for ");
            sb.append(this);
        }
        Log.e("CoordinatorLayout", sb.toString());
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z4) {
        Behavior behavior = ((b) view.getLayoutParams()).f1347a;
        if (behavior != null && behavior.q(this, view, rect, z4)) {
            return true;
        }
        return super.requestChildRectangleOnScreen(view, rect, z4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z4) {
        super.requestDisallowInterceptTouchEvent(z4);
        if (!z4 || this.f1333g) {
            return;
        }
        z(false);
        this.f1333g = true;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z4) {
        super.setFitsSystemWindows(z4);
        C();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f1343q = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        boolean z4;
        Drawable drawable2 = this.f1342p;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f1342p = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f1342p.setState(getDrawableState());
                }
                Drawable drawable4 = this.f1342p;
                WeakHashMap weakHashMap = y0.f4999a;
                c0.c.b(drawable4, h0.d(this));
                Drawable drawable5 = this.f1342p;
                if (getVisibility() == 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                drawable5.setVisible(z4, false);
                this.f1342p.setCallback(this);
            }
            WeakHashMap weakHashMap2 = y0.f4999a;
            g0.k(this);
        }
    }

    public void setStatusBarBackgroundColor(@ColorInt int i4) {
        setStatusBarBackground(new ColorDrawable(i4));
    }

    public void setStatusBarBackgroundResource(@DrawableRes int i4) {
        Drawable drawable;
        if (i4 != 0) {
            Context context = getContext();
            Object obj = z.e.f7215a;
            drawable = z.c.b(context, i4);
        } else {
            drawable = null;
        }
        setStatusBarBackground(drawable);
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
        boolean z4 = i4 == 0;
        Drawable drawable = this.f1342p;
        if (drawable == null || drawable.isVisible() == z4) {
            return;
        }
        this.f1342p.setVisible(z4, false);
    }

    public final boolean t(View view, int i4, int i5) {
        d dVar = f1326x;
        Rect k4 = k();
        p(view, k4);
        try {
            return k4.contains(i4, i5);
        } finally {
            k4.setEmpty();
            dVar.b(k4);
        }
    }

    public final void u(int i4) {
        int i5;
        Rect rect;
        int i6;
        ArrayList arrayList;
        boolean z4;
        boolean z5;
        boolean z6;
        int width;
        int i7;
        int i8;
        int i9;
        int height;
        int i10;
        int i11;
        int i12;
        int i13;
        b bVar;
        ArrayList arrayList2;
        int i14;
        Rect rect2;
        int i15;
        View view;
        d dVar;
        b bVar2;
        int i16;
        boolean z7;
        Behavior behavior;
        WeakHashMap weakHashMap = y0.f4999a;
        int d4 = h0.d(this);
        ArrayList arrayList3 = this.f1327a;
        int size = arrayList3.size();
        Rect k4 = k();
        Rect k5 = k();
        Rect k6 = k();
        int i17 = 0;
        while (true) {
            d dVar2 = f1326x;
            if (i17 < size) {
                View view2 = (View) arrayList3.get(i17);
                b bVar3 = (b) view2.getLayoutParams();
                if (i4 == 0 && view2.getVisibility() == 8) {
                    arrayList = arrayList3;
                    i6 = size;
                    rect = k6;
                    i5 = i17;
                } else {
                    int i18 = 0;
                    while (i18 < i17) {
                        if (bVar3.f1358l == ((View) arrayList3.get(i18))) {
                            b bVar4 = (b) view2.getLayoutParams();
                            if (bVar4.f1357k != null) {
                                Rect k7 = k();
                                Rect k8 = k();
                                arrayList2 = arrayList3;
                                Rect k9 = k();
                                i13 = i18;
                                p(bVar4.f1357k, k7);
                                n(view2, k8, false);
                                int measuredWidth = view2.getMeasuredWidth();
                                i14 = size;
                                int measuredHeight = view2.getMeasuredHeight();
                                i15 = i17;
                                bVar = bVar3;
                                view = view2;
                                rect2 = k6;
                                dVar = dVar2;
                                q(d4, k7, k9, bVar4, measuredWidth, measuredHeight);
                                if (k9.left == k8.left && k9.top == k8.top) {
                                    bVar2 = bVar4;
                                    i16 = measuredWidth;
                                    z7 = false;
                                } else {
                                    bVar2 = bVar4;
                                    i16 = measuredWidth;
                                    z7 = true;
                                }
                                l(bVar2, k9, i16, measuredHeight);
                                int i19 = k9.left - k8.left;
                                int i20 = k9.top - k8.top;
                                if (i19 != 0) {
                                    WeakHashMap weakHashMap2 = y0.f4999a;
                                    view.offsetLeftAndRight(i19);
                                }
                                if (i20 != 0) {
                                    WeakHashMap weakHashMap3 = y0.f4999a;
                                    view.offsetTopAndBottom(i20);
                                }
                                if (z7 && (behavior = bVar2.f1347a) != null) {
                                    behavior.h(this, view, bVar2.f1357k);
                                }
                                k7.setEmpty();
                                dVar.b(k7);
                                k8.setEmpty();
                                dVar.b(k8);
                                k9.setEmpty();
                                dVar.b(k9);
                                i18 = i13 + 1;
                                dVar2 = dVar;
                                view2 = view;
                                arrayList3 = arrayList2;
                                size = i14;
                                i17 = i15;
                                bVar3 = bVar;
                                k6 = rect2;
                            }
                        }
                        i13 = i18;
                        bVar = bVar3;
                        arrayList2 = arrayList3;
                        i14 = size;
                        rect2 = k6;
                        i15 = i17;
                        view = view2;
                        dVar = dVar2;
                        i18 = i13 + 1;
                        dVar2 = dVar;
                        view2 = view;
                        arrayList3 = arrayList2;
                        size = i14;
                        i17 = i15;
                        bVar3 = bVar;
                        k6 = rect2;
                    }
                    b bVar5 = bVar3;
                    ArrayList arrayList4 = arrayList3;
                    int i21 = size;
                    Rect rect3 = k6;
                    i5 = i17;
                    View view3 = view2;
                    d dVar3 = dVar2;
                    n(view3, k5, true);
                    if (bVar5.f1353g != 0 && !k5.isEmpty()) {
                        int absoluteGravity = Gravity.getAbsoluteGravity(bVar5.f1353g, d4);
                        int i22 = absoluteGravity & 112;
                        if (i22 != 48) {
                            if (i22 == 80) {
                                k4.bottom = Math.max(k4.bottom, getHeight() - k5.top);
                            }
                        } else {
                            k4.top = Math.max(k4.top, k5.bottom);
                        }
                        int i23 = absoluteGravity & 7;
                        if (i23 != 3) {
                            if (i23 == 5) {
                                k4.right = Math.max(k4.right, getWidth() - k5.left);
                            }
                        } else {
                            k4.left = Math.max(k4.left, k5.right);
                        }
                    }
                    if (bVar5.f1354h != 0 && view3.getVisibility() == 0) {
                        WeakHashMap weakHashMap4 = y0.f4999a;
                        if (j0.c(view3) && view3.getWidth() > 0 && view3.getHeight() > 0) {
                            b bVar6 = (b) view3.getLayoutParams();
                            Behavior behavior2 = bVar6.f1347a;
                            Rect k10 = k();
                            Rect k11 = k();
                            k11.set(view3.getLeft(), view3.getTop(), view3.getRight(), view3.getBottom());
                            if (behavior2 != null && behavior2.e(view3, k10)) {
                                if (!k11.contains(k10)) {
                                    throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + k10.toShortString() + " | Bounds:" + k11.toShortString());
                                }
                            } else {
                                k10.set(k11);
                            }
                            k11.setEmpty();
                            dVar3.b(k11);
                            if (!k10.isEmpty()) {
                                int absoluteGravity2 = Gravity.getAbsoluteGravity(bVar6.f1354h, d4);
                                if ((absoluteGravity2 & 48) == 48 && (i11 = (k10.top - ((ViewGroup.MarginLayoutParams) bVar6).topMargin) - bVar6.f1356j) < (i12 = k4.top)) {
                                    B(i12 - i11, view3);
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                if ((absoluteGravity2 & 80) == 80 && (height = ((getHeight() - k10.bottom) - ((ViewGroup.MarginLayoutParams) bVar6).bottomMargin) + bVar6.f1356j) < (i10 = k4.bottom)) {
                                    B(height - i10, view3);
                                } else if (!z5) {
                                    B(0, view3);
                                }
                                if ((absoluteGravity2 & 3) == 3 && (i8 = (k10.left - ((ViewGroup.MarginLayoutParams) bVar6).leftMargin) - bVar6.f1355i) < (i9 = k4.left)) {
                                    A(i9 - i8, view3);
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                if ((absoluteGravity2 & 5) == 5 && (width = ((getWidth() - k10.right) - ((ViewGroup.MarginLayoutParams) bVar6).rightMargin) + bVar6.f1355i) < (i7 = k4.right)) {
                                    A(width - i7, view3);
                                } else if (!z6) {
                                    A(0, view3);
                                }
                            }
                            k10.setEmpty();
                            dVar3.b(k10);
                        }
                    }
                    if (i4 != 2) {
                        rect = rect3;
                        rect.set(((b) view3.getLayoutParams()).f1363q);
                        if (rect.equals(k5)) {
                            arrayList = arrayList4;
                            i6 = i21;
                        } else {
                            ((b) view3.getLayoutParams()).f1363q.set(k5);
                        }
                    } else {
                        rect = rect3;
                    }
                    int i24 = i5 + 1;
                    i6 = i21;
                    while (true) {
                        arrayList = arrayList4;
                        if (i24 >= i6) {
                            break;
                        }
                        View view4 = (View) arrayList.get(i24);
                        b bVar7 = (b) view4.getLayoutParams();
                        Behavior behavior3 = bVar7.f1347a;
                        if (behavior3 != null && behavior3.f(view4, view3)) {
                            if (i4 == 0 && bVar7.f1362p) {
                                bVar7.f1362p = false;
                            } else {
                                if (i4 != 2) {
                                    z4 = behavior3.h(this, view4, view3);
                                } else {
                                    behavior3.i(this, view3);
                                    z4 = true;
                                }
                                if (i4 == 1) {
                                    bVar7.f1362p = z4;
                                }
                            }
                        }
                        i24++;
                        arrayList4 = arrayList;
                    }
                }
                i17 = i5 + 1;
                k6 = rect;
                size = i6;
                arrayList3 = arrayList;
            } else {
                Rect rect4 = k6;
                k4.setEmpty();
                dVar2.b(k4);
                k5.setEmpty();
                dVar2.b(k5);
                rect4.setEmpty();
                dVar2.b(rect4);
                return;
            }
        }
    }

    public final void v(int i4, View view) {
        Rect k4;
        Rect k5;
        int i5;
        b bVar = (b) view.getLayoutParams();
        View view2 = bVar.f1357k;
        if (view2 == null && bVar.f1352f != -1) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        d dVar = f1326x;
        if (view2 != null) {
            k4 = k();
            k5 = k();
            try {
                p(view2, k4);
                b bVar2 = (b) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                q(i4, k4, k5, bVar2, measuredWidth, measuredHeight);
                l(bVar2, k5, measuredWidth, measuredHeight);
                view.layout(k5.left, k5.top, k5.right, k5.bottom);
                return;
            } finally {
                k4.setEmpty();
                dVar.b(k4);
                k5.setEmpty();
                dVar.b(k5);
            }
        }
        int i6 = bVar.f1351e;
        if (i6 >= 0) {
            b bVar3 = (b) view.getLayoutParams();
            int i7 = bVar3.f1349c;
            if (i7 == 0) {
                i7 = 8388661;
            }
            int absoluteGravity = Gravity.getAbsoluteGravity(i7, i4);
            int i8 = absoluteGravity & 7;
            int i9 = absoluteGravity & 112;
            int width = getWidth();
            int height = getHeight();
            int measuredWidth2 = view.getMeasuredWidth();
            int measuredHeight2 = view.getMeasuredHeight();
            if (i4 == 1) {
                i6 = width - i6;
            }
            int r4 = r(i6) - measuredWidth2;
            if (i8 != 1) {
                if (i8 == 5) {
                    r4 += measuredWidth2;
                }
            } else {
                r4 += measuredWidth2 / 2;
            }
            if (i9 != 16) {
                if (i9 != 80) {
                    i5 = 0;
                } else {
                    i5 = measuredHeight2;
                }
            } else {
                i5 = measuredHeight2 / 2;
            }
            int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) bVar3).leftMargin, Math.min(r4, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) bVar3).rightMargin));
            int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) bVar3).topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) bVar3).bottomMargin));
            view.layout(max, max2, measuredWidth2 + max, measuredHeight2 + max2);
            return;
        }
        b bVar4 = (b) view.getLayoutParams();
        k4 = k();
        k4.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) bVar4).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) bVar4).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) bVar4).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) bVar4).bottomMargin);
        if (this.f1340n != null) {
            WeakHashMap weakHashMap = y0.f4999a;
            if (g0.b(this) && !g0.b(view)) {
                k4.left = this.f1340n.b() + k4.left;
                k4.top = this.f1340n.d() + k4.top;
                k4.right -= this.f1340n.c();
                k4.bottom -= this.f1340n.a();
            }
        }
        k5 = k();
        int i10 = bVar4.f1349c;
        if ((i10 & 7) == 0) {
            i10 |= 8388611;
        }
        if ((i10 & 112) == 0) {
            i10 |= 48;
        }
        m.b(i10, view.getMeasuredWidth(), view.getMeasuredHeight(), k4, k5, i4);
        view.layout(k5.left, k5.top, k5.right, k5.bottom);
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1342p;
    }

    public final void w(View view, int i4, int i5, int i6) {
        measureChildWithMargins(view, i4, i5, i6, 0);
    }

    public final boolean x(MotionEvent motionEvent, int i4) {
        boolean z4;
        int i5;
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.f1329c;
        arrayList.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i6 = childCount - 1; i6 >= 0; i6--) {
            if (isChildrenDrawingOrderEnabled) {
                i5 = getChildDrawingOrder(childCount, i6);
            } else {
                i5 = i6;
            }
            arrayList.add(getChildAt(i5));
        }
        v.c cVar = f1325w;
        if (cVar != null) {
            Collections.sort(arrayList, cVar);
        }
        int size = arrayList.size();
        MotionEvent motionEvent2 = null;
        boolean z5 = false;
        boolean z6 = false;
        for (int i7 = 0; i7 < size; i7++) {
            View view = (View) arrayList.get(i7);
            b bVar = (b) view.getLayoutParams();
            Behavior behavior = bVar.f1347a;
            if ((z5 || z6) && actionMasked != 0) {
                if (behavior != null) {
                    if (motionEvent2 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (i4 != 0) {
                        if (i4 == 1) {
                            behavior.v(this, view, motionEvent2);
                        }
                    } else {
                        behavior.k(this, view, motionEvent2);
                    }
                }
            } else {
                if (!z5 && behavior != null) {
                    if (i4 != 0) {
                        if (i4 == 1) {
                            z5 = behavior.v(this, view, motionEvent);
                        }
                    } else {
                        z5 = behavior.k(this, view, motionEvent);
                    }
                    if (z5) {
                        this.f1336j = view;
                    }
                }
                if (bVar.f1347a == null) {
                    bVar.f1359m = false;
                }
                boolean z7 = bVar.f1359m;
                if (z7) {
                    z4 = true;
                } else {
                    bVar.f1359m = z7;
                    z4 = z7;
                }
                if (z4 && !z7) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (z4 && !z6) {
                    break;
                }
            }
        }
        arrayList.clear();
        return z5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ec, code lost:
        if ((android.view.Gravity.getAbsoluteGravity(r8.f1354h, r12) & r13) == r13) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0139, code lost:
        throw new java.lang.IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void y() {
        /*
            Method dump skipped, instructions count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.y():void");
    }

    public final void z(boolean z4) {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            Behavior behavior = ((b) childAt.getLayoutParams()).f1347a;
            if (behavior != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z4) {
                    behavior.k(this, childAt, obtain);
                } else {
                    behavior.v(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            ((b) getChildAt(i5).getLayoutParams()).f1359m = false;
        }
        this.f1336j = null;
        this.f1333g = false;
    }

    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.coordinatorLayoutStyle);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b ? new b((b) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, i0.v] */
    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i4) {
        super(context, attributeSet, i4);
        this.f1327a = new ArrayList();
        this.f1328b = new v.d();
        this.f1329c = new ArrayList();
        this.f1330d = new ArrayList();
        this.f1331e = new int[2];
        this.f1332f = new int[2];
        this.f1345s = new Object();
        int[] iArr = u.a.f6847a;
        TypedArray obtainStyledAttributes = i4 == 0 ? context.obtainStyledAttributes(attributeSet, iArr, 0, 2131756123) : context.obtainStyledAttributes(attributeSet, iArr, i4, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            if (i4 != 0) {
                saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, i4, 0);
            } else {
                saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, 0, 2131756123);
            }
        }
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            this.f1335i = intArray;
            float f4 = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i5 = 0; i5 < length; i5++) {
                int[] iArr2 = this.f1335i;
                iArr2[i5] = (int) (iArr2[i5] * f4);
            }
        }
        this.f1342p = obtainStyledAttributes.getDrawable(1);
        obtainStyledAttributes.recycle();
        C();
        super.setOnHierarchyChangeListener(new v.a(this));
        WeakHashMap weakHashMap = y0.f4999a;
        if (g0.c(this) == 0) {
            g0.s(this, 1);
        }
    }
}
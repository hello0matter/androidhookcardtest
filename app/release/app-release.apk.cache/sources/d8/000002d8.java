package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.customview.view.AbsSavedState;
import com.example.msphone.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements i0.r {

    /* renamed from: t0 */
    public static final int[] f1963t0 = {16843830};

    /* renamed from: u0 */
    public static final Class[] f1964u0;

    /* renamed from: v0 */
    public static final h0 f1965v0;
    public boolean A;
    public int B;
    public int C;
    public n0 D;
    public EdgeEffect E;
    public EdgeEffect F;
    public EdgeEffect G;
    public EdgeEffect H;
    public p0 I;
    public int J;
    public int K;
    public VelocityTracker L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public w0 R;
    public final int S;
    public final int T;
    public final float U;
    public final float V;
    public boolean W;

    /* renamed from: a */
    public final d1 f1966a;

    /* renamed from: a0 */
    public final k1 f1967a0;

    /* renamed from: b */
    public final b1 f1968b;

    /* renamed from: b0 */
    public t f1969b0;

    /* renamed from: c */
    public SavedState f1970c;

    /* renamed from: c0 */
    public final r f1971c0;

    /* renamed from: d */
    public final b f1972d;

    /* renamed from: d0 */
    public final i1 f1973d0;

    /* renamed from: e */
    public final d f1974e;

    /* renamed from: e0 */
    public y0 f1975e0;

    /* renamed from: f */
    public final x1 f1976f;

    /* renamed from: f0 */
    public ArrayList f1977f0;

    /* renamed from: g */
    public boolean f1978g;

    /* renamed from: g0 */
    public boolean f1979g0;

    /* renamed from: h */
    public final Rect f1980h;

    /* renamed from: h0 */
    public boolean f1981h0;

    /* renamed from: i */
    public final Rect f1982i;

    /* renamed from: i0 */
    public final i0 f1983i0;

    /* renamed from: j */
    public final RectF f1984j;

    /* renamed from: j0 */
    public boolean f1985j0;

    /* renamed from: k */
    public j0 f1986k;

    /* renamed from: k0 */
    public n1 f1987k0;

    /* renamed from: l */
    public u0 f1988l;

    /* renamed from: l0 */
    public final int[] f1989l0;

    /* renamed from: m */
    public final ArrayList f1990m;

    /* renamed from: m0 */
    public i0.s f1991m0;

    /* renamed from: n */
    public final ArrayList f1992n;

    /* renamed from: n0 */
    public final int[] f1993n0;

    /* renamed from: o */
    public x0 f1994o;

    /* renamed from: o0 */
    public final int[] f1995o0;

    /* renamed from: p */
    public boolean f1996p;

    /* renamed from: p0 */
    public final int[] f1997p0;

    /* renamed from: q */
    public boolean f1998q;

    /* renamed from: q0 */
    public final ArrayList f1999q0;

    /* renamed from: r */
    public boolean f2000r;

    /* renamed from: r0 */
    public final g0 f2001r0;

    /* renamed from: s */
    public int f2002s;

    /* renamed from: s0 */
    public final i0 f2003s0;

    /* renamed from: t */
    public boolean f2004t;

    /* renamed from: u */
    public boolean f2005u;

    /* renamed from: v */
    public boolean f2006v;

    /* renamed from: w */
    public int f2007w;

    /* renamed from: x */
    public final AccessibilityManager f2008x;

    /* renamed from: y */
    public ArrayList f2009y;

    /* renamed from: z */
    public boolean f2010z;

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public l1 f2011a;

        /* renamed from: b */
        public final Rect f2012b;

        /* renamed from: c */
        public boolean f2013c;

        /* renamed from: d */
        public boolean f2014d;

        public LayoutParams(int i4, int i5) {
            super(i4, i5);
            this.f2012b = new Rect();
            this.f2013c = true;
            this.f2014d = false;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2012b = new Rect();
            this.f2013c = true;
            this.f2014d = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2012b = new Rect();
            this.f2013c = true;
            this.f2014d = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2012b = new Rect();
            this.f2013c = true;
            this.f2014d = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.f2012b = new Rect();
            this.f2013c = true;
            this.f2014d = false;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f171c})
    /* loaded from: classes.dex */
    public @interface Orientation {
    }

    @RestrictTo({RestrictTo.Scope.f169a})
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: c */
        public Parcelable f2015c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2015c = parcel.readParcelable(classLoader == null ? u0.class.getClassLoader() : classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeParcelable(this.f2015c, 0);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.recyclerview.widget.h0, java.lang.Object] */
    static {
        Class cls = Integer.TYPE;
        f1964u0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        f1965v0 = new Object();
    }

    public RecyclerView(@NonNull Context context) {
        this(context, null);
    }

    public static RecyclerView E(View view) {
        if (view instanceof ViewGroup) {
            if (view instanceof RecyclerView) {
                return (RecyclerView) view;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                RecyclerView E = E(viewGroup.getChildAt(i4));
                if (E != null) {
                    return E;
                }
            }
            return null;
        }
        return null;
    }

    public static l1 J(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f2011a;
    }

    private i0.s getScrollingChildHelper() {
        if (this.f1991m0 == null) {
            this.f1991m0 = new i0.s(this);
        }
        return this.f1991m0;
    }

    public static void j(l1 l1Var) {
        WeakReference weakReference = l1Var.f2171b;
        if (weakReference != null) {
            Object obj = weakReference.get();
            while (true) {
                for (View view = (View) obj; view != null; view = null) {
                    if (view == l1Var.f2170a) {
                        return;
                    }
                    obj = view.getParent();
                    if (obj instanceof View) {
                        break;
                    }
                }
                l1Var.f2171b = null;
                return;
            }
        }
    }

    public final void A(i1 i1Var) {
        if (getScrollState() != 2) {
            i1Var.getClass();
            return;
        }
        OverScroller overScroller = this.f1967a0.f2162c;
        overScroller.getFinalX();
        overScroller.getCurrX();
        i1Var.getClass();
        overScroller.getFinalY();
        overScroller.getCurrY();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View B(android.view.View r3) {
        /*
            r2 = this;
        L0:
            android.view.ViewParent r0 = r3.getParent()
            if (r0 == 0) goto L10
            if (r0 == r2) goto L10
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L10
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            goto L0
        L10:
            if (r0 != r2) goto L13
            goto L14
        L13:
            r3 = 0
        L14:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.B(android.view.View):android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x005c, code lost:
        if (r7 == 2) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean C(android.view.MotionEvent r13) {
        /*
            r12 = this;
            int r0 = r13.getAction()
            java.util.ArrayList r1 = r12.f1992n
            int r2 = r1.size()
            r3 = 0
            r4 = r3
        Lc:
            if (r4 >= r2) goto L6c
            java.lang.Object r5 = r1.get(r4)
            androidx.recyclerview.widget.x0 r5 = (androidx.recyclerview.widget.x0) r5
            r6 = r5
            androidx.recyclerview.widget.p r6 = (androidx.recyclerview.widget.p) r6
            int r7 = r6.f2224v
            r8 = 1
            r9 = 2
            if (r7 != r8) goto L5c
            float r7 = r13.getX()
            float r10 = r13.getY()
            boolean r7 = r6.e(r7, r10)
            float r10 = r13.getX()
            float r11 = r13.getY()
            boolean r10 = r6.d(r10, r11)
            int r11 = r13.getAction()
            if (r11 != 0) goto L60
            if (r7 != 0) goto L3f
            if (r10 == 0) goto L60
        L3f:
            if (r10 == 0) goto L4c
            r6.f2225w = r8
            float r7 = r13.getX()
            int r7 = (int) r7
            float r7 = (float) r7
            r6.f2218p = r7
            goto L58
        L4c:
            if (r7 == 0) goto L58
            r6.f2225w = r9
            float r7 = r13.getY()
            int r7 = (int) r7
            float r7 = (float) r7
            r6.f2215m = r7
        L58:
            r6.g(r9)
            goto L5e
        L5c:
            if (r7 != r9) goto L60
        L5e:
            r6 = r8
            goto L61
        L60:
            r6 = r3
        L61:
            if (r6 == 0) goto L69
            r6 = 3
            if (r0 == r6) goto L69
            r12.f1994o = r5
            return r8
        L69:
            int r4 = r4 + 1
            goto Lc
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.C(android.view.MotionEvent):boolean");
    }

    public final void D(int[] iArr) {
        int e4 = this.f1974e.e();
        if (e4 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i4 = Integer.MAX_VALUE;
        int i5 = Integer.MIN_VALUE;
        for (int i6 = 0; i6 < e4; i6++) {
            l1 J = J(this.f1974e.d(i6));
            if (!J.q()) {
                int c4 = J.c();
                if (c4 < i4) {
                    i4 = c4;
                }
                if (c4 > i5) {
                    i5 = c4;
                }
            }
        }
        iArr[0] = i4;
        iArr[1] = i5;
    }

    public final l1 F(int i4) {
        l1 l1Var = null;
        if (this.f2010z) {
            return null;
        }
        int f4 = this.f1974e.f2071a.f();
        for (int i5 = 0; i5 < f4; i5++) {
            l1 J = J(this.f1974e.f2071a.e(i5));
            if (J != null && !J.j() && G(J) == i4) {
                if (this.f1974e.h(J.f2170a)) {
                    l1Var = J;
                } else {
                    return J;
                }
            }
        }
        return l1Var;
    }

    public final int G(l1 l1Var) {
        if (l1Var.e(524) || !l1Var.g()) {
            return -1;
        }
        b bVar = this.f1972d;
        int i4 = l1Var.f2172c;
        ArrayList arrayList = bVar.f2057b;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            a aVar = (a) arrayList.get(i5);
            int i6 = aVar.f2042a;
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 == 8) {
                        int i7 = aVar.f2043b;
                        if (i7 == i4) {
                            i4 = aVar.f2045d;
                        } else {
                            if (i7 < i4) {
                                i4--;
                            }
                            if (aVar.f2045d <= i4) {
                                i4++;
                            }
                        }
                    }
                } else {
                    int i8 = aVar.f2043b;
                    if (i8 <= i4) {
                        int i9 = aVar.f2045d;
                        if (i8 + i9 > i4) {
                            return -1;
                        }
                        i4 -= i9;
                    } else {
                        continue;
                    }
                }
            } else if (aVar.f2043b <= i4) {
                i4 += aVar.f2045d;
            }
        }
        return i4;
    }

    public final long H(l1 l1Var) {
        if (this.f1986k.f2146b) {
            return l1Var.f2174e;
        }
        return l1Var.f2172c;
    }

    public final l1 I(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return J(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public final Rect K(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        boolean z4 = layoutParams.f2013c;
        Rect rect = layoutParams.f2012b;
        if (!z4) {
            return rect;
        }
        if (this.f1973d0.f2132g && (layoutParams.f2011a.m() || layoutParams.f2011a.h())) {
            return rect;
        }
        rect.set(0, 0, 0, 0);
        ArrayList arrayList = this.f1990m;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            Rect rect2 = this.f1980h;
            rect2.set(0, 0, 0, 0);
            ((q0) arrayList.get(i4)).a(rect2, view, this);
            rect.left += rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.f2013c = false;
        return rect;
    }

    public final boolean L() {
        return !this.f2000r || this.f2010z || this.f1972d.g();
    }

    public final boolean M() {
        return this.B > 0;
    }

    public final void N(int i4) {
        if (this.f1988l == null) {
            return;
        }
        setScrollState(2);
        this.f1988l.m0(i4);
        awakenScrollBars();
    }

    public final void O() {
        int f4 = this.f1974e.f2071a.f();
        for (int i4 = 0; i4 < f4; i4++) {
            ((LayoutParams) this.f1974e.f2071a.e(i4).getLayoutParams()).f2013c = true;
        }
        ArrayList arrayList = this.f1968b.f2063c;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            LayoutParams layoutParams = (LayoutParams) ((l1) arrayList.get(i5)).f2170a.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.f2013c = true;
            }
        }
    }

    public final void P(int i4, int i5, boolean z4) {
        int i6 = i4 + i5;
        int f4 = this.f1974e.f2071a.f();
        for (int i7 = 0; i7 < f4; i7++) {
            l1 J = J(this.f1974e.f2071a.e(i7));
            if (J != null && !J.q()) {
                int i8 = J.f2172c;
                i1 i1Var = this.f1973d0;
                if (i8 >= i6) {
                    J.n(-i5, z4);
                } else if (i8 >= i4) {
                    J.b(8);
                    J.n(-i5, z4);
                    J.f2172c = i4 - 1;
                }
                i1Var.f2131f = true;
            }
        }
        b1 b1Var = this.f1968b;
        ArrayList arrayList = b1Var.f2063c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            l1 l1Var = (l1) arrayList.get(size);
            if (l1Var != null) {
                int i9 = l1Var.f2172c;
                if (i9 >= i6) {
                    l1Var.n(-i5, z4);
                } else if (i9 >= i4) {
                    l1Var.b(8);
                    b1Var.e(size);
                }
            }
        }
        requestLayout();
    }

    public final void Q() {
        this.B++;
    }

    public final void R(boolean z4) {
        int i4;
        AccessibilityManager accessibilityManager;
        int i5 = this.B - 1;
        this.B = i5;
        if (i5 < 1) {
            this.B = 0;
            if (z4) {
                int i6 = this.f2007w;
                this.f2007w = 0;
                if (i6 != 0 && (accessibilityManager = this.f2008x) != null && accessibilityManager.isEnabled()) {
                    AccessibilityEvent obtain = AccessibilityEvent.obtain();
                    obtain.setEventType(2048);
                    j0.b.b(obtain, i6);
                    sendAccessibilityEventUnchecked(obtain);
                }
                ArrayList arrayList = this.f1999q0;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    l1 l1Var = (l1) arrayList.get(size);
                    if (l1Var.f2170a.getParent() == this && !l1Var.q() && (i4 = l1Var.f2186q) != -1) {
                        WeakHashMap weakHashMap = i0.y0.f4999a;
                        i0.g0.s(l1Var.f2170a, i4);
                        l1Var.f2186q = -1;
                    }
                }
                arrayList.clear();
            }
        }
    }

    public final void S(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.K) {
            int i4 = actionIndex == 0 ? 1 : 0;
            this.K = motionEvent.getPointerId(i4);
            int x4 = (int) (motionEvent.getX(i4) + 0.5f);
            this.O = x4;
            this.M = x4;
            int y4 = (int) (motionEvent.getY(i4) + 0.5f);
            this.P = y4;
            this.N = y4;
        }
    }

    public final void T() {
        if (!this.f1985j0 && this.f1996p) {
            WeakHashMap weakHashMap = i0.y0.f4999a;
            i0.g0.m(this, this.f2001r0);
            this.f1985j0 = true;
        }
    }

    public final void U() {
        boolean z4;
        boolean z5;
        boolean z6;
        if (this.f2010z) {
            b bVar = this.f1972d;
            bVar.l(bVar.f2057b);
            bVar.l(bVar.f2058c);
            if (this.A) {
                this.f1988l.V();
            }
        }
        if (this.I != null && this.f1988l.y0()) {
            this.f1972d.j();
        } else {
            this.f1972d.c();
        }
        boolean z7 = true;
        if (!this.f1979g0 && !this.f1981h0) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (this.f2000r && this.I != null && (((z6 = this.f2010z) || z4 || this.f1988l.f2278f) && (!z6 || this.f1986k.f2146b))) {
            z5 = true;
        } else {
            z5 = false;
        }
        i1 i1Var = this.f1973d0;
        i1Var.f2135j = z5;
        if (!z5 || !z4 || this.f2010z || this.I == null || !this.f1988l.y0()) {
            z7 = false;
        }
        i1Var.f2136k = z7;
    }

    public final void V(boolean z4) {
        this.A = z4 | this.A;
        this.f2010z = true;
        int f4 = this.f1974e.f2071a.f();
        for (int i4 = 0; i4 < f4; i4++) {
            l1 J = J(this.f1974e.f2071a.e(i4));
            if (J != null && !J.q()) {
                J.b(6);
            }
        }
        O();
        b1 b1Var = this.f1968b;
        ArrayList arrayList = b1Var.f2063c;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            l1 l1Var = (l1) arrayList.get(i5);
            if (l1Var != null) {
                l1Var.b(6);
                l1Var.a(null);
            }
        }
        j0 j0Var = b1Var.f2068h.f1986k;
        if (j0Var == null || !j0Var.f2146b) {
            b1Var.d();
        }
    }

    public final void W(l1 l1Var, o0 o0Var) {
        l1Var.f2179j &= -8193;
        boolean z4 = this.f1973d0.f2133h;
        x1 x1Var = this.f1976f;
        if (z4 && l1Var.m() && !l1Var.j() && !l1Var.q()) {
            ((l.e) x1Var.f2316b).e(H(l1Var), l1Var);
        }
        x1Var.c(l1Var, o0Var);
    }

    public final void X(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        int width = view3.getWidth();
        int height = view3.getHeight();
        Rect rect = this.f1980h;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.f2013c) {
                int i4 = rect.left;
                Rect rect2 = layoutParams2.f2012b;
                rect.left = i4 - rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, rect);
            offsetRectIntoDescendantCoords(view, rect);
        }
        this.f1988l.j0(this, view, this.f1980h, !this.f2000r, view2 == null);
    }

    public final void Y() {
        VelocityTracker velocityTracker = this.L;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean z4 = false;
        g0(0);
        EdgeEffect edgeEffect = this.E;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z4 = this.E.isFinished();
        }
        EdgeEffect edgeEffect2 = this.F;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z4 |= this.F.isFinished();
        }
        EdgeEffect edgeEffect3 = this.G;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z4 |= this.G.isFinished();
        }
        EdgeEffect edgeEffect4 = this.H;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z4 |= this.H.isFinished();
        }
        if (z4) {
            WeakHashMap weakHashMap = i0.y0.f4999a;
            i0.g0.k(this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x0110, code lost:
        if (r6 == 0) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean Z(int r22, int r23, android.view.MotionEvent r24) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Z(int, int, android.view.MotionEvent):boolean");
    }

    public final void a0(int i4, int i5, int[] iArr) {
        int i6;
        int i7;
        l1 l1Var;
        e0();
        Q();
        int i8 = e0.j.f4429a;
        e0.i.a("RV Scroll");
        i1 i1Var = this.f1973d0;
        A(i1Var);
        b1 b1Var = this.f1968b;
        if (i4 != 0) {
            i6 = this.f1988l.l0(i4, b1Var, i1Var);
        } else {
            i6 = 0;
        }
        if (i5 != 0) {
            i7 = this.f1988l.n0(i5, b1Var, i1Var);
        } else {
            i7 = 0;
        }
        e0.i.b();
        int e4 = this.f1974e.e();
        for (int i9 = 0; i9 < e4; i9++) {
            View d4 = this.f1974e.d(i9);
            l1 I = I(d4);
            if (I != null && (l1Var = I.f2178i) != null) {
                int left = d4.getLeft();
                int top = d4.getTop();
                View view = l1Var.f2170a;
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        R(true);
        f0(false);
        if (iArr != null) {
            iArr[0] = i6;
            iArr[1] = i7;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i4, int i5) {
        u0 u0Var = this.f1988l;
        if (u0Var != null) {
            u0Var.getClass();
        }
        super.addFocusables(arrayList, i4, i5);
    }

    public final void b0(int i4) {
        h1 h1Var;
        if (this.f2005u) {
            return;
        }
        setScrollState(0);
        k1 k1Var = this.f1967a0;
        k1Var.f2166g.removeCallbacks(k1Var);
        k1Var.f2162c.abortAnimation();
        u0 u0Var = this.f1988l;
        if (u0Var != null && (h1Var = u0Var.f2277e) != null) {
            h1Var.d();
        }
        u0 u0Var2 = this.f1988l;
        if (u0Var2 == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        u0Var2.m0(i4);
        awakenScrollBars();
    }

    public final void c0(int i4, int i5, boolean z4) {
        u0 u0Var = this.f1988l;
        if (u0Var == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.f2005u) {
        } else {
            int i6 = 0;
            if (!u0Var.d()) {
                i4 = 0;
            }
            if (!this.f1988l.e()) {
                i5 = 0;
            }
            if (i4 != 0 || i5 != 0) {
                if (z4) {
                    if (i4 != 0) {
                        i6 = 1;
                    }
                    if (i5 != 0) {
                        i6 |= 2;
                    }
                    getScrollingChildHelper().h(i6, 1);
                }
                this.f1967a0.b(i4, i5, Integer.MIN_VALUE, null);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.f1988l.f((LayoutParams) layoutParams);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        u0 u0Var = this.f1988l;
        if (u0Var != null && u0Var.d()) {
            return this.f1988l.j(this.f1973d0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        u0 u0Var = this.f1988l;
        if (u0Var != null && u0Var.d()) {
            return this.f1988l.k(this.f1973d0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        u0 u0Var = this.f1988l;
        if (u0Var != null && u0Var.d()) {
            return this.f1988l.l(this.f1973d0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        u0 u0Var = this.f1988l;
        if (u0Var != null && u0Var.e()) {
            return this.f1988l.m(this.f1973d0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        u0 u0Var = this.f1988l;
        if (u0Var != null && u0Var.e()) {
            return this.f1988l.n(this.f1973d0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        u0 u0Var = this.f1988l;
        if (u0Var != null && u0Var.e()) {
            return this.f1988l.o(this.f1973d0);
        }
        return 0;
    }

    public final void d0(int i4) {
        if (this.f2005u) {
            return;
        }
        u0 u0Var = this.f1988l;
        if (u0Var == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            u0Var.w0(this, i4);
        }
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f4, float f5, boolean z4) {
        return getScrollingChildHelper().a(f4, f5, z4);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f4, float f5) {
        return getScrollingChildHelper().b(f4, f5);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i4, int i5, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i4, i5, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, int[] iArr) {
        return getScrollingChildHelper().e(i4, i5, i6, i7, iArr, 0, null);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean z4;
        float f4;
        float f5;
        int i4;
        boolean z5;
        boolean z6;
        int i5;
        super.draw(canvas);
        ArrayList arrayList = this.f1990m;
        int size = arrayList.size();
        boolean z7 = false;
        for (int i6 = 0; i6 < size; i6++) {
            ((q0) arrayList.get(i6)).c(canvas, this);
        }
        EdgeEffect edgeEffect = this.E;
        if (edgeEffect != null && !edgeEffect.isFinished()) {
            int save = canvas.save();
            if (this.f1978g) {
                i5 = getPaddingBottom();
            } else {
                i5 = 0;
            }
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + i5, 0.0f);
            EdgeEffect edgeEffect2 = this.E;
            if (edgeEffect2 != null && edgeEffect2.draw(canvas)) {
                z4 = true;
            } else {
                z4 = false;
            }
            canvas.restoreToCount(save);
        } else {
            z4 = false;
        }
        EdgeEffect edgeEffect3 = this.F;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.f1978g) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.F;
            if (edgeEffect4 != null && edgeEffect4.draw(canvas)) {
                z6 = true;
            } else {
                z6 = false;
            }
            z4 |= z6;
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.G;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            if (this.f1978g) {
                i4 = getPaddingTop();
            } else {
                i4 = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate(-i4, -width);
            EdgeEffect edgeEffect6 = this.G;
            if (edgeEffect6 != null && edgeEffect6.draw(canvas)) {
                z5 = true;
            } else {
                z5 = false;
            }
            z4 |= z5;
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.H;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f1978g) {
                f4 = getPaddingRight() + (-getWidth());
                f5 = getPaddingBottom() + (-getHeight());
            } else {
                f4 = -getWidth();
                f5 = -getHeight();
            }
            canvas.translate(f4, f5);
            EdgeEffect edgeEffect8 = this.H;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z7 = true;
            }
            z4 |= z7;
            canvas.restoreToCount(save4);
        }
        if ((!z4 && this.I != null && arrayList.size() > 0 && this.I.f()) || z4) {
            WeakHashMap weakHashMap = i0.y0.f4999a;
            i0.g0.k(this);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j4) {
        return super.drawChild(canvas, view, j4);
    }

    public final void e0() {
        int i4 = this.f2002s + 1;
        this.f2002s = i4;
        if (i4 != 1 || this.f2005u) {
            return;
        }
        this.f2004t = false;
    }

    public final void f(l1 l1Var) {
        boolean z4;
        View view = l1Var.f2170a;
        if (view.getParent() == this) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f1968b.j(I(view));
        if (l1Var.l()) {
            this.f1974e.b(view, -1, view.getLayoutParams(), true);
        } else if (!z4) {
            this.f1974e.a(view, -1, true);
        } else {
            d dVar = this.f1974e;
            int indexOfChild = ((RecyclerView) dVar.f2071a.f2125a).indexOfChild(view);
            if (indexOfChild >= 0) {
                dVar.f2072b.h(indexOfChild);
                dVar.g(view);
                return;
            }
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public final void f0(boolean z4) {
        if (this.f2002s < 1) {
            this.f2002s = 1;
        }
        if (!z4 && !this.f2005u) {
            this.f2004t = false;
        }
        if (this.f2002s == 1) {
            if (z4 && this.f2004t && !this.f2005u && this.f1988l != null && this.f1986k != null) {
                p();
            }
            if (!this.f2005u) {
                this.f2004t = false;
            }
        }
        this.f2002s--;
    }

    /* JADX WARN: Removed duplicated region for block: B:177:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0079  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View focusSearch(android.view.View r18, int r19) {
        /*
            Method dump skipped, instructions count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    public final void g(q0 q0Var) {
        u0 u0Var = this.f1988l;
        if (u0Var != null) {
            u0Var.c("Cannot add item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.f1990m;
        if (arrayList.isEmpty()) {
            setWillNotDraw(false);
        }
        arrayList.add(q0Var);
        O();
        requestLayout();
    }

    public final void g0(int i4) {
        getScrollingChildHelper().i(i4);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        u0 u0Var = this.f1988l;
        if (u0Var != null) {
            return u0Var.r();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + z());
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        u0 u0Var = this.f1988l;
        if (u0Var != null) {
            return u0Var.s(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + z());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    @Nullable
    public j0 getAdapter() {
        return this.f1986k;
    }

    @Override // android.view.View
    public int getBaseline() {
        u0 u0Var = this.f1988l;
        if (u0Var != null) {
            u0Var.getClass();
            return -1;
        }
        return super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i4, int i5) {
        return super.getChildDrawingOrder(i4, i5);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f1978g;
    }

    @Nullable
    public n1 getCompatAccessibilityDelegate() {
        return this.f1987k0;
    }

    @NonNull
    public n0 getEdgeEffectFactory() {
        return this.D;
    }

    @Nullable
    public p0 getItemAnimator() {
        return this.I;
    }

    public int getItemDecorationCount() {
        return this.f1990m.size();
    }

    @Nullable
    public u0 getLayoutManager() {
        return this.f1988l;
    }

    public int getMaxFlingVelocity() {
        return this.T;
    }

    public int getMinFlingVelocity() {
        return this.S;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    @Nullable
    public w0 getOnFlingListener() {
        return this.R;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.W;
    }

    @NonNull
    public a1 getRecycledViewPool() {
        return this.f1968b.c();
    }

    public int getScrollState() {
        return this.J;
    }

    public final void h(y0 y0Var) {
        if (this.f1977f0 == null) {
            this.f1977f0 = new ArrayList();
        }
        this.f1977f0.add(y0Var);
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().g(0);
    }

    public final void i(String str) {
        if (M()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + z());
        } else if (this.C > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + z()));
        }
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.f1996p;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.f2005u;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f4977d;
    }

    public final void k() {
        int f4 = this.f1974e.f2071a.f();
        for (int i4 = 0; i4 < f4; i4++) {
            l1 J = J(this.f1974e.f2071a.e(i4));
            if (!J.q()) {
                J.f2173d = -1;
                J.f2176g = -1;
            }
        }
        b1 b1Var = this.f1968b;
        ArrayList arrayList = b1Var.f2063c;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            l1 l1Var = (l1) arrayList.get(i5);
            l1Var.f2173d = -1;
            l1Var.f2176g = -1;
        }
        ArrayList arrayList2 = b1Var.f2061a;
        int size2 = arrayList2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            l1 l1Var2 = (l1) arrayList2.get(i6);
            l1Var2.f2173d = -1;
            l1Var2.f2176g = -1;
        }
        ArrayList arrayList3 = b1Var.f2062b;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i7 = 0; i7 < size3; i7++) {
                l1 l1Var3 = (l1) b1Var.f2062b.get(i7);
                l1Var3.f2173d = -1;
                l1Var3.f2176g = -1;
            }
        }
    }

    public final void l(int i4, int i5) {
        boolean z4;
        EdgeEffect edgeEffect = this.E;
        if (edgeEffect != null && !edgeEffect.isFinished() && i4 > 0) {
            this.E.onRelease();
            z4 = this.E.isFinished();
        } else {
            z4 = false;
        }
        EdgeEffect edgeEffect2 = this.G;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i4 < 0) {
            this.G.onRelease();
            z4 |= this.G.isFinished();
        }
        EdgeEffect edgeEffect3 = this.F;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i5 > 0) {
            this.F.onRelease();
            z4 |= this.F.isFinished();
        }
        EdgeEffect edgeEffect4 = this.H;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i5 < 0) {
            this.H.onRelease();
            z4 |= this.H.isFinished();
        }
        if (z4) {
            WeakHashMap weakHashMap = i0.y0.f4999a;
            i0.g0.k(this);
        }
    }

    public final void m() {
        if (this.f2000r && !this.f2010z) {
            if (!this.f1972d.g()) {
                return;
            }
            this.f1972d.getClass();
            if (this.f1972d.g()) {
                int i4 = e0.j.f4429a;
                e0.i.a("RV FullInvalidate");
                p();
                e0.i.b();
                return;
            }
            return;
        }
        int i5 = e0.j.f4429a;
        e0.i.a("RV FullInvalidate");
        p();
        e0.i.b();
    }

    public final void n(int i4, int i5) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = i0.y0.f4999a;
        setMeasuredDimension(u0.g(i4, paddingRight, i0.g0.e(this)), u0.g(i5, getPaddingBottom() + getPaddingTop(), i0.g0.d(this)));
    }

    public final void o(View view) {
        J(view);
        ArrayList arrayList = this.f2009y;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((v0) this.f2009y.get(size)).getClass();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0057, code lost:
        if (r1 >= 30.0f) goto L16;
     */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, androidx.recyclerview.widget.t] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.B = r0
            r1 = 1
            r5.f1996p = r1
            boolean r2 = r5.f2000r
            if (r2 == 0) goto L15
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L15
            r2 = r1
            goto L16
        L15:
            r2 = r0
        L16:
            r5.f2000r = r2
            androidx.recyclerview.widget.u0 r2 = r5.f1988l
            if (r2 == 0) goto L1e
            r2.f2279g = r1
        L1e:
            r5.f1985j0 = r0
            java.lang.ThreadLocal r0 = androidx.recyclerview.widget.t.f2255e
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.t r1 = (androidx.recyclerview.widget.t) r1
            r5.f1969b0 = r1
            if (r1 != 0) goto L68
            androidx.recyclerview.widget.t r1 = new androidx.recyclerview.widget.t
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f2257a = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f2260d = r2
            r5.f1969b0 = r1
            java.util.WeakHashMap r1 = i0.y0.f4999a
            android.view.Display r1 = i0.h0.b(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L5a
            if (r1 == 0) goto L5a
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L5a
            goto L5c
        L5a:
            r1 = 1114636288(0x42700000, float:60.0)
        L5c:
            androidx.recyclerview.widget.t r2 = r5.f1969b0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f2259c = r3
            r0.set(r2)
        L68:
            androidx.recyclerview.widget.t r0 = r5.f1969b0
            java.util.ArrayList r0 = r0.f2257a
            r0.add(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        h1 h1Var;
        super.onDetachedFromWindow();
        p0 p0Var = this.I;
        if (p0Var != null) {
            p0Var.e();
        }
        setScrollState(0);
        k1 k1Var = this.f1967a0;
        k1Var.f2166g.removeCallbacks(k1Var);
        k1Var.f2162c.abortAnimation();
        u0 u0Var = this.f1988l;
        if (u0Var != null && (h1Var = u0Var.f2277e) != null) {
            h1Var.d();
        }
        this.f1996p = false;
        u0 u0Var2 = this.f1988l;
        if (u0Var2 != null) {
            u0Var2.f2279g = false;
            u0Var2.O(this);
        }
        this.f1999q0.clear();
        removeCallbacks(this.f2001r0);
        this.f1976f.getClass();
        do {
        } while (w1.f2307d.a() != null);
        t tVar = this.f1969b0;
        if (tVar != null) {
            tVar.f2257a.remove(this);
            this.f1969b0 = null;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.f1990m;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((q0) arrayList.get(i4)).b(canvas, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0068  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.u0 r0 = r5.f1988l
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.f2005u
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3e
            androidx.recyclerview.widget.u0 r0 = r5.f1988l
            boolean r0 = r0.e()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = r2
        L2d:
            androidx.recyclerview.widget.u0 r3 = r5.f1988l
            boolean r3 = r3.d()
            if (r3 == 0) goto L3c
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L64
        L3c:
            r3 = r2
            goto L64
        L3e:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L62
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.u0 r3 = r5.f1988l
            boolean r3 = r3.e()
            if (r3 == 0) goto L57
            float r0 = -r0
            goto L3c
        L57:
            androidx.recyclerview.widget.u0 r3 = r5.f1988l
            boolean r3 = r3.d()
            if (r3 == 0) goto L62
            r3 = r0
            r0 = r2
            goto L64
        L62:
            r0 = r2
            r3 = r0
        L64:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6c
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6c:
            float r2 = r5.U
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.V
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.Z(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x00d1, code lost:
        if (r0 != false) goto L48;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int i8 = e0.j.f4429a;
        e0.i.a("RV OnLayout");
        p();
        e0.i.b();
        this.f2000r = true;
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        u0 u0Var = this.f1988l;
        if (u0Var == null) {
            n(i4, i5);
            return;
        }
        boolean J = u0Var.J();
        i1 i1Var = this.f1973d0;
        if (J) {
            int mode = View.MeasureSpec.getMode(i4);
            int mode2 = View.MeasureSpec.getMode(i5);
            this.f1988l.f2274b.n(i4, i5);
            if ((mode == 1073741824 && mode2 == 1073741824) || this.f1986k == null) {
                return;
            }
            if (i1Var.f2129d == 1) {
                q();
            }
            this.f1988l.p0(i4, i5);
            i1Var.f2134i = true;
            r();
            this.f1988l.r0(i4, i5);
            if (this.f1988l.u0()) {
                this.f1988l.p0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                i1Var.f2134i = true;
                r();
                this.f1988l.r0(i4, i5);
            }
        } else if (this.f1998q) {
            this.f1988l.f2274b.n(i4, i5);
        } else if (i1Var.f2136k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
        } else {
            j0 j0Var = this.f1986k;
            if (j0Var != null) {
                i1Var.f2130e = j0Var.a();
            } else {
                i1Var.f2130e = 0;
            }
            e0();
            this.f1988l.f2274b.n(i4, i5);
            f0(false);
            i1Var.f2132g = false;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i4, Rect rect) {
        if (M()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i4, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.f1970c = savedState;
        super.onRestoreInstanceState(savedState.f1460a);
        u0 u0Var = this.f1988l;
        if (u0Var != null && (parcelable2 = this.f1970c.f2015c) != null) {
            u0Var.b0(parcelable2);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, androidx.recyclerview.widget.RecyclerView$SavedState, androidx.customview.view.AbsSavedState] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable;
        ?? absSavedState = new AbsSavedState(super.onSaveInstanceState());
        SavedState savedState = this.f1970c;
        if (savedState != null) {
            absSavedState.f2015c = savedState.f2015c;
        } else {
            u0 u0Var = this.f1988l;
            if (u0Var != null) {
                parcelable = u0Var.c0();
            } else {
                parcelable = null;
            }
            absSavedState.f2015c = parcelable;
        }
        return absSavedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        if (i4 != i6 || i5 != i7) {
            this.H = null;
            this.F = null;
            this.G = null;
            this.E = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:336:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:493:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:496:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x0362  */
    /* JADX WARN: Type inference failed for: r7v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v7 */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r24) {
        /*
            Method dump skipped, instructions count: 1218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:387:0x030a, code lost:
        if (r18.f1974e.f2073c.contains(getFocusedChild()) == false) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:413:0x0369, code lost:
        if (r6.hasFocusable() != false) goto L169;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [androidx.recyclerview.widget.l1] */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r13v7, types: [java.lang.Object, androidx.recyclerview.widget.o0] */
    /* JADX WARN: Type inference failed for: r9v0, types: [androidx.recyclerview.widget.x1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void p() {
        /*
            Method dump skipped, instructions count: 978
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.p():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object, androidx.recyclerview.widget.o0] */
    /* JADX WARN: Type inference failed for: r9v21, types: [java.lang.Object, androidx.recyclerview.widget.o0] */
    public final void q() {
        View view;
        View B;
        l1 I;
        int G;
        View view2;
        int id;
        boolean z4;
        i1 i1Var = this.f1973d0;
        i1Var.a(1);
        A(i1Var);
        i1Var.f2134i = false;
        e0();
        x1 x1Var = this.f1976f;
        ((l.k) x1Var.f2315a).clear();
        ((l.e) x1Var.f2316b).a();
        Q();
        U();
        if (this.W && hasFocus() && this.f1986k != null) {
            view = getFocusedChild();
        } else {
            view = null;
        }
        if (view == null || (B = B(view)) == null) {
            I = null;
        } else {
            I = I(B);
        }
        long j4 = -1;
        if (I == null) {
            i1Var.f2138m = -1L;
            i1Var.f2137l = -1;
            i1Var.f2139n = -1;
        } else {
            if (this.f1986k.f2146b) {
                j4 = I.f2174e;
            }
            i1Var.f2138m = j4;
            if (!this.f2010z) {
                if (I.j()) {
                    G = I.f2173d;
                } else {
                    RecyclerView recyclerView = I.f2187r;
                    if (recyclerView != null) {
                        G = recyclerView.G(I);
                    }
                }
                i1Var.f2137l = G;
                view2 = I.f2170a;
                loop3: while (true) {
                    id = view2.getId();
                    while (!view2.isFocused() && (view2 instanceof ViewGroup) && view2.hasFocus()) {
                        view2 = ((ViewGroup) view2).getFocusedChild();
                        if (view2.getId() != -1) {
                            break;
                        }
                    }
                }
                i1Var.f2139n = id;
            }
            G = -1;
            i1Var.f2137l = G;
            view2 = I.f2170a;
            loop3: while (true) {
                id = view2.getId();
                while (!view2.isFocused()) {
                    view2 = ((ViewGroup) view2).getFocusedChild();
                    if (view2.getId() != -1) {
                        break;
                    }
                }
            }
            i1Var.f2139n = id;
        }
        if (i1Var.f2135j && this.f1981h0) {
            z4 = true;
        } else {
            z4 = false;
        }
        i1Var.f2133h = z4;
        this.f1981h0 = false;
        this.f1979g0 = false;
        i1Var.f2132g = i1Var.f2136k;
        i1Var.f2130e = this.f1986k.a();
        D(this.f1989l0);
        if (i1Var.f2135j) {
            int e4 = this.f1974e.e();
            for (int i4 = 0; i4 < e4; i4++) {
                l1 J = J(this.f1974e.d(i4));
                if (!J.q() && (!J.h() || this.f1986k.f2146b)) {
                    p0 p0Var = this.I;
                    p0.b(J);
                    J.d();
                    p0Var.getClass();
                    ?? obj = new Object();
                    obj.a(J);
                    x1Var.c(J, obj);
                    if (i1Var.f2133h && J.m() && !J.j() && !J.q() && !J.h()) {
                        ((l.e) x1Var.f2316b).e(H(J), J);
                    }
                }
            }
        }
        if (i1Var.f2136k) {
            int f4 = this.f1974e.f2071a.f();
            for (int i5 = 0; i5 < f4; i5++) {
                l1 J2 = J(this.f1974e.f2071a.e(i5));
                if (!J2.q() && J2.f2173d == -1) {
                    J2.f2173d = J2.f2172c;
                }
            }
            boolean z5 = i1Var.f2131f;
            i1Var.f2131f = false;
            this.f1988l.Z(this.f1968b, i1Var);
            i1Var.f2131f = z5;
            for (int i6 = 0; i6 < this.f1974e.e(); i6++) {
                l1 J3 = J(this.f1974e.d(i6));
                if (!J3.q()) {
                    Object obj2 = x1Var.f2315a;
                    w1 w1Var = (w1) ((l.k) obj2).getOrDefault(J3, null);
                    if (w1Var == null || (w1Var.f2308a & 4) == 0) {
                        p0.b(J3);
                        boolean e5 = J3.e(8192);
                        p0 p0Var2 = this.I;
                        J3.d();
                        p0Var2.getClass();
                        ?? obj3 = new Object();
                        obj3.a(J3);
                        if (e5) {
                            W(J3, obj3);
                        } else {
                            l.k kVar = (l.k) obj2;
                            w1 w1Var2 = (w1) kVar.getOrDefault(J3, null);
                            if (w1Var2 == null) {
                                w1Var2 = w1.a();
                                kVar.put(J3, w1Var2);
                            }
                            w1Var2.f2308a |= 2;
                            w1Var2.f2309b = obj3;
                        }
                    }
                }
            }
        }
        k();
        R(true);
        f0(false);
        i1Var.f2129d = 2;
    }

    public final void r() {
        boolean z4;
        e0();
        Q();
        i1 i1Var = this.f1973d0;
        i1Var.a(6);
        this.f1972d.c();
        i1Var.f2130e = this.f1986k.a();
        i1Var.f2128c = 0;
        i1Var.f2132g = false;
        this.f1988l.Z(this.f1968b, i1Var);
        i1Var.f2131f = false;
        this.f1970c = null;
        if (i1Var.f2135j && this.I != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        i1Var.f2135j = z4;
        i1Var.f2129d = 4;
        R(true);
        f0(false);
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z4) {
        l1 J = J(view);
        if (J != null) {
            if (J.l()) {
                J.f2179j &= -257;
            } else if (!J.q()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + J + z());
            }
        }
        view.clearAnimation();
        o(view);
        super.removeDetachedView(view, z4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        h1 h1Var = this.f1988l.f2277e;
        if ((h1Var == null || !h1Var.f2115e) && !M() && view2 != null) {
            X(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z4) {
        return this.f1988l.j0(this, view, rect, z4, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z4) {
        ArrayList arrayList = this.f1992n;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((x0) arrayList.get(i4)).getClass();
        }
        super.requestDisallowInterceptTouchEvent(z4);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f2002s != 0 || this.f2005u) {
            this.f2004t = true;
        } else {
            super.requestLayout();
        }
    }

    public final boolean s(int i4, int i5, int[] iArr, int[] iArr2, int i6) {
        return getScrollingChildHelper().c(i4, i5, iArr, iArr2, i6);
    }

    @Override // android.view.View
    public final void scrollBy(int i4, int i5) {
        u0 u0Var = this.f1988l;
        if (u0Var == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.f2005u) {
        } else {
            boolean d4 = u0Var.d();
            boolean e4 = this.f1988l.e();
            if (d4 || e4) {
                if (!d4) {
                    i4 = 0;
                }
                if (!e4) {
                    i5 = 0;
                }
                Z(i4, i5, null);
            }
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i4, int i5) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        int i4;
        if (M()) {
            int i5 = 0;
            if (accessibilityEvent != null) {
                i4 = j0.b.a(accessibilityEvent);
            } else {
                i4 = 0;
            }
            if (i4 != 0) {
                i5 = i4;
            }
            this.f2007w |= i5;
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(@Nullable n1 n1Var) {
        this.f1987k0 = n1Var;
        i0.y0.p(this, n1Var);
    }

    public void setAdapter(@Nullable j0 j0Var) {
        setLayoutFrozen(false);
        j0 j0Var2 = this.f1986k;
        d1 d1Var = this.f1966a;
        if (j0Var2 != null) {
            j0Var2.f2145a.unregisterObserver(d1Var);
            this.f1986k.getClass();
        }
        p0 p0Var = this.I;
        if (p0Var != null) {
            p0Var.e();
        }
        u0 u0Var = this.f1988l;
        b1 b1Var = this.f1968b;
        if (u0Var != null) {
            u0Var.f0(b1Var);
            this.f1988l.g0(b1Var);
        }
        b1Var.f2061a.clear();
        b1Var.d();
        b bVar = this.f1972d;
        bVar.l(bVar.f2057b);
        bVar.l(bVar.f2058c);
        j0 j0Var3 = this.f1986k;
        this.f1986k = j0Var;
        if (j0Var != null) {
            j0Var.f2145a.registerObserver(d1Var);
        }
        j0 j0Var4 = this.f1986k;
        b1Var.f2061a.clear();
        b1Var.d();
        a1 c4 = b1Var.c();
        if (j0Var3 != null) {
            c4.f2055b--;
        }
        if (c4.f2055b == 0) {
            int i4 = 0;
            while (true) {
                SparseArray sparseArray = c4.f2054a;
                if (i4 >= sparseArray.size()) {
                    break;
                }
                ((z0) sparseArray.valueAt(i4)).f2329a.clear();
                i4++;
            }
        }
        if (j0Var4 != null) {
            c4.f2055b++;
        }
        this.f1973d0.f2131f = true;
        V(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(@Nullable m0 m0Var) {
        if (m0Var == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z4) {
        if (z4 != this.f1978g) {
            this.H = null;
            this.F = null;
            this.G = null;
            this.E = null;
        }
        this.f1978g = z4;
        super.setClipToPadding(z4);
        if (this.f2000r) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(@NonNull n0 n0Var) {
        n0Var.getClass();
        this.D = n0Var;
        this.H = null;
        this.F = null;
        this.G = null;
        this.E = null;
    }

    public void setHasFixedSize(boolean z4) {
        this.f1998q = z4;
    }

    public void setItemAnimator(@Nullable p0 p0Var) {
        p0 p0Var2 = this.I;
        if (p0Var2 != null) {
            p0Var2.e();
            this.I.f2229a = null;
        }
        this.I = p0Var;
        if (p0Var != null) {
            p0Var.f2229a = this.f1983i0;
        }
    }

    public void setItemViewCacheSize(int i4) {
        b1 b1Var = this.f1968b;
        b1Var.f2065e = i4;
        b1Var.k();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z4) {
        suppressLayout(z4);
    }

    public void setLayoutManager(@Nullable u0 u0Var) {
        i0 i0Var;
        Object obj;
        h1 h1Var;
        if (u0Var == this.f1988l) {
            return;
        }
        int i4 = 0;
        setScrollState(0);
        k1 k1Var = this.f1967a0;
        k1Var.f2166g.removeCallbacks(k1Var);
        k1Var.f2162c.abortAnimation();
        u0 u0Var2 = this.f1988l;
        if (u0Var2 != null && (h1Var = u0Var2.f2277e) != null) {
            h1Var.d();
        }
        u0 u0Var3 = this.f1988l;
        b1 b1Var = this.f1968b;
        if (u0Var3 != null) {
            p0 p0Var = this.I;
            if (p0Var != null) {
                p0Var.e();
            }
            this.f1988l.f0(b1Var);
            this.f1988l.g0(b1Var);
            b1Var.f2061a.clear();
            b1Var.d();
            if (this.f1996p) {
                u0 u0Var4 = this.f1988l;
                u0Var4.f2279g = false;
                u0Var4.O(this);
            }
            this.f1988l.s0(null);
            this.f1988l = null;
        } else {
            b1Var.f2061a.clear();
            b1Var.d();
        }
        d dVar = this.f1974e;
        dVar.f2072b.g();
        ArrayList arrayList = dVar.f2073c;
        int size = arrayList.size() - 1;
        while (true) {
            i0Var = dVar.f2071a;
            if (size < 0) {
                break;
            }
            i0Var.getClass();
            l1 J = J((View) arrayList.get(size));
            if (J != null) {
                RecyclerView recyclerView = (RecyclerView) i0Var.f2125a;
                int i5 = J.f2185p;
                if (recyclerView.M()) {
                    J.f2186q = i5;
                    recyclerView.f1999q0.add(J);
                } else {
                    WeakHashMap weakHashMap = i0.y0.f4999a;
                    i0.g0.s(J.f2170a, i5);
                }
                J.f2185p = 0;
            }
            arrayList.remove(size);
            size--;
        }
        int f4 = i0Var.f();
        while (true) {
            obj = i0Var.f2125a;
            if (i4 >= f4) {
                break;
            }
            View e4 = i0Var.e(i4);
            ((RecyclerView) obj).o(e4);
            e4.clearAnimation();
            i4++;
        }
        ((RecyclerView) obj).removeAllViews();
        this.f1988l = u0Var;
        if (u0Var != null) {
            if (u0Var.f2274b == null) {
                u0Var.s0(this);
                if (this.f1996p) {
                    this.f1988l.f2279g = true;
                }
            } else {
                throw new IllegalArgumentException("LayoutManager " + u0Var + " is already attached to a RecyclerView:" + u0Var.f2274b.z());
            }
        }
        b1Var.k();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z4) {
        i0.s scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.f4977d) {
            WeakHashMap weakHashMap = i0.y0.f4999a;
            i0.m0.z(scrollingChildHelper.f4976c);
        }
        scrollingChildHelper.f4977d = z4;
    }

    public void setOnFlingListener(@Nullable w0 w0Var) {
        this.R = w0Var;
    }

    @Deprecated
    public void setOnScrollListener(@Nullable y0 y0Var) {
        this.f1975e0 = y0Var;
    }

    public void setPreserveFocusAfterLayout(boolean z4) {
        this.W = z4;
    }

    public void setRecycledViewPool(@Nullable a1 a1Var) {
        a1 a1Var2;
        b1 b1Var = this.f1968b;
        if (b1Var.f2067g != null) {
            a1Var2.f2055b--;
        }
        b1Var.f2067g = a1Var;
        if (a1Var != null && b1Var.f2068h.getAdapter() != null) {
            b1Var.f2067g.f2055b++;
        }
    }

    public void setRecyclerListener(@Nullable c1 c1Var) {
    }

    public void setScrollState(int i4) {
        h1 h1Var;
        if (i4 == this.J) {
            return;
        }
        this.J = i4;
        if (i4 != 2) {
            k1 k1Var = this.f1967a0;
            k1Var.f2166g.removeCallbacks(k1Var);
            k1Var.f2162c.abortAnimation();
            u0 u0Var = this.f1988l;
            if (u0Var != null && (h1Var = u0Var.f2277e) != null) {
                h1Var.d();
            }
        }
        u0 u0Var2 = this.f1988l;
        if (u0Var2 != null) {
            u0Var2.d0(i4);
        }
        y0 y0Var = this.f1975e0;
        if (y0Var != null) {
            y0Var.a(i4, this);
        }
        ArrayList arrayList = this.f1977f0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((y0) this.f1977f0.get(size)).a(i4, this);
            }
        }
    }

    public void setScrollingTouchSlop(int i4) {
        int scaledTouchSlop;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i4 != 0) {
            if (i4 == 1) {
                scaledTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                this.Q = scaledTouchSlop;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i4 + "; using default value");
        }
        scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.Q = scaledTouchSlop;
    }

    public void setViewCacheExtension(@Nullable j1 j1Var) {
        this.f1968b.getClass();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i4) {
        return getScrollingChildHelper().h(i4, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        getScrollingChildHelper().i(0);
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z4) {
        h1 h1Var;
        if (z4 != this.f2005u) {
            i("Do not suppressLayout in layout or scroll");
            if (!z4) {
                this.f2005u = false;
                if (this.f2004t && this.f1988l != null && this.f1986k != null) {
                    requestLayout();
                }
                this.f2004t = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.f2005u = true;
            this.f2006v = true;
            setScrollState(0);
            k1 k1Var = this.f1967a0;
            k1Var.f2166g.removeCallbacks(k1Var);
            k1Var.f2162c.abortAnimation();
            u0 u0Var = this.f1988l;
            if (u0Var != null && (h1Var = u0Var.f2277e) != null) {
                h1Var.d();
            }
        }
    }

    public final void t(int i4, int i5, int i6, int i7, int[] iArr, int i8, int[] iArr2) {
        getScrollingChildHelper().e(i4, i5, i6, i7, iArr, i8, iArr2);
    }

    public final void u(int i4, int i5) {
        this.C++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i4, scrollY - i5);
        y0 y0Var = this.f1975e0;
        if (y0Var != null) {
            y0Var.b(this, i4, i5);
        }
        ArrayList arrayList = this.f1977f0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((y0) this.f1977f0.get(size)).b(this, i4, i5);
            }
        }
        this.C--;
    }

    public final void v() {
        int measuredWidth;
        int measuredHeight;
        if (this.H != null) {
            return;
        }
        this.D.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.H = edgeEffect;
        if (this.f1978g) {
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        edgeEffect.setSize(measuredWidth, measuredHeight);
    }

    public final void w() {
        int measuredHeight;
        int measuredWidth;
        if (this.E != null) {
            return;
        }
        this.D.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.E = edgeEffect;
        if (this.f1978g) {
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        edgeEffect.setSize(measuredHeight, measuredWidth);
    }

    public final void x() {
        int measuredHeight;
        int measuredWidth;
        if (this.G != null) {
            return;
        }
        this.D.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.G = edgeEffect;
        if (this.f1978g) {
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        edgeEffect.setSize(measuredHeight, measuredWidth);
    }

    public final void y() {
        int measuredWidth;
        int measuredHeight;
        if (this.F != null) {
            return;
        }
        this.D.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.F = edgeEffect;
        if (this.f1978g) {
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        edgeEffect.setSize(measuredWidth, measuredHeight);
    }

    public final String z() {
        return " " + super.toString() + ", adapter:" + this.f1986k + ", layout:" + this.f1988l + ", context:" + getContext();
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.recyclerViewStyle);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        u0 u0Var = this.f1988l;
        if (u0Var != null) {
            return u0Var.t(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + z());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:35|(1:37)(17:91|(1:93)|39|40|(1:42)(1:70)|43|44|45|46|47|48|49|50|51|(1:53)|54|55)|38|39|40|(0)(0)|43|44|45|46|47|48|49|50|51|(0)|54|55) */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x02f1, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x02f2, code lost:
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x02f4, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x02f5, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x02f7, code lost:
        r4 = r3.getConstructor(new java.lang.Class[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x02fd, code lost:
        r15 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x030c, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x030d, code lost:
        r0.initCause(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x032d, code lost:
        throw new java.lang.IllegalStateException(r20.getPositionDescription() + ": Error creating LayoutManager " + r2, r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02af A[Catch: ClassCastException -> 0x02b8, IllegalAccessException -> 0x02bb, InstantiationException -> 0x02be, InvocationTargetException -> 0x02c1, ClassNotFoundException -> 0x02c4, TryCatch #5 {ClassCastException -> 0x02b8, ClassNotFoundException -> 0x02c4, IllegalAccessException -> 0x02bb, InstantiationException -> 0x02be, InvocationTargetException -> 0x02c1, blocks: (B:158:0x02a9, B:160:0x02af, B:172:0x02cb, B:173:0x02d5, B:175:0x02e0, B:183:0x02fe, B:181:0x02f7, B:185:0x030d, B:186:0x032d, B:171:0x02c7), top: B:209:0x02a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02c7 A[Catch: ClassCastException -> 0x02b8, IllegalAccessException -> 0x02bb, InstantiationException -> 0x02be, InvocationTargetException -> 0x02c1, ClassNotFoundException -> 0x02c4, TryCatch #5 {ClassCastException -> 0x02b8, ClassNotFoundException -> 0x02c4, IllegalAccessException -> 0x02bb, InstantiationException -> 0x02be, InvocationTargetException -> 0x02c1, blocks: (B:158:0x02a9, B:160:0x02af, B:172:0x02cb, B:173:0x02d5, B:175:0x02e0, B:183:0x02fe, B:181:0x02f7, B:185:0x030d, B:186:0x032d, B:171:0x02c7), top: B:209:0x02a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03cd  */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object, androidx.recyclerview.widget.n0] */
    /* JADX WARN: Type inference failed for: r0v9, types: [androidx.recyclerview.widget.k, java.lang.Object, androidx.recyclerview.widget.p0] */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.lang.Object, androidx.recyclerview.widget.r] */
    /* JADX WARN: Type inference failed for: r1v17, types: [androidx.recyclerview.widget.i1, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public RecyclerView(@androidx.annotation.NonNull android.content.Context r19, @androidx.annotation.Nullable android.util.AttributeSet r20, int r21) {
        /*
            Method dump skipped, instructions count: 996
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
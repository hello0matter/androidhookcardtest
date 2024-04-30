package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import com.example.msphone.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class a4 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: k  reason: collision with root package name */
    public static a4 f695k;

    /* renamed from: l  reason: collision with root package name */
    public static a4 f696l;

    /* renamed from: a  reason: collision with root package name */
    public final View f697a;

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f698b;

    /* renamed from: c  reason: collision with root package name */
    public final int f699c;

    /* renamed from: d  reason: collision with root package name */
    public final z3 f700d = new Runnable(this) { // from class: androidx.appcompat.widget.z3

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a4 f1000b;

        {
            this.f1000b = this;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i4 = r2;
            a4 a4Var = this.f1000b;
            switch (i4) {
                case 0:
                    a4Var.c(false);
                    return;
                default:
                    a4Var.a();
                    return;
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public final z3 f701e = new Runnable(this) { // from class: androidx.appcompat.widget.z3

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a4 f1000b;

        {
            this.f1000b = this;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i4 = r2;
            a4 a4Var = this.f1000b;
            switch (i4) {
                case 0:
                    a4Var.c(false);
                    return;
                default:
                    a4Var.a();
                    return;
            }
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public int f702f;

    /* renamed from: g  reason: collision with root package name */
    public int f703g;

    /* renamed from: h  reason: collision with root package name */
    public b4 f704h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f705i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f706j;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.appcompat.widget.z3] */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.appcompat.widget.z3] */
    public a4(View view, CharSequence charSequence) {
        int scaledTouchSlop;
        this.f697a = view;
        this.f698b = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Method method = i0.b1.f4907a;
        if (Build.VERSION.SDK_INT >= 28) {
            scaledTouchSlop = i0.a1.a(viewConfiguration);
        } else {
            scaledTouchSlop = viewConfiguration.getScaledTouchSlop() / 2;
        }
        this.f699c = scaledTouchSlop;
        this.f706j = true;
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void b(a4 a4Var) {
        a4 a4Var2 = f695k;
        if (a4Var2 != null) {
            a4Var2.f697a.removeCallbacks(a4Var2.f700d);
        }
        f695k = a4Var;
        if (a4Var != null) {
            a4Var.f697a.postDelayed(a4Var.f700d, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        a4 a4Var = f696l;
        View view = this.f697a;
        if (a4Var == this) {
            f696l = null;
            b4 b4Var = this.f704h;
            if (b4Var != null) {
                View view2 = b4Var.f717b;
                if (view2.getParent() != null) {
                    ((WindowManager) b4Var.f716a.getSystemService("window")).removeView(view2);
                }
                this.f704h = null;
                this.f706j = true;
                view.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f695k == this) {
            b(null);
        }
        view.removeCallbacks(this.f701e);
    }

    public final void c(boolean z4) {
        int height;
        int i4;
        int i5;
        String str;
        int i6;
        String str2;
        int i7;
        long longPressTimeout;
        long j4;
        long j5;
        WeakHashMap weakHashMap = i0.y0.f4999a;
        View view = this.f697a;
        if (!i0.j0.b(view)) {
            return;
        }
        b(null);
        a4 a4Var = f696l;
        if (a4Var != null) {
            a4Var.a();
        }
        f696l = this;
        this.f705i = z4;
        b4 b4Var = new b4(view.getContext());
        this.f704h = b4Var;
        int i8 = this.f702f;
        int i9 = this.f703g;
        boolean z5 = this.f705i;
        View view2 = b4Var.f717b;
        ViewParent parent = view2.getParent();
        Context context = b4Var.f716a;
        if (parent != null && view2.getParent() != null) {
            ((WindowManager) context.getSystemService("window")).removeView(view2);
        }
        b4Var.f718c.setText(this.f698b);
        WindowManager.LayoutParams layoutParams = b4Var.f719d;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i8 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
            height = i9 + dimensionPixelOffset2;
            i4 = i9 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i4 = 0;
        }
        layoutParams.gravity = 49;
        Resources resources = context.getResources();
        if (z5) {
            i5 = R.dimen.tooltip_y_offset_touch;
        } else {
            i5 = R.dimen.tooltip_y_offset_non_touch;
        }
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(i5);
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams2 = rootView.getLayoutParams();
        if (!(layoutParams2 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams2).type != 2) {
            Context context2 = view.getContext();
            while (true) {
                if (!(context2 instanceof ContextWrapper)) {
                    break;
                } else if (context2 instanceof Activity) {
                    rootView = ((Activity) context2).getWindow().getDecorView();
                    break;
                } else {
                    context2 = ((ContextWrapper) context2).getBaseContext();
                }
            }
        }
        if (rootView == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            str2 = "window";
        } else {
            Rect rect = b4Var.f720e;
            rootView.getWindowVisibleDisplayFrame(rect);
            if (rect.left >= 0 || rect.top >= 0) {
                str = "window";
                i6 = 0;
            } else {
                Resources resources2 = context.getResources();
                str = "window";
                int identifier = resources2.getIdentifier("status_bar_height", "dimen", "android");
                if (identifier != 0) {
                    i7 = resources2.getDimensionPixelSize(identifier);
                } else {
                    i7 = 0;
                }
                DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
                i6 = 0;
                rect.set(0, i7, displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            int[] iArr = b4Var.f722g;
            rootView.getLocationOnScreen(iArr);
            int[] iArr2 = b4Var.f721f;
            view.getLocationOnScreen(iArr2);
            int i10 = iArr2[i6] - iArr[i6];
            iArr2[i6] = i10;
            iArr2[1] = iArr2[1] - iArr[1];
            layoutParams.x = (i10 + i8) - (rootView.getWidth() / 2);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, i6);
            view2.measure(makeMeasureSpec, makeMeasureSpec);
            int measuredHeight = view2.getMeasuredHeight();
            int i11 = iArr2[1];
            int i12 = ((i4 + i11) - dimensionPixelOffset3) - measuredHeight;
            int i13 = i11 + height + dimensionPixelOffset3;
            if (!z5 ? measuredHeight + i13 > rect.height() : i12 >= 0) {
                layoutParams.y = i12;
            } else {
                layoutParams.y = i13;
            }
            str2 = str;
        }
        ((WindowManager) context.getSystemService(str2)).addView(view2, layoutParams);
        view.addOnAttachStateChangeListener(this);
        if (this.f705i) {
            j5 = 2500;
        } else {
            if ((i0.g0.g(view) & 1) == 1) {
                longPressTimeout = ViewConfiguration.getLongPressTimeout();
                j4 = 3000;
            } else {
                longPressTimeout = ViewConfiguration.getLongPressTimeout();
                j4 = 15000;
            }
            j5 = j4 - longPressTimeout;
        }
        z3 z3Var = this.f701e;
        view.removeCallbacks(z3Var);
        view.postDelayed(z3Var, j5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0064, code lost:
        if (java.lang.Math.abs(r5 - r3.f703g) <= r2) goto L17;
     */
    @Override // android.view.View.OnHoverListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onHover(android.view.View r4, android.view.MotionEvent r5) {
        /*
            r3 = this;
            androidx.appcompat.widget.b4 r4 = r3.f704h
            r0 = 0
            if (r4 == 0) goto La
            boolean r4 = r3.f705i
            if (r4 == 0) goto La
            return r0
        La:
            android.view.View r4 = r3.f697a
            android.content.Context r1 = r4.getContext()
            java.lang.String r2 = "accessibility"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.view.accessibility.AccessibilityManager r1 = (android.view.accessibility.AccessibilityManager) r1
            boolean r2 = r1.isEnabled()
            if (r2 == 0) goto L25
            boolean r1 = r1.isTouchExplorationEnabled()
            if (r1 == 0) goto L25
            return r0
        L25:
            int r1 = r5.getAction()
            r2 = 7
            if (r1 == r2) goto L38
            r4 = 10
            if (r1 == r4) goto L31
            goto L6f
        L31:
            r4 = 1
            r3.f706j = r4
            r3.a()
            goto L6f
        L38:
            boolean r4 = r4.isEnabled()
            if (r4 == 0) goto L6f
            androidx.appcompat.widget.b4 r4 = r3.f704h
            if (r4 != 0) goto L6f
            float r4 = r5.getX()
            int r4 = (int) r4
            float r5 = r5.getY()
            int r5 = (int) r5
            boolean r1 = r3.f706j
            if (r1 != 0) goto L66
            int r1 = r3.f702f
            int r1 = r4 - r1
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.f699c
            if (r1 > r2) goto L66
            int r1 = r3.f703g
            int r1 = r5 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r1 <= r2) goto L6f
        L66:
            r3.f702f = r4
            r3.f703g = r5
            r3.f706j = r0
            b(r3)
        L6f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.a4.onHover(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f702f = view.getWidth() / 2;
        this.f703g = view.getHeight() / 2;
        c(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        a();
    }
}
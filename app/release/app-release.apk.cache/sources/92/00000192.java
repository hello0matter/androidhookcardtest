package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public abstract class x1 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final float f940a;

    /* renamed from: b  reason: collision with root package name */
    public final int f941b;

    /* renamed from: c  reason: collision with root package name */
    public final int f942c;

    /* renamed from: d  reason: collision with root package name */
    public final View f943d;

    /* renamed from: e  reason: collision with root package name */
    public w1 f944e;

    /* renamed from: f  reason: collision with root package name */
    public w1 f945f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f946g;

    /* renamed from: h  reason: collision with root package name */
    public int f947h;

    /* renamed from: i  reason: collision with root package name */
    public final int[] f948i = new int[2];

    public x1(View view) {
        this.f943d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f940a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f941b = tapTimeout;
        this.f942c = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        w1 w1Var = this.f945f;
        View view = this.f943d;
        if (w1Var != null) {
            view.removeCallbacks(w1Var);
        }
        w1 w1Var2 = this.f944e;
        if (w1Var2 != null) {
            view.removeCallbacks(w1Var2);
        }
    }

    public abstract g.h0 b();

    public abstract boolean c();

    public abstract boolean d();

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
        if (r14 != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007b, code lost:
        if (r4 != 3) goto L61;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fe  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouch(android.view.View r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.x1.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f946g = false;
        this.f947h = -1;
        w1 w1Var = this.f944e;
        if (w1Var != null) {
            this.f943d.removeCallbacks(w1Var);
        }
    }
}
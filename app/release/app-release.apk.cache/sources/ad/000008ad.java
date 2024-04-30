package n0;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.OverScroller;
import androidx.activity.k;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: x  reason: collision with root package name */
    public static final d f5715x = new d(0);

    /* renamed from: a  reason: collision with root package name */
    public int f5716a;

    /* renamed from: b  reason: collision with root package name */
    public int f5717b;

    /* renamed from: d  reason: collision with root package name */
    public float[] f5719d;

    /* renamed from: e  reason: collision with root package name */
    public float[] f5720e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f5721f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f5722g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f5723h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f5724i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f5725j;

    /* renamed from: k  reason: collision with root package name */
    public int f5726k;

    /* renamed from: l  reason: collision with root package name */
    public VelocityTracker f5727l;

    /* renamed from: m  reason: collision with root package name */
    public final float f5728m;

    /* renamed from: n  reason: collision with root package name */
    public float f5729n;

    /* renamed from: o  reason: collision with root package name */
    public int f5730o;

    /* renamed from: p  reason: collision with root package name */
    public final int f5731p;

    /* renamed from: q  reason: collision with root package name */
    public int f5732q;

    /* renamed from: r  reason: collision with root package name */
    public final OverScroller f5733r;

    /* renamed from: s  reason: collision with root package name */
    public final com.google.common.collect.c f5734s;

    /* renamed from: t  reason: collision with root package name */
    public View f5735t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f5736u;

    /* renamed from: v  reason: collision with root package name */
    public final ViewGroup f5737v;

    /* renamed from: c  reason: collision with root package name */
    public int f5718c = -1;

    /* renamed from: w  reason: collision with root package name */
    public final k f5738w = new k(5, this);

    public e(Context context, ViewGroup viewGroup, com.google.common.collect.c cVar) {
        if (viewGroup != null) {
            if (cVar != null) {
                this.f5737v = viewGroup;
                this.f5734s = cVar;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int i4 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
                this.f5731p = i4;
                this.f5730o = i4;
                this.f5717b = viewConfiguration.getScaledTouchSlop();
                this.f5728m = viewConfiguration.getScaledMaximumFlingVelocity();
                this.f5729n = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f5733r = new OverScroller(context, f5715x);
                return;
            }
            throw new IllegalArgumentException("Callback may not be null");
        }
        throw new IllegalArgumentException("Parent view may not be null");
    }

    public final void a() {
        this.f5718c = -1;
        float[] fArr = this.f5719d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f5720e, 0.0f);
            Arrays.fill(this.f5721f, 0.0f);
            Arrays.fill(this.f5722g, 0.0f);
            Arrays.fill(this.f5723h, 0);
            Arrays.fill(this.f5724i, 0);
            Arrays.fill(this.f5725j, 0);
            this.f5726k = 0;
        }
        VelocityTracker velocityTracker = this.f5727l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f5727l = null;
        }
    }

    public final void b(int i4, View view) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = this.f5737v;
        if (parent == viewGroup) {
            this.f5735t = view;
            this.f5718c = i4;
            this.f5734s.t1(i4, view);
            p(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + viewGroup + ")");
    }

    public final boolean c(float f4, float f5, int i4, int i5) {
        float abs = Math.abs(f4);
        float abs2 = Math.abs(f5);
        if ((this.f5723h[i4] & i5) != i5 || (this.f5732q & i5) == 0 || (this.f5725j[i4] & i5) == i5 || (this.f5724i[i4] & i5) == i5) {
            return false;
        }
        float f6 = this.f5717b;
        if (abs <= f6 && abs2 <= f6) {
            return false;
        }
        if (abs < abs2 * 0.5f) {
            this.f5734s.getClass();
        }
        if ((this.f5724i[i4] & i5) != 0 || abs <= this.f5717b) {
            return false;
        }
        return true;
    }

    public final boolean d(View view, float f4, float f5) {
        boolean z4;
        boolean z5;
        if (view == null) {
            return false;
        }
        com.google.common.collect.c cVar = this.f5734s;
        if (cVar.R0(view) > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (cVar.S0() > 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z4 && z5) {
            float f6 = f5 * f5;
            int i4 = this.f5717b;
            if (f6 + (f4 * f4) <= i4 * i4) {
                return false;
            }
            return true;
        } else if (z4) {
            if (Math.abs(f4) <= this.f5717b) {
                return false;
            }
            return true;
        } else if (!z5 || Math.abs(f5) <= this.f5717b) {
            return false;
        } else {
            return true;
        }
    }

    public final void e(int i4) {
        float[] fArr = this.f5719d;
        if (fArr != null) {
            int i5 = this.f5726k;
            int i6 = 1 << i4;
            if ((i5 & i6) != 0) {
                fArr[i4] = 0.0f;
                this.f5720e[i4] = 0.0f;
                this.f5721f[i4] = 0.0f;
                this.f5722g[i4] = 0.0f;
                this.f5723h[i4] = 0;
                this.f5724i[i4] = 0;
                this.f5725j[i4] = 0;
                this.f5726k = (~i6) & i5;
            }
        }
    }

    public final int f(int i4, int i5, int i6) {
        int width;
        int abs;
        if (i4 == 0) {
            return 0;
        }
        float width2 = this.f5737v.getWidth() / 2;
        float sin = (((float) Math.sin((Math.min(1.0f, Math.abs(i4) / width) - 0.5f) * 0.47123894f)) * width2) + width2;
        int abs2 = Math.abs(i5);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(sin / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i4) / i6) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
        if (r2 == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean g() {
        /*
            r9 = this;
            int r0 = r9.f5716a
            r1 = 2
            if (r0 != r1) goto L5b
            android.widget.OverScroller r0 = r9.f5733r
            boolean r2 = r0.computeScrollOffset()
            int r3 = r0.getCurrX()
            int r4 = r0.getCurrY()
            android.view.View r5 = r9.f5735t
            int r5 = r5.getLeft()
            int r5 = r3 - r5
            android.view.View r6 = r9.f5735t
            int r6 = r6.getTop()
            int r6 = r4 - r6
            if (r5 == 0) goto L2c
            android.view.View r7 = r9.f5735t
            java.util.WeakHashMap r8 = i0.y0.f4999a
            r7.offsetLeftAndRight(r5)
        L2c:
            if (r6 == 0) goto L35
            android.view.View r7 = r9.f5735t
            java.util.WeakHashMap r8 = i0.y0.f4999a
            r7.offsetTopAndBottom(r6)
        L35:
            if (r5 != 0) goto L39
            if (r6 == 0) goto L40
        L39:
            com.google.common.collect.c r5 = r9.f5734s
            android.view.View r6 = r9.f5735t
            r5.v1(r6, r3, r4)
        L40:
            if (r2 == 0) goto L52
            int r5 = r0.getFinalX()
            if (r3 != r5) goto L52
            int r3 = r0.getFinalY()
            if (r4 != r3) goto L52
            r0.abortAnimation()
            goto L54
        L52:
            if (r2 != 0) goto L5b
        L54:
            androidx.activity.k r0 = r9.f5738w
            android.view.ViewGroup r2 = r9.f5737v
            r2.post(r0)
        L5b:
            int r0 = r9.f5716a
            if (r0 != r1) goto L61
            r0 = 1
            goto L62
        L61:
            r0 = 0
        L62:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.e.g():boolean");
    }

    public final View h(int i4, int i5) {
        ViewGroup viewGroup = this.f5737v;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            this.f5734s.getClass();
            View childAt = viewGroup.getChildAt(childCount);
            if (i4 >= childAt.getLeft() && i4 < childAt.getRight() && i5 >= childAt.getTop() && i5 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean i(int r11, int r12, int r13, int r14) {
        /*
            r10 = this;
            android.view.View r0 = r10.f5735t
            int r2 = r0.getLeft()
            android.view.View r0 = r10.f5735t
            int r3 = r0.getTop()
            int r4 = r11 - r2
            int r5 = r12 - r3
            android.widget.OverScroller r1 = r10.f5733r
            r11 = 0
            if (r4 != 0) goto L1e
            if (r5 != 0) goto L1e
            r1.abortAnimation()
            r10.p(r11)
            return r11
        L1e:
            android.view.View r12 = r10.f5735t
            float r0 = r10.f5729n
            int r0 = (int) r0
            float r6 = r10.f5728m
            int r6 = (int) r6
            int r7 = java.lang.Math.abs(r13)
            if (r7 >= r0) goto L2e
            r13 = r11
            goto L35
        L2e:
            if (r7 <= r6) goto L35
            if (r13 <= 0) goto L34
            r13 = r6
            goto L35
        L34:
            int r13 = -r6
        L35:
            float r0 = r10.f5729n
            int r0 = (int) r0
            int r7 = java.lang.Math.abs(r14)
            if (r7 >= r0) goto L40
        L3e:
            r14 = r11
            goto L48
        L40:
            if (r7 <= r6) goto L48
            if (r14 <= 0) goto L46
            r14 = r6
            goto L48
        L46:
            int r11 = -r6
            goto L3e
        L48:
            int r11 = java.lang.Math.abs(r4)
            int r0 = java.lang.Math.abs(r5)
            int r6 = java.lang.Math.abs(r13)
            int r7 = java.lang.Math.abs(r14)
            int r8 = r6 + r7
            int r9 = r11 + r0
            if (r13 == 0) goto L62
            float r11 = (float) r6
            float r6 = (float) r8
        L60:
            float r11 = r11 / r6
            goto L65
        L62:
            float r11 = (float) r11
            float r6 = (float) r9
            goto L60
        L65:
            if (r14 == 0) goto L6b
            float r0 = (float) r7
            float r6 = (float) r8
        L69:
            float r0 = r0 / r6
            goto L6e
        L6b:
            float r0 = (float) r0
            float r6 = (float) r9
            goto L69
        L6e:
            com.google.common.collect.c r6 = r10.f5734s
            int r12 = r6.R0(r12)
            int r12 = r10.f(r4, r13, r12)
            int r13 = r6.S0()
            int r13 = r10.f(r5, r14, r13)
            float r12 = (float) r12
            float r12 = r12 * r11
            float r11 = (float) r13
            float r11 = r11 * r0
            float r11 = r11 + r12
            int r6 = (int) r11
            r1.startScroll(r2, r3, r4, r5, r6)
            r11 = 2
            r10.p(r11)
            r11 = 1
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.e.i(int, int, int, int):boolean");
    }

    public final boolean j(int i4) {
        if ((this.f5726k & (1 << i4)) != 0) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i4 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
        if (r9.f5718c == (-1)) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006e, code lost:
        l();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void k(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.e.k(android.view.MotionEvent):void");
    }

    public final void l() {
        VelocityTracker velocityTracker = this.f5727l;
        float f4 = this.f5728m;
        velocityTracker.computeCurrentVelocity(1000, f4);
        float xVelocity = this.f5727l.getXVelocity(this.f5718c);
        float f5 = this.f5729n;
        float abs = Math.abs(xVelocity);
        float f6 = 0.0f;
        if (abs < f5) {
            xVelocity = 0.0f;
        } else if (abs > f4) {
            if (xVelocity > 0.0f) {
                xVelocity = f4;
            } else {
                xVelocity = -f4;
            }
        }
        float yVelocity = this.f5727l.getYVelocity(this.f5718c);
        float f7 = this.f5729n;
        float abs2 = Math.abs(yVelocity);
        if (abs2 >= f7) {
            if (abs2 > f4) {
                if (yVelocity <= 0.0f) {
                    f4 = -f4;
                }
                f6 = f4;
            } else {
                f6 = yVelocity;
            }
        }
        this.f5736u = true;
        this.f5734s.w1(this.f5735t, xVelocity, f6);
        this.f5736u = false;
        if (this.f5716a == 1) {
            p(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.google.common.collect.c] */
    public final void m(float f4, float f5, int i4) {
        boolean c4 = c(f4, f5, i4, 1);
        boolean z4 = c4;
        if (c(f5, f4, i4, 4)) {
            z4 = c4 | true;
        }
        boolean z5 = z4;
        if (c(f4, f5, i4, 2)) {
            z5 = (z4 ? 1 : 0) | true;
        }
        ?? r02 = z5;
        if (c(f5, f4, i4, 8)) {
            r02 = (z5 ? 1 : 0) | true;
        }
        if (r02 != 0) {
            int[] iArr = this.f5724i;
            iArr[i4] = iArr[i4] | r02;
            this.f5734s.i1(r02, i4);
        }
    }

    public final void n(float f4, float f5, int i4) {
        float[] fArr = this.f5719d;
        int i5 = 0;
        if (fArr == null || fArr.length <= i4) {
            int i6 = i4 + 1;
            float[] fArr2 = new float[i6];
            float[] fArr3 = new float[i6];
            float[] fArr4 = new float[i6];
            float[] fArr5 = new float[i6];
            int[] iArr = new int[i6];
            int[] iArr2 = new int[i6];
            int[] iArr3 = new int[i6];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f5720e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f5721f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f5722g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f5723h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f5724i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f5725j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f5719d = fArr2;
            this.f5720e = fArr3;
            this.f5721f = fArr4;
            this.f5722g = fArr5;
            this.f5723h = iArr;
            this.f5724i = iArr2;
            this.f5725j = iArr3;
        }
        float[] fArr9 = this.f5719d;
        this.f5721f[i4] = f4;
        fArr9[i4] = f4;
        float[] fArr10 = this.f5720e;
        this.f5722g[i4] = f5;
        fArr10[i4] = f5;
        int[] iArr7 = this.f5723h;
        int i7 = (int) f4;
        int i8 = (int) f5;
        ViewGroup viewGroup = this.f5737v;
        if (i7 < viewGroup.getLeft() + this.f5730o) {
            i5 = 1;
        }
        if (i8 < viewGroup.getTop() + this.f5730o) {
            i5 |= 4;
        }
        if (i7 > viewGroup.getRight() - this.f5730o) {
            i5 |= 2;
        }
        if (i8 > viewGroup.getBottom() - this.f5730o) {
            i5 |= 8;
        }
        iArr7[i4] = i5;
        this.f5726k |= 1 << i4;
    }

    public final void o(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i4 = 0; i4 < pointerCount; i4++) {
            int pointerId = motionEvent.getPointerId(i4);
            if (j(pointerId)) {
                float x4 = motionEvent.getX(i4);
                float y4 = motionEvent.getY(i4);
                this.f5721f[pointerId] = x4;
                this.f5722g[pointerId] = y4;
            }
        }
    }

    public final void p(int i4) {
        this.f5737v.removeCallbacks(this.f5738w);
        if (this.f5716a != i4) {
            this.f5716a = i4;
            this.f5734s.u1(i4);
            if (this.f5716a == 0) {
                this.f5735t = null;
            }
        }
    }

    public final boolean q(int i4, int i5) {
        if (this.f5736u) {
            return i(i4, i5, (int) this.f5727l.getXVelocity(this.f5718c), (int) this.f5727l.getYVelocity(this.f5718c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:
        if ((r18.f5723h[r2] & r18.f5732q) != 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d1, code lost:
        if (r13 != r12) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x011d, code lost:
        if ((r18.f5723h[r1] & r18.f5732q) != 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x011f, code lost:
        r7.j1();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean r(android.view.MotionEvent r19) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.e.r(android.view.MotionEvent):boolean");
    }

    public final boolean s(View view, int i4, int i5) {
        this.f5735t = view;
        this.f5718c = -1;
        boolean i6 = i(i4, i5, 0, 0);
        if (!i6 && this.f5716a == 0 && this.f5735t != null) {
            this.f5735t = null;
        }
        return i6;
    }

    public final boolean t(int i4, View view) {
        if (view == this.f5735t && this.f5718c == i4) {
            return true;
        }
        if (view != null && this.f5734s.c2(i4, view)) {
            this.f5718c = i4;
            b(i4, view);
            return true;
        }
        return false;
    }
}
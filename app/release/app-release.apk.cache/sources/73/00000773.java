package i0;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    public ViewParent f4974a;

    /* renamed from: b  reason: collision with root package name */
    public ViewParent f4975b;

    /* renamed from: c  reason: collision with root package name */
    public final View f4976c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4977d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f4978e;

    public s(View view) {
        this.f4976c = view;
    }

    public final boolean a(float f4, float f5, boolean z4) {
        ViewParent f6;
        if (!this.f4977d || (f6 = f(0)) == null) {
            return false;
        }
        try {
            return d1.a(f6, this.f4976c, f4, f5, z4);
        } catch (AbstractMethodError e4) {
            Log.e("ViewParentCompat", "ViewParent " + f6 + " does not implement interface method onNestedFling", e4);
            return false;
        }
    }

    public final boolean b(float f4, float f5) {
        ViewParent f6;
        if (!this.f4977d || (f6 = f(0)) == null) {
            return false;
        }
        try {
            return d1.b(f6, this.f4976c, f4, f5);
        } catch (AbstractMethodError e4) {
            Log.e("ViewParentCompat", "ViewParent " + f6 + " does not implement interface method onNestedPreFling", e4);
            return false;
        }
    }

    public final boolean c(int i4, int i5, int[] iArr, int[] iArr2, int i6) {
        ViewParent f4;
        int i7;
        int i8;
        int[] iArr3;
        if (!this.f4977d || (f4 = f(i6)) == null) {
            return false;
        }
        if (i4 == 0 && i5 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        View view = this.f4976c;
        if (iArr2 != null) {
            view.getLocationInWindow(iArr2);
            i7 = iArr2[0];
            i8 = iArr2[1];
        } else {
            i7 = 0;
            i8 = 0;
        }
        if (iArr == null) {
            if (this.f4978e == null) {
                this.f4978e = new int[2];
            }
            iArr3 = this.f4978e;
        } else {
            iArr3 = iArr;
        }
        iArr3[0] = 0;
        iArr3[1] = 0;
        boolean z4 = f4 instanceof t;
        View view2 = this.f4976c;
        if (z4) {
            ((t) f4).d(view2, i4, i5, iArr3, i6);
        } else if (i6 == 0) {
            try {
                d1.c(f4, view2, i4, i5, iArr3);
            } catch (AbstractMethodError e4) {
                Log.e("ViewParentCompat", "ViewParent " + f4 + " does not implement interface method onNestedPreScroll", e4);
            }
        }
        if (iArr2 != null) {
            view.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i7;
            iArr2[1] = iArr2[1] - i8;
        }
        if (iArr3[0] == 0 && iArr3[1] == 0) {
            return false;
        }
        return true;
    }

    public final void d(int i4, int i5, int i6, int[] iArr) {
        e(0, i4, 0, i5, null, i6, iArr);
    }

    public final boolean e(int i4, int i5, int i6, int i7, int[] iArr, int i8, int[] iArr2) {
        ViewParent f4;
        int i9;
        int i10;
        int[] iArr3;
        if (!this.f4977d || (f4 = f(i8)) == null) {
            return false;
        }
        if (i4 == 0 && i5 == 0 && i6 == 0 && i7 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        View view = this.f4976c;
        if (iArr != null) {
            view.getLocationInWindow(iArr);
            i9 = iArr[0];
            i10 = iArr[1];
        } else {
            i9 = 0;
            i10 = 0;
        }
        if (iArr2 == null) {
            if (this.f4978e == null) {
                this.f4978e = new int[2];
            }
            int[] iArr4 = this.f4978e;
            iArr4[0] = 0;
            iArr4[1] = 0;
            iArr3 = iArr4;
        } else {
            iArr3 = iArr2;
        }
        boolean z4 = f4 instanceof u;
        View view2 = this.f4976c;
        if (z4) {
            ((u) f4).f(view2, i4, i5, i6, i7, i8, iArr3);
        } else {
            iArr3[0] = iArr3[0] + i6;
            iArr3[1] = iArr3[1] + i7;
            if (f4 instanceof t) {
                ((t) f4).i(view2, i4, i5, i6, i7, i8);
            } else if (i8 == 0) {
                try {
                    d1.d(f4, view2, i4, i5, i6, i7);
                } catch (AbstractMethodError e4) {
                    Log.e("ViewParentCompat", "ViewParent " + f4 + " does not implement interface method onNestedScroll", e4);
                }
            }
        }
        if (iArr != null) {
            view.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i9;
            iArr[1] = iArr[1] - i10;
        }
        return true;
    }

    public final ViewParent f(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                return null;
            }
            return this.f4975b;
        }
        return this.f4974a;
    }

    public final boolean g(int i4) {
        if (f(i4) != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0077 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean h(int r9, int r10) {
        /*
            r8 = this;
            boolean r0 = r8.g(r10)
            r1 = 1
            if (r0 == 0) goto L8
            return r1
        L8:
            boolean r0 = r8.f4977d
            if (r0 == 0) goto L7c
            android.view.View r0 = r8.f4976c
            android.view.ViewParent r2 = r0.getParent()
            r3 = r0
        L13:
            if (r2 == 0) goto L7c
            boolean r4 = r2 instanceof i0.t
            java.lang.String r5 = "ViewParentCompat"
            java.lang.String r6 = "ViewParent "
            if (r4 == 0) goto L25
            r7 = r2
            i0.t r7 = (i0.t) r7
            boolean r7 = r7.j(r3, r0, r9, r10)
            goto L2b
        L25:
            if (r10 != 0) goto L70
            boolean r7 = i0.d1.f(r2, r3, r0, r9)     // Catch: java.lang.AbstractMethodError -> L5b
        L2b:
            if (r7 == 0) goto L70
            if (r10 == 0) goto L35
            if (r10 == r1) goto L32
            goto L37
        L32:
            r8.f4975b = r2
            goto L37
        L35:
            r8.f4974a = r2
        L37:
            if (r4 == 0) goto L3f
            i0.t r2 = (i0.t) r2
            r2.b(r3, r0, r9, r10)
            goto L5a
        L3f:
            if (r10 != 0) goto L5a
            i0.d1.e(r2, r3, r0, r9)     // Catch: java.lang.AbstractMethodError -> L45
            goto L5a
        L45:
            r9 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r6)
            r10.append(r2)
            java.lang.String r0 = " does not implement interface method onNestedScrollAccepted"
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            android.util.Log.e(r5, r10, r9)
        L5a:
            return r1
        L5b:
            r4 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r6)
            r7.append(r2)
            java.lang.String r6 = " does not implement interface method onStartNestedScroll"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            android.util.Log.e(r5, r6, r4)
        L70:
            boolean r4 = r2 instanceof android.view.View
            if (r4 == 0) goto L77
            r3 = r2
            android.view.View r3 = (android.view.View) r3
        L77:
            android.view.ViewParent r2 = r2.getParent()
            goto L13
        L7c:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.s.h(int, int):boolean");
    }

    public final void i(int i4) {
        ViewParent f4 = f(i4);
        if (f4 != null) {
            boolean z4 = f4 instanceof t;
            View view = this.f4976c;
            if (z4) {
                ((t) f4).e(i4, view);
            } else if (i4 == 0) {
                try {
                    d1.g(f4, view);
                } catch (AbstractMethodError e4) {
                    Log.e("ViewParentCompat", "ViewParent " + f4 + " does not implement interface method onStopNestedScroll", e4);
                }
            }
            if (i4 != 0) {
                if (i4 == 1) {
                    this.f4975b = null;
                    return;
                }
                return;
            }
            this.f4974a = null;
        }
    }
}
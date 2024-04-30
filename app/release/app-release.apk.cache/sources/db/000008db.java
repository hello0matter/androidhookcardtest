package o;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.Constraints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    public q.e f5889a = new q.e();

    /* renamed from: b  reason: collision with root package name */
    public q.e f5890b = new q.e();

    /* renamed from: c  reason: collision with root package name */
    public androidx.constraintlayout.widget.d f5891c = null;

    /* renamed from: d  reason: collision with root package name */
    public androidx.constraintlayout.widget.d f5892d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f5893e;

    /* renamed from: f  reason: collision with root package name */
    public int f5894f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f5895g;

    public t(MotionLayout motionLayout) {
        this.f5895g = motionLayout;
    }

    public static void b(q.e eVar, q.e eVar2) {
        q.d dVar;
        ArrayList arrayList = eVar.f6229h0;
        HashMap hashMap = new HashMap();
        hashMap.put(eVar, eVar2);
        eVar2.f6229h0.clear();
        eVar2.g(eVar, hashMap);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            q.d dVar2 = (q.d) it.next();
            if (dVar2 instanceof q.a) {
                dVar = new q.a();
            } else if (dVar2 instanceof q.h) {
                dVar = new q.h();
            } else if (dVar2 instanceof q.g) {
                dVar = new q.g();
            } else if (dVar2 instanceof q.i) {
                dVar = new q.j();
            } else {
                dVar = new q.d();
            }
            eVar2.f6229h0.add(dVar);
            q.d dVar3 = dVar.K;
            if (dVar3 != null) {
                ((q.e) dVar3).f6229h0.remove(dVar);
                dVar.K = null;
            }
            dVar.K = eVar2;
            hashMap.put(dVar2, dVar);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            q.d dVar4 = (q.d) it2.next();
            ((q.d) hashMap.get(dVar4)).g(dVar4, hashMap);
        }
    }

    public static q.d c(q.e eVar, View view) {
        if (eVar.W == view) {
            return eVar;
        }
        ArrayList arrayList = eVar.f6229h0;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            q.d dVar = (q.d) arrayList.get(i4);
            if (dVar.W == view) {
                return dVar;
            }
        }
        return null;
    }

    public final void a() {
        int i4;
        MotionLayout motionLayout = this.f5895g;
        int childCount = motionLayout.getChildCount();
        motionLayout.f1066z.clear();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = motionLayout.getChildAt(i6);
            motionLayout.f1066z.put(childAt, new p(childAt));
        }
        while (i5 < childCount) {
            View childAt2 = motionLayout.getChildAt(i5);
            p pVar = (p) motionLayout.f1066z.get(childAt2);
            if (pVar == null) {
                i4 = childCount;
            } else {
                if (this.f5891c != null) {
                    q.d c4 = c(this.f5889a, childAt2);
                    if (c4 != null) {
                        androidx.constraintlayout.widget.d dVar = this.f5891c;
                        w wVar = pVar.f5849d;
                        wVar.f5901c = 0.0f;
                        wVar.f5902d = 0.0f;
                        pVar.d(wVar);
                        i4 = childCount;
                        wVar.f5903e = c4.o();
                        wVar.f5904f = c4.p();
                        wVar.f5905g = c4.n();
                        wVar.f5906h = c4.k();
                        androidx.constraintlayout.widget.c g4 = dVar.g(pVar.f5847b);
                        wVar.a(g4);
                        pVar.f5855j = g4.f1313c.f6627f;
                        pVar.f5851f.c(c4, dVar, pVar.f5847b);
                    } else {
                        i4 = childCount;
                        if (motionLayout.J != 0) {
                            Log.e("MotionLayout", com.google.common.collect.c.z0() + "no widget for  " + com.google.common.collect.c.E0(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                } else {
                    i4 = childCount;
                }
                if (this.f5892d != null) {
                    q.d c5 = c(this.f5890b, childAt2);
                    if (c5 != null) {
                        androidx.constraintlayout.widget.d dVar2 = this.f5892d;
                        w wVar2 = pVar.f5850e;
                        wVar2.f5901c = 1.0f;
                        wVar2.f5902d = 1.0f;
                        pVar.d(wVar2);
                        wVar2.f5903e = c5.o();
                        wVar2.f5904f = c5.p();
                        wVar2.f5905g = c5.n();
                        wVar2.f5906h = c5.k();
                        wVar2.a(dVar2.g(pVar.f5847b));
                        pVar.f5852g.c(c5, dVar2, pVar.f5847b);
                    } else if (motionLayout.J != 0) {
                        Log.e("MotionLayout", com.google.common.collect.c.z0() + "no widget for  " + com.google.common.collect.c.E0(childAt2) + " (" + childAt2.getClass().getName() + ")");
                    }
                }
            }
            i5++;
            childCount = i4;
        }
    }

    public final void d(androidx.constraintlayout.widget.d dVar, androidx.constraintlayout.widget.d dVar2) {
        this.f5891c = dVar;
        this.f5892d = dVar2;
        this.f5889a = new q.e();
        q.e eVar = new q.e();
        this.f5890b = eVar;
        q.e eVar2 = this.f5889a;
        int i4 = MotionLayout.f1031z0;
        MotionLayout motionLayout = this.f5895g;
        q.e eVar3 = motionLayout.f1233c;
        r.c cVar = eVar3.f6232k0;
        eVar2.f6232k0 = cVar;
        eVar2.f6231j0.f6446f = cVar;
        r.c cVar2 = eVar3.f6232k0;
        eVar.f6232k0 = cVar2;
        eVar.f6231j0.f6446f = cVar2;
        eVar2.f6229h0.clear();
        this.f5890b.f6229h0.clear();
        b(motionLayout.f1233c, this.f5889a);
        b(motionLayout.f1233c, this.f5890b);
        if (motionLayout.D > 0.5d) {
            if (dVar != null) {
                f(this.f5889a, dVar);
            }
            f(this.f5890b, dVar2);
        } else {
            f(this.f5890b, dVar2);
            if (dVar != null) {
                f(this.f5889a, dVar);
            }
        }
        this.f5889a.f6233l0 = motionLayout.k();
        this.f5889a.H();
        this.f5890b.f6233l0 = motionLayout.k();
        this.f5890b.H();
        ViewGroup.LayoutParams layoutParams = motionLayout.getLayoutParams();
        if (layoutParams != null) {
            int i5 = layoutParams.width;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.f1132b;
            if (i5 == -2) {
                this.f5889a.y(constraintWidget$DimensionBehaviour);
                this.f5890b.y(constraintWidget$DimensionBehaviour);
            }
            if (layoutParams.height == -2) {
                this.f5889a.z(constraintWidget$DimensionBehaviour);
                this.f5890b.z(constraintWidget$DimensionBehaviour);
            }
        }
    }

    public final void e() {
        boolean z4;
        int i4;
        boolean z5;
        boolean z6;
        int i5;
        float f4;
        float f5;
        float f6;
        float f7;
        MotionLayout motionLayout = this.f5895g;
        int i6 = motionLayout.f1060w;
        int i7 = motionLayout.f1062x;
        int mode = View.MeasureSpec.getMode(i6);
        int mode2 = View.MeasureSpec.getMode(i7);
        motionLayout.f1045n0 = mode;
        motionLayout.f1046o0 = mode2;
        int optimizationLevel = motionLayout.getOptimizationLevel();
        if (motionLayout.f1056u == motionLayout.getStartState()) {
            motionLayout.n(this.f5890b, optimizationLevel, i6, i7);
            if (this.f5891c != null) {
                motionLayout.n(this.f5889a, optimizationLevel, i6, i7);
            }
        } else {
            if (this.f5891c != null) {
                motionLayout.n(this.f5889a, optimizationLevel, i6, i7);
            }
            motionLayout.n(this.f5890b, optimizationLevel, i6, i7);
        }
        boolean z7 = true;
        int i8 = 0;
        if (!(motionLayout.getParent() instanceof MotionLayout) || mode != 1073741824 || mode2 != 1073741824) {
            motionLayout.f1045n0 = mode;
            motionLayout.f1046o0 = mode2;
            if (motionLayout.f1056u == motionLayout.getStartState()) {
                motionLayout.n(this.f5890b, optimizationLevel, i6, i7);
                if (this.f5891c != null) {
                    motionLayout.n(this.f5889a, optimizationLevel, i6, i7);
                }
            } else {
                if (this.f5891c != null) {
                    motionLayout.n(this.f5889a, optimizationLevel, i6, i7);
                }
                motionLayout.n(this.f5890b, optimizationLevel, i6, i7);
            }
            motionLayout.f1041j0 = this.f5889a.n();
            motionLayout.f1042k0 = this.f5889a.k();
            motionLayout.f1043l0 = this.f5890b.n();
            int k4 = this.f5890b.k();
            motionLayout.f1044m0 = k4;
            if (motionLayout.f1041j0 == motionLayout.f1043l0 && motionLayout.f1042k0 == k4) {
                z4 = false;
            } else {
                z4 = true;
            }
            motionLayout.f1040i0 = z4;
        }
        int i9 = motionLayout.f1041j0;
        int i10 = motionLayout.f1042k0;
        int i11 = motionLayout.f1045n0;
        if (i11 == Integer.MIN_VALUE || i11 == 0) {
            i9 = (int) ((motionLayout.f1047p0 * (motionLayout.f1043l0 - i9)) + i9);
        }
        int i12 = i9;
        int i13 = motionLayout.f1046o0;
        if (i13 != Integer.MIN_VALUE && i13 != 0) {
            i4 = i10;
        } else {
            i4 = (int) ((motionLayout.f1047p0 * (motionLayout.f1044m0 - i10)) + i10);
        }
        q.e eVar = this.f5889a;
        if (!eVar.f6242u0 && !this.f5890b.f6242u0) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (!eVar.f6243v0 && !this.f5890b.f6243v0) {
            z6 = false;
        } else {
            z6 = true;
        }
        motionLayout.m(i6, i7, i12, i4, z5, z6);
        int childCount = motionLayout.getChildCount();
        motionLayout.f1057u0.a();
        motionLayout.H = true;
        motionLayout.getWidth();
        motionLayout.getHeight();
        z zVar = motionLayout.f1048q.f1079c;
        if (zVar != null) {
            i5 = zVar.f5932p;
        } else {
            i5 = -1;
        }
        HashMap hashMap = motionLayout.f1066z;
        if (i5 != -1) {
            for (int i14 = 0; i14 < childCount; i14++) {
                p pVar = (p) hashMap.get(motionLayout.getChildAt(i14));
                if (pVar != null) {
                    pVar.f5870y = i5;
                }
            }
        }
        for (int i15 = 0; i15 < childCount; i15++) {
            p pVar2 = (p) hashMap.get(motionLayout.getChildAt(i15));
            if (pVar2 != null) {
                motionLayout.f1048q.e(pVar2);
                pVar2.e(motionLayout.getNanoTime());
            }
        }
        z zVar2 = motionLayout.f1048q.f1079c;
        if (zVar2 != null) {
            f4 = zVar2.f5925i;
        } else {
            f4 = 0.0f;
        }
        if (f4 != 0.0f) {
            if (f4 >= 0.0d) {
                z7 = false;
            }
            float abs = Math.abs(f4);
            float f8 = -3.4028235E38f;
            float f9 = Float.MAX_VALUE;
            float f10 = -3.4028235E38f;
            float f11 = Float.MAX_VALUE;
            for (int i16 = 0; i16 < childCount; i16++) {
                p pVar3 = (p) hashMap.get(motionLayout.getChildAt(i16));
                if (!Float.isNaN(pVar3.f5855j)) {
                    for (int i17 = 0; i17 < childCount; i17++) {
                        p pVar4 = (p) hashMap.get(motionLayout.getChildAt(i17));
                        if (!Float.isNaN(pVar4.f5855j)) {
                            f9 = Math.min(f9, pVar4.f5855j);
                            f8 = Math.max(f8, pVar4.f5855j);
                        }
                    }
                    while (i8 < childCount) {
                        p pVar5 = (p) hashMap.get(motionLayout.getChildAt(i8));
                        if (!Float.isNaN(pVar5.f5855j)) {
                            pVar5.f5857l = 1.0f / (1.0f - abs);
                            float f12 = pVar5.f5855j;
                            if (z7) {
                                f6 = ((f8 - f12) / (f8 - f9)) * abs;
                            } else {
                                f6 = ((f12 - f9) * abs) / (f8 - f9);
                            }
                            pVar5.f5856k = abs - f6;
                        }
                        i8++;
                    }
                    return;
                }
                w wVar = pVar3.f5850e;
                float f13 = wVar.f5903e;
                float f14 = wVar.f5904f;
                if (z7) {
                    f7 = f14 - f13;
                } else {
                    f7 = f14 + f13;
                }
                f11 = Math.min(f11, f7);
                f10 = Math.max(f10, f7);
            }
            while (i8 < childCount) {
                p pVar6 = (p) hashMap.get(motionLayout.getChildAt(i8));
                w wVar2 = pVar6.f5850e;
                float f15 = wVar2.f5903e;
                float f16 = wVar2.f5904f;
                if (z7) {
                    f5 = f16 - f15;
                } else {
                    f5 = f16 + f15;
                }
                pVar6.f5857l = 1.0f / (1.0f - abs);
                pVar6.f5856k = abs - (((f5 - f11) * abs) / (f10 - f11));
                i8++;
            }
        }
    }

    public final void f(q.e eVar, androidx.constraintlayout.widget.d dVar) {
        int i4;
        SparseArray sparseArray = new SparseArray();
        Constraints.LayoutParams layoutParams = new Constraints.LayoutParams();
        sparseArray.clear();
        sparseArray.put(0, eVar);
        MotionLayout motionLayout = this.f5895g;
        sparseArray.put(motionLayout.getId(), eVar);
        Iterator it = eVar.f6229h0.iterator();
        while (it.hasNext()) {
            q.d dVar2 = (q.d) it.next();
            sparseArray.put(((View) dVar2.W).getId(), dVar2);
        }
        Iterator it2 = eVar.f6229h0.iterator();
        while (it2.hasNext()) {
            q.d dVar3 = (q.d) it2.next();
            View view = (View) dVar3.W;
            int id = view.getId();
            HashMap hashMap = dVar.f1321c;
            if (hashMap.containsKey(Integer.valueOf(id))) {
                ((androidx.constraintlayout.widget.c) hashMap.get(Integer.valueOf(id))).a(layoutParams);
            }
            dVar3.A(dVar.g(view.getId()).f1314d.f6589c);
            dVar3.x(dVar.g(view.getId()).f1314d.f6591d);
            if (view instanceof ConstraintHelper) {
                ConstraintHelper constraintHelper = (ConstraintHelper) view;
                int id2 = constraintHelper.getId();
                HashMap hashMap2 = dVar.f1321c;
                if (hashMap2.containsKey(Integer.valueOf(id2))) {
                    androidx.constraintlayout.widget.c cVar = (androidx.constraintlayout.widget.c) hashMap2.get(Integer.valueOf(id2));
                    if (dVar3 instanceof q.j) {
                        constraintHelper.h(cVar, (q.j) dVar3, layoutParams, sparseArray);
                    }
                }
                if (view instanceof Barrier) {
                    ((Barrier) view).l();
                }
            }
            layoutParams.resolveLayoutDirection(motionLayout.getLayoutDirection());
            int i5 = MotionLayout.f1031z0;
            this.f5895g.a(false, view, dVar3, layoutParams, sparseArray);
            if (dVar.g(view.getId()).f1312b.f6631c == 1) {
                i4 = view.getVisibility();
            } else {
                i4 = dVar.g(view.getId()).f1312b.f6630b;
            }
            dVar3.X = i4;
        }
        Iterator it3 = eVar.f6229h0.iterator();
        while (it3.hasNext()) {
            q.d dVar4 = (q.d) it3.next();
            if (dVar4 instanceof q.g) {
                ConstraintHelper constraintHelper2 = (ConstraintHelper) dVar4.W;
                q.i iVar = (q.i) dVar4;
                constraintHelper2.getClass();
                q.j jVar = (q.j) iVar;
                jVar.f6285i0 = 0;
                Arrays.fill(jVar.f6284h0, (Object) null);
                for (int i6 = 0; i6 < constraintHelper2.f1224b; i6++) {
                    jVar.D((q.d) sparseArray.get(constraintHelper2.f1223a[i6]));
                }
                q.g gVar = (q.g) iVar;
                for (int i7 = 0; i7 < gVar.f6285i0; i7++) {
                    q.d dVar5 = gVar.f6284h0[i7];
                }
            }
        }
    }
}
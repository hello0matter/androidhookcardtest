package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.o0;
import androidx.appcompat.widget.e2;
import androidx.appcompat.widget.j;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.d;
import androidx.core.widget.NestedScrollView;
import i0.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import n.i;
import o.o;
import o.p;
import o.r;
import o.s;
import o.t;
import o.v;
import o.w;
import o.y;
import o.z;
import t.e;
import t.g;
import t.h;
import t.k;
import t.l;
import t.m;
import t.n;

/* loaded from: classes.dex */
public class MotionLayout extends ConstraintLayout implements u {

    /* renamed from: z0  reason: collision with root package name */
    public static final /* synthetic */ int f1031z0 = 0;
    public long A;
    public float B;
    public float C;
    public float D;
    public long E;
    public float F;
    public boolean G;
    public boolean H;
    public v I;
    public int J;
    public s K;
    public boolean L;
    public final i M;
    public final r N;
    public o.a O;
    public int P;
    public int Q;
    public boolean R;
    public float S;
    public float T;
    public long U;
    public float V;
    public boolean W;

    /* renamed from: a0  reason: collision with root package name */
    public ArrayList f1032a0;

    /* renamed from: b0  reason: collision with root package name */
    public ArrayList f1033b0;

    /* renamed from: c0  reason: collision with root package name */
    public ArrayList f1034c0;

    /* renamed from: d0  reason: collision with root package name */
    public int f1035d0;

    /* renamed from: e0  reason: collision with root package name */
    public long f1036e0;

    /* renamed from: f0  reason: collision with root package name */
    public float f1037f0;

    /* renamed from: g0  reason: collision with root package name */
    public int f1038g0;

    /* renamed from: h0  reason: collision with root package name */
    public float f1039h0;

    /* renamed from: i0  reason: collision with root package name */
    public boolean f1040i0;

    /* renamed from: j0  reason: collision with root package name */
    public int f1041j0;

    /* renamed from: k0  reason: collision with root package name */
    public int f1042k0;

    /* renamed from: l0  reason: collision with root package name */
    public int f1043l0;

    /* renamed from: m0  reason: collision with root package name */
    public int f1044m0;

    /* renamed from: n0  reason: collision with root package name */
    public int f1045n0;

    /* renamed from: o0  reason: collision with root package name */
    public int f1046o0;

    /* renamed from: p0  reason: collision with root package name */
    public float f1047p0;

    /* renamed from: q  reason: collision with root package name */
    public b f1048q;

    /* renamed from: q0  reason: collision with root package name */
    public final o0 f1049q0;

    /* renamed from: r  reason: collision with root package name */
    public Interpolator f1050r;

    /* renamed from: r0  reason: collision with root package name */
    public boolean f1051r0;

    /* renamed from: s  reason: collision with root package name */
    public float f1052s;

    /* renamed from: s0  reason: collision with root package name */
    public a f1053s0;

    /* renamed from: t  reason: collision with root package name */
    public int f1054t;

    /* renamed from: t0  reason: collision with root package name */
    public TransitionState f1055t0;

    /* renamed from: u  reason: collision with root package name */
    public int f1056u;

    /* renamed from: u0  reason: collision with root package name */
    public final t f1057u0;

    /* renamed from: v  reason: collision with root package name */
    public int f1058v;

    /* renamed from: v0  reason: collision with root package name */
    public boolean f1059v0;

    /* renamed from: w  reason: collision with root package name */
    public int f1060w;

    /* renamed from: w0  reason: collision with root package name */
    public final RectF f1061w0;

    /* renamed from: x  reason: collision with root package name */
    public int f1062x;

    /* renamed from: x0  reason: collision with root package name */
    public View f1063x0;

    /* renamed from: y  reason: collision with root package name */
    public boolean f1064y;

    /* renamed from: y0  reason: collision with root package name */
    public final ArrayList f1065y0;

    /* renamed from: z  reason: collision with root package name */
    public final HashMap f1066z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class TransitionState {

        /* renamed from: a  reason: collision with root package name */
        public static final TransitionState f1067a;

        /* renamed from: b  reason: collision with root package name */
        public static final TransitionState f1068b;

        /* renamed from: c  reason: collision with root package name */
        public static final TransitionState f1069c;

        /* renamed from: d  reason: collision with root package name */
        public static final TransitionState f1070d;

        /* renamed from: e  reason: collision with root package name */
        public static final /* synthetic */ TransitionState[] f1071e;

        /* JADX WARN: Type inference failed for: r0v0, types: [androidx.constraintlayout.motion.widget.MotionLayout$TransitionState, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.constraintlayout.motion.widget.MotionLayout$TransitionState, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r2v2, types: [androidx.constraintlayout.motion.widget.MotionLayout$TransitionState, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r3v2, types: [androidx.constraintlayout.motion.widget.MotionLayout$TransitionState, java.lang.Enum] */
        static {
            ?? r02 = new Enum("UNDEFINED", 0);
            f1067a = r02;
            ?? r12 = new Enum("SETUP", 1);
            f1068b = r12;
            ?? r22 = new Enum("MOVING", 2);
            f1069c = r22;
            ?? r32 = new Enum("FINISHED", 3);
            f1070d = r32;
            f1071e = new TransitionState[]{r02, r12, r22, r32};
        }

        public static TransitionState valueOf(String str) {
            return (TransitionState) Enum.valueOf(TransitionState.class, str);
        }

        public static TransitionState[] values() {
            return (TransitionState[]) f1071e.clone();
        }
    }

    public MotionLayout(@NonNull Context context) {
        super(context);
        this.f1052s = 0.0f;
        this.f1054t = -1;
        this.f1056u = -1;
        this.f1058v = -1;
        this.f1060w = 0;
        this.f1062x = 0;
        this.f1064y = true;
        this.f1066z = new HashMap();
        this.A = 0L;
        this.B = 1.0f;
        this.C = 0.0f;
        this.D = 0.0f;
        this.F = 0.0f;
        this.H = false;
        this.J = 0;
        this.L = false;
        this.M = new i();
        this.N = new r(this);
        this.R = false;
        this.W = false;
        this.f1032a0 = null;
        this.f1033b0 = null;
        this.f1034c0 = null;
        this.f1035d0 = 0;
        this.f1036e0 = -1L;
        this.f1037f0 = 0.0f;
        this.f1038g0 = 0;
        this.f1039h0 = 0.0f;
        this.f1040i0 = false;
        this.f1049q0 = new o0(7);
        this.f1051r0 = false;
        this.f1055t0 = TransitionState.f1067a;
        this.f1057u0 = new t(this);
        this.f1059v0 = false;
        this.f1061w0 = new RectF();
        this.f1063x0 = null;
        this.f1065y0 = new ArrayList();
        u(null);
    }

    @Override // i0.t
    public final void b(View view, View view2, int i4, int i5) {
    }

    @Override // i0.t
    public final void d(View view, int i4, int i5, int[] iArr, int i6) {
        z zVar;
        boolean z4;
        c cVar;
        float f4;
        float f5;
        z zVar2;
        c cVar2;
        c cVar3;
        int i7;
        b bVar = this.f1048q;
        if (bVar == null || (zVar = bVar.f1079c) == null || !(!zVar.f5931o)) {
            return;
        }
        if (z4 && (cVar3 = zVar.f5928l) != null && (i7 = cVar3.f1100e) != -1 && view.getId() != i7) {
            return;
        }
        b bVar2 = this.f1048q;
        if (bVar2 != null && (zVar2 = bVar2.f1079c) != null && (cVar2 = zVar2.f5928l) != null && cVar2.f1113r) {
            float f6 = this.C;
            if ((f6 == 1.0f || f6 == 0.0f) && view.canScrollVertically(-1)) {
                return;
            }
        }
        if (zVar.f5928l != null) {
            c cVar4 = this.f1048q.f1079c.f5928l;
            if ((cVar4.f1115t & 1) != 0) {
                float f7 = i4;
                float f8 = i5;
                cVar4.f1110o.s(cVar4.f1099d, cVar4.f1110o.getProgress(), cVar4.f1103h, cVar4.f1102g, cVar4.f1107l);
                float f9 = cVar4.f1104i;
                int i8 = (f9 > 0.0f ? 1 : (f9 == 0.0f ? 0 : -1));
                float[] fArr = cVar4.f1107l;
                if (i8 != 0) {
                    if (fArr[0] == 0.0f) {
                        fArr[0] = 1.0E-7f;
                    }
                    f5 = (f7 * f9) / fArr[0];
                } else {
                    if (fArr[1] == 0.0f) {
                        fArr[1] = 1.0E-7f;
                    }
                    f5 = (f8 * cVar4.f1105j) / fArr[1];
                }
                float f10 = this.D;
                if ((f10 <= 0.0f && f5 < 0.0f) || (f10 >= 1.0f && f5 > 0.0f)) {
                    view.setNestedScrollingEnabled(false);
                    view.post(new j(2, this, view));
                    return;
                }
            }
        }
        float f11 = this.C;
        long nanoTime = getNanoTime();
        float f12 = i4;
        this.S = f12;
        float f13 = i5;
        this.T = f13;
        this.V = (float) ((nanoTime - this.U) * 1.0E-9d);
        this.U = nanoTime;
        z zVar3 = this.f1048q.f1079c;
        if (zVar3 != null && (cVar = zVar3.f5928l) != null) {
            MotionLayout motionLayout = cVar.f1110o;
            float progress = motionLayout.getProgress();
            if (!cVar.f1106k) {
                cVar.f1106k = true;
                motionLayout.setProgress(progress);
            }
            cVar.f1110o.s(cVar.f1099d, progress, cVar.f1103h, cVar.f1102g, cVar.f1107l);
            float f14 = cVar.f1104i;
            float[] fArr2 = cVar.f1107l;
            if (Math.abs((cVar.f1105j * fArr2[1]) + (f14 * fArr2[0])) < 0.01d) {
                fArr2[0] = 0.01f;
                fArr2[1] = 0.01f;
            }
            float f15 = cVar.f1104i;
            if (f15 != 0.0f) {
                f4 = (f12 * f15) / fArr2[0];
            } else {
                f4 = (f13 * cVar.f1105j) / fArr2[1];
            }
            float max = Math.max(Math.min(progress + f4, 1.0f), 0.0f);
            if (max != motionLayout.getProgress()) {
                motionLayout.setProgress(max);
            }
        }
        if (f11 != this.C) {
            iArr[0] = i4;
            iArr[1] = i5;
        }
        p(false);
        if (iArr[0] != 0 || iArr[1] != 0) {
            this.R = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00be  */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void dispatchDraw(android.graphics.Canvas r38) {
        /*
            Method dump skipped, instructions count: 1197
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.dispatchDraw(android.graphics.Canvas):void");
    }

    @Override // i0.t
    public final void e(int i4, View view) {
        c cVar;
        float f4;
        boolean z4;
        b bVar = this.f1048q;
        if (bVar == null) {
            return;
        }
        float f5 = this.S;
        float f6 = this.V;
        float f7 = f5 / f6;
        float f8 = this.T / f6;
        z zVar = bVar.f1079c;
        if (zVar != null && (cVar = zVar.f5928l) != null) {
            boolean z5 = false;
            cVar.f1106k = false;
            MotionLayout motionLayout = cVar.f1110o;
            float progress = motionLayout.getProgress();
            cVar.f1110o.s(cVar.f1099d, progress, cVar.f1103h, cVar.f1102g, cVar.f1107l);
            float f9 = cVar.f1104i;
            float[] fArr = cVar.f1107l;
            float f10 = fArr[0];
            float f11 = cVar.f1105j;
            float f12 = fArr[1];
            float f13 = 0.0f;
            if (f9 != 0.0f) {
                f4 = (f7 * f9) / f10;
            } else {
                f4 = (f8 * f11) / f12;
            }
            if (!Float.isNaN(f4)) {
                progress += f4 / 3.0f;
            }
            if (progress != 0.0f) {
                if (progress != 1.0f) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                int i5 = cVar.f1098c;
                if (i5 != 3) {
                    z5 = true;
                }
                if (z5 & z4) {
                    if (progress >= 0.5d) {
                        f13 = 1.0f;
                    }
                    motionLayout.y(f13, f4, i5);
                }
            }
        }
    }

    @Override // i0.u
    public final void f(View view, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
        if (this.R || i4 != 0 || i5 != 0) {
            iArr[0] = iArr[0] + i6;
            iArr[1] = iArr[1] + i7;
        }
        this.R = false;
    }

    public int[] getConstraintSetIds() {
        b bVar = this.f1048q;
        if (bVar == null) {
            return null;
        }
        SparseArray sparseArray = bVar.f1083g;
        int size = sparseArray.size();
        int[] iArr = new int[size];
        for (int i4 = 0; i4 < size; i4++) {
            iArr[i4] = sparseArray.keyAt(i4);
        }
        return iArr;
    }

    public int getCurrentState() {
        return this.f1056u;
    }

    public ArrayList<z> getDefinedTransitions() {
        b bVar = this.f1048q;
        if (bVar == null) {
            return null;
        }
        return bVar.f1080d;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [o.a, java.lang.Object] */
    public o.a getDesignTool() {
        if (this.O == null) {
            this.O = new Object();
        }
        return this.O;
    }

    public int getEndState() {
        return this.f1058v;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.D;
    }

    public int getStartState() {
        return this.f1054t;
    }

    public float getTargetPosition() {
        return this.F;
    }

    public Bundle getTransitionState() {
        if (this.f1053s0 == null) {
            this.f1053s0 = new a(this);
        }
        a aVar = this.f1053s0;
        MotionLayout motionLayout = aVar.f1076e;
        aVar.f1075d = motionLayout.f1058v;
        aVar.f1074c = motionLayout.f1054t;
        aVar.f1073b = motionLayout.getVelocity();
        aVar.f1072a = motionLayout.getProgress();
        a aVar2 = this.f1053s0;
        aVar2.getClass();
        Bundle bundle = new Bundle();
        bundle.putFloat("motion.progress", aVar2.f1072a);
        bundle.putFloat("motion.velocity", aVar2.f1073b);
        bundle.putInt("motion.StartState", aVar2.f1074c);
        bundle.putInt("motion.EndState", aVar2.f1075d);
        return bundle;
    }

    public long getTransitionTimeMs() {
        int i4;
        b bVar = this.f1048q;
        if (bVar != null) {
            z zVar = bVar.f1079c;
            if (zVar != null) {
                i4 = zVar.f5924h;
            } else {
                i4 = bVar.f1086j;
            }
            this.B = i4 / 1000.0f;
        }
        return this.B * 1000.0f;
    }

    public float getVelocity() {
        return this.f1052s;
    }

    @Override // i0.t
    public final void i(View view, int i4, int i5, int i6, int i7, int i8) {
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    @Override // i0.t
    public final boolean j(View view, View view2, int i4, int i5) {
        z zVar;
        c cVar;
        b bVar = this.f1048q;
        if (bVar != null && (zVar = bVar.f1079c) != null && (cVar = zVar.f5928l) != null && (cVar.f1115t & 2) == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public final void l(int i4) {
        this.f1241k = null;
    }

    public final void o(float f4) {
        int i4;
        b bVar = this.f1048q;
        if (bVar == null) {
            return;
        }
        float f5 = this.D;
        float f6 = this.C;
        if (f5 != f6 && this.G) {
            this.D = f6;
        }
        float f7 = this.D;
        if (f7 == f4) {
            return;
        }
        this.L = false;
        this.F = f4;
        z zVar = bVar.f1079c;
        if (zVar != null) {
            i4 = zVar.f5924h;
        } else {
            i4 = bVar.f1086j;
        }
        this.B = i4 / 1000.0f;
        setProgress(f4);
        this.f1050r = this.f1048q.d();
        this.G = false;
        this.A = getNanoTime();
        this.H = true;
        this.C = f7;
        this.D = f7;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        int i4;
        super.onAttachedToWindow();
        b bVar = this.f1048q;
        if (bVar != null && (i4 = this.f1056u) != -1) {
            d b5 = bVar.b(i4);
            b bVar2 = this.f1048q;
            int i5 = 0;
            loop0: while (true) {
                SparseArray sparseArray = bVar2.f1083g;
                if (i5 < sparseArray.size()) {
                    int keyAt = sparseArray.keyAt(i5);
                    SparseIntArray sparseIntArray = bVar2.f1085i;
                    int i6 = sparseIntArray.get(keyAt);
                    int size = sparseIntArray.size();
                    while (i6 > 0) {
                        if (i6 == keyAt) {
                            break loop0;
                        }
                        int i7 = size - 1;
                        if (size < 0) {
                            break loop0;
                        }
                        i6 = sparseIntArray.get(i6);
                        size = i7;
                    }
                    bVar2.j(keyAt);
                    i5++;
                } else {
                    for (int i8 = 0; i8 < sparseArray.size(); i8++) {
                        d dVar = (d) sparseArray.valueAt(i8);
                        dVar.getClass();
                        int childCount = getChildCount();
                        for (int i9 = 0; i9 < childCount; i9++) {
                            View childAt = getChildAt(i9);
                            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                            int id = childAt.getId();
                            if (dVar.f1320b && id == -1) {
                                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                            }
                            HashMap hashMap = dVar.f1321c;
                            if (!hashMap.containsKey(Integer.valueOf(id))) {
                                hashMap.put(Integer.valueOf(id), new androidx.constraintlayout.widget.c());
                            }
                            androidx.constraintlayout.widget.c cVar = (androidx.constraintlayout.widget.c) hashMap.get(Integer.valueOf(id));
                            if (!cVar.f1314d.f6587b) {
                                cVar.b(id, layoutParams);
                                boolean z4 = childAt instanceof ConstraintHelper;
                                e eVar = cVar.f1314d;
                                if (z4) {
                                    eVar.f6594e0 = ((ConstraintHelper) childAt).getReferencedIds();
                                    if (childAt instanceof Barrier) {
                                        Barrier barrier = (Barrier) childAt;
                                        eVar.f6604j0 = barrier.f1214j.f6170k0;
                                        eVar.f6588b0 = barrier.getType();
                                        eVar.f6590c0 = barrier.getMargin();
                                    }
                                }
                                eVar.f6587b = true;
                            }
                            g gVar = cVar.f1312b;
                            if (!gVar.f6629a) {
                                gVar.f6630b = childAt.getVisibility();
                                gVar.f6632d = childAt.getAlpha();
                                gVar.f6629a = true;
                            }
                            h hVar = cVar.f1315e;
                            if (!hVar.f6635a) {
                                hVar.f6635a = true;
                                hVar.f6636b = childAt.getRotation();
                                hVar.f6637c = childAt.getRotationX();
                                hVar.f6638d = childAt.getRotationY();
                                hVar.f6639e = childAt.getScaleX();
                                hVar.f6640f = childAt.getScaleY();
                                float pivotX = childAt.getPivotX();
                                float pivotY = childAt.getPivotY();
                                if (pivotX != 0.0d || pivotY != 0.0d) {
                                    hVar.f6641g = pivotX;
                                    hVar.f6642h = pivotY;
                                }
                                hVar.f6643i = childAt.getTranslationX();
                                hVar.f6644j = childAt.getTranslationY();
                                hVar.f6645k = childAt.getTranslationZ();
                                if (hVar.f6646l) {
                                    hVar.f6647m = childAt.getElevation();
                                }
                            }
                        }
                    }
                }
            }
            Log.e("MotionScene", "Cannot be derived from yourself");
            if (b5 != null) {
                b5.b(this);
            }
            this.f1054t = this.f1056u;
        }
        v();
        a aVar = this.f1053s0;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        z zVar;
        c cVar;
        int i4;
        RectF a5;
        b bVar = this.f1048q;
        if (bVar != null && this.f1064y && (zVar = bVar.f1079c) != null && (!zVar.f5931o) && (cVar = zVar.f5928l) != null && ((motionEvent.getAction() != 0 || (a5 = cVar.a(this, new RectF())) == null || a5.contains(motionEvent.getX(), motionEvent.getY())) && (i4 = cVar.f1100e) != -1)) {
            View view = this.f1063x0;
            if (view == null || view.getId() != i4) {
                this.f1063x0 = findViewById(i4);
            }
            View view2 = this.f1063x0;
            if (view2 != null) {
                RectF rectF = this.f1061w0;
                rectF.set(view2.getLeft(), this.f1063x0.getTop(), this.f1063x0.getRight(), this.f1063x0.getBottom());
                if (rectF.contains(motionEvent.getX(), motionEvent.getY()) && !t(0.0f, 0.0f, this.f1063x0, motionEvent)) {
                    return onTouchEvent(motionEvent);
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        this.f1051r0 = true;
        try {
            if (this.f1048q == null) {
                super.onLayout(z4, i4, i5, i6, i7);
                return;
            }
            int i8 = i6 - i4;
            int i9 = i7 - i5;
            if (this.P != i8 || this.Q != i9) {
                x();
                p(true);
            }
            this.P = i8;
            this.Q = i9;
        } finally {
            this.f1051r0 = false;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        boolean z4;
        int i6;
        boolean z5;
        int i7;
        int i8;
        float f4;
        if (this.f1048q == null) {
            super.onMeasure(i4, i5);
            return;
        }
        boolean z6 = true;
        if (this.f1060w == i4 && this.f1062x == i5) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (this.f1059v0) {
            this.f1059v0 = false;
            v();
            w();
            z4 = true;
        }
        if (this.f1238h) {
            z4 = true;
        }
        this.f1060w = i4;
        this.f1062x = i5;
        int g4 = this.f1048q.g();
        z zVar = this.f1048q.f1079c;
        if (zVar == null) {
            i6 = -1;
        } else {
            i6 = zVar.f5919c;
        }
        q.e eVar = this.f1233c;
        t tVar = this.f1057u0;
        if ((z4 || g4 != tVar.f5893e || i6 != tVar.f5894f) && this.f1054t != -1) {
            super.onMeasure(i4, i5);
            tVar.d(this.f1048q.b(g4), this.f1048q.b(i6));
            tVar.e();
            tVar.f5893e = g4;
            tVar.f5894f = i6;
            z5 = false;
        } else {
            z5 = true;
        }
        if (this.f1040i0 || z5) {
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int n4 = eVar.n() + getPaddingRight() + getPaddingLeft();
            int k4 = eVar.k() + paddingBottom;
            int i9 = this.f1045n0;
            if (i9 == Integer.MIN_VALUE || i9 == 0) {
                n4 = (int) ((this.f1047p0 * (this.f1043l0 - i7)) + this.f1041j0);
                requestLayout();
            }
            int i10 = this.f1046o0;
            if (i10 == Integer.MIN_VALUE || i10 == 0) {
                k4 = (int) ((this.f1047p0 * (this.f1044m0 - i8)) + this.f1042k0);
                requestLayout();
            }
            setMeasuredDimension(n4, k4);
        }
        float signum = Math.signum(this.F - this.D);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.f1050r;
        if (!(interpolator instanceof i)) {
            f4 = ((((float) (nanoTime - this.E)) * signum) * 1.0E-9f) / this.B;
        } else {
            f4 = 0.0f;
        }
        float f5 = this.D + f4;
        if (this.G) {
            f5 = this.F;
        }
        int i11 = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
        if ((i11 > 0 && f5 >= this.F) || (signum <= 0.0f && f5 <= this.F)) {
            f5 = this.F;
        } else {
            z6 = false;
        }
        if (interpolator != null && !z6) {
            if (this.L) {
                f5 = interpolator.getInterpolation(((float) (nanoTime - this.A)) * 1.0E-9f);
            } else {
                f5 = interpolator.getInterpolation(f5);
            }
        }
        if ((i11 > 0 && f5 >= this.F) || (signum <= 0.0f && f5 <= this.F)) {
            f5 = this.F;
        }
        this.f1047p0 = f5;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            p pVar = (p) this.f1066z.get(childAt);
            if (pVar != null) {
                pVar.c(f5, nanoTime2, childAt, this.f1049q0);
            }
        }
        if (this.f1040i0) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f4, float f5, boolean z4) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f4, float f5) {
        return false;
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i4) {
        c cVar;
        b bVar = this.f1048q;
        if (bVar != null) {
            boolean k4 = k();
            bVar.f1091o = k4;
            z zVar = bVar.f1079c;
            if (zVar != null && (cVar = zVar.f5928l) != null) {
                cVar.b(k4);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:177:0x037c, code lost:
        if (1.0f > r7) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0389, code lost:
        if (1.0f > r4) goto L189;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(android.view.MotionEvent r26) {
        /*
            Method dump skipped, instructions count: 972
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.f1034c0 == null) {
                this.f1034c0 = new ArrayList();
            }
            this.f1034c0.add(motionHelper);
            if (motionHelper.f1027h) {
                if (this.f1032a0 == null) {
                    this.f1032a0 = new ArrayList();
                }
                this.f1032a0.add(motionHelper);
            }
            if (motionHelper.f1028i) {
                if (this.f1033b0 == null) {
                    this.f1033b0 = new ArrayList();
                }
                this.f1033b0.add(motionHelper);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList arrayList = this.f1032a0;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList arrayList2 = this.f1033b0;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:140:0x0201, code lost:
        if (r1 != r2) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0204, code lost:
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0205, code lost:
        r22.f1056u = r2;
        r7 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0211, code lost:
        if (r1 != r2) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void p(boolean r23) {
        /*
            Method dump skipped, instructions count: 551
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.p(boolean):void");
    }

    public final void q() {
        ArrayList arrayList;
        if ((this.I == null && ((arrayList = this.f1034c0) == null || arrayList.isEmpty())) || this.f1039h0 == this.C) {
            return;
        }
        if (this.f1038g0 != -1) {
            v vVar = this.I;
            if (vVar != null) {
                vVar.getClass();
            }
            ArrayList arrayList2 = this.f1034c0;
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((v) it.next()).getClass();
                }
            }
        }
        this.f1038g0 = -1;
        this.f1039h0 = this.C;
        v vVar2 = this.I;
        if (vVar2 != null) {
            vVar2.getClass();
        }
        ArrayList arrayList3 = this.f1034c0;
        if (arrayList3 != null) {
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                ((v) it2.next()).getClass();
            }
        }
    }

    public final void r() {
        ArrayList arrayList;
        if ((this.I != null || ((arrayList = this.f1034c0) != null && !arrayList.isEmpty())) && this.f1038g0 == -1) {
            this.f1038g0 = this.f1056u;
            ArrayList arrayList2 = this.f1065y0;
            int intValue = !arrayList2.isEmpty() ? ((Integer) arrayList2.get(arrayList2.size() - 1)).intValue() : -1;
            int i4 = this.f1056u;
            if (intValue != i4 && i4 != -1) {
                arrayList2.add(Integer.valueOf(i4));
            }
        }
        w();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public final void requestLayout() {
        b bVar;
        z zVar;
        if (!this.f1040i0 && this.f1056u == -1 && (bVar = this.f1048q) != null && (zVar = bVar.f1079c) != null && zVar.f5933q == 0) {
            return;
        }
        super.requestLayout();
    }

    public final void s(int i4, float f4, float f5, float f6, float[] fArr) {
        String resourceName;
        View c4 = c(i4);
        p pVar = (p) this.f1066z.get(c4);
        if (pVar != null) {
            pVar.b(f4, f5, f6, fArr);
            c4.getY();
            return;
        }
        if (c4 == null) {
            resourceName = androidx.activity.j.b("", i4);
        } else {
            resourceName = c4.getContext().getResources().getResourceName(i4);
        }
        Log.w("MotionLayout", "WARNING could not find view id " + resourceName);
    }

    public void setDebugMode(int i4) {
        this.J = i4;
        invalidate();
    }

    public void setInteractionEnabled(boolean z4) {
        this.f1064y = z4;
    }

    public void setInterpolatedProgress(float f4) {
        if (this.f1048q != null) {
            setState(TransitionState.f1069c);
            Interpolator d4 = this.f1048q.d();
            if (d4 != null) {
                setProgress(d4.getInterpolation(f4));
                return;
            }
        }
        setProgress(f4);
    }

    public void setOnHide(float f4) {
        ArrayList arrayList = this.f1033b0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((MotionHelper) this.f1033b0.get(i4)).setProgress(f4);
            }
        }
    }

    public void setOnShow(float f4) {
        ArrayList arrayList = this.f1032a0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((MotionHelper) this.f1032a0.get(i4)).setProgress(f4);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
        if (r3.D == 0.0f) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
        setState(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r3.D == 1.0f) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setProgress(float r4) {
        /*
            r3 = this;
            boolean r0 = super.isAttachedToWindow()
            if (r0 != 0) goto L16
            androidx.constraintlayout.motion.widget.a r0 = r3.f1053s0
            if (r0 != 0) goto L11
            androidx.constraintlayout.motion.widget.a r0 = new androidx.constraintlayout.motion.widget.a
            r0.<init>(r3)
            r3.f1053s0 = r0
        L11:
            androidx.constraintlayout.motion.widget.a r0 = r3.f1053s0
            r0.f1072a = r4
            return
        L16:
            r0 = 0
            int r1 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r2 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.f1070d
            if (r1 > 0) goto L2b
            int r1 = r3.f1054t
            r3.f1056u = r1
            float r1 = r3.D
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 != 0) goto L44
        L27:
            r3.setState(r2)
            goto L44
        L2b:
            r0 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r1 < 0) goto L3c
            int r1 = r3.f1058v
            r3.f1056u = r1
            float r1 = r3.D
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 != 0) goto L44
            goto L27
        L3c:
            r0 = -1
            r3.f1056u = r0
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r0 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.f1069c
            r3.setState(r0)
        L44:
            androidx.constraintlayout.motion.widget.b r0 = r3.f1048q
            if (r0 != 0) goto L49
            return
        L49:
            r0 = 1
            r3.G = r0
            r3.F = r4
            r3.C = r4
            r1 = -1
            r3.E = r1
            r3.A = r1
            r4 = 0
            r3.f1050r = r4
            r3.H = r0
            r3.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.setProgress(float):void");
    }

    public void setScene(b bVar) {
        c cVar;
        this.f1048q = bVar;
        boolean k4 = k();
        bVar.f1091o = k4;
        z zVar = bVar.f1079c;
        if (zVar != null && (cVar = zVar.f5928l) != null) {
            cVar.b(k4);
        }
        x();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int i4, int i5, int i6) {
        setState(TransitionState.f1068b);
        this.f1056u = i4;
        this.f1054t = -1;
        this.f1058v = -1;
        t.d dVar = this.f1241k;
        if (dVar != null) {
            dVar.e(i5, i6, i4);
            return;
        }
        b bVar = this.f1048q;
        if (bVar != null) {
            bVar.b(i4).b(this);
        }
    }

    public void setTransition(int i4) {
        z zVar;
        b bVar = this.f1048q;
        if (bVar != null) {
            Iterator it = bVar.f1080d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    zVar = null;
                    break;
                }
                zVar = (z) it.next();
                if (zVar.f5917a == i4) {
                    break;
                }
            }
            this.f1054t = zVar.f5920d;
            this.f1058v = zVar.f5919c;
            if (!super.isAttachedToWindow()) {
                if (this.f1053s0 == null) {
                    this.f1053s0 = new a(this);
                }
                a aVar = this.f1053s0;
                aVar.f1074c = this.f1054t;
                aVar.f1075d = this.f1058v;
                return;
            }
            int i5 = this.f1056u;
            float f4 = i5 == this.f1054t ? 0.0f : i5 == this.f1058v ? 1.0f : Float.NaN;
            b bVar2 = this.f1048q;
            bVar2.f1079c = zVar;
            c cVar = zVar.f5928l;
            if (cVar != null) {
                cVar.b(bVar2.f1091o);
            }
            this.f1057u0.d(this.f1048q.b(this.f1054t), this.f1048q.b(this.f1058v));
            x();
            this.D = Float.isNaN(f4) ? 0.0f : f4;
            if (Float.isNaN(f4)) {
                Log.v("MotionLayout", com.google.common.collect.c.z0() + " transitionToStart ");
                o(0.0f);
                return;
            }
            setProgress(f4);
        }
    }

    public void setTransitionDuration(int i4) {
        b bVar = this.f1048q;
        if (bVar == null) {
            Log.e("MotionLayout", "MotionScene not defined");
            return;
        }
        z zVar = bVar.f1079c;
        if (zVar != null) {
            zVar.f5924h = i4;
        } else {
            bVar.f1086j = i4;
        }
    }

    public void setTransitionListener(v vVar) {
        this.I = vVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.f1053s0 == null) {
            this.f1053s0 = new a(this);
        }
        a aVar = this.f1053s0;
        aVar.getClass();
        aVar.f1072a = bundle.getFloat("motion.progress");
        aVar.f1073b = bundle.getFloat("motion.velocity");
        aVar.f1074c = bundle.getInt("motion.StartState");
        aVar.f1075d = bundle.getInt("motion.EndState");
        if (super.isAttachedToWindow()) {
            this.f1053s0.a();
        }
    }

    public final boolean t(float f4, float f5, View view, MotionEvent motionEvent) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                if (t(view.getLeft() + f4, view.getTop() + f5, viewGroup.getChildAt(i4), motionEvent)) {
                    return true;
                }
            }
        }
        RectF rectF = this.f1061w0;
        rectF.set(view.getLeft() + f4, view.getTop() + f5, f4 + view.getRight(), f5 + view.getBottom());
        if (motionEvent.getAction() == 0) {
            if (rectF.contains(motionEvent.getX(), motionEvent.getY()) && view.onTouchEvent(motionEvent)) {
                return true;
            }
        } else if (view.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public final String toString() {
        Context context = getContext();
        return com.google.common.collect.c.D0(context, this.f1054t) + "->" + com.google.common.collect.c.D0(context, this.f1058v) + " (pos:" + this.D + " Dpos/Dt:" + this.f1052s;
    }

    public final void u(AttributeSet attributeSet) {
        b bVar;
        String resourceEntryName;
        String str;
        View childAt;
        androidx.constraintlayout.widget.c cVar;
        isInEditMode();
        int i4 = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, k.f6658k);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z4 = true;
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                int i6 = 2;
                if (index == 2) {
                    this.f1048q = new b(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == 1) {
                    this.f1056u = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == 4) {
                    this.F = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.H = true;
                } else if (index == 0) {
                    z4 = obtainStyledAttributes.getBoolean(index, z4);
                } else if (index == 5) {
                    if (this.J == 0) {
                        if (!obtainStyledAttributes.getBoolean(index, false)) {
                            i6 = 0;
                        }
                        this.J = i6;
                    }
                } else if (index == 3) {
                    this.J = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
            if (this.f1048q == null) {
                Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
            }
            if (!z4) {
                this.f1048q = null;
            }
        }
        if (this.J != 0) {
            b bVar2 = this.f1048q;
            if (bVar2 == null) {
                Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            } else {
                int g4 = bVar2.g();
                b bVar3 = this.f1048q;
                d b5 = bVar3.b(bVar3.g());
                String D0 = com.google.common.collect.c.D0(getContext(), g4);
                int childCount = getChildCount();
                for (int i7 = 0; i7 < childCount; i7++) {
                    int id = getChildAt(i7).getId();
                    if (id == -1) {
                        Log.w("MotionLayout", "CHECK: " + D0 + " ALL VIEWS SHOULD HAVE ID's " + childAt.getClass().getName() + " does not!");
                    }
                    HashMap hashMap = b5.f1321c;
                    if (hashMap.containsKey(Integer.valueOf(id))) {
                        cVar = (androidx.constraintlayout.widget.c) hashMap.get(Integer.valueOf(id));
                    } else {
                        cVar = null;
                    }
                    if (cVar == null) {
                        Log.w("MotionLayout", "CHECK: " + D0 + " NO CONSTRAINTS for " + com.google.common.collect.c.E0(childAt));
                    }
                }
                Integer[] numArr = (Integer[]) b5.f1321c.keySet().toArray(new Integer[0]);
                int length = numArr.length;
                int[] iArr = new int[length];
                for (int i8 = 0; i8 < length; i8++) {
                    iArr[i8] = numArr[i8].intValue();
                }
                for (int i9 = 0; i9 < length; i9++) {
                    int i10 = iArr[i9];
                    String D02 = com.google.common.collect.c.D0(getContext(), i10);
                    if (findViewById(iArr[i9]) == null) {
                        Log.w("MotionLayout", "CHECK: " + D0 + " NO View matches id " + D02);
                    }
                    if (b5.g(i10).f1314d.f6591d == -1) {
                        Log.w("MotionLayout", "CHECK: " + D0 + "(" + D02 + ") no LAYOUT_HEIGHT");
                    }
                    if (b5.g(i10).f1314d.f6589c == -1) {
                        Log.w("MotionLayout", "CHECK: " + D0 + "(" + D02 + ") no LAYOUT_HEIGHT");
                    }
                }
                SparseIntArray sparseIntArray = new SparseIntArray();
                SparseIntArray sparseIntArray2 = new SparseIntArray();
                Iterator it = this.f1048q.f1080d.iterator();
                while (it.hasNext()) {
                    z zVar = (z) it.next();
                    if (zVar == this.f1048q.f1079c) {
                        Log.v("MotionLayout", "CHECK: CURRENT");
                    }
                    StringBuilder sb = new StringBuilder("CHECK: transition = ");
                    Context context = getContext();
                    if (zVar.f5920d == -1) {
                        resourceEntryName = "null";
                    } else {
                        resourceEntryName = context.getResources().getResourceEntryName(zVar.f5920d);
                    }
                    if (zVar.f5919c == -1) {
                        str = androidx.activity.j.c(resourceEntryName, " -> null");
                    } else {
                        str = resourceEntryName + " -> " + context.getResources().getResourceEntryName(zVar.f5919c);
                    }
                    sb.append(str);
                    Log.v("MotionLayout", sb.toString());
                    Log.v("MotionLayout", "CHECK: transition.setDuration = " + zVar.f5924h);
                    if (zVar.f5920d == zVar.f5919c) {
                        Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
                    }
                    int i11 = zVar.f5920d;
                    int i12 = zVar.f5919c;
                    String D03 = com.google.common.collect.c.D0(getContext(), i11);
                    String D04 = com.google.common.collect.c.D0(getContext(), i12);
                    if (sparseIntArray.get(i11) == i12) {
                        Log.e("MotionLayout", "CHECK: two transitions with the same start and end " + D03 + "->" + D04);
                    }
                    if (sparseIntArray2.get(i12) == i11) {
                        Log.e("MotionLayout", "CHECK: you can't have reverse transitions" + D03 + "->" + D04);
                    }
                    sparseIntArray.put(i11, i12);
                    sparseIntArray2.put(i12, i11);
                    if (this.f1048q.b(i11) == null) {
                        Log.e("MotionLayout", " no such constraintSetStart " + D03);
                    }
                    if (this.f1048q.b(i12) == null) {
                        Log.e("MotionLayout", " no such constraintSetEnd " + D03);
                    }
                }
            }
        }
        if (this.f1056u == -1 && (bVar = this.f1048q) != null) {
            this.f1056u = bVar.g();
            this.f1054t = this.f1048q.g();
            z zVar2 = this.f1048q.f1079c;
            if (zVar2 != null) {
                i4 = zVar2.f5919c;
            }
            this.f1058v = i4;
        }
    }

    public final void v() {
        z zVar;
        c cVar;
        View view;
        b bVar = this.f1048q;
        if (bVar == null) {
            return;
        }
        if (bVar.a(this, this.f1056u)) {
            requestLayout();
            return;
        }
        int i4 = this.f1056u;
        if (i4 != -1) {
            b bVar2 = this.f1048q;
            ArrayList arrayList = bVar2.f1080d;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                z zVar2 = (z) it.next();
                if (zVar2.f5929m.size() > 0) {
                    Iterator it2 = zVar2.f5929m.iterator();
                    while (it2.hasNext()) {
                        ((y) it2.next()).b(this);
                    }
                }
            }
            ArrayList arrayList2 = bVar2.f1082f;
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                z zVar3 = (z) it3.next();
                if (zVar3.f5929m.size() > 0) {
                    Iterator it4 = zVar3.f5929m.iterator();
                    while (it4.hasNext()) {
                        ((y) it4.next()).b(this);
                    }
                }
            }
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                z zVar4 = (z) it5.next();
                if (zVar4.f5929m.size() > 0) {
                    Iterator it6 = zVar4.f5929m.iterator();
                    while (it6.hasNext()) {
                        ((y) it6.next()).a(this, i4, zVar4);
                    }
                }
            }
            Iterator it7 = arrayList2.iterator();
            while (it7.hasNext()) {
                z zVar5 = (z) it7.next();
                if (zVar5.f5929m.size() > 0) {
                    Iterator it8 = zVar5.f5929m.iterator();
                    while (it8.hasNext()) {
                        ((y) it8.next()).a(this, i4, zVar5);
                    }
                }
            }
        }
        if (this.f1048q.l() && (zVar = this.f1048q.f1079c) != null && (cVar = zVar.f5928l) != null) {
            int i5 = cVar.f1099d;
            if (i5 != -1) {
                MotionLayout motionLayout = cVar.f1110o;
                view = motionLayout.findViewById(i5);
                if (view == null) {
                    Log.e("TouchResponse", "cannot find TouchAnchorId @id/" + com.google.common.collect.c.D0(motionLayout.getContext(), cVar.f1099d));
                }
            } else {
                view = null;
            }
            if (view instanceof NestedScrollView) {
                NestedScrollView nestedScrollView = (NestedScrollView) view;
                nestedScrollView.setOnTouchListener(new e2(1, cVar));
                nestedScrollView.setOnScrollChangeListener(new o0(8, cVar));
            }
        }
    }

    public final void w() {
        ArrayList arrayList;
        if (this.I == null && ((arrayList = this.f1034c0) == null || arrayList.isEmpty())) {
            return;
        }
        ArrayList arrayList2 = this.f1065y0;
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            v vVar = this.I;
            if (vVar != null) {
                num.intValue();
                vVar.getClass();
            }
            ArrayList arrayList3 = this.f1034c0;
            if (arrayList3 != null) {
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    num.intValue();
                    ((v) it2.next()).getClass();
                }
            }
        }
        arrayList2.clear();
    }

    public final void x() {
        this.f1057u0.e();
        invalidate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0059, code lost:
        if ((((r13 * r7) - (((r1 * r7) * r7) / 2.0f)) + r14) > 1.0f) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0067, code lost:
        if ((((((r1 * r5) * r5) / 2.0f) + (r13 * r5)) + r14) < 0.0f) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0069, code lost:
        r12 = r11.D;
        r14 = r11.f1048q.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007b, code lost:
        r14 = r11.D;
        r10 = r11.B;
        r8 = r11.f1048q.f();
        r1 = r11.f1048q.f1079c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0089, code lost:
        if (r1 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008b, code lost:
        r1 = r1.f5928l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008d, code lost:
        if (r1 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008f, code lost:
        r9 = r1.f1111p;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0093, code lost:
        r9 = 0.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0094, code lost:
        r5 = r11.M;
        r5.f5694l = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009a, code lost:
        if (r14 <= r12) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009d, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009e, code lost:
        r5.f5693k = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a0, code lost:
        if (r0 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a2, code lost:
        r6 = -r13;
        r7 = r14 - r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a5, code lost:
        r5.c(r6, r7, r8, r9, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a9, code lost:
        r7 = r12 - r14;
        r6 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ad, code lost:
        r11.f1052s = 0.0f;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void y(float r12, float r13, int r14) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.y(float, float, int):void");
    }

    public final void z(int i4) {
        int i5;
        float f4;
        float alpha;
        n nVar;
        if (!super.isAttachedToWindow()) {
            if (this.f1053s0 == null) {
                this.f1053s0 = new a(this);
            }
            this.f1053s0.f1075d = i4;
            return;
        }
        b bVar = this.f1048q;
        if (bVar != null && (nVar = bVar.f1078b) != null) {
            int i6 = this.f1056u;
            float f5 = -1;
            l lVar = (l) ((SparseArray) nVar.f6680d).get(i4);
            if (lVar == null) {
                i6 = i4;
            } else {
                int i7 = (f5 > (-1.0f) ? 1 : (f5 == (-1.0f) ? 0 : -1));
                ArrayList arrayList = lVar.f6670b;
                int i8 = lVar.f6671c;
                if (i7 != 0 && i7 != 0) {
                    Iterator it = arrayList.iterator();
                    m mVar = null;
                    while (true) {
                        if (it.hasNext()) {
                            m mVar2 = (m) it.next();
                            if (mVar2.a(f5, f5)) {
                                if (i6 == mVar2.f6676e) {
                                    break;
                                }
                                mVar = mVar2;
                            }
                        } else if (mVar != null) {
                            i6 = mVar.f6676e;
                        }
                    }
                } else if (i8 != i6) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        if (i6 == ((m) it2.next()).f6676e) {
                            break;
                        }
                    }
                    i6 = i8;
                }
            }
            if (i6 != -1) {
                i4 = i6;
            }
        }
        int i9 = this.f1056u;
        if (i9 != i4) {
            if (this.f1054t == i4) {
                o(0.0f);
            } else if (this.f1058v == i4) {
                o(1.0f);
            } else {
                this.f1058v = i4;
                if (i9 != -1) {
                    setTransition(i9, i4);
                    o(1.0f);
                    this.D = 0.0f;
                    o(1.0f);
                    return;
                }
                this.L = false;
                this.F = 1.0f;
                this.C = 0.0f;
                this.D = 0.0f;
                this.E = getNanoTime();
                this.A = getNanoTime();
                this.G = false;
                this.f1050r = null;
                b bVar2 = this.f1048q;
                z zVar = bVar2.f1079c;
                if (zVar != null) {
                    i5 = zVar.f5924h;
                } else {
                    i5 = bVar2.f1086j;
                }
                this.B = i5 / 1000.0f;
                this.f1054t = -1;
                bVar2.k(-1, this.f1058v);
                this.f1048q.g();
                int childCount = getChildCount();
                HashMap hashMap = this.f1066z;
                hashMap.clear();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = getChildAt(i10);
                    hashMap.put(childAt, new p(childAt));
                }
                this.H = true;
                d b5 = this.f1048q.b(i4);
                t tVar = this.f1057u0;
                tVar.d(null, b5);
                x();
                tVar.a();
                int childCount2 = getChildCount();
                for (int i11 = 0; i11 < childCount2; i11++) {
                    View childAt2 = getChildAt(i11);
                    p pVar = (p) hashMap.get(childAt2);
                    if (pVar != null) {
                        w wVar = pVar.f5849d;
                        wVar.f5901c = 0.0f;
                        wVar.f5902d = 0.0f;
                        float x4 = childAt2.getX();
                        float y4 = childAt2.getY();
                        wVar.f5903e = x4;
                        wVar.f5904f = y4;
                        wVar.f5905g = childAt2.getWidth();
                        wVar.f5906h = childAt2.getHeight();
                        o oVar = pVar.f5851f;
                        oVar.getClass();
                        childAt2.getX();
                        childAt2.getY();
                        childAt2.getWidth();
                        childAt2.getHeight();
                        oVar.f5831c = childAt2.getVisibility();
                        if (childAt2.getVisibility() != 0) {
                            alpha = 0.0f;
                        } else {
                            alpha = childAt2.getAlpha();
                        }
                        oVar.f5829a = alpha;
                        oVar.f5832d = childAt2.getElevation();
                        oVar.f5833e = childAt2.getRotation();
                        oVar.f5834f = childAt2.getRotationX();
                        oVar.f5835g = childAt2.getRotationY();
                        oVar.f5836h = childAt2.getScaleX();
                        oVar.f5837i = childAt2.getScaleY();
                        oVar.f5838j = childAt2.getPivotX();
                        oVar.f5839k = childAt2.getPivotY();
                        oVar.f5840l = childAt2.getTranslationX();
                        oVar.f5841m = childAt2.getTranslationY();
                        oVar.f5842n = childAt2.getTranslationZ();
                    }
                }
                getWidth();
                getHeight();
                for (int i12 = 0; i12 < childCount; i12++) {
                    p pVar2 = (p) hashMap.get(getChildAt(i12));
                    this.f1048q.e(pVar2);
                    pVar2.e(getNanoTime());
                }
                z zVar2 = this.f1048q.f1079c;
                if (zVar2 != null) {
                    f4 = zVar2.f5925i;
                } else {
                    f4 = 0.0f;
                }
                if (f4 != 0.0f) {
                    float f6 = Float.MAX_VALUE;
                    float f7 = -3.4028235E38f;
                    for (int i13 = 0; i13 < childCount; i13++) {
                        w wVar2 = ((p) hashMap.get(getChildAt(i13))).f5850e;
                        float f8 = wVar2.f5904f + wVar2.f5903e;
                        f6 = Math.min(f6, f8);
                        f7 = Math.max(f7, f8);
                    }
                    for (int i14 = 0; i14 < childCount; i14++) {
                        p pVar3 = (p) hashMap.get(getChildAt(i14));
                        w wVar3 = pVar3.f5850e;
                        float f9 = wVar3.f5903e;
                        float f10 = wVar3.f5904f;
                        pVar3.f5857l = 1.0f / (1.0f - f4);
                        pVar3.f5856k = f4 - ((((f9 + f10) - f6) * f4) / (f7 - f6));
                    }
                }
                this.C = 0.0f;
                this.D = 0.0f;
                this.H = true;
                invalidate();
            }
        }
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1052s = 0.0f;
        this.f1054t = -1;
        this.f1056u = -1;
        this.f1058v = -1;
        this.f1060w = 0;
        this.f1062x = 0;
        this.f1064y = true;
        this.f1066z = new HashMap();
        this.A = 0L;
        this.B = 1.0f;
        this.C = 0.0f;
        this.D = 0.0f;
        this.F = 0.0f;
        this.H = false;
        this.J = 0;
        this.L = false;
        this.M = new i();
        this.N = new r(this);
        this.R = false;
        this.W = false;
        this.f1032a0 = null;
        this.f1033b0 = null;
        this.f1034c0 = null;
        this.f1035d0 = 0;
        this.f1036e0 = -1L;
        this.f1037f0 = 0.0f;
        this.f1038g0 = 0;
        this.f1039h0 = 0.0f;
        this.f1040i0 = false;
        this.f1049q0 = new o0(7);
        this.f1051r0 = false;
        this.f1055t0 = TransitionState.f1067a;
        this.f1057u0 = new t(this);
        this.f1059v0 = false;
        this.f1061w0 = new RectF();
        this.f1063x0 = null;
        this.f1065y0 = new ArrayList();
        u(attributeSet);
    }

    public void setState(TransitionState transitionState) {
        TransitionState transitionState2 = TransitionState.f1070d;
        if (transitionState == transitionState2 && this.f1056u == -1) {
            return;
        }
        TransitionState transitionState3 = this.f1055t0;
        this.f1055t0 = transitionState;
        TransitionState transitionState4 = TransitionState.f1069c;
        if (transitionState3 == transitionState4 && transitionState == transitionState4) {
            q();
        }
        int ordinal = transitionState3.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            if (transitionState == transitionState4) {
                q();
            }
            if (transitionState != transitionState2) {
                return;
            }
        } else if (ordinal != 2 || transitionState != transitionState2) {
            return;
        }
        r();
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f1052s = 0.0f;
        this.f1054t = -1;
        this.f1056u = -1;
        this.f1058v = -1;
        this.f1060w = 0;
        this.f1062x = 0;
        this.f1064y = true;
        this.f1066z = new HashMap();
        this.A = 0L;
        this.B = 1.0f;
        this.C = 0.0f;
        this.D = 0.0f;
        this.F = 0.0f;
        this.H = false;
        this.J = 0;
        this.L = false;
        this.M = new i();
        this.N = new r(this);
        this.R = false;
        this.W = false;
        this.f1032a0 = null;
        this.f1033b0 = null;
        this.f1034c0 = null;
        this.f1035d0 = 0;
        this.f1036e0 = -1L;
        this.f1037f0 = 0.0f;
        this.f1038g0 = 0;
        this.f1039h0 = 0.0f;
        this.f1040i0 = false;
        this.f1049q0 = new o0(7);
        this.f1051r0 = false;
        this.f1055t0 = TransitionState.f1067a;
        this.f1057u0 = new t(this);
        this.f1059v0 = false;
        this.f1061w0 = new RectF();
        this.f1063x0 = null;
        this.f1065y0 = new ArrayList();
        u(attributeSet);
    }

    public void setProgress(float f4, float f5) {
        if (!super.isAttachedToWindow()) {
            if (this.f1053s0 == null) {
                this.f1053s0 = new a(this);
            }
            a aVar = this.f1053s0;
            aVar.f1072a = f4;
            aVar.f1073b = f5;
            return;
        }
        setProgress(f4);
        setState(TransitionState.f1069c);
        this.f1052s = f5;
        o(1.0f);
    }

    public void setTransition(int i4, int i5) {
        if (!super.isAttachedToWindow()) {
            if (this.f1053s0 == null) {
                this.f1053s0 = new a(this);
            }
            a aVar = this.f1053s0;
            aVar.f1074c = i4;
            aVar.f1075d = i5;
            return;
        }
        b bVar = this.f1048q;
        if (bVar != null) {
            this.f1054t = i4;
            this.f1058v = i5;
            bVar.k(i4, i5);
            this.f1057u0.d(this.f1048q.b(i4), this.f1048q.b(i5));
            x();
            this.D = 0.0f;
            o(0.0f);
        }
    }

    public void setTransition(z zVar) {
        c cVar;
        b bVar = this.f1048q;
        bVar.f1079c = zVar;
        if (zVar != null && (cVar = zVar.f5928l) != null) {
            cVar.b(bVar.f1091o);
        }
        setState(TransitionState.f1068b);
        int i4 = this.f1056u;
        z zVar2 = this.f1048q.f1079c;
        float f4 = i4 == (zVar2 == null ? -1 : zVar2.f5919c) ? 1.0f : 0.0f;
        this.D = f4;
        this.C = f4;
        this.F = f4;
        this.E = (zVar.f5934r & 1) != 0 ? -1L : getNanoTime();
        int g4 = this.f1048q.g();
        b bVar2 = this.f1048q;
        z zVar3 = bVar2.f1079c;
        int i5 = zVar3 != null ? zVar3.f5919c : -1;
        if (g4 == this.f1054t && i5 == this.f1058v) {
            return;
        }
        this.f1054t = g4;
        this.f1058v = i5;
        bVar2.k(g4, i5);
        d b5 = this.f1048q.b(this.f1054t);
        d b6 = this.f1048q.b(this.f1058v);
        t tVar = this.f1057u0;
        tVar.d(b5, b6);
        int i6 = this.f1054t;
        int i7 = this.f1058v;
        tVar.f5893e = i6;
        tVar.f5894f = i7;
        tVar.e();
        x();
    }
}
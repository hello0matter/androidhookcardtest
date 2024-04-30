package androidx.appcompat.app;

import android.content.ClipDescription;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.core.widget.NestedScrollView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class c implements androidx.core.widget.l, l0.h, d2.h {

    /* renamed from: d  reason: collision with root package name */
    public static c f191d;

    /* renamed from: a  reason: collision with root package name */
    public Object f192a;

    /* renamed from: b  reason: collision with root package name */
    public Object f193b;

    /* renamed from: c  reason: collision with root package name */
    public Object f194c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(androidx.lifecycle.k0 k0Var, androidx.lifecycle.j0 j0Var) {
        this(k0Var, j0Var, (v0.b) v0.a.f6946b);
        com.google.common.collect.c.F(k0Var, "store");
        com.google.common.collect.c.F(j0Var, "factory");
    }

    public static void n() {
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
    }

    @Override // l0.h
    public final void a() {
    }

    @Override // l0.h
    public final Uri b() {
        return (Uri) this.f194c;
    }

    @Override // d2.h
    public final int c() {
        Object obj;
        Object obj2 = this.f194c;
        if (((ExtendedFloatingActionButton) obj2).G == -1) {
            obj = this.f192a;
        } else if (((ExtendedFloatingActionButton) obj2).G != 0 && ((ExtendedFloatingActionButton) obj2).G != -2) {
            return ((ExtendedFloatingActionButton) obj2).G;
        } else {
            obj = this.f193b;
        }
        return ((d2.h) obj).c();
    }

    @Override // d2.h
    public final int d() {
        Object obj;
        Object obj2 = this.f194c;
        if (((ExtendedFloatingActionButton) obj2).H == -1) {
            obj = this.f192a;
        } else if (((ExtendedFloatingActionButton) obj2).H != 0 && ((ExtendedFloatingActionButton) obj2).H != -2) {
            return ((ExtendedFloatingActionButton) obj2).H;
        } else {
            obj = this.f193b;
        }
        return ((d2.h) obj).d();
    }

    @Override // d2.h
    public final int e() {
        return ((ExtendedFloatingActionButton) this.f194c).A;
    }

    @Override // l0.h
    public final ClipDescription f() {
        return (ClipDescription) this.f193b;
    }

    @Override // d2.h
    public final int g() {
        return ((ExtendedFloatingActionButton) this.f194c).f3398z;
    }

    @Override // d2.h
    public final ViewGroup.LayoutParams h() {
        int i4;
        Object obj = this.f194c;
        int i5 = -2;
        if (((ExtendedFloatingActionButton) obj).G == 0) {
            i4 = -2;
        } else {
            i4 = ((ExtendedFloatingActionButton) obj).G;
        }
        if (((ExtendedFloatingActionButton) obj).H != 0) {
            i5 = ((ExtendedFloatingActionButton) obj).H;
        }
        return new ViewGroup.LayoutParams(i4, i5);
    }

    @Override // l0.h
    public final Object i() {
        return null;
    }

    @Override // l0.h
    public final Uri j() {
        return (Uri) this.f192a;
    }

    public final androidx.lifecycle.h0 k(Class cls, String str) {
        androidx.lifecycle.h0 a5;
        Object obj = this.f193b;
        com.google.common.collect.c.F(str, "key");
        androidx.lifecycle.k0 k0Var = (androidx.lifecycle.k0) this.f192a;
        k0Var.getClass();
        androidx.lifecycle.h0 h0Var = (androidx.lifecycle.h0) k0Var.f1909a.get(str);
        if (cls.isInstance(h0Var)) {
            com.google.common.collect.c.D(h0Var, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return h0Var;
        }
        v0.d dVar = new v0.d((v0.b) this.f194c);
        dVar.f6947a.put(androidx.lifecycle.i0.f1907b, str);
        try {
            a5 = ((androidx.lifecycle.j0) obj).b(cls, dVar);
        } catch (AbstractMethodError unused) {
            a5 = ((androidx.lifecycle.j0) obj).a(cls);
        }
        k0Var.getClass();
        com.google.common.collect.c.F(a5, "viewModel");
        androidx.lifecycle.h0 h0Var2 = (androidx.lifecycle.h0) k0Var.f1909a.put(str, a5);
        if (h0Var2 != null) {
            h0Var2.a();
        }
        return a5;
    }

    public final Location l(String str) {
        Object obj = this.f193b;
        try {
            if (((LocationManager) obj).isProviderEnabled(str)) {
                return ((LocationManager) obj).getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e4) {
            Log.d("TwilightManager", "Failed to get last known location", e4);
            return null;
        }
    }

    public final boolean m(r.c cVar, q.d dVar, boolean z4) {
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        r.b bVar = (r.b) this.f193b;
        ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr = dVar.J;
        bVar.f6429a = constraintWidget$DimensionBehaviourArr[0];
        boolean z9 = true;
        bVar.f6430b = constraintWidget$DimensionBehaviourArr[1];
        bVar.f6431c = dVar.n();
        bVar.f6432d = dVar.k();
        bVar.f6437i = false;
        bVar.f6438j = z4;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = bVar.f6429a;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.f1133c;
        if (constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour2) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (bVar.f6430b == constraintWidget$DimensionBehaviour2) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 && dVar.N > 0.0f) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z6 && dVar.N > 0.0f) {
            z8 = true;
        } else {
            z8 = false;
        }
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.f1131a;
        int[] iArr = dVar.f6214l;
        if (z7 && iArr[0] == 4) {
            bVar.f6429a = constraintWidget$DimensionBehaviour3;
        }
        if (z8 && iArr[1] == 4) {
            bVar.f6430b = constraintWidget$DimensionBehaviour3;
        }
        ((androidx.constraintlayout.widget.b) cVar).a(dVar, bVar);
        dVar.A(bVar.f6433e);
        dVar.x(bVar.f6434f);
        dVar.f6225w = bVar.f6436h;
        int i4 = bVar.f6435g;
        dVar.R = i4;
        if (i4 <= 0) {
            z9 = false;
        }
        dVar.f6225w = z9;
        bVar.f6438j = false;
        return bVar.f6437i;
    }

    public final void o(q.e eVar, int i4, int i5) {
        int i6 = eVar.S;
        int i7 = eVar.T;
        eVar.S = 0;
        eVar.T = 0;
        eVar.A(i4);
        eVar.x(i5);
        if (i6 < 0) {
            eVar.S = 0;
        } else {
            eVar.S = i6;
        }
        if (i7 < 0) {
            eVar.T = 0;
        } else {
            eVar.T = i7;
        }
        ((q.e) this.f194c).G();
    }

    @Override // androidx.core.widget.l
    public final void t(NestedScrollView nestedScrollView) {
        h.a(nestedScrollView, (View) this.f192a, (View) this.f193b);
    }

    public c(androidx.lifecycle.k0 k0Var, androidx.lifecycle.j0 j0Var, v0.b bVar) {
        com.google.common.collect.c.F(k0Var, "store");
        com.google.common.collect.c.F(j0Var, "factory");
        com.google.common.collect.c.F(bVar, "defaultCreationExtras");
        this.f192a = k0Var;
        this.f193b = j0Var;
        this.f194c = bVar;
    }

    public /* synthetic */ c(Object obj, androidx.appcompat.widget.c0 c0Var, d2.c cVar) {
        this.f194c = obj;
        this.f192a = c0Var;
        this.f193b = cVar;
    }

    public /* synthetic */ c(Object obj, Object obj2, Object obj3) {
        this.f192a = obj;
        this.f193b = obj2;
        this.f194c = obj3;
    }

    public c(Runnable runnable) {
        this.f193b = new CopyOnWriteArrayList();
        this.f194c = new HashMap();
        this.f192a = runnable;
    }
}
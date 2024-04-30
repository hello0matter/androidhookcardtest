package androidx.transition;

import a0.t;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.j;
import c1.c0;
import c1.f0;
import c1.m0;
import com.google.common.collect.c;
import java.util.ArrayList;
import java.util.Iterator;
import p.d;

/* loaded from: classes.dex */
public class TransitionSet extends Transition {
    public int A;
    public boolean B;
    public int C;

    /* renamed from: y  reason: collision with root package name */
    public ArrayList f2372y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f2373z;

    public TransitionSet() {
        this.f2372y = new ArrayList();
        this.f2373z = true;
        this.B = false;
        this.C = 0;
    }

    @Override // androidx.transition.Transition
    public final void A(c cVar) {
        this.f2370t = cVar;
        this.C |= 8;
        int size = this.f2372y.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((Transition) this.f2372y.get(i4)).A(cVar);
        }
    }

    @Override // androidx.transition.Transition
    public final void C(PathMotion pathMotion) {
        super.C(pathMotion);
        this.C |= 4;
        if (this.f2372y != null) {
            for (int i4 = 0; i4 < this.f2372y.size(); i4++) {
                ((Transition) this.f2372y.get(i4)).C(pathMotion);
            }
        }
    }

    @Override // androidx.transition.Transition
    public final void D(c cVar) {
        this.f2369s = cVar;
        this.C |= 2;
        int size = this.f2372y.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((Transition) this.f2372y.get(i4)).D(cVar);
        }
    }

    @Override // androidx.transition.Transition
    public final void E(long j4) {
        this.f2352b = j4;
    }

    @Override // androidx.transition.Transition
    public final String G(String str) {
        String G = super.G(str);
        for (int i4 = 0; i4 < this.f2372y.size(); i4++) {
            StringBuilder sb = new StringBuilder();
            sb.append(G);
            sb.append("\n");
            sb.append(((Transition) this.f2372y.get(i4)).G(str + "  "));
            G = sb.toString();
        }
        return G;
    }

    public final void H(Transition transition) {
        this.f2372y.add(transition);
        transition.f2359i = this;
        long j4 = this.f2353c;
        if (j4 >= 0) {
            transition.z(j4);
        }
        if ((this.C & 1) != 0) {
            transition.B(this.f2354d);
        }
        if ((this.C & 2) != 0) {
            transition.D(this.f2369s);
        }
        if ((this.C & 4) != 0) {
            transition.C(this.f2371u);
        }
        if ((this.C & 8) != 0) {
            transition.A(this.f2370t);
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: I */
    public final void z(long j4) {
        ArrayList arrayList;
        this.f2353c = j4;
        if (j4 >= 0 && (arrayList = this.f2372y) != null) {
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((Transition) this.f2372y.get(i4)).z(j4);
            }
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: J */
    public final void B(TimeInterpolator timeInterpolator) {
        this.C |= 1;
        ArrayList arrayList = this.f2372y;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((Transition) this.f2372y.get(i4)).B(timeInterpolator);
            }
        }
        this.f2354d = timeInterpolator;
    }

    public final void K(int i4) {
        if (i4 != 0) {
            if (i4 == 1) {
                this.f2373z = false;
                return;
            }
            throw new AndroidRuntimeException(j.b("Invalid parameter for TransitionSet ordering: ", i4));
        }
        this.f2373z = true;
    }

    @Override // androidx.transition.Transition
    public final void a(f0 f0Var) {
        super.a(f0Var);
    }

    @Override // androidx.transition.Transition
    public final void b(View view) {
        for (int i4 = 0; i4 < this.f2372y.size(); i4++) {
            ((Transition) this.f2372y.get(i4)).b(view);
        }
        this.f2356f.add(view);
    }

    @Override // androidx.transition.Transition
    public final void d(m0 m0Var) {
        if (s(m0Var.f2647b)) {
            Iterator it = this.f2372y.iterator();
            while (it.hasNext()) {
                Transition transition = (Transition) it.next();
                if (transition.s(m0Var.f2647b)) {
                    transition.d(m0Var);
                    m0Var.f2648c.add(transition);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public final void f(m0 m0Var) {
        super.f(m0Var);
        int size = this.f2372y.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((Transition) this.f2372y.get(i4)).f(m0Var);
        }
    }

    @Override // androidx.transition.Transition
    public final void g(m0 m0Var) {
        if (s(m0Var.f2647b)) {
            Iterator it = this.f2372y.iterator();
            while (it.hasNext()) {
                Transition transition = (Transition) it.next();
                if (transition.s(m0Var.f2647b)) {
                    transition.g(m0Var);
                    m0Var.f2648c.add(transition);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: j */
    public final Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.f2372y = new ArrayList();
        int size = this.f2372y.size();
        for (int i4 = 0; i4 < size; i4++) {
            Transition clone = ((Transition) this.f2372y.get(i4)).clone();
            transitionSet.f2372y.add(clone);
            clone.f2359i = transitionSet;
        }
        return transitionSet;
    }

    @Override // androidx.transition.Transition
    public final void l(ViewGroup viewGroup, d dVar, d dVar2, ArrayList arrayList, ArrayList arrayList2) {
        long j4 = this.f2352b;
        int size = this.f2372y.size();
        for (int i4 = 0; i4 < size; i4++) {
            Transition transition = (Transition) this.f2372y.get(i4);
            if (j4 > 0 && (this.f2373z || i4 == 0)) {
                long j5 = transition.f2352b;
                if (j5 > 0) {
                    transition.E(j5 + j4);
                } else {
                    transition.E(j4);
                }
            }
            transition.l(viewGroup, dVar, dVar2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.Transition
    public final void u(View view) {
        super.u(view);
        int size = this.f2372y.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((Transition) this.f2372y.get(i4)).u(view);
        }
    }

    @Override // androidx.transition.Transition
    public final void v(f0 f0Var) {
        super.v(f0Var);
    }

    @Override // androidx.transition.Transition
    public final void w(View view) {
        for (int i4 = 0; i4 < this.f2372y.size(); i4++) {
            ((Transition) this.f2372y.get(i4)).w(view);
        }
        this.f2356f.remove(view);
    }

    @Override // androidx.transition.Transition
    public final void x(ViewGroup viewGroup) {
        super.x(viewGroup);
        int size = this.f2372y.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((Transition) this.f2372y.get(i4)).x(viewGroup);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [c1.f0, java.lang.Object, c1.j0] */
    @Override // androidx.transition.Transition
    public final void y() {
        if (this.f2372y.isEmpty()) {
            F();
            m();
            return;
        }
        ?? obj = new Object();
        obj.f2626a = this;
        Iterator it = this.f2372y.iterator();
        while (it.hasNext()) {
            ((Transition) it.next()).a(obj);
        }
        this.A = this.f2372y.size();
        if (!this.f2373z) {
            for (int i4 = 1; i4 < this.f2372y.size(); i4++) {
                ((Transition) this.f2372y.get(i4 - 1)).a(new c1.j(3, this, (Transition) this.f2372y.get(i4)));
            }
            Transition transition = (Transition) this.f2372y.get(0);
            if (transition != null) {
                transition.y();
                return;
            }
            return;
        }
        Iterator it2 = this.f2372y.iterator();
        while (it2.hasNext()) {
            ((Transition) it2.next()).y();
        }
    }

    @SuppressLint({"RestrictedApi"})
    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2372y = new ArrayList();
        this.f2373z = true;
        this.B = false;
        this.C = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c0.f2585g);
        K(t.b(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }
}
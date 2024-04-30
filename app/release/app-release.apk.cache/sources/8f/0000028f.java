package androidx.fragment.app;

import android.transition.Transition;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class x0 implements Transition.TransitionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f1846a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1847b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f1848c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1849d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f1850e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1851f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ z0 f1852g;

    public x0(z0 z0Var, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
        this.f1852g = z0Var;
        this.f1846a = obj;
        this.f1847b = arrayList;
        this.f1848c = obj2;
        this.f1849d = arrayList2;
        this.f1850e = obj3;
        this.f1851f = arrayList3;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
        z0 z0Var = this.f1852g;
        Object obj = this.f1846a;
        if (obj != null) {
            z0Var.v(obj, this.f1847b, null);
        }
        Object obj2 = this.f1848c;
        if (obj2 != null) {
            z0Var.v(obj2, this.f1849d, null);
        }
        Object obj3 = this.f1850e;
        if (obj3 != null) {
            z0Var.v(obj3, this.f1851f, null);
        }
    }
}
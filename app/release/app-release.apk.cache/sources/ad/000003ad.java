package c1;

import androidx.transition.Transition;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class q extends g0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f2669a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f2670b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f2671c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ArrayList f2672d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f2673e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f2674f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ r f2675g;

    public q(r rVar, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
        this.f2675g = rVar;
        this.f2669a = obj;
        this.f2670b = arrayList;
        this.f2671c = obj2;
        this.f2672d = arrayList2;
        this.f2673e = obj3;
        this.f2674f = arrayList3;
    }

    @Override // c1.g0, c1.f0
    public final void b() {
        r rVar = this.f2675g;
        Object obj = this.f2669a;
        if (obj != null) {
            rVar.u(obj, this.f2670b, null);
        }
        Object obj2 = this.f2671c;
        if (obj2 != null) {
            rVar.u(obj2, this.f2672d, null);
        }
        Object obj3 = this.f2673e;
        if (obj3 != null) {
            rVar.u(obj3, this.f2674f, null);
        }
    }

    @Override // c1.f0
    public final void d(Transition transition) {
        transition.v(this);
    }
}
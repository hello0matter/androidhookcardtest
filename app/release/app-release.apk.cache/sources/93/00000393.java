package c1;

import android.view.ViewGroup;
import androidx.transition.Transition;

/* loaded from: classes.dex */
public final class d extends g0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2592a = false;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2593b;

    public d(ViewGroup viewGroup) {
        this.f2593b = viewGroup;
    }

    @Override // c1.g0, c1.f0
    public final void a() {
        c0.a(this.f2593b, false);
        this.f2592a = true;
    }

    @Override // c1.g0, c1.f0
    public final void c() {
        c0.a(this.f2593b, false);
    }

    @Override // c1.f0
    public final void d(Transition transition) {
        if (!this.f2592a) {
            c0.a(this.f2593b, false);
        }
        transition.v(this);
    }

    @Override // c1.g0, c1.f0
    public final void e() {
        c0.a(this.f2593b, true);
    }
}
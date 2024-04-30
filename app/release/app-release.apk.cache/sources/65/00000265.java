package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

/* loaded from: classes.dex */
public final class e implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1678a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1679b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f1680c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f1681d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f1682e;

    public e(View view, ViewGroup viewGroup, h hVar, k kVar) {
        this.f1682e = kVar;
        this.f1679b = viewGroup;
        this.f1680c = view;
        this.f1681d = hVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        int i4 = this.f1678a;
        ViewGroup viewGroup = this.f1679b;
        switch (i4) {
            case 0:
                viewGroup.post(new x(1, this));
                return;
            default:
                viewGroup.post(new x(0, this));
                return;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }

    public e(ViewGroup viewGroup, t tVar, d0 d0Var, e0.c cVar) {
        this.f1679b = viewGroup;
        this.f1680c = tVar;
        this.f1681d = d0Var;
        this.f1682e = cVar;
    }
}
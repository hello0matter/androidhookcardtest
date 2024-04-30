package c1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.view.View;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2572a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f2573b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Rect f2574c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f2575d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f2576e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f2577f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f2578g;

    public c(View view, Rect rect, int i4, int i5, int i6, int i7) {
        this.f2573b = view;
        this.f2574c = rect;
        this.f2575d = i4;
        this.f2576e = i5;
        this.f2577f = i6;
        this.f2578g = i7;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f2572a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (!this.f2572a) {
            WeakHashMap weakHashMap = i0.y0.f4999a;
            View view = this.f2573b;
            i0.i0.c(view, this.f2574c);
            p0.a(view, this.f2575d, this.f2576e, this.f2577f, this.f2578g);
        }
    }
}
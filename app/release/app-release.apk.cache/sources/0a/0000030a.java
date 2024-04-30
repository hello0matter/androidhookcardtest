package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class n extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2191a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2192b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f2193c;

    public n(View view) {
        this.f2191a = 1;
        this.f2192b = false;
        this.f2193c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        switch (this.f2191a) {
            case 0:
                this.f2192b = true;
                return;
            default:
                super.onAnimationCancel(animator);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i4 = this.f2191a;
        float f4 = 1.0f;
        Object obj = this.f2193c;
        switch (i4) {
            case 0:
                if (this.f2192b) {
                    this.f2192b = false;
                    return;
                }
                p pVar = (p) obj;
                if (((Float) pVar.f2228z.getAnimatedValue()).floatValue() == 0.0f) {
                    pVar.A = 0;
                    pVar.g(0);
                    return;
                }
                pVar.A = 2;
                pVar.f2221s.invalidate();
                return;
            case 1:
                View view = (View) obj;
                c1.p0.b(view, 1.0f);
                if (this.f2192b) {
                    view.setLayerType(0, null);
                    return;
                }
                return;
            default:
                com.google.android.material.search.p pVar2 = (com.google.android.material.search.p) obj;
                if (!this.f2192b) {
                    f4 = 0.0f;
                }
                com.google.android.material.search.p.a(pVar2, f4);
                ClippableRoundedCornerLayout clippableRoundedCornerLayout = pVar2.f3797c;
                clippableRoundedCornerLayout.f3443a = null;
                clippableRoundedCornerLayout.f3444b = 0.0f;
                clippableRoundedCornerLayout.invalidate();
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        float f4;
        int i4 = this.f2191a;
        Object obj = this.f2193c;
        switch (i4) {
            case 1:
                View view = (View) obj;
                WeakHashMap weakHashMap = i0.y0.f4999a;
                if (i0.g0.h(view) && view.getLayerType() == 0) {
                    this.f2192b = true;
                    view.setLayerType(2, null);
                    return;
                }
                return;
            case 2:
                com.google.android.material.search.p pVar = (com.google.android.material.search.p) obj;
                if (this.f2192b) {
                    f4 = 0.0f;
                } else {
                    f4 = 1.0f;
                }
                com.google.android.material.search.p.a(pVar, f4);
                return;
            default:
                super.onAnimationStart(animator);
                return;
        }
    }

    public n(p pVar) {
        this.f2191a = 0;
        this.f2193c = pVar;
        this.f2192b = false;
    }

    public n(com.google.android.material.search.p pVar, boolean z4) {
        this.f2191a = 2;
        this.f2193c = pVar;
        this.f2192b = z4;
    }
}
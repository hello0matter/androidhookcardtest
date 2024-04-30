package androidx.fragment.app;

import android.animation.Animator;
import android.view.animation.Animation;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    public final Animation f1859a;

    /* renamed from: b  reason: collision with root package name */
    public final Animator f1860b;

    public z(Animator animator) {
        this.f1859a = null;
        this.f1860b = animator;
    }

    public z(Animation animation) {
        this.f1859a = animation;
        this.f1860b = null;
    }
}
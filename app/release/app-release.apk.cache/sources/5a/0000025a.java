package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* loaded from: classes.dex */
public final class a0 extends AnimationSet implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroup f1649a;

    /* renamed from: b  reason: collision with root package name */
    public final View f1650b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1651c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1652d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1653e;

    public a0(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.f1653e = true;
        this.f1649a = viewGroup;
        this.f1650b = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public final boolean getTransformation(long j4, Transformation transformation) {
        this.f1653e = true;
        if (this.f1651c) {
            return !this.f1652d;
        }
        if (!super.getTransformation(j4, transformation)) {
            this.f1651c = true;
            i0.z.a(this.f1649a, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z4 = this.f1651c;
        ViewGroup viewGroup = this.f1649a;
        if (z4 || !this.f1653e) {
            viewGroup.endViewTransition(this.f1650b);
            this.f1652d = true;
            return;
        }
        this.f1653e = false;
        viewGroup.post(this);
    }

    @Override // android.view.animation.Animation
    public final boolean getTransformation(long j4, Transformation transformation, float f4) {
        this.f1653e = true;
        if (this.f1651c) {
            return !this.f1652d;
        }
        if (!super.getTransformation(j4, transformation, f4)) {
            this.f1651c = true;
            i0.z.a(this.f1649a, this);
        }
        return true;
    }
}
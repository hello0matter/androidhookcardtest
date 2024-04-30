package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.i0;
import com.google.android.material.internal.n0;
import com.google.android.material.internal.y;
import com.google.android.material.internal.z;
import i0.h0;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final SearchView f3795a;

    /* renamed from: b  reason: collision with root package name */
    public final View f3796b;

    /* renamed from: c  reason: collision with root package name */
    public final ClippableRoundedCornerLayout f3797c;

    /* renamed from: d  reason: collision with root package name */
    public final FrameLayout f3798d;

    /* renamed from: e  reason: collision with root package name */
    public final FrameLayout f3799e;

    /* renamed from: f  reason: collision with root package name */
    public final MaterialToolbar f3800f;

    /* renamed from: g  reason: collision with root package name */
    public final Toolbar f3801g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f3802h;

    /* renamed from: i  reason: collision with root package name */
    public final EditText f3803i;

    /* renamed from: j  reason: collision with root package name */
    public final ImageButton f3804j;

    /* renamed from: k  reason: collision with root package name */
    public final View f3805k;

    /* renamed from: l  reason: collision with root package name */
    public final TouchObserverFrameLayout f3806l;

    /* renamed from: m  reason: collision with root package name */
    public final f2.i f3807m;

    /* renamed from: n  reason: collision with root package name */
    public AnimatorSet f3808n;

    /* renamed from: o  reason: collision with root package name */
    public SearchBar f3809o;

    public p(SearchView searchView) {
        this.f3795a = searchView;
        this.f3796b = searchView.f3742a;
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = searchView.f3743b;
        this.f3797c = clippableRoundedCornerLayout;
        this.f3798d = searchView.f3746e;
        this.f3799e = searchView.f3747f;
        this.f3800f = searchView.f3748g;
        this.f3801g = searchView.f3749h;
        this.f3802h = searchView.f3750i;
        this.f3803i = searchView.f3751j;
        this.f3804j = searchView.f3752k;
        this.f3805k = searchView.f3753l;
        this.f3806l = searchView.f3754m;
        this.f3807m = new f2.i(clippableRoundedCornerLayout);
    }

    public static void a(p pVar, float f4) {
        ActionMenuView a5;
        pVar.f3804j.setAlpha(f4);
        pVar.f3805k.setAlpha(f4);
        pVar.f3806l.setAlpha(f4);
        if (pVar.f3795a.f3764w && (a5 = i0.a(pVar.f3800f)) != null) {
            a5.setAlpha(f4);
        }
    }

    public final void b(AnimatorSet animatorSet) {
        ImageButton b5 = i0.b(this.f3800f);
        if (b5 == null) {
            return;
        }
        Drawable e22 = com.google.common.collect.c.e2(b5.getDrawable());
        if (this.f3795a.f3763v) {
            if (e22 instanceof d.d) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.addUpdateListener(new u1.b(3, (d.d) e22));
                animatorSet.playTogether(ofFloat);
            }
            if (e22 instanceof com.google.android.material.internal.f) {
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat2.addUpdateListener(new u1.b(4, (com.google.android.material.internal.f) e22));
                animatorSet.playTogether(ofFloat2);
                return;
            }
            return;
        }
        if (e22 instanceof d.d) {
            d.d dVar = (d.d) e22;
            if (dVar.f4246i != 1.0f) {
                dVar.f4246i = 1.0f;
                dVar.invalidateSelf();
            }
        }
        if (e22 instanceof com.google.android.material.internal.f) {
            ((com.google.android.material.internal.f) e22).a(1.0f);
        }
    }

    public final AnimatorSet c(boolean z4) {
        long j4;
        AnimatorSet animatorSet = new AnimatorSet();
        MaterialToolbar materialToolbar = this.f3800f;
        ImageButton b5 = i0.b(materialToolbar);
        if (b5 != null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f(b5), 0.0f);
            ofFloat.addUpdateListener(new com.google.android.material.internal.k(new i1.b(2), b5));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(g(), 0.0f);
            ofFloat2.addUpdateListener(com.google.android.material.internal.k.a(b5));
            animatorSet.playTogether(ofFloat, ofFloat2);
        }
        ActionMenuView a5 = i0.a(materialToolbar);
        if (a5 != null) {
            ValueAnimator ofFloat3 = ValueAnimator.ofFloat(e(a5), 0.0f);
            ofFloat3.addUpdateListener(new com.google.android.material.internal.k(new i1.b(2), a5));
            ValueAnimator ofFloat4 = ValueAnimator.ofFloat(g(), 0.0f);
            ofFloat4.addUpdateListener(com.google.android.material.internal.k.a(a5));
            animatorSet.playTogether(ofFloat3, ofFloat4);
        }
        if (z4) {
            j4 = 300;
        } else {
            j4 = 250;
        }
        animatorSet.setDuration(j4);
        animatorSet.setInterpolator(z.a(z4, p1.a.f6129b));
        return animatorSet;
    }

    public final AnimatorSet d(boolean z4) {
        Interpolator interpolator;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        long j13;
        AnimatorSet animatorSet = new AnimatorSet();
        if (this.f3808n == null) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            b(animatorSet2);
            if (z4) {
                j13 = 300;
            } else {
                j13 = 250;
            }
            animatorSet2.setDuration(j13);
            animatorSet2.setInterpolator(z.a(z4, p1.a.f6129b));
            animatorSet.playTogether(animatorSet2, c(z4));
        }
        Animator[] animatorArr = new Animator[9];
        if (z4) {
            interpolator = p1.a.f6128a;
        } else {
            interpolator = p1.a.f6129b;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        if (z4) {
            j4 = 300;
        } else {
            j4 = 250;
        }
        ofFloat.setDuration(j4);
        ofFloat.setInterpolator(z.a(z4, interpolator));
        ofFloat.addUpdateListener(new com.google.android.material.internal.k(new i1.b(5), this.f3796b));
        animatorArr[0] = ofFloat;
        f2.i iVar = this.f3807m;
        Rect rect = iVar.f4568j;
        Rect rect2 = iVar.f4569k;
        SearchView searchView = this.f3795a;
        if (rect == null) {
            rect = new Rect(searchView.getLeft(), searchView.getTop(), searchView.getRight(), searchView.getBottom());
        }
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = this.f3797c;
        if (rect2 == null) {
            rect2 = n0.a(clippableRoundedCornerLayout, this.f3809o);
        }
        final Rect rect3 = new Rect(rect2);
        final float cornerSize = this.f3809o.getCornerSize();
        final float max = Math.max(clippableRoundedCornerLayout.getCornerRadius(), iVar.c());
        ValueAnimator ofObject = ValueAnimator.ofObject(new y(rect3), rect2, rect);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                p pVar = p.this;
                pVar.getClass();
                float a5 = p1.a.a(cornerSize, max, valueAnimator.getAnimatedFraction());
                ClippableRoundedCornerLayout clippableRoundedCornerLayout2 = pVar.f3797c;
                clippableRoundedCornerLayout2.getClass();
                Rect rect4 = rect3;
                clippableRoundedCornerLayout2.a(rect4.left, rect4.top, rect4.right, rect4.bottom, a5);
            }
        });
        if (z4) {
            j5 = 300;
        } else {
            j5 = 250;
        }
        ofObject.setDuration(j5);
        u0.b bVar = p1.a.f6129b;
        ofObject.setInterpolator(z.a(z4, bVar));
        animatorArr[1] = ofObject;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        if (z4) {
            j6 = 50;
        } else {
            j6 = 42;
        }
        ofFloat2.setDuration(j6);
        if (z4) {
            j7 = 250;
        } else {
            j7 = 0;
        }
        ofFloat2.setStartDelay(j7);
        LinearInterpolator linearInterpolator = p1.a.f6128a;
        ofFloat2.setInterpolator(z.a(z4, linearInterpolator));
        ofFloat2.addUpdateListener(new com.google.android.material.internal.k(new i1.b(5), this.f3804j));
        animatorArr[2] = ofFloat2;
        AnimatorSet animatorSet3 = new AnimatorSet();
        Animator[] animatorArr2 = new Animator[3];
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        if (z4) {
            j8 = 150;
        } else {
            j8 = 83;
        }
        ofFloat3.setDuration(j8);
        if (z4) {
            j9 = 75;
        } else {
            j9 = 0;
        }
        ofFloat3.setStartDelay(j9);
        ofFloat3.setInterpolator(z.a(z4, linearInterpolator));
        View view = this.f3805k;
        TouchObserverFrameLayout touchObserverFrameLayout = this.f3806l;
        ofFloat3.addUpdateListener(new com.google.android.material.internal.k(new i1.b(5), view, touchObserverFrameLayout));
        animatorArr2[0] = ofFloat3;
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat((touchObserverFrameLayout.getHeight() * 0.050000012f) / 2.0f, 0.0f);
        if (z4) {
            j10 = 300;
        } else {
            j10 = 250;
        }
        ofFloat4.setDuration(j10);
        ofFloat4.setInterpolator(z.a(z4, bVar));
        ofFloat4.addUpdateListener(com.google.android.material.internal.k.a(view));
        animatorArr2[1] = ofFloat4;
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(0.95f, 1.0f);
        if (z4) {
            j11 = 300;
        } else {
            j11 = 250;
        }
        ofFloat5.setDuration(j11);
        ofFloat5.setInterpolator(z.a(z4, bVar));
        ofFloat5.addUpdateListener(new com.google.android.material.internal.k(new i1.b(4), touchObserverFrameLayout));
        animatorArr2[2] = ofFloat5;
        animatorSet3.playTogether(animatorArr2);
        animatorArr[3] = animatorSet3;
        animatorArr[4] = i(this.f3798d, z4, false);
        Toolbar toolbar = this.f3801g;
        animatorArr[5] = i(toolbar, z4, false);
        ValueAnimator ofFloat6 = ValueAnimator.ofFloat(0.0f, 1.0f);
        if (z4) {
            j12 = 300;
        } else {
            j12 = 250;
        }
        ofFloat6.setDuration(j12);
        ofFloat6.setInterpolator(z.a(z4, bVar));
        if (searchView.f3764w) {
            ofFloat6.addUpdateListener(new com.google.android.material.internal.g(i0.a(toolbar), i0.a(this.f3800f)));
        }
        animatorArr[6] = ofFloat6;
        animatorArr[7] = i(this.f3803i, z4, true);
        animatorArr[8] = i(this.f3802h, z4, true);
        animatorSet.playTogether(animatorArr);
        animatorSet.addListener(new androidx.recyclerview.widget.n(this, z4));
        return animatorSet;
    }

    public final int e(View view) {
        int b5 = i0.p.b((ViewGroup.MarginLayoutParams) view.getLayoutParams());
        if (n0.f(this.f3809o)) {
            return this.f3809o.getLeft() - b5;
        }
        return (this.f3809o.getRight() - this.f3795a.getWidth()) + b5;
    }

    public final int f(View view) {
        int c4 = i0.p.c((ViewGroup.MarginLayoutParams) view.getLayoutParams());
        SearchBar searchBar = this.f3809o;
        WeakHashMap weakHashMap = y0.f4999a;
        int f4 = h0.f(searchBar);
        if (n0.f(this.f3809o)) {
            return ((this.f3809o.getWidth() - this.f3809o.getRight()) + c4) - f4;
        }
        return (this.f3809o.getLeft() - c4) + f4;
    }

    public final int g() {
        FrameLayout frameLayout = this.f3799e;
        int top = frameLayout.getTop();
        return ((this.f3809o.getBottom() + this.f3809o.getTop()) / 2) - ((frameLayout.getBottom() + top) / 2);
    }

    public final AnimatorSet h(boolean z4) {
        long j4;
        AnimatorSet animatorSet = new AnimatorSet();
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = this.f3797c;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(clippableRoundedCornerLayout.getHeight(), 0.0f);
        ofFloat.addUpdateListener(com.google.android.material.internal.k.a(clippableRoundedCornerLayout));
        animatorSet.playTogether(ofFloat);
        b(animatorSet);
        animatorSet.setInterpolator(z.a(z4, p1.a.f6129b));
        if (z4) {
            j4 = 350;
        } else {
            j4 = 300;
        }
        animatorSet.setDuration(j4);
        return animatorSet;
    }

    public final AnimatorSet i(View view, boolean z4, boolean z5) {
        int e4;
        long j4;
        if (z5) {
            e4 = f(view);
        } else {
            e4 = e(view);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(e4, 0.0f);
        ofFloat.addUpdateListener(new com.google.android.material.internal.k(new i1.b(2), view));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(g(), 0.0f);
        ofFloat2.addUpdateListener(com.google.android.material.internal.k.a(view));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        if (z4) {
            j4 = 300;
        } else {
            j4 = 250;
        }
        animatorSet.setDuration(j4);
        animatorSet.setInterpolator(z.a(z4, p1.a.f6129b));
        return animatorSet;
    }

    public final AnimatorSet j() {
        SearchBar searchBar = this.f3809o;
        SearchView searchView = this.f3795a;
        if (searchBar != null) {
            if (searchView.h()) {
                searchView.f();
            }
            AnimatorSet d4 = d(false);
            d4.addListener(new m(this));
            d4.start();
            return d4;
        }
        if (searchView.h()) {
            searchView.f();
        }
        AnimatorSet h4 = h(false);
        h4.addListener(new o(this));
        h4.start();
        return h4;
    }
}
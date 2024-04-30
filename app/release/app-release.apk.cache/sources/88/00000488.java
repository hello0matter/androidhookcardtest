package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.appcompat.app.o0;
import androidx.appcompat.app.u0;
import java.util.Iterator;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2949a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f2950b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f2951c;

    public /* synthetic */ a(int i4, Object obj, Object obj2) {
        this.f2949a = i4;
        this.f2950b = obj;
        this.f2951c = obj2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i4 = this.f2949a;
        Object obj = this.f2951c;
        Object obj2 = this.f2950b;
        switch (i4) {
            case 0:
                AppBarLayout appBarLayout = (AppBarLayout) obj2;
                int i5 = AppBarLayout.f2867y;
                appBarLayout.getClass();
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ((l2.j) obj).n(floatValue);
                Drawable drawable = appBarLayout.f2889v;
                if (drawable instanceof l2.j) {
                    ((l2.j) drawable).n(floatValue);
                }
                Iterator it = appBarLayout.f2885r.iterator();
                if (!it.hasNext()) {
                    return;
                }
                androidx.activity.j.f(it.next());
                throw null;
            case 1:
                AppBarLayout appBarLayout2 = (AppBarLayout) obj2;
                l2.j jVar = (l2.j) obj;
                int i6 = AppBarLayout.f2867y;
                appBarLayout2.getClass();
                int floatValue2 = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                jVar.setAlpha(floatValue2);
                Iterator it2 = appBarLayout2.f2885r.iterator();
                while (it2.hasNext()) {
                    androidx.activity.j.f(it2.next());
                    ColorStateList colorStateList = jVar.f5310a.f5290c;
                    if (colorStateList != null) {
                        colorStateList.withAlpha(floatValue2).getDefaultColor();
                        throw null;
                    }
                }
                return;
            default:
                ((View) ((u0) ((o0) obj2).f311b).f347d.getParent()).invalidate();
                return;
        }
    }
}
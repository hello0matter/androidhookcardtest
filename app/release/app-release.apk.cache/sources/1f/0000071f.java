package h2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class j extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4850a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f4851b;

    public /* synthetic */ j(k kVar, int i4) {
        this.f4850a = i4;
        this.f4851b = kVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f4850a) {
            case 1:
                super.onAnimationEnd(animator);
                k kVar = this.f4851b;
                k.a(kVar);
                ArrayList arrayList = kVar.f4858f;
                if (arrayList != null && !kVar.f4859g) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((d1.c) it.next()).a(kVar);
                    }
                    return;
                }
                return;
            default:
                super.onAnimationEnd(animator);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f4850a) {
            case 0:
                super.onAnimationStart(animator);
                k kVar = this.f4851b;
                ArrayList arrayList = kVar.f4858f;
                if (arrayList != null && !kVar.f4859g) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((d1.c) it.next()).b(kVar);
                    }
                    return;
                }
                return;
            default:
                super.onAnimationStart(animator);
                return;
        }
    }
}
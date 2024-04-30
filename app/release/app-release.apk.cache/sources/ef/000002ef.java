package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2078a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f2079b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f2080c;

    public /* synthetic */ e(k kVar, ArrayList arrayList, int i4) {
        this.f2078a = i4;
        this.f2080c = kVar;
        this.f2079b = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View view;
        View view2;
        long j4;
        char c4;
        int i4 = this.f2078a;
        k kVar = this.f2080c;
        ArrayList arrayList = this.f2079b;
        switch (i4) {
            case 0:
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    j jVar = (j) it.next();
                    l1 l1Var = jVar.f2140a;
                    kVar.getClass();
                    View view3 = l1Var.f2170a;
                    int i5 = jVar.f2143d - jVar.f2141b;
                    int i6 = jVar.f2144e - jVar.f2142c;
                    if (i5 != 0) {
                        view3.animate().translationX(0.0f);
                    }
                    if (i6 != 0) {
                        view3.animate().translationY(0.0f);
                    }
                    ViewPropertyAnimator animate = view3.animate();
                    kVar.f2157p.add(l1Var);
                    animate.setDuration(kVar.f2233e).setListener(new g(kVar, l1Var, i5, view3, i6, animate)).start();
                }
                arrayList.clear();
                kVar.f2154m.remove(arrayList);
                return;
            case 1:
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    i iVar = (i) it2.next();
                    kVar.getClass();
                    l1 l1Var2 = iVar.f2119a;
                    if (l1Var2 == null) {
                        view = null;
                    } else {
                        view = l1Var2.f2170a;
                    }
                    l1 l1Var3 = iVar.f2120b;
                    if (l1Var3 != null) {
                        view2 = l1Var3.f2170a;
                    } else {
                        view2 = null;
                    }
                    ArrayList arrayList2 = kVar.f2159r;
                    long j5 = kVar.f2234f;
                    if (view != null) {
                        ViewPropertyAnimator duration = view.animate().setDuration(j5);
                        arrayList2.add(iVar.f2119a);
                        duration.translationX(iVar.f2123e - iVar.f2121c);
                        duration.translationY(iVar.f2124f - iVar.f2122d);
                        j4 = j5;
                        duration.alpha(0.0f).setListener(new h(kVar, iVar, duration, view, 0)).start();
                    } else {
                        j4 = j5;
                    }
                    if (view2 != null) {
                        ViewPropertyAnimator animate2 = view2.animate();
                        arrayList2.add(iVar.f2120b);
                        c4 = 0;
                        animate2.translationX(0.0f).translationY(0.0f).setDuration(j4).alpha(1.0f).setListener(new h(kVar, iVar, animate2, view2, 1)).start();
                    } else {
                        c4 = 0;
                    }
                }
                arrayList.clear();
                kVar.f2155n.remove(arrayList);
                return;
            default:
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    l1 l1Var4 = (l1) it3.next();
                    kVar.getClass();
                    View view4 = l1Var4.f2170a;
                    ViewPropertyAnimator animate3 = view4.animate();
                    kVar.f2156o.add(l1Var4);
                    animate3.alpha(1.0f).setDuration(kVar.f2231c).setListener(new f(kVar, l1Var4, view4, animate3, 1)).start();
                }
                arrayList.clear();
                kVar.f2153l.remove(arrayList);
                return;
        }
    }
}
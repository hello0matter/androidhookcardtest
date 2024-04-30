package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class g0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f2105a;

    public /* synthetic */ g0(RecyclerView recyclerView) {
        this.f2105a = recyclerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList;
        long j4;
        long j5;
        RecyclerView recyclerView = this.f2105a;
        p0 p0Var = recyclerView.I;
        if (p0Var != null) {
            k kVar = (k) p0Var;
            ArrayList arrayList2 = kVar.f2149h;
            boolean z4 = !arrayList2.isEmpty();
            ArrayList arrayList3 = kVar.f2151j;
            boolean z5 = !arrayList3.isEmpty();
            ArrayList arrayList4 = kVar.f2152k;
            boolean z6 = !arrayList4.isEmpty();
            ArrayList arrayList5 = kVar.f2150i;
            boolean z7 = !arrayList5.isEmpty();
            if (z4 || z5 || z7 || z6) {
                Iterator it = arrayList2.iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    arrayList = arrayList3;
                    j4 = kVar.f2232d;
                    if (!hasNext) {
                        break;
                    }
                    l1 l1Var = (l1) it.next();
                    View view = l1Var.f2170a;
                    ViewPropertyAnimator animate = view.animate();
                    kVar.f2158q.add(l1Var);
                    animate.setDuration(j4).alpha(0.0f).setListener(new f(kVar, l1Var, animate, view)).start();
                    arrayList3 = arrayList;
                }
                arrayList2.clear();
                if (z5) {
                    ArrayList arrayList6 = new ArrayList();
                    arrayList6.addAll(arrayList);
                    kVar.f2154m.add(arrayList6);
                    arrayList.clear();
                    e eVar = new e(kVar, arrayList6, 0);
                    if (z4) {
                        View view2 = ((j) arrayList6.get(0)).f2140a.f2170a;
                        WeakHashMap weakHashMap = i0.y0.f4999a;
                        i0.g0.n(view2, eVar, j4);
                    } else {
                        eVar.run();
                    }
                }
                if (z6) {
                    ArrayList arrayList7 = new ArrayList();
                    arrayList7.addAll(arrayList4);
                    kVar.f2155n.add(arrayList7);
                    arrayList4.clear();
                    e eVar2 = new e(kVar, arrayList7, 1);
                    if (z4) {
                        View view3 = ((i) arrayList7.get(0)).f2119a.f2170a;
                        WeakHashMap weakHashMap2 = i0.y0.f4999a;
                        i0.g0.n(view3, eVar2, j4);
                    } else {
                        eVar2.run();
                    }
                }
                if (z7) {
                    ArrayList arrayList8 = new ArrayList();
                    arrayList8.addAll(arrayList5);
                    kVar.f2153l.add(arrayList8);
                    arrayList5.clear();
                    e eVar3 = new e(kVar, arrayList8, 2);
                    if (!z4 && !z5 && !z6) {
                        eVar3.run();
                    } else {
                        long j6 = 0;
                        if (!z4) {
                            j4 = 0;
                        }
                        if (z5) {
                            j5 = kVar.f2233e;
                        } else {
                            j5 = 0;
                        }
                        if (z6) {
                            j6 = kVar.f2234f;
                        }
                        View view4 = ((l1) arrayList8.get(0)).f2170a;
                        WeakHashMap weakHashMap3 = i0.y0.f4999a;
                        i0.g0.n(view4, eVar3, Math.max(j5, j6) + j4);
                    }
                }
            }
        }
        recyclerView.f1985j0 = false;
    }
}
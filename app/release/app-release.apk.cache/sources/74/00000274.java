package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class k extends g1 {
    public static void i(View view, ArrayList arrayList) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i0.c1.b(viewGroup)) {
                if (!arrayList.contains(view)) {
                    arrayList.add(viewGroup);
                    return;
                }
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = viewGroup.getChildAt(i4);
                if (childAt.getVisibility() == 0) {
                    i(childAt, arrayList);
                }
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    public static void j(l.b bVar, View view) {
        WeakHashMap weakHashMap = i0.y0.f4999a;
        String k4 = i0.m0.k(view);
        if (k4 != null) {
            bVar.put(k4, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = viewGroup.getChildAt(i4);
                if (childAt.getVisibility() == 0) {
                    j(bVar, childAt);
                }
            }
        }
    }

    public static void k(l.b bVar, Collection collection) {
        Iterator it = ((l.h) bVar.entrySet()).iterator();
        while (it.hasNext()) {
            WeakHashMap weakHashMap = i0.y0.f4999a;
            if (!collection.contains(i0.m0.k((View) ((Map.Entry) it.next()).getValue()))) {
                it.remove();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0464  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0488  */
    /* JADX WARN: Type inference failed for: r13v13, types: [l.b, java.util.Map, l.k] */
    /* JADX WARN: Type inference failed for: r13v23, types: [java.lang.Object, androidx.fragment.app.h, androidx.fragment.app.i] */
    /* JADX WARN: Type inference failed for: r2v55, types: [java.lang.Object, e0.c] */
    /* JADX WARN: Type inference failed for: r2v56, types: [java.lang.Object, e0.c] */
    /* JADX WARN: Type inference failed for: r5v35, types: [e0.b, p.d, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v19, types: [l.b, java.util.Map, l.k] */
    @Override // androidx.fragment.app.g1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(java.util.ArrayList r36, boolean r37) {
        /*
            Method dump skipped, instructions count: 1693
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.k.b(java.util.ArrayList, boolean):void");
    }
}
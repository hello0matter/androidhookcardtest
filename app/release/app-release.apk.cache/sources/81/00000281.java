package androidx.fragment.app;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class q0 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f1775a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap f1776b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public n0 f1777c;

    public final void a(t tVar) {
        if (this.f1775a.contains(tVar)) {
            throw new IllegalStateException("Fragment already added: " + tVar);
        }
        synchronized (this.f1775a) {
            this.f1775a.add(tVar);
        }
        tVar.f1811k = true;
    }

    public final t b(String str) {
        p0 p0Var = (p0) this.f1776b.get(str);
        if (p0Var != null) {
            return p0Var.f1771c;
        }
        return null;
    }

    public final t c(String str) {
        for (p0 p0Var : this.f1776b.values()) {
            if (p0Var != null) {
                t tVar = p0Var.f1771c;
                if (!str.equals(tVar.f1805e)) {
                    tVar = tVar.f1820t.f1725c.c(str);
                }
                if (tVar != null) {
                    return tVar;
                }
            }
        }
        return null;
    }

    public final ArrayList d() {
        ArrayList arrayList = new ArrayList();
        for (p0 p0Var : this.f1776b.values()) {
            if (p0Var != null) {
                arrayList.add(p0Var);
            }
        }
        return arrayList;
    }

    public final ArrayList e() {
        t tVar;
        ArrayList arrayList = new ArrayList();
        for (p0 p0Var : this.f1776b.values()) {
            if (p0Var != null) {
                tVar = p0Var.f1771c;
            } else {
                tVar = null;
            }
            arrayList.add(tVar);
        }
        return arrayList;
    }

    public final List f() {
        ArrayList arrayList;
        if (this.f1775a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f1775a) {
            arrayList = new ArrayList(this.f1775a);
        }
        return arrayList;
    }

    public final void g(p0 p0Var) {
        t tVar = p0Var.f1771c;
        String str = tVar.f1805e;
        HashMap hashMap = this.f1776b;
        if (hashMap.get(str) != null) {
            return;
        }
        hashMap.put(tVar.f1805e, p0Var);
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Added fragment to active set " + tVar);
        }
    }

    public final void h(p0 p0Var) {
        t tVar = p0Var.f1771c;
        if (tVar.A) {
            this.f1777c.b(tVar);
        }
        if (((p0) this.f1776b.put(tVar.f1805e, null)) != null && Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + tVar);
        }
    }
}
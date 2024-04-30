package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.o0;
import androidx.fragment.app.d0;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f139a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap f140b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap f141c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f142d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public final transient HashMap f143e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public final HashMap f144f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public final Bundle f145g = new Bundle();

    public final boolean a(int i4, int i5, Intent intent) {
        b bVar;
        String str = (String) this.f139a.get(Integer.valueOf(i4));
        if (str == null) {
            return false;
        }
        d dVar = (d) this.f143e.get(str);
        if (dVar != null && (bVar = dVar.f135a) != null && this.f142d.contains(str)) {
            bVar.k(dVar.f136b.z1(intent, i5));
            this.f142d.remove(str);
            return true;
        }
        this.f144f.remove(str);
        this.f145g.putParcelable(str, new ActivityResult(intent, i5));
        return true;
    }

    public abstract void b(int i4, com.google.common.collect.c cVar, Intent intent);

    public final c c(final String str, q qVar, final b.b bVar, final o0 o0Var) {
        s f4 = qVar.f();
        if (f4.f1915c.compareTo(Lifecycle$State.f1867d) < 0) {
            e(str);
            HashMap hashMap = this.f141c;
            e eVar = (e) hashMap.get(str);
            if (eVar == null) {
                eVar = new e(f4);
            }
            o oVar = new o() { // from class: androidx.activity.result.ActivityResultRegistry$1
                @Override // androidx.lifecycle.o
                public final void b(q qVar2, Lifecycle$Event lifecycle$Event) {
                    boolean equals = Lifecycle$Event.ON_START.equals(lifecycle$Event);
                    String str2 = str;
                    f fVar = f.this;
                    if (!equals) {
                        if (Lifecycle$Event.ON_STOP.equals(lifecycle$Event)) {
                            fVar.f143e.remove(str2);
                            return;
                        } else if (Lifecycle$Event.ON_DESTROY.equals(lifecycle$Event)) {
                            fVar.f(str2);
                            return;
                        } else {
                            return;
                        }
                    }
                    HashMap hashMap2 = fVar.f143e;
                    b bVar2 = o0Var;
                    com.google.common.collect.c cVar = bVar;
                    hashMap2.put(str2, new d(bVar2, cVar));
                    HashMap hashMap3 = fVar.f144f;
                    if (hashMap3.containsKey(str2)) {
                        Object obj = hashMap3.get(str2);
                        hashMap3.remove(str2);
                        bVar2.k(obj);
                    }
                    Bundle bundle = fVar.f145g;
                    ActivityResult activityResult = (ActivityResult) bundle.getParcelable(str2);
                    if (activityResult != null) {
                        bundle.remove(str2);
                        bVar2.k(cVar.z1(activityResult.f121b, activityResult.f120a));
                    }
                }
            };
            eVar.f137a.a(oVar);
            eVar.f138b.add(oVar);
            hashMap.put(str, eVar);
            return new c(this, str, bVar, 0);
        }
        throw new IllegalStateException("LifecycleOwner " + qVar + " is attempting to register while current state is " + f4.f1915c + ". LifecycleOwners must call register before they are STARTED.");
    }

    public final c d(String str, com.google.common.collect.c cVar, d0 d0Var) {
        e(str);
        this.f143e.put(str, new d(d0Var, cVar));
        HashMap hashMap = this.f144f;
        if (hashMap.containsKey(str)) {
            Object obj = hashMap.get(str);
            hashMap.remove(str);
            d0Var.k(obj);
        }
        Bundle bundle = this.f145g;
        ActivityResult activityResult = (ActivityResult) bundle.getParcelable(str);
        if (activityResult != null) {
            bundle.remove(str);
            d0Var.k(cVar.z1(activityResult.f121b, activityResult.f120a));
        }
        return new c(this, str, cVar, 1);
    }

    public final void e(String str) {
        HashMap hashMap = this.f140b;
        if (((Integer) hashMap.get(str)) != null) {
            return;
        }
        g3.d.f4790a.getClass();
        int nextInt = g3.d.f4791b.a().nextInt(2147418112);
        while (true) {
            int i4 = nextInt + 65536;
            HashMap hashMap2 = this.f139a;
            if (hashMap2.containsKey(Integer.valueOf(i4))) {
                g3.d.f4790a.getClass();
                nextInt = g3.d.f4791b.a().nextInt(2147418112);
            } else {
                hashMap2.put(Integer.valueOf(i4), str);
                hashMap.put(str, Integer.valueOf(i4));
                return;
            }
        }
    }

    public final void f(String str) {
        Integer num;
        if (!this.f142d.contains(str) && (num = (Integer) this.f140b.remove(str)) != null) {
            this.f139a.remove(num);
        }
        this.f143e.remove(str);
        HashMap hashMap = this.f144f;
        if (hashMap.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + hashMap.get(str));
            hashMap.remove(str);
        }
        Bundle bundle = this.f145g;
        if (bundle.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + bundle.getParcelable(str));
            bundle.remove(str);
        }
        HashMap hashMap2 = this.f141c;
        e eVar = (e) hashMap2.get(str);
        if (eVar != null) {
            ArrayList arrayList = eVar.f138b;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                eVar.f137a.b((o) it.next());
            }
            arrayList.clear();
            hashMap2.remove(str);
        }
    }
}
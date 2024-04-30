package androidx.lifecycle;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class s extends l {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1913a;

    /* renamed from: b  reason: collision with root package name */
    public i.a f1914b;

    /* renamed from: c  reason: collision with root package name */
    public Lifecycle$State f1915c;

    /* renamed from: d  reason: collision with root package name */
    public final WeakReference f1916d;

    /* renamed from: e  reason: collision with root package name */
    public int f1917e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1918f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1919g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f1920h;

    public s(q qVar) {
        com.google.common.collect.c.F(qVar, "provider");
        new AtomicReference();
        this.f1913a = true;
        this.f1914b = new i.a();
        this.f1915c = Lifecycle$State.f1865b;
        this.f1920h = new ArrayList();
        this.f1916d = new WeakReference(qVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.lifecycle.r, java.lang.Object] */
    @Override // androidx.lifecycle.l
    public final void a(p pVar) {
        o reflectiveGenericLifecycleObserver;
        q qVar;
        com.google.common.collect.c.F(pVar, "observer");
        d("addObserver");
        Lifecycle$State lifecycle$State = this.f1915c;
        Lifecycle$State lifecycle$State2 = Lifecycle$State.f1864a;
        if (lifecycle$State != lifecycle$State2) {
            lifecycle$State2 = Lifecycle$State.f1865b;
        }
        ?? obj = new Object();
        HashMap hashMap = t.f1921a;
        boolean z4 = pVar instanceof o;
        boolean z5 = pVar instanceof d;
        boolean z6 = false;
        if (z4 && z5) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((d) pVar, (o) pVar);
        } else if (z5) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((d) pVar, null);
        } else if (z4) {
            reflectiveGenericLifecycleObserver = (o) pVar;
        } else {
            Class<?> cls = pVar.getClass();
            if (t.b(cls) == 2) {
                Object obj2 = t.f1922b.get(cls);
                com.google.common.collect.c.C(obj2);
                List list = (List) obj2;
                if (list.size() != 1) {
                    int size = list.size();
                    g[] gVarArr = new g[size];
                    if (size <= 0) {
                        reflectiveGenericLifecycleObserver = new CompositeGeneratedAdaptersObserver(gVarArr);
                    } else {
                        t.a((Constructor) list.get(0), pVar);
                        throw null;
                    }
                } else {
                    t.a((Constructor) list.get(0), pVar);
                    throw null;
                }
            } else {
                reflectiveGenericLifecycleObserver = new ReflectiveGenericLifecycleObserver(pVar);
            }
        }
        obj.f1912b = reflectiveGenericLifecycleObserver;
        obj.f1911a = lifecycle$State2;
        if (((r) this.f1914b.c(pVar, obj)) != null || (qVar = (q) this.f1916d.get()) == null) {
            return;
        }
        if (this.f1917e != 0 || this.f1918f) {
            z6 = true;
        }
        Lifecycle$State c4 = c(pVar);
        this.f1917e++;
        while (obj.f1911a.compareTo(c4) < 0 && this.f1914b.f4891e.containsKey(pVar)) {
            this.f1920h.add(obj.f1911a);
            j jVar = Lifecycle$Event.Companion;
            Lifecycle$State lifecycle$State3 = obj.f1911a;
            jVar.getClass();
            Lifecycle$Event a5 = j.a(lifecycle$State3);
            if (a5 != null) {
                obj.a(qVar, a5);
                ArrayList arrayList = this.f1920h;
                arrayList.remove(arrayList.size() - 1);
                c4 = c(pVar);
            } else {
                throw new IllegalStateException("no event up from " + obj.f1911a);
            }
        }
        if (!z6) {
            h();
        }
        this.f1917e--;
    }

    @Override // androidx.lifecycle.l
    public final void b(p pVar) {
        com.google.common.collect.c.F(pVar, "observer");
        d("removeObserver");
        this.f1914b.b(pVar);
    }

    public final Lifecycle$State c(p pVar) {
        i.c cVar;
        Lifecycle$State lifecycle$State;
        r rVar;
        HashMap hashMap = this.f1914b.f4891e;
        Lifecycle$State lifecycle$State2 = null;
        if (hashMap.containsKey(pVar)) {
            cVar = ((i.c) hashMap.get(pVar)).f4896d;
        } else {
            cVar = null;
        }
        if (cVar != null && (rVar = (r) cVar.f4894b) != null) {
            lifecycle$State = rVar.f1911a;
        } else {
            lifecycle$State = null;
        }
        ArrayList arrayList = this.f1920h;
        if (!arrayList.isEmpty()) {
            lifecycle$State2 = (Lifecycle$State) arrayList.get(arrayList.size() - 1);
        }
        Lifecycle$State lifecycle$State3 = this.f1915c;
        com.google.common.collect.c.F(lifecycle$State3, "state1");
        if (lifecycle$State == null || lifecycle$State.compareTo(lifecycle$State3) >= 0) {
            lifecycle$State = lifecycle$State3;
        }
        if (lifecycle$State2 == null || lifecycle$State2.compareTo(lifecycle$State) >= 0) {
            return lifecycle$State;
        }
        return lifecycle$State2;
    }

    public final void d(String str) {
        if (this.f1913a) {
            h.b.a().f4794a.getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(androidx.activity.j.d("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void e(Lifecycle$Event lifecycle$Event) {
        com.google.common.collect.c.F(lifecycle$Event, "event");
        d("handleLifecycleEvent");
        f(lifecycle$Event.a());
    }

    public final void f(Lifecycle$State lifecycle$State) {
        Lifecycle$State lifecycle$State2 = this.f1915c;
        if (lifecycle$State2 == lifecycle$State) {
            return;
        }
        Lifecycle$State lifecycle$State3 = Lifecycle$State.f1865b;
        Lifecycle$State lifecycle$State4 = Lifecycle$State.f1864a;
        if (lifecycle$State2 == lifecycle$State3 && lifecycle$State == lifecycle$State4) {
            throw new IllegalStateException(("no event down from " + this.f1915c + " in component " + this.f1916d.get()).toString());
        }
        this.f1915c = lifecycle$State;
        if (this.f1918f || this.f1917e != 0) {
            this.f1919g = true;
            return;
        }
        this.f1918f = true;
        h();
        this.f1918f = false;
        if (this.f1915c == lifecycle$State4) {
            this.f1914b = new i.a();
        }
    }

    public final void g() {
        Lifecycle$State lifecycle$State = Lifecycle$State.f1866c;
        d("setCurrentState");
        f(lifecycle$State);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
        r8.f1919g = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void h() {
        /*
            Method dump skipped, instructions count: 389
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.s.h():void");
    }
}
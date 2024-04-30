package androidx.lifecycle;

import java.util.HashMap;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
@Deprecated
/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements o {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1870a;

    /* renamed from: b  reason: collision with root package name */
    public final a f1871b;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f1870a = obj;
        c cVar = c.f1892c;
        Class<?> cls = obj.getClass();
        a aVar = (a) cVar.f1893a.get(cls);
        this.f1871b = aVar == null ? cVar.a(cls, null) : aVar;
    }

    @Override // androidx.lifecycle.o
    public final void b(q qVar, Lifecycle$Event lifecycle$Event) {
        HashMap hashMap = this.f1871b.f1878a;
        Object obj = this.f1870a;
        a.a((List) hashMap.get(lifecycle$Event), qVar, lifecycle$Event, obj);
        a.a((List) hashMap.get(Lifecycle$Event.ON_ANY), qVar, lifecycle$Event, obj);
    }
}
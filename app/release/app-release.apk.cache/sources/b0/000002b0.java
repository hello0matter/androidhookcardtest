package androidx.lifecycle;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class f0 implements z0.c {

    /* renamed from: a  reason: collision with root package name */
    public final z0.d f1899a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1900b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f1901c;

    /* renamed from: d  reason: collision with root package name */
    public final x2.a f1902d;

    public f0(z0.d dVar, final l0 l0Var) {
        com.google.common.collect.c.F(dVar, "savedStateRegistry");
        com.google.common.collect.c.F(l0Var, "viewModelStoreOwner");
        this.f1899a = dVar;
        this.f1902d = kotlin.a.b(new e3.a() { // from class: androidx.lifecycle.SavedStateHandlesProvider$viewModel$2
            @Override // e3.a
            public final Object a() {
                v0.b bVar;
                l0 l0Var2 = l0.this;
                com.google.common.collect.c.F(l0Var2, "<this>");
                ArrayList arrayList = new ArrayList();
                SavedStateHandleSupport$savedStateHandlesVM$1$1 savedStateHandleSupport$savedStateHandlesVM$1$1 = new e3.l() { // from class: androidx.lifecycle.SavedStateHandleSupport$savedStateHandlesVM$1$1
                    @Override // e3.l
                    public final Object c(Object obj) {
                        com.google.common.collect.c.F((v0.b) obj, "$this$initializer");
                        return new g0();
                    }
                };
                f3.e.f4578a.getClass();
                f3.b bVar2 = new f3.b(g0.class);
                com.google.common.collect.c.F(savedStateHandleSupport$savedStateHandlesVM$1$1, "initializer");
                Class a5 = bVar2.a();
                com.google.common.collect.c.D(a5, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
                arrayList.add(new v0.e(a5, savedStateHandleSupport$savedStateHandlesVM$1$1));
                v0.e[] eVarArr = (v0.e[]) arrayList.toArray(new v0.e[0]);
                v0.c cVar = new v0.c((v0.e[]) Arrays.copyOf(eVarArr, eVarArr.length));
                k0 e4 = l0Var2.e();
                if (l0Var2 instanceof h) {
                    bVar = ((h) l0Var2).a();
                } else {
                    bVar = v0.a.f6946b;
                }
                return (g0) new androidx.appcompat.app.c(e4, (j0) cVar, bVar).k(g0.class, "androidx.lifecycle.internal.SavedStateHandlesVM");
            }
        });
    }

    @Override // z0.c
    public final Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1901c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        Iterator it = ((g0) this.f1902d.getValue()).f1903c.entrySet().iterator();
        if (!it.hasNext()) {
            this.f1900b = false;
            return bundle;
        }
        Map.Entry entry = (Map.Entry) it.next();
        String str = (String) entry.getKey();
        androidx.activity.j.f(entry.getValue());
        throw null;
    }
}
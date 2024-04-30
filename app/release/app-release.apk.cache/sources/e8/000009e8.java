package v0;

import androidx.lifecycle.h0;
import androidx.lifecycle.j0;

/* loaded from: classes.dex */
public final class c implements j0 {

    /* renamed from: b  reason: collision with root package name */
    public final e[] f6948b;

    public c(e... eVarArr) {
        com.google.common.collect.c.F(eVarArr, "initializers");
        this.f6948b = eVarArr;
    }

    @Override // androidx.lifecycle.j0
    public final h0 b(Class cls, d dVar) {
        e[] eVarArr;
        h0 h0Var = null;
        for (e eVar : this.f6948b) {
            if (com.google.common.collect.c.n(eVar.f6949a, cls)) {
                Object c4 = eVar.f6950b.c(dVar);
                if (c4 instanceof h0) {
                    h0Var = (h0) c4;
                } else {
                    h0Var = null;
                }
            }
        }
        if (h0Var != null) {
            return h0Var;
        }
        throw new IllegalArgumentException("No initializer set for given class ".concat(cls.getName()));
    }
}
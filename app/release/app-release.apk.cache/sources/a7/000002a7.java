package androidx.lifecycle;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f1881a;

    /* renamed from: b  reason: collision with root package name */
    public final Method f1882b;

    public b(int i4, Method method) {
        this.f1881a = i4;
        this.f1882b = method;
        method.setAccessible(true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.f1881a == bVar.f1881a && this.f1882b.getName().equals(bVar.f1882b.getName());
        }
        return false;
    }

    public final int hashCode() {
        return this.f1882b.getName().hashCode() + (this.f1881a * 31);
    }
}
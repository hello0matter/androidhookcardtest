package i;

import java.util.HashMap;

/* loaded from: classes.dex */
public final class a extends g {

    /* renamed from: e  reason: collision with root package name */
    public final HashMap f4891e = new HashMap();

    @Override // i.g
    public final c a(Object obj) {
        return (c) this.f4891e.get(obj);
    }

    @Override // i.g
    public final Object b(Object obj) {
        Object b5 = super.b(obj);
        this.f4891e.remove(obj);
        return b5;
    }

    public final Object c(Object obj, Object obj2) {
        c a5 = a(obj);
        if (a5 != null) {
            return a5.f4894b;
        }
        HashMap hashMap = this.f4891e;
        c cVar = new c(obj, obj2);
        this.f4905d++;
        c cVar2 = this.f4903b;
        if (cVar2 == null) {
            this.f4902a = cVar;
        } else {
            cVar2.f4895c = cVar;
            cVar.f4896d = cVar2;
        }
        this.f4903b = cVar;
        hashMap.put(obj, cVar);
        return null;
    }
}
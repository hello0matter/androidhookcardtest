package i;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class d extends f implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    public c f4897a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4898b = true;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f4899c;

    public d(g gVar) {
        this.f4899c = gVar;
    }

    @Override // i.f
    public final void a(c cVar) {
        boolean z4;
        c cVar2 = this.f4897a;
        if (cVar == cVar2) {
            c cVar3 = cVar2.f4896d;
            this.f4897a = cVar3;
            if (cVar3 == null) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.f4898b = z4;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f4898b) {
            if (this.f4899c.f4902a == null) {
                return false;
            }
            return true;
        }
        c cVar = this.f4897a;
        if (cVar == null || cVar.f4895c == null) {
            return false;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        c cVar;
        if (this.f4898b) {
            this.f4898b = false;
            cVar = this.f4899c.f4902a;
        } else {
            c cVar2 = this.f4897a;
            if (cVar2 != null) {
                cVar = cVar2.f4895c;
            } else {
                cVar = null;
            }
        }
        this.f4897a = cVar;
        return this.f4897a;
    }
}
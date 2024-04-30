package i;

import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class e extends f implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    public c f4900a;

    /* renamed from: b  reason: collision with root package name */
    public c f4901b;

    @Override // i.f
    public final void a(c cVar) {
        c cVar2;
        c cVar3;
        c cVar4 = null;
        if (this.f4900a == cVar && cVar == this.f4901b) {
            this.f4901b = null;
            this.f4900a = null;
        }
        c cVar5 = this.f4900a;
        if (cVar5 == cVar) {
            switch (((b) this).f4892c) {
                case 0:
                    cVar3 = cVar5.f4896d;
                    break;
                default:
                    cVar3 = cVar5.f4895c;
                    break;
            }
            this.f4900a = cVar3;
        }
        c cVar6 = this.f4901b;
        if (cVar6 == cVar) {
            c cVar7 = this.f4900a;
            if (cVar6 != cVar7 && cVar7 != null) {
                switch (((b) this).f4892c) {
                    case 0:
                        cVar2 = cVar6.f4895c;
                        break;
                    default:
                        cVar2 = cVar6.f4896d;
                        break;
                }
                cVar4 = cVar2;
            }
            this.f4901b = cVar4;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f4901b != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        c cVar;
        c cVar2 = this.f4901b;
        c cVar3 = this.f4900a;
        if (cVar2 != cVar3 && cVar3 != null) {
            switch (((b) this).f4892c) {
                case 0:
                    cVar = cVar2.f4895c;
                    break;
                default:
                    cVar = cVar2.f4896d;
                    break;
            }
        } else {
            cVar = null;
        }
        this.f4901b = cVar;
        return cVar2;
    }
}
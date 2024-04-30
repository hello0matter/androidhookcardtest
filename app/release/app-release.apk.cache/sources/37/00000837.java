package l;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class b extends k implements Map {

    /* renamed from: h  reason: collision with root package name */
    public a f5211h;

    public b(b bVar) {
        if (bVar != null) {
            int i4 = bVar.f5252c;
            b(i4);
            if (this.f5252c == 0) {
                if (i4 > 0) {
                    System.arraycopy(bVar.f5250a, 0, this.f5250a, 0, i4);
                    System.arraycopy(bVar.f5251b, 0, this.f5251b, 0, i4 << 1);
                    this.f5252c = i4;
                    return;
                }
                return;
            }
            for (int i5 = 0; i5 < i4; i5++) {
                put(bVar.h(i5), bVar.j(i5));
            }
        }
    }

    @Override // java.util.Map
    public final Set entrySet() {
        if (this.f5211h == null) {
            this.f5211h = new a(0, this);
        }
        a aVar = this.f5211h;
        if (((h) aVar.f4618a) == null) {
            aVar.f4618a = new h(aVar, 0);
        }
        return (h) aVar.f4618a;
    }

    @Override // java.util.Map
    public final Set keySet() {
        if (this.f5211h == null) {
            this.f5211h = new a(0, this);
        }
        a aVar = this.f5211h;
        if (((h) aVar.f4619b) == null) {
            aVar.f4619b = new h(aVar, 1);
        }
        return (h) aVar.f4619b;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        b(map.size() + this.f5252c);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        if (this.f5211h == null) {
            this.f5211h = new a(0, this);
        }
        a aVar = this.f5211h;
        if (((j) aVar.f4620c) == null) {
            aVar.f4620c = new j(aVar);
        }
        return (j) aVar.f4620c;
    }
}
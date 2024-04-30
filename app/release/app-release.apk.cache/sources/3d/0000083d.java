package l;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class h implements Set {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5239a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g.e f5240b;

    public /* synthetic */ h(g.e eVar, int i4) {
        this.f5239a = i4;
        this.f5240b = eVar;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        switch (this.f5239a) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        switch (this.f5239a) {
            case 0:
                g.e eVar = this.f5240b;
                int g4 = eVar.g();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    eVar.j(entry.getKey(), entry.getValue());
                }
                if (g4 != eVar.g()) {
                    return true;
                }
                return false;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        int i4 = this.f5239a;
        g.e eVar = this.f5240b;
        switch (i4) {
            case 0:
                eVar.d();
                return;
            default:
                eVar.d();
                return;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        int i4 = this.f5239a;
        g.e eVar = this.f5240b;
        switch (i4) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                int h4 = eVar.h(entry.getKey());
                if (h4 < 0) {
                    return false;
                }
                Object e4 = eVar.e(h4, 1);
                Object value = entry.getValue();
                if (e4 != value && (e4 == null || !e4.equals(value))) {
                    return false;
                }
                return true;
            default:
                if (eVar.h(obj) < 0) {
                    return false;
                }
                return true;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        switch (this.f5239a) {
            case 0:
                for (Object obj : collection) {
                    if (!contains(obj)) {
                        return false;
                    }
                }
                return true;
            default:
                b f4 = this.f5240b.f();
                for (Object obj2 : collection) {
                    if (!f4.containsKey(obj2)) {
                        return false;
                    }
                }
                return true;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        switch (this.f5239a) {
            case 0:
                return g.e.m(this, obj);
            default:
                return g.e.m(this, obj);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int i4 = this.f5239a;
        g.e eVar = this.f5240b;
        switch (i4) {
            case 0:
                int i5 = 0;
                for (int g4 = eVar.g() - 1; g4 >= 0; g4--) {
                    Object e4 = eVar.e(g4, 0);
                    Object e5 = eVar.e(g4, 1);
                    if (e4 == null) {
                        hashCode = 0;
                    } else {
                        hashCode = e4.hashCode();
                    }
                    if (e5 == null) {
                        hashCode2 = 0;
                    } else {
                        hashCode2 = e5.hashCode();
                    }
                    i5 += hashCode ^ hashCode2;
                }
                return i5;
            default:
                int i6 = 0;
                for (int g5 = eVar.g() - 1; g5 >= 0; g5--) {
                    Object e6 = eVar.e(g5, 0);
                    if (e6 == null) {
                        hashCode3 = 0;
                    } else {
                        hashCode3 = e6.hashCode();
                    }
                    i6 += hashCode3;
                }
                return i6;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        int i4 = this.f5239a;
        g.e eVar = this.f5240b;
        switch (i4) {
            case 0:
                if (eVar.g() != 0) {
                    return false;
                }
                return true;
            default:
                if (eVar.g() != 0) {
                    return false;
                }
                return true;
        }
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        int i4 = this.f5239a;
        g.e eVar = this.f5240b;
        switch (i4) {
            case 0:
                return new i(eVar);
            default:
                return new g(eVar, 0);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        switch (this.f5239a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                g.e eVar = this.f5240b;
                int h4 = eVar.h(obj);
                if (h4 >= 0) {
                    eVar.k(h4);
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        switch (this.f5239a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                b f4 = this.f5240b.f();
                int i4 = f4.f5252c;
                for (Object obj : collection) {
                    f4.remove(obj);
                }
                if (i4 != f4.f5252c) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        switch (this.f5239a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                return g.e.r(this.f5240b.f(), collection);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        int i4 = this.f5239a;
        g.e eVar = this.f5240b;
        switch (i4) {
            case 0:
                return eVar.g();
            default:
                return eVar.g();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        switch (this.f5239a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                g.e eVar = this.f5240b;
                int g4 = eVar.g();
                Object[] objArr = new Object[g4];
                for (int i4 = 0; i4 < g4; i4++) {
                    objArr[i4] = eVar.e(i4, 0);
                }
                return objArr;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        switch (this.f5239a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                return this.f5240b.t(0, objArr);
        }
    }
}
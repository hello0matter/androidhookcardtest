package l;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class i implements Iterator, Map.Entry {

    /* renamed from: a  reason: collision with root package name */
    public int f5241a;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ g.e f5244d;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5243c = false;

    /* renamed from: b  reason: collision with root package name */
    public int f5242b = -1;

    public i(g.e eVar) {
        this.f5244d = eVar;
        this.f5241a = eVar.g() - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (this.f5243c) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            int i4 = this.f5242b;
            g.e eVar = this.f5244d;
            Object e4 = eVar.e(i4, 0);
            if (key != e4 && (key == null || !key.equals(e4))) {
                return false;
            }
            Object value = entry.getValue();
            Object e5 = eVar.e(this.f5242b, 1);
            if (value != e5 && (value == null || !value.equals(e5))) {
                return false;
            }
            return true;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (this.f5243c) {
            return this.f5244d.e(this.f5242b, 0);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f5243c) {
            return this.f5244d.e(this.f5242b, 1);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f5242b < this.f5241a) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        int hashCode;
        if (this.f5243c) {
            int i4 = this.f5242b;
            g.e eVar = this.f5244d;
            int i5 = 0;
            Object e4 = eVar.e(i4, 0);
            Object e5 = eVar.e(this.f5242b, 1);
            if (e4 == null) {
                hashCode = 0;
            } else {
                hashCode = e4.hashCode();
            }
            if (e5 != null) {
                i5 = e5.hashCode();
            }
            return hashCode ^ i5;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            this.f5242b++;
            this.f5243c = true;
            return this;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.f5243c) {
            this.f5244d.k(this.f5242b);
            this.f5242b--;
            this.f5241a--;
            this.f5243c = false;
            return;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (this.f5243c) {
            return this.f5244d.l(this.f5242b, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
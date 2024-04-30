package s2;

import java.util.Map;

/* loaded from: classes.dex */
public final class d implements Map.Entry {

    /* renamed from: a  reason: collision with root package name */
    public d f6526a;

    /* renamed from: b  reason: collision with root package name */
    public d f6527b;

    /* renamed from: c  reason: collision with root package name */
    public d f6528c;

    /* renamed from: d  reason: collision with root package name */
    public d f6529d;

    /* renamed from: e  reason: collision with root package name */
    public d f6530e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f6531f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f6532g;

    /* renamed from: h  reason: collision with root package name */
    public Object f6533h;

    /* renamed from: i  reason: collision with root package name */
    public int f6534i;

    public d() {
        this.f6531f = null;
        this.f6532g = false;
        this.f6530e = this;
        this.f6529d = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f6531f;
        if (obj2 == null) {
            if (entry.getKey() != null) {
                return false;
            }
        } else if (!obj2.equals(entry.getKey())) {
            return false;
        }
        Object obj3 = this.f6533h;
        Object value = entry.getValue();
        if (obj3 == null) {
            if (value != null) {
                return false;
            }
        } else if (!obj3.equals(value)) {
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f6531f;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f6533h;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        int hashCode;
        int i4 = 0;
        Object obj = this.f6531f;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        Object obj2 = this.f6533h;
        if (obj2 != null) {
            i4 = obj2.hashCode();
        }
        return i4 ^ hashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj == null && !this.f6532g) {
            throw new NullPointerException("value == null");
        }
        Object obj2 = this.f6533h;
        this.f6533h = obj;
        return obj2;
    }

    public final String toString() {
        return this.f6531f + "=" + this.f6533h;
    }

    public d(boolean z4, d dVar, Object obj, d dVar2, d dVar3) {
        this.f6526a = dVar;
        this.f6531f = obj;
        this.f6532g = z4;
        this.f6534i = 1;
        this.f6529d = dVar2;
        this.f6530e = dVar3;
        dVar3.f6529d = this;
        dVar2.f6530e = this;
    }
}
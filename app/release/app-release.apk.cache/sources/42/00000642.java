package com.google.gson.internal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Set;
import s2.b;
import s2.d;
import v.c;

/* loaded from: classes.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: i  reason: collision with root package name */
    public static final c f4214i = new c(3);

    /* renamed from: a  reason: collision with root package name */
    public final Comparator f4215a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f4216b;

    /* renamed from: c  reason: collision with root package name */
    public d f4217c;

    /* renamed from: d  reason: collision with root package name */
    public int f4218d;

    /* renamed from: e  reason: collision with root package name */
    public int f4219e;

    /* renamed from: f  reason: collision with root package name */
    public final d f4220f;

    /* renamed from: g  reason: collision with root package name */
    public b f4221g;

    /* renamed from: h  reason: collision with root package name */
    public b f4222h;

    public LinkedTreeMap() {
        c cVar = f4214i;
        this.f4218d = 0;
        this.f4219e = 0;
        this.f4215a = cVar;
        this.f4216b = false;
        this.f4220f = new d();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() {
        return new LinkedHashMap(this);
    }

    public final d a(Object obj, boolean z4) {
        int i4;
        d dVar;
        Comparable comparable;
        d dVar2;
        d dVar3 = this.f4217c;
        c cVar = f4214i;
        Comparator comparator = this.f4215a;
        if (dVar3 != null) {
            if (comparator == cVar) {
                comparable = (Comparable) obj;
            } else {
                comparable = null;
            }
            while (true) {
                Object obj2 = dVar3.f6531f;
                if (comparable != null) {
                    i4 = comparable.compareTo(obj2);
                } else {
                    i4 = comparator.compare(obj, obj2);
                }
                if (i4 == 0) {
                    return dVar3;
                }
                if (i4 < 0) {
                    dVar2 = dVar3.f6527b;
                } else {
                    dVar2 = dVar3.f6528c;
                }
                if (dVar2 == null) {
                    break;
                }
                dVar3 = dVar2;
            }
        } else {
            i4 = 0;
        }
        if (!z4) {
            return null;
        }
        d dVar4 = this.f4220f;
        if (dVar3 == null) {
            if (comparator == cVar && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            dVar = new d(this.f4216b, dVar3, obj, dVar4, dVar4.f6530e);
            this.f4217c = dVar;
        } else {
            dVar = new d(this.f4216b, dVar3, obj, dVar4, dVar4.f6530e);
            if (i4 < 0) {
                dVar3.f6527b = dVar;
            } else {
                dVar3.f6528c = dVar;
            }
            b(dVar3, true);
        }
        this.f4218d++;
        this.f4219e++;
        return dVar;
    }

    public final void b(d dVar, boolean z4) {
        int i4;
        int i5;
        int i6;
        int i7;
        while (dVar != null) {
            d dVar2 = dVar.f6527b;
            d dVar3 = dVar.f6528c;
            int i8 = 0;
            if (dVar2 != null) {
                i4 = dVar2.f6534i;
            } else {
                i4 = 0;
            }
            if (dVar3 != null) {
                i5 = dVar3.f6534i;
            } else {
                i5 = 0;
            }
            int i9 = i4 - i5;
            if (i9 == -2) {
                d dVar4 = dVar3.f6527b;
                d dVar5 = dVar3.f6528c;
                if (dVar5 != null) {
                    i7 = dVar5.f6534i;
                } else {
                    i7 = 0;
                }
                if (dVar4 != null) {
                    i8 = dVar4.f6534i;
                }
                int i10 = i8 - i7;
                if (i10 != -1 && (i10 != 0 || z4)) {
                    f(dVar3);
                }
                e(dVar);
                if (z4) {
                    return;
                }
            } else if (i9 == 2) {
                d dVar6 = dVar2.f6527b;
                d dVar7 = dVar2.f6528c;
                if (dVar7 != null) {
                    i6 = dVar7.f6534i;
                } else {
                    i6 = 0;
                }
                if (dVar6 != null) {
                    i8 = dVar6.f6534i;
                }
                int i11 = i8 - i6;
                if (i11 != 1 && (i11 != 0 || z4)) {
                    e(dVar2);
                }
                f(dVar);
                if (z4) {
                    return;
                }
            } else if (i9 == 0) {
                dVar.f6534i = i4 + 1;
                if (z4) {
                    return;
                }
            } else {
                dVar.f6534i = Math.max(i4, i5) + 1;
                if (!z4) {
                    return;
                }
            }
            dVar = dVar.f6526a;
        }
    }

    public final void c(d dVar, boolean z4) {
        d dVar2;
        d dVar3;
        int i4;
        if (z4) {
            d dVar4 = dVar.f6530e;
            dVar4.f6529d = dVar.f6529d;
            dVar.f6529d.f6530e = dVar4;
        }
        d dVar5 = dVar.f6527b;
        d dVar6 = dVar.f6528c;
        d dVar7 = dVar.f6526a;
        int i5 = 0;
        if (dVar5 != null && dVar6 != null) {
            if (dVar5.f6534i > dVar6.f6534i) {
                do {
                    dVar3 = dVar5;
                    dVar5 = dVar5.f6528c;
                } while (dVar5 != null);
            } else {
                do {
                    dVar2 = dVar6;
                    dVar6 = dVar6.f6527b;
                } while (dVar6 != null);
                dVar3 = dVar2;
            }
            c(dVar3, false);
            d dVar8 = dVar.f6527b;
            if (dVar8 != null) {
                i4 = dVar8.f6534i;
                dVar3.f6527b = dVar8;
                dVar8.f6526a = dVar3;
                dVar.f6527b = null;
            } else {
                i4 = 0;
            }
            d dVar9 = dVar.f6528c;
            if (dVar9 != null) {
                i5 = dVar9.f6534i;
                dVar3.f6528c = dVar9;
                dVar9.f6526a = dVar3;
                dVar.f6528c = null;
            }
            dVar3.f6534i = Math.max(i4, i5) + 1;
            d(dVar, dVar3);
            return;
        }
        if (dVar5 != null) {
            d(dVar, dVar5);
            dVar.f6527b = null;
        } else if (dVar6 != null) {
            d(dVar, dVar6);
            dVar.f6528c = null;
        } else {
            d(dVar, null);
        }
        b(dVar7, false);
        this.f4218d--;
        this.f4219e++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f4217c = null;
        this.f4218d = 0;
        this.f4219e++;
        d dVar = this.f4220f;
        dVar.f6530e = dVar;
        dVar.f6529d = dVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        d dVar = null;
        if (obj != null) {
            try {
                dVar = a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        if (dVar == null) {
            return false;
        }
        return true;
    }

    public final void d(d dVar, d dVar2) {
        d dVar3 = dVar.f6526a;
        dVar.f6526a = null;
        if (dVar2 != null) {
            dVar2.f6526a = dVar3;
        }
        if (dVar3 != null) {
            if (dVar3.f6527b == dVar) {
                dVar3.f6527b = dVar2;
                return;
            } else {
                dVar3.f6528c = dVar2;
                return;
            }
        }
        this.f4217c = dVar2;
    }

    public final void e(d dVar) {
        int i4;
        int i5;
        d dVar2 = dVar.f6527b;
        d dVar3 = dVar.f6528c;
        d dVar4 = dVar3.f6527b;
        d dVar5 = dVar3.f6528c;
        dVar.f6528c = dVar4;
        if (dVar4 != null) {
            dVar4.f6526a = dVar;
        }
        d(dVar, dVar3);
        dVar3.f6527b = dVar;
        dVar.f6526a = dVar3;
        int i6 = 0;
        if (dVar2 != null) {
            i4 = dVar2.f6534i;
        } else {
            i4 = 0;
        }
        if (dVar4 != null) {
            i5 = dVar4.f6534i;
        } else {
            i5 = 0;
        }
        int max = Math.max(i4, i5) + 1;
        dVar.f6534i = max;
        if (dVar5 != null) {
            i6 = dVar5.f6534i;
        }
        dVar3.f6534i = Math.max(max, i6) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        b bVar = this.f4221g;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(this, 0);
        this.f4221g = bVar2;
        return bVar2;
    }

    public final void f(d dVar) {
        int i4;
        int i5;
        d dVar2 = dVar.f6527b;
        d dVar3 = dVar.f6528c;
        d dVar4 = dVar2.f6527b;
        d dVar5 = dVar2.f6528c;
        dVar.f6527b = dVar5;
        if (dVar5 != null) {
            dVar5.f6526a = dVar;
        }
        d(dVar, dVar2);
        dVar2.f6528c = dVar;
        dVar.f6526a = dVar2;
        int i6 = 0;
        if (dVar3 != null) {
            i4 = dVar3.f6534i;
        } else {
            i4 = 0;
        }
        if (dVar5 != null) {
            i5 = dVar5.f6534i;
        } else {
            i5 = 0;
        }
        int max = Math.max(i4, i5) + 1;
        dVar.f6534i = max;
        if (dVar4 != null) {
            i6 = dVar4.f6534i;
        }
        dVar2.f6534i = Math.max(max, i6) + 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x000c  */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object get(java.lang.Object r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L9
            r1 = 0
            s2.d r3 = r2.a(r3, r1)     // Catch: java.lang.ClassCastException -> L9
            goto La
        L9:
            r3 = r0
        La:
            if (r3 == 0) goto Le
            java.lang.Object r0 = r3.f6533h
        Le:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        b bVar = this.f4222h;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(this, 1);
        this.f4222h = bVar2;
        return bVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj != null) {
            if (obj2 != null || this.f4216b) {
                d a5 = a(obj, true);
                Object obj3 = a5.f6533h;
                a5.f6533h = obj2;
                return obj3;
            }
            throw new NullPointerException("value == null");
        }
        throw new NullPointerException("key == null");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0012  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x000c  */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object remove(java.lang.Object r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L9
            r1 = 0
            s2.d r3 = r2.a(r3, r1)     // Catch: java.lang.ClassCastException -> L9
            goto La
        L9:
            r3 = r0
        La:
            if (r3 == 0) goto L10
            r1 = 1
            r2.c(r3, r1)
        L10:
            if (r3 == 0) goto L14
            java.lang.Object r0 = r3.f6533h
        L14:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.remove(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f4218d;
    }
}
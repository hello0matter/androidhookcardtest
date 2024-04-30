package androidx.recyclerview.widget;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: d  reason: collision with root package name */
    public final i0 f2059d;

    /* renamed from: a  reason: collision with root package name */
    public final p.g f2056a = new p.g(30, 1);

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f2057b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f2058c = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public final i0 f2060e = new i0(this);

    public b(i0 i0Var) {
        this.f2059d = i0Var;
    }

    public final boolean a(int i4) {
        ArrayList arrayList = this.f2058c;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            a aVar = (a) arrayList.get(i5);
            int i6 = aVar.f2042a;
            if (i6 == 8) {
                if (f(aVar.f2045d, i5 + 1) == i4) {
                    return true;
                }
            } else if (i6 == 1) {
                int i7 = aVar.f2043b;
                int i8 = aVar.f2045d + i7;
                while (i7 < i8) {
                    if (f(i7, i5 + 1) == i4) {
                        return true;
                    }
                    i7++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    public final void b() {
        ArrayList arrayList = this.f2058c;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.f2059d.b((a) arrayList.get(i4));
        }
        l(arrayList);
    }

    public final void c() {
        b();
        ArrayList arrayList = this.f2057b;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            a aVar = (a) arrayList.get(i4);
            int i5 = aVar.f2042a;
            i0 i0Var = this.f2059d;
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 4) {
                        if (i5 == 8) {
                            i0Var.b(aVar);
                            i0Var.k(aVar.f2043b, aVar.f2045d);
                        }
                    } else {
                        i0Var.b(aVar);
                        i0Var.g(aVar.f2043b, aVar.f2045d, aVar.f2044c);
                    }
                } else {
                    i0Var.b(aVar);
                    int i6 = aVar.f2043b;
                    int i7 = aVar.f2045d;
                    RecyclerView recyclerView = (RecyclerView) i0Var.f2125a;
                    recyclerView.P(i6, i7, true);
                    recyclerView.f1979g0 = true;
                    recyclerView.f1973d0.f2128c += i7;
                }
            } else {
                i0Var.b(aVar);
                i0Var.j(aVar.f2043b, aVar.f2045d);
            }
        }
        l(arrayList);
    }

    public final void d(a aVar) {
        int i4;
        int i5 = aVar.f2042a;
        if (i5 != 1 && i5 != 8) {
            int m4 = m(aVar.f2043b, i5);
            int i6 = aVar.f2043b;
            int i7 = aVar.f2042a;
            if (i7 != 2) {
                if (i7 == 4) {
                    i4 = 1;
                } else {
                    throw new IllegalArgumentException("op should be remove or update." + aVar);
                }
            } else {
                i4 = 0;
            }
            int i8 = 1;
            for (int i9 = 1; i9 < aVar.f2045d; i9++) {
                int m5 = m((i4 * i9) + aVar.f2043b, aVar.f2042a);
                int i10 = aVar.f2042a;
                if (i10 == 2 ? m5 == m4 : !(i10 != 4 || m5 != m4 + 1)) {
                    i8++;
                } else {
                    a h4 = h(aVar.f2044c, i10, m4, i8);
                    e(h4, i6);
                    h4.f2044c = null;
                    this.f2056a.b(h4);
                    if (aVar.f2042a == 4) {
                        i6 += i8;
                    }
                    i8 = 1;
                    m4 = m5;
                }
            }
            Object obj = aVar.f2044c;
            aVar.f2044c = null;
            this.f2056a.b(aVar);
            if (i8 > 0) {
                a h5 = h(obj, aVar.f2042a, m4, i8);
                e(h5, i6);
                h5.f2044c = null;
                this.f2056a.b(h5);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    public final void e(a aVar, int i4) {
        i0 i0Var = this.f2059d;
        i0Var.b(aVar);
        int i5 = aVar.f2042a;
        if (i5 != 2) {
            if (i5 == 4) {
                i0Var.g(i4, aVar.f2045d, aVar.f2044c);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
        int i6 = aVar.f2045d;
        RecyclerView recyclerView = (RecyclerView) i0Var.f2125a;
        recyclerView.P(i4, i6, true);
        recyclerView.f1979g0 = true;
        recyclerView.f1973d0.f2128c += i6;
    }

    public final int f(int i4, int i5) {
        ArrayList arrayList = this.f2058c;
        int size = arrayList.size();
        while (i5 < size) {
            a aVar = (a) arrayList.get(i5);
            int i6 = aVar.f2042a;
            if (i6 == 8) {
                int i7 = aVar.f2043b;
                if (i7 == i4) {
                    i4 = aVar.f2045d;
                } else {
                    if (i7 < i4) {
                        i4--;
                    }
                    if (aVar.f2045d <= i4) {
                        i4++;
                    }
                }
            } else {
                int i8 = aVar.f2043b;
                if (i8 > i4) {
                    continue;
                } else if (i6 == 2) {
                    int i9 = aVar.f2045d;
                    if (i4 < i8 + i9) {
                        return -1;
                    }
                    i4 -= i9;
                } else if (i6 == 1) {
                    i4 += aVar.f2045d;
                }
            }
            i5++;
        }
        return i4;
    }

    public final boolean g() {
        return this.f2057b.size() > 0;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, androidx.recyclerview.widget.a] */
    public final a h(Object obj, int i4, int i5, int i6) {
        a aVar = (a) this.f2056a.a();
        if (aVar == null) {
            ?? obj2 = new Object();
            obj2.f2042a = i4;
            obj2.f2043b = i5;
            obj2.f2045d = i6;
            obj2.f2044c = obj;
            return obj2;
        }
        aVar.f2042a = i4;
        aVar.f2043b = i5;
        aVar.f2045d = i6;
        aVar.f2044c = obj;
        return aVar;
    }

    public final void i(a aVar) {
        this.f2058c.add(aVar);
        int i4 = aVar.f2042a;
        i0 i0Var = this.f2059d;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 4) {
                    if (i4 == 8) {
                        i0Var.k(aVar.f2043b, aVar.f2045d);
                        return;
                    }
                    throw new IllegalArgumentException("Unknown update op type for " + aVar);
                }
                i0Var.g(aVar.f2043b, aVar.f2045d, aVar.f2044c);
                return;
            }
            int i5 = aVar.f2043b;
            int i6 = aVar.f2045d;
            RecyclerView recyclerView = (RecyclerView) i0Var.f2125a;
            recyclerView.P(i5, i6, false);
            recyclerView.f1979g0 = true;
            return;
        }
        i0Var.j(aVar.f2043b, aVar.f2045d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0191, code lost:
        r1.set(r3, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0198, code lost:
        if (r11.f2043b == r11.f2045d) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x019a, code lost:
        r1.set(r8, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x019e, code lost:
        r1.remove(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01a1, code lost:
        if (r4 == null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01a3, code lost:
        r1.add(r3, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x015f, code lost:
        if (r5 > r12.f2043b) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0161, code lost:
        r11.f2045d = r5 - r12.f2045d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x018e, code lost:
        if (r5 >= r12.f2043b) goto L71;
     */
    /* JADX WARN: Removed duplicated region for block: B:183:0x00aa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0136 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0122 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j() {
        /*
            Method dump skipped, instructions count: 683
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.b.j():void");
    }

    public final void k(a aVar) {
        aVar.f2044c = null;
        this.f2056a.b(aVar);
    }

    public final void l(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            k((a) arrayList.get(i4));
        }
        arrayList.clear();
    }

    public final int m(int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        ArrayList arrayList = this.f2058c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            a aVar = (a) arrayList.get(size);
            int i12 = aVar.f2042a;
            if (i12 == 8) {
                int i13 = aVar.f2043b;
                int i14 = aVar.f2045d;
                if (i13 < i14) {
                    i8 = i13;
                    i7 = i14;
                } else {
                    i7 = i13;
                    i8 = i14;
                }
                if (i4 < i8 || i4 > i7) {
                    if (i4 < i13) {
                        if (i5 == 1) {
                            aVar.f2043b = i13 + 1;
                            i9 = i14 + 1;
                        } else if (i5 == 2) {
                            aVar.f2043b = i13 - 1;
                            i9 = i14 - 1;
                        }
                        aVar.f2045d = i9;
                    }
                } else if (i8 == i13) {
                    if (i5 == 1) {
                        i11 = i14 + 1;
                    } else {
                        if (i5 == 2) {
                            i11 = i14 - 1;
                        }
                        i4++;
                    }
                    aVar.f2045d = i11;
                    i4++;
                } else {
                    if (i5 == 1) {
                        i10 = i13 + 1;
                    } else {
                        if (i5 == 2) {
                            i10 = i13 - 1;
                        }
                        i4--;
                    }
                    aVar.f2043b = i10;
                    i4--;
                }
            } else {
                int i15 = aVar.f2043b;
                if (i15 > i4) {
                    if (i5 == 1) {
                        i6 = i15 + 1;
                    } else if (i5 == 2) {
                        i6 = i15 - 1;
                    }
                    aVar.f2043b = i6;
                } else if (i12 == 1) {
                    i4 -= aVar.f2045d;
                } else if (i12 == 2) {
                    i4 += aVar.f2045d;
                }
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            a aVar2 = (a) arrayList.get(size2);
            if (aVar2.f2042a == 8) {
                int i16 = aVar2.f2045d;
                if (i16 != aVar2.f2043b && i16 >= 0) {
                }
                arrayList.remove(size2);
                k(aVar2);
            } else {
                if (aVar2.f2045d > 0) {
                }
                arrayList.remove(size2);
                k(aVar2);
            }
        }
        return i4;
    }
}
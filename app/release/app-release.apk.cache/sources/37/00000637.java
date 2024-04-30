package com.google.gson;

import androidx.activity.j;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class a extends b implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f4209a = new ArrayList();

    @Override // com.google.gson.b
    public final int a() {
        return e().a();
    }

    @Override // com.google.gson.b
    public final long c() {
        return e().c();
    }

    @Override // com.google.gson.b
    public final String d() {
        return e().d();
    }

    public final b e() {
        ArrayList arrayList = this.f4209a;
        int size = arrayList.size();
        if (size == 1) {
            return (b) arrayList.get(0);
        }
        throw new IllegalStateException(j.b("Array must have size 1, but has size ", size));
    }

    public final boolean equals(Object obj) {
        return obj == this || ((obj instanceof a) && ((a) obj).f4209a.equals(this.f4209a));
    }

    public final int hashCode() {
        return this.f4209a.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f4209a.iterator();
    }
}
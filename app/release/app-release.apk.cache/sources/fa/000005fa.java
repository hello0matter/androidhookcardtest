package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Objects;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes.dex */
class RegularImmutableList<E> extends ImmutableList<E> {

    /* renamed from: e  reason: collision with root package name */
    public static final ImmutableList f4182e = new RegularImmutableList(0, new Object[0]);

    /* renamed from: c  reason: collision with root package name */
    public final transient Object[] f4183c;

    /* renamed from: d  reason: collision with root package name */
    public final transient int f4184d;

    public RegularImmutableList(int i4, Object[] objArr) {
        this.f4183c = objArr;
        this.f4184d = i4;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public final int a(Object[] objArr) {
        Object[] objArr2 = this.f4183c;
        int i4 = this.f4184d;
        System.arraycopy(objArr2, 0, objArr, 0, i4);
        return i4;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final Object[] b() {
        return this.f4183c;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int c() {
        return this.f4184d;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int d() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final boolean e() {
        return false;
    }

    @Override // java.util.List
    public final Object get(int i4) {
        c.A(i4, this.f4184d);
        Object obj = this.f4183c[i4];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4184d;
    }
}
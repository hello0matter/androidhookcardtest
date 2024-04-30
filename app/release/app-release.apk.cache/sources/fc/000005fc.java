package com.google.common.collect;

/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: c  reason: collision with root package name */
    public final ImmutableList f4187c;

    public b(ImmutableList immutableList, int i4) {
        super(immutableList.size(), i4);
        this.f4187c = immutableList;
    }

    @Override // com.google.common.collect.a
    public final Object b(int i4) {
        return this.f4187c.get(i4);
    }
}
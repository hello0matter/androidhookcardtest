package com.google.common.collect;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class a extends d {

    /* renamed from: a  reason: collision with root package name */
    public final int f4185a;

    /* renamed from: b  reason: collision with root package name */
    public int f4186b;

    public a(int i4, int i5) {
        if (i5 >= 0 && i5 <= i4) {
            this.f4185a = i4;
            this.f4186b = i5;
            return;
        }
        throw new IndexOutOfBoundsException(c.p(i5, i4, "index"));
    }

    public abstract Object b(int i4);

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f4186b < this.f4185a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f4186b > 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            int i4 = this.f4186b;
            this.f4186b = i4 + 1;
            return b(i4);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f4186b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (hasPrevious()) {
            int i4 = this.f4186b - 1;
            this.f4186b = i4;
            return b(i4);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f4186b - 1;
    }
}
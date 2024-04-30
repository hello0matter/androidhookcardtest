package k3;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final b f5144a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5145b;

    public a(b bVar, int i4) {
        com.google.common.collect.c.F(bVar, "sequence");
        this.f5144a = bVar;
        this.f5145b = i4;
        if (i4 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i4 + '.').toString());
    }

    @Override // k3.b
    public final Iterator iterator() {
        return new y2.a(this);
    }
}
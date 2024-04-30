package h0;

import p.g;

/* loaded from: classes.dex */
public final class d extends g {

    /* renamed from: d  reason: collision with root package name */
    public final Object f4799d;

    public d(int i4) {
        super(i4, 1);
        this.f4799d = new Object();
    }

    @Override // p.g
    public final Object a() {
        Object a5;
        synchronized (this.f4799d) {
            a5 = super.a();
        }
        return a5;
    }

    @Override // p.g
    public final boolean b(Object obj) {
        boolean b5;
        synchronized (this.f4799d) {
            b5 = super.b(obj);
        }
        return b5;
    }
}
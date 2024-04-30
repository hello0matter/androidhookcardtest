package m;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class d extends com.google.common.collect.c {

    /* renamed from: q  reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f5417q;

    /* renamed from: r  reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f5418r;

    /* renamed from: s  reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f5419s;

    /* renamed from: t  reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f5420t;

    /* renamed from: u  reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f5421u;

    public d(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.f5417q = atomicReferenceFieldUpdater;
        this.f5418r = atomicReferenceFieldUpdater2;
        this.f5419s = atomicReferenceFieldUpdater3;
        this.f5420t = atomicReferenceFieldUpdater4;
        this.f5421u = atomicReferenceFieldUpdater5;
    }

    @Override // com.google.common.collect.c
    public final void D1(e eVar, e eVar2) {
        this.f5418r.lazySet(eVar, eVar2);
    }

    @Override // com.google.common.collect.c
    public final void E1(e eVar, Thread thread) {
        this.f5417q.lazySet(eVar, thread);
    }

    @Override // com.google.common.collect.c
    public final boolean w(f fVar, c cVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        c cVar2 = c.f5415b;
        do {
            atomicReferenceFieldUpdater = this.f5420t;
            if (atomicReferenceFieldUpdater.compareAndSet(fVar, cVar, cVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(fVar) == cVar);
        return false;
    }

    @Override // com.google.common.collect.c
    public final boolean x(f fVar, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f5421u;
            if (atomicReferenceFieldUpdater.compareAndSet(fVar, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(fVar) == obj);
        return false;
    }

    @Override // com.google.common.collect.c
    public final boolean y(f fVar, e eVar, e eVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f5419s;
            if (atomicReferenceFieldUpdater.compareAndSet(fVar, eVar, eVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(fVar) == eVar);
        return false;
    }
}
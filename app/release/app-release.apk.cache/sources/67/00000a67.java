package y3;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a  reason: collision with root package name */
    public static final p f7207a = new p(new byte[0], 0, 0, false);

    /* renamed from: b  reason: collision with root package name */
    public static final int f7208b;

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicReference[] f7209c;

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f7208b = highestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i4 = 0; i4 < highestOneBit; i4++) {
            atomicReferenceArr[i4] = new AtomicReference();
        }
        f7209c = atomicReferenceArr;
    }

    public static final void a(p pVar) {
        int i4;
        if (pVar.f7205f == null && pVar.f7206g == null) {
            if (pVar.f7203d) {
                return;
            }
            AtomicReference atomicReference = f7209c[(int) (Thread.currentThread().getId() & (f7208b - 1))];
            p pVar2 = f7207a;
            p pVar3 = (p) atomicReference.getAndSet(pVar2);
            if (pVar3 == pVar2) {
                return;
            }
            if (pVar3 != null) {
                i4 = pVar3.f7202c;
            } else {
                i4 = 0;
            }
            if (i4 >= 65536) {
                atomicReference.set(pVar3);
                return;
            }
            pVar.f7205f = pVar3;
            pVar.f7201b = 0;
            pVar.f7202c = i4 + 8192;
            atomicReference.set(pVar);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final p b() {
        AtomicReference atomicReference = f7209c[(int) (Thread.currentThread().getId() & (f7208b - 1))];
        p pVar = f7207a;
        p pVar2 = (p) atomicReference.getAndSet(pVar);
        if (pVar2 == pVar) {
            return new p();
        }
        if (pVar2 == null) {
            atomicReference.set(null);
            return new p();
        }
        atomicReference.set(pVar2.f7205f);
        pVar2.f7205f = null;
        pVar2.f7202c = 0;
        return pVar2;
    }
}
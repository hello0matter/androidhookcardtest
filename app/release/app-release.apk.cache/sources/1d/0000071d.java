package h2;

/* loaded from: classes.dex */
public final class h extends g0.i {
    @Override // g0.i
    public final float b(Object obj) {
        return ((i) obj).f4848o * 10000.0f;
    }

    @Override // g0.i
    public final void d(Object obj, float f4) {
        i iVar = (i) obj;
        iVar.f4848o = f4 / 10000.0f;
        iVar.invalidateSelf();
    }
}
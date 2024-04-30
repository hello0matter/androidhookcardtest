package l2;

/* loaded from: classes.dex */
public final class e extends com.google.common.collect.c {
    @Override // com.google.common.collect.c
    public final void p0(float f4, float f5, z zVar) {
        zVar.e(0.0f, f5 * f4, 180.0f, 90.0f);
        double d4 = f5;
        double d5 = f4;
        zVar.d((float) (Math.sin(Math.toRadians(90.0f)) * d4 * d5), (float) (Math.sin(Math.toRadians(0.0f)) * d4 * d5));
    }
}
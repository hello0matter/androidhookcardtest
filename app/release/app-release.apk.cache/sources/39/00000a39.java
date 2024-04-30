package x1;

import android.animation.TypeEvaluator;

/* loaded from: classes.dex */
public final class c implements TypeEvaluator {

    /* renamed from: b  reason: collision with root package name */
    public static final c f7135b = new c();

    /* renamed from: a  reason: collision with root package name */
    public final f f7136a = new Object();

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f4, Object obj, Object obj2) {
        f fVar = (f) obj;
        f fVar2 = (f) obj2;
        float f5 = fVar.f7139a;
        float f6 = 1.0f - f4;
        float f7 = (fVar2.f7139a * f4) + (f5 * f6);
        float f8 = fVar.f7140b;
        float f9 = fVar2.f7140b * f4;
        float f10 = fVar.f7141c;
        float f11 = f4 * fVar2.f7141c;
        f fVar3 = this.f7136a;
        fVar3.f7139a = f7;
        fVar3.f7140b = f9 + (f8 * f6);
        fVar3.f7141c = f11 + (f6 * f10);
        return fVar3;
    }
}
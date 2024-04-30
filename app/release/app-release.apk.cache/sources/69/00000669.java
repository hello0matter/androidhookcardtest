package d2;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;

/* loaded from: classes.dex */
public final class n implements TypeEvaluator {

    /* renamed from: a  reason: collision with root package name */
    public FloatEvaluator f4387a;

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f4, Object obj, Object obj2) {
        float floatValue = this.f4387a.evaluate(f4, (Number) ((Float) obj), (Number) ((Float) obj2)).floatValue();
        if (floatValue < 0.1f) {
            floatValue = 0.0f;
        }
        return Float.valueOf(floatValue);
    }
}
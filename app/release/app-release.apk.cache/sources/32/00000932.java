package p1;

import android.animation.TypeEvaluator;
import androidx.activity.j;

/* loaded from: classes.dex */
public final class c implements TypeEvaluator {

    /* renamed from: a  reason: collision with root package name */
    public static final c f6133a = new Object();

    public static Integer a(float f4, Integer num, Integer num2) {
        int intValue = num.intValue();
        float f5 = ((intValue >> 24) & 255) / 255.0f;
        int intValue2 = num2.intValue();
        float pow = (float) Math.pow(((intValue >> 16) & 255) / 255.0f, 2.2d);
        float pow2 = (float) Math.pow(((intValue >> 8) & 255) / 255.0f, 2.2d);
        float pow3 = (float) Math.pow((intValue & 255) / 255.0f, 2.2d);
        float pow4 = (float) Math.pow(((intValue2 >> 16) & 255) / 255.0f, 2.2d);
        float a5 = j.a(((intValue2 >> 24) & 255) / 255.0f, f5, f4, f5);
        float a6 = j.a(pow4, pow, f4, pow);
        float a7 = j.a((float) Math.pow(((intValue2 >> 8) & 255) / 255.0f, 2.2d), pow2, f4, pow2);
        float a8 = j.a((float) Math.pow((intValue2 & 255) / 255.0f, 2.2d), pow3, f4, pow3);
        int round = Math.round(((float) Math.pow(a6, 0.45454545454545453d)) * 255.0f) << 16;
        return Integer.valueOf(Math.round(((float) Math.pow(a8, 0.45454545454545453d)) * 255.0f) | round | (Math.round(a5 * 255.0f) << 24) | (Math.round(((float) Math.pow(a7, 0.45454545454545453d)) * 255.0f) << 8));
    }

    @Override // android.animation.TypeEvaluator
    public final /* bridge */ /* synthetic */ Object evaluate(float f4, Object obj, Object obj2) {
        return a(f4, (Integer) obj, (Integer) obj2);
    }
}
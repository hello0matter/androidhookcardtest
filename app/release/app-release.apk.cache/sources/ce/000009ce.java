package u0;

import android.view.animation.Interpolator;
import androidx.activity.j;

/* loaded from: classes.dex */
public abstract class d implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f6852a;

    /* renamed from: b  reason: collision with root package name */
    public final float f6853b;

    public d(float[] fArr) {
        this.f6852a = fArr;
        this.f6853b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f4) {
        if (f4 >= 1.0f) {
            return 1.0f;
        }
        if (f4 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f6852a;
        int min = Math.min((int) ((fArr.length - 1) * f4), fArr.length - 2);
        float f5 = this.f6853b;
        float f6 = fArr[min];
        return j.a(fArr[min + 1], f6, (f4 - (min * f5)) / f5, f6);
    }
}
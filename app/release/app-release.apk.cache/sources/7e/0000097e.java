package s;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.widget.ImageView;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f6489a = new float[20];

    /* renamed from: b  reason: collision with root package name */
    public final ColorMatrix f6490b = new ColorMatrix();

    /* renamed from: c  reason: collision with root package name */
    public final ColorMatrix f6491c = new ColorMatrix();

    /* renamed from: d  reason: collision with root package name */
    public float f6492d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f6493e = 1.0f;

    /* renamed from: f  reason: collision with root package name */
    public float f6494f = 1.0f;

    /* renamed from: g  reason: collision with root package name */
    public float f6495g = 1.0f;

    public final void a(ImageView imageView) {
        boolean z4;
        float log;
        float f4;
        float f5;
        float f6;
        ColorMatrix colorMatrix = this.f6490b;
        colorMatrix.reset();
        float f7 = this.f6493e;
        float f8 = 1.0f;
        int i4 = (f7 > 1.0f ? 1 : (f7 == 1.0f ? 0 : -1));
        float[] fArr = this.f6489a;
        if (i4 != 0) {
            float f9 = 1.0f - f7;
            float f10 = 0.2999f * f9;
            float f11 = 0.587f * f9;
            float f12 = f9 * 0.114f;
            fArr[0] = f10 + f7;
            fArr[1] = f11;
            fArr[2] = f12;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f10;
            fArr[6] = f11 + f7;
            fArr[7] = f12;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f10;
            fArr[11] = f11;
            fArr[12] = f12 + f7;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
            colorMatrix.set(fArr);
            z4 = true;
        } else {
            z4 = false;
        }
        float f13 = this.f6494f;
        int i5 = (f13 > 1.0f ? 1 : (f13 == 1.0f ? 0 : -1));
        ColorMatrix colorMatrix2 = this.f6491c;
        if (i5 != 0) {
            colorMatrix2.setScale(f13, f13, f13, 1.0f);
            colorMatrix.postConcat(colorMatrix2);
            z4 = true;
        }
        float f14 = this.f6495g;
        if (f14 != 1.0f) {
            if (f14 <= 0.0f) {
                f14 = 0.01f;
            }
            float f15 = (5000.0f / f14) / 100.0f;
            if (f15 > 66.0f) {
                double d4 = f15 - 60.0f;
                f4 = ((float) Math.pow(d4, -0.13320475816726685d)) * 329.69873f;
                log = ((float) Math.pow(d4, 0.07551484555006027d)) * 288.12216f;
            } else {
                log = (((float) Math.log(f15)) * 99.4708f) - 161.11957f;
                f4 = 255.0f;
            }
            if (f15 < 66.0f) {
                if (f15 > 19.0f) {
                    f5 = log;
                    f6 = (((float) Math.log(f15 - 10.0f)) * 138.51773f) - 305.0448f;
                } else {
                    f5 = log;
                    f6 = 0.0f;
                }
            } else {
                f5 = log;
                f6 = 255.0f;
            }
            float min = Math.min(255.0f, Math.max(f4, 0.0f));
            float min2 = Math.min(255.0f, Math.max(f5, 0.0f));
            float min3 = Math.min(255.0f, Math.max(f6, 0.0f));
            float min4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float min5 = Math.min(255.0f, Math.max((((float) Math.log(50.0f)) * 99.4708f) - 161.11957f, 0.0f));
            fArr[0] = min / min4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = min2 / min5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = min3 / Math.min(255.0f, Math.max((((float) Math.log(40.0f)) * 138.51773f) - 305.0448f, 0.0f));
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            f8 = 1.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
            colorMatrix2.set(fArr);
            colorMatrix.postConcat(colorMatrix2);
            z4 = true;
        }
        float f16 = this.f6492d;
        if (f16 != f8) {
            fArr[0] = f16;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f16;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f16;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
            colorMatrix2.set(fArr);
            colorMatrix.postConcat(colorMatrix2);
        } else if (!z4) {
            imageView.clearColorFilter();
            return;
        }
        imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }
}
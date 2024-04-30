package a0;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final float[][] f8a = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    /* renamed from: b  reason: collision with root package name */
    public static final float[][] f9b = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    /* renamed from: c  reason: collision with root package name */
    public static final float[] f10c = {95.047f, 100.0f, 108.883f};

    /* renamed from: d  reason: collision with root package name */
    public static final float[][] f11d = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    public static int a(float f4) {
        float f5;
        boolean z4;
        float f6;
        if (f4 < 1.0f) {
            return -16777216;
        }
        if (f4 > 99.0f) {
            return -1;
        }
        float f7 = (f4 + 16.0f) / 116.0f;
        if (f4 > 8.0f) {
            f5 = f7 * f7 * f7;
        } else {
            f5 = f4 / 903.2963f;
        }
        float f8 = f7 * f7 * f7;
        if (f8 > 0.008856452f) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            f6 = f8;
        } else {
            f6 = ((f7 * 116.0f) - 16.0f) / 903.2963f;
        }
        if (!z4) {
            f8 = ((f7 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f10c;
        return b0.a.a(f6 * fArr[0], f5 * fArr[1], f8 * fArr[2]);
    }

    public static float b(int i4) {
        float pow;
        float f4 = i4 / 255.0f;
        if (f4 <= 0.04045f) {
            pow = f4 / 12.92f;
        } else {
            pow = (float) Math.pow((f4 + 0.055f) / 1.055f, 2.4000000953674316d);
        }
        return pow * 100.0f;
    }

    public static float c() {
        return ((float) Math.pow((50.0f + 16.0d) / 116.0d, 3.0d)) * 100.0f;
    }
}
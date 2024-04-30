package n;

import androidx.annotation.VisibleForTesting;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public float[] f5679a;

    /* renamed from: b  reason: collision with root package name */
    public double[] f5680b;

    /* renamed from: c  reason: collision with root package name */
    public double[] f5681c;

    /* renamed from: d  reason: collision with root package name */
    public int f5682d;

    public final void a(double d4, float f4) {
        int length = this.f5679a.length + 1;
        int binarySearch = Arrays.binarySearch(this.f5680b, d4);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.f5680b = Arrays.copyOf(this.f5680b, length);
        this.f5679a = Arrays.copyOf(this.f5679a, length);
        this.f5681c = new double[length];
        double[] dArr = this.f5680b;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.f5680b[binarySearch] = d4;
        this.f5679a[binarySearch] = f4;
    }

    public final double b(double d4) {
        if (d4 <= 0.0d) {
            d4 = 1.0E-5d;
        } else if (d4 >= 1.0d) {
            d4 = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(this.f5680b, d4);
        if (binarySearch > 0 || binarySearch == 0) {
            return 0.0d;
        }
        int i4 = -binarySearch;
        int i5 = i4 - 1;
        float[] fArr = this.f5679a;
        float f4 = fArr[i5];
        int i6 = i4 - 2;
        float f5 = fArr[i6];
        double[] dArr = this.f5680b;
        double d5 = dArr[i5];
        double d6 = dArr[i6];
        double d7 = (f4 - f5) / (d5 - d6);
        return (f5 - (d7 * d6)) + (d4 * d7);
    }

    public final double c(double d4) {
        if (d4 < 0.0d) {
            d4 = 0.0d;
        } else if (d4 > 1.0d) {
            d4 = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.f5680b, d4);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch == 0) {
            return 0.0d;
        }
        int i4 = -binarySearch;
        int i5 = i4 - 1;
        float[] fArr = this.f5679a;
        float f4 = fArr[i5];
        int i6 = i4 - 2;
        float f5 = fArr[i6];
        double[] dArr = this.f5680b;
        double d5 = dArr[i5];
        double d6 = dArr[i6];
        double d7 = (f4 - f5) / (d5 - d6);
        return ((((d4 * d4) - (d6 * d6)) * d7) / 2.0d) + ((d4 - d6) * (f5 - (d7 * d6))) + this.f5681c[i6];
    }

    public final double d(double d4) {
        double abs;
        int i4 = this.f5682d;
        double c4 = c(d4);
        switch (i4) {
            case 1:
                return Math.signum(0.5d - (c4 % 1.0d));
            case 2:
                abs = Math.abs((((c4 * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                return (((c4 * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case VisibleForTesting.PROTECTED /* 4 */:
                abs = ((c4 * 2.0d) + 1.0d) % 2.0d;
                break;
            case VisibleForTesting.NONE /* 5 */:
                return Math.cos(c4 * 6.283185307179586d);
            case 6:
                double abs2 = 1.0d - Math.abs(((c4 * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            default:
                return Math.sin(c4 * 6.283185307179586d);
        }
        return 1.0d - abs;
    }

    public final String toString() {
        return "pos =" + Arrays.toString(this.f5680b) + " period=" + Arrays.toString(this.f5679a);
    }
}
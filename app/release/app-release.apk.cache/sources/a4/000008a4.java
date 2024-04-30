package n;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;

/* loaded from: classes.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static final e f5671b = new e();

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f5672c = {"standard", "accelerate", "decelerate", "linear"};

    /* renamed from: a  reason: collision with root package name */
    public String f5673a = "identity";

    public static e c(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new d(str);
        }
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1354466595:
                if (str.equals("accelerate")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1263948740:
                if (str.equals("decelerate")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c4 = 2;
                    break;
                }
                break;
            case 1312628413:
                if (str.equals("standard")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return new d("cubic(0.4, 0.05, 0.8, 0.7)");
            case 1:
                return new d("cubic(0.0, 0.0, 0.2, 0.95)");
            case 2:
                return new d("cubic(1, 1, 0, 0)");
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                return new d("cubic(0.4, 0.0, 0.2, 1)");
            default:
                Log.e("ConstraintSet", "transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(f5672c));
                return f5671b;
        }
    }

    public double b(double d4) {
        return 1.0d;
    }

    public final String toString() {
        return this.f5673a;
    }

    public double a(double d4) {
        return d4;
    }
}
package o;

import androidx.constraintlayout.widget.ConstraintAttribute$AttributeType;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class w implements Comparable {

    /* renamed from: n  reason: collision with root package name */
    public static final String[] f5898n = {"position", "x", "y", "width", "height", "pathRotate"};

    /* renamed from: a  reason: collision with root package name */
    public n.e f5899a;

    /* renamed from: c  reason: collision with root package name */
    public float f5901c;

    /* renamed from: d  reason: collision with root package name */
    public float f5902d;

    /* renamed from: e  reason: collision with root package name */
    public float f5903e;

    /* renamed from: f  reason: collision with root package name */
    public float f5904f;

    /* renamed from: g  reason: collision with root package name */
    public float f5905g;

    /* renamed from: h  reason: collision with root package name */
    public float f5906h;

    /* renamed from: b  reason: collision with root package name */
    public int f5900b = 0;

    /* renamed from: i  reason: collision with root package name */
    public float f5907i = Float.NaN;

    /* renamed from: j  reason: collision with root package name */
    public int f5908j = -1;

    /* renamed from: k  reason: collision with root package name */
    public final LinkedHashMap f5909k = new LinkedHashMap();

    /* renamed from: l  reason: collision with root package name */
    public double[] f5910l = new double[18];

    /* renamed from: m  reason: collision with root package name */
    public double[] f5911m = new double[18];

    public static boolean b(float f4, float f5) {
        if (!Float.isNaN(f4) && !Float.isNaN(f5)) {
            if (Math.abs(f4 - f5) <= 1.0E-6f) {
                return false;
            }
            return true;
        } else if (Float.isNaN(f4) == Float.isNaN(f5)) {
            return false;
        } else {
            return true;
        }
    }

    public static void d(float f4, float f5, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            float f10 = (float) dArr[i4];
            double d4 = dArr2[i4];
            int i5 = iArr[i4];
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 == 4) {
                            f9 = f10;
                        }
                    } else {
                        f7 = f10;
                    }
                } else {
                    f8 = f10;
                }
            } else {
                f6 = f10;
            }
        }
        float f11 = f6 - ((0.0f * f7) / 2.0f);
        float f12 = f8 - ((0.0f * f9) / 2.0f);
        fArr[0] = (((f7 * 1.0f) + f11) * f4) + ((1.0f - f4) * f11) + 0.0f;
        fArr[1] = (((f9 * 1.0f) + f12) * f5) + ((1.0f - f5) * f12) + 0.0f;
    }

    public final void a(androidx.constraintlayout.widget.c cVar) {
        this.f5899a = n.e.c(cVar.f1313c.f6624c);
        t.f fVar = cVar.f1313c;
        this.f5908j = fVar.f6625d;
        this.f5907i = fVar.f6628g;
        this.f5900b = fVar.f6626e;
        float f4 = cVar.f1312b.f6633e;
        for (String str : cVar.f1316f.keySet()) {
            t.a aVar = (t.a) cVar.f1316f.get(str);
            if (aVar.f6561b != ConstraintAttribute$AttributeType.f1219e) {
                this.f5909k.put(str, aVar);
            }
        }
    }

    public final void c(int[] iArr, double[] dArr, float[] fArr, int i4) {
        float f4 = this.f5903e;
        float f5 = this.f5904f;
        float f6 = this.f5905g;
        float f7 = this.f5906h;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            float f8 = (float) dArr[i5];
            int i6 = iArr[i5];
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 3) {
                        if (i6 == 4) {
                            f7 = f8;
                        }
                    } else {
                        f6 = f8;
                    }
                } else {
                    f5 = f8;
                }
            } else {
                f4 = f8;
            }
        }
        fArr[i4] = (f6 / 2.0f) + f4 + 0.0f;
        fArr[i4 + 1] = (f7 / 2.0f) + f5 + 0.0f;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Float.compare(this.f5902d, ((w) obj).f5902d);
    }
}
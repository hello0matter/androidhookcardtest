package o;

import android.util.Log;
import android.view.View;
import androidx.appcompat.app.o0;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class j0 {

    /* renamed from: a  reason: collision with root package name */
    public com.google.common.collect.c f5821a;

    /* renamed from: b  reason: collision with root package name */
    public String f5822b;

    /* renamed from: c  reason: collision with root package name */
    public final float[] f5823c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5824d;

    /* renamed from: e  reason: collision with root package name */
    public long f5825e;

    /* renamed from: f  reason: collision with root package name */
    public float f5826f;

    public j0() {
        float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, 10, 3);
        this.f5823c = new float[3];
        this.f5824d = false;
        this.f5826f = Float.NaN;
    }

    public final float a(float f4, long j4, View view, o0 o0Var) {
        HashMap hashMap;
        float f5;
        float[] fArr = this.f5823c;
        this.f5821a.K0(f4, fArr);
        boolean z4 = true;
        float f6 = fArr[1];
        int i4 = (f6 > 0.0f ? 1 : (f6 == 0.0f ? 0 : -1));
        if (i4 == 0) {
            this.f5824d = false;
            return fArr[2];
        }
        if (Float.isNaN(this.f5826f)) {
            String str = this.f5822b;
            float f7 = Float.NaN;
            if (((HashMap) o0Var.f311b).containsKey(view)) {
                HashMap hashMap2 = (HashMap) ((HashMap) o0Var.f311b).get(view);
                if (hashMap2.containsKey(str)) {
                    float[] fArr2 = (float[]) hashMap2.get(str);
                    if (fArr2.length > 0) {
                        f7 = fArr2[0];
                    }
                }
            }
            this.f5826f = f7;
            if (Float.isNaN(f7)) {
                this.f5826f = 0.0f;
            }
        }
        float f8 = (float) (((((j4 - this.f5825e) * 1.0E-9d) * f6) + this.f5826f) % 1.0d);
        this.f5826f = f8;
        String str2 = this.f5822b;
        if (!((HashMap) o0Var.f311b).containsKey(view)) {
            hashMap = new HashMap();
            hashMap.put(str2, new float[]{f8});
        } else {
            hashMap = (HashMap) ((HashMap) o0Var.f311b).get(view);
            if (!hashMap.containsKey(str2)) {
                hashMap.put(str2, new float[]{f8});
            } else {
                float[] fArr3 = (float[]) hashMap.get(str2);
                if (fArr3.length <= 0) {
                    fArr3 = Arrays.copyOf(fArr3, 1);
                }
                fArr3[0] = f8;
                hashMap.put(str2, fArr3);
                this.f5825e = j4;
                f5 = fArr[0];
                float sin = (((float) Math.sin(this.f5826f * 6.2831855f)) * f5) + fArr[2];
                if (f5 == 0.0f && i4 == 0) {
                    z4 = false;
                }
                this.f5824d = z4;
                return sin;
            }
        }
        ((HashMap) o0Var.f311b).put(view, hashMap);
        this.f5825e = j4;
        f5 = fArr[0];
        float sin2 = (((float) Math.sin(this.f5826f * 6.2831855f)) * f5) + fArr[2];
        if (f5 == 0.0f) {
            z4 = false;
        }
        this.f5824d = z4;
        return sin2;
    }

    public abstract boolean b(float f4, long j4, View view, o0 o0Var);

    public void c(int i4) {
        Log.e("SplineSet", "Error no points added to " + this.f5822b);
    }

    public final String toString() {
        String str = this.f5822b;
        new DecimalFormat("##.##");
        return str;
    }
}
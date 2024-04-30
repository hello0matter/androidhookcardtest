package a0;

import android.graphics.Color;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public float f2a;

    /* renamed from: b  reason: collision with root package name */
    public float f3b;

    /* renamed from: c  reason: collision with root package name */
    public float f4c;

    /* renamed from: d  reason: collision with root package name */
    public float f5d;

    /* renamed from: e  reason: collision with root package name */
    public float f6e;

    /* renamed from: f  reason: collision with root package name */
    public float f7f;

    public a(float f4, float f5, float f6, float f7, float f8, float f9) {
        this.f2a = f4;
        this.f3b = f5;
        this.f4c = f6;
        this.f5d = f7;
        this.f6e = f8;
        this.f7f = f9;
    }

    public static a b(int i4) {
        float f4;
        float pow;
        u uVar = u.f41k;
        float b5 = b.b(Color.red(i4));
        float b6 = b.b(Color.green(i4));
        float b7 = b.b(Color.blue(i4));
        float[][] fArr = b.f11d;
        float[] fArr2 = fArr[0];
        float f5 = (fArr2[2] * b7) + (fArr2[1] * b6) + (fArr2[0] * b5);
        float[] fArr3 = fArr[1];
        float f6 = fArr3[1] * b6;
        float f7 = fArr3[2] * b7;
        float[] fArr4 = fArr[2];
        float[] fArr5 = {f5, f7 + f6 + (fArr3[0] * b5), (b7 * fArr4[2]) + (b6 * fArr4[1]) + (b5 * fArr4[0])};
        float[][] fArr6 = b.f8a;
        float f8 = fArr5[0];
        float[] fArr7 = fArr6[0];
        float f9 = fArr5[1];
        float f10 = fArr7[1] * f9;
        float f11 = fArr5[2];
        float f12 = (fArr7[2] * f11) + f10 + (fArr7[0] * f8);
        float[] fArr8 = fArr6[1];
        float f13 = fArr8[1] * f9;
        float f14 = fArr8[2] * f11;
        float[] fArr9 = fArr6[2];
        float f15 = f8 * fArr9[0];
        float f16 = f11 * fArr9[2];
        float[] fArr10 = uVar.f48g;
        float f17 = fArr10[0] * f12;
        float f18 = fArr10[1] * (f14 + f13 + (fArr8[0] * f8));
        float f19 = fArr10[2] * (f16 + (f9 * fArr9[1]) + f15);
        float abs = Math.abs(f17);
        float f20 = uVar.f49h;
        float pow2 = (float) Math.pow((abs * f20) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow((Math.abs(f18) * f20) / 100.0d, 0.42d);
        float pow4 = (float) Math.pow((Math.abs(f19) * f20) / 100.0d, 0.42d);
        float signum = ((Math.signum(f17) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum2 = ((Math.signum(f18) * 400.0f) * pow3) / (pow3 + 27.13f);
        float signum3 = ((Math.signum(f19) * 400.0f) * pow4) / (pow4 + 27.13f);
        double d4 = signum3;
        float f21 = ((float) (((signum2 * (-12.0d)) + (signum * 11.0d)) + d4)) / 11.0f;
        float f22 = ((float) ((signum + signum2) - (d4 * 2.0d))) / 9.0f;
        float f23 = signum2 * 20.0f;
        float f24 = ((21.0f * signum3) + ((signum * 20.0f) + f23)) / 20.0f;
        float f25 = (((signum * 40.0f) + f23) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2(f22, f21)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f26 = atan2;
        float f27 = (3.1415927f * f26) / 180.0f;
        float f28 = f25 * uVar.f43b;
        float f29 = uVar.f42a;
        float f30 = uVar.f45d;
        float pow5 = ((float) Math.pow(f28 / f29, uVar.f51j * f30)) * 100.0f;
        Math.sqrt(pow5 / 100.0f);
        float f31 = f29 + 4.0f;
        if (f26 < 20.14d) {
            f4 = 360.0f + f26;
        } else {
            f4 = f26;
        }
        float pow6 = ((float) Math.pow(1.64d - Math.pow(0.29d, uVar.f47f), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((f4 * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * uVar.f46e) * uVar.f44c) * ((float) Math.sqrt((f22 * f22) + (f21 * f21)))) / (f24 + 0.305f), 0.9d)) * ((float) Math.sqrt(pow5 / 100.0d));
        Math.sqrt((pow * f30) / f31);
        float f32 = (1.7f * pow5) / ((0.007f * pow5) + 1.0f);
        float log = ((float) Math.log((uVar.f50i * pow6 * 0.0228f) + 1.0f)) * 43.85965f;
        double d5 = f27;
        return new a(f26, pow6, pow5, f32, log * ((float) Math.cos(d5)), log * ((float) Math.sin(d5)));
    }

    public static a c(float f4, float f5, float f6) {
        u uVar;
        double d4;
        float f7 = u.f41k.f45d;
        Math.sqrt(f4 / 100.0d);
        Math.sqrt(((f5 / ((float) Math.sqrt(d4))) * uVar.f45d) / (uVar.f42a + 4.0f));
        float f8 = (1.7f * f4) / ((0.007f * f4) + 1.0f);
        float log = ((float) Math.log((uVar.f50i * f5 * 0.0228d) + 1.0d)) * 43.85965f;
        double d5 = (3.1415927f * f6) / 180.0f;
        return new a(f6, f5, f4, f8, log * ((float) Math.cos(d5)), log * ((float) Math.sin(d5)));
    }

    public void a(float f4, float f5, int i4, int i5, float[] fArr) {
        float f6;
        float f7 = fArr[0];
        float f8 = fArr[1];
        float f9 = (f5 - 0.5f) * 2.0f;
        float f10 = f7 + this.f4c;
        float f11 = f8 + this.f5d;
        float f12 = (this.f2a * (f4 - 0.5f) * 2.0f) + f10;
        float f13 = (this.f3b * f9) + f11;
        float radians = (float) Math.toRadians(this.f7f);
        float radians2 = (float) Math.toRadians(this.f6e);
        double d4 = radians;
        double sin = Math.sin(d4);
        double d5 = i5 * f9;
        double cos = Math.cos(d4);
        fArr[0] = (((float) ((sin * ((-i4) * f6)) - (Math.cos(d4) * d5))) * radians2) + f12;
        fArr[1] = (radians2 * ((float) ((cos * (i4 * f6)) - (Math.sin(d4) * d5)))) + f13;
    }

    public int d(u uVar) {
        float f4;
        float[] fArr;
        float f5 = this.f3b;
        int i4 = (f5 > 0.0d ? 1 : (f5 == 0.0d ? 0 : -1));
        float f6 = this.f4c;
        if (i4 != 0) {
            double d4 = f6;
            if (d4 != 0.0d) {
                f4 = f5 / ((float) Math.sqrt(d4 / 100.0d));
                float pow = (float) Math.pow(f4 / Math.pow(1.64d - Math.pow(0.29d, uVar.f47f), 0.73d), 1.1111111111111112d);
                double d5 = (this.f2a * 3.1415927f) / 180.0f;
                float pow2 = uVar.f42a * ((float) Math.pow(f6 / 100.0d, (1.0d / uVar.f45d) / uVar.f51j));
                float cos = ((float) (Math.cos(2.0d + d5) + 3.8d)) * 0.25f * 3846.1538f * uVar.f46e * uVar.f44c;
                float f7 = pow2 / uVar.f43b;
                float sin = (float) Math.sin(d5);
                float cos2 = (float) Math.cos(d5);
                float f8 = (((0.305f + f7) * 23.0f) * pow) / (((pow * 108.0f) * sin) + (((11.0f * pow) * cos2) + (cos * 23.0f)));
                float f9 = cos2 * f8;
                float f10 = f8 * sin;
                float f11 = f7 * 460.0f;
                float f12 = ((288.0f * f10) + ((451.0f * f9) + f11)) / 1403.0f;
                float f13 = ((f11 - (891.0f * f9)) - (261.0f * f10)) / 1403.0f;
                float f14 = ((f11 - (f9 * 220.0f)) - (f10 * 6300.0f)) / 1403.0f;
                float max = (float) Math.max(0.0d, (Math.abs(f12) * 27.13d) / (400.0d - Math.abs(f12)));
                float signum = Math.signum(f12);
                float f15 = 100.0f / uVar.f49h;
                float pow3 = signum * f15 * ((float) Math.pow(max, 2.380952380952381d));
                float signum2 = Math.signum(f13) * f15 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f13) * 27.13d) / (400.0d - Math.abs(f13))), 2.380952380952381d));
                float[] fArr2 = uVar.f48g;
                float f16 = pow3 / fArr2[0];
                float f17 = signum2 / fArr2[1];
                float signum3 = ((Math.signum(f14) * f15) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f14) * 27.13d) / (400.0d - Math.abs(f14))), 2.380952380952381d))) / fArr2[2];
                float[][] fArr3 = b.f9b;
                float[] fArr4 = fArr3[0];
                float f18 = (fArr4[2] * signum3) + (fArr4[1] * f17) + (fArr4[0] * f16);
                float[] fArr5 = fArr3[1];
                float f19 = fArr5[1] * f17;
                float f20 = fArr5[2] * signum3;
                float f21 = f16 * fArr3[2][0];
                return b0.a.a(f18, f20 + f19 + (fArr5[0] * f16), (signum3 * fArr[2]) + (f17 * fArr[1]) + f21);
            }
        }
        f4 = 0.0f;
        float pow4 = (float) Math.pow(f4 / Math.pow(1.64d - Math.pow(0.29d, uVar.f47f), 0.73d), 1.1111111111111112d);
        double d52 = (this.f2a * 3.1415927f) / 180.0f;
        float pow22 = uVar.f42a * ((float) Math.pow(f6 / 100.0d, (1.0d / uVar.f45d) / uVar.f51j));
        float cos3 = ((float) (Math.cos(2.0d + d52) + 3.8d)) * 0.25f * 3846.1538f * uVar.f46e * uVar.f44c;
        float f72 = pow22 / uVar.f43b;
        float sin2 = (float) Math.sin(d52);
        float cos22 = (float) Math.cos(d52);
        float f82 = (((0.305f + f72) * 23.0f) * pow4) / (((pow4 * 108.0f) * sin2) + (((11.0f * pow4) * cos22) + (cos3 * 23.0f)));
        float f92 = cos22 * f82;
        float f102 = f82 * sin2;
        float f112 = f72 * 460.0f;
        float f122 = ((288.0f * f102) + ((451.0f * f92) + f112)) / 1403.0f;
        float f132 = ((f112 - (891.0f * f92)) - (261.0f * f102)) / 1403.0f;
        float f142 = ((f112 - (f92 * 220.0f)) - (f102 * 6300.0f)) / 1403.0f;
        float max2 = (float) Math.max(0.0d, (Math.abs(f122) * 27.13d) / (400.0d - Math.abs(f122)));
        float signum4 = Math.signum(f122);
        float f152 = 100.0f / uVar.f49h;
        float pow32 = signum4 * f152 * ((float) Math.pow(max2, 2.380952380952381d));
        float signum22 = Math.signum(f132) * f152 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f132) * 27.13d) / (400.0d - Math.abs(f132))), 2.380952380952381d));
        float[] fArr22 = uVar.f48g;
        float f162 = pow32 / fArr22[0];
        float f172 = signum22 / fArr22[1];
        float signum32 = ((Math.signum(f142) * f152) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f142) * 27.13d) / (400.0d - Math.abs(f142))), 2.380952380952381d))) / fArr22[2];
        float[][] fArr32 = b.f9b;
        float[] fArr42 = fArr32[0];
        float f182 = (fArr42[2] * signum32) + (fArr42[1] * f172) + (fArr42[0] * f162);
        float[] fArr52 = fArr32[1];
        float f192 = fArr52[1] * f172;
        float f202 = fArr52[2] * signum32;
        float f212 = f162 * fArr32[2][0];
        return b0.a.a(f182, f202 + f192 + (fArr52[0] * f162), (signum32 * fArr[2]) + (f172 * fArr[1]) + f212);
    }
}
package b0;

import android.graphics.Path;
import android.util.Log;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public char f2495a;

    /* renamed from: b  reason: collision with root package name */
    public float[] f2496b;

    public static void a(Path path, float f4, float f5, float f6, float f7, float f8, float f9, float f10, boolean z4, boolean z5) {
        double d4;
        double d5;
        double radians = Math.toRadians(f10);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double d6 = f4;
        double d7 = f5;
        double d8 = (d7 * sin) + (d6 * cos);
        double d9 = d6;
        double d10 = f8;
        double d11 = d8 / d10;
        double d12 = f9;
        double d13 = ((d7 * cos) + ((-f4) * sin)) / d12;
        double d14 = d7;
        double d15 = f7;
        double d16 = ((d15 * sin) + (f6 * cos)) / d10;
        double d17 = ((d15 * cos) + ((-f6) * sin)) / d12;
        double d18 = d11 - d16;
        double d19 = d13 - d17;
        double d20 = (d11 + d16) / 2.0d;
        double d21 = (d13 + d17) / 2.0d;
        double d22 = (d19 * d19) + (d18 * d18);
        if (d22 == 0.0d) {
            Log.w("PathParser", " Points are coincident");
            return;
        }
        double d23 = (1.0d / d22) - 0.25d;
        if (d23 < 0.0d) {
            Log.w("PathParser", "Points are too far apart " + d22);
            float sqrt = (float) (Math.sqrt(d22) / 1.99999d);
            a(path, f4, f5, f6, f7, f8 * sqrt, f9 * sqrt, f10, z4, z5);
            return;
        }
        double sqrt2 = Math.sqrt(d23);
        double d24 = d18 * sqrt2;
        double d25 = sqrt2 * d19;
        if (z4 == z5) {
            d4 = d20 - d25;
            d5 = d21 + d24;
        } else {
            d4 = d20 + d25;
            d5 = d21 - d24;
        }
        double atan2 = Math.atan2(d13 - d5, d11 - d4);
        double atan22 = Math.atan2(d17 - d5, d16 - d4) - atan2;
        int i4 = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
        if (z5 != (i4 >= 0)) {
            atan22 = i4 > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
        }
        double d26 = d4 * d10;
        double d27 = d5 * d12;
        double d28 = (d26 * cos) - (d27 * sin);
        double d29 = (d27 * cos) + (d26 * sin);
        int ceil = (int) Math.ceil(Math.abs((atan22 * 4.0d) / 3.141592653589793d));
        double cos2 = Math.cos(radians);
        double sin2 = Math.sin(radians);
        double cos3 = Math.cos(atan2);
        double sin3 = Math.sin(atan2);
        double d30 = -d10;
        double d31 = d30 * cos2;
        double d32 = d12 * sin2;
        double d33 = (d31 * sin3) - (d32 * cos3);
        double d34 = d30 * sin2;
        double d35 = d12 * cos2;
        double d36 = (cos3 * d35) + (sin3 * d34);
        double d37 = d35;
        double d38 = atan22 / ceil;
        int i5 = 0;
        while (i5 < ceil) {
            double d39 = atan2 + d38;
            double sin4 = Math.sin(d39);
            double cos4 = Math.cos(d39);
            double d40 = d38;
            double d41 = (((d10 * cos2) * cos4) + d28) - (d32 * sin4);
            double d42 = d37;
            double d43 = d28;
            double d44 = (d42 * sin4) + (d10 * sin2 * cos4) + d29;
            double d45 = (d31 * sin4) - (d32 * cos4);
            double d46 = (cos4 * d42) + (sin4 * d34);
            double d47 = d39 - atan2;
            double tan = Math.tan(d47 / 2.0d);
            double sqrt3 = ((Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d) * Math.sin(d47)) / 3.0d;
            path.rLineTo(0.0f, 0.0f);
            path.cubicTo((float) ((d33 * sqrt3) + d9), (float) ((d36 * sqrt3) + d14), (float) (d41 - (sqrt3 * d45)), (float) (d44 - (sqrt3 * d46)), (float) d41, (float) d44);
            i5++;
            atan2 = d39;
            d34 = d34;
            cos2 = cos2;
            ceil = ceil;
            d36 = d46;
            d10 = d10;
            d33 = d45;
            d9 = d41;
            d14 = d44;
            d28 = d43;
            d38 = d40;
            d37 = d42;
        }
    }

    public static void b(f[] fVarArr, Path path) {
        int i4;
        int i5;
        float[] fArr;
        char c4;
        int i6;
        boolean z4;
        boolean z5;
        float f4;
        float f5;
        boolean z6;
        boolean z7;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        f[] fVarArr2 = fVarArr;
        int i7 = 6;
        float[] fArr2 = new float[6];
        char c5 = 'm';
        int i8 = 0;
        char c6 = 'm';
        int i9 = 0;
        while (i9 < fVarArr2.length) {
            f fVar = fVarArr2[i9];
            char c7 = fVar.f2495a;
            float[] fArr3 = fVar.f2496b;
            float f18 = fArr2[i8];
            float f19 = fArr2[1];
            float f20 = fArr2[2];
            float f21 = fArr2[3];
            float f22 = fArr2[4];
            float f23 = fArr2[5];
            switch (c7) {
                case 'A':
                case 'a':
                    i4 = 7;
                    break;
                case 'C':
                case 'c':
                    i4 = i7;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i4 = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i4 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f22, f23);
                    f18 = f22;
                    f20 = f18;
                    f19 = f23;
                    f21 = f19;
                default:
                    i4 = 2;
                    break;
            }
            float f24 = f22;
            float f25 = f23;
            float f26 = f18;
            float f27 = f19;
            int i10 = i8;
            while (i10 < fArr3.length) {
                if (c7 != 'A') {
                    if (c7 != 'C') {
                        if (c7 != 'H') {
                            if (c7 != 'Q') {
                                if (c7 != 'V') {
                                    if (c7 != 'a') {
                                        if (c7 != 'c') {
                                            if (c7 != 'h') {
                                                if (c7 != 'q') {
                                                    if (c7 != 'v') {
                                                        if (c7 != 'L') {
                                                            if (c7 != 'M') {
                                                                if (c7 != 'S') {
                                                                    if (c7 != 'T') {
                                                                        if (c7 != 'l') {
                                                                            if (c7 != c5) {
                                                                                if (c7 != 's') {
                                                                                    if (c7 != 't') {
                                                                                        i5 = i10;
                                                                                    } else {
                                                                                        if (c6 != 'q' && c6 != 't' && c6 != 'Q' && c6 != 'T') {
                                                                                            f17 = 0.0f;
                                                                                            f16 = 0.0f;
                                                                                        } else {
                                                                                            f16 = f26 - f20;
                                                                                            f17 = f27 - f21;
                                                                                        }
                                                                                        int i11 = i10 + 1;
                                                                                        path.rQuadTo(f16, f17, fArr3[i10], fArr3[i11]);
                                                                                        float f28 = f16 + f26;
                                                                                        float f29 = f17 + f27;
                                                                                        f26 += fArr3[i10];
                                                                                        f27 += fArr3[i11];
                                                                                        f21 = f29;
                                                                                        i5 = i10;
                                                                                        fArr = fArr3;
                                                                                        c4 = c7;
                                                                                        i6 = i9;
                                                                                        f20 = f28;
                                                                                    }
                                                                                } else {
                                                                                    if (c6 != 'c' && c6 != 's' && c6 != 'C' && c6 != 'S') {
                                                                                        f15 = 0.0f;
                                                                                        f14 = 0.0f;
                                                                                    } else {
                                                                                        f14 = f27 - f21;
                                                                                        f15 = f26 - f20;
                                                                                    }
                                                                                    int i12 = i10 + 1;
                                                                                    int i13 = i10 + 2;
                                                                                    int i14 = i10 + 3;
                                                                                    i5 = i10;
                                                                                    f6 = f27;
                                                                                    float f30 = f26;
                                                                                    path.rCubicTo(f15, f14, fArr3[i10], fArr3[i12], fArr3[i13], fArr3[i14]);
                                                                                    f7 = f30 + fArr3[i5];
                                                                                    f8 = f6 + fArr3[i12];
                                                                                    f9 = f30 + fArr3[i13];
                                                                                    f10 = fArr3[i14];
                                                                                }
                                                                            } else {
                                                                                i5 = i10;
                                                                                float f31 = fArr3[i5];
                                                                                f26 += f31;
                                                                                float f32 = fArr3[i5 + 1];
                                                                                f27 += f32;
                                                                                if (i5 > 0) {
                                                                                    path.rLineTo(f31, f32);
                                                                                } else {
                                                                                    path.rMoveTo(f31, f32);
                                                                                    f25 = f27;
                                                                                    f24 = f26;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            i5 = i10;
                                                                            int i15 = i5 + 1;
                                                                            path.rLineTo(fArr3[i5], fArr3[i15]);
                                                                            f26 += fArr3[i5];
                                                                            f27 += fArr3[i15];
                                                                        }
                                                                    } else {
                                                                        i5 = i10;
                                                                        float f33 = f27;
                                                                        float f34 = f26;
                                                                        if (c6 != 'q' && c6 != 't' && c6 != 'Q' && c6 != 'T') {
                                                                            f7 = f34;
                                                                            f8 = f33;
                                                                        } else {
                                                                            f7 = (f34 * 2.0f) - f20;
                                                                            f8 = (f33 * 2.0f) - f21;
                                                                        }
                                                                        int i16 = i5 + 1;
                                                                        path.quadTo(f7, f8, fArr3[i5], fArr3[i16]);
                                                                        f9 = fArr3[i5];
                                                                        f11 = fArr3[i16];
                                                                        f21 = f8;
                                                                        f20 = f7;
                                                                        fArr = fArr3;
                                                                        c4 = c7;
                                                                        i6 = i9;
                                                                        f26 = f9;
                                                                        f27 = f11;
                                                                    }
                                                                } else {
                                                                    i5 = i10;
                                                                    float f35 = f27;
                                                                    float f36 = f26;
                                                                    if (c6 != 'c' && c6 != 's' && c6 != 'C' && c6 != 'S') {
                                                                        f13 = f36;
                                                                        f12 = f35;
                                                                    } else {
                                                                        f12 = (f35 * 2.0f) - f21;
                                                                        f13 = (f36 * 2.0f) - f20;
                                                                    }
                                                                    int i17 = i5 + 1;
                                                                    int i18 = i5 + 2;
                                                                    int i19 = i5 + 3;
                                                                    path.cubicTo(f13, f12, fArr3[i5], fArr3[i17], fArr3[i18], fArr3[i19]);
                                                                    float f37 = fArr3[i5];
                                                                    float f38 = fArr3[i17];
                                                                    f26 = fArr3[i18];
                                                                    f27 = fArr3[i19];
                                                                    f21 = f38;
                                                                    f20 = f37;
                                                                }
                                                            } else {
                                                                i5 = i10;
                                                                f26 = fArr3[i5];
                                                                f27 = fArr3[i5 + 1];
                                                                if (i5 > 0) {
                                                                    path.lineTo(f26, f27);
                                                                } else {
                                                                    path.moveTo(f26, f27);
                                                                    f25 = f27;
                                                                    f24 = f26;
                                                                }
                                                            }
                                                        } else {
                                                            i5 = i10;
                                                            int i20 = i5 + 1;
                                                            path.lineTo(fArr3[i5], fArr3[i20]);
                                                            f26 = fArr3[i5];
                                                            f27 = fArr3[i20];
                                                        }
                                                    } else {
                                                        i5 = i10;
                                                        path.rLineTo(0.0f, fArr3[i5]);
                                                        f27 += fArr3[i5];
                                                    }
                                                } else {
                                                    i5 = i10;
                                                    float f39 = f27;
                                                    float f40 = f26;
                                                    int i21 = i5 + 1;
                                                    int i22 = i5 + 2;
                                                    int i23 = i5 + 3;
                                                    path.rQuadTo(fArr3[i5], fArr3[i21], fArr3[i22], fArr3[i23]);
                                                    float f41 = f40 + fArr3[i5];
                                                    float f42 = f40 + fArr3[i22];
                                                    f27 = f39 + fArr3[i23];
                                                    f21 = fArr3[i21] + f39;
                                                    f20 = f41;
                                                    fArr = fArr3;
                                                    c4 = c7;
                                                    i6 = i9;
                                                    f26 = f42;
                                                }
                                            } else {
                                                i5 = i10;
                                                path.rLineTo(fArr3[i5], 0.0f);
                                                f26 += fArr3[i5];
                                            }
                                            fArr = fArr3;
                                            c4 = c7;
                                            i6 = i9;
                                        } else {
                                            i5 = i10;
                                            f6 = f27;
                                            float f43 = f26;
                                            int i24 = i5 + 2;
                                            int i25 = i5 + 3;
                                            int i26 = i5 + 4;
                                            int i27 = i5 + 5;
                                            path.rCubicTo(fArr3[i5], fArr3[i5 + 1], fArr3[i24], fArr3[i25], fArr3[i26], fArr3[i27]);
                                            f7 = f43 + fArr3[i24];
                                            f8 = f6 + fArr3[i25];
                                            f9 = f43 + fArr3[i26];
                                            f10 = fArr3[i27];
                                        }
                                        f11 = f10 + f6;
                                        f21 = f8;
                                        f20 = f7;
                                        fArr = fArr3;
                                        c4 = c7;
                                        i6 = i9;
                                        f26 = f9;
                                        f27 = f11;
                                    } else {
                                        i5 = i10;
                                        float f44 = f27;
                                        float f45 = f26;
                                        int i28 = i5 + 5;
                                        float f46 = fArr3[i28] + f45;
                                        int i29 = i5 + 6;
                                        float f47 = fArr3[i29] + f44;
                                        float f48 = fArr3[i5];
                                        float f49 = fArr3[i5 + 1];
                                        float f50 = fArr3[i5 + 2];
                                        if (fArr3[i5 + 3] != 0.0f) {
                                            z6 = true;
                                        } else {
                                            z6 = false;
                                        }
                                        if (fArr3[i5 + 4] != 0.0f) {
                                            z7 = true;
                                        } else {
                                            z7 = false;
                                        }
                                        fArr = fArr3;
                                        c4 = c7;
                                        i6 = i9;
                                        a(path, f45, f44, f46, f47, f48, f49, f50, z6, z7);
                                        f26 = f45 + fArr[i28];
                                        f27 = f44 + fArr[i29];
                                    }
                                } else {
                                    i5 = i10;
                                    fArr = fArr3;
                                    c4 = c7;
                                    i6 = i9;
                                    path.lineTo(f26, fArr[i5]);
                                    f27 = fArr[i5];
                                }
                            } else {
                                i5 = i10;
                                fArr = fArr3;
                                c4 = c7;
                                i6 = i9;
                                int i30 = i5 + 1;
                                int i31 = i5 + 2;
                                int i32 = i5 + 3;
                                path.quadTo(fArr[i5], fArr[i30], fArr[i31], fArr[i32]);
                                f4 = fArr[i5];
                                f5 = fArr[i30];
                                f26 = fArr[i31];
                                f27 = fArr[i32];
                            }
                        } else {
                            i5 = i10;
                            fArr = fArr3;
                            c4 = c7;
                            i6 = i9;
                            path.lineTo(fArr[i5], f27);
                            f26 = fArr[i5];
                        }
                        i10 = i5 + i4;
                        c6 = c4;
                        c7 = c6;
                        fArr3 = fArr;
                        i9 = i6;
                        c5 = 'm';
                        i8 = 0;
                    } else {
                        i5 = i10;
                        fArr = fArr3;
                        c4 = c7;
                        i6 = i9;
                        int i33 = i5 + 2;
                        int i34 = i5 + 3;
                        int i35 = i5 + 4;
                        int i36 = i5 + 5;
                        path.cubicTo(fArr[i5], fArr[i5 + 1], fArr[i33], fArr[i34], fArr[i35], fArr[i36]);
                        f26 = fArr[i35];
                        f27 = fArr[i36];
                        f4 = fArr[i33];
                        f5 = fArr[i34];
                    }
                    f20 = f4;
                    f21 = f5;
                    i10 = i5 + i4;
                    c6 = c4;
                    c7 = c6;
                    fArr3 = fArr;
                    i9 = i6;
                    c5 = 'm';
                    i8 = 0;
                } else {
                    i5 = i10;
                    float f51 = f27;
                    float f52 = f26;
                    fArr = fArr3;
                    c4 = c7;
                    i6 = i9;
                    int i37 = i5 + 5;
                    float f53 = fArr[i37];
                    int i38 = i5 + 6;
                    float f54 = fArr[i38];
                    float f55 = fArr[i5];
                    float f56 = fArr[i5 + 1];
                    float f57 = fArr[i5 + 2];
                    if (fArr[i5 + 3] != 0.0f) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (fArr[i5 + 4] != 0.0f) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    a(path, f52, f51, f53, f54, f55, f56, f57, z4, z5);
                    f26 = fArr[i37];
                    f27 = fArr[i38];
                }
                f21 = f27;
                f20 = f26;
                i10 = i5 + i4;
                c6 = c4;
                c7 = c6;
                fArr3 = fArr;
                i9 = i6;
                c5 = 'm';
                i8 = 0;
            }
            int i39 = i9;
            int i40 = i8;
            fArr2[i40] = f26;
            fArr2[1] = f27;
            fArr2[2] = f20;
            fArr2[3] = f21;
            fArr2[4] = f24;
            fArr2[5] = f25;
            i9 = i39 + 1;
            i7 = 6;
            c5 = 'm';
            i8 = i40;
            c6 = fVarArr[i39].f2495a;
            fVarArr2 = fVarArr;
        }
    }
}
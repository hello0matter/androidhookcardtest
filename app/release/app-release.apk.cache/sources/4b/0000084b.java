package l1;

import android.opengl.GLES20;
import androidx.activity.result.h;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f5266a;

    /* renamed from: b  reason: collision with root package name */
    public final a[] f5267b;

    /* renamed from: c  reason: collision with root package name */
    public final h[] f5268c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap f5269d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap f5270e;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, androidx.activity.result.h] */
    public b(String str, String str2) {
        boolean z4;
        byte[] bArr;
        byte[] bArr2;
        int glCreateProgram = GLES20.glCreateProgram();
        this.f5266a = glCreateProgram;
        com.google.common.collect.c.B();
        a(glCreateProgram, 35633, str);
        a(glCreateProgram, 35632, str2);
        GLES20.glLinkProgram(glCreateProgram);
        int i4 = 0;
        int[] iArr = {0};
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        int i5 = 1;
        if (iArr[0] == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        String str3 = "Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(glCreateProgram);
        if (z4) {
            GLES20.glUseProgram(glCreateProgram);
            this.f5269d = new HashMap();
            int[] iArr2 = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35721, iArr2, 0);
            this.f5267b = new a[iArr2[0]];
            int i6 = 0;
            while (i6 < iArr2[0]) {
                int i7 = this.f5266a;
                int[] iArr3 = new int[i5];
                GLES20.glGetProgramiv(i7, 35722, iArr3, 0);
                int i8 = iArr3[0];
                byte[] bArr3 = new byte[i8];
                GLES20.glGetActiveAttrib(i7, i6, i8, new int[i5], 0, new int[i5], 0, new int[i5], 0, bArr3, 0);
                int i9 = 0;
                while (true) {
                    bArr2 = bArr3;
                    if (i9 < i8) {
                        if (bArr2[i9] == 0) {
                            break;
                        }
                        i9++;
                        bArr3 = bArr2;
                    } else {
                        i9 = i8;
                        break;
                    }
                }
                String str4 = new String(bArr2, 0, i9);
                a aVar = new a(i6, GLES20.glGetAttribLocation(i7, str4), str4);
                this.f5267b[i6] = aVar;
                this.f5269d.put(str4, aVar);
                i6++;
                i5 = 1;
            }
            this.f5270e = new HashMap();
            int[] iArr4 = new int[1];
            GLES20.glGetProgramiv(this.f5266a, 35718, iArr4, 0);
            this.f5268c = new h[iArr4[0]];
            for (int i10 = 0; i10 < iArr4[i4]; i10++) {
                int i11 = this.f5266a;
                int[] iArr5 = new int[1];
                GLES20.glGetProgramiv(i11, 35719, iArr5, i4);
                int[] iArr6 = new int[1];
                int i12 = iArr5[i4];
                byte[] bArr4 = new byte[i12];
                GLES20.glGetActiveUniform(i11, i10, i12, new int[1], 0, new int[1], 0, iArr6, 0, bArr4, 0);
                int i13 = 0;
                while (true) {
                    bArr = bArr4;
                    if (i13 < i12) {
                        if (bArr[i13] == 0) {
                            break;
                        }
                        i13++;
                        bArr4 = bArr;
                    } else {
                        i13 = i12;
                        break;
                    }
                }
                i4 = 0;
                String str5 = new String(bArr, 0, i13);
                int glGetUniformLocation = GLES20.glGetUniformLocation(i11, str5);
                int i14 = iArr6[0];
                ?? obj = new Object();
                obj.f148c = str5;
                obj.f146a = glGetUniformLocation;
                obj.f147b = i14;
                obj.f149d = new float[16];
                this.f5268c[i10] = obj;
                this.f5270e.put(str5, obj);
            }
            com.google.common.collect.c.B();
            return;
        }
        throw new Exception(str3);
    }

    public static void a(int i4, int i5, String str) {
        int glCreateShader = GLES20.glCreateShader(i5);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        boolean z4 = false;
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 1) {
            z4 = true;
        }
        String str2 = GLES20.glGetShaderInfoLog(glCreateShader) + ", source: " + str;
        if (z4) {
            GLES20.glAttachShader(i4, glCreateShader);
            GLES20.glDeleteShader(glCreateShader);
            com.google.common.collect.c.B();
            return;
        }
        throw new Exception(str2);
    }

    public final int b(String str) {
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.f5266a, str);
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        com.google.common.collect.c.B();
        return glGetAttribLocation;
    }
}
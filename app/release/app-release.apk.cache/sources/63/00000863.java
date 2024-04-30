package l2;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.BitSet;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    public final z[] f5361a = new z[4];

    /* renamed from: b  reason: collision with root package name */
    public final Matrix[] f5362b = new Matrix[4];

    /* renamed from: c  reason: collision with root package name */
    public final Matrix[] f5363c = new Matrix[4];

    /* renamed from: d  reason: collision with root package name */
    public final PointF f5364d = new PointF();

    /* renamed from: e  reason: collision with root package name */
    public final Path f5365e = new Path();

    /* renamed from: f  reason: collision with root package name */
    public final Path f5366f = new Path();

    /* renamed from: g  reason: collision with root package name */
    public final z f5367g = new z();

    /* renamed from: h  reason: collision with root package name */
    public final float[] f5368h = new float[2];

    /* renamed from: i  reason: collision with root package name */
    public final float[] f5369i = new float[2];

    /* renamed from: j  reason: collision with root package name */
    public final Path f5370j = new Path();

    /* renamed from: k  reason: collision with root package name */
    public final Path f5371k = new Path();

    /* renamed from: l  reason: collision with root package name */
    public final boolean f5372l = true;

    public r() {
        for (int i4 = 0; i4 < 4; i4++) {
            this.f5361a[i4] = new z();
            this.f5362b[i4] = new Matrix();
            this.f5363c[i4] = new Matrix();
        }
    }

    public final void a(p pVar, float f4, RectF rectF, w1.g gVar, Path path) {
        int i4;
        Matrix[] matrixArr;
        float[] fArr;
        Matrix[] matrixArr2;
        z[] zVarArr;
        float centerX;
        float f5;
        f fVar;
        Path path2;
        Path path3;
        w1.g gVar2;
        d dVar;
        com.google.common.collect.c cVar;
        Path path4;
        float f6;
        float f7;
        r rVar = this;
        p pVar2 = pVar;
        w1.g gVar3 = gVar;
        Path path5 = path;
        path.rewind();
        Path path6 = rVar.f5365e;
        path6.rewind();
        Path path7 = rVar.f5366f;
        path7.rewind();
        path7.addRect(rectF, Path.Direction.CW);
        int i5 = 0;
        while (true) {
            i4 = 4;
            matrixArr = rVar.f5363c;
            fArr = rVar.f5368h;
            matrixArr2 = rVar.f5362b;
            zVarArr = rVar.f5361a;
            if (i5 >= 4) {
                break;
            }
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        dVar = pVar2.f5353f;
                    } else {
                        dVar = pVar2.f5352e;
                    }
                } else {
                    dVar = pVar2.f5355h;
                }
            } else {
                dVar = pVar2.f5354g;
            }
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        cVar = pVar2.f5349b;
                    } else {
                        cVar = pVar2.f5348a;
                    }
                } else {
                    cVar = pVar2.f5351d;
                }
            } else {
                cVar = pVar2.f5350c;
            }
            z zVar = zVarArr[i5];
            cVar.getClass();
            cVar.p0(f4, dVar.a(rectF), zVar);
            int i6 = i5 + 1;
            float f8 = (i6 % 4) * 90;
            matrixArr2[i5].reset();
            PointF pointF = rVar.f5364d;
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        path4 = path6;
                        pointF.set(rectF.right, rectF.top);
                        matrixArr2[i5].setTranslate(pointF.x, pointF.y);
                        matrixArr2[i5].preRotate(f8);
                        z zVar2 = zVarArr[i5];
                        fArr[0] = zVar2.f5393c;
                        fArr[1] = zVar2.f5394d;
                        matrixArr2[i5].mapPoints(fArr);
                        matrixArr[i5].reset();
                        matrixArr[i5].setTranslate(fArr[0], fArr[1]);
                        matrixArr[i5].preRotate(f8);
                        i5 = i6;
                        path6 = path4;
                    } else {
                        path4 = path6;
                        f6 = rectF.left;
                        f7 = rectF.top;
                        pointF.set(f6, f7);
                        matrixArr2[i5].setTranslate(pointF.x, pointF.y);
                        matrixArr2[i5].preRotate(f8);
                        z zVar22 = zVarArr[i5];
                        fArr[0] = zVar22.f5393c;
                        fArr[1] = zVar22.f5394d;
                        matrixArr2[i5].mapPoints(fArr);
                        matrixArr[i5].reset();
                        matrixArr[i5].setTranslate(fArr[0], fArr[1]);
                        matrixArr[i5].preRotate(f8);
                        i5 = i6;
                        path6 = path4;
                    }
                } else {
                    path4 = path6;
                    f6 = rectF.left;
                }
            } else {
                path4 = path6;
                f6 = rectF.right;
            }
            f7 = rectF.bottom;
            pointF.set(f6, f7);
            matrixArr2[i5].setTranslate(pointF.x, pointF.y);
            matrixArr2[i5].preRotate(f8);
            z zVar222 = zVarArr[i5];
            fArr[0] = zVar222.f5393c;
            fArr[1] = zVar222.f5394d;
            matrixArr2[i5].mapPoints(fArr);
            matrixArr[i5].reset();
            matrixArr[i5].setTranslate(fArr[0], fArr[1]);
            matrixArr[i5].preRotate(f8);
            i5 = i6;
            path6 = path4;
        }
        Path path8 = path6;
        int i7 = 0;
        while (i7 < i4) {
            z zVar3 = zVarArr[i7];
            fArr[0] = zVar3.f5391a;
            fArr[1] = zVar3.f5392b;
            matrixArr2[i7].mapPoints(fArr);
            if (i7 == 0) {
                path5.moveTo(fArr[0], fArr[1]);
            } else {
                path5.lineTo(fArr[0], fArr[1]);
            }
            zVarArr[i7].c(matrixArr2[i7], path5);
            if (gVar3 != null) {
                z zVar4 = zVarArr[i7];
                Matrix matrix = matrixArr2[i7];
                BitSet bitSet = ((j) gVar3.f7056b).f5313d;
                zVar4.getClass();
                bitSet.set(i7, false);
                y[] yVarArr = ((j) gVar3.f7056b).f5311b;
                zVar4.b(zVar4.f5396f);
                yVarArr[i7] = new s(new ArrayList(zVar4.f5398h), new Matrix(matrix));
            }
            int i8 = i7 + 1;
            int i9 = i8 % 4;
            z zVar5 = zVarArr[i7];
            fArr[0] = zVar5.f5393c;
            fArr[1] = zVar5.f5394d;
            matrixArr2[i7].mapPoints(fArr);
            z zVar6 = zVarArr[i9];
            float f9 = zVar6.f5391a;
            float[] fArr2 = rVar.f5369i;
            fArr2[0] = f9;
            fArr2[1] = zVar6.f5392b;
            matrixArr2[i9].mapPoints(fArr2);
            float max = Math.max(((float) Math.hypot(fArr[0] - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
            z zVar7 = zVarArr[i7];
            fArr[0] = zVar7.f5393c;
            fArr[1] = zVar7.f5394d;
            matrixArr2[i7].mapPoints(fArr);
            if (i7 != 1 && i7 != 3) {
                centerX = rectF.centerY();
                f5 = fArr[1];
            } else {
                centerX = rectF.centerX();
                f5 = fArr[0];
            }
            float abs = Math.abs(centerX - f5);
            z zVar8 = rVar.f5367g;
            zVar8.e(0.0f, 0.0f, 270.0f, 0.0f);
            if (i7 != 1) {
                if (i7 != 2) {
                    if (i7 != 3) {
                        fVar = pVar2.f5357j;
                    } else {
                        fVar = pVar2.f5356i;
                    }
                } else {
                    fVar = pVar2.f5359l;
                }
            } else {
                fVar = pVar2.f5358k;
            }
            fVar.f(max, abs, f4, zVar8);
            Path path9 = rVar.f5370j;
            path9.reset();
            zVar8.c(matrixArr[i7], path9);
            if (!rVar.f5372l || (!fVar.e() && !rVar.b(path9, i7) && !rVar.b(path9, i9))) {
                path2 = path8;
                path3 = path;
                zVar8.c(matrixArr[i7], path3);
                gVar2 = gVar;
            } else {
                path9.op(path9, path7, Path.Op.DIFFERENCE);
                fArr[0] = zVar8.f5391a;
                fArr[1] = zVar8.f5392b;
                matrixArr[i7].mapPoints(fArr);
                path2 = path8;
                path2.moveTo(fArr[0], fArr[1]);
                zVar8.c(matrixArr[i7], path2);
                gVar2 = gVar;
                path3 = path;
            }
            if (gVar2 != null) {
                Matrix matrix2 = matrixArr[i7];
                ((j) gVar2.f7056b).f5313d.set(i7 + 4, false);
                y[] yVarArr2 = ((j) gVar2.f7056b).f5312c;
                zVar8.b(zVar8.f5396f);
                yVarArr2[i7] = new s(new ArrayList(zVar8.f5398h), new Matrix(matrix2));
            }
            rVar = this;
            pVar2 = pVar;
            path5 = path3;
            i7 = i8;
            path8 = path2;
            i4 = 4;
            gVar3 = gVar2;
        }
        Path path10 = path5;
        Path path11 = path8;
        path.close();
        path11.close();
        if (!path11.isEmpty()) {
            path10.op(path11, Path.Op.UNION);
        }
    }

    public final boolean b(Path path, int i4) {
        Path path2 = this.f5371k;
        path2.reset();
        this.f5361a[i4].c(this.f5362b[i4], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (!rectF.isEmpty()) {
            return true;
        }
        if (rectF.width() > 1.0f && rectF.height() > 1.0f) {
            return true;
        }
        return false;
    }
}
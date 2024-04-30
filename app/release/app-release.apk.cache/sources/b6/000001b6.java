package androidx.constraintlayout.utils.widget;

import a0.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.util.HashMap;
import n.b;
import o.e0;
import o.j;
import o.p;
import o.q;
import o.w;
import t.k;

/* loaded from: classes.dex */
public class MotionTelltales extends MockView {

    /* renamed from: l  reason: collision with root package name */
    public final Paint f1205l;

    /* renamed from: m  reason: collision with root package name */
    public MotionLayout f1206m;

    /* renamed from: n  reason: collision with root package name */
    public final float[] f1207n;

    /* renamed from: o  reason: collision with root package name */
    public final Matrix f1208o;

    /* renamed from: p  reason: collision with root package name */
    public int f1209p;

    /* renamed from: q  reason: collision with root package name */
    public int f1210q;

    /* renamed from: r  reason: collision with root package name */
    public float f1211r;

    public MotionTelltales(Context context) {
        super(context);
        this.f1205l = new Paint();
        this.f1207n = new float[2];
        this.f1208o = new Matrix();
        this.f1209p = 0;
        this.f1210q = -65281;
        this.f1211r = 0.25f;
        b(context, null);
    }

    public final void b(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f6660m);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == 0) {
                    this.f1210q = obtainStyledAttributes.getColor(index, this.f1210q);
                } else if (index == 2) {
                    this.f1209p = obtainStyledAttributes.getInt(index, this.f1209p);
                } else if (index == 1) {
                    this.f1211r = obtainStyledAttributes.getFloat(index, this.f1211r);
                }
            }
        }
        int i5 = this.f1210q;
        Paint paint = this.f1205l;
        paint.setColor(i5);
        paint.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* JADX WARN: Type inference failed for: r12v8, types: [java.lang.Object, a0.a] */
    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public final void onDraw(Canvas canvas) {
        float f4;
        int i4;
        Matrix matrix;
        int i5;
        float[] fArr;
        int i6;
        float[] fArr2;
        int i7;
        float f5;
        int i8;
        float f6;
        e0 e0Var;
        float[] fArr3;
        e0 e0Var2;
        int i9;
        e0 e0Var3;
        e0 e0Var4;
        e0 e0Var5;
        j jVar;
        j jVar2;
        j jVar3;
        j jVar4;
        j jVar5;
        p pVar;
        e0 e0Var6;
        float[] fArr4;
        double[] dArr;
        a aVar;
        float f7;
        int i10;
        MotionTelltales motionTelltales = this;
        int i11 = 5;
        super.onDraw(canvas);
        Matrix matrix2 = getMatrix();
        Matrix matrix3 = motionTelltales.f1208o;
        matrix2.invert(matrix3);
        if (motionTelltales.f1206m == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                motionTelltales.f1206m = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float[] fArr5 = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        int i12 = 0;
        while (i12 < i11) {
            float f8 = fArr5[i12];
            int i13 = 0;
            while (i13 < i11) {
                float f9 = fArr5[i13];
                MotionLayout motionLayout = motionTelltales.f1206m;
                int i14 = motionTelltales.f1209p;
                float f10 = motionLayout.f1052s;
                float f11 = motionLayout.D;
                if (motionLayout.f1050r != null) {
                    float signum = Math.signum(motionLayout.F - f11);
                    float interpolation = motionLayout.f1050r.getInterpolation(motionLayout.D + 1.0E-5f);
                    f11 = motionLayout.f1050r.getInterpolation(motionLayout.D);
                    f10 = (((interpolation - f11) / 1.0E-5f) * signum) / motionLayout.B;
                }
                Interpolator interpolator = motionLayout.f1050r;
                if (interpolator instanceof q) {
                    f10 = ((q) interpolator).a();
                }
                float f12 = f10;
                p pVar2 = (p) motionLayout.f1066z.get(motionTelltales);
                int i15 = i14 & 1;
                float[] fArr6 = motionTelltales.f1207n;
                if (i15 == 0) {
                    int width2 = getWidth();
                    int height2 = getHeight();
                    float[] fArr7 = pVar2.f5865t;
                    float a5 = pVar2.a(f11, fArr7);
                    HashMap hashMap = pVar2.f5868w;
                    fArr = fArr5;
                    j jVar6 = null;
                    if (hashMap == null) {
                        fArr3 = fArr6;
                        e0Var = null;
                    } else {
                        e0Var = (e0) hashMap.get("translationX");
                        fArr3 = fArr6;
                    }
                    HashMap hashMap2 = pVar2.f5868w;
                    if (hashMap2 == null) {
                        i9 = i13;
                        e0Var2 = null;
                    } else {
                        e0Var2 = (e0) hashMap2.get("translationY");
                        i9 = i13;
                    }
                    HashMap hashMap3 = pVar2.f5868w;
                    i6 = i12;
                    if (hashMap3 == null) {
                        i5 = height;
                        e0Var3 = null;
                    } else {
                        e0Var3 = (e0) hashMap3.get("rotation");
                        i5 = height;
                    }
                    HashMap hashMap4 = pVar2.f5868w;
                    i4 = width;
                    if (hashMap4 == null) {
                        matrix = matrix3;
                        e0Var4 = null;
                    } else {
                        e0Var4 = (e0) hashMap4.get("scaleX");
                        matrix = matrix3;
                    }
                    HashMap hashMap5 = pVar2.f5868w;
                    if (hashMap5 == null) {
                        f4 = f12;
                        e0Var5 = null;
                    } else {
                        e0Var5 = (e0) hashMap5.get("scaleY");
                        f4 = f12;
                    }
                    HashMap hashMap6 = pVar2.f5869x;
                    if (hashMap6 == null) {
                        jVar = null;
                    } else {
                        jVar = (j) hashMap6.get("translationX");
                    }
                    HashMap hashMap7 = pVar2.f5869x;
                    if (hashMap7 == null) {
                        jVar2 = null;
                    } else {
                        jVar2 = (j) hashMap7.get("translationY");
                    }
                    HashMap hashMap8 = pVar2.f5869x;
                    if (hashMap8 == null) {
                        jVar3 = null;
                    } else {
                        jVar3 = (j) hashMap8.get("rotation");
                    }
                    HashMap hashMap9 = pVar2.f5869x;
                    if (hashMap9 == null) {
                        jVar4 = null;
                    } else {
                        jVar4 = (j) hashMap9.get("scaleX");
                    }
                    HashMap hashMap10 = pVar2.f5869x;
                    if (hashMap10 != null) {
                        jVar6 = (j) hashMap10.get("scaleY");
                    }
                    j jVar7 = jVar6;
                    ?? obj = new Object();
                    obj.f6e = 0.0f;
                    obj.f5d = 0.0f;
                    obj.f4c = 0.0f;
                    obj.f3b = 0.0f;
                    obj.f2a = 0.0f;
                    if (e0Var3 != null) {
                        jVar5 = jVar2;
                        pVar = pVar2;
                        obj.f6e = (float) e0Var3.f5797a.M0(a5);
                        obj.f7f = e0Var3.a(a5);
                    } else {
                        jVar5 = jVar2;
                        pVar = pVar2;
                    }
                    if (e0Var != null) {
                        e0Var6 = e0Var3;
                        f6 = f8;
                        obj.f4c = (float) e0Var.f5797a.M0(a5);
                    } else {
                        e0Var6 = e0Var3;
                        f6 = f8;
                    }
                    if (e0Var2 != null) {
                        obj.f5d = (float) e0Var2.f5797a.M0(a5);
                    }
                    if (e0Var4 != null) {
                        obj.f2a = (float) e0Var4.f5797a.M0(a5);
                    }
                    if (e0Var5 != null) {
                        obj.f3b = (float) e0Var5.f5797a.M0(a5);
                    }
                    if (jVar3 != null) {
                        obj.f6e = jVar3.b(a5);
                    }
                    if (jVar != null) {
                        obj.f4c = jVar.b(a5);
                    }
                    j jVar8 = jVar5;
                    if (jVar5 != null) {
                        obj.f5d = jVar8.b(a5);
                    }
                    if (jVar4 != null || jVar7 != null) {
                        if (jVar4 == null) {
                            obj.f2a = jVar4.b(a5);
                        }
                        if (jVar7 == null) {
                            obj.f3b = jVar7.b(a5);
                        }
                    }
                    p pVar3 = pVar;
                    b bVar = pVar3.f5854i;
                    if (bVar != null) {
                        double[] dArr2 = pVar3.f5859n;
                        if (dArr2.length > 0) {
                            double d4 = a5;
                            bVar.J0(d4, dArr2);
                            pVar3.f5854i.N0(d4, pVar3.f5860o);
                            int[] iArr = pVar3.f5858m;
                            double[] dArr3 = pVar3.f5860o;
                            double[] dArr4 = pVar3.f5859n;
                            pVar3.f5849d.getClass();
                            fArr4 = fArr3;
                            aVar = obj;
                            i10 = i14;
                            f7 = f9;
                            i8 = i9;
                            w.d(f9, f6, fArr4, iArr, dArr3, dArr4);
                        } else {
                            aVar = obj;
                            f7 = f9;
                            fArr4 = fArr3;
                            i10 = i14;
                            i8 = i9;
                        }
                        aVar.a(f7, f6, width2, height2, fArr4);
                        f5 = f7;
                        i7 = i10;
                    } else {
                        fArr4 = fArr3;
                        i8 = i9;
                        if (pVar3.f5853h != null) {
                            double a6 = pVar3.a(a5, fArr7);
                            pVar3.f5853h[0].N0(a6, pVar3.f5860o);
                            pVar3.f5853h[0].J0(a6, pVar3.f5859n);
                            float f13 = fArr7[0];
                            int i16 = 0;
                            while (true) {
                                dArr = pVar3.f5860o;
                                if (i16 >= dArr.length) {
                                    break;
                                }
                                dArr[i16] = dArr[i16] * f13;
                                i16++;
                            }
                            int[] iArr2 = pVar3.f5858m;
                            double[] dArr5 = pVar3.f5859n;
                            pVar3.f5849d.getClass();
                            w.d(f9, f6, fArr4, iArr2, dArr, dArr5);
                            obj.a(f9, f6, width2, height2, fArr4);
                            i7 = i14;
                            f5 = f9;
                        } else {
                            w wVar = pVar3.f5850e;
                            float f14 = wVar.f5903e;
                            w wVar2 = pVar3.f5849d;
                            j jVar9 = jVar4;
                            float f15 = f14 - wVar2.f5903e;
                            float f16 = wVar.f5904f - wVar2.f5904f;
                            j jVar10 = jVar;
                            fArr4[0] = (((wVar.f5905g - wVar2.f5905g) + f15) * f9) + ((1.0f - f9) * f15);
                            fArr4[1] = (((wVar.f5906h - wVar2.f5906h) + f16) * f6) + ((1.0f - f6) * f16);
                            obj.f6e = 0.0f;
                            obj.f5d = 0.0f;
                            obj.f4c = 0.0f;
                            obj.f3b = 0.0f;
                            obj.f2a = 0.0f;
                            if (e0Var6 != null) {
                                fArr2 = fArr4;
                                obj.f6e = (float) e0Var6.f5797a.M0(a5);
                                obj.f7f = e0Var6.a(a5);
                            } else {
                                fArr2 = fArr4;
                            }
                            if (e0Var != null) {
                                obj.f4c = (float) e0Var.f5797a.M0(a5);
                            }
                            if (e0Var2 != null) {
                                obj.f5d = (float) e0Var2.f5797a.M0(a5);
                            }
                            if (e0Var4 != null) {
                                obj.f2a = (float) e0Var4.f5797a.M0(a5);
                            }
                            if (e0Var5 != null) {
                                obj.f3b = (float) e0Var5.f5797a.M0(a5);
                            }
                            if (jVar3 != null) {
                                obj.f6e = jVar3.b(a5);
                            }
                            if (jVar10 != null) {
                                obj.f4c = jVar10.b(a5);
                            }
                            if (jVar8 != null) {
                                obj.f5d = jVar8.b(a5);
                            }
                            if (jVar9 != null || jVar7 != null) {
                                if (jVar9 == null) {
                                    obj.f2a = jVar9.b(a5);
                                }
                                if (jVar7 == null) {
                                    obj.f3b = jVar7.b(a5);
                                }
                            }
                            i7 = i14;
                            f5 = f9;
                            obj.a(f9, f6, width2, height2, fArr2);
                        }
                    }
                    fArr2 = fArr4;
                } else {
                    f4 = f12;
                    i4 = width;
                    matrix = matrix3;
                    i5 = height;
                    fArr = fArr5;
                    i6 = i12;
                    fArr2 = fArr6;
                    i7 = i14;
                    f5 = f9;
                    i8 = i13;
                    f6 = f8;
                    pVar2.b(f11, f5, f6, fArr2);
                }
                if (i7 < 2) {
                    fArr2[0] = fArr2[0] * f4;
                    fArr2[1] = fArr2[1] * f4;
                }
                motionTelltales = this;
                float[] fArr8 = motionTelltales.f1207n;
                Matrix matrix4 = matrix;
                matrix4.mapVectors(fArr8);
                int i17 = i4;
                float f17 = i17 * f5;
                int i18 = i5;
                float f18 = i18 * f6;
                float f19 = fArr8[0];
                float f20 = motionTelltales.f1211r;
                matrix4.mapVectors(fArr8);
                canvas.drawLine(f17, f18, f17 - (f19 * f20), f18 - (fArr8[1] * f20), motionTelltales.f1205l);
                i13 = i8 + 1;
                height = i18;
                f8 = f6;
                fArr5 = fArr;
                i12 = i6;
                i11 = 5;
                matrix3 = matrix4;
                width = i17;
            }
            i12++;
            height = height;
            i11 = 5;
            matrix3 = matrix3;
            width = width;
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.f1199f = charSequence.toString();
        requestLayout();
    }

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1205l = new Paint();
        this.f1207n = new float[2];
        this.f1208o = new Matrix();
        this.f1209p = 0;
        this.f1210q = -65281;
        this.f1211r = 0.25f;
        b(context, attributeSet);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f1205l = new Paint();
        this.f1207n = new float[2];
        this.f1208o = new Matrix();
        this.f1209p = 0;
        this.f1210q = -65281;
        this.f1211r = 0.25f;
        b(context, attributeSet);
    }
}
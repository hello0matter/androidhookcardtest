package androidx.appcompat.widget;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.VisibleForTesting;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;
import java.util.Arrays;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class j3 extends Property {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f804a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j3(Class cls, String str, int i4) {
        super(cls, str);
        this.f804a = i4;
    }

    public final Float a(View view) {
        switch (this.f804a) {
            case 9:
                return Float.valueOf(c1.p0.f2666a.y(view));
            case 10:
            default:
                WeakHashMap weakHashMap = i0.y0.f4999a;
                return Float.valueOf(i0.h0.e(view));
            case 11:
                return Float.valueOf(view.getLayoutParams().width);
            case 12:
                return Float.valueOf(view.getLayoutParams().height);
            case 13:
                WeakHashMap weakHashMap2 = i0.y0.f4999a;
                return Float.valueOf(i0.h0.f(view));
        }
    }

    public final void b(View view, PointF pointF) {
        switch (this.f804a) {
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                c1.p0.a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
                return;
            case VisibleForTesting.PROTECTED /* 4 */:
                c1.p0.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
                return;
            default:
                int round = Math.round(pointF.x);
                int round2 = Math.round(pointF.y);
                c1.p0.a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
                return;
        }
    }

    public final void c(View view, Float f4) {
        switch (this.f804a) {
            case 9:
                c1.p0.b(view, f4.floatValue());
                return;
            case 10:
            default:
                WeakHashMap weakHashMap = i0.y0.f4999a;
                i0.h0.k(view, i0.h0.f(view), view.getPaddingTop(), f4.intValue(), view.getPaddingBottom());
                return;
            case 11:
                view.getLayoutParams().width = f4.intValue();
                view.requestLayout();
                return;
            case 12:
                view.getLayoutParams().height = f4.intValue();
                view.requestLayout();
                return;
            case 13:
                int intValue = f4.intValue();
                int paddingTop = view.getPaddingTop();
                WeakHashMap weakHashMap2 = i0.y0.f4999a;
                i0.h0.k(view, intValue, paddingTop, i0.h0.e(view), view.getPaddingBottom());
                return;
        }
    }

    public final void d(c1.e eVar, PointF pointF) {
        switch (this.f804a) {
            case 1:
                eVar.getClass();
                eVar.f2594a = Math.round(pointF.x);
                int round = Math.round(pointF.y);
                eVar.f2595b = round;
                int i4 = eVar.f2599f + 1;
                eVar.f2599f = i4;
                if (i4 == eVar.f2600g) {
                    c1.p0.a(eVar.f2598e, eVar.f2594a, round, eVar.f2596c, eVar.f2597d);
                    eVar.f2599f = 0;
                    eVar.f2600g = 0;
                    return;
                }
                return;
            default:
                eVar.getClass();
                eVar.f2596c = Math.round(pointF.x);
                int round2 = Math.round(pointF.y);
                eVar.f2597d = round2;
                int i5 = eVar.f2600g + 1;
                eVar.f2600g = i5;
                if (eVar.f2599f == i5) {
                    c1.p0.a(eVar.f2598e, eVar.f2594a, eVar.f2595b, eVar.f2596c, round2);
                    eVar.f2599f = 0;
                    eVar.f2600g = 0;
                    return;
                }
                return;
        }
    }

    public final void e(h2.g gVar, Float f4) {
        switch (this.f804a) {
            case 15:
                float floatValue = f4.floatValue();
                gVar.f4841i = floatValue;
                int i4 = (int) (5400.0f * floatValue);
                float[] fArr = (float[]) gVar.f4619b;
                float f5 = floatValue * 1520.0f;
                fArr[0] = (-20.0f) + f5;
                fArr[1] = f5;
                int i5 = 0;
                while (true) {
                    u0.b bVar = gVar.f4838f;
                    if (i5 < 4) {
                        float f6 = 667;
                        float[] fArr2 = (float[]) gVar.f4619b;
                        fArr2[1] = (bVar.getInterpolation((i4 - h2.g.f4831l[i5]) / f6) * 250.0f) + fArr2[1];
                        float f7 = (i4 - h2.g.f4832m[i5]) / f6;
                        float[] fArr3 = (float[]) gVar.f4619b;
                        fArr3[0] = (bVar.getInterpolation(f7) * 250.0f) + fArr3[0];
                        i5++;
                    } else {
                        float[] fArr4 = (float[]) gVar.f4619b;
                        float f8 = fArr4[0];
                        float f9 = fArr4[1];
                        float f10 = ((f9 - f8) * gVar.f4842j) + f8;
                        fArr4[0] = f10;
                        fArr4[0] = f10 / 360.0f;
                        fArr4[1] = f9 / 360.0f;
                        int i6 = 0;
                        while (true) {
                            if (i6 < 4) {
                                float f11 = (i4 - h2.g.f4833n[i6]) / 333;
                                if (f11 >= 0.0f && f11 <= 1.0f) {
                                    int i7 = i6 + gVar.f4840h;
                                    CircularProgressIndicatorSpec circularProgressIndicatorSpec = gVar.f4839g;
                                    int[] iArr = circularProgressIndicatorSpec.f4821c;
                                    int length = i7 % iArr.length;
                                    ((int[]) gVar.f4620c)[0] = p1.c.a(bVar.getInterpolation(f11), Integer.valueOf(y1.a.a(iArr[length], ((h2.m) gVar.f4618a).f4862j)), Integer.valueOf(y1.a.a(circularProgressIndicatorSpec.f4821c[(length + 1) % iArr.length], ((h2.m) gVar.f4618a).f4862j))).intValue();
                                } else {
                                    i6++;
                                }
                            }
                        }
                        ((h2.m) gVar.f4618a).invalidateSelf();
                        return;
                    }
                }
                break;
            default:
                gVar.f4842j = f4.floatValue();
                return;
        }
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        int i4 = this.f804a;
        switch (i4) {
            case 0:
                return Float.valueOf(((SwitchCompat) obj).f654z);
            case 1:
                c1.e eVar = (c1.e) obj;
                return null;
            case 2:
                c1.e eVar2 = (c1.e) obj;
                return null;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                View view = (View) obj;
                return null;
            case VisibleForTesting.PROTECTED /* 4 */:
                View view2 = (View) obj;
                return null;
            case VisibleForTesting.NONE /* 5 */:
                View view3 = (View) obj;
                return null;
            case 6:
                ImageView imageView = (ImageView) obj;
                return null;
            case 7:
                c1.k kVar = (c1.k) obj;
                return null;
            case 8:
                c1.k kVar2 = (c1.k) obj;
                return null;
            case 9:
                return a((View) obj);
            case 10:
                WeakHashMap weakHashMap = i0.y0.f4999a;
                return i0.i0.a((View) obj);
            case 11:
                return a((View) obj);
            case 12:
                return a((View) obj);
            case 13:
                return a((View) obj);
            case 14:
                return a((View) obj);
            case 15:
                h2.g gVar = (h2.g) obj;
                switch (i4) {
                    case 15:
                        return Float.valueOf(gVar.f4841i);
                    default:
                        return Float.valueOf(gVar.f4842j);
                }
            case 16:
                h2.g gVar2 = (h2.g) obj;
                switch (i4) {
                    case 15:
                        return Float.valueOf(gVar2.f4841i);
                    default:
                        return Float.valueOf(gVar2.f4842j);
                }
            case 17:
                return Float.valueOf(((h2.k) obj).b());
            case 18:
                return Float.valueOf(((h2.o) obj).f4877i);
            default:
                return Float.valueOf(((h2.q) obj).f4889j);
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        float floatValue;
        switch (this.f804a) {
            case 0:
                ((SwitchCompat) obj).setThumbPosition(((Float) obj2).floatValue());
                return;
            case 1:
                d((c1.e) obj, (PointF) obj2);
                return;
            case 2:
                d((c1.e) obj, (PointF) obj2);
                return;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                b((View) obj, (PointF) obj2);
                return;
            case VisibleForTesting.PROTECTED /* 4 */:
                b((View) obj, (PointF) obj2);
                return;
            case VisibleForTesting.NONE /* 5 */:
                b((View) obj, (PointF) obj2);
                return;
            case 6:
                ImageView imageView = (ImageView) obj;
                Matrix matrix = (Matrix) obj2;
                if (Build.VERSION.SDK_INT >= 29) {
                    imageView.animateTransform(matrix);
                    return;
                } else if (matrix == null) {
                    Drawable drawable = imageView.getDrawable();
                    if (drawable != null) {
                        drawable.setBounds(0, 0, (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight(), (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom());
                        imageView.invalidate();
                        return;
                    }
                    return;
                } else if (c1.c0.f2588j) {
                    try {
                        imageView.animateTransform(matrix);
                        return;
                    } catch (NoSuchMethodError unused) {
                        c1.c0.f2588j = false;
                        return;
                    }
                } else {
                    return;
                }
            case 7:
                c1.k kVar = (c1.k) obj;
                float[] fArr = (float[]) obj2;
                kVar.getClass();
                System.arraycopy(fArr, 0, kVar.f2629c, 0, fArr.length);
                kVar.a();
                return;
            case 8:
                c1.k kVar2 = (c1.k) obj;
                PointF pointF = (PointF) obj2;
                kVar2.getClass();
                kVar2.f2630d = pointF.x;
                kVar2.f2631e = pointF.y;
                kVar2.a();
                return;
            case 9:
                c((View) obj, (Float) obj2);
                return;
            case 10:
                WeakHashMap weakHashMap = i0.y0.f4999a;
                i0.i0.c((View) obj, (Rect) obj2);
                return;
            case 11:
                c((View) obj, (Float) obj2);
                return;
            case 12:
                c((View) obj, (Float) obj2);
                return;
            case 13:
                c((View) obj, (Float) obj2);
                return;
            case 14:
                c((View) obj, (Float) obj2);
                return;
            case 15:
                e((h2.g) obj, (Float) obj2);
                return;
            case 16:
                e((h2.g) obj, (Float) obj2);
                return;
            case 17:
                h2.k kVar3 = (h2.k) obj;
                float floatValue2 = ((Float) obj2).floatValue();
                if (kVar3.f4860h != floatValue2) {
                    kVar3.f4860h = floatValue2;
                    kVar3.invalidateSelf();
                    return;
                }
                return;
            case 18:
                h2.o oVar = (h2.o) obj;
                oVar.f4877i = ((Float) obj2).floatValue();
                Object obj3 = oVar.f4619b;
                ((float[]) obj3)[0] = 0.0f;
                float f4 = ((int) (floatValue * 333.0f)) / 667;
                float[] fArr2 = (float[]) obj3;
                u0.b bVar = oVar.f4873e;
                float interpolation = bVar.getInterpolation(f4);
                fArr2[2] = interpolation;
                fArr2[1] = interpolation;
                float[] fArr3 = (float[]) oVar.f4619b;
                float interpolation2 = bVar.getInterpolation(f4 + 0.49925038f);
                fArr3[4] = interpolation2;
                fArr3[3] = interpolation2;
                float[] fArr4 = (float[]) oVar.f4619b;
                fArr4[5] = 1.0f;
                if (oVar.f4876h && fArr4[3] < 1.0f) {
                    int[] iArr = (int[]) oVar.f4620c;
                    iArr[2] = iArr[1];
                    iArr[1] = iArr[0];
                    iArr[0] = y1.a.a(oVar.f4874f.f4821c[oVar.f4875g], ((h2.m) oVar.f4618a).f4862j);
                    oVar.f4876h = false;
                }
                ((h2.m) oVar.f4618a).invalidateSelf();
                return;
            default:
                h2.q qVar = (h2.q) obj;
                float floatValue3 = ((Float) obj2).floatValue();
                qVar.f4889j = floatValue3;
                int i4 = (int) (floatValue3 * 1800.0f);
                for (int i5 = 0; i5 < 4; i5++) {
                    ((float[]) qVar.f4619b)[i5] = Math.max(0.0f, Math.min(1.0f, qVar.f4885f[i5].getInterpolation((i4 - h2.q.f4881m[i5]) / h2.q.f4880l[i5])));
                }
                if (qVar.f4888i) {
                    Arrays.fill((int[]) qVar.f4620c, y1.a.a(qVar.f4886g.f4821c[qVar.f4887h], ((h2.m) qVar.f4618a).f4862j));
                    qVar.f4888i = false;
                }
                ((h2.m) qVar.f4618a).invalidateSelf();
                return;
        }
    }
}
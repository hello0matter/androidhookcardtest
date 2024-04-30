package o;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final View f5846a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5847b;

    /* renamed from: h  reason: collision with root package name */
    public com.google.common.collect.c[] f5853h;

    /* renamed from: i  reason: collision with root package name */
    public n.b f5854i;

    /* renamed from: m  reason: collision with root package name */
    public int[] f5858m;

    /* renamed from: n  reason: collision with root package name */
    public double[] f5859n;

    /* renamed from: o  reason: collision with root package name */
    public double[] f5860o;

    /* renamed from: p  reason: collision with root package name */
    public String[] f5861p;

    /* renamed from: q  reason: collision with root package name */
    public int[] f5862q;

    /* renamed from: v  reason: collision with root package name */
    public HashMap f5867v;

    /* renamed from: w  reason: collision with root package name */
    public HashMap f5868w;

    /* renamed from: x  reason: collision with root package name */
    public HashMap f5869x;

    /* renamed from: c  reason: collision with root package name */
    public int f5848c = -1;

    /* renamed from: d  reason: collision with root package name */
    public final w f5849d = new w();

    /* renamed from: e  reason: collision with root package name */
    public final w f5850e = new w();

    /* renamed from: f  reason: collision with root package name */
    public final o f5851f = new o();

    /* renamed from: g  reason: collision with root package name */
    public final o f5852g = new o();

    /* renamed from: j  reason: collision with root package name */
    public float f5855j = Float.NaN;

    /* renamed from: k  reason: collision with root package name */
    public float f5856k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    public float f5857l = 1.0f;

    /* renamed from: r  reason: collision with root package name */
    public final float[] f5863r = new float[4];

    /* renamed from: s  reason: collision with root package name */
    public final ArrayList f5864s = new ArrayList();

    /* renamed from: t  reason: collision with root package name */
    public final float[] f5865t = new float[1];

    /* renamed from: u  reason: collision with root package name */
    public final ArrayList f5866u = new ArrayList();

    /* renamed from: y  reason: collision with root package name */
    public int f5870y = -1;

    public p(View view) {
        this.f5846a = view;
        this.f5847b = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).getClass();
        }
    }

    public final float a(float f4, float[] fArr) {
        float f5 = 0.0f;
        float f6 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f7 = this.f5857l;
            if (f7 != 1.0d) {
                float f8 = this.f5856k;
                if (f4 < f8) {
                    f4 = 0.0f;
                }
                if (f4 > f8 && f4 < 1.0d) {
                    f4 = (f4 - f8) * f7;
                }
            }
        }
        n.e eVar = this.f5849d.f5899a;
        Iterator it = this.f5864s.iterator();
        float f9 = Float.NaN;
        while (it.hasNext()) {
            w wVar = (w) it.next();
            n.e eVar2 = wVar.f5899a;
            if (eVar2 != null) {
                float f10 = wVar.f5901c;
                if (f10 < f4) {
                    eVar = eVar2;
                    f5 = f10;
                } else if (Float.isNaN(f9)) {
                    f9 = wVar.f5901c;
                }
            }
        }
        if (eVar != null) {
            if (!Float.isNaN(f9)) {
                f6 = f9;
            }
            float f11 = f6 - f5;
            double d4 = (f4 - f5) / f11;
            f4 = (((float) eVar.a(d4)) * f11) + f5;
            if (fArr != null) {
                fArr[0] = (float) eVar.b(d4);
            }
        }
        return f4;
    }

    public final void b(float f4, float f5, float f6, float[] fArr) {
        double[] dArr;
        float[] fArr2 = this.f5865t;
        float a5 = a(f4, fArr2);
        com.google.common.collect.c[] cVarArr = this.f5853h;
        int i4 = 0;
        if (cVarArr != null) {
            double d4 = a5;
            cVarArr[0].N0(d4, this.f5860o);
            this.f5853h[0].J0(d4, this.f5859n);
            float f7 = fArr2[0];
            while (true) {
                dArr = this.f5860o;
                if (i4 >= dArr.length) {
                    break;
                }
                dArr[i4] = dArr[i4] * f7;
                i4++;
            }
            n.b bVar = this.f5854i;
            if (bVar != null) {
                double[] dArr2 = this.f5859n;
                if (dArr2.length > 0) {
                    bVar.J0(d4, dArr2);
                    this.f5854i.N0(d4, this.f5860o);
                    int[] iArr = this.f5858m;
                    double[] dArr3 = this.f5860o;
                    double[] dArr4 = this.f5859n;
                    this.f5849d.getClass();
                    w.d(f5, f6, fArr, iArr, dArr3, dArr4);
                    return;
                }
                return;
            }
            int[] iArr2 = this.f5858m;
            double[] dArr5 = this.f5859n;
            this.f5849d.getClass();
            w.d(f5, f6, fArr, iArr2, dArr, dArr5);
            return;
        }
        w wVar = this.f5850e;
        float f8 = wVar.f5903e;
        w wVar2 = this.f5849d;
        float f9 = f8 - wVar2.f5903e;
        float f10 = wVar.f5904f - wVar2.f5904f;
        fArr[0] = (((wVar.f5905g - wVar2.f5905g) + f9) * f5) + ((1.0f - f5) * f9);
        fArr[1] = (((wVar.f5906h - wVar2.f5906h) + f10) * f6) + ((1.0f - f6) * f10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0146, code lost:
        if (java.lang.Float.isNaN(Float.NaN) == false) goto L78;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean c(float r27, long r28, android.view.View r30, androidx.appcompat.app.o0 r31) {
        /*
            Method dump skipped, instructions count: 720
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: o.p.c(float, long, android.view.View, androidx.appcompat.app.o0):boolean");
    }

    public final void d(w wVar) {
        wVar.f5903e = (int) this.f5846a.getX();
        wVar.f5904f = (int) this.f5846a.getY();
        wVar.f5905g = this.f5846a.getWidth();
        wVar.f5906h = this.f5846a.getHeight();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:272:0x04df  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:474:0x0c24  */
    /* JADX WARN: Removed duplicated region for block: B:573:0x0c07 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v75, types: [o.j, o.i] */
    /* JADX WARN: Type inference failed for: r0v81, types: [o.j] */
    /* JADX WARN: Type inference failed for: r1v99, types: [o.e0, o.b0] */
    /* JADX WARN: Type inference failed for: r2v86, types: [o.i0, o.j0] */
    /* JADX WARN: Type inference failed for: r2v91, types: [o.j0] */
    /* JADX WARN: Type inference failed for: r3v111, types: [o.d0, o.e0] */
    /* JADX WARN: Type inference failed for: r3v119, types: [o.e0] */
    /* JADX WARN: Type inference failed for: r3v60, types: [o.j0, o.g0] */
    /* JADX WARN: Type inference failed for: r4v41, types: [o.f, o.j] */
    /* JADX WARN: Type inference failed for: r8v4, types: [o.g, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v3, types: [n.h, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(long r41) {
        /*
            Method dump skipped, instructions count: 3810
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: o.p.e(long):void");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(" start: x: ");
        w wVar = this.f5849d;
        sb.append(wVar.f5903e);
        sb.append(" y: ");
        sb.append(wVar.f5904f);
        sb.append(" end: x: ");
        w wVar2 = this.f5850e;
        sb.append(wVar2.f5903e);
        sb.append(" y: ");
        sb.append(wVar2.f5904f);
        return sb.toString();
    }
}
package d1;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: p  reason: collision with root package name */
    public static final Matrix f4296p = new Matrix();

    /* renamed from: a  reason: collision with root package name */
    public final Path f4297a;

    /* renamed from: b  reason: collision with root package name */
    public final Path f4298b;

    /* renamed from: c  reason: collision with root package name */
    public final Matrix f4299c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f4300d;

    /* renamed from: e  reason: collision with root package name */
    public Paint f4301e;

    /* renamed from: f  reason: collision with root package name */
    public PathMeasure f4302f;

    /* renamed from: g  reason: collision with root package name */
    public final j f4303g;

    /* renamed from: h  reason: collision with root package name */
    public float f4304h;

    /* renamed from: i  reason: collision with root package name */
    public float f4305i;

    /* renamed from: j  reason: collision with root package name */
    public float f4306j;

    /* renamed from: k  reason: collision with root package name */
    public float f4307k;

    /* renamed from: l  reason: collision with root package name */
    public int f4308l;

    /* renamed from: m  reason: collision with root package name */
    public String f4309m;

    /* renamed from: n  reason: collision with root package name */
    public Boolean f4310n;

    /* renamed from: o  reason: collision with root package name */
    public final l.b f4311o;

    /* JADX WARN: Type inference failed for: r0v4, types: [l.b, l.k] */
    public m() {
        this.f4299c = new Matrix();
        this.f4304h = 0.0f;
        this.f4305i = 0.0f;
        this.f4306j = 0.0f;
        this.f4307k = 0.0f;
        this.f4308l = 255;
        this.f4309m = null;
        this.f4310n = null;
        this.f4311o = new l.k();
        this.f4303g = new j();
        this.f4297a = new Path();
        this.f4298b = new Path();
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00e6, code lost:
        if (r0.f4275k != 1.0f) goto L68;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v16 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(d1.j r19, android.graphics.Matrix r20, android.graphics.Canvas r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 550
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.m.a(d1.j, android.graphics.Matrix, android.graphics.Canvas, int, int):void");
    }

    public float getAlpha() {
        return getRootAlpha() / 255.0f;
    }

    public int getRootAlpha() {
        return this.f4308l;
    }

    public void setAlpha(float f4) {
        setRootAlpha((int) (f4 * 255.0f));
    }

    public void setRootAlpha(int i4) {
        this.f4308l = i4;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [l.b, l.k] */
    public m(m mVar) {
        this.f4299c = new Matrix();
        this.f4304h = 0.0f;
        this.f4305i = 0.0f;
        this.f4306j = 0.0f;
        this.f4307k = 0.0f;
        this.f4308l = 255;
        this.f4309m = null;
        this.f4310n = null;
        ?? kVar = new l.k();
        this.f4311o = kVar;
        this.f4303g = new j(mVar.f4303g, kVar);
        this.f4297a = new Path(mVar.f4297a);
        this.f4298b = new Path(mVar.f4298b);
        this.f4304h = mVar.f4304h;
        this.f4305i = mVar.f4305i;
        this.f4306j = mVar.f4306j;
        this.f4307k = mVar.f4307k;
        this.f4308l = mVar.f4308l;
        this.f4309m = mVar.f4309m;
        String str = mVar.f4309m;
        if (str != null) {
            kVar.put(str, this);
        }
        this.f4310n = mVar.f4310n;
    }
}
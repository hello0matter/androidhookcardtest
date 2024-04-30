package l2;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    public float f5391a;

    /* renamed from: b  reason: collision with root package name */
    public float f5392b;

    /* renamed from: c  reason: collision with root package name */
    public float f5393c;

    /* renamed from: d  reason: collision with root package name */
    public float f5394d;

    /* renamed from: e  reason: collision with root package name */
    public float f5395e;

    /* renamed from: f  reason: collision with root package name */
    public float f5396f;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList f5397g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f5398h = new ArrayList();

    public z() {
        e(0.0f, 0.0f, 270.0f, 0.0f);
    }

    public final void a(float f4, float f5, float f6, float f7, float f8, float f9) {
        boolean z4;
        float f10;
        v vVar = new v(f4, f5, f6, f7);
        vVar.f5384f = f8;
        vVar.f5385g = f9;
        this.f5397g.add(vVar);
        t tVar = new t(vVar);
        float f11 = f8 + f9;
        if (f9 < 0.0f) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            f8 = (f8 + 180.0f) % 360.0f;
        }
        if (z4) {
            f10 = (180.0f + f11) % 360.0f;
        } else {
            f10 = f11;
        }
        b(f8);
        this.f5398h.add(tVar);
        this.f5395e = f10;
        double d4 = f11;
        this.f5393c = (((f6 - f4) / 2.0f) * ((float) Math.cos(Math.toRadians(d4)))) + ((f4 + f6) * 0.5f);
        this.f5394d = (((f7 - f5) / 2.0f) * ((float) Math.sin(Math.toRadians(d4)))) + ((f5 + f7) * 0.5f);
    }

    public final void b(float f4) {
        float f5 = this.f5395e;
        if (f5 == f4) {
            return;
        }
        float f6 = ((f4 - f5) + 360.0f) % 360.0f;
        if (f6 > 180.0f) {
            return;
        }
        float f7 = this.f5393c;
        float f8 = this.f5394d;
        v vVar = new v(f7, f8, f7, f8);
        vVar.f5384f = this.f5395e;
        vVar.f5385g = f6;
        this.f5398h.add(new t(vVar));
        this.f5395e = f4;
    }

    public final void c(Matrix matrix, Path path) {
        ArrayList arrayList = this.f5397g;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((x) arrayList.get(i4)).a(matrix, path);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [l2.x, java.lang.Object, l2.w] */
    public final void d(float f4, float f5) {
        ?? xVar = new x();
        xVar.f5386b = f4;
        xVar.f5387c = f5;
        this.f5397g.add(xVar);
        u uVar = new u(xVar, this.f5393c, this.f5394d);
        b(uVar.b() + 270.0f);
        this.f5398h.add(uVar);
        this.f5395e = uVar.b() + 270.0f;
        this.f5393c = f4;
        this.f5394d = f5;
    }

    public final void e(float f4, float f5, float f6, float f7) {
        this.f5391a = f4;
        this.f5392b = f5;
        this.f5393c = f4;
        this.f5394d = f5;
        this.f5395e = f6;
        this.f5396f = (f6 + f7) % 360.0f;
        this.f5397g.clear();
        this.f5398h.clear();
    }
}
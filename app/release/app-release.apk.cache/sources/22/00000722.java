package h2;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.provider.Settings;

/* loaded from: classes.dex */
public final class m extends k {

    /* renamed from: l  reason: collision with root package name */
    public final l f4865l;

    /* renamed from: m  reason: collision with root package name */
    public g.e f4866m;

    public m(Context context, d dVar, l lVar, g.e eVar) {
        super(context, dVar);
        this.f4865l = lVar;
        lVar.f4864b = this;
        this.f4866m = eVar;
        eVar.f4618a = this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            l lVar = this.f4865l;
            Rect bounds = getBounds();
            float b5 = b();
            lVar.f4863a.a();
            lVar.a(canvas, bounds, b5);
            l lVar2 = this.f4865l;
            Paint paint = this.f4861i;
            lVar2.c(canvas, paint);
            int i4 = 0;
            while (true) {
                g.e eVar = this.f4866m;
                int[] iArr = (int[]) eVar.f4620c;
                if (i4 < iArr.length) {
                    l lVar3 = this.f4865l;
                    float[] fArr = (float[]) eVar.f4619b;
                    int i5 = i4 * 2;
                    lVar3.b(canvas, paint, fArr[i5], fArr[i5 + 1], iArr[i4]);
                    i4++;
                } else {
                    canvas.restore();
                    return;
                }
            }
        }
    }

    @Override // h2.k
    public final boolean f(boolean z4, boolean z5, boolean z6) {
        boolean f4 = super.f(z4, z5, z6);
        if (!isRunning()) {
            this.f4866m.c();
        }
        a aVar = this.f4855c;
        ContentResolver contentResolver = this.f4853a.getContentResolver();
        aVar.getClass();
        Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
        if (z4 && z6) {
            this.f4866m.s();
        }
        return f4;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f4865l.d();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f4865l.e();
    }
}
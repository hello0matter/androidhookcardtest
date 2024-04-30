package x1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final a f7130a;

    /* renamed from: b  reason: collision with root package name */
    public final View f7131b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f7132c;

    /* renamed from: d  reason: collision with root package name */
    public f f7133d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f7134e;

    public b(a aVar) {
        this.f7130a = aVar;
        View view = (View) aVar;
        this.f7131b = view;
        view.setWillNotDraw(false);
        new Path();
        new Paint(7);
        Paint paint = new Paint(1);
        this.f7132c = paint;
        paint.setColor(0);
    }

    public final void a(Canvas canvas) {
        boolean z4;
        f fVar = this.f7133d;
        if (fVar != null && fVar.f7141c != Float.MAX_VALUE) {
            z4 = false;
        } else {
            z4 = true;
        }
        boolean z5 = !z4;
        Paint paint = this.f7132c;
        a aVar = this.f7130a;
        View view = this.f7131b;
        aVar.a(canvas);
        if (!z5 ? Color.alpha(paint.getColor()) != 0 : Color.alpha(paint.getColor()) != 0) {
            canvas.drawRect(0.0f, 0.0f, view.getWidth(), view.getHeight(), paint);
        }
        Drawable drawable = this.f7134e;
        if (drawable != null && this.f7133d != null) {
            Rect bounds = drawable.getBounds();
            float width = this.f7133d.f7139a - (bounds.width() / 2.0f);
            float height = this.f7133d.f7140b - (bounds.height() / 2.0f);
            canvas.translate(width, height);
            this.f7134e.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    public final f b() {
        f fVar = this.f7133d;
        if (fVar == null) {
            return null;
        }
        f fVar2 = new f(fVar);
        if (fVar2.f7141c == Float.MAX_VALUE) {
            float f4 = fVar2.f7139a;
            float f5 = fVar2.f7140b;
            View view = this.f7131b;
            fVar2.f7141c = com.google.common.collect.c.j0(f4, f5, view.getWidth(), view.getHeight());
        }
        return fVar2;
    }

    public final boolean c() {
        boolean z4;
        if (!this.f7130a.h()) {
            return false;
        }
        f fVar = this.f7133d;
        if (fVar != null && fVar.f7141c != Float.MAX_VALUE) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (!z4) {
            return false;
        }
        return true;
    }

    public final void d(Drawable drawable) {
        this.f7134e = drawable;
        this.f7131b.invalidate();
    }

    public final void e(int i4) {
        this.f7132c.setColor(i4);
        this.f7131b.invalidate();
    }

    public final void f(f fVar) {
        View view = this.f7131b;
        if (fVar == null) {
            this.f7133d = null;
        } else {
            f fVar2 = this.f7133d;
            if (fVar2 == null) {
                this.f7133d = new f(fVar);
            } else {
                float f4 = fVar.f7139a;
                float f5 = fVar.f7140b;
                float f6 = fVar.f7141c;
                fVar2.f7139a = f4;
                fVar2.f7140b = f5;
                fVar2.f7141c = f6;
            }
            if (fVar.f7141c + 1.0E-4f >= com.google.common.collect.c.j0(fVar.f7139a, fVar.f7140b, view.getWidth(), view.getHeight())) {
                this.f7133d.f7141c = Float.MAX_VALUE;
            }
        }
        view.invalidate();
    }
}
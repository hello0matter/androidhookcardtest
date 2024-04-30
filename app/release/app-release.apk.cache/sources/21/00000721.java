package h2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    public final d f4863a;

    /* renamed from: b  reason: collision with root package name */
    public k f4864b;

    public l(d dVar) {
        this.f4863a = dVar;
    }

    public abstract void a(Canvas canvas, Rect rect, float f4);

    public abstract void b(Canvas canvas, Paint paint, float f4, float f5, int i4);

    public abstract void c(Canvas canvas, Paint paint);

    public abstract int d();

    public abstract int e();
}
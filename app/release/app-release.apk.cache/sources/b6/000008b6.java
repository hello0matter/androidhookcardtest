package n1;

import android.content.Context;
import android.graphics.PointF;
import android.opengl.Matrix;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public final class i extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, c {

    /* renamed from: c  reason: collision with root package name */
    public final h f5775c;

    /* renamed from: e  reason: collision with root package name */
    public final GestureDetector f5777e;

    /* renamed from: a  reason: collision with root package name */
    public final PointF f5773a = new PointF();

    /* renamed from: b  reason: collision with root package name */
    public final PointF f5774b = new PointF();

    /* renamed from: d  reason: collision with root package name */
    public final float f5776d = 25.0f;

    /* renamed from: f  reason: collision with root package name */
    public volatile float f5778f = 3.1415927f;

    public i(Context context, h hVar) {
        this.f5775c = hVar;
        this.f5777e = new GestureDetector(context, this);
    }

    @Override // n1.c
    public final void a(float f4, float[] fArr) {
        this.f5778f = -f4;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        this.f5773a.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
        float x4 = (motionEvent2.getX() - this.f5773a.x) / this.f5776d;
        float y4 = motionEvent2.getY();
        PointF pointF = this.f5773a;
        float f6 = (y4 - pointF.y) / this.f5776d;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d4 = this.f5778f;
        float cos = (float) Math.cos(d4);
        float sin = (float) Math.sin(d4);
        PointF pointF2 = this.f5774b;
        pointF2.x -= (cos * x4) - (sin * f6);
        float f7 = (cos * f6) + (sin * x4) + pointF2.y;
        pointF2.y = f7;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f7));
        h hVar = this.f5775c;
        PointF pointF3 = this.f5774b;
        synchronized (hVar) {
            float f8 = pointF3.y;
            hVar.f5768g = f8;
            Matrix.setRotateM(hVar.f5766e, 0, -f8, (float) Math.cos(hVar.f5769h), (float) Math.sin(hVar.f5769h), 0.0f);
            Matrix.setRotateM(hVar.f5767f, 0, -pointF3.x, 0.0f, 1.0f, 0.0f);
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f5775c.f5772k.performClick();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f5777e.onTouchEvent(motionEvent);
    }
}
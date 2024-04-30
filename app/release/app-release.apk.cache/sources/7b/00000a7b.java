package z1;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public final class a implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final Dialog f7228a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7229b;

    /* renamed from: c  reason: collision with root package name */
    public final int f7230c;

    /* renamed from: d  reason: collision with root package name */
    public final int f7231d;

    public a(Dialog dialog, Rect rect) {
        this.f7228a = dialog;
        this.f7229b = rect.left;
        this.f7230c = rect.top;
        this.f7231d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = findViewById.getLeft() + this.f7229b;
        int width = findViewById.getWidth() + left;
        int top = findViewById.getTop() + this.f7230c;
        if (new RectF(left, top, width, findViewById.getHeight() + top).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i4 = this.f7231d;
            obtain.setLocation((-i4) - 1, (-i4) - 1);
        }
        view.performClick();
        return this.f7228a.onTouchEvent(obtain);
    }
}
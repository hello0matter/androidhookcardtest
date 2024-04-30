package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public final class w1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f931a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x1 f932b;

    public /* synthetic */ w1(x1 x1Var, int i4) {
        this.f931a = i4;
        this.f932b = x1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f931a;
        x1 x1Var = this.f932b;
        switch (i4) {
            case 0:
                ViewParent parent = x1Var.f943d.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                    return;
                }
                return;
            default:
                x1Var.a();
                View view = x1Var.f943d;
                if (view.isEnabled() && !view.isLongClickable() && x1Var.c()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(obtain);
                    obtain.recycle();
                    x1Var.f946g = true;
                    return;
                }
                return;
        }
    }
}
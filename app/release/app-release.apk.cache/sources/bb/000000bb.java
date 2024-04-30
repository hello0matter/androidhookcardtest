package androidx.appcompat.app;

import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.widget.ContentFrameLayout;

/* loaded from: classes.dex */
public final class c0 extends ContentFrameLayout {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ f0 f195i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(f0 f0Var, f.f fVar) {
        super(fVar);
        this.f195i = f0Var;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f195i.u(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int x4 = (int) motionEvent.getX();
            int y4 = (int) motionEvent.getY();
            if (x4 < -5 || y4 < -5 || x4 > getWidth() + 5 || y4 > getHeight() + 5) {
                f0 f0Var = this.f195i;
                f0Var.s(f0Var.z(0), true);
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i4) {
        setBackgroundDrawable(com.google.common.collect.c.t0(getContext(), i4));
    }
}
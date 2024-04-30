package i0;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class z implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final View f5015a;

    /* renamed from: b  reason: collision with root package name */
    public ViewTreeObserver f5016b;

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f5017c;

    public z(View view, Runnable runnable) {
        this.f5015a = view;
        this.f5016b = view.getViewTreeObserver();
        this.f5017c = runnable;
    }

    public static void a(View view, Runnable runnable) {
        if (view != null) {
            if (runnable != null) {
                z zVar = new z(view, runnable);
                view.getViewTreeObserver().addOnPreDrawListener(zVar);
                view.addOnAttachStateChangeListener(zVar);
                return;
            }
            throw new NullPointerException("runnable == null");
        }
        throw new NullPointerException("view == null");
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ViewTreeObserver viewTreeObserver;
        boolean isAlive = this.f5016b.isAlive();
        View view = this.f5015a;
        if (isAlive) {
            viewTreeObserver = this.f5016b;
        } else {
            viewTreeObserver = view.getViewTreeObserver();
        }
        viewTreeObserver.removeOnPreDrawListener(this);
        view.removeOnAttachStateChangeListener(this);
        this.f5017c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f5016b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        ViewTreeObserver viewTreeObserver;
        boolean isAlive = this.f5016b.isAlive();
        View view2 = this.f5015a;
        if (isAlive) {
            viewTreeObserver = this.f5016b;
        } else {
            viewTreeObserver = view2.getViewTreeObserver();
        }
        viewTreeObserver.removeOnPreDrawListener(this);
        view2.removeOnAttachStateChangeListener(this);
    }
}
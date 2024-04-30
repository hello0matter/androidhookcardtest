package i0;

import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class g1 {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f4929a;

    public g1(View view) {
        this.f4929a = new WeakReference(view);
    }

    public final void a(float f4) {
        View view = (View) this.f4929a.get();
        if (view != null) {
            view.animate().alpha(f4);
        }
    }

    public final void b() {
        View view = (View) this.f4929a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void c(long j4) {
        View view = (View) this.f4929a.get();
        if (view != null) {
            view.animate().setDuration(j4);
        }
    }

    public final void d(h1 h1Var) {
        View view = (View) this.f4929a.get();
        if (view != null) {
            if (h1Var != null) {
                view.animate().setListener(new e1(this, h1Var, view, 0));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    public final void e(float f4) {
        View view = (View) this.f4929a.get();
        if (view != null) {
            view.animate().translationY(f4);
        }
    }
}
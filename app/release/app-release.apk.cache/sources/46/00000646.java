package d;

import android.graphics.drawable.Drawable;
import d1.f;

/* loaded from: classes.dex */
public final class a implements Drawable.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4234a = 1;

    /* renamed from: b  reason: collision with root package name */
    public final Object f4235b;

    public a(f fVar) {
        this.f4235b = fVar;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        switch (this.f4234a) {
            case 0:
                return;
            default:
                ((f) this.f4235b).invalidateSelf();
                return;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j4) {
        switch (this.f4234a) {
            case 0:
                Drawable.Callback callback = (Drawable.Callback) this.f4235b;
                if (callback != null) {
                    callback.scheduleDrawable(drawable, runnable, j4);
                    return;
                }
                return;
            default:
                ((f) this.f4235b).scheduleSelf(runnable, j4);
                return;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        switch (this.f4234a) {
            case 0:
                Drawable.Callback callback = (Drawable.Callback) this.f4235b;
                if (callback != null) {
                    callback.unscheduleDrawable(drawable, runnable);
                    return;
                }
                return;
            default:
                ((f) this.f4235b).unscheduleSelf(runnable);
                return;
        }
    }
}
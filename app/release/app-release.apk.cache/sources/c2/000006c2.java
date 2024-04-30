package f2;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;

/* loaded from: classes.dex */
public final class d implements OnBackAnimationCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f4558a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f4559b;

    public d(e eVar, b bVar) {
        this.f4559b = eVar;
        this.f4558a = bVar;
    }

    public final void onBackCancelled() {
        if (this.f4559b.f4557a != null) {
            this.f4558a.d();
        }
    }

    public final void onBackInvoked() {
        this.f4558a.a();
    }

    public final void onBackProgressed(BackEvent backEvent) {
        if (this.f4559b.f4557a != null) {
            this.f4558a.c(new androidx.activity.b(backEvent));
        }
    }

    public final void onBackStarted(BackEvent backEvent) {
        if (this.f4559b.f4557a != null) {
            this.f4558a.b(new androidx.activity.b(backEvent));
        }
    }
}
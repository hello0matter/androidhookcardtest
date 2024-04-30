package androidx.activity;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;

/* loaded from: classes.dex */
public final class t implements OnBackAnimationCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e3.l f151a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e3.l f152b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e3.a f153c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e3.a f154d;

    public t(e3.l lVar, e3.l lVar2, e3.a aVar, e3.a aVar2) {
        this.f151a = lVar;
        this.f152b = lVar2;
        this.f153c = aVar;
        this.f154d = aVar2;
    }

    public final void onBackCancelled() {
        this.f154d.a();
    }

    public final void onBackInvoked() {
        this.f153c.a();
    }

    public final void onBackProgressed(BackEvent backEvent) {
        com.google.common.collect.c.F(backEvent, "backEvent");
        this.f152b.c(new b(backEvent));
    }

    public final void onBackStarted(BackEvent backEvent) {
        com.google.common.collect.c.F(backEvent, "backEvent");
        this.f151a.c(new b(backEvent));
    }
}
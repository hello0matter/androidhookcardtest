package androidx.appcompat.app;

import android.content.IntentFilter;

/* loaded from: classes.dex */
public abstract class b0 {

    /* renamed from: a  reason: collision with root package name */
    public a0 f189a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f0 f190b;

    public b0(f0 f0Var) {
        this.f190b = f0Var;
    }

    public final void a() {
        a0 a0Var = this.f189a;
        if (a0Var != null) {
            try {
                this.f190b.f238k.unregisterReceiver(a0Var);
            } catch (IllegalArgumentException unused) {
            }
            this.f189a = null;
        }
    }

    public abstract int b();

    public final void c() {
        IntentFilter intentFilter;
        a();
        switch (((z) this).f372c) {
            case 0:
                intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                break;
            default:
                intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.TIME_SET");
                intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
                intentFilter.addAction("android.intent.action.TIME_TICK");
                break;
        }
        if (intentFilter.countActions() == 0) {
            return;
        }
        if (this.f189a == null) {
            this.f189a = new a0(0, this);
        }
        this.f190b.f238k.registerReceiver(this.f189a, intentFilter);
    }
}
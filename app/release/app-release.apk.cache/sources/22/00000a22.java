package x;

import android.content.ComponentName;
import android.content.Context;
import android.os.PowerManager;

/* loaded from: classes.dex */
public final class k extends p {

    /* renamed from: a  reason: collision with root package name */
    public final PowerManager.WakeLock f7079a;

    /* renamed from: b  reason: collision with root package name */
    public final PowerManager.WakeLock f7080b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7081c;

    public k(Context context, ComponentName componentName) {
        context.getApplicationContext();
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
        this.f7079a = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
        this.f7080b = newWakeLock2;
        newWakeLock2.setReferenceCounted(false);
    }

    @Override // x.p
    public final void a() {
        synchronized (this) {
            try {
                if (this.f7081c) {
                    this.f7081c = false;
                    this.f7080b.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // x.p
    public final void b() {
        synchronized (this) {
            try {
                if (!this.f7081c) {
                    this.f7081c = true;
                    this.f7080b.acquire(600000L);
                    this.f7079a.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // x.p
    public final void c() {
        synchronized (this) {
        }
    }
}
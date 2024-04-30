package x;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes.dex */
public final class f implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    public Object f7065a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f7066b;

    /* renamed from: c  reason: collision with root package name */
    public final int f7067c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7068d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7069e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7070f = false;

    public f(Activity activity) {
        this.f7066b = activity;
        this.f7067c = activity.hashCode();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (this.f7066b == activity) {
            this.f7066b = null;
            this.f7069e = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (this.f7069e && !this.f7070f && !this.f7068d) {
            Object obj = this.f7065a;
            try {
                Object obj2 = g.f7073c.get(activity);
                if (obj2 == obj && activity.hashCode() == this.f7067c) {
                    g.f7077g.postAtFrontOfQueue(new androidx.appcompat.widget.j(g.f7072b.get(activity), obj2, 5));
                    this.f7070f = true;
                    this.f7065a = null;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while fetching field values", th);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (this.f7066b == activity) {
            this.f7068d = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
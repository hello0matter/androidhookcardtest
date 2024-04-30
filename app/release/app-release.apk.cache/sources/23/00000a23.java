package x;

import android.content.Intent;
import androidx.core.app.JobIntentService;

/* loaded from: classes.dex */
public final class l implements m {

    /* renamed from: a  reason: collision with root package name */
    public final Intent f7082a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7083b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ JobIntentService f7084c;

    public l(JobIntentService jobIntentService, Intent intent, int i4) {
        this.f7084c = jobIntentService;
        this.f7082a = intent;
        this.f7083b = i4;
    }

    @Override // x.m
    public final void a() {
        this.f7084c.stopSelf(this.f7083b);
    }

    @Override // x.m
    public final Intent getIntent() {
        return this.f7082a;
    }
}
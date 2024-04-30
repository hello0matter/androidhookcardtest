package x;

import android.app.job.JobParameters;
import android.app.job.JobWorkItem;
import android.content.Intent;

/* loaded from: classes.dex */
public final class n implements m {

    /* renamed from: a  reason: collision with root package name */
    public final JobWorkItem f7085a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ o f7086b;

    public n(o oVar, JobWorkItem jobWorkItem) {
        this.f7086b = oVar;
        this.f7085a = jobWorkItem;
    }

    @Override // x.m
    public final void a() {
        synchronized (this.f7086b.f7088b) {
            try {
                JobParameters jobParameters = this.f7086b.f7089c;
                if (jobParameters != null) {
                    jobParameters.completeWork(this.f7085a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // x.m
    public final Intent getIntent() {
        Intent intent;
        intent = this.f7085a.getIntent();
        return intent;
    }
}
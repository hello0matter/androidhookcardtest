package x;

import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import androidx.core.app.JobIntentService;

/* loaded from: classes.dex */
public final class o extends JobServiceEngine {

    /* renamed from: a  reason: collision with root package name */
    public final JobIntentService f7087a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f7088b;

    /* renamed from: c  reason: collision with root package name */
    public JobParameters f7089c;

    public o(JobIntentService jobIntentService) {
        super(jobIntentService);
        this.f7088b = new Object();
        this.f7087a = jobIntentService;
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        this.f7089c = jobParameters;
        this.f7087a.a(false);
        return true;
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        j jVar = this.f7087a.f1368c;
        if (jVar != null) {
            jVar.cancel(false);
        }
        synchronized (this.f7088b) {
            this.f7089c = null;
        }
        return true;
    }
}
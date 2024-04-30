package androidx.appcompat.app;

import android.app.job.JobParameters;
import android.app.job.JobWorkItem;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: classes.dex */
public abstract /* synthetic */ class w {
    public static /* bridge */ /* synthetic */ JobWorkItem b(JobParameters jobParameters) {
        return jobParameters.dequeueWork();
    }

    public static /* bridge */ /* synthetic */ Intent d(JobWorkItem jobWorkItem) {
        return jobWorkItem.getIntent();
    }

    public static /* bridge */ /* synthetic */ IBinder e(x.o oVar) {
        return oVar.getBinder();
    }
}
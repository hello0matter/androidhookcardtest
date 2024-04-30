package x;

import android.os.AsyncTask;
import androidx.core.app.JobIntentService;

/* loaded from: classes.dex */
public final class j extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JobIntentService f7078a;

    public j(JobIntentService jobIntentService) {
        this.f7078a = jobIntentService;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x004d A[LOOP:0: B:3:0x0002->B:31:0x004d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0059 A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object doInBackground(java.lang.Object[] r5) {
        /*
            r4 = this;
            java.lang.Void[] r5 = (java.lang.Void[]) r5
        L2:
            androidx.core.app.JobIntentService r5 = r4.f7078a
            x.o r0 = r5.f1366a
            r1 = 0
            if (r0 == 0) goto L30
            java.lang.Object r2 = r0.f7088b
            monitor-enter(r2)
            android.app.job.JobParameters r5 = r0.f7089c     // Catch: java.lang.Throwable -> L12
            if (r5 != 0) goto L14
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L12
            goto L4a
        L12:
            r5 = move-exception
            goto L2e
        L14:
            android.app.job.JobWorkItem r5 = androidx.appcompat.app.w.b(r5)     // Catch: java.lang.Throwable -> L12
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L12
            if (r5 == 0) goto L4a
            android.content.Intent r2 = androidx.appcompat.app.w.d(r5)
            androidx.core.app.JobIntentService r3 = r0.f7087a
            java.lang.ClassLoader r3 = r3.getClassLoader()
            r2.setExtrasClassLoader(r3)
            x.n r2 = new x.n
            r2.<init>(r0, r5)
            goto L4b
        L2e:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L12
            throw r5
        L30:
            java.util.ArrayList r0 = r5.f1370e
            monitor-enter(r0)
            java.util.ArrayList r2 = r5.f1370e     // Catch: java.lang.Throwable -> L47
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L47
            if (r2 <= 0) goto L49
            java.util.ArrayList r5 = r5.f1370e     // Catch: java.lang.Throwable -> L47
            r2 = 0
            java.lang.Object r5 = r5.remove(r2)     // Catch: java.lang.Throwable -> L47
            r2 = r5
            x.m r2 = (x.m) r2     // Catch: java.lang.Throwable -> L47
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L47
            goto L4b
        L47:
            r5 = move-exception
            goto L5a
        L49:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L47
        L4a:
            r2 = r1
        L4b:
            if (r2 == 0) goto L59
            androidx.core.app.JobIntentService r5 = r4.f7078a
            r2.getIntent()
            r5.b()
            r2.a()
            goto L2
        L59:
            return r1
        L5a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L47
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: x.j.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    @Override // android.os.AsyncTask
    public final void onCancelled(Object obj) {
        Void r12 = (Void) obj;
        this.f7078a.c();
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        Void r12 = (Void) obj;
        this.f7078a.c();
    }
}
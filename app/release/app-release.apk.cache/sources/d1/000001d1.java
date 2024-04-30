package androidx.core.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import androidx.appcompat.app.w;
import java.util.ArrayList;
import java.util.HashMap;
import x.j;
import x.k;
import x.l;
import x.o;
import x.p;

@Deprecated
/* loaded from: classes.dex */
public abstract class JobIntentService extends Service {

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap f1365f = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public o f1366a;

    /* renamed from: b  reason: collision with root package name */
    public p f1367b;

    /* renamed from: c  reason: collision with root package name */
    public j f1368c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1369d = false;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList f1370e;

    public JobIntentService() {
        this.f1370e = Build.VERSION.SDK_INT >= 26 ? null : new ArrayList();
    }

    public final void a(boolean z4) {
        if (this.f1368c == null) {
            this.f1368c = new j(this);
            p pVar = this.f1367b;
            if (pVar != null && z4) {
                pVar.b();
            }
            this.f1368c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public abstract void b();

    public final void c() {
        ArrayList arrayList = this.f1370e;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.f1368c = null;
                    ArrayList arrayList2 = this.f1370e;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        a(false);
                    } else if (!this.f1369d) {
                        this.f1367b.a();
                    }
                } finally {
                }
            }
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        o oVar = this.f1366a;
        if (oVar != null) {
            return w.e(oVar);
        }
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            this.f1366a = new o(this);
            this.f1367b = null;
            return;
        }
        this.f1366a = null;
        ComponentName componentName = new ComponentName(this, getClass());
        HashMap hashMap = f1365f;
        p pVar = (p) hashMap.get(componentName);
        if (pVar == null) {
            if (i4 < 26) {
                pVar = new k(this, componentName);
                hashMap.put(componentName, pVar);
            } else {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
        }
        this.f1367b = pVar;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        ArrayList arrayList = this.f1370e;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f1369d = true;
                this.f1367b.a();
            }
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i4, int i5) {
        if (this.f1370e != null) {
            this.f1367b.c();
            synchronized (this.f1370e) {
                ArrayList arrayList = this.f1370e;
                if (intent == null) {
                    intent = new Intent();
                }
                arrayList.add(new l(this, intent, i5));
                a(true);
            }
            return 3;
        }
        return 2;
    }
}
package com.google.android.exoplayer2.offline;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.activity.j;
import com.google.common.collect.c;
import java.util.HashMap;
import l1.d;

@Deprecated
/* loaded from: classes.dex */
public abstract class DownloadService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap f2850a = new HashMap();

    public abstract c a();

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public final void onCreate() {
        j.f(f2850a.get(getClass()));
        int i4 = d.f5272a;
        a();
        throw null;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        throw null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i4, int i5) {
        if (intent != null) {
            String action = intent.getAction();
            intent.getStringExtra("content_id");
            if (!intent.getBooleanExtra("foreground", false)) {
                "com.google.android.exoplayer.downloadService.action.RESTART".equals(action);
            }
        }
        throw null;
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
    }
}
package w2;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public final class a implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public boolean f7059a = false;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedBlockingQueue f7060b = new LinkedBlockingQueue(1);

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f7060b.put(iBinder);
        } catch (InterruptedException unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
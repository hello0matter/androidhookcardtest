package f0;

import android.os.Process;

/* loaded from: classes.dex */
public final class m extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final int f4540a;

    public m(Runnable runnable, String str, int i4) {
        super(runnable, str);
        this.f4540a = i4;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f4540a);
        super.run();
    }
}
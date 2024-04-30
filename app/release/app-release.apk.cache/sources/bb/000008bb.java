package n2;

import android.os.Handler;
import android.os.Message;
import androidx.activity.j;

/* loaded from: classes.dex */
public final class e implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p.d f5780a;

    public e(p.d dVar) {
        this.f5780a = dVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        p.d dVar = this.f5780a;
        j.f(message.obj);
        synchronized (dVar.f6074a) {
            j.f(dVar.f6076c);
            throw null;
        }
    }
}
package n2;

import android.os.Handler;
import android.os.Message;
import androidx.activity.j;

/* loaded from: classes.dex */
public final class a implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i4 = message.what;
        if (i4 != 0) {
            if (i4 != 1) {
                return false;
            }
            j.f(message.obj);
            throw null;
        }
        j.f(message.obj);
        throw null;
    }
}
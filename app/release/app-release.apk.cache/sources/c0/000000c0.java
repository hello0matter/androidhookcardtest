package androidx.appcompat.app;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class f extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference f225a;

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i4 = message.what;
        if (i4 == -3 || i4 == -2 || i4 == -1) {
            ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f225a.get(), message.what);
        } else if (i4 != 1) {
        } else {
            ((DialogInterface) message.obj).dismiss();
        }
    }
}
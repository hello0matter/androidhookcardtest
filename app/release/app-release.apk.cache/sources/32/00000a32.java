package x0;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class h {
    @DoNotInline
    public static Handler a(Looper looper) {
        Handler createAsync;
        createAsync = Handler.createAsync(looper);
        return createAsync;
    }
}
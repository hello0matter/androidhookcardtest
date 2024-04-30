package a0;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.l0;

/* loaded from: classes.dex */
public abstract class p {
    public final void a(int i4) {
        new Handler(Looper.getMainLooper()).post(new o(i4, 0, this));
    }

    public final void b(Typeface typeface) {
        new Handler(Looper.getMainLooper()).post(new l0(1, this, typeface));
    }

    public abstract void c(int i4);

    public abstract void d(Typeface typeface);
}
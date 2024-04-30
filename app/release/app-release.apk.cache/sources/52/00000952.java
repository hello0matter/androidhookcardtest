package q0;

import android.os.Looper;
import android.util.AndroidRuntimeException;

/* loaded from: classes.dex */
public final class i extends h {

    /* renamed from: r  reason: collision with root package name */
    public j f6317r;

    /* renamed from: s  reason: collision with root package name */
    public float f6318s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f6319t;

    public final void b() {
        if (this.f6317r.f6321b > 0.0d) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                if (this.f6311f) {
                    this.f6319t = true;
                    return;
                }
                return;
            }
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
    }
}
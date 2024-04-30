package q0;

import android.view.Choreographer;
import androidx.appcompat.app.o0;

/* loaded from: classes.dex */
public final class c extends g0.i {

    /* renamed from: b  reason: collision with root package name */
    public final Choreographer f6288b;

    /* renamed from: c  reason: collision with root package name */
    public final b f6289c;

    public c(o0 o0Var) {
        super(o0Var);
        this.f6288b = Choreographer.getInstance();
        this.f6289c = new b(this);
    }

    public final void e() {
        this.f6288b.postFrameCallback(this.f6289c);
    }
}
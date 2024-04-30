package i0;

import android.graphics.Insets;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class b2 extends a2 {

    /* renamed from: n  reason: collision with root package name */
    public b0.c f4908n;

    /* renamed from: o  reason: collision with root package name */
    public b0.c f4909o;

    /* renamed from: p  reason: collision with root package name */
    public b0.c f4910p;

    public b2(@NonNull g2 g2Var, @NonNull WindowInsets windowInsets) {
        super(g2Var, windowInsets);
        this.f4908n = null;
        this.f4909o = null;
        this.f4910p = null;
    }

    @Override // i0.d2
    @NonNull
    public b0.c g() {
        Insets mandatorySystemGestureInsets;
        if (this.f4909o == null) {
            mandatorySystemGestureInsets = this.f5010c.getMandatorySystemGestureInsets();
            this.f4909o = b0.c.c(mandatorySystemGestureInsets);
        }
        return this.f4909o;
    }

    @Override // i0.d2
    @NonNull
    public b0.c i() {
        Insets systemGestureInsets;
        if (this.f4908n == null) {
            systemGestureInsets = this.f5010c.getSystemGestureInsets();
            this.f4908n = b0.c.c(systemGestureInsets);
        }
        return this.f4908n;
    }

    @Override // i0.d2
    @NonNull
    public b0.c k() {
        Insets tappableElementInsets;
        if (this.f4910p == null) {
            tappableElementInsets = this.f5010c.getTappableElementInsets();
            this.f4910p = b0.c.c(tappableElementInsets);
        }
        return this.f4910p;
    }

    @Override // i0.y1, i0.d2
    @NonNull
    public g2 l(int i4, int i5, int i6, int i7) {
        WindowInsets inset;
        inset = this.f5010c.inset(i4, i5, i6, i7);
        return g2.h(null, inset);
    }

    @Override // i0.z1, i0.d2
    public void q(@Nullable b0.c cVar) {
    }
}
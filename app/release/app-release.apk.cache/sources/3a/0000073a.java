package i0;

import android.graphics.Insets;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class c2 extends b2 {

    /* renamed from: q  reason: collision with root package name */
    public static final g2 f4915q;

    static {
        WindowInsets windowInsets;
        windowInsets = WindowInsets.CONSUMED;
        f4915q = g2.h(null, windowInsets);
    }

    public c2(@NonNull g2 g2Var, @NonNull WindowInsets windowInsets) {
        super(g2Var, windowInsets);
    }

    @Override // i0.y1, i0.d2
    @NonNull
    public b0.c f(int i4) {
        Insets insets;
        insets = this.f5010c.getInsets(f2.a(i4));
        return b0.c.c(insets);
    }

    @Override // i0.y1, i0.d2
    public final void d(@NonNull View view) {
    }
}
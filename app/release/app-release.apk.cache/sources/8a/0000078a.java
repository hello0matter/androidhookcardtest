package i0;

import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class z1 extends y1 {

    /* renamed from: m  reason: collision with root package name */
    public b0.c f5018m;

    public z1(@NonNull g2 g2Var, @NonNull WindowInsets windowInsets) {
        super(g2Var, windowInsets);
        this.f5018m = null;
    }

    @Override // i0.d2
    @NonNull
    public g2 b() {
        return g2.h(null, this.f5010c.consumeStableInsets());
    }

    @Override // i0.d2
    @NonNull
    public g2 c() {
        return g2.h(null, this.f5010c.consumeSystemWindowInsets());
    }

    @Override // i0.d2
    @NonNull
    public final b0.c h() {
        if (this.f5018m == null) {
            WindowInsets windowInsets = this.f5010c;
            this.f5018m = b0.c.b(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.f5018m;
    }

    @Override // i0.d2
    public boolean m() {
        return this.f5010c.isConsumed();
    }

    @Override // i0.d2
    public void q(@Nullable b0.c cVar) {
        this.f5018m = cVar;
    }
}
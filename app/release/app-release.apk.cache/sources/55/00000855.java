package l2;

import android.view.View;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public final class d0 extends b0 {
    public d0(View view) {
        c(view);
    }

    @DoNotInline
    private void c(View view) {
        view.setOutlineProvider(new w1.c(2, this));
    }

    @Override // l2.b0
    public final void a(View view) {
        view.setClipToOutline(!this.f5276a);
        if (this.f5276a) {
            view.invalidate();
        } else {
            view.invalidateOutline();
        }
    }

    @Override // l2.b0
    public final boolean b() {
        return this.f5276a;
    }
}
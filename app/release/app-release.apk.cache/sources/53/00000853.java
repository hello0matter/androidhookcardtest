package l2;

import android.view.View;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public final class c0 extends b0 {

    /* renamed from: f  reason: collision with root package name */
    public boolean f5282f = false;

    /* renamed from: g  reason: collision with root package name */
    public float f5283g = 0.0f;

    public c0(View view) {
        c(view);
    }

    @DoNotInline
    private void c(View view) {
        view.setOutlineProvider(new w1.c(1, this));
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0106  */
    @Override // l2.b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.view.View r9) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.c0.a(android.view.View):void");
    }

    @Override // l2.b0
    public final boolean b() {
        if (this.f5282f && !this.f5276a) {
            return false;
        }
        return true;
    }
}
package g;

import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.o0;

/* loaded from: classes.dex */
public final class t extends s implements ActionProvider.VisibilityListener {

    /* renamed from: d  reason: collision with root package name */
    public o0 f4750d;

    @Override // i0.e
    public final boolean a() {
        return this.f4748b.isVisible();
    }

    @Override // i0.e
    public final View b(MenuItem menuItem) {
        return this.f4748b.onCreateActionView(menuItem);
    }

    @Override // i0.e
    public final boolean c() {
        return this.f4748b.overridesItemVisibility();
    }

    @Override // i0.e
    public final void d(o0 o0Var) {
        this.f4750d = o0Var;
        this.f4748b.setVisibilityListener(this);
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z4) {
        o0 o0Var = this.f4750d;
        if (o0Var != null) {
            p pVar = ((r) o0Var.f311b).f4735n;
            pVar.f4702h = true;
            pVar.p(true);
        }
    }
}
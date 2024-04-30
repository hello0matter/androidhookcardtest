package g;

import android.view.MenuItem;

/* loaded from: classes.dex */
public final class v implements MenuItem.OnActionExpandListener {

    /* renamed from: a  reason: collision with root package name */
    public final MenuItem.OnActionExpandListener f4752a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x f4753b;

    public v(x xVar, MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f4753b = xVar;
        this.f4752a = onActionExpandListener;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.f4752a.onMenuItemActionCollapse(this.f4753b.n(menuItem));
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.f4752a.onMenuItemActionExpand(this.f4753b.n(menuItem));
    }
}
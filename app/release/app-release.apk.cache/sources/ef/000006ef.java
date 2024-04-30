package g;

import android.view.MenuItem;

/* loaded from: classes.dex */
public final class w implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final MenuItem.OnMenuItemClickListener f4754a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x f4755b;

    public w(x xVar, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f4755b = xVar;
        this.f4754a = onMenuItemClickListener;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        return this.f4754a.onMenuItemClick(this.f4755b.n(menuItem));
    }
}
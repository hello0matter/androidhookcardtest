package g;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public class j0 extends p implements SubMenu {
    public final r A;

    /* renamed from: z  reason: collision with root package name */
    public final p f4679z;

    public j0(Context context, p pVar, r rVar) {
        super(context);
        this.f4679z = pVar;
        this.A = rVar;
    }

    @Override // g.p
    public final boolean d(r rVar) {
        return this.f4679z.d(rVar);
    }

    @Override // g.p
    public final boolean e(p pVar, MenuItem menuItem) {
        if (!super.e(pVar, menuItem) && !this.f4679z.e(pVar, menuItem)) {
            return false;
        }
        return true;
    }

    @Override // g.p
    public final boolean f(r rVar) {
        return this.f4679z.f(rVar);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.A;
    }

    @Override // g.p
    public final String j() {
        int i4;
        r rVar = this.A;
        if (rVar != null) {
            i4 = rVar.f4722a;
        } else {
            i4 = 0;
        }
        if (i4 == 0) {
            return null;
        }
        return androidx.activity.j.b("android:menu:actionviewstates:", i4);
    }

    @Override // g.p
    public final p k() {
        return this.f4679z.k();
    }

    @Override // g.p
    public final boolean m() {
        return this.f4679z.m();
    }

    @Override // g.p
    public final boolean n() {
        return this.f4679z.n();
    }

    @Override // g.p
    public final boolean o() {
        return this.f4679z.o();
    }

    @Override // g.p, android.view.Menu
    public final void setGroupDividerEnabled(boolean z4) {
        this.f4679z.setGroupDividerEnabled(z4);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i4) {
        w(0, null, i4, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i4) {
        w(i4, null, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        w(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i4) {
        this.A.setIcon(i4);
        return this;
    }

    @Override // g.p, android.view.Menu
    public final void setQwertyMode(boolean z4) {
        this.f4679z.setQwertyMode(z4);
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.A.setIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        w(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        w(0, charSequence, 0, null, null);
        return this;
    }
}
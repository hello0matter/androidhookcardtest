package f;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class g extends c implements g.n {

    /* renamed from: c  reason: collision with root package name */
    public Context f4452c;

    /* renamed from: d  reason: collision with root package name */
    public ActionBarContextView f4453d;

    /* renamed from: e  reason: collision with root package name */
    public b f4454e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference f4455f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4456g;

    /* renamed from: h  reason: collision with root package name */
    public g.p f4457h;

    @Override // f.c
    public final void a() {
        if (this.f4456g) {
            return;
        }
        this.f4456g = true;
        this.f4454e.c(this);
    }

    @Override // g.n
    public final void b(g.p pVar) {
        h();
        androidx.appcompat.widget.n nVar = this.f4453d.f710d;
        if (nVar != null) {
            nVar.o();
        }
    }

    @Override // f.c
    public final View c() {
        WeakReference weakReference = this.f4455f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // f.c
    public final g.p d() {
        return this.f4457h;
    }

    @Override // f.c
    public final MenuInflater e() {
        return new l(this.f4453d.getContext());
    }

    @Override // f.c
    public final CharSequence f() {
        return this.f4453d.getSubtitle();
    }

    @Override // f.c
    public final CharSequence g() {
        return this.f4453d.getTitle();
    }

    @Override // f.c
    public final void h() {
        this.f4454e.d(this, this.f4457h);
    }

    @Override // f.c
    public final boolean i() {
        return this.f4453d.f425s;
    }

    @Override // f.c
    public final void j(View view) {
        WeakReference weakReference;
        this.f4453d.setCustomView(view);
        if (view != null) {
            weakReference = new WeakReference(view);
        } else {
            weakReference = null;
        }
        this.f4455f = weakReference;
    }

    @Override // f.c
    public final void k(int i4) {
        l(this.f4452c.getString(i4));
    }

    @Override // f.c
    public final void l(CharSequence charSequence) {
        this.f4453d.setSubtitle(charSequence);
    }

    @Override // f.c
    public final void m(int i4) {
        n(this.f4452c.getString(i4));
    }

    @Override // f.c
    public final void n(CharSequence charSequence) {
        this.f4453d.setTitle(charSequence);
    }

    @Override // f.c
    public final void o(boolean z4) {
        this.f4445b = z4;
        this.f4453d.setTitleOptional(z4);
    }

    @Override // g.n
    public final boolean p(g.p pVar, MenuItem menuItem) {
        return this.f4454e.a(this, menuItem);
    }
}
package androidx.appcompat.app;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class t0 extends f.c implements g.n {

    /* renamed from: c  reason: collision with root package name */
    public final Context f335c;

    /* renamed from: d  reason: collision with root package name */
    public final g.p f336d;

    /* renamed from: e  reason: collision with root package name */
    public f.b f337e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference f338f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ u0 f339g;

    public t0(u0 u0Var, Context context, u uVar) {
        this.f339g = u0Var;
        this.f335c = context;
        this.f337e = uVar;
        g.p pVar = new g.p(context);
        pVar.f4706l = 1;
        this.f336d = pVar;
        pVar.f4699e = this;
    }

    @Override // f.c
    public final void a() {
        u0 u0Var = this.f339g;
        if (u0Var.f352i != this) {
            return;
        }
        if (u0Var.f359p) {
            u0Var.f353j = this;
            u0Var.f354k = this.f337e;
        } else {
            this.f337e.c(this);
        }
        this.f337e = null;
        u0Var.a(false);
        ActionBarContextView actionBarContextView = u0Var.f349f;
        if (actionBarContextView.f417k == null) {
            actionBarContextView.h();
        }
        u0Var.f346c.setHideOnContentScrollEnabled(u0Var.f364u);
        u0Var.f352i = null;
    }

    @Override // g.n
    public final void b(g.p pVar) {
        if (this.f337e == null) {
            return;
        }
        h();
        androidx.appcompat.widget.n nVar = this.f339g.f349f.f710d;
        if (nVar != null) {
            nVar.o();
        }
    }

    @Override // f.c
    public final View c() {
        WeakReference weakReference = this.f338f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // f.c
    public final g.p d() {
        return this.f336d;
    }

    @Override // f.c
    public final MenuInflater e() {
        return new f.l(this.f335c);
    }

    @Override // f.c
    public final CharSequence f() {
        return this.f339g.f349f.getSubtitle();
    }

    @Override // f.c
    public final CharSequence g() {
        return this.f339g.f349f.getTitle();
    }

    @Override // f.c
    public final void h() {
        if (this.f339g.f352i != this) {
            return;
        }
        g.p pVar = this.f336d;
        pVar.y();
        try {
            this.f337e.d(this, pVar);
        } finally {
            pVar.x();
        }
    }

    @Override // f.c
    public final boolean i() {
        return this.f339g.f349f.f425s;
    }

    @Override // f.c
    public final void j(View view) {
        this.f339g.f349f.setCustomView(view);
        this.f338f = new WeakReference(view);
    }

    @Override // f.c
    public final void k(int i4) {
        l(this.f339g.f344a.getResources().getString(i4));
    }

    @Override // f.c
    public final void l(CharSequence charSequence) {
        this.f339g.f349f.setSubtitle(charSequence);
    }

    @Override // f.c
    public final void m(int i4) {
        n(this.f339g.f344a.getResources().getString(i4));
    }

    @Override // f.c
    public final void n(CharSequence charSequence) {
        this.f339g.f349f.setTitle(charSequence);
    }

    @Override // f.c
    public final void o(boolean z4) {
        this.f4445b = z4;
        this.f339g.f349f.setTitleOptional(z4);
    }

    @Override // g.n
    public final boolean p(g.p pVar, MenuItem menuItem) {
        f.b bVar = this.f337e;
        if (bVar != null) {
            return bVar.a(this, menuItem);
        }
        return false;
    }
}
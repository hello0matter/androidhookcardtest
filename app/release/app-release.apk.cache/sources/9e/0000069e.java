package f;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import g.g0;

/* loaded from: classes.dex */
public final class i extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4462a;

    /* renamed from: b  reason: collision with root package name */
    public final c f4463b;

    public i(Context context, c cVar) {
        this.f4462a = context;
        this.f4463b = cVar;
    }

    @Override // android.view.ActionMode
    public final void finish() {
        this.f4463b.a();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f4463b.c();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return new g0(this.f4462a, this.f4463b.d());
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f4463b.e();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f4463b.f();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.f4463b.f4444a;
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f4463b.g();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.f4463b.f4445b;
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f4463b.h();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.f4463b.i();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View view) {
        this.f4463b.j(view);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int i4) {
        this.f4463b.k(i4);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object obj) {
        this.f4463b.f4444a = obj;
    }

    @Override // android.view.ActionMode
    public final void setTitle(int i4) {
        this.f4463b.m(i4);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z4) {
        this.f4463b.o(z4);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.f4463b.l(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.f4463b.n(charSequence);
    }
}
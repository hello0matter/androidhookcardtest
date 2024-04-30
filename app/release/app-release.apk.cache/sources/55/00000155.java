package androidx.appcompat.widget;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;

/* loaded from: classes.dex */
public final class l0 implements q0, DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public androidx.appcompat.app.j f809a;

    /* renamed from: b  reason: collision with root package name */
    public ListAdapter f810b;

    /* renamed from: c  reason: collision with root package name */
    public CharSequence f811c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AppCompatSpinner f812d;

    public l0(AppCompatSpinner appCompatSpinner) {
        this.f812d = appCompatSpinner;
    }

    @Override // androidx.appcompat.widget.q0
    public final boolean b() {
        androidx.appcompat.app.j jVar = this.f809a;
        if (jVar != null) {
            return jVar.isShowing();
        }
        return false;
    }

    @Override // androidx.appcompat.widget.q0
    public final void c(int i4) {
        Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    @Override // androidx.appcompat.widget.q0
    public final int d() {
        return 0;
    }

    @Override // androidx.appcompat.widget.q0
    public final void dismiss() {
        androidx.appcompat.app.j jVar = this.f809a;
        if (jVar != null) {
            jVar.dismiss();
            this.f809a = null;
        }
    }

    @Override // androidx.appcompat.widget.q0
    public final void e(int i4, int i5) {
        if (this.f810b == null) {
            return;
        }
        AppCompatSpinner appCompatSpinner = this.f812d;
        androidx.appcompat.app.i iVar = new androidx.appcompat.app.i(appCompatSpinner.getPopupContext());
        CharSequence charSequence = this.f811c;
        androidx.appcompat.app.e eVar = iVar.f281a;
        if (charSequence != null) {
            eVar.f202d = charSequence;
        }
        ListAdapter listAdapter = this.f810b;
        int selectedItemPosition = appCompatSpinner.getSelectedItemPosition();
        eVar.f205g = listAdapter;
        eVar.f206h = this;
        eVar.f208j = selectedItemPosition;
        eVar.f207i = true;
        androidx.appcompat.app.j a5 = iVar.a();
        this.f809a = a5;
        AlertController$RecycleListView alertController$RecycleListView = a5.f287f.f259e;
        j0.d(alertController$RecycleListView, i4);
        j0.c(alertController$RecycleListView, i5);
        this.f809a.show();
    }

    @Override // androidx.appcompat.widget.q0
    public final int g() {
        return 0;
    }

    @Override // androidx.appcompat.widget.q0
    public final Drawable h() {
        return null;
    }

    @Override // androidx.appcompat.widget.q0
    public final CharSequence i() {
        return this.f811c;
    }

    @Override // androidx.appcompat.widget.q0
    public final void j(CharSequence charSequence) {
        this.f811c = charSequence;
    }

    @Override // androidx.appcompat.widget.q0
    public final void l(Drawable drawable) {
        Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }

    @Override // androidx.appcompat.widget.q0
    public final void n(int i4) {
        Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    @Override // androidx.appcompat.widget.q0
    public final void o(ListAdapter listAdapter) {
        this.f810b = listAdapter;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i4) {
        AppCompatSpinner appCompatSpinner = this.f812d;
        appCompatSpinner.setSelection(i4);
        if (appCompatSpinner.getOnItemClickListener() != null) {
            appCompatSpinner.performItemClick(null, i4, this.f810b.getItemId(i4));
        }
        dismiss();
    }

    @Override // androidx.appcompat.widget.q0
    public final void p(int i4) {
        Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }
}
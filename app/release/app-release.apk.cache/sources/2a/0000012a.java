package androidx.appcompat.widget;

import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f730a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final Object f731b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f732c;

    public d(ActionBarContextView actionBarContextView, f.c cVar) {
        this.f732c = actionBarContextView;
        this.f731b = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i4 = this.f730a;
        Object obj = this.f731b;
        switch (i4) {
            case 0:
                ((f.c) obj).a();
                return;
            default:
                x3 x3Var = (x3) this.f732c;
                Window.Callback callback = x3Var.f961l;
                if (callback != null && x3Var.f962m) {
                    callback.onMenuItemSelected(0, (g.a) obj);
                    return;
                }
                return;
        }
    }

    public d(x3 x3Var) {
        this.f732c = x3Var;
        this.f731b = new g.a(x3Var.f950a.getContext(), x3Var.f958i);
    }
}
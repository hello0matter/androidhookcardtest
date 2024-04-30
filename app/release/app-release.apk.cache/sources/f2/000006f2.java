package g;

import android.widget.PopupWindow;

/* loaded from: classes.dex */
public final class z implements PopupWindow.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b0 f4759a;

    public z(b0 b0Var) {
        this.f4759a = b0Var;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f4759a.c();
    }
}
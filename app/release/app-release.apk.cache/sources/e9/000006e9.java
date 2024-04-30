package g;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public final class q implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, c0 {

    /* renamed from: a  reason: collision with root package name */
    public p f4719a;

    /* renamed from: b  reason: collision with root package name */
    public androidx.appcompat.app.j f4720b;

    /* renamed from: c  reason: collision with root package name */
    public l f4721c;

    @Override // g.c0
    public final void a(p pVar, boolean z4) {
        androidx.appcompat.app.j jVar;
        if ((z4 || pVar == this.f4719a) && (jVar = this.f4720b) != null) {
            jVar.dismiss();
        }
    }

    @Override // g.c0
    public final boolean f(p pVar) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i4) {
        l lVar = this.f4721c;
        if (lVar.f4687f == null) {
            lVar.f4687f = new k(lVar);
        }
        this.f4719a.q(lVar.f4687f.getItem(i4), null, 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f4721c.a(this.f4719a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        p pVar = this.f4719a;
        if (i4 == 82 || i4 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f4720b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f4720b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                pVar.c(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return pVar.performShortcut(i4, keyEvent, 0);
    }
}
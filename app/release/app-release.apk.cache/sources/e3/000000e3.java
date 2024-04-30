package androidx.appcompat.app;

import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class y extends f.r {

    /* renamed from: b  reason: collision with root package name */
    public boolean f368b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f369c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f370d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ f0 f371e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(f0 f0Var, Window.Callback callback) {
        super(callback);
        this.f371e = f0Var;
    }

    public final void a(Window.Callback callback) {
        try {
            this.f368b = true;
            callback.onContentChanged();
        } finally {
            this.f368b = false;
        }
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z4 = this.f369c;
        Window.Callback callback = this.f4509a;
        if (z4) {
            return callback.dispatchKeyEvent(keyEvent);
        }
        if (!this.f371e.u(keyEvent) && !callback.dispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        t0 t0Var;
        g.p pVar;
        boolean z4;
        if (this.f4509a.dispatchKeyShortcutEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        f0 f0Var = this.f371e;
        f0Var.A();
        u0 u0Var = f0Var.f242o;
        if (u0Var != null && (t0Var = u0Var.f352i) != null && (pVar = t0Var.f336d) != null) {
            if (KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() != 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            pVar.setQwertyMode(z4);
            if (pVar.performShortcut(keyCode, keyEvent, 0)) {
                return true;
            }
        }
        e0 e0Var = f0Var.M;
        if (e0Var != null && f0Var.F(e0Var, keyEvent.getKeyCode(), keyEvent)) {
            e0 e0Var2 = f0Var.M;
            if (e0Var2 == null) {
                return true;
            }
            e0Var2.f220l = true;
            return true;
        }
        if (f0Var.M == null) {
            e0 z5 = f0Var.z(0);
            f0Var.G(z5, keyEvent);
            boolean F = f0Var.F(z5, keyEvent.getKeyCode(), keyEvent);
            z5.f219k = false;
            if (F) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        if (this.f368b) {
            this.f4509a.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i4, Menu menu) {
        if (i4 == 0 && !(menu instanceof g.p)) {
            return false;
        }
        return this.f4509a.onCreatePanelMenu(i4, menu);
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i4) {
        return this.f4509a.onCreatePanelView(i4);
    }

    @Override // f.r, android.view.Window.Callback
    public final boolean onMenuOpened(int i4, Menu menu) {
        super.onMenuOpened(i4, menu);
        f0 f0Var = this.f371e;
        if (i4 == 108) {
            f0Var.A();
            u0 u0Var = f0Var.f242o;
            if (u0Var != null && true != u0Var.f355l) {
                u0Var.f355l = true;
                ArrayList arrayList = u0Var.f356m;
                if (arrayList.size() > 0) {
                    androidx.activity.j.f(arrayList.get(0));
                    throw null;
                }
            }
        } else {
            f0Var.getClass();
        }
        return true;
    }

    @Override // f.r, android.view.Window.Callback
    public final void onPanelClosed(int i4, Menu menu) {
        if (this.f370d) {
            this.f4509a.onPanelClosed(i4, menu);
            return;
        }
        super.onPanelClosed(i4, menu);
        f0 f0Var = this.f371e;
        if (i4 == 108) {
            f0Var.A();
            u0 u0Var = f0Var.f242o;
            if (u0Var != null && u0Var.f355l) {
                u0Var.f355l = false;
                ArrayList arrayList = u0Var.f356m;
                if (arrayList.size() > 0) {
                    androidx.activity.j.f(arrayList.get(0));
                    throw null;
                }
            }
        } else if (i4 == 0) {
            e0 z4 = f0Var.z(i4);
            if (z4.f221m) {
                f0Var.s(z4, false);
            }
        } else {
            f0Var.getClass();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i4, View view, Menu menu) {
        g.p pVar;
        if (menu instanceof g.p) {
            pVar = (g.p) menu;
        } else {
            pVar = null;
        }
        if (i4 == 0 && pVar == null) {
            return false;
        }
        if (pVar != null) {
            pVar.f4718x = true;
        }
        boolean onPreparePanel = this.f4509a.onPreparePanel(i4, view, menu);
        if (pVar != null) {
            pVar.f4718x = false;
        }
        return onPreparePanel;
    }

    @Override // f.r, android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i4) {
        g.p pVar = this.f371e.z(0).f216h;
        if (pVar != null) {
            super.onProvideKeyboardShortcuts(list, pVar, i4);
        } else {
            super.onProvideKeyboardShortcuts(list, menu, i4);
        }
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01d4  */
    /* JADX WARN: Type inference failed for: r1v10, types: [g.n, java.lang.Object, f.c, f.g] */
    @Override // android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r9, int r10) {
        /*
            Method dump skipped, instructions count: 501
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.y.onWindowStartingActionMode(android.view.ActionMode$Callback, int):android.view.ActionMode");
    }
}
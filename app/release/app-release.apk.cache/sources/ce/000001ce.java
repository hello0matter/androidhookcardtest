package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import i0.n;
import i0.o;
import l2.f;

@RestrictTo({RestrictTo.Scope.f171c})
/* loaded from: classes.dex */
public class ComponentActivity extends Activity implements q, n {

    /* renamed from: a  reason: collision with root package name */
    public final s f1364a = new s(this);

    @Override // i0.n
    public final boolean c(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public void d() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !o.a(decorView, keyEvent)) {
            return o.b(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !o.a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    public s f() {
        return this.f1364a;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i4 = ReportFragment.f1872b;
        f.k(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        s sVar = this.f1364a;
        sVar.getClass();
        sVar.d("markState");
        sVar.g();
        super.onSaveInstanceState(bundle);
    }
}
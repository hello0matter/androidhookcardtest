package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity implements x.c, x.d {

    /* renamed from: v  reason: collision with root package name */
    public boolean f1586v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f1587w;

    /* renamed from: t  reason: collision with root package name */
    public final n f1584t = new n(2, new w(this));

    /* renamed from: u  reason: collision with root package name */
    public final androidx.lifecycle.s f1585u = new androidx.lifecycle.s(this);

    /* renamed from: x  reason: collision with root package name */
    public boolean f1588x = true;

    public FragmentActivity() {
        this.f62e.f7226b.b("android:support:fragments", new u(this));
        h(new v(this));
    }

    public static boolean k(k0 k0Var) {
        FragmentActivity fragmentActivity;
        boolean z4 = false;
        for (t tVar : k0Var.f1725c.f()) {
            if (tVar != null) {
                w wVar = tVar.f1819s;
                if (wVar == null) {
                    fragmentActivity = null;
                } else {
                    fragmentActivity = wVar.f1841u;
                }
                if (fragmentActivity != null) {
                    z4 |= k(tVar.h());
                }
                c1 c1Var = tVar.N;
                Lifecycle$State lifecycle$State = Lifecycle$State.f1867d;
                if (c1Var != null) {
                    c1Var.d();
                    if (c1Var.f1670b.f1915c.compareTo(lifecycle$State) >= 0) {
                        tVar.N.f1670b.g();
                        z4 = true;
                    }
                }
                if (tVar.M.f1915c.compareTo(lifecycle$State) >= 0) {
                    tVar.M.g();
                    z4 = true;
                }
            }
        }
        return z4;
    }

    @Override // android.app.Activity
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f1586v);
        printWriter.print(" mResumed=");
        printWriter.print(this.f1587w);
        printWriter.print(" mStopped=");
        printWriter.print(this.f1588x);
        if (getApplication() != null) {
            androidx.appcompat.app.c cVar = new androidx.appcompat.app.c(e(), w0.b.f7018d);
            String canonicalName = w0.b.class.getCanonicalName();
            if (canonicalName != null) {
                l.l lVar = ((w0.b) cVar.k(w0.b.class, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName))).f7019c;
                if (lVar.f5256c > 0) {
                    printWriter.print(str2);
                    printWriter.println("Loaders:");
                    if (lVar.f5256c > 0) {
                        androidx.activity.j.f(lVar.f5255b[0]);
                        printWriter.print(str2);
                        printWriter.print("  #");
                        printWriter.print(lVar.f5254a[0]);
                        printWriter.print(": ");
                        throw null;
                    }
                }
            } else {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
        }
        ((w) this.f1584t.f1752b).f1840t.u(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i4, int i5, Intent intent) {
        this.f1584t.c();
        super.onActivityResult(i4, i5, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        n nVar = this.f1584t;
        nVar.c();
        super.onConfigurationChanged(configuration);
        ((w) nVar.f1752b).f1840t.h();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1585u.e(Lifecycle$Event.ON_CREATE);
        l0 l0Var = ((w) this.f1584t.f1752b).f1840t;
        l0Var.A = false;
        l0Var.B = false;
        l0Var.H.f1759h = false;
        l0Var.s(1);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i4, Menu menu) {
        if (i4 == 0) {
            super.onCreatePanelMenu(i4, menu);
            getMenuInflater();
            return ((w) this.f1584t.f1752b).f1840t.j() | true;
        }
        super.onCreatePanelMenu(i4, menu);
        return true;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View onCreateView = ((w) this.f1584t.f1752b).f1840t.f1728f.onCreateView(view, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(view, str, context, attributeSet) : onCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ((w) this.f1584t.f1752b).f1840t.k();
        this.f1585u.e(Lifecycle$Event.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onLowMemory() {
        super.onLowMemory();
        ((w) this.f1584t.f1752b).f1840t.l();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i4, MenuItem menuItem) {
        if (super.onMenuItemSelected(i4, menuItem)) {
            return true;
        }
        n nVar = this.f1584t;
        if (i4 != 0) {
            if (i4 != 6) {
                return false;
            }
            return ((w) nVar.f1752b).f1840t.i();
        }
        return ((w) nVar.f1752b).f1840t.n();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onMultiWindowModeChanged(boolean z4) {
        ((w) this.f1584t.f1752b).f1840t.m(z4);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        this.f1584t.c();
        super.onNewIntent(intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i4, Menu menu) {
        if (i4 == 0) {
            ((w) this.f1584t.f1752b).f1840t.o();
        }
        super.onPanelClosed(i4, menu);
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        this.f1587w = false;
        ((w) this.f1584t.f1752b).f1840t.s(5);
        this.f1585u.e(Lifecycle$Event.ON_PAUSE);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z4) {
        ((w) this.f1584t.f1752b).f1840t.q(z4);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.f1585u.e(Lifecycle$Event.ON_RESUME);
        l0 l0Var = ((w) this.f1584t.f1752b).f1840t;
        l0Var.A = false;
        l0Var.B = false;
        l0Var.H.f1759h = false;
        l0Var.s(7);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onPreparePanel(int i4, View view, Menu menu) {
        if (i4 == 0) {
            super.onPreparePanel(0, view, menu);
            return ((w) this.f1584t.f1752b).f1840t.r() | true;
        }
        super.onPreparePanel(i4, view, menu);
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i4, String[] strArr, int[] iArr) {
        this.f1584t.c();
        super.onRequestPermissionsResult(i4, strArr, iArr);
    }

    @Override // android.app.Activity
    public final void onResume() {
        n nVar = this.f1584t;
        nVar.c();
        super.onResume();
        this.f1587w = true;
        ((w) nVar.f1752b).f1840t.x(true);
    }

    @Override // android.app.Activity
    public void onStart() {
        n nVar = this.f1584t;
        nVar.c();
        super.onStart();
        this.f1588x = false;
        boolean z4 = this.f1586v;
        Object obj = nVar.f1752b;
        if (!z4) {
            this.f1586v = true;
            l0 l0Var = ((w) obj).f1840t;
            l0Var.A = false;
            l0Var.B = false;
            l0Var.H.f1759h = false;
            l0Var.s(4);
        }
        ((w) obj).f1840t.x(true);
        this.f1585u.e(Lifecycle$Event.ON_START);
        l0 l0Var2 = ((w) obj).f1840t;
        l0Var2.A = false;
        l0Var2.B = false;
        l0Var2.H.f1759h = false;
        l0Var2.s(5);
    }

    @Override // android.app.Activity
    public final void onStateNotSaved() {
        this.f1584t.c();
    }

    @Override // android.app.Activity
    public void onStop() {
        n nVar;
        super.onStop();
        this.f1588x = true;
        do {
            nVar = this.f1584t;
        } while (k(((w) nVar.f1752b).f1840t));
        l0 l0Var = ((w) nVar.f1752b).f1840t;
        l0Var.B = true;
        l0Var.H.f1759h = true;
        l0Var.s(4);
        this.f1585u.e(Lifecycle$Event.ON_STOP);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View onCreateView = ((w) this.f1584t.f1752b).f1840t.f1728f.onCreateView(null, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(str, context, attributeSet) : onCreateView;
    }
}
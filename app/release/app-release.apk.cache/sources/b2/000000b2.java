package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.c4;
import androidx.appcompat.widget.m2;
import androidx.appcompat.widget.x3;
import androidx.fragment.app.FragmentActivity;
import com.example.msphone.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AppCompatActivity extends FragmentActivity implements m {

    /* renamed from: y  reason: collision with root package name */
    public f0 f180y;

    public AppCompatActivity() {
        this.f62e.f7226b.b("androidx:appcompat", new k(this));
        h(new l(this));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m();
        f0 f0Var = (f0) l();
        f0Var.w();
        ((ViewGroup) f0Var.A.findViewById(16908290)).addView(view, layoutParams);
        f0Var.f240m.a(f0Var.f239l.getCallback());
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Configuration configuration;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        f0 f0Var = (f0) l();
        f0Var.O = true;
        int i12 = f0Var.S;
        if (i12 == -100) {
            i12 = q.f313b;
        }
        int C = f0Var.C(context, i12);
        if (q.d(context) && q.d(context)) {
            if (e0.a.a()) {
                if (!q.f317f) {
                    q.f312a.execute(new n(context, 0));
                }
            } else {
                synchronized (q.f320i) {
                    try {
                        e0.f fVar = q.f314c;
                        if (fVar == null) {
                            if (q.f315d == null) {
                                q.f315d = e0.f.a(com.google.common.collect.c.H1(context));
                            }
                            if (!((e0.h) q.f315d.f4427a).f4428a.isEmpty()) {
                                q.f314c = q.f315d;
                            }
                        } else if (!fVar.equals(q.f315d)) {
                            e0.f fVar2 = q.f314c;
                            q.f315d = fVar2;
                            com.google.common.collect.c.C1(context, ((e0.h) fVar2.f4427a).f4428a.toLanguageTags());
                        }
                    } finally {
                    }
                }
            }
        }
        e0.f o4 = f0.o(context);
        if (f0.f229k0 && (context instanceof ContextThemeWrapper)) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(f0.t(context, C, o4, null, false));
            } catch (IllegalStateException unused) {
            }
            super.attachBaseContext(context);
        }
        if (context instanceof f.f) {
            try {
                ((f.f) context).a(f0.t(context, C, o4, null, false));
            } catch (IllegalStateException unused2) {
            }
            super.attachBaseContext(context);
        }
        if (f0.f228j0) {
            int i13 = Build.VERSION.SDK_INT;
            Configuration configuration2 = new Configuration();
            configuration2.uiMode = -1;
            configuration2.fontScale = 0.0f;
            Configuration configuration3 = context.createConfigurationContext(configuration2).getResources().getConfiguration();
            Configuration configuration4 = context.getResources().getConfiguration();
            configuration3.uiMode = configuration4.uiMode;
            if (!configuration3.equals(configuration4)) {
                configuration = new Configuration();
                configuration.fontScale = 0.0f;
                if (configuration3.diff(configuration4) != 0) {
                    float f4 = configuration3.fontScale;
                    float f5 = configuration4.fontScale;
                    if (f4 != f5) {
                        configuration.fontScale = f5;
                    }
                    int i14 = configuration3.mcc;
                    int i15 = configuration4.mcc;
                    if (i14 != i15) {
                        configuration.mcc = i15;
                    }
                    int i16 = configuration3.mnc;
                    int i17 = configuration4.mnc;
                    if (i16 != i17) {
                        configuration.mnc = i17;
                    }
                    v.a(configuration3, configuration4, configuration);
                    int i18 = configuration3.touchscreen;
                    int i19 = configuration4.touchscreen;
                    if (i18 != i19) {
                        configuration.touchscreen = i19;
                    }
                    int i20 = configuration3.keyboard;
                    int i21 = configuration4.keyboard;
                    if (i20 != i21) {
                        configuration.keyboard = i21;
                    }
                    int i22 = configuration3.keyboardHidden;
                    int i23 = configuration4.keyboardHidden;
                    if (i22 != i23) {
                        configuration.keyboardHidden = i23;
                    }
                    int i24 = configuration3.navigation;
                    int i25 = configuration4.navigation;
                    if (i24 != i25) {
                        configuration.navigation = i25;
                    }
                    int i26 = configuration3.navigationHidden;
                    int i27 = configuration4.navigationHidden;
                    if (i26 != i27) {
                        configuration.navigationHidden = i27;
                    }
                    int i28 = configuration3.orientation;
                    int i29 = configuration4.orientation;
                    if (i28 != i29) {
                        configuration.orientation = i29;
                    }
                    int i30 = configuration3.screenLayout & 15;
                    int i31 = configuration4.screenLayout & 15;
                    if (i30 != i31) {
                        configuration.screenLayout |= i31;
                    }
                    int i32 = configuration3.screenLayout & 192;
                    int i33 = configuration4.screenLayout & 192;
                    if (i32 != i33) {
                        configuration.screenLayout |= i33;
                    }
                    int i34 = configuration3.screenLayout & 48;
                    int i35 = configuration4.screenLayout & 48;
                    if (i34 != i35) {
                        configuration.screenLayout |= i35;
                    }
                    int i36 = configuration3.screenLayout & 768;
                    int i37 = configuration4.screenLayout & 768;
                    if (i36 != i37) {
                        configuration.screenLayout |= i37;
                    }
                    if (i13 >= 26) {
                        i4 = configuration3.colorMode;
                        int i38 = i4 & 3;
                        i5 = configuration4.colorMode;
                        if (i38 != (i5 & 3)) {
                            i10 = configuration.colorMode;
                            i11 = configuration4.colorMode;
                            configuration.colorMode = i10 | (i11 & 3);
                        }
                        i6 = configuration3.colorMode;
                        int i39 = i6 & 12;
                        i7 = configuration4.colorMode;
                        if (i39 != (i7 & 12)) {
                            i8 = configuration.colorMode;
                            i9 = configuration4.colorMode;
                            configuration.colorMode = i8 | (i9 & 12);
                        }
                    }
                    int i40 = configuration3.uiMode & 15;
                    int i41 = configuration4.uiMode & 15;
                    if (i40 != i41) {
                        configuration.uiMode |= i41;
                    }
                    int i42 = configuration3.uiMode & 48;
                    int i43 = configuration4.uiMode & 48;
                    if (i42 != i43) {
                        configuration.uiMode |= i43;
                    }
                    int i44 = configuration3.screenWidthDp;
                    int i45 = configuration4.screenWidthDp;
                    if (i44 != i45) {
                        configuration.screenWidthDp = i45;
                    }
                    int i46 = configuration3.screenHeightDp;
                    int i47 = configuration4.screenHeightDp;
                    if (i46 != i47) {
                        configuration.screenHeightDp = i47;
                    }
                    int i48 = configuration3.smallestScreenWidthDp;
                    int i49 = configuration4.smallestScreenWidthDp;
                    if (i48 != i49) {
                        configuration.smallestScreenWidthDp = i49;
                    }
                    int i50 = configuration3.densityDpi;
                    int i51 = configuration4.densityDpi;
                    if (i50 != i51) {
                        configuration.densityDpi = i51;
                    }
                }
            } else {
                configuration = null;
            }
            Configuration t4 = f0.t(context, C, o4, configuration, true);
            f.f fVar3 = new f.f(context, 2131755544);
            fVar3.a(t4);
            try {
                if (context.getTheme() != null) {
                    Resources.Theme theme = fVar3.getTheme();
                    if (i13 >= 29) {
                        a0.r.a(theme);
                    } else {
                        synchronized (a0.q.f35a) {
                            if (!a0.q.f37c) {
                                try {
                                    Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                                    a0.q.f36b = declaredMethod;
                                    declaredMethod.setAccessible(true);
                                } catch (NoSuchMethodException e4) {
                                    Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e4);
                                }
                                a0.q.f37c = true;
                            }
                            Method method = a0.q.f36b;
                            if (method != null) {
                                try {
                                    method.invoke(theme, new Object[0]);
                                } catch (IllegalAccessException | InvocationTargetException e5) {
                                    Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e5);
                                    a0.q.f36b = null;
                                }
                            }
                        }
                    }
                }
            } catch (NullPointerException unused3) {
            }
            context = fVar3;
        }
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity
    public final void closeOptionsMenu() {
        ((f0) l()).A();
        if (getWindow().hasFeature(0)) {
            super.closeOptionsMenu();
        }
    }

    @Override // androidx.core.app.ComponentActivity
    public final void d() {
        l().c();
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getKeyCode();
        ((f0) l()).A();
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public final View findViewById(int i4) {
        f0 f0Var = (f0) l();
        f0Var.w();
        return f0Var.f239l.findViewById(i4);
    }

    @Override // android.app.Activity
    public final MenuInflater getMenuInflater() {
        Context context;
        f0 f0Var = (f0) l();
        if (f0Var.f243p == null) {
            f0Var.A();
            u0 u0Var = f0Var.f242o;
            if (u0Var != null) {
                context = u0Var.b();
            } else {
                context = f0Var.f238k;
            }
            f0Var.f243p = new f.l(context);
        }
        return f0Var.f243p;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        int i4 = c4.f729a;
        return super.getResources();
    }

    @Override // android.app.Activity
    public final void invalidateOptionsMenu() {
        l().c();
    }

    public final q l() {
        if (this.f180y == null) {
            m0 m0Var = q.f312a;
            this.f180y = new f0(this, null, this, this);
        }
        return this.f180y;
    }

    public final void m() {
        View decorView = getWindow().getDecorView();
        com.google.common.collect.c.F(decorView, "<this>");
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        View decorView2 = getWindow().getDecorView();
        com.google.common.collect.c.F(decorView2, "<this>");
        decorView2.setTag(R.id.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        com.google.common.collect.c.F(decorView3, "<this>");
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
        View decorView4 = getWindow().getDecorView();
        com.google.common.collect.c.F(decorView4, "<this>");
        decorView4.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        f0 f0Var = (f0) l();
        if (f0Var.F && f0Var.f253z) {
            f0Var.A();
            u0 u0Var = f0Var.f242o;
            if (u0Var != null) {
                u0Var.e(f.a.a(u0Var.f344a).f4443a.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs));
            }
        }
        androidx.appcompat.widget.a0 a5 = androidx.appcompat.widget.a0.a();
        Context context = f0Var.f238k;
        synchronized (a5) {
            m2 m2Var = a5.f693a;
            synchronized (m2Var) {
                l.e eVar = (l.e) m2Var.f827b.get(context);
                if (eVar != null) {
                    eVar.a();
                }
            }
        }
        f0Var.R = new Configuration(f0Var.f238k.getResources().getConfiguration());
        f0Var.m(false, false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onContentChanged() {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        l().f();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i4, KeyEvent keyEvent) {
        Window window;
        if (Build.VERSION.SDK_INT < 26 && !keyEvent.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) && keyEvent.getRepeatCount() == 0 && !KeyEvent.isModifierKey(keyEvent.getKeyCode()) && (window = getWindow()) != null && window.getDecorView() != null && window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i4, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i4, MenuItem menuItem) {
        Intent F0;
        if (super.onMenuItemSelected(i4, menuItem)) {
            return true;
        }
        f0 f0Var = (f0) l();
        f0Var.A();
        u0 u0Var = f0Var.f242o;
        if (menuItem.getItemId() == 16908332 && u0Var != null && (((x3) u0Var.f348e).f951b & 4) != 0 && (F0 = com.google.common.collect.c.F0(this)) != null) {
            if (x.r.c(this, F0)) {
                ArrayList arrayList = new ArrayList();
                Intent F02 = com.google.common.collect.c.F0(this);
                if (F02 == null) {
                    F02 = com.google.common.collect.c.F0(this);
                }
                if (F02 != null) {
                    ComponentName component = F02.getComponent();
                    if (component == null) {
                        component = F02.resolveActivity(getPackageManager());
                    }
                    int size = arrayList.size();
                    while (true) {
                        try {
                            Intent G0 = com.google.common.collect.c.G0(this, component);
                            if (G0 == null) {
                                break;
                            }
                            arrayList.add(size, G0);
                            component = G0.getComponent();
                        } catch (PackageManager.NameNotFoundException e4) {
                            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                            throw new IllegalArgumentException(e4);
                        }
                    }
                    arrayList.add(F02);
                }
                if (!arrayList.isEmpty()) {
                    Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
                    intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
                    Object obj = z.e.f7215a;
                    z.a.a(this, intentArr, null);
                    try {
                        int i5 = x.e.f7064b;
                        x.a.a(this);
                        return true;
                    } catch (IllegalStateException unused) {
                        finish();
                        return true;
                    }
                }
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
            x.r.b(this, F0);
            return true;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onMenuOpened(int i4, Menu menu) {
        return super.onMenuOpened(i4, menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final void onPanelClosed(int i4, Menu menu) {
        super.onPanelClosed(i4, menu);
    }

    @Override // android.app.Activity
    public final void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((f0) l()).w();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPostResume() {
        super.onPostResume();
        f0 f0Var = (f0) l();
        f0Var.A();
        u0 u0Var = f0Var.f242o;
        if (u0Var != null) {
            u0Var.f363t = true;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        ((f0) l()).m(true, false);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        f0 f0Var = (f0) l();
        f0Var.A();
        u0 u0Var = f0Var.f242o;
        if (u0Var != null) {
            u0Var.f363t = false;
            f.n nVar = u0Var.f362s;
            if (nVar != null) {
                nVar.a();
            }
        }
    }

    @Override // android.app.Activity
    public final void onTitleChanged(CharSequence charSequence, int i4) {
        super.onTitleChanged(charSequence, i4);
        l().l(charSequence);
    }

    @Override // android.app.Activity
    public final void openOptionsMenu() {
        ((f0) l()).A();
        if (getWindow().hasFeature(0)) {
            super.openOptionsMenu();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void setContentView(int i4) {
        m();
        l().i(i4);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i4) {
        super.setTheme(i4);
        ((f0) l()).T = i4;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        m();
        l().j(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m();
        l().k(view, layoutParams);
    }
}
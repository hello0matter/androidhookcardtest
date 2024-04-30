package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateHandleAttacher;
import androidx.lifecycle.e0;
import androidx.lifecycle.f0;
import androidx.lifecycle.i0;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import com.example.msphone.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements l0, androidx.lifecycle.h, z0.f, x, androidx.activity.result.g {

    /* renamed from: s */
    public static final /* synthetic */ int f58s = 0;

    /* renamed from: b */
    public final a.a f59b = new a.a();

    /* renamed from: c */
    public final androidx.appcompat.app.c f60c = new androidx.appcompat.app.c(new d(0, this));

    /* renamed from: d */
    public final androidx.lifecycle.s f61d;

    /* renamed from: e */
    public final z0.e f62e;

    /* renamed from: f */
    public k0 f63f;

    /* renamed from: g */
    public w f64g;

    /* renamed from: h */
    public final n f65h;

    /* renamed from: i */
    public final q f66i;

    /* renamed from: j */
    public final AtomicInteger f67j;

    /* renamed from: k */
    public final i f68k;

    /* renamed from: l */
    public final CopyOnWriteArrayList f69l;

    /* renamed from: m */
    public final CopyOnWriteArrayList f70m;

    /* renamed from: n */
    public final CopyOnWriteArrayList f71n;

    /* renamed from: o */
    public final CopyOnWriteArrayList f72o;

    /* renamed from: p */
    public final CopyOnWriteArrayList f73p;

    /* renamed from: q */
    public boolean f74q;

    /* renamed from: r */
    public boolean f75r;

    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.activity.e] */
    public ComponentActivity() {
        androidx.lifecycle.s sVar = new androidx.lifecycle.s(this);
        this.f61d = sVar;
        z0.e c4 = l2.f.c(this);
        this.f62e = c4;
        z0.c cVar = null;
        this.f64g = null;
        n nVar = new n(this);
        this.f65h = nVar;
        this.f66i = new q(nVar, new e3.a() { // from class: androidx.activity.e
            @Override // e3.a
            public final Object a() {
                int i4 = ComponentActivity.f58s;
                ComponentActivity.this.reportFullyDrawn();
                return null;
            }
        });
        this.f67j = new AtomicInteger();
        this.f68k = new i(this);
        this.f69l = new CopyOnWriteArrayList();
        this.f70m = new CopyOnWriteArrayList();
        this.f71n = new CopyOnWriteArrayList();
        this.f72o = new CopyOnWriteArrayList();
        this.f73p = new CopyOnWriteArrayList();
        this.f74q = false;
        this.f75r = false;
        sVar.a(new androidx.lifecycle.o() { // from class: androidx.activity.ComponentActivity.2
            {
                ComponentActivity.this = this;
            }

            @Override // androidx.lifecycle.o
            public final void b(androidx.lifecycle.q qVar, Lifecycle$Event lifecycle$Event) {
                View view;
                if (lifecycle$Event == Lifecycle$Event.ON_STOP) {
                    Window window = ComponentActivity.this.getWindow();
                    if (window != null) {
                        view = window.peekDecorView();
                    } else {
                        view = null;
                    }
                    if (view != null) {
                        view.cancelPendingInputEvents();
                    }
                }
            }
        });
        sVar.a(new androidx.lifecycle.o() { // from class: androidx.activity.ComponentActivity.3
            {
                ComponentActivity.this = this;
            }

            @Override // androidx.lifecycle.o
            public final void b(androidx.lifecycle.q qVar, Lifecycle$Event lifecycle$Event) {
                if (lifecycle$Event == Lifecycle$Event.ON_DESTROY) {
                    ComponentActivity.this.f59b.f1b = null;
                    if (!ComponentActivity.this.isChangingConfigurations()) {
                        ComponentActivity.this.e().a();
                    }
                    n nVar2 = ComponentActivity.this.f65h;
                    ComponentActivity componentActivity = nVar2.f111d;
                    componentActivity.getWindow().getDecorView().removeCallbacks(nVar2);
                    componentActivity.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(nVar2);
                }
            }
        });
        sVar.a(new androidx.lifecycle.o() { // from class: androidx.activity.ComponentActivity.4
            {
                ComponentActivity.this = this;
            }

            @Override // androidx.lifecycle.o
            public final void b(androidx.lifecycle.q qVar, Lifecycle$Event lifecycle$Event) {
                ComponentActivity componentActivity = ComponentActivity.this;
                if (componentActivity.f63f == null) {
                    m mVar = (m) componentActivity.getLastNonConfigurationInstance();
                    if (mVar != null) {
                        componentActivity.f63f = mVar.f107a;
                    }
                    if (componentActivity.f63f == null) {
                        componentActivity.f63f = new k0();
                    }
                }
                componentActivity.f61d.b(this);
            }
        });
        c4.a();
        Lifecycle$State lifecycle$State = sVar.f1915c;
        if (lifecycle$State != Lifecycle$State.f1865b && lifecycle$State != Lifecycle$State.f1866c) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        z0.d dVar = c4.f7226b;
        dVar.getClass();
        Iterator it = dVar.f7219a.iterator();
        while (true) {
            i.e eVar = (i.e) it;
            if (!eVar.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) eVar.next();
            com.google.common.collect.c.E(entry, "components");
            z0.c cVar2 = (z0.c) entry.getValue();
            if (com.google.common.collect.c.n((String) entry.getKey(), "androidx.lifecycle.internal.SavedStateHandlesProvider")) {
                cVar = cVar2;
                break;
            }
        }
        if (cVar == null) {
            f0 f0Var = new f0(this.f62e.f7226b, this);
            this.f62e.f7226b.b("androidx.lifecycle.internal.SavedStateHandlesProvider", f0Var);
            this.f61d.a(new SavedStateHandleAttacher(f0Var));
        }
        this.f62e.f7226b.b("android:support:activity-result", new z0.c() { // from class: androidx.activity.f
            @Override // z0.c
            public final Bundle a() {
                int i4 = ComponentActivity.f58s;
                ComponentActivity componentActivity = ComponentActivity.this;
                componentActivity.getClass();
                Bundle bundle = new Bundle();
                i iVar = componentActivity.f68k;
                iVar.getClass();
                HashMap hashMap = iVar.f140b;
                bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(hashMap.values()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(hashMap.keySet()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(iVar.f142d));
                bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) iVar.f145g.clone());
                return bundle;
            }
        });
        h(new a.b() { // from class: androidx.activity.g
            @Override // a.b
            public final void a() {
                ComponentActivity componentActivity = ComponentActivity.this;
                Bundle a5 = componentActivity.f62e.f7226b.a("android:support:activity-result");
                if (a5 != null) {
                    i iVar = componentActivity.f68k;
                    iVar.getClass();
                    ArrayList<Integer> integerArrayList = a5.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
                    ArrayList<String> stringArrayList = a5.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
                    if (stringArrayList != null && integerArrayList != null) {
                        iVar.f142d = a5.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                        Bundle bundle = a5.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
                        Bundle bundle2 = iVar.f145g;
                        bundle2.putAll(bundle);
                        for (int i4 = 0; i4 < stringArrayList.size(); i4++) {
                            String str = stringArrayList.get(i4);
                            HashMap hashMap = iVar.f140b;
                            boolean containsKey = hashMap.containsKey(str);
                            HashMap hashMap2 = iVar.f139a;
                            if (containsKey) {
                                Integer num = (Integer) hashMap.remove(str);
                                if (!bundle2.containsKey(str)) {
                                    hashMap2.remove(num);
                                }
                            }
                            Integer num2 = integerArrayList.get(i4);
                            num2.intValue();
                            String str2 = stringArrayList.get(i4);
                            hashMap2.put(num2, str2);
                            hashMap.put(str2, num2);
                        }
                    }
                }
            }
        });
    }

    public static /* synthetic */ void g(ComponentActivity componentActivity) {
        super.onBackPressed();
    }

    @Override // androidx.lifecycle.h
    public final v0.b a() {
        v0.d dVar = new v0.d(v0.a.f6946b);
        Application application = getApplication();
        LinkedHashMap linkedHashMap = dVar.f6947a;
        if (application != null) {
            linkedHashMap.put(i0.f1906a, getApplication());
        }
        linkedHashMap.put(e0.f1896a, this);
        linkedHashMap.put(e0.f1897b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            linkedHashMap.put(e0.f1898c, getIntent().getExtras());
        }
        return dVar;
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        j();
        this.f65h.a(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    @Override // z0.f
    public final z0.d b() {
        return this.f62e.f7226b;
    }

    @Override // androidx.lifecycle.l0
    public final k0 e() {
        if (getApplication() != null) {
            if (this.f63f == null) {
                m mVar = (m) getLastNonConfigurationInstance();
                if (mVar != null) {
                    this.f63f = mVar.f107a;
                }
                if (this.f63f == null) {
                    this.f63f = new k0();
                }
            }
            return this.f63f;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.q
    public final androidx.lifecycle.s f() {
        return this.f61d;
    }

    public final void h(a.b bVar) {
        a.a aVar = this.f59b;
        aVar.getClass();
        if (aVar.f1b != null) {
            bVar.a();
        }
        aVar.f0a.add(bVar);
    }

    public final w i() {
        if (this.f64g == null) {
            this.f64g = new w(new k(0, this));
            this.f61d.a(new androidx.lifecycle.o() { // from class: androidx.activity.ComponentActivity.6
                {
                    ComponentActivity.this = this;
                }

                @Override // androidx.lifecycle.o
                public final void b(androidx.lifecycle.q qVar, Lifecycle$Event lifecycle$Event) {
                    if (lifecycle$Event == Lifecycle$Event.ON_CREATE && Build.VERSION.SDK_INT >= 33) {
                        w wVar = ComponentActivity.this.f64g;
                        OnBackInvokedDispatcher a5 = l.a((ComponentActivity) qVar);
                        wVar.getClass();
                        com.google.common.collect.c.F(a5, "invoker");
                        wVar.f162e = a5;
                        wVar.c(wVar.f164g);
                    }
                }
            });
        }
        return this.f64g;
    }

    public final void j() {
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
        View decorView5 = getWindow().getDecorView();
        com.google.common.collect.c.F(decorView5, "<this>");
        decorView5.setTag(R.id.report_drawn, this);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        if (this.f68k.a(i4, i5, intent)) {
            return;
        }
        super.onActivityResult(i4, i5, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        i().b();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator it = this.f69l.iterator();
        while (it.hasNext()) {
            ((f0.g) ((h0.a) it.next())).b(configuration);
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f62e.b(bundle);
        a.a aVar = this.f59b;
        aVar.getClass();
        aVar.f1b = this;
        Iterator it = aVar.f0a.iterator();
        while (it.hasNext()) {
            ((a.b) it.next()).a();
        }
        super.onCreate(bundle);
        int i4 = ReportFragment.f1872b;
        l2.f.k(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i4, Menu menu) {
        if (i4 == 0) {
            super.onCreatePanelMenu(i4, menu);
            getMenuInflater();
            Iterator it = ((CopyOnWriteArrayList) this.f60c.f193b).iterator();
            if (it.hasNext()) {
                j.f(it.next());
                throw null;
            }
            return true;
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i4, MenuItem menuItem) {
        if (super.onMenuItemSelected(i4, menuItem)) {
            return true;
        }
        if (i4 != 0) {
            return false;
        }
        Iterator it = ((CopyOnWriteArrayList) this.f60c.f193b).iterator();
        if (!it.hasNext()) {
            return false;
        }
        j.f(it.next());
        throw null;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z4) {
        if (this.f74q) {
            return;
        }
        Iterator it = this.f72o.iterator();
        while (it.hasNext()) {
            ((f0.g) ((h0.a) it.next())).b(new x.q(z4));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator it = this.f71n.iterator();
        while (it.hasNext()) {
            ((f0.g) ((h0.a) it.next())).b(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i4, Menu menu) {
        Iterator it = ((CopyOnWriteArrayList) this.f60c.f193b).iterator();
        if (!it.hasNext()) {
            super.onPanelClosed(i4, menu);
        } else {
            j.f(it.next());
            throw null;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z4) {
        if (this.f75r) {
            return;
        }
        Iterator it = this.f73p.iterator();
        while (it.hasNext()) {
            ((f0.g) ((h0.a) it.next())).b(new x.q(z4));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i4, View view, Menu menu) {
        if (i4 == 0) {
            super.onPreparePanel(i4, view, menu);
            Iterator it = ((CopyOnWriteArrayList) this.f60c.f193b).iterator();
            if (it.hasNext()) {
                j.f(it.next());
                throw null;
            }
            return true;
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i4, String[] strArr, int[] iArr) {
        if (this.f68k.a(i4, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i4, strArr, iArr);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.activity.m, java.lang.Object] */
    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        m mVar;
        k0 k0Var = this.f63f;
        if (k0Var == null && (mVar = (m) getLastNonConfigurationInstance()) != null) {
            k0Var = mVar.f107a;
        }
        if (k0Var == null) {
            return null;
        }
        ?? obj = new Object();
        obj.f107a = k0Var;
        return obj;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.s sVar = this.f61d;
        if (sVar instanceof androidx.lifecycle.s) {
            sVar.g();
        }
        super.onSaveInstanceState(bundle);
        this.f62e.c(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i4) {
        super.onTrimMemory(i4);
        Iterator it = this.f70m.iterator();
        while (it.hasNext()) {
            ((f0.g) ((h0.a) it.next())).b(Integer.valueOf(i4));
        }
    }

    @Override // android.app.Activity
    public final void reportFullyDrawn() {
        try {
            if (com.google.common.collect.c.Y0()) {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            this.f66i.a();
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i4) {
        j();
        this.f65h.a(getWindow().getDecorView());
        super.setContentView(i4);
    }

    @Override // android.app.Activity
    public final void startActivityForResult(Intent intent, int i4) {
        super.startActivityForResult(intent, i4);
    }

    @Override // android.app.Activity
    public final void startIntentSenderForResult(IntentSender intentSender, int i4, Intent intent, int i5, int i6, int i7) {
        super.startIntentSenderForResult(intentSender, i4, intent, i5, i6, i7);
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z4, Configuration configuration) {
        this.f74q = true;
        try {
            super.onMultiWindowModeChanged(z4, configuration);
            this.f74q = false;
            Iterator it = this.f72o.iterator();
            while (it.hasNext()) {
                ((f0.g) ((h0.a) it.next())).b(new x.q(z4, configuration));
            }
        } catch (Throwable th) {
            this.f74q = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z4, Configuration configuration) {
        this.f75r = true;
        try {
            super.onPictureInPictureModeChanged(z4, configuration);
            this.f75r = false;
            Iterator it = this.f73p.iterator();
            while (it.hasNext()) {
                ((f0.g) ((h0.a) it.next())).b(new x.q(z4, configuration));
            }
        } catch (Throwable th) {
            this.f75r = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        j();
        this.f65h.a(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public final void startActivityForResult(Intent intent, int i4, Bundle bundle) {
        super.startActivityForResult(intent, i4, bundle);
    }

    @Override // android.app.Activity
    public final void startIntentSenderForResult(IntentSender intentSender, int i4, Intent intent, int i5, int i6, int i7, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i4, intent, i5, i6, i7, bundle);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        j();
        this.f65h.a(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }
}
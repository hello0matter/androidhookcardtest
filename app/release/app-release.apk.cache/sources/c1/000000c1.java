package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.e4;
import androidx.appcompat.widget.k1;
import androidx.appcompat.widget.l1;
import androidx.appcompat.widget.q3;
import androidx.appcompat.widget.u3;
import androidx.appcompat.widget.x3;
import com.example.msphone.R;
import i0.g1;
import i0.g2;
import i0.y0;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class f0 extends q implements g.n, LayoutInflater.Factory2 {

    /* renamed from: h0  reason: collision with root package name */
    public static final l.k f226h0 = new l.k();

    /* renamed from: i0  reason: collision with root package name */
    public static final int[] f227i0 = {16842836};

    /* renamed from: j0  reason: collision with root package name */
    public static final boolean f228j0 = !"robolectric".equals(Build.FINGERPRINT);

    /* renamed from: k0  reason: collision with root package name */
    public static final boolean f229k0 = true;
    public ViewGroup A;
    public TextView B;
    public View C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public e0[] L;
    public e0 M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public Configuration R;
    public final int S;
    public int T;
    public int U;
    public boolean V;
    public z W;
    public z X;
    public boolean Y;
    public int Z;

    /* renamed from: b0  reason: collision with root package name */
    public boolean f231b0;

    /* renamed from: c0  reason: collision with root package name */
    public Rect f232c0;

    /* renamed from: d0  reason: collision with root package name */
    public Rect f233d0;

    /* renamed from: e0  reason: collision with root package name */
    public j0 f234e0;

    /* renamed from: f0  reason: collision with root package name */
    public OnBackInvokedDispatcher f235f0;

    /* renamed from: g0  reason: collision with root package name */
    public OnBackInvokedCallback f236g0;

    /* renamed from: j  reason: collision with root package name */
    public final Object f237j;

    /* renamed from: k  reason: collision with root package name */
    public final Context f238k;

    /* renamed from: l  reason: collision with root package name */
    public Window f239l;

    /* renamed from: m  reason: collision with root package name */
    public y f240m;

    /* renamed from: n  reason: collision with root package name */
    public final m f241n;

    /* renamed from: o  reason: collision with root package name */
    public u0 f242o;

    /* renamed from: p  reason: collision with root package name */
    public f.l f243p;

    /* renamed from: q  reason: collision with root package name */
    public CharSequence f244q;

    /* renamed from: r  reason: collision with root package name */
    public k1 f245r;

    /* renamed from: s  reason: collision with root package name */
    public s f246s;

    /* renamed from: t  reason: collision with root package name */
    public s f247t;

    /* renamed from: u  reason: collision with root package name */
    public f.c f248u;

    /* renamed from: v  reason: collision with root package name */
    public ActionBarContextView f249v;

    /* renamed from: w  reason: collision with root package name */
    public PopupWindow f250w;

    /* renamed from: x  reason: collision with root package name */
    public r f251x;

    /* renamed from: z  reason: collision with root package name */
    public boolean f253z;

    /* renamed from: y  reason: collision with root package name */
    public g1 f252y = null;

    /* renamed from: a0  reason: collision with root package name */
    public final r f230a0 = new r(this, 0);

    public f0(Context context, Window window, m mVar, Object obj) {
        AppCompatActivity appCompatActivity;
        this.S = -100;
        this.f238k = context;
        this.f241n = mVar;
        this.f237j = obj;
        if (obj instanceof Dialog) {
            while (context != null) {
                if (context instanceof AppCompatActivity) {
                    appCompatActivity = (AppCompatActivity) context;
                    break;
                } else if (!(context instanceof ContextWrapper)) {
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            appCompatActivity = null;
            if (appCompatActivity != null) {
                this.S = ((f0) appCompatActivity.l()).S;
            }
        }
        if (this.S == -100) {
            l.k kVar = f226h0;
            Integer num = (Integer) kVar.getOrDefault(this.f237j.getClass().getName(), null);
            if (num != null) {
                this.S = num.intValue();
                kVar.remove(this.f237j.getClass().getName());
            }
        }
        if (window != null) {
            n(window);
        }
        androidx.appcompat.widget.a0.d();
    }

    public static e0.f o(Context context) {
        e0.f fVar;
        e0.f fVar2;
        Locale locale;
        if (Build.VERSION.SDK_INT >= 33 || (fVar = q.f314c) == null) {
            return null;
        }
        e0.f b5 = v.b(context.getApplicationContext().getResources().getConfiguration());
        e0.g gVar = fVar.f4427a;
        if (((e0.h) gVar).f4428a.isEmpty()) {
            fVar2 = e0.f.f4426b;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (int i4 = 0; i4 < ((e0.h) b5.f4427a).f4428a.size() + ((e0.h) gVar).f4428a.size(); i4++) {
                if (i4 < ((e0.h) gVar).f4428a.size()) {
                    locale = ((e0.h) gVar).f4428a.get(i4);
                } else {
                    locale = ((e0.h) b5.f4427a).f4428a.get(i4 - ((e0.h) gVar).f4428a.size());
                }
                if (locale != null) {
                    linkedHashSet.add(locale);
                }
            }
            fVar2 = new e0.f(new e0.h(e0.e.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]))));
        }
        if (!((e0.h) fVar2.f4427a).f4428a.isEmpty()) {
            return fVar2;
        }
        return b5;
    }

    public static Configuration t(Context context, int i4, e0.f fVar, Configuration configuration, boolean z4) {
        int i5;
        if (i4 != 1) {
            if (i4 != 2) {
                if (z4) {
                    i5 = 0;
                } else {
                    i5 = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
                }
            } else {
                i5 = 32;
            }
        } else {
            i5 = 16;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i5 | (configuration2.uiMode & (-49));
        if (fVar != null) {
            v.d(configuration2, fVar);
        }
        return configuration2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A() {
        /*
            r3 = this;
            r3.w()
            boolean r0 = r3.F
            if (r0 == 0) goto L33
            androidx.appcompat.app.u0 r0 = r3.f242o
            if (r0 == 0) goto Lc
            goto L33
        Lc:
            java.lang.Object r0 = r3.f237j
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L1e
            androidx.appcompat.app.u0 r1 = new androidx.appcompat.app.u0
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r2 = r3.G
            r1.<init>(r0, r2)
        L1b:
            r3.f242o = r1
            goto L2a
        L1e:
            boolean r1 = r0 instanceof android.app.Dialog
            if (r1 == 0) goto L2a
            androidx.appcompat.app.u0 r1 = new androidx.appcompat.app.u0
            android.app.Dialog r0 = (android.app.Dialog) r0
            r1.<init>(r0)
            goto L1b
        L2a:
            androidx.appcompat.app.u0 r0 = r3.f242o
            if (r0 == 0) goto L33
            boolean r1 = r3.f231b0
            r0.d(r1)
        L33:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f0.A():void");
    }

    public final void B(int i4) {
        this.Z = (1 << i4) | this.Z;
        if (!this.Y) {
            View decorView = this.f239l.getDecorView();
            WeakHashMap weakHashMap = y0.f4999a;
            i0.g0.m(decorView, this.f230a0);
            this.Y = true;
        }
    }

    public final int C(Context context, int i4) {
        if (i4 == -100) {
            return -1;
        }
        if (i4 != -1) {
            if (i4 != 0) {
                if (i4 != 1 && i4 != 2) {
                    if (i4 == 3) {
                        if (this.X == null) {
                            this.X = new z(this, context);
                        }
                        return this.X.b();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            } else if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                return -1;
            } else {
                return y(context).b();
            }
        }
        return i4;
    }

    public final boolean D() {
        l1 l1Var;
        u3 u3Var;
        g.r rVar;
        boolean z4 = this.N;
        this.N = false;
        e0 z5 = z(0);
        if (z5.f221m) {
            if (!z4) {
                s(z5, true);
            }
            return true;
        }
        f.c cVar = this.f248u;
        if (cVar != null) {
            cVar.a();
            return true;
        }
        A();
        u0 u0Var = this.f242o;
        if (u0Var == null || (l1Var = u0Var.f348e) == null || (u3Var = ((x3) l1Var).f950a.L) == null || u3Var.f920b == null) {
            return false;
        }
        u3 u3Var2 = ((x3) l1Var).f950a.L;
        if (u3Var2 == null) {
            rVar = null;
        } else {
            rVar = u3Var2.f920b;
        }
        if (rVar != null) {
            rVar.collapseActionView();
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x0150, code lost:
        if (r3 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0170, code lost:
        if (r3.f4687f.getCount() > 0) goto L65;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void E(androidx.appcompat.app.e0 r19, android.view.KeyEvent r20) {
        /*
            Method dump skipped, instructions count: 469
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f0.E(androidx.appcompat.app.e0, android.view.KeyEvent):void");
    }

    public final boolean F(e0 e0Var, int i4, KeyEvent keyEvent) {
        g.p pVar;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((!e0Var.f219k && !G(e0Var, keyEvent)) || (pVar = e0Var.f216h) == null) {
            return false;
        }
        return pVar.performShortcut(i4, keyEvent, 1);
    }

    public final boolean G(e0 e0Var, KeyEvent keyEvent) {
        boolean z4;
        k1 k1Var;
        k1 k1Var2;
        Resources.Theme theme;
        int i4;
        boolean z5;
        k1 k1Var3;
        k1 k1Var4;
        if (this.Q) {
            return false;
        }
        if (e0Var.f219k) {
            return true;
        }
        e0 e0Var2 = this.M;
        if (e0Var2 != null && e0Var2 != e0Var) {
            s(e0Var2, false);
        }
        Window.Callback callback = this.f239l.getCallback();
        int i5 = e0Var.f209a;
        if (callback != null) {
            e0Var.f215g = callback.onCreatePanelView(i5);
        }
        if (i5 != 0 && i5 != 108) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z4 && (k1Var4 = this.f245r) != null) {
            k1Var4.setMenuPrepared();
        }
        if (e0Var.f215g == null) {
            g.p pVar = e0Var.f216h;
            if (pVar == null || e0Var.f223o) {
                if (pVar == null) {
                    Context context = this.f238k;
                    if ((i5 == 0 || i5 == 108) && this.f245r != null) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme2 = context.getTheme();
                        theme2.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            theme = context.getResources().newTheme();
                            theme.setTo(theme2);
                            theme.applyStyle(typedValue.resourceId, true);
                            theme.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme2.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
                            theme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (theme == null) {
                                theme = context.getResources().newTheme();
                                theme.setTo(theme2);
                            }
                            theme.applyStyle(typedValue.resourceId, true);
                        }
                        if (theme != null) {
                            f.f fVar = new f.f(context, 0);
                            fVar.getTheme().setTo(theme);
                            context = fVar;
                        }
                    }
                    g.p pVar2 = new g.p(context);
                    pVar2.f4699e = this;
                    g.p pVar3 = e0Var.f216h;
                    if (pVar2 != pVar3) {
                        if (pVar3 != null) {
                            pVar3.r(e0Var.f217i);
                        }
                        e0Var.f216h = pVar2;
                        g.l lVar = e0Var.f217i;
                        if (lVar != null) {
                            pVar2.b(lVar, pVar2.f4695a);
                        }
                    }
                    if (e0Var.f216h == null) {
                        return false;
                    }
                }
                if (z4 && (k1Var2 = this.f245r) != null) {
                    if (this.f246s == null) {
                        this.f246s = new s(this, 3);
                    }
                    k1Var2.setMenu(e0Var.f216h, this.f246s);
                }
                e0Var.f216h.y();
                if (!callback.onCreatePanelMenu(i5, e0Var.f216h)) {
                    g.p pVar4 = e0Var.f216h;
                    if (pVar4 != null) {
                        if (pVar4 != null) {
                            pVar4.r(e0Var.f217i);
                        }
                        e0Var.f216h = null;
                    }
                    if (z4 && (k1Var = this.f245r) != null) {
                        k1Var.setMenu(null, this.f246s);
                    }
                    return false;
                }
                e0Var.f223o = false;
            }
            e0Var.f216h.y();
            Bundle bundle = e0Var.f224p;
            if (bundle != null) {
                e0Var.f216h.s(bundle);
                e0Var.f224p = null;
            }
            if (!callback.onPreparePanel(0, e0Var.f215g, e0Var.f216h)) {
                if (z4 && (k1Var3 = this.f245r) != null) {
                    k1Var3.setMenu(null, this.f246s);
                }
                e0Var.f216h.x();
                return false;
            }
            if (keyEvent != null) {
                i4 = keyEvent.getDeviceId();
            } else {
                i4 = -1;
            }
            if (KeyCharacterMap.load(i4).getKeyboardType() != 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            e0Var.f216h.setQwertyMode(z5);
            e0Var.f216h.x();
        }
        e0Var.f219k = true;
        e0Var.f220l = false;
        this.M = e0Var;
        return true;
    }

    public final void H() {
        if (this.f253z) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void I() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z4 = false;
            if (this.f235f0 != null && (z(0).f221m || this.f248u != null)) {
                z4 = true;
            }
            if (z4 && this.f236g0 == null) {
                this.f236g0 = x.b(this.f235f0, this);
            } else if (!z4 && (onBackInvokedCallback = this.f236g0) != null) {
                x.c(this.f235f0, onBackInvokedCallback);
            }
        }
    }

    public final int J(g2 g2Var, Rect rect) {
        int i4;
        boolean z4;
        int b5;
        int c4;
        boolean z5;
        int i5;
        int i6 = 0;
        if (g2Var != null) {
            i4 = g2Var.d();
        } else if (rect != null) {
            i4 = rect.top;
        } else {
            i4 = 0;
        }
        ActionBarContextView actionBarContextView = this.f249v;
        if (actionBarContextView != null && (actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f249v.getLayoutParams();
            boolean z6 = true;
            if (this.f249v.isShown()) {
                if (this.f232c0 == null) {
                    this.f232c0 = new Rect();
                    this.f233d0 = new Rect();
                }
                Rect rect2 = this.f232c0;
                Rect rect3 = this.f233d0;
                if (g2Var == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(g2Var.b(), g2Var.d(), g2Var.c(), g2Var.a());
                }
                ViewGroup viewGroup = this.A;
                Method method = e4.f743a;
                if (method != null) {
                    try {
                        method.invoke(viewGroup, rect2, rect3);
                    } catch (Exception e4) {
                        Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e4);
                    }
                }
                int i7 = rect2.top;
                int i8 = rect2.left;
                int i9 = rect2.right;
                ViewGroup viewGroup2 = this.A;
                WeakHashMap weakHashMap = y0.f4999a;
                g2 a5 = i0.n0.a(viewGroup2);
                if (a5 == null) {
                    b5 = 0;
                } else {
                    b5 = a5.b();
                }
                if (a5 == null) {
                    c4 = 0;
                } else {
                    c4 = a5.c();
                }
                if (marginLayoutParams.topMargin == i7 && marginLayoutParams.leftMargin == i8 && marginLayoutParams.rightMargin == i9) {
                    z5 = false;
                } else {
                    marginLayoutParams.topMargin = i7;
                    marginLayoutParams.leftMargin = i8;
                    marginLayoutParams.rightMargin = i9;
                    z5 = true;
                }
                Context context = this.f238k;
                if (i7 > 0 && this.C == null) {
                    View view = new View(context);
                    this.C = view;
                    view.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = b5;
                    layoutParams.rightMargin = c4;
                    this.A.addView(this.C, -1, layoutParams);
                } else {
                    View view2 = this.C;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        int i10 = marginLayoutParams2.height;
                        int i11 = marginLayoutParams.topMargin;
                        if (i10 != i11 || marginLayoutParams2.leftMargin != b5 || marginLayoutParams2.rightMargin != c4) {
                            marginLayoutParams2.height = i11;
                            marginLayoutParams2.leftMargin = b5;
                            marginLayoutParams2.rightMargin = c4;
                            this.C.setLayoutParams(marginLayoutParams2);
                        }
                    }
                }
                View view3 = this.C;
                if (view3 == null) {
                    z6 = false;
                }
                if (z6 && view3.getVisibility() != 0) {
                    View view4 = this.C;
                    if ((i0.g0.g(view4) & 8192) != 0) {
                        Object obj = z.e.f7215a;
                        i5 = R.color.abc_decor_view_status_guard_light;
                    } else {
                        Object obj2 = z.e.f7215a;
                        i5 = R.color.abc_decor_view_status_guard;
                    }
                    view4.setBackgroundColor(z.d.a(context, i5));
                }
                if (!this.H && z6) {
                    i4 = 0;
                }
                z4 = z6;
                z6 = z5;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z4 = false;
            } else {
                z4 = false;
                z6 = false;
            }
            if (z6) {
                this.f249v.setLayoutParams(marginLayoutParams);
            }
        } else {
            z4 = false;
        }
        View view5 = this.C;
        if (view5 != null) {
            if (!z4) {
                i6 = 8;
            }
            view5.setVisibility(i6);
        }
        return i4;
    }

    @Override // androidx.appcompat.app.q
    public final void a() {
        LayoutInflater from = LayoutInflater.from(this.f238k);
        if (from.getFactory() == null) {
            from.setFactory2(this);
        } else if (!(from.getFactory2() instanceof f0)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
        if (r6.k() != false) goto L19;
     */
    @Override // g.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(g.p r6) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f0.b(g.p):void");
    }

    @Override // androidx.appcompat.app.q
    public final void c() {
        if (this.f242o != null) {
            A();
            this.f242o.getClass();
            B(0);
        }
    }

    @Override // androidx.appcompat.app.q
    public final void e() {
        String str;
        this.O = true;
        m(false, true);
        x();
        Object obj = this.f237j;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    str = com.google.common.collect.c.H0(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e4) {
                    throw new IllegalArgumentException(e4);
                }
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                u0 u0Var = this.f242o;
                if (u0Var == null) {
                    this.f231b0 = true;
                } else {
                    u0Var.d(true);
                }
            }
            synchronized (q.f319h) {
                q.g(this);
                q.f318g.add(new WeakReference(this));
            }
        }
        this.R = new Configuration(this.f238k.getResources().getConfiguration());
        this.P = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // androidx.appcompat.app.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f237j
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L11
            java.lang.Object r0 = androidx.appcompat.app.q.f319h
            monitor-enter(r0)
            androidx.appcompat.app.q.g(r3)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            goto L11
        Le:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r1
        L11:
            boolean r0 = r3.Y
            if (r0 == 0) goto L20
            android.view.Window r0 = r3.f239l
            android.view.View r0 = r0.getDecorView()
            androidx.appcompat.app.r r1 = r3.f230a0
            r0.removeCallbacks(r1)
        L20:
            r0 = 1
            r3.Q = r0
            int r0 = r3.S
            r1 = -100
            if (r0 == r1) goto L4d
            java.lang.Object r0 = r3.f237j
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L4d
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L4d
            l.k r0 = androidx.appcompat.app.f0.f226h0
            java.lang.Object r1 = r3.f237j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.S
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L5c
        L4d:
            l.k r0 = androidx.appcompat.app.f0.f226h0
            java.lang.Object r1 = r3.f237j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L5c:
            androidx.appcompat.app.z r0 = r3.W
            if (r0 == 0) goto L63
            r0.a()
        L63:
            androidx.appcompat.app.z r0 = r3.X
            if (r0 == 0) goto L6a
            r0.a()
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f0.f():void");
    }

    @Override // androidx.appcompat.app.q
    public final boolean h(int i4) {
        if (i4 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i4 = 108;
        } else if (i4 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i4 = 109;
        }
        if (this.J && i4 == 108) {
            return false;
        }
        if (this.F && i4 == 1) {
            this.F = false;
        }
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 5) {
                    if (i4 != 10) {
                        if (i4 != 108) {
                            if (i4 != 109) {
                                return this.f239l.requestFeature(i4);
                            }
                            H();
                            this.G = true;
                            return true;
                        }
                        H();
                        this.F = true;
                        return true;
                    }
                    H();
                    this.H = true;
                    return true;
                }
                H();
                this.E = true;
                return true;
            }
            H();
            this.D = true;
            return true;
        }
        H();
        this.J = true;
        return true;
    }

    @Override // androidx.appcompat.app.q
    public final void i(int i4) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.A.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f238k).inflate(i4, viewGroup);
        this.f240m.a(this.f239l.getCallback());
    }

    @Override // androidx.appcompat.app.q
    public final void j(View view) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.A.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f240m.a(this.f239l.getCallback());
    }

    @Override // androidx.appcompat.app.q
    public final void k(View view, ViewGroup.LayoutParams layoutParams) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.A.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f240m.a(this.f239l.getCallback());
    }

    @Override // androidx.appcompat.app.q
    public final void l(CharSequence charSequence) {
        this.f244q = charSequence;
        k1 k1Var = this.f245r;
        if (k1Var != null) {
            k1Var.setWindowTitle(charSequence);
            return;
        }
        u0 u0Var = this.f242o;
        if (u0Var != null) {
            x3 x3Var = (x3) u0Var.f348e;
            if (!x3Var.f957h) {
                x3Var.f958i = charSequence;
                if ((x3Var.f951b & 8) != 0) {
                    Toolbar toolbar = x3Var.f950a;
                    toolbar.setTitle(charSequence);
                    if (x3Var.f957h) {
                        y0.q(toolbar.getRootView(), charSequence);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        TextView textView = this.B;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0218 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e6 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m(boolean r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 598
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f0.m(boolean, boolean):boolean");
    }

    public final void n(Window window) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback;
        if (this.f239l == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof y)) {
                y yVar = new y(this, callback);
                this.f240m = yVar;
                window.setCallback(yVar);
                q3 e4 = q3.e(this.f238k, null, f227i0);
                Drawable c4 = e4.c(0);
                if (c4 != null) {
                    window.setBackgroundDrawable(c4);
                }
                e4.g();
                this.f239l = window;
                if (Build.VERSION.SDK_INT >= 33 && (onBackInvokedDispatcher = this.f235f0) == null) {
                    if (onBackInvokedDispatcher != null && (onBackInvokedCallback = this.f236g0) != null) {
                        x.c(onBackInvokedDispatcher, onBackInvokedCallback);
                        this.f236g0 = null;
                    }
                    Object obj = this.f237j;
                    if (obj instanceof Activity) {
                        Activity activity = (Activity) obj;
                        if (activity.getWindow() != null) {
                            this.f235f0 = x.a(activity);
                            I();
                            return;
                        }
                    }
                    this.f235f0 = null;
                    I();
                    return;
                }
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x010c, code lost:
        if (r9.equals("ImageButton") == false) goto L24;
     */
    @Override // android.view.LayoutInflater.Factory2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View onCreateView(android.view.View r8, java.lang.String r9, android.content.Context r10, android.util.AttributeSet r11) {
        /*
            Method dump skipped, instructions count: 718
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f0.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    @Override // g.n
    public final boolean p(g.p pVar, MenuItem menuItem) {
        int i4;
        e0 e0Var;
        Window.Callback callback = this.f239l.getCallback();
        if (callback != null && !this.Q) {
            g.p k4 = pVar.k();
            e0[] e0VarArr = this.L;
            if (e0VarArr != null) {
                i4 = e0VarArr.length;
            } else {
                i4 = 0;
            }
            int i5 = 0;
            while (true) {
                if (i5 < i4) {
                    e0Var = e0VarArr[i5];
                    if (e0Var != null && e0Var.f216h == k4) {
                        break;
                    }
                    i5++;
                } else {
                    e0Var = null;
                    break;
                }
            }
            if (e0Var != null) {
                return callback.onMenuItemSelected(e0Var.f209a, menuItem);
            }
        }
        return false;
    }

    public final void q(int i4, e0 e0Var, g.p pVar) {
        if (pVar == null) {
            if (e0Var == null && i4 >= 0) {
                e0[] e0VarArr = this.L;
                if (i4 < e0VarArr.length) {
                    e0Var = e0VarArr[i4];
                }
            }
            if (e0Var != null) {
                pVar = e0Var.f216h;
            }
        }
        if ((e0Var == null || e0Var.f221m) && !this.Q) {
            y yVar = this.f240m;
            Window.Callback callback = this.f239l.getCallback();
            yVar.getClass();
            try {
                yVar.f370d = true;
                callback.onPanelClosed(i4, pVar);
            } finally {
                yVar.f370d = false;
            }
        }
    }

    public final void r(g.p pVar) {
        androidx.appcompat.widget.n nVar;
        if (this.K) {
            return;
        }
        this.K = true;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f245r;
        actionBarOverlayLayout.k();
        ActionMenuView actionMenuView = ((x3) actionBarOverlayLayout.f431e).f950a.f655a;
        if (actionMenuView != null && (nVar = actionMenuView.f458t) != null) {
            nVar.f();
            androidx.appcompat.widget.h hVar = nVar.f849u;
            if (hVar != null && hVar.b()) {
                hVar.f4606j.dismiss();
            }
        }
        Window.Callback callback = this.f239l.getCallback();
        if (callback != null && !this.Q) {
            callback.onPanelClosed(108, pVar);
        }
        this.K = false;
    }

    public final void s(e0 e0Var, boolean z4) {
        c0 c0Var;
        k1 k1Var;
        androidx.appcompat.widget.n nVar;
        if (z4 && e0Var.f209a == 0 && (k1Var = this.f245r) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) k1Var;
            actionBarOverlayLayout.k();
            ActionMenuView actionMenuView = ((x3) actionBarOverlayLayout.f431e).f950a.f655a;
            if (actionMenuView != null && (nVar = actionMenuView.f458t) != null && nVar.k()) {
                r(e0Var.f216h);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.f238k.getSystemService("window");
        if (windowManager != null && e0Var.f221m && (c0Var = e0Var.f213e) != null) {
            windowManager.removeView(c0Var);
            if (z4) {
                q(e0Var.f209a, e0Var, null);
            }
        }
        e0Var.f219k = false;
        e0Var.f220l = false;
        e0Var.f221m = false;
        e0Var.f214f = null;
        e0Var.f222n = true;
        if (this.M == e0Var) {
            this.M = null;
        }
        if (e0Var.f209a == 0) {
            I();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:93:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean u(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f0.u(android.view.KeyEvent):boolean");
    }

    public final void v(int i4) {
        e0 z4 = z(i4);
        if (z4.f216h != null) {
            Bundle bundle = new Bundle();
            z4.f216h.u(bundle);
            if (bundle.size() > 0) {
                z4.f224p = bundle;
            }
            z4.f216h.y();
            z4.f216h.clear();
        }
        z4.f223o = true;
        z4.f222n = true;
        if ((i4 == 108 || i4 == 0) && this.f245r != null) {
            e0 z5 = z(0);
            z5.f219k = false;
            G(z5, null);
        }
    }

    public final void w() {
        int i4;
        ViewGroup viewGroup;
        CharSequence charSequence;
        Context context;
        if (!this.f253z) {
            int[] iArr = c.a.f2553k;
            Context context2 = this.f238k;
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(iArr);
            if (obtainStyledAttributes.hasValue(117)) {
                if (obtainStyledAttributes.getBoolean(126, false)) {
                    h(1);
                } else if (obtainStyledAttributes.getBoolean(117, false)) {
                    h(108);
                }
                if (obtainStyledAttributes.getBoolean(118, false)) {
                    h(109);
                }
                if (obtainStyledAttributes.getBoolean(119, false)) {
                    h(10);
                }
                this.I = obtainStyledAttributes.getBoolean(0, false);
                obtainStyledAttributes.recycle();
                x();
                this.f239l.getDecorView();
                LayoutInflater from = LayoutInflater.from(context2);
                if (!this.J) {
                    if (this.I) {
                        viewGroup = (ViewGroup) from.inflate(R.layout.abc_dialog_title_material, (ViewGroup) null);
                        this.G = false;
                        this.F = false;
                    } else if (this.F) {
                        TypedValue typedValue = new TypedValue();
                        context2.getTheme().resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            context = new f.f(context2, typedValue.resourceId);
                        } else {
                            context = context2;
                        }
                        viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.abc_screen_toolbar, (ViewGroup) null);
                        k1 k1Var = (k1) viewGroup.findViewById(R.id.decor_content_parent);
                        this.f245r = k1Var;
                        k1Var.setWindowCallback(this.f239l.getCallback());
                        if (this.G) {
                            ((ActionBarOverlayLayout) this.f245r).h(109);
                        }
                        if (this.D) {
                            ((ActionBarOverlayLayout) this.f245r).h(2);
                        }
                        if (this.E) {
                            ((ActionBarOverlayLayout) this.f245r).h(5);
                        }
                    } else {
                        viewGroup = null;
                    }
                } else {
                    if (this.H) {
                        i4 = R.layout.abc_screen_simple_overlay_action_mode;
                    } else {
                        i4 = R.layout.abc_screen_simple;
                    }
                    viewGroup = (ViewGroup) from.inflate(i4, (ViewGroup) null);
                }
                if (viewGroup != null) {
                    s sVar = new s(this, 0);
                    WeakHashMap weakHashMap = y0.f4999a;
                    i0.m0.u(viewGroup, sVar);
                    if (this.f245r == null) {
                        this.B = (TextView) viewGroup.findViewById(R.id.title);
                    }
                    Method method = e4.f743a;
                    try {
                        Method method2 = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                        if (!method2.isAccessible()) {
                            method2.setAccessible(true);
                        }
                        method2.invoke(viewGroup, new Object[0]);
                    } catch (IllegalAccessException e4) {
                        e = e4;
                        Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e);
                    } catch (NoSuchMethodException unused) {
                        Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
                    } catch (InvocationTargetException e5) {
                        e = e5;
                        Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e);
                    }
                    ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R.id.action_bar_activity_content);
                    ViewGroup viewGroup2 = (ViewGroup) this.f239l.findViewById(16908290);
                    if (viewGroup2 != null) {
                        while (viewGroup2.getChildCount() > 0) {
                            View childAt = viewGroup2.getChildAt(0);
                            viewGroup2.removeViewAt(0);
                            contentFrameLayout.addView(childAt);
                        }
                        viewGroup2.setId(-1);
                        contentFrameLayout.setId(16908290);
                        if (viewGroup2 instanceof FrameLayout) {
                            ((FrameLayout) viewGroup2).setForeground(null);
                        }
                    }
                    this.f239l.setContentView(viewGroup);
                    contentFrameLayout.setAttachListener(new s(this, 2));
                    this.A = viewGroup;
                    Object obj = this.f237j;
                    if (obj instanceof Activity) {
                        charSequence = ((Activity) obj).getTitle();
                    } else {
                        charSequence = this.f244q;
                    }
                    if (!TextUtils.isEmpty(charSequence)) {
                        k1 k1Var2 = this.f245r;
                        if (k1Var2 != null) {
                            k1Var2.setWindowTitle(charSequence);
                        } else {
                            u0 u0Var = this.f242o;
                            if (u0Var != null) {
                                x3 x3Var = (x3) u0Var.f348e;
                                if (!x3Var.f957h) {
                                    x3Var.f958i = charSequence;
                                    if ((x3Var.f951b & 8) != 0) {
                                        Toolbar toolbar = x3Var.f950a;
                                        toolbar.setTitle(charSequence);
                                        if (x3Var.f957h) {
                                            y0.q(toolbar.getRootView(), charSequence);
                                        }
                                    }
                                }
                            } else {
                                TextView textView = this.B;
                                if (textView != null) {
                                    textView.setText(charSequence);
                                }
                            }
                        }
                    }
                    ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.A.findViewById(16908290);
                    View decorView = this.f239l.getDecorView();
                    contentFrameLayout2.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
                    TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(iArr);
                    obtainStyledAttributes2.getValue(124, contentFrameLayout2.getMinWidthMajor());
                    obtainStyledAttributes2.getValue(125, contentFrameLayout2.getMinWidthMinor());
                    if (obtainStyledAttributes2.hasValue(122)) {
                        obtainStyledAttributes2.getValue(122, contentFrameLayout2.getFixedWidthMajor());
                    }
                    if (obtainStyledAttributes2.hasValue(123)) {
                        obtainStyledAttributes2.getValue(123, contentFrameLayout2.getFixedWidthMinor());
                    }
                    if (obtainStyledAttributes2.hasValue(120)) {
                        obtainStyledAttributes2.getValue(120, contentFrameLayout2.getFixedHeightMajor());
                    }
                    if (obtainStyledAttributes2.hasValue(121)) {
                        obtainStyledAttributes2.getValue(121, contentFrameLayout2.getFixedHeightMinor());
                    }
                    obtainStyledAttributes2.recycle();
                    contentFrameLayout2.requestLayout();
                    this.f253z = true;
                    e0 z4 = z(0);
                    if (!this.Q && z4.f216h == null) {
                        B(108);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.F + ", windowActionBarOverlay: " + this.G + ", android:windowIsFloating: " + this.I + ", windowActionModeOverlay: " + this.H + ", windowNoTitle: " + this.J + " }");
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
    }

    public final void x() {
        if (this.f239l == null) {
            Object obj = this.f237j;
            if (obj instanceof Activity) {
                n(((Activity) obj).getWindow());
            }
        }
        if (this.f239l == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.appcompat.app.c, java.lang.Object] */
    public final b0 y(Context context) {
        if (this.W == null) {
            if (c.f191d == null) {
                Context applicationContext = context.getApplicationContext();
                ?? obj = new Object();
                obj.f194c = new Object();
                obj.f192a = applicationContext;
                obj.f193b = (LocationManager) applicationContext.getSystemService("location");
                c.f191d = obj;
            }
            this.W = new z(this, c.f191d);
        }
        return this.W;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, androidx.appcompat.app.e0] */
    public final e0 z(int i4) {
        Object[] objArr = this.L;
        if (objArr == null || objArr.length <= i4) {
            e0[] e0VarArr = new e0[i4 + 1];
            if (objArr != null) {
                System.arraycopy(objArr, 0, e0VarArr, 0, objArr.length);
            }
            this.L = e0VarArr;
            objArr = e0VarArr;
        }
        e0 e0Var = objArr[i4];
        if (e0Var == 0) {
            ?? obj = new Object();
            obj.f209a = i4;
            obj.f222n = false;
            objArr[i4] = obj;
            return obj;
        }
        return e0Var;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
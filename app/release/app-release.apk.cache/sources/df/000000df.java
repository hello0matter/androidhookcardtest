package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.l1;
import androidx.appcompat.widget.x3;
import com.example.msphone.R;
import i0.f1;
import i0.g1;
import i0.y0;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class u0 extends a implements androidx.appcompat.widget.g {

    /* renamed from: y  reason: collision with root package name */
    public static final AccelerateInterpolator f342y = new AccelerateInterpolator();

    /* renamed from: z  reason: collision with root package name */
    public static final DecelerateInterpolator f343z = new DecelerateInterpolator();

    /* renamed from: a  reason: collision with root package name */
    public Context f344a;

    /* renamed from: b  reason: collision with root package name */
    public Context f345b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarOverlayLayout f346c;

    /* renamed from: d  reason: collision with root package name */
    public ActionBarContainer f347d;

    /* renamed from: e  reason: collision with root package name */
    public l1 f348e;

    /* renamed from: f  reason: collision with root package name */
    public ActionBarContextView f349f;

    /* renamed from: g  reason: collision with root package name */
    public final View f350g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f351h;

    /* renamed from: i  reason: collision with root package name */
    public t0 f352i;

    /* renamed from: j  reason: collision with root package name */
    public t0 f353j;

    /* renamed from: k  reason: collision with root package name */
    public f.b f354k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f355l;

    /* renamed from: m  reason: collision with root package name */
    public final ArrayList f356m;

    /* renamed from: n  reason: collision with root package name */
    public int f357n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f358o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f359p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f360q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f361r;

    /* renamed from: s  reason: collision with root package name */
    public f.n f362s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f363t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f364u;

    /* renamed from: v  reason: collision with root package name */
    public final s0 f365v;

    /* renamed from: w  reason: collision with root package name */
    public final s0 f366w;

    /* renamed from: x  reason: collision with root package name */
    public final o0 f367x;

    public u0(Activity activity, boolean z4) {
        new ArrayList();
        this.f356m = new ArrayList();
        this.f357n = 0;
        this.f358o = true;
        this.f361r = true;
        this.f365v = new s0(this, 0);
        this.f366w = new s0(this, 1);
        this.f367x = new o0(1, this);
        View decorView = activity.getWindow().getDecorView();
        c(decorView);
        if (z4) {
            return;
        }
        this.f350g = decorView.findViewById(16908290);
    }

    public final void a(boolean z4) {
        g1 e4;
        g1 g1Var;
        long j4;
        if (z4) {
            if (!this.f360q) {
                this.f360q = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f346c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                f(false);
            }
        } else if (this.f360q) {
            this.f360q = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f346c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            f(false);
        }
        ActionBarContainer actionBarContainer = this.f347d;
        WeakHashMap weakHashMap = y0.f4999a;
        if (i0.j0.c(actionBarContainer)) {
            if (z4) {
                x3 x3Var = (x3) this.f348e;
                e4 = y0.a(x3Var.f950a);
                e4.a(0.0f);
                e4.c(100L);
                e4.d(new f.m(x3Var, 4));
                g1Var = this.f349f.e(0, 200L);
            } else {
                x3 x3Var2 = (x3) this.f348e;
                g1 a5 = y0.a(x3Var2.f950a);
                a5.a(1.0f);
                a5.c(200L);
                a5.d(new f.m(x3Var2, 0));
                e4 = this.f349f.e(8, 100L);
                g1Var = a5;
            }
            f.n nVar = new f.n();
            ArrayList arrayList = nVar.f4503a;
            arrayList.add(e4);
            View view = (View) e4.f4929a.get();
            if (view != null) {
                j4 = view.animate().getDuration();
            } else {
                j4 = 0;
            }
            View view2 = (View) g1Var.f4929a.get();
            if (view2 != null) {
                view2.animate().setStartDelay(j4);
            }
            arrayList.add(g1Var);
            nVar.b();
        } else if (z4) {
            ((x3) this.f348e).f950a.setVisibility(4);
            this.f349f.setVisibility(0);
        } else {
            ((x3) this.f348e).f950a.setVisibility(0);
            this.f349f.setVisibility(8);
        }
    }

    public final Context b() {
        if (this.f345b == null) {
            TypedValue typedValue = new TypedValue();
            this.f344a.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i4 = typedValue.resourceId;
            if (i4 != 0) {
                this.f345b = new ContextThemeWrapper(this.f344a, i4);
            } else {
                this.f345b = this.f344a;
            }
        }
        return this.f345b;
    }

    public final void c(View view) {
        String str;
        l1 wrapper;
        boolean z4;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R.id.decor_content_parent);
        this.f346c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        View findViewById = view.findViewById(R.id.action_bar);
        if (findViewById instanceof l1) {
            wrapper = (l1) findViewById;
        } else if (findViewById instanceof Toolbar) {
            wrapper = ((Toolbar) findViewById).getWrapper();
        } else {
            if (findViewById != null) {
                str = findViewById.getClass().getSimpleName();
            } else {
                str = "null";
            }
            throw new IllegalStateException("Can't make a decor toolbar out of ".concat(str));
        }
        this.f348e = wrapper;
        this.f349f = (ActionBarContextView) view.findViewById(R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R.id.action_bar_container);
        this.f347d = actionBarContainer;
        l1 l1Var = this.f348e;
        if (l1Var != null && this.f349f != null && actionBarContainer != null) {
            Context context = ((x3) l1Var).f950a.getContext();
            this.f344a = context;
            if ((((x3) this.f348e).f951b & 4) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                this.f351h = true;
            }
            f.a a5 = f.a.a(context);
            int i4 = a5.f4443a.getApplicationInfo().targetSdkVersion;
            this.f348e.getClass();
            e(a5.f4443a.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs));
            TypedArray obtainStyledAttributes = this.f344a.obtainStyledAttributes(null, c.a.f2543a, R.attr.actionBarStyle, 0);
            if (obtainStyledAttributes.getBoolean(14, false)) {
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.f346c;
                if (actionBarOverlayLayout2.f434h) {
                    this.f364u = true;
                    actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
                } else {
                    throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
                }
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(12, 0);
            if (dimensionPixelSize != 0) {
                ActionBarContainer actionBarContainer2 = this.f347d;
                WeakHashMap weakHashMap = y0.f4999a;
                i0.m0.s(actionBarContainer2, dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalStateException(u0.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
    }

    public final void d(boolean z4) {
        int i4;
        if (!this.f351h) {
            if (z4) {
                i4 = 4;
            } else {
                i4 = 0;
            }
            x3 x3Var = (x3) this.f348e;
            int i5 = x3Var.f951b;
            this.f351h = true;
            x3Var.a((i4 & 4) | (i5 & (-5)));
        }
    }

    public final void e(boolean z4) {
        if (!z4) {
            x3 x3Var = (x3) this.f348e;
            ScrollingTabContainerView scrollingTabContainerView = x3Var.f952c;
            if (scrollingTabContainerView != null) {
                ViewParent parent = scrollingTabContainerView.getParent();
                Toolbar toolbar = x3Var.f950a;
                if (parent == toolbar) {
                    toolbar.removeView(x3Var.f952c);
                }
            }
            x3Var.f952c = null;
            this.f347d.setTabContainer(null);
        } else {
            this.f347d.setTabContainer(null);
            x3 x3Var2 = (x3) this.f348e;
            ScrollingTabContainerView scrollingTabContainerView2 = x3Var2.f952c;
            if (scrollingTabContainerView2 != null) {
                ViewParent parent2 = scrollingTabContainerView2.getParent();
                Toolbar toolbar2 = x3Var2.f950a;
                if (parent2 == toolbar2) {
                    toolbar2.removeView(x3Var2.f952c);
                }
            }
            x3Var2.f952c = null;
        }
        this.f348e.getClass();
        ((x3) this.f348e).f950a.setCollapsible(false);
        this.f346c.setHasNonEmbeddedTabs(false);
    }

    public final void f(boolean z4) {
        boolean z5;
        int[] iArr;
        int[] iArr2;
        boolean z6 = this.f359p;
        if (this.f360q || !z6) {
            z5 = true;
        } else {
            z5 = false;
        }
        o0 o0Var = this.f367x;
        View view = this.f350g;
        com.google.android.material.appbar.a aVar = null;
        if (z5) {
            if (!this.f361r) {
                this.f361r = true;
                f.n nVar = this.f362s;
                if (nVar != null) {
                    nVar.a();
                }
                this.f347d.setVisibility(0);
                int i4 = this.f357n;
                s0 s0Var = this.f366w;
                if (i4 == 0 && (this.f363t || z4)) {
                    this.f347d.setTranslationY(0.0f);
                    float f4 = -this.f347d.getHeight();
                    if (z4) {
                        this.f347d.getLocationInWindow(new int[]{0, 0});
                        f4 -= iArr2[1];
                    }
                    this.f347d.setTranslationY(f4);
                    f.n nVar2 = new f.n();
                    g1 a5 = y0.a(this.f347d);
                    a5.e(0.0f);
                    View view2 = (View) a5.f4929a.get();
                    if (view2 != null) {
                        if (o0Var != null) {
                            aVar = new com.google.android.material.appbar.a(2, o0Var, view2);
                        }
                        f1.a(view2.animate(), aVar);
                    }
                    boolean z7 = nVar2.f4507e;
                    ArrayList arrayList = nVar2.f4503a;
                    if (!z7) {
                        arrayList.add(a5);
                    }
                    if (this.f358o && view != null) {
                        view.setTranslationY(f4);
                        g1 a6 = y0.a(view);
                        a6.e(0.0f);
                        if (!nVar2.f4507e) {
                            arrayList.add(a6);
                        }
                    }
                    DecelerateInterpolator decelerateInterpolator = f343z;
                    boolean z8 = nVar2.f4507e;
                    if (!z8) {
                        nVar2.f4505c = decelerateInterpolator;
                    }
                    if (!z8) {
                        nVar2.f4504b = 250L;
                    }
                    if (!z8) {
                        nVar2.f4506d = s0Var;
                    }
                    this.f362s = nVar2;
                    nVar2.b();
                } else {
                    this.f347d.setAlpha(1.0f);
                    this.f347d.setTranslationY(0.0f);
                    if (this.f358o && view != null) {
                        view.setTranslationY(0.0f);
                    }
                    s0Var.a();
                }
                ActionBarOverlayLayout actionBarOverlayLayout = this.f346c;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = y0.f4999a;
                    i0.k0.c(actionBarOverlayLayout);
                }
            }
        } else if (this.f361r) {
            this.f361r = false;
            f.n nVar3 = this.f362s;
            if (nVar3 != null) {
                nVar3.a();
            }
            int i5 = this.f357n;
            s0 s0Var2 = this.f365v;
            if (i5 == 0 && (this.f363t || z4)) {
                this.f347d.setAlpha(1.0f);
                this.f347d.setTransitioning(true);
                f.n nVar4 = new f.n();
                float f5 = -this.f347d.getHeight();
                if (z4) {
                    this.f347d.getLocationInWindow(new int[]{0, 0});
                    f5 -= iArr[1];
                }
                g1 a7 = y0.a(this.f347d);
                a7.e(f5);
                View view3 = (View) a7.f4929a.get();
                if (view3 != null) {
                    if (o0Var != null) {
                        aVar = new com.google.android.material.appbar.a(2, o0Var, view3);
                    }
                    f1.a(view3.animate(), aVar);
                }
                boolean z9 = nVar4.f4507e;
                ArrayList arrayList2 = nVar4.f4503a;
                if (!z9) {
                    arrayList2.add(a7);
                }
                if (this.f358o && view != null) {
                    g1 a8 = y0.a(view);
                    a8.e(f5);
                    if (!nVar4.f4507e) {
                        arrayList2.add(a8);
                    }
                }
                AccelerateInterpolator accelerateInterpolator = f342y;
                boolean z10 = nVar4.f4507e;
                if (!z10) {
                    nVar4.f4505c = accelerateInterpolator;
                }
                if (!z10) {
                    nVar4.f4504b = 250L;
                }
                if (!z10) {
                    nVar4.f4506d = s0Var2;
                }
                this.f362s = nVar4;
                nVar4.b();
                return;
            }
            s0Var2.a();
        }
    }

    public u0(Dialog dialog) {
        new ArrayList();
        this.f356m = new ArrayList();
        this.f357n = 0;
        this.f358o = true;
        this.f361r = true;
        this.f365v = new s0(this, 0);
        this.f366w = new s0(this, 1);
        this.f367x = new o0(1, this);
        c(dialog.getWindow().getDecorView());
    }
}
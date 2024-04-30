package f;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import g.x;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class k {
    public CharSequence A;
    public CharSequence B;
    public final /* synthetic */ l E;

    /* renamed from: a  reason: collision with root package name */
    public final Menu f4467a;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4474h;

    /* renamed from: i  reason: collision with root package name */
    public int f4475i;

    /* renamed from: j  reason: collision with root package name */
    public int f4476j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f4477k;

    /* renamed from: l  reason: collision with root package name */
    public CharSequence f4478l;

    /* renamed from: m  reason: collision with root package name */
    public int f4479m;

    /* renamed from: n  reason: collision with root package name */
    public char f4480n;

    /* renamed from: o  reason: collision with root package name */
    public int f4481o;

    /* renamed from: p  reason: collision with root package name */
    public char f4482p;

    /* renamed from: q  reason: collision with root package name */
    public int f4483q;

    /* renamed from: r  reason: collision with root package name */
    public int f4484r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f4485s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f4486t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f4487u;

    /* renamed from: v  reason: collision with root package name */
    public int f4488v;

    /* renamed from: w  reason: collision with root package name */
    public int f4489w;

    /* renamed from: x  reason: collision with root package name */
    public String f4490x;

    /* renamed from: y  reason: collision with root package name */
    public String f4491y;

    /* renamed from: z  reason: collision with root package name */
    public i0.e f4492z;
    public ColorStateList C = null;
    public PorterDuff.Mode D = null;

    /* renamed from: b  reason: collision with root package name */
    public int f4468b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f4469c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f4470d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f4471e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4472f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4473g = true;

    public k(l lVar, Menu menu) {
        this.E = lVar;
        this.f4467a = menu;
    }

    public final Object a(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.E.f4497c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e4) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e4);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v33, types: [android.view.MenuItem$OnMenuItemClickListener, f.j, java.lang.Object] */
    public final void b(MenuItem menuItem) {
        boolean z4;
        Class<?> cls;
        MenuItem enabled = menuItem.setChecked(this.f4485s).setVisible(this.f4486t).setEnabled(this.f4487u);
        boolean z5 = false;
        if (this.f4484r >= 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        enabled.setCheckable(z4).setTitleCondensed(this.f4478l).setIcon(this.f4479m);
        int i4 = this.f4488v;
        if (i4 >= 0) {
            menuItem.setShowAsAction(i4);
        }
        String str = this.f4491y;
        l lVar = this.E;
        if (str != null) {
            if (!lVar.f4497c.isRestricted()) {
                if (lVar.f4498d == null) {
                    lVar.f4498d = l.a(lVar.f4497c);
                }
                Object obj = lVar.f4498d;
                String str2 = this.f4491y;
                ?? obj2 = new Object();
                obj2.f4465a = obj;
                try {
                    obj2.f4466b = obj.getClass().getMethod(str2, j.f4464c);
                    menuItem.setOnMenuItemClickListener(obj2);
                } catch (Exception e4) {
                    InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str2 + " in class " + cls.getName());
                    inflateException.initCause(e4);
                    throw inflateException;
                }
            } else {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
        }
        if (this.f4484r >= 2) {
            if (menuItem instanceof g.r) {
                ((g.r) menuItem).g(true);
            } else if (menuItem instanceof x) {
                x xVar = (x) menuItem;
                try {
                    Method method = xVar.f4757e;
                    d0.b bVar = xVar.f4756d;
                    if (method == null) {
                        xVar.f4757e = bVar.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                    }
                    xVar.f4757e.invoke(bVar, Boolean.TRUE);
                } catch (Exception e5) {
                    Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e5);
                }
            }
        }
        String str3 = this.f4490x;
        if (str3 != null) {
            menuItem.setActionView((View) a(str3, l.f4493e, lVar.f4495a));
            z5 = true;
        }
        int i5 = this.f4489w;
        if (i5 > 0) {
            if (!z5) {
                menuItem.setActionView(i5);
            } else {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            }
        }
        i0.e eVar = this.f4492z;
        if (eVar != null) {
            if (menuItem instanceof d0.b) {
                ((d0.b) menuItem).a(eVar);
            } else {
                Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            }
        }
        CharSequence charSequence = this.A;
        boolean z6 = menuItem instanceof d0.b;
        if (z6) {
            ((d0.b) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            i0.q.h(menuItem, charSequence);
        }
        CharSequence charSequence2 = this.B;
        if (z6) {
            ((d0.b) menuItem).setTooltipText(charSequence2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            i0.q.m(menuItem, charSequence2);
        }
        char c4 = this.f4480n;
        int i6 = this.f4481o;
        if (z6) {
            ((d0.b) menuItem).setAlphabeticShortcut(c4, i6);
        } else if (Build.VERSION.SDK_INT >= 26) {
            i0.q.g(menuItem, c4, i6);
        }
        char c5 = this.f4482p;
        int i7 = this.f4483q;
        if (z6) {
            ((d0.b) menuItem).setNumericShortcut(c5, i7);
        } else if (Build.VERSION.SDK_INT >= 26) {
            i0.q.k(menuItem, c5, i7);
        }
        PorterDuff.Mode mode = this.D;
        if (mode != null) {
            if (z6) {
                ((d0.b) menuItem).setIconTintMode(mode);
            } else if (Build.VERSION.SDK_INT >= 26) {
                i0.q.j(menuItem, mode);
            }
        }
        ColorStateList colorStateList = this.C;
        if (colorStateList != null) {
            if (z6) {
                ((d0.b) menuItem).setIconTintList(colorStateList);
            } else if (Build.VERSION.SDK_INT >= 26) {
                i0.q.i(menuItem, colorStateList);
            }
        }
    }
}
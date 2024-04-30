package i0;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class y1 extends d2 {

    /* renamed from: h  reason: collision with root package name */
    public static boolean f5005h = false;

    /* renamed from: i  reason: collision with root package name */
    public static Method f5006i;

    /* renamed from: j  reason: collision with root package name */
    public static Class f5007j;

    /* renamed from: k  reason: collision with root package name */
    public static Field f5008k;

    /* renamed from: l  reason: collision with root package name */
    public static Field f5009l;

    /* renamed from: c  reason: collision with root package name */
    public final WindowInsets f5010c;

    /* renamed from: d  reason: collision with root package name */
    public b0.c[] f5011d;

    /* renamed from: e  reason: collision with root package name */
    public b0.c f5012e;

    /* renamed from: f  reason: collision with root package name */
    public g2 f5013f;

    /* renamed from: g  reason: collision with root package name */
    public b0.c f5014g;

    public y1(@NonNull g2 g2Var, @NonNull WindowInsets windowInsets) {
        super(g2Var);
        this.f5012e = null;
        this.f5010c = windowInsets;
    }

    @NonNull
    @SuppressLint({"WrongConstant"})
    private b0.c r(int i4, boolean z4) {
        b0.c cVar = b0.c.f2489e;
        for (int i5 = 1; i5 <= 256; i5 <<= 1) {
            if ((i4 & i5) != 0) {
                cVar = b0.c.a(cVar, s(i5, z4));
            }
        }
        return cVar;
    }

    private b0.c t() {
        g2 g2Var = this.f5013f;
        if (g2Var != null) {
            return g2Var.f4931a.h();
        }
        return b0.c.f2489e;
    }

    @Nullable
    private b0.c u(@NonNull View view) {
        if (Build.VERSION.SDK_INT < 30) {
            if (!f5005h) {
                v();
            }
            Method method = f5006i;
            if (method != null && f5007j != null && f5008k != null) {
                try {
                    Object invoke = method.invoke(view, new Object[0]);
                    if (invoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f5008k.get(f5009l.get(invoke));
                    if (rect == null) {
                        return null;
                    }
                    return b0.c.b(rect.left, rect.top, rect.right, rect.bottom);
                } catch (ReflectiveOperationException e4) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e4.getMessage(), e4);
                }
            }
            return null;
        }
        throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
    }

    @SuppressLint({"PrivateApi"})
    private static void v() {
        try {
            f5006i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            f5007j = cls;
            f5008k = cls.getDeclaredField("mVisibleInsets");
            f5009l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            f5008k.setAccessible(true);
            f5009l.setAccessible(true);
        } catch (ReflectiveOperationException e4) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e4.getMessage(), e4);
        }
        f5005h = true;
    }

    @Override // i0.d2
    public void d(@NonNull View view) {
        b0.c u4 = u(view);
        if (u4 == null) {
            u4 = b0.c.f2489e;
        }
        w(u4);
    }

    @Override // i0.d2
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        return Objects.equals(this.f5014g, ((y1) obj).f5014g);
    }

    @Override // i0.d2
    @NonNull
    public b0.c f(int i4) {
        return r(i4, false);
    }

    @Override // i0.d2
    @NonNull
    public final b0.c j() {
        if (this.f5012e == null) {
            WindowInsets windowInsets = this.f5010c;
            this.f5012e = b0.c.b(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.f5012e;
    }

    @Override // i0.d2
    @NonNull
    public g2 l(int i4, int i5, int i6, int i7) {
        x1 t1Var;
        g2 h4 = g2.h(null, this.f5010c);
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 30) {
            t1Var = new w1(h4);
        } else if (i8 >= 29) {
            t1Var = new v1(h4);
        } else {
            t1Var = new t1(h4);
        }
        t1Var.g(g2.e(j(), i4, i5, i6, i7));
        t1Var.e(g2.e(h(), i4, i5, i6, i7));
        return t1Var.b();
    }

    @Override // i0.d2
    public boolean n() {
        return this.f5010c.isRound();
    }

    @Override // i0.d2
    public void o(b0.c[] cVarArr) {
        this.f5011d = cVarArr;
    }

    @Override // i0.d2
    public void p(@Nullable g2 g2Var) {
        this.f5013f = g2Var;
    }

    @NonNull
    public b0.c s(int i4, boolean z4) {
        int i5;
        l e4;
        int i6;
        int i7;
        int i8;
        int i9 = 0;
        if (i4 != 1) {
            b0.c cVar = null;
            if (i4 != 2) {
                b0.c cVar2 = b0.c.f2489e;
                if (i4 != 8) {
                    if (i4 != 16) {
                        if (i4 != 32) {
                            if (i4 != 64) {
                                if (i4 != 128) {
                                    return cVar2;
                                }
                                g2 g2Var = this.f5013f;
                                if (g2Var != null) {
                                    e4 = g2Var.f4931a.e();
                                } else {
                                    e4 = e();
                                }
                                if (e4 != null) {
                                    int i10 = Build.VERSION.SDK_INT;
                                    DisplayCutout displayCutout = e4.f4948a;
                                    if (i10 >= 28) {
                                        i6 = k.d(displayCutout);
                                    } else {
                                        i6 = 0;
                                    }
                                    if (i10 >= 28) {
                                        i7 = k.f(displayCutout);
                                    } else {
                                        i7 = 0;
                                    }
                                    if (i10 >= 28) {
                                        i8 = k.e(displayCutout);
                                    } else {
                                        i8 = 0;
                                    }
                                    if (i10 >= 28) {
                                        i9 = k.c(displayCutout);
                                    }
                                    return b0.c.b(i6, i7, i8, i9);
                                }
                                return cVar2;
                            }
                            return k();
                        }
                        return g();
                    }
                    return i();
                }
                b0.c[] cVarArr = this.f5011d;
                if (cVarArr != null) {
                    cVar = cVarArr[e2.a(8)];
                }
                if (cVar != null) {
                    return cVar;
                }
                b0.c j4 = j();
                b0.c t4 = t();
                int i11 = j4.f2493d;
                if (i11 > t4.f2493d) {
                    return b0.c.b(0, 0, 0, i11);
                }
                b0.c cVar3 = this.f5014g;
                if (cVar3 != null && !cVar3.equals(cVar2) && (i5 = this.f5014g.f2493d) > t4.f2493d) {
                    return b0.c.b(0, 0, 0, i5);
                }
                return cVar2;
            } else if (z4) {
                b0.c t5 = t();
                b0.c h4 = h();
                return b0.c.b(Math.max(t5.f2490a, h4.f2490a), 0, Math.max(t5.f2492c, h4.f2492c), Math.max(t5.f2493d, h4.f2493d));
            } else {
                b0.c j5 = j();
                g2 g2Var2 = this.f5013f;
                if (g2Var2 != null) {
                    cVar = g2Var2.f4931a.h();
                }
                int i12 = j5.f2493d;
                if (cVar != null) {
                    i12 = Math.min(i12, cVar.f2493d);
                }
                return b0.c.b(j5.f2490a, 0, j5.f2492c, i12);
            }
        } else if (z4) {
            return b0.c.b(0, Math.max(t().f2491b, j().f2491b), 0, 0);
        } else {
            return b0.c.b(0, j().f2491b, 0, 0);
        }
    }

    public void w(@NonNull b0.c cVar) {
        this.f5014g = cVar;
    }
}
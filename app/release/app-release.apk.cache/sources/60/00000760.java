package i0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.msphone.R;

/* loaded from: classes.dex */
public abstract class m0 {
    @DoNotInline
    public static void a(@NonNull WindowInsets windowInsets, @NonNull View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    @DoNotInline
    public static g2 b(@NonNull View view, @NonNull g2 g2Var, @NonNull Rect rect) {
        WindowInsets g4 = g2Var.g();
        if (g4 != null) {
            return g2.h(view, view.computeSystemWindowInsets(g4, rect));
        }
        rect.setEmpty();
        return g2Var;
    }

    @DoNotInline
    public static boolean c(@NonNull View view, float f4, float f5, boolean z4) {
        return view.dispatchNestedFling(f4, f5, z4);
    }

    @DoNotInline
    public static boolean d(@NonNull View view, float f4, float f5) {
        return view.dispatchNestedPreFling(f4, f5);
    }

    @DoNotInline
    public static boolean e(View view, int i4, int i5, int[] iArr, int[] iArr2) {
        return view.dispatchNestedPreScroll(i4, i5, iArr, iArr2);
    }

    @DoNotInline
    public static boolean f(View view, int i4, int i5, int i6, int i7, int[] iArr) {
        return view.dispatchNestedScroll(i4, i5, i6, i7, iArr);
    }

    @DoNotInline
    public static ColorStateList g(View view) {
        return view.getBackgroundTintList();
    }

    @DoNotInline
    public static PorterDuff.Mode h(View view) {
        return view.getBackgroundTintMode();
    }

    @DoNotInline
    public static float i(View view) {
        return view.getElevation();
    }

    @Nullable
    @DoNotInline
    public static g2 j(@NonNull View view) {
        x1 t1Var;
        if (!s1.f4982d || !view.isAttachedToWindow()) {
            return null;
        }
        try {
            Object obj = s1.f4979a.get(view.getRootView());
            if (obj == null) {
                return null;
            }
            Rect rect = (Rect) s1.f4980b.get(obj);
            Rect rect2 = (Rect) s1.f4981c.get(obj);
            if (rect == null || rect2 == null) {
                return null;
            }
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 30) {
                t1Var = new w1();
            } else if (i4 >= 29) {
                t1Var = new v1();
            } else {
                t1Var = new t1();
            }
            t1Var.e(b0.c.b(rect.left, rect.top, rect.right, rect.bottom));
            t1Var.g(b0.c.b(rect2.left, rect2.top, rect2.right, rect2.bottom));
            g2 b5 = t1Var.b();
            b5.f4931a.p(b5);
            b5.f4931a.d(view.getRootView());
            return b5;
        } catch (IllegalAccessException e4) {
            Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e4.getMessage(), e4);
            return null;
        }
    }

    @DoNotInline
    public static String k(View view) {
        return view.getTransitionName();
    }

    @DoNotInline
    public static float l(View view) {
        return view.getTranslationZ();
    }

    @DoNotInline
    public static float m(@NonNull View view) {
        return view.getZ();
    }

    @DoNotInline
    public static boolean n(View view) {
        return view.hasNestedScrollingParent();
    }

    @DoNotInline
    public static boolean o(View view) {
        return view.isImportantForAccessibility();
    }

    @DoNotInline
    public static boolean p(View view) {
        return view.isNestedScrollingEnabled();
    }

    @DoNotInline
    public static void q(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    @DoNotInline
    public static void r(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    @DoNotInline
    public static void s(View view, float f4) {
        view.setElevation(f4);
    }

    @DoNotInline
    public static void t(View view, boolean z4) {
        view.setNestedScrollingEnabled(z4);
    }

    @DoNotInline
    public static void u(@NonNull View view, @Nullable w wVar) {
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(R.id.tag_on_apply_window_listener, wVar);
        }
        if (wVar == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
        } else {
            view.setOnApplyWindowInsetsListener(new l0(view, wVar));
        }
    }

    @DoNotInline
    public static void v(View view, String str) {
        view.setTransitionName(str);
    }

    @DoNotInline
    public static void w(View view, float f4) {
        view.setTranslationZ(f4);
    }

    @DoNotInline
    public static void x(@NonNull View view, float f4) {
        view.setZ(f4);
    }

    @DoNotInline
    public static boolean y(View view, int i4) {
        return view.startNestedScroll(i4);
    }

    @DoNotInline
    public static void z(View view) {
        view.stopNestedScroll();
    }
}
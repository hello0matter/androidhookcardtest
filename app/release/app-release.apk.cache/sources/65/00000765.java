package i0;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import com.example.msphone.R;
import java.util.List;

/* loaded from: classes.dex */
public final class n1 extends q1 {
    public static void e(View view) {
        t.n j4 = j(view);
        if (j4 != null) {
            ((View) j4.f6681e).setTranslationY(0.0f);
            if (j4.f6677a == 0) {
                return;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                e(viewGroup.getChildAt(i4));
            }
        }
    }

    public static void f(View view, WindowInsets windowInsets, boolean z4) {
        t.n j4 = j(view);
        if (j4 != null) {
            j4.f6680d = windowInsets;
            if (!z4) {
                int[] iArr = j4.f6682f;
                ((View) j4.f6681e).getLocationOnScreen(iArr);
                z4 = true;
                j4.f6678b = iArr[1];
                if (j4.f6677a != 0) {
                    z4 = false;
                }
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                f(viewGroup.getChildAt(i4), windowInsets, z4);
            }
        }
    }

    public static void g(View view, g2 g2Var, List list) {
        t.n j4 = j(view);
        if (j4 != null) {
            j4.a(g2Var, list);
            if (j4.f6677a == 0) {
                return;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                g(viewGroup.getChildAt(i4), g2Var, list);
            }
        }
    }

    public static void h(View view, androidx.appcompat.widget.c0 c0Var) {
        t.n j4 = j(view);
        if (j4 != null) {
            j4.b(c0Var);
            if (j4.f6677a == 0) {
                return;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                h(viewGroup.getChildAt(i4), c0Var);
            }
        }
    }

    public static WindowInsets i(View view, WindowInsets windowInsets) {
        if (view.getTag(R.id.tag_on_apply_window_listener) != null) {
            return windowInsets;
        }
        return view.onApplyWindowInsets(windowInsets);
    }

    public static t.n j(View view) {
        Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
        if (tag instanceof m1) {
            return ((m1) tag).f4955a;
        }
        return null;
    }
}
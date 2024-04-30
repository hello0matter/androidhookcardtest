package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public abstract class o1 {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f857a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f858b = new int[0];

    /* renamed from: c  reason: collision with root package name */
    public static final Rect f859c = new Rect();

    public static void a(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 29 && i4 < 31 && "android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            int[] state = drawable.getState();
            if (state != null && state.length != 0) {
                drawable.setState(f858b);
            } else {
                drawable.setState(f857a);
            }
            drawable.setState(state);
        }
    }

    public static Rect b(Drawable drawable) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 29) {
            Insets a5 = n1.a(drawable);
            i4 = a5.left;
            i5 = a5.top;
            i6 = a5.right;
            i7 = a5.bottom;
            return new Rect(i4, i5, i6, i7);
        }
        Drawable e22 = com.google.common.collect.c.e2(drawable);
        if (i8 < 29) {
            if (m1.f817a) {
                try {
                    Object invoke = m1.f818b.invoke(e22, new Object[0]);
                    if (invoke != null) {
                        return new Rect(m1.f819c.getInt(invoke), m1.f820d.getInt(invoke), m1.f821e.getInt(invoke), m1.f822f.getInt(invoke));
                    }
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
        } else {
            boolean z4 = m1.f817a;
        }
        return f859c;
    }

    public static PorterDuff.Mode c(int i4, PorterDuff.Mode mode) {
        if (i4 != 3) {
            if (i4 != 5) {
                if (i4 != 9) {
                    switch (i4) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }
}
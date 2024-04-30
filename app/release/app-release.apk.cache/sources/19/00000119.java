package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;

/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: b  reason: collision with root package name */
    public static final PorterDuff.Mode f691b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    public static a0 f692c;

    /* renamed from: a  reason: collision with root package name */
    public m2 f693a;

    public static synchronized a0 a() {
        a0 a0Var;
        synchronized (a0.class) {
            try {
                if (f692c == null) {
                    d();
                }
                a0Var = f692c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return a0Var;
    }

    public static synchronized PorterDuffColorFilter c(int i4, PorterDuff.Mode mode) {
        PorterDuffColorFilter g4;
        synchronized (a0.class) {
            g4 = m2.g(i4, mode);
        }
        return g4;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.appcompat.widget.a0, java.lang.Object] */
    public static synchronized void d() {
        synchronized (a0.class) {
            if (f692c == null) {
                ?? obj = new Object();
                f692c = obj;
                obj.f693a = m2.c();
                m2 m2Var = f692c.f693a;
                z zVar = new z();
                synchronized (m2Var) {
                    m2Var.f830e = zVar;
                }
            }
        }
    }

    public static void e(Drawable drawable, o3 o3Var, int[] iArr) {
        ColorStateList colorStateList;
        PorterDuff.Mode mode;
        PorterDuff.Mode mode2 = m2.f823f;
        int[] state = drawable.getState();
        int[] iArr2 = o1.f857a;
        if (drawable.mutate() == drawable) {
            if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
                drawable.setState(new int[0]);
                drawable.setState(state);
            }
            boolean z4 = o3Var.f871d;
            if (!z4 && !o3Var.f870c) {
                drawable.clearColorFilter();
                return;
            }
            PorterDuffColorFilter porterDuffColorFilter = null;
            if (z4) {
                colorStateList = o3Var.f868a;
            } else {
                colorStateList = null;
            }
            if (o3Var.f870c) {
                mode = o3Var.f869b;
            } else {
                mode = m2.f823f;
            }
            if (colorStateList != null && mode != null) {
                porterDuffColorFilter = m2.g(colorStateList.getColorForState(iArr, 0), mode);
            }
            drawable.setColorFilter(porterDuffColorFilter);
            return;
        }
        Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
    }

    public final synchronized Drawable b(Context context, int i4) {
        return this.f693a.e(context, i4);
    }
}
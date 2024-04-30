package i0;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class t1 extends x1 {

    /* renamed from: e  reason: collision with root package name */
    public static Field f4983e = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f4984f = false;

    /* renamed from: g  reason: collision with root package name */
    public static Constructor f4985g = null;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f4986h = false;

    /* renamed from: c  reason: collision with root package name */
    public WindowInsets f4987c;

    /* renamed from: d  reason: collision with root package name */
    public b0.c f4988d;

    public t1() {
        this.f4987c = i();
    }

    @Nullable
    private static WindowInsets i() {
        if (!f4984f) {
            try {
                f4983e = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException e4) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e4);
            }
            f4984f = true;
        }
        Field field = f4983e;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException e5) {
                Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e5);
            }
        }
        if (!f4986h) {
            try {
                f4985g = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException e6) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e6);
            }
            f4986h = true;
        }
        Constructor constructor = f4985g;
        if (constructor != null) {
            try {
                return (WindowInsets) constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException e7) {
                Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e7);
            }
        }
        return null;
    }

    @Override // i0.x1
    @NonNull
    public g2 b() {
        a();
        g2 h4 = g2.h(null, this.f4987c);
        b0.c[] cVarArr = this.f4998b;
        d2 d2Var = h4.f4931a;
        d2Var.o(cVarArr);
        d2Var.q(this.f4988d);
        return h4;
    }

    @Override // i0.x1
    public void e(@Nullable b0.c cVar) {
        this.f4988d = cVar;
    }

    @Override // i0.x1
    public void g(@NonNull b0.c cVar) {
        WindowInsets windowInsets = this.f4987c;
        if (windowInsets != null) {
            this.f4987c = windowInsets.replaceSystemWindowInsets(cVar.f2490a, cVar.f2491b, cVar.f2492c, cVar.f2493d);
        }
    }

    public t1(@NonNull g2 g2Var) {
        super(g2Var);
        this.f4987c = g2Var.g();
    }
}
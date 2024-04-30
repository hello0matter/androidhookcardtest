package c1;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import androidx.appcompat.widget.j3;

/* loaded from: classes.dex */
public abstract class p0 {

    /* renamed from: a  reason: collision with root package name */
    public static final t0 f2666a;

    /* renamed from: b  reason: collision with root package name */
    public static final j3 f2667b;

    /* renamed from: c  reason: collision with root package name */
    public static final j3 f2668c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [c1.t0] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    static {
        ?? r02;
        if (Build.VERSION.SDK_INT >= 29) {
            r02 = new q0();
        } else {
            r02 = new q0();
        }
        f2666a = r02;
        f2667b = new j3(Float.class, "translationAlpha", 9);
        f2668c = new j3(Rect.class, "clipBounds", 10);
    }

    public static void a(View view, int i4, int i5, int i6, int i7) {
        f2666a.D(view, i4, i5, i6, i7);
    }

    public static void b(View view, float f4) {
        f2666a.z(view, f4);
    }

    public static void c(int i4, View view) {
        f2666a.w(i4, view);
    }
}
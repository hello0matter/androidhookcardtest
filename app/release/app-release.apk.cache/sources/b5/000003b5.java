package c1;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class u implements s {

    /* renamed from: b  reason: collision with root package name */
    public static Class f2685b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f2686c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f2687d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f2688e;

    /* renamed from: f  reason: collision with root package name */
    public static Method f2689f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f2690g;

    /* renamed from: a  reason: collision with root package name */
    public final View f2691a;

    public u(View view) {
        this.f2691a = view;
    }

    public static void b() {
        if (!f2686c) {
            try {
                f2685b = Class.forName("android.view.GhostView");
            } catch (ClassNotFoundException e4) {
                Log.i("GhostViewApi21", "Failed to retrieve GhostView class", e4);
            }
            f2686c = true;
        }
    }

    @Override // c1.s
    public final void setVisibility(int i4) {
        this.f2691a.setVisibility(i4);
    }

    @Override // c1.s
    public final void a(ViewGroup viewGroup, View view) {
    }
}
package c1;

import android.os.Build;
import android.view.ViewGroup;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class c0 {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f2579a = {16843073, 16843160, 16843746, 16843855};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f2580b = {16843983};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f2581c = {16843900};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f2582d = {16843745};

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f2583e = {16843964, 16843965};

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f2584f = {16843824};

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f2585g = {16843744};

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f2586h = {16843901, 16843902, 16843903};

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f2587i = {16843978};

    /* renamed from: j  reason: collision with root package name */
    public static boolean f2588j = true;

    /* renamed from: k  reason: collision with root package name */
    public static boolean f2589k = true;

    /* renamed from: l  reason: collision with root package name */
    public static Method f2590l;

    /* renamed from: m  reason: collision with root package name */
    public static boolean f2591m;

    public static void a(ViewGroup viewGroup, boolean z4) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z4);
        } else if (f2589k) {
            try {
                viewGroup.suppressLayout(z4);
            } catch (NoSuchMethodError unused) {
                f2589k = false;
            }
        }
    }
}
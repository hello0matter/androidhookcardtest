package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/* loaded from: classes.dex */
public abstract class m3 {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal f831a = new ThreadLocal();

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f832b = {-16842910};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f833c = {16842908};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f834d = {16842919};

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f835e = {16842912};

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f836f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f837g = new int[1];

    public static void a(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(c.a.f2553k);
        try {
            if (!obtainStyledAttributes.hasValue(117)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i4) {
        ColorStateList d4 = d(context, i4);
        if (d4 != null && d4.isStateful()) {
            return d4.getColorForState(f832b, d4.getDefaultColor());
        }
        ThreadLocal threadLocal = f831a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        float f4 = typedValue.getFloat();
        int c4 = c(context, i4);
        return b0.a.e(c4, Math.round(Color.alpha(c4) * f4));
    }

    public static int c(Context context, int i4) {
        int[] iArr = f837g;
        iArr[0] = i4;
        q3 e4 = q3.e(context, null, iArr);
        try {
            return e4.f879b.getColor(0, 0);
        } finally {
            e4.g();
        }
    }

    public static ColorStateList d(Context context, int i4) {
        int[] iArr = f837g;
        iArr[0] = i4;
        q3 e4 = q3.e(context, null, iArr);
        try {
            return e4.a(0);
        } finally {
            e4.g();
        }
    }
}
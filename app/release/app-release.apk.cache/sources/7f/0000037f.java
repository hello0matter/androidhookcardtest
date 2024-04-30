package b2;

import android.content.Context;
import android.graphics.Color;
import com.example.msphone.R;
import i2.c;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: f  reason: collision with root package name */
    public static final int f2516f = (int) Math.round(5.1000000000000005d);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f2517a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2518b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2519c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2520d;

    /* renamed from: e  reason: collision with root package name */
    public final float f2521e;

    public a(Context context) {
        boolean b5 = c.b(context, R.attr.elevationOverlayEnabled, false);
        int c4 = y1.a.c(context, R.attr.elevationOverlayColor, 0);
        int c5 = y1.a.c(context, R.attr.elevationOverlayAccentColor, 0);
        int c6 = y1.a.c(context, R.attr.colorSurface, 0);
        float f4 = context.getResources().getDisplayMetrics().density;
        this.f2517a = b5;
        this.f2518b = c4;
        this.f2519c = c5;
        this.f2520d = c6;
        this.f2521e = f4;
    }

    public final int a(int i4, float f4) {
        float f5;
        float f6;
        int i5;
        if (this.f2517a && b0.a.e(i4, 255) == this.f2520d) {
            if (this.f2521e > 0.0f && f4 > 0.0f) {
                f6 = Math.min(((((float) Math.log1p(f4 / f5)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
            } else {
                f6 = 0.0f;
            }
            int alpha = Color.alpha(i4);
            int e4 = y1.a.e(b0.a.e(i4, 255), f6, this.f2518b);
            if (f6 > 0.0f && (i5 = this.f2519c) != 0) {
                e4 = b0.a.c(b0.a.e(i5, f2516f), e4);
            }
            return b0.a.e(e4, alpha);
        }
        return i4;
    }
}
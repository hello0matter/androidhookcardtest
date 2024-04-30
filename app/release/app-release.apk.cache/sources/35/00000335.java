package androidx.transition;

import a0.t;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.activity.j;
import c1.c0;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class ArcMotion extends PathMotion {

    /* renamed from: d  reason: collision with root package name */
    public static final float f2334d = (float) Math.tan(Math.toRadians(35.0d));

    /* renamed from: a  reason: collision with root package name */
    public final float f2335a;

    /* renamed from: b  reason: collision with root package name */
    public final float f2336b;

    /* renamed from: c  reason: collision with root package name */
    public final float f2337c;

    @SuppressLint({"RestrictedApi"})
    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f4;
        this.f2335a = 0.0f;
        this.f2336b = 0.0f;
        this.f2337c = f2334d;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c0.f2586h);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        if (!t.d(xmlPullParser, "minimumVerticalAngle")) {
            f4 = 0.0f;
        } else {
            f4 = obtainStyledAttributes.getFloat(1, 0.0f);
        }
        this.f2336b = b(f4);
        this.f2335a = b(t.d(xmlPullParser, "minimumHorizontalAngle") ? obtainStyledAttributes.getFloat(0, 0.0f) : 0.0f);
        this.f2337c = b(t.d(xmlPullParser, "maximumAngle") ? obtainStyledAttributes.getFloat(2, 70.0f) : 70.0f);
        obtainStyledAttributes.recycle();
    }

    public static float b(float f4) {
        if (f4 < 0.0f || f4 > 90.0f) {
            throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
        }
        return (float) Math.tan(Math.toRadians(f4 / 2.0f));
    }

    @Override // androidx.transition.PathMotion
    public final Path a(float f4, float f5, float f6, float f7) {
        float f8;
        float f9;
        float f10;
        Path path = new Path();
        path.moveTo(f4, f5);
        float f11 = f6 - f4;
        float f12 = f7 - f5;
        float f13 = (f12 * f12) + (f11 * f11);
        float f14 = (f4 + f6) / 2.0f;
        float f15 = (f5 + f7) / 2.0f;
        float f16 = 0.25f * f13;
        boolean z4 = f5 > f7;
        if (Math.abs(f11) < Math.abs(f12)) {
            float abs = Math.abs(f13 / (f12 * 2.0f));
            if (z4) {
                f9 = abs + f7;
                f8 = f6;
            } else {
                f9 = abs + f5;
                f8 = f4;
            }
            f10 = this.f2336b;
        } else {
            float f17 = f13 / (f11 * 2.0f);
            if (z4) {
                f9 = f5;
                f8 = f17 + f4;
            } else {
                f8 = f6 - f17;
                f9 = f7;
            }
            f10 = this.f2335a;
        }
        float f18 = f16 * f10 * f10;
        float f19 = f14 - f8;
        float f20 = f15 - f9;
        float f21 = (f20 * f20) + (f19 * f19);
        float f22 = this.f2337c;
        float f23 = f16 * f22 * f22;
        if (f21 >= f18) {
            f18 = f21 > f23 ? f23 : 0.0f;
        }
        if (f18 != 0.0f) {
            float sqrt = (float) Math.sqrt(f18 / f21);
            f8 = j.a(f8, f14, sqrt, f14);
            f9 = j.a(f9, f15, sqrt, f15);
        }
        path.cubicTo((f4 + f8) / 2.0f, (f5 + f9) / 2.0f, (f8 + f6) / 2.0f, (f9 + f7) / 2.0f, f6, f7);
        return path;
    }
}
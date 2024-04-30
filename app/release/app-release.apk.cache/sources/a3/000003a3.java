package c1;

import android.view.View;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final float f2635a;

    /* renamed from: b  reason: collision with root package name */
    public final float f2636b;

    /* renamed from: c  reason: collision with root package name */
    public final float f2637c;

    /* renamed from: d  reason: collision with root package name */
    public final float f2638d;

    /* renamed from: e  reason: collision with root package name */
    public final float f2639e;

    /* renamed from: f  reason: collision with root package name */
    public final float f2640f;

    /* renamed from: g  reason: collision with root package name */
    public final float f2641g;

    /* renamed from: h  reason: collision with root package name */
    public final float f2642h;

    public l(View view) {
        this.f2635a = view.getTranslationX();
        this.f2636b = view.getTranslationY();
        WeakHashMap weakHashMap = i0.y0.f4999a;
        this.f2637c = i0.m0.l(view);
        this.f2638d = view.getScaleX();
        this.f2639e = view.getScaleY();
        this.f2640f = view.getRotationX();
        this.f2641g = view.getRotationY();
        this.f2642h = view.getRotation();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (lVar.f2635a != this.f2635a || lVar.f2636b != this.f2636b || lVar.f2637c != this.f2637c || lVar.f2638d != this.f2638d || lVar.f2639e != this.f2639e || lVar.f2640f != this.f2640f || lVar.f2641g != this.f2641g || lVar.f2642h != this.f2642h) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        float f4 = this.f2635a;
        int i11 = 0;
        if (f4 != 0.0f) {
            i4 = Float.floatToIntBits(f4);
        } else {
            i4 = 0;
        }
        int i12 = i4 * 31;
        float f5 = this.f2636b;
        if (f5 != 0.0f) {
            i5 = Float.floatToIntBits(f5);
        } else {
            i5 = 0;
        }
        int i13 = (i12 + i5) * 31;
        float f6 = this.f2637c;
        if (f6 != 0.0f) {
            i6 = Float.floatToIntBits(f6);
        } else {
            i6 = 0;
        }
        int i14 = (i13 + i6) * 31;
        float f7 = this.f2638d;
        if (f7 != 0.0f) {
            i7 = Float.floatToIntBits(f7);
        } else {
            i7 = 0;
        }
        int i15 = (i14 + i7) * 31;
        float f8 = this.f2639e;
        if (f8 != 0.0f) {
            i8 = Float.floatToIntBits(f8);
        } else {
            i8 = 0;
        }
        int i16 = (i15 + i8) * 31;
        float f9 = this.f2640f;
        if (f9 != 0.0f) {
            i9 = Float.floatToIntBits(f9);
        } else {
            i9 = 0;
        }
        int i17 = (i16 + i9) * 31;
        float f10 = this.f2641g;
        if (f10 != 0.0f) {
            i10 = Float.floatToIntBits(f10);
        } else {
            i10 = 0;
        }
        int i18 = (i17 + i10) * 31;
        float f11 = this.f2642h;
        if (f11 != 0.0f) {
            i11 = Float.floatToIntBits(f11);
        }
        return i18 + i11;
    }
}
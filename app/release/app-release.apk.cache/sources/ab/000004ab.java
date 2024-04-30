package com.google.android.material.bottomappbar;

import androidx.activity.j;
import l2.z;

/* loaded from: classes.dex */
public final class i extends l2.f implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    public float f3060c;

    /* renamed from: d  reason: collision with root package name */
    public float f3061d;

    /* renamed from: e  reason: collision with root package name */
    public float f3062e;

    /* renamed from: f  reason: collision with root package name */
    public float f3063f;

    /* renamed from: g  reason: collision with root package name */
    public float f3064g;

    /* renamed from: h  reason: collision with root package name */
    public float f3065h;

    @Override // l2.f
    public final void f(float f4, float f5, float f6, z zVar) {
        boolean z4;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15 = this.f3062e;
        if (f15 == 0.0f) {
            zVar.d(f4, 0.0f);
            return;
        }
        float f16 = ((this.f3061d * 2.0f) + f15) / 2.0f;
        float f17 = f6 * this.f3060c;
        float f18 = f5 + this.f3064g;
        float a5 = j.a(1.0f, f6, f16, this.f3063f * f6);
        if (a5 / f16 >= 1.0f) {
            zVar.d(f4, 0.0f);
            return;
        }
        float f19 = this.f3065h;
        float f20 = f19 * f6;
        if (f19 != -1.0f && Math.abs((f19 * 2.0f) - f15) >= 0.1f) {
            z4 = false;
        } else {
            z4 = true;
        }
        boolean z5 = z4;
        if (!z5) {
            f8 = 1.75f;
            f7 = 0.0f;
        } else {
            f7 = a5;
            f8 = 0.0f;
        }
        float f21 = f16 + f17;
        float f22 = f7 + f17;
        float sqrt = (float) Math.sqrt((f21 * f21) - (f22 * f22));
        float f23 = f18 - sqrt;
        float f24 = f18 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f22));
        float f25 = (90.0f - degrees) + f8;
        zVar.d(f23, 0.0f);
        float f26 = f17 * 2.0f;
        zVar.a(f23 - f17, 0.0f, f23 + f17, f26, 270.0f, degrees);
        if (z5) {
            f10 = f18 - f16;
            f12 = (-f16) - f7;
            f9 = f18 + f16;
            f11 = f16 - f7;
            f14 = 180.0f - f25;
            f13 = (f25 * 2.0f) - 180.0f;
        } else {
            float f27 = this.f3061d;
            float f28 = f20 * 2.0f;
            float f29 = f18 - f16;
            float f30 = f20 + f27;
            zVar.a(f29, -f30, f29 + f27 + f28, f30, 180.0f - f25, ((f25 * 2.0f) - 180.0f) / 2.0f);
            f9 = f18 + f16;
            float f31 = this.f3061d;
            zVar.d(f9 - ((f31 / 2.0f) + f20), f31 + f20);
            float f32 = this.f3061d;
            f10 = f9 - (f28 + f32);
            f11 = f20 + f32;
            f12 = -f11;
            f13 = f25 - 90.0f;
            f14 = 90.0f;
        }
        zVar.a(f10, f12, f9, f11, f14, f13);
        zVar.a(f24 - f17, 0.0f, f24 + f17, f26, 270.0f - degrees, degrees);
        zVar.d(f4, 0.0f);
    }

    public final void u(float f4) {
        if (f4 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.f3063f = f4;
    }
}
package com.google.android.material.slider;

/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public int f3880a = -1;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseSlider f3881b;

    public c(BaseSlider baseSlider) {
        this.f3881b = baseSlider;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3881b.f3847g.x(this.f3880a, 4);
    }
}
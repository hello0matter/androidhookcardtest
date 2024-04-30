package androidx.activity;

import android.window.BackEvent;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final float f91a;

    /* renamed from: b  reason: collision with root package name */
    public final float f92b;

    /* renamed from: c  reason: collision with root package name */
    public final float f93c;

    /* renamed from: d  reason: collision with root package name */
    public final int f94d;

    public b(BackEvent backEvent) {
        com.google.common.collect.c.F(backEvent, "backEvent");
        a aVar = a.f90a;
        float d4 = aVar.d(backEvent);
        float e4 = aVar.e(backEvent);
        float b5 = aVar.b(backEvent);
        int c4 = aVar.c(backEvent);
        this.f91a = d4;
        this.f92b = e4;
        this.f93c = b5;
        this.f94d = c4;
    }

    public final String toString() {
        return "BackEventCompat{touchX=" + this.f91a + ", touchY=" + this.f92b + ", progress=" + this.f93c + ", swipeEdge=" + this.f94d + '}';
    }
}
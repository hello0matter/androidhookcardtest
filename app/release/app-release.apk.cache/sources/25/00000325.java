package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public d0 f2302a;

    /* renamed from: b  reason: collision with root package name */
    public int f2303b;

    /* renamed from: c  reason: collision with root package name */
    public int f2304c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2305d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2306e;

    public w() {
        d();
    }

    public final void a() {
        this.f2304c = this.f2305d ? this.f2302a.g() : this.f2302a.k();
    }

    public final void b(int i4, View view) {
        if (this.f2305d) {
            this.f2304c = this.f2302a.m() + this.f2302a.b(view);
        } else {
            this.f2304c = this.f2302a.e(view);
        }
        this.f2303b = i4;
    }

    public final void c(int i4, View view) {
        int min;
        int m4 = this.f2302a.m();
        if (m4 >= 0) {
            b(i4, view);
            return;
        }
        this.f2303b = i4;
        if (this.f2305d) {
            int g4 = (this.f2302a.g() - m4) - this.f2302a.b(view);
            this.f2304c = this.f2302a.g() - g4;
            if (g4 > 0) {
                int c4 = this.f2304c - this.f2302a.c(view);
                int k4 = this.f2302a.k();
                int min2 = c4 - (Math.min(this.f2302a.e(view) - k4, 0) + k4);
                if (min2 < 0) {
                    min = Math.min(g4, -min2) + this.f2304c;
                } else {
                    return;
                }
            } else {
                return;
            }
        } else {
            int e4 = this.f2302a.e(view);
            int k5 = e4 - this.f2302a.k();
            this.f2304c = e4;
            if (k5 > 0) {
                int g5 = (this.f2302a.g() - Math.min(0, (this.f2302a.g() - m4) - this.f2302a.b(view))) - (this.f2302a.c(view) + e4);
                if (g5 < 0) {
                    min = this.f2304c - Math.min(k5, -g5);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        this.f2304c = min;
    }

    public final void d() {
        this.f2303b = -1;
        this.f2304c = Integer.MIN_VALUE;
        this.f2305d = false;
        this.f2306e = false;
    }

    public final String toString() {
        return "AnchorInfo{mPosition=" + this.f2303b + ", mCoordinate=" + this.f2304c + ", mLayoutFromEnd=" + this.f2305d + ", mValid=" + this.f2306e + '}';
    }
}
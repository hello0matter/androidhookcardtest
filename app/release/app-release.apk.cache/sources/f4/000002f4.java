package androidx.recyclerview.widget;

import android.util.Log;
import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public final class f1 {

    /* renamed from: a  reason: collision with root package name */
    public int f2092a;

    /* renamed from: b  reason: collision with root package name */
    public int f2093b;

    /* renamed from: c  reason: collision with root package name */
    public int f2094c;

    /* renamed from: d  reason: collision with root package name */
    public int f2095d;

    /* renamed from: e  reason: collision with root package name */
    public Interpolator f2096e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2097f;

    /* renamed from: g  reason: collision with root package name */
    public int f2098g;

    public final void a(RecyclerView recyclerView) {
        int i4 = this.f2095d;
        if (i4 >= 0) {
            this.f2095d = -1;
            recyclerView.N(i4);
            this.f2097f = false;
        } else if (this.f2097f) {
            Interpolator interpolator = this.f2096e;
            if (interpolator != null && this.f2094c < 1) {
                throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
            }
            int i5 = this.f2094c;
            if (i5 >= 1) {
                recyclerView.f1967a0.b(this.f2092a, this.f2093b, i5, interpolator);
                int i6 = this.f2098g + 1;
                this.f2098g = i6;
                if (i6 > 10) {
                    Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                }
                this.f2097f = false;
                return;
            }
            throw new IllegalStateException("Scroll duration must be a positive number");
        } else {
            this.f2098g = 0;
        }
    }
}
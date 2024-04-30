package f;

import android.view.View;
import android.view.animation.Interpolator;
import i0.g1;
import i0.h1;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f4505c;

    /* renamed from: d  reason: collision with root package name */
    public h1 f4506d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4507e;

    /* renamed from: b  reason: collision with root package name */
    public long f4504b = -1;

    /* renamed from: f  reason: collision with root package name */
    public final m f4508f = new m(this);

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f4503a = new ArrayList();

    public final void a() {
        if (!this.f4507e) {
            return;
        }
        Iterator it = this.f4503a.iterator();
        while (it.hasNext()) {
            ((g1) it.next()).b();
        }
        this.f4507e = false;
    }

    public final void b() {
        View view;
        if (this.f4507e) {
            return;
        }
        Iterator it = this.f4503a.iterator();
        while (it.hasNext()) {
            g1 g1Var = (g1) it.next();
            long j4 = this.f4504b;
            if (j4 >= 0) {
                g1Var.c(j4);
            }
            Interpolator interpolator = this.f4505c;
            if (interpolator != null && (view = (View) g1Var.f4929a.get()) != null) {
                view.animate().setInterpolator(interpolator);
            }
            if (this.f4506d != null) {
                g1Var.d(this.f4508f);
            }
            View view2 = (View) g1Var.f4929a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.f4507e = true;
    }
}
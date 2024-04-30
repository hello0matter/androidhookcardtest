package v;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c1.v;
import d2.q;
import i0.g0;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6937a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f6938b;

    public /* synthetic */ b(int i4, Object obj) {
        this.f6937a = i4;
        this.f6938b = obj;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        View view;
        int i4 = this.f6937a;
        Object obj = this.f6938b;
        switch (i4) {
            case 0:
                ((CoordinatorLayout) obj).u(0);
                return true;
            case 1:
                v vVar = (v) obj;
                WeakHashMap weakHashMap = y0.f4999a;
                g0.k(vVar);
                ViewGroup viewGroup = vVar.f2693a;
                if (viewGroup != null && (view = vVar.f2694b) != null) {
                    viewGroup.endViewTransition(view);
                    g0.k(vVar.f2693a);
                    vVar.f2693a = null;
                    vVar.f2694b = null;
                }
                return true;
            default:
                q qVar = (q) obj;
                float rotation = qVar.f4415v.getRotation();
                if (qVar.f4408o != rotation) {
                    qVar.f4408o = rotation;
                    qVar.q();
                }
                return true;
        }
    }
}
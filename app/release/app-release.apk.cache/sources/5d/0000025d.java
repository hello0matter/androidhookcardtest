package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class b0 implements View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1660a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p0 f1661b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f1662c;

    public b0(c0 c0Var, p0 p0Var) {
        this.f1662c = c0Var;
        this.f1661b = p0Var;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        int i4 = this.f1660a;
        Object obj = this.f1662c;
        switch (i4) {
            case 0:
                p0 p0Var = this.f1661b;
                t tVar = p0Var.f1771c;
                p0Var.k();
                g1.f((ViewGroup) tVar.E.getParent(), ((c0) obj).f1668a.E()).e();
                return;
            default:
                View view2 = (View) obj;
                view2.removeOnAttachStateChangeListener(this);
                WeakHashMap weakHashMap = i0.y0.f4999a;
                i0.k0.c(view2);
                return;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }

    public b0(p0 p0Var, View view) {
        this.f1661b = p0Var;
        this.f1662c = view;
    }
}
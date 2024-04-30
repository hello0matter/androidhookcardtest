package r1;

import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;
import i0.g0;
import i0.y0;
import java.util.WeakHashMap;
import n0.e;

/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final View f6458a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f6459b;

    public b(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z4) {
        this.f6459b = swipeDismissBehavior;
        this.f6458a = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e eVar = this.f6459b.f3009a;
        if (eVar != null && eVar.g()) {
            WeakHashMap weakHashMap = y0.f4999a;
            g0.m(this.f6458a, this);
        }
    }
}
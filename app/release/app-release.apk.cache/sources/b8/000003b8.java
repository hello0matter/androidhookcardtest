package c1;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.Visibility;
import com.example.msphone.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class v0 extends g0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2699a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f2700b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f2701c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Visibility f2702d;

    public v0(Visibility visibility, ViewGroup viewGroup, View view, View view2) {
        this.f2702d = visibility;
        this.f2699a = viewGroup;
        this.f2700b = view;
        this.f2701c = view2;
    }

    @Override // c1.g0, c1.f0
    public final void c() {
        this.f2699a.getOverlay().remove(this.f2700b);
    }

    @Override // c1.f0
    public final void d(Transition transition) {
        this.f2701c.setTag(R.id.save_overlay_view, null);
        this.f2699a.getOverlay().remove(this.f2700b);
        transition.v(this);
    }

    @Override // c1.g0, c1.f0
    public final void e() {
        View view = this.f2700b;
        if (view.getParent() == null) {
            this.f2699a.getOverlay().add(view);
            return;
        }
        Visibility visibility = this.f2702d;
        ArrayList arrayList = visibility.f2363m;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((Animator) arrayList.get(size)).cancel();
        }
        ArrayList arrayList2 = visibility.f2367q;
        if (arrayList2 != null && arrayList2.size() > 0) {
            ArrayList arrayList3 = (ArrayList) visibility.f2367q.clone();
            int size2 = arrayList3.size();
            for (int i4 = 0; i4 < size2; i4++) {
                ((f0) arrayList3.get(i4)).a();
            }
        }
    }
}
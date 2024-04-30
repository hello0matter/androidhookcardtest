package c1;

import android.view.View;
import androidx.transition.Transition;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class p implements f0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f2664a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f2665b;

    public p(View view, ArrayList arrayList) {
        this.f2664a = view;
        this.f2665b = arrayList;
    }

    @Override // c1.f0
    public final void d(Transition transition) {
        transition.v(this);
        this.f2664a.setVisibility(8);
        ArrayList arrayList = this.f2665b;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((View) arrayList.get(i4)).setVisibility(0);
        }
    }

    @Override // c1.f0
    public final void a() {
    }

    @Override // c1.f0
    public final void b() {
    }

    @Override // c1.f0
    public final void c() {
    }

    @Override // c1.f0
    public final void e() {
    }
}
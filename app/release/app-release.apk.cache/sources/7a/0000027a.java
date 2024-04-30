package androidx.fragment.app;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class n implements e0.b, j0.v {

    /* renamed from: a  reason: collision with root package name */
    public int f1751a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f1752b;

    public /* synthetic */ n(int i4, Object obj) {
        this.f1751a = i4;
        this.f1752b = obj;
    }

    @Override // e0.b
    public void a() {
        View view;
        View view2;
        int i4 = this.f1751a;
        Object obj = this.f1752b;
        switch (i4) {
            case 1:
                t tVar = (t) obj;
                r rVar = tVar.H;
                if (rVar == null) {
                    view = null;
                } else {
                    view = rVar.f1778a;
                }
                if (view != null) {
                    if (rVar == null) {
                        view2 = null;
                    } else {
                        view2 = rVar.f1778a;
                    }
                    tVar.g().f1778a = null;
                    view2.clearAnimation();
                }
                tVar.g().f1779b = null;
                return;
            default:
                ((f1) obj).a();
                return;
        }
    }

    public boolean b() {
        if (this.f1751a < ((List) this.f1752b).size()) {
            return true;
        }
        return false;
    }

    public void c() {
        ((w) this.f1752b).f1840t.L();
    }

    @Override // j0.v
    public boolean e(View view) {
        ((BottomSheetBehavior) this.f1752b).I(this.f1751a);
        return true;
    }

    public n(BottomSheetBehavior bottomSheetBehavior, int i4) {
        this.f1752b = bottomSheetBehavior;
        this.f1751a = i4;
    }

    public n(ArrayList arrayList) {
        this.f1752b = arrayList;
    }
}
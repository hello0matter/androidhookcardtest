package androidx.appcompat.widget;

import android.view.View;

/* loaded from: classes.dex */
public final class k extends x1 {

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f805j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f806k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ View f807l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(View view, View view2, Object obj, int i4) {
        super(view2);
        this.f805j = i4;
        this.f807l = view;
        this.f806k = obj;
    }

    @Override // androidx.appcompat.widget.x1
    public final g.h0 b() {
        switch (this.f805j) {
            case 0:
                h hVar = ((l) this.f807l).f808d.f848t;
                if (hVar == null) {
                    return null;
                }
                return hVar.a();
            default:
                return (o0) this.f806k;
        }
    }

    @Override // androidx.appcompat.widget.x1
    public final boolean c() {
        int i4 = this.f805j;
        View view = this.f807l;
        switch (i4) {
            case 0:
                ((l) view).f808d.o();
                return true;
            default:
                AppCompatSpinner appCompatSpinner = (AppCompatSpinner) view;
                if (!appCompatSpinner.getInternalPopup().b()) {
                    appCompatSpinner.f526f.e(j0.b(appCompatSpinner), j0.a(appCompatSpinner));
                }
                return true;
        }
    }

    @Override // androidx.appcompat.widget.x1
    public final boolean d() {
        switch (this.f805j) {
            case 0:
                n nVar = ((l) this.f807l).f808d;
                if (nVar.f850v != null) {
                    return false;
                }
                nVar.f();
                return true;
            default:
                g.h0 b5 = b();
                if (b5 != null && b5.b()) {
                    b5.dismiss();
                }
                return true;
        }
    }
}
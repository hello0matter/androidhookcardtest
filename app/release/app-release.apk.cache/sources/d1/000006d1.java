package g;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.x1;

/* loaded from: classes.dex */
public final class b extends x1 {

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f4595j = 0;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ View f4596k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ActionMenuItemView actionMenuItemView) {
        super(actionMenuItemView);
        this.f4596k = actionMenuItemView;
    }

    @Override // androidx.appcompat.widget.x1
    public final h0 b() {
        androidx.appcompat.widget.h hVar;
        int i4 = this.f4595j;
        View view = this.f4596k;
        switch (i4) {
            case 0:
                c cVar = ((ActionMenuItemView) view).f380m;
                if (cVar == null || (hVar = ((androidx.appcompat.widget.i) cVar).f770a.f849u) == null) {
                    return null;
                }
                return hVar.a();
            default:
                return ((ActivityChooserView) view).getListPopupWindow();
        }
    }

    @Override // androidx.appcompat.widget.x1
    public final boolean c() {
        int i4 = this.f4595j;
        boolean z4 = true;
        View view = this.f4596k;
        switch (i4) {
            case 0:
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) view;
                o oVar = actionMenuItemView.f378k;
                if (oVar == null || !oVar.a(actionMenuItemView.f375h)) {
                    return false;
                }
                h0 b5 = b();
                if (b5 == null || !b5.b()) {
                    z4 = false;
                }
                return z4;
            default:
                ActivityChooserView activityChooserView = (ActivityChooserView) view;
                if (activityChooserView.b() || !activityChooserView.f481k) {
                    return true;
                }
                activityChooserView.f471a.getClass();
                throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
    }

    @Override // androidx.appcompat.widget.x1
    public final boolean d() {
        switch (this.f4595j) {
            case 1:
                ((ActivityChooserView) this.f4596k).a();
                return true;
            default:
                h0 b5 = b();
                if (b5 != null && b5.b()) {
                    b5.dismiss();
                }
                return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ActivityChooserView activityChooserView, FrameLayout frameLayout) {
        super(frameLayout);
        this.f4596k = activityChooserView;
    }
}
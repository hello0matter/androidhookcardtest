package androidx.appcompat.app;

import android.view.View;
import android.widget.Button;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.u3;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.internal.NavigationMenuItemView;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f187a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f188b;

    public /* synthetic */ b(int i4, Object obj) {
        this.f187a = i4;
        this.f188b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        g.r rVar;
        int i4 = this.f187a;
        boolean z4 = true;
        Object obj = this.f188b;
        switch (i4) {
            case 0:
                h hVar = (h) obj;
                Button button = hVar.f260f;
                hVar.f277w.obtainMessage(1, hVar.f256b).sendToTarget();
                return;
            case 1:
            default:
                g.r itemData = ((NavigationBarItemView) view).getItemData();
                NavigationBarMenuView navigationBarMenuView = (NavigationBarMenuView) obj;
                if (!navigationBarMenuView.E.q(itemData, navigationBarMenuView.D, 0)) {
                    itemData.setChecked(true);
                    return;
                }
                return;
            case 2:
                u3 u3Var = ((Toolbar) obj).L;
                if (u3Var == null) {
                    rVar = null;
                } else {
                    rVar = u3Var.f920b;
                }
                if (rVar != null) {
                    rVar.collapseActionView();
                    return;
                }
                return;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                ((MaterialCalendar) obj).K();
                return;
            case VisibleForTesting.PROTECTED /* 4 */:
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
                com.google.android.material.internal.w wVar = (com.google.android.material.internal.w) obj;
                com.google.android.material.internal.o oVar = wVar.f3581e;
                if (oVar != null) {
                    oVar.f3569e = true;
                }
                g.r itemData2 = navigationMenuItemView.getItemData();
                boolean q4 = wVar.f3579c.q(itemData2, wVar, 0);
                if (itemData2 != null && itemData2.isCheckable() && q4) {
                    wVar.f3581e.h(itemData2);
                } else {
                    z4 = false;
                }
                com.google.android.material.internal.o oVar2 = wVar.f3581e;
                if (oVar2 != null) {
                    oVar2.f3569e = false;
                }
                if (z4) {
                    wVar.m(false);
                    return;
                }
                return;
        }
    }
}
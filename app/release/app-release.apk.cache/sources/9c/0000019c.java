package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;

/* loaded from: classes.dex */
public final class z1 implements AdapterView.OnItemSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f995a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f996b;

    public /* synthetic */ z1(int i4, Object obj) {
        this.f995a = i4;
        this.f996b = obj;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i4, long j4) {
        u1 u1Var;
        int i5 = this.f995a;
        Object obj = this.f996b;
        switch (i5) {
            case 0:
                if (i4 != -1 && (u1Var = ((ListPopupWindow) obj).f570c) != null) {
                    u1Var.setListSelectionHidden(false);
                    return;
                }
                return;
            default:
                ((SearchView) obj).q(i4);
                return;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }
}
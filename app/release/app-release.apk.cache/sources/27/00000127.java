package androidx.appcompat.widget;

import android.database.DataSetObserver;

/* loaded from: classes.dex */
public final class c2 extends DataSetObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f727a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f728b;

    public /* synthetic */ c2(int i4, Object obj) {
        this.f727a = i4;
        this.f728b = obj;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        int i4 = this.f727a;
        Object obj = this.f728b;
        switch (i4) {
            case 0:
                ListPopupWindow listPopupWindow = (ListPopupWindow) obj;
                if (listPopupWindow.f593z.isShowing()) {
                    listPopupWindow.f();
                    return;
                }
                return;
            default:
                m0.b bVar = (m0.b) obj;
                bVar.f5434a = true;
                bVar.notifyDataSetChanged();
                return;
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        int i4 = this.f727a;
        Object obj = this.f728b;
        switch (i4) {
            case 0:
                ((ListPopupWindow) obj).dismiss();
                return;
            default:
                m0.b bVar = (m0.b) obj;
                bVar.f5434a = false;
                bVar.notifyDataSetInvalidated();
                return;
        }
    }
}
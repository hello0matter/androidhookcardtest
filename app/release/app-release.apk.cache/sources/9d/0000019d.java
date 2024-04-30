package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;

/* loaded from: classes.dex */
public final class z2 implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f997a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f998b;

    public /* synthetic */ z2(int i4, View view) {
        this.f997a = i4;
        this.f998b = view;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
        Object item;
        int selectedItemPosition;
        int i5 = this.f997a;
        View view2 = this.f998b;
        switch (i5) {
            case 0:
                ((SearchView) view2).p(i4);
                return;
            default:
                View view3 = null;
                MaterialAutoCompleteTextView materialAutoCompleteTextView = (MaterialAutoCompleteTextView) view2;
                if (i4 < 0) {
                    ListPopupWindow listPopupWindow = materialAutoCompleteTextView.f3950e;
                    if (!listPopupWindow.f593z.isShowing()) {
                        item = null;
                    } else {
                        item = listPopupWindow.f570c.getSelectedItem();
                    }
                } else {
                    item = materialAutoCompleteTextView.getAdapter().getItem(i4);
                }
                MaterialAutoCompleteTextView materialAutoCompleteTextView2 = (MaterialAutoCompleteTextView) view2;
                MaterialAutoCompleteTextView.a(materialAutoCompleteTextView2, item);
                AdapterView.OnItemClickListener onItemClickListener = materialAutoCompleteTextView2.getOnItemClickListener();
                ListPopupWindow listPopupWindow2 = materialAutoCompleteTextView2.f3950e;
                if (onItemClickListener != null) {
                    if (view == null || i4 < 0) {
                        if (listPopupWindow2.f593z.isShowing()) {
                            view3 = listPopupWindow2.f570c.getSelectedView();
                        }
                        view = view3;
                        if (!listPopupWindow2.f593z.isShowing()) {
                            selectedItemPosition = -1;
                        } else {
                            selectedItemPosition = listPopupWindow2.f570c.getSelectedItemPosition();
                        }
                        i4 = selectedItemPosition;
                        if (!listPopupWindow2.f593z.isShowing()) {
                            j4 = Long.MIN_VALUE;
                        } else {
                            j4 = listPopupWindow2.f570c.getSelectedItemId();
                        }
                    }
                    onItemClickListener.onItemClick(listPopupWindow2.f570c, view, i4, j4);
                }
                listPopupWindow2.dismiss();
                return;
        }
    }
}
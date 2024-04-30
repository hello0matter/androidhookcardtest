package androidx.appcompat.widget;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.widget.SearchView;

/* loaded from: classes.dex */
public final class x2 implements View.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchView f949a;

    public x2(SearchView searchView) {
        this.f949a = searchView;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i4, KeyEvent keyEvent) {
        int length;
        SearchView searchView = this.f949a;
        if (searchView.f608b0 == null) {
            return false;
        }
        SearchView.SearchAutoComplete searchAutoComplete = searchView.f613p;
        if (searchAutoComplete.isPopupShowing() && searchAutoComplete.getListSelection() != -1) {
            if (searchView.f608b0 == null || searchView.O == null || keyEvent.getAction() != 0 || !keyEvent.hasNoModifiers()) {
                return false;
            }
            if (i4 != 66 && i4 != 84 && i4 != 61) {
                if (i4 != 21 && i4 != 22) {
                    if (i4 != 19) {
                        return false;
                    }
                    searchAutoComplete.getListSelection();
                    return false;
                }
                if (i4 == 21) {
                    length = 0;
                } else {
                    length = searchAutoComplete.length();
                }
                searchAutoComplete.setSelection(length);
                searchAutoComplete.setListSelection(0);
                searchAutoComplete.clearListSelection();
                searchAutoComplete.a();
            } else {
                searchView.p(searchAutoComplete.getListSelection());
            }
            return true;
        } else if (TextUtils.getTrimmedLength(searchAutoComplete.getText()) == 0 || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i4 != 66) {
            return false;
        } else {
            view.cancelLongPress();
            searchView.getContext().startActivity(searchView.l("android.intent.action.SEARCH", null, null, searchAutoComplete.getText().toString()));
            return true;
        }
    }
}
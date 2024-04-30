package com.google.android.material.search;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import i0.n2;
import i0.y0;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3781a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchView f3782b;

    public /* synthetic */ f(SearchView searchView, int i4) {
        this.f3781a = i4;
        this.f3782b = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n2 h4;
        n2 h5;
        int i4 = this.f3781a;
        SearchView searchView = this.f3782b;
        switch (i4) {
            case 0:
                searchView.l();
                return;
            case 1:
                EditText editText = searchView.f3751j;
                if (editText.requestFocus()) {
                    editText.sendAccessibilityEvent(8);
                }
                if (searchView.f3767z && (h4 = y0.h(editText)) != null) {
                    h4.f4959a.s();
                    return;
                }
                Context context = editText.getContext();
                Object obj = z.e.f7215a;
                ((InputMethodManager) z.d.b(context, InputMethodManager.class)).showSoftInput(editText, 1);
                return;
            case 2:
                EditText editText2 = searchView.f3751j;
                editText2.clearFocus();
                SearchBar searchBar = searchView.f3761t;
                if (searchBar != null) {
                    searchBar.requestFocus();
                }
                if (searchView.f3767z && (h5 = y0.h(editText2)) != null) {
                    h5.f4959a.j();
                    return;
                }
                Context context2 = editText2.getContext();
                Object obj2 = z.e.f7215a;
                InputMethodManager inputMethodManager = (InputMethodManager) z.d.b(context2, InputMethodManager.class);
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(editText2.getWindowToken(), 0);
                    return;
                }
                return;
            default:
                searchView.j();
                return;
        }
    }
}
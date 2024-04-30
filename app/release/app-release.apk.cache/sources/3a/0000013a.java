package androidx.appcompat.widget;

import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.SearchView;

/* loaded from: classes.dex */
public final class f3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchView.SearchAutoComplete f750a;

    public f3(SearchView.SearchAutoComplete searchAutoComplete) {
        this.f750a = searchAutoComplete;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SearchView.SearchAutoComplete searchAutoComplete = this.f750a;
        if (searchAutoComplete.f627g) {
            ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
            searchAutoComplete.f627g = false;
        }
    }
}
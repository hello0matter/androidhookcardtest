package androidx.appcompat.widget;

import android.widget.AutoCompleteTextView;
import androidx.annotation.DoNotInline;
import androidx.appcompat.widget.SearchView;

/* loaded from: classes.dex */
public abstract class a3 {
    @DoNotInline
    public static void a(AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.refreshAutoCompleteResults();
    }

    @DoNotInline
    public static void b(SearchView.SearchAutoComplete searchAutoComplete, int i4) {
        searchAutoComplete.setInputMethodMode(i4);
    }
}
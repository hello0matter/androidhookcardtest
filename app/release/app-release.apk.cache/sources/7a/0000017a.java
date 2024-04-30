package androidx.appcompat.widget;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public final class s2 implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f894a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f895b;

    public /* synthetic */ s2(ViewGroup viewGroup, int i4) {
        this.f894a = i4;
        this.f895b = viewGroup;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        switch (this.f894a) {
            case 0:
            case 1:
                return;
            default:
                TextInputLayout textInputLayout = (TextInputLayout) this.f895b;
                textInputLayout.u(!textInputLayout.f4011z0, false);
                if (textInputLayout.f3980k) {
                    textInputLayout.n(editable);
                }
                if (textInputLayout.f3996s) {
                    textInputLayout.v(editable);
                    return;
                }
                return;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        int i7 = 8;
        int i8 = this.f894a;
        ViewGroup viewGroup = this.f895b;
        switch (i8) {
            case 0:
                SearchView searchView = (SearchView) viewGroup;
                Editable text = searchView.f613p.getText();
                searchView.V = text;
                boolean isEmpty = TextUtils.isEmpty(text);
                searchView.x(!isEmpty);
                if (searchView.U && !searchView.N && isEmpty) {
                    searchView.f618u.setVisibility(8);
                    i7 = 0;
                }
                searchView.f620w.setVisibility(i7);
                searchView.t();
                searchView.w();
                charSequence.toString();
                searchView.getClass();
                return;
            case 1:
                ImageButton imageButton = ((com.google.android.material.search.SearchView) viewGroup).f3752k;
                if (charSequence.length() > 0) {
                    i7 = 0;
                }
                imageButton.setVisibility(i7);
                return;
            default:
                return;
        }
    }
}
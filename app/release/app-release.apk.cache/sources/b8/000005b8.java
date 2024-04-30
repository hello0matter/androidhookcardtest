package com.google.android.material.textfield;

import android.widget.EditText;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f4047a;

    public k(l lVar) {
        this.f4047a = lVar;
    }

    public final void a(TextInputLayout textInputLayout) {
        l lVar = this.f4047a;
        if (lVar.f4067s == textInputLayout.getEditText()) {
            return;
        }
        EditText editText = lVar.f4067s;
        j jVar = lVar.f4070v;
        if (editText != null) {
            editText.removeTextChangedListener(jVar);
            if (lVar.f4067s.getOnFocusChangeListener() == lVar.b().e()) {
                lVar.f4067s.setOnFocusChangeListener(null);
            }
        }
        EditText editText2 = textInputLayout.getEditText();
        lVar.f4067s = editText2;
        if (editText2 != null) {
            editText2.addTextChangedListener(jVar);
        }
        lVar.b().m(lVar.f4067s);
        lVar.j(lVar.b());
    }
}
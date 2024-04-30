package com.google.android.material.datepicker;

import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;

/* loaded from: classes.dex */
public final /* synthetic */ class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3360a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f3361b;

    public /* synthetic */ s(int i4, Object obj) {
        this.f3360a = i4;
        this.f3361b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        PasswordTransformationMethod passwordTransformationMethod;
        int i4 = this.f3360a;
        Object obj = this.f3361b;
        switch (i4) {
            case 0:
                MaterialDatePicker materialDatePicker = (MaterialDatePicker) obj;
                materialDatePicker.D0.setEnabled(materialDatePicker.J().h());
                materialDatePicker.B0.toggle();
                int i5 = 1;
                if (materialDatePicker.f3284u0 == 1) {
                    i5 = 0;
                }
                materialDatePicker.f3284u0 = i5;
                materialDatePicker.N(materialDatePicker.B0);
                materialDatePicker.M();
                return;
            case 1:
                com.google.android.material.textfield.c cVar = (com.google.android.material.textfield.c) obj;
                EditText editText2 = cVar.f4022i;
                if (editText2 != null) {
                    Editable text = editText2.getText();
                    if (text != null) {
                        text.clear();
                    }
                    cVar.q();
                    return;
                }
                return;
            case 2:
                ((com.google.android.material.textfield.i) obj).u();
                return;
            default:
                com.google.android.material.textfield.q qVar = (com.google.android.material.textfield.q) obj;
                EditText editText3 = qVar.f4110f;
                if (editText3 != null) {
                    int selectionEnd = editText3.getSelectionEnd();
                    EditText editText4 = qVar.f4110f;
                    if (editText4 != null && (editText4.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                        editText = qVar.f4110f;
                        passwordTransformationMethod = null;
                    } else {
                        editText = qVar.f4110f;
                        passwordTransformationMethod = PasswordTransformationMethod.getInstance();
                    }
                    editText.setTransformationMethod(passwordTransformationMethod);
                    if (selectionEnd >= 0) {
                        qVar.f4110f.setSelection(selectionEnd);
                    }
                    qVar.q();
                    return;
                }
                return;
        }
    }
}
package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.example.msphone.R;

/* loaded from: classes.dex */
public final class q extends m {

    /* renamed from: e  reason: collision with root package name */
    public final int f4109e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f4110f;

    /* renamed from: g  reason: collision with root package name */
    public final com.google.android.material.datepicker.s f4111g;

    public q(l lVar, int i4) {
        super(lVar);
        this.f4109e = R.drawable.design_password_eye;
        this.f4111g = new com.google.android.material.datepicker.s(3, this);
        if (i4 != 0) {
            this.f4109e = i4;
        }
    }

    @Override // com.google.android.material.textfield.m
    public final void b() {
        q();
    }

    @Override // com.google.android.material.textfield.m
    public final int c() {
        return R.string.password_toggle_content_description;
    }

    @Override // com.google.android.material.textfield.m
    public final int d() {
        return this.f4109e;
    }

    @Override // com.google.android.material.textfield.m
    public final View.OnClickListener f() {
        return this.f4111g;
    }

    @Override // com.google.android.material.textfield.m
    public final boolean k() {
        return true;
    }

    @Override // com.google.android.material.textfield.m
    public final boolean l() {
        boolean z4;
        EditText editText = this.f4110f;
        if (editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            z4 = true;
        } else {
            z4 = false;
        }
        return !z4;
    }

    @Override // com.google.android.material.textfield.m
    public final void m(EditText editText) {
        this.f4110f = editText;
        q();
    }

    @Override // com.google.android.material.textfield.m
    public final void r() {
        EditText editText = this.f4110f;
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                this.f4110f.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // com.google.android.material.textfield.m
    public final void s() {
        EditText editText = this.f4110f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
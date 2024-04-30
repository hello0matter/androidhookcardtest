package com.google.android.material.textfield;

import android.text.Editable;
import com.google.android.material.internal.g0;

/* loaded from: classes.dex */
public final class j extends g0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f4046a;

    public j(l lVar) {
        this.f4046a = lVar;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f4046a.b().a();
    }

    @Override // com.google.android.material.internal.g0, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        this.f4046a.b().b();
    }
}
package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.g0;

/* loaded from: classes.dex */
public final class a extends g0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChipTextInputComboView f4156a;

    public a(ChipTextInputComboView chipTextInputComboView) {
        this.f4156a = chipTextInputComboView;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        boolean isEmpty = TextUtils.isEmpty(editable);
        ChipTextInputComboView chipTextInputComboView = this.f4156a;
        if (isEmpty) {
            chipTextInputComboView.f4125a.setText(ChipTextInputComboView.a(chipTextInputComboView, "00"));
            return;
        }
        String a5 = ChipTextInputComboView.a(chipTextInputComboView, editable);
        Chip chip = chipTextInputComboView.f4125a;
        if (TextUtils.isEmpty(a5)) {
            a5 = ChipTextInputComboView.a(chipTextInputComboView, "00");
        }
        chip.setText(a5);
    }
}
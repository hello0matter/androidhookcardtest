package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.msphone.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.j0;
import com.google.android.material.textfield.TextInputLayout;
import i0.h0;
import i0.y0;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: a  reason: collision with root package name */
    public final Chip f4125a;

    /* renamed from: b  reason: collision with root package name */
    public final EditText f4126b;

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static String a(ChipTextInputComboView chipTextInputComboView, CharSequence charSequence) {
        try {
            return String.format(chipTextInputComboView.getResources().getConfiguration().locale, "%02d", Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f4125a.isChecked();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f4126b.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
    }

    @Override // android.widget.Checkable
    public final void setChecked(boolean z4) {
        int i4;
        Chip chip = this.f4125a;
        chip.setChecked(z4);
        int i5 = 0;
        if (z4) {
            i4 = 0;
        } else {
            i4 = 4;
        }
        EditText editText = this.f4126b;
        editText.setVisibility(i4);
        if (z4) {
            i5 = 8;
        }
        chip.setVisibility(i5);
        if (chip.isChecked()) {
            editText.requestFocus();
            editText.post(new j0(editText));
        }
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f4125a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public final void setTag(int i4, Object obj) {
        this.f4125a.setTag(i4, obj);
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        this.f4125a.toggle();
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(R.layout.material_time_chip, (ViewGroup) this, false);
        this.f4125a = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(R.layout.material_time_input, (ViewGroup) this, false);
        EditText editText = textInputLayout.getEditText();
        this.f4126b = editText;
        editText.setVisibility(4);
        editText.addTextChangedListener(new a(this));
        editText.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        addView(chip);
        addView(textInputLayout);
        WeakHashMap weakHashMap = y0.f4999a;
        editText.setId(h0.a());
        h0.h((TextView) findViewById(R.id.material_label), editText.getId());
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }
}
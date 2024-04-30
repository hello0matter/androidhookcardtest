package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.RestrictTo;
import i0.h2;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.f170b})
/* loaded from: classes.dex */
public interface DateSelector<S> extends Parcelable {
    static void j(EditText... editTextArr) {
        if (editTextArr.length == 0) {
            return;
        }
        j jVar = new j(0, editTextArr);
        for (EditText editText : editTextArr) {
            editText.setOnFocusChangeListener(jVar);
        }
        EditText editText2 = editTextArr[0];
        editText2.postDelayed(new h2(2, editText2), 100L);
    }

    Object a();

    String b(Context context);

    String c(Context context);

    int d(Context context);

    ArrayList e();

    View g(LayoutInflater layoutInflater, ViewGroup viewGroup, CalendarConstraints calendarConstraints, u uVar);

    boolean h();

    void i(long j4);

    ArrayList k();
}
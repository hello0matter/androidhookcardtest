package com.google.android.material.datepicker;

import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class e implements g {
    @Override // com.google.android.material.datepicker.g
    public final boolean a(List list, long j4) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CalendarConstraints.DateValidator dateValidator = (CalendarConstraints.DateValidator) it.next();
            if (dateValidator != null && !dateValidator.f(j4)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.material.datepicker.g
    public final int getId() {
        return 2;
    }
}
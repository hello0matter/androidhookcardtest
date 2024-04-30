package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.f170b})
/* loaded from: classes.dex */
public final class v<S> extends c0 {
    public int T;
    public DateSelector U;
    public CalendarConstraints V;

    @Override // androidx.fragment.app.t
    public final void r(Bundle bundle) {
        super.r(bundle);
        if (bundle == null) {
            bundle = this.f1806f;
        }
        this.T = bundle.getInt("THEME_RES_ID_KEY");
        this.U = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.V = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.t
    public final View s(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.U.g(layoutInflater.cloneInContext(new ContextThemeWrapper(i(), this.T)), viewGroup, this.V, new u(1, this));
    }

    @Override // androidx.fragment.app.t
    public final void w(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.T);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.U);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.V);
    }
}
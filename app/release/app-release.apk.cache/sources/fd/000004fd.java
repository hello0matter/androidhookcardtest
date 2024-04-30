package com.google.android.material.datepicker;

import android.view.View;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3362a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MaterialDatePicker f3363b;

    public /* synthetic */ t(MaterialDatePicker materialDatePicker, int i4) {
        this.f3362a = i4;
        this.f3363b = materialDatePicker;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i4 = this.f3362a;
        MaterialDatePicker materialDatePicker = this.f3363b;
        switch (i4) {
            case 0:
                Iterator it = materialDatePicker.f3271h0.iterator();
                if (!it.hasNext()) {
                    materialDatePicker.H(false, false);
                    return;
                }
                androidx.activity.j.f(it.next());
                materialDatePicker.J().getClass();
                throw null;
            default:
                Iterator it2 = materialDatePicker.f3272i0.iterator();
                while (it2.hasNext()) {
                    ((View.OnClickListener) it2.next()).onClick(view);
                }
                materialDatePicker.H(false, false);
                return;
        }
    }
}
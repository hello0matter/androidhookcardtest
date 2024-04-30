package com.google.android.material.datepicker;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class u extends b0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3364a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ androidx.fragment.app.t f3365b;

    public u(int i4, androidx.fragment.app.t tVar) {
        this.f3364a = i4;
        this.f3365b = tVar;
    }

    @Override // com.google.android.material.datepicker.b0
    public final void a() {
        int i4 = this.f3364a;
        androidx.fragment.app.t tVar = this.f3365b;
        switch (i4) {
            case 0:
                ((MaterialDatePicker) tVar).D0.setEnabled(false);
                return;
            default:
                Iterator it = ((v) tVar).S.iterator();
                while (it.hasNext()) {
                    ((b0) it.next()).a();
                }
                return;
        }
    }

    @Override // com.google.android.material.datepicker.b0
    public final void b(Object obj) {
        int i4 = this.f3364a;
        androidx.fragment.app.t tVar = this.f3365b;
        switch (i4) {
            case 0:
                MaterialDatePicker materialDatePicker = (MaterialDatePicker) tVar;
                String c4 = materialDatePicker.J().c(materialDatePicker.i());
                materialDatePicker.A0.setContentDescription(materialDatePicker.J().b(materialDatePicker.C()));
                materialDatePicker.A0.setText(c4);
                materialDatePicker.D0.setEnabled(materialDatePicker.J().h());
                return;
            default:
                Iterator it = ((v) tVar).S.iterator();
                while (it.hasNext()) {
                    ((b0) it.next()).b(obj);
                }
                return;
        }
    }
}
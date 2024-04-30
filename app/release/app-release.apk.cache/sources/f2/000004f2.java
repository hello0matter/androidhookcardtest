package com.google.android.material.datepicker;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* loaded from: classes.dex */
public final /* synthetic */ class j implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3341a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f3342b;

    public /* synthetic */ j(int i4, Object obj) {
        this.f3341a = i4;
        this.f3342b = obj;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z4) {
        int i4 = this.f3341a;
        Object obj = this.f3342b;
        switch (i4) {
            case 0:
                for (EditText editText : (EditText[]) obj) {
                    if (editText.hasFocus()) {
                        return;
                    }
                }
                Context context = view.getContext();
                Object obj2 = z.e.f7215a;
                InputMethodManager inputMethodManager = (InputMethodManager) z.d.b(context, InputMethodManager.class);
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    return;
                }
                return;
            case 1:
                com.google.android.material.textfield.c cVar = (com.google.android.material.textfield.c) obj;
                cVar.t(cVar.u());
                return;
            default:
                com.google.android.material.textfield.i iVar = (com.google.android.material.textfield.i) obj;
                iVar.f4039l = z4;
                iVar.q();
                if (!z4) {
                    iVar.t(false);
                    iVar.f4040m = false;
                    return;
                }
                return;
        }
    }
}
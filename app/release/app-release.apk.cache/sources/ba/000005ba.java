package com.google.android.material.textfield;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a  reason: collision with root package name */
    public final TextInputLayout f4071a;

    /* renamed from: b  reason: collision with root package name */
    public final l f4072b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f4073c;

    /* renamed from: d  reason: collision with root package name */
    public final CheckableImageButton f4074d;

    public m(l lVar) {
        this.f4071a = lVar.f4049a;
        this.f4072b = lVar;
        this.f4073c = lVar.getContext();
        this.f4074d = lVar.f4055g;
    }

    public void a() {
    }

    public void b() {
    }

    public int c() {
        return 0;
    }

    public int d() {
        return 0;
    }

    public View.OnFocusChangeListener e() {
        return null;
    }

    public View.OnClickListener f() {
        return null;
    }

    public View.OnFocusChangeListener g() {
        return null;
    }

    public j0.d h() {
        return null;
    }

    public boolean i(int i4) {
        return true;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return this instanceof i;
    }

    public boolean l() {
        return false;
    }

    public void m(EditText editText) {
    }

    public void o(AccessibilityEvent accessibilityEvent) {
    }

    public void p(boolean z4) {
    }

    public final void q() {
        this.f4072b.f(false);
    }

    public abstract void r();

    public void s() {
    }

    public void n(j0.h hVar) {
    }
}
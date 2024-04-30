package com.google.android.material.textfield;

import com.google.android.material.internal.CheckableImageButton;

/* loaded from: classes.dex */
public final class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4122a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f4123b;

    public /* synthetic */ s(TextInputLayout textInputLayout, int i4) {
        this.f4122a = i4;
        this.f4123b = textInputLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f4122a;
        TextInputLayout textInputLayout = this.f4123b;
        switch (i4) {
            case 0:
                CheckableImageButton checkableImageButton = textInputLayout.f3964c.f4055g;
                checkableImageButton.performClick();
                checkableImageButton.jumpDrawablesToCurrentState();
                return;
            default:
                textInputLayout.f3966d.requestLayout();
                return;
        }
    }
}
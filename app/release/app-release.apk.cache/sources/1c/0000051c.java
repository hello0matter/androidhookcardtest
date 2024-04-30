package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.annotation.RestrictTo;

@SuppressLint({"AppCompatCustomView"})
@RestrictTo({RestrictTo.Scope.f170b})
/* loaded from: classes.dex */
public class VisibilityAwareImageButton extends ImageButton {

    /* renamed from: a  reason: collision with root package name */
    public int f3468a;

    public VisibilityAwareImageButton(Context context) {
        this(context, null);
    }

    public final void a(int i4, boolean z4) {
        super.setVisibility(i4);
        if (z4) {
            this.f3468a = i4;
        }
    }

    public final int getUserSetVisibility() {
        return this.f3468a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i4) {
        a(i4, true);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f3468a = getVisibility();
    }
}
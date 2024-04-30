package com.google.android.material.transformation;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.e;

@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* renamed from: b  reason: collision with root package name */
    public AnimatorSet f4165b;

    public ExpandableTransformationBehavior() {
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior
    public void w(View view, View view2, boolean z4, boolean z5) {
        boolean z6;
        AnimatorSet animatorSet = this.f4165b;
        if (animatorSet != null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            animatorSet.cancel();
        }
        AnimatorSet x4 = x(view, view2, z4, z6);
        this.f4165b = x4;
        x4.addListener(new e(11, this));
        this.f4165b.start();
        if (!z5) {
            this.f4165b.end();
        }
    }

    public abstract AnimatorSet x(View view, View view2, boolean z4, boolean z5);

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
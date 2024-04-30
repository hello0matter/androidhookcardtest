package com.google.android.material.tabs;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.q3;

/* loaded from: classes.dex */
public class TabItem extends View {

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f3899a;

    /* renamed from: b  reason: collision with root package name */
    public final Drawable f3900b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3901c;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        q3 e4 = q3.e(context, attributeSet, o1.a.f5939b0);
        TypedArray typedArray = e4.f879b;
        this.f3899a = typedArray.getText(2);
        this.f3900b = e4.b(0);
        this.f3901c = typedArray.getResourceId(1, 0);
        e4.g();
    }
}
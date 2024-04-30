package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.msphone.R;
import com.google.android.material.internal.h0;
import h2.d;
import o1.a;

/* loaded from: classes.dex */
public final class CircularProgressIndicatorSpec extends d {

    /* renamed from: g  reason: collision with root package name */
    public int f3718g;

    /* renamed from: h  reason: collision with root package name */
    public int f3719h;

    /* renamed from: i  reason: collision with root package name */
    public int f3720i;

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.circularProgressIndicatorStyle);
    }

    @Override // h2.d
    public final void a() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i4) {
        super(context, attributeSet, i4, 2131756037);
        int i5 = CircularProgressIndicator.f3717n;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_size_medium);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_inset_medium);
        int[] iArr = a.f5954k;
        h0.a(context, attributeSet, i4, 2131756037);
        h0.b(context, attributeSet, iArr, i4, 2131756037, new int[0]);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i4, 2131756037);
        this.f3718g = Math.max(i2.d.c(context, obtainStyledAttributes, 2, dimensionPixelSize), this.f4819a * 2);
        this.f3719h = i2.d.c(context, obtainStyledAttributes, 1, dimensionPixelSize2);
        this.f3720i = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
    }
}
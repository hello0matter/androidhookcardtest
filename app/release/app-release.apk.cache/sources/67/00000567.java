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
public final class LinearProgressIndicatorSpec extends d {

    /* renamed from: g  reason: collision with root package name */
    public int f3722g;

    /* renamed from: h  reason: collision with root package name */
    public int f3723h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3724i;

    public LinearProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.linearProgressIndicatorStyle);
    }

    @Override // h2.d
    public final void a() {
        if (this.f3722g == 0) {
            if (this.f4820b > 0) {
                throw new IllegalArgumentException("Rounded corners are not supported in contiguous indeterminate animation.");
            }
            if (this.f4821c.length < 3) {
                throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinearProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i4) {
        super(context, attributeSet, i4, 2131756049);
        int i5 = LinearProgressIndicator.f3721n;
        int[] iArr = a.f5966w;
        h0.a(context, attributeSet, R.attr.linearProgressIndicatorStyle, 2131756049);
        h0.b(context, attributeSet, iArr, R.attr.linearProgressIndicatorStyle, 2131756049, new int[0]);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, R.attr.linearProgressIndicatorStyle, 2131756049);
        this.f3722g = obtainStyledAttributes.getInt(0, 1);
        this.f3723h = obtainStyledAttributes.getInt(1, 0);
        obtainStyledAttributes.recycle();
        a();
        this.f3724i = this.f3723h == 1;
    }
}
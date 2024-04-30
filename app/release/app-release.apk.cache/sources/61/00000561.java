package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.example.msphone.R;
import h2.d;
import h2.e;
import h2.g;
import h2.i;
import h2.m;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class CircularProgressIndicator extends BaseProgressIndicator<CircularProgressIndicatorSpec> {

    /* renamed from: n  reason: collision with root package name */
    public static final /* synthetic */ int f3717n = 0;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f170b})
    /* loaded from: classes.dex */
    public @interface IndicatorDirection {
    }

    public CircularProgressIndicator(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public final d a(Context context, AttributeSet attributeSet) {
        return new CircularProgressIndicatorSpec(context, attributeSet);
    }

    public int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec) this.f3705a).f3720i;
    }

    @Px
    public int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec) this.f3705a).f3719h;
    }

    @Px
    public int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec) this.f3705a).f3718g;
    }

    public void setIndicatorDirection(int i4) {
        ((CircularProgressIndicatorSpec) this.f3705a).f3720i = i4;
        invalidate();
    }

    public void setIndicatorInset(@Px int i4) {
        d dVar = this.f3705a;
        if (((CircularProgressIndicatorSpec) dVar).f3719h != i4) {
            ((CircularProgressIndicatorSpec) dVar).f3719h = i4;
            invalidate();
        }
    }

    public void setIndicatorSize(@Px int i4) {
        int max = Math.max(i4, getTrackThickness() * 2);
        d dVar = this.f3705a;
        if (((CircularProgressIndicatorSpec) dVar).f3718g != max) {
            ((CircularProgressIndicatorSpec) dVar).f3718g = max;
            ((CircularProgressIndicatorSpec) dVar).getClass();
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackThickness(int i4) {
        super.setTrackThickness(i4);
        ((CircularProgressIndicatorSpec) this.f3705a).getClass();
    }

    public CircularProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i4) {
        super(context, attributeSet, i4, 2131756037);
        Context context2 = getContext();
        CircularProgressIndicatorSpec circularProgressIndicatorSpec = (CircularProgressIndicatorSpec) this.f3705a;
        setIndeterminateDrawable(new m(context2, circularProgressIndicatorSpec, new e(circularProgressIndicatorSpec), new g(circularProgressIndicatorSpec)));
        setProgressDrawable(new i(getContext(), circularProgressIndicatorSpec, new e(circularProgressIndicatorSpec)));
    }
}
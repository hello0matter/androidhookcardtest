package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.example.msphone.R;
import g.e;
import h2.d;
import h2.i;
import h2.m;
import h2.n;
import h2.o;
import h2.q;
import i0.h0;
import i0.y0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class LinearProgressIndicator extends BaseProgressIndicator<LinearProgressIndicatorSpec> {

    /* renamed from: n  reason: collision with root package name */
    public static final /* synthetic */ int f3721n = 0;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f170b})
    /* loaded from: classes.dex */
    public @interface IndeterminateAnimationType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.f170b})
    /* loaded from: classes.dex */
    public @interface IndicatorDirection {
    }

    public LinearProgressIndicator(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public final d a(Context context, AttributeSet attributeSet) {
        return new LinearProgressIndicatorSpec(context, attributeSet);
    }

    public int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec) this.f3705a).f3722g;
    }

    public int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec) this.f3705a).f3723h;
    }

    @Override // android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        d dVar = this.f3705a;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) dVar;
        boolean z5 = true;
        if (((LinearProgressIndicatorSpec) dVar).f3723h != 1) {
            WeakHashMap weakHashMap = y0.f4999a;
            if ((h0.d(this) != 1 || ((LinearProgressIndicatorSpec) dVar).f3723h != 2) && (h0.d(this) != 0 || ((LinearProgressIndicatorSpec) dVar).f3723h != 3)) {
                z5 = false;
            }
        }
        linearProgressIndicatorSpec.f3724i = z5;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        int paddingRight = i4 - (getPaddingRight() + getPaddingLeft());
        int paddingBottom = i5 - (getPaddingBottom() + getPaddingTop());
        m indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingRight, paddingBottom);
        }
        i progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingRight, paddingBottom);
        }
    }

    public void setIndeterminateAnimationType(int i4) {
        m indeterminateDrawable;
        e qVar;
        d dVar = this.f3705a;
        if (((LinearProgressIndicatorSpec) dVar).f3722g == i4) {
            return;
        }
        if (b() && isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        ((LinearProgressIndicatorSpec) dVar).f3722g = i4;
        ((LinearProgressIndicatorSpec) dVar).a();
        if (i4 == 0) {
            indeterminateDrawable = getIndeterminateDrawable();
            qVar = new o((LinearProgressIndicatorSpec) dVar);
        } else {
            indeterminateDrawable = getIndeterminateDrawable();
            qVar = new q(getContext(), (LinearProgressIndicatorSpec) dVar);
        }
        indeterminateDrawable.f4866m = qVar;
        qVar.f4618a = indeterminateDrawable;
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(@NonNull int... iArr) {
        super.setIndicatorColor(iArr);
        ((LinearProgressIndicatorSpec) this.f3705a).a();
    }

    public void setIndicatorDirection(int i4) {
        d dVar = this.f3705a;
        ((LinearProgressIndicatorSpec) dVar).f3723h = i4;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) dVar;
        boolean z4 = true;
        if (i4 != 1) {
            WeakHashMap weakHashMap = y0.f4999a;
            if ((h0.d(this) != 1 || ((LinearProgressIndicatorSpec) dVar).f3723h != 2) && (h0.d(this) != 0 || i4 != 3)) {
                z4 = false;
            }
        }
        linearProgressIndicatorSpec.f3724i = z4;
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setProgressCompat(int i4, boolean z4) {
        d dVar = this.f3705a;
        if (dVar != null && ((LinearProgressIndicatorSpec) dVar).f3722g == 0 && isIndeterminate()) {
            return;
        }
        super.setProgressCompat(i4, z4);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int i4) {
        super.setTrackCornerRadius(i4);
        ((LinearProgressIndicatorSpec) this.f3705a).a();
        invalidate();
    }

    public LinearProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.linearProgressIndicatorStyle);
    }

    public LinearProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i4) {
        super(context, attributeSet, i4, 2131756049);
        Context context2 = getContext();
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) this.f3705a;
        setIndeterminateDrawable(new m(context2, linearProgressIndicatorSpec, new n(linearProgressIndicatorSpec), linearProgressIndicatorSpec.f3722g == 0 ? new o(linearProgressIndicatorSpec) : new q(context2, linearProgressIndicatorSpec)));
        setProgressDrawable(new i(getContext(), linearProgressIndicatorSpec, new n(linearProgressIndicatorSpec)));
    }
}
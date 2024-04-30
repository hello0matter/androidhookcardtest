package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.widget.SeekBar;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.msphone.R;
import com.google.android.material.internal.h0;
import java.util.ArrayList;
import java.util.List;
import l2.j;

/* loaded from: classes.dex */
public class RangeSlider extends BaseSlider<RangeSlider, Object, Object> {

    /* renamed from: j0  reason: collision with root package name */
    public float f3874j0;

    /* renamed from: k0  reason: collision with root package name */
    public int f3875k0;

    /* loaded from: classes.dex */
    public static class RangeSliderState extends AbsSavedState {
        public static final Parcelable.Creator<RangeSliderState> CREATOR = new Object();

        /* renamed from: a  reason: collision with root package name */
        public float f3876a;

        /* renamed from: b  reason: collision with root package name */
        public int f3877b;

        public RangeSliderState(Parcel parcel) {
            super(parcel.readParcelable(RangeSliderState.class.getClassLoader()));
            this.f3876a = parcel.readFloat();
            this.f3877b = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeFloat(this.f3876a);
            parcel.writeInt(this.f3877b);
        }

        public RangeSliderState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public RangeSlider(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    public int getActiveThumbIndex() {
        return this.L;
    }

    public int getFocusedThumbIndex() {
        return this.M;
    }

    @Dimension
    public int getHaloRadius() {
        return this.D;
    }

    @NonNull
    public ColorStateList getHaloTintList() {
        return this.V;
    }

    public int getLabelBehavior() {
        return this.f3868z;
    }

    @Override // com.google.android.material.slider.BaseSlider
    public float getMinSeparation() {
        return this.f3874j0;
    }

    public float getStepSize() {
        return this.N;
    }

    public float getThumbElevation() {
        return this.f3842d0.f5310a.f5301n;
    }

    @Dimension
    public int getThumbRadius() {
        return this.C;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.f3842d0.f5310a.f5291d;
    }

    public float getThumbStrokeWidth() {
        return this.f3842d0.f5310a.f5298k;
    }

    @NonNull
    public ColorStateList getThumbTintList() {
        return this.f3842d0.f5310a.f5290c;
    }

    @Dimension
    public int getTickActiveRadius() {
        return this.Q;
    }

    @NonNull
    public ColorStateList getTickActiveTintList() {
        return this.W;
    }

    @Dimension
    public int getTickInactiveRadius() {
        return this.R;
    }

    @NonNull
    public ColorStateList getTickInactiveTintList() {
        return this.f3836a0;
    }

    @NonNull
    public ColorStateList getTickTintList() {
        if (this.f3836a0.equals(this.W)) {
            return this.W;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    @NonNull
    public ColorStateList getTrackActiveTintList() {
        return this.f3838b0;
    }

    @Dimension
    public int getTrackHeight() {
        return this.A;
    }

    @NonNull
    public ColorStateList getTrackInactiveTintList() {
        return this.f3840c0;
    }

    @Dimension
    public int getTrackSidePadding() {
        return this.B;
    }

    @NonNull
    public ColorStateList getTrackTintList() {
        if (this.f3840c0.equals(this.f3838b0)) {
            return this.f3838b0;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    @Dimension
    public int getTrackWidth() {
        return this.S;
    }

    @Override // com.google.android.material.slider.BaseSlider
    public float getValueFrom() {
        return this.I;
    }

    @Override // com.google.android.material.slider.BaseSlider
    public float getValueTo() {
        return this.J;
    }

    @Override // com.google.android.material.slider.BaseSlider
    @NonNull
    public List<Float> getValues() {
        return super.getValues();
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        RangeSliderState rangeSliderState = (RangeSliderState) parcelable;
        super.onRestoreInstanceState(rangeSliderState.getSuperState());
        this.f3874j0 = rangeSliderState.f3876a;
        int i4 = rangeSliderState.f3877b;
        this.f3875k0 = i4;
        setSeparationUnit(i4);
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public final Parcelable onSaveInstanceState() {
        RangeSliderState rangeSliderState = new RangeSliderState(super.onSaveInstanceState());
        rangeSliderState.f3876a = this.f3874j0;
        rangeSliderState.f3877b = this.f3875k0;
        return rangeSliderState;
    }

    public void setCustomThumbDrawable(@DrawableRes int i4) {
        setCustomThumbDrawable(getResources().getDrawable(i4));
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setCustomThumbDrawablesForValues(@NonNull @DrawableRes int... iArr) {
        super.setCustomThumbDrawablesForValues(iArr);
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public /* bridge */ /* synthetic */ void setEnabled(boolean z4) {
        super.setEnabled(z4);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setFocusedThumbIndex(int i4) {
        super.setFocusedThumbIndex(i4);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setHaloRadius(@IntRange(from = 0) @Dimension int i4) {
        super.setHaloRadius(i4);
    }

    public void setHaloRadiusResource(@DimenRes int i4) {
        setHaloRadius(getResources().getDimensionPixelSize(i4));
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setHaloTintList(@NonNull ColorStateList colorStateList) {
        super.setHaloTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setLabelBehavior(int i4) {
        super.setLabelBehavior(i4);
    }

    public /* bridge */ /* synthetic */ void setLabelFormatter(@Nullable f fVar) {
    }

    public void setMinSeparation(@Dimension float f4) {
        this.f3874j0 = f4;
        this.f3875k0 = 0;
        setSeparationUnit(0);
    }

    public void setMinSeparationValue(float f4) {
        this.f3874j0 = f4;
        this.f3875k0 = 1;
        setSeparationUnit(1);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setStepSize(float f4) {
        super.setStepSize(f4);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbElevation(float f4) {
        super.setThumbElevation(f4);
    }

    public void setThumbElevationResource(@DimenRes int i4) {
        setThumbElevation(getResources().getDimension(i4));
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbRadius(@IntRange(from = 0) @Dimension int i4) {
        super.setThumbRadius(i4);
    }

    public void setThumbRadiusResource(@DimenRes int i4) {
        setThumbRadius(getResources().getDimensionPixelSize(i4));
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbStrokeColor(@Nullable ColorStateList colorStateList) {
        super.setThumbStrokeColor(colorStateList);
    }

    public void setThumbStrokeColorResource(@ColorRes int i4) {
        if (i4 != 0) {
            setThumbStrokeColor(z.e.b(getContext(), i4));
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbStrokeWidth(float f4) {
        super.setThumbStrokeWidth(f4);
    }

    public void setThumbStrokeWidthResource(@DimenRes int i4) {
        if (i4 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i4));
        }
    }

    public void setThumbTintList(@NonNull ColorStateList colorStateList) {
        j jVar = this.f3842d0;
        if (!colorStateList.equals(jVar.f5310a.f5290c)) {
            jVar.o(colorStateList);
            invalidate();
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickActiveRadius(@IntRange(from = 0) @Dimension int i4) {
        super.setTickActiveRadius(i4);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickActiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTickActiveTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickInactiveRadius(@IntRange(from = 0) @Dimension int i4) {
        super.setTickInactiveRadius(i4);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTickInactiveTintList(colorStateList);
    }

    public void setTickTintList(@NonNull ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z4) {
        if (this.P != z4) {
            this.P = z4;
            postInvalidate();
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackActiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTrackActiveTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackHeight(@IntRange(from = 0) @Dimension int i4) {
        super.setTrackHeight(i4);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTrackInactiveTintList(colorStateList);
    }

    public void setTrackTintList(@NonNull ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f4) {
        this.I = f4;
        this.U = true;
        postInvalidate();
    }

    public void setValueTo(float f4) {
        this.J = f4;
        this.U = true;
        postInvalidate();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setValues(@NonNull List<Float> list) {
        super.setValues(list);
    }

    public RangeSlider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setCustomThumbDrawable(@NonNull Drawable drawable) {
        super.setCustomThumbDrawable(drawable);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setCustomThumbDrawablesForValues(@NonNull Drawable... drawableArr) {
        super.setCustomThumbDrawablesForValues(drawableArr);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setValues(@NonNull Float... fArr) {
        super.setValues(fArr);
    }

    public RangeSlider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        TypedArray d4 = h0.d(context, attributeSet, o1.a.Q, i4, 2131756088, new int[0]);
        if (d4.hasValue(1)) {
            TypedArray obtainTypedArray = d4.getResources().obtainTypedArray(d4.getResourceId(1, 0));
            ArrayList arrayList = new ArrayList();
            for (int i5 = 0; i5 < obtainTypedArray.length(); i5++) {
                arrayList.add(Float.valueOf(obtainTypedArray.getFloat(i5, -1.0f)));
            }
            setValues(arrayList);
        }
        this.f3874j0 = d4.getDimension(0, 0.0f);
        d4.recycle();
    }
}
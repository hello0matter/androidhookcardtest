package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.msphone.R;
import l2.j;

/* loaded from: classes.dex */
public class Slider extends BaseSlider<Slider, Object, Object> {
    public Slider(@NonNull Context context) {
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

    public float getValue() {
        return getValues().get(0).floatValue();
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
    public final boolean p() {
        if (getActiveThumbIndex() != -1) {
            return true;
        }
        setActiveThumbIndex(0);
        return true;
    }

    public void setCustomThumbDrawable(@DrawableRes int i4) {
        setCustomThumbDrawable(getResources().getDrawable(i4));
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

    public void setValue(float f4) {
        setValues(Float.valueOf(f4));
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

    public Slider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setCustomThumbDrawable(@NonNull Drawable drawable) {
        super.setCustomThumbDrawable(drawable);
    }

    public Slider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842788});
        if (obtainStyledAttributes.hasValue(0)) {
            setValue(obtainStyledAttributes.getFloat(0, 0.0f));
        }
        obtainStyledAttributes.recycle();
    }
}
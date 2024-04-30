package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.customview.view.AbsSavedState;
import com.example.msphone.R;
import i0.y0;

@RestrictTo({RestrictTo.Scope.f170b})
/* loaded from: classes.dex */
public class CheckableImageButton extends AppCompatImageButton implements Checkable {

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f3438g = {16842912};

    /* renamed from: d  reason: collision with root package name */
    public boolean f3439d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3440e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3441f;

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: c  reason: collision with root package name */
        public boolean f3442c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3442c = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f3442c ? 1 : 0);
        }
    }

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f3439d;
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int i4) {
        return this.f3439d ? View.mergeDrawableStates(super.onCreateDrawableState(i4 + 1), f3438g) : super.onCreateDrawableState(i4);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f1460a);
        setChecked(savedState.f3442c);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.os.Parcelable, androidx.customview.view.AbsSavedState, com.google.android.material.internal.CheckableImageButton$SavedState] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ?? absSavedState = new AbsSavedState(super.onSaveInstanceState());
        absSavedState.f3442c = this.f3439d;
        return absSavedState;
    }

    public void setCheckable(boolean z4) {
        if (this.f3440e != z4) {
            this.f3440e = z4;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z4) {
        if (!this.f3440e || this.f3439d == z4) {
            return;
        }
        this.f3439d = z4;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z4) {
        this.f3441f = z4;
    }

    @Override // android.view.View
    public void setPressed(boolean z4) {
        if (this.f3441f) {
            super.setPressed(z4);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f3439d);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f3440e = true;
        this.f3441f = true;
        y0.p(this, new f1.f(3, this));
    }
}
package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.f170b})
/* loaded from: classes.dex */
public class TouchObserverFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public View.OnTouchListener f3467a;

    public TouchObserverFrameLayout(@NonNull Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener = this.f3467a;
        if (onTouchListener != null) {
            onTouchListener.onTouch(this, motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setOnTouchListener(@Nullable View.OnTouchListener onTouchListener) {
        this.f3467a = onTouchListener;
    }

    public TouchObserverFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TouchObserverFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }
}
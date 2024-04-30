package com.google.android.material.snackbar;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.example.msphone.R;
import com.google.common.collect.c;
import i0.h0;
import i0.y0;
import java.util.WeakHashMap;
import p1.a;

@RestrictTo({RestrictTo.Scope.f170b})
/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f3894a;

    /* renamed from: b  reason: collision with root package name */
    public Button f3895b;

    /* renamed from: c  reason: collision with root package name */
    public int f3896c;

    public SnackbarContentLayout(@NonNull Context context) {
        this(context, null);
    }

    public final boolean a(int i4, int i5, int i6) {
        boolean z4;
        if (i4 != getOrientation()) {
            setOrientation(i4);
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.f3894a.getPaddingTop() == i5 && this.f3894a.getPaddingBottom() == i6) {
            return z4;
        }
        TextView textView = this.f3894a;
        WeakHashMap weakHashMap = y0.f4999a;
        if (h0.g(textView)) {
            h0.k(textView, h0.f(textView), i5, h0.e(textView), i6);
            return true;
        }
        textView.setPadding(textView.getPaddingLeft(), i5, textView.getPaddingRight(), i6);
        return true;
    }

    public Button getActionView() {
        return this.f3895b;
    }

    public TextView getMessageView() {
        return this.f3894a;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f3894a = (TextView) findViewById(R.id.snackbar_text);
        this.f3895b = (Button) findViewById(R.id.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
        Layout layout = this.f3894a.getLayout();
        boolean z4 = layout != null && layout.getLineCount() > 1;
        if (!z4 || this.f3896c <= 0 || this.f3895b.getMeasuredWidth() <= this.f3896c) {
            if (!z4) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!a(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i4, i5);
    }

    public void setMaxInlineActionWidth(int i4) {
        this.f3896c = i4;
    }

    public SnackbarContentLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        c.L1(context, R.attr.motionEasingEmphasizedInterpolator, a.f6129b);
    }
}
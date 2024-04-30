package com.google.android.material.textview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.example.msphone.R;
import i2.c;
import i2.d;
import o1.a;

/* loaded from: classes.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(@NonNull Context context) {
        this(context, null);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(@NonNull Context context, int i4) {
        super.setTextAppearance(context, i4);
        if (c.b(context, R.attr.textAppearanceLineHeightEnabled, true)) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(i4, a.I);
            Context context2 = getContext();
            int[] iArr = {1, 2};
            int i5 = -1;
            for (int i6 = 0; i6 < 2 && i5 < 0; i6++) {
                i5 = d.c(context2, obtainStyledAttributes, iArr[i6], -1);
            }
            obtainStyledAttributes.recycle();
            if (i5 >= 0) {
                setLineHeight(i5);
            }
        }
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(p2.a.a(context, attributeSet, i4, 0), attributeSet, i4);
        Context context2 = getContext();
        if (c.b(context2, R.attr.textAppearanceLineHeightEnabled, true)) {
            Resources.Theme theme = context2.getTheme();
            int[] iArr = a.J;
            TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, i4, 0);
            int[] iArr2 = {1, 2};
            int i5 = -1;
            for (int i6 = 0; i6 < 2 && i5 < 0; i6++) {
                i5 = d.c(context2, obtainStyledAttributes, iArr2[i6], -1);
            }
            obtainStyledAttributes.recycle();
            if (i5 != -1) {
                return;
            }
            TypedArray obtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, iArr, i4, 0);
            int resourceId = obtainStyledAttributes2.getResourceId(0, -1);
            obtainStyledAttributes2.recycle();
            if (resourceId != -1) {
                TypedArray obtainStyledAttributes3 = theme.obtainStyledAttributes(resourceId, a.I);
                Context context3 = getContext();
                int[] iArr3 = {1, 2};
                int i7 = -1;
                for (int i8 = 0; i8 < 2 && i7 < 0; i8++) {
                    i7 = d.c(context3, obtainStyledAttributes3, iArr3[i8], -1);
                }
                obtainStyledAttributes3.recycle();
                if (i7 >= 0) {
                    setLineHeight(i7);
                }
            }
        }
    }
}
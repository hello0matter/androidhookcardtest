package com.google.android.material.appbar;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.f1;

/* loaded from: classes.dex */
public abstract class h {
    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    @DoNotInline
    public static ColorStateList b(@Nullable Drawable drawable) {
        ColorStateList colorStateList;
        if (f1.u(drawable)) {
            colorStateList = f1.e(drawable).getColorStateList();
            return colorStateList;
        }
        return null;
    }
}
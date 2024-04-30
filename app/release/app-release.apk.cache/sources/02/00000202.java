package androidx.core.widget;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class c {
    @DoNotInline
    public static Drawable a(CompoundButton compoundButton) {
        return compoundButton.getButtonDrawable();
    }
}
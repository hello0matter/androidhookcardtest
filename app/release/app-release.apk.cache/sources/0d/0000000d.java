package a0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import androidx.annotation.ColorRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class l {
    @DoNotInline
    public static int a(Resources resources, int i4, Resources.Theme theme) {
        return resources.getColor(i4, theme);
    }

    @NonNull
    @DoNotInline
    public static ColorStateList b(@NonNull Resources resources, @ColorRes int i4, @Nullable Resources.Theme theme) {
        return resources.getColorStateList(i4, theme);
    }
}
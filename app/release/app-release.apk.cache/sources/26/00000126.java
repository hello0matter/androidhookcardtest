package androidx.appcompat.widget;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class c1 {
    @DoNotInline
    public static boolean a(@NonNull View view) {
        return view.isInLayout();
    }
}
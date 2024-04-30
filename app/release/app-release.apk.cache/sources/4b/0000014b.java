package androidx.appcompat.widget;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class j0 {
    @DoNotInline
    public static int a(@NonNull View view) {
        return view.getTextAlignment();
    }

    @DoNotInline
    public static int b(@NonNull View view) {
        return view.getTextDirection();
    }

    @DoNotInline
    public static void c(@NonNull View view, int i4) {
        view.setTextAlignment(i4);
    }

    @DoNotInline
    public static void d(@NonNull View view, int i4) {
        view.setTextDirection(i4);
    }
}
package androidx.core.widget;

import android.widget.TextView;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class p {
    @DoNotInline
    public static boolean a(TextView textView) {
        return textView.getIncludeFontPadding();
    }

    @DoNotInline
    public static int b(TextView textView) {
        return textView.getMaxLines();
    }

    @DoNotInline
    public static int c(TextView textView) {
        return textView.getMinLines();
    }
}
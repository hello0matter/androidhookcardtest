package androidx.core.widget;

import android.icu.text.DecimalFormatSymbols;
import android.text.PrecomputedText;
import android.widget.TextView;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class t {
    @DoNotInline
    public static String[] a(DecimalFormatSymbols decimalFormatSymbols) {
        return decimalFormatSymbols.getDigitStrings();
    }

    @DoNotInline
    public static PrecomputedText.Params b(TextView textView) {
        return textView.getTextMetricsParams();
    }

    @DoNotInline
    public static void c(TextView textView, int i4) {
        textView.setFirstBaselineToTopHeight(i4);
    }
}
package androidx.appcompat.widget;

import android.widget.TextView;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class w0 {
    @DoNotInline
    public static int a(TextView textView) {
        return textView.getAutoSizeStepGranularity();
    }

    @DoNotInline
    public static void b(TextView textView, int i4, int i5, int i6, int i7) {
        textView.setAutoSizeTextTypeUniformWithConfiguration(i4, i5, i6, i7);
    }

    @DoNotInline
    public static void c(TextView textView, int[] iArr, int i4) {
        textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i4);
    }

    @DoNotInline
    public static boolean d(TextView textView, String str) {
        return textView.setFontVariationSettings(str);
    }
}
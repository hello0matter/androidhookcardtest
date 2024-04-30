package androidx.core.widget;

import android.icu.text.DecimalFormatSymbols;
import androidx.annotation.DoNotInline;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class s {
    @DoNotInline
    public static DecimalFormatSymbols a(Locale locale) {
        return DecimalFormatSymbols.getInstance(locale);
    }
}
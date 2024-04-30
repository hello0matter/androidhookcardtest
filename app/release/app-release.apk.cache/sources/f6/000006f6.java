package g0;

import android.icu.util.ULocale;
import androidx.annotation.DoNotInline;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class d {
    @DoNotInline
    public static ULocale a(Object obj) {
        return ULocale.addLikelySubtags((ULocale) obj);
    }

    @DoNotInline
    public static ULocale b(Locale locale) {
        return ULocale.forLocale(locale);
    }

    @DoNotInline
    public static String c(Object obj) {
        return ((ULocale) obj).getScript();
    }
}
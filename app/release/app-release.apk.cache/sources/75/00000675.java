package e0;

import android.os.LocaleList;
import androidx.annotation.DoNotInline;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class e {
    @DoNotInline
    public static LocaleList a(Locale... localeArr) {
        return new LocaleList(localeArr);
    }

    @DoNotInline
    public static LocaleList b() {
        return LocaleList.getAdjustedDefault();
    }

    @DoNotInline
    public static LocaleList c() {
        return LocaleList.getDefault();
    }
}
package e0;

import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Locale[] f4425a = {new Locale("en", "XA"), new Locale("ar", "XB")};

    @DoNotInline
    public static Locale a(String str) {
        return Locale.forLanguageTag(str);
    }

    @DoNotInline
    public static boolean b(@NonNull Locale locale, @NonNull Locale locale2) {
        if (locale.equals(locale2)) {
            return true;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage())) {
            return false;
        }
        Locale[] localeArr = f4425a;
        int length = localeArr.length;
        int i4 = 0;
        while (true) {
            if (i4 < length) {
                if (localeArr[i4].equals(locale)) {
                    break;
                }
                i4++;
            } else {
                for (Locale locale3 : localeArr) {
                    if (!locale3.equals(locale2)) {
                    }
                }
                String c4 = g0.d.c(g0.d.a(g0.d.b(locale)));
                if (c4.isEmpty()) {
                    String country = locale.getCountry();
                    if (country.isEmpty() || country.equals(locale2.getCountry())) {
                        return true;
                    }
                    return false;
                }
                return c4.equals(g0.d.c(g0.d.a(g0.d.b(locale2))));
            }
        }
        return false;
    }
}
package e0;

import android.os.Build;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class a {
    public static boolean a() {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 33) {
            if (i4 >= 32) {
                String str = Build.VERSION.CODENAME;
                if (!"REL".equals(str)) {
                    Locale locale = Locale.ROOT;
                    if (str.toUpperCase(locale).compareTo("Tiramisu".toUpperCase(locale)) >= 0) {
                    }
                }
            }
            return false;
        }
        return true;
    }
}
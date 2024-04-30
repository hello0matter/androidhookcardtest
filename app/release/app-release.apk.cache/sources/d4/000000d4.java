package androidx.appcompat.app;

import android.app.LocaleManager;
import android.os.LocaleList;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class p {
    @DoNotInline
    public static LocaleList a(Object obj) {
        return ((LocaleManager) obj).getApplicationLocales();
    }

    @DoNotInline
    public static void b(Object obj, LocaleList localeList) {
        ((LocaleManager) obj).setApplicationLocales(localeList);
    }
}
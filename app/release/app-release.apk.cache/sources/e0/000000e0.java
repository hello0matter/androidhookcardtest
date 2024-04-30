package androidx.appcompat.app;

import android.content.res.Configuration;
import android.os.LocaleList;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class v {
    @DoNotInline
    public static void a(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
        LocaleList locales = configuration.getLocales();
        LocaleList locales2 = configuration2.getLocales();
        if (locales.equals(locales2)) {
            return;
        }
        configuration3.setLocales(locales2);
        configuration3.locale = configuration2.locale;
    }

    @DoNotInline
    public static e0.f b(Configuration configuration) {
        return e0.f.a(configuration.getLocales().toLanguageTags());
    }

    @DoNotInline
    public static void c(e0.f fVar) {
        LocaleList.setDefault(LocaleList.forLanguageTags(((e0.h) fVar.f4427a).f4428a.toLanguageTags()));
    }

    @DoNotInline
    public static void d(Configuration configuration, e0.f fVar) {
        configuration.setLocales(LocaleList.forLanguageTags(((e0.h) fVar.f4427a).f4428a.toLanguageTags()));
    }
}
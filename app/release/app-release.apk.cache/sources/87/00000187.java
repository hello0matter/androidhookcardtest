package androidx.appcompat.widget;

import android.os.LocaleList;
import android.widget.TextView;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class v0 {
    @DoNotInline
    public static LocaleList a(String str) {
        return LocaleList.forLanguageTags(str);
    }

    @DoNotInline
    public static void b(TextView textView, LocaleList localeList) {
        textView.setTextLocales(localeList);
    }
}
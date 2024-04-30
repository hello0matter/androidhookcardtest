package androidx.appcompat.app;

import android.os.LocaleList;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class o {
    @DoNotInline
    public static LocaleList a(String str) {
        return LocaleList.forLanguageTags(str);
    }
}
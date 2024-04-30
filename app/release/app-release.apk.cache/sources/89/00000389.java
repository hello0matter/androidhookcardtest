package c0;

import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class d {
    @DoNotInline
    public static int a(Object obj) {
        return ((Icon) obj).getResId();
    }

    @DoNotInline
    public static String b(Object obj) {
        return ((Icon) obj).getResPackage();
    }

    @DoNotInline
    public static int c(Object obj) {
        return ((Icon) obj).getType();
    }

    @DoNotInline
    public static Uri d(Object obj) {
        return ((Icon) obj).getUri();
    }
}
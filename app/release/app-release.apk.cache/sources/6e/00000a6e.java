package z;

import android.content.Context;
import androidx.annotation.DoNotInline;
import java.io.File;

/* loaded from: classes.dex */
public abstract class b {
    @DoNotInline
    public static File[] a(Context context) {
        return context.getExternalCacheDirs();
    }

    @DoNotInline
    public static File[] b(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    @DoNotInline
    public static File[] c(Context context) {
        return context.getObbDirs();
    }
}
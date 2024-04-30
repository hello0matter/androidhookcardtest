package z;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.DoNotInline;
import java.io.File;

/* loaded from: classes.dex */
public abstract class c {
    @DoNotInline
    public static File a(Context context) {
        return context.getCodeCacheDir();
    }

    @DoNotInline
    public static Drawable b(Context context, int i4) {
        return context.getDrawable(i4);
    }

    @DoNotInline
    public static File c(Context context) {
        return context.getNoBackupFilesDir();
    }
}
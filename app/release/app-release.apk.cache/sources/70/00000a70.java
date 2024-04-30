package z;

import android.content.Context;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class d {
    @DoNotInline
    public static int a(Context context, int i4) {
        return context.getColor(i4);
    }

    @DoNotInline
    public static <T> T b(Context context, Class<T> cls) {
        return (T) context.getSystemService(cls);
    }

    @DoNotInline
    public static String c(Context context, Class<?> cls) {
        return context.getSystemServiceName(cls);
    }
}
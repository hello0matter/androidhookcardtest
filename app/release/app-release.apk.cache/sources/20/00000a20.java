package x;

import android.app.AppOpsManager;
import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class i {
    @DoNotInline
    public static int a(@Nullable AppOpsManager appOpsManager, @NonNull String str, int i4, @NonNull String str2) {
        if (appOpsManager == null) {
            return 1;
        }
        return appOpsManager.checkOpNoThrow(str, i4, str2);
    }

    @NonNull
    @DoNotInline
    public static String b(@NonNull Context context) {
        return context.getOpPackageName();
    }

    @Nullable
    @DoNotInline
    public static AppOpsManager c(@NonNull Context context) {
        return (AppOpsManager) context.getSystemService(AppOpsManager.class);
    }
}
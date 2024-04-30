package x;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class r {
    @DoNotInline
    public static Intent a(Activity activity) {
        return activity.getParentActivityIntent();
    }

    @DoNotInline
    public static boolean b(Activity activity, Intent intent) {
        return activity.navigateUpTo(intent);
    }

    @DoNotInline
    public static boolean c(Activity activity, Intent intent) {
        return activity.shouldUpRecreateTask(intent);
    }
}
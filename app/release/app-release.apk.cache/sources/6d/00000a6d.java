package z;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class a {
    @DoNotInline
    public static void a(Context context, Intent[] intentArr, Bundle bundle) {
        context.startActivities(intentArr, bundle);
    }

    @DoNotInline
    public static void b(Context context, Intent intent, Bundle bundle) {
        context.startActivity(intent, bundle);
    }
}
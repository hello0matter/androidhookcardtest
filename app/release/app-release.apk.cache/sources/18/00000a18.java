package x;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class a {
    @DoNotInline
    public static void a(Activity activity) {
        activity.finishAffinity();
    }

    @DoNotInline
    public static void b(Activity activity, Intent intent, int i4, Bundle bundle) {
        activity.startActivityForResult(intent, i4, bundle);
    }

    @DoNotInline
    public static void c(Activity activity, IntentSender intentSender, int i4, Intent intent, int i5, int i6, int i7, Bundle bundle) {
        activity.startIntentSenderForResult(intentSender, i4, intent, i5, i6, i7, bundle);
    }
}
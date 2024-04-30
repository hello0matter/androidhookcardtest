package androidx.activity;

import android.app.Activity;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class l {
    @DoNotInline
    public static OnBackInvokedDispatcher a(Activity activity) {
        return activity.getOnBackInvokedDispatcher();
    }
}
package i0;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class b {
    @DoNotInline
    public static AccessibilityNodeProvider a(View.AccessibilityDelegate accessibilityDelegate, View view) {
        return accessibilityDelegate.getAccessibilityNodeProvider(view);
    }

    @DoNotInline
    public static boolean b(View.AccessibilityDelegate accessibilityDelegate, View view, int i4, Bundle bundle) {
        return accessibilityDelegate.performAccessibilityAction(view, i4, bundle);
    }
}
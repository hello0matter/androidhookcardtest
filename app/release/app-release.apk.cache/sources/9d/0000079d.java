package j0;

import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class b {
    @DoNotInline
    public static int a(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }

    @DoNotInline
    public static void b(AccessibilityEvent accessibilityEvent, int i4) {
        accessibilityEvent.setContentChangeTypes(i4);
    }
}
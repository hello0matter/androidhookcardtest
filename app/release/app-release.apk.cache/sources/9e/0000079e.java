package j0;

import android.view.accessibility.AccessibilityManager;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class c {
    @DoNotInline
    public static boolean a(AccessibilityManager accessibilityManager, d dVar) {
        return accessibilityManager.addTouchExplorationStateChangeListener(new e(dVar));
    }

    @DoNotInline
    public static boolean b(AccessibilityManager accessibilityManager, d dVar) {
        return accessibilityManager.removeTouchExplorationStateChangeListener(new e(dVar));
    }
}
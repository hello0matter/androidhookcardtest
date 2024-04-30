package j0;

import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class l {
    @DoNotInline
    public static int a(AccessibilityRecord accessibilityRecord) {
        return accessibilityRecord.getMaxScrollX();
    }

    @DoNotInline
    public static int b(AccessibilityRecord accessibilityRecord) {
        return accessibilityRecord.getMaxScrollY();
    }

    @DoNotInline
    public static void c(AccessibilityRecord accessibilityRecord, int i4) {
        accessibilityRecord.setMaxScrollX(i4);
    }

    @DoNotInline
    public static void d(AccessibilityRecord accessibilityRecord, int i4) {
        accessibilityRecord.setMaxScrollY(i4);
    }
}
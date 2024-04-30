package j0;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class m {
    @DoNotInline
    public static void a(AccessibilityRecord accessibilityRecord, View view, int i4) {
        accessibilityRecord.setSource(view, i4);
    }
}
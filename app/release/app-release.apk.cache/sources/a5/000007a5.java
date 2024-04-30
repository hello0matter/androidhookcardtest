package j0;

import android.view.accessibility.AccessibilityNodeInfo;

/* loaded from: classes.dex */
public class j extends i {
    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int i4) {
        h c4 = this.f5096a.c(i4);
        if (c4 == null) {
            return null;
        }
        return c4.f5093a;
    }
}
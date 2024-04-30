package j0;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.recyclerview.widget.i0;
import java.util.List;

/* loaded from: classes.dex */
public abstract class i extends AccessibilityNodeProvider {

    /* renamed from: a  reason: collision with root package name */
    public final i0 f5096a;

    public i(i0 i0Var) {
        this.f5096a = i0Var;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i4) {
        h a5 = this.f5096a.a(i4);
        if (a5 == null) {
            return null;
        }
        return a5.f5093a;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final List findAccessibilityNodeInfosByText(String str, int i4) {
        this.f5096a.getClass();
        return null;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int i4, int i5, Bundle bundle) {
        return this.f5096a.l(i4, i5, bundle);
    }
}
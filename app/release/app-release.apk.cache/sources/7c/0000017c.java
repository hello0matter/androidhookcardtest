package androidx.appcompat.widget;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;

/* loaded from: classes.dex */
public final class t extends View.AccessibilityDelegate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f897a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f898b;

    public /* synthetic */ t(int i4, Object obj) {
        this.f897a = i4;
        this.f898b = obj;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        switch (this.f897a) {
            case 0:
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setCanOpenPopup(true);
                return;
            default:
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                EditText editText = ((com.google.android.material.textfield.o) this.f898b).f4087h.getEditText();
                if (editText != null) {
                    accessibilityNodeInfo.setLabeledBy(editText);
                    return;
                }
                return;
        }
    }
}
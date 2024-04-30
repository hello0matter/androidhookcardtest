package androidx.appcompat.widget;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.example.msphone.R;

/* loaded from: classes.dex */
public final class q2 extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScrollingTabContainerView f877a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q2(ScrollingTabContainerView scrollingTabContainerView, Context context) {
        super(context, null, R.attr.actionBarTabStyle);
        this.f877a = scrollingTabContainerView;
        q3 f4 = q3.f(context, null, new int[]{16842964}, R.attr.actionBarTabStyle, 0);
        if (f4.f879b.hasValue(0)) {
            setBackgroundDrawable(f4.b(0));
        }
        f4.g();
        setGravity(8388627);
        throw null;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        ScrollingTabContainerView scrollingTabContainerView = this.f877a;
        if (scrollingTabContainerView.f602e > 0) {
            int measuredWidth = getMeasuredWidth();
            int i6 = scrollingTabContainerView.f602e;
            if (measuredWidth > i6) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), i5);
            }
        }
    }

    @Override // android.view.View
    public final void setSelected(boolean z4) {
        boolean z5 = isSelected() != z4;
        super.setSelected(z4);
        if (z5 && z4) {
            sendAccessibilityEvent(4);
        }
    }
}
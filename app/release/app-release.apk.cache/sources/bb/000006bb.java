package f1;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.VisibleForTesting;
import androidx.recyclerview.widget.i0;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;

/* loaded from: classes.dex */
public final class f extends i0.c {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f4549d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ View f4550e;

    public /* synthetic */ f(int i4, View view) {
        this.f4549d = i4;
        this.f4550e = view;
    }

    @Override // i0.c
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        int i4 = this.f4549d;
        View view2 = this.f4550e;
        switch (i4) {
            case 0:
                super.c(view, accessibilityEvent);
                accessibilityEvent.setClassName(ViewPager.class.getName());
                ((ViewPager) view2).getClass();
                accessibilityEvent.setScrollable(false);
                if (accessibilityEvent.getEventType() == 4096) {
                    ((ViewPager) view2).getClass();
                    return;
                }
                return;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                super.c(view, accessibilityEvent);
                accessibilityEvent.setChecked(((CheckableImageButton) view2).f3439d);
                return;
            default:
                super.c(view, accessibilityEvent);
                return;
        }
    }

    @Override // i0.c
    public final void d(View view, j0.h hVar) {
        int i4;
        View.AccessibilityDelegate accessibilityDelegate = this.f4912a;
        AccessibilityNodeInfo accessibilityNodeInfo = hVar.f5093a;
        int i5 = this.f4549d;
        View view2 = this.f4550e;
        switch (i5) {
            case 0:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                hVar.g(ViewPager.class.getName());
                ((ViewPager) view2).getClass();
                hVar.j(false);
                ((ViewPager) view2).getClass();
                return;
            case 1:
            default:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                return;
            case 2:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) view2;
                int i6 = MaterialButtonToggleGroup.f3130k;
                materialButtonToggleGroup.getClass();
                if (view instanceof MaterialButton) {
                    int i7 = 0;
                    for (int i8 = 0; i8 < materialButtonToggleGroup.getChildCount(); i8++) {
                        if (materialButtonToggleGroup.getChildAt(i8) == view) {
                            i4 = i7;
                            hVar.h(i0.i(0, 1, i4, 1, false, ((MaterialButton) view).f3126o));
                            return;
                        }
                        if ((materialButtonToggleGroup.getChildAt(i8) instanceof MaterialButton) && materialButtonToggleGroup.c(i8)) {
                            i7++;
                        }
                    }
                }
                i4 = -1;
                hVar.h(i0.i(0, 1, i4, 1, false, ((MaterialButton) view).f3126o));
                return;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                CheckableImageButton checkableImageButton = (CheckableImageButton) view2;
                accessibilityNodeInfo.setCheckable(checkableImageButton.f3440e);
                accessibilityNodeInfo.setChecked(checkableImageButton.f3439d);
                return;
            case VisibleForTesting.PROTECTED /* 4 */:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setCheckable(((NavigationMenuItemView) view2).f3457x);
                return;
        }
    }

    @Override // i0.c
    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f4549d) {
            case 1:
                super.e(view, accessibilityEvent);
                if (accessibilityEvent.getEventType() == 1) {
                    int i4 = BottomSheetDragHandleView.f3103m;
                    ((BottomSheetDragHandleView) this.f4550e).c();
                    return;
                }
                return;
            default:
                super.e(view, accessibilityEvent);
                return;
        }
    }

    @Override // i0.c
    public final boolean g(View view, int i4, Bundle bundle) {
        switch (this.f4549d) {
            case 0:
                if (super.g(view, i4, bundle)) {
                    return true;
                }
                View view2 = this.f4550e;
                if (i4 == 4096 || i4 == 8192) {
                    ((ViewPager) view2).getClass();
                }
                return false;
            default:
                return super.g(view, i4, bundle);
        }
    }
}
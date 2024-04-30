package w1;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.example.msphone.R;
import com.google.android.material.chip.Chip;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class d extends n0.b {

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Chip f7025q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Chip chip, Chip chip2) {
        super(chip2);
        this.f7025q = chip;
    }

    @Override // n0.b
    public final int n(float f4, float f5) {
        RectF closeIconTouchBounds;
        Rect rect = Chip.f3212x;
        Chip chip = this.f7025q;
        if (chip.d()) {
            closeIconTouchBounds = chip.getCloseIconTouchBounds();
            if (closeIconTouchBounds.contains(f4, f5)) {
                return 1;
            }
        }
        return 0;
    }

    @Override // n0.b
    public final void o(ArrayList arrayList) {
        boolean z4 = false;
        arrayList.add(0);
        Rect rect = Chip.f3212x;
        Chip chip = this.f7025q;
        if (chip.d()) {
            f fVar = chip.f3215e;
            if (fVar != null && fVar.K) {
                z4 = true;
            }
            if (z4 && chip.f3218h != null) {
                arrayList.add(1);
            }
        }
    }

    @Override // n0.b
    public final boolean s(int i4, int i5, Bundle bundle) {
        boolean z4 = false;
        if (i5 == 16) {
            Chip chip = this.f7025q;
            if (i4 == 0) {
                return chip.performClick();
            }
            if (i4 == 1) {
                chip.playSoundEffect(0);
                View.OnClickListener onClickListener = chip.f3218h;
                if (onClickListener != null) {
                    onClickListener.onClick(chip);
                    z4 = true;
                }
                if (chip.f3230t) {
                    chip.f3229s.x(1, 1);
                }
            }
        }
        return z4;
    }

    @Override // n0.b
    public final void t(j0.h hVar) {
        Chip chip = this.f7025q;
        boolean e4 = chip.e();
        AccessibilityNodeInfo accessibilityNodeInfo = hVar.f5093a;
        accessibilityNodeInfo.setCheckable(e4);
        accessibilityNodeInfo.setClickable(chip.isClickable());
        hVar.g(chip.getAccessibilityClassName());
        hVar.k(chip.getText());
    }

    @Override // n0.b
    public final void u(int i4, j0.h hVar) {
        Rect closeIconTouchBoundsInt;
        AccessibilityNodeInfo accessibilityNodeInfo = hVar.f5093a;
        String str = "";
        if (i4 == 1) {
            Chip chip = this.f7025q;
            CharSequence closeIconContentDescription = chip.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                accessibilityNodeInfo.setContentDescription(closeIconContentDescription);
            } else {
                CharSequence text = chip.getText();
                Context context = chip.getContext();
                Object[] objArr = new Object[1];
                if (!TextUtils.isEmpty(text)) {
                    str = text;
                }
                objArr[0] = str;
                accessibilityNodeInfo.setContentDescription(context.getString(R.string.mtrl_chip_close_icon_content_description, objArr).trim());
            }
            closeIconTouchBoundsInt = chip.getCloseIconTouchBoundsInt();
            accessibilityNodeInfo.setBoundsInParent(closeIconTouchBoundsInt);
            hVar.b(j0.g.f5079g);
            accessibilityNodeInfo.setEnabled(chip.isEnabled());
            return;
        }
        accessibilityNodeInfo.setContentDescription("");
        accessibilityNodeInfo.setBoundsInParent(Chip.f3212x);
    }

    @Override // n0.b
    public final void v(int i4, boolean z4) {
        if (i4 == 1) {
            Chip chip = this.f7025q;
            chip.f3224n = z4;
            chip.refreshDrawableState();
        }
    }
}
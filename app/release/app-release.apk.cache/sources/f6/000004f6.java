package com.google.android.material.datepicker;

import android.content.res.Resources;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.example.msphone.R;

/* loaded from: classes.dex */
public final class m extends i0.c {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f3351d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f3352e;

    public /* synthetic */ m(int i4, Object obj) {
        this.f3351d = i4;
        this.f3352e = obj;
    }

    @Override // i0.c
    public final void d(View view, j0.h hVar) {
        Resources resources;
        int i4;
        int i5 = this.f3351d;
        View.AccessibilityDelegate accessibilityDelegate = this.f4912a;
        AccessibilityNodeInfo accessibilityNodeInfo = hVar.f5093a;
        switch (i5) {
            case 0:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setCollectionInfo(null);
                return;
            case 1:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                hVar.j(false);
                return;
            case 2:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                MaterialCalendar materialCalendar = (MaterialCalendar) this.f3352e;
                if (materialCalendar.f3265f0.getVisibility() == 0) {
                    resources = materialCalendar.C().getResources();
                    i4 = R.string.mtrl_picker_toggle_to_year_selection;
                } else {
                    resources = materialCalendar.C().getResources();
                    i4 = R.string.mtrl_picker_toggle_to_day_selection;
                }
                hVar.i(resources.getString(i4));
                return;
            default:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setCollectionInfo(null);
                return;
        }
    }
}
package com.google.android.material.slider;

import android.content.Context;
import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.SeekBar;
import com.example.msphone.R;
import j0.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class d extends n0.b {

    /* renamed from: q  reason: collision with root package name */
    public final BaseSlider f3882q;

    /* renamed from: r  reason: collision with root package name */
    public final Rect f3883r;

    public d(BaseSlider baseSlider) {
        super(baseSlider);
        this.f3883r = new Rect();
        this.f3882q = baseSlider;
    }

    @Override // n0.b
    public final int n(float f4, float f5) {
        int i4 = 0;
        while (true) {
            BaseSlider baseSlider = this.f3882q;
            if (i4 >= baseSlider.getValues().size()) {
                return -1;
            }
            Rect rect = this.f3883r;
            baseSlider.u(i4, rect);
            if (rect.contains((int) f4, (int) f5)) {
                return i4;
            }
            i4++;
        }
    }

    @Override // n0.b
    public final void o(ArrayList arrayList) {
        for (int i4 = 0; i4 < this.f3882q.getValues().size(); i4++) {
            arrayList.add(Integer.valueOf(i4));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
        if (r0.s(r8, r9) != false) goto L16;
     */
    @Override // n0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean s(int r8, int r9, android.os.Bundle r10) {
        /*
            r7 = this;
            com.google.android.material.slider.BaseSlider r0 = r7.f3882q
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            r1 = 4096(0x1000, float:5.74E-42)
            r3 = 1
            r4 = 8192(0x2000, float:1.148E-41)
            if (r9 == r1) goto L3b
            if (r9 == r4) goto L3b
            r1 = 16908349(0x102003d, float:2.38774E-38)
            if (r9 == r1) goto L19
            return r2
        L19:
            if (r10 == 0) goto L3a
            java.lang.String r9 = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"
            boolean r1 = r10.containsKey(r9)
            if (r1 != 0) goto L24
            goto L3a
        L24:
            float r9 = r10.getFloat(r9)
            int r10 = com.google.android.material.slider.BaseSlider.f3834i0
            boolean r9 = r0.s(r8, r9)
            if (r9 == 0) goto L3a
        L30:
            r0.v()
            r0.postInvalidate()
            r7.p(r8)
            return r3
        L3a:
            return r2
        L3b:
            int r10 = com.google.android.material.slider.BaseSlider.f3834i0
            float r10 = r0.N
            r1 = 0
            int r1 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r1 != 0) goto L46
            r10 = 1065353216(0x3f800000, float:1.0)
        L46:
            float r1 = r0.J
            float r5 = r0.I
            float r1 = r1 - r5
            float r1 = r1 / r10
            r5 = 20
            float r5 = (float) r5
            int r6 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r6 > 0) goto L54
            goto L5b
        L54:
            float r1 = r1 / r5
            int r1 = java.lang.Math.round(r1)
            float r1 = (float) r1
            float r10 = r10 * r1
        L5b:
            if (r9 != r4) goto L5e
            float r10 = -r10
        L5e:
            boolean r9 = r0.j()
            if (r9 == 0) goto L65
            float r10 = -r10
        L65:
            java.util.List r9 = r0.getValues()
            java.lang.Object r9 = r9.get(r8)
            java.lang.Float r9 = (java.lang.Float) r9
            float r9 = r9.floatValue()
            float r9 = r9 + r10
            float r10 = r0.getValueFrom()
            float r1 = r0.getValueTo()
            float r9 = com.google.common.collect.c.K(r9, r10, r1)
            boolean r9 = r0.s(r8, r9)
            if (r9 == 0) goto L87
            goto L30
        L87:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.d.s(int, int, android.os.Bundle):boolean");
    }

    @Override // n0.b
    public final void u(int i4, h hVar) {
        String str;
        Context context;
        int i5;
        hVar.b(j0.g.f5087o);
        BaseSlider baseSlider = this.f3882q;
        List<Float> values = baseSlider.getValues();
        float floatValue = values.get(i4).floatValue();
        float valueFrom = baseSlider.getValueFrom();
        float valueTo = baseSlider.getValueTo();
        if (baseSlider.isEnabled()) {
            if (floatValue > valueFrom) {
                hVar.a(8192);
            }
            if (floatValue < valueTo) {
                hVar.a(4096);
            }
        }
        AccessibilityNodeInfo.RangeInfo obtain = AccessibilityNodeInfo.RangeInfo.obtain(1, valueFrom, valueTo, floatValue);
        AccessibilityNodeInfo accessibilityNodeInfo = hVar.f5093a;
        accessibilityNodeInfo.setRangeInfo(obtain);
        hVar.g(SeekBar.class.getName());
        StringBuilder sb = new StringBuilder();
        if (baseSlider.getContentDescription() != null) {
            sb.append(baseSlider.getContentDescription());
            sb.append(",");
        }
        String e4 = baseSlider.e(floatValue);
        String string = baseSlider.getContext().getString(R.string.material_slider_value);
        if (values.size() > 1) {
            if (i4 == baseSlider.getValues().size() - 1) {
                context = baseSlider.getContext();
                i5 = R.string.material_slider_range_end;
            } else if (i4 == 0) {
                context = baseSlider.getContext();
                i5 = R.string.material_slider_range_start;
            } else {
                str = "";
                string = str;
            }
            str = context.getString(i5);
            string = str;
        }
        Locale locale = Locale.US;
        sb.append(string + ", " + e4);
        accessibilityNodeInfo.setContentDescription(sb.toString());
        Rect rect = this.f3883r;
        baseSlider.u(i4, rect);
        accessibilityNodeInfo.setBoundsInParent(rect);
    }
}
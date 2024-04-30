package c1;

import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.transition.Transition;

/* loaded from: classes.dex */
public final class m extends y0 {
    @Override // com.google.common.collect.c
    public final long O0(ViewGroup viewGroup, Transition transition, m0 m0Var, m0 m0Var2) {
        int i4;
        Rect n12;
        int[] iArr;
        int round;
        int i5;
        Integer num;
        if (m0Var == null && m0Var2 == null) {
            return 0L;
        }
        if (m0Var2 != null && (m0Var == null || (num = (Integer) m0Var.f2646a.get("android:visibilityPropagation:visibility")) == null || num.intValue() != 0)) {
            m0Var = m0Var2;
            i4 = 1;
        } else {
            i4 = -1;
        }
        int h22 = y0.h2(m0Var, 0);
        int h23 = y0.h2(m0Var, 1);
        com.google.common.collect.c cVar = transition.f2370t;
        if (cVar == null) {
            n12 = null;
        } else {
            n12 = cVar.n1();
        }
        if (n12 != null) {
            i5 = n12.centerX();
            round = n12.centerY();
        } else {
            viewGroup.getLocationOnScreen(new int[2]);
            int round2 = Math.round(viewGroup.getTranslationX() + (viewGroup.getWidth() / 2) + iArr[0]);
            round = Math.round(viewGroup.getTranslationY() + (viewGroup.getHeight() / 2) + iArr[1]);
            i5 = round2;
        }
        float f4 = i5 - h22;
        float f5 = round - h23;
        float sqrt = (float) Math.sqrt((f5 * f5) + (f4 * f4));
        float width = viewGroup.getWidth() - 0.0f;
        float height = viewGroup.getHeight() - 0.0f;
        float sqrt2 = sqrt / ((float) Math.sqrt((height * height) + (width * width)));
        long j4 = transition.f2353c;
        if (j4 < 0) {
            j4 = 300;
        }
        return Math.round((((float) (j4 * i4)) / 3.0f) * sqrt2);
    }
}
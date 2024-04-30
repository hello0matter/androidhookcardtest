package c1;

import android.view.View;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class y0 extends com.google.common.collect.c {

    /* renamed from: q  reason: collision with root package name */
    public static final String[] f2717q = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    public static int h2(m0 m0Var, int i4) {
        int[] iArr;
        if (m0Var == null || (iArr = (int[]) m0Var.f2646a.get("android:visibilityPropagation:center")) == null) {
            return -1;
        }
        return iArr[i4];
    }

    @Override // com.google.common.collect.c
    public final void v(m0 m0Var) {
        View view = m0Var.f2647b;
        HashMap hashMap = m0Var.f2646a;
        Integer num = (Integer) hashMap.get("android:visibility:visibility");
        if (num == null) {
            num = Integer.valueOf(view.getVisibility());
        }
        hashMap.put("android:visibilityPropagation:visibility", num);
        view.getLocationOnScreen(r2);
        int round = Math.round(view.getTranslationX()) + r2[0];
        int[] iArr = {round};
        iArr[0] = (view.getWidth() / 2) + round;
        int round2 = Math.round(view.getTranslationY()) + iArr[1];
        iArr[1] = round2;
        iArr[1] = (view.getHeight() / 2) + round2;
        hashMap.put("android:visibilityPropagation:center", iArr);
    }
}
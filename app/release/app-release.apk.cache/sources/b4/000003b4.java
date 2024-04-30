package c1;

import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public class t0 extends s0 {

    /* renamed from: j  reason: collision with root package name */
    public static boolean f2684j = true;

    @Override // androidx.appcompat.app.o0
    public void w(int i4, View view) {
        if (Build.VERSION.SDK_INT == 28) {
            super.w(i4, view);
        } else if (f2684j) {
            try {
                view.setTransitionVisibility(i4);
            } catch (NoSuchMethodError unused) {
                f2684j = false;
            }
        }
    }
}
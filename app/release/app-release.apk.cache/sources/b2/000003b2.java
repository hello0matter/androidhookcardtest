package c1;

import android.view.View;

/* loaded from: classes.dex */
public abstract class s0 extends r0 {

    /* renamed from: i  reason: collision with root package name */
    public static boolean f2680i = true;

    public void D(View view, int i4, int i5, int i6, int i7) {
        if (f2680i) {
            try {
                view.setLeftTopRightBottom(i4, i5, i6, i7);
            } catch (NoSuchMethodError unused) {
                f2680i = false;
            }
        }
    }
}
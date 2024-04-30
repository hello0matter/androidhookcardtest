package i0;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class l0 implements View.OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public g2 f4949a = null;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f4950b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ w f4951c;

    public l0(View view, w wVar) {
        this.f4950b = view;
        this.f4951c = wVar;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        g2 h4 = g2.h(view, windowInsets);
        int i4 = Build.VERSION.SDK_INT;
        w wVar = this.f4951c;
        if (i4 < 30) {
            m0.a(windowInsets, this.f4950b);
            if (h4.equals(this.f4949a)) {
                return wVar.i(view, h4).g();
            }
        }
        this.f4949a = h4;
        g2 i5 = wVar.i(view, h4);
        if (i4 >= 30) {
            return i5.g();
        }
        WeakHashMap weakHashMap = y0.f4999a;
        k0.c(view);
        return i5.g();
    }
}
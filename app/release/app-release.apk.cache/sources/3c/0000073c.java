package i0;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class d0 implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f4916a = new WeakHashMap();

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean z4;
        int i4;
        if (Build.VERSION.SDK_INT < 28) {
            WeakHashMap weakHashMap = this.f4916a;
            for (Map.Entry entry : weakHashMap.entrySet()) {
                View view = (View) entry.getKey();
                boolean booleanValue = ((Boolean) entry.getValue()).booleanValue();
                if (view.isShown() && view.getWindowVisibility() == 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (booleanValue != z4) {
                    if (z4) {
                        i4 = 16;
                    } else {
                        i4 = 32;
                    }
                    y0.i(i4, view);
                    weakHashMap.put(view, Boolean.valueOf(z4));
                }
            }
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
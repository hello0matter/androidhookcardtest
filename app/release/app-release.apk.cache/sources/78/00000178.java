package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class s0 extends a0.p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f889a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f890b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WeakReference f891c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ y0 f892d;

    public s0(y0 y0Var, int i4, int i5, WeakReference weakReference) {
        this.f892d = y0Var;
        this.f889a = i4;
        this.f890b = i5;
        this.f891c = weakReference;
    }

    @Override // a0.p
    public final void c(int i4) {
    }

    @Override // a0.p
    public final void d(Typeface typeface) {
        int i4;
        boolean z4;
        if (Build.VERSION.SDK_INT >= 28 && (i4 = this.f889a) != -1) {
            if ((this.f890b & 2) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            typeface = x0.a(typeface, i4, z4);
        }
        y0 y0Var = this.f892d;
        if (y0Var.f984m) {
            y0Var.f983l = typeface;
            TextView textView = (TextView) this.f891c.get();
            if (textView != null) {
                WeakHashMap weakHashMap = i0.y0.f4999a;
                boolean b5 = i0.j0.b(textView);
                int i5 = y0Var.f981j;
                if (b5) {
                    textView.post(new t0(textView, typeface, i5));
                } else {
                    textView.setTypeface(typeface, i5);
                }
            }
        }
    }
}
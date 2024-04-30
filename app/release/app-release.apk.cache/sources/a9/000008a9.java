package n0;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.i0;
import i0.g0;
import i0.y0;
import j0.h;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class a extends i0 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f5696b;

    public a(b bVar) {
        this.f5696b = bVar;
    }

    @Override // androidx.recyclerview.widget.i0
    public final h a(int i4) {
        return new h(AccessibilityNodeInfo.obtain(this.f5696b.r(i4).f5093a));
    }

    @Override // androidx.recyclerview.widget.i0
    public final h c(int i4) {
        int i5;
        b bVar = this.f5696b;
        if (i4 == 2) {
            i5 = bVar.f5707k;
        } else {
            i5 = bVar.f5708l;
        }
        if (i5 == Integer.MIN_VALUE) {
            return null;
        }
        return a(i5);
    }

    @Override // androidx.recyclerview.widget.i0
    public final boolean l(int i4, int i5, Bundle bundle) {
        int i6;
        b bVar = this.f5696b;
        View view = bVar.f5705i;
        if (i4 != -1) {
            boolean z4 = true;
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 64) {
                        if (i5 != 128) {
                            return bVar.s(i4, i5, bundle);
                        }
                        if (bVar.f5707k == i4) {
                            bVar.f5707k = Integer.MIN_VALUE;
                            view.invalidate();
                            bVar.x(i4, 65536);
                        }
                        z4 = false;
                    } else {
                        AccessibilityManager accessibilityManager = bVar.f5704h;
                        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled() && (i6 = bVar.f5707k) != i4) {
                            if (i6 != Integer.MIN_VALUE) {
                                bVar.f5707k = Integer.MIN_VALUE;
                                bVar.f5705i.invalidate();
                                bVar.x(i6, 65536);
                            }
                            bVar.f5707k = i4;
                            view.invalidate();
                            bVar.x(i4, 32768);
                        }
                        z4 = false;
                    }
                    return z4;
                }
                return bVar.j(i4);
            }
            return bVar.w(i4);
        }
        WeakHashMap weakHashMap = y0.f4999a;
        return g0.j(view, i5, bundle);
    }
}
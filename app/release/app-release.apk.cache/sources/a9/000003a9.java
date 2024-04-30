package c1;

import android.graphics.Rect;

/* loaded from: classes.dex */
public final class o extends com.google.common.collect.c {

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f2660q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Rect f2661r;

    public /* synthetic */ o(Rect rect, int i4) {
        this.f2660q = i4;
        this.f2661r = rect;
    }

    @Override // com.google.common.collect.c
    public final Rect n1() {
        int i4 = this.f2660q;
        Rect rect = this.f2661r;
        switch (i4) {
            case 0:
                return rect;
            default:
                if (rect == null || rect.isEmpty()) {
                    return null;
                }
                return rect;
        }
    }
}
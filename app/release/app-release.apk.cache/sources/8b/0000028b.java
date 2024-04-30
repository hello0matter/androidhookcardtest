package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;

/* loaded from: classes.dex */
public final class v0 extends Transition.EpicenterCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1835a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Rect f1836b;

    public /* synthetic */ v0(Rect rect, int i4) {
        this.f1835a = i4;
        this.f1836b = rect;
    }

    @Override // android.transition.Transition.EpicenterCallback
    public final Rect onGetEpicenter(Transition transition) {
        int i4 = this.f1835a;
        Rect rect = this.f1836b;
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
package c1;

import android.view.View;
import android.view.ViewGroup;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class z extends com.google.common.collect.c {

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f2718q;

    @Override // com.google.common.collect.c, c1.b0
    public final float d(ViewGroup viewGroup, View view) {
        switch (this.f2718q) {
            case 0:
                return view.getTranslationX() - viewGroup.getWidth();
            case 1:
                WeakHashMap weakHashMap = i0.y0.f4999a;
                int d4 = i0.h0.d(viewGroup);
                float translationX = view.getTranslationX();
                float width = viewGroup.getWidth();
                if (d4 == 1) {
                    return translationX + width;
                }
                return translationX - width;
            case 2:
                return view.getTranslationX() + viewGroup.getWidth();
            default:
                WeakHashMap weakHashMap2 = i0.y0.f4999a;
                int d5 = i0.h0.d(viewGroup);
                float translationX2 = view.getTranslationX();
                float width2 = viewGroup.getWidth();
                if (d5 == 1) {
                    return translationX2 - width2;
                }
                return translationX2 + width2;
        }
    }
}
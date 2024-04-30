package c1;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class a0 extends com.google.common.collect.c {

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f2571q;

    @Override // com.google.common.collect.c, c1.b0
    public final float h(ViewGroup viewGroup, View view) {
        switch (this.f2571q) {
            case 0:
                return view.getTranslationY() - viewGroup.getHeight();
            default:
                return view.getTranslationY() + viewGroup.getHeight();
        }
    }
}
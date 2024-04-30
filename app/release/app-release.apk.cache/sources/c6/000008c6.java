package o;

import android.view.View;
import androidx.annotation.VisibleForTesting;

/* loaded from: classes.dex */
public final class e extends j {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f5796d;

    @Override // o.j
    public final void c(View view, float f4) {
        switch (this.f5796d) {
            case 0:
                view.setAlpha(a(f4));
                return;
            case 1:
                view.setElevation(a(f4));
                return;
            case 2:
                view.setRotation(a(f4));
                return;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                view.setRotationX(a(f4));
                return;
            case VisibleForTesting.PROTECTED /* 4 */:
                view.setRotationY(a(f4));
                return;
            case VisibleForTesting.NONE /* 5 */:
                view.setScaleX(a(f4));
                return;
            case 6:
                view.setScaleY(a(f4));
                return;
            case 7:
                view.setTranslationX(a(f4));
                return;
            case 8:
                view.setTranslationY(a(f4));
                return;
            default:
                view.setTranslationZ(a(f4));
                return;
        }
    }
}
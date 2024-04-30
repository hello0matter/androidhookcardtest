package o;

import android.view.View;
import androidx.annotation.VisibleForTesting;

/* loaded from: classes.dex */
public final class a0 extends e0 {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f5790f;

    @Override // o.e0
    public final void c(View view, float f4) {
        switch (this.f5790f) {
            case 0:
                view.setAlpha(a(f4));
                return;
            case 1:
                view.setElevation(a(f4));
                return;
            case 2:
                view.setPivotX(a(f4));
                return;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                view.setPivotY(a(f4));
                return;
            case VisibleForTesting.PROTECTED /* 4 */:
                view.setRotation(a(f4));
                return;
            case VisibleForTesting.NONE /* 5 */:
                view.setRotationX(a(f4));
                return;
            case 6:
                view.setRotationY(a(f4));
                return;
            case 7:
                view.setScaleX(a(f4));
                return;
            case 8:
                view.setScaleY(a(f4));
                return;
            case 9:
                view.setTranslationX(a(f4));
                return;
            case 10:
                view.setTranslationY(a(f4));
                return;
            default:
                view.setTranslationZ(a(f4));
                return;
        }
    }
}
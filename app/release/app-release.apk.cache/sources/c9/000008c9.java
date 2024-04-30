package o;

import android.view.View;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.o0;

/* loaded from: classes.dex */
public final class f0 extends j0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f5803g;

    public /* synthetic */ f0(int i4) {
        this.f5803g = i4;
    }

    @Override // o.j0
    public final boolean b(float f4, long j4, View view, o0 o0Var) {
        switch (this.f5803g) {
            case 0:
                view.setAlpha(a(f4, j4, view, o0Var));
                return this.f5824d;
            case 1:
                view.setElevation(a(f4, j4, view, o0Var));
                return this.f5824d;
            case 2:
                view.setRotation(a(f4, j4, view, o0Var));
                return this.f5824d;
            case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                view.setRotationX(a(f4, j4, view, o0Var));
                return this.f5824d;
            case VisibleForTesting.PROTECTED /* 4 */:
                view.setRotationY(a(f4, j4, view, o0Var));
                return this.f5824d;
            case VisibleForTesting.NONE /* 5 */:
                view.setScaleX(a(f4, j4, view, o0Var));
                return this.f5824d;
            case 6:
                view.setScaleY(a(f4, j4, view, o0Var));
                return this.f5824d;
            case 7:
                view.setTranslationX(a(f4, j4, view, o0Var));
                return this.f5824d;
            case 8:
                view.setTranslationY(a(f4, j4, view, o0Var));
                return this.f5824d;
            default:
                view.setTranslationZ(a(f4, j4, view, o0Var));
                return this.f5824d;
        }
    }
}
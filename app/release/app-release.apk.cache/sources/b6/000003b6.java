package c1;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
public final class u0 extends t0 {
    @Override // c1.r0
    public final void A(View view, Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }

    @Override // c1.r0
    public final void B(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // c1.r0
    public final void C(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }

    @Override // c1.s0
    public final void D(View view, int i4, int i5, int i6, int i7) {
        view.setLeftTopRightBottom(i4, i5, i6, i7);
    }

    @Override // c1.t0, androidx.appcompat.app.o0
    public final void w(int i4, View view) {
        view.setTransitionVisibility(i4);
    }

    @Override // c1.q0
    public final float y(View view) {
        float transitionAlpha;
        transitionAlpha = view.getTransitionAlpha();
        return transitionAlpha;
    }

    @Override // c1.q0
    public final void z(View view, float f4) {
        view.setTransitionAlpha(f4);
    }
}
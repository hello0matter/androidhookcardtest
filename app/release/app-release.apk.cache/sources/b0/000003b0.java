package c1;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
public abstract class r0 extends q0 {

    /* renamed from: f  reason: collision with root package name */
    public static boolean f2677f = true;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f2678g = true;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f2679h = true;

    public void A(View view, Matrix matrix) {
        if (f2677f) {
            try {
                view.setAnimationMatrix(matrix);
            } catch (NoSuchMethodError unused) {
                f2677f = false;
            }
        }
    }

    public void B(View view, Matrix matrix) {
        if (f2678g) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f2678g = false;
            }
        }
    }

    public void C(View view, Matrix matrix) {
        if (f2679h) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f2679h = false;
            }
        }
    }
}
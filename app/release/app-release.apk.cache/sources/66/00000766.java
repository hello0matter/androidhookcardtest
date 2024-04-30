package i0;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* loaded from: classes.dex */
public final class n2 {

    /* renamed from: a  reason: collision with root package name */
    public final l2.f f4959a;

    public n2(Window window, View view) {
        i2 i2Var;
        WindowInsetsController insetsController;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 30) {
            insetsController = window.getInsetsController();
            m2 m2Var = new m2(insetsController);
            m2Var.f4958d = window;
            this.f4959a = m2Var;
            return;
        }
        if (i4 >= 26) {
            i2Var = new i2(window, view);
        } else {
            i2Var = new i2(window, view);
        }
        this.f4959a = i2Var;
    }

    public n2(WindowInsetsController windowInsetsController) {
        this.f4959a = new m2(windowInsetsController);
    }
}
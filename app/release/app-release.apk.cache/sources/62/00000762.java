package i0;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;

/* loaded from: classes.dex */
public final class m2 extends l2.f {

    /* renamed from: c  reason: collision with root package name */
    public final WindowInsetsController f4957c;

    /* renamed from: d  reason: collision with root package name */
    public Window f4958d;

    public m2(WindowInsetsController windowInsetsController) {
        super(5, 0);
        this.f4957c = windowInsetsController;
    }

    @Override // l2.f
    public final void j() {
        this.f4957c.hide(8);
    }

    @Override // l2.f
    public final void p(boolean z4) {
        Window window = this.f4958d;
        WindowInsetsController windowInsetsController = this.f4957c;
        if (z4) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
            windowInsetsController.setSystemBarsAppearance(16, 16);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-17));
        }
        windowInsetsController.setSystemBarsAppearance(0, 16);
    }

    @Override // l2.f
    public final void q(boolean z4) {
        Window window = this.f4958d;
        WindowInsetsController windowInsetsController = this.f4957c;
        if (z4) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
            }
            windowInsetsController.setSystemBarsAppearance(8, 8);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
        }
        windowInsetsController.setSystemBarsAppearance(0, 8);
    }

    @Override // l2.f
    public final void s() {
        Window window = this.f4958d;
        if (window != null && Build.VERSION.SDK_INT < 32) {
            ((InputMethodManager) window.getContext().getSystemService("input_method")).isActive();
        }
        this.f4957c.show(8);
    }
}
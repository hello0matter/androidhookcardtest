package i0;

import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

/* loaded from: classes.dex */
public abstract class i2 extends l2.f {

    /* renamed from: c  reason: collision with root package name */
    public final Window f4940c;

    /* renamed from: d  reason: collision with root package name */
    public final View f4941d;

    public i2(Window window, View view) {
        super(5, 0);
        this.f4940c = window;
        this.f4941d = view;
    }

    @Override // l2.f
    public final void j() {
        for (int i4 = 1; i4 <= 256; i4 <<= 1) {
            if ((8 & i4) != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 == 8) {
                            Window window = this.f4940c;
                            ((InputMethodManager) window.getContext().getSystemService("input_method")).hideSoftInputFromWindow(window.getDecorView().getWindowToken(), 0);
                        }
                    } else {
                        u(2);
                    }
                } else {
                    u(4);
                }
            }
        }
    }

    @Override // l2.f
    public final void s() {
        for (int i4 = 1; i4 <= 256; i4 <<= 1) {
            if ((8 & i4) != 0) {
                Window window = this.f4940c;
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 == 8) {
                            View view = this.f4941d;
                            if (!view.isInEditMode() && !view.onCheckIsTextEditor()) {
                                view = window.getCurrentFocus();
                            } else {
                                view.requestFocus();
                            }
                            if (view == null) {
                                view = window.findViewById(16908290);
                            }
                            if (view != null && view.hasWindowFocus()) {
                                view.post(new h2(0, view));
                            }
                        }
                    } else {
                        v(2);
                    }
                } else {
                    v(4);
                    window.clearFlags(1024);
                }
            }
        }
    }

    public final void u(int i4) {
        View decorView = this.f4940c.getDecorView();
        decorView.setSystemUiVisibility(i4 | decorView.getSystemUiVisibility());
    }

    public final void v(int i4) {
        View decorView = this.f4940c.getDecorView();
        decorView.setSystemUiVisibility((~i4) & decorView.getSystemUiVisibility());
    }
}
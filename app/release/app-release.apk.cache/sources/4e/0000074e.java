package i0;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.google.android.material.bottomappbar.BottomAppBar;

/* loaded from: classes.dex */
public final /* synthetic */ class h2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4938a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f4939b;

    public /* synthetic */ h2(int i4, View view) {
        this.f4938a = i4;
        this.f4939b = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f4938a;
        View view = this.f4939b;
        switch (i4) {
            case 0:
                ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
                return;
            case 1:
                int i5 = BottomAppBar.f3017u0;
                view.requestLayout();
                return;
            default:
                view.requestFocus();
                view.post(new com.google.android.material.internal.j0(view));
                return;
        }
    }
}
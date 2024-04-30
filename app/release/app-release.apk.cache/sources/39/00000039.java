package androidx.activity;

import android.view.inputmethod.InputMethodManager;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Lifecycle$Event;

@RequiresApi(19)
/* loaded from: classes.dex */
final class ImmLeaksCleaner implements androidx.lifecycle.o {

    /* renamed from: a  reason: collision with root package name */
    public static int f80a;

    @Override // androidx.lifecycle.o
    public final void b(androidx.lifecycle.q qVar, Lifecycle$Event lifecycle$Event) {
        if (lifecycle$Event != Lifecycle$Event.ON_DESTROY) {
            return;
        }
        if (f80a == 0) {
            try {
                f80a = 2;
                InputMethodManager.class.getDeclaredField("mServedView").setAccessible(true);
                InputMethodManager.class.getDeclaredField("mNextServedView").setAccessible(true);
                InputMethodManager.class.getDeclaredField("mH").setAccessible(true);
                f80a = 1;
            } catch (NoSuchFieldException unused) {
            }
        }
        if (f80a != 1) {
            return;
        }
        throw null;
    }
}
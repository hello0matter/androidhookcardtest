package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Landroidx/lifecycle/ReportFragment;", "Landroid/app/Fragment;", "<init>", "()V", "androidx/lifecycle/a0", "l2/f", "androidx/lifecycle/d0", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0})
@RestrictTo({RestrictTo.Scope.f171c})
/* loaded from: classes.dex */
public class ReportFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int f1872b = 0;

    /* renamed from: a  reason: collision with root package name */
    public a0 f1873a;

    public final void a(Lifecycle$Event lifecycle$Event) {
        if (Build.VERSION.SDK_INT < 29) {
            Activity activity = getActivity();
            com.google.common.collect.c.E(activity, "activity");
            l2.f.d(activity, lifecycle$Event);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(Lifecycle$Event.ON_CREATE);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        a(Lifecycle$Event.ON_DESTROY);
        this.f1873a = null;
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        a(Lifecycle$Event.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        a0 a0Var = this.f1873a;
        if (a0Var != null) {
            a0Var.f1880a.a();
        }
        a(Lifecycle$Event.ON_RESUME);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        a0 a0Var = this.f1873a;
        if (a0Var != null) {
            b0 b0Var = a0Var.f1880a;
            int i4 = b0Var.f1884a + 1;
            b0Var.f1884a = i4;
            if (i4 == 1 && b0Var.f1887d) {
                b0Var.f1889f.e(Lifecycle$Event.ON_START);
                b0Var.f1887d = false;
            }
        }
        a(Lifecycle$Event.ON_START);
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        a(Lifecycle$Event.ON_STOP);
    }
}
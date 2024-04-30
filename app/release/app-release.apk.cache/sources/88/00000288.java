package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.Lifecycle$Event;

/* loaded from: classes.dex */
public final class u implements z0.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f1831a;

    public u(FragmentActivity fragmentActivity) {
        this.f1831a = fragmentActivity;
    }

    @Override // z0.c
    public final Bundle a() {
        FragmentActivity fragmentActivity;
        Bundle bundle = new Bundle();
        do {
            fragmentActivity = this.f1831a;
        } while (FragmentActivity.k(((w) fragmentActivity.f1584t.f1752b).f1840t));
        fragmentActivity.f1585u.e(Lifecycle$Event.ON_STOP);
        Parcelable R = ((w) fragmentActivity.f1584t.f1752b).f1840t.R();
        if (R != null) {
            bundle.putParcelable("android:support:fragments", R);
        }
        return bundle;
    }
}
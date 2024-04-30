package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class v implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f1834a;

    public v(FragmentActivity fragmentActivity) {
        this.f1834a = fragmentActivity;
    }

    @Override // a.b
    public final void a() {
        FragmentActivity fragmentActivity = this.f1834a;
        w wVar = (w) fragmentActivity.f1584t.f1752b;
        wVar.f1840t.b(wVar, wVar, null);
        Bundle a5 = fragmentActivity.f62e.f7226b.a("android:support:fragments");
        if (a5 != null) {
            Parcelable parcelable = a5.getParcelable("android:support:fragments");
            w wVar2 = (w) fragmentActivity.f1584t.f1752b;
            if (wVar2 instanceof androidx.lifecycle.l0) {
                wVar2.f1840t.Q(parcelable);
                return;
            }
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
    }
}
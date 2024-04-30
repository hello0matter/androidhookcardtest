package c1;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class m0 {

    /* renamed from: b  reason: collision with root package name */
    public final View f2647b;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f2646a = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f2648c = new ArrayList();

    public m0(View view) {
        this.f2647b = view;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m0) {
            m0 m0Var = (m0) obj;
            if (this.f2647b == m0Var.f2647b && this.f2646a.equals(m0Var.f2646a)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return this.f2646a.hashCode() + (this.f2647b.hashCode() * 31);
    }

    public final String toString() {
        HashMap hashMap;
        String c4 = androidx.activity.j.c(("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f2647b + "\n", "    values:");
        for (String str : this.f2646a.keySet()) {
            c4 = c4 + "    " + str + ": " + hashMap.get(str) + "\n";
        }
        return c4;
    }
}
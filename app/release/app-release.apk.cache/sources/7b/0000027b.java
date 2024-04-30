package androidx.fragment.app;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class n0 extends androidx.lifecycle.h0 {

    /* renamed from: i  reason: collision with root package name */
    public static final m0 f1753i = new Object();

    /* renamed from: f  reason: collision with root package name */
    public final boolean f1757f;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap f1754c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final HashMap f1755d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final HashMap f1756e = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public boolean f1758g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1759h = false;

    public n0(boolean z4) {
        this.f1757f = z4;
    }

    @Override // androidx.lifecycle.h0
    public final void a() {
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f1758g = true;
    }

    public final void b(t tVar) {
        if (this.f1759h) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.f1754c.remove(tVar.f1805e) != null && Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + tVar);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n0.class != obj.getClass()) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return this.f1754c.equals(n0Var.f1754c) && this.f1755d.equals(n0Var.f1755d) && this.f1756e.equals(n0Var.f1756e);
    }

    public final int hashCode() {
        int hashCode = this.f1755d.hashCode();
        return this.f1756e.hashCode() + ((hashCode + (this.f1754c.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f1754c.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f1755d.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f1756e.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
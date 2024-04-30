package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import com.example.msphone.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class g1 {

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroup f1707a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f1708b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f1709c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public boolean f1710d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1711e = false;

    public g1(ViewGroup viewGroup) {
        this.f1707a = viewGroup;
    }

    public static g1 f(ViewGroup viewGroup, d0 d0Var) {
        Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof g1) {
            return (g1) tag;
        }
        d0Var.getClass();
        g1 g1Var = new g1(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, g1Var);
        return g1Var;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, e0.c] */
    public final void a(SpecialEffectsController$Operation$State specialEffectsController$Operation$State, SpecialEffectsController$Operation$LifecycleImpact specialEffectsController$Operation$LifecycleImpact, p0 p0Var) {
        synchronized (this.f1708b) {
            try {
                ?? obj = new Object();
                f1 d4 = d(p0Var.f1771c);
                if (d4 != null) {
                    d4.c(specialEffectsController$Operation$State, specialEffectsController$Operation$LifecycleImpact);
                    return;
                }
                f1 f1Var = new f1(specialEffectsController$Operation$State, specialEffectsController$Operation$LifecycleImpact, p0Var, obj);
                this.f1708b.add(f1Var);
                f1Var.f1698d.add(new e1(this, f1Var, 0));
                f1Var.f1698d.add(new e1(this, f1Var, 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void b(ArrayList arrayList, boolean z4);

    public final void c() {
        if (this.f1711e) {
            return;
        }
        ViewGroup viewGroup = this.f1707a;
        WeakHashMap weakHashMap = i0.y0.f4999a;
        if (!i0.j0.b(viewGroup)) {
            e();
            this.f1710d = false;
            return;
        }
        synchronized (this.f1708b) {
            try {
                if (!this.f1708b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.f1709c);
                    this.f1709c.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        f1 f1Var = (f1) it.next();
                        if (Log.isLoggable("FragmentManager", 2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + f1Var);
                        }
                        f1Var.a();
                        if (!f1Var.f1701g) {
                            this.f1709c.add(f1Var);
                        }
                    }
                    h();
                    ArrayList arrayList2 = new ArrayList(this.f1708b);
                    this.f1708b.clear();
                    this.f1709c.addAll(arrayList2);
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((f1) it2.next()).d();
                    }
                    b(arrayList2, this.f1710d);
                    this.f1710d = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final f1 d(t tVar) {
        Iterator it = this.f1708b.iterator();
        while (it.hasNext()) {
            f1 f1Var = (f1) it.next();
            if (f1Var.f1697c.equals(tVar) && !f1Var.f1700f) {
                return f1Var;
            }
        }
        return null;
    }

    public final void e() {
        String str;
        String str2;
        ViewGroup viewGroup = this.f1707a;
        WeakHashMap weakHashMap = i0.y0.f4999a;
        boolean b5 = i0.j0.b(viewGroup);
        synchronized (this.f1708b) {
            try {
                h();
                Iterator it = this.f1708b.iterator();
                while (it.hasNext()) {
                    ((f1) it.next()).d();
                }
                Iterator it2 = new ArrayList(this.f1709c).iterator();
                while (it2.hasNext()) {
                    f1 f1Var = (f1) it2.next();
                    if (Log.isLoggable("FragmentManager", 2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: ");
                        if (b5) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.f1707a + " is not attached to window. ";
                        }
                        sb.append(str2);
                        sb.append("Cancelling running operation ");
                        sb.append(f1Var);
                        Log.v("FragmentManager", sb.toString());
                    }
                    f1Var.a();
                }
                Iterator it3 = new ArrayList(this.f1708b).iterator();
                while (it3.hasNext()) {
                    f1 f1Var2 = (f1) it3.next();
                    if (Log.isLoggable("FragmentManager", 2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        if (b5) {
                            str = "";
                        } else {
                            str = "Container " + this.f1707a + " is not attached to window. ";
                        }
                        sb2.append(str);
                        sb2.append("Cancelling pending operation ");
                        sb2.append(f1Var2);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    f1Var2.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g() {
        synchronized (this.f1708b) {
            try {
                h();
                this.f1711e = false;
                int size = this.f1708b.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    f1 f1Var = (f1) this.f1708b.get(size);
                    SpecialEffectsController$Operation$State c4 = SpecialEffectsController$Operation$State.c(f1Var.f1697c.E);
                    SpecialEffectsController$Operation$State specialEffectsController$Operation$State = f1Var.f1695a;
                    SpecialEffectsController$Operation$State specialEffectsController$Operation$State2 = SpecialEffectsController$Operation$State.f1627b;
                    if (specialEffectsController$Operation$State == specialEffectsController$Operation$State2 && c4 != specialEffectsController$Operation$State2) {
                        f1Var.f1697c.getClass();
                        this.f1711e = false;
                        break;
                    }
                    size--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h() {
        Iterator it = this.f1708b.iterator();
        while (it.hasNext()) {
            f1 f1Var = (f1) it.next();
            if (f1Var.f1696b == SpecialEffectsController$Operation$LifecycleImpact.f1623b) {
                f1Var.c(SpecialEffectsController$Operation$State.b(f1Var.f1697c.D().getVisibility()), SpecialEffectsController$Operation$LifecycleImpact.f1622a);
            }
        }
    }
}
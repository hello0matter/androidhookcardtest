package androidx.savedstate;

import android.os.Bundle;
import androidx.activity.j;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.SavedStateHandleController;
import androidx.lifecycle.h0;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import com.google.common.collect.c;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import z0.b;
import z0.d;
import z0.f;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Landroidx/savedstate/Recreator;", "Landroidx/lifecycle/o;", "l2/f", "androidx/appcompat/app/k", "savedstate_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class Recreator implements o {

    /* renamed from: a  reason: collision with root package name */
    public final f f2333a;

    public Recreator(f fVar) {
        c.F(fVar, "owner");
        this.f2333a = fVar;
    }

    @Override // androidx.lifecycle.o
    public final void b(q qVar, Lifecycle$Event lifecycle$Event) {
        Object obj;
        boolean z4;
        if (lifecycle$Event == Lifecycle$Event.ON_CREATE) {
            qVar.f().b(this);
            Bundle a5 = this.f2333a.b().a("androidx.savedstate.Restarter");
            if (a5 == null) {
                return;
            }
            ArrayList<String> stringArrayList = a5.getStringArrayList("classes_to_restore");
            if (stringArrayList != null) {
                for (String str : stringArrayList) {
                    try {
                        Class<? extends U> asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(b.class);
                        c.E(asSubclass, "{\n                Class.…class.java)\n            }");
                        try {
                            Constructor declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                            declaredConstructor.setAccessible(true);
                            try {
                                Object newInstance = declaredConstructor.newInstance(new Object[0]);
                                c.E(newInstance, "{\n                constr…wInstance()\n            }");
                                b bVar = (b) newInstance;
                                f fVar = this.f2333a;
                                c.F(fVar, "owner");
                                if (fVar instanceof l0) {
                                    k0 e4 = ((l0) fVar).e();
                                    d b5 = fVar.b();
                                    e4.getClass();
                                    Iterator it = new HashSet(e4.f1909a.keySet()).iterator();
                                    while (it.hasNext()) {
                                        String str2 = (String) it.next();
                                        c.F(str2, "key");
                                        h0 h0Var = (h0) e4.f1909a.get(str2);
                                        c.C(h0Var);
                                        s f4 = fVar.f();
                                        c.F(b5, "registry");
                                        c.F(f4, "lifecycle");
                                        HashMap hashMap = h0Var.f1904a;
                                        if (hashMap == null) {
                                            obj = null;
                                        } else {
                                            synchronized (hashMap) {
                                                obj = h0Var.f1904a.get("androidx.lifecycle.savedstate.vm.tag");
                                            }
                                        }
                                        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) obj;
                                        if (savedStateHandleController != null && !(z4 = savedStateHandleController.f1875a)) {
                                            if (!(!z4)) {
                                                throw new IllegalStateException("Already attached to lifecycleOwner".toString());
                                            }
                                            savedStateHandleController.f1875a = true;
                                            f4.a(savedStateHandleController);
                                            throw null;
                                        }
                                    }
                                    if (!new HashSet(e4.f1909a.keySet()).isEmpty()) {
                                        b5.c();
                                    }
                                } else {
                                    throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
                                }
                            } catch (Exception e5) {
                                throw new RuntimeException("Failed to instantiate " + str, e5);
                            }
                        } catch (NoSuchMethodException e6) {
                            throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e6);
                        }
                    } catch (ClassNotFoundException e7) {
                        throw new RuntimeException(j.d("Class ", str, " wasn't found"), e7);
                    }
                }
                return;
            }
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }
}
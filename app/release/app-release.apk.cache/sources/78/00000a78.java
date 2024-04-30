package z0;

import android.os.Bundle;
import androidx.appcompat.app.k;
import androidx.lifecycle.i;
import i.g;
import java.util.Set;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: b  reason: collision with root package name */
    public boolean f7220b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f7221c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7222d;

    /* renamed from: e  reason: collision with root package name */
    public k f7223e;

    /* renamed from: a  reason: collision with root package name */
    public final g f7219a = new g();

    /* renamed from: f  reason: collision with root package name */
    public boolean f7224f = true;

    public final Bundle a(String str) {
        if (this.f7222d) {
            Bundle bundle = this.f7221c;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            Bundle bundle3 = this.f7221c;
            if (bundle3 != null) {
                bundle3.remove(str);
            }
            Bundle bundle4 = this.f7221c;
            if (bundle4 == null || bundle4.isEmpty()) {
                this.f7221c = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
    }

    public final void b(String str, c cVar) {
        Object obj;
        com.google.common.collect.c.F(cVar, "provider");
        g gVar = this.f7219a;
        i.c a5 = gVar.a(str);
        if (a5 != null) {
            obj = a5.f4894b;
        } else {
            i.c cVar2 = new i.c(str, cVar);
            gVar.f4905d++;
            i.c cVar3 = gVar.f4903b;
            if (cVar3 == null) {
                gVar.f4902a = cVar2;
            } else {
                cVar3.f4895c = cVar2;
                cVar2.f4896d = cVar3;
            }
            gVar.f4903b = cVar2;
            obj = null;
        }
        if (((c) obj) == null) {
            return;
        }
        throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
    }

    public final void c() {
        if (this.f7224f) {
            k kVar = this.f7223e;
            if (kVar == null) {
                kVar = new k(this);
            }
            this.f7223e = kVar;
            try {
                i.class.getDeclaredConstructor(new Class[0]);
                k kVar2 = this.f7223e;
                if (kVar2 != null) {
                    ((Set) kVar2.f297b).add(i.class.getName());
                    return;
                }
                return;
            } catch (NoSuchMethodException e4) {
                throw new IllegalArgumentException("Class " + i.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e4);
            }
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
    }
}
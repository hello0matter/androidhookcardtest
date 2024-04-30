package androidx.appcompat.widget;

import android.view.MenuItem;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class s3 implements q, g.n {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Toolbar f896a;

    public /* synthetic */ s3(Toolbar toolbar) {
        this.f896a = toolbar;
    }

    @Override // g.n
    public final void b(g.p pVar) {
        Toolbar toolbar = this.f896a;
        n nVar = toolbar.f655a.f458t;
        if (nVar == null || !nVar.k()) {
            Iterator it = ((CopyOnWriteArrayList) toolbar.G.f193b).iterator();
            if (it.hasNext()) {
                androidx.activity.j.f(it.next());
                throw null;
            }
        }
        g.n nVar2 = toolbar.N;
        if (nVar2 != null) {
            nVar2.b(pVar);
        }
    }

    @Override // g.n
    public final boolean p(g.p pVar, MenuItem menuItem) {
        g.n nVar = this.f896a.N;
        if (nVar != null && nVar.p(pVar, menuItem)) {
            return true;
        }
        return false;
    }
}
package f;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import g.g0;
import g.x;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class h implements b {

    /* renamed from: a  reason: collision with root package name */
    public final ActionMode.Callback f4458a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f4459b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f4460c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final l.k f4461d = new l.k();

    public h(Context context, ActionMode.Callback callback) {
        this.f4459b = context;
        this.f4458a = callback;
    }

    @Override // f.b
    public final boolean a(c cVar, MenuItem menuItem) {
        return this.f4458a.onActionItemClicked(e(cVar), new x(this.f4459b, (d0.b) menuItem));
    }

    @Override // f.b
    public final boolean b(c cVar, g.p pVar) {
        i e4 = e(cVar);
        l.k kVar = this.f4461d;
        Menu menu = (Menu) kVar.getOrDefault(pVar, null);
        if (menu == null) {
            menu = new g0(this.f4459b, pVar);
            kVar.put(pVar, menu);
        }
        return this.f4458a.onCreateActionMode(e4, menu);
    }

    @Override // f.b
    public final void c(c cVar) {
        this.f4458a.onDestroyActionMode(e(cVar));
    }

    @Override // f.b
    public final boolean d(c cVar, g.p pVar) {
        i e4 = e(cVar);
        l.k kVar = this.f4461d;
        Menu menu = (Menu) kVar.getOrDefault(pVar, null);
        if (menu == null) {
            menu = new g0(this.f4459b, pVar);
            kVar.put(pVar, menu);
        }
        return this.f4458a.onPrepareActionMode(e4, menu);
    }

    public final i e(c cVar) {
        ArrayList arrayList = this.f4460c;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            i iVar = (i) arrayList.get(i4);
            if (iVar != null && iVar.f4463b == cVar) {
                return iVar;
            }
        }
        i iVar2 = new i(this.f4459b, cVar);
        arrayList.add(iVar2);
        return iVar2;
    }
}
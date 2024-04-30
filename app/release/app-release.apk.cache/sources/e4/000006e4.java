package g;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import androidx.appcompat.view.menu.ExpandedMenuView;

/* loaded from: classes.dex */
public final class l implements d0, AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f4682a;

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f4683b;

    /* renamed from: c  reason: collision with root package name */
    public p f4684c;

    /* renamed from: d  reason: collision with root package name */
    public ExpandedMenuView f4685d;

    /* renamed from: e  reason: collision with root package name */
    public c0 f4686e;

    /* renamed from: f  reason: collision with root package name */
    public k f4687f;

    public l(Context context) {
        this.f4682a = context;
        this.f4683b = LayoutInflater.from(context);
    }

    @Override // g.d0
    public final void a(p pVar, boolean z4) {
        c0 c0Var = this.f4686e;
        if (c0Var != null) {
            c0Var.a(pVar, z4);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.content.DialogInterface$OnClickListener, android.content.DialogInterface$OnKeyListener, java.lang.Object, g.q, g.c0, android.content.DialogInterface$OnDismissListener] */
    @Override // g.d0
    public final boolean c(j0 j0Var) {
        if (!j0Var.hasVisibleItems()) {
            return false;
        }
        ?? obj = new Object();
        obj.f4719a = j0Var;
        Context context = j0Var.f4695a;
        androidx.appcompat.app.i iVar = new androidx.appcompat.app.i(context);
        androidx.appcompat.app.e eVar = iVar.f281a;
        l lVar = new l(eVar.f199a);
        obj.f4721c = lVar;
        lVar.f4686e = obj;
        j0Var.b(lVar, context);
        l lVar2 = obj.f4721c;
        if (lVar2.f4687f == null) {
            lVar2.f4687f = new k(lVar2);
        }
        eVar.f205g = lVar2.f4687f;
        eVar.f206h = obj;
        View view = j0Var.f4709o;
        if (view != null) {
            eVar.f203e = view;
        } else {
            eVar.f201c = j0Var.f4708n;
            eVar.f202d = j0Var.f4707m;
        }
        eVar.f204f = obj;
        androidx.appcompat.app.j a5 = iVar.a();
        obj.f4720b = a5;
        a5.setOnDismissListener(obj);
        WindowManager.LayoutParams attributes = obj.f4720b.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        obj.f4720b.show();
        c0 c0Var = this.f4686e;
        if (c0Var != null) {
            c0Var.f(j0Var);
            return true;
        }
        return true;
    }

    @Override // g.d0
    public final void d(c0 c0Var) {
        this.f4686e = c0Var;
    }

    @Override // g.d0
    public final boolean e() {
        return false;
    }

    @Override // g.d0
    public final Parcelable g() {
        if (this.f4685d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f4685d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    @Override // g.d0
    public final int getId() {
        return 0;
    }

    @Override // g.d0
    public final boolean h(r rVar) {
        return false;
    }

    @Override // g.d0
    public final void i(Parcelable parcelable) {
        SparseArray<Parcelable> sparseParcelableArray = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f4685d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // g.d0
    public final boolean j(r rVar) {
        return false;
    }

    @Override // g.d0
    public final void l(Context context, p pVar) {
        if (this.f4682a != null) {
            this.f4682a = context;
            if (this.f4683b == null) {
                this.f4683b = LayoutInflater.from(context);
            }
        }
        this.f4684c = pVar;
        k kVar = this.f4687f;
        if (kVar != null) {
            kVar.notifyDataSetChanged();
        }
    }

    @Override // g.d0
    public final void m(boolean z4) {
        k kVar = this.f4687f;
        if (kVar != null) {
            kVar.notifyDataSetChanged();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
        this.f4684c.q(this.f4687f.getItem(i4), this, 0);
    }
}
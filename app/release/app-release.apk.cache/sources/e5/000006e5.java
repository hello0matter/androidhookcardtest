package g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class m extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final p f4688a;

    /* renamed from: b  reason: collision with root package name */
    public int f4689b = -1;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4690c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f4691d;

    /* renamed from: e  reason: collision with root package name */
    public final LayoutInflater f4692e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4693f;

    public m(p pVar, LayoutInflater layoutInflater, boolean z4, int i4) {
        this.f4691d = z4;
        this.f4692e = layoutInflater;
        this.f4688a = pVar;
        this.f4693f = i4;
        a();
    }

    public final void a() {
        p pVar = this.f4688a;
        r rVar = pVar.f4716v;
        if (rVar != null) {
            pVar.i();
            ArrayList arrayList = pVar.f4704j;
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (((r) arrayList.get(i4)) == rVar) {
                    this.f4689b = i4;
                    return;
                }
            }
        }
        this.f4689b = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b */
    public final r getItem(int i4) {
        ArrayList l4;
        boolean z4 = this.f4691d;
        p pVar = this.f4688a;
        if (z4) {
            pVar.i();
            l4 = pVar.f4704j;
        } else {
            l4 = pVar.l();
        }
        int i5 = this.f4689b;
        if (i5 >= 0 && i4 >= i5) {
            i4++;
        }
        return (r) l4.get(i4);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList l4;
        boolean z4 = this.f4691d;
        p pVar = this.f4688a;
        if (z4) {
            pVar.i();
            l4 = pVar.f4704j;
        } else {
            l4 = pVar.l();
        }
        int i4 = this.f4689b;
        int size = l4.size();
        if (i4 < 0) {
            return size;
        }
        return size - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i4) {
        return i4;
    }

    @Override // android.widget.Adapter
    public final View getView(int i4, View view, ViewGroup viewGroup) {
        int i5;
        boolean z4 = false;
        if (view == null) {
            view = this.f4692e.inflate(this.f4693f, viewGroup, false);
        }
        int i6 = getItem(i4).f4723b;
        int i7 = i4 - 1;
        if (i7 >= 0) {
            i5 = getItem(i7).f4723b;
        } else {
            i5 = i6;
        }
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f4688a.m() && i6 != i5) {
            z4 = true;
        }
        listMenuItemView.setGroupDividerEnabled(z4);
        e0 e0Var = (e0) view;
        if (this.f4690c) {
            listMenuItemView.setForceShowIcon(true);
        }
        e0Var.c(getItem(i4));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
package g;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.example.msphone.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class k extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public int f4680a = -1;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f4681b;

    public k(l lVar) {
        this.f4681b = lVar;
        a();
    }

    public final void a() {
        p pVar = this.f4681b.f4684c;
        r rVar = pVar.f4716v;
        if (rVar != null) {
            pVar.i();
            ArrayList arrayList = pVar.f4704j;
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (((r) arrayList.get(i4)) == rVar) {
                    this.f4680a = i4;
                    return;
                }
            }
        }
        this.f4680a = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b */
    public final r getItem(int i4) {
        l lVar = this.f4681b;
        p pVar = lVar.f4684c;
        pVar.i();
        ArrayList arrayList = pVar.f4704j;
        lVar.getClass();
        int i5 = this.f4680a;
        if (i5 >= 0 && i4 >= i5) {
            i4++;
        }
        return (r) arrayList.get(i4);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        l lVar = this.f4681b;
        p pVar = lVar.f4684c;
        pVar.i();
        int size = pVar.f4704j.size();
        lVar.getClass();
        if (this.f4680a < 0) {
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
        if (view == null) {
            view = this.f4681b.f4683b.inflate(R.layout.abc_list_menu_item_layout, viewGroup, false);
        }
        ((e0) view).c(getItem(i4));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
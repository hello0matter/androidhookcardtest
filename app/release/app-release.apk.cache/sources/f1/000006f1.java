package g;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
public abstract class y implements h0, d0, AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public Rect f4758a;

    public static int o(m mVar, Context context, int i4) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = mVar.getCount();
        int i5 = 0;
        int i6 = 0;
        FrameLayout frameLayout = null;
        View view = null;
        for (int i7 = 0; i7 < count; i7++) {
            int itemViewType = mVar.getItemViewType(i7);
            if (itemViewType != i6) {
                view = null;
                i6 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = mVar.getView(i7, view, frameLayout);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i4) {
                return i4;
            }
            if (measuredWidth > i5) {
                i5 = measuredWidth;
            }
        }
        return i5;
    }

    public static boolean w(p pVar) {
        int size = pVar.f4700f.size();
        for (int i4 = 0; i4 < size; i4++) {
            MenuItem item = pVar.getItem(i4);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
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
    public final boolean j(r rVar) {
        return false;
    }

    public abstract void n(p pVar);

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
        m mVar;
        int i5;
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        if (listAdapter instanceof HeaderViewListAdapter) {
            mVar = (m) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        } else {
            mVar = (m) listAdapter;
        }
        p pVar = mVar.f4688a;
        MenuItem menuItem = (MenuItem) listAdapter.getItem(i4);
        if (!(this instanceof j)) {
            i5 = 0;
        } else {
            i5 = 4;
        }
        pVar.q(menuItem, this, i5);
    }

    public abstract void p(View view);

    public abstract void q(boolean z4);

    public abstract void r(int i4);

    public abstract void s(int i4);

    public abstract void t(PopupWindow.OnDismissListener onDismissListener);

    public abstract void u(boolean z4);

    public abstract void v(int i4);

    @Override // g.d0
    public final void l(Context context, p pVar) {
    }
}
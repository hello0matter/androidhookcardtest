package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/* loaded from: classes.dex */
public final class p2 extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScrollingTabContainerView f872a;

    public p2(ScrollingTabContainerView scrollingTabContainerView) {
        this.f872a = scrollingTabContainerView;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f872a.f599b.getChildCount();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i4) {
        ((q2) this.f872a.f599b.getChildAt(i4)).getClass();
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i4) {
        return i4;
    }

    @Override // android.widget.Adapter
    public final View getView(int i4, View view, ViewGroup viewGroup) {
        if (view == null) {
            getItem(i4);
            ScrollingTabContainerView scrollingTabContainerView = this.f872a;
            scrollingTabContainerView.getClass();
            new q2(scrollingTabContainerView, scrollingTabContainerView.getContext());
            throw null;
        }
        q2 q2Var = (q2) view;
        getItem(i4);
        throw null;
    }
}
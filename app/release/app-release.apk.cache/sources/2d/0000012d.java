package androidx.appcompat.widget;

import android.os.Handler;
import android.widget.AbsListView;

/* loaded from: classes.dex */
public final class d2 implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ListPopupWindow f735a;

    public d2(ListPopupWindow listPopupWindow) {
        this.f735a = listPopupWindow;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i4, int i5, int i6) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i4) {
        if (i4 == 1) {
            ListPopupWindow listPopupWindow = this.f735a;
            if (listPopupWindow.f593z.getInputMethodMode() != 2 && listPopupWindow.f593z.getContentView() != null) {
                Handler handler = listPopupWindow.f589v;
                y1 y1Var = listPopupWindow.f585r;
                handler.removeCallbacks(y1Var);
                y1Var.run();
            }
        }
    }
}
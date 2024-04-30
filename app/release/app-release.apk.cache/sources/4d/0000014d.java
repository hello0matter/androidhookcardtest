package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class j2 extends ListPopupWindow implements f2 {
    public static final Method D;
    public f2 C;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                D = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.appcompat.widget.u1, androidx.appcompat.widget.MenuPopupWindow$MenuDropDownListView] */
    @Override // androidx.appcompat.widget.ListPopupWindow
    public final u1 a(final Context context, final boolean z4) {
        ?? r02 = new u1(context, z4) { // from class: androidx.appcompat.widget.MenuPopupWindow$MenuDropDownListView

            /* renamed from: m  reason: collision with root package name */
            public final int f594m;

            /* renamed from: n  reason: collision with root package name */
            public final int f595n;

            /* renamed from: o  reason: collision with root package name */
            public f2 f596o;

            /* renamed from: p  reason: collision with root package name */
            public g.r f597p;

            {
                super(context, z4);
                if (1 == i2.a(context.getResources().getConfiguration())) {
                    this.f594m = 21;
                    this.f595n = 22;
                    return;
                }
                this.f594m = 22;
                this.f595n = 21;
            }

            @Override // androidx.appcompat.widget.u1, android.view.View
            public final boolean onHoverEvent(MotionEvent motionEvent) {
                g.m mVar;
                int i4;
                g.r rVar;
                int pointToPosition;
                int i5;
                if (this.f596o != null) {
                    ListAdapter adapter = getAdapter();
                    if (adapter instanceof HeaderViewListAdapter) {
                        HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                        i4 = headerViewListAdapter.getHeadersCount();
                        mVar = (g.m) headerViewListAdapter.getWrappedAdapter();
                    } else {
                        mVar = (g.m) adapter;
                        i4 = 0;
                    }
                    if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i5 = pointToPosition - i4) >= 0 && i5 < mVar.getCount()) {
                        rVar = mVar.b(i5);
                    } else {
                        rVar = null;
                    }
                    g.r rVar2 = this.f597p;
                    if (rVar2 != rVar) {
                        g.p pVar = mVar.f4688a;
                        if (rVar2 != null) {
                            this.f596o.r(pVar, rVar2);
                        }
                        this.f597p = rVar;
                        if (rVar != null) {
                            this.f596o.m(pVar, rVar);
                        }
                    }
                }
                return super.onHoverEvent(motionEvent);
            }

            @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
            public final boolean onKeyDown(int i4, KeyEvent keyEvent) {
                ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
                if (listMenuItemView != null && i4 == this.f594m) {
                    if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                        performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                    }
                    return true;
                } else if (listMenuItemView != null && i4 == this.f595n) {
                    setSelection(-1);
                    ListAdapter adapter = getAdapter();
                    if (adapter instanceof HeaderViewListAdapter) {
                        adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                    }
                    ((g.m) adapter).f4688a.c(false);
                    return true;
                } else {
                    return super.onKeyDown(i4, keyEvent);
                }
            }

            public void setHoverListener(f2 f2Var) {
                this.f596o = f2Var;
            }

            @Override // androidx.appcompat.widget.u1, android.widget.AbsListView
            public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
                super.setSelector(drawable);
            }
        };
        r02.setHoverListener(this);
        return r02;
    }

    @Override // androidx.appcompat.widget.f2
    public final void m(g.p pVar, g.r rVar) {
        f2 f2Var = this.C;
        if (f2Var != null) {
            f2Var.m(pVar, rVar);
        }
    }

    @Override // androidx.appcompat.widget.f2
    public final void r(g.p pVar, MenuItem menuItem) {
        f2 f2Var = this.C;
        if (f2Var != null) {
            f2Var.r(pVar, menuItem);
        }
    }
}
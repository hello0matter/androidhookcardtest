package androidx.appcompat.widget;

import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class y1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f985a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ListPopupWindow f986b;

    public /* synthetic */ y1(ListPopupWindow listPopupWindow, int i4) {
        this.f985a = i4;
        this.f986b = listPopupWindow;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f985a;
        ListPopupWindow listPopupWindow = this.f986b;
        switch (i4) {
            case 1:
                u1 u1Var = listPopupWindow.f570c;
                if (u1Var != null) {
                    u1Var.setListSelectionHidden(true);
                    u1Var.requestLayout();
                    return;
                }
                return;
            default:
                u1 u1Var2 = listPopupWindow.f570c;
                if (u1Var2 != null) {
                    WeakHashMap weakHashMap = i0.y0.f4999a;
                    if (i0.j0.b(u1Var2) && listPopupWindow.f570c.getCount() > listPopupWindow.f570c.getChildCount() && listPopupWindow.f570c.getChildCount() <= listPopupWindow.f580m) {
                        listPopupWindow.f593z.setInputMethodMode(2);
                        listPopupWindow.f();
                        return;
                    }
                    return;
                }
                return;
        }
    }
}
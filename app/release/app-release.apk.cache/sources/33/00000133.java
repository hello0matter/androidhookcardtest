package androidx.appcompat.widget;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
public final class e2 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f741a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f742b;

    public /* synthetic */ e2(int i4, Object obj) {
        this.f741a = i4;
        this.f742b = obj;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        ListPopupWindow listPopupWindow;
        PopupWindow popupWindow;
        switch (this.f741a) {
            case 0:
                int action = motionEvent.getAction();
                int x4 = (int) motionEvent.getX();
                int y4 = (int) motionEvent.getY();
                Object obj = this.f742b;
                if (action == 0 && (popupWindow = (listPopupWindow = (ListPopupWindow) obj).f593z) != null && popupWindow.isShowing() && x4 >= 0 && x4 < listPopupWindow.f593z.getWidth() && y4 >= 0 && y4 < listPopupWindow.f593z.getHeight()) {
                    listPopupWindow.f589v.postDelayed(listPopupWindow.f585r, 250L);
                } else if (action == 1) {
                    ListPopupWindow listPopupWindow2 = (ListPopupWindow) obj;
                    listPopupWindow2.f589v.removeCallbacks(listPopupWindow2.f585r);
                }
                return false;
            default:
                return false;
        }
    }
}
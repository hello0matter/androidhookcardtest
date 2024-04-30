package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
public final class o0 extends ListPopupWindow implements q0 {
    public CharSequence C;
    public ListAdapter D;
    public final Rect E;
    public int F;
    public final /* synthetic */ AppCompatSpinner G;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(AppCompatSpinner appCompatSpinner, Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.G = appCompatSpinner;
        this.E = new Rect();
        this.f582o = appCompatSpinner;
        this.f592y = true;
        this.f593z.setFocusable(true);
        this.f583p = new androidx.appcompat.app.d(1, this, appCompatSpinner);
    }

    @Override // androidx.appcompat.widget.q0
    public final void e(int i4, int i5) {
        ViewTreeObserver viewTreeObserver;
        PopupWindow popupWindow = this.f593z;
        boolean isShowing = popupWindow.isShowing();
        s();
        this.f593z.setInputMethodMode(2);
        f();
        u1 u1Var = this.f570c;
        u1Var.setChoiceMode(1);
        j0.d(u1Var, i4);
        j0.c(u1Var, i5);
        AppCompatSpinner appCompatSpinner = this.G;
        int selectedItemPosition = appCompatSpinner.getSelectedItemPosition();
        u1 u1Var2 = this.f570c;
        if (popupWindow.isShowing() && u1Var2 != null) {
            u1Var2.setListSelectionHidden(false);
            u1Var2.setSelection(selectedItemPosition);
            if (u1Var2.getChoiceMode() != 0) {
                u1Var2.setItemChecked(selectedItemPosition, true);
            }
        }
        if (!isShowing && (viewTreeObserver = appCompatSpinner.getViewTreeObserver()) != null) {
            g.f fVar = new g.f(4, this);
            viewTreeObserver.addOnGlobalLayoutListener(fVar);
            this.f593z.setOnDismissListener(new n0(this, fVar));
        }
    }

    @Override // androidx.appcompat.widget.q0
    public final CharSequence i() {
        return this.C;
    }

    @Override // androidx.appcompat.widget.q0
    public final void j(CharSequence charSequence) {
        this.C = charSequence;
    }

    @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.q0
    public final void o(ListAdapter listAdapter) {
        super.o(listAdapter);
        this.D = listAdapter;
    }

    @Override // androidx.appcompat.widget.q0
    public final void p(int i4) {
        this.F = i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void s() {
        /*
            r9 = this;
            android.widget.PopupWindow r0 = r9.f593z
            android.graphics.drawable.Drawable r1 = r0.getBackground()
            androidx.appcompat.widget.AppCompatSpinner r2 = r9.G
            if (r1 == 0) goto L20
            android.graphics.Rect r3 = r2.f528h
            r1.getPadding(r3)
            boolean r1 = androidx.appcompat.widget.e4.a(r2)
            if (r1 == 0) goto L1a
            android.graphics.Rect r1 = r2.f528h
            int r1 = r1.right
            goto L28
        L1a:
            android.graphics.Rect r1 = r2.f528h
            int r1 = r1.left
            int r1 = -r1
            goto L28
        L20:
            android.graphics.Rect r1 = r2.f528h
            r3 = 0
            r1.right = r3
            r1.left = r3
            r1 = r3
        L28:
            int r3 = r2.getPaddingLeft()
            int r4 = r2.getPaddingRight()
            int r5 = r2.getWidth()
            int r6 = r2.f527g
            r7 = -2
            if (r6 != r7) goto L69
            android.widget.ListAdapter r6 = r9.D
            android.widget.SpinnerAdapter r6 = (android.widget.SpinnerAdapter) r6
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            int r0 = r2.a(r6, r0)
            android.content.Context r6 = r2.getContext()
            android.content.res.Resources r6 = r6.getResources()
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
            int r6 = r6.widthPixels
            android.graphics.Rect r7 = r2.f528h
            int r8 = r7.left
            int r6 = r6 - r8
            int r7 = r7.right
            int r6 = r6 - r7
            if (r0 <= r6) goto L5e
            r0 = r6
        L5e:
            int r6 = r5 - r3
            int r6 = r6 - r4
            int r0 = java.lang.Math.max(r0, r6)
        L65:
            r9.q(r0)
            goto L73
        L69:
            r0 = -1
            if (r6 != r0) goto L70
            int r0 = r5 - r3
            int r0 = r0 - r4
            goto L65
        L70:
            r9.q(r6)
        L73:
            boolean r0 = androidx.appcompat.widget.e4.a(r2)
            if (r0 == 0) goto L82
            int r5 = r5 - r4
            int r0 = r9.f572e
            int r5 = r5 - r0
            int r0 = r9.F
            int r5 = r5 - r0
            int r5 = r5 + r1
            goto L87
        L82:
            int r0 = r9.F
            int r3 = r3 + r0
            int r5 = r3 + r1
        L87:
            r9.f573f = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.o0.s():void");
    }
}
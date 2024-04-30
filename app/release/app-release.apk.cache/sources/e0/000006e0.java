package g;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.j2;
import androidx.appcompat.widget.u1;
import com.example.msphone.R;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class i0 extends y implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* renamed from: b  reason: collision with root package name */
    public final Context f4634b;

    /* renamed from: c  reason: collision with root package name */
    public final p f4635c;

    /* renamed from: d  reason: collision with root package name */
    public final m f4636d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f4637e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4638f;

    /* renamed from: g  reason: collision with root package name */
    public final int f4639g;

    /* renamed from: h  reason: collision with root package name */
    public final int f4640h;

    /* renamed from: i  reason: collision with root package name */
    public final j2 f4641i;

    /* renamed from: l  reason: collision with root package name */
    public PopupWindow.OnDismissListener f4644l;

    /* renamed from: m  reason: collision with root package name */
    public View f4645m;

    /* renamed from: n  reason: collision with root package name */
    public View f4646n;

    /* renamed from: o  reason: collision with root package name */
    public c0 f4647o;

    /* renamed from: p  reason: collision with root package name */
    public ViewTreeObserver f4648p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f4649q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f4650r;

    /* renamed from: s  reason: collision with root package name */
    public int f4651s;

    /* renamed from: u  reason: collision with root package name */
    public boolean f4653u;

    /* renamed from: j  reason: collision with root package name */
    public final f f4642j = new f(1, this);

    /* renamed from: k  reason: collision with root package name */
    public final g f4643k = new g(1, this);

    /* renamed from: t  reason: collision with root package name */
    public int f4652t = 0;

    /* JADX WARN: Type inference failed for: r7v1, types: [androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.j2] */
    public i0(int i4, int i5, Context context, View view, p pVar, boolean z4) {
        this.f4634b = context;
        this.f4635c = pVar;
        this.f4637e = z4;
        this.f4636d = new m(pVar, LayoutInflater.from(context), z4, R.layout.abc_popup_menu_item_layout);
        this.f4639g = i4;
        this.f4640h = i5;
        Resources resources = context.getResources();
        this.f4638f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f4645m = view;
        this.f4641i = new ListPopupWindow(context, null, i4, i5);
        pVar.b(this, context);
    }

    @Override // g.d0
    public final void a(p pVar, boolean z4) {
        if (pVar != this.f4635c) {
            return;
        }
        dismiss();
        c0 c0Var = this.f4647o;
        if (c0Var != null) {
            c0Var.a(pVar, z4);
        }
    }

    @Override // g.h0
    public final boolean b() {
        if (!this.f4649q && this.f4641i.f593z.isShowing()) {
            return true;
        }
        return false;
    }

    @Override // g.d0
    public final boolean c(j0 j0Var) {
        if (j0Var.hasVisibleItems()) {
            View view = this.f4646n;
            b0 b0Var = new b0(this.f4639g, this.f4640h, this.f4634b, view, j0Var, this.f4637e);
            c0 c0Var = this.f4647o;
            b0Var.f4605i = c0Var;
            y yVar = b0Var.f4606j;
            if (yVar != null) {
                yVar.d(c0Var);
            }
            boolean w4 = y.w(j0Var);
            b0Var.f4604h = w4;
            y yVar2 = b0Var.f4606j;
            if (yVar2 != null) {
                yVar2.q(w4);
            }
            b0Var.f4607k = this.f4644l;
            this.f4644l = null;
            this.f4635c.c(false);
            j2 j2Var = this.f4641i;
            int i4 = j2Var.f573f;
            int g4 = j2Var.g();
            int i5 = this.f4652t;
            View view2 = this.f4645m;
            WeakHashMap weakHashMap = y0.f4999a;
            if ((Gravity.getAbsoluteGravity(i5, i0.h0.d(view2)) & 7) == 5) {
                i4 += this.f4645m.getWidth();
            }
            if (!b0Var.b()) {
                if (b0Var.f4602f != null) {
                    b0Var.d(i4, g4, true, true);
                }
            }
            c0 c0Var2 = this.f4647o;
            if (c0Var2 != null) {
                c0Var2.f(j0Var);
            }
            return true;
        }
        return false;
    }

    @Override // g.d0
    public final void d(c0 c0Var) {
        this.f4647o = c0Var;
    }

    @Override // g.h0
    public final void dismiss() {
        if (b()) {
            this.f4641i.dismiss();
        }
    }

    @Override // g.d0
    public final boolean e() {
        return false;
    }

    @Override // g.h0
    public final void f() {
        View view;
        boolean z4;
        Rect rect;
        if (!b()) {
            if (!this.f4649q && (view = this.f4645m) != null) {
                this.f4646n = view;
                j2 j2Var = this.f4641i;
                j2Var.f593z.setOnDismissListener(this);
                j2Var.f583p = this;
                j2Var.f592y = true;
                j2Var.f593z.setFocusable(true);
                View view2 = this.f4646n;
                if (this.f4648p == null) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                this.f4648p = viewTreeObserver;
                if (z4) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f4642j);
                }
                view2.addOnAttachStateChangeListener(this.f4643k);
                j2Var.f582o = view2;
                j2Var.f579l = this.f4652t;
                boolean z5 = this.f4650r;
                Context context = this.f4634b;
                m mVar = this.f4636d;
                if (!z5) {
                    this.f4651s = y.o(mVar, context, this.f4638f);
                    this.f4650r = true;
                }
                j2Var.q(this.f4651s);
                j2Var.f593z.setInputMethodMode(2);
                Rect rect2 = this.f4758a;
                if (rect2 != null) {
                    rect = new Rect(rect2);
                } else {
                    rect = null;
                }
                j2Var.f591x = rect;
                j2Var.f();
                u1 u1Var = j2Var.f570c;
                u1Var.setOnKeyListener(this);
                if (this.f4653u) {
                    p pVar = this.f4635c;
                    if (pVar.f4707m != null) {
                        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) u1Var, false);
                        TextView textView = (TextView) frameLayout.findViewById(16908310);
                        if (textView != null) {
                            textView.setText(pVar.f4707m);
                        }
                        frameLayout.setEnabled(false);
                        u1Var.addHeaderView(frameLayout, null, false);
                    }
                }
                j2Var.o(mVar);
                j2Var.f();
                return;
            }
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // g.d0
    public final Parcelable g() {
        return null;
    }

    @Override // g.h0
    public final u1 k() {
        return this.f4641i.f570c;
    }

    @Override // g.d0
    public final void m(boolean z4) {
        this.f4650r = false;
        m mVar = this.f4636d;
        if (mVar != null) {
            mVar.notifyDataSetChanged();
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f4649q = true;
        this.f4635c.c(true);
        ViewTreeObserver viewTreeObserver = this.f4648p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f4648p = this.f4646n.getViewTreeObserver();
            }
            this.f4648p.removeGlobalOnLayoutListener(this.f4642j);
            this.f4648p = null;
        }
        this.f4646n.removeOnAttachStateChangeListener(this.f4643k);
        PopupWindow.OnDismissListener onDismissListener = this.f4644l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i4, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i4 == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // g.y
    public final void p(View view) {
        this.f4645m = view;
    }

    @Override // g.y
    public final void q(boolean z4) {
        this.f4636d.f4690c = z4;
    }

    @Override // g.y
    public final void r(int i4) {
        this.f4652t = i4;
    }

    @Override // g.y
    public final void s(int i4) {
        this.f4641i.f573f = i4;
    }

    @Override // g.y
    public final void t(PopupWindow.OnDismissListener onDismissListener) {
        this.f4644l = onDismissListener;
    }

    @Override // g.y
    public final void u(boolean z4) {
        this.f4653u = z4;
    }

    @Override // g.y
    public final void v(int i4) {
        this.f4641i.n(i4);
    }

    @Override // g.d0
    public final void i(Parcelable parcelable) {
    }

    @Override // g.y
    public final void n(p pVar) {
    }
}
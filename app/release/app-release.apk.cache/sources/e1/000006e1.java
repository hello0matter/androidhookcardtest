package g;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.app.o0;
import androidx.appcompat.widget.g2;
import androidx.appcompat.widget.j2;
import androidx.appcompat.widget.u1;
import com.example.msphone.R;
import i0.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class j extends y implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public boolean A;

    /* renamed from: b  reason: collision with root package name */
    public final Context f4654b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4655c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4656d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4657e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f4658f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f4659g;

    /* renamed from: o  reason: collision with root package name */
    public View f4667o;

    /* renamed from: p  reason: collision with root package name */
    public View f4668p;

    /* renamed from: q  reason: collision with root package name */
    public int f4669q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f4670r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f4671s;

    /* renamed from: t  reason: collision with root package name */
    public int f4672t;

    /* renamed from: u  reason: collision with root package name */
    public int f4673u;

    /* renamed from: w  reason: collision with root package name */
    public boolean f4675w;

    /* renamed from: x  reason: collision with root package name */
    public c0 f4676x;

    /* renamed from: y  reason: collision with root package name */
    public ViewTreeObserver f4677y;

    /* renamed from: z  reason: collision with root package name */
    public PopupWindow.OnDismissListener f4678z;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f4660h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList f4661i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public final f f4662j = new f(0, this);

    /* renamed from: k  reason: collision with root package name */
    public final g f4663k = new g(0, this);

    /* renamed from: l  reason: collision with root package name */
    public final o0 f4664l = new o0(2, this);

    /* renamed from: m  reason: collision with root package name */
    public int f4665m = 0;

    /* renamed from: n  reason: collision with root package name */
    public int f4666n = 0;

    /* renamed from: v  reason: collision with root package name */
    public boolean f4674v = false;

    public j(Context context, View view, int i4, int i5, boolean z4) {
        this.f4654b = context;
        this.f4667o = view;
        this.f4656d = i4;
        this.f4657e = i5;
        this.f4658f = z4;
        WeakHashMap weakHashMap = y0.f4999a;
        this.f4669q = i0.h0.d(view) != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.f4655c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f4659g = new Handler();
    }

    @Override // g.d0
    public final void a(p pVar, boolean z4) {
        int i4;
        ArrayList arrayList = this.f4661i;
        int size = arrayList.size();
        int i5 = 0;
        while (true) {
            if (i5 < size) {
                if (pVar == ((i) arrayList.get(i5)).f4632b) {
                    break;
                }
                i5++;
            } else {
                i5 = -1;
                break;
            }
        }
        if (i5 < 0) {
            return;
        }
        int i6 = i5 + 1;
        if (i6 < arrayList.size()) {
            ((i) arrayList.get(i6)).f4632b.c(false);
        }
        i iVar = (i) arrayList.remove(i5);
        iVar.f4632b.r(this);
        boolean z5 = this.A;
        j2 j2Var = iVar.f4631a;
        if (z5) {
            g2.b(j2Var.f593z, null);
            j2Var.f593z.setAnimationStyle(0);
        }
        j2Var.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            i4 = ((i) arrayList.get(size2 - 1)).f4633c;
        } else {
            View view = this.f4667o;
            WeakHashMap weakHashMap = y0.f4999a;
            if (i0.h0.d(view) == 1) {
                i4 = 0;
            } else {
                i4 = 1;
            }
        }
        this.f4669q = i4;
        if (size2 == 0) {
            dismiss();
            c0 c0Var = this.f4676x;
            if (c0Var != null) {
                c0Var.a(pVar, true);
            }
            ViewTreeObserver viewTreeObserver = this.f4677y;
            if (viewTreeObserver != null) {
                if (viewTreeObserver.isAlive()) {
                    this.f4677y.removeGlobalOnLayoutListener(this.f4662j);
                }
                this.f4677y = null;
            }
            this.f4668p.removeOnAttachStateChangeListener(this.f4663k);
            this.f4678z.onDismiss();
        } else if (z4) {
            ((i) arrayList.get(0)).f4632b.c(false);
        }
    }

    @Override // g.h0
    public final boolean b() {
        ArrayList arrayList = this.f4661i;
        if (arrayList.size() <= 0 || !((i) arrayList.get(0)).f4631a.f593z.isShowing()) {
            return false;
        }
        return true;
    }

    @Override // g.d0
    public final boolean c(j0 j0Var) {
        Iterator it = this.f4661i.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (j0Var == iVar.f4632b) {
                iVar.f4631a.f570c.requestFocus();
                return true;
            }
        }
        if (j0Var.hasVisibleItems()) {
            n(j0Var);
            c0 c0Var = this.f4676x;
            if (c0Var != null) {
                c0Var.f(j0Var);
            }
            return true;
        }
        return false;
    }

    @Override // g.d0
    public final void d(c0 c0Var) {
        this.f4676x = c0Var;
    }

    @Override // g.h0
    public final void dismiss() {
        ArrayList arrayList = this.f4661i;
        int size = arrayList.size();
        if (size > 0) {
            i[] iVarArr = (i[]) arrayList.toArray(new i[size]);
            for (int i4 = size - 1; i4 >= 0; i4--) {
                i iVar = iVarArr[i4];
                if (iVar.f4631a.f593z.isShowing()) {
                    iVar.f4631a.dismiss();
                }
            }
        }
    }

    @Override // g.d0
    public final boolean e() {
        return false;
    }

    @Override // g.h0
    public final void f() {
        boolean z4;
        if (b()) {
            return;
        }
        ArrayList arrayList = this.f4660h;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            x((p) it.next());
        }
        arrayList.clear();
        View view = this.f4667o;
        this.f4668p = view;
        if (view != null) {
            if (this.f4677y == null) {
                z4 = true;
            } else {
                z4 = false;
            }
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f4677y = viewTreeObserver;
            if (z4) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f4662j);
            }
            this.f4668p.addOnAttachStateChangeListener(this.f4663k);
        }
    }

    @Override // g.d0
    public final Parcelable g() {
        return null;
    }

    @Override // g.h0
    public final u1 k() {
        ArrayList arrayList = this.f4661i;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((i) arrayList.get(arrayList.size() - 1)).f4631a.f570c;
    }

    @Override // g.d0
    public final void m(boolean z4) {
        Iterator it = this.f4661i.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = ((i) it.next()).f4631a.f570c.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((m) adapter).notifyDataSetChanged();
        }
    }

    @Override // g.y
    public final void n(p pVar) {
        pVar.b(this, this.f4654b);
        if (b()) {
            x(pVar);
        } else {
            this.f4660h.add(pVar);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        i iVar;
        ArrayList arrayList = this.f4661i;
        int size = arrayList.size();
        int i4 = 0;
        while (true) {
            if (i4 < size) {
                iVar = (i) arrayList.get(i4);
                if (!iVar.f4631a.f593z.isShowing()) {
                    break;
                }
                i4++;
            } else {
                iVar = null;
                break;
            }
        }
        if (iVar != null) {
            iVar.f4632b.c(false);
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
        if (this.f4667o != view) {
            this.f4667o = view;
            int i4 = this.f4665m;
            WeakHashMap weakHashMap = y0.f4999a;
            this.f4666n = Gravity.getAbsoluteGravity(i4, i0.h0.d(view));
        }
    }

    @Override // g.y
    public final void q(boolean z4) {
        this.f4674v = z4;
    }

    @Override // g.y
    public final void r(int i4) {
        if (this.f4665m != i4) {
            this.f4665m = i4;
            View view = this.f4667o;
            WeakHashMap weakHashMap = y0.f4999a;
            this.f4666n = Gravity.getAbsoluteGravity(i4, i0.h0.d(view));
        }
    }

    @Override // g.y
    public final void s(int i4) {
        this.f4670r = true;
        this.f4672t = i4;
    }

    @Override // g.y
    public final void t(PopupWindow.OnDismissListener onDismissListener) {
        this.f4678z = onDismissListener;
    }

    @Override // g.y
    public final void u(boolean z4) {
        this.f4675w = z4;
    }

    @Override // g.y
    public final void v(int i4) {
        this.f4671s = true;
        this.f4673u = i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01b7  */
    /* JADX WARN: Type inference failed for: r7v0, types: [androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.j2] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void x(g.p r18) {
        /*
            Method dump skipped, instructions count: 532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: g.j.x(g.p):void");
    }

    @Override // g.d0
    public final void i(Parcelable parcelable) {
    }
}
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import com.example.msphone.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class n extends g.d implements i0.d {

    /* renamed from: j  reason: collision with root package name */
    public l f838j;

    /* renamed from: k  reason: collision with root package name */
    public Drawable f839k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f840l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f841m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f842n;

    /* renamed from: o  reason: collision with root package name */
    public int f843o;

    /* renamed from: p  reason: collision with root package name */
    public int f844p;

    /* renamed from: q  reason: collision with root package name */
    public int f845q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f846r;

    /* renamed from: s  reason: collision with root package name */
    public final SparseBooleanArray f847s;

    /* renamed from: t  reason: collision with root package name */
    public h f848t;

    /* renamed from: u  reason: collision with root package name */
    public h f849u;

    /* renamed from: v  reason: collision with root package name */
    public j f850v;

    /* renamed from: w  reason: collision with root package name */
    public i f851w;

    /* renamed from: x  reason: collision with root package name */
    public final androidx.appcompat.app.o0 f852x;

    /* renamed from: y  reason: collision with root package name */
    public int f853y;

    public n(Context context) {
        this.f4609a = context;
        this.f4612d = LayoutInflater.from(context);
        this.f4614f = R.layout.abc_action_menu_layout;
        this.f4615g = R.layout.abc_action_menu_item_layout;
        this.f847s = new SparseBooleanArray();
        this.f852x = new androidx.appcompat.app.o0(4, this);
    }

    @Override // g.d0
    public final void a(g.p pVar, boolean z4) {
        f();
        h hVar = this.f849u;
        if (hVar != null && hVar.b()) {
            hVar.f4606j.dismiss();
        }
        g.c0 c0Var = this.f4613e;
        if (c0Var != null) {
            c0Var.a(pVar, z4);
        }
    }

    public final View b(g.r rVar, View view, ViewGroup viewGroup) {
        g.e0 e0Var;
        View actionView = rVar.getActionView();
        int i4 = 0;
        if (actionView == null || rVar.e()) {
            if (view instanceof g.e0) {
                e0Var = (g.e0) view;
            } else {
                e0Var = (g.e0) this.f4612d.inflate(this.f4615g, viewGroup, false);
            }
            e0Var.c(rVar);
            ActionMenuItemView actionMenuItemView = (ActionMenuItemView) e0Var;
            actionMenuItemView.setItemInvoker((ActionMenuView) this.f4616h);
            if (this.f851w == null) {
                this.f851w = new i(this);
            }
            actionMenuItemView.setPopupCallback(this.f851w);
            actionView = (View) e0Var;
        }
        if (rVar.C) {
            i4 = 8;
        }
        actionView.setVisibility(i4);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        ((ActionMenuView) viewGroup).getClass();
        if (!(layoutParams instanceof ActionMenuView.LayoutParams)) {
            actionView.setLayoutParams(ActionMenuView.m(layoutParams));
        }
        return actionView;
    }

    @Override // g.d0
    public final boolean c(g.j0 j0Var) {
        boolean z4;
        if (!j0Var.hasVisibleItems()) {
            return false;
        }
        g.j0 j0Var2 = j0Var;
        while (true) {
            g.p pVar = j0Var2.f4679z;
            if (pVar == this.f4611c) {
                break;
            }
            j0Var2 = (g.j0) pVar;
        }
        ViewGroup viewGroup = (ViewGroup) this.f4616h;
        View view = null;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i4);
                if ((childAt instanceof g.e0) && ((g.e0) childAt).getItemData() == j0Var2.A) {
                    view = childAt;
                    break;
                }
                i4++;
            }
        }
        if (view == null) {
            return false;
        }
        this.f853y = j0Var.A.f4722a;
        int size = j0Var.f4700f.size();
        int i5 = 0;
        while (true) {
            if (i5 < size) {
                MenuItem item = j0Var.getItem(i5);
                if (item.isVisible() && item.getIcon() != null) {
                    z4 = true;
                    break;
                }
                i5++;
            } else {
                z4 = false;
                break;
            }
        }
        h hVar = new h(this, this.f4610b, j0Var, view);
        this.f849u = hVar;
        hVar.f4604h = z4;
        g.y yVar = hVar.f4606j;
        if (yVar != null) {
            yVar.q(z4);
        }
        h hVar2 = this.f849u;
        if (!hVar2.b()) {
            if (hVar2.f4602f != null) {
                hVar2.d(0, 0, false, false);
            } else {
                throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
            }
        }
        g.c0 c0Var = this.f4613e;
        if (c0Var != null) {
            c0Var.f(j0Var);
        }
        return true;
    }

    @Override // g.d0
    public final boolean e() {
        int i4;
        ArrayList arrayList;
        int i5;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        g.p pVar = this.f4611c;
        if (pVar != null) {
            arrayList = pVar.l();
            i4 = arrayList.size();
        } else {
            i4 = 0;
            arrayList = null;
        }
        int i6 = this.f845q;
        int i7 = this.f844p;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f4616h;
        int i8 = 0;
        boolean z8 = false;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            i5 = 2;
            z4 = true;
            if (i8 >= i4) {
                break;
            }
            g.r rVar = (g.r) arrayList.get(i8);
            int i11 = rVar.f4746y;
            if ((i11 & 2) == 2) {
                i9++;
            } else if ((i11 & 1) == 1) {
                i10++;
            } else {
                z8 = true;
            }
            if (this.f846r && rVar.C) {
                i6 = 0;
            }
            i8++;
        }
        if (this.f841m && (z8 || i10 + i9 > i6)) {
            i6--;
        }
        int i12 = i6 - i9;
        SparseBooleanArray sparseBooleanArray = this.f847s;
        sparseBooleanArray.clear();
        int i13 = 0;
        int i14 = 0;
        while (i13 < i4) {
            g.r rVar2 = (g.r) arrayList.get(i13);
            int i15 = rVar2.f4746y;
            if ((i15 & 2) == i5) {
                z5 = z4;
            } else {
                z5 = false;
            }
            int i16 = rVar2.f4723b;
            if (z5) {
                View b5 = b(rVar2, null, viewGroup);
                b5.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = b5.getMeasuredWidth();
                i7 -= measuredWidth;
                if (i14 == 0) {
                    i14 = measuredWidth;
                }
                if (i16 != 0) {
                    sparseBooleanArray.put(i16, z4);
                }
                rVar2.h(z4);
            } else if ((i15 & 1) == z4) {
                boolean z9 = sparseBooleanArray.get(i16);
                if ((i12 > 0 || z9) && i7 > 0) {
                    z6 = z4;
                } else {
                    z6 = false;
                }
                if (z6) {
                    View b6 = b(rVar2, null, viewGroup);
                    b6.measure(makeMeasureSpec, makeMeasureSpec);
                    int measuredWidth2 = b6.getMeasuredWidth();
                    i7 -= measuredWidth2;
                    if (i14 == 0) {
                        i14 = measuredWidth2;
                    }
                    if (i7 + i14 > 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z6 &= z7;
                }
                if (z6 && i16 != 0) {
                    sparseBooleanArray.put(i16, true);
                } else if (z9) {
                    sparseBooleanArray.put(i16, false);
                    for (int i17 = 0; i17 < i13; i17++) {
                        g.r rVar3 = (g.r) arrayList.get(i17);
                        if (rVar3.f4723b == i16) {
                            if (rVar3.f()) {
                                i12++;
                            }
                            rVar3.h(false);
                        }
                    }
                }
                if (z6) {
                    i12--;
                }
                rVar2.h(z6);
            } else {
                rVar2.h(false);
                i13++;
                i5 = 2;
                z4 = true;
            }
            i13++;
            i5 = 2;
            z4 = true;
        }
        return z4;
    }

    public final boolean f() {
        g.f0 f0Var;
        j jVar = this.f850v;
        if (jVar != null && (f0Var = this.f4616h) != null) {
            ((View) f0Var).removeCallbacks(jVar);
            this.f850v = null;
            return true;
        }
        h hVar = this.f848t;
        if (hVar != null) {
            if (hVar.b()) {
                hVar.f4606j.dismiss();
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, java.lang.Object, androidx.appcompat.widget.ActionMenuPresenter$SavedState] */
    @Override // g.d0
    public final Parcelable g() {
        ?? obj = new Object();
        obj.f453a = this.f853y;
        return obj;
    }

    @Override // g.d0
    public final void i(Parcelable parcelable) {
        int i4;
        MenuItem findItem;
        if ((parcelable instanceof ActionMenuPresenter$SavedState) && (i4 = ((ActionMenuPresenter$SavedState) parcelable).f453a) > 0 && (findItem = this.f4611c.findItem(i4)) != null) {
            c((g.j0) findItem.getSubMenu());
        }
    }

    public final boolean k() {
        h hVar = this.f848t;
        return hVar != null && hVar.b();
    }

    @Override // g.d0
    public final void l(Context context, g.p pVar) {
        this.f4610b = context;
        LayoutInflater.from(context);
        this.f4611c = pVar;
        Resources resources = context.getResources();
        f.a a5 = f.a.a(context);
        if (!this.f842n) {
            this.f841m = true;
        }
        this.f843o = a5.f4443a.getResources().getDisplayMetrics().widthPixels / 2;
        this.f845q = a5.b();
        int i4 = this.f843o;
        if (this.f841m) {
            if (this.f838j == null) {
                l lVar = new l(this, this.f4609a);
                this.f838j = lVar;
                if (this.f840l) {
                    lVar.setImageDrawable(this.f839k);
                    this.f839k = null;
                    this.f840l = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f838j.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i4 -= this.f838j.getMeasuredWidth();
        } else {
            this.f838j = null;
        }
        this.f844p = i4;
        float f4 = resources.getDisplayMetrics().density;
    }

    @Override // g.d0
    public final void m(boolean z4) {
        int size;
        int i4;
        g.r rVar;
        ViewGroup viewGroup = (ViewGroup) this.f4616h;
        ArrayList arrayList = null;
        if (viewGroup != null) {
            g.p pVar = this.f4611c;
            if (pVar != null) {
                pVar.i();
                ArrayList l4 = this.f4611c.l();
                int size2 = l4.size();
                i4 = 0;
                for (int i5 = 0; i5 < size2; i5++) {
                    g.r rVar2 = (g.r) l4.get(i5);
                    if (rVar2.f()) {
                        View childAt = viewGroup.getChildAt(i4);
                        if (childAt instanceof g.e0) {
                            rVar = ((g.e0) childAt).getItemData();
                        } else {
                            rVar = null;
                        }
                        View b5 = b(rVar2, childAt, viewGroup);
                        if (rVar2 != rVar) {
                            b5.setPressed(false);
                            b5.jumpDrawablesToCurrentState();
                        }
                        if (b5 != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) b5.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(b5);
                            }
                            ((ViewGroup) this.f4616h).addView(b5, i4);
                        }
                        i4++;
                    }
                }
            } else {
                i4 = 0;
            }
            while (i4 < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i4) == this.f838j) {
                    i4++;
                } else {
                    viewGroup.removeViewAt(i4);
                }
            }
        }
        ((View) this.f4616h).requestLayout();
        g.p pVar2 = this.f4611c;
        if (pVar2 != null) {
            pVar2.i();
            ArrayList arrayList2 = pVar2.f4703i;
            int size3 = arrayList2.size();
            for (int i6 = 0; i6 < size3; i6++) {
                i0.e eVar = ((g.r) arrayList2.get(i6)).A;
                if (eVar != null) {
                    eVar.f4919a = this;
                }
            }
        }
        g.p pVar3 = this.f4611c;
        if (pVar3 != null) {
            pVar3.i();
            arrayList = pVar3.f4704j;
        }
        if (this.f841m && arrayList != null && ((size = arrayList.size()) != 1 ? size > 0 : (!((g.r) arrayList.get(0)).C))) {
            if (this.f838j == null) {
                this.f838j = new l(this, this.f4609a);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f838j.getParent();
            if (viewGroup3 != this.f4616h) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.f838j);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f4616h;
                l lVar = this.f838j;
                actionMenuView.getClass();
                ActionMenuView.LayoutParams l5 = ActionMenuView.l();
                l5.f465a = true;
                actionMenuView.addView(lVar, l5);
            }
        } else {
            l lVar2 = this.f838j;
            if (lVar2 != null) {
                ViewParent parent = lVar2.getParent();
                g.f0 f0Var = this.f4616h;
                if (parent == f0Var) {
                    ((ViewGroup) f0Var).removeView(this.f838j);
                }
            }
        }
        ((ActionMenuView) this.f4616h).setOverflowReserved(this.f841m);
    }

    public final void n(boolean z4) {
        if (z4) {
            g.c0 c0Var = this.f4613e;
            if (c0Var != null) {
                c0Var.f(this.f4611c);
                return;
            }
            return;
        }
        g.p pVar = this.f4611c;
        if (pVar != null) {
            pVar.c(false);
        }
    }

    public final boolean o() {
        g.p pVar;
        if (this.f841m && !k() && (pVar = this.f4611c) != null && this.f4616h != null && this.f850v == null) {
            pVar.i();
            if (!pVar.f4704j.isEmpty()) {
                j jVar = new j(0, this, new h(this, this.f4610b, this.f4611c, this.f838j));
                this.f850v = jVar;
                ((View) this.f4616h).post(jVar);
                return true;
            }
        }
        return false;
    }
}
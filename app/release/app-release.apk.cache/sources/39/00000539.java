package com.google.android.material.internal;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l1;
import com.example.msphone.R;
import i0.y0;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class o extends androidx.recyclerview.widget.j0 {

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f3567c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public g.r f3568d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3569e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ w f3570f;

    public o(w wVar) {
        this.f3570f = wVar;
        g();
    }

    @Override // androidx.recyclerview.widget.j0
    public final int a() {
        return this.f3567c.size();
    }

    @Override // androidx.recyclerview.widget.j0
    public final long b(int i4) {
        return i4;
    }

    @Override // androidx.recyclerview.widget.j0
    public final int c(int i4) {
        q qVar = (q) this.f3567c.get(i4);
        if (qVar instanceof r) {
            return 2;
        }
        if (qVar instanceof p) {
            return 3;
        }
        if (qVar instanceof s) {
            if (((s) qVar).f3574a.hasSubMenu()) {
                return 1;
            }
            return 0;
        }
        throw new RuntimeException("Unknown item type.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.j0
    public final void d(l1 l1Var, int i4) {
        Drawable drawable;
        n nVar;
        NavigationMenuItemView navigationMenuItemView;
        int c4 = c(i4);
        ArrayList arrayList = this.f3567c;
        View view = ((v) l1Var).f2170a;
        w wVar = this.f3570f;
        if (c4 != 0) {
            if (c4 != 1) {
                if (c4 == 2) {
                    r rVar = (r) arrayList.get(i4);
                    view.setPadding(wVar.f3595s, rVar.f3572a, wVar.f3596t, rVar.f3573b);
                    return;
                }
                return;
            }
            TextView textView = (TextView) view;
            textView.setText(((s) arrayList.get(i4)).f3574a.f4726e);
            textView.setTextAppearance(wVar.f3583g);
            textView.setPadding(wVar.f3597u, textView.getPaddingTop(), wVar.f3598v, textView.getPaddingBottom());
            ColorStateList colorStateList = wVar.f3584h;
            if (colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
            nVar = new n(this, i4, true);
            navigationMenuItemView = textView;
        } else {
            NavigationMenuItemView navigationMenuItemView2 = (NavigationMenuItemView) view;
            navigationMenuItemView2.setIconTintList(wVar.f3588l);
            navigationMenuItemView2.setTextAppearance(wVar.f3585i);
            ColorStateList colorStateList2 = wVar.f3587k;
            if (colorStateList2 != null) {
                navigationMenuItemView2.setTextColor(colorStateList2);
            }
            Drawable drawable2 = wVar.f3589m;
            if (drawable2 != null) {
                drawable = drawable2.getConstantState().newDrawable();
            } else {
                drawable = null;
            }
            WeakHashMap weakHashMap = y0.f4999a;
            i0.g0.q(navigationMenuItemView2, drawable);
            RippleDrawable rippleDrawable = wVar.f3590n;
            if (rippleDrawable != null) {
                navigationMenuItemView2.setForeground(rippleDrawable.getConstantState().newDrawable());
            }
            s sVar = (s) arrayList.get(i4);
            navigationMenuItemView2.setNeedsEmptyIcon(sVar.f3575b);
            int i5 = wVar.f3591o;
            int i6 = wVar.f3592p;
            navigationMenuItemView2.setPadding(i5, i6, i5, i6);
            navigationMenuItemView2.setIconPadding(wVar.f3593q);
            if (wVar.f3599w) {
                navigationMenuItemView2.setIconSize(wVar.f3594r);
            }
            navigationMenuItemView2.setMaxLines(wVar.f3601y);
            navigationMenuItemView2.f3458y = wVar.f3586j;
            navigationMenuItemView2.c(sVar.f3574a);
            nVar = new n(this, i4, false);
            navigationMenuItemView = navigationMenuItemView2;
        }
        y0.p(navigationMenuItemView, nVar);
    }

    @Override // androidx.recyclerview.widget.j0
    public final l1 e(RecyclerView recyclerView, int i4) {
        l1 l1Var;
        w wVar = this.f3570f;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        return null;
                    }
                    return new l1(wVar.f3578b);
                }
                l1Var = new m(1, wVar.f3582f, recyclerView);
            } else {
                l1Var = new m(2, wVar.f3582f, recyclerView);
            }
        } else {
            View inflate = wVar.f3582f.inflate(R.layout.design_navigation_item, (ViewGroup) recyclerView, false);
            l1Var = new l1(inflate);
            inflate.setOnClickListener(wVar.C);
        }
        return l1Var;
    }

    @Override // androidx.recyclerview.widget.j0
    public final void f(l1 l1Var) {
        v vVar = (v) l1Var;
        if (vVar instanceof u) {
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) vVar.f2170a;
            FrameLayout frameLayout = navigationMenuItemView.A;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            navigationMenuItemView.f3459z.setCompoundDrawables(null, null, null, null);
        }
    }

    public final void g() {
        boolean z4;
        if (this.f3569e) {
            return;
        }
        this.f3569e = true;
        ArrayList arrayList = this.f3567c;
        arrayList.clear();
        arrayList.add(new Object());
        w wVar = this.f3570f;
        int size = wVar.f3579c.l().size();
        boolean z5 = false;
        int i4 = -1;
        int i5 = 0;
        boolean z6 = false;
        int i6 = 0;
        while (i5 < size) {
            g.r rVar = (g.r) wVar.f3579c.l().get(i5);
            if (rVar.isChecked()) {
                h(rVar);
            }
            if (rVar.isCheckable()) {
                rVar.g(z5);
            }
            if (rVar.hasSubMenu()) {
                g.j0 j0Var = rVar.f4736o;
                if (j0Var.hasVisibleItems()) {
                    if (i5 != 0) {
                        arrayList.add(new r(wVar.A, z5 ? 1 : 0));
                    }
                    arrayList.add(new s(rVar));
                    int size2 = j0Var.f4700f.size();
                    int i7 = z5 ? 1 : 0;
                    int i8 = i7;
                    while (i7 < size2) {
                        g.r rVar2 = (g.r) j0Var.getItem(i7);
                        if (rVar2.isVisible()) {
                            if (i8 == 0 && rVar2.getIcon() != null) {
                                i8 = 1;
                            }
                            if (rVar2.isCheckable()) {
                                rVar2.g(z5);
                            }
                            if (rVar.isChecked()) {
                                h(rVar);
                            }
                            arrayList.add(new s(rVar2));
                        }
                        i7++;
                        z5 = false;
                    }
                    if (i8 != 0) {
                        int size3 = arrayList.size();
                        for (int size4 = arrayList.size(); size4 < size3; size4++) {
                            ((s) arrayList.get(size4)).f3575b = true;
                        }
                    }
                }
                z4 = true;
            } else {
                int i9 = rVar.f4723b;
                if (i9 != i4) {
                    i6 = arrayList.size();
                    if (rVar.getIcon() != null) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (i5 != 0) {
                        i6++;
                        int i10 = wVar.A;
                        arrayList.add(new r(i10, i10));
                    }
                } else if (!z6 && rVar.getIcon() != null) {
                    int size5 = arrayList.size();
                    for (int i11 = i6; i11 < size5; i11++) {
                        ((s) arrayList.get(i11)).f3575b = true;
                    }
                    z4 = true;
                    z6 = true;
                    s sVar = new s(rVar);
                    sVar.f3575b = z6;
                    arrayList.add(sVar);
                    i4 = i9;
                }
                z4 = true;
                s sVar2 = new s(rVar);
                sVar2.f3575b = z6;
                arrayList.add(sVar2);
                i4 = i9;
            }
            i5++;
            z5 = false;
        }
        this.f3569e = z5 ? 1 : 0;
    }

    public final void h(g.r rVar) {
        if (this.f3568d != rVar && rVar.isCheckable()) {
            g.r rVar2 = this.f3568d;
            if (rVar2 != null) {
                rVar2.setChecked(false);
            }
            this.f3568d = rVar;
            rVar.setChecked(true);
        }
    }
}
package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.example.msphone.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class w implements g.d0 {
    public int A;

    /* renamed from: a  reason: collision with root package name */
    public NavigationMenuView f3577a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f3578b;

    /* renamed from: c  reason: collision with root package name */
    public g.p f3579c;

    /* renamed from: d  reason: collision with root package name */
    public int f3580d;

    /* renamed from: e  reason: collision with root package name */
    public o f3581e;

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f3582f;

    /* renamed from: h  reason: collision with root package name */
    public ColorStateList f3584h;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f3587k;

    /* renamed from: l  reason: collision with root package name */
    public ColorStateList f3588l;

    /* renamed from: m  reason: collision with root package name */
    public Drawable f3589m;

    /* renamed from: n  reason: collision with root package name */
    public RippleDrawable f3590n;

    /* renamed from: o  reason: collision with root package name */
    public int f3591o;

    /* renamed from: p  reason: collision with root package name */
    public int f3592p;

    /* renamed from: q  reason: collision with root package name */
    public int f3593q;

    /* renamed from: r  reason: collision with root package name */
    public int f3594r;

    /* renamed from: s  reason: collision with root package name */
    public int f3595s;

    /* renamed from: t  reason: collision with root package name */
    public int f3596t;

    /* renamed from: u  reason: collision with root package name */
    public int f3597u;

    /* renamed from: v  reason: collision with root package name */
    public int f3598v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f3599w;

    /* renamed from: y  reason: collision with root package name */
    public int f3601y;

    /* renamed from: z  reason: collision with root package name */
    public int f3602z;

    /* renamed from: g  reason: collision with root package name */
    public int f3583g = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f3585i = 0;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3586j = true;

    /* renamed from: x  reason: collision with root package name */
    public boolean f3600x = true;
    public int B = -1;
    public final androidx.appcompat.app.b C = new androidx.appcompat.app.b(4, this);

    @Override // g.d0
    public final boolean c(g.j0 j0Var) {
        return false;
    }

    @Override // g.d0
    public final boolean e() {
        return false;
    }

    @Override // g.d0
    public final Parcelable g() {
        View view;
        Bundle bundle = new Bundle();
        if (this.f3577a != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f3577a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        o oVar = this.f3581e;
        if (oVar != null) {
            oVar.getClass();
            Bundle bundle2 = new Bundle();
            g.r rVar = oVar.f3568d;
            if (rVar != null) {
                bundle2.putInt("android:menu:checked", rVar.f4722a);
            }
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            ArrayList arrayList = oVar.f3567c;
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                q qVar = (q) arrayList.get(i4);
                if (qVar instanceof s) {
                    g.r rVar2 = ((s) qVar).f3574a;
                    if (rVar2 != null) {
                        view = rVar2.getActionView();
                    } else {
                        view = null;
                    }
                    if (view != null) {
                        SparseArray<Parcelable> sparseArray3 = new SparseArray<>();
                        view.saveHierarchyState(sparseArray3);
                        sparseArray2.put(rVar2.f4722a, sparseArray3);
                    }
                }
            }
            bundle2.putSparseParcelableArray("android:menu:action_views", sparseArray2);
            bundle.putBundle("android:menu:adapter", bundle2);
        }
        if (this.f3578b != null) {
            SparseArray<Parcelable> sparseArray4 = new SparseArray<>();
            this.f3578b.saveHierarchyState(sparseArray4);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray4);
        }
        return bundle;
    }

    @Override // g.d0
    public final int getId() {
        return this.f3580d;
    }

    @Override // g.d0
    public final boolean h(g.r rVar) {
        return false;
    }

    @Override // g.d0
    public final void i(Parcelable parcelable) {
        g.r rVar;
        View actionView;
        ParcelableSparseArray parcelableSparseArray;
        g.r rVar2;
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f3577a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                o oVar = this.f3581e;
                oVar.getClass();
                int i4 = bundle2.getInt("android:menu:checked", 0);
                ArrayList arrayList = oVar.f3567c;
                if (i4 != 0) {
                    oVar.f3569e = true;
                    int size = arrayList.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size) {
                            break;
                        }
                        q qVar = (q) arrayList.get(i5);
                        if ((qVar instanceof s) && (rVar2 = ((s) qVar).f3574a) != null && rVar2.f4722a == i4) {
                            oVar.h(rVar2);
                            break;
                        }
                        i5++;
                    }
                    oVar.f3569e = false;
                    oVar.g();
                }
                SparseArray sparseParcelableArray2 = bundle2.getSparseParcelableArray("android:menu:action_views");
                if (sparseParcelableArray2 != null) {
                    int size2 = arrayList.size();
                    for (int i6 = 0; i6 < size2; i6++) {
                        q qVar2 = (q) arrayList.get(i6);
                        if ((qVar2 instanceof s) && (rVar = ((s) qVar2).f3574a) != null && (actionView = rVar.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray2.get(rVar.f4722a)) != null) {
                            actionView.restoreHierarchyState(parcelableSparseArray);
                        }
                    }
                }
            }
            SparseArray<Parcelable> sparseParcelableArray3 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray3 != null) {
                this.f3578b.restoreHierarchyState(sparseParcelableArray3);
            }
        }
    }

    @Override // g.d0
    public final boolean j(g.r rVar) {
        return false;
    }

    @Override // g.d0
    public final void l(Context context, g.p pVar) {
        this.f3582f = LayoutInflater.from(context);
        this.f3579c = pVar;
        this.A = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    @Override // g.d0
    public final void m(boolean z4) {
        o oVar = this.f3581e;
        if (oVar != null) {
            oVar.g();
            oVar.f2145a.b();
        }
    }

    @Override // g.d0
    public final void a(g.p pVar, boolean z4) {
    }
}
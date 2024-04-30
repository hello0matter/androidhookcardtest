package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.MenuItem;
import androidx.transition.AutoTransition;
import c1.i0;
import com.google.android.material.badge.BadgeState$State;
import com.google.android.material.internal.ParcelableSparseArray;
import g.d0;
import g.j0;
import g.p;
import g.r;

/* loaded from: classes.dex */
public final class g implements d0 {

    /* renamed from: a  reason: collision with root package name */
    public NavigationBarMenuView f3695a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3696b;

    /* renamed from: c  reason: collision with root package name */
    public int f3697c;

    @Override // g.d0
    public final boolean c(j0 j0Var) {
        return false;
    }

    @Override // g.d0
    public final boolean e() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, java.lang.Object, com.google.android.material.navigation.NavigationBarPresenter$SavedState] */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.util.SparseArray, com.google.android.material.internal.ParcelableSparseArray] */
    @Override // g.d0
    public final Parcelable g() {
        ?? obj = new Object();
        obj.f3667a = this.f3695a.getSelectedItemId();
        SparseArray<q1.a> badgeDrawables = this.f3695a.getBadgeDrawables();
        ?? sparseArray = new SparseArray();
        for (int i4 = 0; i4 < badgeDrawables.size(); i4++) {
            int keyAt = badgeDrawables.keyAt(i4);
            q1.a valueAt = badgeDrawables.valueAt(i4);
            if (valueAt != null) {
                sparseArray.put(keyAt, valueAt.f6334e.f6343a);
            } else {
                throw new IllegalArgumentException("badgeDrawable cannot be null");
            }
        }
        obj.f3668b = sparseArray;
        return obj;
    }

    @Override // g.d0
    public final int getId() {
        return this.f3697c;
    }

    @Override // g.d0
    public final boolean h(r rVar) {
        return false;
    }

    @Override // g.d0
    public final void i(Parcelable parcelable) {
        SparseArray sparseArray;
        if (parcelable instanceof NavigationBarPresenter$SavedState) {
            NavigationBarMenuView navigationBarMenuView = this.f3695a;
            NavigationBarPresenter$SavedState navigationBarPresenter$SavedState = (NavigationBarPresenter$SavedState) parcelable;
            int i4 = navigationBarPresenter$SavedState.f3667a;
            int size = navigationBarMenuView.E.f4700f.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size) {
                    break;
                }
                MenuItem item = navigationBarMenuView.E.getItem(i5);
                if (i4 == item.getItemId()) {
                    navigationBarMenuView.f3647g = i4;
                    navigationBarMenuView.f3648h = i5;
                    item.setChecked(true);
                    break;
                }
                i5++;
            }
            Context context = this.f3695a.getContext();
            ParcelableSparseArray parcelableSparseArray = navigationBarPresenter$SavedState.f3668b;
            SparseArray sparseArray2 = new SparseArray(parcelableSparseArray.size());
            for (int i6 = 0; i6 < parcelableSparseArray.size(); i6++) {
                int keyAt = parcelableSparseArray.keyAt(i6);
                BadgeState$State badgeState$State = (BadgeState$State) parcelableSparseArray.valueAt(i6);
                if (badgeState$State != null) {
                    sparseArray2.put(keyAt, new q1.a(context, badgeState$State));
                } else {
                    throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
                }
            }
            NavigationBarMenuView navigationBarMenuView2 = this.f3695a;
            navigationBarMenuView2.getClass();
            int i7 = 0;
            while (true) {
                int size2 = sparseArray2.size();
                sparseArray = navigationBarMenuView2.f3659s;
                if (i7 >= size2) {
                    break;
                }
                int keyAt2 = sparseArray2.keyAt(i7);
                if (sparseArray.indexOfKey(keyAt2) < 0) {
                    sparseArray.append(keyAt2, (q1.a) sparseArray2.get(keyAt2));
                }
                i7++;
            }
            NavigationBarItemView[] navigationBarItemViewArr = navigationBarMenuView2.f3646f;
            if (navigationBarItemViewArr != null) {
                for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                    navigationBarItemView.setBadge((q1.a) sparseArray.get(navigationBarItemView.getId()));
                }
            }
        }
    }

    @Override // g.d0
    public final boolean j(r rVar) {
        return false;
    }

    @Override // g.d0
    public final void l(Context context, p pVar) {
        this.f3695a.E = pVar;
    }

    @Override // g.d0
    public final void m(boolean z4) {
        AutoTransition autoTransition;
        if (this.f3696b) {
            return;
        }
        if (z4) {
            this.f3695a.a();
            return;
        }
        NavigationBarMenuView navigationBarMenuView = this.f3695a;
        p pVar = navigationBarMenuView.E;
        if (pVar != null && navigationBarMenuView.f3646f != null) {
            int size = pVar.f4700f.size();
            if (size != navigationBarMenuView.f3646f.length) {
                navigationBarMenuView.a();
                return;
            }
            int i4 = navigationBarMenuView.f3647g;
            for (int i5 = 0; i5 < size; i5++) {
                MenuItem item = navigationBarMenuView.E.getItem(i5);
                if (item.isChecked()) {
                    navigationBarMenuView.f3647g = item.getItemId();
                    navigationBarMenuView.f3648h = i5;
                }
            }
            if (i4 != navigationBarMenuView.f3647g && (autoTransition = navigationBarMenuView.f3641a) != null) {
                i0.a(navigationBarMenuView, autoTransition);
            }
            boolean f4 = NavigationBarMenuView.f(navigationBarMenuView.f3645e, navigationBarMenuView.E.l().size());
            for (int i6 = 0; i6 < size; i6++) {
                navigationBarMenuView.D.f3696b = true;
                navigationBarMenuView.f3646f[i6].setLabelVisibilityMode(navigationBarMenuView.f3645e);
                navigationBarMenuView.f3646f[i6].setShifting(f4);
                navigationBarMenuView.f3646f[i6].c((r) navigationBarMenuView.E.getItem(i6));
                navigationBarMenuView.D.f3696b = false;
            }
        }
    }

    @Override // g.d0
    public final void a(p pVar, boolean z4) {
    }
}
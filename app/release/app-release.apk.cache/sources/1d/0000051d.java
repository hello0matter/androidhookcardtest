package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.ChipGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f3469a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final HashSet f3470b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public w1.g f3471c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3472d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3473e;

    public final boolean a(i iVar) {
        int id = iVar.getId();
        HashSet hashSet = this.f3470b;
        if (hashSet.contains(Integer.valueOf(id))) {
            return false;
        }
        i iVar2 = (i) this.f3469a.get(Integer.valueOf(c()));
        if (iVar2 != null) {
            e(iVar2, false);
        }
        boolean add = hashSet.add(Integer.valueOf(id));
        if (!iVar.isChecked()) {
            iVar.setChecked(true);
        }
        return add;
    }

    public final ArrayList b(ViewGroup viewGroup) {
        HashSet hashSet = new HashSet(this.f3470b);
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
            View childAt = viewGroup.getChildAt(i4);
            if ((childAt instanceof i) && hashSet.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    public final int c() {
        if (this.f3472d) {
            HashSet hashSet = this.f3470b;
            if (!hashSet.isEmpty()) {
                return ((Integer) hashSet.iterator().next()).intValue();
            }
        }
        return -1;
    }

    public final void d() {
        w1.g gVar = this.f3471c;
        if (gVar != null) {
            new HashSet(this.f3470b);
            ChipGroup chipGroup = (ChipGroup) gVar.f7056b;
            w1.i iVar = chipGroup.f3236g;
            if (iVar != null) {
                chipGroup.f3237h.b(chipGroup);
                androidx.appcompat.widget.c0 c0Var = (androidx.appcompat.widget.c0) iVar;
                if (((ChipGroup) c0Var.f726c).f3237h.f3472d) {
                    androidx.activity.j.f(c0Var.f725b);
                    ((ChipGroup) c0Var.f726c).getCheckedChipId();
                    throw null;
                }
            }
        }
    }

    public final boolean e(i iVar, boolean z4) {
        int id = iVar.getId();
        HashSet hashSet = this.f3470b;
        if (hashSet.contains(Integer.valueOf(id))) {
            if (z4 && hashSet.size() == 1 && hashSet.contains(Integer.valueOf(id))) {
                iVar.setChecked(true);
                return false;
            }
            boolean remove = hashSet.remove(Integer.valueOf(id));
            if (iVar.isChecked()) {
                iVar.setChecked(false);
            }
            return remove;
        }
        return false;
    }
}
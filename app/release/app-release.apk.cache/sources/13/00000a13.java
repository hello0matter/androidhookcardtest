package w1;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import i0.h0;
import i0.y0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class j implements ViewGroup.OnHierarchyChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f7057a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChipGroup f7058b;

    public j(ChipGroup chipGroup) {
        this.f7058b = chipGroup;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewAdded(View view, View view2) {
        ChipGroup chipGroup = this.f7058b;
        if (view == chipGroup && (view2 instanceof Chip)) {
            if (view2.getId() == -1) {
                WeakHashMap weakHashMap = y0.f4999a;
                view2.setId(h0.a());
            }
            com.google.android.material.internal.a aVar = chipGroup.f3237h;
            Chip chip = (Chip) view2;
            aVar.f3469a.put(Integer.valueOf(chip.getId()), chip);
            if (chip.isChecked()) {
                aVar.a(chip);
            }
            chip.setInternalOnCheckedChangeListener(new g(3, aVar));
        }
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f7057a;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewAdded(view, view2);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewRemoved(View view, View view2) {
        ChipGroup chipGroup = this.f7058b;
        if (view == chipGroup && (view2 instanceof Chip)) {
            com.google.android.material.internal.a aVar = chipGroup.f3237h;
            Chip chip = (Chip) view2;
            aVar.getClass();
            chip.setInternalOnCheckedChangeListener(null);
            aVar.f3469a.remove(Integer.valueOf(chip.getId()));
            aVar.f3470b.remove(Integer.valueOf(chip.getId()));
        }
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f7057a;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewRemoved(view, view2);
        }
    }
}
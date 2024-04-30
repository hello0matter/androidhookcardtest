package o;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class d implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5793a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f5794b;

    public /* synthetic */ d(int i4, Object obj) {
        this.f5793a = i4;
        this.f5794b = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f5793a) {
            case 0:
                androidx.activity.j.f(obj);
                androidx.activity.j.f(obj2);
                throw null;
            case 1:
                return ((p.j) obj).f6104b - ((p.j) obj2).f6104b;
            case 2:
                return ((int[]) obj)[0] - ((int[]) obj2)[0];
            default:
                MaterialButton materialButton = (MaterialButton) obj;
                MaterialButton materialButton2 = (MaterialButton) obj2;
                int compareTo = Boolean.valueOf(materialButton.f3126o).compareTo(Boolean.valueOf(materialButton2.f3126o));
                if (compareTo == 0) {
                    int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
                    if (compareTo2 == 0) {
                        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.f5794b;
                        return Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton)).compareTo(Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton2)));
                    }
                    return compareTo2;
                }
                return compareTo;
        }
    }
}
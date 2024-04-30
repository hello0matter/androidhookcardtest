package p1;

import android.util.Property;
import android.view.ViewGroup;
import com.example.msphone.R;

/* loaded from: classes.dex */
public final class d extends Property {

    /* renamed from: a  reason: collision with root package name */
    public static final d f6134a = new Property(Float.class, "childrenAlpha");

    @Override // android.util.Property
    public final Object get(Object obj) {
        Float f4 = (Float) ((ViewGroup) obj).getTag(R.id.mtrl_internal_children_alpha_tag);
        if (f4 == null) {
            return Float.valueOf(1.0f);
        }
        return f4;
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        ViewGroup viewGroup = (ViewGroup) obj;
        Float f4 = (Float) obj2;
        float floatValue = f4.floatValue();
        viewGroup.setTag(R.id.mtrl_internal_children_alpha_tag, f4);
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            viewGroup.getChildAt(i4).setAlpha(floatValue);
        }
    }
}
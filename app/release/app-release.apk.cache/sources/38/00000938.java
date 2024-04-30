package p2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.example.msphone.R;
import f.f;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f6143a = {16842752, R.attr.theme};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f6144b = {R.attr.materialThemeOverlay};

    public static Context a(Context context, AttributeSet attributeSet, int i4, int i5) {
        boolean z4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f6144b, i4, i5);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        if ((context instanceof f) && ((f) context).f4447a == resourceId) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (resourceId != 0 && !z4) {
            f fVar = new f(context, resourceId);
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f6143a);
            int resourceId2 = obtainStyledAttributes2.getResourceId(0, 0);
            int resourceId3 = obtainStyledAttributes2.getResourceId(1, 0);
            obtainStyledAttributes2.recycle();
            if (resourceId2 == 0) {
                resourceId2 = resourceId3;
            }
            if (resourceId2 != 0) {
                fVar.getTheme().applyStyle(resourceId2, true);
            }
            return fVar;
        }
        return context;
    }
}
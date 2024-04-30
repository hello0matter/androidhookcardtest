package t;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final float f6571a;

    /* renamed from: b  reason: collision with root package name */
    public final float f6572b;

    /* renamed from: c  reason: collision with root package name */
    public final float f6573c;

    /* renamed from: d  reason: collision with root package name */
    public final float f6574d;

    /* renamed from: e  reason: collision with root package name */
    public final int f6575e;

    /* renamed from: f  reason: collision with root package name */
    public final androidx.constraintlayout.widget.d f6576f;

    public c(Context context, XmlResourceParser xmlResourceParser) {
        this.f6571a = Float.NaN;
        this.f6572b = Float.NaN;
        this.f6573c = Float.NaN;
        this.f6574d = Float.NaN;
        this.f6575e = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), k.f6668u);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = obtainStyledAttributes.getIndex(i4);
            if (index == 0) {
                int resourceId = obtainStyledAttributes.getResourceId(index, this.f6575e);
                this.f6575e = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
                    this.f6576f = dVar;
                    dVar.d((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            } else if (index == 1) {
                this.f6574d = obtainStyledAttributes.getDimension(index, this.f6574d);
            } else if (index == 2) {
                this.f6572b = obtainStyledAttributes.getDimension(index, this.f6572b);
            } else if (index == 3) {
                this.f6573c = obtainStyledAttributes.getDimension(index, this.f6573c);
            } else if (index == 4) {
                this.f6571a = obtainStyledAttributes.getDimension(index, this.f6571a);
            } else {
                Log.v("ConstraintLayoutStates", "Unknown tag");
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final boolean a(float f4, float f5) {
        float f6 = this.f6571a;
        if (!Float.isNaN(f6) && f4 < f6) {
            return false;
        }
        float f7 = this.f6572b;
        if (!Float.isNaN(f7) && f5 < f7) {
            return false;
        }
        float f8 = this.f6573c;
        if (!Float.isNaN(f8) && f4 > f8) {
            return false;
        }
        float f9 = this.f6574d;
        if (!Float.isNaN(f9) && f5 > f9) {
            return false;
        }
        return true;
    }
}
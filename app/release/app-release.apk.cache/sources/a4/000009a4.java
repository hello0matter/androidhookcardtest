package t;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public final float f6672a;

    /* renamed from: b  reason: collision with root package name */
    public final float f6673b;

    /* renamed from: c  reason: collision with root package name */
    public final float f6674c;

    /* renamed from: d  reason: collision with root package name */
    public final float f6675d;

    /* renamed from: e  reason: collision with root package name */
    public final int f6676e;

    public m(Context context, XmlResourceParser xmlResourceParser) {
        this.f6672a = Float.NaN;
        this.f6673b = Float.NaN;
        this.f6674c = Float.NaN;
        this.f6675d = Float.NaN;
        this.f6676e = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), k.f6668u);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = obtainStyledAttributes.getIndex(i4);
            if (index == 0) {
                int resourceId = obtainStyledAttributes.getResourceId(index, this.f6676e);
                this.f6676e = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                "layout".equals(resourceTypeName);
            } else if (index == 1) {
                this.f6675d = obtainStyledAttributes.getDimension(index, this.f6675d);
            } else if (index == 2) {
                this.f6673b = obtainStyledAttributes.getDimension(index, this.f6673b);
            } else if (index == 3) {
                this.f6674c = obtainStyledAttributes.getDimension(index, this.f6674c);
            } else if (index == 4) {
                this.f6672a = obtainStyledAttributes.getDimension(index, this.f6672a);
            } else {
                Log.v("ConstraintLayoutStates", "Unknown tag");
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final boolean a(float f4, float f5) {
        float f6 = this.f6672a;
        if (!Float.isNaN(f6) && f4 < f6) {
            return false;
        }
        float f7 = this.f6673b;
        if (!Float.isNaN(f7) && f5 < f7) {
            return false;
        }
        float f8 = this.f6674c;
        if (!Float.isNaN(f8) && f4 > f8) {
            return false;
        }
        float f9 = this.f6675d;
        if (!Float.isNaN(f9) && f5 > f9) {
            return false;
        }
        return true;
    }
}
package t;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final int f6669a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f6670b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final int f6671c;

    public l(Context context, XmlResourceParser xmlResourceParser) {
        this.f6671c = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), k.f6664q);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = obtainStyledAttributes.getIndex(i4);
            if (index == 0) {
                this.f6669a = obtainStyledAttributes.getResourceId(index, this.f6669a);
            } else if (index == 1) {
                int resourceId = obtainStyledAttributes.getResourceId(index, this.f6671c);
                this.f6671c = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                "layout".equals(resourceTypeName);
            }
        }
        obtainStyledAttributes.recycle();
    }
}
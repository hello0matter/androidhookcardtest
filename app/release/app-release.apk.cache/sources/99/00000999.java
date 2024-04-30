package t;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f6567a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f6568b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final int f6569c;

    /* renamed from: d  reason: collision with root package name */
    public final androidx.constraintlayout.widget.d f6570d;

    public b(Context context, XmlResourceParser xmlResourceParser) {
        this.f6569c = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), k.f6664q);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = obtainStyledAttributes.getIndex(i4);
            if (index == 0) {
                this.f6567a = obtainStyledAttributes.getResourceId(index, this.f6567a);
            } else if (index == 1) {
                int resourceId = obtainStyledAttributes.getResourceId(index, this.f6569c);
                this.f6569c = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
                    this.f6570d = dVar;
                    dVar.d((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            }
        }
        obtainStyledAttributes.recycle();
    }
}
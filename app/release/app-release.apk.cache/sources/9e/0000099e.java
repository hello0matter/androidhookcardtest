package t;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public boolean f6629a;

    /* renamed from: b  reason: collision with root package name */
    public int f6630b;

    /* renamed from: c  reason: collision with root package name */
    public int f6631c;

    /* renamed from: d  reason: collision with root package name */
    public float f6632d;

    /* renamed from: e  reason: collision with root package name */
    public float f6633e;

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f6663p);
        this.f6629a = true;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = obtainStyledAttributes.getIndex(i4);
            if (index == 1) {
                this.f6632d = obtainStyledAttributes.getFloat(index, this.f6632d);
            } else if (index == 0) {
                int i5 = obtainStyledAttributes.getInt(index, this.f6630b);
                this.f6630b = i5;
                this.f6630b = androidx.constraintlayout.widget.d.f1317d[i5];
            } else if (index == 4) {
                this.f6631c = obtainStyledAttributes.getInt(index, this.f6631c);
            } else if (index == 3) {
                this.f6633e = obtainStyledAttributes.getFloat(index, this.f6633e);
            }
        }
        obtainStyledAttributes.recycle();
    }
}
package t;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.annotation.VisibleForTesting;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: h  reason: collision with root package name */
    public static final SparseIntArray f6621h;

    /* renamed from: a  reason: collision with root package name */
    public boolean f6622a;

    /* renamed from: b  reason: collision with root package name */
    public int f6623b;

    /* renamed from: c  reason: collision with root package name */
    public String f6624c;

    /* renamed from: d  reason: collision with root package name */
    public int f6625d;

    /* renamed from: e  reason: collision with root package name */
    public int f6626e;

    /* renamed from: f  reason: collision with root package name */
    public float f6627f;

    /* renamed from: g  reason: collision with root package name */
    public float f6628g;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f6621h = sparseIntArray;
        sparseIntArray.append(2, 1);
        sparseIntArray.append(4, 2);
        sparseIntArray.append(5, 3);
        sparseIntArray.append(1, 4);
        sparseIntArray.append(0, 5);
        sparseIntArray.append(3, 6);
    }

    public final void a(f fVar) {
        this.f6622a = fVar.f6622a;
        this.f6623b = fVar.f6623b;
        this.f6624c = fVar.f6624c;
        this.f6625d = fVar.f6625d;
        this.f6626e = fVar.f6626e;
        this.f6628g = fVar.f6628g;
        this.f6627f = fVar.f6627f;
    }

    public final void b(Context context, AttributeSet attributeSet) {
        String str;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f6656i);
        this.f6622a = true;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = obtainStyledAttributes.getIndex(i4);
            switch (f6621h.get(index)) {
                case 1:
                    this.f6628g = obtainStyledAttributes.getFloat(index, this.f6628g);
                    break;
                case 2:
                    this.f6625d = obtainStyledAttributes.getInt(index, this.f6625d);
                    break;
                case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                    if (obtainStyledAttributes.peekValue(index).type == 3) {
                        str = obtainStyledAttributes.getString(index);
                    } else {
                        str = n.e.f5672c[obtainStyledAttributes.getInteger(index, 0)];
                    }
                    this.f6624c = str;
                    break;
                case VisibleForTesting.PROTECTED /* 4 */:
                    this.f6626e = obtainStyledAttributes.getInt(index, 0);
                    break;
                case VisibleForTesting.NONE /* 5 */:
                    this.f6623b = androidx.constraintlayout.widget.d.j(obtainStyledAttributes, index, this.f6623b);
                    break;
                case 6:
                    this.f6627f = obtainStyledAttributes.getFloat(index, this.f6627f);
                    break;
            }
        }
        obtainStyledAttributes.recycle();
    }
}
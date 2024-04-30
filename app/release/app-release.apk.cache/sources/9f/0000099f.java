package t;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.annotation.VisibleForTesting;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: n  reason: collision with root package name */
    public static final SparseIntArray f6634n;

    /* renamed from: a  reason: collision with root package name */
    public boolean f6635a;

    /* renamed from: b  reason: collision with root package name */
    public float f6636b;

    /* renamed from: c  reason: collision with root package name */
    public float f6637c;

    /* renamed from: d  reason: collision with root package name */
    public float f6638d;

    /* renamed from: e  reason: collision with root package name */
    public float f6639e;

    /* renamed from: f  reason: collision with root package name */
    public float f6640f;

    /* renamed from: g  reason: collision with root package name */
    public float f6641g;

    /* renamed from: h  reason: collision with root package name */
    public float f6642h;

    /* renamed from: i  reason: collision with root package name */
    public float f6643i;

    /* renamed from: j  reason: collision with root package name */
    public float f6644j;

    /* renamed from: k  reason: collision with root package name */
    public float f6645k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f6646l;

    /* renamed from: m  reason: collision with root package name */
    public float f6647m;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f6634n = sparseIntArray;
        sparseIntArray.append(6, 1);
        sparseIntArray.append(7, 2);
        sparseIntArray.append(8, 3);
        sparseIntArray.append(4, 4);
        sparseIntArray.append(5, 5);
        sparseIntArray.append(0, 6);
        sparseIntArray.append(1, 7);
        sparseIntArray.append(2, 8);
        sparseIntArray.append(3, 9);
        sparseIntArray.append(9, 10);
        sparseIntArray.append(10, 11);
    }

    public final void a(h hVar) {
        this.f6635a = hVar.f6635a;
        this.f6636b = hVar.f6636b;
        this.f6637c = hVar.f6637c;
        this.f6638d = hVar.f6638d;
        this.f6639e = hVar.f6639e;
        this.f6640f = hVar.f6640f;
        this.f6641g = hVar.f6641g;
        this.f6642h = hVar.f6642h;
        this.f6643i = hVar.f6643i;
        this.f6644j = hVar.f6644j;
        this.f6645k = hVar.f6645k;
        this.f6646l = hVar.f6646l;
        this.f6647m = hVar.f6647m;
    }

    public final void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f6666s);
        this.f6635a = true;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = obtainStyledAttributes.getIndex(i4);
            switch (f6634n.get(index)) {
                case 1:
                    this.f6636b = obtainStyledAttributes.getFloat(index, this.f6636b);
                    break;
                case 2:
                    this.f6637c = obtainStyledAttributes.getFloat(index, this.f6637c);
                    break;
                case VisibleForTesting.PACKAGE_PRIVATE /* 3 */:
                    this.f6638d = obtainStyledAttributes.getFloat(index, this.f6638d);
                    break;
                case VisibleForTesting.PROTECTED /* 4 */:
                    this.f6639e = obtainStyledAttributes.getFloat(index, this.f6639e);
                    break;
                case VisibleForTesting.NONE /* 5 */:
                    this.f6640f = obtainStyledAttributes.getFloat(index, this.f6640f);
                    break;
                case 6:
                    this.f6641g = obtainStyledAttributes.getDimension(index, this.f6641g);
                    break;
                case 7:
                    this.f6642h = obtainStyledAttributes.getDimension(index, this.f6642h);
                    break;
                case 8:
                    this.f6643i = obtainStyledAttributes.getDimension(index, this.f6643i);
                    break;
                case 9:
                    this.f6644j = obtainStyledAttributes.getDimension(index, this.f6644j);
                    break;
                case 10:
                    this.f6645k = obtainStyledAttributes.getDimension(index, this.f6645k);
                    break;
                case 11:
                    this.f6646l = true;
                    this.f6647m = obtainStyledAttributes.getDimension(index, this.f6647m);
                    break;
            }
        }
        obtainStyledAttributes.recycle();
    }
}
package h2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.example.msphone.R;
import com.google.android.material.internal.h0;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public int f4819a;

    /* renamed from: b  reason: collision with root package name */
    public int f4820b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f4821c;

    /* renamed from: d  reason: collision with root package name */
    public int f4822d;

    /* renamed from: e  reason: collision with root package name */
    public int f4823e;

    /* renamed from: f  reason: collision with root package name */
    public int f4824f;

    public d(Context context, AttributeSet attributeSet, int i4, int i5) {
        int a5;
        this.f4821c = new int[0];
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_track_thickness);
        int[] iArr = o1.a.f5942d;
        h0.a(context, attributeSet, i4, i5);
        h0.b(context, attributeSet, iArr, i4, i5, new int[0]);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i4, i5);
        this.f4819a = i2.d.c(context, obtainStyledAttributes, 8, dimensionPixelSize);
        this.f4820b = Math.min(i2.d.c(context, obtainStyledAttributes, 7, 0), this.f4819a / 2);
        this.f4823e = obtainStyledAttributes.getInt(4, 0);
        this.f4824f = obtainStyledAttributes.getInt(1, 0);
        if (!obtainStyledAttributes.hasValue(2)) {
            this.f4821c = new int[]{y1.a.c(context, R.attr.colorPrimary, -1)};
        } else if (obtainStyledAttributes.peekValue(2).type != 1) {
            this.f4821c = new int[]{obtainStyledAttributes.getColor(2, -1)};
        } else {
            int[] intArray = context.getResources().getIntArray(obtainStyledAttributes.getResourceId(2, -1));
            this.f4821c = intArray;
            if (intArray.length == 0) {
                throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
            }
        }
        if (obtainStyledAttributes.hasValue(6)) {
            a5 = obtainStyledAttributes.getColor(6, -1);
        } else {
            this.f4822d = this.f4821c[0];
            TypedArray obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(new int[]{16842803});
            float f4 = obtainStyledAttributes2.getFloat(0, 0.2f);
            obtainStyledAttributes2.recycle();
            a5 = y1.a.a(this.f4822d, (int) (f4 * 255.0f));
        }
        this.f4822d = a5;
        obtainStyledAttributes.recycle();
    }

    public abstract void a();
}
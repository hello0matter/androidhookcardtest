package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f733a;

    /* renamed from: b  reason: collision with root package name */
    public final androidx.appcompat.app.o0 f734b;

    public d0(TextView textView) {
        this.f733a = textView;
        this.f734b = new androidx.appcompat.app.o0(textView);
    }

    public final InputFilter[] a(InputFilter[] inputFilterArr) {
        return ((l2.f) this.f734b.f311b).g(inputFilterArr);
    }

    public final void b(AttributeSet attributeSet, int i4) {
        TypedArray obtainStyledAttributes = this.f733a.getContext().obtainStyledAttributes(attributeSet, c.a.f2552j, i4, 0);
        try {
            boolean z4 = obtainStyledAttributes.hasValue(14) ? obtainStyledAttributes.getBoolean(14, true) : true;
            obtainStyledAttributes.recycle();
            d(z4);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void c(boolean z4) {
        ((l2.f) this.f734b.f311b).o(z4);
    }

    public final void d(boolean z4) {
        ((l2.f) this.f734b.f311b).r(z4);
    }
}
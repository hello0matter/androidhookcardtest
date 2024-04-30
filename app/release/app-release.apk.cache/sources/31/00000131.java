package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f738a;

    /* renamed from: b  reason: collision with root package name */
    public o3 f739b;

    /* renamed from: c  reason: collision with root package name */
    public int f740c = 0;

    public e0(ImageView imageView) {
        this.f738a = imageView;
    }

    public final void a() {
        o3 o3Var;
        ImageView imageView = this.f738a;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            o1.a(drawable);
        }
        if (drawable == null || (o3Var = this.f739b) == null) {
            return;
        }
        a0.e(drawable, o3Var, imageView.getDrawableState());
    }

    public final void b(AttributeSet attributeSet, int i4) {
        int resourceId;
        ImageView imageView = this.f738a;
        Context context = imageView.getContext();
        int[] iArr = c.a.f2549g;
        q3 f4 = q3.f(context, attributeSet, iArr, i4, 0);
        i0.y0.o(imageView, imageView.getContext(), iArr, attributeSet, f4.f879b, i4);
        try {
            Drawable drawable = imageView.getDrawable();
            TypedArray typedArray = f4.f879b;
            if (drawable == null && (resourceId = typedArray.getResourceId(1, -1)) != -1 && (drawable = com.google.common.collect.c.t0(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                o1.a(drawable);
            }
            if (typedArray.hasValue(2)) {
                androidx.core.widget.g.c(imageView, f4.a(2));
            }
            if (typedArray.hasValue(3)) {
                androidx.core.widget.g.d(imageView, o1.c(typedArray.getInt(3, -1), null));
            }
            f4.g();
        } catch (Throwable th) {
            f4.g();
            throw th;
        }
    }

    public final void c(int i4) {
        Drawable drawable;
        ImageView imageView = this.f738a;
        if (i4 != 0) {
            drawable = com.google.common.collect.c.t0(imageView.getContext(), i4);
            if (drawable != null) {
                o1.a(drawable);
            }
        } else {
            drawable = null;
        }
        imageView.setImageDrawable(drawable);
        a();
    }
}
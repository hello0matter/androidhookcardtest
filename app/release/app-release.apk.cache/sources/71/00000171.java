package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

/* loaded from: classes.dex */
public final class q3 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f878a;

    /* renamed from: b  reason: collision with root package name */
    public final TypedArray f879b;

    /* renamed from: c  reason: collision with root package name */
    public TypedValue f880c;

    public q3(Context context, TypedArray typedArray) {
        this.f878a = context;
        this.f879b = typedArray;
    }

    public static q3 e(Context context, AttributeSet attributeSet, int[] iArr) {
        return new q3(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static q3 f(Context context, AttributeSet attributeSet, int[] iArr, int i4, int i5) {
        return new q3(context, context.obtainStyledAttributes(attributeSet, iArr, i4, i5));
    }

    public final ColorStateList a(int i4) {
        int resourceId;
        ColorStateList b5;
        TypedArray typedArray = this.f879b;
        if (typedArray.hasValue(i4) && (resourceId = typedArray.getResourceId(i4, 0)) != 0 && (b5 = z.e.b(this.f878a, resourceId)) != null) {
            return b5;
        }
        return typedArray.getColorStateList(i4);
    }

    public final Drawable b(int i4) {
        int resourceId;
        TypedArray typedArray = this.f879b;
        return (!typedArray.hasValue(i4) || (resourceId = typedArray.getResourceId(i4, 0)) == 0) ? typedArray.getDrawable(i4) : com.google.common.collect.c.t0(this.f878a, resourceId);
    }

    public final Drawable c(int i4) {
        int resourceId;
        Drawable f4;
        if (this.f879b.hasValue(i4) && (resourceId = this.f879b.getResourceId(i4, 0)) != 0) {
            a0 a5 = a0.a();
            Context context = this.f878a;
            synchronized (a5) {
                f4 = a5.f693a.f(context, resourceId, true);
            }
            return f4;
        }
        return null;
    }

    public final Typeface d(int i4, int i5, s0 s0Var) {
        int resourceId = this.f879b.getResourceId(i4, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f880c == null) {
            this.f880c = new TypedValue();
        }
        TypedValue typedValue = this.f880c;
        ThreadLocal threadLocal = a0.s.f38a;
        Context context = this.f878a;
        if (context.isRestricted()) {
            return null;
        }
        return a0.s.b(context, resourceId, typedValue, i5, s0Var, true, false);
    }

    public final void g() {
        this.f879b.recycle();
    }
}
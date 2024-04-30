package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class y0 {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f972a;

    /* renamed from: b  reason: collision with root package name */
    public o3 f973b;

    /* renamed from: c  reason: collision with root package name */
    public o3 f974c;

    /* renamed from: d  reason: collision with root package name */
    public o3 f975d;

    /* renamed from: e  reason: collision with root package name */
    public o3 f976e;

    /* renamed from: f  reason: collision with root package name */
    public o3 f977f;

    /* renamed from: g  reason: collision with root package name */
    public o3 f978g;

    /* renamed from: h  reason: collision with root package name */
    public o3 f979h;

    /* renamed from: i  reason: collision with root package name */
    public final i1 f980i;

    /* renamed from: j  reason: collision with root package name */
    public int f981j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f982k = -1;

    /* renamed from: l  reason: collision with root package name */
    public Typeface f983l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f984m;

    public y0(TextView textView) {
        this.f972a = textView;
        this.f980i = new i1(textView);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.appcompat.widget.o3, java.lang.Object] */
    public static o3 c(Context context, a0 a0Var, int i4) {
        ColorStateList h4;
        synchronized (a0Var) {
            h4 = a0Var.f693a.h(context, i4);
        }
        if (h4 != null) {
            ?? obj = new Object();
            obj.f871d = true;
            obj.f868a = h4;
            return obj;
        }
        return null;
    }

    public static void h(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        int i4;
        int i5;
        int i6;
        CharSequence subSequence;
        int i7 = Build.VERSION.SDK_INT;
        if (i7 < 30 && inputConnection != null) {
            CharSequence text = textView.getText();
            if (i7 >= 30) {
                l0.b.a(editorInfo, text);
                return;
            }
            text.getClass();
            if (i7 >= 30) {
                l0.b.a(editorInfo, text);
                return;
            }
            int i8 = editorInfo.initialSelStart;
            int i9 = editorInfo.initialSelEnd;
            if (i8 > i9) {
                i4 = i9;
            } else {
                i4 = i8;
            }
            if (i8 <= i9) {
                i8 = i9;
            }
            int length = text.length();
            if (i4 >= 0 && i8 <= length && (i5 = editorInfo.inputType & 4095) != 129 && i5 != 225 && i5 != 18) {
                if (length <= 2048) {
                    l0.c.a(editorInfo, text, i4, i8);
                    return;
                }
                int i10 = i8 - i4;
                if (i10 > 1024) {
                    i6 = 0;
                } else {
                    i6 = i10;
                }
                int i11 = 2048 - i6;
                int min = Math.min(text.length() - i8, i11 - Math.min(i4, (int) (i11 * 0.8d)));
                int min2 = Math.min(i4, i11 - min);
                int i12 = i4 - min2;
                if (Character.isLowSurrogate(text.charAt(i12))) {
                    i12++;
                    min2--;
                }
                if (Character.isHighSurrogate(text.charAt((i8 + min) - 1))) {
                    min--;
                }
                int i13 = min2 + i6;
                int i14 = i13 + min;
                if (i6 != i10) {
                    subSequence = TextUtils.concat(text.subSequence(i12, i12 + min2), text.subSequence(i8, min + i8));
                } else {
                    subSequence = text.subSequence(i12, i14 + i12);
                }
                l0.c.a(editorInfo, subSequence, min2, i13);
                return;
            }
            l0.c.a(editorInfo, null, 0, 0);
        }
    }

    public final void a(Drawable drawable, o3 o3Var) {
        if (drawable == null || o3Var == null) {
            return;
        }
        a0.e(drawable, o3Var, this.f972a.getDrawableState());
    }

    public final void b() {
        o3 o3Var = this.f973b;
        TextView textView = this.f972a;
        if (o3Var != null || this.f974c != null || this.f975d != null || this.f976e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.f973b);
            a(compoundDrawables[1], this.f974c);
            a(compoundDrawables[2], this.f975d);
            a(compoundDrawables[3], this.f976e);
        }
        if (this.f977f == null && this.f978g == null) {
            return;
        }
        Drawable[] a5 = u0.a(textView);
        a(a5[0], this.f977f);
        a(a5[2], this.f978g);
    }

    public final ColorStateList d() {
        o3 o3Var = this.f979h;
        if (o3Var != null) {
            return o3Var.f868a;
        }
        return null;
    }

    public final PorterDuff.Mode e() {
        o3 o3Var = this.f979h;
        if (o3Var != null) {
            return o3Var.f869b;
        }
        return null;
    }

    public final void f(AttributeSet attributeSet, int i4) {
        boolean z4;
        boolean z5;
        String str;
        String str2;
        boolean z6;
        float f4;
        float f5;
        float f6;
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        Drawable drawable6;
        int i5;
        int fontMetricsInt;
        ColorStateList colorStateList;
        int resourceId;
        int i6;
        int resourceId2;
        TextView textView = this.f972a;
        Context context = textView.getContext();
        a0 a5 = a0.a();
        int[] iArr = c.a.f2551i;
        q3 f7 = q3.f(context, attributeSet, iArr, i4, 0);
        i0.y0.o(textView, textView.getContext(), iArr, attributeSet, f7.f879b, i4);
        TypedArray typedArray = f7.f879b;
        int resourceId3 = typedArray.getResourceId(0, -1);
        if (typedArray.hasValue(3)) {
            this.f973b = c(context, a5, typedArray.getResourceId(3, 0));
        }
        if (typedArray.hasValue(1)) {
            this.f974c = c(context, a5, typedArray.getResourceId(1, 0));
        }
        if (typedArray.hasValue(4)) {
            this.f975d = c(context, a5, typedArray.getResourceId(4, 0));
        }
        if (typedArray.hasValue(2)) {
            this.f976e = c(context, a5, typedArray.getResourceId(2, 0));
        }
        int i7 = Build.VERSION.SDK_INT;
        if (typedArray.hasValue(5)) {
            this.f977f = c(context, a5, typedArray.getResourceId(5, 0));
        }
        if (typedArray.hasValue(6)) {
            this.f978g = c(context, a5, typedArray.getResourceId(6, 0));
        }
        f7.g();
        boolean z7 = textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        int[] iArr2 = c.a.f2568z;
        if (resourceId3 != -1) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(resourceId3, iArr2);
            q3 q3Var = new q3(context, obtainStyledAttributes);
            if (!z7 && obtainStyledAttributes.hasValue(14)) {
                z4 = obtainStyledAttributes.getBoolean(14, false);
                z5 = true;
            } else {
                z4 = false;
                z5 = false;
            }
            n(context, q3Var);
            if (obtainStyledAttributes.hasValue(15)) {
                str2 = obtainStyledAttributes.getString(15);
            } else {
                str2 = null;
            }
            if (i7 >= 26 && obtainStyledAttributes.hasValue(13)) {
                str = obtainStyledAttributes.getString(13);
            } else {
                str = null;
            }
            q3Var.g();
        } else {
            z4 = false;
            z5 = false;
            str = null;
            str2 = null;
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i4, 0);
        q3 q3Var2 = new q3(context, obtainStyledAttributes2);
        if (!z7 && obtainStyledAttributes2.hasValue(14)) {
            z6 = obtainStyledAttributes2.getBoolean(14, false);
            z5 = true;
        } else {
            z6 = z4;
        }
        if (obtainStyledAttributes2.hasValue(15)) {
            str2 = obtainStyledAttributes2.getString(15);
        }
        if (i7 >= 26 && obtainStyledAttributes2.hasValue(13)) {
            str = obtainStyledAttributes2.getString(13);
        }
        if (i7 >= 28 && obtainStyledAttributes2.hasValue(0) && obtainStyledAttributes2.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        n(context, q3Var2);
        q3Var2.g();
        if (!z7 && z5) {
            textView.setAllCaps(z6);
        }
        Typeface typeface = this.f983l;
        if (typeface != null) {
            if (this.f982k == -1) {
                textView.setTypeface(typeface, this.f981j);
            } else {
                textView.setTypeface(typeface);
            }
        }
        if (str != null) {
            w0.d(textView, str);
        }
        if (str2 != null) {
            v0.b(textView, v0.a(str2));
        }
        int[] iArr3 = c.a.f2552j;
        i1 i1Var = this.f980i;
        Context context2 = i1Var.f782j;
        TypedArray obtainStyledAttributes3 = context2.obtainStyledAttributes(attributeSet, iArr3, i4, 0);
        TextView textView2 = i1Var.f781i;
        i0.y0.o(textView2, textView2.getContext(), iArr3, attributeSet, obtainStyledAttributes3, i4);
        if (obtainStyledAttributes3.hasValue(5)) {
            i1Var.f773a = obtainStyledAttributes3.getInt(5, 0);
        }
        if (obtainStyledAttributes3.hasValue(4)) {
            f4 = obtainStyledAttributes3.getDimension(4, -1.0f);
        } else {
            f4 = -1.0f;
        }
        if (obtainStyledAttributes3.hasValue(2)) {
            f5 = obtainStyledAttributes3.getDimension(2, -1.0f);
        } else {
            f5 = -1.0f;
        }
        if (obtainStyledAttributes3.hasValue(1)) {
            f6 = obtainStyledAttributes3.getDimension(1, -1.0f);
        } else {
            f6 = -1.0f;
        }
        if (obtainStyledAttributes3.hasValue(3) && (resourceId2 = obtainStyledAttributes3.getResourceId(3, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes3.getResources().obtainTypedArray(resourceId2);
            int length = obtainTypedArray.length();
            int[] iArr4 = new int[length];
            if (length > 0) {
                for (int i8 = 0; i8 < length; i8++) {
                    iArr4[i8] = obtainTypedArray.getDimensionPixelSize(i8, -1);
                }
                i1Var.f778f = i1.b(iArr4);
                i1Var.i();
            }
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes3.recycle();
        if (i1Var.j()) {
            if (i1Var.f773a == 1) {
                if (!i1Var.f779g) {
                    DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
                    if (f5 == -1.0f) {
                        i6 = 2;
                        f5 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    } else {
                        i6 = 2;
                    }
                    if (f6 == -1.0f) {
                        f6 = TypedValue.applyDimension(i6, 112.0f, displayMetrics);
                    }
                    if (f4 == -1.0f) {
                        f4 = 1.0f;
                    }
                    i1Var.k(f5, f6, f4);
                }
                i1Var.h();
            }
        } else {
            i1Var.f773a = 0;
        }
        if (e4.f744b && i1Var.f773a != 0) {
            int[] iArr5 = i1Var.f778f;
            if (iArr5.length > 0) {
                if (w0.a(textView) != -1.0f) {
                    w0.b(textView, Math.round(i1Var.f776d), Math.round(i1Var.f777e), Math.round(i1Var.f775c), 0);
                } else {
                    w0.c(textView, iArr5, 0);
                }
            }
        }
        TypedArray obtainStyledAttributes4 = context.obtainStyledAttributes(attributeSet, iArr3);
        int resourceId4 = obtainStyledAttributes4.getResourceId(8, -1);
        if (resourceId4 != -1) {
            drawable = a5.b(context, resourceId4);
        } else {
            drawable = null;
        }
        int resourceId5 = obtainStyledAttributes4.getResourceId(13, -1);
        if (resourceId5 != -1) {
            drawable2 = a5.b(context, resourceId5);
        } else {
            drawable2 = null;
        }
        int resourceId6 = obtainStyledAttributes4.getResourceId(9, -1);
        if (resourceId6 != -1) {
            drawable3 = a5.b(context, resourceId6);
        } else {
            drawable3 = null;
        }
        int resourceId7 = obtainStyledAttributes4.getResourceId(6, -1);
        if (resourceId7 != -1) {
            drawable4 = a5.b(context, resourceId7);
        } else {
            drawable4 = null;
        }
        int resourceId8 = obtainStyledAttributes4.getResourceId(10, -1);
        if (resourceId8 != -1) {
            drawable5 = a5.b(context, resourceId8);
        } else {
            drawable5 = null;
        }
        int resourceId9 = obtainStyledAttributes4.getResourceId(7, -1);
        if (resourceId9 != -1) {
            drawable6 = a5.b(context, resourceId9);
        } else {
            drawable6 = null;
        }
        if (drawable5 == null && drawable6 == null) {
            if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
                Drawable[] a6 = u0.a(textView);
                Drawable drawable7 = a6[0];
                if (drawable7 == null && a6[2] == null) {
                    Drawable[] compoundDrawables = textView.getCompoundDrawables();
                    if (drawable == null) {
                        drawable = compoundDrawables[0];
                    }
                    if (drawable2 == null) {
                        drawable2 = compoundDrawables[1];
                    }
                    if (drawable3 == null) {
                        drawable3 = compoundDrawables[2];
                    }
                    if (drawable4 == null) {
                        drawable4 = compoundDrawables[3];
                    }
                    textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                } else {
                    if (drawable2 == null) {
                        drawable2 = a6[1];
                    }
                    Drawable drawable8 = a6[2];
                    if (drawable4 == null) {
                        drawable4 = a6[3];
                    }
                    u0.b(textView, drawable7, drawable2, drawable8, drawable4);
                }
            }
        } else {
            Drawable[] a7 = u0.a(textView);
            if (drawable5 == null) {
                drawable5 = a7[0];
            }
            if (drawable2 == null) {
                drawable2 = a7[1];
            }
            if (drawable6 == null) {
                drawable6 = a7[2];
            }
            if (drawable4 == null) {
                drawable4 = a7[3];
            }
            u0.b(textView, drawable5, drawable2, drawable6, drawable4);
        }
        if (obtainStyledAttributes4.hasValue(11)) {
            if (!obtainStyledAttributes4.hasValue(11) || (resourceId = obtainStyledAttributes4.getResourceId(11, 0)) == 0 || (colorStateList = z.e.b(context, resourceId)) == null) {
                colorStateList = obtainStyledAttributes4.getColorStateList(11);
            }
            androidx.core.widget.r.f(textView, colorStateList);
        }
        if (obtainStyledAttributes4.hasValue(12)) {
            i5 = -1;
            androidx.core.widget.r.g(textView, o1.c(obtainStyledAttributes4.getInt(12, -1), null));
        } else {
            i5 = -1;
        }
        int dimensionPixelSize = obtainStyledAttributes4.getDimensionPixelSize(15, i5);
        int dimensionPixelSize2 = obtainStyledAttributes4.getDimensionPixelSize(18, i5);
        int dimensionPixelSize3 = obtainStyledAttributes4.getDimensionPixelSize(19, i5);
        obtainStyledAttributes4.recycle();
        if (dimensionPixelSize != i5) {
            androidx.core.widget.v.b(textView, dimensionPixelSize);
        }
        if (dimensionPixelSize2 != i5) {
            androidx.core.widget.v.c(textView, dimensionPixelSize2);
        }
        if (dimensionPixelSize3 != i5) {
            h0.e.b(dimensionPixelSize3);
            if (dimensionPixelSize3 != textView.getPaint().getFontMetricsInt(null)) {
                textView.setLineSpacing(dimensionPixelSize3 - fontMetricsInt, 1.0f);
            }
        }
    }

    public final void g(Context context, int i4) {
        String string;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i4, c.a.f2568z);
        q3 q3Var = new q3(context, obtainStyledAttributes);
        boolean hasValue = obtainStyledAttributes.hasValue(14);
        TextView textView = this.f972a;
        if (hasValue) {
            textView.setAllCaps(obtainStyledAttributes.getBoolean(14, false));
        }
        int i5 = Build.VERSION.SDK_INT;
        if (obtainStyledAttributes.hasValue(0) && obtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        n(context, q3Var);
        if (i5 >= 26 && obtainStyledAttributes.hasValue(13) && (string = obtainStyledAttributes.getString(13)) != null) {
            w0.d(textView, string);
        }
        q3Var.g();
        Typeface typeface = this.f983l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.f981j);
        }
    }

    public final void i(int i4, int i5, int i6, int i7) {
        i1 i1Var = this.f980i;
        if (i1Var.j()) {
            DisplayMetrics displayMetrics = i1Var.f782j.getResources().getDisplayMetrics();
            i1Var.k(TypedValue.applyDimension(i7, i4, displayMetrics), TypedValue.applyDimension(i7, i5, displayMetrics), TypedValue.applyDimension(i7, i6, displayMetrics));
            if (i1Var.h()) {
                i1Var.a();
            }
        }
    }

    public final void j(int[] iArr, int i4) {
        i1 i1Var = this.f980i;
        if (i1Var.j()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i4 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = i1Var.f782j.getResources().getDisplayMetrics();
                    for (int i5 = 0; i5 < length; i5++) {
                        iArr2[i5] = Math.round(TypedValue.applyDimension(i4, iArr[i5], displayMetrics));
                    }
                }
                i1Var.f778f = i1.b(iArr2);
                if (!i1Var.i()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                i1Var.f779g = false;
            }
            if (i1Var.h()) {
                i1Var.a();
            }
        }
    }

    public final void k(int i4) {
        i1 i1Var = this.f980i;
        if (i1Var.j()) {
            if (i4 != 0) {
                if (i4 == 1) {
                    DisplayMetrics displayMetrics = i1Var.f782j.getResources().getDisplayMetrics();
                    i1Var.k(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                    if (i1Var.h()) {
                        i1Var.a();
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException(androidx.activity.j.b("Unknown auto-size text type: ", i4));
            }
            i1Var.f773a = 0;
            i1Var.f776d = -1.0f;
            i1Var.f777e = -1.0f;
            i1Var.f775c = -1.0f;
            i1Var.f778f = new int[0];
            i1Var.f774b = false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.appcompat.widget.o3, java.lang.Object] */
    public final void l(ColorStateList colorStateList) {
        boolean z4;
        if (this.f979h == null) {
            this.f979h = new Object();
        }
        o3 o3Var = this.f979h;
        o3Var.f868a = colorStateList;
        if (colorStateList != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        o3Var.f871d = z4;
        this.f973b = o3Var;
        this.f974c = o3Var;
        this.f975d = o3Var;
        this.f976e = o3Var;
        this.f977f = o3Var;
        this.f978g = o3Var;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.appcompat.widget.o3, java.lang.Object] */
    public final void m(PorterDuff.Mode mode) {
        boolean z4;
        if (this.f979h == null) {
            this.f979h = new Object();
        }
        o3 o3Var = this.f979h;
        o3Var.f869b = mode;
        if (mode != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        o3Var.f870c = z4;
        this.f973b = o3Var;
        this.f974c = o3Var;
        this.f975d = o3Var;
        this.f976e = o3Var;
        this.f977f = o3Var;
        this.f978g = o3Var;
    }

    public final void n(Context context, q3 q3Var) {
        String string;
        Typeface create;
        boolean z4;
        boolean z5;
        Typeface typeface;
        int i4 = this.f981j;
        TypedArray typedArray = q3Var.f879b;
        this.f981j = typedArray.getInt(2, i4);
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 28) {
            int i6 = typedArray.getInt(11, -1);
            this.f982k = i6;
            if (i6 != -1) {
                this.f981j &= 2;
            }
        }
        int i7 = 10;
        boolean z6 = false;
        if (!typedArray.hasValue(10) && !typedArray.hasValue(12)) {
            if (typedArray.hasValue(1)) {
                this.f984m = false;
                int i8 = typedArray.getInt(1, 1);
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 == 3) {
                            typeface = Typeface.MONOSPACE;
                        } else {
                            return;
                        }
                    } else {
                        typeface = Typeface.SERIF;
                    }
                } else {
                    typeface = Typeface.SANS_SERIF;
                }
                this.f983l = typeface;
                return;
            }
            return;
        }
        this.f983l = null;
        if (typedArray.hasValue(12)) {
            i7 = 12;
        }
        int i9 = this.f982k;
        int i10 = this.f981j;
        if (!context.isRestricted()) {
            try {
                Typeface d4 = q3Var.d(i7, this.f981j, new s0(this, i9, i10, new WeakReference(this.f972a)));
                if (d4 != null) {
                    if (i5 >= 28 && this.f982k != -1) {
                        Typeface create2 = Typeface.create(d4, 0);
                        int i11 = this.f982k;
                        if ((this.f981j & 2) != 0) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        d4 = x0.a(create2, i11, z5);
                    }
                    this.f983l = d4;
                }
                if (this.f983l == null) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.f984m = z4;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f983l == null && (string = typedArray.getString(i7)) != null) {
            if (Build.VERSION.SDK_INT >= 28 && this.f982k != -1) {
                Typeface create3 = Typeface.create(string, 0);
                int i12 = this.f982k;
                if ((this.f981j & 2) != 0) {
                    z6 = true;
                }
                create = x0.a(create3, i12, z6);
            } else {
                create = Typeface.create(string, this.f981j);
            }
            this.f983l = create;
        }
    }
}
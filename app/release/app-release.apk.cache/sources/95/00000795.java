package i2;

import a0.s;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final ColorStateList f5050a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5051b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5052c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5053d;

    /* renamed from: e  reason: collision with root package name */
    public final float f5054e;

    /* renamed from: f  reason: collision with root package name */
    public final float f5055f;

    /* renamed from: g  reason: collision with root package name */
    public final float f5056g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f5057h;

    /* renamed from: i  reason: collision with root package name */
    public final float f5058i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f5059j;

    /* renamed from: k  reason: collision with root package name */
    public float f5060k;

    /* renamed from: l  reason: collision with root package name */
    public final int f5061l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f5062m = false;

    /* renamed from: n  reason: collision with root package name */
    public Typeface f5063n;

    public g(Context context, int i4) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i4, o1.a.f5943d0);
        this.f5060k = obtainStyledAttributes.getDimension(0, 0.0f);
        this.f5059j = d.a(context, obtainStyledAttributes, 3);
        d.a(context, obtainStyledAttributes, 4);
        d.a(context, obtainStyledAttributes, 5);
        this.f5052c = obtainStyledAttributes.getInt(2, 0);
        this.f5053d = obtainStyledAttributes.getInt(1, 1);
        int i5 = obtainStyledAttributes.hasValue(12) ? 12 : 10;
        this.f5061l = obtainStyledAttributes.getResourceId(i5, 0);
        this.f5051b = obtainStyledAttributes.getString(i5);
        obtainStyledAttributes.getBoolean(14, false);
        this.f5050a = d.a(context, obtainStyledAttributes, 6);
        this.f5054e = obtainStyledAttributes.getFloat(7, 0.0f);
        this.f5055f = obtainStyledAttributes.getFloat(8, 0.0f);
        this.f5056g = obtainStyledAttributes.getFloat(9, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i4, o1.a.I);
        this.f5057h = obtainStyledAttributes2.hasValue(0);
        this.f5058i = obtainStyledAttributes2.getFloat(0, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    public final void a() {
        Typeface typeface;
        String str;
        Typeface typeface2 = this.f5063n;
        int i4 = this.f5052c;
        if (typeface2 == null && (str = this.f5051b) != null) {
            this.f5063n = Typeface.create(str, i4);
        }
        if (this.f5063n == null) {
            int i5 = this.f5053d;
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        typeface = Typeface.DEFAULT;
                    } else {
                        typeface = Typeface.MONOSPACE;
                    }
                } else {
                    typeface = Typeface.SERIF;
                }
            } else {
                typeface = Typeface.SANS_SERIF;
            }
            this.f5063n = typeface;
            this.f5063n = Typeface.create(this.f5063n, i4);
        }
    }

    public final Typeface b(Context context) {
        if (this.f5062m) {
            return this.f5063n;
        }
        if (!context.isRestricted()) {
            try {
                Typeface a5 = s.a(context, this.f5061l);
                this.f5063n = a5;
                if (a5 != null) {
                    this.f5063n = Typeface.create(a5, this.f5052c);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e4) {
                Log.d("TextAppearance", "Error loading font " + this.f5051b, e4);
            }
        }
        a();
        this.f5062m = true;
        return this.f5063n;
    }

    public final void c(Context context, h hVar) {
        if (d(context)) {
            b(context);
        } else {
            a();
        }
        int i4 = this.f5061l;
        if (i4 == 0) {
            this.f5062m = true;
        }
        if (this.f5062m) {
            hVar.b(this.f5063n, true);
            return;
        }
        try {
            e eVar = new e(this, hVar);
            ThreadLocal threadLocal = s.f38a;
            if (context.isRestricted()) {
                eVar.a(-4);
            } else {
                s.b(context, i4, new TypedValue(), 0, eVar, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.f5062m = true;
            hVar.a(1);
        } catch (Exception e4) {
            Log.d("TextAppearance", "Error loading font " + this.f5051b, e4);
            this.f5062m = true;
            hVar.a(-3);
        }
    }

    public final boolean d(Context context) {
        Typeface typeface = null;
        int i4 = this.f5061l;
        if (i4 != 0) {
            ThreadLocal threadLocal = s.f38a;
            if (!context.isRestricted()) {
                typeface = s.b(context, i4, new TypedValue(), 0, null, false, true);
            }
        }
        if (typeface != null) {
            return true;
        }
        return false;
    }

    public final void e(Context context, TextPaint textPaint, h hVar) {
        int i4;
        int i5;
        f(context, textPaint, hVar);
        ColorStateList colorStateList = this.f5059j;
        if (colorStateList != null) {
            i4 = colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor());
        } else {
            i4 = -16777216;
        }
        textPaint.setColor(i4);
        ColorStateList colorStateList2 = this.f5050a;
        if (colorStateList2 != null) {
            i5 = colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor());
        } else {
            i5 = 0;
        }
        textPaint.setShadowLayer(this.f5056g, this.f5054e, this.f5055f, i5);
    }

    public final void f(Context context, TextPaint textPaint, h hVar) {
        if (d(context)) {
            g(context, textPaint, b(context));
            return;
        }
        a();
        g(context, textPaint, this.f5063n);
        c(context, new f(this, context, textPaint, hVar));
    }

    public final void g(Context context, TextPaint textPaint, Typeface typeface) {
        boolean z4;
        float f4;
        Typeface a5 = i.a(context.getResources().getConfiguration(), typeface);
        if (a5 != null) {
            typeface = a5;
        }
        textPaint.setTypeface(typeface);
        int i4 = (~typeface.getStyle()) & this.f5052c;
        if ((i4 & 1) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        textPaint.setFakeBoldText(z4);
        if ((i4 & 2) != 0) {
            f4 = -0.25f;
        } else {
            f4 = 0.0f;
        }
        textPaint.setTextSkewX(f4);
        textPaint.setTextSize(this.f5060k);
        if (this.f5057h) {
            textPaint.setLetterSpacing(this.f5058i);
        }
    }
}
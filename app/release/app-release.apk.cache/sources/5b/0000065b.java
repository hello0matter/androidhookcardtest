package d1;

import a0.t;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import java.util.ArrayDeque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class p extends g {

    /* renamed from: j  reason: collision with root package name */
    public static final PorterDuff.Mode f4325j = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    public n f4326b;

    /* renamed from: c  reason: collision with root package name */
    public PorterDuffColorFilter f4327c;

    /* renamed from: d  reason: collision with root package name */
    public ColorFilter f4328d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4329e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4330f;

    /* renamed from: g  reason: collision with root package name */
    public final float[] f4331g;

    /* renamed from: h  reason: collision with root package name */
    public final Matrix f4332h;

    /* renamed from: i  reason: collision with root package name */
    public final Rect f4333i;

    /* JADX WARN: Type inference failed for: r0v5, types: [android.graphics.drawable.Drawable$ConstantState, d1.n] */
    public p() {
        this.f4330f = true;
        this.f4331g = new float[9];
        this.f4332h = new Matrix();
        this.f4333i = new Rect();
        ?? constantState = new Drawable.ConstantState();
        constantState.f4314c = null;
        constantState.f4315d = f4325j;
        constantState.f4313b = new m();
        this.f4326b = constantState;
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            c0.b.b(drawable);
            return false;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.f4333i;
        copyBounds(rect);
        if (rect.width() > 0 && rect.height() > 0) {
            ColorFilter colorFilter = this.f4328d;
            if (colorFilter == null) {
                colorFilter = this.f4327c;
            }
            Matrix matrix = this.f4332h;
            canvas.getMatrix(matrix);
            float[] fArr = this.f4331g;
            matrix.getValues(fArr);
            float abs = Math.abs(fArr[0]);
            float abs2 = Math.abs(fArr[4]);
            float abs3 = Math.abs(fArr[1]);
            float abs4 = Math.abs(fArr[3]);
            if (abs3 != 0.0f || abs4 != 0.0f) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (rect.width() * abs));
            int min2 = Math.min(2048, (int) (rect.height() * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                canvas.translate(rect.left, rect.top);
                if (isAutoMirrored() && c0.c.a(this) == 1) {
                    canvas.translate(rect.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                rect.offsetTo(0, 0);
                n nVar = this.f4326b;
                Bitmap bitmap = nVar.f4317f;
                if (bitmap == null || min != bitmap.getWidth() || min2 != nVar.f4317f.getHeight()) {
                    nVar.f4317f = Bitmap.createBitmap(min, min2, Bitmap.Config.ARGB_8888);
                    nVar.f4322k = true;
                }
                if (!this.f4330f) {
                    n nVar2 = this.f4326b;
                    nVar2.f4317f.eraseColor(0);
                    Canvas canvas2 = new Canvas(nVar2.f4317f);
                    m mVar = nVar2.f4313b;
                    mVar.a(mVar.f4303g, m.f4296p, canvas2, min, min2);
                } else {
                    n nVar3 = this.f4326b;
                    if (nVar3.f4322k || nVar3.f4318g != nVar3.f4314c || nVar3.f4319h != nVar3.f4315d || nVar3.f4321j != nVar3.f4316e || nVar3.f4320i != nVar3.f4313b.getRootAlpha()) {
                        n nVar4 = this.f4326b;
                        nVar4.f4317f.eraseColor(0);
                        Canvas canvas3 = new Canvas(nVar4.f4317f);
                        m mVar2 = nVar4.f4313b;
                        mVar2.a(mVar2.f4303g, m.f4296p, canvas3, min, min2);
                        n nVar5 = this.f4326b;
                        nVar5.f4318g = nVar5.f4314c;
                        nVar5.f4319h = nVar5.f4315d;
                        nVar5.f4320i = nVar5.f4313b.getRootAlpha();
                        nVar5.f4321j = nVar5.f4316e;
                        nVar5.f4322k = false;
                    }
                }
                n nVar6 = this.f4326b;
                if (nVar6.f4313b.getRootAlpha() >= 255 && colorFilter == null) {
                    paint = null;
                } else {
                    if (nVar6.f4323l == null) {
                        Paint paint2 = new Paint();
                        nVar6.f4323l = paint2;
                        paint2.setFilterBitmap(true);
                    }
                    nVar6.f4323l.setAlpha(nVar6.f4313b.getRootAlpha());
                    nVar6.f4323l.setColorFilter(colorFilter);
                    paint = nVar6.f4323l;
                }
                canvas.drawBitmap(nVar6.f4317f, (Rect) null, rect, paint);
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return c0.a.a(drawable);
        }
        return this.f4326b.f4313b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f4326b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return c0.b.c(drawable);
        }
        return this.f4328d;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f4268a != null) {
            return new o(this.f4268a.getConstantState());
        }
        this.f4326b.f4312a = getChangingConfigurations();
        return this.f4326b;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f4326b.f4313b.f4305i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f4326b.f4313b.f4304h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return c0.a.d(drawable);
        }
        return this.f4326b.f4316e;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (!super.isStateful()) {
            n nVar = this.f4326b;
            if (nVar != null) {
                m mVar = nVar.f4313b;
                if (mVar.f4310n == null) {
                    mVar.f4310n = Boolean.valueOf(mVar.f4303g.a());
                }
                if (mVar.f4310n.booleanValue() || ((colorStateList = this.f4326b.f4314c) != null && colorStateList.isStateful())) {
                }
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.graphics.drawable.Drawable$ConstantState, d1.n] */
    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f4329e && super.mutate() == this) {
            n nVar = this.f4326b;
            ?? constantState = new Drawable.ConstantState();
            constantState.f4314c = null;
            constantState.f4315d = f4325j;
            if (nVar != null) {
                constantState.f4312a = nVar.f4312a;
                m mVar = new m(nVar.f4313b);
                constantState.f4313b = mVar;
                if (nVar.f4313b.f4301e != null) {
                    mVar.f4301e = new Paint(nVar.f4313b.f4301e);
                }
                if (nVar.f4313b.f4300d != null) {
                    constantState.f4313b.f4300d = new Paint(nVar.f4313b.f4300d);
                }
                constantState.f4314c = nVar.f4314c;
                constantState.f4315d = nVar.f4315d;
                constantState.f4316e = nVar.f4316e;
            }
            this.f4326b = constantState;
            this.f4329e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z4;
        PorterDuff.Mode mode;
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        n nVar = this.f4326b;
        ColorStateList colorStateList = nVar.f4314c;
        if (colorStateList != null && (mode = nVar.f4315d) != null) {
            this.f4327c = a(colorStateList, mode);
            invalidateSelf();
            z4 = true;
        } else {
            z4 = false;
        }
        m mVar = nVar.f4313b;
        if (mVar.f4310n == null) {
            mVar.f4310n = Boolean.valueOf(mVar.f4303g.a());
        }
        if (mVar.f4310n.booleanValue()) {
            boolean b5 = nVar.f4313b.f4303g.b(iArr);
            nVar.f4322k |= b5;
            if (b5) {
                invalidateSelf();
                return true;
            }
        }
        return z4;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j4) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j4);
        } else {
            super.scheduleSelf(runnable, j4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i4) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            drawable.setAlpha(i4);
        } else if (this.f4326b.f4313b.getRootAlpha() != i4) {
            this.f4326b.f4313b.setRootAlpha(i4);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z4) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            c0.a.e(drawable, z4);
        } else {
            this.f4326b.f4316e = z4;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f4328d = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i4) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            com.google.common.collect.c.S1(drawable, i4);
        } else {
            setTintList(ColorStateList.valueOf(i4));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            c0.b.h(drawable, colorStateList);
            return;
        }
        n nVar = this.f4326b;
        if (nVar.f4314c != colorStateList) {
            nVar.f4314c = colorStateList;
            this.f4327c = a(colorStateList, nVar.f4315d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            c0.b.i(drawable, mode);
            return;
        }
        n nVar = this.f4326b;
        if (nVar.f4315d != mode) {
            nVar.f4315d = mode;
            this.f4327c = a(nVar.f4314c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z4, boolean z5) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            return drawable.setVisible(z4, z5);
        }
        return super.setVisible(z4, z5);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v21, types: [d1.l, d1.i, java.lang.Object] */
    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        m mVar;
        int i4;
        int i5;
        boolean z4;
        int i6;
        boolean z5;
        Paint.Cap cap;
        Paint.Join join;
        Drawable drawable = this.f4268a;
        if (drawable != null) {
            c0.b.d(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        n nVar = this.f4326b;
        nVar.f4313b = new m();
        TypedArray e4 = t.e(resources, theme, attributeSet, a.f4249a);
        n nVar2 = this.f4326b;
        m mVar2 = nVar2.f4313b;
        int b5 = t.b(e4, xmlPullParser, "tintMode", 6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        int i7 = 3;
        if (b5 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (b5 != 5) {
            if (b5 != 9) {
                switch (b5) {
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        nVar2.f4315d = mode;
        int i8 = 1;
        ColorStateList colorStateList = null;
        boolean z6 = false;
        if (t.d(xmlPullParser, "tint")) {
            TypedValue typedValue = new TypedValue();
            e4.getValue(1, typedValue);
            int i9 = typedValue.type;
            if (i9 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue);
            } else if (i9 >= 28 && i9 <= 31) {
                colorStateList = ColorStateList.valueOf(typedValue.data);
            } else {
                Resources resources2 = e4.getResources();
                int resourceId = e4.getResourceId(1, 0);
                ThreadLocal threadLocal = a0.c.f12a;
                try {
                    colorStateList = a0.c.a(resources2, resources2.getXml(resourceId), theme);
                } catch (Exception e5) {
                    Log.e("CSLCompat", "Failed to inflate ColorStateList.", e5);
                }
            }
        }
        ColorStateList colorStateList2 = colorStateList;
        if (colorStateList2 != null) {
            nVar2.f4314c = colorStateList2;
        }
        boolean z7 = nVar2.f4316e;
        if (t.d(xmlPullParser, "autoMirrored")) {
            z7 = e4.getBoolean(5, z7);
        }
        nVar2.f4316e = z7;
        float f4 = mVar2.f4306j;
        if (t.d(xmlPullParser, "viewportWidth")) {
            f4 = e4.getFloat(7, f4);
        }
        mVar2.f4306j = f4;
        float f5 = mVar2.f4307k;
        if (t.d(xmlPullParser, "viewportHeight")) {
            f5 = e4.getFloat(8, f5);
        }
        mVar2.f4307k = f5;
        if (mVar2.f4306j <= 0.0f) {
            throw new XmlPullParserException(e4.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (f5 <= 0.0f) {
            throw new XmlPullParserException(e4.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            mVar2.f4304h = e4.getDimension(3, mVar2.f4304h);
            float dimension = e4.getDimension(2, mVar2.f4305i);
            mVar2.f4305i = dimension;
            if (mVar2.f4304h <= 0.0f) {
                throw new XmlPullParserException(e4.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension > 0.0f) {
                float alpha = mVar2.getAlpha();
                if (t.d(xmlPullParser, "alpha")) {
                    alpha = e4.getFloat(4, alpha);
                }
                mVar2.setAlpha(alpha);
                String string = e4.getString(0);
                if (string != null) {
                    mVar2.f4309m = string;
                    mVar2.f4311o.put(string, mVar2);
                }
                e4.recycle();
                nVar.f4312a = getChangingConfigurations();
                nVar.f4322k = true;
                n nVar3 = this.f4326b;
                m mVar3 = nVar3.f4313b;
                ArrayDeque arrayDeque = new ArrayDeque();
                arrayDeque.push(mVar3.f4303g);
                int eventType = xmlPullParser.getEventType();
                int depth = xmlPullParser.getDepth() + 1;
                boolean z8 = true;
                while (eventType != i8 && (xmlPullParser.getDepth() >= depth || eventType != i7)) {
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        j jVar = (j) arrayDeque.peek();
                        boolean equals = "path".equals(name);
                        i4 = depth;
                        l.b bVar = mVar3.f4311o;
                        if (equals) {
                            ?? lVar = new l();
                            lVar.f4270f = 0.0f;
                            lVar.f4272h = 1.0f;
                            lVar.f4273i = 1.0f;
                            lVar.f4274j = 0.0f;
                            lVar.f4275k = 1.0f;
                            lVar.f4276l = 0.0f;
                            Paint.Cap cap2 = Paint.Cap.BUTT;
                            lVar.f4277m = cap2;
                            Paint.Join join2 = Paint.Join.MITER;
                            lVar.f4278n = join2;
                            mVar = mVar3;
                            lVar.f4279o = 4.0f;
                            TypedArray e6 = t.e(resources, theme, attributeSet, a.f4251c);
                            if (t.d(xmlPullParser, "pathData")) {
                                String string2 = e6.getString(0);
                                if (string2 != null) {
                                    lVar.f4293b = string2;
                                }
                                String string3 = e6.getString(2);
                                if (string3 != null) {
                                    lVar.f4292a = com.google.common.collect.c.d0(string3);
                                }
                                lVar.f4271g = t.a(e6, xmlPullParser, theme, "fillColor", 1);
                                float f6 = lVar.f4273i;
                                if (t.d(xmlPullParser, "fillAlpha")) {
                                    f6 = e6.getFloat(12, f6);
                                }
                                lVar.f4273i = f6;
                                int i10 = !t.d(xmlPullParser, "strokeLineCap") ? -1 : e6.getInt(8, -1);
                                Paint.Cap cap3 = lVar.f4277m;
                                if (i10 == 0) {
                                    cap = cap2;
                                } else if (i10 != 1) {
                                    cap = i10 != 2 ? cap3 : Paint.Cap.SQUARE;
                                } else {
                                    cap = Paint.Cap.ROUND;
                                }
                                lVar.f4277m = cap;
                                int i11 = !t.d(xmlPullParser, "strokeLineJoin") ? -1 : e6.getInt(9, -1);
                                Paint.Join join3 = lVar.f4278n;
                                if (i11 == 0) {
                                    join = join2;
                                } else if (i11 != 1) {
                                    join = i11 != 2 ? join3 : Paint.Join.BEVEL;
                                } else {
                                    join = Paint.Join.ROUND;
                                }
                                lVar.f4278n = join;
                                float f7 = lVar.f4279o;
                                if (t.d(xmlPullParser, "strokeMiterLimit")) {
                                    f7 = e6.getFloat(10, f7);
                                }
                                lVar.f4279o = f7;
                                lVar.f4269e = t.a(e6, xmlPullParser, theme, "strokeColor", 3);
                                float f8 = lVar.f4272h;
                                if (t.d(xmlPullParser, "strokeAlpha")) {
                                    f8 = e6.getFloat(11, f8);
                                }
                                lVar.f4272h = f8;
                                float f9 = lVar.f4270f;
                                if (t.d(xmlPullParser, "strokeWidth")) {
                                    f9 = e6.getFloat(4, f9);
                                }
                                lVar.f4270f = f9;
                                float f10 = lVar.f4275k;
                                if (t.d(xmlPullParser, "trimPathEnd")) {
                                    f10 = e6.getFloat(6, f10);
                                }
                                lVar.f4275k = f10;
                                float f11 = lVar.f4276l;
                                if (t.d(xmlPullParser, "trimPathOffset")) {
                                    f11 = e6.getFloat(7, f11);
                                }
                                lVar.f4276l = f11;
                                float f12 = lVar.f4274j;
                                if (t.d(xmlPullParser, "trimPathStart")) {
                                    f12 = e6.getFloat(5, f12);
                                }
                                lVar.f4274j = f12;
                                int i12 = lVar.f4294c;
                                if (t.d(xmlPullParser, "fillType")) {
                                    i12 = e6.getInt(13, i12);
                                }
                                lVar.f4294c = i12;
                            }
                            e6.recycle();
                            jVar.f4281b.add(lVar);
                            if (lVar.getPathName() != null) {
                                bVar.put(lVar.getPathName(), lVar);
                            }
                            nVar3.f4312a |= lVar.f4295d;
                            z5 = false;
                            i5 = 1;
                            z8 = false;
                        } else {
                            mVar = mVar3;
                            if ("clip-path".equals(name)) {
                                l lVar2 = new l();
                                if (t.d(xmlPullParser, "pathData")) {
                                    TypedArray e7 = t.e(resources, theme, attributeSet, a.f4252d);
                                    String string4 = e7.getString(0);
                                    if (string4 != null) {
                                        lVar2.f4293b = string4;
                                    }
                                    String string5 = e7.getString(1);
                                    if (string5 != null) {
                                        lVar2.f4292a = com.google.common.collect.c.d0(string5);
                                    }
                                    lVar2.f4294c = !t.d(xmlPullParser, "fillType") ? 0 : e7.getInt(2, 0);
                                    e7.recycle();
                                }
                                jVar.f4281b.add(lVar2);
                                if (lVar2.getPathName() != null) {
                                    bVar.put(lVar2.getPathName(), lVar2);
                                }
                                nVar3.f4312a = lVar2.f4295d | nVar3.f4312a;
                            } else if ("group".equals(name)) {
                                j jVar2 = new j();
                                TypedArray e8 = t.e(resources, theme, attributeSet, a.f4250b);
                                float f13 = jVar2.f4282c;
                                if (t.d(xmlPullParser, "rotation")) {
                                    f13 = e8.getFloat(5, f13);
                                }
                                jVar2.f4282c = f13;
                                i5 = 1;
                                jVar2.f4283d = e8.getFloat(1, jVar2.f4283d);
                                jVar2.f4284e = e8.getFloat(2, jVar2.f4284e);
                                float f14 = jVar2.f4285f;
                                if (t.d(xmlPullParser, "scaleX")) {
                                    f14 = e8.getFloat(3, f14);
                                }
                                jVar2.f4285f = f14;
                                float f15 = jVar2.f4286g;
                                if (t.d(xmlPullParser, "scaleY")) {
                                    f15 = e8.getFloat(4, f15);
                                }
                                jVar2.f4286g = f15;
                                float f16 = jVar2.f4287h;
                                if (t.d(xmlPullParser, "translateX")) {
                                    f16 = e8.getFloat(6, f16);
                                }
                                jVar2.f4287h = f16;
                                float f17 = jVar2.f4288i;
                                if (t.d(xmlPullParser, "translateY")) {
                                    f17 = e8.getFloat(7, f17);
                                }
                                jVar2.f4288i = f17;
                                z5 = false;
                                String string6 = e8.getString(0);
                                if (string6 != null) {
                                    jVar2.f4291l = string6;
                                }
                                jVar2.c();
                                e8.recycle();
                                jVar.f4281b.add(jVar2);
                                arrayDeque.push(jVar2);
                                if (jVar2.getGroupName() != null) {
                                    bVar.put(jVar2.getGroupName(), jVar2);
                                }
                                nVar3.f4312a = jVar2.f4290k | nVar3.f4312a;
                            }
                            z5 = false;
                            i5 = 1;
                        }
                        z4 = z5;
                        i6 = 3;
                    } else {
                        mVar = mVar3;
                        i4 = depth;
                        i5 = i8;
                        z4 = z6;
                        i6 = 3;
                        if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                            arrayDeque.pop();
                        }
                    }
                    eventType = xmlPullParser.next();
                    i7 = i6;
                    z6 = z4;
                    i8 = i5;
                    depth = i4;
                    mVar3 = mVar;
                }
                if (!z8) {
                    this.f4327c = a(nVar.f4314c, nVar.f4315d);
                    return;
                }
                throw new XmlPullParserException("no path defined");
            } else {
                throw new XmlPullParserException(e4.getPositionDescription() + "<vector> tag requires height > 0");
            }
        }
    }

    public p(n nVar) {
        this.f4330f = true;
        this.f4331g = new float[9];
        this.f4332h = new Matrix();
        this.f4333i = new Rect();
        this.f4326b = nVar;
        this.f4327c = a(nVar.f4314c, nVar.f4315d);
    }
}
package l2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import java.util.BitSet;

/* loaded from: classes.dex */
public class j extends Drawable implements a0 {

    /* renamed from: w  reason: collision with root package name */
    public static final Paint f5309w;

    /* renamed from: a  reason: collision with root package name */
    public i f5310a;

    /* renamed from: b  reason: collision with root package name */
    public final y[] f5311b;

    /* renamed from: c  reason: collision with root package name */
    public final y[] f5312c;

    /* renamed from: d  reason: collision with root package name */
    public final BitSet f5313d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5314e;

    /* renamed from: f  reason: collision with root package name */
    public final Matrix f5315f;

    /* renamed from: g  reason: collision with root package name */
    public final Path f5316g;

    /* renamed from: h  reason: collision with root package name */
    public final Path f5317h;

    /* renamed from: i  reason: collision with root package name */
    public final RectF f5318i;

    /* renamed from: j  reason: collision with root package name */
    public final RectF f5319j;

    /* renamed from: k  reason: collision with root package name */
    public final Region f5320k;

    /* renamed from: l  reason: collision with root package name */
    public final Region f5321l;

    /* renamed from: m  reason: collision with root package name */
    public p f5322m;

    /* renamed from: n  reason: collision with root package name */
    public final Paint f5323n;

    /* renamed from: o  reason: collision with root package name */
    public final Paint f5324o;

    /* renamed from: p  reason: collision with root package name */
    public final k2.a f5325p;

    /* renamed from: q  reason: collision with root package name */
    public final w1.g f5326q;

    /* renamed from: r  reason: collision with root package name */
    public final r f5327r;

    /* renamed from: s  reason: collision with root package name */
    public PorterDuffColorFilter f5328s;

    /* renamed from: t  reason: collision with root package name */
    public PorterDuffColorFilter f5329t;

    /* renamed from: u  reason: collision with root package name */
    public final RectF f5330u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f5331v;

    static {
        Paint paint = new Paint(1);
        f5309w = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public j() {
        this(new p());
    }

    public void a() {
        invalidateSelf();
    }

    public final void b(RectF rectF, Path path) {
        i iVar = this.f5310a;
        this.f5327r.a(iVar.f5288a, iVar.f5297j, rectF, this.f5326q, path);
        if (this.f5310a.f5296i != 1.0f) {
            Matrix matrix = this.f5315f;
            matrix.reset();
            float f4 = this.f5310a.f5296i;
            matrix.setScale(f4, f4, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.f5330u, true);
    }

    public final PorterDuffColorFilter c(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z4) {
        PorterDuffColorFilter porterDuffColorFilter;
        int color;
        int d4;
        if (colorStateList != null && mode != null) {
            int colorForState = colorStateList.getColorForState(getState(), 0);
            if (z4) {
                colorForState = d(colorForState);
            }
            return new PorterDuffColorFilter(colorForState, mode);
        }
        if (z4 && (d4 = d((color = paint.getColor()))) != color) {
            porterDuffColorFilter = new PorterDuffColorFilter(d4, PorterDuff.Mode.SRC_IN);
        } else {
            porterDuffColorFilter = null;
        }
        return porterDuffColorFilter;
    }

    public final int d(int i4) {
        i iVar = this.f5310a;
        float f4 = iVar.f5301n + iVar.f5302o + iVar.f5300m;
        b2.a aVar = iVar.f5289b;
        if (aVar != null) {
            return aVar.a(i4, f4);
        }
        return i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b0, code lost:
        if (r1 < 29) goto L23;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void draw(android.graphics.Canvas r19) {
        /*
            Method dump skipped, instructions count: 383
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.j.draw(android.graphics.Canvas):void");
    }

    public final void e(Canvas canvas) {
        if (this.f5313d.cardinality() > 0) {
            Log.w("j", "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        int i4 = this.f5310a.f5305r;
        Path path = this.f5316g;
        k2.a aVar = this.f5325p;
        if (i4 != 0) {
            canvas.drawPath(path, aVar.f5136a);
        }
        for (int i5 = 0; i5 < 4; i5++) {
            y yVar = this.f5311b[i5];
            int i6 = this.f5310a.f5304q;
            Matrix matrix = y.f5389b;
            yVar.a(matrix, aVar, i6, canvas);
            this.f5312c[i5].a(matrix, aVar, this.f5310a.f5304q, canvas);
        }
        if (this.f5331v) {
            i iVar = this.f5310a;
            int sin = (int) (Math.sin(Math.toRadians(iVar.f5306s)) * iVar.f5305r);
            int i7 = i();
            canvas.translate(-sin, -i7);
            canvas.drawPath(path, f5309w);
            canvas.translate(sin, i7);
        }
    }

    public final void f(Canvas canvas, Paint paint, Path path, p pVar, RectF rectF) {
        if (pVar.f(rectF)) {
            float a5 = pVar.f5353f.a(rectF) * this.f5310a.f5297j;
            canvas.drawRoundRect(rectF, a5, a5, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    public void g(Canvas canvas) {
        float f4;
        Paint paint = this.f5324o;
        Path path = this.f5317h;
        p pVar = this.f5322m;
        RectF rectF = this.f5319j;
        rectF.set(h());
        if (k()) {
            f4 = paint.getStrokeWidth() / 2.0f;
        } else {
            f4 = 0.0f;
        }
        rectF.inset(f4, f4);
        f(canvas, paint, path, pVar, rectF);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f5310a.f5299l;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f5310a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f5310a.f5303p == 2) {
            return;
        }
        if (m()) {
            outline.setRoundRect(getBounds(), j() * this.f5310a.f5297j);
            return;
        }
        RectF h4 = h();
        Path path = this.f5316g;
        b(h4, path);
        a2.b.d(outline, path);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.f5310a.f5295h;
        if (rect2 != null) {
            rect.set(rect2);
            return true;
        }
        return super.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.f5320k;
        region.set(bounds);
        RectF h4 = h();
        Path path = this.f5316g;
        b(h4, path);
        Region region2 = this.f5321l;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final RectF h() {
        RectF rectF = this.f5318i;
        rectF.set(getBounds());
        return rectF;
    }

    public final int i() {
        i iVar = this.f5310a;
        return (int) (Math.cos(Math.toRadians(iVar.f5306s)) * iVar.f5305r);
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.f5314e = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        if (!super.isStateful() && (((colorStateList = this.f5310a.f5293f) == null || !colorStateList.isStateful()) && (((colorStateList2 = this.f5310a.f5292e) == null || !colorStateList2.isStateful()) && (((colorStateList3 = this.f5310a.f5291d) == null || !colorStateList3.isStateful()) && ((colorStateList4 = this.f5310a.f5290c) == null || !colorStateList4.isStateful()))))) {
            return false;
        }
        return true;
    }

    public final float j() {
        return this.f5310a.f5288a.f5352e.a(h());
    }

    public final boolean k() {
        Paint.Style style = this.f5310a.f5308u;
        if ((style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f5324o.getStrokeWidth() > 0.0f) {
            return true;
        }
        return false;
    }

    public final void l(Context context) {
        this.f5310a.f5289b = new b2.a(context);
        x();
    }

    public final boolean m() {
        return this.f5310a.f5288a.f(h());
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f5310a = new i(this.f5310a);
        return this;
    }

    public final void n(float f4) {
        i iVar = this.f5310a;
        if (iVar.f5301n != f4) {
            iVar.f5301n = f4;
            x();
        }
    }

    public final void o(ColorStateList colorStateList) {
        i iVar = this.f5310a;
        if (iVar.f5290c != colorStateList) {
            iVar.f5290c = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f5314e = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z4;
        boolean v2 = v(iArr);
        boolean w4 = w();
        if (!v2 && !w4) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z4) {
            invalidateSelf();
        }
        return z4;
    }

    public final void p(float f4) {
        i iVar = this.f5310a;
        if (iVar.f5297j != f4) {
            iVar.f5297j = f4;
            this.f5314e = true;
            invalidateSelf();
        }
    }

    public final void q(Paint.Style style) {
        this.f5310a.f5308u = style;
        super.invalidateSelf();
    }

    public final void r() {
        this.f5325p.a(-12303292);
        this.f5310a.f5307t = false;
        super.invalidateSelf();
    }

    public final void s(int i4) {
        i iVar = this.f5310a;
        if (iVar.f5303p != i4) {
            iVar.f5303p = i4;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        i iVar = this.f5310a;
        if (iVar.f5299l != i4) {
            iVar.f5299l = i4;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5310a.getClass();
        super.invalidateSelf();
    }

    @Override // l2.a0
    public final void setShapeAppearanceModel(p pVar) {
        this.f5310a.f5288a = pVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i4) {
        setTintList(ColorStateList.valueOf(i4));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f5310a.f5293f = colorStateList;
        w();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        i iVar = this.f5310a;
        if (iVar.f5294g != mode) {
            iVar.f5294g = mode;
            w();
            super.invalidateSelf();
        }
    }

    public final void t(ColorStateList colorStateList) {
        i iVar = this.f5310a;
        if (iVar.f5291d != colorStateList) {
            iVar.f5291d = colorStateList;
            onStateChange(getState());
        }
    }

    public final void u(float f4) {
        this.f5310a.f5298k = f4;
        invalidateSelf();
    }

    public final boolean v(int[] iArr) {
        boolean z4;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.f5310a.f5290c != null && color2 != (colorForState2 = this.f5310a.f5290c.getColorForState(iArr, (color2 = (paint2 = this.f5323n).getColor())))) {
            paint2.setColor(colorForState2);
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.f5310a.f5291d != null && color != (colorForState = this.f5310a.f5291d.getColorForState(iArr, (color = (paint = this.f5324o).getColor())))) {
            paint.setColor(colorForState);
            return true;
        }
        return z4;
    }

    public final boolean w() {
        PorterDuffColorFilter porterDuffColorFilter = this.f5328s;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f5329t;
        i iVar = this.f5310a;
        this.f5328s = c(iVar.f5293f, iVar.f5294g, this.f5323n, true);
        i iVar2 = this.f5310a;
        this.f5329t = c(iVar2.f5292e, iVar2.f5294g, this.f5324o, false);
        i iVar3 = this.f5310a;
        if (iVar3.f5307t) {
            this.f5325p.a(iVar3.f5293f.getColorForState(getState(), 0));
        }
        if (!h0.b.a(porterDuffColorFilter, this.f5328s) || !h0.b.a(porterDuffColorFilter2, this.f5329t)) {
            return true;
        }
        return false;
    }

    public final void x() {
        i iVar = this.f5310a;
        float f4 = iVar.f5301n + iVar.f5302o;
        iVar.f5304q = (int) Math.ceil(0.75f * f4);
        this.f5310a.f5305r = (int) Math.ceil(f4 * 0.25f);
        w();
        super.invalidateSelf();
    }

    public j(Context context, AttributeSet attributeSet, int i4, int i5) {
        this(p.c(context, attributeSet, i4, i5).a());
    }

    public j(i iVar) {
        r rVar;
        this.f5311b = new y[4];
        this.f5312c = new y[4];
        this.f5313d = new BitSet(8);
        this.f5315f = new Matrix();
        this.f5316g = new Path();
        this.f5317h = new Path();
        this.f5318i = new RectF();
        this.f5319j = new RectF();
        this.f5320k = new Region();
        this.f5321l = new Region();
        Paint paint = new Paint(1);
        this.f5323n = paint;
        Paint paint2 = new Paint(1);
        this.f5324o = paint2;
        this.f5325p = new k2.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            rVar = q.f5360a;
        } else {
            rVar = new r();
        }
        this.f5327r = rVar;
        this.f5330u = new RectF();
        this.f5331v = true;
        this.f5310a = iVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        w();
        v(getState());
        this.f5326q = new w1.g(9, this);
    }

    public j(p pVar) {
        this(new i(pVar));
    }
}
package q2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import androidx.appcompat.widget.v2;
import com.google.android.material.internal.c0;
import com.google.android.material.internal.d0;
import i2.g;
import l2.j;
import l2.k;
import l2.n;

/* loaded from: classes.dex */
public final class a extends j implements c0 {
    public static final /* synthetic */ int N = 0;
    public final d0 A;
    public final v2 B;
    public final Rect C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public float J;
    public float K;
    public float L;
    public float M;

    /* renamed from: x  reason: collision with root package name */
    public CharSequence f6354x;

    /* renamed from: y  reason: collision with root package name */
    public final Context f6355y;

    /* renamed from: z  reason: collision with root package name */
    public final Paint.FontMetrics f6356z;

    public a(Context context, int i4) {
        super(context, null, 0, i4);
        this.f6356z = new Paint.FontMetrics();
        d0 d0Var = new d0(this);
        this.A = d0Var;
        this.B = new v2(2, this);
        this.C = new Rect();
        this.J = 1.0f;
        this.K = 1.0f;
        this.L = 0.5f;
        this.M = 1.0f;
        this.f6355y = context;
        TextPaint textPaint = d0Var.f3534a;
        textPaint.density = context.getResources().getDisplayMetrics().density;
        textPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override // l2.j, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        canvas.save();
        float y4 = y();
        double sqrt = Math.sqrt(2.0d);
        canvas.scale(this.J, this.K, (getBounds().width() * 0.5f) + getBounds().left, (getBounds().height() * this.L) + getBounds().top);
        canvas.translate(y4, (float) (-((sqrt * this.H) - this.H)));
        super.draw(canvas);
        if (this.f6354x != null) {
            Rect bounds = getBounds();
            d0 d0Var = this.A;
            TextPaint textPaint = d0Var.f3534a;
            Paint.FontMetrics fontMetrics = this.f6356z;
            textPaint.getFontMetrics(fontMetrics);
            int centerY = (int) (bounds.centerY() - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f));
            g gVar = d0Var.f3540g;
            TextPaint textPaint2 = d0Var.f3534a;
            if (gVar != null) {
                textPaint2.drawableState = getState();
                d0Var.f3540g.e(this.f6355y, textPaint2, d0Var.f3535b);
                textPaint2.setAlpha((int) (this.M * 255.0f));
            }
            CharSequence charSequence = this.f6354x;
            canvas.drawText(charSequence, 0, charSequence.length(), bounds.centerX(), centerY, textPaint2);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) Math.max(this.A.f3534a.getTextSize(), this.F);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        float a5;
        float f4 = this.D * 2;
        CharSequence charSequence = this.f6354x;
        if (charSequence == null) {
            a5 = 0.0f;
        } else {
            a5 = this.A.a(charSequence.toString());
        }
        return (int) Math.max(f4 + a5, this.E);
    }

    @Override // l2.j, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        n g4 = this.f5310a.f5288a.g();
        g4.f5345k = z();
        setShapeAppearanceModel(g4.a());
    }

    @Override // l2.j, android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public final float y() {
        int i4;
        Rect rect = this.C;
        if (((rect.right - getBounds().right) - this.I) - this.G < 0) {
            i4 = ((rect.right - getBounds().right) - this.I) - this.G;
        } else if (((rect.left - getBounds().left) - this.I) + this.G > 0) {
            i4 = ((rect.left - getBounds().left) - this.I) + this.G;
        } else {
            return 0.0f;
        }
        return i4;
    }

    public final k z() {
        float width = ((float) (getBounds().width() - (Math.sqrt(2.0d) * this.H))) / 2.0f;
        return new k(new l2.g(this.H), Math.min(Math.max(-y(), -width), width));
    }
}
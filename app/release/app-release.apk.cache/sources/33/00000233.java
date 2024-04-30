package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

/* loaded from: classes.dex */
public final class g0 extends w {
    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i4, int i5, float f4, int i6, int i7, int i8, Paint paint) {
        o.a().getClass();
        t tVar = this.f1555b;
        d0 d0Var = tVar.f1543b;
        Typeface typeface = d0Var.f1510d;
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(typeface);
        int i9 = tVar.f1542a * 2;
        canvas.drawText(d0Var.f1508b, i9, 2, f4, i7, paint);
        paint.setTypeface(typeface2);
    }
}
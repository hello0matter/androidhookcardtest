package androidx.emoji2.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* loaded from: classes.dex */
public abstract class w extends ReplacementSpan {

    /* renamed from: b  reason: collision with root package name */
    public final t f1555b;

    /* renamed from: a  reason: collision with root package name */
    public final Paint.FontMetricsInt f1554a = new Paint.FontMetricsInt();

    /* renamed from: c  reason: collision with root package name */
    public float f1556c = 1.0f;

    public w(t tVar) {
        h0.e.c(tVar, "metadata cannot be null");
        this.f1555b = tVar;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i4, int i5, Paint.FontMetricsInt fontMetricsInt) {
        short s4;
        Paint.FontMetricsInt fontMetricsInt2 = this.f1554a;
        paint.getFontMetricsInt(fontMetricsInt2);
        float abs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        t tVar = this.f1555b;
        r0.a c4 = tVar.c();
        int a5 = c4.a(14);
        short s5 = 0;
        if (a5 != 0) {
            s4 = c4.f6452b.getShort(a5 + c4.f6451a);
        } else {
            s4 = 0;
        }
        this.f1556c = abs / s4;
        r0.a c5 = tVar.c();
        int a6 = c5.a(14);
        if (a6 != 0) {
            c5.f6452b.getShort(a6 + c5.f6451a);
        }
        r0.a c6 = tVar.c();
        int a7 = c6.a(12);
        if (a7 != 0) {
            s5 = c6.f6452b.getShort(a7 + c6.f6451a);
        }
        short s6 = (short) (s5 * this.f1556c);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s6;
    }
}
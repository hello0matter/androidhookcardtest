package androidx.emoji2.text;

import android.text.TextPaint;

/* loaded from: classes.dex */
public final class g implements k {

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal f1515b = new ThreadLocal();

    /* renamed from: a  reason: collision with root package name */
    public final TextPaint f1516a;

    public g() {
        TextPaint textPaint = new TextPaint();
        this.f1516a = textPaint;
        textPaint.setTextSize(10.0f);
    }
}
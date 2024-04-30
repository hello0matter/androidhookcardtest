package g0;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final TextPaint f4775a;

    /* renamed from: b  reason: collision with root package name */
    public final TextDirectionHeuristic f4776b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4777c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4778d;

    public e(PrecomputedText.Params params) {
        TextPaint textPaint;
        TextDirectionHeuristic textDirection;
        int breakStrategy;
        int hyphenationFrequency;
        textPaint = params.getTextPaint();
        this.f4775a = textPaint;
        textDirection = params.getTextDirection();
        this.f4776b = textDirection;
        breakStrategy = params.getBreakStrategy();
        this.f4777c = breakStrategy;
        hyphenationFrequency = params.getHyphenationFrequency();
        this.f4778d = hyphenationFrequency;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f4777c == eVar.f4777c && this.f4778d == eVar.f4778d) {
            TextPaint textPaint = this.f4775a;
            float textSize = textPaint.getTextSize();
            TextPaint textPaint2 = eVar.f4775a;
            if (textSize == textPaint2.getTextSize() && textPaint.getTextScaleX() == textPaint2.getTextScaleX() && textPaint.getTextSkewX() == textPaint2.getTextSkewX() && textPaint.getLetterSpacing() == textPaint2.getLetterSpacing() && TextUtils.equals(textPaint.getFontFeatureSettings(), textPaint2.getFontFeatureSettings()) && textPaint.getFlags() == textPaint2.getFlags() && textPaint.getTextLocales().equals(textPaint2.getTextLocales()) && (textPaint.getTypeface() != null ? textPaint.getTypeface().equals(textPaint2.getTypeface()) : textPaint2.getTypeface() == null) && this.f4776b == eVar.f4776b) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        TextPaint textPaint = this.f4775a;
        return h0.b.b(Float.valueOf(textPaint.getTextSize()), Float.valueOf(textPaint.getTextScaleX()), Float.valueOf(textPaint.getTextSkewX()), Float.valueOf(textPaint.getLetterSpacing()), Integer.valueOf(textPaint.getFlags()), textPaint.getTextLocales(), textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), this.f4776b, Integer.valueOf(this.f4777c), Integer.valueOf(this.f4778d));
    }

    public final String toString() {
        String fontVariationSettings;
        StringBuilder sb = new StringBuilder("{");
        StringBuilder sb2 = new StringBuilder("textSize=");
        TextPaint textPaint = this.f4775a;
        sb2.append(textPaint.getTextSize());
        sb.append(sb2.toString());
        sb.append(", textScaleX=" + textPaint.getTextScaleX());
        sb.append(", textSkewX=" + textPaint.getTextSkewX());
        int i4 = Build.VERSION.SDK_INT;
        sb.append(", letterSpacing=" + textPaint.getLetterSpacing());
        sb.append(", elegantTextHeight=" + textPaint.isElegantTextHeight());
        sb.append(", textLocale=" + textPaint.getTextLocales());
        sb.append(", typeface=" + textPaint.getTypeface());
        if (i4 >= 26) {
            StringBuilder sb3 = new StringBuilder(", variationSettings=");
            fontVariationSettings = textPaint.getFontVariationSettings();
            sb3.append(fontVariationSettings);
            sb.append(sb3.toString());
        }
        sb.append(", textDir=" + this.f4776b);
        sb.append(", breakStrategy=" + this.f4777c);
        sb.append(", hyphenationFrequency=" + this.f4778d);
        sb.append("}");
        return sb.toString();
    }

    public e(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i4, int i5) {
        PrecomputedText.Params.Builder breakStrategy;
        PrecomputedText.Params.Builder hyphenationFrequency;
        PrecomputedText.Params.Builder textDirection;
        if (Build.VERSION.SDK_INT >= 29) {
            breakStrategy = androidx.emoji2.text.b.i(textPaint).setBreakStrategy(i4);
            hyphenationFrequency = breakStrategy.setHyphenationFrequency(i5);
            textDirection = hyphenationFrequency.setTextDirection(textDirectionHeuristic);
            textDirection.build();
        }
        this.f4775a = textPaint;
        this.f4776b = textDirectionHeuristic;
        this.f4777c = i4;
        this.f4778d = i5;
    }
}
package com.google.android.material.internal;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a  reason: collision with root package name */
    public CharSequence f3477a;

    /* renamed from: b  reason: collision with root package name */
    public final TextPaint f3478b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3479c;

    /* renamed from: d  reason: collision with root package name */
    public int f3480d;

    /* renamed from: k  reason: collision with root package name */
    public boolean f3487k;

    /* renamed from: e  reason: collision with root package name */
    public Layout.Alignment f3481e = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: f  reason: collision with root package name */
    public int f3482f = Integer.MAX_VALUE;

    /* renamed from: g  reason: collision with root package name */
    public float f3483g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    public float f3484h = 1.0f;

    /* renamed from: i  reason: collision with root package name */
    public int f3485i = 1;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3486j = true;

    /* renamed from: l  reason: collision with root package name */
    public TextUtils.TruncateAt f3488l = null;

    public b0(CharSequence charSequence, TextPaint textPaint, int i4) {
        this.f3477a = charSequence;
        this.f3478b = textPaint;
        this.f3479c = i4;
        this.f3480d = charSequence.length();
    }

    public final StaticLayout a() {
        if (this.f3477a == null) {
            this.f3477a = "";
        }
        int max = Math.max(0, this.f3479c);
        CharSequence charSequence = this.f3477a;
        int i4 = this.f3482f;
        TextPaint textPaint = this.f3478b;
        if (i4 == 1) {
            charSequence = TextUtils.ellipsize(charSequence, textPaint, max, this.f3488l);
        }
        int min = Math.min(charSequence.length(), this.f3480d);
        this.f3480d = min;
        if (this.f3487k && this.f3482f == 1) {
            this.f3481e = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, min, textPaint, max);
        obtain.setAlignment(this.f3481e);
        obtain.setIncludePad(this.f3486j);
        obtain.setTextDirection(this.f3487k ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f3488l;
        if (truncateAt != null) {
            obtain.setEllipsize(truncateAt);
        }
        obtain.setMaxLines(this.f3482f);
        float f4 = this.f3483g;
        if (f4 != 0.0f || this.f3484h != 1.0f) {
            obtain.setLineSpacing(f4, this.f3484h);
        }
        if (this.f3482f > 1) {
            obtain.setHyphenationFrequency(this.f3485i);
        }
        return obtain.build();
    }
}